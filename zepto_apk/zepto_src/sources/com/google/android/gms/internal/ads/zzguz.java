package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzguz extends zzgtd {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzgva f33235c;

    public zzguz(zzgva zzgvaVar) {
        Objects.requireNonNull(zzgvaVar);
        this.f33235c = zzgvaVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzgva zzgvaVar = this.f33235c;
        zzgqa.i(i2, zzgvaVar.f33238f);
        int i3 = i2 + i2;
        Object[] objArr = zzgvaVar.f33237e;
        Object obj = objArr[i3];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i3 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final boolean j() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f33235c.f33238f;
    }
}
