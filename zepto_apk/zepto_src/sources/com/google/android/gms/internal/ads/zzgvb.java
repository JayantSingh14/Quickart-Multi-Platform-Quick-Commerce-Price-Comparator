package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzgvb extends zzgtn {

    /* renamed from: d, reason: collision with root package name */
    public final transient zzgtg f33239d;

    /* renamed from: e, reason: collision with root package name */
    public final transient zzgtd f33240e;

    public zzgvb(zzgtg zzgtgVar, zzgtd zzgtdVar) {
        this.f33239d = zzgtgVar;
        this.f33240e = zzgtdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    /* renamed from: b */
    public final zzgvr iterator() {
        return this.f33240e.listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f33239d.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtn, com.google.android.gms.internal.ads.zzgsz
    public final zzgtd i() {
        return this.f33240e;
    }

    @Override // com.google.android.gms.internal.ads.zzgtn, com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.f33240e.listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int k(int i2, Object[] objArr) {
        return this.f33240e.k(i2, objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f33239d.size();
    }
}
