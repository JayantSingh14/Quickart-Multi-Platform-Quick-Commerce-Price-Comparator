package kotlin.coroutines;

import androidx.fragment.app.e;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CombinedContext implements CoroutineContext, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f53681a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext.Element f53682b;

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final Companion f53683a = new Companion(null);

        @Metadata
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }
    }

    public CombinedContext(CoroutineContext.Element element, CoroutineContext left) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(element, "element");
        this.f53681a = left;
        this.f53682b = element;
    }

    public final boolean equals(Object obj) {
        boolean zB;
        if (this == obj) {
            return true;
        }
        if (obj instanceof CombinedContext) {
            CombinedContext combinedContext = (CombinedContext) obj;
            combinedContext.getClass();
            int i2 = 2;
            CombinedContext combinedContext2 = combinedContext;
            int i3 = 2;
            while (true) {
                CoroutineContext coroutineContext = combinedContext2.f53681a;
                combinedContext2 = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
                if (combinedContext2 == null) {
                    break;
                }
                i3++;
            }
            CombinedContext combinedContext3 = this;
            while (true) {
                CoroutineContext coroutineContext2 = combinedContext3.f53681a;
                combinedContext3 = coroutineContext2 instanceof CombinedContext ? (CombinedContext) coroutineContext2 : null;
                if (combinedContext3 == null) {
                    break;
                }
                i2++;
            }
            if (i3 == i2) {
                CombinedContext combinedContext4 = this;
                while (true) {
                    CoroutineContext.Element element = combinedContext4.f53682b;
                    if (!Intrinsics.b(combinedContext.get(element.getKey()), element)) {
                        zB = false;
                        break;
                    }
                    CoroutineContext coroutineContext3 = combinedContext4.f53681a;
                    if (!(coroutineContext3 instanceof CombinedContext)) {
                        Intrinsics.d(coroutineContext3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext3;
                        zB = Intrinsics.b(combinedContext.get(element2.getKey()), element2);
                        break;
                    }
                    combinedContext4 = (CombinedContext) coroutineContext3;
                }
                if (zB) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(this.f53681a.fold(obj, operation), this.f53682b);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext.Element element = combinedContext.f53682b.get(key);
            if (element != null) {
                return element;
            }
            CoroutineContext coroutineContext = combinedContext.f53681a;
            if (!(coroutineContext instanceof CombinedContext)) {
                return coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public final int hashCode() {
        return this.f53682b.hashCode() + this.f53681a.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CoroutineContext.Element element = this.f53682b;
        CoroutineContext.Element element2 = element.get(key);
        CoroutineContext coroutineContext = this.f53681a;
        if (element2 != null) {
            return coroutineContext;
        }
        CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(key);
        return coroutineContextMinusKey == coroutineContext ? this : coroutineContextMinusKey == EmptyCoroutineContext.f53685a ? element : new CombinedContext(element, coroutineContextMinusKey);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context == EmptyCoroutineContext.f53685a ? this : (CoroutineContext) context.fold(this, new a(0));
    }

    public final String toString() {
        return e.t(new StringBuilder("["), (String) fold("", new com.chuckerteam.chucker.internal.data.repository.a(4)), ']');
    }
}
