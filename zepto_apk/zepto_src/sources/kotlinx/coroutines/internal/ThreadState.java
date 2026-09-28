package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata
/* loaded from: classes3.dex */
final class ThreadState {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f55115a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f55116b;

    /* renamed from: c, reason: collision with root package name */
    public final ThreadContextElement[] f55117c;

    /* renamed from: d, reason: collision with root package name */
    public int f55118d;

    public ThreadState(int i2, CoroutineContext coroutineContext) {
        this.f55115a = coroutineContext;
        this.f55116b = new Object[i2];
        this.f55117c = new ThreadContextElement[i2];
    }

    public final void a(ThreadContextElement threadContextElement, Object obj) {
        int i2 = this.f55118d;
        this.f55116b[i2] = obj;
        this.f55118d = i2 + 1;
        Intrinsics.d(threadContextElement, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        this.f55117c[i2] = threadContextElement;
    }

    public final void b(CoroutineContext coroutineContext) {
        ThreadContextElement[] threadContextElementArr = this.f55117c;
        int length = threadContextElementArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            ThreadContextElement threadContextElement = threadContextElementArr[length];
            Intrinsics.c(threadContextElement);
            threadContextElement.u0(this.f55116b[length]);
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }
}
