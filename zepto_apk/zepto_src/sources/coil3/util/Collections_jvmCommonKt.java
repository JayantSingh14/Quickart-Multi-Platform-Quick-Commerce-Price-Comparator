package coil3.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Collections_jvmCommonKt {
    @NotNull
    public static final <K, V> Map<K, V> LruMutableMap(int i2, float f2) {
        return new LinkedHashMap(i2, f2, true);
    }

    public static /* synthetic */ Map LruMutableMap$default(int i2, float f2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            f2 = 0.75f;
        }
        return LruMutableMap(i2, f2);
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> list) {
        int size = list.size();
        return size != 0 ? size != 1 ? Collections.unmodifiableList(new ArrayList(list)) : Collections.singletonList(kotlin.collections.CollectionsKt.z(list)) : EmptyList.f53609a;
    }

    @NotNull
    public static final <K, V> Map<K, V> toImmutableMap(@NotNull Map<K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return MapsKt.c();
        }
        if (size != 1) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) kotlin.collections.CollectionsKt.y(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }
}
