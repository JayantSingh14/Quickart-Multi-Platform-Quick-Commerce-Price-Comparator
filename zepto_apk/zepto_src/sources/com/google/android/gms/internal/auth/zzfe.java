package com.google.android.gms.internal.auth;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class zzfe extends zzdr implements RandomAccess, zzff {

    /* renamed from: b, reason: collision with root package name */
    public final List f36357b;

    static {
        new zzfe((Object) null);
    }

    public zzfe() {
        this(10);
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        b();
        this.f36357b.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        b();
        if (collection instanceof zzff) {
            collection = ((zzff) collection).zzg();
        }
        boolean zAddAll = this.f36357b.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        b();
        this.f36357b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String get(int i2) {
        List list = this.f36357b;
        Object obj = list.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzef) {
            zzef zzefVar = (zzef) obj;
            String strJ = zzefVar.f() == 0 ? "" : zzefVar.j(zzfa.f36355a);
            if (zzefVar.k()) {
                list.set(i2, strJ);
            }
            return strJ;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, zzfa.f36355a);
        if (zzhn.f36430a.b(bArr, 0, bArr.length)) {
            list.set(i2, str);
        }
        return str;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        Object objRemove = this.f36357b.remove(i2);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof zzef)) {
            return new String((byte[]) objRemove, zzfa.f36355a);
        }
        zzef zzefVar = (zzef) objRemove;
        return zzefVar.f() == 0 ? "" : zzefVar.j(zzfa.f36355a);
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b();
        Object obj2 = this.f36357b.set(i2, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof zzef)) {
            return new String((byte[]) obj2, zzfa.f36355a);
        }
        zzef zzefVar = (zzef) obj2;
        return zzefVar.f() == 0 ? "" : zzefVar.j(zzfa.f36355a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36357b.size();
    }

    @Override // com.google.android.gms.internal.auth.zzez
    public final zzez zzd(int i2) {
        List list = this.f36357b;
        if (i2 < list.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i2);
        arrayList.addAll(list);
        return new zzfe(arrayList);
    }

    @Override // com.google.android.gms.internal.auth.zzff
    public final zzff zze() {
        return this.f36324a ? new zzhe(this) : this;
    }

    @Override // com.google.android.gms.internal.auth.zzff
    public final List zzg() {
        return Collections.unmodifiableList(this.f36357b);
    }

    public zzfe(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        super(true);
        this.f36357b = arrayList;
    }

    public zzfe(ArrayList arrayList) {
        super(true);
        this.f36357b = arrayList;
    }

    public zzfe(Object obj) {
        super(false);
        this.f36357b = Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.internal.auth.zzdr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f36357b.size(), collection);
    }
}
