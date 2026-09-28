package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzga extends zzgc {
    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object a(JSONObject jSONObject) {
        return jSONObject.optString(this.f37747b, (String) this.f37748c);
    }

    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object b(Bundle bundle) {
        String str = this.f37747b;
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(str)) ? bundle.getString("com.google.android.gms.ads.flag.".concat(str)) : (String) this.f37748c;
    }

    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object c(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(this.f37747b, (String) this.f37748c);
    }
}
