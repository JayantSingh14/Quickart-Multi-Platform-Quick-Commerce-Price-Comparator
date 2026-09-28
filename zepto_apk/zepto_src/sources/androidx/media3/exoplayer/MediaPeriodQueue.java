package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;

/* loaded from: classes3.dex */
final class MediaPeriodQueue {

    /* renamed from: a, reason: collision with root package name */
    public final Timeline.Period f6289a;

    /* renamed from: b, reason: collision with root package name */
    public final Timeline.Window f6290b;

    /* renamed from: c, reason: collision with root package name */
    public final AnalyticsCollector f6291c;

    /* renamed from: d, reason: collision with root package name */
    public final HandlerWrapper f6292d;

    /* renamed from: e, reason: collision with root package name */
    public final e f6293e;

    /* renamed from: f, reason: collision with root package name */
    public long f6294f;

    /* renamed from: g, reason: collision with root package name */
    public int f6295g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6296h;

    /* renamed from: i, reason: collision with root package name */
    public MediaPeriodHolder f6297i;

    /* renamed from: j, reason: collision with root package name */
    public MediaPeriodHolder f6298j;

    /* renamed from: k, reason: collision with root package name */
    public MediaPeriodHolder f6299k;

    /* renamed from: l, reason: collision with root package name */
    public int f6300l;

    /* renamed from: m, reason: collision with root package name */
    public Object f6301m;
    public long n;
    public ExoPlayer.PreloadConfiguration o;
    public ArrayList p;

    public MediaPeriodQueue(AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, e eVar) {
        ExoPlayer.PreloadConfiguration preloadConfiguration = ExoPlayer.PreloadConfiguration.f6196a;
        this.f6291c = analyticsCollector;
        this.f6292d = handlerWrapper;
        this.f6293e = eVar;
        this.o = preloadConfiguration;
        this.f6289a = new Timeline.Period();
        this.f6290b = new Timeline.Window();
        this.p = new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.exoplayer.source.MediaSource.MediaPeriodId m(androidx.media3.common.Timeline r16, java.lang.Object r17, long r18, long r20, androidx.media3.common.Timeline.Window r22, androidx.media3.common.Timeline.Period r23) {
        /*
            r0 = r16
            r1 = r18
            r3 = r22
            r4 = r17
            r5 = r23
            r0.g(r4, r5)
            int r6 = r5.f5477c
            r0.n(r6, r3)
            int r6 = r16.b(r17)
            r8 = r4
        L17:
            androidx.media3.common.AdPlaybackState r4 = r5.f5481g
            int r4 = r4.f5125b
            r7 = -1
            if (r4 == 0) goto L75
            r9 = 1
            r10 = 0
            if (r4 != r9) goto L28
            boolean r11 = r5.e(r10)
            if (r11 != 0) goto L75
        L28:
            androidx.media3.common.AdPlaybackState r11 = r5.f5481g
            int r11 = r11.f5128e
            boolean r11 = r5.f(r11)
            if (r11 == 0) goto L75
            androidx.media3.common.AdPlaybackState r11 = r5.f5481g
            long r12 = r5.f5478d
            r14 = 0
            int r11 = r11.c(r14, r12)
            if (r11 == r7) goto L3f
            goto L75
        L3f:
            long r11 = r5.f5478d
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 != 0) goto L46
            goto L66
        L46:
            int r11 = r4 + (-1)
            boolean r11 = r5.e(r11)
            if (r11 == 0) goto L50
            r11 = 2
            goto L51
        L50:
            r11 = r9
        L51:
            int r4 = r4 - r11
        L52:
            if (r10 > r4) goto L60
            androidx.media3.common.AdPlaybackState r11 = r5.f5481g
            androidx.media3.common.AdPlaybackState$AdGroup r11 = r11.a(r10)
            long r11 = r11.f5141h
            long r14 = r14 + r11
            int r10 = r10 + 1
            goto L52
        L60:
            long r10 = r5.f5478d
            int r4 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r4 > 0) goto L75
        L66:
            int r4 = r3.o
            if (r6 > r4) goto L75
            r0.f(r6, r5, r9)
            java.lang.Object r8 = r5.f5476b
            r8.getClass()
            int r6 = r6 + 1
            goto L17
        L75:
            r0.g(r8, r5)
            androidx.media3.common.AdPlaybackState r0 = r5.f5481g
            long r3 = r5.f5478d
            int r9 = r0.c(r1, r3)
            if (r9 != r7) goto L92
            androidx.media3.common.AdPlaybackState r0 = r5.f5481g
            long r3 = r5.f5478d
            int r0 = r0.b(r1, r3)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = new androidx.media3.exoplayer.source.MediaSource$MediaPeriodId
            r11 = r20
            r1.<init>(r8, r0, r11)
            return r1
        L92:
            r11 = r20
            int r10 = r5.d(r9)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r7 = new androidx.media3.exoplayer.source.MediaSource$MediaPeriodId
            r13 = -1
            r7.<init>(r8, r9, r10, r11, r13)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.m(androidx.media3.common.Timeline, java.lang.Object, long, long, androidx.media3.common.Timeline$Window, androidx.media3.common.Timeline$Period):androidx.media3.exoplayer.source.MediaSource$MediaPeriodId");
    }

    public final MediaPeriodHolder a() {
        MediaPeriodHolder mediaPeriodHolder = this.f6297i;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.f6298j) {
            this.f6298j = mediaPeriodHolder.f6278l;
        }
        mediaPeriodHolder.g();
        int i2 = this.f6300l - 1;
        this.f6300l = i2;
        if (i2 == 0) {
            this.f6299k = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.f6297i;
            this.f6301m = mediaPeriodHolder2.f6268b;
            this.n = mediaPeriodHolder2.f6272f.f6280a.f7612d;
        }
        this.f6297i = this.f6297i.f6278l;
        k();
        return this.f6297i;
    }

    public final void b() {
        if (this.f6300l == 0) {
            return;
        }
        MediaPeriodHolder mediaPeriodHolder = this.f6297i;
        Assertions.h(mediaPeriodHolder);
        this.f6301m = mediaPeriodHolder.f6268b;
        this.n = mediaPeriodHolder.f6272f.f6280a.f7612d;
        while (mediaPeriodHolder != null) {
            mediaPeriodHolder.g();
            mediaPeriodHolder = mediaPeriodHolder.f6278l;
        }
        this.f6297i = null;
        this.f6299k = null;
        this.f6298j = null;
        this.f6300l = 0;
        k();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.exoplayer.MediaPeriodInfo c(androidx.media3.common.Timeline r21, androidx.media3.exoplayer.MediaPeriodHolder r22, long r23) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.c(androidx.media3.common.Timeline, androidx.media3.exoplayer.MediaPeriodHolder, long):androidx.media3.exoplayer.MediaPeriodInfo");
    }

    public final MediaPeriodInfo d(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j2) {
        Timeline timeline2;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f6272f;
        long j3 = (mediaPeriodHolder.o + mediaPeriodInfo.f6284e) - j2;
        if (mediaPeriodInfo.f6286g) {
            return c(timeline, mediaPeriodHolder, j3);
        }
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f6280a;
        Object obj = mediaPeriodId.f7609a;
        Timeline.Period period = this.f6289a;
        timeline.g(obj, period);
        boolean zB = mediaPeriodId.b();
        Object obj2 = mediaPeriodId.f7609a;
        if (!zB) {
            int i2 = mediaPeriodId.f7613e;
            if (i2 != -1 && period.e(i2)) {
                return c(timeline, mediaPeriodHolder, j3);
            }
            int iD = period.d(i2);
            boolean z = period.f(i2) && period.c(i2, iD) == 3;
            if (iD != period.f5481g.a(i2).f5135b && !z) {
                return f(timeline, mediaPeriodId.f7609a, mediaPeriodId.f7613e, iD, mediaPeriodInfo.f6284e, mediaPeriodId.f7612d);
            }
            timeline.g(obj2, period);
            long jB = period.b(i2);
            return g(timeline, mediaPeriodId.f7609a, jB == Long.MIN_VALUE ? period.f5478d : period.f5481g.a(i2).f5141h + jB, mediaPeriodInfo.f6284e, mediaPeriodId.f7612d);
        }
        AdPlaybackState adPlaybackState = period.f5481g;
        int i3 = mediaPeriodId.f7610b;
        int i4 = adPlaybackState.a(i3).f5135b;
        if (i4 == -1) {
            return null;
        }
        int iB = period.f5481g.a(i3).b(mediaPeriodId.f7611c);
        if (iB < i4) {
            return f(timeline, mediaPeriodId.f7609a, i3, iB, mediaPeriodInfo.f6282c, mediaPeriodId.f7612d);
        }
        long jLongValue = mediaPeriodInfo.f6282c;
        if (jLongValue == -9223372036854775807L) {
            timeline2 = timeline;
            Pair pairJ = timeline2.j(this.f6290b, period, period.f5477c, -9223372036854775807L, Math.max(0L, j3));
            if (pairJ == null) {
                return null;
            }
            jLongValue = ((Long) pairJ.second).longValue();
        } else {
            timeline2 = timeline;
        }
        timeline2.g(obj2, period);
        int i5 = mediaPeriodId.f7610b;
        long jB2 = period.b(i5);
        return g(timeline2, mediaPeriodId.f7609a, Math.max(jB2 == Long.MIN_VALUE ? period.f5478d : period.f5481g.a(i5).f5141h + jB2, jLongValue), mediaPeriodInfo.f6282c, mediaPeriodId.f7612d);
    }

    public final MediaPeriodInfo e(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3) {
        timeline.g(mediaPeriodId.f7609a, this.f6289a);
        return mediaPeriodId.b() ? f(timeline, mediaPeriodId.f7609a, mediaPeriodId.f7610b, mediaPeriodId.f7611c, j2, mediaPeriodId.f7612d) : g(timeline, mediaPeriodId.f7609a, j3, j2, mediaPeriodId.f7612d);
    }

    public final MediaPeriodInfo f(Timeline timeline, Object obj, int i2, int i3, long j2, long j3) {
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i2, i3, j3, -1);
        Timeline.Period period = this.f6289a;
        long jA = timeline.g(obj, period).a(i2, i3);
        long jMax = i3 == period.d(i2) ? period.f5481g.f5126c : 0L;
        boolean zF = period.f(i2);
        if (jA != -9223372036854775807L && jMax >= jA) {
            jMax = Math.max(0L, jA - 1);
        }
        return new MediaPeriodInfo(mediaPeriodId, jMax, j2, -9223372036854775807L, jA, zF, false, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.exoplayer.MediaPeriodInfo g(androidx.media3.common.Timeline r27, java.lang.Object r28, long r29, long r31, long r33) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.g(androidx.media3.common.Timeline, java.lang.Object, long, long, long):androidx.media3.exoplayer.MediaPeriodInfo");
    }

    public final MediaPeriodInfo h(Timeline timeline, MediaPeriodInfo mediaPeriodInfo) {
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f6280a;
        boolean zB = mediaPeriodId.b();
        boolean zF = false;
        int i2 = mediaPeriodId.f7613e;
        boolean z = !zB && i2 == -1;
        boolean zJ = j(timeline, mediaPeriodId);
        boolean zI = i(timeline, mediaPeriodId, z);
        Object obj = mediaPeriodId.f7609a;
        Timeline.Period period = this.f6289a;
        timeline.g(obj, period);
        long jB = (mediaPeriodId.b() || i2 == -1) ? -9223372036854775807L : period.b(i2);
        boolean zB2 = mediaPeriodId.b();
        int i3 = mediaPeriodId.f7610b;
        long jA = zB2 ? period.a(i3, mediaPeriodId.f7611c) : (jB == -9223372036854775807L || jB == Long.MIN_VALUE) ? period.f5478d : jB;
        if (mediaPeriodId.b()) {
            zF = period.f(i3);
        } else if (i2 != -1 && period.f(i2)) {
            zF = true;
        }
        return new MediaPeriodInfo(mediaPeriodId, mediaPeriodInfo.f6281b, mediaPeriodInfo.f6282c, jB, jA, zF, z, zJ, zI);
    }

    public final boolean i(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        int iB = timeline.b(mediaPeriodId.f7609a);
        if (!timeline.m(timeline.f(iB, this.f6289a, false).f5477c, this.f6290b, 0L).f5494i) {
            if (timeline.d(iB, this.f6289a, this.f6290b, this.f6295g, this.f6296h) == -1 && z) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!mediaPeriodId.b() && mediaPeriodId.f7613e == -1) {
            Object obj = mediaPeriodId.f7609a;
            if (timeline.m(timeline.g(obj, this.f6289a).f5477c, this.f6290b, 0L).o == timeline.b(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void k() {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (MediaPeriodHolder mediaPeriodHolder = this.f6297i; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.f6278l) {
            builder.h(mediaPeriodHolder.f6272f.f6280a);
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f6298j;
        this.f6292d.i(new p(this, builder, mediaPeriodHolder2 == null ? null : mediaPeriodHolder2.f6272f.f6280a, 0));
    }

    public final boolean l(MediaPeriodHolder mediaPeriodHolder) {
        Assertions.h(mediaPeriodHolder);
        boolean z = false;
        if (mediaPeriodHolder.equals(this.f6299k)) {
            return false;
        }
        this.f6299k = mediaPeriodHolder;
        while (true) {
            mediaPeriodHolder = mediaPeriodHolder.f6278l;
            if (mediaPeriodHolder == null) {
                break;
            }
            if (mediaPeriodHolder == this.f6298j) {
                this.f6298j = this.f6297i;
                z = true;
            }
            mediaPeriodHolder.g();
            this.f6300l--;
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f6299k;
        mediaPeriodHolder2.getClass();
        if (mediaPeriodHolder2.f6278l != null) {
            mediaPeriodHolder2.b();
            mediaPeriodHolder2.f6278l = null;
            mediaPeriodHolder2.c();
        }
        k();
        return z;
    }

    public final MediaSource.MediaPeriodId n(Timeline timeline, Object obj, long j2) {
        long jO;
        int iB;
        Object obj2 = obj;
        Timeline.Period period = this.f6289a;
        int i2 = timeline.g(obj2, period).f5477c;
        Object obj3 = this.f6301m;
        if (obj3 == null || (iB = timeline.b(obj3)) == -1 || timeline.f(iB, period, false).f5477c != i2) {
            MediaPeriodHolder mediaPeriodHolder = this.f6297i;
            while (true) {
                if (mediaPeriodHolder == null) {
                    MediaPeriodHolder mediaPeriodHolder2 = this.f6297i;
                    while (true) {
                        if (mediaPeriodHolder2 != null) {
                            int iB2 = timeline.b(mediaPeriodHolder2.f6268b);
                            if (iB2 != -1 && timeline.f(iB2, period, false).f5477c == i2) {
                                jO = mediaPeriodHolder2.f6272f.f6280a.f7612d;
                                break;
                            }
                            mediaPeriodHolder2 = mediaPeriodHolder2.f6278l;
                        } else {
                            jO = o(obj2);
                            if (jO == -1) {
                                jO = this.f6294f;
                                this.f6294f = 1 + jO;
                                if (this.f6297i == null) {
                                    this.f6301m = obj2;
                                    this.n = jO;
                                }
                            }
                        }
                    }
                } else {
                    if (mediaPeriodHolder.f6268b.equals(obj2)) {
                        jO = mediaPeriodHolder.f6272f.f6280a.f7612d;
                        break;
                    }
                    mediaPeriodHolder = mediaPeriodHolder.f6278l;
                }
            }
        } else {
            jO = this.n;
        }
        timeline.g(obj2, period);
        int i3 = period.f5477c;
        Timeline.Window window = this.f6290b;
        timeline.n(i3, window);
        boolean z = false;
        for (int iB3 = timeline.b(obj); iB3 >= window.n; iB3--) {
            timeline.f(iB3, period, true);
            AdPlaybackState adPlaybackState = period.f5481g;
            boolean z2 = adPlaybackState.f5125b > 0;
            z |= z2;
            long j3 = period.f5478d;
            if (adPlaybackState.c(j3, j3) != -1) {
                obj2 = period.f5476b;
                obj2.getClass();
            }
            if (z && (!z2 || period.f5478d != 0)) {
                break;
            }
        }
        return m(timeline, obj2, j2, jO, this.f6290b, this.f6289a);
    }

    public final long o(Object obj) {
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) this.p.get(i2);
            if (mediaPeriodHolder.f6268b.equals(obj)) {
                return mediaPeriodHolder.f6272f.f6280a.f7612d;
            }
        }
        return -1L;
    }

    public final boolean p(Timeline timeline) {
        Timeline timeline2;
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder mediaPeriodHolder2 = this.f6297i;
        if (mediaPeriodHolder2 == null) {
            return true;
        }
        int iB = timeline.b(mediaPeriodHolder2.f6268b);
        while (true) {
            timeline2 = timeline;
            iB = timeline2.d(iB, this.f6289a, this.f6290b, this.f6295g, this.f6296h);
            while (true) {
                mediaPeriodHolder = mediaPeriodHolder2.f6278l;
                if (mediaPeriodHolder == null || mediaPeriodHolder2.f6272f.f6286g) {
                    break;
                }
                mediaPeriodHolder2 = mediaPeriodHolder;
            }
            if (iB == -1 || mediaPeriodHolder == null || timeline2.b(mediaPeriodHolder.f6268b) != iB) {
                break;
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
            timeline = timeline2;
        }
        boolean zL = l(mediaPeriodHolder2);
        mediaPeriodHolder2.f6272f = h(timeline2, mediaPeriodHolder2.f6272f);
        return !zL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
    
        return !l(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0086, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(androidx.media3.common.Timeline r11, long r12, long r14) {
        /*
            r10 = this;
            androidx.media3.exoplayer.MediaPeriodHolder r0 = r10.f6297i
            r1 = 0
        L3:
            r2 = 1
            if (r0 == 0) goto L86
            androidx.media3.exoplayer.MediaPeriodInfo r3 = r0.f6272f
            if (r1 != 0) goto Lf
            androidx.media3.exoplayer.MediaPeriodInfo r1 = r10.h(r11, r3)
            goto L2e
        Lf:
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r10.d(r11, r1, r12)
            if (r4 != 0) goto L1b
            boolean r11 = r10.l(r1)
            r11 = r11 ^ r2
            return r11
        L1b:
            long r5 = r3.f6281b
            long r7 = r4.f6281b
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L80
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r3.f6280a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r6 = r4.f6280a
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L80
            r1 = r4
        L2e:
            long r4 = r3.f6282c
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r1.a(r4)
            r0.f6272f = r4
            long r3 = r3.f6284e
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L7a
            long r7 = r1.f6284e
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 != 0) goto L48
            goto L7a
        L48:
            r0.i()
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 != 0) goto L55
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L58
        L55:
            long r11 = r0.o
            long r11 = r11 + r7
        L58:
            androidx.media3.exoplayer.MediaPeriodHolder r13 = r10.f6298j
            r1 = 0
            if (r0 != r13) goto L6f
            androidx.media3.exoplayer.MediaPeriodInfo r13 = r0.f6272f
            boolean r13 = r13.f6285f
            if (r13 != 0) goto L6f
            r3 = -9223372036854775808
            int r13 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r13 == 0) goto L6d
            int r11 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r11 < 0) goto L6f
        L6d:
            r11 = r2
            goto L70
        L6f:
            r11 = r1
        L70:
            boolean r12 = r10.l(r0)
            if (r12 != 0) goto L79
            if (r11 != 0) goto L79
            goto L86
        L79:
            return r1
        L7a:
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r0.f6278l
            r9 = r1
            r1 = r0
            r0 = r9
            goto L3
        L80:
            boolean r11 = r10.l(r1)
            r11 = r11 ^ r2
            return r11
        L86:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.q(androidx.media3.common.Timeline, long, long):boolean");
    }
}
