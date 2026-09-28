package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzgts extends zzgrb {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Iterator f33207c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgqb f33208d;

    public zzgts(Iterator it, zzgqb zzgqbVar) {
        this.f33207c = it;
        this.f33208d = zzgqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgrb
    public final Object a() {
        Object next;
        do {
            Iterator it = this.f33207c;
            if (!it.hasNext()) {
                this.f33097b = 3;
                return null;
            }
            next = it.next();
        } while (!this.f33208d.zza(next));
        return next;
    }
}
