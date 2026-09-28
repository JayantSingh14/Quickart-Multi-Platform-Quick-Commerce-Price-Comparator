package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzegl implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzflu f29284a;

    public zzegl(zzegn zzegnVar, zzflu zzfluVar) {
        this.f29284a = zzfluVar;
        Objects.requireNonNull(zzegnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        String strValueOf = String.valueOf(th.getMessage());
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.c("Failed to get offline signal database: ".concat(strValueOf));
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.f29284a.zza((SQLiteDatabase) obj);
        } catch (Exception e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Error executing function on offline signal database: ".concat(strValueOf));
        }
    }
}
