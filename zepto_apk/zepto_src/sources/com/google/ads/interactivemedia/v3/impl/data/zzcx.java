package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.UniversalAdId;
import com.google.ads.interactivemedia.v3.internal.zzagh;
import com.google.ads.interactivemedia.v3.internal.zzagk;

/* loaded from: classes3.dex */
public final class zzcx implements UniversalAdId {
    private String adIdValue = zzck.UNKNOWN_CONTENT_TYPE;
    private String adIdRegistry = zzck.UNKNOWN_CONTENT_TYPE;

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return zzagh.zzf(this, obj, false, null, false, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.v3.api.UniversalAdId
    public String getAdIdRegistry() {
        return this.adIdRegistry;
    }

    @Override // com.google.ads.interactivemedia.v3.api.UniversalAdId
    public String getAdIdValue() {
        return this.adIdValue;
    }

    public int hashCode() {
        return zzagk.zza(this, new String[0]);
    }

    public void setAdIdRegistry(String str) {
        this.adIdRegistry = str;
    }

    public void setAdIdValue(String str) {
        this.adIdValue = str;
    }

    public String toString() {
        return b.m("UniversalAdId [adIdValue=", this.adIdValue, ", adIdRegistry=", this.adIdRegistry, "]");
    }
}
