package com.google.android.gms.internal.ads;

import android.util.Log;
import coil3.network.internal.UtilsKt;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.time.TimeZones;

/* loaded from: classes4.dex */
public final class zzash {
    public static zzaqt a(zzarg zzargVar) throws NumberFormatException {
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        long jB;
        long j6;
        long j7;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = zzargVar.f24207c;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long jB2 = str != null ? b(str) : 0L;
        String str2 = (String) map.get(UtilsKt.CACHE_CONTROL);
        int i2 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z = false;
            j3 = 0;
            j4 = 0;
            while (i2 < strArrSplit.length) {
                String strTrim = strArrSplit[i2].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j4 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z = true;
                }
                i2++;
            }
            j2 = 0;
            i2 = 1;
        } else {
            j2 = 0;
            z = false;
            j3 = 0;
            j4 = 0;
        }
        String str3 = (String) map.get("Expires");
        long jB3 = str3 != null ? b(str3) : j2;
        String str4 = (String) map.get("Last-Modified");
        if (str4 != null) {
            j5 = jCurrentTimeMillis;
            jB = b(str4);
        } else {
            j5 = jCurrentTimeMillis;
            jB = j2;
        }
        String str5 = (String) map.get("ETag");
        if (i2 != 0) {
            long j8 = (j4 * 1000) + j5;
            j7 = z ? j8 : (j3 * 1000) + j8;
            j6 = j8;
        } else {
            j6 = (jB2 <= j2 || jB3 < jB2) ? j2 : (jB3 - jB2) + j5;
            j7 = j6;
        }
        zzaqt zzaqtVar = new zzaqt();
        zzaqtVar.f24173a = zzargVar.f24206b;
        zzaqtVar.f24174b = str5;
        zzaqtVar.f24178f = j6;
        zzaqtVar.f24177e = j7;
        zzaqtVar.f24175c = jB2;
        zzaqtVar.f24176d = jB;
        zzaqtVar.f24179g = map;
        zzaqtVar.f24180h = zzargVar.f24208d;
        return zzaqtVar;
    }

    public static long b(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(TimeZones.GMT_ID));
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzarw.a("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            Log.e("Volley", zzarw.d("Unable to parse dateStr: %s, falling back to 0", str), e2);
            return 0L;
        }
    }
}
