package androidx.media3.datasource.cache;

import android.support.v4.media.b;
import androidx.media3.common.util.UnstableApi;
import java.io.File;

@UnstableApi
/* loaded from: classes3.dex */
public class CacheSpan implements Comparable<CacheSpan> {

    /* renamed from: a, reason: collision with root package name */
    public final String f5983a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5984b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5985c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5986d;

    /* renamed from: e, reason: collision with root package name */
    public final File f5987e;

    /* renamed from: f, reason: collision with root package name */
    public final long f5988f;

    public CacheSpan(String str, long j2, long j3, long j4, File file) {
        this.f5983a = str;
        this.f5984b = j2;
        this.f5985c = j3;
        this.f5986d = file != null;
        this.f5987e = file;
        this.f5988f = j4;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(CacheSpan cacheSpan) {
        String str = cacheSpan.f5983a;
        String str2 = this.f5983a;
        if (!str2.equals(str)) {
            return str2.compareTo(cacheSpan.f5983a);
        }
        long j2 = this.f5984b - cacheSpan.f5984b;
        if (j2 == 0) {
            return 0;
        }
        return j2 < 0 ? -1 : 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.f5984b);
        sb.append(", ");
        return b.p(sb, this.f5985c, "]");
    }
}
