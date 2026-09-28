package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class zzpa {

    /* renamed from: a, reason: collision with root package name */
    public final Class f37991a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f37992b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f37993c;

    public zzpa(Class cls, zzpq... zzpqVarArr) {
        this.f37991a = cls;
        HashMap map = new HashMap();
        for (int i2 = 0; i2 <= 0; i2++) {
            zzpq zzpqVar = zzpqVarArr[i2];
            boolean zContainsKey = map.containsKey(zzpqVar.f38002a);
            Class cls2 = zzpqVar.f38002a;
            if (zContainsKey) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(cls2.getCanonicalName())));
            }
            map.put(cls2, zzpqVar);
        }
        this.f37993c = zzpqVarArr[0].f38002a;
        this.f37992b = Collections.unmodifiableMap(map);
    }

    public zzoz a() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract zzvn b();

    public abstract zzaef c(zzaby zzabyVar);

    public abstract String d();

    public abstract void e(zzaef zzaefVar);

    public int f() {
        return 1;
    }

    public final Object g(zzaef zzaefVar, Class cls) {
        zzpq zzpqVar = (zzpq) this.f37992b.get(cls);
        if (zzpqVar != null) {
            return zzpqVar.a(zzaefVar);
        }
        throw new IllegalArgumentException(android.support.v4.media.b.D("Requested primitive class ", cls.getCanonicalName(), " not supported."));
    }
}
