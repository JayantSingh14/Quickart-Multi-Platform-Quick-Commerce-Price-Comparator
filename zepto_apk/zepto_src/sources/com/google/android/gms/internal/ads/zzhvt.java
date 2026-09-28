package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzhvt implements zzhaq {

    /* renamed from: a, reason: collision with root package name */
    public final zzhxc f34397a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f34398b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f34399c;

    public zzhvt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (!zzhhb.a(1)) {
            throw new IllegalStateException(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Given public key's length is not 32.");
        }
        this.f34397a = zzhxc.a(bArr);
        this.f34398b = bArr2;
        this.f34399c = bArr3;
        if (zzhho.f33812a == null) {
            throw new IllegalStateException("Could not initialize Ed25519.");
        }
    }

    public final void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        if (bArr3.length != 64) {
            throw new GeneralSecurityException("The length of the signature is not 64.");
        }
        byte[] bArrB = this.f34397a.b();
        if (bArr3.length == 64) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr3, 32, 64);
            int i2 = 31;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                int i3 = bArrCopyOfRange[i2] & 255;
                int i4 = zzhhm.f33809c[i2] & 255;
                if (i3 == i4) {
                    i2--;
                    bArr3 = bArr;
                } else if (i3 < i4) {
                    MessageDigest messageDigest = (MessageDigest) zzhwc.f34417e.f34420a.a(MessageDigestAlgorithms.SHA_512);
                    messageDigest.update(bArr3, 0, 32);
                    messageDigest.update(bArrB);
                    messageDigest.update(bArr2);
                    byte[] bArrDigest = messageDigest.digest();
                    long j2 = zzhhm.j(bArrDigest, 0) & 2097151;
                    long jK = zzhhm.k(2, bArrDigest) >> 5;
                    long j3 = zzhhm.j(bArrDigest, 5) >> 2;
                    long jK2 = zzhhm.k(7, bArrDigest) >> 7;
                    long jK3 = zzhhm.k(10, bArrDigest) >> 4;
                    long j4 = zzhhm.j(bArrDigest, 13) >> 1;
                    long jK4 = zzhhm.k(15, bArrDigest) >> 6;
                    long j5 = zzhhm.j(bArrDigest, 18) >> 3;
                    long j6 = zzhhm.j(bArrDigest, 21) & 2097151;
                    long jK5 = zzhhm.k(23, bArrDigest) >> 5;
                    long j7 = zzhhm.j(bArrDigest, 26) >> 2;
                    long jK6 = zzhhm.k(28, bArrDigest) >> 7;
                    long jK7 = zzhhm.k(31, bArrDigest) >> 4;
                    long j8 = zzhhm.j(bArrDigest, 34) >> 1;
                    long jK8 = zzhhm.k(36, bArrDigest) >> 6;
                    long j9 = zzhhm.j(bArrDigest, 39) >> 3;
                    long j10 = zzhhm.j(bArrDigest, 42) & 2097151;
                    long jK9 = zzhhm.k(44, bArrDigest) >> 5;
                    long j11 = (zzhhm.j(bArrDigest, 47) >> 2) & 2097151;
                    long jK10 = (zzhhm.k(49, bArrDigest) >> 7) & 2097151;
                    long jK11 = (zzhhm.k(52, bArrDigest) >> 4) & 2097151;
                    long j12 = (zzhhm.j(bArrDigest, 55) >> 1) & 2097151;
                    long jK12 = (zzhhm.k(57, bArrDigest) >> 6) & 2097151;
                    long jK13 = zzhhm.k(60, bArrDigest) >> 3;
                    long j13 = (jK11 * 666643) + j6;
                    long j14 = (jK10 * 666643) + j5;
                    long j15 = (j11 * 666643) + (jK4 & 2097151);
                    long j16 = (j15 + 1048576) >> 21;
                    long j17 = j16 << 21;
                    long j18 = (j11 * 654183) + (jK10 * 470296) + j13;
                    long j19 = (j18 + 1048576) >> 21;
                    long j20 = j19 << 21;
                    long j21 = (j11 * 136657) + (((jK11 * 654183) + ((j12 * 470296) + ((jK12 * 666643) + (j7 & 2097151)))) - (jK10 * 997805));
                    long j22 = (j21 + 1048576) >> 21;
                    long j23 = j22 << 21;
                    long j24 = ((jK11 * 136657) + (((jK12 * 654183) + ((jK13 * 470296) + (jK7 & 2097151))) - (j12 * 997805))) - (jK10 * 683901);
                    long j25 = (j24 + 1048576) >> 21;
                    long j26 = ((jK12 * 136657) + ((jK8 & 2097151) - (jK13 * 997805))) - (j12 * 683901);
                    long j27 = (j26 + 1048576) >> 21;
                    long j28 = j27 << 21;
                    long j29 = j10 - (jK13 * 683901);
                    long j30 = (j29 + 1048576) >> 21;
                    long j31 = (j11 * 470296) + j14 + j16;
                    long j32 = (j31 + 1048576) >> 21;
                    long j33 = j32 << 21;
                    long j34 = (((jK10 * 654183) + ((jK11 * 470296) + ((j12 * 666643) + (jK5 & 2097151)))) - (j11 * 997805)) + j19;
                    long j35 = (j34 + 1048576) >> 21;
                    long j36 = j35 << 21;
                    long j37 = (((jK10 * 136657) + (((j12 * 654183) + ((jK12 * 470296) + ((jK13 * 666643) + (jK6 & 2097151)))) - (jK11 * 997805))) - (j11 * 683901)) + j22;
                    long j38 = (j37 + 1048576) >> 21;
                    long j39 = j38 << 21;
                    long j40 = (((j12 * 136657) + (((jK13 * 654183) + (j8 & 2097151)) - (jK12 * 997805))) - (jK11 * 683901)) + j25;
                    long j41 = (j40 + 1048576) >> 21;
                    long j42 = (((jK13 * 136657) + j9) - (jK12 * 683901)) + j27;
                    long j43 = (j42 + 1048576) >> 21;
                    long j44 = (j24 - (j25 << 21)) + j38;
                    long j45 = (j44 * 666643) + j2;
                    long j46 = (j45 + 1048576) >> 21;
                    long j47 = j46 << 21;
                    long j48 = (j26 - j28) + j41;
                    long j49 = j40 - (j41 << 21);
                    long j50 = (j44 * 654183) + (j49 * 470296) + (j48 * 666643) + (j3 & 2097151);
                    long j51 = (j50 + 1048576) >> 21;
                    long j52 = j51 << 21;
                    long j53 = (j29 - (j30 << 21)) + j43;
                    long j54 = j42 - (j43 << 21);
                    long j55 = (j44 * 136657) + (((j48 * 654183) + ((j54 * 470296) + ((j53 * 666643) + (jK3 & 2097151)))) - (j49 * 997805));
                    long j56 = (j55 + 1048576) >> 21;
                    long j57 = j56 << 21;
                    long j58 = (jK9 & 2097151) + j30;
                    long j59 = ((j48 * 136657) + (((j53 * 654183) + ((j58 * 470296) + (j15 - j17))) - (j54 * 997805))) - (j49 * 683901);
                    long j60 = (j59 + 1048576) >> 21;
                    long j61 = j60 << 21;
                    long j62 = ((j53 * 136657) + (((j18 - j20) + j32) - (j58 * 997805))) - (j54 * 683901);
                    long j63 = (j62 + 1048576) >> 21;
                    long j64 = j63 << 21;
                    long j65 = ((j21 - j23) + j35) - (j58 * 683901);
                    long j66 = (j65 + 1048576) >> 21;
                    long j67 = j66 << 21;
                    long j68 = (j44 * 470296) + (j49 * 666643) + (jK & 2097151) + j46;
                    long j69 = (j68 + 1048576) >> 21;
                    long j70 = (((j49 * 654183) + ((j48 * 470296) + ((j54 * 666643) + (jK2 & 2097151)))) - (j44 * 997805)) + j51;
                    long j71 = (j70 + 1048576) >> 21;
                    long j72 = (((j49 * 136657) + (((j54 * 654183) + ((j53 * 470296) + ((j58 * 666643) + (j4 & 2097151)))) - (j48 * 997805))) - (j44 * 683901)) + j56;
                    long j73 = (j72 + 1048576) >> 21;
                    long j74 = (((j54 * 136657) + (((j58 * 654183) + (j31 - j33)) - (j53 * 997805))) - (j48 * 683901)) + j60;
                    long j75 = (j74 + 1048576) >> 21;
                    long j76 = (((j58 * 136657) + (j34 - j36)) - (j53 * 683901)) + j63;
                    long j77 = (j76 + 1048576) >> 21;
                    long j78 = (j37 - j39) + j66;
                    long j79 = (j78 + 1048576) >> 21;
                    long j80 = j79 << 21;
                    long j81 = (j79 * 666643) + (j45 - j47);
                    long j82 = j81 >> 21;
                    long j83 = j82 << 21;
                    long j84 = (j79 * 470296) + (j68 - (j69 << 21)) + j82;
                    long j85 = j84 >> 21;
                    long j86 = j85 << 21;
                    long j87 = (j79 * 654183) + (j50 - j52) + j69 + j85;
                    long j88 = j87 >> 21;
                    long j89 = j88 << 21;
                    long j90 = ((j70 - (j71 << 21)) - (j79 * 997805)) + j88;
                    long j91 = j90 >> 21;
                    long j92 = j91 << 21;
                    long j93 = (j79 * 136657) + (j55 - j57) + j71 + j91;
                    long j94 = j93 >> 21;
                    long j95 = j94 << 21;
                    long j96 = ((j72 - (j73 << 21)) - (j79 * 683901)) + j94;
                    long j97 = j96 >> 21;
                    long j98 = j97 << 21;
                    long j99 = (j59 - j61) + j73 + j97;
                    long j100 = j99 >> 21;
                    long j101 = j100 << 21;
                    long j102 = (j74 - (j75 << 21)) + j100;
                    long j103 = j102 >> 21;
                    long j104 = j103 << 21;
                    long j105 = (j62 - j64) + j75 + j103;
                    long j106 = j105 >> 21;
                    long j107 = j106 << 21;
                    long j108 = (j76 - (j77 << 21)) + j106;
                    long j109 = j108 >> 21;
                    long j110 = j109 << 21;
                    long j111 = (j65 - j67) + j77 + j109;
                    long j112 = j111 >> 21;
                    long j113 = j112 << 21;
                    long j114 = (j78 - j80) + j112;
                    long j115 = j114 >> 21;
                    long j116 = j115 << 21;
                    long j117 = (666643 * j115) + (j81 - j83);
                    long j118 = j117 >> 21;
                    long j119 = j118 << 21;
                    long j120 = (470296 * j115) + (j84 - j86) + j118;
                    long j121 = j120 >> 21;
                    long j122 = j121 << 21;
                    long j123 = (654183 * j115) + (j87 - j89) + j121;
                    long j124 = j123 >> 21;
                    long j125 = j124 << 21;
                    long j126 = ((j90 - j92) - (997805 * j115)) + j124;
                    long j127 = j126 >> 21;
                    long j128 = j127 << 21;
                    long j129 = (136657 * j115) + (j93 - j95) + j127;
                    long j130 = j129 >> 21;
                    long j131 = j130 << 21;
                    long j132 = ((j96 - j98) - (j115 * 683901)) + j130;
                    long j133 = j132 >> 21;
                    long j134 = j133 << 21;
                    long j135 = (j99 - j101) + j133;
                    long j136 = j135 >> 21;
                    long j137 = j136 << 21;
                    long j138 = (j102 - j104) + j136;
                    long j139 = j138 >> 21;
                    long j140 = j139 << 21;
                    long j141 = (j105 - j107) + j139;
                    long j142 = j141 >> 21;
                    long j143 = j142 << 21;
                    long j144 = (j108 - j110) + j142;
                    long j145 = j144 >> 21;
                    long j146 = j145 << 21;
                    long j147 = (j111 - j113) + j145;
                    long j148 = j147 >> 21;
                    bArrDigest[0] = (byte) (j117 - j119);
                    long j149 = j138 - j140;
                    long j150 = j135 - j137;
                    long j151 = j132 - j134;
                    long j152 = j129 - j131;
                    long j153 = j126 - j128;
                    long j154 = j123 - j125;
                    long j155 = j120 - j122;
                    bArrDigest[1] = (byte) (r13 >> 8);
                    bArrDigest[2] = (byte) ((r13 >> 16) | (j155 << 5));
                    bArrDigest[3] = (byte) (j155 >> 3);
                    bArrDigest[4] = (byte) (j155 >> 11);
                    bArrDigest[5] = (byte) ((j155 >> 19) | (j154 << 2));
                    bArrDigest[6] = (byte) (j154 >> 6);
                    bArrDigest[7] = (byte) ((j154 >> 14) | (j153 << 7));
                    bArrDigest[8] = (byte) (j153 >> 1);
                    bArrDigest[9] = (byte) (j153 >> 9);
                    bArrDigest[10] = (byte) ((j153 >> 17) | (j152 << 4));
                    bArrDigest[11] = (byte) (j152 >> 4);
                    bArrDigest[12] = (byte) (j152 >> 12);
                    bArrDigest[13] = (byte) ((j152 >> 20) | (j151 + j151));
                    bArrDigest[14] = (byte) (j151 >> 7);
                    bArrDigest[15] = (byte) ((j151 >> 15) | (j150 << 6));
                    bArrDigest[16] = (byte) (j150 >> 2);
                    bArrDigest[17] = (byte) (j150 >> 10);
                    bArrDigest[18] = (byte) ((j150 >> 18) | (j149 << 3));
                    long j156 = j147 - (j148 << 21);
                    long j157 = (j114 - j116) + j148;
                    long j158 = j144 - j146;
                    bArrDigest[19] = (byte) (j149 >> 5);
                    bArrDigest[20] = (byte) (j149 >> 13);
                    bArrDigest[21] = (byte) (j141 - j143);
                    bArrDigest[22] = (byte) (r9 >> 8);
                    bArrDigest[23] = (byte) ((r9 >> 16) | (j158 << 5));
                    bArrDigest[24] = (byte) (j158 >> 3);
                    bArrDigest[25] = (byte) (j158 >> 11);
                    bArrDigest[26] = (byte) ((j158 >> 19) | (j156 << 2));
                    bArrDigest[27] = (byte) (j156 >> 6);
                    bArrDigest[28] = (byte) ((j156 >> 14) | (j157 << 7));
                    bArrDigest[29] = (byte) (j157 >> 1);
                    bArrDigest[30] = (byte) (j157 >> 9);
                    bArrDigest[31] = (byte) (j157 >> 17);
                    long[] jArr = new long[10];
                    long[] jArrG = zzhht.g(bArrB);
                    long[] jArr2 = new long[10];
                    jArr2[0] = 1;
                    long[] jArr3 = new long[10];
                    long[] jArr4 = new long[10];
                    long[] jArr5 = new long[10];
                    long[] jArr6 = new long[10];
                    long[] jArr7 = new long[10];
                    zzhht.f(jArr4, jArrG);
                    zzhht.e(jArr5, jArr4, zzhho.f33812a);
                    zzhht.b(jArr4, jArr4, jArr2);
                    zzhht.a(jArr5, jArr5, jArr2);
                    long[] jArr8 = new long[10];
                    zzhht.f(jArr8, jArr5);
                    zzhht.e(jArr8, jArr8, jArr5);
                    zzhht.f(jArr, jArr8);
                    zzhht.e(jArr, jArr, jArr5);
                    zzhht.e(jArr, jArr, jArr4);
                    long[] jArr9 = new long[10];
                    long[] jArr10 = new long[10];
                    long[] jArr11 = new long[10];
                    zzhht.f(jArr9, jArr);
                    zzhht.f(jArr10, jArr9);
                    zzhht.f(jArr10, jArr10);
                    zzhht.e(jArr10, jArr, jArr10);
                    zzhht.e(jArr9, jArr9, jArr10);
                    zzhht.f(jArr9, jArr9);
                    zzhht.e(jArr9, jArr10, jArr9);
                    zzhht.f(jArr10, jArr9);
                    for (int i5 = 1; i5 < 5; i5++) {
                        zzhht.f(jArr10, jArr10);
                    }
                    zzhht.e(jArr9, jArr10, jArr9);
                    zzhht.f(jArr10, jArr9);
                    for (int i6 = 1; i6 < 10; i6++) {
                        zzhht.f(jArr10, jArr10);
                    }
                    zzhht.e(jArr10, jArr10, jArr9);
                    zzhht.f(jArr11, jArr10);
                    for (int i7 = 1; i7 < 20; i7++) {
                        zzhht.f(jArr11, jArr11);
                    }
                    zzhht.e(jArr10, jArr11, jArr10);
                    zzhht.f(jArr10, jArr10);
                    for (int i8 = 1; i8 < 10; i8++) {
                        zzhht.f(jArr10, jArr10);
                    }
                    zzhht.e(jArr9, jArr10, jArr9);
                    zzhht.f(jArr10, jArr9);
                    for (int i9 = 1; i9 < 50; i9++) {
                        zzhht.f(jArr10, jArr10);
                    }
                    zzhht.e(jArr10, jArr10, jArr9);
                    zzhht.f(jArr11, jArr10);
                    for (int i10 = 1; i10 < 100; i10++) {
                        zzhht.f(jArr11, jArr11);
                    }
                    zzhht.e(jArr10, jArr11, jArr10);
                    zzhht.f(jArr10, jArr10);
                    for (int i11 = 1; i11 < 50; i11++) {
                        zzhht.f(jArr10, jArr10);
                    }
                    zzhht.e(jArr9, jArr10, jArr9);
                    zzhht.f(jArr9, jArr9);
                    zzhht.f(jArr9, jArr9);
                    zzhht.e(jArr, jArr9, jArr);
                    zzhht.e(jArr, jArr, jArr8);
                    zzhht.e(jArr, jArr, jArr4);
                    zzhht.f(jArr6, jArr);
                    zzhht.e(jArr6, jArr6, jArr5);
                    zzhht.b(jArr7, jArr6, jArr4);
                    if (zzhhm.c(jArr7)) {
                        zzhht.a(jArr7, jArr6, jArr4);
                        if (zzhhm.c(jArr7)) {
                            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                        }
                        zzhht.e(jArr, jArr, zzhho.f33814c);
                    }
                    if (!zzhhm.c(jArr) && ((bArrB[31] & 255) >> 7) != 0) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
                    }
                    if ((zzhht.h(jArr)[0] & 1) == ((bArrB[31] & 255) >> 7)) {
                        for (int i12 = 0; i12 < 10; i12++) {
                            jArr[i12] = -jArr[i12];
                        }
                    }
                    zzhht.e(jArr3, jArr, jArrG);
                    zzhhk zzhhkVar = new zzhhk(jArr, jArrG, jArr2);
                    zzhhi[] zzhhiVarArr = new zzhhi[8];
                    zzhhiVarArr[0] = new zzhhi(new zzhhl(zzhhkVar, jArr3));
                    zzhhj zzhhjVar = new zzhhj(new zzhhk(), new long[10]);
                    zzhhm.f(zzhhjVar, zzhhkVar);
                    zzhhl zzhhlVar = new zzhhl(zzhhjVar);
                    for (int i13 = 1; i13 < 8; i13++) {
                        zzhhm.d(zzhhjVar, zzhhlVar, zzhhiVarArr[i13 - 1]);
                        zzhhiVarArr[i13] = new zzhhi(new zzhhl(zzhhjVar));
                    }
                    byte[] bArrI = zzhhm.i(bArrDigest);
                    byte[] bArrI2 = zzhhm.i(bArrCopyOfRange);
                    zzhhj zzhhjVar2 = new zzhhj();
                    zzhhl zzhhlVar2 = new zzhhl();
                    int i14 = 255;
                    while (i14 >= 0 && bArrI[i14] == 0 && bArrI2[i14] == 0) {
                        i14--;
                    }
                    while (i14 >= 0) {
                        zzhhm.f(zzhhjVar2, new zzhhk(zzhhjVar2));
                        byte b2 = bArrI[i14];
                        if (b2 > 0) {
                            zzhhl.a(zzhhlVar2, zzhhjVar2);
                            zzhhm.d(zzhhjVar2, zzhhlVar2, zzhhiVarArr[bArrI[i14] / 2]);
                        } else if (b2 < 0) {
                            zzhhl.a(zzhhlVar2, zzhhjVar2);
                            zzhhm.e(zzhhjVar2, zzhhlVar2, zzhhiVarArr[(-bArrI[i14]) / 2]);
                        }
                        byte b3 = bArrI2[i14];
                        if (b3 > 0) {
                            zzhhl.a(zzhhlVar2, zzhhjVar2);
                            zzhhm.d(zzhhjVar2, zzhhlVar2, zzhho.f33816e[bArrI2[i14] / 2]);
                        } else if (b3 < 0) {
                            zzhhl.a(zzhhlVar2, zzhhjVar2);
                            zzhhm.e(zzhhjVar2, zzhhlVar2, zzhho.f33816e[(-bArrI2[i14]) / 2]);
                        }
                        i14--;
                    }
                    byte[] bArrB2 = new zzhhk(zzhhjVar2).b();
                    for (int i15 = 0; i15 < 32; i15++) {
                        if (bArrB2[i15] == bArr[i15]) {
                        }
                    }
                    return;
                }
            }
        }
        throw new GeneralSecurityException("Signature check failed.");
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34398b;
        int length = bArr3.length;
        byte[] bArr4 = this.f34399c;
        if (length == 0 && bArr4.length == 0) {
            a(bArr, bArr2);
        } else {
            if (!zzhkl.c(bArr3, bArr)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            if (bArr4.length != 0) {
                bArr2 = zzhvp.a(bArr2, bArr4);
            }
            a(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
    }
}
