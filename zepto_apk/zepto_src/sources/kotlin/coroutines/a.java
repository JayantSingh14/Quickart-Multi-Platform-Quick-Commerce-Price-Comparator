package kotlin.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThreadContextElement;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f53688a;

    public /* synthetic */ a(int i2) {
        this.f53688a = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CombinedContext combinedContext;
        switch (this.f53688a) {
            case 0:
                CoroutineContext acc = (CoroutineContext) obj;
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(element, "element");
                CoroutineContext coroutineContextMinusKey = acc.minusKey(element.getKey());
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f53685a;
                if (coroutineContextMinusKey == emptyCoroutineContext) {
                    return element;
                }
                ContinuationInterceptor.Key key = ContinuationInterceptor.y0;
                ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.get(key);
                if (continuationInterceptor == null) {
                    combinedContext = new CombinedContext(element, coroutineContextMinusKey);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(key);
                    if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                        return new CombinedContext(continuationInterceptor, element);
                    }
                    combinedContext = new CombinedContext(continuationInterceptor, new CombinedContext(element, coroutineContextMinusKey2));
                }
                return combinedContext;
            case 1:
                return Boolean.valueOf(((Boolean) obj).booleanValue() || (((CoroutineContext.Element) obj2) instanceof CopyableThreadContextElement));
            case 2:
                CoroutineContext coroutineContext = (CoroutineContext) obj;
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                return element2 instanceof CopyableThreadContextElement ? coroutineContext.plus(((CopyableThreadContextElement) element2).k0()) : coroutineContext.plus(element2);
            case 3:
                return Boolean.valueOf(Intrinsics.b(obj, obj2));
            default:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
        }
    }
}
