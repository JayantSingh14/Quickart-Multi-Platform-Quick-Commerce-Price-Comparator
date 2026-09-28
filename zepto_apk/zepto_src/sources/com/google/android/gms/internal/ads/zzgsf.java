package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgsf extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgsk f33145a;

    public /* synthetic */ zzgsf(zzgsk zzgskVar) {
        this.f33145a = zzgskVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f33145a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        zzgsk zzgskVar = this.f33145a;
        Map mapE = zzgskVar.e();
        if (mapE != null) {
            return mapE.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int i2 = zzgskVar.i(entry.getKey());
            if (i2 != -1 && Objects.equals(zzgskVar.c()[i2], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzgsk zzgskVar = this.f33145a;
        Map mapE = zzgskVar.e();
        return mapE != null ? mapE.entrySet().iterator() : new zzgsd(zzgskVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        zzgsk zzgskVar = this.f33145a;
        Map mapE = zzgskVar.e();
        if (mapE != null) {
            return mapE.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (zzgskVar.d()) {
            return false;
        }
        int iG = zzgskVar.g();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object obj2 = zzgskVar.f33156a;
        Objects.requireNonNull(obj2);
        int iD = zzgsl.d(key, value, iG, obj2, zzgskVar.a(), zzgskVar.b(), zzgskVar.c());
        if (iD == -1) {
            return false;
        }
        zzgskVar.f(iD, iG);
        zzgskVar.f33161f--;
        zzgskVar.f33160e += 32;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f33145a.size();
    }
}
