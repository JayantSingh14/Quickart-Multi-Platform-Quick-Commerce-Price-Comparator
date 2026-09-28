package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgva extends zzgtn {

    /* renamed from: d, reason: collision with root package name */
    public final transient zzgtg f33236d;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object[] f33237e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int f33238f;

    public zzgva(zzgtg zzgtgVar, Object[] objArr, int i2) {
        this.f33236d = zzgtgVar;
        this.f33237e = objArr;
        this.f33238f = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    /* renamed from: b */
    public final zzgvr iterator() {
        return i().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f33236d.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgtn, com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return i().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int k(int i2, Object[] objArr) {
        return i().k(i2, objArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgtn
    public final zzgtd r() {
        return new zzguz(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f33238f;
    }
}
