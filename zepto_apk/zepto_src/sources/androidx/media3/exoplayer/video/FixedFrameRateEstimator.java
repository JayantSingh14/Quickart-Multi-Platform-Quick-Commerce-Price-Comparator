package androidx.media3.exoplayer.video;

import java.util.Arrays;

/* loaded from: classes3.dex */
final class FixedFrameRateEstimator {

    /* renamed from: c, reason: collision with root package name */
    public boolean f8262c;

    /* renamed from: e, reason: collision with root package name */
    public int f8264e;

    /* renamed from: a, reason: collision with root package name */
    public Matcher f8260a = new Matcher();

    /* renamed from: b, reason: collision with root package name */
    public Matcher f8261b = new Matcher();

    /* renamed from: d, reason: collision with root package name */
    public long f8263d = -9223372036854775807L;

    public static final class Matcher {

        /* renamed from: a, reason: collision with root package name */
        public long f8265a;

        /* renamed from: b, reason: collision with root package name */
        public long f8266b;

        /* renamed from: c, reason: collision with root package name */
        public long f8267c;

        /* renamed from: d, reason: collision with root package name */
        public long f8268d;

        /* renamed from: e, reason: collision with root package name */
        public long f8269e;

        /* renamed from: f, reason: collision with root package name */
        public long f8270f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean[] f8271g = new boolean[15];

        /* renamed from: h, reason: collision with root package name */
        public int f8272h;

        public final boolean a() {
            return this.f8268d > 15 && this.f8272h == 0;
        }

        public final void b(long j2) {
            long j3 = this.f8268d;
            if (j3 == 0) {
                this.f8265a = j2;
            } else if (j3 == 1) {
                long j4 = j2 - this.f8265a;
                this.f8266b = j4;
                this.f8270f = j4;
                this.f8269e = 1L;
            } else {
                long j5 = j2 - this.f8267c;
                int i2 = (int) (j3 % 15);
                long jAbs = Math.abs(j5 - this.f8266b);
                boolean[] zArr = this.f8271g;
                if (jAbs <= 1000000) {
                    this.f8269e++;
                    this.f8270f += j5;
                    if (zArr[i2]) {
                        zArr[i2] = false;
                        this.f8272h--;
                    }
                } else if (!zArr[i2]) {
                    zArr[i2] = true;
                    this.f8272h++;
                }
            }
            this.f8268d++;
            this.f8267c = j2;
        }

        public final void c() {
            this.f8268d = 0L;
            this.f8269e = 0L;
            this.f8270f = 0L;
            this.f8272h = 0;
            Arrays.fill(this.f8271g, false);
        }
    }
}
