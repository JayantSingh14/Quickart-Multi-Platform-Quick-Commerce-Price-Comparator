package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzaek implements zzadw {
    private final zzadz zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzaek(zzadz zzadzVar, String str, Object[] objArr) {
        this.zza = zzadzVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 1;
        int i4 = 13;
        while (true) {
            int i5 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.zzd = i2 | (cCharAt2 << i4);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i4;
                i4 += 13;
                i3 = i5;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadw
    public final zzadz zza() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadw
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadw
    public final int zzc() {
        int i2 = this.zzd;
        if ((i2 & 1) != 0) {
            return 1;
        }
        return (i2 & 4) == 4 ? 3 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
