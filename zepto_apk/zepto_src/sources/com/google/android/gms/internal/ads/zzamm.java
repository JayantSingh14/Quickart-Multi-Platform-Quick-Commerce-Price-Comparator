package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

/* loaded from: classes4.dex */
public final class zzamm implements zzaly {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23599a = new zzer();

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23600b = new zzer();

    /* renamed from: c, reason: collision with root package name */
    public final zzaml f23601c = new zzaml();

    /* renamed from: d, reason: collision with root package name */
    public Inflater f23602d;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzaly
    public final void a(byte[] bArr, int i2, int i3, zzdr zzdrVar) {
        zzer zzerVar;
        int i4;
        zzcx zzcxVarB;
        int i5;
        int i6;
        int i7;
        int i8;
        int iO;
        int i9 = 128;
        zzer zzerVar2 = this.f23599a;
        zzerVar2.z(i2 + i3, bArr);
        zzerVar2.E(i2);
        if (this.f23602d == null) {
            this.f23602d = new Inflater();
        }
        Inflater inflater = this.f23602d;
        zzer zzerVar3 = this.f23600b;
        if (zzfj.g(zzerVar2, zzerVar3, inflater)) {
            zzerVar2.z(zzerVar3.f30146c, zzerVar3.f30144a);
        }
        zzaml zzamlVar = this.f23601c;
        int i10 = 0;
        zzamlVar.f23593d = 0;
        zzamlVar.f23594e = 0;
        zzamlVar.f23595f = 0;
        zzamlVar.f23596g = 0;
        zzamlVar.f23597h = 0;
        zzamlVar.f23598i = 0;
        zzer zzerVar4 = zzamlVar.f23590a;
        zzerVar4.y(0);
        zzamlVar.f23592c = false;
        ArrayList arrayList = new ArrayList();
        while (zzerVar2.B() >= 3) {
            int i11 = zzerVar2.f30146c;
            int iK = zzerVar2.K();
            int iL = zzerVar2.L();
            int i12 = zzerVar2.f30145b + iL;
            if (i12 > i11) {
                zzerVar2.E(i11);
                i4 = i9;
                i5 = i10;
                zzerVar = zzerVar2;
                zzcxVarB = null;
            } else {
                int[] iArr = zzamlVar.f23591b;
                if (iK != i9) {
                    switch (iK) {
                        case 20:
                            if (iL % 5 != 2) {
                                zzerVar = zzerVar2;
                            } else {
                                zzerVar2.G(2);
                                Arrays.fill(iArr, i10);
                                int i13 = iL / 5;
                                int i14 = i10;
                                while (i14 < i13) {
                                    int iK2 = zzerVar2.K();
                                    int iK3 = zzerVar2.K();
                                    int iK4 = zzerVar2.K();
                                    double d2 = iK3;
                                    int iK5 = zzerVar2.K() - 128;
                                    int iK6 = zzerVar2.K() << 24;
                                    String str = zzfj.f31254a;
                                    double d3 = iK4 - 128;
                                    double d4 = iK5;
                                    iArr[iK2] = (Math.max(0, Math.min((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 255)) << 8) | iK6 | (Math.max(0, Math.min((int) ((1.402d * d3) + d2), 255)) << 16) | Math.max(0, Math.min((int) ((d4 * 1.772d) + d2), 255));
                                    i14++;
                                    zzerVar2 = zzerVar2;
                                }
                                zzerVar = zzerVar2;
                                zzamlVar.f23592c = true;
                            }
                            i5 = 0;
                            i4 = 128;
                            break;
                        case 21:
                            if (iL >= 4) {
                                zzerVar2.G(3);
                                int i15 = iL - 4;
                                if ((zzerVar2.K() & i9) == 0) {
                                    i7 = zzerVar4.f30145b;
                                    i8 = zzerVar4.f30146c;
                                    if (i7 < i8 && i15 > 0) {
                                        int iMin = Math.min(i15, i8 - i7);
                                        zzerVar2.H(i7, zzerVar4.f30144a, iMin);
                                        zzerVar4.E(i7 + iMin);
                                    }
                                } else if (i15 >= 7 && (iO = zzerVar2.O()) >= 4) {
                                    zzamlVar.f23597h = zzerVar2.L();
                                    zzamlVar.f23598i = zzerVar2.L();
                                    zzerVar4.y(iO - 4);
                                    i15 = iL - 11;
                                    i7 = zzerVar4.f30145b;
                                    i8 = zzerVar4.f30146c;
                                    if (i7 < i8) {
                                        int iMin2 = Math.min(i15, i8 - i7);
                                        zzerVar2.H(i7, zzerVar4.f30144a, iMin2);
                                        zzerVar4.E(i7 + iMin2);
                                    }
                                }
                            }
                            i4 = i9;
                            i5 = i10;
                            zzerVar = zzerVar2;
                            break;
                        case 22:
                            if (iL >= 19) {
                                zzamlVar.f23593d = zzerVar2.L();
                                zzamlVar.f23594e = zzerVar2.L();
                                zzerVar2.G(11);
                                zzamlVar.f23595f = zzerVar2.L();
                                zzamlVar.f23596g = zzerVar2.L();
                            }
                            i4 = i9;
                            i5 = i10;
                            zzerVar = zzerVar2;
                            break;
                        default:
                            i4 = i9;
                            i5 = i10;
                            zzerVar = zzerVar2;
                            break;
                    }
                    zzcxVarB = null;
                } else {
                    zzerVar = zzerVar2;
                    if (zzamlVar.f23593d == 0 || zzamlVar.f23594e == 0 || zzamlVar.f23597h == 0 || zzamlVar.f23598i == 0 || (i6 = zzerVar4.f30146c) == 0 || zzerVar4.f30145b != i6 || !zzamlVar.f23592c) {
                        i4 = 128;
                        zzcxVarB = null;
                    } else {
                        zzerVar4.E(0);
                        int i16 = zzamlVar.f23597h * zzamlVar.f23598i;
                        int[] iArr2 = new int[i16];
                        int i17 = 0;
                        while (i17 < i16) {
                            int iK7 = zzerVar4.K();
                            if (iK7 != 0) {
                                iArr2[i17] = iArr[iK7];
                                i17++;
                            } else {
                                int iK8 = zzerVar4.K();
                                if (iK8 != 0) {
                                    int iK9 = iK8 & 63;
                                    if ((iK8 & 64) != 0) {
                                        iK9 = (iK9 << 8) | zzerVar4.K();
                                    }
                                    int i18 = (iK8 & 128) == 0 ? iArr[0] : iArr[zzerVar4.K()];
                                    int i19 = i17 + iK9;
                                    Arrays.fill(iArr2, i17, i19, i18);
                                    i17 = i19;
                                }
                            }
                        }
                        i4 = 128;
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr2, zzamlVar.f23597h, zzamlVar.f23598i, Bitmap.Config.ARGB_8888);
                        zzcw zzcwVar = new zzcw();
                        zzcwVar.f27257b = bitmapCreateBitmap;
                        zzcwVar.f27256a = null;
                        float f2 = zzamlVar.f23595f;
                        float f3 = zzamlVar.f23593d;
                        zzcwVar.f27263h = f2 / f3;
                        zzcwVar.f27264i = 0;
                        float f4 = zzamlVar.f23596g;
                        float f5 = zzamlVar.f23594e;
                        zzcwVar.f27260e = f4 / f5;
                        zzcwVar.f27261f = 0;
                        zzcwVar.f27262g = 0;
                        zzcwVar.f27267l = zzamlVar.f23597h / f3;
                        zzcwVar.f27268m = zzamlVar.f23598i / f5;
                        zzcxVarB = zzcwVar.b();
                    }
                    i5 = 0;
                    zzamlVar.f23593d = 0;
                    zzamlVar.f23594e = 0;
                    zzamlVar.f23595f = 0;
                    zzamlVar.f23596g = 0;
                    zzamlVar.f23597h = 0;
                    zzamlVar.f23598i = 0;
                    zzerVar4.y(0);
                    zzamlVar.f23592c = false;
                }
                zzerVar.E(i12);
            }
            if (zzcxVarB != null) {
                arrayList.add(zzcxVarB);
            }
            i10 = i5;
            i9 = i4;
            zzerVar2 = zzerVar;
        }
        ((zzama) zzdrVar).zza(new zzalq(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
