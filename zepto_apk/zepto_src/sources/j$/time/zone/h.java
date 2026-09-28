package j$.time.zone;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList f53493b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f53494c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile Set f53495d;

    /* renamed from: a, reason: collision with root package name */
    public final Set f53496a;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f53493b = copyOnWriteArrayList;
        f53494c = new ConcurrentHashMap(512, 0.75f, 2);
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new g(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    public static ZoneRules a(String str) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentHashMap concurrentHashMap = f53494c;
        h hVar = (h) concurrentHashMap.get(str);
        if (hVar == null) {
            if (concurrentHashMap.isEmpty()) {
                throw new f("No time-zone data files registered");
            }
            throw new f("Unknown time-zone ID: ".concat(str));
        }
        if (hVar.f53496a.contains(str)) {
            return new ZoneRules(TimeZone.getTimeZone(str));
        }
        throw new f("Not a built-in time zone: ".concat(str));
    }

    public static void b(h hVar) {
        Objects.requireNonNull(hVar, "provider");
        synchronized (h.class) {
            try {
                for (String str : hVar.f53496a) {
                    Objects.requireNonNull(str, "zoneId");
                    if (((h) f53494c.putIfAbsent(str, hVar)) != null) {
                        throw new f("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + hVar);
                    }
                }
                f53495d = Collections.unmodifiableSet(new HashSet(f53494c.keySet()));
            } catch (Throwable th) {
                throw th;
            }
        }
        f53493b.add(hVar);
    }

    public h() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : TimeZone.getAvailableIDs()) {
            linkedHashSet.add(str);
        }
        this.f53496a = Collections.unmodifiableSet(linkedHashSet);
    }
}
