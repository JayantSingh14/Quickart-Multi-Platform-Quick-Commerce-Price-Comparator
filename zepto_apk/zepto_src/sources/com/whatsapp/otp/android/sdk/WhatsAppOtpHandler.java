package com.whatsapp.otp.android.sdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.whatsapp.otp.android.sdk.enums.WhatsAppClientType;

/* loaded from: classes4.dex */
public class WhatsAppOtpHandler {

    /* renamed from: a, reason: collision with root package name */
    public final WhatsAppOtpIntentBuilder f47301a = new WhatsAppOtpIntentBuilder();

    public final void a(Context context, WhatsAppClientType whatsAppClientType) {
        Intent intent;
        WhatsAppOtpIntentBuilder whatsAppOtpIntentBuilder = this.f47301a;
        synchronized (whatsAppOtpIntentBuilder) {
            if (context == null) {
                throw new NullPointerException("Context cannot be null.");
            }
            String str = whatsAppClientType.f47307a;
            intent = new Intent();
            intent.setPackage(str);
            intent.setAction("com.whatsapp.otp.OTP_REQUESTED");
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 67108864 : 0);
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putParcelable("_ci_", activity);
            Package r6 = whatsAppOtpIntentBuilder.getClass().getPackage();
            String implementationVersion = r6 != null ? r6.getImplementationVersion() : null;
            if (implementationVersion == null) {
                implementationVersion = "0.1.0_not_from_manifest";
            }
            extras.putString("SDK_VERSION", implementationVersion);
            intent.putExtras(extras);
        }
        context.sendBroadcast(intent);
    }
}
