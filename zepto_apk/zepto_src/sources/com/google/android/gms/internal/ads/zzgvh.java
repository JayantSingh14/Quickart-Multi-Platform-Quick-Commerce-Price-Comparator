package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgvh extends zzgrb {

    /* renamed from: c, reason: collision with root package name */
    public final Iterator f33256c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgtn f33257d;

    public zzgvh(zzgvi zzgviVar, zzgtn zzgtnVar, zzgtn zzgtnVar2) {
        this.f33257d = zzgtnVar2;
        Objects.requireNonNull(zzgviVar);
        this.f33256c = zzgtnVar.iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzgrb
    public final Object a() {
        Object next;
        do {
            Iterator it = this.f33256c;
            if (!it.hasNext()) {
                this.f33097b = 3;
                return null;
            }
            next = it.next();
        } while (!this.f33257d.contains(next));
        return next;
    }
}
