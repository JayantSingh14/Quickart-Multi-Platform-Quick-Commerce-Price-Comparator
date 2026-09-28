package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Unconfined;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.CoroutinesKt$launchChannel$job$1", f = "Coroutines.kt", l = {147}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class CoroutinesKt$launchChannel$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f51132a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51133b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f51134c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f51135d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CoroutineDispatcher f51136e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutinesKt$launchChannel$job$1(ByteBufferChannel byteBufferChannel, Function2 function2, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.f51134c = byteBufferChannel;
        this.f51135d = (SuspendLambda) function2;
        this.f51136e = coroutineDispatcher;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CoroutinesKt$launchChannel$job$1 coroutinesKt$launchChannel$job$1 = new CoroutinesKt$launchChannel$job$1(this.f51134c, this.f51135d, this.f51136e, continuation);
        coroutinesKt$launchChannel$job$1.f51133b = obj;
        return coroutinesKt$launchChannel$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((CoroutinesKt$launchChannel$job$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f51132a;
        ByteBufferChannel byteBufferChannel = this.f51134c;
        try {
            if (i2 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f51133b;
                CoroutineContext.Element element = coroutineScope.r().get(Job.Key.f54121a);
                Intrinsics.c(element);
                byteBufferChannel.P((Job) element);
                ChannelScope channelScope = new ChannelScope(coroutineScope, byteBufferChannel);
                ?? r6 = this.f51135d;
                this.f51132a = 1;
                if (r6.invoke(channelScope, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Throwable th) {
            Unconfined unconfined = Dispatchers.f54092b;
            CoroutineDispatcher coroutineDispatcher = this.f51136e;
            if (!Intrinsics.b(coroutineDispatcher, unconfined) && coroutineDispatcher != null) {
                throw th;
            }
            byteBufferChannel.d(th);
        }
        return Unit.f53572a;
    }
}
