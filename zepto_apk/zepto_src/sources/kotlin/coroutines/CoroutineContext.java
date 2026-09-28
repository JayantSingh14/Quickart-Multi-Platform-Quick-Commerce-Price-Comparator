package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@SinceKotlin
@Metadata
/* loaded from: classes.dex */
public interface CoroutineContext {

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public interface Element extends CoroutineContext {

        @Metadata
        public static final class DefaultImpls {
            public static Element a(Element element, Key key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (Intrinsics.b(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static CoroutineContext b(Element element, Key key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return Intrinsics.b(element.getKey(), key) ? EmptyCoroutineContext.f53685a : element;
            }

            public static CoroutineContext c(Element element, CoroutineContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(context, "context");
                return context == EmptyCoroutineContext.f53685a ? element : (CoroutineContext) context.fold(element, new a(0));
            }
        }

        Key getKey();
    }

    @Metadata
    public interface Key<E extends Element> {
    }

    Object fold(Object obj, Function2 function2);

    Element get(Key key);

    CoroutineContext minusKey(Key key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
