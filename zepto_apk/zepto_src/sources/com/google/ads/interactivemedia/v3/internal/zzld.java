package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;

/* loaded from: classes3.dex */
final class zzld implements zzlm {
    final /* synthetic */ SharedPreferences zza;

    public zzld(zzle zzleVar, SharedPreferences sharedPreferences) {
        this.zza = sharedPreferences;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzlm
    public final Boolean zza(String str, boolean z) {
        try {
            return Boolean.valueOf(this.zza.getBoolean(str, z));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(this.zza.getString(str, String.valueOf(z)));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzlm
    public final Long zzb(String str, long j2) {
        try {
            return Long.valueOf(this.zza.getLong(str, j2));
        } catch (ClassCastException unused) {
            return Long.valueOf(this.zza.getInt(str, (int) j2));
        }
    }
}
