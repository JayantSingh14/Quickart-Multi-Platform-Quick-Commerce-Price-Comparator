package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ChannelFlowKt {
    public static final Object a(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation frame) {
        Object objInvoke;
        Object objC = ThreadContextKt.c(coroutineContext, obj2);
        try {
            StackFrameContinuation stackFrameContinuation = new StackFrameContinuation(frame, coroutineContext);
            if (function2 == null) {
                objInvoke = IntrinsicsKt.c(function2, obj, stackFrameContinuation);
            } else {
                TypeIntrinsics.b(2, function2);
                objInvoke = function2.invoke(obj, stackFrameContinuation);
            }
            ThreadContextKt.a(coroutineContext, objC);
            if (objInvoke == CoroutineSingletons.f53689a) {
                Intrinsics.checkNotNullParameter(frame, "frame");
            }
            return objInvoke;
        } catch (Throwable th) {
            ThreadContextKt.a(coroutineContext, objC);
            throw th;
        }
    }
}
