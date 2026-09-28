package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public abstract class zzha implements zzgz {
    protected static volatile zzih zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;

    @Nullable
    protected zzhz zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    public zzha(Context context) {
        try {
            zzfs.zzd();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) zzkq.zzc().zza(zzlg.zzcC)).booleanValue()) {
                this.zzr = new zzhz();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzj() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        if (this.zzc.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzc.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00dc A[Catch: Exception -> 0x00d8, TRY_LEAVE, TryCatch #2 {Exception -> 0x00d8, blocks: (B:44:0x009a, B:47:0x00a7, B:56:0x00cb, B:59:0x00dc), top: B:77:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String zzm(android.content.Context r19, java.lang.String r20, int r21, android.view.View r22, android.app.Activity r23, byte[] r24) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzha.zzm(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzhx;

    public abstract zzaf zzb(Context context, View view, Activity activity);

    public abstract zzaf zzc(Context context, zzy zzyVar);

    public abstract zzaf zzd(Context context, View view, Activity activity);

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zze(Context context, @Nullable String str, @Nullable View view, @Nullable Activity activity) {
        return zzm(context, str, 3, view, activity, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zzf(Context context) {
        if (zzik.zzc()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzm(context, null, 1, null, null, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zzg(Context context, byte[] bArr) {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final String zzh(Context context, @Nullable View view, @Nullable Activity activity) {
        return zzm(context, null, 2, view, activity, null);
    }

    public abstract zzij zzi(MotionEvent motionEvent) throws zzhx;

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final synchronized void zzk(@Nullable MotionEvent motionEvent) {
        Long l2;
        try {
            if (this.zzu) {
                zzj();
                this.zzu = false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.zzk = 0.0d;
                this.zzs = motionEvent.getRawX();
                this.zzt = motionEvent.getRawY();
            } else if (action == 1 || action == 2) {
                double rawX = motionEvent.getRawX();
                double rawY = motionEvent.getRawY();
                double d2 = rawX - this.zzs;
                double d3 = rawY - this.zzt;
                this.zzk += Math.sqrt((d3 * d3) + (d2 * d2));
                this.zzs = rawX;
                this.zzt = rawY;
            }
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                try {
                    if (action2 == 1) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        this.zzb = motionEventObtain;
                        this.zzc.add(motionEventObtain);
                        if (this.zzc.size() > 6) {
                            ((MotionEvent) this.zzc.remove()).recycle();
                        }
                        this.zzf++;
                        this.zzh = zza(new Throwable().getStackTrace());
                    } else if (action2 == 2) {
                        this.zze += motionEvent.getHistorySize() + 1;
                        zzij zzijVarZzi = zzi(motionEvent);
                        Long l3 = zzijVarZzi.zzd;
                        if (l3 != null && zzijVarZzi.zzg != null) {
                            this.zzi = l3.longValue() + zzijVarZzi.zzg.longValue() + this.zzi;
                        }
                        if (this.zzq != null && (l2 = zzijVarZzi.zze) != null && zzijVarZzi.zzh != null) {
                            this.zzj = l2.longValue() + zzijVarZzi.zzh.longValue() + this.zzj;
                        }
                    } else if (action2 == 3) {
                        this.zzg++;
                    }
                } catch (zzhx unused) {
                }
            } else {
                this.zzl = motionEvent.getX();
                this.zzm = motionEvent.getY();
                this.zzn = motionEvent.getRawX();
                this.zzo = motionEvent.getRawY();
                this.zzd++;
            }
            this.zzp = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final synchronized void zzl(int i2, int i3, int i4) {
        try {
            if (this.zzb != null) {
                if (((Boolean) zzkq.zzc().zza(zzlg.zzcs)).booleanValue()) {
                    zzj();
                } else {
                    this.zzb.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.zzq;
            if (displayMetrics != null) {
                float f2 = displayMetrics.density;
                this.zzb = MotionEvent.obtain(0L, i4, 1, i2 * f2, i3 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.zzb = null;
            }
            this.zzp = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public void zzn(View view) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final boolean zzq() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzgz
    public final boolean zzs() {
        return true;
    }
}
