package com.whatsapp.otp.android.sdk;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.material.color.utilities.d;
import com.whatsapp.otp.android.sdk.enums.WhatsAppClientType;
import com.whatsapp.otp.android.sdk.exceptions.InvalidWhatsAppOtpIntentException;
import java.util.Arrays;
import java.util.function.Predicate;

/* loaded from: classes4.dex */
public class WhatsAppOtpIncomingIntentHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final WhatsAppClientType[] f47302a = {WhatsAppClientType.CONSUMER, WhatsAppClientType.BUSINESS};

    public static String a(Intent intent) {
        boolean zAnyMatch;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("_ci_");
        if (pendingIntent == null) {
            zAnyMatch = false;
        } else {
            WhatsAppClientType[] whatsAppClientTypeArr = f47302a;
            final String creatorPackage = pendingIntent.getCreatorPackage();
            zAnyMatch = Arrays.stream(whatsAppClientTypeArr).map(new d(29)).anyMatch(new Predicate() { // from class: com.whatsapp.otp.android.sdk.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((String) obj).equals(creatorPackage);
                }
            });
        }
        if (zAnyMatch) {
            return intent.getStringExtra("code");
        }
        throw new InvalidWhatsAppOtpIntentException("Invalid Intent");
    }
}
