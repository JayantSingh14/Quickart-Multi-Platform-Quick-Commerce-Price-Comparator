package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.Inflater;

/* loaded from: classes4.dex */
public final class zzanf implements zzaly {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23738a = new zzer();

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23739b = new zzer();

    /* renamed from: c, reason: collision with root package name */
    public final zzane f23740c;

    /* renamed from: d, reason: collision with root package name */
    public Inflater f23741d;

    public zzanf(List list) throws NumberFormatException {
        int i2;
        zzane zzaneVar = new zzane();
        this.f23740c = zzaneVar;
        String strTrim = new String((byte[]) list.get(0), StandardCharsets.UTF_8).trim();
        String str = zzfj.f31254a;
        for (String str2 : strTrim.split("\\r?\\n", -1)) {
            if (str2.startsWith("palette: ")) {
                String[] strArrSplit = str2.substring(9).split(",", -1);
                zzaneVar.f23732d = new int[strArrSplit.length];
                for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                    int[] iArr = zzaneVar.f23732d;
                    try {
                        i2 = Integer.parseInt(strArrSplit[i3].trim(), 16);
                    } catch (RuntimeException unused) {
                        i2 = 0;
                    }
                    iArr[i3] = i2;
                }
            } else if (str2.startsWith("size: ")) {
                String[] strArrSplit2 = str2.substring(6).trim().split("x", -1);
                if (strArrSplit2.length == 2) {
                    try {
                        zzaneVar.f23733e = Integer.parseInt(strArrSplit2[0]);
                        zzaneVar.f23734f = Integer.parseInt(strArrSplit2[1]);
                        zzaneVar.f23730b = true;
                    } catch (RuntimeException e2) {
                        zzee.d("VobsubParser", "Parsing IDX failed", e2);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final void a(byte[] bArr, int i2, int i3, zzdr zzdrVar) {
        zzgtd zzgtdVarN;
        Rect rect;
        int i4;
        int i5 = 4;
        zzer zzerVar = this.f23738a;
        zzerVar.z(i2 + i3, bArr);
        zzerVar.E(i2);
        if (this.f23741d == null) {
            this.f23741d = new Inflater();
        }
        Inflater inflater = this.f23741d;
        zzer zzerVar2 = this.f23739b;
        if (zzfj.g(zzerVar, zzerVar2, inflater)) {
            zzerVar.z(zzerVar2.f30146c, zzerVar2.f30144a);
        }
        zzane zzaneVar = this.f23740c;
        zzaneVar.f23731c = false;
        zzcx zzcxVarB = null;
        zzaneVar.f23735g = null;
        zzaneVar.f23736h = -1;
        zzaneVar.f23737i = -1;
        int iB = zzerVar.B();
        if (iB >= 2 && zzerVar.L() == iB) {
            int[] iArr = zzaneVar.f23732d;
            if (iArr != null && zzaneVar.f23730b) {
                zzerVar.G(zzerVar.L() - 2);
                int iL = zzerVar.L();
                while (zzerVar.f30145b < iL && zzerVar.B() > 0) {
                    int iK = zzerVar.K();
                    int[] iArr2 = zzaneVar.f23729a;
                    switch (iK) {
                        case 3:
                            i4 = i5;
                            if (zzerVar.B() < 2) {
                                break;
                            } else {
                                int iK2 = zzerVar.K();
                                int iK3 = zzerVar.K();
                                int i6 = iK2 >> 4;
                                if (i6 >= iArr.length) {
                                    i6 = 0;
                                }
                                iArr2[3] = iArr[i6];
                                int i7 = iK2 & 15;
                                if (i7 >= iArr.length) {
                                    i7 = 0;
                                }
                                iArr2[2] = iArr[i7];
                                int i8 = iK3 >> 4;
                                if (i8 >= iArr.length) {
                                    i8 = 0;
                                }
                                iArr2[1] = iArr[i8];
                                int i9 = iK3 & 15;
                                if (i9 >= iArr.length) {
                                    i9 = 0;
                                }
                                iArr2[0] = iArr[i9];
                                zzaneVar.f23731c = true;
                                i5 = i4;
                            }
                        case 4:
                            i4 = i5;
                            if (zzerVar.B() < 2 || !zzaneVar.f23731c) {
                                break;
                            } else {
                                int iK4 = zzerVar.K();
                                int iK5 = zzerVar.K();
                                iArr2[3] = zzane.a(iArr2[3], iK4 >> 4);
                                iArr2[2] = zzane.a(iArr2[2], iK4 & 15);
                                iArr2[1] = zzane.a(iArr2[1], iK5 >> 4);
                                iArr2[0] = zzane.a(iArr2[0], iK5 & 15);
                                i5 = i4;
                            }
                            break;
                        case 5:
                            if (zzerVar.B() < 6) {
                                break;
                            } else {
                                int iK6 = zzerVar.K();
                                int iK7 = zzerVar.K();
                                int i10 = iK7 >> 4;
                                int iK8 = ((iK7 & 15) << 8) | zzerVar.K();
                                int iK9 = zzerVar.K();
                                int iK10 = zzerVar.K();
                                i4 = i5;
                                zzaneVar.f23735g = new Rect((iK6 << i5) | i10, (iK9 << i5) | (iK10 >> 4), iK8 + 1, (((iK10 & 15) << 8) | zzerVar.K()) + 1);
                                i5 = i4;
                            }
                        case 6:
                            if (zzerVar.B() < i5) {
                                break;
                            } else {
                                zzaneVar.f23736h = zzerVar.L();
                                zzaneVar.f23737i = zzerVar.L();
                            }
                    }
                }
            }
            if (zzaneVar.f23732d != null && zzaneVar.f23730b && zzaneVar.f23731c && (rect = zzaneVar.f23735g) != null && zzaneVar.f23736h != -1 && zzaneVar.f23737i != -1 && rect.width() >= 2 && zzaneVar.f23735g.height() >= 2) {
                Rect rect2 = zzaneVar.f23735g;
                int[] iArr3 = new int[rect2.height() * rect2.width()];
                zzeq zzeqVar = new zzeq();
                zzerVar.E(zzaneVar.f23736h);
                zzeqVar.a(zzerVar);
                zzaneVar.b(zzeqVar, true, rect2, iArr3);
                zzerVar.E(zzaneVar.f23737i);
                zzeqVar.a(zzerVar);
                zzaneVar.b(zzeqVar, false, rect2, iArr3);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr3, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
                zzcw zzcwVar = new zzcw();
                zzcwVar.f27257b = bitmapCreateBitmap;
                zzcwVar.f27256a = null;
                zzcwVar.f27263h = rect2.left / zzaneVar.f23733e;
                zzcwVar.f27264i = 0;
                zzcwVar.f27260e = rect2.top / zzaneVar.f23734f;
                zzcwVar.f27261f = 0;
                zzcwVar.f27262g = 0;
                zzcwVar.f27267l = rect2.width() / zzaneVar.f23733e;
                zzcwVar.f27268m = rect2.height() / zzaneVar.f23734f;
                zzcxVarB = zzcwVar.b();
            }
        }
        if (zzcxVarB != null) {
            zzgtdVarN = zzgtd.n(zzcxVarB);
        } else {
            zzgvs zzgvsVar = zzgtd.f33183b;
            zzgtdVarN = zzguy.f33232e;
        }
        ((zzama) zzdrVar).zza(new zzalq(zzgtdVarN, -9223372036854775807L, 5000000L));
    }
}
