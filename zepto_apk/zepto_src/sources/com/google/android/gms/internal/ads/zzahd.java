package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class zzahd extends zzahf {

    /* renamed from: b, reason: collision with root package name */
    public long f23096b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f23097c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f23098d;

    public zzahd() {
        super(new zzael());
        this.f23096b = -9223372036854775807L;
        this.f23097c = new long[0];
        this.f23098d = new long[0];
    }

    public static String a(zzer zzerVar) {
        int iL = zzerVar.L();
        int i2 = zzerVar.f30145b;
        zzerVar.G(iL);
        return new String(zzerVar.f30144a, i2, iL);
    }

    public static HashMap b(zzer zzerVar) {
        int iH = zzerVar.h();
        HashMap map = new HashMap(iH);
        for (int i2 = 0; i2 < iH; i2++) {
            String strA = a(zzerVar);
            Serializable serializableC = c(zzerVar.K(), zzerVar);
            if (serializableC != null) {
                map.put(strA, serializableC);
            }
        }
        return map;
    }

    public static Serializable c(int i2, zzer zzerVar) {
        if (i2 == 0) {
            return Double.valueOf(Double.longBitsToDouble(zzerVar.d()));
        }
        if (i2 == 1) {
            return Boolean.valueOf(zzerVar.K() == 1);
        }
        if (i2 == 2) {
            return a(zzerVar);
        }
        if (i2 != 3) {
            if (i2 == 8) {
                return b(zzerVar);
            }
            if (i2 != 10) {
                if (i2 != 11) {
                    return null;
                }
                Date date = new Date((long) Double.longBitsToDouble(zzerVar.d()));
                zzerVar.G(2);
                return date;
            }
            int iH = zzerVar.h();
            ArrayList arrayList = new ArrayList(iH);
            for (int i3 = 0; i3 < iH; i3++) {
                Serializable serializableC = c(zzerVar.K(), zzerVar);
                if (serializableC != null) {
                    arrayList.add(serializableC);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strA = a(zzerVar);
            int iK = zzerVar.K();
            if (iK == 9) {
                return map;
            }
            Serializable serializableC2 = c(iK, zzerVar);
            if (serializableC2 != null) {
                map.put(strA, serializableC2);
            }
        }
    }
}
