package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzps extends AbstractMap implements Serializable, zzpl {
    private final zzpy zza;
    private transient Set zzb;

    public zzps(zzpy zzpyVar) {
        this.zza = zzpyVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return this.zza.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return this.zza.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzb;
        if (set != null) {
            return set;
        }
        zzpt zzptVar = new zzpt(this.zza);
        this.zzb = zzptVar;
        return zzptVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        int iZzc = zzpz.zzc(obj);
        zzpy zzpyVar = this.zza;
        int iZzd = zzpyVar.zzd(obj, iZzc);
        if (iZzd == -1) {
            return null;
        }
        return zzpyVar.zza[iZzd];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.zza.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        return this.zza.zzh(obj, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        int iZzc = zzpz.zzc(obj);
        zzpy zzpyVar = this.zza;
        int iZzd = zzpyVar.zzd(obj, iZzc);
        if (iZzd == -1) {
            return null;
        }
        Object obj2 = zzpyVar.zza[iZzd];
        zzpyVar.zzm(iZzd, iZzc);
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.zzc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Collection values() {
        return this.zza.keySet();
    }
}
