package com.zeptoconsumerapp.otpVerify.utils;

import com.zeptoconsumerapp.otpVerify.constants.OtpListenerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class OtpDataPayload {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f47718a;

    /* renamed from: b, reason: collision with root package name */
    public final String f47719b;

    /* renamed from: c, reason: collision with root package name */
    public final OtpListenerType f47720c;

    public OtpDataPayload(boolean z, String message, OtpListenerType otpListenerType) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(otpListenerType, "otpListenerType");
        this.f47718a = z;
        this.f47719b = message;
        this.f47720c = otpListenerType;
    }
}
