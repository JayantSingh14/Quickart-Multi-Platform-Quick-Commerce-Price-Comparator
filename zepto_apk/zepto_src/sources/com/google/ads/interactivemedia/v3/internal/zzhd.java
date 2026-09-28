package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class zzhd implements Runnable, zzgz {
    private Context zzc;
    private final zzmo zzd;
    private final Executor zze;
    private final zzm zzf;
    private final boolean zzg;
    private final AtomicReference zzb = new AtomicReference();
    final CountDownLatch zza = new CountDownLatch(1);
    private final List zzh = new ArrayList();

    public zzhd(Context context, Executor executor, zzm zzmVar) {
        this.zzf = zzmVar;
        this.zzc = context;
        this.zze = executor;
        zzlg.zza(context);
        boolean z = ((Boolean) zzkq.zzc().zza(zzlg.zzcm)).booleanValue() && zzmVar.zzh();
        this.zzg = z;
        this.zzd = zzmo.zza(context, executor, z);
        executor.execute(this);
    }

    private final void zzd() {
        if (this.zzh.isEmpty() || this.zzb.get() == null) {
            return;
        }
        for (Object[] objArr : this.zzh) {
            int length = objArr.length;
            if (length == 1) {
                ((zzgz) this.zzb.get()).zzk((MotionEvent) objArr[0]);
            } else if (length == 3) {
                ((zzgz) this.zzb.get()).zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzh.clear();
    }

    private final boolean zzi() {
        String strZzc = this.zzf.zzc();
        Context contextZzj = zzj(this.zzc);
        boolean zZzg = this.zzf.zzg();
        zzhe.zzr(contextZzj, zZzg);
        this.zzb.set(new zzhf(contextZzj, strZzc, zZzg));
        return true;
    }

    private static final Context zzj(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[Catch: all -> 0x0049, NullPointerException -> 0x004b, TryCatch #0 {NullPointerException -> 0x004b, blocks: (B:3:0x0005, B:16:0x004d, B:18:0x0051, B:20:0x005c, B:21:0x0067, B:23:0x008c, B:25:0x0094, B:6:0x0013, B:8:0x003e), top: B:35:0x0005, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[Catch: all -> 0x0049, NullPointerException -> 0x004b, TryCatch #0 {NullPointerException -> 0x004b, blocks: (B:3:0x0005, B:16:0x004d, B:18:0x0051, B:20:0x005c, B:21:0x0067, B:23:0x008c, B:25:0x0094, B:6:0x0013, B:8:0x003e), top: B:35:0x0005, outer: #1 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            int r3 = r3.zzk()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            int r3 = r3 + (-1)
            r4 = 3
            r5 = 2
            if (r3 == r5) goto L13
        L11:
            r3 = r5
            goto L4d
        L13:
            android.content.Context r3 = r11.zzc     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            com.google.ads.interactivemedia.v3.internal.zzmo r6 = r11.zzd     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            com.google.ads.interactivemedia.v3.internal.zzhc r7 = new com.google.ads.interactivemedia.v3.internal.zzhc     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            r7.<init>(r11)     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            com.google.ads.interactivemedia.v3.internal.zzny r8 = new com.google.ads.interactivemedia.v3.internal.zzny     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            android.content.Context r9 = r11.zzc     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            int r3 = com.google.ads.interactivemedia.v3.internal.zzng.zzb(r3, r6)     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            com.google.ads.interactivemedia.v3.internal.zzkx r6 = com.google.ads.interactivemedia.v3.internal.zzlg.zzcj     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            com.google.ads.interactivemedia.v3.internal.zzle r10 = com.google.ads.interactivemedia.v3.internal.zzkq.zzc()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            java.lang.Object r6 = r10.zza(r6)     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            r8.<init>(r9, r3, r7, r6)     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            r3 = 1
            boolean r3 = r8.zzd(r3)     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            if (r3 != 0) goto L47
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            boolean r3 = r3.zzi()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            if (r3 == 0) goto L47
            goto L11
        L47:
            r3 = r4
            goto L4d
        L49:
            r0 = move-exception
            goto Lb7
        L4b:
            r3 = move-exception
            goto L98
        L4d:
            int r3 = r3 + (-1)
            if (r3 == r5) goto L67
            r11.zzi()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            int r3 = r3.zzk()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            if (r3 != r4) goto Laf
            java.util.concurrent.Executor r3 = r11.zze     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            com.google.ads.interactivemedia.v3.internal.zzhb r4 = new com.google.ads.interactivemedia.v3.internal.zzhb     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            r4.<init>()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            r3.execute(r4)     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            goto Laf
        L67:
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            java.lang.String r3 = r3.zzc()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            android.content.Context r4 = r11.zzc     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            android.content.Context r4 = zzj(r4)     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            java.util.concurrent.Executor r5 = r11.zze     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            com.google.ads.interactivemedia.v3.internal.zzm r6 = r11.zzf     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            boolean r6 = r6.zzg()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            boolean r7 = r11.zzg     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            com.google.ads.interactivemedia.v3.internal.zzgw r3 = com.google.ads.interactivemedia.v3.internal.zzgw.zzb(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            java.util.concurrent.atomic.AtomicReference r4 = r11.zzb     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            r4.set(r3)     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            boolean r3 = r3.zzr()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            if (r3 != 0) goto Laf
            com.google.ads.interactivemedia.v3.internal.zzm r3 = r11.zzf     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            boolean r3 = r3.zzi()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            if (r3 == 0) goto Laf
            r11.zzi()     // Catch: java.lang.Throwable -> L49 java.lang.NullPointerException -> L4b
            goto Laf
        L98:
            com.google.ads.interactivemedia.v3.internal.zzm r4 = r11.zzf     // Catch: java.lang.Throwable -> L49
            boolean r4 = r4.zzi()     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto La3
            r11.zzi()     // Catch: java.lang.Throwable -> L49
        La3:
            com.google.ads.interactivemedia.v3.internal.zzmo r4 = r11.zzd     // Catch: java.lang.Throwable -> L49
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L49
            long r5 = r5 - r0
            r0 = 2031(0x7ef, float:2.846E-42)
            r4.zzc(r0, r5, r3)     // Catch: java.lang.Throwable -> L49
        Laf:
            r11.zzc = r2
            java.util.concurrent.CountDownLatch r0 = r11.zza
            r0.countDown()
            return
        Lb7:
            r11.zzc = r2
            java.util.concurrent.CountDownLatch r1 = r11.zza
            r1.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzhd.run():void");
    }

    public final zzgz zza() {
        return (zzgz) this.zzb.get();
    }

    public final /* synthetic */ void zzc() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            zzgw.zza(this.zzf.zzc(), zzj(this.zzc), this.zzf.zzg(), this.zzg).zzo();
        } catch (NullPointerException e2) {
            this.zzd.zzc(2027, System.currentTimeMillis() - jCurrentTimeMillis, e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    @Deprecated
    public final String zze(Context context, String str, @Nullable View view, @Nullable Activity activity) {
        if (!zzs()) {
            return "";
        }
        zzd();
        return ((zzgz) this.zzb.get()).zze(zzj(context), str, view, activity);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zzf(Context context) {
        return zzg(context, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zzg(Context context, byte[] bArr) {
        if (!zzs()) {
            return "";
        }
        zzd();
        return ((zzgz) this.zzb.get()).zzf(zzj(context));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zzh(Context context, @Nullable View view, @Nullable Activity activity) {
        return zzs() ? ((zzgz) this.zzb.get()).zzh(context, view, activity) : "";
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final void zzk(@Nullable MotionEvent motionEvent) {
        if (this.zzb.get() == null) {
            this.zzh.add(new Object[]{motionEvent});
        } else {
            zzd();
            ((zzgz) this.zzb.get()).zzk(motionEvent);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final void zzl(int i2, int i3, int i4) {
        if (this.zzb.get() == null) {
            this.zzh.add(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            zzd();
            ((zzgz) this.zzb.get()).zzl(i2, i3, i4);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final void zzn(@Nullable View view) {
        if (this.zzb.get() != null) {
            ((zzgz) this.zzb.get()).zzn(view);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final boolean zzq() {
        return this.zza.getCount() == 0 && this.zzb.get() != null && ((zzgz) this.zzb.get()).zzq();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final boolean zzs() throws InterruptedException {
        try {
            this.zza.await();
            if (this.zzb.get() != null) {
                return ((zzgz) this.zzb.get()).zzs();
            }
            return false;
        } catch (InterruptedException unused) {
            return false;
        }
    }
}
