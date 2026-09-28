package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzr.class)
/* loaded from: classes3.dex */
public abstract class zzbk {
    private String companionId;

    private static zzbk create(String str, String str2, String str3, zzbj zzbjVar) {
        return new zzr(str, str2, str3, zzbjVar);
    }

    public abstract String clickThroughUrl();

    public String companionId() {
        return this.companionId;
    }

    public abstract String size();

    public abstract String src();

    public final String toString() {
        String strCompanionId = companionId();
        String size = size();
        String strSrc = src();
        String strClickThroughUrl = clickThroughUrl();
        String strValueOf = String.valueOf(type());
        StringBuilder sbV = e.v("CompanionData [companionId=", strCompanionId, ", size=", size, ", src=");
        b.B(sbV, strSrc, ", clickThroughUrl=", strClickThroughUrl, ", type=");
        return b.r(sbV, strValueOf, "]");
    }

    public abstract zzbj type();

    public static zzbk create(String str, String str2, String str3, String str4, zzbj zzbjVar) {
        zzbk zzbkVarCreate = create(str2, str3, str4, zzbjVar);
        zzbkVarCreate.companionId = str;
        return zzbkVarCreate;
    }
}
