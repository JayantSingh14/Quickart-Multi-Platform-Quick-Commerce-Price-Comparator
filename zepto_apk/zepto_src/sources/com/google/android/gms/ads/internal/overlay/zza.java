package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzdxe;

/* loaded from: classes4.dex */
public final class zza {
    public static final boolean a(Context context, Intent intent, zzad zzadVar, zzaa zzaaVar, boolean z, zzdxe zzdxeVar, String str, Bundle bundle) {
        int iM;
        if (z) {
            try {
                iM = com.google.android.gms.ads.internal.zzt.C.f21679c.M(context, intent.getData(), bundle);
                if (zzadVar != null) {
                    zzadVar.zzl();
                }
            } catch (ActivityNotFoundException e2) {
                String message = e2.getMessage();
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f(message);
                iM = 6;
            }
            if (zzaaVar != null) {
                zzaaVar.zzb(iM);
            }
            return iM == 5;
        }
        try {
            String uri = intent.toURI();
            StringBuilder sb = new StringBuilder(String.valueOf(uri).length() + 21);
            sb.append("Launching an intent: ");
            sb.append(uri);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.le)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                com.google.android.gms.ads.internal.util.zzs.v(context, intent, zzdxeVar, str);
            } else {
                com.google.android.gms.ads.internal.util.zzs zzsVar2 = com.google.android.gms.ads.internal.zzt.C.f21679c;
                com.google.android.gms.ads.internal.util.zzs.t(context, intent);
            }
            if (zzadVar != null) {
                zzadVar.zzl();
            }
            if (zzaaVar != null) {
                zzaaVar.j1(true);
            }
            return true;
        } catch (ActivityNotFoundException e3) {
            String message2 = e3.getMessage();
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f(message2);
            if (zzaaVar != null) {
                zzaaVar.j1(false);
            }
            return false;
        }
    }

    public static final boolean b(Context context, zzc zzcVar, zzad zzadVar, zzaa zzaaVar, zzdxe zzdxeVar, String str) throws NumberFormatException {
        int i2 = 0;
        if (zzcVar == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("No intent data for launcher overlay.");
            return false;
        }
        zzbgk.a(context);
        Intent intent = zzcVar.f21343h;
        if (intent != null) {
            return a(context, intent, zzadVar, zzaaVar, zzcVar.f21345j, zzdxeVar, str, zzcVar.f21346k);
        }
        Intent intent2 = new Intent();
        String str2 = zzcVar.f21337b;
        if (TextUtils.isEmpty(str2)) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Open GMSG did not contain a URL.");
            return false;
        }
        String str3 = zzcVar.f21338c;
        if (TextUtils.isEmpty(str3)) {
            intent2.setData(Uri.parse(str2));
        } else {
            intent2.setDataAndType(Uri.parse(str2), str3);
        }
        intent2.setAction("android.intent.action.VIEW");
        String str4 = zzcVar.f21339d;
        if (!TextUtils.isEmpty(str4)) {
            intent2.setPackage(str4);
        }
        String str5 = zzcVar.f21340e;
        if (!TextUtils.isEmpty(str5)) {
            String[] strArrSplit = str5.split("/", 2);
            if (strArrSplit.length < 2) {
                int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Could not parse component name from open GMSG: ".concat(str5));
                return false;
            }
            intent2.setClassName(strArrSplit[0], strArrSplit[1]);
        }
        String str6 = zzcVar.f21341f;
        if (!TextUtils.isEmpty(str6)) {
            try {
                i2 = Integer.parseInt(str6);
            } catch (NumberFormatException unused) {
                int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Could not parse intent flags.");
            }
            intent2.addFlags(i2);
        }
        zzbgb zzbgbVar = zzbgk.l5;
        zzbd zzbdVar = zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.k5)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                com.google.android.gms.ads.internal.util.zzs.P(context, intent2);
            }
        }
        return a(context, intent2, zzadVar, zzaaVar, zzcVar.f21345j, zzdxeVar, str, zzcVar.f21346k);
    }
}
