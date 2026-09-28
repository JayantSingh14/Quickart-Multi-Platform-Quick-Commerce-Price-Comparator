package com.zeptoconsumerapp.otpVerify.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class OtpListenerType {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OtpListenerType[] f47710a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47711b;

    static {
        OtpListenerType[] otpListenerTypeArr = {new OtpListenerType("WhatsApp", 0), new OtpListenerType("Sms", 1)};
        f47710a = otpListenerTypeArr;
        f47711b = EnumEntriesKt.a(otpListenerTypeArr);
    }

    public static OtpListenerType valueOf(String str) {
        return (OtpListenerType) Enum.valueOf(OtpListenerType.class, str);
    }

    public static OtpListenerType[] values() {
        return (OtpListenerType[]) f47710a.clone();
    }
}
