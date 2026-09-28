package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import in.juspay.hypersdk.core.PaymentConstants;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@KeepName
/* loaded from: classes4.dex */
public class SignInHubActivity extends FragmentActivity {
    public static boolean n = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f22198i = false;

    /* renamed from: j, reason: collision with root package name */
    public SignInConfiguration f22199j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22200k;

    /* renamed from: l, reason: collision with root package name */
    public int f22201l;

    /* renamed from: m, reason: collision with root package name */
    public Intent f22202m;

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final void f(int i2) {
        Status status = new Status(i2);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        n = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        GoogleSignInAccount googleSignInAccount;
        if (this.f22198i) {
            return;
        }
        setResult(0);
        if (i2 != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && (googleSignInAccount = signInAccount.f22190b) != null) {
                zbn zbnVarA = zbn.a(this);
                GoogleSignInOptions googleSignInOptions = this.f22199j.f22197b;
                synchronized (zbnVarA) {
                    zbnVarA.f22218a.c(googleSignInAccount, googleSignInOptions);
                }
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccount);
                this.f22200k = true;
                this.f22201l = i3;
                this.f22202m = intent;
                getSupportLoaderManager().c(new zbv(this));
                n = false;
                return;
            }
            if (intent.hasExtra(CLConstants.FIELD_ERROR_CODE)) {
                int intExtra = intent.getIntExtra(CLConstants.FIELD_ERROR_CODE, 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                f(intExtra);
                return;
            }
        }
        f(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null) {
            Log.e("AuthSignInClient", "Null action");
            f(12500);
            return;
        }
        if (action.equals("com.google.android.gms.auth.NO_IMPL")) {
            Log.e("AuthSignInClient", "Action not implemented");
            f(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra(PaymentConstants.Category.CONFIG);
        if (bundleExtra == null) {
            Log.e("AuthSignInClient", "Activity started with no configuration.");
            setResult(0);
            finish();
            return;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable(PaymentConstants.Category.CONFIG);
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.f22199j = signInConfiguration;
        if (bundle != null) {
            boolean z = bundle.getBoolean("signingInGoogleApiClients");
            this.f22200k = z;
            if (z) {
                this.f22201l = bundle.getInt("signInResultCode");
                Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                if (intent2 == null) {
                    Log.e("AuthSignInClient", "Sign in result data cannot be null");
                    setResult(0);
                    finish();
                    return;
                } else {
                    this.f22202m = intent2;
                    getSupportLoaderManager().c(new zbv(this));
                    n = false;
                    return;
                }
            }
            return;
        }
        if (n) {
            setResult(0);
            f(12502);
            return;
        }
        n = true;
        Intent intent3 = new Intent(action);
        if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent3.setPackage("com.google.android.gms");
        } else {
            intent3.setPackage(getPackageName());
        }
        intent3.putExtra(PaymentConstants.Category.CONFIG, this.f22199j);
        try {
            startActivityForResult(intent3, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f22198i = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            f(17);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        n = false;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f22200k);
        if (this.f22200k) {
            bundle.putInt("signInResultCode", this.f22201l);
            bundle.putParcelable("signInResultData", this.f22202m);
        }
    }
}
