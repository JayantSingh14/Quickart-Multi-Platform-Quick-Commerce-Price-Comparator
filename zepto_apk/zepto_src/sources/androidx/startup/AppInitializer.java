package androidx.startup;

import android.content.Context;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class AppInitializer {

    /* renamed from: d, reason: collision with root package name */
    public static volatile AppInitializer f11945d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f11946e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f11949c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f11948b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f11947a = new HashMap();

    public AppInitializer(Context context) {
        this.f11949c = context.getApplicationContext();
    }

    public static AppInitializer c(Context context) {
        if (f11945d == null) {
            synchronized (f11946e) {
                try {
                    if (f11945d == null) {
                        f11945d = new AppInitializer(context);
                    }
                } finally {
                }
            }
        }
        return f11945d;
    }

    public final void a(Bundle bundle) throws ClassNotFoundException {
        HashSet hashSet;
        String string = this.f11949c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f11948b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e2) {
                throw new StartupException(e2);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object objB;
        if (Trace.e()) {
            try {
                android.os.Trace.beginSection(Trace.g(cls.getSimpleName()));
            } catch (Throwable th) {
                android.os.Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap map = this.f11947a;
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                Initializer initializer = (Initializer) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = initializer.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                objB = initializer.b(this.f11949c);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        android.os.Trace.endSection();
        return objB;
    }
}
