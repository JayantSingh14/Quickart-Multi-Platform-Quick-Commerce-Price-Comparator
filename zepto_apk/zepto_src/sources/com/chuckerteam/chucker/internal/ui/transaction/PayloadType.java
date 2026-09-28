package com.chuckerteam.chucker.internal.ui.transaction;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class PayloadType {

    /* renamed from: a, reason: collision with root package name */
    public static final PayloadType f16899a;

    /* renamed from: b, reason: collision with root package name */
    public static final PayloadType f16900b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ PayloadType[] f16901c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f16902d;

    static {
        PayloadType payloadType = new PayloadType("REQUEST", 0);
        f16899a = payloadType;
        PayloadType payloadType2 = new PayloadType("RESPONSE", 1);
        f16900b = payloadType2;
        PayloadType[] payloadTypeArr = {payloadType, payloadType2};
        f16901c = payloadTypeArr;
        f16902d = EnumEntriesKt.a(payloadTypeArr);
    }

    public static PayloadType valueOf(String str) {
        return (PayloadType) Enum.valueOf(PayloadType.class, str);
    }

    public static PayloadType[] values() {
        return (PayloadType[]) f16901c.clone();
    }
}
