package io.ktor.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FileContentTypeKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f50187a = LazyKt.b(FileContentTypeKt$contentTypesByExtensions$2.f50189c);

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f50188b = LazyKt.b(FileContentTypeKt$extensionsByContentType$2.f50190c);

    public static final LinkedHashMap a(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequence) {
            Object obj2 = ((Pair) obj).f53533a;
            Object arrayList = linkedHashMap.get(obj2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(obj2, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.f(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.r(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Pair) it.next()).f53534b);
            }
            linkedHashMap2.put(key, arrayList2);
        }
        return linkedHashMap2;
    }
}
