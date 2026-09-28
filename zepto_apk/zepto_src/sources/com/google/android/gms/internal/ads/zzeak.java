package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzeak implements zzebm, zzdzv {

    /* renamed from: a, reason: collision with root package name */
    public final zzeav f28934a;

    /* renamed from: b, reason: collision with root package name */
    public final zzebn f28935b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdzw f28936c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeaf f28937d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdzu f28938e;

    /* renamed from: f, reason: collision with root package name */
    public final zzebh f28939f;

    /* renamed from: g, reason: collision with root package name */
    public final zzear f28940g;

    /* renamed from: h, reason: collision with root package name */
    public final zzear f28941h;

    /* renamed from: i, reason: collision with root package name */
    public final String f28942i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f28943j;

    /* renamed from: k, reason: collision with root package name */
    public final String f28944k;
    public JSONObject p;
    public boolean s;
    public int t;
    public boolean u;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f28945l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f28946m = new HashMap();
    public final HashMap n = new HashMap();
    public String o = "{}";
    public long q = Long.MAX_VALUE;
    public zzeag r = zzeag.f28925a;
    public zzeaj v = zzeaj.f28929a;
    public long w = 0;
    public String x = "";

    public zzeak(zzeav zzeavVar, zzebn zzebnVar, zzdzw zzdzwVar, Context context, VersionInfoParcel versionInfoParcel, zzeaf zzeafVar, zzebh zzebhVar, zzear zzearVar, zzear zzearVar2, String str) {
        this.f28934a = zzeavVar;
        this.f28935b = zzebnVar;
        this.f28936c = zzdzwVar;
        this.f28938e = new zzdzu(context);
        this.f28942i = versionInfoParcel.f21400a;
        this.f28944k = str;
        this.f28937d = zzeafVar;
        this.f28939f = zzebhVar;
        this.f28940g = zzearVar;
        this.f28941h = zzearVar2;
        this.f28943j = context;
        com.google.android.gms.ads.internal.zzt.C.o.f21511g = this;
    }

    public final void a() throws JSONException {
        String str;
        boolean z;
        zzbgb zzbgbVar = zzbgk.aa;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.pa)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzj zzjVarG = com.google.android.gms.ads.internal.zzt.C.f21684h.g();
                zzjVarG.d();
                synchronized (zzjVarG.f21580a) {
                    z = zzjVarG.y;
                }
                if (z) {
                    j();
                    return;
                }
            }
            com.google.android.gms.ads.internal.util.zzj zzjVarG2 = com.google.android.gms.ads.internal.zzt.C.f21684h.g();
            zzjVarG2.d();
            synchronized (zzjVarG2.f21580a) {
                str = zzjVarG2.x;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                if (new JSONObject(str).optBoolean("isTestMode", false)) {
                    j();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final void b(boolean z) throws JSONException {
        if (!this.u && z) {
            j();
        }
        g(z, true);
    }

    public final synchronized void c(String str, zzdzy zzdzyVar) {
        zzbgb zzbgbVar = zzbgk.aa;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && f()) {
            if (this.t >= ((Integer) zzbdVar.f21153c.a(zzbgk.ca)).intValue()) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            HashMap map = this.f28945l;
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList());
            }
            this.t++;
            ((List) map.get(str)).add(zzdzyVar);
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.ya)).booleanValue()) {
                String str2 = zzdzyVar.f28891c;
                this.f28946m.put(str2, zzdzyVar);
                HashMap map2 = this.n;
                if (map2.containsKey(str2)) {
                    List list = (List) map2.get(str2);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((zzcdt) it.next()).b(zzdzyVar);
                    }
                    list.clear();
                }
            }
        }
    }

    public final synchronized zzcdt d(String str) {
        zzcdt zzcdtVar;
        try {
            zzcdtVar = new zzcdt();
            HashMap map = this.f28946m;
            if (map.containsKey(str)) {
                zzcdtVar.b((zzdzy) map.get(str));
            } else {
                HashMap map2 = this.n;
                if (!map2.containsKey(str)) {
                    map2.put(str, new ArrayList());
                }
                ((List) map2.get(str)).add(zzcdtVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzcdtVar;
    }

    public final synchronized void e(com.google.android.gms.ads.internal.client.zzdn zzdnVar, zzeaj zzeajVar) {
        if (!f()) {
            try {
                zzdnVar.x0(zzfjm.d(18, null, null));
                return;
            } catch (RemoteException unused) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.aa)).booleanValue()) {
            this.v = zzeajVar;
            this.f28934a.b(zzdnVar, new zzboi(this), new zzbob(this.f28939f), new zzbno(this));
            return;
        } else {
            try {
                zzdnVar.x0(zzfjm.d(1, null, null));
                return;
            } catch (RemoteException unused2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector had an internal error.");
                return;
            }
        }
    }

    public final synchronized boolean f() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.pa)).booleanValue()) {
            return this.s || com.google.android.gms.ads.internal.zzt.C.o.g();
        }
        return this.s;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x000a, B:10:0x001c, B:15:0x0029, B:20:0x0038, B:16:0x002d, B:18:0x0033), top: B:27:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void g(boolean r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.s     // Catch: java.lang.Throwable -> L27
            if (r0 != r2) goto L6
            goto L3d
        L6:
            r1.s = r2     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L2d
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.pa     // Catch: java.lang.Throwable -> L27
            com.google.android.gms.ads.internal.client.zzbd r0 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L27
            com.google.android.gms.internal.ads.zzbgi r0 = r0.f21153c     // Catch: java.lang.Throwable -> L27
            java.lang.Object r2 = r0.a(r2)     // Catch: java.lang.Throwable -> L27
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L27
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L29
            com.google.android.gms.ads.internal.zzt r2 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L27
            com.google.android.gms.ads.internal.util.zzax r2 = r2.o     // Catch: java.lang.Throwable -> L27
            boolean r2 = r2.g()     // Catch: java.lang.Throwable -> L27
            if (r2 != 0) goto L2d
            goto L29
        L27:
            r2 = move-exception
            goto L3f
        L29:
            r1.k()     // Catch: java.lang.Throwable -> L27
            goto L36
        L2d:
            boolean r2 = r1.f()     // Catch: java.lang.Throwable -> L27
            if (r2 != 0) goto L36
            r1.l()     // Catch: java.lang.Throwable -> L27
        L36:
            if (r3 == 0) goto L3d
            r1.m()     // Catch: java.lang.Throwable -> L27
            monitor-exit(r1)
            return
        L3d:
            monitor-exit(r1)
            return
        L3f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L27
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeak.g(boolean, boolean):void");
    }

    public final synchronized void h(zzeag zzeagVar, boolean z) {
        try {
            if (this.r != zzeagVar) {
                if (f()) {
                    l();
                }
                this.r = zzeagVar;
                if (f()) {
                    k();
                }
                if (z) {
                    m();
                }
            }
        } finally {
        }
    }

    public final synchronized JSONObject i() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            for (Map.Entry entry : this.f28945l.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                for (zzdzy zzdzyVar : (List) entry.getValue()) {
                    if (zzdzyVar.f28893e != zzdzx.f28885a) {
                        jSONArray.put(zzdzyVar.a());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put((String) entry.getKey(), jSONArray);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public final void j() throws JSONException {
        String str;
        String str2;
        this.u = true;
        zzeaf zzeafVar = this.f28937d;
        zzeafVar.getClass();
        zzead zzeadVar = new zzead(zzeafVar);
        zzdzp zzdzpVar = zzeafVar.f28920a;
        zzdzpVar.getClass();
        zzdzpVar.f28850e.f25992a.q(new zzdzo(zzdzpVar, zzeadVar), zzdzpVar.f28855j);
        this.f28934a.f28970c = this;
        this.f28935b.f29017f = this;
        this.f28936c.f28883i = this;
        this.f28939f.f29003f = this;
        zzbgb zzbgbVar = zzbgk.Ea;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!TextUtils.isEmpty((CharSequence) zzbdVar.f21153c.a(zzbgbVar))) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f28943j);
            List listAsList = Arrays.asList(((String) zzbdVar.f21153c.a(zzbgbVar)).split(","));
            zzear zzearVar = this.f28940g;
            zzearVar.f28965b = listAsList;
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzearVar);
            Iterator it = listAsList.iterator();
            while (it.hasNext()) {
                zzearVar.onSharedPreferenceChanged(defaultSharedPreferences, (String) it.next());
            }
        }
        zzbgb zzbgbVar2 = zzbgk.Fa;
        if (!TextUtils.isEmpty((CharSequence) zzbdVar.f21153c.a(zzbgbVar2))) {
            SharedPreferences sharedPreferences = this.f28943j.getSharedPreferences("admob", 0);
            List listAsList2 = Arrays.asList(((String) zzbdVar.f21153c.a(zzbgbVar2)).split(","));
            zzear zzearVar2 = this.f28941h;
            zzearVar2.f28965b = listAsList2;
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzearVar2);
            Iterator it2 = listAsList2.iterator();
            while (it2.hasNext()) {
                zzearVar2.onSharedPreferenceChanged(sharedPreferences, (String) it2.next());
            }
        }
        com.google.android.gms.ads.internal.util.zzj zzjVarG = com.google.android.gms.ads.internal.zzt.C.f21684h.g();
        zzjVarG.d();
        synchronized (zzjVarG.f21580a) {
            str = zzjVarG.x;
        }
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    g(jSONObject.optBoolean("isTestMode", false), false);
                    h((zzeag) Enum.valueOf(zzeag.class, jSONObject.optString("gesture", "NONE")), false);
                    this.o = jSONObject.optString("networkExtras", "{}");
                    this.q = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
                } catch (JSONException unused) {
                }
            }
        }
        com.google.android.gms.ads.internal.util.zzj zzjVarG2 = com.google.android.gms.ads.internal.zzt.C.f21684h.g();
        zzjVarG2.d();
        synchronized (zzjVarG2.f21580a) {
            str2 = zzjVarG2.A;
        }
        this.x = str2;
    }

    public final synchronized void k() {
        int iOrdinal = this.r.ordinal();
        if (iOrdinal == 1) {
            this.f28935b.b();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.f28936c.b();
        }
    }

    public final synchronized void l() {
        SensorManager sensorManager;
        Sensor sensor;
        try {
            int iOrdinal = this.r.ordinal();
            if (iOrdinal == 1) {
                zzebn zzebnVar = this.f28935b;
                synchronized (zzebnVar) {
                    try {
                        if (zzebnVar.f29018g) {
                            SensorManager sensorManager2 = zzebnVar.f29013b;
                            if (sensorManager2 != null) {
                                sensorManager2.unregisterListener(zzebnVar, zzebnVar.f29014c);
                                com.google.android.gms.ads.internal.util.zze.k("Stopped listening for shake gestures.");
                            }
                            zzebnVar.f29018g = false;
                        }
                    } finally {
                    }
                }
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            zzdzw zzdzwVar = this.f28936c;
            synchronized (zzdzwVar) {
                try {
                    if (zzdzwVar.f28884j && (sensorManager = zzdzwVar.f28875a) != null && (sensor = zzdzwVar.f28876b) != null) {
                        sensorManager.unregisterListener(zzdzwVar, sensor);
                        zzdzwVar.f28884j = false;
                        com.google.android.gms.ads.internal.util.zze.k("Stopped listening for flick gestures.");
                    }
                } finally {
                }
            }
            return;
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    public final void m() {
        String string;
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzj zzjVarG = zztVar.f21684h.g();
        synchronized (this) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isTestMode", this.s);
                jSONObject.put("gesture", this.r);
                if (this.q > zztVar.f21687k.currentTimeMillis() / 1000) {
                    jSONObject.put("networkExtras", this.o);
                    jSONObject.put("networkExtrasExpirationSecs", this.q);
                }
            } catch (JSONException unused) {
            }
            string = jSONObject.toString();
        }
        zzjVarG.getClass();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.aa)).booleanValue()) {
            zzjVarG.d();
            synchronized (zzjVarG.f21580a) {
                try {
                    if (zzjVarG.x.equals(string)) {
                        return;
                    }
                    zzjVarG.x = string;
                    SharedPreferences.Editor editor = zzjVarG.f21586g;
                    if (editor != null) {
                        editor.putString("inspector_info", string);
                        zzjVarG.f21586g.apply();
                    }
                    zzjVarG.e();
                } finally {
                }
            }
        }
    }
}
