package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbhp {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f25075a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzo f25076b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzf f25077c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdxj f25078d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f25079e;

    /* renamed from: f, reason: collision with root package name */
    public zzbhm f25080f;

    /* renamed from: g, reason: collision with root package name */
    public CustomTabsSession f25081g;

    /* renamed from: h, reason: collision with root package name */
    public String f25082h;

    /* renamed from: i, reason: collision with root package name */
    public long f25083i = 0;

    /* renamed from: j, reason: collision with root package name */
    public long f25084j;

    /* renamed from: k, reason: collision with root package name */
    public JSONArray f25085k;

    /* renamed from: l, reason: collision with root package name */
    public Context f25086l;

    public zzbhp(ScheduledExecutorService scheduledExecutorService, com.google.android.gms.ads.nonagon.signalgeneration.zzo zzoVar, com.google.android.gms.ads.nonagon.signalgeneration.zzf zzfVar, zzdxj zzdxjVar) {
        this.f25075a = scheduledExecutorService;
        this.f25076b = zzoVar;
        this.f25077c = zzfVar;
        this.f25078d = zzdxjVar;
    }

    public final void a(String str) {
        try {
            CustomTabsSession customTabsSession = this.f25081g;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gsppack", true);
            jSONObject.put("fpt", new Date(this.f25084j).toString());
            e(jSONObject);
            if (((Boolean) zzbip.f25197c.c()).booleanValue()) {
                jSONObject.put("as", this.f25077c.b());
            }
            customTabsSession.a(jSONObject.toString());
            zzbhn zzbhnVar = new zzbhn(this, str);
            if (((Boolean) zzbip.f25199e.c()).booleanValue()) {
                this.f25076b.a(this.f25081g, zzbhnVar);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            QueryInfo.a(this.f25086l, new AdRequest((AdRequest.Builder) new AdRequest.Builder().c(bundle)), zzbhnVar);
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error creating JSON: ", e2);
        }
    }

    public final JSONObject b(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("error", str2);
        jSONObject.put("sdk_ttl_ms", ((Boolean) zzbip.f25199e.c()).booleanValue() ? ((Long) zzbip.f25202h.c()).longValue() : 0L);
        e(jSONObject);
        if (((Boolean) zzbip.f25197c.c()).booleanValue()) {
            jSONObject.put("as", this.f25077c.b());
        }
        return jSONObject;
    }

    public final JSONObject c(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("signal", str2);
        jSONObject.put("sdk_ttl_ms", ((Boolean) zzbip.f25199e.c()).booleanValue() ? ((Long) zzbip.f25202h.c()).longValue() : 0L);
        e(jSONObject);
        if (((Boolean) zzbip.f25197c.c()).booleanValue()) {
            jSONObject.put("as", this.f25077c.b());
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(com.google.android.gms.internal.ads.zzbgk.Ya)).booleanValue() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbhm r0 = r6.f25080f
            if (r0 != 0) goto Lc
            int r0 = com.google.android.gms.ads.internal.util.zze.f21576b
            java.lang.String r0 = "PACT callback is not present, please initialize the PawCustomTabsImpl."
            com.google.android.gms.ads.internal.util.client.zzo.c(r0)
            return
        Lc:
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f25067a
            boolean r0 = r0.get()
            if (r0 == 0) goto L15
            return
        L15:
            java.lang.String r0 = r6.f25082h
            if (r0 == 0) goto L8f
            androidx.browser.customtabs.CustomTabsSession r0 = r6.f25081g
            if (r0 == 0) goto L8f
            java.util.concurrent.ScheduledExecutorService r0 = r6.f25075a
            if (r0 == 0) goto L8f
            long r1 = r6.f25083i
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L2a
            goto L39
        L2a:
            com.google.android.gms.ads.internal.zzt r1 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.common.util.Clock r1 = r1.f21687k
            long r1 = r1.elapsedRealtime()
            long r3 = r6.f25083i
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L39
            goto L4b
        L39:
            com.google.android.gms.internal.ads.zzbgb r1 = com.google.android.gms.internal.ads.zzbgk.Ya
            com.google.android.gms.ads.internal.client.zzbd r2 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r2 = r2.f21153c
            java.lang.Object r1 = r2.a(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L8f
        L4b:
            androidx.browser.customtabs.CustomTabsSession r1 = r6.f25081g
            java.lang.String r2 = r6.f25082h
            android.net.Uri r2 = android.net.Uri.parse(r2)
            r1.getClass()
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            android.os.Bundle r4 = new android.os.Bundle     // Catch: android.os.RemoteException -> L77
            r4.<init>()     // Catch: android.os.RemoteException -> L77
            boolean r5 = r4.isEmpty()     // Catch: android.os.RemoteException -> L77
            if (r5 == 0) goto L67
            r4 = 0
        L67:
            android.support.customtabs.ICustomTabsCallback r5 = r1.f1354c
            android.support.customtabs.ICustomTabsService r1 = r1.f1353b
            if (r4 == 0) goto L74
            r3.putAll(r4)     // Catch: android.os.RemoteException -> L77
            r1.J4(r5, r2, r3)     // Catch: android.os.RemoteException -> L77
            goto L77
        L74:
            r1.Oa(r5, r2)     // Catch: android.os.RemoteException -> L77
        L77:
            java.lang.Runnable r1 = r6.f25079e
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.Za
            com.google.android.gms.ads.internal.client.zzbd r3 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r3 = r3.f21153c
            java.lang.Object r2 = r3.a(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r2, r4)
            return
        L8f:
            java.lang.String r0 = "PACT max retry connection duration timed out"
            com.google.android.gms.ads.internal.util.zze.k(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhp.d():void");
    }

    public final void e(JSONObject jSONObject) throws JSONException {
        try {
            if (this.f25085k == null) {
                this.f25085k = new JSONArray((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.bb));
            }
            jSONObject.put("eids", this.f25085k);
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error fetching the PACT active eids JSON: ", e2);
        }
    }
}
