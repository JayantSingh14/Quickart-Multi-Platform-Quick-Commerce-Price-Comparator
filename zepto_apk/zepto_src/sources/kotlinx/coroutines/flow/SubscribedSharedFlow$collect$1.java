package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", l = {408}, m = "collect")
/* loaded from: classes3.dex */
final class SubscribedSharedFlow$collect$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54932a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SubscribedSharedFlow f54933b;

    /* renamed from: c, reason: collision with root package name */
    public int f54934c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscribedSharedFlow$collect$1(SubscribedSharedFlow subscribedSharedFlow, Continuation continuation) {
        super(continuation);
        this.f54933b = subscribedSharedFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54932a = obj;
        this.f54934c |= Integer.MIN_VALUE;
        this.f54933b.c(null, this);
        throw null;
    }
}
