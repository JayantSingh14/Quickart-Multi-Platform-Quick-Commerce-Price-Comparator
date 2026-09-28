package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
final class zzabs implements zzael {
    private final zzabr zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzabs(zzabr zzabrVar) {
        byte[] bArr = zzacx.zzd;
        this.zza = zzabrVar;
        zzabrVar.zzc = this;
    }

    private final void zzP(Object obj, zzaet zzaetVar, zzacb zzacbVar) throws IOException {
        int i2 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzaetVar.zzh(obj, this, zzacbVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzacz.zzg();
            }
        } finally {
            this.zzc = i2;
        }
    }

    private final void zzQ(Object obj, zzaet zzaetVar, zzacb zzacbVar) throws IOException {
        zzabr zzabrVar = this.zza;
        int iZze = ((zzabp) zzabrVar).zze();
        if (zzabrVar.zza >= zzabrVar.zzb) {
            throw new zzacz("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzc = this.zza.zzc(iZze);
        this.zza.zza++;
        zzaetVar.zzh(obj, this, zzacbVar);
        this.zza.zzm(0);
        r4.zza--;
        this.zza.zzn(iZzc);
    }

    private final void zzR(int i2) throws IOException {
        if (this.zza.zzb() != i2) {
            throw zzacz.zzi();
        }
    }

    private final void zzS(int i2) throws IOException {
        if ((this.zzb & 7) != i2) {
            throw zzacz.zza();
        }
    }

    private static final void zzT(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw zzacz.zzg();
        }
    }

    private static final void zzU(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw zzacz.zzg();
        }
    }

    public static zzabs zzq(zzabr zzabrVar) {
        zzabs zzabsVar = zzabrVar.zzc;
        return zzabsVar != null ? zzabsVar : new zzabs(zzabrVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzA(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzado) {
            zzado zzadoVar = (zzado) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                int iZze = ((zzabp) this.zza).zze();
                zzU(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    zzadoVar.zzf(((zzabp) this.zza).zzg());
                } while (this.zza.zzb() < iZzb);
                return;
            }
            do {
                zzadoVar.zzf(((zzabp) this.zza).zzg());
                zzabr zzabrVar = this.zza;
                if (zzabrVar.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                int iZze2 = ((zzabp) this.zza).zze();
                zzU(iZze2);
                int iZzb2 = this.zza.zzb() + iZze2;
                do {
                    list.add(Long.valueOf(((zzabp) this.zza).zzg()));
                } while (this.zza.zzb() < iZzb2);
                return;
            }
            do {
                list.add(Long.valueOf(((zzabp) this.zza).zzg()));
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar2.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzB(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzaci) {
            zzaci zzaciVar = (zzaci) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZze = ((zzabp) this.zza).zze();
                zzT(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    zzaciVar.zze(Float.intBitsToFloat(((zzabp) this.zza).zzd()));
                } while (this.zza.zzb() < iZzb);
                return;
            }
            if (i2 != 5) {
                throw zzacz.zza();
            }
            do {
                zzaciVar.zze(Float.intBitsToFloat(((zzabp) this.zza).zzd()));
                zzabr zzabrVar = this.zza;
                if (zzabrVar.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int iZze2 = ((zzabp) this.zza).zze();
                zzT(iZze2);
                int iZzb2 = this.zza.zzb() + iZze2;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzabp) this.zza).zzd())));
                } while (this.zza.zzb() < iZzb2);
                return;
            }
            if (i3 != 5) {
                throw zzacz.zza();
            }
            do {
                list.add(Float.valueOf(Float.intBitsToFloat(((zzabp) this.zza).zzd())));
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar2.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    @Deprecated
    public final void zzC(List list, zzaet zzaetVar, zzacb zzacbVar) throws IOException {
        int iZzf;
        int i2 = this.zzb;
        if ((i2 & 7) != 3) {
            throw zzacz.zza();
        }
        do {
            Object objZze = zzaetVar.zze();
            zzP(objZze, zzaetVar, zzacbVar);
            zzaetVar.zzf(objZze);
            list.add(objZze);
            zzabr zzabrVar = this.zza;
            if (zzabrVar.zzp() || this.zzd != 0) {
                return;
            } else {
                iZzf = zzabrVar.zzf();
            }
        } while (iZzf == i2);
        this.zzd = iZzf;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzD(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzacr) {
            zzacr zzacrVar = (zzacr) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar = this.zza;
                int iZzb = zzabrVar.zzb() + ((zzabp) zzabrVar).zze();
                do {
                    zzacrVar.zzg(((zzabp) this.zza).zze());
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                zzacrVar.zzg(((zzabp) this.zza).zze());
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar2.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar3 = this.zza;
                int iZzb2 = zzabrVar3.zzb() + ((zzabp) zzabrVar3).zze();
                do {
                    list.add(Integer.valueOf(((zzabp) this.zza).zze()));
                } while (this.zza.zzb() < iZzb2);
                zzR(iZzb2);
                return;
            }
            do {
                list.add(Integer.valueOf(((zzabp) this.zza).zze()));
                zzabr zzabrVar4 = this.zza;
                if (zzabrVar4.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar4.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzE(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzado) {
            zzado zzadoVar = (zzado) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar = this.zza;
                int iZzb = zzabrVar.zzb() + ((zzabp) zzabrVar).zze();
                do {
                    zzadoVar.zzf(((zzabp) this.zza).zzh());
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                zzadoVar.zzf(((zzabp) this.zza).zzh());
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar2.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar3 = this.zza;
                int iZzb2 = zzabrVar3.zzb() + ((zzabp) zzabrVar3).zze();
                do {
                    list.add(Long.valueOf(((zzabp) this.zza).zzh()));
                } while (this.zza.zzb() < iZzb2);
                zzR(iZzb2);
                return;
            }
            do {
                list.add(Long.valueOf(((zzabp) this.zza).zzh()));
                zzabr zzabrVar4 = this.zza;
                if (zzabrVar4.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar4.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzF(List list, zzaet zzaetVar, zzacb zzacbVar) throws IOException {
        int iZzf;
        int i2 = this.zzb;
        if ((i2 & 7) != 2) {
            throw zzacz.zza();
        }
        do {
            Object objZze = zzaetVar.zze();
            zzQ(objZze, zzaetVar, zzacbVar);
            zzaetVar.zzf(objZze);
            list.add(objZze);
            zzabr zzabrVar = this.zza;
            if (zzabrVar.zzp() || this.zzd != 0) {
                return;
            } else {
                iZzf = zzabrVar.zzf();
            }
        } while (iZzf == i2);
        this.zzd = iZzf;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzG(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzacr) {
            zzacr zzacrVar = (zzacr) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZze = ((zzabp) this.zza).zze();
                zzT(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    zzacrVar.zzg(((zzabp) this.zza).zzd());
                } while (this.zza.zzb() < iZzb);
                return;
            }
            if (i2 != 5) {
                throw zzacz.zza();
            }
            do {
                zzacrVar.zzg(((zzabp) this.zza).zzd());
                zzabr zzabrVar = this.zza;
                if (zzabrVar.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int iZze2 = ((zzabp) this.zza).zze();
                zzT(iZze2);
                int iZzb2 = this.zza.zzb() + iZze2;
                do {
                    list.add(Integer.valueOf(((zzabp) this.zza).zzd()));
                } while (this.zza.zzb() < iZzb2);
                return;
            }
            if (i3 != 5) {
                throw zzacz.zza();
            }
            do {
                list.add(Integer.valueOf(((zzabp) this.zza).zzd()));
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar2.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzH(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzado) {
            zzado zzadoVar = (zzado) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                int iZze = ((zzabp) this.zza).zze();
                zzU(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    zzadoVar.zzf(((zzabp) this.zza).zzg());
                } while (this.zza.zzb() < iZzb);
                return;
            }
            do {
                zzadoVar.zzf(((zzabp) this.zza).zzg());
                zzabr zzabrVar = this.zza;
                if (zzabrVar.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                int iZze2 = ((zzabp) this.zza).zze();
                zzU(iZze2);
                int iZzb2 = this.zza.zzb() + iZze2;
                do {
                    list.add(Long.valueOf(((zzabp) this.zza).zzg()));
                } while (this.zza.zzb() < iZzb2);
                return;
            }
            do {
                list.add(Long.valueOf(((zzabp) this.zza).zzg()));
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar2.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzI(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzacr) {
            zzacr zzacrVar = (zzacr) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar = this.zza;
                int iZzb = zzabrVar.zzb() + ((zzabp) zzabrVar).zze();
                do {
                    zzacrVar.zzg(zzabr.zzs(((zzabp) this.zza).zze()));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                zzacrVar.zzg(zzabr.zzs(((zzabp) this.zza).zze()));
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar2.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar3 = this.zza;
                int iZzb2 = zzabrVar3.zzb() + ((zzabp) zzabrVar3).zze();
                do {
                    list.add(Integer.valueOf(zzabr.zzs(((zzabp) this.zza).zze())));
                } while (this.zza.zzb() < iZzb2);
                zzR(iZzb2);
                return;
            }
            do {
                list.add(Integer.valueOf(zzabr.zzs(((zzabp) this.zza).zze())));
                zzabr zzabrVar4 = this.zza;
                if (zzabrVar4.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar4.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzJ(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzado) {
            zzado zzadoVar = (zzado) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar = this.zza;
                int iZzb = zzabrVar.zzb() + ((zzabp) zzabrVar).zze();
                do {
                    zzadoVar.zzf(zzabr.zzt(((zzabp) this.zza).zzh()));
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                zzadoVar.zzf(zzabr.zzt(((zzabp) this.zza).zzh()));
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar2.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar3 = this.zza;
                int iZzb2 = zzabrVar3.zzb() + ((zzabp) zzabrVar3).zze();
                do {
                    list.add(Long.valueOf(zzabr.zzt(((zzabp) this.zza).zzh())));
                } while (this.zza.zzb() < iZzb2);
                zzR(iZzb2);
                return;
            }
            do {
                list.add(Long.valueOf(zzabr.zzt(((zzabp) this.zza).zzh())));
                zzabr zzabrVar4 = this.zza;
                if (zzabrVar4.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar4.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    public final void zzK(List list, boolean z) throws IOException {
        int iZzf;
        int iZzf2;
        if ((this.zzb & 7) != 2) {
            throw zzacz.zza();
        }
        if ((list instanceof zzadh) && !z) {
            zzadh zzadhVar = (zzadh) list;
            do {
                zzadhVar.zzi(zzp());
                zzabr zzabrVar = this.zza;
                if (zzabrVar.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            do {
                list.add(z ? zzs() : zzr());
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar2.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzL(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzacr) {
            zzacr zzacrVar = (zzacr) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar = this.zza;
                int iZzb = zzabrVar.zzb() + ((zzabp) zzabrVar).zze();
                do {
                    zzacrVar.zzg(((zzabp) this.zza).zze());
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                zzacrVar.zzg(((zzabp) this.zza).zze());
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar2.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar3 = this.zza;
                int iZzb2 = zzabrVar3.zzb() + ((zzabp) zzabrVar3).zze();
                do {
                    list.add(Integer.valueOf(((zzabp) this.zza).zze()));
                } while (this.zza.zzb() < iZzb2);
                zzR(iZzb2);
                return;
            }
            do {
                list.add(Integer.valueOf(((zzabp) this.zza).zze()));
                zzabr zzabrVar4 = this.zza;
                if (zzabrVar4.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar4.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzM(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzado) {
            zzado zzadoVar = (zzado) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar = this.zza;
                int iZzb = zzabrVar.zzb() + ((zzabp) zzabrVar).zze();
                do {
                    zzadoVar.zzf(((zzabp) this.zza).zzh());
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                zzadoVar.zzf(((zzabp) this.zza).zzh());
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar2.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar3 = this.zza;
                int iZzb2 = zzabrVar3.zzb() + ((zzabp) zzabrVar3).zze();
                do {
                    list.add(Long.valueOf(((zzabp) this.zza).zzh()));
                } while (this.zza.zzb() < iZzb2);
                zzR(iZzb2);
                return;
            }
            do {
                list.add(Long.valueOf(((zzabp) this.zza).zzh()));
                zzabr zzabrVar4 = this.zza;
                if (zzabrVar4.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar4.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzq();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final boolean zzO() throws IOException {
        int i2;
        zzabr zzabrVar = this.zza;
        if (zzabrVar.zzp() || (i2 = this.zzb) == this.zzc) {
            return false;
        }
        return zzabrVar.zzr(i2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final double zza() throws IOException {
        zzS(1);
        return Double.longBitsToDouble(((zzabp) this.zza).zzg());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final float zzb() throws IOException {
        zzS(5);
        return Float.intBitsToFloat(((zzabp) this.zza).zzd());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final int zzc() throws IOException {
        int iZzf = this.zzd;
        if (iZzf != 0) {
            this.zzb = iZzf;
            this.zzd = 0;
        } else {
            iZzf = this.zza.zzf();
            this.zzb = iZzf;
        }
        return (iZzf == 0 || iZzf == this.zzc) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iZzf >>> 3;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final int zze() throws IOException {
        zzS(0);
        return ((zzabp) this.zza).zze();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final int zzf() throws IOException {
        zzS(5);
        return ((zzabp) this.zza).zzd();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final int zzg() throws IOException {
        zzS(0);
        return ((zzabp) this.zza).zze();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final int zzh() throws IOException {
        zzS(5);
        return ((zzabp) this.zza).zzd();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final int zzi() throws IOException {
        zzS(0);
        return zzabr.zzs(((zzabp) this.zza).zze());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final int zzj() throws IOException {
        zzS(0);
        return ((zzabp) this.zza).zze();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final long zzk() throws IOException {
        zzS(1);
        return ((zzabp) this.zza).zzg();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final long zzl() throws IOException {
        zzS(0);
        return ((zzabp) this.zza).zzh();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final long zzm() throws IOException {
        zzS(1);
        return ((zzabp) this.zza).zzg();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final long zzn() throws IOException {
        zzS(0);
        return zzabr.zzt(((zzabp) this.zza).zzh());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final long zzo() throws IOException {
        zzS(0);
        return ((zzabp) this.zza).zzh();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final zzabn zzp() throws IOException {
        zzS(2);
        return this.zza.zzj();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzk();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzl();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzt(Object obj, zzaet zzaetVar, zzacb zzacbVar) throws IOException {
        zzS(3);
        zzP(obj, zzaetVar, zzacbVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzu(Object obj, zzaet zzaetVar, zzacb zzacbVar) throws IOException {
        zzS(2);
        zzQ(obj, zzaetVar, zzacbVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzv(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzabb) {
            zzabb zzabbVar = (zzabb) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar = this.zza;
                int iZzb = zzabrVar.zzb() + ((zzabp) zzabrVar).zze();
                do {
                    zzabbVar.zze(this.zza.zzq());
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                zzabbVar.zze(this.zza.zzq());
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar2.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar3 = this.zza;
                int iZzb2 = zzabrVar3.zzb() + ((zzabp) zzabrVar3).zze();
                do {
                    list.add(Boolean.valueOf(this.zza.zzq()));
                } while (this.zza.zzb() < iZzb2);
                zzR(iZzb2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzq()));
                zzabr zzabrVar4 = this.zza;
                if (zzabrVar4.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar4.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzw(List list) throws IOException {
        int iZzf;
        if ((this.zzb & 7) != 2) {
            throw zzacz.zza();
        }
        do {
            list.add(zzp());
            zzabr zzabrVar = this.zza;
            if (zzabrVar.zzp()) {
                return;
            } else {
                iZzf = zzabrVar.zzf();
            }
        } while (iZzf == this.zzb);
        this.zzd = iZzf;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzx(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzaby) {
            zzaby zzabyVar = (zzaby) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                int iZze = ((zzabp) this.zza).zze();
                zzU(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    zzabyVar.zze(Double.longBitsToDouble(((zzabp) this.zza).zzg()));
                } while (this.zza.zzb() < iZzb);
                return;
            }
            do {
                zzabyVar.zze(Double.longBitsToDouble(((zzabp) this.zza).zzg()));
                zzabr zzabrVar = this.zza;
                if (zzabrVar.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                int iZze2 = ((zzabp) this.zza).zze();
                zzU(iZze2);
                int iZzb2 = this.zza.zzb() + iZze2;
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzabp) this.zza).zzg())));
                } while (this.zza.zzb() < iZzb2);
                return;
            }
            do {
                list.add(Double.valueOf(Double.longBitsToDouble(((zzabp) this.zza).zzg())));
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar2.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzy(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzacr) {
            zzacr zzacrVar = (zzacr) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar = this.zza;
                int iZzb = zzabrVar.zzb() + ((zzabp) zzabrVar).zze();
                do {
                    zzacrVar.zzg(((zzabp) this.zza).zze());
                } while (this.zza.zzb() < iZzb);
                zzR(iZzb);
                return;
            }
            do {
                zzacrVar.zzg(((zzabp) this.zza).zze());
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar2.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzacz.zza();
                }
                zzabr zzabrVar3 = this.zza;
                int iZzb2 = zzabrVar3.zzb() + ((zzabp) zzabrVar3).zze();
                do {
                    list.add(Integer.valueOf(((zzabp) this.zza).zze()));
                } while (this.zza.zzb() < iZzb2);
                zzR(iZzb2);
                return;
            }
            do {
                list.add(Integer.valueOf(((zzabp) this.zza).zze()));
                zzabr zzabrVar4 = this.zza;
                if (zzabrVar4.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar4.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzael
    public final void zzz(List list) throws IOException {
        int iZzf;
        int iZzf2;
        if (list instanceof zzacr) {
            zzacr zzacrVar = (zzacr) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZze = ((zzabp) this.zza).zze();
                zzT(iZze);
                int iZzb = this.zza.zzb() + iZze;
                do {
                    zzacrVar.zzg(((zzabp) this.zza).zzd());
                } while (this.zza.zzb() < iZzb);
                return;
            }
            if (i2 != 5) {
                throw zzacz.zza();
            }
            do {
                zzacrVar.zzg(((zzabp) this.zza).zzd());
                zzabr zzabrVar = this.zza;
                if (zzabrVar.zzp()) {
                    return;
                } else {
                    iZzf2 = zzabrVar.zzf();
                }
            } while (iZzf2 == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int iZze2 = ((zzabp) this.zza).zze();
                zzT(iZze2);
                int iZzb2 = this.zza.zzb() + iZze2;
                do {
                    list.add(Integer.valueOf(((zzabp) this.zza).zzd()));
                } while (this.zza.zzb() < iZzb2);
                return;
            }
            if (i3 != 5) {
                throw zzacz.zza();
            }
            do {
                list.add(Integer.valueOf(((zzabp) this.zza).zzd()));
                zzabr zzabrVar2 = this.zza;
                if (zzabrVar2.zzp()) {
                    return;
                } else {
                    iZzf = zzabrVar2.zzf();
                }
            } while (iZzf == this.zzb);
            iZzf2 = iZzf;
        }
        this.zzd = iZzf2;
    }
}
