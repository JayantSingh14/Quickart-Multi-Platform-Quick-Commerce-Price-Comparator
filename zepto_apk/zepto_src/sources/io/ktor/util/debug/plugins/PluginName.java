package io.ktor.util.debug.plugins;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: classes3.dex */
public final class PluginName extends AbstractCoroutineContextElement {

    @Metadata
    public static final class Key implements CoroutineContext.Key<PluginName> {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluginName)) {
            return false;
        }
        ((PluginName) obj).getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "PluginName(null)";
    }
}
