package com.google.android.gms.internal.ads;

import in.juspay.hypersdk.core.PaymentConstants;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzeae {

    /* renamed from: a, reason: collision with root package name */
    public final String f28913a;

    /* renamed from: b, reason: collision with root package name */
    public final String f28914b;

    /* renamed from: c, reason: collision with root package name */
    public final String f28915c;

    /* renamed from: d, reason: collision with root package name */
    public final int f28916d;

    /* renamed from: e, reason: collision with root package name */
    public final String f28917e;

    /* renamed from: f, reason: collision with root package name */
    public final int f28918f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f28919g;

    public zzeae(String str, String str2, String str3, int i2, String str4, int i3, boolean z) {
        this.f28913a = str;
        this.f28914b = str2;
        this.f28915c = str3;
        this.f28916d = i2;
        this.f28917e = str4;
        this.f28918f = i3;
        this.f28919g = z;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adapterClassName", this.f28913a);
        jSONObject.put("version", this.f28915c);
        zzbgb zzbgbVar = zzbgk.wa;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            jSONObject.put(PaymentConstants.SDK_VERSION, this.f28914b);
        }
        jSONObject.put(CLConstants.OTP_STATUS, this.f28916d);
        jSONObject.put("description", this.f28917e);
        jSONObject.put("initializationLatencyMillis", this.f28918f);
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.xa)).booleanValue()) {
            jSONObject.put("supportsInitialization", this.f28919g);
        }
        return jSONObject;
    }
}
