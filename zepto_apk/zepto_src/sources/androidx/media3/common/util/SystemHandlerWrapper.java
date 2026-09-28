package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.util.HandlerWrapper;
import java.util.ArrayList;

/* loaded from: classes3.dex */
final class SystemHandlerWrapper implements HandlerWrapper {

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f5733b = new ArrayList(50);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f5734a;

    public static final class SystemMessage implements HandlerWrapper.Message {

        /* renamed from: a, reason: collision with root package name */
        public Message f5735a;

        @Override // androidx.media3.common.util.HandlerWrapper.Message
        public final void a() {
            Message message = this.f5735a;
            message.getClass();
            message.sendToTarget();
            b();
        }

        public final void b() {
            this.f5735a = null;
            ArrayList arrayList = SystemHandlerWrapper.f5733b;
            synchronized (arrayList) {
                if (arrayList.size() < 50) {
                    arrayList.add(this);
                }
            }
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.f5734a = handler;
    }

    public static SystemMessage m() {
        SystemMessage systemMessage;
        ArrayList arrayList = f5733b;
        synchronized (arrayList) {
            try {
                systemMessage = arrayList.isEmpty() ? new SystemMessage() : (SystemMessage) arrayList.remove(arrayList.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return systemMessage;
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final boolean a() {
        return this.f5734a.hasMessages(1);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final HandlerWrapper.Message b(Object obj, int i2, int i3, int i4) {
        SystemMessage systemMessageM = m();
        systemMessageM.f5735a = this.f5734a.obtainMessage(i2, i3, i4, obj);
        return systemMessageM;
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final HandlerWrapper.Message c(int i2) {
        SystemMessage systemMessageM = m();
        systemMessageM.f5735a = this.f5734a.obtainMessage(i2);
        return systemMessageM;
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final void d() {
        this.f5734a.removeCallbacksAndMessages(null);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final HandlerWrapper.Message e(int i2, Object obj) {
        SystemMessage systemMessageM = m();
        systemMessageM.f5735a = this.f5734a.obtainMessage(i2, obj);
        return systemMessageM;
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final Looper f() {
        return this.f5734a.getLooper();
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final HandlerWrapper.Message g(int i2, int i3, int i4) {
        SystemMessage systemMessageM = m();
        systemMessageM.f5735a = this.f5734a.obtainMessage(i2, i3, i4);
        return systemMessageM;
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final boolean h(HandlerWrapper.Message message) {
        SystemMessage systemMessage = (SystemMessage) message;
        Message message2 = systemMessage.f5735a;
        message2.getClass();
        boolean zSendMessageAtFrontOfQueue = this.f5734a.sendMessageAtFrontOfQueue(message2);
        systemMessage.b();
        return zSendMessageAtFrontOfQueue;
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final boolean i(Runnable runnable) {
        return this.f5734a.post(runnable);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final boolean j(long j2) {
        return this.f5734a.sendEmptyMessageAtTime(2, j2);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final boolean k(int i2) {
        return this.f5734a.sendEmptyMessage(i2);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public final void l(int i2) {
        Assertions.a(i2 != 0);
        this.f5734a.removeMessages(i2);
    }
}
