package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzfy extends zzgc {
    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object a(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(this.f37747b, ((Long) this.f37748c).longValue()));
    }

    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object b(Bundle bundle) {
        String str = this.f37747b;
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(str)) ? Long.valueOf(bundle.getLong("com.google.android.gms.ads.flag.".concat(str))) : (Long) this.f37748c;
    }

    @Override // com.google.android.gms.internal.pal.zzgc
    public final Object c(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(this.f37747b, ((Long) this.f37748c).longValue()));
    }
}
