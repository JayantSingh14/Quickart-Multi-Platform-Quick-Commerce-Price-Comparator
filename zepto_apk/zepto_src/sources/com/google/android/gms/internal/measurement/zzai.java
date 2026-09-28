package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class zzai implements zzao, zzak {

    /* renamed from: a, reason: collision with root package name */
    public final String f36762a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f36763b = new HashMap();

    public zzai(String str) {
        this.f36762a = str;
    }

    public abstract zzao a(zzg zzgVar, List list);

    @Override // com.google.android.gms.internal.measurement.zzak
    public final zzao b(String str) {
        HashMap map = this.f36763b;
        return map.containsKey(str) ? (zzao) map.get(str) : zzao.o0;
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final void d(String str, zzao zzaoVar) {
        HashMap map = this.f36763b;
        if (zzaoVar == null) {
            map.remove(str);
        } else {
            map.put(str, zzaoVar);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzaiVar = (zzai) obj;
        String str = this.f36762a;
        if (str != null) {
            return str.equals(zzaiVar.f36762a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public zzao f() {
        return this;
    }

    public final int hashCode() {
        String str = this.f36762a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao i(String str, zzg zzgVar, ArrayList arrayList) {
        return "toString".equals(str) ? new zzas(this.f36762a) : zzak.g(this, new zzas(str), zzgVar, arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final boolean j(String str) {
        return this.f36763b.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return this.f36762a;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzaj(this.f36763b.keySet().iterator());
    }
}
