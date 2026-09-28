package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
class zzgrj extends zzguh {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzgut f33111b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgrj(zzgut zzgutVar, Map map) {
        super(map);
        Objects.requireNonNull(zzgutVar);
        this.f33111b = zzgutVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguh, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        Iterator it = iterator();
        while (true) {
            zzgri zzgriVar = (zzgri) it;
            if (!zzgriVar.hasNext()) {
                return;
            }
            zzgriVar.next();
            zzgriVar.remove();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return this.f33223a.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return this == obj || this.f33223a.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f33223a.keySet().hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzguh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzgri(this, this.f33223a.entrySet().iterator());
    }

    @Override // com.google.android.gms.internal.ads.zzguh, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.f33223a.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        this.f33111b.f33128e -= size;
        return size > 0;
    }
}
