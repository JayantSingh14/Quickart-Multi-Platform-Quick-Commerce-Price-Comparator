package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class zzgw implements zzgz {

    @Nullable
    private static zzgw zzb;
    private final Context zzc;
    private final zznr zzd;
    private final zzny zze;
    private final zzoa zzf;
    private final zzib zzg;
    private final zzmo zzh;
    private final Executor zzi;
    private final zznx zzj;
    private final zziq zzl;

    @Nullable
    private final zzii zzm;

    @Nullable
    private final zzhz zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;

    @VisibleForTesting
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    @VisibleForTesting
    public zzgw(@NonNull Context context, @NonNull zzmo zzmoVar, @NonNull zznr zznrVar, @NonNull zzny zznyVar, @NonNull zzoa zzoaVar, @NonNull zzib zzibVar, @NonNull Executor executor, @NonNull zzmj zzmjVar, int i2, @Nullable zziq zziqVar, @Nullable zzii zziiVar, @Nullable zzhz zzhzVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzmoVar;
        this.zzd = zznrVar;
        this.zze = zznyVar;
        this.zzf = zzoaVar;
        this.zzg = zzibVar;
        this.zzi = executor;
        this.zzr = i2;
        this.zzl = zziqVar;
        this.zzm = zziiVar;
        this.zzn = zzhzVar;
        this.zzq = false;
        this.zzj = new zzgu(this, zzmjVar);
    }

    public static synchronized zzgw zza(@NonNull String str, @NonNull Context context, boolean z, boolean z2) {
        return zzb(str, context, Executors.newCachedThreadPool(), z, z2);
    }

    @Deprecated
    public static synchronized zzgw zzb(@NonNull String str, @NonNull Context context, @NonNull Executor executor, boolean z, boolean z2) {
        try {
            if (zzb == null) {
                zzmp zzmpVarZza = zzmq.zza();
                zzmpVarZza.zza(str);
                zzmpVarZza.zzc(z);
                zzmq zzmqVarZzd = zzmpVarZza.zzd();
                zzmo zzmoVarZza = zzmo.zza(context, executor, z2);
                zzhk zzhkVarZzc = ((Boolean) zzkq.zzc().zza(zzlg.zzdl)).booleanValue() ? zzhk.zzc(context) : null;
                zziq zziqVarZzd = ((Boolean) zzkq.zzc().zza(zzlg.zzdm)).booleanValue() ? zziq.zzd(context, executor) : null;
                zzii zziiVar = ((Boolean) zzkq.zzc().zza(zzlg.zzcA)).booleanValue() ? new zzii() : null;
                zzhz zzhzVar = ((Boolean) zzkq.zzc().zza(zzlg.zzcC)).booleanValue() ? new zzhz() : null;
                zznf zznfVarZze = zznf.zze(context, executor, zzmoVarZza, zzmqVarZzd);
                zzia zziaVar = new zzia(context);
                zzii zziiVar2 = zziiVar;
                zzib zzibVar = new zzib(zzmqVarZzd, zznfVarZze, new zzio(context, zziaVar), zziaVar, zzhkVarZzc, zziqVarZzd, zziiVar2, zzhzVar);
                int iZzb = zzng.zzb(context, zzmoVarZza);
                zzmj zzmjVar = new zzmj();
                zzgw zzgwVar = new zzgw(context, zzmoVarZza, new zznr(context, iZzb), new zzny(context, iZzb, new zzgt(zzmoVarZza), ((Boolean) zzkq.zzc().zza(zzlg.zzcj)).booleanValue()), new zzoa(context, zzibVar, zzmoVarZza, zzmjVar), zzibVar, executor, zzmjVar, iZzb, zziqVarZzd, zziiVar2, zzhzVar);
                zzb = zzgwVar;
                zzgwVar.zzm();
                zzb.zzo();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00fc A[Catch: all -> 0x009d, zzacz -> 0x00a0, TryCatch #0 {zzacz -> 0x00a0, blocks: (B:6:0x0021, B:8:0x0032, B:12:0x0038, B:13:0x0044, B:15:0x0052, B:17:0x0060, B:20:0x006d, B:32:0x00a3, B:36:0x00bc, B:42:0x00d5, B:43:0x00e2, B:45:0x00e8, B:47:0x00f0, B:48:0x00f2, B:39:0x00c6, B:40:0x00cd, B:23:0x0074, B:25:0x008a, B:49:0x00fc, B:50:0x0109, B:51:0x0116), top: B:58:0x0021, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* bridge */ /* synthetic */ void zzj(com.google.ads.interactivemedia.v3.internal.zzgw r12) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzgw.zzj(com.google.ads.interactivemedia.v3.internal.zzgw):void");
    }

    private final void zzt() {
        zziq zziqVar = this.zzl;
        if (zziqVar != null) {
            zziqVar.zzh();
        }
    }

    private final zznq zzu(int i2) {
        if (zzng.zza(this.zzr)) {
            return ((Boolean) zzkq.zzc().zza(zzlg.zzch)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzc(1);
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zze(Context context, String str, @Nullable View view, @Nullable Activity activity) {
        zzt();
        if (((Boolean) zzkq.zzc().zza(zzlg.zzcA)).booleanValue()) {
            this.zzm.zzi();
        }
        zzo();
        zzmr zzmrVarZza = this.zzf.zza();
        if (zzmrVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzmrVarZza.zza(context, null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zzf(Context context) {
        zzt();
        if (((Boolean) zzkq.zzc().zza(zzlg.zzcA)).booleanValue()) {
            this.zzm.zzj();
        }
        zzo();
        zzmr zzmrVarZza = this.zzf.zza();
        if (zzmrVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzc = zzmrVarZza.zzc(context, null);
        this.zzh.zzf(5001, System.currentTimeMillis() - jCurrentTimeMillis, strZzc, null);
        return strZzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zzg(Context context, byte[] bArr) {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zzh(Context context, @Nullable View view, @Nullable Activity activity) {
        zzt();
        if (((Boolean) zzkq.zzc().zza(zzlg.zzcA)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzo();
        zzmr zzmrVarZza = this.zzf.zza();
        if (zzmrVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzmrVarZza.zzb(context, null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final void zzk(@Nullable MotionEvent motionEvent) {
        zzmr zzmrVarZza = this.zzf.zza();
        if (zzmrVarZza != null) {
            try {
                zzmrVarZza.zzd(null, motionEvent);
            } catch (zznz e2) {
                this.zzh.zzc(e2.zza(), -1L, e2);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final void zzl(int i2, int i3, int i4) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) zzkq.zzc().zza(zzlg.zzlD)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f2 = i2;
        float f3 = displayMetrics.density;
        float f4 = i3;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f2 * f3, f4 * f3, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain);
        motionEventObtain.recycle();
        float f5 = displayMetrics.density;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 2, f2 * f5, f4 * f5, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain2);
        motionEventObtain2.recycle();
        float f6 = displayMetrics.density;
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, i4, 1, f2 * f6, f4 * f6, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    public final synchronized void zzm() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zznq zznqVarZzu = zzu(1);
        if (zznqVarZzu == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.zzf.zzc(zznqVarZzu)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final void zzn(@Nullable View view) {
        this.zzg.zzd(view);
    }

    public final void zzo() {
        if (this.zzp) {
            return;
        }
        synchronized (this.zzo) {
            try {
                if (!this.zzp) {
                    if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                        return;
                    }
                    zznq zznqVarZzb = this.zzf.zzb();
                    if ((zznqVarZzb == null || zznqVarZzb.zzd(3600L)) && zzng.zza(this.zzr)) {
                        this.zzi.execute(new zzgv(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final boolean zzq() {
        return zzr();
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final boolean zzs() throws InterruptedException {
        try {
            this.zzk.await();
        } catch (InterruptedException unused) {
        }
        return zzr();
    }
}
