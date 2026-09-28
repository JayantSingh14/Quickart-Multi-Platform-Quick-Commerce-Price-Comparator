package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzabg extends zzabk {
    private final int zzc;
    private final int zzd;

    public zzabg(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzabn.zzp(i2, i2 + i3, bArr.length);
        this.zzc = i2;
        this.zzd = i3;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabk, com.google.ads.interactivemedia.v3.internal.zzabn
    public final byte zza(int i2) {
        zzabn.zzv(i2, this.zzd);
        return this.zza[this.zzc + i2];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabk, com.google.ads.interactivemedia.v3.internal.zzabn
    public final byte zzb(int i2) {
        return this.zza[this.zzc + i2];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabk
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabk, com.google.ads.interactivemedia.v3.internal.zzabn
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabk, com.google.ads.interactivemedia.v3.internal.zzabn
    public final void zze(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zza, this.zzc + i2, bArr, i3, i4);
    }
}
