package com.google.android.gms.internal.pal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class zzjc implements Map, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient zzjd f37828a;

    /* renamed from: b, reason: collision with root package name */
    public transient zzjd f37829b;

    /* renamed from: c, reason: collision with root package name */
    public transient zziw f37830c;

    public static zzjc b() {
        return zzjj.f37844g;
    }

    public static zzjc c(Object obj, String str) {
        zziu.a(str, obj);
        return zzjj.h(1, new Object[]{str, obj}, null);
    }

    public static zzjc d(String str, String str2, String str3, String str4) {
        zziu.a(str, str2);
        zziu.a(str3, str4);
        return zzjj.h(2, new Object[]{str, str2, str3, str4}, null);
    }

    public static zzjc e(String str, String str2, String str3, String str4, String str5, String str6) {
        zziu.a(str, str2);
        zziu.a(str3, str4);
        zziu.a(str5, str6);
        return zzjj.h(3, new Object[]{str, str2, str3, str4, str5, str6}, null);
    }

    public abstract zziw a();

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        zziw zziwVarA = this.f37830c;
        if (zziwVarA == null) {
            zziwVarA = a();
            this.f37830c = zziwVarA;
        }
        return zziwVarA.contains(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        zzjd zzjdVar = this.f37828a;
        if (zzjdVar != null) {
            return zzjdVar;
        }
        zzjd zzjdVarF = f();
        this.f37828a = zzjdVarF;
        return zzjdVarF;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public abstract zzjd f();

    public abstract zzjd g();

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        zzjd zzjdVarF = this.f37828a;
        if (zzjdVarF == null) {
            zzjdVarF = f();
            this.f37828a = zzjdVarF;
        }
        Iterator it = zzjdVarF.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        zzjd zzjdVar = this.f37829b;
        if (zzjdVar != null) {
            return zzjdVar;
        }
        zzjd zzjdVarG = g();
        this.f37829b = zzjdVarG;
        return zzjdVarG;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(size, "size cannot be negative but was: "));
        }
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        zziw zziwVar = this.f37830c;
        if (zziwVar != null) {
            return zziwVar;
        }
        zziw zziwVarA = a();
        this.f37830c = zziwVarA;
        return zziwVarA;
    }
}
