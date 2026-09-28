package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class CompositeMediaSource<T> extends BaseMediaSource {

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f7521h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public Handler f7522i;

    /* renamed from: j, reason: collision with root package name */
    public TransferListener f7523j;

    public final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        /* renamed from: a, reason: collision with root package name */
        public final Object f7524a;

        /* renamed from: b, reason: collision with root package name */
        public MediaSourceEventListener.EventDispatcher f7525b;

        /* renamed from: c, reason: collision with root package name */
        public DrmSessionEventListener.EventDispatcher f7526c;

        public ForwardingEventListener(Object obj) {
            this.f7525b = CompositeMediaSource.this.f0(null);
            this.f7526c = CompositeMediaSource.this.e0(null);
            this.f7524a = obj;
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void B(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (b(i2, mediaPeriodId)) {
                this.f7525b.l(loadEventInfo, d(mediaLoadData, mediaPeriodId));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i2, mediaPeriodId)) {
                this.f7526c.b();
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
            if (b(i2, mediaPeriodId)) {
                this.f7526c.d(i3);
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void H(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            if (b(i2, mediaPeriodId)) {
                this.f7525b.j(loadEventInfo, d(mediaLoadData, mediaPeriodId), iOException, z);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void K(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            if (b(i2, mediaPeriodId)) {
                this.f7526c.e(exc);
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void M(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (b(i2, mediaPeriodId)) {
                this.f7525b.d(loadEventInfo, d(mediaLoadData, mediaPeriodId));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void Q(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (b(i2, mediaPeriodId)) {
                this.f7525b.g(loadEventInfo, d(mediaLoadData, mediaPeriodId));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void R(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (b(i2, mediaPeriodId)) {
                this.f7525b.b(d(mediaLoadData, mediaPeriodId));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void S(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i2, mediaPeriodId)) {
                this.f7526c.c();
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void Z(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i2, mediaPeriodId)) {
                this.f7526c.f();
            }
        }

        public final boolean b(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodIdM0;
            Object obj = this.f7524a;
            CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
            if (mediaPeriodId != null) {
                mediaPeriodIdM0 = compositeMediaSource.m0(obj, mediaPeriodId);
                if (mediaPeriodIdM0 == null) {
                    return false;
                }
            } else {
                mediaPeriodIdM0 = null;
            }
            int iO0 = compositeMediaSource.o0(i2, obj);
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.f7525b;
            if (eventDispatcher.f7614a != iO0 || !Util.a(eventDispatcher.f7615b, mediaPeriodIdM0)) {
                this.f7525b = new MediaSourceEventListener.EventDispatcher(compositeMediaSource.f7497c.f7616c, iO0, mediaPeriodIdM0);
            }
            DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.f7526c;
            if (eventDispatcher2.f6924a == iO0 && Util.a(eventDispatcher2.f6925b, mediaPeriodIdM0)) {
                return true;
            }
            this.f7526c = new DrmSessionEventListener.EventDispatcher(compositeMediaSource.f7498d.f6926c, iO0, mediaPeriodIdM0);
            return true;
        }

        public final MediaLoadData d(MediaLoadData mediaLoadData, MediaSource.MediaPeriodId mediaPeriodId) {
            CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
            Object obj = this.f7524a;
            long j2 = mediaLoadData.f7605f;
            long jN0 = compositeMediaSource.n0(obj, j2, mediaPeriodId);
            long j3 = mediaLoadData.f7606g;
            long jN02 = compositeMediaSource.n0(obj, j3, mediaPeriodId);
            if (jN0 == j2 && jN02 == j3) {
                return mediaLoadData;
            }
            return new MediaLoadData(mediaLoadData.f7600a, mediaLoadData.f7601b, mediaLoadData.f7602c, mediaLoadData.f7603d, mediaLoadData.f7604e, jN0, jN02);
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public final void h(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (b(i2, mediaPeriodId)) {
                this.f7525b.m(d(mediaLoadData, mediaPeriodId));
            }
        }
    }

    public static final class MediaSourceAndListener<T> {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSource f7528a;

        /* renamed from: b, reason: collision with root package name */
        public final a f7529b;

        /* renamed from: c, reason: collision with root package name */
        public final ForwardingEventListener f7530c;

        public MediaSourceAndListener(MediaSource mediaSource, a aVar, ForwardingEventListener forwardingEventListener) {
            this.f7528a = mediaSource;
            this.f7529b = aVar;
            this.f7530c = forwardingEventListener;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void V() {
        Iterator it = this.f7521h.values().iterator();
        while (it.hasNext()) {
            ((MediaSourceAndListener) it.next()).f7528a.V();
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public void g0() {
        for (MediaSourceAndListener mediaSourceAndListener : this.f7521h.values()) {
            mediaSourceAndListener.f7528a.U(mediaSourceAndListener.f7529b);
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public void h0() {
        for (MediaSourceAndListener mediaSourceAndListener : this.f7521h.values()) {
            mediaSourceAndListener.f7528a.N(mediaSourceAndListener.f7529b);
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public void j0(TransferListener transferListener) {
        this.f7523j = transferListener;
        this.f7522i = Util.o(null);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public void l0() {
        HashMap map = this.f7521h;
        for (MediaSourceAndListener mediaSourceAndListener : map.values()) {
            mediaSourceAndListener.f7528a.T(mediaSourceAndListener.f7529b);
            ForwardingEventListener forwardingEventListener = mediaSourceAndListener.f7530c;
            MediaSource mediaSource = mediaSourceAndListener.f7528a;
            mediaSource.z(forwardingEventListener);
            mediaSource.I(forwardingEventListener);
        }
        map.clear();
    }

    public MediaSource.MediaPeriodId m0(Object obj, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    public long n0(Object obj, long j2, MediaSource.MediaPeriodId mediaPeriodId) {
        return j2;
    }

    public abstract void p0(Object obj, BaseMediaSource baseMediaSource, Timeline timeline);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.media3.exoplayer.source.MediaSource$MediaSourceCaller, androidx.media3.exoplayer.source.a] */
    public final void q0(final Object obj, MediaSource mediaSource) {
        HashMap map = this.f7521h;
        Assertions.a(!map.containsKey(obj));
        ?? r1 = new MediaSource.MediaSourceCaller() { // from class: androidx.media3.exoplayer.source.a
            @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
            public final void b(BaseMediaSource baseMediaSource, Timeline timeline) {
                this.f7775a.p0(obj, baseMediaSource, timeline);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(obj);
        map.put(obj, new MediaSourceAndListener(mediaSource, r1, forwardingEventListener));
        Handler handler = this.f7522i;
        handler.getClass();
        mediaSource.d(handler, forwardingEventListener);
        Handler handler2 = this.f7522i;
        handler2.getClass();
        mediaSource.F(handler2, forwardingEventListener);
        TransferListener transferListener = this.f7523j;
        PlayerId playerId = this.f7501g;
        Assertions.h(playerId);
        mediaSource.L(r1, transferListener, playerId);
        if (this.f7496b.isEmpty()) {
            mediaSource.U(r1);
        }
    }

    public final void r0(MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) this.f7521h.remove(mediaPeriodId);
        mediaSourceAndListener.getClass();
        a aVar = mediaSourceAndListener.f7529b;
        MediaSource mediaSource = mediaSourceAndListener.f7528a;
        mediaSource.T(aVar);
        ForwardingEventListener forwardingEventListener = mediaSourceAndListener.f7530c;
        mediaSource.z(forwardingEventListener);
        mediaSource.I(forwardingEventListener);
    }

    public int o0(int i2, Object obj) {
        return i2;
    }
}
