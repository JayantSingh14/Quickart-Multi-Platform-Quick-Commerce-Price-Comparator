package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.common.api.Api;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zzqs {
    @CheckForNull
    public static Object zza(@CheckForNull Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static HashMap zzb(int i2) {
        int iCeil;
        if (i2 < 3) {
            zzpm.zza(i2, "expectedSize");
            iCeil = i2 + 1;
        } else {
            iCeil = i2 < 1073741824 ? (int) Math.ceil(i2 / 0.75d) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return new HashMap(iCeil);
    }
}
