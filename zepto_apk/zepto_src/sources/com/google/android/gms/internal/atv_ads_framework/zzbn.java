package com.google.android.gms.internal.atv_ads_framework;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzbn extends zzbi {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzbh f36062c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f36063d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f36064e;

    public zzbn(zzbh zzbhVar, Object[] objArr, int i2) {
        this.f36062c = zzbhVar;
        this.f36063d = objArr;
        this.f36064e = i2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int b(Object[] objArr) {
        return g().b(objArr);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f36062c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    /* renamed from: i */
    public final zzbu iterator() {
        return g().listIterator(0);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi, com.google.android.gms.internal.atv_ads_framework.zzbb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return g().listIterator(0);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi
    public final zzbe n() {
        return new zzbm(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f36064e;
    }
}
