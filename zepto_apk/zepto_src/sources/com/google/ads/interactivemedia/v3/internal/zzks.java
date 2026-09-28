package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class zzks extends zzkx {
    public zzks(int i2, String str, Integer num, Integer num2) {
        super(1, str, num, num2, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(zzl(), ((Integer) zzk()).intValue()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzl())) ? Integer.valueOf(bundle.getInt("com.google.android.gms.ads.flag.".concat(zzl()))) : (Integer) zzk();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(zzl(), ((Integer) zzk()).intValue()));
    }
}
