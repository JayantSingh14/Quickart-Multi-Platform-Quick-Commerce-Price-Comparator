package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzgvo extends zzgtn {

    /* renamed from: d, reason: collision with root package name */
    public final transient Object f33260d;

    public zzgvo(Object obj) {
        obj.getClass();
        this.f33260d = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    /* renamed from: b */
    public final zzgvr iterator() {
        return new zzgtv(this.f33260d);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f33260d.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgtn, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f33260d.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzgtn, com.google.android.gms.internal.ads.zzgsz
    public final zzgtd i() {
        return zzgtd.n(this.f33260d);
    }

    @Override // com.google.android.gms.internal.ads.zzgtn, com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzgtv(this.f33260d);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final boolean j() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int k(int i2, Object[] objArr) {
        objArr[i2] = this.f33260d;
        return i2 + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.f33260d.toString();
        return android.support.v4.media.b.s(new StringBuilder(String.valueOf(string).length() + 2), "[", string, "]");
    }
}
