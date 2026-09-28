package com.truecaller.android.sdk.common.otpVerification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationDataBundle;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class TruecallerOtpReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f47242a;

    public TruecallerOtpReceiver(VerificationCallback verificationCallback) {
        this.f47242a = new WeakReference(verificationCallback);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.unregisterReceiver(this);
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                Matcher matcher = Pattern.compile("\\b\\d{6,}\\b").matcher((String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE"));
                VerificationDataBundle verificationDataBundle = new VerificationDataBundle();
                if (matcher.find()) {
                    verificationDataBundle.a(matcher.group(), CLConstants.OTP);
                }
                WeakReference weakReference = this.f47242a;
                if (weakReference.get() != null) {
                    ((VerificationCallback) weakReference.get()).onRequestSuccess(2, verificationDataBundle);
                }
            }
        }
    }
}
