package com.zeptoconsumerapp.otpVerify.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.zeptoconsumerapp.otpVerify.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class SmsOtpBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final a f47721a;

    /* renamed from: b, reason: collision with root package name */
    public final a f47722b;

    public SmsOtpBroadcastReceiver(a onSuccess, a onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.f47721a = onSuccess;
        this.f47722b = onError;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        Status status;
        if (!"com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent != null ? intent.getAction() : null) || (extras = intent.getExtras()) == null || (status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")) == null) {
            return;
        }
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            if (statusCode != 15) {
                return;
            }
            this.f47722b.invoke("Timeout");
        } else {
            String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
            if (str != null) {
                this.f47721a.invoke(str);
            }
        }
    }
}
