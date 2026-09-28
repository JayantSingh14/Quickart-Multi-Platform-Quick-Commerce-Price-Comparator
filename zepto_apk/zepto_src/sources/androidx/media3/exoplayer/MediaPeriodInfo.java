package androidx.media3.exoplayer;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;

/* loaded from: classes3.dex */
final class MediaPeriodInfo {

    /* renamed from: a, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f6280a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6281b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6282c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6283d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6284e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f6285f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6286g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6287h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f6288i;

    public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = true;
        Assertions.a(!z4 || z2);
        Assertions.a(!z3 || z2);
        if (z && (z2 || z3 || z4)) {
            z5 = false;
        }
        Assertions.a(z5);
        this.f6280a = mediaPeriodId;
        this.f6281b = j2;
        this.f6282c = j3;
        this.f6283d = j4;
        this.f6284e = j5;
        this.f6285f = z;
        this.f6286g = z2;
        this.f6287h = z3;
        this.f6288i = z4;
    }

    public final MediaPeriodInfo a(long j2) {
        if (j2 == this.f6282c) {
            return this;
        }
        return new MediaPeriodInfo(this.f6280a, this.f6281b, j2, this.f6283d, this.f6284e, this.f6285f, this.f6286g, this.f6287h, this.f6288i);
    }

    public final MediaPeriodInfo b(long j2) {
        if (j2 == this.f6281b) {
            return this;
        }
        return new MediaPeriodInfo(this.f6280a, j2, this.f6282c, this.f6283d, this.f6284e, this.f6285f, this.f6286g, this.f6287h, this.f6288i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MediaPeriodInfo.class == obj.getClass()) {
            MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) obj;
            if (this.f6281b == mediaPeriodInfo.f6281b && this.f6282c == mediaPeriodInfo.f6282c && this.f6283d == mediaPeriodInfo.f6283d && this.f6284e == mediaPeriodInfo.f6284e && this.f6285f == mediaPeriodInfo.f6285f && this.f6286g == mediaPeriodInfo.f6286g && this.f6287h == mediaPeriodInfo.f6287h && this.f6288i == mediaPeriodInfo.f6288i && Util.a(this.f6280a, mediaPeriodInfo.f6280a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((this.f6280a.hashCode() + 527) * 31) + ((int) this.f6281b)) * 31) + ((int) this.f6282c)) * 31) + ((int) this.f6283d)) * 31) + ((int) this.f6284e)) * 31) + (this.f6285f ? 1 : 0)) * 31) + (this.f6286g ? 1 : 0)) * 31) + (this.f6287h ? 1 : 0)) * 31) + (this.f6288i ? 1 : 0);
    }
}
