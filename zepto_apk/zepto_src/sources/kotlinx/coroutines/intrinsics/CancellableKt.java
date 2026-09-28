package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CancellableKt {
    public static final void a(Continuation continuation, AbstractCoroutine abstractCoroutine) {
        try {
            Continuation continuationB = IntrinsicsKt.b(continuation);
            Result.Companion companion = Result.f53538b;
            DispatchedContinuationKt.a(Unit.f53572a, continuationB);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            abstractCoroutine.resumeWith(ResultKt.a(th));
            throw th;
        }
    }

    public static final void b(Function2 function2, AbstractCoroutine abstractCoroutine, AbstractCoroutine abstractCoroutine2) {
        try {
            Continuation continuationB = IntrinsicsKt.b(IntrinsicsKt.a(abstractCoroutine, abstractCoroutine2, function2));
            Result.Companion companion = Result.f53538b;
            DispatchedContinuationKt.a(Unit.f53572a, continuationB);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            abstractCoroutine2.resumeWith(ResultKt.a(th));
            throw th;
        }
    }
}
