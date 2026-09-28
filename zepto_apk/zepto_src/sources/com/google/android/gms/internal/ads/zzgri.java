package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgri implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public Map.Entry f33108a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f33109b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzgrj f33110c;

    public zzgri(zzgrj zzgrjVar, Iterator it) {
        this.f33109b = it;
        this.f33110c = zzgrjVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f33109b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.f33109b.next();
        this.f33108a = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzgqa.g("no calls to next() since the last call to remove()", this.f33108a != null);
        Collection collection = (Collection) this.f33108a.getValue();
        this.f33109b.remove();
        this.f33110c.f33111b.f33128e -= collection.size();
        collection.clear();
        this.f33108a = null;
    }
}
