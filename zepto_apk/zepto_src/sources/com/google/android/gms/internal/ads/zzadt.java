package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzadt {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f22822a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22823b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22824c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22825d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22826e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22827f;

    /* renamed from: g, reason: collision with root package name */
    public final int f22828g;

    /* renamed from: h, reason: collision with root package name */
    public final int f22829h;

    /* renamed from: i, reason: collision with root package name */
    public final int f22830i;

    /* renamed from: j, reason: collision with root package name */
    public final int f22831j;

    /* renamed from: k, reason: collision with root package name */
    public final float f22832k;

    /* renamed from: l, reason: collision with root package name */
    public final String f22833l;

    public zzadt(ArrayList arrayList, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f2, String str) {
        this.f22822a = arrayList;
        this.f22823b = i2;
        this.f22824c = i3;
        this.f22825d = i4;
        this.f22826e = i5;
        this.f22827f = i6;
        this.f22828g = i7;
        this.f22829h = i8;
        this.f22830i = i9;
        this.f22831j = i10;
        this.f22832k = f2;
        this.f22833l = str;
    }

    public static zzadt a(zzer zzerVar) throws zzat {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f2;
        int i8;
        int i9;
        try {
            zzerVar.G(4);
            int iK = (zzerVar.K() & 3) + 1;
            if (iK == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iK2 = zzerVar.K() & 31;
            for (int i10 = 0; i10 < iK2; i10++) {
                int iL = zzerVar.L();
                int i11 = zzerVar.f30145b;
                zzerVar.G(iL);
                byte[] bArr = zzerVar.f30144a;
                byte[] bArr2 = zzdo.f28067a;
                byte[] bArr3 = new byte[iL + 4];
                System.arraycopy(zzdo.f28067a, 0, bArr3, 0, 4);
                System.arraycopy(bArr, i11, bArr3, 4, iL);
                arrayList.add(bArr3);
            }
            int iK3 = zzerVar.K();
            for (int i12 = 0; i12 < iK3; i12++) {
                int iL2 = zzerVar.L();
                int i13 = zzerVar.f30145b;
                zzerVar.G(iL2);
                byte[] bArr4 = zzerVar.f30144a;
                byte[] bArr5 = zzdo.f28067a;
                byte[] bArr6 = new byte[iL2 + 4];
                System.arraycopy(zzdo.f28067a, 0, bArr6, 0, 4);
                System.arraycopy(bArr4, i13, bArr6, 4, iL2);
                arrayList.add(bArr6);
            }
            if (iK2 > 0) {
                zzgl zzglVarD = zzgm.d(5, (byte[]) arrayList.get(0), ((byte[]) arrayList.get(0)).length);
                int i14 = zzglVarD.f32825e;
                int i15 = zzglVarD.f32826f;
                int i16 = zzglVarD.f32828h + 8;
                int i17 = zzglVarD.f32829i + 8;
                int i18 = zzglVarD.f32830j;
                int i19 = zzglVarD.f32831k;
                int i20 = zzglVarD.f32832l;
                int i21 = zzglVarD.f32833m;
                float f3 = zzglVarD.f32827g;
                int i22 = zzglVarD.f32821a;
                int i23 = zzglVarD.f32822b;
                int i24 = zzglVarD.f32823c;
                byte[] bArr7 = zzdo.f28067a;
                str = String.format("avc1.%02X%02X%02X", Integer.valueOf(i22), Integer.valueOf(i23), Integer.valueOf(i24));
                i5 = i19;
                i6 = i20;
                i7 = i21;
                f2 = f3;
                i3 = i15;
                i4 = i16;
                i8 = i17;
                i9 = i18;
                i2 = i14;
            } else {
                str = null;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = -1;
                i7 = 16;
                f2 = 1.0f;
                i8 = -1;
                i9 = -1;
            }
            return new zzadt(arrayList, iK, i2, i3, i4, i8, i9, i5, i6, i7, f2, str);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw zzat.a(e2, "Error parsing AVC config");
        }
    }
}
