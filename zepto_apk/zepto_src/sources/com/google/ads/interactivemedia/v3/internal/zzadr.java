package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzadr implements zzaeu {
    private static final zzadx zza = new zzadp();
    private final zzadx zzb;

    public zzadr() {
        zzadx zzadxVar;
        zzack zzackVarZza = zzack.zza();
        try {
            zzadxVar = (zzadx) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzadxVar = zza;
        }
        zzadq zzadqVar = new zzadq(zzackVarZza, zzadxVar);
        byte[] bArr = zzacx.zzd;
        this.zzb = zzadqVar;
    }

    private static boolean zzb(zzadw zzadwVar) {
        return zzadwVar.zzc() + (-1) != 1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaeu
    public final zzaet zza(Class cls) {
        zzaev.zzs(cls);
        zzadw zzadwVarZzb = this.zzb.zzb(cls);
        return zzadwVarZzb.zzb() ? zzacq.class.isAssignableFrom(cls) ? zzaed.zzc(zzaev.zzn(), zzace.zzb(), zzadwVarZzb.zza()) : zzaed.zzc(zzaev.zzm(), zzace.zza(), zzadwVarZzb.zza()) : zzacq.class.isAssignableFrom(cls) ? zzb(zzadwVarZzb) ? zzaec.zzm(cls, zzadwVarZzb, zzaeg.zzb(), zzadn.zze(), zzaev.zzn(), zzace.zzb(), zzadv.zzb()) : zzaec.zzm(cls, zzadwVarZzb, zzaeg.zzb(), zzadn.zze(), zzaev.zzn(), null, zzadv.zzb()) : zzb(zzadwVarZzb) ? zzaec.zzm(cls, zzadwVarZzb, zzaeg.zza(), zzadn.zzd(), zzaev.zzm(), zzace.zza(), zzadv.zza()) : zzaec.zzm(cls, zzadwVarZzb, zzaeg.zza(), zzadn.zzd(), zzaev.zzm(), null, zzadv.zza());
    }
}
