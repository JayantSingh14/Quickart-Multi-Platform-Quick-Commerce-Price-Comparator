package com.truecaller.android.sdk.common.callbacks;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.p001authapiphone.zzak;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationDataBundle;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import com.truecaller.android.sdk.common.otpVerification.SmsRetrieverClientHandler;
import com.truecaller.android.sdk.common.otpVerification.TruecallerOtpReceiver;
import java.lang.ref.WeakReference;
import java.util.Map;

@RestrictTo
/* loaded from: classes4.dex */
public class OtpInstallationCallback extends CreateInstallationCallback {

    /* renamed from: e, reason: collision with root package name */
    public final SmsRetrieverClientHandler f47228e;

    public OtpInstallationCallback(VerificationCallback verificationCallback, VerificationRequestManagerImpl verificationRequestManagerImpl, SmsRetrieverClientHandler smsRetrieverClientHandler) {
        super(verificationCallback, verificationRequestManagerImpl);
        this.f47228e = smsRetrieverClientHandler;
    }

    @Override // com.truecaller.android.sdk.common.callbacks.CreateInstallationCallback
    public void e(Map map) {
        Double dValueOf = (Double) map.get("tokenTtl");
        if (dValueOf == null) {
            dValueOf = Double.valueOf(300.0d);
        }
        VerificationDataBundle verificationDataBundle = new VerificationDataBundle();
        verificationDataBundle.a(dValueOf.toString(), "ttl");
        verificationDataBundle.a((String) map.get("requestNonce"), "requestNonce");
        VerificationCallback verificationCallback = this.f47213a;
        verificationCallback.onRequestSuccess(1, verificationDataBundle);
        WeakReference weakReference = this.f47228e.f47241a;
        if (weakReference.get() != null) {
            new zzak((Context) weakReference.get(), SmsRetrieverClient.f22138a, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS).b();
            ContextCompat.e((Context) weakReference.get(), new TruecallerOtpReceiver(verificationCallback), new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"), 2);
        }
    }
}
