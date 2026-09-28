package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public abstract class zzaaa extends zzaad {
    @Override // com.google.android.gms.internal.ads.zzaad
    public final zzaae f(zzmk[] zzmkVarArr, zzyh zzyhVar, zzwg zzwgVar, zzbf zzbfVar) {
        int[][][] iArr;
        int[][][] iArr2;
        boolean z;
        zzv[] zzvVarArr;
        int i2;
        int[] iArr3;
        zzyh zzyhVar2 = zzyhVar;
        int[] iArr4 = new int[3];
        zzbg[][] zzbgVarArr = new zzbg[3][];
        int[][][] iArr5 = new int[3][][];
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = zzyhVar2.f35905a;
            zzbgVarArr[i3] = new zzbg[i4];
            iArr5[i3] = new int[i4][];
        }
        int i5 = 2;
        int[] iArr6 = new int[2];
        for (int i6 = 0; i6 < 2; i6++) {
            iArr6[i6] = zzmkVarArr[i6].c();
        }
        int i7 = 0;
        while (i7 < zzyhVar2.f35905a) {
            zzbg zzbgVarA = zzyhVar2.a(i7);
            int i8 = zzbgVarA.f24985c;
            int i9 = i5;
            int i10 = 0;
            int i11 = 0;
            boolean z2 = true;
            while (true) {
                zzvVarArr = zzbgVarA.f24986d;
                i2 = zzbgVarA.f24983a;
                if (i10 >= i5) {
                    break;
                }
                zzmk zzmkVar = zzmkVarArr[i10];
                int iMax = 0;
                int i12 = 0;
                while (i12 < i2) {
                    int i13 = i12;
                    iMax = Math.max(iMax, zzmkVar.b(zzvVarArr[i13]) & 7);
                    i12 = i13 + 1;
                }
                boolean z3 = iArr4[i10] == 0;
                if (iMax > i11) {
                    i11 = iMax;
                    z2 = z3;
                } else if (iMax == i11 && i8 == 5 && !z2 && z3) {
                    z2 = true;
                    i11 = iMax;
                } else {
                    i10++;
                    i5 = 2;
                }
                i9 = i10;
                i10++;
                i5 = 2;
            }
            if (i9 == i5) {
                iArr3 = new int[i2];
            } else {
                zzmk zzmkVar2 = zzmkVarArr[i9];
                int[] iArr7 = new int[i2];
                for (int i14 = 0; i14 < i2; i14++) {
                    iArr7[i14] = zzmkVar2.b(zzvVarArr[i14]);
                }
                iArr3 = iArr7;
            }
            int i15 = iArr4[i9];
            zzbgVarArr[i9][i15] = zzbgVarA;
            iArr5[i9][i15] = iArr3;
            iArr4[i9] = i15 + 1;
            i7++;
            zzyhVar2 = zzyhVar;
            i5 = 2;
        }
        int i16 = i5;
        zzyh[] zzyhVarArr = new zzyh[i16];
        String[] strArr = new String[i16];
        int[] iArr8 = new int[i16];
        int i17 = 0;
        while (i17 < i16) {
            int i18 = iArr4[i17];
            zzyhVarArr[i17] = new zzyh((zzbg[]) zzfj.m(zzbgVarArr[i17], i18));
            iArr5[i17] = (int[][]) zzfj.m(iArr5[i17], i18);
            strArr[i17] = zzmkVarArr[i17].d();
            iArr8[i17] = zzmkVarArr[i17].zza();
            i17++;
            i16 = 2;
        }
        int i19 = i16;
        zzzz zzzzVar = new zzzz(iArr8, zzyhVarArr, iArr6, iArr5, new zzyh((zzbg[]) zzfj.m(zzbgVarArr[i19], iArr4[i19])));
        Pair pairG = g(zzzzVar, iArr5, iArr6);
        zzaab[] zzaabVarArr = (zzaab[]) pairG.second;
        List[] listArr = new List[zzaabVarArr.length];
        for (int i20 = 0; i20 < zzaabVarArr.length; i20++) {
            zzaab zzaabVar = zzaabVarArr[i20];
            listArr[i20] = zzaabVar != null ? zzgtd.n(zzaabVar) : zzguy.f33232e;
        }
        zzgta zzgtaVar = new zzgta();
        for (int i21 = 0; i21 < 2; i21++) {
            zzyh[] zzyhVarArr2 = zzzzVar.f36001b;
            zzyh zzyhVar3 = zzyhVarArr2[i21];
            List list = listArr[i21];
            int i22 = 0;
            while (i22 < zzyhVar3.f35905a) {
                zzbg zzbgVarA2 = zzyhVar3.a(i22);
                int i23 = zzyhVarArr2[i21].a(i22).f24983a;
                int[] iArr9 = new int[i23];
                int i24 = 0;
                int i25 = 0;
                while (true) {
                    iArr = zzzzVar.f36003d;
                    if (i24 >= i23) {
                        break;
                    }
                    if ((iArr[i21][i22][i24] & 7) == 4) {
                        iArr9[i25] = i24;
                        i25++;
                    }
                    i24++;
                }
                int[] iArrCopyOf = Arrays.copyOf(iArr9, i25);
                String str = null;
                int iMin = 16;
                List[] listArr2 = listArr;
                int i26 = 0;
                boolean z4 = false;
                int i27 = 0;
                while (i26 < iArrCopyOf.length) {
                    int[] iArr10 = iArrCopyOf;
                    String str2 = zzyhVarArr2[i21].a(i22).f24986d[iArrCopyOf[i26]].f35691m;
                    int i28 = i27 + 1;
                    if (i27 == 0) {
                        str = str2;
                    } else {
                        z4 |= !Objects.equals(str, str2);
                    }
                    iMin = Math.min(iMin, iArr[i21][i22][i26] & 24);
                    i26++;
                    iArrCopyOf = iArr10;
                    i27 = i28;
                }
                if (z4) {
                    iMin = Math.min(iMin, zzzzVar.f36002c[i21]);
                }
                boolean z5 = iMin != 0;
                int i29 = zzbgVarA2.f24983a;
                int[] iArr11 = new int[i29];
                boolean[] zArr = new boolean[i29];
                int i30 = 0;
                while (i30 < i29) {
                    iArr11[i30] = iArr[i21][i22][i30] & 7;
                    int i31 = i29;
                    int i32 = 0;
                    while (true) {
                        if (i32 >= list.size()) {
                            iArr2 = iArr;
                            z = false;
                            break;
                        }
                        zzaab zzaabVar2 = (zzaab) list.get(i32);
                        iArr2 = iArr;
                        if (zzaabVar2.zza().equals(zzbgVarA2) && zzaabVar2.zzg(i30) != -1) {
                            z = true;
                            break;
                        }
                        i32++;
                        iArr = iArr2;
                    }
                    zArr[i30] = z;
                    i30++;
                    iArr = iArr2;
                    i29 = i31;
                }
                zzgtaVar.c(new zzbm(zzbgVarA2, z5, iArr11, zArr));
                i22++;
                listArr = listArr2;
            }
        }
        int i33 = 0;
        while (true) {
            zzyh zzyhVar4 = zzzzVar.f36004e;
            if (i33 >= zzyhVar4.f35905a) {
                return new zzaae((zzml[]) pairG.first, (zzzw[]) pairG.second, new zzbn(zzgtaVar.f()), zzzzVar);
            }
            zzbg zzbgVarA3 = zzyhVar4.a(i33);
            int i34 = zzbgVarA3.f24983a;
            int[] iArr12 = new int[i34];
            Arrays.fill(iArr12, 0);
            zzgtaVar.c(new zzbm(zzbgVarA3, false, iArr12, new boolean[i34]));
            i33++;
        }
    }

    public abstract Pair g(zzzz zzzzVar, int[][][] iArr, int[] iArr2);

    @Override // com.google.android.gms.internal.ads.zzaad
    public final void e(zzzz zzzzVar) {
    }
}
