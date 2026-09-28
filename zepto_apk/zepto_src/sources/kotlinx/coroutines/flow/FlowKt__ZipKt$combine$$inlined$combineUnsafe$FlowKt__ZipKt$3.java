package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.xbill.DNS.Type;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3 implements Flow<Object> {

    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", l = {Type.DOA, Type.AVC}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2, reason: invalid class name */
    public final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f54852a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ FlowCollector f54853b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object[] f54854c;

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(3, (Continuation) obj3);
            anonymousClass2.f54853b = (FlowCollector) obj;
            anonymousClass2.f54854c = (Object[]) obj2;
            return anonymousClass2.invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f54852a;
            if (i2 != 0) {
                if (i2 == 1) {
                    FlowCollector flowCollector = this.f54853b;
                    ResultKt.b(obj);
                    this.f54853b = null;
                    this.f54852a = 2;
                    if (flowCollector.a(obj, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f53572a;
            }
            ResultKt.b(obj);
            FlowCollector flowCollector2 = this.f54853b;
            Object[] objArr = this.f54854c;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            Object obj4 = objArr[2];
            Object obj5 = objArr[3];
            Object obj6 = objArr[4];
            this.f54853b = flowCollector2;
            this.f54852a = 1;
            throw null;
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        Object objA = CombineKt.a(continuation, FlowKt__ZipKt$nullArrayFactory$1.f54876a, new AnonymousClass2(3, null), flowCollector, null);
        return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
    }
}
