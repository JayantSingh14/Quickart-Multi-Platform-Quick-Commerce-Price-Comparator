package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

@Metadata
/* loaded from: classes3.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1 extends RestrictedContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f53702a;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i2 = this.f53702a;
        if (i2 == 0) {
            this.f53702a = 1;
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("This coroutine had already completed");
        }
        this.f53702a = 2;
        ResultKt.b(obj);
        return obj;
    }
}
