package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzfz extends zzgc {
    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object a(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(this.f37747b, ((Float) this.f37748c).floatValue()));
    }

    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object b(Bundle bundle) {
        String str = this.f37747b;
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(str)) ? Float.valueOf(bundle.getFloat("com.google.android.gms.ads.flag.".concat(str))) : (Float) this.f37748c;
    }

    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object c(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(this.f37747b, ((Float) this.f37748c).floatValue()));
    }
}
