package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
/* loaded from: classes.dex */
public final class UShort implements Comparable<UShort> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53567b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final short f53568a;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.e(this.f53568a & 65535, uShort.f53568a & 65535);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UShort) {
            return this.f53568a == ((UShort) obj).f53568a;
        }
        return false;
    }

    public final int hashCode() {
        return Short.hashCode(this.f53568a);
    }

    public final String toString() {
        return String.valueOf(65535 & this.f53568a);
    }
}
