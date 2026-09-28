package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
class zzgrh implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f33104a;

    /* renamed from: b, reason: collision with root package name */
    public Collection f33105b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f33106c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgrt f33107d;

    public zzgrh(zzgrt zzgrtVar) {
        Objects.requireNonNull(zzgrtVar);
        this.f33107d = zzgrtVar;
        this.f33104a = zzgrtVar.f33127d.entrySet().iterator();
        this.f33105b = null;
        this.f33106c = zzgtu.f33211a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f33104a.hasNext() || this.f33106c.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f33106c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f33104a.next();
            entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f33105b = collection;
            this.f33106c = collection.iterator();
        }
        return this.f33106c.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f33106c.remove();
        Collection collection = this.f33105b;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.f33104a.remove();
        }
        zzgrt zzgrtVar = this.f33107d;
        zzgrtVar.f33128e--;
    }
}
