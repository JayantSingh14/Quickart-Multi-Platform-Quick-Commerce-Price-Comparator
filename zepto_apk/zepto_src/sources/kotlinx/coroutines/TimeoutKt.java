package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class TimeoutKt {
    public static final Object a(TimeoutCoroutine timeoutCoroutine, Function2 function2) throws Throwable {
        Object completedExceptionally;
        Object objA0;
        JobKt.f(timeoutCoroutine, new DisposeOnCompletion(DelayKt.b(timeoutCoroutine.f55103d.getContext()).b(timeoutCoroutine.f54165e, timeoutCoroutine, timeoutCoroutine.f54036c)));
        try {
            if (function2 == null) {
                completedExceptionally = IntrinsicsKt.c(function2, timeoutCoroutine, timeoutCoroutine);
            } else {
                TypeIntrinsics.b(2, function2);
                completedExceptionally = function2.invoke(timeoutCoroutine, timeoutCoroutine);
            }
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(false, th);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (completedExceptionally == coroutineSingletons || (objA0 = timeoutCoroutine.a0(completedExceptionally)) == JobSupportKt.f54147b) {
            return coroutineSingletons;
        }
        if (objA0 instanceof CompletedExceptionally) {
            Throwable th2 = ((CompletedExceptionally) objA0).f54073a;
            if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).f54164a != timeoutCoroutine) {
                throw th2;
            }
            if (completedExceptionally instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) completedExceptionally).f54073a;
            }
        } else {
            completedExceptionally = JobSupportKt.a(objA0);
        }
        return completedExceptionally;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(long r6, kotlin.jvm.functions.Function2 r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.f54169d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54169d = r1
            goto L18
        L13:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f54168c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54169d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.internal.Ref$ObjectRef r6 = r0.f54167b
            kotlin.ResultKt.b(r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L29
            return r9
        L29:
            r7 = move-exception
            goto L67
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.b(r9)
            r4 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 > 0) goto L3d
            goto L6d
        L3d:
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            r0.f54166a = r8     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L65
            r0.f54167b = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L65
            r0.f54169d = r3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L65
            kotlinx.coroutines.TimeoutCoroutine r2 = new kotlinx.coroutines.TimeoutCoroutine     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L65
            r2.<init>(r6, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L65
            r9.f53801a = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L65
            java.lang.Object r6 = a(r2, r8)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L65
            if (r6 != r1) goto L61
            java.lang.String r7 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r7)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L5d
            goto L61
        L5b:
            r7 = r6
            goto L5f
        L5d:
            r6 = move-exception
            goto L5b
        L5f:
            r6 = r9
            goto L67
        L61:
            if (r6 != r1) goto L64
            return r1
        L64:
            return r6
        L65:
            r7 = move-exception
            goto L5f
        L67:
            kotlinx.coroutines.Job r8 = r7.f54164a
            java.lang.Object r6 = r6.f53801a
            if (r8 != r6) goto L6f
        L6d:
            r6 = 0
            return r6
        L6f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.b(long, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
