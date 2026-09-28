package com.whatsapp.otp.android.sdk.enums;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class WhatsAppOtpError {

    /* renamed from: a, reason: collision with root package name */
    public static final WhatsAppOtpError f47308a;

    /* renamed from: b, reason: collision with root package name */
    public static final WhatsAppOtpError f47309b;

    /* renamed from: c, reason: collision with root package name */
    public static final WhatsAppOtpError f47310c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ WhatsAppOtpError[] f47311d;

    static {
        WhatsAppOtpError whatsAppOtpError = new WhatsAppOtpError("INTENT_IS_NOT_FROM_WHATSAPP", 0);
        f47308a = whatsAppOtpError;
        WhatsAppOtpError whatsAppOtpError2 = new WhatsAppOtpError("OTP_CODE_NOT_RECEIVED", 1);
        f47309b = whatsAppOtpError2;
        WhatsAppOtpError whatsAppOtpError3 = new WhatsAppOtpError("GENERIC_EXCEPTION", 2);
        f47310c = whatsAppOtpError3;
        f47311d = new WhatsAppOtpError[]{whatsAppOtpError, whatsAppOtpError2, whatsAppOtpError3};
    }

    public static WhatsAppOtpError valueOf(String str) {
        return (WhatsAppOtpError) Enum.valueOf(WhatsAppOtpError.class, str);
    }

    public static WhatsAppOtpError[] values() {
        return (WhatsAppOtpError[]) f47311d.clone();
    }
}
