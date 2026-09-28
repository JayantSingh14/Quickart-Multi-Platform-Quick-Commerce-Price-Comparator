package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface zzbqk extends zzbqv, zzbqj {
    @Override // com.google.android.gms.internal.ads.zzbqv
    void a(String str);

    @Override // com.google.android.gms.internal.ads.zzbqv
    default void c(String str, String str2) {
        a(android.support.v4.media.a.n(new StringBuilder(androidx.fragment.app.e.C(1, String.valueOf(str2).length(), str) + 2), str, "(", str2, ");"));
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    default void f(String str, JSONObject jSONObject) {
        c(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbqj
    default void g(String str, Map map) {
        try {
            m(str, com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.l(map));
        } catch (JSONException unused) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqj
    default void m(String str, JSONObject jSONObject) {
        StringBuilder sbV = androidx.fragment.app.e.v("(window.AFMA_ReceiveMessage || function() {})('", str, "',", jSONObject.toString(), ");");
        String string = sbV.toString();
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Dispatching AFMA event: ".concat(string));
        a(sbV.toString());
    }
}
