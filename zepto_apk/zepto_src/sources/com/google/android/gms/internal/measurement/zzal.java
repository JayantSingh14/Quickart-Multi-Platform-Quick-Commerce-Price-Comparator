package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class zzal implements zzao, zzak {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f36765a = new HashMap();

    @Override // com.google.android.gms.internal.measurement.zzak
    public final zzao b(String str) {
        HashMap map = this.f36765a;
        return map.containsKey(str) ? (zzao) map.get(str) : zzao.o0;
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final void d(String str, zzao zzaoVar) {
        HashMap map = this.f36765a;
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
        if (obj instanceof zzal) {
            return this.f36765a.equals(((zzal) obj).f36765a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao f() {
        zzal zzalVar = new zzal();
        for (Map.Entry entry : this.f36765a.entrySet()) {
            boolean z = entry.getValue() instanceof zzak;
            HashMap map = zzalVar.f36765a;
            if (z) {
                map.put((String) entry.getKey(), (zzao) entry.getValue());
            } else {
                map.put((String) entry.getKey(), ((zzao) entry.getValue()).f());
            }
        }
        return zzalVar;
    }

    public final int hashCode() {
        return this.f36765a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public zzao i(String str, zzg zzgVar, ArrayList arrayList) {
        return "toString".equals(str) ? new zzas(toString()) : zzak.g(this, new zzas(str), zzgVar, arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final boolean j(String str) {
        return this.f36765a.containsKey(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        HashMap map = this.f36765a;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(String.format("%s: %s,", str, map.get(str)));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return "[object Object]";
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
        return new zzaj(this.f36765a.keySet().iterator());
    }
}
