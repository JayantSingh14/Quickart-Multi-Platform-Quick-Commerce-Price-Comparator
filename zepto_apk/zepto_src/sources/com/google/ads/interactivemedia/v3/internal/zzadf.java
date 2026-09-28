package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public class zzadf {
    private static final zzacb zzb = zzacb.zza;
    protected volatile zzadz zza;
    private volatile zzabn zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzadf)) {
            return false;
        }
        zzadf zzadfVar = (zzadf) obj;
        zzadz zzadzVar = this.zza;
        zzadz zzadzVar2 = zzadfVar.zza;
        if (zzadzVar == null && zzadzVar2 == null) {
            return zzb().equals(zzadfVar.zzb());
        }
        if (zzadzVar != null && zzadzVar2 != null) {
            return zzadzVar.equals(zzadzVar2);
        }
        if (zzadzVar != null) {
            zzadfVar.zzd(zzadzVar.zzaS());
            return zzadzVar.equals(zzadfVar.zza);
        }
        zzd(zzadzVar2.zzaS());
        return this.zza.equals(zzadzVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzabk) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzax();
        }
        return 0;
    }

    public final zzabn zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            try {
                if (this.zzc != null) {
                    return this.zzc;
                }
                if (this.zza == null) {
                    this.zzc = zzabn.zzb;
                } else {
                    this.zzc = this.zza.zzau();
                }
                return this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzadz zzc(zzadz zzadzVar) {
        zzadz zzadzVar2 = this.zza;
        this.zzc = null;
        this.zza = zzadzVar;
        return zzadzVar2;
    }

    public final void zzd(zzadz zzadzVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzadzVar;
                this.zzc = zzabn.zzb;
            } catch (zzacz unused) {
                this.zza = zzadzVar;
                this.zzc = zzabn.zzb;
            }
        }
    }
}
