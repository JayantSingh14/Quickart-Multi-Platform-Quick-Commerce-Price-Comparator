package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class zzaes extends zzabn {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Api.BaseClientBuilder.API_PRIORITY_OTHER};
    private final int zzc;
    private final zzabn zzd;
    private final zzabn zze;
    private final int zzf;
    private final int zzg;

    private static zzabn zzA(zzabn zzabnVar, zzabn zzabnVar2) {
        int iZzd = zzabnVar.zzd();
        int iZzd2 = zzabnVar2.zzd();
        byte[] bArr = new byte[iZzd + iZzd2];
        zzabnVar.zzw(bArr, 0, 0, iZzd);
        zzabnVar2.zzw(bArr, 0, iZzd, iZzd2);
        return new zzabk(bArr);
    }

    public static int zzc(int i2) {
        int[] iArr = zza;
        int length = iArr.length;
        return i2 >= 47 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iArr[i2];
    }

    public static zzabn zzz(zzabn zzabnVar, zzabn zzabnVar2) {
        if (zzabnVar2.zzd() == 0) {
            return zzabnVar;
        }
        if (zzabnVar.zzd() == 0) {
            return zzabnVar2;
        }
        int iZzd = zzabnVar2.zzd() + zzabnVar.zzd();
        if (iZzd < 128) {
            return zzA(zzabnVar, zzabnVar2);
        }
        if (zzabnVar instanceof zzaes) {
            zzaes zzaesVar = (zzaes) zzabnVar;
            if (zzabnVar2.zzd() + zzaesVar.zze.zzd() < 128) {
                return new zzaes(zzaesVar.zzd, zzA(zzaesVar.zze, zzabnVar2));
            }
            if (zzaesVar.zzd.zzf() > zzaesVar.zze.zzf() && zzaesVar.zzg > zzabnVar2.zzf()) {
                return new zzaes(zzaesVar.zzd, new zzaes(zzaesVar.zze, zzabnVar2));
            }
        }
        return iZzd >= zzc(Math.max(zzabnVar.zzf(), zzabnVar2.zzf()) + 1) ? new zzaes(zzabnVar, zzabnVar2) : zzaeo.zza(new zzaeo(null), zzabnVar, zzabnVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzabn)) {
            return false;
        }
        zzabn zzabnVar = (zzabn) obj;
        if (this.zzc != zzabnVar.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int iZzq = zzq();
        int iZzq2 = zzabnVar.zzq();
        if (iZzq != 0 && iZzq2 != 0 && iZzq != iZzq2) {
            return false;
        }
        zzaep zzaepVar = null;
        zzaeq zzaeqVar = new zzaeq(this, zzaepVar);
        zzabj zzabjVarZza = zzaeqVar.next();
        zzaeq zzaeqVar2 = new zzaeq(zzabnVar, zzaepVar);
        zzabj zzabjVarZza2 = zzaeqVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int iZzd = zzabjVarZza.zzd() - i2;
            int iZzd2 = zzabjVarZza2.zzd() - i3;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i2 == 0 ? zzabjVarZza.zzg(zzabjVarZza2, i3, iMin) : zzabjVarZza2.zzg(zzabjVarZza, i2, iMin))) {
                return false;
            }
            i4 += iMin;
            int i5 = this.zzc;
            if (i4 >= i5) {
                if (i4 == i5) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                zzabjVarZza = zzaeqVar.next();
                i2 = 0;
            } else {
                i2 += iMin;
                zzabjVarZza = zzabjVarZza;
            }
            if (iMin == iZzd2) {
                zzabjVarZza2 = zzaeqVar2.next();
                i3 = 0;
            } else {
                i3 += iMin;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzaem(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final byte zza(int i2) {
        zzabn.zzv(i2, this.zzc);
        return zzb(i2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final byte zzb(int i2) {
        int i3 = this.zzf;
        return i2 < i3 ? this.zzd.zzb(i2) : this.zze.zzb(i2 - i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final void zze(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        int i6 = this.zzf;
        if (i5 <= i6) {
            this.zzd.zze(bArr, i2, i3, i4);
        } else {
            if (i2 >= i6) {
                this.zze.zze(bArr, i2 - i6, i3, i4);
                return;
            }
            int i7 = i6 - i2;
            this.zzd.zze(bArr, i2, i3, i7);
            this.zze.zze(bArr, 0, i3 + i7, i4 - i7);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final int zzf() {
        return this.zzg;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final int zzi(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.zzf;
        if (i5 <= i6) {
            return this.zzd.zzi(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.zze.zzi(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.zze.zzi(this.zzd.zzi(i2, i3, i7), 0, i4 - i7);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final int zzj(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.zzf;
        if (i5 <= i6) {
            return this.zzd.zzj(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.zze.zzj(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.zze.zzj(this.zzd.zzj(i2, i3, i7), 0, i4 - i7);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final zzabn zzk(int i2, int i3) {
        int iZzp = zzabn.zzp(i2, i3, this.zzc);
        if (iZzp == 0) {
            return zzabn.zzb;
        }
        if (iZzp == this.zzc) {
            return this;
        }
        int i4 = this.zzf;
        if (i3 <= i4) {
            return this.zzd.zzk(i2, i3);
        }
        if (i2 >= i4) {
            return this.zze.zzk(i2 - i4, i3 - i4);
        }
        zzabn zzabnVar = this.zzd;
        return new zzaes(zzabnVar.zzk(i2, zzabnVar.zzd()), this.zze.zzk(0, i3 - this.zzf));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final zzabr zzl() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final String zzm(Charset charset) {
        return new String(zzx(), charset);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final void zzn(zzabc zzabcVar) throws IOException {
        this.zzd.zzn(zzabcVar);
        this.zze.zzn(zzabcVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final boolean zzo() {
        zzabn zzabnVar = this.zzd;
        zzabn zzabnVar2 = this.zze;
        return zzabnVar2.zzj(zzabnVar.zzj(0, 0, this.zzf), 0, zzabnVar2.zzd()) == 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    /* renamed from: zzr */
    public final zzabh iterator() {
        return new zzaem(this);
    }

    private zzaes(zzabn zzabnVar, zzabn zzabnVar2) {
        this.zzd = zzabnVar;
        this.zze = zzabnVar2;
        int iZzd = zzabnVar.zzd();
        this.zzf = iZzd;
        this.zzc = zzabnVar2.zzd() + iZzd;
        this.zzg = Math.max(zzabnVar.zzf(), zzabnVar2.zzf()) + 1;
    }
}
