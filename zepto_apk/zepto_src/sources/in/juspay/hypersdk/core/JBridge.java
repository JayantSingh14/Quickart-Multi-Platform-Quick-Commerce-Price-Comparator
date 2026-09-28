package in.juspay.hypersdk.core;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import coil3.network.internal.UtilsKt;
import com.airbnb.lottie.LottieAnimationView;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.apay.hardened.external.model.APayConstants;
import in.juspay.airborne.HyperOTAServices;
import in.juspay.airborne.network.JuspayHttpsResponse;
import in.juspay.airborne.network.NetUtils;
import in.juspay.airborne.security.HyperSSLSocketFactory;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hyper.bridge.ThreeDS2Bridge;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.mystique.SwypeLayout;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.security.JOSEUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.SessionizedNetUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLHandshakeException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public class JBridge extends DuiInterface {
    private static final String DEEPLINK_RESULT_CB = "deeplink-result-cb";
    private static final String LOG_TAG = "JBridge";
    private static final ConcurrentHashMap<String, PermissionRequest> pendingPermissionRequests = new ConcurrentHashMap<>();
    private final int JUSPAY_LOADER_ID;

    @NonNull
    private final Set<String> acceptedCerts;

    @NonNull
    private final AtomicInteger apiTag;

    @Nullable
    private BroadcastReceiver broadcastReceiver;

    @NonNull
    private final HyperOTAServices hyperOTAServices;

    @Nullable
    private NetUtils netUtils;

    @Nullable
    private NetUtils netUtilsSsl;

    public JBridge(@NonNull JuspayServices juspayServices, @NonNull HyperOTAServices hyperOTAServices) {
        super(juspayServices);
        this.JUSPAY_LOADER_ID = 898989;
        this.broadcastReceiver = null;
        this.apiTag = new AtomicInteger(0);
        this.hyperOTAServices = hyperOTAServices;
        this.acceptedCerts = new HashSet();
        try {
            this.netUtils = new SessionizedNetUtils(((DuiInterface) this).sessionInfo, 0, 0, false);
            this.netUtilsSsl = new SessionizedNetUtils(((DuiInterface) this).sessionInfo, 0, 0, true);
        } catch (Exception e2) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error while instantiating NetUtils", e2);
        }
    }

    public static String cachePermissionRequest(@NonNull PermissionRequest permissionRequest) {
        String string = UUID.randomUUID().toString();
        pendingPermissionRequests.put(string, permissionRequest);
        return string;
    }

    public static float dpToPx(float f2, Context context) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f2;
    }

    private void drawIcon(Drawable drawable, int i2) {
        ExecutorManager.runOnMainThread(new c(this, i2, drawable, this.juspayServices.getSdkTracker()));
    }

    private String extractStoredPublicKey(String str, String str2) throws Exception {
        if (!str2.equals(Constants.KEY_ORIGIN_SHARED_PREF)) {
            return getPublicKeyAsString(str).replaceAll(StringUtils.LF, "");
        }
        String dataFromSharedPrefs = getDataFromSharedPrefs(str.contains(CLConstants.DOT_SALT_DELIMETER) ? str.split("\\.")[0] : str, "");
        if (!str.contains(CLConstants.DOT_SALT_DELIMETER)) {
            return dataFromSharedPrefs.replaceAll(StringUtils.LF, "");
        }
        String nestedJsonValue = getNestedJsonValue(dataFromSharedPrefs, str.substring(str.indexOf(CLConstants.DOT_SALT_DELIMETER) + 1));
        if (nestedJsonValue == null || nestedJsonValue.isEmpty()) {
            throw new Exception("Key not found in nested path".concat(str));
        }
        return nestedJsonValue.replaceAll(StringUtils.LF, "");
    }

    private Map<String, String> getDecodedQueryParameters(String str) {
        if (str == null || str.trim().length() < 1) {
            return null;
        }
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            int iIndexOf = str2.indexOf("=");
            map.put(URLDecoder.decode(str2.substring(0, iIndexOf), "UTF-8").trim(), URLDecoder.decode(str2.substring(iIndexOf + 1), "UTF-8").trim());
        }
        return map;
    }

    private String getNestedJsonValue(String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] strArrSplit = str2.split("\\.");
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                String str3 = strArrSplit[i2];
                if (i2 == strArrSplit.length - 1) {
                    return jSONObject.getString(str3);
                }
                jSONObject = jSONObject.getJSONObject(str3);
            }
            return null;
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error in getting Value from Nested JSON", e2);
            return null;
        }
    }

    private String getPersistentDeviceFingerprint(Context context) {
        return context.getSharedPreferences("DevicePrefs", 0).getString("device_fingerprint", "");
    }

    @Nullable
    private PrivateKey getPrivateKey(String str) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        KeyStore.Entry entry = keyStore.getEntry(str, null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            return ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
        }
        throw new Exception(android.support.v4.media.b.C("Private Key not found against alias", str));
    }

    @Nullable
    private PublicKey getPublicKey(String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, UnrecoverableEntryException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(str, null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                return ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
            }
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error in getPublicKey", e2);
        }
        return null;
    }

    @JavascriptInterface
    public static String hmacDigest(String str, String str2, String str3) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), str3);
            Mac mac = Mac.getInstance(str3);
            mac.init(secretKeySpec);
            byte[] bArrDoFinal = mac.doFinal(str.getBytes(StandardCharsets.US_ASCII));
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDoFinal) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$drawIcon$2(int i2, Drawable drawable, SdkTracker sdkTracker) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        View viewFindViewById = activity.findViewById(i2);
        ImageView imageView = new ImageView(this.activity);
        imageView.setImageDrawable(drawable);
        if (viewFindViewById != null) {
            ((ViewGroup) viewFindViewById).addView(imageView);
        } else {
            sdkTracker.trackAction("system", "error", Labels.System.JBRIDGE, "draw_icon", android.support.v4.media.b.g(i2, "No view at ", " found to attach the image."));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$hideJuspayLoader$1(java.lang.String r6) throws java.lang.NumberFormatException {
        /*
            r5 = this;
            android.app.Activity r0 = r5.activity
            if (r0 != 0) goto L5
            goto L5d
        L5:
            r1 = 898989(0xdb7ad, float:1.259752E-39)
            android.view.View r0 = r0.findViewById(r1)
            if (r0 != 0) goto Lf
            goto L5d
        Lf:
            r1 = 1065353216(0x3f800000, float:1.0)
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3b
            r2.<init>(r6)     // Catch: java.lang.Exception -> L3b
            java.lang.String r6 = "animationDuration"
            java.lang.String r3 = "1000"
            java.lang.String r6 = r2.optString(r6, r3)     // Catch: java.lang.Exception -> L3b
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Exception -> L3b
            java.lang.String r3 = "startAlpha"
            java.lang.String r4 = "1.0"
            java.lang.String r3 = r2.optString(r3, r4)     // Catch: java.lang.Exception -> L3d
            float r1 = java.lang.Float.parseFloat(r3)     // Catch: java.lang.Exception -> L3d
            java.lang.String r3 = "endAlpha"
            java.lang.String r4 = "0.0"
            java.lang.String r2 = r2.optString(r3, r4)     // Catch: java.lang.Exception -> L3d
            float r2 = java.lang.Float.parseFloat(r2)     // Catch: java.lang.Exception -> L3d
            goto L3e
        L3b:
            r6 = 1000(0x3e8, float:1.401E-42)
        L3d:
            r2 = 0
        L3e:
            android.view.animation.AlphaAnimation r3 = new android.view.animation.AlphaAnimation
            r3.<init>(r1, r2)
            android.view.animation.AccelerateInterpolator r1 = new android.view.animation.AccelerateInterpolator
            r1.<init>()
            r3.setInterpolator(r1)
            long r1 = (long) r6
            r3.setDuration(r1)
            r0.setAnimation(r3)
            in.juspay.hypersdk.core.JuspayServices r6 = r5.juspayServices
            android.widget.FrameLayout r6 = r6.getContainer()
            if (r6 == 0) goto L5d
            r6.removeView(r0)
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JBridge.lambda$hideJuspayLoader$1(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$newDialogWithoutDateField$3(String str, DatePicker datePicker, int i2, int i3, int i4) {
        String strF = i4 / 10 == 0 ? android.support.v4.media.b.f(i4, "0") : android.support.v4.media.b.f(i4, "");
        int i5 = i3 + 1;
        invokeCallbackInDUIWebview(str, i2 + "-" + (i5 / 10 == 0 ? android.support.v4.media.b.f(i5, "0") : android.support.v4.media.b.f(i5, "")) + "-" + strF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$newDialogWithoutDateField$4(String str, DialogInterface dialogInterface) {
        invokeCallbackInDUIWebview(str, "NaN-NaN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showJuspayLoader$0(String str) throws NumberFormatException {
        int i2;
        String strOptString = "Processing your payment";
        Activity activity = this.activity;
        if (activity != null && activity.findViewById(898989) == null) {
            int i3 = 1000;
            float f2 = 0.0f;
            float f3 = 1.0f;
            try {
                JSONObject jSONObject = new JSONObject(str);
                i2 = Integer.parseInt(jSONObject.optString("rotationDuration", "2100"));
                try {
                    i3 = Integer.parseInt(jSONObject.optString("animationDuration", "1000"));
                    f2 = Float.parseFloat(jSONObject.optString("startAlpha", "0.0"));
                    f3 = Float.parseFloat(jSONObject.optString("endAlpha", CLConstants.ARQC_VERSION));
                    strOptString = jSONObject.optString(APayConstants.Error.MESSAGE, "Processing your payment");
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i2 = 2100;
            }
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout.setGravity(17);
            linearLayout.setId(898989);
            linearLayout.setClickable(true);
            LinearLayout linearLayout2 = new LinearLayout(this.activity);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            ImageView imageView = new ImageView(this.activity);
            imageView.setBackgroundResource(R.drawable.juspay_icon);
            imageView.setLayoutParams(new LinearLayout.LayoutParams((int) dpToPx(48.0f, this.activity), (int) dpToPx(48.0f, this.activity)));
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 350.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(i2);
            imageView.startAnimation(rotateAnimation);
            TextView textView = new TextView(this.activity);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setPadding(0, (int) dpToPx(10.0f, this.activity), 0, (int) dpToPx(20.0f, this.activity));
            textView.setTextSize(16.0f);
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setText(strOptString);
            ImageView imageView2 = new ImageView(this.activity);
            imageView2.setBackgroundResource(R.drawable.juspay_safe);
            imageView2.setLayoutParams(new LinearLayout.LayoutParams((int) dpToPx(90.0f, this.activity), (int) dpToPx(12.0f, this.activity)));
            ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, (int) dpToPx(24.0f, this.activity), 0, 0);
            linearLayout2.addView(imageView);
            linearLayout2.addView(imageView2);
            linearLayout2.addView(textView);
            linearLayout.addView(linearLayout2);
            Animation alphaAnimation = new AlphaAnimation(f2, f3);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            alphaAnimation.setDuration(i3);
            linearLayout.setAnimation(alphaAnimation);
            FrameLayout container = this.juspayServices.getContainer();
            if (container != null) {
                container.addView(linearLayout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDatePicker$5(String str, String str2, int i2, String str3, String str4, boolean z) throws ParseException {
        DatePickerDialog datePickerDialogNewDialogWithoutDateField = newDialogWithoutDateField(str, str2, i2);
        if (datePickerDialogNewDialogWithoutDateField == null) {
            return;
        }
        if (str3 != null && !str3.isEmpty() && !str3.equals("undefined")) {
            datePickerDialogNewDialogWithoutDateField.getDatePicker().setMinDate(dateToMillisecond(str3));
        }
        if (str4 != null && !str4.isEmpty() && !str4.equals("undefined")) {
            datePickerDialogNewDialogWithoutDateField.getDatePicker().setMaxDate(dateToMillisecond(str4));
        }
        View viewFindViewById = datePickerDialogNewDialogWithoutDateField.getDatePicker().findViewById(Resources.getSystem().getIdentifier("day", CLConstants.SHARED_PREFERENCE_ITEM_ID, LogSubCategory.LifeCycle.ANDROID));
        if (viewFindViewById != null) {
            if (z) {
                viewFindViewById.setVisibility(0);
            } else {
                viewFindViewById.setVisibility(8);
            }
        }
        datePickerDialogNewDialogWithoutDateField.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$startLottieAnimation$6(int i2, String str, boolean z, float f2, float f3, SdkTracker sdkTracker) {
        try {
            Activity activity = this.activity;
            if (activity == null) {
                return;
            }
            LottieAnimationView lottieAnimationView = (LottieAnimationView) activity.findViewById(i2);
            lottieAnimationView.f14113h.j(true);
            lottieAnimationView.setAnimation(str);
            lottieAnimationView.setRepeatCount(z ? -1 : 0);
            lottieAnimationView.f14113h.c0(f2, f3);
            lottieAnimationView.f();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while playing Lottie animation", e2);
        }
    }

    @Nullable
    private DatePickerDialog newDialogWithoutDateField(final String str, String str2, int i2) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: in.juspay.hypersdk.core.g0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i3, int i4, int i5) {
                this.f48578a.lambda$newDialogWithoutDateField$3(str, datePicker, i3, i4, i5);
            }
        };
        DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: in.juspay.hypersdk.core.h0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f48585a.lambda$newDialogWithoutDateField$4(str, dialogInterface);
            }
        };
        if (str2 != null && !str2.isEmpty() && !str2.equals("undefined")) {
            calendar.setTimeInMillis(dateToMillisecond(str2));
        }
        if (this.activity == null) {
            return null;
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.activity, i2, onDateSetListener, calendar.get(1), calendar.get(2), calendar.get(5));
        datePickerDialog.setOnCancelListener(onCancelListener);
        return datePickerDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiverCallback(Intent intent) throws Exception {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            String action = intent.getAction();
            if (action == null) {
                throw new Exception("action is null");
            }
            if (action.equals("customtab-result")) {
                handleCustomTabResult(intent);
            } else if (action.equals(RedirectResponseActivity.DEEPLINK_RESULT_ACTION)) {
                handleDeepLinkResult(intent);
            } else {
                sdkTracker.trackApiCalls(LogSubCategory.ApiCall.SDK, "error", Labels.SDK.RECEIVER_CALLBACK, null, null, null, null, null, "unknown_intent", null);
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.RECEIVER_CALLBACK, "JSON Exception", e2);
        }
    }

    private int versionCompare(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int i2 = 0;
        while (i2 < strArrSplit.length && i2 < strArrSplit2.length && strArrSplit[i2].equalsIgnoreCase(strArrSplit2[i2])) {
            i2++;
        }
        return (i2 >= strArrSplit.length || i2 >= strArrSplit2.length) ? Integer.signum(strArrSplit.length - strArrSplit2.length) : Integer.signum(Integer.valueOf(strArrSplit[i2]).compareTo(Integer.valueOf(strArrSplit2[i2])));
    }

    @JavascriptInterface
    public void addCertificates(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.acceptedCerts.add(jSONArray.getString(i2));
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while manipulating JSON", e2);
        }
    }

    @JavascriptInterface
    @Deprecated
    public void amazonNonTokenPay(String str, String str2) throws JSONException {
        launchCustomTab(str, str2);
    }

    @JavascriptInterface
    public void attachBase64ImageToId(String str, String str2) {
        try {
            ImageView imageView = (ImageView) this.activity.findViewById(Integer.parseInt(str2));
            byte[] bArrDecode = Base64.decode(str, 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void blurBackground(String str, String str2, int i2) {
    }

    @JavascriptInterface
    public String callAPI(String str, String str2, String str3, String str4, boolean z, boolean z2, String str5) {
        return callAPIWithOptions(str, str2, str3, str4, z, z2, new JSONObject().toString(), str5);
    }

    @JavascriptInterface
    public String callAPIWithOptions(final String str, final String str2, final String str3, final String str4, final boolean z, boolean z2, String str5, final String str6) {
        JSONObject jSONObject;
        SessionizedNetUtils sessionizedNetUtils;
        final SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        final DynamicUI dynamicUI = this.juspayServices.getDynamicUI();
        try {
            jSONObject = new JSONObject(str5);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        final JSONObject jSONObject2 = jSONObject;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final String str7 = "tag" + this.apiTag.incrementAndGet();
        sdkTracker.trackApiCalls("network", "info", Labels.Network.BEFORE_REQUEST, null, str2, str7, jCurrentTimeMillis, null, JSONObject.NULL, null, str, jSONObject2.optJSONArray("channels"), jSONObject2.optJSONObject("rootLogFields"));
        NetUtils netUtils = z2 ? this.netUtilsSsl : this.netUtils;
        if (netUtils == null) {
            try {
                if (z2) {
                    sessionizedNetUtils = new SessionizedNetUtils(((DuiInterface) this).sessionInfo, 0, 0, true);
                    this.netUtilsSsl = sessionizedNetUtils;
                } else {
                    sessionizedNetUtils = new SessionizedNetUtils(((DuiInterface) this).sessionInfo, 0, 0, false);
                    this.netUtils = sessionizedNetUtils;
                }
                netUtils = sessionizedNetUtils;
            } catch (Exception e2) {
                this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error while instantiating NetUtils in callAPI", e2);
            }
        }
        final NetUtils netUtils2 = netUtils;
        if (netUtils2 == null) {
            if (str6 != null) {
                dynamicUI.addJsToWebView(android.support.v4.media.b.r(androidx.fragment.app.e.v("window.callUICallback('", str6, "','failure','", Base64.encodeToString("{}".getBytes(), 2), "','-1','"), Base64.encodeToString(str2.getBytes(), 2), "','%7B%7D');"));
            }
            sdkTracker.trackApiCalls("network", "error", Labels.Network.NETWORK_CALL, -1, str2, null, jCurrentTimeMillis, Long.valueOf(System.currentTimeMillis()), str3, "Unable to create netUtils object", str, jSONObject2.optJSONArray("channels"), jSONObject2.optJSONObject("rootLogFields"));
            return "";
        }
        if (z2) {
            try {
                netUtils2.setSslSocketFactory(new HyperSSLSocketFactory(this.acceptedCerts).getSslSocketFactory());
            } catch (Exception e3) {
                JuspayLogger.e(LOG_TAG, "Exception: ", e3);
            }
        }
        new AsyncTask<Object, Object, Object>() { // from class: in.juspay.hypersdk.core.JBridge.2
            private HashMap<String, String> toMap(String str8) {
                HashMap<String, String> map = new HashMap<>();
                try {
                    JSONObject jSONObject3 = new JSONObject(str8);
                    Iterator<String> itKeys = jSONObject3.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject3.getString(next));
                    }
                    return map;
                } catch (JSONException unused2) {
                    JBridge.this.juspayServices.sdkDebug(JBridge.LOG_TAG, "Not a json string. Passing as such");
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Object obj) throws JSONException {
                String str8;
                String string;
                String strEncodeToString;
                String strReplace;
                if (obj == null) {
                    sdkTracker.trackApiCalls("network", "info", Labels.Network.NETWORK_CALL, -1, str2, str7, jCurrentTimeMillis, Long.valueOf(System.currentTimeMillis()), str3, "failure", str, jSONObject2.optJSONArray("channels"), jSONObject2.optJSONObject("rootLogFields"));
                    if (str6 != null) {
                        String strEncodeToString2 = Base64.encodeToString("{}".getBytes(), 2);
                        dynamicUI.addJsToWebView(android.support.v4.media.b.r(androidx.fragment.app.e.v("window.callUICallback('", str6, "','failure','", strEncodeToString2, "','-1','"), Base64.encodeToString(str2.getBytes(), 2), "','%7B%7D');"));
                        return;
                    }
                    return;
                }
                JuspayHttpsResponse juspayHttpsResponse = (JuspayHttpsResponse) obj;
                if (juspayHttpsResponse.responsePayload != null) {
                    str8 = "{}";
                    sdkTracker.trackApiCalls("network", "info", Labels.Network.NETWORK_CALL, Integer.valueOf(juspayHttpsResponse.responseCode), str2, str7, jCurrentTimeMillis, Long.valueOf(System.currentTimeMillis()), str3, new String(juspayHttpsResponse.responsePayload), str, jSONObject2.optJSONArray("channels"), jSONObject2.optJSONObject("rootLogFields"));
                } else {
                    str8 = "{}";
                    sdkTracker.trackApiCalls("network", "info", Labels.Network.NETWORK_CALL, Integer.valueOf(juspayHttpsResponse.responseCode), str2, str7, jCurrentTimeMillis, Long.valueOf(System.currentTimeMillis()), str3, null, str, jSONObject2.optJSONArray("channels"), jSONObject2.optJSONObject("rootLogFields"));
                }
                int i2 = juspayHttpsResponse.responseCode;
                if (i2 == -1 || i2 == -2 || i2 == -3) {
                    byte[] bytes = str8.getBytes();
                    String strEncodeToString3 = Base64.encodeToString(bytes, 2);
                    String str9 = str6;
                    if (str9 != null) {
                        try {
                            string = "window.callUICallback('" + str9 + "','failure','" + strEncodeToString3 + "','" + juspayHttpsResponse.responseCode + "','" + Base64.encodeToString(str2.getBytes(), 2) + "','', '" + URLEncoder.encode(Arrays.toString(bytes), "UTF-8").replace("+", "%20") + "');";
                        } catch (UnsupportedEncodingException unused2) {
                            String str10 = str6;
                            int i3 = juspayHttpsResponse.responseCode;
                            String strEncodeToString4 = Base64.encodeToString(str2.getBytes(), 2);
                            StringBuilder sbV = androidx.fragment.app.e.v("window.callUICallback('", str10, "','failure','", strEncodeToString3, "','");
                            sbV.append(i3);
                            sbV.append("','");
                            sbV.append(strEncodeToString4);
                            sbV.append("');");
                            string = sbV.toString();
                        }
                        dynamicUI.addJsToWebView(string);
                        return;
                    }
                    return;
                }
                byte[] bArr = juspayHttpsResponse.responsePayload;
                String strEncodeToString5 = "";
                if (bArr == null) {
                    strReplace = "";
                    strEncodeToString = strReplace;
                } else {
                    String str11 = new String(bArr);
                    try {
                        String string2 = new JSONObject(str11).toString();
                        JBridge.this.juspayServices.sdkDebug(APayConstants.Error.MESSAGE, string2);
                        strEncodeToString = Base64.encodeToString(string2.getBytes(), 2);
                        strReplace = URLEncoder.encode(string2, "UTF-8").replace("+", "%20");
                    } catch (Exception e4) {
                        strEncodeToString = Base64.encodeToString(str11.getBytes(), 2);
                        try {
                            strReplace = URLEncoder.encode(str11, "UTF-8").replace("+", "%20");
                        } catch (Exception unused3) {
                            strReplace = "";
                        }
                        JuspayLogger.e(JBridge.LOG_TAG, "This happened: ", e4);
                    }
                }
                JuspayServices juspayServices = JBridge.this.juspayServices;
                StringBuilder sbX = android.support.v4.media.b.x(strEncodeToString, StringUtils.SPACE);
                sbX.append(juspayHttpsResponse.responseCode);
                juspayServices.sdkDebug("Response inserted: ", sbX.toString());
                if (juspayHttpsResponse.headers != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, List<String>> entry : juspayHttpsResponse.headers.entrySet()) {
                        try {
                            jSONObject3.put(entry.getKey(), new JSONArray((Collection) entry.getValue()));
                        } catch (Exception unused4) {
                        }
                    }
                    try {
                        JBridge.this.juspayServices.sdkDebug("headers", jSONObject3.toString());
                        strEncodeToString5 = Base64.encodeToString(jSONObject3.toString().getBytes(), 2);
                    } catch (Exception e5) {
                        JuspayLogger.e(JBridge.LOG_TAG, "This happened: ", e5);
                    }
                }
                JuspayServices juspayServices2 = JBridge.this.juspayServices;
                StringBuilder sbX2 = android.support.v4.media.b.x(strEncodeToString5, StringUtils.SPACE);
                sbX2.append(juspayHttpsResponse.responseCode);
                juspayServices2.sdkDebug("Headers inserted: ", sbX2.toString());
                String str12 = str6;
                if (str12 != null) {
                    int i4 = juspayHttpsResponse.responseCode;
                    String strEncodeToString6 = Base64.encodeToString(str2.getBytes(), 2);
                    StringBuilder sbV2 = androidx.fragment.app.e.v("window.callUICallback('", str12, "','success','", strEncodeToString, "','");
                    sbV2.append(i4);
                    sbV2.append("','");
                    sbV2.append(strEncodeToString6);
                    sbV2.append("','");
                    String strN = android.support.v4.media.a.n(sbV2, strEncodeToString5, "', '", strReplace, "');");
                    JBridge.this.juspayServices.sdkDebug("Js inserted: ", strN);
                    dynamicUI.addJsToWebView(strN);
                }
            }

            @Override // android.os.AsyncTask
            /* renamed from: doInBackground, reason: merged with bridge method [inline-methods] */
            public Object doInBackground2(Object[] objArr) {
                try {
                    HashMap<String, String> map = toMap(str4);
                    HashMap<String, String> map2 = z ? toMap(str3) : null;
                    if (UtilsKt.HTTP_METHOD_GET.equals(str)) {
                        return new JuspayHttpsResponse(netUtils2.doGet(str2, map, map2, jSONObject2, str7));
                    }
                    if ("HEAD".equals(str)) {
                        return new JuspayHttpsResponse(netUtils2.doHead(str2, map, map2, jSONObject2, str7));
                    }
                    if ("POST".equals(str)) {
                        return map2 == null ? new JuspayHttpsResponse(netUtils2.postUrl(new URL(str2), map, str3, jSONObject2, str7)) : new JuspayHttpsResponse(netUtils2.postUrl(new URL(str2), map, map2, jSONObject2, str7));
                    }
                    if ("DELETE".equals(str)) {
                        return map2 == null ? new JuspayHttpsResponse(netUtils2.deleteUrl(new URL(str2), map, str3, jSONObject2, str7)) : new JuspayHttpsResponse(netUtils2.deleteUrl(new URL(str2), map, map2, jSONObject2, str7));
                    }
                    if ("PUT".equals(str)) {
                        return new JuspayHttpsResponse(netUtils2.doPut(JBridge.this.juspayServices.getContext(), new URL(str2), str3.getBytes(), map, netUtils2, jSONObject2, str7));
                    }
                    return null;
                } catch (SocketTimeoutException e4) {
                    sdkTracker.trackAndLogApiException(JBridge.LOG_TAG, LogCategory.API_CALL, "network", Labels.Network.NETWORK_CALL, Long.valueOf(jCurrentTimeMillis), Long.valueOf(System.currentTimeMillis()), str3, str2, str, "SocketTimeoutException while calling api", e4, jSONObject2.optJSONArray("channels"), jSONObject2.optJSONObject("rootLogFields"));
                    return new JuspayHttpsResponse(-3, "Socket Timeout".getBytes(), null);
                } catch (SSLHandshakeException e5) {
                    sdkTracker.trackAndLogApiException(JBridge.LOG_TAG, LogCategory.API_CALL, "network", Labels.Network.NETWORK_CALL, Long.valueOf(jCurrentTimeMillis), Long.valueOf(System.currentTimeMillis()), str3, str2, str, "SSLHandshakeException while calling api", e5, jSONObject2.optJSONArray("channels"), jSONObject2.optJSONObject("rootLogFields"));
                    return new JuspayHttpsResponse(-2, "SSL Handshake Failed".getBytes(), null);
                } catch (IOException e6) {
                    sdkTracker.trackAndLogApiException(JBridge.LOG_TAG, LogCategory.API_CALL, "network", Labels.Network.NETWORK_CALL, Long.valueOf(jCurrentTimeMillis), Long.valueOf(System.currentTimeMillis()), str3, str2, str, "IOException while calling api", e6, jSONObject2.optJSONArray("channels"), jSONObject2.optJSONObject("rootLogFields"));
                    return new JuspayHttpsResponse(-1, "Network Error".getBytes(), null);
                } catch (Exception e7) {
                    sdkTracker.trackAndLogApiException(JBridge.LOG_TAG, LogCategory.API_CALL, "network", Labels.Network.NETWORK_CALL, Long.valueOf(jCurrentTimeMillis), Long.valueOf(System.currentTimeMillis()), str3, str2, str, "Exception while calling api", e7, jSONObject2.optJSONArray("channels"), jSONObject2.optJSONObject("rootLogFields"));
                    byte[] bytes = new byte[0];
                    if (e7.getLocalizedMessage() != null) {
                        bytes = e7.getLocalizedMessage().getBytes();
                    }
                    return new JuspayHttpsResponse(-1, bytes, null);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        return str7;
    }

    @JavascriptInterface
    public void cancelAPI(String str) {
        NetUtils.cancelAPICall(str, this.juspayServices.getTrackerCallback());
    }

    @JavascriptInterface
    public void checkAmazonNonTokenSdk(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            invokeCallbackInDUIWebview(str, "true");
        } catch (ClassNotFoundException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.AMAZON_UTILS, "Amazon Sdk Not found Exception", e2);
            invokeCallbackInDUIWebview(str, "false");
        }
    }

    @JavascriptInterface
    public boolean checkCustomTabs() {
        return true;
    }

    @JavascriptInterface
    public boolean checkPhonePeSdk() throws ClassNotFoundException {
        try {
            Class.forName("com.phonepe.android.sdk.api.PhonePe");
            Class.forName("com.phonepe.android.sdk.api.PhonePeInitException");
            Class.forName("com.phonepe.android.sdk.api.builders.TransactionRequestBuilder");
            Class.forName("com.phonepe.android.sdk.base.model.TransactionRequest");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public void copyLink(String str, String str2, String str3) {
        ((ClipboardManager) this.juspayServices.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str2, str));
        invokeCallbackInDUIWebview(str3, "true");
    }

    @JavascriptInterface
    public int cursorPosition(int i2) {
        EditText editText;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            Activity activity = this.activity;
            if (activity == null || (editText = (EditText) activity.findViewById(i2)) == null) {
                return 0;
            }
            return editText.getSelectionStart();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Cursor Position Exception", e2);
            return 0;
        }
    }

    public long dateToMillisecond(String str) throws ParseException {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (ParseException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error in date to millis", e2);
            return 0L;
        }
    }

    @JavascriptInterface
    public String decryptJWE(String str, String str2, String str3, String str4, String str5, String str6) throws Exception {
        try {
            String str7 = str + CLConstants.DOT_SALT_DELIMETER + str2 + CLConstants.DOT_SALT_DELIMETER + str3 + CLConstants.DOT_SALT_DELIMETER + str4 + CLConstants.DOT_SALT_DELIMETER + str5;
            PrivateKey privateKey = getPrivateKey(str6);
            if (privateKey == null) {
                throw new Exception("Private key not found for alias: " + str6);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PaymentConstants.PAYLOAD, JOSEUtils.jweDecrypt(str7, privateKey).getString(PaymentConstants.PAYLOAD));
            jSONObject.put("error", false);
            return jSONObject.toString();
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error in JWE Decryption", e2);
            return android.support.v4.media.b.D("{\"error\":true,\"payload\":\"", e2.getMessage(), "\"}");
        }
    }

    @JavascriptInterface
    public boolean doesPhonePeAppExist(String str) throws PackageManager.NameNotFoundException {
        long j2;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.juspayServices.getContext().getPackageManager().getPackageInfo(str, 1);
            j2 = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            sdkTracker.trackAction("system", "debug", Labels.System.JBRIDGE, "Failed to get phonepe package name", e2);
            j2 = -1;
            packageInfo = packageInfo;
        }
        return packageInfo != null && j2 > 94033;
    }

    @JavascriptInterface
    public void drawAppIcon(String str) throws JSONException {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                PackageManager packageManager = this.juspayServices.getContext().getPackageManager();
                drawIcon(packageManager.getApplicationInfo(jSONObject.getString("packageName"), 0).loadIcon(packageManager), Integer.parseInt(jSONObject.getString(CLConstants.SHARED_PREFERENCE_ITEM_ID)));
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error happened while parsing json", e2);
        }
    }

    @JavascriptInterface
    public String encryptJWE(String str, String str2, String str3, String str4) {
        try {
            return jweEncrypt(str, str2, extractStoredPublicKey(str3, str4));
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error in JWE Encryption", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", e2);
        }
    }

    @JavascriptInterface
    public String encryptRSA(String str, String str2) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArrEncryptRSAHelper = encryptRSAHelper(str, str2);
        return bArrEncryptRSAHelper == null ? "" : Base64.encodeToString(bArrEncryptRSAHelper, 2);
    }

    public byte[] encryptRSAHelper(String str, String str2) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(Constants.ALG_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("-----END PUBLIC KEY-----", ""), 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            return cipher.doFinal(str2.getBytes());
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception when encrypting using RSA", e2);
            return null;
        }
    }

    @Override // in.juspay.hypersdk.core.HyperJsInterface
    @JavascriptInterface
    public void exitApp(int i2, String str) {
        SwypeLayout.clear();
        super.exitApp(i2, str);
    }

    @JavascriptInterface
    public String fetchDeviceDetails() throws JSONException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context context = this.juspayServices.getContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        CookieManager cookieManager = CookieManager.getInstance();
        JSONObject jSONObject = new JSONObject();
        try {
            String persistentDeviceFingerprint = getPersistentDeviceFingerprint(context);
            boolean zIsEmpty = persistentDeviceFingerprint.isEmpty();
            if (zIsEmpty) {
                persistentDeviceFingerprint = UUID.randomUUID().toString();
                context.getSharedPreferences("DevicePrefs", 0).edit().putString("device_fingerprint", persistentDeviceFingerprint).apply();
            }
            jSONObject.put("Application type", "Android");
            jSONObject.put("Browser language", Locale.getDefault().getLanguage());
            boolean z = !new java.net.CookieManager().getCookieStore().getCookies().isEmpty();
            if (cookieManager.acceptCookie()) {
                z = true;
            }
            jSONObject.put("Cookies enabled", z);
            jSONObject.put("Device matched", !zIsEmpty);
            jSONObject.put("deviceID_firstseen", zIsEmpty);
            jSONObject.put("Device fingerprint", persistentDeviceFingerprint);
            jSONObject.put("Flash enabled", false);
            jSONObject.put("Flash operating system", "");
            jSONObject.put("Flash version", "");
            jSONObject.put("Images enabled", false);
            jSONObject.put("JavaScript enabled", true);
            jSONObject.put("Jailbreak", SessionInfo.isRooted());
            jSONObject.put("Profiled URL", "");
            jSONObject.put("Screen resolution", displayMetrics.widthPixels + " x " + displayMetrics.heightPixels);
            jSONObject.put("True IP address", "");
            jSONObject.put("Proxy IP address", "");
            jSONObject.put("os_name", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("hardware_model", Build.MODEL);
            jSONObject.put("Profiling duration", System.currentTimeMillis() - jCurrentTimeMillis);
            jSONObject.put("Time on page", 0);
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error while fetching Device Details", e2);
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String findApps(String str) throws JSONException, PackageManager.NameNotFoundException {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        PackageManager packageManager = this.juspayServices.getContext().getPackageManager();
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Collections.sort(listQueryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
        JSONArray jSONArray = new JSONArray();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            JSONObject jSONObject = new JSONObject();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.activityInfo.packageName, 0);
                jSONObject.put("packageName", applicationInfo.packageName);
                jSONObject.put("appName", packageManager.getApplicationLabel(applicationInfo));
                jSONArray.put(jSONObject);
            } catch (PackageManager.NameNotFoundException e2) {
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error while searching for the app", e2);
            } catch (JSONException e3) {
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error While add to json", e3);
            }
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String generateRSAKeyPair(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(Constants.ALG_RSA, "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 15).setEncryptionPaddings("OAEPPadding").setSignaturePaddings("PKCS1").setDigests(MessageDigestAlgorithms.SHA_256).setKeySize(2048).build());
            keyPairGenerator.generateKeyPair();
            return "{\"error\":false,\"payload\":\"SUCCESS\"}";
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error in generateRSAKeyPair", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", e2);
        }
    }

    @JavascriptInterface
    public String get3DS2SdkList() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, HyperBridge> entry : this.juspayServices.getJBridgeList().entrySet()) {
            if (entry.getValue() instanceof ThreeDS2Bridge) {
                jSONArray.put(((ThreeDS2Bridge) entry.getValue()).getThreeDS2SdkName());
            }
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getApplicationContent() {
        return this.juspayServices.getApplicationManager().getApplicationContent();
    }

    @JavascriptInterface
    public String getBuildInfo() throws JSONException {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("BOARD", Build.BOARD);
            jSONObject.put("BRAND", Build.BRAND);
            jSONObject.put("CPU_ABI", Build.CPU_ABI);
            jSONObject.put("CPU_ABI2", Build.CPU_ABI2);
            jSONObject.put("DEVICE", Build.DEVICE);
            jSONObject.put("DISPLAY", Build.DISPLAY);
            jSONObject.put("FINGERPRINT", Build.FINGERPRINT);
            jSONObject.put("HARDWARE", Build.HARDWARE);
            jSONObject.put("HOST", Build.HOST);
            jSONObject.put("ID", Build.ID);
            jSONObject.put("MANUFACTURER", Build.MANUFACTURER);
            jSONObject.put("MODEL", Build.MODEL);
            jSONObject.put("PRODUCT", Build.PRODUCT);
            jSONObject.put("RADIO", Build.getRadioVersion());
            jSONObject.put("TAGS", Build.TAGS);
            jSONObject.put("TIME", Build.TIME);
            jSONObject.put("USER", Build.USER);
            jSONObject.put("SUPPORTED_32_BIT_ABIS", new JSONArray(Build.SUPPORTED_32_BIT_ABIS));
            jSONObject.put("SUPPORTED_64_BIT_ABIS", new JSONArray(Build.SUPPORTED_64_BIT_ABIS));
            jSONObject.put("SUPPORTED_ABIS", new JSONArray(Build.SUPPORTED_ABIS));
            JSONObject jSONObject2 = new JSONObject();
            int i2 = Build.VERSION.SDK_INT;
            jSONObject2.put("BASE_OS", Build.VERSION.BASE_OS);
            jSONObject2.put("INCREMENTAL", Build.VERSION.INCREMENTAL);
            jSONObject2.put("PREVIEW_SDK_INT", Build.VERSION.PREVIEW_SDK_INT);
            jSONObject2.put("SECURITY_PATCH", Build.VERSION.SECURITY_PATCH);
            jSONObject2.put("RELEASE", Build.VERSION.RELEASE);
            jSONObject2.put("SDK_INT", i2);
            jSONObject.put("VERSION", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception fetching build info", e2);
            return "";
        }
    }

    @JavascriptInterface
    public String getContainerMetrics() throws JSONException {
        int systemWindowInsetTop;
        int systemWindowInsetBottom;
        int systemWindowInsetLeft;
        int systemWindowInsetRight;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        FrameLayout container = this.juspayServices.getContainer();
        JSONObject jSONObject = new JSONObject();
        if (container != null && this.activity != null && this.juspayServices.getActivity() != null) {
            try {
                container.getLocationOnScreen(new int[2]);
                float f2 = this.activity.getResources().getDisplayMetrics().density;
                this.juspayServices.getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(new DisplayMetrics());
                int i3 = (int) (r5.heightPixels / f2);
                int i4 = (int) (r5.widthPixels / f2);
                int measuredHeight = (int) (container.getMeasuredHeight() / f2);
                int measuredWidth = (int) (container.getMeasuredWidth() / f2);
                if (Build.VERSION.SDK_INT >= 30) {
                    WindowInsets rootWindowInsets = container.getRootWindowInsets();
                    if (rootWindowInsets != null) {
                        systemWindowInsetTop = (int) (r1.top / f2);
                        systemWindowInsetBottom = (int) (r1.bottom / f2);
                        systemWindowInsetLeft = (int) (r1.left / f2);
                        systemWindowInsetRight = rootWindowInsets.getInsets(WindowInsets.Type.systemBars()).right;
                        i2 = (int) (systemWindowInsetRight / f2);
                    }
                    i2 = 0;
                    systemWindowInsetTop = 0;
                    systemWindowInsetBottom = 0;
                    systemWindowInsetLeft = 0;
                } else {
                    WindowInsets rootWindowInsets2 = container.getRootWindowInsets();
                    if (rootWindowInsets2 != null) {
                        systemWindowInsetTop = (int) (rootWindowInsets2.getSystemWindowInsetTop() / f2);
                        systemWindowInsetBottom = (int) (rootWindowInsets2.getSystemWindowInsetBottom() / f2);
                        systemWindowInsetLeft = (int) (rootWindowInsets2.getSystemWindowInsetLeft() / f2);
                        systemWindowInsetRight = rootWindowInsets2.getSystemWindowInsetRight();
                        i2 = (int) (systemWindowInsetRight / f2);
                    }
                    i2 = 0;
                    systemWindowInsetTop = 0;
                    systemWindowInsetBottom = 0;
                    systemWindowInsetLeft = 0;
                }
                ViewGroup viewGroup = this.container;
                if (viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
                    jSONObject.put("isHeightWrapContent", layoutParams.height == -2);
                }
                jSONObject.put("containerLocation", new JSONObject().put("containerX", (int) (r3[0] / f2)).put("containerY", (int) (r3[1] / f2)));
                jSONObject.put("windowMetrics", new JSONObject().put("windowHeight", i3).put("windowWidth", i4));
                jSONObject.put("containerMetrics", new JSONObject().put("containerHeight", measuredHeight).put("containerWidth", measuredWidth));
                jSONObject.put("insets", new JSONObject().put("topInset", systemWindowInsetTop).put("bottomInset", systemWindowInsetBottom).put("leftInset", systemWindowInsetLeft).put("rightInset", i2));
            } catch (Exception unused) {
            }
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public float getDensity() {
        return this.juspayServices.getContext().getResources().getDisplayMetrics().densityDpi / 160.0f;
    }

    @JavascriptInterface
    public String getDeviceInfo() throws JSONException {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        JSONObject sessionData = this.juspayServices.getSessionInfo().getSessionData();
        try {
            sessionData.put("android_id_raw", this.juspayServices.getSessionInfo().getAndroidId());
            return sessionData.toString();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while extracting android id", e2);
            return getSessionInfo();
        }
    }

    @JavascriptInterface
    @Deprecated
    public void getPackageName(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            invokeCallbackInDUIWebview(str, this.juspayServices.getContext().getPackageName());
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "NULL Pointer Exception while getting package name", e2);
            invokeCallbackInDUIWebview(str, MerchantConstants.ERROR);
        }
    }

    @JavascriptInterface
    public long getPhonePeVersionCode(String str) {
        PackageManager packageManager = this.juspayServices.getContext().getPackageManager();
        if (doesPhonePeAppExist(str)) {
            try {
                return packageManager.getPackageInfo(str, 1).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return -1L;
    }

    @JavascriptInterface
    public String getPublicKeyAsString(String str) throws JSONException {
        try {
            PublicKey publicKey = getPublicKey(str);
            if (publicKey == null) {
                return "{\"error\":true,\"payload\":\"publicKey is null\"}";
            }
            String strEncodeToString = Base64.encodeToString(publicKey.getEncoded(), 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", false);
            jSONObject.put(PaymentConstants.PAYLOAD, strEncodeToString);
            return String.valueOf(jSONObject);
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error in getPublicKeyAsString", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", e2);
        }
    }

    @JavascriptInterface
    public String getResourceByName(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int identifier = this.juspayServices.getContext().getResources().getIdentifier(str, str2, str3);
            return identifier > 0 ? super.getResourceById(identifier) : "0";
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Get Resource Exception", e2);
            return "0";
        }
    }

    @JavascriptInterface
    public String getSHA256Hash(@Nullable String str) throws NoSuchAlgorithmException {
        if (str == null) {
            return null;
        }
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(str.getBytes());
            String strBytesToHexString = EncryptionHelper.bytesToHexString(messageDigest.digest());
            JuspayLogger.d(LOG_TAG, "result is " + strBytesToHexString);
            return strBytesToHexString;
        } catch (NoSuchAlgorithmException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception caught trying to SHA-256 hash", e2);
            return null;
        }
    }

    @JavascriptInterface
    public String getStatusBarHeight(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int identifier = this.juspayServices.getContext().getResources().getIdentifier(str, str2, str3);
            if (identifier <= 0) {
                return "0";
            }
            return "" + this.juspayServices.getContext().getResources().getDimensionPixelSize(identifier);
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Get Resource Exception", e2);
            return "0";
        }
    }

    public void handleCustomTabResult(Intent intent) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if (intent == null) {
                invokeCallbackInDUIWebview((String) this.listenerMap.get("customtab-result-cb"), "{}");
            } else {
                invokeCallbackInDUIWebview((String) this.listenerMap.get("customtab-result-cb"), Utils.toJSON(intent.getExtras()).toString());
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.CUSTOM_TAB, "JSON Exception", e2);
            invokeCallbackInDUIWebview((String) this.listenerMap.get("customtab-result-cb"), "{}");
        }
    }

    public void handleDeepLinkResult(Intent intent) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if (intent == null) {
                invokeCallbackInDUIWebview((String) this.listenerMap.get(DEEPLINK_RESULT_CB), "{}");
            } else {
                invokeCallbackInDUIWebview((String) this.listenerMap.get(DEEPLINK_RESULT_CB), Utils.toJSON(intent.getExtras()).toString());
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.CUSTOM_TAB, "JSON Exception", e2);
            invokeCallbackInDUIWebview((String) this.listenerMap.get(DEEPLINK_RESULT_CB), "{}");
        }
    }

    @JavascriptInterface
    public boolean handlePermissionRequest(String str, String str2, boolean z) {
        PermissionRequest permissionRequest = pendingPermissionRequests.get(str);
        if (permissionRequest != null) {
            try {
                try {
                    if (z) {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr = new String[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            strArr[i2] = jSONArray.getString(i2);
                        }
                        ExecutorManager.runOnMainThread(new l(4, permissionRequest, strArr));
                    } else {
                        ExecutorManager.runOnMainThread(new v(permissionRequest, 1));
                    }
                    pendingPermissionRequests.remove(str);
                    return true;
                } catch (Exception unused) {
                    pendingPermissionRequests.remove(str);
                    return false;
                }
            } catch (Exception unused2) {
                ExecutorManager.runOnMainThread(new v(permissionRequest, 1));
                pendingPermissionRequests.remove(str);
                return false;
            }
        }
        return false;
    }

    @JavascriptInterface
    public void handlePhonepayActivityResult(String str) {
        invokeCallbackInDUIWebview("", str);
    }

    @JavascriptInterface
    public void hideJuspayLoader(String str) {
        ExecutorManager.runOnMainThread(new f0(this, str, 1));
    }

    @JavascriptInterface
    public void hideSoftInput() {
        InputMethodManager inputMethodManager;
        Activity activity = this.activity;
        if (activity == null || activity.getCurrentFocus() == null || (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 0);
    }

    @JavascriptInterface
    public boolean isCCTSupportedChromeAvailable(String str) {
        try {
            return CustomtabActivity.isChromeInstalled(CustomtabActivity.getCustomTabsPackages(this.juspayServices.getContext(), str));
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public boolean isNoLimitsActivity() {
        Activity activity = this.activity;
        return activity != null && (activity.getWindow().getAttributes().flags & 512) == 512;
    }

    @JavascriptInterface
    public boolean isShimmerPossible() throws ClassNotFoundException {
        try {
            Class.forName("com.facebook.shimmer.ShimmerFrameLayout");
            Class.forName("com.facebook.shimmer.Shimmer");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public String jweDecrypt(String str, String str2) throws JSONException {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            KeyPair keyPair = EncryptionHelper.getKeyPair(str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PaymentConstants.PAYLOAD, JOSEUtils.jweDecrypt(str, keyPair.getPrivate()));
            jSONObject.put("error", false);
            return jSONObject.toString();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while trying to decrypt JSON Web Token", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", e2);
        }
    }

    @JavascriptInterface
    public String jweEncrypt(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return "{\"error\":false,\"payload\":\"" + JOSEUtils.jweEncrypt(str, str2, Base64.decode(str3, 2)) + "\"}";
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while trying to encrypt JSON Web Token", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", e2);
        }
    }

    @JavascriptInterface
    public String jwsSign(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return "{\"error\":false,\"payload\":\"" + JOSEUtils.jwsSign(str, str2, EncryptionHelper.getKeyPair(str3).getPrivate()) + "\"}";
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while trying to sign JSON Web Token", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", e2);
        }
    }

    @JavascriptInterface
    public boolean jwsVerify(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return JOSEUtils.jwsVerify(str, Base64.decode(str2, 2));
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while trying to verify JSON Web Token", e2);
            return false;
        }
    }

    @JavascriptInterface
    public void launchCustomTab(String str, String str2) throws JSONException {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        this.listenerMap.put("customtab-result-cb", str2);
        try {
            if (!this.juspayServices.isPaused()) {
                Intent intent = new Intent(this.juspayServices.getContext(), (Class<?>) CustomtabActivity.class);
                intent.putExtra("url", str);
                registerReceiver("customtab-result");
                this.juspayServices.startActivityForResult(intent, -1, null);
                return;
            }
            sdkTracker.trackAction(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.CUSTOM_TAB, "onPause called before launch customtab");
            unRegisterReceiver();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CLConstants.OTP_STATUS, "onPause");
            invokeCallbackInDUIWebview(str2, jSONObject.toString());
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.CUSTOM_TAB, "Exception at launch customtab", e2);
            unRegisterReceiver();
            invokeCallbackInDUIWebview(str2, e2.toString());
        }
    }

    @JavascriptInterface
    public void makeAppRedirection(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.addFlags(268435456);
            this.juspayServices.getContext().startActivity(intent);
            this.juspayServices.addJsToWebView("if (window.onDeepLinkUrlAppOpen != null) { window.onDeepLinkUrlAppOpen('{}'); }");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public void openApp(String str, String str2, String str3, int i2, int i3) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction(str3);
        intent.setData(Uri.parse(str2));
        intent.setFlags(i2);
        this.juspayServices.startActivityForResult(intent, i3, null);
    }

    @JavascriptInterface
    public String readResource(String str) {
        return this.juspayServices.getApplicationManager().readResourceByName(str);
    }

    @JavascriptInterface
    public String readSplit(String str) {
        return this.juspayServices.getApplicationManager().readSplit(str);
    }

    @JavascriptInterface
    public String readSplits(String str) {
        return this.juspayServices.getApplicationManager().readSplits(str);
    }

    @JavascriptInterface
    public void registerCallbackForDeepLinkResult(String str) {
        this.listenerMap.put(DEEPLINK_RESULT_CB, str);
        registerReceiver(RedirectResponseActivity.DEEPLINK_RESULT_ACTION);
    }

    @JavascriptInterface
    public void registerReceiver(@NonNull String str) {
        if (this.broadcastReceiver != null) {
            return;
        }
        this.broadcastReceiver = new BroadcastReceiver() { // from class: in.juspay.hypersdk.core.JBridge.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) throws Exception {
                JBridge.this.receiverCallback(intent);
            }
        };
        LocalBroadcastManager.a(this.juspayServices.getContext()).b(this.broadcastReceiver, new IntentFilter(str));
    }

    @Override // in.juspay.hypersdk.core.DuiInterface
    public void reset() {
        super.reset();
        unRegisterReceiver();
    }

    @JavascriptInterface
    @Deprecated
    public String rsaEncryption(String str, String str2, String str3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(Constants.ALG_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str3, 2)));
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(1, rSAPublicKey);
            return "{\"error\":false,\"payload\":\"" + Base64.encodeToString(cipher.doFinal(str.getBytes()), 2) + "\"}";
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while trying to encrypt using RSA", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", e2);
        }
    }

    @JavascriptInterface
    public void shareLink(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(UtilsKt.MIME_TYPE_TEXT_PLAIN);
        intent.putExtra("android.intent.extra.TEXT", str);
        this.juspayServices.startActivityForResult(Intent.createChooser(intent, str2), -1, null);
        invokeCallbackInDUIWebview(str3, "true");
    }

    @JavascriptInterface
    public void showJuspayLoader(String str) {
        ExecutorManager.runOnMainThread(new f0(this, str, 0));
    }

    @JavascriptInterface
    public void startDatePicker(String str, String str2, String str3) {
        startDatePicker(str, str2, str3, null, 2, false);
    }

    @JavascriptInterface
    public void startLottieAnimation(final int i2, final String str, final boolean z, final float f2, final float f3) {
        final SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        ExecutorManager.runOnMainThread(new Runnable() { // from class: in.juspay.hypersdk.core.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f48561a.lambda$startLottieAnimation$6(i2, str, z, f2, f3, sdkTracker);
            }
        });
    }

    @JavascriptInterface
    public void startPaytmRequest(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (versionCompare(str2, "8.6.0") < 0) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("nativeSdkForMerchantAmount", jSONObject.optString("nativeSdkForMerchantAmount"));
                bundle.putString("orderid", jSONObject.optString("orderid"));
                bundle.putString("mid", jSONObject.optString("mid"));
                bundle.putString("txnToken", jSONObject.optString("txnToken"));
                intent.setComponent(new ComponentName("net.one97.paytm", jSONObject.optString("net.one97.paytm")));
                intent.putExtra("paymentmode", jSONObject.optInt("paymentmode"));
                intent.putExtra("bill", bundle);
                this.juspayServices.startActivityForResult(intent, 116, null);
                this.juspayServices.sdkDebug("paytmSDkParams1", intent.toString());
                return;
            }
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("net.one97.paytm", jSONObject.optString("net.one97.paytm")));
            intent2.putExtra("paymentmode", jSONObject.optInt("paymentmode"));
            intent2.putExtra("enable_paytm_invoke", jSONObject.optBoolean("enable_paytm_invoke"));
            intent2.putExtra("paytm_invoke", jSONObject.optBoolean("paytm_invoke"));
            intent2.putExtra("price", jSONObject.optString("price"));
            intent2.putExtra("nativeSdkEnabled", jSONObject.optBoolean("nativeSdkEnabled"));
            intent2.putExtra("orderid", jSONObject.optString("orderid"));
            intent2.putExtra("txnToken", jSONObject.optString("txnToken"));
            intent2.putExtra("mid", jSONObject.optString("mid"));
            this.juspayServices.startActivityForResult(intent2, 116, null);
            this.juspayServices.sdkDebug("paytmSDkParams2", intent2.toString());
        } catch (JSONException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.PAYTM_UTILS, "Paytm Init Exception", e2);
            invokeCallbackInDUIWebview(str3, e2.toString());
        }
    }

    @JavascriptInterface
    @Deprecated
    public void startPhonepeRequest(String str, String str2, String str3, String str4) {
        invokeCallbackInDUIWebview(str4, "Function deprecated");
    }

    @JavascriptInterface
    public String triggerIntent(String str, String str2, int i2, int i3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setData(Uri.parse(str));
            intent.addFlags(i2);
            this.juspayServices.startActivityForResult(intent, i3, null);
            return "{\"error\":\"false\",\"data\":\"Success\"}";
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Error in triggerIntent", e2);
            return android.support.v4.media.b.D("{\"error\":\"true\",\"data\":\"", e2.getMessage(), "\"}");
        }
    }

    @JavascriptInterface
    public void unRegisterReceiver() {
        if (this.broadcastReceiver == null) {
            return;
        }
        LocalBroadcastManager.a(this.juspayServices.getContext()).d(this.broadcastReceiver);
        this.broadcastReceiver = null;
    }

    @JavascriptInterface
    public String verifyJws(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return "{\"error\":false,\"payload\":\"" + jwsVerify(str, extractStoredPublicKey(str2, str3)) + "\"}";
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while trying to sign JSON Web Token", e2);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", e2);
        }
    }

    @JavascriptInterface
    public void writeFileToDisk(String str, String str2, String str3) {
        invokeCallbackInDUIWebview(str3, this.juspayServices.getFileProviderService().writeFileToDisk(this.juspayServices.getContext(), str, str2));
    }

    @JavascriptInterface
    public void startDatePicker(String str, String str2, String str3, String str4, int i2, boolean z) {
        ExecutorManager.runOnMainThread(new i(this, str, str4, i2, str2, str3, z));
    }

    @JavascriptInterface
    public void startPhonepeRequest(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setPackage(str2);
        this.juspayServices.startActivityForResult(intent, WKSRecord.Service.AUTH, null);
    }

    @JavascriptInterface
    @Deprecated
    public void checkPhonePeSdk(String str) {
        invokeCallbackInDUIWebview(str, String.valueOf(checkPhonePeSdk()));
    }
}
