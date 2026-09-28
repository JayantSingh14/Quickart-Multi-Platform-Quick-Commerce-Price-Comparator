package kotlin;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DeepRecursiveKt {

    /* renamed from: a, reason: collision with root package name */
    public static final CoroutineSingletons f53514a;

    static {
        Result.Companion companion = Result.f53538b;
        f53514a = CoroutineSingletons.f53689a;
    }

    public static final Object a(DeepRecursiveFunction deepRecursiveFunction, Unit unit) {
        Object objInvoke;
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "<this>");
        Function3 block = deepRecursiveFunction.f53513a;
        Intrinsics.checkNotNullParameter(block, "block");
        DeepRecursiveScopeImpl deepRecursiveScopeImpl = new DeepRecursiveScopeImpl(null);
        deepRecursiveScopeImpl.f53515a = block;
        deepRecursiveScopeImpl.f53516b = unit;
        deepRecursiveScopeImpl.f53517c = deepRecursiveScopeImpl;
        CoroutineSingletons coroutineSingletons = f53514a;
        deepRecursiveScopeImpl.f53518d = coroutineSingletons;
        while (true) {
            Object obj = deepRecursiveScopeImpl.f53518d;
            Continuation completion = deepRecursiveScopeImpl.f53517c;
            if (completion == null) {
                ResultKt.b(obj);
                return obj;
            }
            Result.Companion companion = Result.f53538b;
            if (Intrinsics.b(coroutineSingletons, obj)) {
                try {
                    Function3 function3 = deepRecursiveScopeImpl.f53515a;
                    Unit unit2 = deepRecursiveScopeImpl.f53516b;
                    if (function3 == null) {
                        Intrinsics.checkNotNullParameter(function3, "<this>");
                        Intrinsics.checkNotNullParameter(completion, "completion");
                        Intrinsics.checkNotNullParameter(completion, "completion");
                        CoroutineContext context = completion.getContext();
                        Object intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1 = context == EmptyCoroutineContext.f53685a ? new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(completion) : new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(completion, context);
                        TypeIntrinsics.b(3, function3);
                        objInvoke = function3.invoke(deepRecursiveScopeImpl, unit2, intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1);
                    } else {
                        TypeIntrinsics.b(3, function3);
                        objInvoke = function3.invoke(deepRecursiveScopeImpl, unit2, completion);
                    }
                    if (objInvoke != CoroutineSingletons.f53689a) {
                        completion.resumeWith(objInvoke);
                    }
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f53538b;
                    completion.resumeWith(ResultKt.a(th));
                }
            } else {
                deepRecursiveScopeImpl.f53518d = coroutineSingletons;
                completion.resumeWith(obj);
            }
        }
    }
}
