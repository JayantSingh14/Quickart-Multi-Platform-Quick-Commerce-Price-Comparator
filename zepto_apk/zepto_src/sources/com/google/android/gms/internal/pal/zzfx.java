package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzfx extends zzgc {
    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object a(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(this.f37747b, ((Integer) this.f37748c).intValue()));
    }

    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object b(Bundle bundle) {
        String str = this.f37747b;
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(str)) ? Integer.valueOf(bundle.getInt("com.google.android.gms.ads.flag.".concat(str))) : (Integer) this.f37748c;
    }

    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object c(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(this.f37747b, ((Integer) this.f37748c).intValue()));
    }
}
