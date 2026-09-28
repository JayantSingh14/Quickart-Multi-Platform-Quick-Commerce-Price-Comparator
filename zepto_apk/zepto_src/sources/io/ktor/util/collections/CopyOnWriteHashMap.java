package io.ktor.util.collections;

import io.ktor.events.EventDefinition;
import io.ktor.util.InternalAPI;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@InternalAPI
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CopyOnWriteHashMap<K, V> {

    @NotNull
    private volatile /* synthetic */ Object current = MapsKt.c();

    static {
        AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, "current");
    }

    public final Object a(EventDefinition key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((Map) this.current).get(key);
    }
}
