package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class zzagp implements Map.Entry, Comparable, Serializable {
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzagp zzagpVar = (zzagp) obj;
        zzagg zzaggVar = new zzagg();
        zzaggVar.zzb(zza(), zzagpVar.zza(), null);
        zzaggVar.zzb(zzb(), zzagpVar.zzb(), null);
        return zzaggVar.zza();
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (Objects.equals(zza(), entry.getKey()) && Objects.equals(zzb(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return zza();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return zzb();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return Objects.hashCode(zza()) ^ Objects.hashCode(zzb());
    }

    public final String toString() {
        return b.m("(", String.valueOf(zza()), ",", String.valueOf(zzb()), ")");
    }

    public abstract Object zza();

    public abstract Object zzb();
}
