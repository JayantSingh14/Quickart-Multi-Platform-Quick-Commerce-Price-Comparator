package androidx.media3.exoplayer;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultLivePlaybackSpeedControl implements LivePlaybackSpeedControl {

    /* renamed from: a, reason: collision with root package name */
    public final long f6142a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6143b;

    /* renamed from: c, reason: collision with root package name */
    public final float f6144c;

    /* renamed from: d, reason: collision with root package name */
    public long f6145d = -9223372036854775807L;

    /* renamed from: e, reason: collision with root package name */
    public long f6146e = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public long f6148g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f6149h = -9223372036854775807L;

    /* renamed from: k, reason: collision with root package name */
    public float f6152k = 0.97f;

    /* renamed from: j, reason: collision with root package name */
    public float f6151j = 1.03f;

    /* renamed from: l, reason: collision with root package name */
    public float f6153l = 1.0f;

    /* renamed from: m, reason: collision with root package name */
    public long f6154m = -9223372036854775807L;

    /* renamed from: f, reason: collision with root package name */
    public long f6147f = -9223372036854775807L;

    /* renamed from: i, reason: collision with root package name */
    public long f6150i = -9223372036854775807L;
    public long n = -9223372036854775807L;
    public long o = -9223372036854775807L;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final long f6155a = Util.T(20);

        /* renamed from: b, reason: collision with root package name */
        public final long f6156b = Util.T(500);

        /* renamed from: c, reason: collision with root package name */
        public final float f6157c = 0.999f;
    }

    public DefaultLivePlaybackSpeedControl(long j2, long j3, float f2) {
        this.f6142a = j2;
        this.f6143b = j3;
        this.f6144c = f2;
    }

    public final void a() {
        long j2;
        long j3 = this.f6145d;
        if (j3 != -9223372036854775807L) {
            j2 = this.f6146e;
            if (j2 == -9223372036854775807L) {
                long j4 = this.f6148g;
                if (j4 != -9223372036854775807L && j3 < j4) {
                    j3 = j4;
                }
                j2 = this.f6149h;
                if (j2 == -9223372036854775807L || j3 <= j2) {
                    j2 = j3;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.f6147f == j2) {
            return;
        }
        this.f6147f = j2;
        this.f6150i = j2;
        this.n = -9223372036854775807L;
        this.o = -9223372036854775807L;
        this.f6154m = -9223372036854775807L;
    }

    public final void b(long j2) {
        this.f6146e = j2;
        a();
    }
}
