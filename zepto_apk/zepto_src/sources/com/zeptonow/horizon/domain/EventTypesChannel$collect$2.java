package com.zeptonow.horizon.domain;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventTypesChannel$collect$2", f = "EventTypesChannel.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class EventTypesChannel$collect$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f48051a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventTypesChannel f48052b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f48053c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EventTypesChannel$collect$2(EventTypesChannel eventTypesChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f48052b = eventTypesChannel;
        this.f48053c = (SuspendLambda) function2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        EventTypesChannel$collect$2 eventTypesChannel$collect$2 = new EventTypesChannel$collect$2(this.f48052b, this.f48053c, continuation);
        eventTypesChannel$collect$2.f48051a = obj;
        return eventTypesChannel$collect$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventTypesChannel$collect$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f48051a;
        EventTypesChannel eventTypesChannel = this.f48052b;
        Iterator it = eventTypesChannel.f48050b.values().iterator();
        while (it.hasNext()) {
            BuildersKt.c(coroutineScope, null, new EventTypesChannel$collect$2$1$1((Channel) it.next(), eventTypesChannel, this.f48053c, null), 3);
        }
        return Unit.f53572a;
    }
}
