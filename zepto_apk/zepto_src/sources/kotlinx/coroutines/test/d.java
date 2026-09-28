package kotlinx.coroutines.test;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f55327a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f55328b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f55327a = i2;
        this.f55328b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ThreadSafeHeapNode threadSafeHeapNode;
        switch (this.f55327a) {
            case 0:
                ThreadSafeHeap threadSafeHeap = ((TestCoroutineScheduler) this.f55328b).f55304a;
                TestCoroutineScheduler$advanceUntilIdle$1$1 testCoroutineScheduler$advanceUntilIdle$1$1 = TestCoroutineScheduler$advanceUntilIdle$1$1.f55309c;
                synchronized (threadSafeHeap) {
                    try {
                        int i2 = ThreadSafeHeap.f55113b.get(threadSafeHeap);
                        int i3 = 0;
                        while (true) {
                            if (i3 < i2) {
                                ThreadSafeHeapNode[] threadSafeHeapNodeArr = threadSafeHeap.f55114a;
                                threadSafeHeapNode = threadSafeHeapNodeArr != null ? threadSafeHeapNodeArr[i3] : null;
                                Intrinsics.c(threadSafeHeapNode);
                                if (!((Boolean) testCoroutineScheduler$advanceUntilIdle$1$1.invoke(threadSafeHeapNode)).booleanValue()) {
                                    i3++;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return Boolean.valueOf(threadSafeHeapNode == null);
            default:
                return Boolean.valueOf(!(((Job) ((CoroutineScope) this.f55328b).r().get(Job.Key.f54121a)) != null ? r0.a() : true));
        }
    }
}
