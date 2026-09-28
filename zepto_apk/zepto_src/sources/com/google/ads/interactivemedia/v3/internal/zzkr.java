package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class zzkr extends zzkx {
    public zzkr(int i2, String str, Boolean bool, Boolean bool2) {
        super(i2, str, bool, bool2, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(zzl(), ((Boolean) zzk()).booleanValue()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzl())) ? Boolean.valueOf(bundle.getBoolean("com.google.android.gms.ads.flag.".concat(zzl()))) : (Boolean) zzk();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(zzl(), ((Boolean) zzk()).booleanValue()));
    }
}
