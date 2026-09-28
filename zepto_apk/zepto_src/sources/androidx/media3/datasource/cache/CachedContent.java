package androidx.media3.datasource.cache;

import androidx.fragment.app.e;
import androidx.media3.common.util.Assertions;
import java.util.ArrayList;
import java.util.TreeSet;

/* loaded from: classes3.dex */
final class CachedContent {

    /* renamed from: a, reason: collision with root package name */
    public final int f5993a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5994b;

    /* renamed from: c, reason: collision with root package name */
    public final TreeSet f5995c = new TreeSet();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f5996d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public DefaultContentMetadata f5997e;

    public static final class Range {

        /* renamed from: a, reason: collision with root package name */
        public final long f5998a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5999b;

        public Range(long j2, long j3) {
            this.f5998a = j2;
            this.f5999b = j3;
        }
    }

    public CachedContent(int i2, String str, DefaultContentMetadata defaultContentMetadata) {
        this.f5993a = i2;
        this.f5994b = str;
        this.f5997e = defaultContentMetadata;
    }

    public final long a(long j2, long j3) {
        Assertions.a(j2 >= 0);
        Assertions.a(j3 >= 0);
        SimpleCacheSpan simpleCacheSpanB = b(j2, j3);
        boolean z = simpleCacheSpanB.f5986d;
        long j4 = simpleCacheSpanB.f5985c;
        if (!z) {
            return -Math.min(j4 != -1 ? j4 : Long.MAX_VALUE, j3);
        }
        long j5 = j2 + j3;
        long j6 = j5 >= 0 ? j5 : Long.MAX_VALUE;
        long jMax = simpleCacheSpanB.f5984b + j4;
        if (jMax < j6) {
            for (SimpleCacheSpan simpleCacheSpan : this.f5995c.tailSet(simpleCacheSpanB, false)) {
                long j7 = simpleCacheSpan.f5984b;
                if (j7 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j7 + simpleCacheSpan.f5985c);
                if (jMax >= j6) {
                    break;
                }
            }
        }
        return Math.min(jMax - j2, j3);
    }

    public final SimpleCacheSpan b(long j2, long j3) {
        long jMin = j3;
        SimpleCacheSpan simpleCacheSpan = new SimpleCacheSpan(this.f5994b, j2, -1L, -9223372036854775807L, null);
        TreeSet treeSet = this.f5995c;
        SimpleCacheSpan simpleCacheSpan2 = (SimpleCacheSpan) treeSet.floor(simpleCacheSpan);
        if (simpleCacheSpan2 != null && simpleCacheSpan2.f5984b + simpleCacheSpan2.f5985c > j2) {
            return simpleCacheSpan2;
        }
        SimpleCacheSpan simpleCacheSpan3 = (SimpleCacheSpan) treeSet.ceiling(simpleCacheSpan);
        if (simpleCacheSpan3 != null) {
            long j4 = simpleCacheSpan3.f5984b - j2;
            jMin = jMin == -1 ? j4 : Math.min(j4, jMin);
        }
        return new SimpleCacheSpan(this.f5994b, j2, jMin, -9223372036854775807L, null);
    }

    public final boolean c(long j2, long j3) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f5996d;
            if (i2 >= arrayList.size()) {
                return false;
            }
            Range range = (Range) arrayList.get(i2);
            long j4 = range.f5999b;
            long j5 = range.f5998a;
            if (j4 == -1) {
                if (j2 >= j5) {
                    return true;
                }
            } else if (j3 != -1 && j5 <= j2 && j2 + j3 <= j5 + j4) {
                return true;
            }
            i2++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CachedContent.class == obj.getClass()) {
            CachedContent cachedContent = (CachedContent) obj;
            if (this.f5993a == cachedContent.f5993a && this.f5994b.equals(cachedContent.f5994b) && this.f5995c.equals(cachedContent.f5995c) && this.f5997e.equals(cachedContent.f5997e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5997e.hashCode() + e.e(this.f5993a * 31, 31, this.f5994b);
    }
}
