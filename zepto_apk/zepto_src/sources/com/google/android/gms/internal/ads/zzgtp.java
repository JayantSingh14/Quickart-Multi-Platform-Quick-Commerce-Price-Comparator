package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgtp extends zzgtn {

    /* renamed from: d, reason: collision with root package name */
    public final transient zzgtq f33205d;

    public zzgtp(zzgtq zzgtqVar) {
        this.f33205d = zzgtqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    /* renamed from: b */
    public final zzgvr iterator() {
        return new zzgth(this.f33205d);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        Collection collection = (Collection) this.f33205d.c().get(key);
        return collection != null && collection.contains(value);
    }

    @Override // com.google.android.gms.internal.ads.zzgtn, com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzgth(this.f33205d);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final boolean j() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f33205d.f33200e;
    }
}
