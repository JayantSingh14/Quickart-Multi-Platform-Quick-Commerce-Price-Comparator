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
public final class UByte implements Comparable<UByte> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53551b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte f53552a;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.e(this.f53552a & 255, uByte.f53552a & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UByte) {
            return this.f53552a == ((UByte) obj).f53552a;
        }
        return false;
    }

    public final int hashCode() {
        return Byte.hashCode(this.f53552a);
    }

    public final String toString() {
        return String.valueOf(this.f53552a & 255);
    }
}
