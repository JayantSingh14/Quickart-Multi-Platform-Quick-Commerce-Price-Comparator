package com.google.android.gms.internal.maps;

import android.support.v4.media.b;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzbe extends zzba {

    /* renamed from: d, reason: collision with root package name */
    public final transient Object f36736d;

    public zzbe(Object obj) {
        this.f36736d = obj;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final void b(Object[] objArr) {
        objArr[0] = this.f36736d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f36736d.equals(obj);
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    /* renamed from: g */
    public final zzbf iterator() {
        return new zzbb(this.f36736d);
    }

    @Override // com.google.android.gms.internal.maps.zzba, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f36736d.hashCode();
    }

    @Override // com.google.android.gms.internal.maps.zzba, com.google.android.gms.internal.maps.zzaw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzbb(this.f36736d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return b.D("[", this.f36736d.toString(), "]");
    }
}
