package androidx.datastore.preferences.core;

import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class Actual_jvmKt {
    public static final Set a(Set set) {
        Intrinsics.checkNotNullParameter(set, "set");
        Set setUnmodifiableSet = Collections.unmodifiableSet(CollectionsKt.h0(set));
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
        return setUnmodifiableSet;
    }

    public static final Map b(LinkedHashMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }
}
