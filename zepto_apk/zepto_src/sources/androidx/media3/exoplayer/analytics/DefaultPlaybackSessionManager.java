package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.HashMap;
import java.util.Random;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {

    /* renamed from: h, reason: collision with root package name */
    public static final androidx.media3.datasource.a f6396h = new androidx.media3.datasource.a(1);

    /* renamed from: i, reason: collision with root package name */
    public static final Random f6397i = new Random();

    /* renamed from: d, reason: collision with root package name */
    public MediaMetricsListener f6401d;

    /* renamed from: f, reason: collision with root package name */
    public String f6403f;

    /* renamed from: a, reason: collision with root package name */
    public final Timeline.Window f6398a = new Timeline.Window();

    /* renamed from: b, reason: collision with root package name */
    public final Timeline.Period f6399b = new Timeline.Period();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6400c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public Timeline f6402e = Timeline.f5466a;

    /* renamed from: g, reason: collision with root package name */
    public long f6404g = -1;

    public final class SessionDescriptor {

        /* renamed from: a, reason: collision with root package name */
        public final String f6405a;

        /* renamed from: b, reason: collision with root package name */
        public int f6406b;

        /* renamed from: c, reason: collision with root package name */
        public long f6407c;

        /* renamed from: d, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f6408d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f6409e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f6410f;

        public SessionDescriptor(String str, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f6405a = str;
            this.f6406b = i2;
            this.f6407c = mediaPeriodId == null ? -1L : mediaPeriodId.f7612d;
            if (mediaPeriodId == null || !mediaPeriodId.b()) {
                return;
            }
            this.f6408d = mediaPeriodId;
        }

        public final boolean a(AnalyticsListener.EventTime eventTime) {
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.f6372d;
            if (mediaPeriodId == null) {
                return this.f6406b != eventTime.f6371c;
            }
            long j2 = this.f6407c;
            if (j2 == -1) {
                return false;
            }
            if (mediaPeriodId.f7612d > j2) {
                return true;
            }
            MediaSource.MediaPeriodId mediaPeriodId2 = this.f6408d;
            if (mediaPeriodId2 == null) {
                return false;
            }
            Timeline timeline = eventTime.f6370b;
            int iB = timeline.b(mediaPeriodId.f7609a);
            int iB2 = timeline.b(mediaPeriodId2.f7609a);
            if (mediaPeriodId.f7612d < mediaPeriodId2.f7612d || iB < iB2) {
                return false;
            }
            if (iB > iB2) {
                return true;
            }
            boolean zB = mediaPeriodId.b();
            int i2 = mediaPeriodId2.f7610b;
            if (!zB) {
                int i3 = mediaPeriodId.f7613e;
                return i3 == -1 || i3 > i2;
            }
            int i4 = mediaPeriodId.f7610b;
            if (i4 > i2) {
                return true;
            }
            if (i4 == i2) {
                return mediaPeriodId.f7611c > mediaPeriodId2.f7611c;
            }
            return false;
        }

        public final boolean b(Timeline timeline, Timeline timeline2) {
            MediaSource.MediaPeriodId mediaPeriodId;
            int i2 = this.f6406b;
            if (i2 < timeline.o()) {
                DefaultPlaybackSessionManager defaultPlaybackSessionManager = DefaultPlaybackSessionManager.this;
                timeline.n(i2, defaultPlaybackSessionManager.f6398a);
                Timeline.Window window = defaultPlaybackSessionManager.f6398a;
                for (int i3 = window.n; i3 <= window.o; i3++) {
                    int iB = timeline2.b(timeline.l(i3));
                    if (iB != -1) {
                        i2 = timeline2.f(iB, defaultPlaybackSessionManager.f6399b, false).f5477c;
                        break;
                    }
                }
                i2 = -1;
            } else if (i2 >= timeline2.o()) {
                i2 = -1;
            }
            this.f6406b = i2;
            return i2 != -1 && ((mediaPeriodId = this.f6408d) == null || timeline2.b(mediaPeriodId.f7609a) != -1);
        }
    }

    public final void a(SessionDescriptor sessionDescriptor) {
        long j2 = sessionDescriptor.f6407c;
        if (j2 != -1) {
            this.f6404g = j2;
        }
        this.f6403f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.SessionDescriptor b(int r18, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.util.HashMap r3 = r0.f6400c
            java.util.Collection r4 = r3.values()
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L16:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L9e
            java.lang.Object r8 = r4.next()
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor r8 = (androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.SessionDescriptor) r8
            long r9 = r8.f6407c
            r11 = -1
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L52
            int r9 = r8.f6406b
            if (r1 != r9) goto L52
            if (r2 == 0) goto L52
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager r9 = androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.this
            java.util.HashMap r10 = r9.f6400c
            java.lang.String r13 = r9.f6403f
            java.lang.Object r10 = r10.get(r13)
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor r10 = (androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.SessionDescriptor) r10
            if (r10 == 0) goto L45
            long r13 = r10.f6407c
            int r10 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r10 == 0) goto L45
            goto L4a
        L45:
            long r9 = r9.f6404g
            r13 = 1
            long r13 = r13 + r9
        L4a:
            long r9 = r2.f7612d
            int r13 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r13 < 0) goto L52
            r8.f6407c = r9
        L52:
            if (r2 != 0) goto L5a
            int r9 = r8.f6406b
            if (r1 != r9) goto L16
        L58:
            r15 = r11
            goto L80
        L5a:
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r9 = r8.f6408d
            long r13 = r2.f7612d
            if (r9 != 0) goto L6d
            boolean r9 = r2.b()
            if (r9 != 0) goto L16
            long r9 = r8.f6407c
            int r9 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r9 != 0) goto L16
            goto L58
        L6d:
            r15 = r11
            long r11 = r9.f7612d
            int r10 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r10 != 0) goto L16
            int r10 = r2.f7610b
            int r11 = r9.f7610b
            if (r10 != r11) goto L16
            int r10 = r2.f7611c
            int r9 = r9.f7611c
            if (r10 != r9) goto L16
        L80:
            long r9 = r8.f6407c
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L9a
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 >= 0) goto L8b
            goto L9a
        L8b:
            if (r11 != 0) goto L16
            int r9 = androidx.media3.common.util.Util.f5744a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r9 = r5.f6408d
            if (r9 == 0) goto L16
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r9 = r8.f6408d
            if (r9 == 0) goto L16
            r5 = r8
            goto L16
        L9a:
            r5 = r8
            r6 = r9
            goto L16
        L9e:
            if (r5 != 0) goto Lb0
            androidx.media3.datasource.a r4 = androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.f6396h
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor r5 = new androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor
            r5.<init>(r4, r1, r2)
            r3.put(r4, r5)
        Lb0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.b(int, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId):androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor");
    }

    public final synchronized String c(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return b(timeline.g(mediaPeriodId.f7609a, this.f6399b).f5477c, mediaPeriodId).f6405a;
    }

    public final void d(AnalyticsListener.EventTime eventTime) {
        MediaSource.MediaPeriodId mediaPeriodId;
        boolean zP = eventTime.f6370b.p();
        HashMap map = this.f6400c;
        if (zP) {
            String str = this.f6403f;
            if (str != null) {
                SessionDescriptor sessionDescriptor = (SessionDescriptor) map.get(str);
                sessionDescriptor.getClass();
                a(sessionDescriptor);
                return;
            }
            return;
        }
        SessionDescriptor sessionDescriptor2 = (SessionDescriptor) map.get(this.f6403f);
        int i2 = eventTime.f6371c;
        MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f6372d;
        this.f6403f = b(i2, mediaPeriodId2).f6405a;
        e(eventTime);
        if (mediaPeriodId2 == null || !mediaPeriodId2.b()) {
            return;
        }
        long j2 = mediaPeriodId2.f7612d;
        if (sessionDescriptor2 != null && sessionDescriptor2.f6407c == j2 && (mediaPeriodId = sessionDescriptor2.f6408d) != null && mediaPeriodId.f7610b == mediaPeriodId2.f7610b && mediaPeriodId.f7611c == mediaPeriodId2.f7611c) {
            return;
        }
        b(i2, new MediaSource.MediaPeriodId(j2, mediaPeriodId2.f7609a));
        this.f6401d.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0010, B:9:0x0014, B:11:0x0024, B:20:0x0036, B:22:0x0042, B:24:0x0048, B:14:0x002b, B:30:0x0053, B:32:0x005f, B:33:0x0063, B:35:0x0068, B:37:0x006e, B:39:0x0085, B:40:0x00b3, B:42:0x00b7, B:43:0x00be, B:45:0x00c8, B:47:0x00cc, B:49:0x00d9, B:52:0x00e0), top: B:57:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void e(androidx.media3.exoplayer.analytics.AnalyticsListener.EventTime r10) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.e(androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime):void");
    }
}
