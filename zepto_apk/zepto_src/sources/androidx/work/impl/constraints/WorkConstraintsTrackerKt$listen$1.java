package androidx.work.impl.constraints;

import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata
@DebugMetadata(c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", f = "WorkConstraintsTracker.kt", l = {54}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class WorkConstraintsTrackerKt$listen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f12809a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WorkConstraintsTracker f12810b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WorkSpec f12811c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OnConstraintsStateChangedListener f12812d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTrackerKt$listen$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, Continuation continuation) {
        super(2, continuation);
        this.f12810b = workConstraintsTracker;
        this.f12811c = workSpec;
        this.f12812d = onConstraintsStateChangedListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WorkConstraintsTrackerKt$listen$1(this.f12810b, this.f12811c, this.f12812d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((WorkConstraintsTrackerKt$listen$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f12809a;
        if (i2 == 0) {
            ResultKt.b(obj);
            WorkConstraintsTracker workConstraintsTracker = this.f12810b;
            workConstraintsTracker.getClass();
            final WorkSpec spec = this.f12811c;
            Intrinsics.checkNotNullParameter(spec, "spec");
            List list = workConstraintsTracker.f12801a;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (((ConstraintController) obj2).b(spec)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ConstraintController) it.next()).d());
            }
            final Flow[] flowArr = (Flow[]) CollectionsKt.e0(arrayList2).toArray(new Flow[0]);
            Flow flowE = FlowKt.e(new Flow<ConstraintsState>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1

                @Metadata
                @DebugMetadata(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", l = {292}, m = "invokeSuspend")
                @SourceDebugExtension
                /* renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3, reason: invalid class name */
                public final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super ConstraintsState>, ConstraintsState[], Continuation<? super Unit>, Object> {

                    /* renamed from: a, reason: collision with root package name */
                    public int f12804a;

                    /* renamed from: b, reason: collision with root package name */
                    public /* synthetic */ FlowCollector f12805b;

                    /* renamed from: c, reason: collision with root package name */
                    public /* synthetic */ Object[] f12806c;

                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(3, (Continuation) obj3);
                        anonymousClass3.f12805b = (FlowCollector) obj;
                        anonymousClass3.f12806c = (Object[]) obj2;
                        return anonymousClass3.invokeSuspend(Unit.f53572a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        ConstraintsState constraintsState;
                        ConstraintsState constraintsState2;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
                        int i2 = this.f12804a;
                        if (i2 == 0) {
                            ResultKt.b(obj);
                            FlowCollector flowCollector = this.f12805b;
                            ConstraintsState[] constraintsStateArr = (ConstraintsState[]) this.f12806c;
                            int length = constraintsStateArr.length;
                            int i3 = 0;
                            while (true) {
                                constraintsState = ConstraintsState.ConstraintsMet.f12795a;
                                if (i3 >= length) {
                                    constraintsState2 = null;
                                    break;
                                }
                                constraintsState2 = constraintsStateArr[i3];
                                if (!Intrinsics.b(constraintsState2, constraintsState)) {
                                    break;
                                }
                                i3++;
                            }
                            if (constraintsState2 != null) {
                                constraintsState = constraintsState2;
                            }
                            this.f12804a = 1;
                            if (flowCollector.a(constraintsState, this) == coroutineSingletons) {
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

                @Override // kotlinx.coroutines.flow.Flow
                public final Object c(FlowCollector flowCollector, Continuation continuation) {
                    final Flow[] flowArr2 = flowArr;
                    Object objA = CombineKt.a(continuation, new Function0<ConstraintsState[]>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return new ConstraintsState[flowArr2.length];
                        }
                    }, new AnonymousClass3(3, null), flowCollector, flowArr2);
                    return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
                }
            });
            final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.f12812d;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object a(Object obj3, Continuation continuation) {
                    WorkSpec workSpec = spec;
                    onConstraintsStateChangedListener.e(workSpec, (ConstraintsState) obj3);
                    return Unit.f53572a;
                }
            };
            this.f12809a = 1;
            if (flowE.c(flowCollector, this) == coroutineSingletons) {
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
