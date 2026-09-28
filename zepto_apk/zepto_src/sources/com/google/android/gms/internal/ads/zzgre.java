package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzgre extends zzgug {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgrg f33098a;

    public zzgre(zzgrg zzgrgVar) {
        Objects.requireNonNull(zzgrgVar);
        this.f33098a = zzgrgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgug
    public final Map b() {
        return this.f33098a;
    }

    @Override // com.google.android.gms.internal.ads.zzgug, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Set setEntrySet = this.f33098a.f33102d.entrySet();
        setEntrySet.getClass();
        try {
            return setEntrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzgrf(this.f33098a);
    }

    @Override // com.google.android.gms.internal.ads.zzgug, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Object objRemove;
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Objects.requireNonNull(entry);
        Object key = entry.getKey();
        zzgut zzgutVar = this.f33098a.f33103e;
        try {
            objRemove = zzgutVar.f33127d.remove(key);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection == null) {
            return true;
        }
        int size = collection.size();
        collection.clear();
        zzgutVar.f33128e -= size;
        return true;
    }
}
