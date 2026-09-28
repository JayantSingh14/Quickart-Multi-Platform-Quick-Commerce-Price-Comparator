package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzduu {

    /* renamed from: a, reason: collision with root package name */
    public final zzfjg f28608a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdur f28609b;

    public zzduu(zzfjg zzfjgVar, zzdur zzdurVar) {
        this.f28608a = zzfjgVar;
        this.f28609b = zzdurVar;
    }

    public final zzfji a(String str, JSONObject jSONObject) throws zzfir {
        zzbtc zzbtcVarB;
        zzdur zzdurVar = this.f28609b;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzbtcVarB = new zzbua(new AdMobAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzbtcVarB = new zzbua(new zzbvr());
            } else {
                zzbsz zzbszVar = (zzbsz) this.f28608a.f31269c.get();
                if (zzbszVar == null) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Unexpected call to adapter creator.");
                    throw new RemoteException();
                }
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                    try {
                        String string = jSONObject.getString("class_name");
                        zzbtcVarB = zzbszVar.o(string) ? zzbszVar.b("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") : zzbszVar.Y(string) ? zzbszVar.b(string) : zzbszVar.b("com.google.ads.mediation.customevent.CustomEventAdapter");
                    } catch (JSONException e2) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("Invalid custom event.", e2);
                    }
                } else {
                    zzbtcVarB = zzbszVar.b(str);
                }
            }
            zzfji zzfjiVar = new zzfji(zzbtcVarB);
            zzdurVar.a(str, zzfjiVar);
            return zzfjiVar;
        } catch (Throwable th) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.xa)).booleanValue()) {
                zzdurVar.a(str, null);
            }
            throw new zzfir(th);
        }
    }

    public final zzbuy b(String str) throws RemoteException {
        zzbsz zzbszVar = (zzbsz) this.f28608a.f31269c.get();
        if (zzbszVar == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Unexpected call to adapter creator.");
            throw new RemoteException();
        }
        zzbuy zzbuyVarQ = zzbszVar.q(str);
        zzdur zzdurVar = this.f28609b;
        synchronized (zzdurVar) {
            if (zzdurVar.f28606a.containsKey(str)) {
                return zzbuyVarQ;
            }
            try {
                zzdurVar.f28606a.put(str, new zzduq(str, zzbuyVarQ.zzf(), zzbuyVarQ.zzg(), true));
                return zzbuyVarQ;
            } catch (Throwable unused) {
                return zzbuyVarQ;
            }
        }
    }
}
