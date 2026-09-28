package androidx.media3.exoplayer.dash.manifest;

import android.support.v4.media.b;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;

@UnstableApi
/* loaded from: classes3.dex */
public final class RangedUri {

    /* renamed from: a, reason: collision with root package name */
    public final long f6831a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6832b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6833c;

    /* renamed from: d, reason: collision with root package name */
    public int f6834d;

    public RangedUri(long j2, long j3, String str) {
        this.f6833c = str == null ? "" : str;
        this.f6831a = j2;
        this.f6832b = j3;
    }

    public final RangedUri a(RangedUri rangedUri, String str) {
        RangedUri rangedUri2;
        long j2;
        String strD = UriUtil.d(str, this.f6833c);
        if (rangedUri == null || !strD.equals(UriUtil.d(str, rangedUri.f6833c))) {
            return null;
        }
        long j3 = this.f6832b;
        long j4 = rangedUri.f6832b;
        if (j3 != -1) {
            j2 = j3;
            long j5 = this.f6831a;
            rangedUri2 = null;
            if (j5 + j2 == rangedUri.f6831a) {
                return new RangedUri(j5, j4 == -1 ? -1L : j2 + j4, strD);
            }
        } else {
            rangedUri2 = null;
            j2 = j3;
        }
        if (j4 == -1) {
            return rangedUri2;
        }
        long j6 = rangedUri.f6831a;
        if (j6 + j4 == this.f6831a) {
            return new RangedUri(j6, j2 == -1 ? -1L : j4 + j2, strD);
        }
        return rangedUri2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && RangedUri.class == obj.getClass()) {
            RangedUri rangedUri = (RangedUri) obj;
            if (this.f6831a == rangedUri.f6831a && this.f6832b == rangedUri.f6832b && this.f6833c.equals(rangedUri.f6833c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f6834d == 0) {
            this.f6834d = this.f6833c.hashCode() + ((((527 + ((int) this.f6831a)) * 31) + ((int) this.f6832b)) * 31);
        }
        return this.f6834d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RangedUri(referenceUri=");
        sb.append(this.f6833c);
        sb.append(", start=");
        sb.append(this.f6831a);
        sb.append(", length=");
        return b.p(sb, this.f6832b, ")");
    }
}
