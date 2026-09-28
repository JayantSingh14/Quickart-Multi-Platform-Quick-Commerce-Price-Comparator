package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzagh;
import com.google.ads.interactivemedia.v3.internal.zzagk;
import com.google.ads.interactivemedia.v3.internal.zzov;
import com.google.ads.interactivemedia.v3.internal.zzow;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzcd {
    public final Map<String, String> consentKeyTypes;

    public zzcd(Map<String, String> map) {
        this.consentKeyTypes = map;
    }

    public Map<String, Object> constructMap() {
        HashMap map = new HashMap();
        map.put("consentKeyTypes", this.consentKeyTypes);
        return map;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return zzagh.zzf(this, obj, false, null, false, new String[0]);
    }

    public int hashCode() {
        return zzagk.zza(this, new String[0]);
    }

    public String toString() {
        zzov zzovVarZza = zzow.zza(this);
        zzovVarZza.zza("consentKeyTypes", this.consentKeyTypes);
        return zzovVarZza.toString();
    }
}
