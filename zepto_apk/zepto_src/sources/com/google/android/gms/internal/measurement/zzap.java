package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzap implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final String f36769a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f36770b;

    public zzap(String str, ArrayList arrayList) {
        this.f36769a = str;
        ArrayList arrayList2 = new ArrayList();
        this.f36770b = arrayList2;
        arrayList2.addAll(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzap)) {
            return false;
        }
        zzap zzapVar = (zzap) obj;
        String str = this.f36769a;
        if (str == null ? zzapVar.f36769a == null : str.equals(zzapVar.f36769a)) {
            return this.f36770b.equals(zzapVar.f36770b);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao f() {
        return this;
    }

    public final int hashCode() {
        String str = this.f36769a;
        return this.f36770b.hashCode() + ((str != null ? str.hashCode() : 0) * 31);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao i(String str, zzg zzgVar, ArrayList arrayList) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }
}
