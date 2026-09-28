package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class zzbx implements zzca {
    private static final zzbx zzb = new zzbx(new zzcb());
    protected final zzcx zza = new zzcx();
    private Date zzc;
    private boolean zzd;
    private final zzcb zze;
    private boolean zzf;

    private zzbx(zzcb zzcbVar) {
        this.zze = zzcbVar;
    }

    public static zzbx zza() {
        return zzb;
    }

    public final Date zzb() {
        Date date = this.zzc;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzca
    public final void zzc(boolean z) {
        if (!this.zzf && z) {
            Date date = new Date();
            Date date2 = this.zzc;
            if (date2 == null || date.after(date2)) {
                this.zzc = date;
                if (this.zzd) {
                    Iterator it = zzbz.zza().zzb().iterator();
                    while (it.hasNext()) {
                        ((com.google.ads.interactivemedia.omid.library.adsession.zze) it.next()).zzh().zzg(zzb());
                    }
                }
            }
        }
        this.zzf = z;
    }

    public final void zzd(@NonNull Context context) {
        if (this.zzd) {
            return;
        }
        this.zze.zzd(context);
        this.zze.zze(this);
        this.zze.zzf();
        this.zzf = this.zze.zza;
        this.zzd = true;
    }
}
