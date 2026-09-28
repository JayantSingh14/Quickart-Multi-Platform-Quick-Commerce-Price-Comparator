package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdzy implements zzdan, zzddq, zzdcc {

    /* renamed from: a, reason: collision with root package name */
    public final zzeak f28889a;

    /* renamed from: b, reason: collision with root package name */
    public final String f28890b;

    /* renamed from: c, reason: collision with root package name */
    public final String f28891c;

    /* renamed from: f, reason: collision with root package name */
    public zzdad f28894f;

    /* renamed from: g, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zze f28895g;

    /* renamed from: k, reason: collision with root package name */
    public JSONObject f28899k;

    /* renamed from: l, reason: collision with root package name */
    public JSONObject f28900l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f28901m;
    public boolean n;
    public boolean o;

    /* renamed from: h, reason: collision with root package name */
    public String f28896h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f28897i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f28898j = "";

    /* renamed from: d, reason: collision with root package name */
    public int f28892d = 0;

    /* renamed from: e, reason: collision with root package name */
    public zzdzx f28893e = zzdzx.f28885a;

    public zzdzy(zzeak zzeakVar, zzfik zzfikVar, String str) {
        this.f28889a = zzeakVar;
        this.f28891c = str;
        this.f28890b = zzfikVar.f31219g;
    }

    public static JSONObject c(com.google.android.gms.ads.internal.client.zze zzeVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", zzeVar.f21163c);
        jSONObject.put(CLConstants.FIELD_ERROR_CODE, zzeVar.f21161a);
        jSONObject.put("errorDescription", zzeVar.f21162b);
        com.google.android.gms.ads.internal.client.zze zzeVar2 = zzeVar.f21164d;
        jSONObject.put("underlyingError", zzeVar2 == null ? null : c(zzeVar2));
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void F(zzfic zzficVar) {
        zzeak zzeakVar = this.f28889a;
        if (zzeakVar.f()) {
            zzfib zzfibVar = zzficVar.f31194b;
            List list = zzfibVar.f31189a;
            if (!list.isEmpty()) {
                this.f28892d = ((zzfhr) list.get(0)).f31150b;
            }
            zzfhu zzfhuVar = zzfibVar.f31190b;
            String str = zzfhuVar.f31177l;
            if (!TextUtils.isEmpty(str)) {
                this.f28896h = str;
            }
            String str2 = zzfhuVar.f31178m;
            if (!TextUtils.isEmpty(str2)) {
                this.f28897i = str2;
            }
            JSONObject jSONObject = zzfhuVar.p;
            if (jSONObject.length() > 0) {
                this.f28900l = jSONObject;
            }
            zzbgb zzbgbVar = zzbgk.ua;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                if (zzeakVar.w >= ((Long) zzbdVar.f21153c.a(zzbgk.va)).longValue()) {
                    this.o = true;
                    return;
                }
                String str3 = zzfhuVar.n;
                if (!TextUtils.isEmpty(str3)) {
                    this.f28898j = str3;
                }
                JSONObject jSONObject2 = zzfhuVar.o;
                if (jSONObject2.length() > 0) {
                    this.f28899k = jSONObject2;
                }
                JSONObject jSONObject3 = this.f28899k;
                int length = jSONObject3 != null ? jSONObject3.toString().length() : 0;
                if (!TextUtils.isEmpty(this.f28898j)) {
                    length += this.f28898j.length();
                }
                long j2 = length;
                synchronized (zzeakVar) {
                    zzeakVar.w += j2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ya)).booleanValue()) {
            return;
        }
        zzeak zzeakVar = this.f28889a;
        if (zzeakVar.f()) {
            zzeakVar.c(this.f28890b, this);
        }
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectB;
        IBinder iBinder;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", this.f28893e);
        jSONObject.put("format", zzfhr.a(this.f28892d));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ya)).booleanValue()) {
            jSONObject.put("isOutOfContext", this.f28901m);
            if (this.f28901m) {
                jSONObject.put("shown", this.n);
            }
        }
        zzdad zzdadVar = this.f28894f;
        if (zzdadVar != null) {
            jSONObjectB = b(zzdadVar);
        } else {
            com.google.android.gms.ads.internal.client.zze zzeVar = this.f28895g;
            JSONObject jSONObjectB2 = null;
            if (zzeVar != null && (iBinder = zzeVar.f21165e) != null) {
                zzdad zzdadVar2 = (zzdad) iBinder;
                jSONObjectB2 = b(zzdadVar2);
                if (zzdadVar2.f27547e.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(c(this.f28895g));
                    jSONObjectB2.put("errors", jSONArray);
                }
            }
            jSONObjectB = jSONObjectB2;
        }
        jSONObject.put("responseInfo", jSONObjectB);
        return jSONObject;
    }

    public final JSONObject b(zzdad zzdadVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("winningAdapterClassName", zzdadVar.f27543a);
        jSONObject.put("responseSecsSinceEpoch", zzdadVar.f27548f);
        jSONObject.put("responseId", zzdadVar.f27544b);
        zzbgb zzbgbVar = zzbgk.ra;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            String str = zzdadVar.f27549g;
            if (!TextUtils.isEmpty(str)) {
                String strValueOf = String.valueOf(str);
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Bidding data: ".concat(strValueOf));
                jSONObject.put("biddingData", new JSONObject(str));
            }
        }
        if (!TextUtils.isEmpty(this.f28896h)) {
            jSONObject.put("adRequestUrl", this.f28896h);
        }
        if (!TextUtils.isEmpty(this.f28897i)) {
            jSONObject.put("postBody", this.f28897i);
        }
        if (!TextUtils.isEmpty(this.f28898j)) {
            jSONObject.put("adResponseBody", this.f28898j);
        }
        Object obj = this.f28899k;
        if (obj != null) {
            jSONObject.put("adResponseHeaders", obj);
        }
        Object obj2 = this.f28900l;
        if (obj2 != null) {
            jSONObject.put("transactionExtras", obj2);
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.ua)).booleanValue()) {
            jSONObject.put("hasExceededMemoryLimit", this.o);
        }
        JSONArray jSONArray = new JSONArray();
        for (com.google.android.gms.ads.internal.client.zzv zzvVar : zzdadVar.f27547e) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("adapterClassName", zzvVar.f21298a);
            jSONObject2.put("latencyMillis", zzvVar.f21299b);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.sa)).booleanValue()) {
                jSONObject2.put("credentials", com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.m(zzvVar.f21301d));
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = zzvVar.f21300c;
            jSONObject2.put("error", zzeVar == null ? null : c(zzeVar));
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("adNetworks", jSONArray);
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void m0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzeak zzeakVar = this.f28889a;
        if (zzeakVar.f()) {
            this.f28893e = zzdzx.f28887c;
            this.f28895g = zzeVar;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ya)).booleanValue()) {
                zzeakVar.c(this.f28890b, this);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final void t(zzcvk zzcvkVar) {
        zzeak zzeakVar = this.f28889a;
        if (zzeakVar.f()) {
            this.f28894f = zzcvkVar.f27232f;
            this.f28893e = zzdzx.f28886b;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ya)).booleanValue()) {
                zzeakVar.c(this.f28890b, this);
            }
        }
    }
}
