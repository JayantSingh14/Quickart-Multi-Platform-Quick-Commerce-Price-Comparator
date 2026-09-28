package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
class zzabk extends zzabj {
    protected final byte[] zza;

    public zzabk(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzabn) || zzd() != ((zzabn) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzabk)) {
            return obj.equals(this);
        }
        zzabk zzabkVar = (zzabk) obj;
        int iZzq = zzq();
        int iZzq2 = zzabkVar.zzq();
        if (iZzq == 0 || iZzq2 == 0 || iZzq == iZzq2) {
            return zzg(zzabkVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public byte zza(int i2) {
        return this.zza[i2];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public byte zzb(int i2) {
        return this.zza[i2];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public void zze(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zza, i2, bArr, i3, i4);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabj
    public final boolean zzg(zzabn zzabnVar, int i2, int i3) {
        if (i3 > zzabnVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i3 + zzd());
        }
        int i4 = i2 + i3;
        if (i4 > zzabnVar.zzd()) {
            int iZzd = zzabnVar.zzd();
            StringBuilder sbT = b.t(i2, i3, "Ran off end of other: ", ", ", ", ");
            sbT.append(iZzd);
            throw new IllegalArgumentException(sbT.toString());
        }
        if (!(zzabnVar instanceof zzabk)) {
            return zzabnVar.zzk(i2, i4).equals(zzk(0, i3));
        }
        zzabk zzabkVar = (zzabk) zzabnVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzabkVar.zza;
        int iZzc = zzc() + i3;
        int iZzc2 = zzc();
        int iZzc3 = zzabkVar.zzc() + i2;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final int zzi(int i2, int i3, int i4) {
        return zzacx.zzb(i2, this.zza, zzc() + i3, i4);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final int zzj(int i2, int i3, int i4) {
        int iZzc = zzc() + i3;
        return zzafz.zzf(i2, this.zza, iZzc, i4 + iZzc);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final zzabn zzk(int i2, int i3) {
        int iZzp = zzabn.zzp(i2, i3, zzd());
        return iZzp == 0 ? zzabn.zzb : new zzabg(this.zza, zzc() + i2, iZzp);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final zzabr zzl() {
        return zzabr.zzu(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final void zzn(zzabc zzabcVar) throws IOException {
        ((zzabt) zzabcVar).zzc(this.zza, zzc(), zzd());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabn
    public final boolean zzo() {
        int iZzc = zzc();
        return zzafz.zzi(this.zza, iZzc, zzd() + iZzc);
    }
}
