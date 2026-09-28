package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {759}, m = "receiveCatching-JP2dKIU$suspendImpl")
/* loaded from: classes.dex */
final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54229a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel f54230b;

    /* renamed from: c, reason: collision with root package name */
    public int f54231c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel bufferedChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f54230b = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f54229a = obj;
        this.f54231c |= Integer.MIN_VALUE;
        Object objL = BufferedChannel.L(this.f54230b, this);
        return objL == CoroutineSingletons.f53689a ? objL : new ChannelResult(objL);
    }
}
