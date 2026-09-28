package com.zeptonow.horizon;

import com.zeptonow.horizon.di.DependencyContainer;
import com.zeptonow.horizon.domain.EventManager;
import defpackage.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.HorizonSDK$init$1", f = "HorizonSDK.kt", l = {43}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class HorizonSDK$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47837a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f47838b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonSDK$init$1(b bVar, Continuation continuation) {
        super(2, continuation);
        this.f47838b = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HorizonSDK$init$1(this.f47838b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HorizonSDK$init$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EventManager eventManager;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47837a;
        if (i2 == 0) {
            ResultKt.b(obj);
            DependencyContainer dependencyContainer = HorizonSDK.f47830a;
            if (dependencyContainer != null && (eventManager = (EventManager) dependencyContainer.o.getValue()) != null) {
                eventManager.b();
            }
            DependencyContainer dependencyContainer2 = HorizonSDK.f47830a;
            this.f47837a = 1;
            if (HorizonSDK.a(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f47838b.invoke();
        return Unit.f53572a;
    }
}
