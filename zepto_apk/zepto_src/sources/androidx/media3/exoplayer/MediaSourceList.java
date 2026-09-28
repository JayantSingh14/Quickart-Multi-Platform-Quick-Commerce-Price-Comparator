package androidx.media3.exoplayer;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ShuffleOrder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class MediaSourceList {

    /* renamed from: a, reason: collision with root package name */
    public final PlayerId f6302a;

    /* renamed from: e, reason: collision with root package name */
    public final MediaSourceListInfoRefreshListener f6306e;

    /* renamed from: h, reason: collision with root package name */
    public final AnalyticsCollector f6309h;

    /* renamed from: i, reason: collision with root package name */
    public final HandlerWrapper f6310i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6312k;

    /* renamed from: l, reason: collision with root package name */
    public TransferListener f6313l;

    /* renamed from: j, reason: collision with root package name */
    public ShuffleOrder f6311j = new ShuffleOrder.DefaultShuffleOrder();

    /* renamed from: c, reason: collision with root package name */
    public final IdentityHashMap f6304c = new IdentityHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f6305d = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f6303b = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f6307f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final HashSet f6308g = new HashSet();

    public final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSourceHolder f6314a;

        public ForwardingEventListener(MediaSourceHolder mediaSourceHolder) {
            this.f6314a = mediaSourceHolder;
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void B(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new u(this, pairB, loadEventInfo, mediaLoadData, 1));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new t(this, pairB, 0));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, final int i3) {
            final Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new Runnable() { // from class: androidx.media3.exoplayer.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnalyticsCollector analyticsCollector = MediaSourceList.this.f6309h;
                        Pair pair = pairB;
                        analyticsCollector.G(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, i3);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void H(int i2, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
            final Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new Runnable() { // from class: androidx.media3.exoplayer.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnalyticsCollector analyticsCollector = MediaSourceList.this.f6309h;
                        Pair pair = pairB;
                        analyticsCollector.H(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, iOException, z);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void K(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new p(this, pairB, exc, 1));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void M(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new u(this, pairB, loadEventInfo, mediaLoadData, 0));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void Q(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new u(this, pairB, loadEventInfo, mediaLoadData, 2));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void R(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new s(this, pairB, mediaLoadData, 1));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void S(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new t(this, pairB, 2));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void Z(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new t(this, pairB, 1));
            }
        }

        public final Pair b(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodIdA;
            MediaSourceHolder mediaSourceHolder = this.f6314a;
            MediaSource.MediaPeriodId mediaPeriodId2 = null;
            if (mediaPeriodId != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= mediaSourceHolder.f6321c.size()) {
                        mediaPeriodIdA = null;
                        break;
                    }
                    if (((MediaSource.MediaPeriodId) mediaSourceHolder.f6321c.get(i3)).f7612d == mediaPeriodId.f7612d) {
                        Object obj = mediaSourceHolder.f6320b;
                        int i4 = AbstractConcatenatedTimeline.f6093g;
                        mediaPeriodIdA = mediaPeriodId.a(Pair.create(obj, mediaPeriodId.f7609a));
                        break;
                    }
                    i3++;
                }
                if (mediaPeriodIdA == null) {
                    return null;
                }
                mediaPeriodId2 = mediaPeriodIdA;
            }
            return Pair.create(Integer.valueOf(i2 + mediaSourceHolder.f6322d), mediaPeriodId2);
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void h(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair pairB = b(i2, mediaPeriodId);
            if (pairB != null) {
                MediaSourceList.this.f6310i.i(new s(this, pairB, mediaLoadData, 0));
            }
        }
    }

    public static final class MediaSourceAndListener {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSource f6316a;

        /* renamed from: b, reason: collision with root package name */
        public final q f6317b;

        /* renamed from: c, reason: collision with root package name */
        public final ForwardingEventListener f6318c;

        public MediaSourceAndListener(MediaSource mediaSource, q qVar, ForwardingEventListener forwardingEventListener) {
            this.f6316a = mediaSource;
            this.f6317b = qVar;
            this.f6318c = forwardingEventListener;
        }
    }

    public static final class MediaSourceHolder implements MediaSourceInfoHolder {

        /* renamed from: a, reason: collision with root package name */
        public final MaskingMediaSource f6319a;

        /* renamed from: d, reason: collision with root package name */
        public int f6322d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f6323e;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f6321c = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final Object f6320b = new Object();

        public MediaSourceHolder(MediaSource mediaSource, boolean z) {
            this.f6319a = new MaskingMediaSource(mediaSource, z);
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public final Object a() {
            return this.f6320b;
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public final Timeline b() {
            return this.f6319a.o;
        }
    }

    public interface MediaSourceListInfoRefreshListener {
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, PlayerId playerId) {
        this.f6302a = playerId;
        this.f6306e = mediaSourceListInfoRefreshListener;
        this.f6309h = analyticsCollector;
        this.f6310i = handlerWrapper;
    }

    public final Timeline a(int i2, ArrayList arrayList, ShuffleOrder shuffleOrder) {
        if (!arrayList.isEmpty()) {
            this.f6311j = shuffleOrder;
            for (int i3 = i2; i3 < arrayList.size() + i2; i3++) {
                MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) arrayList.get(i3 - i2);
                ArrayList arrayList2 = this.f6303b;
                if (i3 > 0) {
                    MediaSourceHolder mediaSourceHolder2 = (MediaSourceHolder) arrayList2.get(i3 - 1);
                    mediaSourceHolder.f6322d = mediaSourceHolder2.f6319a.o.f7572e.o() + mediaSourceHolder2.f6322d;
                    mediaSourceHolder.f6323e = false;
                    mediaSourceHolder.f6321c.clear();
                } else {
                    mediaSourceHolder.f6322d = 0;
                    mediaSourceHolder.f6323e = false;
                    mediaSourceHolder.f6321c.clear();
                }
                int iO = mediaSourceHolder.f6319a.o.f7572e.o();
                for (int i4 = i3; i4 < arrayList2.size(); i4++) {
                    ((MediaSourceHolder) arrayList2.get(i4)).f6322d += iO;
                }
                arrayList2.add(i3, mediaSourceHolder);
                this.f6305d.put(mediaSourceHolder.f6320b, mediaSourceHolder);
                if (this.f6312k) {
                    e(mediaSourceHolder);
                    if (this.f6304c.isEmpty()) {
                        this.f6308g.add(mediaSourceHolder);
                    } else {
                        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) this.f6307f.get(mediaSourceHolder);
                        if (mediaSourceAndListener != null) {
                            mediaSourceAndListener.f6316a.U(mediaSourceAndListener.f6317b);
                        }
                    }
                }
            }
        }
        return b();
    }

    public final Timeline b() {
        ArrayList arrayList = this.f6303b;
        if (arrayList.isEmpty()) {
            return Timeline.f5466a;
        }
        int iO = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) arrayList.get(i2);
            mediaSourceHolder.f6322d = iO;
            iO += mediaSourceHolder.f6319a.o.f7572e.o();
        }
        return new PlaylistTimeline(arrayList, this.f6311j);
    }

    public final void c() {
        Iterator it = this.f6308g.iterator();
        while (it.hasNext()) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) it.next();
            if (mediaSourceHolder.f6321c.isEmpty()) {
                MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) this.f6307f.get(mediaSourceHolder);
                if (mediaSourceAndListener != null) {
                    mediaSourceAndListener.f6316a.U(mediaSourceAndListener.f6317b);
                }
                it.remove();
            }
        }
    }

    public final void d(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f6323e && mediaSourceHolder.f6321c.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) this.f6307f.remove(mediaSourceHolder);
            mediaSourceAndListener.getClass();
            q qVar = mediaSourceAndListener.f6317b;
            MediaSource mediaSource = mediaSourceAndListener.f6316a;
            mediaSource.T(qVar);
            ForwardingEventListener forwardingEventListener = mediaSourceAndListener.f6318c;
            mediaSource.z(forwardingEventListener);
            mediaSource.I(forwardingEventListener);
            this.f6308g.remove(mediaSourceHolder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.media3.exoplayer.q, androidx.media3.exoplayer.source.MediaSource$MediaSourceCaller] */
    public final void e(MediaSourceHolder mediaSourceHolder) {
        MaskingMediaSource maskingMediaSource = mediaSourceHolder.f6319a;
        ?? r1 = new MediaSource.MediaSourceCaller() { // from class: androidx.media3.exoplayer.q
            @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
            public final void b(BaseMediaSource baseMediaSource, Timeline timeline) {
                HandlerWrapper handlerWrapper = ((ExoPlayerImplInternal) this.f7394a.f6306e).f6224h;
                handlerWrapper.l(2);
                handlerWrapper.k(22);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(mediaSourceHolder);
        this.f6307f.put(mediaSourceHolder, new MediaSourceAndListener(maskingMediaSource, r1, forwardingEventListener));
        int i2 = Util.f5744a;
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        maskingMediaSource.d(new Handler(looperMyLooper, null), forwardingEventListener);
        Looper looperMyLooper2 = Looper.myLooper();
        if (looperMyLooper2 == null) {
            looperMyLooper2 = Looper.getMainLooper();
        }
        maskingMediaSource.f7498d.a(new Handler(looperMyLooper2, null), forwardingEventListener);
        maskingMediaSource.L(r1, this.f6313l, this.f6302a);
    }

    public final void f(MediaPeriod mediaPeriod) {
        IdentityHashMap identityHashMap = this.f6304c;
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) identityHashMap.remove(mediaPeriod);
        mediaSourceHolder.getClass();
        mediaSourceHolder.f6319a.J(mediaPeriod);
        mediaSourceHolder.f6321c.remove(((MaskingMediaPeriod) mediaPeriod).f7585a);
        if (!identityHashMap.isEmpty()) {
            c();
        }
        d(mediaSourceHolder);
    }

    public final void g(int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            ArrayList arrayList = this.f6303b;
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) arrayList.remove(i4);
            this.f6305d.remove(mediaSourceHolder.f6320b);
            int i5 = -mediaSourceHolder.f6319a.o.f7572e.o();
            for (int i6 = i4; i6 < arrayList.size(); i6++) {
                ((MediaSourceHolder) arrayList.get(i6)).f6322d += i5;
            }
            mediaSourceHolder.f6323e = true;
            if (this.f6312k) {
                d(mediaSourceHolder);
            }
        }
    }
}
