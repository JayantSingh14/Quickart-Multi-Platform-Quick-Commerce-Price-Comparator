package androidx.media3.exoplayer.drm;

import android.os.Handler;
import androidx.activity.g;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.e;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
/* loaded from: classes.dex */
public interface DrmSessionEventListener {

    /* loaded from: classes3.dex */
    public static class EventDispatcher {

        /* renamed from: a, reason: collision with root package name */
        public final int f6924a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f6925b;

        /* renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList f6926c;

        public static final class ListenerAndHandler {

            /* renamed from: a, reason: collision with root package name */
            public Handler f6927a;

            /* renamed from: b, reason: collision with root package name */
            public Object f6928b;
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public final void a(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            handler.getClass();
            ListenerAndHandler listenerAndHandler = new ListenerAndHandler();
            listenerAndHandler.f6927a = handler;
            listenerAndHandler.f6928b = drmSessionEventListener;
            this.f6926c.add(listenerAndHandler);
        }

        public final void b() {
            Iterator it = this.f6926c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                Util.X(listenerAndHandler.f6927a, new b(2, this, listenerAndHandler.f6928b));
            }
        }

        public final void c() {
            Iterator it = this.f6926c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                Util.X(listenerAndHandler.f6927a, new b(1, this, listenerAndHandler.f6928b));
            }
        }

        public final void d(int i2) {
            Iterator it = this.f6926c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                Util.X(listenerAndHandler.f6927a, new g(this, listenerAndHandler.f6928b, i2, 2));
            }
        }

        public final void e(Exception exc) {
            Iterator it = this.f6926c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                Util.X(listenerAndHandler.f6927a, new e(this, listenerAndHandler.f6928b, exc, 3));
            }
        }

        public final void f() {
            Iterator it = this.f6926c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                Util.X(listenerAndHandler.f6927a, new b(0, this, listenerAndHandler.f6928b));
            }
        }

        public final void g(DrmSessionEventListener drmSessionEventListener) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f6926c;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                if (listenerAndHandler.f6928b == drmSessionEventListener) {
                    copyOnWriteArrayList.remove(listenerAndHandler);
                }
            }
        }

        public EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f6926c = copyOnWriteArrayList;
            this.f6924a = i2;
            this.f6925b = mediaPeriodId;
        }
    }

    default void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    default void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
    }

    default void K(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
    }

    default void S(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    default void Z(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
    }
}
