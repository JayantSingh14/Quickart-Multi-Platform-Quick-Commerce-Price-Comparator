package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzcby {
    public static String a(String str, Context context, boolean z, HashMap map) {
        zzcbw zzcbwVar;
        String strD;
        zzbgb zzbgbVar = zzbgk.M0;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && !z) {
            return str;
        }
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        if (!zztVar.y.a(context) || TextUtils.isEmpty(str) || (strD = (zzcbwVar = zztVar.y).d(context)) == null) {
            return str;
        }
        zzbgb zzbgbVar2 = zzbgk.F0;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        String str2 = (String) zzbgiVar.a(zzbgbVar2);
        boolean zBooleanValue = ((Boolean) zzbgiVar.a(zzbgk.E0)).booleanValue();
        com.google.android.gms.ads.internal.util.zzs zzsVar = zztVar.f21679c;
        if (zBooleanValue && str.contains(str2)) {
            if (zzsVar.H(str)) {
                Map map2 = (Map) map.get("_ac");
                zzcbwVar.getClass();
                zzcbwVar.h(context, "_ac", strD, zzcbw.f(map2));
                return c(context, str).replace(str2, strD);
            }
            if (!zzsVar.I(str)) {
                return str;
            }
            Map map3 = (Map) map.get("_ai");
            zzcbwVar.getClass();
            zzcbwVar.h(context, "_ai", strD, zzcbw.f(map3));
            return c(context, str).replace(str2, strD);
        }
        if (str.contains("fbs_aeid") || ((Boolean) zzbgiVar.a(zzbgk.D0)).booleanValue()) {
            return str;
        }
        if (zzsVar.H(str)) {
            Map map4 = (Map) map.get("_ac");
            zzcbwVar.getClass();
            zzcbwVar.h(context, "_ac", strD, zzcbw.f(map4));
            return b(c(context, str), "fbs_aeid", strD).toString();
        }
        if (!zzsVar.I(str)) {
            return str;
        }
        Map map5 = (Map) map.get("_ai");
        zzcbwVar.getClass();
        zzcbwVar.h(context, "_ai", strD, zzcbw.f(map5));
        return b(c(context, str), "fbs_aeid", strD).toString();
    }

    public static Uri b(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("?adurl");
        }
        if (iIndexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i2 = iIndexOf + 1;
        StringBuilder sb = new StringBuilder(str.substring(0, i2));
        android.support.v4.media.b.B(sb, str2, "=", str3, "&");
        sb.append(str.substring(i2));
        return Uri.parse(sb.toString());
    }

    public static String c(Context context, String str) {
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        String strB = zztVar.y.b(context);
        String strC = zztVar.y.c(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(strB)) {
            str = b(str, "gmp_app_id", strB).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(strC)) ? str : b(str, "fbs_aiid", strC).toString();
    }
}
