package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public abstract class zzqi<K, V> implements Map<K, V>, Serializable {

    @CheckForNull
    private transient zzqk zza;

    @CheckForNull
    private transient zzqk zzb;

    @CheckForNull
    private transient zzqb zzc;

    public static zzqi zzc(Map map) {
        if ((map instanceof zzqi) && !(map instanceof SortedMap)) {
            zzqi zzqiVar = (zzqi) map;
            if (!zzqiVar.zzk()) {
                return zzqiVar;
            }
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        zzqh zzqhVar = new zzqh(setEntrySet != null ? setEntrySet.size() : 4);
        zzqhVar.zzb(setEntrySet);
        return zzqhVar.zzc();
    }

    public static zzqi zzd() {
        return zzrc.zza;
    }

    public static zzqi zze(Object obj, Object obj2) {
        zzpm.zzb("adBreakTime", obj2);
        return zzrc.zzl(1, new Object[]{"adBreakTime", obj2}, null);
    }

    public static zzqi zzf(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        zzpm.zzb("IABTCF_AddtlConsent", "String");
        zzpm.zzb("IABTCF_gdprApplies", "Number");
        zzpm.zzb("IABTCF_TCString", "String");
        zzpm.zzb("IABUSPrivacy_String", "String");
        zzpm.zzb("IABGPP_HDR_GppString", "String");
        zzpm.zzb("IABGPP_GppSID", "String");
        return zzrc.zzl(6, new Object[]{"IABTCF_AddtlConsent", "String", "IABTCF_gdprApplies", "Number", "IABTCF_TCString", "String", "IABUSPrivacy_String", "String", "IABGPP_HDR_GppString", "String", "IABGPP_GppSID", "String"}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzrh.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzpm.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public abstract zzqb zza();

    @Override // java.util.Map
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public zzqb values() {
        zzqb zzqbVar = this.zzc;
        if (zzqbVar != null) {
            return zzqbVar;
        }
        zzqb zzqbVarZza = zza();
        this.zzc = zzqbVarZza;
        return zzqbVarZza;
    }

    public abstract zzqk zzg();

    public abstract zzqk zzh();

    @Override // java.util.Map
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzqk entrySet() {
        zzqk zzqkVar = this.zza;
        if (zzqkVar != null) {
            return zzqkVar;
        }
        zzqk zzqkVarZzg = zzg();
        this.zza = zzqkVarZzg;
        return zzqkVarZzg;
    }

    @Override // java.util.Map
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public zzqk keySet() {
        zzqk zzqkVar = this.zzb;
        if (zzqkVar != null) {
            return zzqkVar;
        }
        zzqk zzqkVarZzh = zzh();
        this.zzb = zzqkVarZzh;
        return zzqkVarZzh;
    }

    public abstract boolean zzk();
}
