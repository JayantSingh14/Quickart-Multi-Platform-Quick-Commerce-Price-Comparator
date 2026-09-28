package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
/* loaded from: classes.dex */
public final class ULong implements Comparable<ULong> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53561b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f53562a;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.b(this.f53562a, uLong.f53562a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ULong) {
            return this.f53562a == ((ULong) obj).f53562a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f53562a);
    }

    public final String toString() {
        return UnsignedKt.c(this.f53562a);
    }
}
