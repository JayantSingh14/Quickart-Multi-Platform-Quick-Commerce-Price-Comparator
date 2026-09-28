package io.ktor.utils.io.pool;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata
/* loaded from: classes.dex */
public /* synthetic */ class DefaultPool$Companion$Top$1 extends MutablePropertyReference1Impl {

    /* renamed from: c, reason: collision with root package name */
    public static final DefaultPool$Companion$Top$1 f51374c = new DefaultPool$Companion$Top$1("top", "getTop()J", DefaultPool.class);

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public final void g(Object obj, Object obj2) {
        ((DefaultPool) obj).top = ((Number) obj2).longValue();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return Long.valueOf(((DefaultPool) obj).top);
    }
}
