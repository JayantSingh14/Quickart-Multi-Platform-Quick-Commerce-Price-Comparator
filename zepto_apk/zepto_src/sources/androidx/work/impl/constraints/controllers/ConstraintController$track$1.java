package androidx.work.impl.constraints.controllers;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.ConstraintTrackerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata
@DebugMetadata(c = "androidx.work.impl.constraints.controllers.ConstraintController$track$1", f = "ContraintControllers.kt", l = {55}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ConstraintController$track$1 extends SuspendLambda implements Function2<ProducerScope<? super ConstraintsState>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f12818a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f12819b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ConstraintController f12820c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintController$track$1(ConstraintController constraintController, Continuation continuation) {
        super(2, continuation);
        this.f12820c = constraintController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ConstraintController$track$1 constraintController$track$1 = new ConstraintController$track$1(this.f12820c, continuation);
        constraintController$track$1.f12819b = obj;
        return constraintController$track$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ConstraintController$track$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.work.impl.constraints.controllers.ConstraintController$track$1$listener$1, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f12818a;
        if (i2 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f12819b;
            final ConstraintController constraintController = this.f12820c;
            final ?? listener = new ConstraintListener<Object>() { // from class: androidx.work.impl.constraints.controllers.ConstraintController$track$1$listener$1
                @Override // androidx.work.impl.constraints.ConstraintListener
                public final void a(Object obj2) {
                    ConstraintController constraintController2 = constraintController;
                    producerScope.b().i(constraintController2.c(obj2) ? new ConstraintsState.ConstraintsNotMet(constraintController2.a()) : ConstraintsState.ConstraintsMet.f12795a);
                }
            };
            ConstraintTracker constraintTracker = constraintController.f12817a;
            constraintTracker.getClass();
            Intrinsics.checkNotNullParameter(listener, "listener");
            synchronized (constraintTracker.f12838c) {
                try {
                    if (constraintTracker.f12839d.add(listener)) {
                        if (constraintTracker.f12839d.size() == 1) {
                            constraintTracker.f12840e = constraintTracker.a();
                            Logger.e().a(ConstraintTrackerKt.f12841a, constraintTracker.getClass().getSimpleName() + ": initial state = " + constraintTracker.f12840e);
                            constraintTracker.c();
                        }
                        listener.a(constraintTracker.f12840e);
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            final ConstraintController constraintController2 = this.f12820c;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.work.impl.constraints.controllers.ConstraintController$track$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    ConstraintTracker constraintTracker2 = constraintController2.f12817a;
                    ConstraintController$track$1$listener$1 listener2 = listener;
                    constraintTracker2.getClass();
                    Intrinsics.checkNotNullParameter(listener2, "listener");
                    synchronized (constraintTracker2.f12838c) {
                        if (constraintTracker2.f12839d.remove(listener2) && constraintTracker2.f12839d.isEmpty()) {
                            constraintTracker2.d();
                        }
                    }
                    return Unit.f53572a;
                }
            };
            this.f12818a = 1;
            if (ProduceKt.a(producerScope, function0, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
