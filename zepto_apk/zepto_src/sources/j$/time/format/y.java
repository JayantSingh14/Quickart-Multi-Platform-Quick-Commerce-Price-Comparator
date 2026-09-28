package j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final Map f53373a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f53374b;

    public y(Map map) {
        this.f53373a = map;
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap map3 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                String str = (String) entry2.getValue();
                String str2 = (String) entry2.getValue();
                Long l2 = (Long) entry2.getKey();
                ConcurrentHashMap concurrentHashMap = z.f53375a;
                map3.put(str, new AbstractMap.SimpleImmutableEntry(str2, l2));
            }
            ArrayList arrayList2 = new ArrayList(map3.values());
            Collections.sort(arrayList2, z.f53376b);
            map2.put((E) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            map2.put(null, arrayList);
        }
        Collections.sort(arrayList, z.f53376b);
        this.f53374b = map2;
    }

    public final String a(long j2, E e2) {
        Map map = (Map) this.f53373a.get(e2);
        if (map != null) {
            return (String) map.get(Long.valueOf(j2));
        }
        return null;
    }
}
