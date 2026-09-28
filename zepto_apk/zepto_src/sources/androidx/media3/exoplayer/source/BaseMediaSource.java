package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class BaseMediaSource implements MediaSource {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7495a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f7496b = new HashSet(1);

    /* renamed from: c, reason: collision with root package name */
    public final MediaSourceEventListener.EventDispatcher f7497c = new MediaSourceEventListener.EventDispatcher();

    /* renamed from: d, reason: collision with root package name */
    public final DrmSessionEventListener.EventDispatcher f7498d = new DrmSessionEventListener.EventDispatcher();

    /* renamed from: e, reason: collision with root package name */
    public Looper f7499e;

    /* renamed from: f, reason: collision with root package name */
    public Timeline f7500f;

    /* renamed from: g, reason: collision with root package name */
    public PlayerId f7501g;

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void F(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        handler.getClass();
        this.f7498d.a(handler, drmSessionEventListener);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void I(DrmSessionEventListener drmSessionEventListener) {
        this.f7498d.g(drmSessionEventListener);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void L(MediaSource.MediaSourceCaller mediaSourceCaller, TransferListener transferListener, PlayerId playerId) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f7499e;
        Assertions.a(looper == null || looper == looperMyLooper);
        this.f7501g = playerId;
        Timeline timeline = this.f7500f;
        this.f7495a.add(mediaSourceCaller);
        if (this.f7499e == null) {
            this.f7499e = looperMyLooper;
            this.f7496b.add(mediaSourceCaller);
            j0(transferListener);
        } else if (timeline != null) {
            N(mediaSourceCaller);
            mediaSourceCaller.b(this, timeline);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void N(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.f7499e.getClass();
        HashSet hashSet = this.f7496b;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(mediaSourceCaller);
        if (zIsEmpty) {
            h0();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void T(MediaSource.MediaSourceCaller mediaSourceCaller) {
        ArrayList arrayList = this.f7495a;
        arrayList.remove(mediaSourceCaller);
        if (!arrayList.isEmpty()) {
            U(mediaSourceCaller);
            return;
        }
        this.f7499e = null;
        this.f7500f = null;
        this.f7501g = null;
        this.f7496b.clear();
        l0();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void U(MediaSource.MediaSourceCaller mediaSourceCaller) {
        HashSet hashSet = this.f7496b;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.remove(mediaSourceCaller);
        if (zIsEmpty || !hashSet.isEmpty()) {
            return;
        }
        g0();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void d(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        handler.getClass();
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.f7497c;
        eventDispatcher.getClass();
        MediaSourceEventListener.EventDispatcher.ListenerAndHandler listenerAndHandler = new MediaSourceEventListener.EventDispatcher.ListenerAndHandler();
        listenerAndHandler.f7617a = handler;
        listenerAndHandler.f7618b = mediaSourceEventListener;
        eventDispatcher.f7616c.add(listenerAndHandler);
    }

    public final DrmSessionEventListener.EventDispatcher e0(MediaSource.MediaPeriodId mediaPeriodId) {
        return new DrmSessionEventListener.EventDispatcher(this.f7498d.f6926c, 0, mediaPeriodId);
    }

    public final MediaSourceEventListener.EventDispatcher f0(MediaSource.MediaPeriodId mediaPeriodId) {
        return new MediaSourceEventListener.EventDispatcher(this.f7497c.f7616c, 0, mediaPeriodId);
    }

    public void g0() {
    }

    public void h0() {
    }

    public void i0(Timeline timeline) {
        k0(timeline);
    }

    public abstract void j0(TransferListener transferListener);

    public final void k0(Timeline timeline) {
        this.f7500f = timeline;
        Iterator it = this.f7495a.iterator();
        while (it.hasNext()) {
            ((MediaSource.MediaSourceCaller) it.next()).b(this, timeline);
        }
    }

    public abstract void l0();

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void z(MediaSourceEventListener mediaSourceEventListener) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7497c.f7616c;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            MediaSourceEventListener.EventDispatcher.ListenerAndHandler listenerAndHandler = (MediaSourceEventListener.EventDispatcher.ListenerAndHandler) it.next();
            if (listenerAndHandler.f7618b == mediaSourceEventListener) {
                copyOnWriteArrayList.remove(listenerAndHandler);
            }
        }
    }
}
