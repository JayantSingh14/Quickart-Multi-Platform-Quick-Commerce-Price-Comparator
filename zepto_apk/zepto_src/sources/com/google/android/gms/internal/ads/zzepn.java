package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzepn extends zzbva {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f30040f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final zzbuy f30041a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcdt f30042b;

    /* renamed from: c, reason: collision with root package name */
    public final JSONObject f30043c;

    /* renamed from: d, reason: collision with root package name */
    public final long f30044d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f30045e;

    public zzepn(String str, zzbuy zzbuyVar, zzcdt zzcdtVar, long j2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.f30043c = jSONObject;
        this.f30045e = false;
        this.f30042b = zzcdtVar;
        this.f30041a = zzbuyVar;
        this.f30044d = j2;
        try {
            jSONObject.put("adapter_version", zzbuyVar.zzf().toString());
            jSONObject.put("sdk_version", zzbuyVar.zzg().toString());
            jSONObject.put(CLConstants.FIELD_PAY_INFO_NAME, str);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    public final synchronized void Xb(int i2, String str) {
        try {
            if (this.f30045e) {
                return;
            }
            try {
                JSONObject jSONObject = this.f30043c;
                jSONObject.put("signal_error", str);
                zzbgb zzbgbVar = zzbgk.W1;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                    jSONObject.put("latency", com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - this.f30044d);
                }
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.V1)).booleanValue()) {
                    jSONObject.put("signal_error_code", i2);
                }
            } catch (JSONException unused) {
            }
            this.f30042b.b(this.f30043c);
            this.f30045e = true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
