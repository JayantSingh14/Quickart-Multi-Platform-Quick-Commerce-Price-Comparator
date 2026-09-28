package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgrf implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f33099a;

    /* renamed from: b, reason: collision with root package name */
    public Collection f33100b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzgrg f33101c;

    public zzgrf(zzgrg zzgrgVar) {
        Objects.requireNonNull(zzgrgVar);
        this.f33101c = zzgrgVar;
        this.f33099a = zzgrgVar.f33102d.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f33099a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f33099a.next();
        this.f33100b = (Collection) entry.getValue();
        return this.f33101c.c(entry);
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzgqa.g("no calls to next() since the last call to remove()", this.f33100b != null);
        this.f33099a.remove();
        this.f33101c.f33103e.f33128e -= this.f33100b.size();
        this.f33100b.clear();
        this.f33100b = null;
    }
}
