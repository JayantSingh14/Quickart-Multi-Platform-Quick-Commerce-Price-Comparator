package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class EventLoop extends CoroutineDispatcher {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f54097e = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f54098b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f54099c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayDeque f54100d;

    public final void O1(boolean z) {
        long j2 = this.f54098b - (z ? 4294967296L : 1L);
        this.f54098b = j2;
        if (j2 <= 0 && this.f54099c) {
            shutdown();
        }
    }

    public final void S1(DispatchedTask dispatchedTask) {
        ArrayDeque arrayDeque = this.f54100d;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            this.f54100d = arrayDeque;
        }
        arrayDeque.addLast(dispatchedTask);
    }

    public final void T1(boolean z) {
        this.f54098b = (z ? 4294967296L : 1L) + this.f54098b;
        if (z) {
            return;
        }
        this.f54099c = true;
    }

    public long U1() {
        return !V1() ? Long.MAX_VALUE : 0L;
    }

    public final boolean V1() {
        ArrayDeque arrayDeque = this.f54100d;
        if (arrayDeque == null) {
            return false;
        }
        DispatchedTask dispatchedTask = (DispatchedTask) (arrayDeque.isEmpty() ? null : arrayDeque.removeFirst());
        if (dispatchedTask == null) {
            return false;
        }
        dispatchedTask.run();
        return true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher s1(int i2) {
        LimitedDispatcherKt.a(i2);
        return this;
    }

    public void shutdown() {
    }
}
