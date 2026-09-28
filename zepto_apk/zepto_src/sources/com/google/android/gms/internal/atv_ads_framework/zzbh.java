package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class zzbh implements Map, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient zzbi f36052a;

    /* renamed from: b, reason: collision with root package name */
    public transient zzbi f36053b;

    /* renamed from: c, reason: collision with root package name */
    public transient zzbb f36054c;

    public abstract zzbb a();

    public abstract zzbi b();

    public abstract zzbi c();

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
        zzbb zzbbVarA = this.f36054c;
        if (zzbbVarA == null) {
            zzbbVarA = a();
            this.f36054c = zzbbVarA;
        }
        return zzbbVarA.contains(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        zzbi zzbiVar = this.f36052a;
        if (zzbiVar != null) {
            return zzbiVar;
        }
        zzbi zzbiVarB = b();
        this.f36052a = zzbiVarB;
        return zzbiVarB;
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

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        zzbi zzbiVarB = this.f36052a;
        if (zzbiVarB == null) {
            zzbiVarB = b();
            this.f36052a = zzbiVarB;
        }
        Iterator it = zzbiVarB.iterator();
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
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzbi zzbiVar = this.f36053b;
        if (zzbiVar != null) {
            return zzbiVar;
        }
        zzbi zzbiVarC = c();
        this.f36053b = zzbiVarC;
        return zzbiVarC;
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
            throw new IllegalArgumentException(b.f(size, "size cannot be negative but was: "));
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
        zzbb zzbbVar = this.f36054c;
        if (zzbbVar != null) {
            return zzbbVar;
        }
        zzbb zzbbVarA = a();
        this.f36054c = zzbbVarA;
        return zzbbVarA;
    }
}
