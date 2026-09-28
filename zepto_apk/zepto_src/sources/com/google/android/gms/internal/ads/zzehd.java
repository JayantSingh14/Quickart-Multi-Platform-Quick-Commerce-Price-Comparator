package com.google.android.gms.internal.ads;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbfp;

/* loaded from: classes4.dex */
public final class zzehd implements zzfmv {

    /* renamed from: a, reason: collision with root package name */
    public final zzegr f29331a;

    /* renamed from: b, reason: collision with root package name */
    public final zzegv f29332b;

    public zzehd(zzegr zzegrVar, zzegv zzegvVar) {
        this.f29331a = zzegrVar;
        this.f29332b = zzegvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void c(zzfmo zzfmoVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R6)).booleanValue()) {
            if (zzfmo.RENDERER == zzfmoVar) {
                zzegr zzegrVar = this.f29331a;
                long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
                synchronized (zzegrVar) {
                    synchronized (zzegrVar.f29304i) {
                        zzegrVar.f29299d = jElapsedRealtime;
                    }
                }
                return;
            }
            if (zzfmo.PRELOADED_LOADER == zzfmoVar || zzfmo.SERVER_TRANSACTION == zzfmoVar) {
                zzegr zzegrVar2 = this.f29331a;
                long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
                synchronized (zzegrVar2) {
                    synchronized (zzegrVar2.f29301f) {
                        zzegrVar2.f29296a = jElapsedRealtime2;
                    }
                }
                final zzegv zzegvVar = this.f29332b;
                final long jA = zzegrVar2.a();
                zzegvVar.f29325b.a(new zzflu() { // from class: com.google.android.gms.internal.ads.zzegu
                    @Override // com.google.android.gms.internal.ads.zzflu
                    public final Object zza(Object obj) throws SQLException {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzegvVar.f29324a.q()) {
                            return null;
                        }
                        zzbfp.zzaf.zza.C0025zza c0025zzaT = zzbfp.zzaf.zza.T();
                        c0025zzaT.j();
                        zzbfp.zzaf.zza zzaVar = (zzbfp.zzaf.zza) c0025zzaT.f34638b;
                        long j2 = jA;
                        zzaVar.O(j2);
                        byte[] bArrG = ((zzbfp.zzaf.zza) c0025zzaT.l()).g();
                        sQLiteDatabase.execSQL("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = 'total_requests'");
                        zzehc.b(sQLiteDatabase, j2, bArrG);
                        return null;
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void j(zzfmo zzfmoVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R6)).booleanValue() && zzfmo.RENDERER == zzfmoVar) {
            zzegr zzegrVar = this.f29331a;
            if (zzegrVar.b() != 0) {
                long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - zzegrVar.b();
                synchronized (zzegrVar) {
                    synchronized (zzegrVar.f29305j) {
                        zzegrVar.f29300e = jElapsedRealtime;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void t(zzfmo zzfmoVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R6)).booleanValue() && zzfmo.RENDERER == zzfmoVar) {
            zzegr zzegrVar = this.f29331a;
            if (zzegrVar.b() != 0) {
                long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - zzegrVar.b();
                synchronized (zzegrVar) {
                    synchronized (zzegrVar.f29305j) {
                        zzegrVar.f29300e = jElapsedRealtime;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void m(String str) {
    }
}
