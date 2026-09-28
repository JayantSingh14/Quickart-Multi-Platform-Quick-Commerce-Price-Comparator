package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.webkit.WebViewFeature;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdwk implements zzddq, zzdby, zzdan, zzdjd {

    /* renamed from: a, reason: collision with root package name */
    public final zzdwy f28681a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdxj f28682b;

    /* renamed from: c, reason: collision with root package name */
    public final int f28683c;

    public zzdwk(zzdwy zzdwyVar, zzdxj zzdxjVar, int i2) {
        this.f28681a = zzdwyVar;
        this.f28682b = zzdxjVar;
        this.f28683c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void F(zzfic zzficVar) {
        zzdwy zzdwyVar = this.f28681a;
        zzdwyVar.getClass();
        zzfib zzfibVar = zzficVar.f31194b;
        List list = zzfibVar.f31189a;
        if (!list.isEmpty()) {
            int i2 = ((zzfhr) list.get(0)).f31150b;
            zzdwyVar.b("ad_format", zzfhr.a(i2));
            if (i2 == 6) {
                zzdwyVar.f28712a.put("as", true != zzdwyVar.f28713b.f25968g ? "0" : "1");
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.B2)).booleanValue()) {
            zzdwyVar.b("mwl", Integer.toString(list.size()));
        }
        zzdwyVar.b("gqi", zzfibVar.f31190b.f31167b);
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) {
        this.f28681a.a(zzbzaVar.f25720a);
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void a(com.google.android.gms.ads.nonagon.signalgeneration.zzbj zzbjVar) {
        String str;
        zzbgb zzbgbVar = zzbgk.D7;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzbgb zzbgbVar2 = zzbgk.k8;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            boolean zBooleanValue = ((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue();
            zzdwy zzdwyVar = this.f28681a;
            if (zBooleanValue) {
                zzdwyVar.f28712a.put("sgw", String.valueOf(this.f28683c));
            }
            zzdxj zzdxjVar = this.f28682b;
            if (zzbjVar == null) {
                zzdwyVar.f28712a.put("action", "sgs");
                ConcurrentHashMap concurrentHashMap = zzdwyVar.f28712a;
                concurrentHashMap.put("request_id", "-1");
                zzdxjVar.a(concurrentHashMap, false);
                return;
            }
            Bundle bundle = zzbjVar.f21856e;
            zzbza zzbzaVar = zzbjVar.f21855d;
            if (zzbzaVar != null) {
                b(zzbzaVar.f25732m, zzdwn.f28700d);
            } else if (bundle != null && !bundle.isEmpty()) {
                b(bundle, zzdwn.f28700d);
            }
            try {
                JSONObject jSONObject = new JSONObject(TextUtils.isEmpty(zzbjVar.f21854c) ? zzbjVar.f21853b : zzbjVar.f21854c);
                zzdwyVar.f28712a.put("action", "sgs");
                ConcurrentHashMap concurrentHashMap2 = zzdwyVar.f28712a;
                if (((Boolean) zzbgiVar.a(zzbgk.Oa)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                    } catch (JSONException e2) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("Error retrieving JSONObject from the requestJson, ", e2);
                    }
                } else {
                    str = "na";
                }
                concurrentHashMap2.put("tpc", str);
                if (zzbzaVar != null) {
                    zzdwyVar.a(zzbzaVar.f25720a);
                }
                zzdwyVar.c();
                zzdxjVar.a(concurrentHashMap2, false);
            } catch (JSONException unused) {
                zzdwyVar.f28712a.put("action", "sgf");
                ConcurrentHashMap concurrentHashMap3 = zzdwyVar.f28712a;
                concurrentHashMap3.put("sgf_reason", "request_invalid");
                zzdxjVar.a(concurrentHashMap3, false);
            }
        }
    }

    public final void b(Bundle bundle, zzgtd zzgtdVar) {
        zzbgb zzbgbVar = zzbgk.z2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() || bundle == null) {
            return;
        }
        bundle.putLong("public-api-callback", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        zzdwy zzdwyVar = this.f28681a;
        zzdwyVar.getClass();
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.ue)).booleanValue()) {
            zzdwyVar.b("brr", true != zzdwyVar.f28714c.q ? "0" : "1");
        }
        if (bundle.containsKey("ls")) {
            zzdwyVar.b("ls", true != bundle.getBoolean("ls") ? "0" : "1");
        }
        int i2 = ((zzguy) zzgtdVar).f33234d;
        for (int i3 = 0; i3 < i2; i3++) {
            zzdwn zzdwnVar = (zzdwn) ((zzguy) zzgtdVar).get(i3);
            long j2 = bundle.getLong(zzdwnVar.f28703b.f28699a, -1L);
            long j3 = bundle.getLong(zzdwnVar.f28704c.f28699a, -1L);
            if (j2 > 0 && j3 > 0) {
                zzdwyVar.b(zzdwnVar.f28702a, String.valueOf(j3 - j2));
            }
        }
        c(bundle.getBundle("client_sig_latency_key"));
        c(bundle.getBundle("gms_sig_latency_key"));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.k8)).booleanValue()) {
            if (bundle.containsKey("sod_h")) {
                zzdwyVar.b("sod_h", true != bundle.getBoolean("sod_h") ? "0" : "1");
            }
            if (bundle.containsKey("cmr")) {
                zzdwyVar.b("cmr", String.valueOf(bundle.getInt("cmr")));
            }
        }
    }

    public final void c(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            long j2 = bundle.getLong(str);
            if (j2 >= 0) {
                this.f28681a.b(str, String.valueOf(j2));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void m0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdwy zzdwyVar = this.f28681a;
        zzdwyVar.f28712a.put("action", "ftl");
        zzdwyVar.b("ftl", String.valueOf(zzeVar.f21161a));
        zzdwyVar.b("ed", zzeVar.f21163c);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.S7)).booleanValue()) {
            zzdwyVar.b("emsg", zzeVar.f21162b);
        }
        zzdwyVar.c();
        this.f28682b.a(zzdwyVar.f28712a, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void q(String str) {
        zzbgb zzbgbVar = zzbgk.D7;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgk.k8)).booleanValue();
            zzdwy zzdwyVar = this.f28681a;
            if (zBooleanValue) {
                zzdwyVar.f28712a.put("sgw", String.valueOf(this.f28683c));
            }
            zzdwyVar.f28712a.put("action", "sgf");
            zzdwyVar.b("sgf_reason", str);
            zzdwyVar.c();
            this.f28682b.a(zzdwyVar.f28712a, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        zzdwy zzdwyVar = this.f28681a;
        zzdwyVar.f28712a.put("action", "loaded");
        b(zzdwyVar.f28716e, zzdwn.f28701e);
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ld)).booleanValue();
        ConcurrentHashMap concurrentHashMap = zzdwyVar.f28712a;
        if (zBooleanValue) {
            concurrentHashMap.put("mafe", true != WebViewFeature.a("MUTE_AUDIO") ? "0" : "1");
        }
        zzdwyVar.c();
        this.f28682b.a(concurrentHashMap, false);
    }
}
