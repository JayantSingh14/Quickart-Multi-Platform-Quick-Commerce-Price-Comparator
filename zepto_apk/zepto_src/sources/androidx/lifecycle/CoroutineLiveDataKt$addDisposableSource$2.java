package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class CoroutineLiveDataKt$addDisposableSource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EmittedSource>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoroutineLiveData f4784a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveData f4785b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveDataKt$addDisposableSource$2(CoroutineLiveData coroutineLiveData, LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.f4784a = coroutineLiveData;
        this.f4785b = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CoroutineLiveDataKt$addDisposableSource$2(this.f4784a, this.f4785b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((CoroutineLiveDataKt$addDisposableSource$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        final CoroutineLiveData coroutineLiveData = this.f4784a;
        CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0 coroutineLiveDataKt$sam$androidx_lifecycle_Observer$0 = new CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(new Function1<Object, Unit>() { // from class: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                coroutineLiveData.k(obj2);
                return Unit.f53572a;
            }
        });
        LiveData liveData = this.f4785b;
        coroutineLiveData.l(liveData, coroutineLiveDataKt$sam$androidx_lifecycle_Observer$0);
        return new EmittedSource(liveData, coroutineLiveData);
    }
}
