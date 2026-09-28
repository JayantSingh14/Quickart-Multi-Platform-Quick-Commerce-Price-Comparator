package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
/* loaded from: classes.dex */
public final class KotlinVersion implements Comparable<KotlinVersion> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53524b = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final KotlinVersion f53525c = new KotlinVersion();

    /* renamed from: a, reason: collision with root package name */
    public final int f53526a = 131328;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(KotlinVersion kotlinVersion) {
        KotlinVersion other = kotlinVersion;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f53526a - other.f53526a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        KotlinVersion kotlinVersion = obj instanceof KotlinVersion ? (KotlinVersion) obj : null;
        return kotlinVersion != null && this.f53526a == kotlinVersion.f53526a;
    }

    public final int hashCode() {
        return this.f53526a;
    }

    public final String toString() {
        return "2.1.0";
    }
}
