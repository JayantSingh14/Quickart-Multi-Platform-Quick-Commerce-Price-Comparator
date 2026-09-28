package in.juspay.hyperupi;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Parcelable;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.core.content.ContextCompat;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.zbs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapi.zbap;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.StandardIntegrityManager;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.BridgeProcessResponse;
import in.juspay.hyper.core.CallbackInvoker;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.FragmentHooks;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.TrackerInterface;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;
import org.npci.upi.security.services.CLServices;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class UPIBridge extends HyperBridge {
    private static final float BEEP_VOLUME = 0.1f;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final String LOG_TAG = "UPIBridge";
    private static final int REQUEST_CODE_PHONE_NUMBER_HINT = 1001;

    @Nullable
    private static StandardIntegrityManager.StandardIntegrityTokenProvider integrityTokenProvider;

    @NotNull
    private final CLUtils clInterface;
    private boolean errorInNativeDecode;

    @Nullable
    private PhoneNumberRetrievedCallback phoneNumberCallback;

    @NotNull
    private final Queue<ResetCallback> resetCallbackQueue;

    @NotNull
    private final UPIUtils upiInterface;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata
    public interface PhoneNumberRetrievedCallback {
        void onPhoneNumberRetrievalFailed(@NotNull String str);

        void onPhoneNumberRetrieved(@NotNull String str);
    }

    @Metadata
    /* renamed from: in.juspay.hyperupi.UPIBridge$sendSMS$1, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C01061 implements OnRegisterCallback, FunctionAdapter {
        final /* synthetic */ Queue<ResetCallback> $tmp0;

        public C01061(Queue<ResetCallback> queue) {
            this.$tmp0 = queue;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof OnRegisterCallback) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(this.$tmp0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // in.juspay.hyperupi.OnRegisterCallback
        public final void onRegistered(ResetCallback resetCallback) {
            this.$tmp0.add(resetCallback);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UPIBridge(@NotNull BridgeComponents bridgeComponents) {
        super(bridgeComponents);
        Intrinsics.checkNotNullParameter(bridgeComponents, "bridgeComponents");
        this.upiInterface = new UPIUtils(bridgeComponents);
        this.clInterface = new CLUtils(bridgeComponents);
        this.resetCallbackQueue = new LinkedList();
        JSONObject jSONObjectOptJSONObject = bridgeComponents.getSdkConfig().optJSONObject(PaymentConstants.WIDGET_UPI);
        boolean zOptBoolean = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optBoolean("enableRegisterService", false) : false;
        this.errorInNativeDecode = false;
        if (zOptBoolean) {
            bridgeComponents.registerService("in.juspay.hyperapi", this);
        }
    }

    private final String aesDecrypt(String str, String str2) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] cipherData = Base64.decode(str2, 2);
        Intrinsics.checkNotNullExpressionValue(cipherData, "cipherData");
        byte[] bArrO = ArraysKt.o(0, cipherData, 16);
        byte[] bArrO2 = ArraysKt.o(16, cipherData, 32);
        byte[] bArrO3 = ArraysKt.o(32, cipherData, cipherData.length);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        SecretKey secretKeyGenerateSecret = secretKeyFactory.generateSecret(new PBEKeySpec(charArray, bArrO, 10000, 256));
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateSecret, "factory.generateSecret(spec)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyGenerateSecret.getEncoded(), CLConstants.AES_KEY_VAULT_KEY);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrO2);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        byte[] decryptedData = cipher.doFinal(bArrO3);
        Intrinsics.checkNotNullExpressionValue(decryptedData, "decryptedData");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new String(decryptedData, UTF_8);
    }

    private final String extractHashFromRequest(JSONObject jSONObject) throws JSONException, NoSuchAlgorithmException {
        String string;
        String deviceId;
        String strOptString = jSONObject.optString(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL);
        String strOptString2 = jSONObject.optString("protected");
        if (Intrinsics.b(strOptString, "")) {
            string = jSONObject.optString("customerId");
            Intrinsics.checkNotNullExpressionValue(string, "{\n            innerPaylo…g(\"customerId\")\n        }");
        } else if (Intrinsics.b(strOptString2, "")) {
            string = new JSONObject(strOptString).getString(PaymentConstants.CUSTOMER_ID);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            signatureP…customer_id\") }\n        }");
        } else {
            byte[] bArrDecode = Base64.decode(strOptString, 2);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(it, Base64.NO_WRAP or Base64.DEFAULT)");
            string = new JSONObject(new String(bArrDecode, Charsets.UTF_8)).getString("merchantCustomerId");
            Intrinsics.checkNotNullExpressionValue(string, "{\n            signatureP…tCustomerId\") }\n        }");
        }
        if (Intrinsics.b(string, "")) {
            String fromSharedPreference = getBridgeComponents().getWorkspace().getFromSharedPreference("CUSTOMER_ID", "");
            if (fromSharedPreference == null || fromSharedPreference.equals("")) {
                string = "";
            } else {
                string = fromSharedPreference.substring(1, fromSharedPreference.length() - 1);
                Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String…ing(startIndex, endIndex)");
            }
        }
        String fromSharedPreference2 = getBridgeComponents().getWorkspace().getFromSharedPreference("BOUND_DEVICE_ID", "");
        if (fromSharedPreference2 == null || fromSharedPreference2.equals("")) {
            deviceId = getBridgeComponents().getSessionInfoInterface().getDeviceId();
        } else {
            deviceId = fromSharedPreference2.substring(1, fromSharedPreference2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(deviceId, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        String sHA256Hash = getSHA256Hash(android.support.v4.media.b.k(deviceId, string));
        String strW = sHA256Hash != null ? StringsKt.W(35, sHA256Hash) : null;
        return strW == null ? "" : strW;
    }

    private final String fetchAddress(Context context, Location location) throws IOException {
        Address address;
        try {
            List<Address> fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            String addressLine = (fromLocation == null || (address = fromLocation.get(0)) == null) ? null : address.getAddressLine(0);
            return addressLine == null ? "DEFAULT" : addressLine;
        } catch (Exception e2) {
            TrackerInterface trackerInterface = getBridgeComponents().getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UPI_UTILS, "FetchAddress Exception", e2);
            return "DEFAULT";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLocationDetails$lambda$13(UPIBridge this$0, String callback) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lat", "00.000000");
            jSONObject.put("long", "00.000000");
            jSONObject.put("addr", "DEFAULT");
            jSONObject.put("error", true);
            if (ContextCompat.a(this$0.getBridgeComponents().getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.a(this$0.getBridgeComponents().getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                LocationManager locationManager = (LocationManager) this$0.getBridgeComponents().getContext().getSystemService("location");
                Location lastKnownLocation = null;
                for (String str : Build.VERSION.SDK_INT >= 31 ? new String[]{"fused", "gps", "network", "passive"} : new String[]{"gps", "network", "passive"}) {
                    if (locationManager != null && locationManager.isProviderEnabled(str) && (lastKnownLocation = locationManager.getLastKnownLocation(str)) != null) {
                        break;
                    }
                }
                if (lastKnownLocation != null) {
                    String strFetchAddress = this$0.fetchAddress(this$0.getBridgeComponents().getContext(), lastKnownLocation);
                    String str2 = String.format(Locale.getDefault(), "%.6f", Arrays.copyOf(new Object[]{Double.valueOf(lastKnownLocation.getLatitude())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
                    jSONObject.put("lat", str2);
                    String str3 = String.format(Locale.getDefault(), "%.6f", Arrays.copyOf(new Object[]{Double.valueOf(lastKnownLocation.getLongitude())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
                    jSONObject.put("long", str3);
                    jSONObject.put("addr", strFetchAddress);
                    jSONObject.put("error", false);
                } else {
                    jSONObject.put("errorMsg", "Could not fetch location from any provider");
                }
            } else {
                jSONObject.put("errorMsg", "No location permission given");
            }
        } catch (Exception e2) {
            TrackerInterface trackerInterface = this$0.getBridgeComponents().getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UPI_UTILS, "Get Geocode Exception", e2);
            jSONObject.put("errorMsg", e2.getMessage());
        }
        this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, jSONObject.toString());
    }

    private final void getPhoneNumber(final PhoneNumberRetrievedCallback phoneNumberRetrievedCallback) {
        this.phoneNumberCallback = phoneNumberRetrievedCallback;
        Parcelable.Creator<GetPhoneNumberHintIntentRequest> creator = GetPhoneNumberHintIntentRequest.CREATOR;
        GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequestA = GetPhoneNumberHintIntentRequest.Builder.a();
        Intrinsics.checkNotNullExpressionValue(getPhoneNumberHintIntentRequestA, "builder().build()");
        new zbap((Context) Preconditions.checkNotNull(getBridgeComponents().getContext()), new zbs()).c(getPhoneNumberHintIntentRequestA).e(new in.juspay.hypersmshandler.b(3, new Function1<PendingIntent, Unit>() { // from class: in.juspay.hyperupi.UPIBridge.getPhoneNumber.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PendingIntent) obj);
                return Unit.f53572a;
            }

            public final void invoke(PendingIntent pendingIntent) {
                try {
                    FragmentHooks fragmentHooks = UPIBridge.this.getBridgeComponents().getFragmentHooks();
                    IntentSender intentSender = pendingIntent.getIntentSender();
                    Intrinsics.checkNotNullExpressionValue(intentSender, "pendingIntent.intentSender");
                    fragmentHooks.startIntentSenderForResult(intentSender, 1001, null, 0, 0, 0, null);
                } catch (IntentSender.SendIntentException e2) {
                    TrackerInterface trackerInterface = UPIBridge.this.getBridgeComponents().getTrackerInterface();
                    String LOG_TAG2 = UPIBridge.LOG_TAG;
                    Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
                    trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UTIL, "Google intent Exception : ", e2);
                    phoneNumberRetrievedCallback.onPhoneNumberRetrievalFailed("GOOGLE_INTENT_FAILURE");
                }
            }
        })).c(new androidx.media3.exoplayer.analytics.d(15, this, phoneNumberRetrievedCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPhoneNumber$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPhoneNumber$lambda$9(UPIBridge this$0, PhoneNumberRetrievedCallback callback, Exception e2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(e2, "e");
        TrackerInterface trackerInterface = this$0.getBridgeComponents().getTrackerInterface();
        String LOG_TAG2 = LOG_TAG;
        Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
        trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UTIL, "Phone Number Hint request failed : ", e2);
        callback.onPhoneNumberRetrievalFailed("GOOGLE_INTENT_FAILURE");
    }

    private final String getSHA256Hash(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(\"SHA-256\")");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest.digest()");
            return getSHA256Hash$bytesToHexString(bArrDigest);
        } catch (Exception unused) {
            return null;
        }
    }

    private static final String getSHA256Hash$bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuffer.toString()");
        return string;
    }

    private final boolean isPermissionGranted(String str) {
        return ContextCompat.a(getBridgeComponents().getContext(), str) == 0;
    }

    private final JSONObject notifyMerchant(String str, String str2, boolean z, String str3, JSONObject jSONObject, JSONObject jSONObject2, Function1<? super JSONObject, Unit> function1) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("requestId", jSONObject.optString("requestId", ""));
            jSONObject3.put(PaymentConstants.SERVICE, jSONObject.optString(PaymentConstants.SERVICE, PaymentConstants.SERVICE));
            jSONObject3.put("error", z);
            jSONObject3.put(CLConstants.FIELD_ERROR_CODE, str);
            jSONObject3.put("errorMessage", str2);
            jSONObject3.put("event", str3);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject3.put(PaymentConstants.PAYLOAD, jSONObject2);
            function1.invoke(jSONObject3);
        } catch (Exception unused) {
        }
        return jSONObject3;
    }

    private final void notifyMerchantSuccess(String str, JSONObject jSONObject, JSONObject jSONObject2, Function1<? super JSONObject, Unit> function1) throws JSONException {
        notifyMerchant("", "", false, str, jSONObject, jSONObject2, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playSound$lambda$14(MediaPlayer mp) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(mp, "mp");
        mp.stop();
        mp.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean playSound$lambda$15(UPIBridge this$0, MediaPlayer mp, int i2, int i3) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mp, "mp");
        Log.w(LOG_TAG, "Failed to play sound " + i2 + ", " + i3);
        this$0.getBridgeComponents().getTrackerInterface().trackAction("system", "error", Labels.System.PLAY_AUDIO, "Failed to play sound", i2 + ", " + i3);
        mp.stop();
        mp.release();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareIntegrityTokenProvider$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareIntegrityTokenProvider$lambda$3(UPIBridge this$0, String callback, Exception exception) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(exception, "exception");
        TrackerInterface trackerInterface = this$0.getBridgeComponents().getTrackerInterface();
        String LOG_TAG2 = LOG_TAG;
        Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
        trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", "IntegrityCheck", "Failed to prepare Integrity Token: " + exception.getMessage(), exception);
        this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"error\":\"true\",\"data\":\"INTEGRITY_TOKEN_PROVIDER_FAILED\"}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void process$lambda$5(UPIBridge this$0, String hash, String str, JSONObject payload, Function1 merchantCallback) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hash, "$hash");
        Intrinsics.checkNotNullParameter(payload, "$payload");
        Intrinsics.checkNotNullParameter(merchantCallback, "$merchantCallback");
        try {
            ExecutorManager.runOnMainThread(new androidx.media3.exoplayer.source.h(this$0, payload, new JSONObject(this$0.aesDecrypt(hash, str)), merchantCallback, 11));
        } catch (Exception e2) {
            this$0.getBridgeComponents().getTrackerInterface().trackAction("system", "error", Labels.System.UPI_UTILS, "Error Decoding GST CACHE", e2.toString());
            this$0.errorInNativeDecode = true;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "upiGetSessionToken");
            this$0.notifyMerchant("JP_001", "SDK internal error", true, "process_result", payload, jSONObject, merchantCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void process$lambda$5$lambda$4(UPIBridge this$0, JSONObject payload, JSONObject respPayload, Function1 merchantCallback) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(payload, "$payload");
        Intrinsics.checkNotNullParameter(respPayload, "$respPayload");
        Intrinsics.checkNotNullParameter(merchantCallback, "$merchantCallback");
        this$0.notifyMerchantSuccess("process_result", payload, respPayload, merchantCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestIntegrityToken$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestIntegrityToken$lambda$1(UPIBridge this$0, String callback, Exception exception) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(exception, "exception");
        TrackerInterface trackerInterface = this$0.getBridgeComponents().getTrackerInterface();
        String LOG_TAG2 = LOG_TAG;
        Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
        trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", "IntegrityCheck", "Integrity Token request failed: " + exception.getMessage(), exception);
        this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"error\":\"true\",\"data\":\"INTEGRITY_TOKEN_GENERATION_FAILED\"}");
    }

    @JavascriptInterface
    public final boolean checkCLLibrary() {
        try {
            int i2 = CLRemoteResultReceiver.f57683a;
            int i3 = CLServices.f57684a;
            return true;
        } catch (Exception e2) {
            TrackerInterface trackerInterface = getBridgeComponents().getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.CL_ELIGIBILITY, "Inapp Eligibility Exception", e2);
            getBridgeComponents().getTrackerInterface().trackAction("system", "debug", Labels.System.CL_ELIGIBILITY, "Inapp Eligibility", "False : CL Dependencies are missing.");
            return false;
        }
    }

    @JavascriptInterface
    @NotNull
    public final String checkConnection() {
        Context context = getBridgeComponents().getContext();
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        Object systemService2 = context.getSystemService("phone");
        TelephonyManager telephonyManager = systemService2 instanceof TelephonyManager ? (TelephonyManager) systemService2 : null;
        if (connectivityManager == null) {
            return UPIConstants.NETWORK_UNAVAILABLE;
        }
        if (!isPermissionGranted("android.permission.ACCESS_NETWORK_STATE")) {
            return UPIConstants.NETWORK_PERMISSION_DENIED;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return UPIConstants.NETWORK_UNAVAILABLE;
        }
        if (activeNetworkInfo.getType() != 1) {
            return activeNetworkInfo.getType() == 0 ? UPIConstants.MOBILE_DATA : UPIConstants.NETWORK_UNAVAILABLE;
        }
        boolean zIsDataEnabled = false;
        boolean z = Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 0;
        if (Build.VERSION.SDK_INT >= 29) {
            if (telephonyManager != null) {
                zIsDataEnabled = telephonyManager.isDataEnabled();
            }
        } else if (telephonyManager != null && telephonyManager.getSimState() == 5) {
            zIsDataEnabled = Settings.Global.getInt(context.getContentResolver(), "mobile_data", 1) == 1;
        }
        return (zIsDataEnabled && z) ? UPIConstants.MOBILE_DATA_AND_WIFI : UPIConstants.WIFI;
    }

    @JavascriptInterface
    @NotNull
    public final String decodeNPCIXmlKeys(@Nullable String str) {
        return this.clInterface.decodeNPCIXmlKeys(str);
    }

    @JavascriptInterface
    @NotNull
    public final String generateRandom() {
        return this.clInterface.generateRandom();
    }

    @JavascriptInterface
    @Nullable
    public final String generateTrustCred(@Nullable String str, @Nullable String str2) {
        return this.clInterface.generateTrustCred(str, str2);
    }

    @JavascriptInterface
    @NotNull
    public final String getCLVersion() {
        return this.clInterface.getClVersion();
    }

    @JavascriptInterface
    public final void getChallenge(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.clInterface.getChallenge(str, str2, str3);
    }

    @JavascriptInterface
    @NotNull
    public final String getContactList() {
        return isPermissionGranted("android.permission.READ_CONTACTS") ? this.upiInterface.getContactList() : "{\"error\":\"true\",\"payload\":\"PERMISSION_DENIED\"}";
    }

    @JavascriptInterface
    public final void getCredentials(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        this.clInterface.getCredentials(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    @JavascriptInterface
    @NotNull
    public final String getDeviceDetails() {
        byte[] bytes = this.upiInterface.getDeviceDetails().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(\n        … Base64.DEFAULT\n        )");
        return strEncodeToString;
    }

    @JavascriptInterface
    @SuppressLint({"MissingPermission"})
    public final void getLocationDetails(@NotNull String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ExecutorManager.runOnBackgroundThread(new in.juspay.hypernfc.b(15, this, callback));
    }

    @JavascriptInterface
    @NotNull
    public final String getSIMOperators() {
        byte[] bytes;
        String simOperators = this.upiInterface.getSimOperators();
        if (simOperators != null) {
            bytes = simOperators.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        } else {
            bytes = null;
        }
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(\n        … Base64.DEFAULT\n        )");
        return strEncodeToString;
    }

    @JavascriptInterface
    public final void getUPILiteBalance(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.clInterface.getUPILiteBalance(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final boolean isAirplaneModeOn() {
        return this.upiInterface.isAirplaneModeOn();
    }

    @JavascriptInterface
    public final boolean isDualSIM() {
        return SimUtils.INSTANCE.isDualSim(getBridgeComponents().getContext());
    }

    @JavascriptInterface
    public final boolean isSimActive(int i2) {
        return this.upiInterface.isSimActive(i2);
    }

    @JavascriptInterface
    public final boolean isSimSupport() {
        return SimUtils.INSTANCE.isSimSupport(getBridgeComponents().getContext());
    }

    @JavascriptInterface
    public final void isUpiLiteBound(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.clInterface.isUpiLiteBound(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void isUpiLiteSupported(@Nullable String str) {
        this.clInterface.isUpiLiteSupported(str);
    }

    @Override // in.juspay.hyper.bridge.HyperBridge
    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        PhoneNumberRetrievedCallback phoneNumberRetrievedCallback;
        PhoneNumberRetrievedCallback phoneNumberRetrievedCallback2;
        if (i2 != 1001) {
            return false;
        }
        if (i3 != -1 || intent == null) {
            getBridgeComponents().getTrackerInterface().trackAction("system", "debug", Labels.System.CL_ELIGIBILITY, "ResultCode", "Result code didn't match or data is null");
            PhoneNumberRetrievedCallback phoneNumberRetrievedCallback3 = this.phoneNumberCallback;
            if (phoneNumberRetrievedCallback3 != null) {
                phoneNumberRetrievedCallback3.onPhoneNumberRetrievalFailed("BACKPRESSED");
            }
        } else {
            try {
                String strB = new zbap((Context) Preconditions.checkNotNull(getBridgeComponents().getContext()), new zbs()).b(intent);
                Intrinsics.checkNotNullExpressionValue(strB, "getSignInClient(bridgeCo…oneNumberFromIntent(data)");
                String strReplace = new Regex("\\D+").replace(strB, "");
                Unit unit = null;
                if ((strReplace.length() == 10 ? strReplace : null) == null) {
                    String strX = StringsKt.X(10, strReplace);
                    if (strX.length() != 10) {
                        strX = null;
                    }
                    if (strX != null && (phoneNumberRetrievedCallback2 = this.phoneNumberCallback) != null) {
                        phoneNumberRetrievedCallback2.onPhoneNumberRetrieved(strX);
                        unit = Unit.f53572a;
                    }
                    if (unit == null && (phoneNumberRetrievedCallback = this.phoneNumberCallback) != null) {
                        phoneNumberRetrievedCallback.onPhoneNumberRetrievalFailed("INVALID_PHONE_NUMBER");
                        Unit unit2 = Unit.f53572a;
                        return true;
                    }
                }
            } catch (Exception e2) {
                TrackerInterface trackerInterface = getBridgeComponents().getTrackerInterface();
                String LOG_TAG2 = LOG_TAG;
                Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
                trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UTIL, "onActivityResult exception : ", e2);
                PhoneNumberRetrievedCallback phoneNumberRetrievedCallback4 = this.phoneNumberCallback;
                if (phoneNumberRetrievedCallback4 != null) {
                    phoneNumberRetrievedCallback4.onPhoneNumberRetrievalFailed("ACTIVITY_FAILURE");
                }
            }
        }
        return true;
    }

    @JavascriptInterface
    public final void playSound(@Nullable String str, @Nullable String str2) throws IllegalStateException, IOException {
        if (str == null) {
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            JuspayLogger.d(LOG_TAG2, "sound is null, returning.");
            CallbackInvoker callbackInvoker = getBridgeComponents().getCallbackInvoker();
            byte[] bytes = "sound NOT PROVIDED".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String str3 = String.format("{\"error\":\"true\",\"data\":\"%s\"}", Arrays.copyOf(new Object[]{Base64.encodeToString(bytes, 2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
            callbackInvoker.invokeCallbackInDUIWebview(str2, str3);
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(new h());
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: in.juspay.hyperupi.i
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) {
                return UPIBridge.playSound$lambda$15(this.f48796a, mediaPlayer2, i2, i3);
            }
        });
        try {
            AssetFileDescriptor assetFileDescriptorOpenFd = getBridgeComponents().getContext().getResources().getAssets().openFd(str);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                Unit unit = Unit.f53572a;
                assetFileDescriptorOpenFd.close();
                mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } finally {
            }
        } catch (Exception e2) {
            String LOG_TAG3 = LOG_TAG;
            Log.w(LOG_TAG3, e2);
            TrackerInterface trackerInterface = getBridgeComponents().getTrackerInterface();
            Intrinsics.checkNotNullExpressionValue(LOG_TAG3, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG3, "action", "system", Labels.System.PLAY_AUDIO, "PlaySound Exception", e2);
            mediaPlayer.release();
        }
    }

    @JavascriptInterface
    @Nullable
    public final String populateHMAC(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return this.clInterface.populateHMAC(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void prepareIntegrityTokenProvider(@NotNull String cloudProjectNumber, @NotNull final String callback) {
        Intrinsics.checkNotNullParameter(cloudProjectNumber, "cloudProjectNumber");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Long lA0 = StringsKt.a0(cloudProjectNumber);
            if (lA0 != null && lA0.longValue() != 0) {
                StandardIntegrityManager standardIntegrityManagerA = IntegrityManagerFactory.a(getBridgeComponents().getContext());
                Intrinsics.checkNotNullExpressionValue(standardIntegrityManagerA, "createStandard(bridgeComponents.context)");
                StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder builderB = StandardIntegrityManager.PrepareIntegrityTokenRequest.b();
                builderB.b(lA0.longValue());
                standardIntegrityManagerA.a(builderB.a()).e(new in.juspay.hypersmshandler.b(2, new Function1<StandardIntegrityManager.StandardIntegrityTokenProvider, Unit>() { // from class: in.juspay.hyperupi.UPIBridge.prepareIntegrityTokenProvider.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((StandardIntegrityManager.StandardIntegrityTokenProvider) obj);
                        return Unit.f53572a;
                    }

                    public final void invoke(StandardIntegrityManager.StandardIntegrityTokenProvider standardIntegrityTokenProvider) {
                        UPIBridge.integrityTokenProvider = standardIntegrityTokenProvider;
                        UPIBridge.this.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"success\":\"true\"}");
                    }
                })).c(new g(this, callback, 0));
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid cloud project number: ".concat(cloudProjectNumber));
            TrackerInterface trackerInterface = getBridgeComponents().getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", "IntegrityCheck", "Invalid cloud project number: ".concat(cloudProjectNumber), illegalArgumentException);
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"error\":\"true\",\"data\":\"INVALID_CLOUD_PROJECT_NUMBER\"}");
        } catch (Exception e2) {
            TrackerInterface trackerInterface2 = getBridgeComponents().getTrackerInterface();
            String LOG_TAG3 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG3, "LOG_TAG");
            trackerInterface2.trackAndLogException(LOG_TAG3, "action", "system", "IntegrityCheck", "Prepare Integrity Token exception: " + e2.getMessage(), e2);
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"error\":\"true\",\"data\":\"INTEGRITY_TOKEN_PROVIDER_FAILED\"}");
        }
    }

    @Override // in.juspay.hyper.bridge.HyperBridge
    @NotNull
    public BridgeProcessResponse process(@NotNull JSONObject payload, @NotNull Function1<? super JSONObject, Unit> merchantCallback) throws JSONException {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(merchantCallback, "merchantCallback");
        JSONObject innerPayload = payload.optJSONObject(PaymentConstants.PAYLOAD);
        if (Intrinsics.b(innerPayload != null ? innerPayload.optString("action") : null, "upiGetSessionToken")) {
            String fromSharedPreference = getBridgeComponents().getWorkspace().getFromSharedPreference("GST_NATIVE_RESP", "");
            String fromSharedPreference2 = getBridgeComponents().getWorkspace().getFromSharedPreference("GST_NATIVE_RESP_ENC", "");
            if (!Intrinsics.b(fromSharedPreference, "") && fromSharedPreference != null) {
                notifyMerchantSuccess("process_result", payload, new JSONObject(fromSharedPreference), merchantCallback);
                innerPayload.put("skipResponse", true);
            } else if (fromSharedPreference2 != null && !fromSharedPreference2.equals("") && !this.errorInNativeDecode) {
                Intrinsics.checkNotNullExpressionValue(innerPayload, "innerPayload");
                jSONObject = payload;
                ExecutorManager.runOnBackgroundThread(new androidx.media3.exoplayer.audio.i(this, extractHashFromRequest(innerPayload), fromSharedPreference2, jSONObject, merchantCallback, 4));
                innerPayload.put("skipResponse", true);
            }
            jSONObject = payload;
        } else {
            jSONObject = payload;
        }
        return new BridgeProcessResponse(false, jSONObject);
    }

    @JavascriptInterface
    public final void registerApp(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.clInterface.registerApp(str, str2, str3, str4, str5);
    }

    @JavascriptInterface
    public final void registerUPILiteOnboarding(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.clInterface.registerUPILiteOnboarding(str, str2, str3, str4, str5);
    }

    @JavascriptInterface
    public final void registerUPILiteState(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.clInterface.registerUPILiteState(str, str2, str3, str4, str5);
    }

    @JavascriptInterface
    public final void requestIntegrityToken(@NotNull String requestHash, @NotNull final String callback) {
        Intrinsics.checkNotNullParameter(requestHash, "requestHash");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            StandardIntegrityManager.StandardIntegrityTokenProvider standardIntegrityTokenProvider = integrityTokenProvider;
            if (standardIntegrityTokenProvider == null) {
                getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"error\":\"true\",\"data\":\"INTEGRITY_TOKEN_PROVIDER_NULL\"}");
                return;
            }
            StandardIntegrityManager.StandardIntegrityTokenRequest.Builder builderA = StandardIntegrityManager.StandardIntegrityTokenRequest.a();
            builderA.b(requestHash);
            Task taskA = standardIntegrityTokenProvider.a(builderA.a());
            taskA.e(new in.juspay.hypersmshandler.b(4, new Function1<StandardIntegrityManager.StandardIntegrityToken, Unit>() { // from class: in.juspay.hyperupi.UPIBridge.requestIntegrityToken.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((StandardIntegrityManager.StandardIntegrityToken) obj);
                    return Unit.f53572a;
                }

                public final void invoke(@NotNull StandardIntegrityManager.StandardIntegrityToken response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    UPIBridge.this.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"success\":\"true\",\"data\":\"" + response.a() + "\"}");
                }
            }));
            taskA.c(new g(this, callback, 1));
        } catch (Exception e2) {
            TrackerInterface trackerInterface = getBridgeComponents().getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", "IntegrityCheck", "Request Integrity Token exception: " + e2.getMessage(), e2);
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"error\":\"true\",\"data\":\"INTEGRITY_TOKEN_GENERATION_FAILED\"}");
        }
    }

    @Override // in.juspay.hyper.bridge.HyperBridge
    public void reset() {
        while (this.resetCallbackQueue.peek() != null) {
            ResetCallback resetCallbackPoll = this.resetCallbackQueue.poll();
            if (resetCallbackPoll != null) {
                resetCallbackPoll.reset();
            }
        }
    }

    @JavascriptInterface
    public final void sendSMS(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        sendSMS(str, new String[]{str}, str3, "1", str4);
    }

    @JavascriptInterface
    public final void startPhoneNumberHint(@NotNull final String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPhoneNumber(new PhoneNumberRetrievedCallback() { // from class: in.juspay.hyperupi.UPIBridge.startPhoneNumberHint.1
            @Override // in.juspay.hyperupi.UPIBridge.PhoneNumberRetrievedCallback
            public void onPhoneNumberRetrievalFailed(@NotNull String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                CallbackInvoker callbackInvoker = UPIBridge.this.getBridgeComponents().getCallbackInvoker();
                String str = callback;
                String str2 = String.format("{\"error\":\"true\",\"data\":\"%s\"}", Arrays.copyOf(new Object[]{errorMessage}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                callbackInvoker.invokeCallbackInDUIWebview(str, str2);
            }

            @Override // in.juspay.hyperupi.UPIBridge.PhoneNumberRetrievedCallback
            public void onPhoneNumberRetrieved(@NotNull String phoneNumber) {
                Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
                UPIBridge.this.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, phoneNumber);
            }
        });
    }

    @JavascriptInterface
    public final void unBindDevice(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.clInterface.unBindDevice(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void unbindNPCICL(@NotNull String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.clInterface.unbindNPCICL(callback);
    }

    @JavascriptInterface
    public final void sendSMS(@Nullable String str, @Nullable String[] strArr, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        String[] strArr2;
        if (strArr == null || (strArr2 = (String[]) ArraysKt.t(strArr).toArray(new String[0])) == null) {
            strArr2 = new String[0];
        }
        String[] strArr3 = strArr2;
        UPIUtils uPIUtils = this.upiInterface;
        if (str == null) {
            str = "0";
        }
        String str5 = str;
        if (str3 == null) {
            str3 = "1";
        }
        uPIUtils.sendSms(str5, strArr3, str2, str3, str4, new C01061(this.resetCallbackQueue));
    }
}
