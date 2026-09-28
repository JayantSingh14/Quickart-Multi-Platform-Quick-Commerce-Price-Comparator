package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class zzku extends zzkx {
    public zzku(int i2, String str, Float f2, Float f3) {
        super(1, str, f2, f3, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(zzl(), ((Float) zzk()).floatValue()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzl())) ? Float.valueOf(bundle.getFloat("com.google.android.gms.ads.flag.".concat(zzl()))) : (Float) zzk();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkx
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(zzl(), ((Float) zzk()).floatValue()));
    }
}
