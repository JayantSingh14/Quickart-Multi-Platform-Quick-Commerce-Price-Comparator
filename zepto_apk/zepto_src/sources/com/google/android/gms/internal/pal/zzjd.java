package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class zzjd extends zziw implements Set {

    /* renamed from: b, reason: collision with root package name */
    public transient zziz f37831b;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.pal.zziw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final zziz j() {
        zziz zzizVar = this.f37831b;
        if (zzizVar != null) {
            return zzizVar;
        }
        zzjf zzjfVar = new zzjf((zzjg) this);
        this.f37831b = zzjfVar;
        return zzjfVar;
    }
}
