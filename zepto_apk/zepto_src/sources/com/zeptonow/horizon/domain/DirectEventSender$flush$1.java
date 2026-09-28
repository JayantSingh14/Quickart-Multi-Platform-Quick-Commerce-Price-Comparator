package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.EventType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.DirectEventSender$flush$1", f = "DirectEventSender.kt", l = {156}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class DirectEventSender$flush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public MutexImpl f47888a;

    /* renamed from: b, reason: collision with root package name */
    public DirectEventSender f47889b;

    /* renamed from: c, reason: collision with root package name */
    public int f47890c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DirectEventSender f47891d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectEventSender$flush$1(DirectEventSender directEventSender, Continuation continuation) {
        super(2, continuation);
        this.f47891d = directEventSender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DirectEventSender$flush$1(this.f47891d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DirectEventSender$flush$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutexImpl mutexImpl;
        DirectEventSender directEventSender;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47890c;
        if (i2 == 0) {
            ResultKt.b(obj);
            DirectEventSender directEventSender2 = this.f47891d;
            mutexImpl = directEventSender2.f47870d;
            this.f47888a = mutexImpl;
            this.f47889b = directEventSender2;
            this.f47890c = 1;
            if (mutexImpl.c(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            directEventSender = directEventSender2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            directEventSender = this.f47889b;
            mutexImpl = this.f47888a;
            ResultKt.b(obj);
        }
        try {
            Iterator it = CollectionsKt.e0(directEventSender.f47871e.keySet()).iterator();
            while (it.hasNext()) {
                directEventSender.b((EventType) it.next());
            }
            Unit unit = Unit.f53572a;
            mutexImpl.b(null);
            return Unit.f53572a;
        } catch (Throwable th) {
            mutexImpl.b(null);
            throw th;
        }
    }
}
