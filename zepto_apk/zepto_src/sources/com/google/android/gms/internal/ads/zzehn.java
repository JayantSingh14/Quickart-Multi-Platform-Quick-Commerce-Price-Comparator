package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzehn implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzflu f29353a;

    public zzehn(zzehu zzehuVar, zzflu zzfluVar) {
        this.f29353a = zzfluVar;
        Objects.requireNonNull(zzehuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        String strValueOf = String.valueOf(th.getMessage());
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.c("Failed to get offline buffered ping database: ".concat(strValueOf));
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.f29353a.zza((SQLiteDatabase) obj);
        } catch (Exception e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Error executing function on offline buffered ping database: ".concat(strValueOf));
        }
    }
}
