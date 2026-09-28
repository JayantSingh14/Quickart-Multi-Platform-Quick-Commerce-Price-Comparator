package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DebugProbesImpl {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentWeakMap f54465a;

    /* renamed from: b, reason: collision with root package name */
    public static final Function1 f54466b;

    @Metadata
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public final CoroutineStackFrame getCallerFrame() {
            throw null;
        }

        @Override // kotlin.coroutines.Continuation
        public final CoroutineContext getContext() {
            throw null;
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object obj) {
            ConcurrentWeakMap concurrentWeakMap = DebugProbesImpl.f54465a;
            DebugProbesImpl.f54465a.remove(this);
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    static {
        Object objA;
        new ArtificialStackFrames();
        CoroutineDebuggingKt.a("_CREATION", new Exception());
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f54465a = new ConcurrentWeakMap(false);
        try {
            Result.Companion companion = Result.f53538b;
            Object objNewInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(null);
            Intrinsics.d(objNewInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            TypeIntrinsics.b(1, objNewInstance);
            objA = (Function1) objNewInstance;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        f54466b = (Function1) (objA instanceof Result.Failure ? null : objA);
        new ConcurrentWeakMap(true);
    }
}
