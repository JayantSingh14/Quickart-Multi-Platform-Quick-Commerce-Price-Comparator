package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class zzty {
    private zzvy zza = zzvy.zza;
    private final zztq zzb = zztp.IDENTITY;
    private final Map zzc = new HashMap();
    private final List zzd = new ArrayList();
    private final List zze = new ArrayList();
    private final zztr zzf = zztx.zza;
    private final zzus zzg = zztx.zzc;
    private final zzus zzh = zztx.zzd;
    private final ArrayDeque zzi = new ArrayDeque();

    public final zztx zza() {
        List list = this.zze;
        ArrayList arrayList = new ArrayList(list.size() + this.zzd.size() + 3);
        arrayList.addAll(this.zzd);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.zze);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        boolean z = zzaan.zza;
        zzvy zzvyVar = this.zza;
        HashMap map = new HashMap(this.zzc);
        ArrayList arrayList3 = new ArrayList(this.zzd);
        ArrayList arrayList4 = new ArrayList(this.zze);
        ArrayList arrayList5 = new ArrayList(this.zzi);
        return new zztx(zzvyVar, this.zzb, map, false, false, false, true, this.zzf, null, false, true, 1, null, 2, 2, arrayList3, arrayList4, arrayList, this.zzg, this.zzh, arrayList5);
    }

    public final zzty zzb(Type type, Object obj) {
        Objects.requireNonNull(type);
        boolean z = obj instanceof zzuj;
        boolean z2 = true;
        if (!z && !(obj instanceof zzub) && !(obj instanceof zztz) && !(obj instanceof zzuu)) {
            z2 = false;
        }
        zzuy.zza(z2);
        if (type == Object.class || zzuc.class.isAssignableFrom((Class) type)) {
            throw new IllegalArgumentException("Cannot override built-in adapter for ".concat(type.toString()));
        }
        if (obj instanceof zztz) {
            this.zzc.put(type, (zztz) obj);
        }
        if (z || (obj instanceof zzub)) {
            this.zzd.add(zzyg.zzb(zzaao.zzb(type), obj));
        }
        if (obj instanceof zzuu) {
            this.zzd.add(zzzt.zza(zzaao.zzb(type), (zzuu) obj));
        }
        return this;
    }

    public final zzty zzc(zzuv zzuvVar) {
        Objects.requireNonNull(zzuvVar);
        this.zzd.add(zzuvVar);
        return this;
    }

    public final zzty zzd(zzop zzopVar) {
        Objects.requireNonNull(zzopVar);
        this.zza = this.zza.zze(zzopVar, true, false);
        return this;
    }
}
