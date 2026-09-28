package com.google.ads.interactivemedia.omid.library.adsession;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzbx;
import com.google.ads.interactivemedia.v3.internal.zzbz;
import com.google.ads.interactivemedia.v3.internal.zzcd;
import com.google.ads.interactivemedia.v3.internal.zzch;
import com.google.ads.interactivemedia.v3.internal.zzcn;
import com.google.ads.interactivemedia.v3.internal.zzco;
import com.google.ads.interactivemedia.v3.internal.zzcr;
import com.google.ads.interactivemedia.v3.internal.zzcy;
import com.google.ads.interactivemedia.v3.internal.zzdp;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class zze extends zza {
    private final zzc zza;
    private final zzb zzb;
    private final zzcd zzc;
    private zzdp zzd;
    private zzcn zze;
    private boolean zzf;
    private boolean zzg;
    private final String zzh;

    public zze(zzb zzbVar, zzc zzcVar) {
        String string = UUID.randomUUID().toString();
        this.zzc = new zzcd();
        this.zzf = false;
        this.zzg = false;
        this.zzb = zzbVar;
        this.zza = zzcVar;
        this.zzh = string;
        zzl(null);
        if (zzcVar.zzc() == zzd.HTML || zzcVar.zzc() == zzd.JAVASCRIPT) {
            this.zze = new zzco(string, zzcVar.zza());
        } else {
            this.zze = new zzcr(string, zzcVar.zzh(), null);
        }
        this.zze.zzn();
        zzbz.zza().zzd(this);
        this.zze.zzf(zzbVar);
    }

    private final void zzl(View view) {
        this.zzd = new zzdp(view);
    }

    @Override // com.google.ads.interactivemedia.omid.library.adsession.zza
    public final void zzb(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.zzg) {
            return;
        }
        this.zzc.zzb(view, friendlyObstructionPurpose, str);
    }

    @Override // com.google.ads.interactivemedia.omid.library.adsession.zza
    public final void zzc() {
        if (this.zzg) {
            return;
        }
        this.zzd.clear();
        zze();
        this.zzg = true;
        this.zze.zze();
        zzbz.zza().zze(this);
        this.zze.zzc();
        this.zze = null;
    }

    @Override // com.google.ads.interactivemedia.omid.library.adsession.zza
    public final void zzd(View view) {
        if (this.zzg) {
            return;
        }
        zzcy.zzb(view, "AdView is null");
        if (zzg() != view) {
            zzl(view);
            this.zze.zzb();
            Collection<zze> collectionZzc = zzbz.zza().zzc();
            if (collectionZzc == null || collectionZzc.isEmpty()) {
                return;
            }
            for (zze zzeVar : collectionZzc) {
                if (zzeVar != this && zzeVar.zzg() == view) {
                    zzeVar.zzd.clear();
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.omid.library.adsession.zza
    public final void zze() {
        if (this.zzg) {
            return;
        }
        this.zzc.zzc();
    }

    @Override // com.google.ads.interactivemedia.omid.library.adsession.zza
    public final void zzf() {
        if (this.zzf) {
            return;
        }
        this.zzf = true;
        zzbz.zza().zzf(this);
        this.zze.zzl(zzch.zzb().zza());
        this.zze.zzg(zzbx.zza().zzb());
        this.zze.zzi(this, this.zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zzg() {
        return (View) this.zzd.get();
    }

    public final zzcn zzh() {
        return this.zze;
    }

    public final String zzi() {
        return this.zzh;
    }

    public final List zzj() {
        return this.zzc.zza();
    }

    public final boolean zzk() {
        return this.zzf && !this.zzg;
    }
}
