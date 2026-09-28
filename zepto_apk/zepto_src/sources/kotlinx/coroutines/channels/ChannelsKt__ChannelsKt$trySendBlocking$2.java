package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelResult<? extends Unit>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f54260a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54261b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SendChannel f54262c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f54263d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__ChannelsKt$trySendBlocking$2(SendChannel sendChannel, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f54262c = sendChannel;
        this.f54263d = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.f54262c, this.f54263d, continuation);
        channelsKt__ChannelsKt$trySendBlocking$2.f54261b = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        Object objA2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f54260a;
        try {
            if (i2 == 0) {
                ResultKt.b(obj);
                SendChannel sendChannel = this.f54262c;
                Object obj2 = this.f54263d;
                Result.Companion companion = Result.f53538b;
                this.f54260a = 1;
                if (sendChannel.o(obj2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            objA = Unit.f53572a;
            Result.Companion companion2 = Result.f53538b;
        } catch (Throwable th) {
            Result.Companion companion3 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        if (objA instanceof Result.Failure) {
            ChannelResult.Failed failed = ChannelResult.f54254b;
            objA2 = ChannelResult.Companion.a(Result.a(objA));
        } else {
            ChannelResult.Failed failed2 = ChannelResult.f54254b;
            objA2 = Unit.f53572a;
        }
        return new ChannelResult(objA2);
    }
}
