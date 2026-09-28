package com.google.android.gms.internal.atv_ads_framework;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class zzdv extends zzcb implements RandomAccess, zzdw {

    /* renamed from: b, reason: collision with root package name */
    public final List f36141b;

    static {
        new zzdv((Object) null);
    }

    public zzdv() {
        this(10);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        b();
        this.f36141b.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        b();
        if (collection instanceof zzdw) {
            collection = ((zzdw) collection).zzh();
        }
        boolean zAddAll = this.f36141b.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdw
    public final Object c(int i2) {
        return this.f36141b.get(i2);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        b();
        this.f36141b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String get(int i2) {
        List list = this.f36141b;
        Object obj = list.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzcn) {
            zzcn zzcnVar = (zzcn) obj;
            String strJ = zzcnVar.f() == 0 ? "" : zzcnVar.j(zzdp.f36125a);
            if (zzcnVar.m()) {
                list.set(i2, strJ);
            }
            return strJ;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, zzdp.f36125a);
        if (zzgd.f36218a.a(bArr.length, bArr) == 0) {
            list.set(i2, str);
        }
        return str;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        Object objRemove = this.f36141b.remove(i2);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof zzcn)) {
            return new String((byte[]) objRemove, zzdp.f36125a);
        }
        zzcn zzcnVar = (zzcn) objRemove;
        return zzcnVar.f() == 0 ? "" : zzcnVar.j(zzdp.f36125a);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b();
        Object obj2 = this.f36141b.set(i2, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof zzcn)) {
            return new String((byte[]) obj2, zzdp.f36125a);
        }
        zzcn zzcnVar = (zzcn) obj2;
        return zzcnVar.f() == 0 ? "" : zzcnVar.j(zzdp.f36125a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36141b.size();
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdw
    public final zzdw zzd() {
        return this.f36088a ? new zzfu(this) : this;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdo
    public final zzdo zzg(int i2) {
        List list = this.f36141b;
        if (i2 < list.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i2);
        arrayList.addAll(list);
        return new zzdv(arrayList);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdw
    public final List zzh() {
        return Collections.unmodifiableList(this.f36141b);
    }

    public zzdv(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        super(true);
        this.f36141b = arrayList;
    }

    public zzdv(ArrayList arrayList) {
        super(true);
        this.f36141b = arrayList;
    }

    public zzdv(Object obj) {
        super(false);
        this.f36141b = Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcb, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f36141b.size(), collection);
    }
}
