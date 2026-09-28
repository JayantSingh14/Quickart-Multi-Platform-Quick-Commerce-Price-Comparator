package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ChannelSegment<E> extends Segment<ChannelSegment<E>> {

    /* renamed from: e, reason: collision with root package name */
    public final BufferedChannel f54257e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f54258f;

    public ChannelSegment(long j2, ChannelSegment channelSegment, BufferedChannel bufferedChannel, int i2) {
        super(j2, channelSegment, i2);
        this.f54257e = bufferedChannel;
        this.f54258f = new AtomicReferenceArray(BufferedChannelKt.f54236b * 2);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final int g() {
        return BufferedChannelKt.f54236b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        n(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        kotlin.jvm.internal.Intrinsics.c(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.Segment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r5, kotlin.coroutines.CoroutineContext r6) {
        /*
            r4 = this;
            int r6 = kotlinx.coroutines.channels.BufferedChannelKt.f54236b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            java.util.concurrent.atomic.AtomicReferenceArray r6 = r4.f54258f
            int r1 = r5 * 2
            r6.get(r1)
        L11:
            java.lang.Object r6 = r4.l(r5)
            boolean r1 = r6 instanceof kotlinx.coroutines.Waiter
            kotlinx.coroutines.channels.BufferedChannel r2 = r4.f54257e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r1 == 0) goto L21
            goto L62
        L21:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.f54244j
            if (r6 == r1) goto L59
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.f54245k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.f54241g
            if (r6 == r1) goto L11
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.f54240f
            if (r6 != r1) goto L33
            goto L11
        L33:
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.BufferedChannelKt.f54243i
            if (r6 == r5) goto L7c
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.BufferedChannelKt.f54238d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.BufferedChannelKt.f54246l
            if (r6 != r5) goto L41
            goto L7c
        L41:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected state: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L59:
            r4.n(r5, r3)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.Intrinsics.c(r2)
            return
        L62:
            if (r0 == 0) goto L67
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.f54244j
            goto L69
        L67:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.f54245k
        L69:
            boolean r6 = r4.k(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.n(r5, r3)
            r6 = r0 ^ 1
            r4.m(r5, r6)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.Intrinsics.c(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelSegment.h(int, kotlin.coroutines.CoroutineContext):void");
    }

    public final boolean k(int i2, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.f54258f;
        int i3 = (i2 * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(i3, obj, obj2)) {
            if (atomicReferenceArray.get(i3) != obj) {
                return false;
            }
        }
        return true;
    }

    public final Object l(int i2) {
        return this.f54258f.get((i2 * 2) + 1);
    }

    public final void m(int i2, boolean z) {
        if (z) {
            BufferedChannel bufferedChannel = this.f54257e;
            Intrinsics.c(bufferedChannel);
            bufferedChannel.V((this.f55105c * BufferedChannelKt.f54236b) + i2);
        }
        i();
    }

    public final void n(int i2, Object obj) {
        this.f54258f.set(i2 * 2, obj);
    }

    public final void o(int i2, Symbol symbol) {
        this.f54258f.set((i2 * 2) + 1, symbol);
    }
}
