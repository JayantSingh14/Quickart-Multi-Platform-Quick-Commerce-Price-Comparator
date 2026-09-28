package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzamk implements zzaly {

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f23580h = {0, 7, 8, 15};

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f23581i = {0, 119, -120, -1};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f23582j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f23583a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f23584b;

    /* renamed from: c, reason: collision with root package name */
    public final Canvas f23585c;

    /* renamed from: d, reason: collision with root package name */
    public final zzamd f23586d;

    /* renamed from: e, reason: collision with root package name */
    public final zzamc f23587e;

    /* renamed from: f, reason: collision with root package name */
    public final zzamj f23588f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f23589g;

    public zzamk(List list) {
        zzer zzerVar = new zzer((byte[]) list.get(0));
        int iL = zzerVar.L();
        int iL2 = zzerVar.L();
        Paint paint = new Paint();
        this.f23583a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f23584b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f23585c = new Canvas();
        this.f23586d = new zzamd(719, 575, 0, 719, 0, 575);
        this.f23587e = new zzamc(0, new int[]{0, -1, -16777216, -8421505}, d(), e());
        this.f23588f = new zzamj(iL, iL2);
    }

    public static zzamc b(zzeq zzeqVar, int i2) {
        int iH;
        int iH2;
        int iH3;
        int iH4;
        int i3 = 8;
        int iH5 = zzeqVar.h(8);
        zzeqVar.f(8);
        int i4 = 0;
        int[] iArr = {0, -1, -16777216, -8421505};
        int[] iArrD = d();
        int[] iArrE = e();
        int i5 = i2 - 2;
        while (i5 > 0) {
            int iH6 = zzeqVar.h(i3);
            int iH7 = zzeqVar.h(i3);
            int[] iArr2 = (iH7 & 128) != 0 ? iArr : (iH7 & 64) != 0 ? iArrD : iArrE;
            if ((iH7 & 1) != 0) {
                iH3 = zzeqVar.h(i3);
                iH4 = zzeqVar.h(i3);
                iH = zzeqVar.h(i3);
                iH2 = zzeqVar.h(i3);
                i5 -= 6;
            } else {
                int iH8 = zzeqVar.h(6) << 2;
                int iH9 = zzeqVar.h(4) << 4;
                i5 -= 4;
                iH = zzeqVar.h(4) << 4;
                iH2 = zzeqVar.h(2) << 6;
                iH3 = iH8;
                iH4 = iH9;
            }
            if (iH3 == 0) {
                iH2 = 255;
            }
            if (iH3 == 0) {
                iH = i4;
            }
            if (iH3 == 0) {
                iH4 = i4;
            }
            double d2 = iH3;
            String str = zzfj.f31254a;
            double d3 = iH4 - 128;
            double d4 = iH - 128;
            iArr2[iH6] = f((byte) (255 - (iH2 & 255)), Math.max(0, Math.min((int) ((1.402d * d3) + d2), 255)), Math.max(0, Math.min((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 255)), Math.max(0, Math.min((int) ((d4 * 1.772d) + d2), 255)));
            i4 = 0;
            iH5 = iH5;
            iArrE = iArrE;
            i3 = 8;
        }
        return new zzamc(iH5, iArr, iArrD, iArrE);
    }

    public static zzame c(zzeq zzeqVar) {
        byte[] bArr;
        int iH = zzeqVar.h(16);
        zzeqVar.f(4);
        int iH2 = zzeqVar.h(2);
        boolean zG = zzeqVar.g();
        zzeqVar.f(1);
        byte[] bArr2 = zzfj.f31255b;
        if (iH2 != 1) {
            if (iH2 == 0) {
                int iH3 = zzeqVar.h(16);
                int iH4 = zzeqVar.h(16);
                if (iH3 > 0) {
                    bArr2 = new byte[iH3];
                    zzgqa.f(zzeqVar.f30086c == 0);
                    System.arraycopy(zzeqVar.f30084a, zzeqVar.f30085b, bArr2, 0, iH3);
                    zzeqVar.f30085b += iH3;
                    zzeqVar.m();
                }
                if (iH4 > 0) {
                    bArr = new byte[iH4];
                    zzgqa.f(zzeqVar.f30086c == 0);
                    System.arraycopy(zzeqVar.f30084a, zzeqVar.f30085b, bArr, 0, iH4);
                    zzeqVar.f30085b += iH4;
                    zzeqVar.m();
                }
            }
            return new zzame(iH, zG, bArr2, bArr);
        }
        zzeqVar.f(zzeqVar.h(8) * 16);
        bArr = bArr2;
        return new zzame(iH, zG, bArr2, bArr);
    }

    public static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            int i3 = i2 & 4;
            int i4 = i2 & 2;
            int i5 = i2 & 1;
            if (i2 < 8) {
                iArr[i2] = f(255, 1 != i5 ? 0 : 255, i4 != 0 ? 255 : 0, i3 != 0 ? 255 : 0);
            } else {
                int i6 = WKSRecord.Service.LOCUS_CON;
                int i7 = 1 != i5 ? 0 : 127;
                int i8 = i4 != 0 ? 127 : 0;
                if (i3 == 0) {
                    i6 = 0;
                }
                iArr[i2] = f(255, i7, i8, i6);
            }
        }
        return iArr;
    }

    public static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = f(63, 1 != (i2 & 1) ? 0 : 255, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & WKSRecord.Service.PROFILE;
                if (i3 == 0) {
                    iArr[i2] = f(255, (1 != (i2 & 1) ? 0 : 85) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 8) {
                    iArr[i2] = f(WKSRecord.Service.LOCUS_CON, (1 != (i2 & 1) ? 0 : 85) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 128) {
                    iArr[i2] = f(255, (1 != (i2 & 1) ? 0 : 43) + WKSRecord.Service.LOCUS_CON + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + WKSRecord.Service.LOCUS_CON + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + WKSRecord.Service.LOCUS_CON + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = f(255, (1 != (i2 & 1) ? 0 : 43) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int f(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ff A[LOOP:3: B:86:0x0164->B:118:0x01ff, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(byte[] r22, int[] r23, int r24, int r25, int r26, android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamk.g(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static byte[] h(int i2, int i3, zzeq zzeqVar) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) zzeqVar.h(i3);
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final void a(byte[] bArr, int i2, int i3, zzdr zzdrVar) {
        zzamj zzamjVar;
        zzalq zzalqVar;
        char c2;
        char c3;
        char c4;
        int i4;
        zzamd zzamdVar;
        zzamj zzamjVar2;
        zzamh zzamhVar;
        int i5;
        int i6;
        int i7;
        int i8;
        ArrayList arrayList;
        int i9;
        zzamh zzamhVar2;
        int i10;
        int iH;
        int i11;
        int i12;
        boolean z = true;
        zzeq zzeqVar = new zzeq(bArr, i2 + i3);
        zzeqVar.d(i2);
        while (true) {
            int iB = zzeqVar.b();
            zzamjVar = this.f23588f;
            if (iB >= 48 && zzeqVar.h(8) == 15) {
                int iH2 = zzeqVar.h(8);
                int iH3 = zzeqVar.h(16);
                int iH4 = zzeqVar.h(16);
                int iC = zzeqVar.c() + iH4;
                if (iH4 * 8 > zzeqVar.b()) {
                    zzee.c("DvbParser", "Data field length exceeds limit");
                    zzeqVar.f(zzeqVar.b());
                } else {
                    switch (iH2) {
                        case 16:
                            if (iH3 == zzamjVar.f23571a) {
                                zzamf zzamfVar = zzamjVar.f23579i;
                                zzeqVar.h(8);
                                int iH5 = zzeqVar.h(4);
                                int iH6 = zzeqVar.h(2);
                                zzeqVar.f(2);
                                SparseArray sparseArray = new SparseArray();
                                for (int i13 = iH4 - 2; i13 > 0; i13 -= 6) {
                                    int iH7 = zzeqVar.h(8);
                                    zzeqVar.f(8);
                                    sparseArray.put(iH7, new zzamg(zzeqVar.h(16), zzeqVar.h(16)));
                                }
                                zzamf zzamfVar2 = new zzamf(iH5, iH6, sparseArray);
                                if (iH6 != 0) {
                                    zzamjVar.f23579i = zzamfVar2;
                                    zzamjVar.f23573c.clear();
                                    zzamjVar.f23574d.clear();
                                    zzamjVar.f23575e.clear();
                                    break;
                                } else if (zzamfVar != null && zzamfVar.f23554a != iH5) {
                                    zzamjVar.f23579i = zzamfVar2;
                                    break;
                                }
                            }
                            break;
                        case 17:
                            zzamf zzamfVar3 = zzamjVar.f23579i;
                            if (iH3 == zzamjVar.f23571a && zzamfVar3 != null) {
                                int iH8 = zzeqVar.h(8);
                                zzeqVar.f(4);
                                boolean zG = zzeqVar.g();
                                zzeqVar.f(3);
                                int iH9 = zzeqVar.h(16);
                                int iH10 = zzeqVar.h(16);
                                zzeqVar.h(3);
                                int iH11 = zzeqVar.h(3);
                                zzeqVar.f(2);
                                int iH12 = zzeqVar.h(8);
                                int iH13 = zzeqVar.h(8);
                                int iH14 = zzeqVar.h(4);
                                int iH15 = zzeqVar.h(2);
                                zzeqVar.f(2);
                                int i14 = iH4 - 10;
                                SparseArray sparseArray2 = new SparseArray();
                                while (i14 > 0) {
                                    int iH16 = zzeqVar.h(16);
                                    int iH17 = zzeqVar.h(2);
                                    zzeqVar.h(2);
                                    int iH18 = zzeqVar.h(12);
                                    zzeqVar.f(4);
                                    int iH19 = zzeqVar.h(12);
                                    int i15 = i14 - 6;
                                    if (iH17 == 1 || iH17 == 2) {
                                        zzeqVar.h(8);
                                        zzeqVar.h(8);
                                        i14 -= 8;
                                    } else {
                                        i14 = i15;
                                    }
                                    sparseArray2.put(iH16, new zzami(iH18, iH19));
                                }
                                zzamh zzamhVar3 = new zzamh(iH8, zG, iH9, iH10, iH11, iH12, iH13, iH14, iH15, sparseArray2);
                                SparseArray sparseArray3 = zzamjVar.f23573c;
                                if (zzamfVar3.f23555b == 0 && (zzamhVar2 = (zzamh) sparseArray3.get(iH8)) != null) {
                                    int i16 = 0;
                                    while (true) {
                                        SparseArray sparseArray4 = zzamhVar2.f23568j;
                                        if (i16 < sparseArray4.size()) {
                                            zzamhVar3.f23568j.put(sparseArray4.keyAt(i16), (zzami) sparseArray4.valueAt(i16));
                                            i16++;
                                        }
                                    }
                                }
                                sparseArray3.put(zzamhVar3.f23559a, zzamhVar3);
                                break;
                            }
                            break;
                        case 18:
                            if (iH3 == zzamjVar.f23571a) {
                                zzamc zzamcVarB = b(zzeqVar, iH4);
                                zzamjVar.f23574d.put(zzamcVarB.f23540a, zzamcVarB);
                                break;
                            } else if (iH3 == zzamjVar.f23572b) {
                                zzamc zzamcVarB2 = b(zzeqVar, iH4);
                                zzamjVar.f23576f.put(zzamcVarB2.f23540a, zzamcVarB2);
                                break;
                            }
                            break;
                        case 19:
                            if (iH3 == zzamjVar.f23571a) {
                                zzame zzameVarC = c(zzeqVar);
                                zzamjVar.f23575e.put(zzameVarC.f23550a, zzameVarC);
                                break;
                            } else if (iH3 == zzamjVar.f23572b) {
                                zzame zzameVarC2 = c(zzeqVar);
                                zzamjVar.f23577g.put(zzameVarC2.f23550a, zzameVarC2);
                                break;
                            }
                            break;
                        case 20:
                            if (iH3 == zzamjVar.f23571a) {
                                zzeqVar.f(4);
                                boolean zG2 = zzeqVar.g();
                                zzeqVar.f(3);
                                int iH20 = zzeqVar.h(16);
                                int iH21 = zzeqVar.h(16);
                                if (zG2) {
                                    int iH22 = zzeqVar.h(16);
                                    int iH23 = zzeqVar.h(16);
                                    int iH24 = zzeqVar.h(16);
                                    i10 = iH23;
                                    iH = zzeqVar.h(16);
                                    i12 = iH24;
                                    i11 = iH22;
                                } else {
                                    i10 = iH20;
                                    iH = iH21;
                                    i11 = 0;
                                    i12 = 0;
                                }
                                zzamjVar.f23578h = new zzamd(iH20, iH21, i11, i10, i12, iH);
                                break;
                            }
                            break;
                    }
                    zzeqVar.l(iC - zzeqVar.c());
                }
            }
        }
        zzamf zzamfVar4 = zzamjVar.f23579i;
        if (zzamfVar4 == null) {
            zzgvs zzgvsVar = zzgtd.f33183b;
            zzalqVar = new zzalq(zzguy.f33232e, -9223372036854775807L, -9223372036854775807L);
        } else {
            zzamd zzamdVar2 = zzamjVar.f23578h;
            if (zzamdVar2 == null) {
                zzamdVar2 = this.f23586d;
            }
            Bitmap bitmap = this.f23589g;
            Canvas canvas = this.f23585c;
            if (bitmap == null || zzamdVar2.f23544a + 1 != bitmap.getWidth() || zzamdVar2.f23545b + 1 != this.f23589g.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzamdVar2.f23544a + 1, zzamdVar2.f23545b + 1, Bitmap.Config.ARGB_8888);
                this.f23589g = bitmapCreateBitmap;
                canvas.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList2 = new ArrayList();
            int i17 = 0;
            while (true) {
                SparseArray sparseArray5 = zzamfVar4.f23556c;
                if (i17 < sparseArray5.size()) {
                    canvas.save();
                    zzamg zzamgVar = (zzamg) sparseArray5.valueAt(i17);
                    zzamh zzamhVar4 = (zzamh) zzamjVar.f23573c.get(sparseArray5.keyAt(i17));
                    int i18 = zzamgVar.f23557a + zzamdVar2.f23546c;
                    int i19 = zzamgVar.f23558b + zzamdVar2.f23548e;
                    int i20 = zzamhVar4.f23561c;
                    int i21 = i18 + i20;
                    int iMin = Math.min(i21, zzamdVar2.f23547d);
                    boolean z2 = z;
                    int i22 = zzamhVar4.f23562d;
                    int i23 = i19 + i22;
                    canvas.clipRect(i18, i19, iMin, Math.min(i23, zzamdVar2.f23549f));
                    SparseArray sparseArray6 = zzamjVar.f23574d;
                    int i24 = zzamhVar4.f23564f;
                    zzamc zzamcVar = (zzamc) sparseArray6.get(i24);
                    if (zzamcVar == null && (zzamcVar = (zzamc) zzamjVar.f23576f.get(i24)) == null) {
                        zzamcVar = this.f23587e;
                    }
                    zzamf zzamfVar5 = zzamfVar4;
                    int i25 = 0;
                    while (true) {
                        SparseArray sparseArray7 = zzamhVar4.f23568j;
                        int i26 = i17;
                        Canvas canvas2 = canvas;
                        if (i25 < sparseArray7.size()) {
                            int iKeyAt = sparseArray7.keyAt(i25);
                            zzami zzamiVar = (zzami) sparseArray7.valueAt(i25);
                            zzame zzameVar = (zzame) zzamjVar.f23575e.get(iKeyAt);
                            if (zzameVar == null) {
                                zzameVar = (zzame) zzamjVar.f23577g.get(iKeyAt);
                            }
                            zzame zzameVar2 = zzameVar;
                            if (zzameVar2 != null) {
                                Paint paint = zzameVar2.f23551b ? null : this.f23583a;
                                zzamjVar2 = zzamjVar;
                                int i27 = zzamiVar.f23569a + i18;
                                int i28 = zzamiVar.f23570b + i19;
                                int i29 = i18;
                                int i30 = zzamhVar4.f23563e;
                                int i31 = i19;
                                int[] iArr = i30 == 3 ? zzamcVar.f23543d : i30 == 2 ? zzamcVar.f23542c : zzamcVar.f23541b;
                                zzamhVar = zzamhVar4;
                                i6 = i20;
                                i5 = i29;
                                i8 = i25;
                                Paint paint2 = paint;
                                canvas = canvas2;
                                arrayList = arrayList2;
                                i9 = i31;
                                zzamdVar = zzamdVar2;
                                i7 = i21;
                                g(zzameVar2.f23552c, iArr, i30, i27, i28, paint2, canvas);
                                g(zzameVar2.f23553d, iArr, i30, i27, i28 + 1, paint2, canvas);
                            } else {
                                zzamdVar = zzamdVar2;
                                zzamjVar2 = zzamjVar;
                                zzamhVar = zzamhVar4;
                                i5 = i18;
                                i6 = i20;
                                i7 = i21;
                                i8 = i25;
                                canvas = canvas2;
                                arrayList = arrayList2;
                                i9 = i19;
                            }
                            i25 = i8 + 1;
                            zzamhVar4 = zzamhVar;
                            i21 = i7;
                            i19 = i9;
                            i18 = i5;
                            i17 = i26;
                            arrayList2 = arrayList;
                            zzamjVar = zzamjVar2;
                            zzamdVar2 = zzamdVar;
                            i20 = i6;
                        } else {
                            zzamd zzamdVar3 = zzamdVar2;
                            zzamj zzamjVar3 = zzamjVar;
                            zzamh zzamhVar5 = zzamhVar4;
                            int i32 = i18;
                            int i33 = i20;
                            int i34 = i21;
                            canvas = canvas2;
                            ArrayList arrayList3 = arrayList2;
                            int i35 = i19;
                            float f2 = i35;
                            float f3 = i32;
                            if (zzamhVar5.f23560b) {
                                int i36 = zzamhVar5.f23563e;
                                if (i36 == 3) {
                                    i4 = zzamcVar.f23543d[zzamhVar5.f23565g];
                                    c4 = 2;
                                } else {
                                    c4 = 2;
                                    i4 = i36 == 2 ? zzamcVar.f23542c[zzamhVar5.f23566h] : zzamcVar.f23541b[zzamhVar5.f23567i];
                                }
                                Paint paint3 = this.f23584b;
                                paint3.setColor(i4);
                                float f4 = i34;
                                c3 = c4;
                                c2 = 3;
                                canvas.drawRect(f3, f2, f4, i23, paint3);
                            } else {
                                c2 = 3;
                                c3 = 2;
                            }
                            zzcw zzcwVar = new zzcw();
                            zzcwVar.f27257b = Bitmap.createBitmap(this.f23589g, i32, i35, i33, i22);
                            zzcwVar.f27256a = null;
                            float f5 = zzamdVar3.f23544a;
                            zzcwVar.f27263h = f3 / f5;
                            zzcwVar.f27264i = 0;
                            float f6 = zzamdVar3.f23545b;
                            zzcwVar.f27260e = f2 / f6;
                            zzcwVar.f27261f = 0;
                            zzcwVar.f27262g = 0;
                            zzcwVar.f27267l = i33 / f5;
                            zzcwVar.f27268m = i22 / f6;
                            arrayList3.add(zzcwVar.b());
                            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                            canvas.restore();
                            i17 = i26 + 1;
                            zzamdVar2 = zzamdVar3;
                            arrayList2 = arrayList3;
                            z = z2;
                            zzamfVar4 = zzamfVar5;
                            zzamjVar = zzamjVar3;
                        }
                    }
                } else {
                    zzalqVar = new zzalq(arrayList2, -9223372036854775807L, -9223372036854775807L);
                }
            }
        }
        ((zzama) zzdrVar).zza(zzalqVar);
    }
}
