package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
/* loaded from: classes.dex */
public interface BandwidthMeter {

    public interface EventListener {

        public static final class EventDispatcher {

            /* renamed from: a, reason: collision with root package name */
            public final CopyOnWriteArrayList f8061a = new CopyOnWriteArrayList();

            /* loaded from: classes3.dex */
            public static final class HandlerAndListener {

                /* renamed from: a, reason: collision with root package name */
                public final Handler f8062a;

                /* renamed from: b, reason: collision with root package name */
                public final EventListener f8063b;

                /* renamed from: c, reason: collision with root package name */
                public boolean f8064c;

                public HandlerAndListener(Handler handler, EventListener eventListener) {
                    this.f8062a = handler;
                    this.f8063b = eventListener;
                }

                public final void d() {
                    this.f8064c = true;
                }
            }

            public final void a(EventListener eventListener) {
                CopyOnWriteArrayList copyOnWriteArrayList = this.f8061a;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    HandlerAndListener handlerAndListener = (HandlerAndListener) it.next();
                    if (handlerAndListener.f8063b == eventListener) {
                        handlerAndListener.d();
                        copyOnWriteArrayList.remove(handlerAndListener);
                    }
                }
            }
        }

        void z(long j2, long j3, int i2);
    }

    void a(EventListener eventListener);

    default long b() {
        return -9223372036854775807L;
    }

    void d(Handler handler, EventListener eventListener);

    TransferListener e();

    long f();
}
