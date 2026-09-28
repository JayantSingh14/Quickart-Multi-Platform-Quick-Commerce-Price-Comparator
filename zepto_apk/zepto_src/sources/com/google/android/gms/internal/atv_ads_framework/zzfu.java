package com.google.android.gms.internal.atv_ads_framework;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* loaded from: classes4.dex */
public final class zzfu extends AbstractList implements RandomAccess, zzdw {

    /* renamed from: a, reason: collision with root package name */
    public final zzdv f36208a;

    public zzfu(zzdv zzdvVar) {
        this.f36208a = zzdvVar;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdw
    public final Object c(int i2) {
        return this.f36208a.f36141b.get(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return this.f36208a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzft(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new zzfs(this, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36208a.f36141b.size();
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdw
    public final zzdw zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdw
    public final List zzh() {
        return Collections.unmodifiableList(this.f36208a.f36141b);
    }
}
