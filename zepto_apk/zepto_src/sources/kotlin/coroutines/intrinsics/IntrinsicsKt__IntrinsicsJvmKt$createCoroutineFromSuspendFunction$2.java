package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes3.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f53703a;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i2 = this.f53703a;
        if (i2 == 0) {
            this.f53703a = 1;
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("This coroutine had already completed");
        }
        this.f53703a = 2;
        ResultKt.b(obj);
        return obj;
    }
}
