package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class zzeaf {

    /* renamed from: a, reason: collision with root package name */
    public final zzdzp f28920a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdur f28921b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f28922c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f28923d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f28924e;

    public zzeaf(zzdzp zzdzpVar, zzdur zzdurVar) {
        this.f28920a = zzdzpVar;
        this.f28921b = zzdurVar;
    }

    public final JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f28922c) {
            try {
                if (!this.f28924e) {
                    zzdzp zzdzpVar = this.f28920a;
                    if (!zzdzpVar.f28847b) {
                        zzead zzeadVar = new zzead(this);
                        zzdzp zzdzpVar2 = this.f28920a;
                        zzdzpVar2.getClass();
                        zzdzpVar2.f28850e.f25992a.q(new zzdzo(zzdzpVar2, zzeadVar), zzdzpVar2.f28855j);
                        return jSONArray;
                    }
                    b(zzdzpVar.b());
                }
                Iterator it = this.f28923d.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((zzeae) it.next()).a());
                }
                return jSONArray;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(List list) {
        zzbvn zzbvnVar;
        zzduq zzduqVarB;
        zzduq zzduqVarB2;
        zzbvn zzbvnVar2;
        synchronized (this.f28922c) {
            try {
                if (this.f28924e) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzbpm zzbpmVar = (zzbpm) it.next();
                    zzbgb zzbgbVar = zzbgk.wa;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                    String string = (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() || (zzduqVarB2 = this.f28921b.b(zzbpmVar.f25411a)) == null || (zzbvnVar2 = zzduqVarB2.f28604c) == null) ? "" : zzbvnVar2.toString();
                    String str = string;
                    boolean z = ((Boolean) zzbdVar.f21153c.a(zzbgk.xa)).booleanValue() && (zzduqVarB = this.f28921b.b(zzbpmVar.f25411a)) != null && zzduqVarB.f28605d;
                    ArrayList arrayList = this.f28923d;
                    String str2 = zzbpmVar.f25411a;
                    zzduq zzduqVarB3 = this.f28921b.b(str2);
                    arrayList.add(new zzeae(str2, str, (zzduqVarB3 == null || (zzbvnVar = zzduqVarB3.f28603b) == null) ? "" : zzbvnVar.toString(), zzbpmVar.f25412b ? 1 : 0, zzbpmVar.f25414d, zzbpmVar.f25413c, z));
                }
                this.f28924e = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
