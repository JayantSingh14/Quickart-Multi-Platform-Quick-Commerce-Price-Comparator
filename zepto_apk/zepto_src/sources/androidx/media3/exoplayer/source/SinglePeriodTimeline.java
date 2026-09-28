package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class SinglePeriodTimeline extends Timeline {
    public static final Object r = new Object();

    /* renamed from: e, reason: collision with root package name */
    public final long f7722e;

    /* renamed from: f, reason: collision with root package name */
    public final long f7723f;

    /* renamed from: g, reason: collision with root package name */
    public final long f7724g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7725h;

    /* renamed from: i, reason: collision with root package name */
    public final long f7726i;

    /* renamed from: j, reason: collision with root package name */
    public final long f7727j;

    /* renamed from: k, reason: collision with root package name */
    public final long f7728k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f7729l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f7730m;
    public final boolean n;
    public final Object o;
    public final MediaItem p;
    public final MediaItem.LiveConfiguration q;

    static {
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.f5266a = "SinglePeriodTimeline";
        builder.f5267b = Uri.EMPTY;
        builder.a();
    }

    public SinglePeriodTimeline(long j2, boolean z, boolean z2, MediaItem mediaItem) {
        this(j2, j2, 0L, 0L, z, false, z2, null, mediaItem);
    }

    @Override // androidx.media3.common.Timeline
    public final int b(Object obj) {
        return r.equals(obj) ? 0 : -1;
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
        Assertions.c(i2, 1);
        Object obj = z ? r : null;
        long j2 = -this.f7727j;
        period.getClass();
        period.g(null, obj, 0, this.f7725h, j2, AdPlaybackState.f5118g, false);
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public final int h() {
        return 1;
    }

    @Override // androidx.media3.common.Timeline
    public final Object l(int i2) {
        Assertions.c(i2, 1);
        return r;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r1
      0x002d: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v5 long) binds: [B:3:0x000c, B:5:0x0010, B:7:0x0016, B:12:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.media3.common.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.common.Timeline.Window m(int r25, androidx.media3.common.Timeline.Window r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 1
            r2 = r25
            androidx.media3.common.util.Assertions.c(r2, r1)
            long r1 = r0.f7728k
            boolean r14 = r0.f7730m
            if (r14 == 0) goto L2d
            boolean r3 = r0.n
            if (r3 != 0) goto L2d
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2d
            long r3 = r0.f7726i
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L26
        L23:
            r16 = r5
            goto L2f
        L26:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2d
            goto L23
        L2d:
            r16 = r1
        L2f:
            java.lang.Object r4 = androidx.media3.common.Timeline.Window.q
            long r1 = r0.f7726i
            r20 = 0
            androidx.media3.common.MediaItem r5 = r0.p
            java.lang.Object r6 = r0.o
            long r7 = r0.f7722e
            long r9 = r0.f7723f
            long r11 = r0.f7724g
            boolean r13 = r0.f7729l
            androidx.media3.common.MediaItem$LiveConfiguration r15 = r0.q
            r21 = 0
            r18 = r1
            long r1 = r0.f7727j
            r3 = r26
            r22 = r1
            r3.b(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r26
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SinglePeriodTimeline.m(int, androidx.media3.common.Timeline$Window, long):androidx.media3.common.Timeline$Window");
    }

    @Override // androidx.media3.common.Timeline
    public final int o() {
        return 1;
    }

    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3, Object obj, MediaItem mediaItem) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j3, j4, j5, z, z2, false, obj, mediaItem, z3 ? mediaItem.f5259c : null);
    }

    public SinglePeriodTimeline(long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
        this.f7722e = j2;
        this.f7723f = j3;
        this.f7724g = -9223372036854775807L;
        this.f7725h = j4;
        this.f7726i = j5;
        this.f7727j = j6;
        this.f7728k = j7;
        this.f7729l = z;
        this.f7730m = z2;
        this.n = z3;
        this.o = obj;
        mediaItem.getClass();
        this.p = mediaItem;
        this.q = liveConfiguration;
    }
}
