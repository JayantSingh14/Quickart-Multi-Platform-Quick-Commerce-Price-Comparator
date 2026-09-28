package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata
/* loaded from: classes.dex */
public final class ThreadContextKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Symbol f55109a = new Symbol("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    public static final b f55110b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f55111c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f55112d;

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.internal.b] */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlinx.coroutines.internal.b] */
    static {
        final int i2 = 1;
        f55110b = new Function2() { // from class: kotlinx.coroutines.internal.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i2) {
                    case 0:
                        ThreadState threadState = (ThreadState) obj;
                        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                        if (element instanceof ThreadContextElement) {
                            ThreadContextElement threadContextElement = (ThreadContextElement) element;
                            threadState.a(threadContextElement, threadContextElement.J1(threadState.f55115a));
                        }
                        return threadState;
                    case 1:
                        CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                        if (!(element2 instanceof ThreadContextElement)) {
                            return obj;
                        }
                        Integer num = obj instanceof Integer ? (Integer) obj : null;
                        int iIntValue = num != null ? num.intValue() : 1;
                        return iIntValue == 0 ? element2 : Integer.valueOf(iIntValue + 1);
                    default:
                        ThreadContextElement threadContextElement2 = (ThreadContextElement) obj;
                        CoroutineContext.Element element3 = (CoroutineContext.Element) obj2;
                        if (threadContextElement2 != null) {
                            return threadContextElement2;
                        }
                        if (element3 instanceof ThreadContextElement) {
                            return (ThreadContextElement) element3;
                        }
                        return null;
                }
            }
        };
        final int i3 = 2;
        f55111c = new Function2() { // from class: kotlinx.coroutines.internal.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i3) {
                    case 0:
                        ThreadState threadState = (ThreadState) obj;
                        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                        if (element instanceof ThreadContextElement) {
                            ThreadContextElement threadContextElement = (ThreadContextElement) element;
                            threadState.a(threadContextElement, threadContextElement.J1(threadState.f55115a));
                        }
                        return threadState;
                    case 1:
                        CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                        if (!(element2 instanceof ThreadContextElement)) {
                            return obj;
                        }
                        Integer num = obj instanceof Integer ? (Integer) obj : null;
                        int iIntValue = num != null ? num.intValue() : 1;
                        return iIntValue == 0 ? element2 : Integer.valueOf(iIntValue + 1);
                    default:
                        ThreadContextElement threadContextElement2 = (ThreadContextElement) obj;
                        CoroutineContext.Element element3 = (CoroutineContext.Element) obj2;
                        if (threadContextElement2 != null) {
                            return threadContextElement2;
                        }
                        if (element3 instanceof ThreadContextElement) {
                            return (ThreadContextElement) element3;
                        }
                        return null;
                }
            }
        };
        final int i4 = 0;
        f55112d = new Function2() { // from class: kotlinx.coroutines.internal.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i4) {
                    case 0:
                        ThreadState threadState = (ThreadState) obj;
                        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                        if (element instanceof ThreadContextElement) {
                            ThreadContextElement threadContextElement = (ThreadContextElement) element;
                            threadState.a(threadContextElement, threadContextElement.J1(threadState.f55115a));
                        }
                        return threadState;
                    case 1:
                        CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                        if (!(element2 instanceof ThreadContextElement)) {
                            return obj;
                        }
                        Integer num = obj instanceof Integer ? (Integer) obj : null;
                        int iIntValue = num != null ? num.intValue() : 1;
                        return iIntValue == 0 ? element2 : Integer.valueOf(iIntValue + 1);
                    default:
                        ThreadContextElement threadContextElement2 = (ThreadContextElement) obj;
                        CoroutineContext.Element element3 = (CoroutineContext.Element) obj2;
                        if (threadContextElement2 != null) {
                            return threadContextElement2;
                        }
                        if (element3 instanceof ThreadContextElement) {
                            return (ThreadContextElement) element3;
                        }
                        return null;
                }
            }
        };
    }

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f55109a) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).b(coroutineContext);
            return;
        }
        Object objFold = coroutineContext.fold(null, f55111c);
        Intrinsics.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((ThreadContextElement) objFold).u0(obj);
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, f55110b);
        Intrinsics.c(objFold);
        return objFold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        return obj == 0 ? f55109a : obj instanceof Integer ? coroutineContext.fold(new ThreadState(((Number) obj).intValue(), coroutineContext), f55112d) : ((ThreadContextElement) obj).J1(coroutineContext);
    }
}
