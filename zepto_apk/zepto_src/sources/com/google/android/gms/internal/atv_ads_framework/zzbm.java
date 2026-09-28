package com.google.android.gms.internal.atv_ads_framework;

import java.util.AbstractMap;

/* loaded from: classes4.dex */
final class zzbm extends zzbe {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbn f36061c;

    public zzbm(zzbn zzbnVar) {
        this.f36061c = zzbnVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        zzbn zzbnVar = this.f36061c;
        zzaq.a(i2, zzbnVar.f36064e);
        int i3 = i2 + i2;
        Object[] objArr = zzbnVar.f36063d;
        Object obj = objArr[i3];
        obj.getClass();
        Object obj2 = objArr[i3 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final boolean j() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36061c.f36064e;
    }
}
