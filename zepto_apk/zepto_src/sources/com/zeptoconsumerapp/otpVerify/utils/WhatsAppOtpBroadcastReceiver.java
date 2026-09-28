package com.zeptoconsumerapp.otpVerify.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.whatsapp.otp.android.sdk.WhatsAppOtpIncomingIntentHandler;
import com.whatsapp.otp.android.sdk.enums.WhatsAppOtpError;
import com.whatsapp.otp.android.sdk.exceptions.InvalidWhatsAppOtpIntentException;
import com.zeptoconsumerapp.otpVerify.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class WhatsAppOtpBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static a f47723a;

    /* renamed from: b, reason: collision with root package name */
    public static a f47724b;

    @Metadata
    public static final class Companion {
    }

    public static void a(WhatsAppOtpError whatsAppOtpError, Exception exc) {
        String string;
        String message;
        StringBuilder sb = new StringBuilder();
        if (exc != null && (message = exc.getMessage()) != null) {
            if (message.length() <= 0) {
                message = null;
            }
            if (message != null) {
                sb.append(message);
            }
        }
        if (whatsAppOtpError != null && (string = whatsAppOtpError.toString()) != null) {
            String str = string.length() > 0 ? string : null;
            if (str != null) {
                sb.append(str);
            }
        }
        String string2 = sb.toString();
        a aVar = f47724b;
        if (aVar != null) {
            aVar.invoke(string2);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        new WhatsAppOtpIncomingIntentHandler();
        try {
            String strA = WhatsAppOtpIncomingIntentHandler.a(intent);
            if (strA == null) {
                a(WhatsAppOtpError.f47309b, null);
                return;
            }
            a aVar = f47723a;
            if (aVar != null) {
                aVar.invoke(strA);
            }
        } catch (InvalidWhatsAppOtpIntentException e2) {
            a(WhatsAppOtpError.f47308a, e2);
        } catch (Exception e3) {
            a(WhatsAppOtpError.f47310c, e3);
        }
    }
}
