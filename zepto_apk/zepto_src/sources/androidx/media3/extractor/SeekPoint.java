package androidx.media3.extractor;

import android.support.v4.media.b;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class SeekPoint {

    /* renamed from: c, reason: collision with root package name */
    public static final SeekPoint f8604c = new SeekPoint(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f8605a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8606b;

    public SeekPoint(long j2, long j3) {
        this.f8605a = j2;
        this.f8606b = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SeekPoint.class == obj.getClass()) {
            SeekPoint seekPoint = (SeekPoint) obj;
            if (this.f8605a == seekPoint.f8605a && this.f8606b == seekPoint.f8606b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f8605a) * 31) + ((int) this.f8606b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[timeUs=");
        sb.append(this.f8605a);
        sb.append(", position=");
        return b.p(sb, this.f8606b, "]");
    }
}
