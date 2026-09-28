package coil3.util;

import coil3.annotation.ExperimentalCoilApi;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata
@JvmInline
@ExperimentalCoilApi
/* loaded from: classes.dex */
public final class IntPair {
    private final long value;

    private /* synthetic */ IntPair(long j2) {
        this.value = j2;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntPair m46boximpl(long j2) {
        return new IntPair(j2);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m48constructorimpl(long j2) {
        return j2;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m49equalsimpl(long j2, Object obj) {
        return (obj instanceof IntPair) && j2 == ((IntPair) obj).m55unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m50equalsimpl0(long j2, long j3) {
        return j2 == j3;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final int m51getFirstimpl(long j2) {
        return (int) (j2 >> 32);
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final int m52getSecondimpl(long j2) {
        return (int) (j2 & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m53hashCodeimpl(long j2) {
        return Long.hashCode(j2);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m54toStringimpl(long j2) {
        return "IntPair(value=" + j2 + ')';
    }

    public boolean equals(Object obj) {
        return m49equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m53hashCodeimpl(this.value);
    }

    public String toString() {
        return m54toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m55unboximpl() {
        return this.value;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m47constructorimpl(int i2, int i3) {
        return m48constructorimpl((i3 & 4294967295L) | (i2 << 32));
    }
}
