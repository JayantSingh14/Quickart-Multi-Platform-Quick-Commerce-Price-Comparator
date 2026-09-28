package androidx.work;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "androidx.work.OperationKt", f = "Operation.kt", l = {39}, m = "await")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class OperationKt$await$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12547a;

    /* renamed from: b, reason: collision with root package name */
    public int f12548b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12547a = obj;
        int i2 = (this.f12548b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f12548b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "result.await()");
        return obj;
    }
}
