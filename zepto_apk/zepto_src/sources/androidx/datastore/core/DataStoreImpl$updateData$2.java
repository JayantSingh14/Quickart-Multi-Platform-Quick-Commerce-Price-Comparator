package androidx.datastore.core;

import androidx.datastore.core.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$updateData$2", f = "DataStoreImpl.kt", l = {169}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DataStoreImpl$updateData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f3522a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3523b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3524c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f3525d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DataStoreImpl$updateData$2(DataStoreImpl dataStoreImpl, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f3524c = dataStoreImpl;
        this.f3525d = (SuspendLambda) function2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataStoreImpl$updateData$2 dataStoreImpl$updateData$2 = new DataStoreImpl$updateData$2(this.f3524c, this.f3525d, continuation);
        dataStoreImpl$updateData$2.f3523b = obj;
        return dataStoreImpl$updateData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DataStoreImpl$updateData$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f3522a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f3523b;
        CompletableDeferred completableDeferredA = CompletableDeferredKt.a();
        DataStoreImpl dataStoreImpl = this.f3524c;
        Message.Update update = new Message.Update(this.f3525d, completableDeferredA, dataStoreImpl.f3403h.a(), coroutineScope.r());
        SimpleActor simpleActor = dataStoreImpl.f3407l;
        Object objI = simpleActor.f3616c.i(update);
        if (objI instanceof ChannelResult.Closed) {
            Throwable thA = ChannelResult.a(objI);
            if (thA == null) {
                throw new ClosedSendChannelException("Channel was closed normally");
            }
            throw thA;
        }
        ChannelResult.Failed failed = ChannelResult.f54254b;
        if (objI instanceof ChannelResult.Failed) {
            throw new IllegalStateException("Check failed.");
        }
        if (simpleActor.f3617d.f3377a.getAndIncrement() == 0) {
            BuildersKt.c(simpleActor.f3614a, null, new SimpleActor$offer$2(simpleActor, null), 3);
        }
        this.f3522a = 1;
        Object objV = completableDeferredA.V(this);
        return objV == coroutineSingletons ? coroutineSingletons : objV;
    }
}
