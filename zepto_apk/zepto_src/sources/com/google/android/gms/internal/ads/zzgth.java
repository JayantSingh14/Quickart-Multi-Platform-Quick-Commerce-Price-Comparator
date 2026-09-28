package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgth extends zzgvr {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f33193a;

    /* renamed from: b, reason: collision with root package name */
    public Object f33194b;

    /* renamed from: c, reason: collision with root package name */
    public zzgvr f33195c;

    public zzgth(zzgtl zzgtlVar) {
        Objects.requireNonNull(zzgtlVar);
        zzgtg zzgtgVar = zzgtlVar.f33199d;
        zzgtn zzgtnVarB = zzgtgVar.f33190a;
        if (zzgtnVarB == null) {
            zzgtnVarB = zzgtgVar.b();
            zzgtgVar.f33190a = zzgtnVarB;
        }
        this.f33193a = zzgtnVarB.i().listIterator(0);
        this.f33194b = null;
        this.f33195c = zzgtt.f33209d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f33195c.hasNext() || ((zzgra) this.f33193a).hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (!this.f33195c.hasNext()) {
            Map.Entry entry = (Map.Entry) ((zzgra) this.f33193a).next();
            this.f33194b = entry.getKey();
            this.f33195c = ((zzgsz) entry.getValue()).iterator();
        }
        Object obj = this.f33194b;
        Objects.requireNonNull(obj);
        return new AbstractMap.SimpleImmutableEntry(obj, this.f33195c.next());
    }
}
