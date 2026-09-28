package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class zzch implements zzca {
    private static zzch zza;
    private float zzb = 0.0f;
    private final zzbw zzc;
    private final zzbu zzd;
    private zzbv zze;
    private zzbz zzf;

    public zzch(zzbw zzbwVar, zzbu zzbuVar) {
        this.zzc = zzbwVar;
        this.zzd = zzbuVar;
    }

    public static zzch zzb() {
        if (zza == null) {
            zza = new zzch(new zzbw(), new zzbu());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzca
    public final void zzc(boolean z) {
        if (z) {
            zzdi.zzd().zzi();
        } else {
            zzdi.zzd().zzh();
        }
    }

    public final void zzd(Context context) {
        this.zze = new zzbv(new Handler(), context, new zzbt(), this);
    }

    public final void zze(float f2) {
        this.zzb = f2;
        if (this.zzf == null) {
            this.zzf = zzbz.zza();
        }
        Iterator it = this.zzf.zzb().iterator();
        while (it.hasNext()) {
            ((com.google.ads.interactivemedia.omid.library.adsession.zze) it.next()).zzh().zzl(f2);
        }
    }

    public final void zzf() {
        zzby.zza().zze(this);
        zzby.zza().zzf();
        zzdi.zzd().zzi();
        this.zze.zza();
    }

    public final void zzg() {
        zzdi.zzd().zzj();
        zzby.zza().zzg();
        this.zze.zzb();
    }
}
