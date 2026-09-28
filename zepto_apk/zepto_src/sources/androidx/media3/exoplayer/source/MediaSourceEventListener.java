package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public interface MediaSourceEventListener {

    public static class EventDispatcher {

        /* renamed from: a, reason: collision with root package name */
        public final int f7614a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f7615b;

        /* renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList f7616c;

        public static final class ListenerAndHandler {

            /* renamed from: a, reason: collision with root package name */
            public Handler f7617a;

            /* renamed from: b, reason: collision with root package name */
            public Object f7618b;
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public final void a(int i2, Format format, int i3, Object obj, long j2) {
            b(new MediaLoadData(1, i2, format, i3, obj, Util.j0(j2), -9223372036854775807L));
        }

        public final void b(MediaLoadData mediaLoadData) {
            Iterator it = this.f7616c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                Util.X(listenerAndHandler.f7617a, new androidx.media3.common.util.e(this, listenerAndHandler.f7618b, mediaLoadData, 4));
            }
        }

        public final void c(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            d(loadEventInfo, new MediaLoadData(i2, i3, format, i4, obj, Util.j0(j2), Util.j0(j3)));
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
        public final void d(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator it = this.f7616c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                LoadEventInfo loadEventInfo2 = loadEventInfo;
                Util.X(listenerAndHandler.f7617a, new f(this, listenerAndHandler.f7618b, loadEventInfo2, mediaLoadData, 2));
                loadEventInfo = loadEventInfo2;
            }
        }

        public final void e(LoadEventInfo loadEventInfo, int i2) {
            f(loadEventInfo, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public final void f(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            g(loadEventInfo, new MediaLoadData(i2, i3, format, i4, obj, Util.j0(j2), Util.j0(j3)));
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
        public final void g(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator it = this.f7616c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                LoadEventInfo loadEventInfo2 = loadEventInfo;
                Util.X(listenerAndHandler.f7617a, new f(this, listenerAndHandler.f7618b, loadEventInfo2, mediaLoadData, 1));
                loadEventInfo = loadEventInfo2;
            }
        }

        public final void h(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, IOException iOException, boolean z) {
            j(loadEventInfo, new MediaLoadData(i2, i3, format, i4, obj, Util.j0(j2), Util.j0(j3)), iOException, z);
        }

        public final void i(LoadEventInfo loadEventInfo, int i2, IOException iOException, boolean z) {
            h(loadEventInfo, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
        public final void j(LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
            Iterator it = this.f7616c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                final ?? r4 = listenerAndHandler.f7618b;
                final LoadEventInfo loadEventInfo2 = loadEventInfo;
                Util.X(listenerAndHandler.f7617a, new Runnable() { // from class: androidx.media3.exoplayer.source.g
                    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceEventListener.EventDispatcher eventDispatcher = this.f7904a;
                        int i2 = eventDispatcher.f7614a;
                        r4.H(i2, eventDispatcher.f7615b, loadEventInfo2, mediaLoadData, iOException, z);
                    }
                });
                loadEventInfo = loadEventInfo2;
            }
        }

        public final void k(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            l(loadEventInfo, new MediaLoadData(i2, i3, format, i4, obj, Util.j0(j2), Util.j0(j3)));
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
        public final void l(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator it = this.f7616c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                LoadEventInfo loadEventInfo2 = loadEventInfo;
                Util.X(listenerAndHandler.f7617a, new f(this, listenerAndHandler.f7618b, loadEventInfo2, mediaLoadData, 0));
                loadEventInfo = loadEventInfo2;
            }
        }

        public final void m(MediaLoadData mediaLoadData) {
            MediaSource.MediaPeriodId mediaPeriodId = this.f7615b;
            mediaPeriodId.getClass();
            Iterator it = this.f7616c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                MediaLoadData mediaLoadData2 = mediaLoadData;
                Util.X(listenerAndHandler.f7617a, new h(this, listenerAndHandler.f7618b, mediaPeriodId, mediaLoadData2, 0));
                mediaLoadData = mediaLoadData2;
            }
        }

        public EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f7616c = copyOnWriteArrayList;
            this.f7614a = i2;
            this.f7615b = mediaPeriodId;
        }
    }

    default void B(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void H(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
    }

    default void M(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void Q(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void R(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    default void h(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }
}
