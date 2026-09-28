package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbrz;
import com.google.android.gms.internal.ads.zzbsc;
import com.google.android.gms.internal.ads.zzbsf;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzcdr;
import com.google.android.gms.internal.ads.zzcdt;
import com.google.android.gms.internal.ads.zzdxd;
import com.google.android.gms.internal.ads.zzdxe;
import com.google.android.gms.internal.ads.zzfne;
import com.google.android.gms.internal.ads.zzfnr;
import com.google.android.gms.internal.ads.zzgxu;
import com.google.android.gms.internal.ads.zzgym;
import com.google.android.gms.internal.ads.zzgyw;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzf {

    /* renamed from: a, reason: collision with root package name */
    public Context f21633a;

    /* renamed from: b, reason: collision with root package name */
    public long f21634b = 0;

    public static final void b(zzdxe zzdxeVar, String str, long j2) {
        if (zzdxeVar != null) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Nd)).booleanValue()) {
                zzdxd zzdxdVarA = zzdxeVar.a();
                zzdxdVarA.b("action", "lat_init");
                zzdxdVarA.b(str, Long.toString(j2));
                zzdxdVarA.c();
            }
        }
    }

    public final void a(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzccv zzccvVar, String str, String str2, Runnable runnable, final zzfnr zzfnrVar, final zzdxe zzdxeVar, final Long l2, boolean z2) throws JSONException {
        PackageInfo packageInfo;
        zzt zztVar = zzt.C;
        if (zztVar.f21687k.elapsedRealtime() - this.f21634b < 5000) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Not retrying to fetch app settings");
            return;
        }
        Clock clock = zztVar.f21687k;
        this.f21634b = clock.elapsedRealtime();
        if (zzccvVar != null && !TextUtils.isEmpty(zzccvVar.f25911e)) {
            if (clock.currentTimeMillis() - zzccvVar.f25912f <= ((Long) zzbd.f21150e.f21153c.a(zzbgk.P4)).longValue() && zzccvVar.f25914h) {
                return;
            }
        }
        if (context == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.f21633a = applicationContext;
        final zzfne zzfneVarF = zzfne.f(4, context);
        zzfneVarF.zza();
        zzbsf zzbsfVarB = zztVar.r.b(this.f21633a, versionInfoParcel, zzfnrVar);
        zzbrz zzbrzVar = zzbsc.f25504a;
        zzbsj zzbsjVarA = zzbsfVarB.a("google.afma.config.fetchAppSettings", zzbrzVar, zzbrzVar);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ad_unit_id", str2);
            }
            jSONObject.put("is_init", z);
            jSONObject.put("pn", context.getPackageName());
            zzbgb zzbgbVar = zzbgk.f25011a;
            zzbd zzbdVar = zzbd.f21150e;
            jSONObject.put("experiment_ids", TextUtils.join(",", zzbdVar.f21151a.a()));
            jSONObject.put("js", versionInfoParcel.f21400a);
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.Ga)).booleanValue()) {
                jSONObject.put("inspector_enabled", z2);
            }
            try {
                ApplicationInfo applicationInfo = this.f21633a.getApplicationInfo();
                if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                    jSONObject.put("version", packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                com.google.android.gms.ads.internal.util.zze.k("Error fetching PackageInfo.");
            }
            ListenableFuture listenableFutureA = zzbsjVarA.a(jSONObject);
            zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.ads.internal.zzd
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final ListenableFuture zza(Object obj) throws JSONException {
                    Long l3 = l2;
                    zzdxe zzdxeVar2 = zzdxeVar;
                    zzfne zzfneVar = zzfneVarF;
                    zzfnr zzfnrVar2 = zzfnrVar;
                    JSONObject jSONObject2 = (JSONObject) obj;
                    boolean zOptBoolean = jSONObject2.optBoolean("isSuccessful", false);
                    if (zOptBoolean) {
                        String string = jSONObject2.getString("appSettingsJson");
                        zzt zztVar2 = zzt.C;
                        com.google.android.gms.ads.internal.util.zzj zzjVarG = zztVar2.f21684h.g();
                        zzjVarG.d();
                        synchronized (zzjVarG.f21580a) {
                            try {
                                long jCurrentTimeMillis = zztVar2.f21687k.currentTimeMillis();
                                if (string == null || string.equals(zzjVarG.n.f25911e)) {
                                    zzjVarG.n.f25912f = jCurrentTimeMillis;
                                } else {
                                    zzjVarG.n = new zzccv(string, jCurrentTimeMillis);
                                    SharedPreferences.Editor editor = zzjVarG.f21586g;
                                    if (editor != null) {
                                        editor.putString("app_settings_json", string);
                                        zzjVarG.f21586g.putLong("app_settings_last_update_ms", jCurrentTimeMillis);
                                        zzjVarG.f21586g.apply();
                                    }
                                    zzjVarG.e();
                                    Iterator it = zzjVarG.f21582c.iterator();
                                    while (it.hasNext()) {
                                        ((Runnable) it.next()).run();
                                    }
                                }
                            } finally {
                            }
                        }
                        if (l3 != null) {
                            zzf.b(zzdxeVar2, "cld_s", zzt.C.f21687k.elapsedRealtime() - l3.longValue());
                        }
                    }
                    String strOptString = jSONObject2.optString("errorReason", "");
                    if (!TextUtils.isEmpty(strOptString)) {
                        zzfneVar.b(strOptString);
                    }
                    zzfneVar.a(zOptBoolean);
                    zzfnrVar2.b(zzfneVar.zzm());
                    return zzgym.a(null);
                }
            };
            zzgyw zzgywVar = zzcdo.f25988g;
            ListenableFuture listenableFutureH = zzgym.h(listenableFutureA, zzgxuVar, zzgywVar);
            if (runnable != null) {
                ((zzcdt) listenableFutureA).f25992a.q(runnable, zzgywVar);
            }
            if (l2 != null) {
                ((zzcdt) listenableFutureA).f25992a.q(new Runnable() { // from class: com.google.android.gms.ads.internal.zze
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzf.b(zzdxeVar, "cld_r", zzt.C.f21687k.elapsedRealtime() - l2.longValue());
                    }
                }, zzgywVar);
            }
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.x8)).booleanValue()) {
                zzcdr.b(listenableFutureH, "ConfigLoader.maybeFetchNewAppSettings");
            } else {
                zzcdr.a(listenableFutureH, "ConfigLoader.maybeFetchNewAppSettings");
            }
        } catch (Exception e2) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error requesting application settings", e2);
            zzfneVarF.c(e2);
            zzfneVarF.a(false);
            zzfnrVar.b(zzfneVarF.zzm());
        }
    }
}
