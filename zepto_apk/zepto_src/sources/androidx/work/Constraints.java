package androidx.work;

import android.net.Uri;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class Constraints {

    /* renamed from: i, reason: collision with root package name */
    public static final Constraints f12486i;

    /* renamed from: a, reason: collision with root package name */
    public final NetworkType f12487a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12488b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12489c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f12490d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12491e;

    /* renamed from: f, reason: collision with root package name */
    public final long f12492f;

    /* renamed from: g, reason: collision with root package name */
    public final long f12493g;

    /* renamed from: h, reason: collision with root package name */
    public final Set f12494h;

    @Metadata
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public NetworkType f12495a = NetworkType.f12536a;

        /* renamed from: b, reason: collision with root package name */
        public final LinkedHashSet f12496b = new LinkedHashSet();

        public final Constraints a() {
            return new Constraints(this.f12495a, false, false, false, false, -1L, -1L, CollectionsKt.h0(this.f12496b));
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class ContentUriTrigger {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f12497a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f12498b;

        public ContentUriTrigger(boolean z, Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.f12497a = uri;
            this.f12498b = z;
        }

        public final Uri a() {
            return this.f12497a;
        }

        public final boolean b() {
            return this.f12498b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!ContentUriTrigger.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.d(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) obj;
            return Intrinsics.b(this.f12497a, contentUriTrigger.f12497a) && this.f12498b == contentUriTrigger.f12498b;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.f12498b) + (this.f12497a.hashCode() * 31);
        }
    }

    static {
        NetworkType requiredNetworkType = NetworkType.f12536a;
        Intrinsics.checkNotNullParameter(requiredNetworkType, "requiredNetworkType");
        Intrinsics.checkNotNullParameter(requiredNetworkType, "requiredNetworkType");
        f12486i = new Constraints(requiredNetworkType, false, false, false, false, -1L, -1L, EmptySet.f53611a);
    }

    public Constraints(NetworkType requiredNetworkType, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, Set contentUriTriggers) {
        Intrinsics.checkNotNullParameter(requiredNetworkType, "requiredNetworkType");
        Intrinsics.checkNotNullParameter(contentUriTriggers, "contentUriTriggers");
        this.f12487a = requiredNetworkType;
        this.f12488b = z;
        this.f12489c = z2;
        this.f12490d = z3;
        this.f12491e = z4;
        this.f12492f = j2;
        this.f12493g = j3;
        this.f12494h = contentUriTriggers;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Constraints.class.equals(obj.getClass())) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.f12488b == constraints.f12488b && this.f12489c == constraints.f12489c && this.f12490d == constraints.f12490d && this.f12491e == constraints.f12491e && this.f12492f == constraints.f12492f && this.f12493g == constraints.f12493g && this.f12487a == constraints.f12487a) {
            return Intrinsics.b(this.f12494h, constraints.f12494h);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((((((this.f12487a.hashCode() * 31) + (this.f12488b ? 1 : 0)) * 31) + (this.f12489c ? 1 : 0)) * 31) + (this.f12490d ? 1 : 0)) * 31) + (this.f12491e ? 1 : 0)) * 31;
        long j2 = this.f12492f;
        int i2 = (iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.f12493g;
        return this.f12494h.hashCode() + ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31);
    }

    public final String toString() {
        return "Constraints{requiredNetworkType=" + this.f12487a + ", requiresCharging=" + this.f12488b + ", requiresDeviceIdle=" + this.f12489c + ", requiresBatteryNotLow=" + this.f12490d + ", requiresStorageNotLow=" + this.f12491e + ", contentTriggerUpdateDelayMillis=" + this.f12492f + ", contentTriggerMaxDelayMillis=" + this.f12493g + ", contentUriTriggers=" + this.f12494h + ", }";
    }

    public Constraints(Constraints other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.f12488b = other.f12488b;
        this.f12489c = other.f12489c;
        this.f12487a = other.f12487a;
        this.f12490d = other.f12490d;
        this.f12491e = other.f12491e;
        this.f12494h = other.f12494h;
        this.f12492f = other.f12492f;
        this.f12493g = other.f12493g;
    }
}
