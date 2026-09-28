package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class BoundType {

    /* renamed from: a, reason: collision with root package name */
    public static final BoundType f42528a;

    /* renamed from: b, reason: collision with root package name */
    public static final BoundType f42529b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ BoundType[] f42530c;

    static {
        BoundType boundType = new BoundType("OPEN", 0);
        f42528a = boundType;
        BoundType boundType2 = new BoundType("CLOSED", 1);
        f42529b = boundType2;
        f42530c = new BoundType[]{boundType, boundType2};
    }

    public static BoundType a(boolean z) {
        return z ? f42529b : f42528a;
    }

    public static BoundType valueOf(String str) {
        return (BoundType) Enum.valueOf(BoundType.class, str);
    }

    public static BoundType[] values() {
        return (BoundType[]) f42530c.clone();
    }
}
