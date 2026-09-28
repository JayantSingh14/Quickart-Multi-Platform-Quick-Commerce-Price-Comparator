package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import java.lang.reflect.Method;
import java.math.RoundingMode;

/* loaded from: classes3.dex */
final class AudioTrackPositionTracker {
    public long A;
    public long B;
    public long C;
    public long D;
    public boolean E;
    public long F;
    public long G;
    public boolean H;
    public long I;
    public SystemClock J;

    /* renamed from: a, reason: collision with root package name */
    public final Listener f6551a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f6552b;

    /* renamed from: c, reason: collision with root package name */
    public AudioTrack f6553c;

    /* renamed from: d, reason: collision with root package name */
    public int f6554d;

    /* renamed from: e, reason: collision with root package name */
    public int f6555e;

    /* renamed from: f, reason: collision with root package name */
    public AudioTimestampPoller f6556f;

    /* renamed from: g, reason: collision with root package name */
    public int f6557g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6558h;

    /* renamed from: i, reason: collision with root package name */
    public long f6559i;

    /* renamed from: j, reason: collision with root package name */
    public float f6560j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6561k;

    /* renamed from: l, reason: collision with root package name */
    public long f6562l;

    /* renamed from: m, reason: collision with root package name */
    public long f6563m;
    public Method n;
    public long o;
    public boolean p;
    public boolean q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public int w;
    public int x;
    public long y;
    public long z;

    public interface Listener {
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.f6551a = listener;
        try {
            this.n = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.f6552b = new long[10];
        this.J = Clock.f5662a;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021d A[Catch: Exception -> 0x0233, TRY_LEAVE, TryCatch #0 {Exception -> 0x0233, blocks: (B:92:0x01f8, B:94:0x021d), top: B:135:0x01f8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(boolean r27) {
        /*
            Method dump skipped, instructions count: 770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.AudioTrackPositionTracker.a(boolean):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long b() {
        /*
            r11 = this;
            androidx.media3.common.util.SystemClock r0 = r11.J
            r0.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = r11.y
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 2
            if (r2 == 0) goto L46
            android.media.AudioTrack r2 = r11.f6553c
            r2.getClass()
            int r2 = r2.getPlayState()
            if (r2 != r3) goto L23
            long r0 = r11.A
            return r0
        L23:
            long r0 = androidx.media3.common.util.Util.T(r0)
            long r2 = r11.y
            long r0 = r0 - r2
            float r2 = r11.f6560j
            long r3 = androidx.media3.common.util.Util.z(r0, r2)
            int r0 = r11.f6557g
            long r5 = (long) r0
            r7 = 1000000(0xf4240, double:4.940656E-318)
            java.math.RoundingMode r9 = java.math.RoundingMode.CEILING
            long r0 = androidx.media3.common.util.Util.b0(r3, r5, r7, r9)
            long r2 = r11.B
            long r4 = r11.A
            long r4 = r4 + r0
            long r0 = java.lang.Math.min(r2, r4)
            return r0
        L46:
            long r6 = r11.s
            long r6 = r0 - r6
            r8 = 5
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 < 0) goto Lb7
            android.media.AudioTrack r2 = r11.f6553c
            r2.getClass()
            int r6 = r2.getPlayState()
            r7 = 1
            if (r6 != r7) goto L5d
            goto Lb5
        L5d:
            int r2 = r2.getPlaybackHeadPosition()
            long r7 = (long) r2
            r9 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r7 = r7 & r9
            boolean r2 = r11.f6558h
            r9 = 0
            if (r2 == 0) goto L7b
            if (r6 != r3) goto L78
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 != 0) goto L78
            long r2 = r11.t
            r11.v = r2
        L78:
            long r2 = r11.v
            long r7 = r7 + r2
        L7b:
            int r2 = androidx.media3.common.util.Util.f5744a
            r3 = 29
            if (r2 > r3) goto L99
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 != 0) goto L97
            long r2 = r11.t
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L97
            r2 = 3
            if (r6 != r2) goto L97
            long r2 = r11.z
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto Lb5
            r11.z = r0
            goto Lb5
        L97:
            r11.z = r4
        L99:
            long r2 = r11.t
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 <= 0) goto Lb3
            boolean r4 = r11.H
            if (r4 == 0) goto Lac
            long r4 = r11.I
            long r4 = r4 + r2
            r11.I = r4
            r2 = 0
            r11.H = r2
            goto Lb3
        Lac:
            long r2 = r11.u
            r4 = 1
            long r2 = r2 + r4
            r11.u = r2
        Lb3:
            r11.t = r7
        Lb5:
            r11.s = r0
        Lb7:
            long r0 = r11.t
            long r2 = r11.I
            long r0 = r0 + r2
            long r2 = r11.u
            r4 = 32
            long r2 = r2 << r4
            long r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.AudioTrackPositionTracker.b():long");
    }

    public final boolean c(long j2) {
        long jA = a(false);
        int i2 = this.f6557g;
        int i3 = Util.f5744a;
        if (j2 > Util.b0(jA, i2, 1000000L, RoundingMode.CEILING)) {
            return true;
        }
        if (this.f6558h) {
            AudioTrack audioTrack = this.f6553c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2 && b() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        this.f6562l = 0L;
        this.x = 0;
        this.w = 0;
        this.f6563m = 0L;
        this.D = 0L;
        this.G = 0L;
        this.f6561k = false;
    }
}
