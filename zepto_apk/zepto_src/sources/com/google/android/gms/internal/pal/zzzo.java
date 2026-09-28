package com.google.android.gms.internal.pal;

import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzzo extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzzr f38171a;

    public zzzo(zzzr zzzrVar) {
        this.f38171a = zzzrVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f38171a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f38171a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzzn(this.f38171a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        zzzr zzzrVar = this.f38171a;
        zzzq zzzqVarA = null;
        if (obj != null) {
            try {
                zzzqVarA = zzzrVar.a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        if (zzzqVarA != null) {
            zzzrVar.b(zzzqVarA, true);
        }
        return zzzqVarA != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f38171a.f38187c;
    }
}
