package com.google.android.gms.internal.pal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class zzadm extends zzabj implements RandomAccess, zzadn {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f37426b;

    static {
        new zzadm(10).f37350a = false;
    }

    public zzadm() {
        this(10);
    }

    @Override // com.google.android.gms.internal.pal.zzadn
    public final void V(zzaby zzabyVar) {
        b();
        this.f37426b.add(zzabyVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        b();
        this.f37426b.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        b();
        if (collection instanceof zzadn) {
            collection = ((zzadn) collection).zzh();
        }
        boolean zAddAll = this.f37426b.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        b();
        this.f37426b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String get(int i2) {
        ArrayList arrayList = this.f37426b;
        Object obj = arrayList.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzaby) {
            zzaby zzabyVar = (zzaby) obj;
            String strM = zzabyVar.f() == 0 ? "" : zzabyVar.m(zzadg.f37410a);
            if (zzabyVar.o()) {
                arrayList.set(i2, strM);
            }
            return strM;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, zzadg.f37410a);
        if (zzafx.f37505a.b(bArr, 0, bArr.length)) {
            arrayList.set(i2, str);
        }
        return str;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        Object objRemove = this.f37426b.remove(i2);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof zzaby)) {
            return new String((byte[]) objRemove, zzadg.f37410a);
        }
        zzaby zzabyVar = (zzaby) objRemove;
        return zzabyVar.f() == 0 ? "" : zzabyVar.m(zzadg.f37410a);
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b();
        Object obj2 = this.f37426b.set(i2, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof zzaby)) {
            return new String((byte[]) obj2, zzadg.f37410a);
        }
        zzaby zzabyVar = (zzaby) obj2;
        return zzabyVar.f() == 0 ? "" : zzabyVar.m(zzadg.f37410a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37426b.size();
    }

    @Override // com.google.android.gms.internal.pal.zzadf
    public final zzadf zzd(int i2) {
        ArrayList arrayList = this.f37426b;
        if (i2 < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i2);
        arrayList2.addAll(arrayList);
        return new zzadm(arrayList2);
    }

    @Override // com.google.android.gms.internal.pal.zzadn
    public final zzadn zze() {
        return this.f37350a ? new zzafn(this) : this;
    }

    @Override // com.google.android.gms.internal.pal.zzadn
    public final Object zzf(int i2) {
        return this.f37426b.get(i2);
    }

    @Override // com.google.android.gms.internal.pal.zzadn
    public final List zzh() {
        return Collections.unmodifiableList(this.f37426b);
    }

    public zzadm(int i2) {
        this.f37426b = new ArrayList(i2);
    }

    public zzadm(ArrayList arrayList) {
        this.f37426b = arrayList;
    }

    @Override // com.google.android.gms.internal.pal.zzabj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f37426b.size(), collection);
    }
}
