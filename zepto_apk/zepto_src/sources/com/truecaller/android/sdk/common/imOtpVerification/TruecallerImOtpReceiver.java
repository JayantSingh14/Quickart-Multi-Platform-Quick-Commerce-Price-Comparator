package com.truecaller.android.sdk.common.imOtpVerification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationDataBundle;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class TruecallerImOtpReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f47237a;

    public TruecallerImOtpReceiver(VerificationCallback verificationCallback) {
        Intrinsics.checkNotNullParameter(verificationCallback, "verificationCallback");
        this.f47237a = new WeakReference(verificationCallback);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        context.unregisterReceiver(this);
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString("tc-im-otp") : null;
        if (string != null) {
            VerificationDataBundle verificationDataBundle = new VerificationDataBundle();
            verificationDataBundle.a(string, CLConstants.OTP);
            VerificationCallback verificationCallback = (VerificationCallback) this.f47237a.get();
            if (verificationCallback != null) {
                verificationCallback.onRequestSuccess(10, verificationDataBundle);
            }
        }
    }
}
