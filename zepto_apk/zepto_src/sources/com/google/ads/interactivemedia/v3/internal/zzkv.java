package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class zzkv extends zzkx {
    public zzkv(int i2, String str, String str2, String str3) {
        super(1, str, str2, str3, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return jSONObject.optString(zzl(), (String) zzk());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzl())) ? bundle.getString("com.google.android.gms.ads.flag.".concat(zzl())) : (String) zzk();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(zzl(), (String) zzk());
    }
}
