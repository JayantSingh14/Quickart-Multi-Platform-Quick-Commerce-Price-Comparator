package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class zzabp extends zzabr {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk;

    public /* synthetic */ zzabp(byte[] bArr, int i2, int i3, boolean z, zzabo zzaboVar) {
        super(null);
        this.zzk = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zze = bArr;
        this.zzf = i3 + i2;
        this.zzh = i2;
        this.zzi = i2;
    }

    private final void zzv() {
        int i2 = this.zzf + this.zzg;
        this.zzf = i2;
        int i3 = i2 - this.zzi;
        int i4 = this.zzk;
        if (i3 <= i4) {
            this.zzg = 0;
            return;
        }
        int i5 = i3 - i4;
        this.zzg = i5;
        this.zzf = i2 - i5;
    }

    public final byte zza() throws IOException {
        int i2 = this.zzh;
        if (i2 == this.zzf) {
            throw zzacz.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i2 + 1;
        return bArr[i2];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final int zzb() {
        return this.zzh - this.zzi;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final int zzc(int i2) throws zzacz {
        if (i2 < 0) {
            throw zzacz.zzf();
        }
        int i3 = (this.zzh - this.zzi) + i2;
        if (i3 < 0) {
            throw zzacz.zzg();
        }
        int i4 = this.zzk;
        if (i3 > i4) {
            throw zzacz.zzi();
        }
        this.zzk = i3;
        zzv();
        return i4;
    }

    public final int zzd() throws IOException {
        int i2 = this.zzh;
        if (this.zzf - i2 < 4) {
            throw zzacz.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i2 + 4;
        int i3 = bArr[i2] & 255;
        int i4 = bArr[i2 + 1] & 255;
        int i5 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public final int zze() throws IOException {
        int i2;
        int i3 = this.zzh;
        int i4 = this.zzf;
        if (i4 != i3) {
            byte[] bArr = this.zze;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.zzh = i5;
                return b2;
            }
            if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b2;
                if (i7 < 0) {
                    i2 = i7 ^ (-128);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << 14) ^ i7;
                    if (i9 >= 0) {
                        i2 = i9 ^ 16256;
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << 21);
                        if (i11 < 0) {
                            i2 = (-2080896) ^ i11;
                        } else {
                            i8 = i3 + 5;
                            byte b3 = bArr[i10];
                            int i12 = (i11 ^ (b3 << 28)) ^ 266354560;
                            if (b3 < 0) {
                                i10 = i3 + 6;
                                if (bArr[i8] < 0) {
                                    i8 = i3 + 7;
                                    if (bArr[i10] < 0) {
                                        i10 = i3 + 8;
                                        if (bArr[i8] < 0) {
                                            i8 = i3 + 9;
                                            if (bArr[i10] < 0) {
                                                int i13 = i3 + 10;
                                                if (bArr[i8] >= 0) {
                                                    i6 = i13;
                                                    i2 = i12;
                                                }
                                            }
                                        }
                                    }
                                }
                                i2 = i12;
                            }
                            i2 = i12;
                        }
                        i6 = i10;
                    }
                    i6 = i8;
                }
                this.zzh = i6;
                return i2;
            }
        }
        return (int) zzi();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final int zzf() throws IOException {
        if (zzp()) {
            this.zzj = 0;
            return 0;
        }
        int iZze = zze();
        this.zzj = iZze;
        if ((iZze >>> 3) != 0) {
            return iZze;
        }
        throw zzacz.zzc();
    }

    public final long zzg() throws IOException {
        int i2 = this.zzh;
        if (this.zzf - i2 < 8) {
            throw zzacz.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i2 + 8;
        long j2 = bArr[i2];
        long j3 = bArr[i2 + 2];
        long j4 = bArr[i2 + 3];
        return ((bArr[i2 + 6] & 255) << 48) | (j2 & 255) | ((bArr[i2 + 1] & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 7] & 255) << 56);
    }

    public final long zzh() throws IOException {
        long j2;
        long j3;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zze;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.zzh = i4;
                return b2;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b2;
                if (i6 < 0) {
                    j2 = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        j2 = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            long j4 = (-2080896) ^ i10;
                            i5 = i9;
                            j2 = j4;
                        } else {
                            i7 = i2 + 5;
                            long j5 = (bArr[i9] << 28) ^ i10;
                            if (j5 >= 0) {
                                j2 = j5 ^ 266354560;
                            } else {
                                i5 = i2 + 6;
                                long j6 = (bArr[i7] << 35) ^ j5;
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    int i11 = i2 + 7;
                                    long j7 = j6 ^ (bArr[i5] << 42);
                                    if (j7 >= 0) {
                                        j2 = j7 ^ 4363953127296L;
                                    } else {
                                        i5 = i2 + 8;
                                        j6 = j7 ^ (bArr[i11] << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i11 = i2 + 9;
                                            long j8 = (j6 ^ (bArr[i5] << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                i5 = i2 + 10;
                                                if (bArr[i11] >= 0) {
                                                    j2 = j8;
                                                }
                                            } else {
                                                j2 = j8;
                                            }
                                        }
                                    }
                                    i5 = i11;
                                }
                                j2 = j6 ^ j3;
                            }
                        }
                    }
                    i5 = i7;
                }
                this.zzh = i5;
                return j2;
            }
        }
        return zzi();
    }

    public final long zzi() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j2 |= (r3 & 127) << i2;
            if ((zza() & 128) == 0) {
                return j2;
            }
        }
        throw zzacz.zze();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final zzabn zzj() throws IOException {
        int iZze = zze();
        if (iZze > 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (iZze <= i2 - i3) {
                zzabn zzabnVarZzs = zzabn.zzs(this.zze, i3, iZze);
                this.zzh += iZze;
                return zzabnVarZzs;
            }
        }
        if (iZze == 0) {
            return zzabn.zzb;
        }
        if (iZze > 0) {
            int i4 = this.zzf;
            int i5 = this.zzh;
            if (iZze <= i4 - i5) {
                int i6 = iZze + i5;
                this.zzh = i6;
                return new zzabk(Arrays.copyOfRange(this.zze, i5, i6));
            }
        }
        if (iZze <= 0) {
            throw zzacz.zzf();
        }
        throw zzacz.zzi();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final String zzk() throws IOException {
        int iZze = zze();
        if (iZze > 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (iZze <= i2 - i3) {
                String str = new String(this.zze, i3, iZze, zzacx.zzb);
                this.zzh += iZze;
                return str;
            }
        }
        if (iZze == 0) {
            return "";
        }
        if (iZze < 0) {
            throw zzacz.zzf();
        }
        throw zzacz.zzi();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final String zzl() throws IOException {
        int iZze = zze();
        if (iZze > 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (iZze <= i2 - i3) {
                String strZzg = zzafz.zzg(this.zze, i3, iZze);
                this.zzh += iZze;
                return strZzg;
            }
        }
        if (iZze == 0) {
            return "";
        }
        if (iZze <= 0) {
            throw zzacz.zzf();
        }
        throw zzacz.zzi();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final void zzm(int i2) throws zzacz {
        if (this.zzj != i2) {
            throw zzacz.zzb();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final void zzn(int i2) {
        this.zzk = i2;
        zzv();
    }

    public final void zzo(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (i2 <= i3 - i4) {
                this.zzh = i4 + i2;
                return;
            }
        }
        if (i2 >= 0) {
            throw zzacz.zzi();
        }
        throw zzacz.zzf();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final boolean zzp() throws IOException {
        return this.zzh == this.zzf;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final boolean zzq() throws IOException {
        return zzh() != 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabr
    public final boolean zzr(int i2) throws IOException {
        int iZzf;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i4 < 10) {
                    if (zza() < 0) {
                        i4++;
                    }
                }
                throw zzacz.zze();
            }
            while (i4 < 10) {
                byte[] bArr = this.zze;
                int i5 = this.zzh;
                this.zzh = i5 + 1;
                if (bArr[i5] < 0) {
                    i4++;
                }
            }
            throw zzacz.zze();
            return true;
        }
        if (i3 == 1) {
            zzo(8);
            return true;
        }
        if (i3 == 2) {
            zzo(zze());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw zzacz.zza();
            }
            zzo(4);
            return true;
        }
        do {
            iZzf = zzf();
            if (iZzf == 0) {
                break;
            }
        } while (zzr(iZzf));
        zzm(((i2 >>> 3) << 3) | 4);
        return true;
    }
}
