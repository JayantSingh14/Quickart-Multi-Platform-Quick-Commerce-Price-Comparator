package kotlin.collections;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: classes.dex */
public final class MapsKt extends MapsKt___MapsKt {
    public static Map c() {
        EmptyMap emptyMap = EmptyMap.f53610a;
        Intrinsics.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static Object d(Object obj, Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof MapWithDefault) {
            ((MapWithDefault) map).s0();
            throw null;
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static HashMap e(Pair... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        HashMap map = new HashMap(f(pairs.length));
        MapsKt__MapsKt.b(map, pairs);
        return map;
    }

    public static int f(int i2) {
        return i2 < 0 ? i2 : i2 < 3 ? i2 + 1 : i2 < 1073741824 ? (int) ((i2 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static Map g(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.f53533a, pair.f53534b);
        Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static Map h(Pair... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        if (pairs.length <= 0) {
            return c();
        }
        LinkedHashMap destination = new LinkedHashMap(f(pairs.length));
        Intrinsics.checkNotNullParameter(pairs, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        MapsKt__MapsKt.b(destination, pairs);
        return destination;
    }

    public static LinkedHashMap i(Pair... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(f(pairs.length));
        MapsKt__MapsKt.b(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static LinkedHashMap j(Map map, Map map2) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static Map k(ArrayList pairs) {
        Intrinsics.checkNotNullParameter(pairs, "<this>");
        int size = pairs.size();
        if (size == 0) {
            return c();
        }
        if (size == 1) {
            return g((Pair) pairs.get(0));
        }
        LinkedHashMap destination = new LinkedHashMap(f(pairs.size()));
        Intrinsics.checkNotNullParameter(pairs, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(destination, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            destination.put(pair.f53533a, pair.f53534b);
        }
        return destination;
    }

    public static Map l(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? n(map) : MapsKt__MapsJVMKt.a(map) : c();
    }

    public static Map m(Sequence pairs) {
        Intrinsics.checkNotNullParameter(pairs, "<this>");
        LinkedHashMap destination = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(pairs, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(destination, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            destination.put(pair.f53533a, pair.f53534b);
        }
        Intrinsics.checkNotNullParameter(destination, "<this>");
        int size = destination.size();
        return size != 0 ? size != 1 ? destination : MapsKt__MapsJVMKt.a(destination) : c();
    }

    public static LinkedHashMap n(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new LinkedHashMap(map);
    }
}
