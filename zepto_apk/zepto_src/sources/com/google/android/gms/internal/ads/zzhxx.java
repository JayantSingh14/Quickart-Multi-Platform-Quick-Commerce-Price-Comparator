package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzhxx extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzhya f34478a;

    public zzhxx(zzhya zzhyaVar) {
        this.f34478a = zzhyaVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f34478a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f34478a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzhxw(this.f34478a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        zzhya zzhyaVar = this.f34478a;
        zzhyaVar.getClass();
        zzhxz zzhxzVarA = null;
        if (obj != null) {
            try {
                zzhxzVarA = zzhyaVar.a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        if (zzhxzVarA != null) {
            zzhyaVar.b(zzhxzVarA, true);
        }
        return zzhxzVarA != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f34478a.f34499d;
    }
}
