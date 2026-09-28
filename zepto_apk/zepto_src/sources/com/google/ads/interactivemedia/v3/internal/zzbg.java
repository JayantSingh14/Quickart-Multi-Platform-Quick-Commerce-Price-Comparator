package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzbg extends zzacq implements zzaea {
    private static final zzbg zzb;
    private int zzd;
    private zzabn zze;
    private zzabn zzf;
    private zzabn zzg;
    private zzabn zzh;

    static {
        zzbg zzbgVar = new zzbg();
        zzb = zzbgVar;
        zzacq.zzaL(zzbg.class, zzbgVar);
    }

    private zzbg() {
        zzabn zzabnVar = zzabn.zzb;
        this.zze = zzabnVar;
        this.zzf = zzabnVar;
        this.zzg = zzabnVar;
        this.zzh = zzabnVar;
    }

    public static zzbf zza() {
        return (zzbf) zzb.zzay();
    }

    public static zzbg zzc(byte[] bArr, zzacb zzacbVar) throws zzacz {
        return (zzbg) zzacq.zzaD(zzb, bArr, zzacbVar);
    }

    public static /* synthetic */ void zzh(zzbg zzbgVar, zzabn zzabnVar) {
        zzbgVar.zzd |= 1;
        zzbgVar.zze = zzabnVar;
    }

    public static /* synthetic */ void zzi(zzbg zzbgVar, zzabn zzabnVar) {
        zzbgVar.zzd |= 2;
        zzbgVar.zzf = zzabnVar;
    }

    public static /* synthetic */ void zzk(zzbg zzbgVar, zzabn zzabnVar) {
        zzbgVar.zzd |= 4;
        zzbgVar.zzg = zzabnVar;
    }

    public static /* synthetic */ void zzl(zzbg zzbgVar, zzabn zzabnVar) {
        zzbgVar.zzd |= 8;
        zzbgVar.zzh = zzabnVar;
    }

    public final zzabn zzd() {
        return this.zze;
    }

    public final zzabn zze() {
        return this.zzf;
    }

    public final zzabn zzf() {
        return this.zzh;
    }

    public final zzabn zzg() {
        return this.zzg;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new zzbg();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzbf(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
