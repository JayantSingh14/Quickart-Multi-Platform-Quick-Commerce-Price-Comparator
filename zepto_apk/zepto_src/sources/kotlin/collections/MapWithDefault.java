package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
interface MapWithDefault<K, V> extends Map<K, V>, KMappedMarker {
    Object s0();
}
