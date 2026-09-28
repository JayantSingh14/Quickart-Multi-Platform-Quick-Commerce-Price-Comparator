package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgsj extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgsk f33154a;

    public /* synthetic */ zzgsj(zzgsk zzgskVar) {
        this.f33154a = zzgskVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f33154a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzgsk zzgskVar = this.f33154a;
        Map mapE = zzgskVar.e();
        return mapE != null ? mapE.values().iterator() : new zzgse(zzgskVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f33154a.size();
    }
}
