package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: classes3.dex */
public final class zzdx {
    static final zzqi zza = zzqi.zzf("IABTCF_AddtlConsent", "String", "IABTCF_gdprApplies", "Number", "IABTCF_TCString", "String", "IABUSPrivacy_String", "String", "IABGPP_HDR_GppString", "String", "IABGPP_GppSID", "String");
    public final zzqi zzb;

    private zzdx(zzqi zzqiVar) {
        this.zzb = zzqiVar;
    }

    public static zzdx zza(com.google.ads.interactivemedia.v3.impl.data.zzcf zzcfVar) {
        Map<String, String> map;
        zzqi zzqiVarZzc = zza;
        com.google.ads.interactivemedia.v3.impl.data.zzcd zzcdVar = zzcfVar.consentSettingsConfig;
        if (zzcdVar != null && (map = zzcdVar.consentKeyTypes) != null) {
            zzqiVarZzc = zzqi.zzc(map);
        }
        return new zzdx(zzqiVarZzc);
    }
}
