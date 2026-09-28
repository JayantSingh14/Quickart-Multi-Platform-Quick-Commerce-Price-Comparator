package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
/* loaded from: classes.dex */
public final class UInt implements Comparable<UInt> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53556b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f53557a;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public static String a(int i2) {
        return String.valueOf(i2 & 4294967295L);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.a(this.f53557a, uInt.f53557a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UInt) {
            return this.f53557a == ((UInt) obj).f53557a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f53557a);
    }

    public final String toString() {
        return a(this.f53557a);
    }
}
