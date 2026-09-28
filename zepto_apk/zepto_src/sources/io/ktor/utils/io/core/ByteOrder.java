package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ByteOrder {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteOrder f51187a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ByteOrder[] f51188b;

    @Metadata
    public static final class Companion {
    }

    static {
        java.nio.ByteOrder BIG_ENDIAN = java.nio.ByteOrder.BIG_ENDIAN;
        Intrinsics.checkNotNullExpressionValue(BIG_ENDIAN, "BIG_ENDIAN");
        ByteOrder byteOrder = new ByteOrder("BIG_ENDIAN", 0);
        f51187a = byteOrder;
        java.nio.ByteOrder LITTLE_ENDIAN = java.nio.ByteOrder.LITTLE_ENDIAN;
        Intrinsics.checkNotNullExpressionValue(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        f51188b = new ByteOrder[]{byteOrder, new ByteOrder("LITTLE_ENDIAN", 1)};
        Intrinsics.checkNotNullExpressionValue(java.nio.ByteOrder.nativeOrder(), "nativeOrder()");
    }

    public static ByteOrder valueOf(String str) {
        return (ByteOrder) Enum.valueOf(ByteOrder.class, str);
    }

    public static ByteOrder[] values() {
        return (ByteOrder[]) f51188b.clone();
    }
}
