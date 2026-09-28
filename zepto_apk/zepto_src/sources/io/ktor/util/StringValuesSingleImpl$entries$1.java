package io.ktor.util;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class StringValuesSingleImpl$entries$1 implements Map.Entry<String, List<? extends String>>, KMappedMarker {
    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Intrinsics.b(entry.getKey(), null) && Intrinsics.b(entry.getValue(), null);
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ String getKey() {
        return null;
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ List<? extends String> getValue() {
        return null;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        throw null;
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ List<? extends String> setValue(List<? extends String> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        return "null=null";
    }
}
