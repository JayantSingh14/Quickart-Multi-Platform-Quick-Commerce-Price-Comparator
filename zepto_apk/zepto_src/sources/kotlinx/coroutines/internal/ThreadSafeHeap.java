package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@InternalCoroutinesApi
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f55113b = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public ThreadSafeHeapNode[] f55114a;

    public final void a(ThreadSafeHeapNode threadSafeHeapNode) {
        threadSafeHeapNode.a(this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f55114a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f55113b;
        if (threadSafeHeapNodeArr == null) {
            threadSafeHeapNodeArr = new ThreadSafeHeapNode[4];
            this.f55114a = threadSafeHeapNodeArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= threadSafeHeapNodeArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(threadSafeHeapNodeArr, atomicIntegerFieldUpdater.get(this) * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            threadSafeHeapNodeArr = (ThreadSafeHeapNode[]) objArrCopyOf;
            this.f55114a = threadSafeHeapNodeArr;
        }
        int i2 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i2 + 1);
        threadSafeHeapNodeArr[i2] = threadSafeHeapNode;
        threadSafeHeapNode.c(i2);
        c(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.ThreadSafeHeapNode b(int r9) {
        /*
            r8 = this;
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r0 = r8.f55114a
            kotlin.jvm.internal.Intrinsics.c(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = kotlinx.coroutines.internal.ThreadSafeHeap.f55113b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L80
            int r2 = r1.get(r8)
            r8.d(r9, r2)
            int r2 = r9 + (-1)
            int r2 = r2 / 2
            if (r9 <= 0) goto L3c
            r4 = r0[r9]
            kotlin.jvm.internal.Intrinsics.c(r4)
            java.lang.Comparable r4 = (java.lang.Comparable) r4
            r5 = r0[r2]
            kotlin.jvm.internal.Intrinsics.c(r5)
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L3c
            r8.d(r9, r2)
            r8.c(r2)
            goto L80
        L3c:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L47
            goto L80
        L47:
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r5 = r8.f55114a
            kotlin.jvm.internal.Intrinsics.c(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L67
            r6 = r5[r2]
            kotlin.jvm.internal.Intrinsics.c(r6)
            java.lang.Comparable r6 = (java.lang.Comparable) r6
            r7 = r5[r4]
            kotlin.jvm.internal.Intrinsics.c(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L67
            goto L68
        L67:
            r2 = r4
        L68:
            r4 = r5[r9]
            kotlin.jvm.internal.Intrinsics.c(r4)
            java.lang.Comparable r4 = (java.lang.Comparable) r4
            r5 = r5[r2]
            kotlin.jvm.internal.Intrinsics.c(r5)
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L7b
            goto L80
        L7b:
            r8.d(r9, r2)
            r9 = r2
            goto L3c
        L80:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            kotlin.jvm.internal.Intrinsics.c(r9)
            r2 = 0
            r9.a(r2)
            r9.c(r3)
            int r1 = r1.get(r8)
            r0[r1] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.b(int):kotlinx.coroutines.internal.ThreadSafeHeapNode");
    }

    public final void c(int i2) {
        while (i2 > 0) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f55114a;
            Intrinsics.c(threadSafeHeapNodeArr);
            int i3 = (i2 - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i3];
            Intrinsics.c(threadSafeHeapNode);
            ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i2];
            Intrinsics.c(threadSafeHeapNode2);
            if (((Comparable) threadSafeHeapNode).compareTo(threadSafeHeapNode2) <= 0) {
                return;
            }
            d(i2, i3);
            i2 = i3;
        }
    }

    public final void d(int i2, int i3) {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f55114a;
        Intrinsics.c(threadSafeHeapNodeArr);
        ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i3];
        Intrinsics.c(threadSafeHeapNode);
        ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i2];
        Intrinsics.c(threadSafeHeapNode2);
        threadSafeHeapNodeArr[i2] = threadSafeHeapNode;
        threadSafeHeapNodeArr[i3] = threadSafeHeapNode2;
        threadSafeHeapNode.c(i2);
        threadSafeHeapNode2.c(i3);
    }
}
