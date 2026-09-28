package com.google.android.gms.internal.atv_ads_framework;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzbo extends zzbi {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzbh f36065c;

    /* renamed from: d, reason: collision with root package name */
    public final transient zzbe f36066d;

    public zzbo(zzbh zzbhVar, zzbe zzbeVar) {
        this.f36065c = zzbhVar;
        this.f36066d = zzbeVar;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int b(Object[] objArr) {
        return this.f36066d.b(objArr);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f36065c.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi, com.google.android.gms.internal.atv_ads_framework.zzbb
    public final zzbe g() {
        return this.f36066d;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    /* renamed from: i */
    public final zzbu iterator() {
        return this.f36066d.listIterator(0);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi, com.google.android.gms.internal.atv_ads_framework.zzbb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.f36066d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f36065c.size();
    }
}
