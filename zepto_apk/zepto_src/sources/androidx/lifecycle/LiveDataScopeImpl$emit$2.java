package androidx.lifecycle;

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
@DebugMetadata(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", l = {99}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class LiveDataScopeImpl$emit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f4848a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveDataScopeImpl f4849b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4850c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveDataScopeImpl$emit$2(LiveDataScopeImpl liveDataScopeImpl, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f4849b = liveDataScopeImpl;
        this.f4850c = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LiveDataScopeImpl$emit$2(this.f4849b, this.f4850c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((LiveDataScopeImpl$emit$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f4848a;
        LiveDataScopeImpl liveDataScopeImpl = this.f4849b;
        if (i2 == 0) {
            ResultKt.b(obj);
            liveDataScopeImpl.getClass();
            this.f4848a = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        liveDataScopeImpl.getClass();
        throw null;
    }
}
