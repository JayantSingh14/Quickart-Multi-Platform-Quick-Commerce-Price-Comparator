package io.sentry.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class CollectionUtils {

    public interface Mapper<T, R> {
    }

    public interface Predicate<T> {
    }

    public static boolean a(Object[] objArr) {
        for (Object obj : objArr) {
            if ("custom".equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList b(List list) {
        if (list != null) {
            return new ArrayList(list);
        }
        return null;
    }

    public static ConcurrentHashMap c(Map map) {
        if (map == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return concurrentHashMap;
    }

    public static HashMap d(Map map) {
        return new HashMap(map);
    }

    public static int e(Collection collection) {
        if (collection instanceof Collection) {
            return collection.size();
        }
        Iterator it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }
}
