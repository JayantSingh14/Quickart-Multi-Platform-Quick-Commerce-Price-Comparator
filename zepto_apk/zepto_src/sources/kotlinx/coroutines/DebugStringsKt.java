package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DebugStringsKt {
    public static final String a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String b(Continuation continuation) {
        Object objA;
        if (continuation instanceof DispatchedContinuation) {
            return ((DispatchedContinuation) continuation).toString();
        }
        try {
            Result.Companion companion = Result.f53538b;
            objA = continuation + '@' + a(continuation);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        if (Result.a(objA) != null) {
            objA = continuation.getClass().getName() + '@' + a(continuation);
        }
        return (String) objA;
    }
}
