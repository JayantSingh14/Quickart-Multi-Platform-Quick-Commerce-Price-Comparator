package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzaca extends zzacc {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f37365c;

    /* renamed from: d, reason: collision with root package name */
    public int f37366d;

    /* renamed from: e, reason: collision with root package name */
    public int f37367e;

    /* renamed from: g, reason: collision with root package name */
    public int f37369g;

    /* renamed from: h, reason: collision with root package name */
    public int f37370h = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: f, reason: collision with root package name */
    public int f37368f = 0;

    public /* synthetic */ zzaca(byte[] bArr, int i2) {
        this.f37365c = bArr;
        this.f37366d = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final int a() {
        return this.f37368f;
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final int b(int i2) throws zzadi {
        if (i2 < 0) {
            throw zzadi.c();
        }
        int i3 = i2 + this.f37368f;
        if (i3 < 0) {
            throw zzadi.d();
        }
        int i4 = this.f37370h;
        if (i3 > i4) {
            throw zzadi.e();
        }
        this.f37370h = i3;
        int i5 = this.f37366d + this.f37367e;
        this.f37366d = i5;
        if (i5 <= i3) {
            this.f37367e = 0;
            return i4;
        }
        int i6 = i5 - i3;
        this.f37367e = i6;
        this.f37366d = i5 - i6;
        return i4;
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final int c() throws zzadi {
        if (i()) {
            this.f37369g = 0;
            return 0;
        }
        int iN = n();
        this.f37369g = iN;
        if ((iN >>> 3) != 0) {
            return iN;
        }
        throw new zzadi("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final zzaby d() throws zzadi {
        int iN = n();
        byte[] bArr = this.f37365c;
        if (iN > 0) {
            int i2 = this.f37366d;
            int i3 = this.f37368f;
            if (iN <= i2 - i3) {
                zzaby zzabyVarQ = zzaby.q(i3, bArr, iN);
                this.f37368f += iN;
                return zzabyVarQ;
            }
        }
        if (iN == 0) {
            return zzaby.f37363b;
        }
        if (iN > 0) {
            int i4 = this.f37366d;
            int i5 = this.f37368f;
            if (iN <= i4 - i5) {
                int i6 = iN + i5;
                this.f37368f = i6;
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5, i6);
                zzaby zzabyVar = zzaby.f37363b;
                return new zzabv(bArrCopyOfRange);
            }
        }
        if (iN <= 0) {
            throw zzadi.c();
        }
        throw zzadi.e();
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final String e() throws zzadi {
        int iN = n();
        if (iN > 0) {
            int i2 = this.f37366d;
            int i3 = this.f37368f;
            if (iN <= i2 - i3) {
                String str = new String(this.f37365c, i3, iN, zzadg.f37410a);
                this.f37368f += iN;
                return str;
            }
        }
        if (iN == 0) {
            return "";
        }
        if (iN < 0) {
            throw zzadi.c();
        }
        throw zzadi.e();
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final String f() throws zzadi {
        int iN = n();
        if (iN > 0) {
            int i2 = this.f37366d;
            int i3 = this.f37368f;
            if (iN <= i2 - i3) {
                String strD = zzafx.d(i3, this.f37365c, iN);
                this.f37368f += iN;
                return strD;
            }
        }
        if (iN == 0) {
            return "";
        }
        if (iN <= 0) {
            throw zzadi.c();
        }
        throw zzadi.e();
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final void g(int i2) throws zzadi {
        if (this.f37369g != i2) {
            throw new zzadi("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final void h(int i2) {
        this.f37370h = i2;
        int i3 = this.f37366d + this.f37367e;
        this.f37366d = i3;
        if (i3 <= i2) {
            this.f37367e = 0;
            return;
        }
        int i4 = i3 - i2;
        this.f37367e = i4;
        this.f37366d = i3 - i4;
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final boolean i() {
        return this.f37368f == this.f37366d;
    }

    @Override // com.google.android.gms.internal.pal.zzacc
    public final boolean j() {
        return p() != 0;
    }

    public final int m() throws zzadi {
        int i2 = this.f37368f;
        if (this.f37366d - i2 < 4) {
            throw zzadi.e();
        }
        this.f37368f = i2 + 4;
        byte[] bArr = this.f37365c;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public final int n() {
        int i2;
        int i3 = this.f37368f;
        int i4 = this.f37366d;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.f37365c;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f37368f = i5;
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
                this.f37368f = i6;
                return i2;
            }
        }
        return (int) q();
    }

    public final long o() throws zzadi {
        int i2 = this.f37368f;
        if (this.f37366d - i2 < 8) {
            throw zzadi.e();
        }
        this.f37368f = i2 + 8;
        byte[] bArr = this.f37365c;
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public final long p() {
        long j2;
        long j3;
        long j4;
        int i2 = this.f37368f;
        int i3 = this.f37366d;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.f37365c;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.f37368f = i4;
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
                            long j5 = (-2080896) ^ i10;
                            i5 = i9;
                            j2 = j5;
                        } else {
                            i7 = i2 + 5;
                            long j6 = (bArr[i9] << 28) ^ i10;
                            if (j6 >= 0) {
                                j4 = 266354560;
                            } else {
                                int i11 = i2 + 6;
                                long j7 = j6 ^ (bArr[i7] << 35);
                                if (j7 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i7 = i2 + 7;
                                    j6 = j7 ^ (bArr[i11] << 42);
                                    if (j6 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i11 = i2 + 8;
                                        j7 = j6 ^ (bArr[i7] << 49);
                                        if (j7 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i7 = i2 + 9;
                                            long j8 = (j7 ^ (bArr[i11] << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    j2 = j8;
                                                    i5 = i12;
                                                }
                                            } else {
                                                j2 = j8;
                                            }
                                        }
                                    }
                                }
                                j2 = j7 ^ j3;
                                i5 = i11;
                            }
                            j2 = j6 ^ j4;
                        }
                    }
                    i5 = i7;
                }
                this.f37368f = i5;
                return j2;
            }
        }
        return q();
    }

    public final long q() throws zzadi {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            int i3 = this.f37368f;
            if (i3 == this.f37366d) {
                throw zzadi.e();
            }
            this.f37368f = i3 + 1;
            j2 |= (r3 & 127) << i2;
            if ((this.f37365c[i3] & 128) == 0) {
                return j2;
            }
        }
        throw new zzadi("CodedInputStream encountered a malformed varint.");
    }
}
