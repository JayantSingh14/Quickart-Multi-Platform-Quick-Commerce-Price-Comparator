package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbge implements zzbja {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f24995a;

    public zzbge(zzbgi zzbgiVar, SharedPreferences sharedPreferences) {
        this.f24995a = sharedPreferences;
        Objects.requireNonNull(zzbgiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final String a(String str, String str2) {
        return this.f24995a.getString(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final Double b(String str, double d2) {
        try {
            return Double.valueOf(r0.getFloat(str, (float) d2));
        } catch (ClassCastException unused) {
            return Double.valueOf(this.f24995a.getString(str, String.valueOf(d2)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final Boolean zza(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f24995a;
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, z));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(sharedPreferences.getString(str, String.valueOf(z)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final Long zzb(String str, long j2) {
        try {
            return Long.valueOf(this.f24995a.getLong(str, j2));
        } catch (ClassCastException unused) {
            return Long.valueOf(r0.getInt(str, (int) j2));
        }
    }
}
