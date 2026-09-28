package kotlinx.coroutines.flow.internal;

import androidx.fragment.app.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;

@InternalCoroutinesApi
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class ChannelFlow<T> implements FusibleFlow<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f54942a;

    /* renamed from: b, reason: collision with root package name */
    public final int f54943b;

    /* renamed from: c, reason: collision with root package name */
    public final BufferOverflow f54944c;

    public ChannelFlow(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        this.f54942a = coroutineContext;
        this.f54943b = i2;
        this.f54944c = bufferOverflow;
    }

    public String a() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.flow.Flow b(kotlin.coroutines.CoroutineContext r5, int r6, kotlinx.coroutines.channels.BufferOverflow r7) {
        /*
            r4 = this;
            kotlin.coroutines.CoroutineContext r0 = r4.f54942a
            kotlin.coroutines.CoroutineContext r5 = r5.plus(r0)
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.f54203a
            kotlinx.coroutines.channels.BufferOverflow r2 = r4.f54944c
            int r3 = r4.f54943b
            if (r7 == r1) goto Lf
            goto L26
        Lf:
            r7 = -3
            if (r3 != r7) goto L13
            goto L25
        L13:
            if (r6 != r7) goto L17
        L15:
            r6 = r3
            goto L25
        L17:
            r7 = -2
            if (r3 != r7) goto L1b
            goto L25
        L1b:
            if (r6 != r7) goto L1e
            goto L15
        L1e:
            int r6 = r6 + r3
            if (r6 < 0) goto L22
            goto L25
        L22:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L25:
            r7 = r2
        L26:
            boolean r0 = kotlin.jvm.internal.Intrinsics.b(r5, r0)
            if (r0 == 0) goto L31
            if (r6 != r3) goto L31
            if (r7 != r2) goto L31
            return r4
        L31:
            kotlinx.coroutines.flow.internal.ChannelFlow r5 = r4.f(r5, r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlow.b(kotlin.coroutines.CoroutineContext, int, kotlinx.coroutines.channels.BufferOverflow):kotlinx.coroutines.flow.Flow");
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object c(FlowCollector flowCollector, Continuation continuation) {
        Object objC = CoroutineScopeKt.c(new ChannelFlow$collect$2(flowCollector, this, null), continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }

    public abstract Object d(ProducerScope producerScope, Continuation continuation);

    public abstract ChannelFlow f(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow);

    public ReceiveChannel g(CoroutineScope coroutineScope) {
        int i2 = this.f54943b;
        if (i2 == -3) {
            i2 = -2;
        }
        CoroutineStart coroutineStart = CoroutineStart.f54080c;
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this, null);
        return ProduceKt.b(coroutineScope, this.f54942a, i2, this.f54944c, coroutineStart, channelFlow$collectToFun$1);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strA = a();
        if (strA != null) {
            arrayList.add(strA);
        }
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f53685a;
        CoroutineContext coroutineContext = this.f54942a;
        if (coroutineContext != emptyCoroutineContext) {
            arrayList.add("context=" + coroutineContext);
        }
        int i2 = this.f54943b;
        if (i2 != -3) {
            arrayList.add("capacity=" + i2);
        }
        BufferOverflow bufferOverflow = BufferOverflow.f54203a;
        BufferOverflow bufferOverflow2 = this.f54944c;
        if (bufferOverflow2 != bufferOverflow) {
            arrayList.add("onBufferOverflow=" + bufferOverflow2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return e.t(sb, CollectionsKt.E(arrayList, ", ", null, null, null, 62), ']');
    }
}
