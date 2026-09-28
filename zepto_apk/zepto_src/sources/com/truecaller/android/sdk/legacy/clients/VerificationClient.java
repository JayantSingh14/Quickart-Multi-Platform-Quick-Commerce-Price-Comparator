package com.truecaller.android.sdk.legacy.clients;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.R;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationRequestManager;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import com.truecaller.android.sdk.common.callVerification.CallRejector;
import com.truecaller.android.sdk.common.callVerification.CallRejectorLegacyImpl;
import com.truecaller.android.sdk.common.callVerification.CallRejectorPieImpl;
import com.truecaller.android.sdk.common.callVerification.IncomingCallListener;
import com.truecaller.android.sdk.common.callbacks.MissedCallInstallationCallback;
import com.truecaller.android.sdk.common.network.ProfileService;
import com.truecaller.android.sdk.common.network.RestAdapter;
import com.truecaller.android.sdk.common.network.VerificationService;
import com.truecaller.android.sdk.common.otpVerification.SmsRetrieverClientHandler;
import com.truecaller.android.sdk.legacy.ITrueCallback;

@RestrictTo
/* loaded from: classes4.dex */
public final class VerificationClient extends TcClient implements VerificationRequestManager.Client {

    /* renamed from: h, reason: collision with root package name */
    public final VerificationRequestManagerImpl f47265h;

    /* renamed from: i, reason: collision with root package name */
    public final CallRejector f47266i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f47267j;

    /* renamed from: k, reason: collision with root package name */
    public IncomingCallListener f47268k;

    /* renamed from: l, reason: collision with root package name */
    public Handler f47269l;

    public VerificationClient(Context context, String str, ITrueCallback iTrueCallback, boolean z) {
        super(context, str, iTrueCallback, 2);
        this.f47267j = z;
        String string = context.getString(R.string.sdk_variant);
        String string2 = context.getString(R.string.sdk_variant_version);
        this.f47265h = new VerificationRequestManagerImpl(this, (ProfileService) RestAdapter.a("https://outline.truecaller.com/v1/", ProfileService.class, "2.9.0", string, string2), (VerificationService) RestAdapter.a("https://sdk-otp-verification-noneu.truecaller.com/v3/otp/installation/", VerificationService.class, "2.9.0", string, string2), iTrueCallback, new SmsRetrieverClientHandler(context));
        this.f47266i = Build.VERSION.SDK_INT >= 28 ? new CallRejectorPieImpl(context) : new CallRejectorLegacyImpl(context);
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final void a() {
        this.f47266i.a();
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final boolean b() {
        return Settings.Global.getInt(this.f47257a.getContentResolver(), "airplane_mode_on", 0) == 0;
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final void c(MissedCallInstallationCallback missedCallInstallationCallback) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f47257a.getSystemService("phone");
        IncomingCallListener incomingCallListener = new IncomingCallListener(missedCallInstallationCallback);
        this.f47268k = incomingCallListener;
        telephonyManager.listen(incomingCallListener, 32);
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final boolean d() {
        if (h("android.permission.READ_PHONE_STATE") && h("android.permission.READ_CALL_LOG")) {
            return Build.VERSION.SDK_INT < 26 ? h("android.permission.CALL_PHONE") : h("android.permission.ANSWER_PHONE_CALLS");
        }
        return false;
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final int e() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f47257a.getSystemService("phone");
        if (telephonyManager == null) {
            return 0;
        }
        return telephonyManager.getSimState();
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final void f(VerificationCallback verificationCallback, long j2) {
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final void g() {
        ((TelephonyManager) this.f47257a.getSystemService("phone")).listen(this.f47268k, 0);
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final Handler getHandler() {
        if (this.f47269l == null) {
            this.f47269l = new Handler();
        }
        return this.f47269l;
    }

    public final boolean h(String str) {
        return this.f47257a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
