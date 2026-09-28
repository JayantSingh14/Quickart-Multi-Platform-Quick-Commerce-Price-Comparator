package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzagg {
    public static int a(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    public static zzagd b(zzer zzerVar, boolean z, boolean z2) throws zzat {
        if (z) {
            d(3, zzerVar, false);
        }
        zzerVar.k((int) zzerVar.a(), StandardCharsets.UTF_8);
        long jA = zzerVar.a();
        String[] strArr = new String[(int) jA];
        for (int i2 = 0; i2 < jA; i2++) {
            strArr[i2] = zzerVar.k((int) zzerVar.a(), StandardCharsets.UTF_8);
        }
        if (z2 && (zzerVar.K() & 1) == 0) {
            throw zzat.a(null, "framing bit expected to be set");
        }
        return new zzagd(strArr);
    }

    public static zzap c(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = (String) list.get(i2);
            String str2 = zzfj.f31254a;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                zzee.c("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzaht.b(new zzer(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e2) {
                    zzee.d("VorbisUtil", "Failed to parse vorbis picture", e2);
                }
            } else {
                arrayList.add(new zzair(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzap(arrayList);
    }

    public static boolean d(int i2, zzer zzerVar, boolean z) throws zzat {
        if (zzerVar.B() < 7) {
            if (z) {
                return false;
            }
            int iB = zzerVar.B();
            StringBuilder sb = new StringBuilder(String.valueOf(iB).length() + 18);
            sb.append("too short header: ");
            sb.append(iB);
            throw zzat.a(null, sb.toString());
        }
        if (zzerVar.K() != i2) {
            if (z) {
                return false;
            }
            throw zzat.a(null, "expected header type ".concat(String.valueOf(Integer.toHexString(i2))));
        }
        if (zzerVar.K() == 118 && zzerVar.K() == 111 && zzerVar.K() == 114 && zzerVar.K() == 98 && zzerVar.K() == 105 && zzerVar.K() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw zzat.a(null, "expected characters 'vorbis'");
    }
}
