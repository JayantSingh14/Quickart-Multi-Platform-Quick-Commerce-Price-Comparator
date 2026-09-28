package org.npci.upi.security.pinactivitycomponent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.lang.Thread;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Locale;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.Keypad;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes5.dex */
public class GetCredential extends AppCompatActivity {
    private static final String TAG = "GetCredential";
    private static GetCredential _instance;
    public static String callbackFromApp;
    private ImageView bankImage;
    private Bitmap bitmap;
    private org.npci.upi.security.pinactivitycomponent.a bitmapPicture;
    private e credBlockBuilder;
    private String credType;
    private Fragment fragment;
    private String imageUrl;
    private o lite;
    private int mActivityHeight;
    private ImageView mTransactionBarArrow;
    private View mTransactionDetailScroller;
    private View mTransactionDetailSpace;
    private TransitionDrawable mTransitionDrawable;
    private Boolean showFragment;
    private a smsReceiver;
    private Boolean urlChecker;
    private Boolean verifiedMerchant;
    private final Context context = this;
    private s currentFragment = null;
    private boolean doubleBackToExitPressedOnce = false;
    private int numDigitsOfOTP = 0;
    private Thread.UncaughtExceptionHandler defaultHandler = null;

    public class a extends BroadcastReceiver {
        private a() {
        }

        private void a(Intent intent) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Object[] objArr = (Object[]) extras.get("pdus");
                int length = objArr.length;
                SmsMessage[] smsMessageArr = new SmsMessage[length];
                for (int i2 = 0; i2 < length; i2++) {
                    SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i2]);
                    smsMessageArr[i2] = smsMessageCreateFromPdu;
                    String upperCase = smsMessageCreateFromPdu.getOriginatingAddress().toUpperCase();
                    String upperCase2 = smsMessageArr[i2].getMessageBody().toUpperCase();
                    new Date(smsMessageArr[i2].getTimestampMillis());
                    t tVarA = new u(GetCredential.this.context).a(GetCredential.this.numDigitsOfOTP, upperCase, upperCase2);
                    if (tVarA != null) {
                        GetCredential.this.currentFragment.b(tVarA);
                    }
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                    a(intent);
                }
            } catch (Exception e2) {
                q.a(GetCredential.TAG, e2);
            }
        }
    }

    public GetCredential() {
        Boolean bool = Boolean.FALSE;
        this.showFragment = bool;
        this.imageUrl = "";
        this.urlChecker = bool;
        this.bitmap = null;
        this.verifiedMerchant = bool;
        this.credType = null;
        _instance = this;
    }

    public static GetCredential _getInstance() {
        return _instance;
    }

    private static Bitmap decodeBase64(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        this.credBlockBuilder.g().c().send(0, androidx.fragment.app.e.i("error", CLConstants.OUTPUT_ERROR_MESSAGE));
        finish();
    }

    private Boolean hasDeviceLock() {
        KeyguardManager keyguardManager = (KeyguardManager) this.context.getSystemService("keyguard");
        if (!keyguardManager.isKeyguardSecure()) {
            startActivity(new Intent(this, (Class<?>) UserAuthInfoActivity.class));
        }
        return Boolean.valueOf(keyguardManager.isKeyguardSecure());
    }

    private void headLessFlow() throws JSONException {
        try {
            String string = this.credBlockBuilder.p().getJSONObject(0).getString(CLConstants.FIELD_SUBTYPE);
            JSONObject jSONObjectC = this.credBlockBuilder.c();
            if (!string.equals(CLConstants.CREDTYPE_IDENTITY)) {
                if (string.equals(CLConstants.CREDTYPE_SIGNATURE)) {
                    this.lite.e();
                    return;
                }
                return;
            }
            Boolean boolValueOf = Boolean.TRUE;
            if (jSONObjectC != null) {
                boolValueOf = Boolean.valueOf(Boolean.parseBoolean(jSONObjectC.optString(CLConstants.FIELD_ENABLE_USER_AUTH, "true")));
            }
            if (boolValueOf.booleanValue()) {
                hasDeviceLock();
            }
            o oVar = new o(this.context, this.credBlockBuilder.d(), this.credBlockBuilder.p(), jSONObjectC);
            this.lite = oVar;
            oVar.b(boolValueOf);
        } catch (Exception e2) {
            q.a(TAG, e2);
            ((GetCredential) this.context).showError(CLConstants.ERROR_TECHNICAL_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTransactionDetailsExpanded() {
        return this.mTransactionDetailScroller.getVisibility() == 0;
    }

    private int pix(float f2) {
        return (int) (f2 * (getResources().getDisplayMetrics().densityDpi / 160));
    }

    private void readUIArguments() {
        try {
            if (this.credBlockBuilder.c().has(CLConstants.INPUT_BANK_IMAGE_URL)) {
                this.imageUrl = this.credBlockBuilder.c().getString(CLConstants.INPUT_BANK_IMAGE_URL);
                this.urlChecker = Boolean.TRUE;
            }
            if (this.credBlockBuilder.c().has(CLConstants.INPUT_BANK_IMAGE)) {
                this.bitmap = decodeBase64(this.credBlockBuilder.c().getString(CLConstants.INPUT_BANK_IMAGE));
            }
            if (this.credBlockBuilder.c().has(CLConstants.INPUT_VERIFIED_MERCHANT)) {
                this.verifiedMerchant = Boolean.valueOf(this.credBlockBuilder.c().getBoolean(CLConstants.INPUT_VERIFIED_MERCHANT));
            }
            String[] strArrSplit = this.credBlockBuilder.b().split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
            Locale locale = new Locale(this.credBlockBuilder.b());
            if (strArrSplit.length == 2) {
                locale = new Locale(strArrSplit[0], strArrSplit[1]);
            }
            Locale.setDefault(locale);
            Configuration configuration = new Configuration();
            configuration.locale = locale;
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        } catch (Exception e2) {
            q.a(TAG, e2);
        }
    }

    private void registerSMSReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        try {
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(999);
            registerReceiver(this.smsReceiver, intentFilter);
        } catch (Throwable unused) {
            q.a(TAG, "Failed to register SMS broadcast receiver (Ignoring)");
        }
    }

    private Keypad setupKeyboard() {
        Keypad keypad = (Keypad) findViewById(R.id.fragmentTelKeyboard);
        if (keypad != null) {
            keypad.setOnKeyPressCallback(new Keypad.a() { // from class: org.npci.upi.security.pinactivitycomponent.GetCredential.3
                @Override // org.npci.upi.security.pinactivitycomponent.Keypad.a
                public void a(View view, int i2) {
                    GetCredential.this.dispatchKeyEvent(new KeyEvent(0, i2));
                    if (i2 == 66) {
                        if (GetCredential.this.currentFragment != null) {
                            GetCredential.this.currentFragment.a();
                        }
                    } else if (i2 == 67) {
                        GetCredential.this.currentFragment.b();
                    }
                }
            });
        }
        return keypad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleTransactionDetails(final boolean z) {
        ImageView imageView = this.mTransactionBarArrow;
        if (z) {
            rotateView(0.0f, 180.0f, 300, imageView);
        } else {
            rotateView(180.0f, 0.0f, 300, imageView);
        }
        final int height = this.mTransactionDetailScroller.getHeight();
        if (height == 0) {
            height = this.mActivityHeight;
        }
        this.mTransactionDetailScroller.clearAnimation();
        this.mTransactionDetailScroller.animate().y(z ? 0.0f : height * (-1.0f)).alpha(z ? 1.0f : 0.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: org.npci.upi.security.pinactivitycomponent.GetCredential.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z) {
                    return;
                }
                GetCredential.this.mTransactionDetailScroller.setVisibility(8);
                GetCredential.this.mTransactionDetailSpace.setVisibility(8);
                GetCredential.this.mTransitionDrawable.resetTransition();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            @TargetApi(17)
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (!z) {
                    GetCredential.this.mTransitionDrawable.reverseTransition(300);
                    return;
                }
                GetCredential.this.mTransitionDrawable.startTransition(300);
                GetCredential.this.mTransactionDetailScroller.setVisibility(0);
                GetCredential.this.mTransactionDetailSpace.setVisibility(0);
                GetCredential.this.mTransactionDetailSpace.setLayoutDirection(0);
                View view = GetCredential.this.mTransactionDetailScroller;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if (view.getY() == 0.0f) {
                    GetCredential.this.mTransactionDetailScroller.setY(height * (-1));
                }
            }
        });
    }

    private void unregisterSMSReceiver() {
        try {
            a aVar = this.smsReceiver;
            if (aVar != null) {
                unregisterReceiver(aVar);
                this.smsReceiver = null;
            }
        } catch (Throwable unused) {
            q.a(TAG, "Failed to unregister SMS receiver (Ignoring)");
        }
    }

    private Boolean validateLiteRequest() {
        GetCredential getCredential;
        String str;
        Boolean bool = Boolean.FALSE;
        try {
            this.lite = new o(this.context, this.credBlockBuilder.d(), this.credBlockBuilder.p(), this.credBlockBuilder.c());
            return this.credBlockBuilder.f().booleanValue() ? Boolean.valueOf(this.lite.a(CLConstants.FIELD_LOAD_MONEY_FLOW)) : Boolean.valueOf(this.lite.a(CLConstants.FIELD_LITE_PAY_FLOW));
        } catch (Exception e2) {
            q.a(TAG, e2);
            if (e2 instanceof IllegalStateException) {
                getCredential = (GetCredential) this.context;
                str = CLConstants.ERROR_SYNC_REQUIRED;
            } else if (e2 instanceof IllegalArgumentException) {
                getCredential = (GetCredential) this.context;
                str = CLConstants.ERROR_INVALID_REQUEST;
            } else if (e2 instanceof CertificateException) {
                getCredential = (GetCredential) this.context;
                str = CLConstants.ERROR_LITE_KEYS_ROTATION_NEEDED;
            } else {
                getCredential = (GetCredential) this.context;
                str = CLConstants.ERROR_TECHNICAL_ERROR;
            }
            getCredential.showError(str);
            return bool;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(p.a(context, new n(context).b(CLConstants.SHARED_PREFERENCE_ITEM_LANG_PREF, CLConstants.DEFAULT_LANGUAGE_PREFERENCE)));
    }

    public boolean checkSMSReadPermission() {
        return checkCallingOrSelfPermission("android.permission.READ_SMS") == 0;
    }

    public boolean checkSMSReceivePermission() {
        return checkCallingOrSelfPermission("android.permission.RECEIVE_SMS") == 0;
    }

    public e getCredBlockBuilder() {
        return this.credBlockBuilder;
    }

    public o getLiteInstace() {
        return this.lite;
    }

    public void loadFragment(s sVar, Bundle bundle, boolean z) {
        try {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (bundle != null) {
                sVar.setArguments(bundle);
            }
            FragmentTransaction fragmentTransactionD = supportFragmentManager.d();
            fragmentTransactionD.j(sVar, R.id.main_inner_layout);
            if (z) {
                String simpleName = sVar.getClass().getSimpleName();
                if (!fragmentTransactionD.f4650j) {
                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                }
                fragmentTransactionD.f4649i = true;
                fragmentTransactionD.f4651k = simpleName;
            }
            fragmentTransactionD.d();
            setCurrentFragment(sVar);
        } catch (Exception unused) {
            q.a("CommonLibrary", "Exception while loading Fragment");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            try {
                if (i2 == CLConstants.FIELD_LOAD_MONEY_FLOW.intValue()) {
                    this.lite.d();
                } else if (i2 == CLConstants.FIELD_LITE_PAY_FLOW.intValue()) {
                    this.lite.e();
                }
            } catch (Exception e2) {
                q.a(TAG, e2);
                ((GetCredential) this.context).showError(CLConstants.ERROR_TECHNICAL_ERROR);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, getString(R.string.back_button_exit_message), 0).show();
            new Handler().postDelayed(new Runnable() { // from class: org.npci.upi.security.pinactivitycomponent.GetCredential.2
                @Override // java.lang.Runnable
                public void run() {
                    GetCredential.this.doubleBackToExitPressedOnce = false;
                }
            }, 2000L);
        } else {
            this.credBlockBuilder.g().c().send(0, androidx.fragment.app.e.i("error", CLConstants.OUTPUT_ERROR_MESSAGE));
            Fragment fragment = this.fragment;
            if (fragment != null) {
                ((w) fragment).f();
            }
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws JSONException {
        int i2;
        int i3;
        getWindow().setFlags(KEYRecord.Flags.FLAG2, KEYRecord.Flags.FLAG2);
        super.onCreate(bundle);
        this.defaultHandler = Thread.currentThread().getUncaughtExceptionHandler();
        Thread.currentThread().setUncaughtExceptionHandler(new j());
        e eVar = new e(getIntent().getExtras());
        this.credBlockBuilder = eVar;
        try {
            eVar.a(this);
            readUIArguments();
            if (!this.credBlockBuilder.p().toString().contains(CLConstants.CREDTYPE_SIGNATURE) || validateLiteRequest().booleanValue()) {
                if (this.credBlockBuilder.s()) {
                    headLessFlow();
                    return;
                }
                setContentView(R.layout.activity_pin_activity_component);
                if (this.urlChecker.booleanValue()) {
                    org.npci.upi.security.pinactivitycomponent.a aVar = new org.npci.upi.security.pinactivitycomponent.a(this, this.imageUrl);
                    this.bitmapPicture = aVar;
                    aVar.execute(new String[0]);
                }
                ImageView imageView = (ImageView) findViewById(R.id.bank_image);
                this.bankImage = imageView;
                Bitmap bitmap = this.bitmap;
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                }
                renderTransactionBar();
                renderTransactionDetails();
                Keypad keypad = setupKeyboard();
                ((LinearLayout) findViewById(R.id.toolBar)).setPadding(0, 10, 0, 0);
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.main_inner_layout);
                DisplayMetrics displayMetrics = getDisplayMetrics();
                if (displayMetrics.densityDpi > 320 || (i3 = displayMetrics.heightPixels) > 1184) {
                    i2 = 50;
                } else {
                    if (i3 <= 800) {
                        ViewGroup.LayoutParams layoutParams = keypad.getLayoutParams();
                        layoutParams.height = 280;
                        keypad.setLayoutParams(layoutParams);
                    }
                    i2 = 0;
                }
                frameLayout.setPadding(0, i2, 0, 0);
                w wVar = new w();
                this.fragment = wVar;
                loadFragment(wVar, getIntent().getExtras(), false);
                TextView textView = (TextView) findViewById(R.id.go_back);
                if (textView != null) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.GetCredential.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            GetCredential.this.goBack();
                        }
                    });
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (_instance != null) {
            _instance = null;
        }
        Thread.currentThread().setUncaughtExceptionHandler(this.defaultHandler);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        unregisterSMSReceiver();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!checkSMSReceivePermission()) {
            q.a(TAG, "RECEIVE_SMS permission not provided by the App. This will affect Auto OTP detection feature of Common Library");
        } else {
            this.smsReceiver = new a();
            registerSMSReceiver();
        }
    }

    public void renderTransactionBar() {
        String strOptString;
        String str;
        String str2;
        JSONObject jSONObject;
        String strOptString2;
        String strOptString3 = this.credBlockBuilder.c() != null ? this.credBlockBuilder.c().optString("payerBankName") : "";
        JSONObject jSONObjectD = this.credBlockBuilder.d();
        JSONArray jSONArrayE = this.credBlockBuilder.e();
        if (jSONObjectD == null) {
            new c(this, "l12", CLConstants.ERROR_MSG_SALT_MISSING);
            return;
        }
        String strOptString4 = jSONObjectD.optString("txnAmount");
        try {
            this.credBlockBuilder.a(jSONObjectD.getJSONArray(CLConstants.OUTPUT_CRED_TYPE));
            for (int i2 = 0; i2 < this.credBlockBuilder.n().length(); i2++) {
                if (this.credBlockBuilder.n().getString(i2).equals(CLConstants.CRED_TYPE_MANDATE)) {
                    this.credType = this.credBlockBuilder.n().getString(i2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String strOptString5 = "";
        for (int i3 = 0; i3 < jSONArrayE.length(); i3++) {
            try {
            } catch (Exception e3) {
                q.a(TAG, e3);
            }
            if (((JSONObject) jSONArrayE.get(i3)).optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_ACCOUNT)) {
                String strOptString6 = ((JSONObject) jSONArrayE.get(i3)).optString(CLConstants.FIELD_PAY_INFO_VALUE, "");
                strOptString5 = CLConstants.MASK_CHARACTER + strOptString6.substring(strOptString6.length() - 4, strOptString6.length());
            } else if (((JSONObject) jSONArrayE.get(i3)).optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals("payeeVpa")) {
                strOptString5 = ((JSONObject) jSONArrayE.get(i3)).optString(CLConstants.FIELD_PAY_INFO_VALUE, "");
            } else {
                continue;
            }
        }
        for (int i4 = 0; i4 < jSONArrayE.length(); i4++) {
            try {
            } catch (Exception e4) {
                q.a(TAG, e4);
            }
            if (((JSONObject) jSONArrayE.get(i4)).optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_PAYEE_NAME)) {
                jSONObject = (JSONObject) jSONArrayE.get(i4);
            } else if (((JSONObject) jSONArrayE.get(i4)).optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_ACCOUNT)) {
                jSONObject = (JSONObject) jSONArrayE.get(i4);
            } else {
                if (((JSONObject) jSONArrayE.get(i4)).optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals("mobileNumber")) {
                    strOptString2 = ((JSONObject) jSONArrayE.get(i4)).optString("mobileNumber", "");
                    strOptString = strOptString2;
                    break;
                }
            }
            strOptString2 = jSONObject.optString(CLConstants.FIELD_PAY_INFO_VALUE, "");
            strOptString = strOptString2;
        }
        strOptString = "";
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.transaction_bar_root);
        TextView textView = (TextView) findViewById(R.id.tv_acc_or_payee);
        TextView textView2 = (TextView) findViewById(R.id.tv_acc_or_payee_name);
        TextView textView3 = (TextView) findViewById(R.id.transaction_payee_label);
        TextView textView4 = (TextView) findViewById(R.id.transaction_payee_value);
        TextView textView5 = (TextView) findViewById(R.id.transaction_amount_title);
        TextView textView6 = (TextView) findViewById(R.id.transaction_amount_value);
        String str3 = CLConstants.FIELD_PAY_INFO_VALUE;
        this.mTransactionBarArrow = (ImageView) findViewById(R.id.transaction_bar_arrow);
        textView2.setText(strOptString5);
        if (!strOptString3.equals("")) {
            textView.setText(strOptString3);
        }
        if (strOptString4.equals("") || strOptString4.equalsIgnoreCase("null") || Double.parseDouble(strOptString4) <= 0.0d) {
            textView5.setText("");
            textView3.setText("");
            textView6.setText("");
            textView4.setText("");
            int i5 = 0;
            while (i5 < jSONArrayE.length()) {
                try {
                } catch (Exception e5) {
                    e = e5;
                    str = str3;
                }
                if (((JSONObject) jSONArrayE.get(i5)).optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_NOTE)) {
                    str = str3;
                    try {
                        strOptString = ((JSONObject) jSONArrayE.get(i5)).optString(str, "");
                        break;
                    } catch (Exception e6) {
                        e = e6;
                        q.a(TAG, e);
                        i5++;
                        str3 = str;
                    }
                } else {
                    str = str3;
                    i5++;
                    str3 = str;
                }
            }
            textView5.setText(strOptString);
            textView5.setEllipsize(TextUtils.TruncateAt.END);
            textView5.setSingleLine(true);
        } else {
            String strConcat = CLConstants.RUPEES_SYMBOL.concat(strOptString4);
            String str4 = this.credType;
            if (str4 == null || !str4.equals(CLConstants.CRED_TYPE_MANDATE)) {
                textView5.setText(CLConstants.SENDING_AMOUNT_TITLE);
                str2 = CLConstants.SENDING_TO_TITLE;
            } else {
                textView5.setText(CLConstants.SENDING_MANDATE_AMOUNT_TITLE);
                str2 = CLConstants.SENDING_MANDATE_TO_TITLE;
            }
            textView3.setText(str2);
            textView6.setText(strConcat);
            textView4.setText(strOptString);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.mActivityHeight = point.y;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.GetCredential.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GetCredential.this.toggleTransactionDetails(!r2.isTransactionDetailsExpanded());
            }
        });
        this.mTransactionDetailScroller = findViewById(R.id.transaction_details_scroller);
        this.mTransactionDetailSpace = findViewById(R.id.transaction_details_expanded_space);
        this.mTransactionDetailScroller.setOnTouchListener(new View.OnTouchListener() { // from class: org.npci.upi.security.pinactivitycomponent.GetCredential.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() != R.id.transaction_details_scroller || motionEvent.getAction() != 1 || !GetCredential.this.isTransactionDetailsExpanded()) {
                    return false;
                }
                GetCredential.this.toggleTransactionDetails(false);
                return true;
            }
        });
        View view = this.mTransactionDetailSpace;
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: org.npci.upi.security.pinactivitycomponent.GetCredential.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1 || !GetCredential.this.isTransactionDetailsExpanded()) {
                        return false;
                    }
                    GetCredential.this.toggleTransactionDetails(false);
                    return true;
                }
            });
        }
        TransitionDrawable transitionDrawable = (TransitionDrawable) findViewById(R.id.transaction_info_root).getBackground();
        this.mTransitionDrawable = transitionDrawable;
        transitionDrawable.setCrossFadeEnabled(true);
    }

    public void renderTransactionDetails() {
        String strOptString;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.transaction_details_root);
        JSONArray jSONArrayE = this.credBlockBuilder.e();
        for (int i2 = 0; i2 < jSONArrayE.length(); i2++) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.layout_transaction_details_item, (ViewGroup) linearLayout, false);
            TextView textView = (TextView) viewGroup.findViewById(R.id.transaction_details_item_name);
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.transaction_details_item_value);
            TextView textView3 = (TextView) viewGroup.findViewById(R.id.verified);
            LinearLayout linearLayout2 = (LinearLayout) viewGroup.findViewById(R.id.verified_merchant);
            JSONObject jSONObjectOptJSONObject = jSONArrayE.optJSONObject(i2);
            if (jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_PAYEE_NAME)) {
                String str = this.credType;
                textView.setText(((str == null || !str.equals(CLConstants.CRED_TYPE_MANDATE)) ? CLConstants.DROP_LIST_PAYING_TO_LABEL : CLConstants.DROP_LIST_PAYING_MANDATE_TO_LABEL).toUpperCase());
                textView2.setText(jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_VALUE));
                textView3.setText(CLConstants.DROP_LIST_VERIFIED);
                if (this.verifiedMerchant.booleanValue()) {
                    linearLayout2.setVisibility(0);
                }
            } else {
                if (jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals("txnAmount") || jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_TXN_AMOUNT_ALTR)) {
                    String str2 = this.credType;
                    textView.setText(((str2 == null || !str2.equals(CLConstants.CRED_TYPE_MANDATE)) ? CLConstants.DROP_LIST_AMOUNT_LABEL : CLConstants.DROP_LIST_AMOUNT_MANDATE_LABEL).toUpperCase());
                    strOptString = CLConstants.RUPEES_SYMBOL + jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_VALUE);
                } else {
                    textView.setText((jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_NOTE) ? CLConstants.DROP_LIST_DETAILS_LABEL : jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals("mobileNumber") ? CLConstants.DROP_LIST_MOBILE_LABEL : jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_REF_URL) ? CLConstants.DROP_LIST_REFURL_LABEL : jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_REF_ID) ? CLConstants.DROP_LIST_REFID_LABEL : jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME, "").equals(CLConstants.LABEL_MANDATE_TXN_SUBTYPE) ? CLConstants.DROP_LIST_MANDATE_SUBYPE_LABEL : jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_NAME)).toUpperCase());
                    strOptString = jSONObjectOptJSONObject.optString(CLConstants.FIELD_PAY_INFO_VALUE);
                }
                textView2.setText(strOptString);
            }
            linearLayout.addView(viewGroup);
        }
        View view = new View(this);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, pix(3.0f)));
        view.setBackgroundColor(-16777216);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        view.setAlpha(0.33f);
        linearLayout.addView(view);
    }

    public void rotateView(float f2, float f3, int i2, View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(f2, f3, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(i2);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }

    public void setCurrentFragment(s sVar) {
        this.currentFragment = sVar;
    }

    public void setNumDigitsOfOTP(int i2) {
        this.numDigitsOfOTP = i2;
    }

    public void showError(String str) {
        this.credBlockBuilder.g().c().send(0, androidx.fragment.app.e.i("error", str));
        finish();
    }

    public void triggredOTPResponse(String str) {
        ((w) this.fragment).a(str);
    }

    public void showError(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(CLConstants.FIELD_ERROR_CODE, str);
        bundle.putString("error", str2);
        this.credBlockBuilder.g().c().send(0, bundle);
        finish();
    }
}
