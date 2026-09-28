package androidx.media3.common.util;

import android.os.Looper;

@UnstableApi
/* loaded from: classes3.dex */
public interface HandlerWrapper {

    public interface Message {
        void a();
    }

    boolean a();

    Message b(Object obj, int i2, int i3, int i4);

    Message c(int i2);

    void d();

    Message e(int i2, Object obj);

    Looper f();

    Message g(int i2, int i3, int i4);

    boolean h(Message message);

    boolean i(Runnable runnable);

    boolean j(long j2);

    boolean k(int i2);

    void l(int i2);
}
