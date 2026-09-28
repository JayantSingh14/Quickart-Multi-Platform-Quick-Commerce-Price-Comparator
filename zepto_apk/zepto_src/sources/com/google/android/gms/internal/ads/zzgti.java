package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgti extends zzgvr {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f33196a;

    /* renamed from: b, reason: collision with root package name */
    public zzgvr f33197b;

    public zzgti(zzgtl zzgtlVar) {
        Objects.requireNonNull(zzgtlVar);
        zzgtg zzgtgVar = zzgtlVar.f33199d;
        zzgsz zzgszVarD = zzgtgVar.f33192c;
        if (zzgszVarD == null) {
            zzgszVarD = zzgtgVar.d();
            zzgtgVar.f33192c = zzgszVarD;
        }
        this.f33196a = ((zzgtd) zzgszVarD).listIterator(0);
        this.f33197b = zzgtt.f33209d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f33197b.hasNext() || ((zzgra) this.f33196a).hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f33197b.hasNext()) {
            this.f33197b = ((zzgsz) ((zzgra) this.f33196a).next()).iterator();
        }
        return this.f33197b.next();
    }
}
