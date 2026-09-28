package io.ktor.util.debug.plugins;

import androidx.fragment.app.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class PluginsTrace extends AbstractCoroutineContextElement {

    /* renamed from: b, reason: collision with root package name */
    public static final Key f50559b = new Key();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f50560a;

    @Metadata
    public static final class Key implements CoroutineContext.Key<PluginsTrace> {
    }

    public PluginsTrace() {
        ArrayList eventOrder = new ArrayList();
        Intrinsics.checkNotNullParameter(eventOrder, "eventOrder");
        super(f50559b);
        this.f50560a = eventOrder;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PluginsTrace) && Intrinsics.b(this.f50560a, ((PluginsTrace) obj).f50560a);
    }

    public final int hashCode() {
        return this.f50560a.hashCode();
    }

    public final String toString() {
        return e.t(new StringBuilder("PluginsTrace("), CollectionsKt.E(this.f50560a, null, null, null, null, 63), ')');
    }
}
