package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@SinceKotlin
@Metadata
@ExperimentalStdlibApi
/* loaded from: classes.dex */
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f53679a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext.Key f53680b;

    public AbstractCoroutineContextKey(CoroutineContext.Key baseKey, Function1 safeCast) {
        Intrinsics.checkNotNullParameter(baseKey, "baseKey");
        Intrinsics.checkNotNullParameter(safeCast, "safeCast");
        this.f53679a = safeCast;
        this.f53680b = baseKey instanceof AbstractCoroutineContextKey ? ((AbstractCoroutineContextKey) baseKey).f53680b : baseKey;
    }
}
