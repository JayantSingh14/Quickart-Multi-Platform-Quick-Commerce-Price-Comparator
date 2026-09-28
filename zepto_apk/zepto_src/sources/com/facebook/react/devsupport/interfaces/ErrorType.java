package com.facebook.react.devsupport.interfaces;

import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ErrorType {

    /* renamed from: b, reason: collision with root package name */
    public static final ErrorType f18939b;

    /* renamed from: c, reason: collision with root package name */
    public static final ErrorType f18940c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ ErrorType[] f18941d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f18942e;

    /* renamed from: a, reason: collision with root package name */
    public final String f18943a;

    static {
        ErrorType errorType = new ErrorType(PaymentConstants.Category.JS, 0, PaymentConstants.Category.JS);
        f18939b = errorType;
        ErrorType errorType2 = new ErrorType("NATIVE", 1, "Native");
        f18940c = errorType2;
        ErrorType[] errorTypeArr = {errorType, errorType2};
        f18941d = errorTypeArr;
        f18942e = EnumEntriesKt.a(errorTypeArr);
    }

    public ErrorType(String str, int i2, String str2) {
        this.f18943a = str2;
    }

    public static ErrorType valueOf(String str) {
        return (ErrorType) Enum.valueOf(ErrorType.class, str);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) f18941d.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f18943a;
    }
}
