package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzaed implements zzaet {
    private final zzadz zza;
    private final zzafk zzb;
    private final boolean zzc;
    private final zzacc zzd;

    private zzaed(zzafk zzafkVar, zzacc zzaccVar, zzadz zzadzVar) {
        this.zzb = zzafkVar;
        this.zzc = zzaccVar.zzj(zzadzVar);
        this.zzd = zzaccVar;
        this.zza = zzadzVar;
    }

    public static zzaed zzc(zzafk zzafkVar, zzacc zzaccVar, zzadz zzadzVar) {
        return new zzaed(zzafkVar, zzaccVar, zzadzVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final int zza(Object obj) {
        zzafk zzafkVar = this.zzb;
        int iZzb = zzafkVar.zzb(zzafkVar.zzd(obj));
        return this.zzc ? iZzb + this.zzd.zzb(obj).zzc() : iZzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : iHashCode;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final Object zze() {
        zzadz zzadzVar = this.zza;
        return zzadzVar instanceof zzacq ? ((zzacq) zzadzVar).zzaA() : zzadzVar.zzaP().zzao();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zzf(obj);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final void zzg(Object obj, Object obj2) {
        zzaev.zzr(this.zzb, obj, obj2);
        if (this.zzc) {
            zzaev.zzq(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final void zzh(Object obj, zzael zzaelVar, zzacb zzacbVar) throws IOException {
        boolean zZzO;
        zzafk zzafkVar = this.zzb;
        Object objZzc = zzafkVar.zzc(obj);
        zzacc zzaccVar = this.zzd;
        zzacg zzacgVarZzc = zzaccVar.zzc(obj);
        while (zzaelVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzaelVar.zzd();
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZzd = zzaccVar.zzd(zzacbVar, this.zza, iZzd >>> 3);
                        if (objZzd != null) {
                            zzaccVar.zzg(zzaelVar, objZzd, zzacbVar, zzacgVarZzc);
                        } else {
                            zZzO = zzafkVar.zzr(objZzc, zzaelVar);
                        }
                    } else {
                        zZzO = zzaelVar.zzO();
                    }
                    if (!zZzO) {
                        break;
                    }
                } else {
                    Object objZzd2 = null;
                    int iZzj = 0;
                    zzabn zzabnVarZzp = null;
                    while (zzaelVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzaelVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzaelVar.zzj();
                            objZzd2 = zzaccVar.zzd(zzacbVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZzd2 != null) {
                                zzaccVar.zzg(zzaelVar, objZzd2, zzacbVar, zzacgVarZzc);
                            } else {
                                zzabnVarZzp = zzaelVar.zzp();
                            }
                        } else if (!zzaelVar.zzO()) {
                            break;
                        }
                    }
                    if (zzaelVar.zzd() != 12) {
                        throw zzacz.zzb();
                    }
                    if (zzabnVarZzp != null) {
                        if (objZzd2 != null) {
                            zzaccVar.zzh(zzabnVarZzp, objZzd2, zzacbVar, zzacgVarZzc);
                        } else {
                            zzafkVar.zzk(objZzc, iZzj, zzabnVarZzp);
                        }
                    }
                }
            } finally {
                zzafkVar.zzn(obj, objZzc);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final void zzi(Object obj, byte[] bArr, int i2, int i3, zzaaz zzaazVar) throws IOException {
        zzacq zzacqVar = (zzacq) obj;
        if (zzacqVar.zzc == zzafl.zzc()) {
            zzacqVar.zzc = zzafl.zzf();
        }
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final void zzj(Object obj, zzagc zzagcVar) throws IOException {
        Iterator itZzf = this.zzd.zzb(obj).zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzacf zzacfVar = (zzacf) entry.getKey();
            if (zzacfVar.zze() != zzagb.MESSAGE || zzacfVar.zzg() || zzacfVar.zzf()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzadc) {
                zzagcVar.zzw(zzacfVar.zza(), ((zzadc) entry).zza().zzb());
            } else {
                zzagcVar.zzw(zzacfVar.zza(), entry.getValue());
            }
        }
        zzafk zzafkVar = this.zzb;
        zzafkVar.zzp(zzafkVar.zzd(obj), zzagcVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final boolean zzk(Object obj, Object obj2) {
        zzafk zzafkVar = this.zzb;
        if (!zzafkVar.zzd(obj).equals(zzafkVar.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final boolean zzl(Object obj) {
        return this.zzd.zzb(obj).zzj();
    }
}
