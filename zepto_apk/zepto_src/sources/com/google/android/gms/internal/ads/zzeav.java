package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import in.juspay.hypersdk.core.PaymentConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzeav implements com.google.android.gms.ads.internal.overlay.zzr, zzckn {

    /* renamed from: a, reason: collision with root package name */
    public final Context f28968a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f28969b;

    /* renamed from: c, reason: collision with root package name */
    public zzeak f28970c;

    /* renamed from: d, reason: collision with root package name */
    public zzcir f28971d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f28972e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f28973f;

    /* renamed from: g, reason: collision with root package name */
    public long f28974g;

    /* renamed from: h, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzdn f28975h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f28976i;

    public zzeav(Context context, VersionInfoParcel versionInfoParcel) {
        this.f28968a = context;
        this.f28969b = versionInfoParcel;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void R6(int i2) {
        this.f28971d.destroy();
        if (!this.f28976i) {
            com.google.android.gms.ads.internal.util.zze.k("Inspector closed.");
            com.google.android.gms.ads.internal.client.zzdn zzdnVar = this.f28975h;
            if (zzdnVar != null) {
                try {
                    zzdnVar.x0(null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.f28973f = false;
        this.f28972e = false;
        this.f28974g = 0L;
        this.f28976i = false;
        this.f28975h = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
    }

    @Override // com.google.android.gms.internal.ads.zzckn
    public final synchronized void a(String str, int i2, String str2, boolean z) {
        if (z) {
            com.google.android.gms.ads.internal.util.zze.k("Ad inspector loaded.");
            this.f28972e = true;
            c();
            return;
        }
        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector failed to load.");
        try {
            zzcda zzcdaVar = com.google.android.gms.ads.internal.zzt.C.f21684h;
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 46 + String.valueOf(str).length() + 15 + String.valueOf(str2).length());
            sb.append("Failed to load UI. Error code: ");
            sb.append(i2);
            sb.append(", Description: ");
            sb.append(str);
            sb.append(", Failing URL: ");
            sb.append(str2);
            zzcdaVar.d("InspectorUi.onAdWebViewFinishedLoading 0", new Exception(sb.toString()));
            com.google.android.gms.ads.internal.client.zzdn zzdnVar = this.f28975h;
            if (zzdnVar != null) {
                zzdnVar.x0(zzfjm.d(17, null, null));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("InspectorUi.onAdWebViewFinishedLoading 1", e2);
        }
        this.f28976i = true;
        this.f28971d.destroy();
    }

    public final synchronized void b(com.google.android.gms.ads.internal.client.zzdn zzdnVar, zzboi zzboiVar, zzbob zzbobVar, zzbno zzbnoVar) {
        if (d(zzdnVar)) {
            try {
                com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                zzcjh zzcjhVar = zztVar.f21680d;
                zzcir zzcirVarA = zzcjh.a(this.f28968a, this.f28969b, null, null, null, new zzbfj(), null, new zzclb(0, 0, 0), null, null, null, null, null, "", false, false);
                this.f28971d = zzcirVarA;
                zzcjc zzcjcVarE0 = zzcirVarA.e0();
                if (zzcjcVarE0 == null) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Failed to obtain a web view for the ad inspector");
                    try {
                        zztVar.f21684h.d("InspectorUi.openInspector 2", new NullPointerException("Failed to obtain a web view for the ad inspector"));
                        zzdnVar.x0(zzfjm.d(17, "Failed to obtain a web view for the ad inspector", null));
                        return;
                    } catch (RemoteException e2) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("InspectorUi.openInspector 3", e2);
                        return;
                    }
                }
                this.f28975h = zzdnVar;
                Context context = this.f28968a;
                zzcjcVarE0.y(null, null, null, null, null, false, null, null, null, null, null, null, null, zzboiVar, null, new zzboh(context), zzbobVar, zzbnoVar, null, null, null, null);
                zzcjcVarE0.f26375g = this;
                this.f28971d.loadUrl((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ba));
                com.google.android.gms.ads.internal.overlay.zzn.a(context, new AdOverlayInfoParcel(this, this.f28971d, this.f28969b), true, null);
                this.f28974g = zztVar.f21687k.currentTimeMillis();
            } catch (zzcjg e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Failed to obtain a web view for the ad inspector", e3);
                try {
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("InspectorUi.openInspector 0", e3);
                    zzdnVar.x0(zzfjm.d(17, "Failed to obtain a web view for the ad inspector", null));
                } catch (RemoteException e4) {
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("InspectorUi.openInspector 1", e4);
                }
            }
        }
    }

    public final synchronized void c() {
        if (this.f28972e && this.f28973f) {
            ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeau
                @Override // java.lang.Runnable
                public final void run() {
                    JSONObject jSONObject;
                    JSONObject jSONObject2;
                    zzeav zzeavVar = this.f28967a;
                    zzcir zzcirVar = zzeavVar.f28971d;
                    zzeak zzeakVar = zzeavVar.f28970c;
                    synchronized (zzeakVar) {
                        try {
                            jSONObject = new JSONObject();
                            try {
                                jSONObject.put("platform", "ANDROID");
                                String str = zzeakVar.f28944k;
                                if (!TextUtils.isEmpty(str)) {
                                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                                    sb.append("afma-sdk-a-v");
                                    sb.append(str);
                                    jSONObject.put(PaymentConstants.SDK_VERSION, sb.toString());
                                }
                                jSONObject.put("internalSdkVersion", zzeakVar.f28942i);
                                jSONObject.put("osVersion", Build.VERSION.RELEASE);
                                jSONObject.put("adapters", zzeakVar.f28937d.a());
                                zzbgb zzbgbVar = zzbgk.Ba;
                                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                                    String str2 = com.google.android.gms.ads.internal.zzt.C.f21684h.f25937g;
                                    if (!TextUtils.isEmpty(str2)) {
                                        jSONObject.put("plugin", str2);
                                    }
                                }
                                long j2 = zzeakVar.q;
                                com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                                if (j2 < zztVar.f21687k.currentTimeMillis() / 1000) {
                                    zzeakVar.o = "{}";
                                }
                                jSONObject.put("networkExtras", zzeakVar.o);
                                jSONObject.put("adSlots", zzeakVar.i());
                                jSONObject.put("appInfo", zzeakVar.f28938e.a());
                                String str3 = zztVar.f21684h.g().i().f25911e;
                                if (!TextUtils.isEmpty(str3)) {
                                    jSONObject.put("cld", new JSONObject(str3));
                                }
                                if (((Boolean) zzbdVar.f21153c.a(zzbgk.qa)).booleanValue() && (jSONObject2 = zzeakVar.p) != null) {
                                    String string = jSONObject2.toString();
                                    StringBuilder sb2 = new StringBuilder(string.length() + 13);
                                    sb2.append("Server data: ");
                                    sb2.append(string);
                                    String string2 = sb2.toString();
                                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                    com.google.android.gms.ads.internal.util.client.zzo.a(string2);
                                    jSONObject.put("serverData", zzeakVar.p);
                                }
                                if (((Boolean) zzbdVar.f21153c.a(zzbgk.pa)).booleanValue()) {
                                    jSONObject.put("openAction", zzeakVar.v);
                                    jSONObject.put("gesture", zzeakVar.r);
                                }
                                jSONObject.put("isGamRegisteredTestDevice", zztVar.o.g());
                                com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
                                jSONObject.put("isSimulator", com.google.android.gms.ads.internal.util.client.zzf.r());
                                if (((Boolean) zzbdVar.f21153c.a(zzbgk.Da)).booleanValue()) {
                                    jSONObject.put("uiStorage", new JSONObject(zzeakVar.x));
                                }
                                if (!TextUtils.isEmpty((CharSequence) zzbdVar.f21153c.a(zzbgk.Fa))) {
                                    jSONObject.put("gmaDisk", zzeakVar.f28941h.f28964a);
                                }
                                if (!TextUtils.isEmpty((CharSequence) zzbdVar.f21153c.a(zzbgk.Ea))) {
                                    jSONObject.put("userDisk", zzeakVar.f28940g.f28964a);
                                }
                            } catch (JSONException e2) {
                                com.google.android.gms.ads.internal.zzt.C.f21684h.e("Inspector.toJson", e2);
                                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                com.google.android.gms.ads.internal.util.client.zzo.g("Ad inspector encountered an error", e2);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    zzcirVar.c("window.inspectorInfo", jSONObject.toString());
                }
            });
        }
    }

    public final synchronized boolean d(com.google.android.gms.ads.internal.client.zzdn zzdnVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.aa)).booleanValue()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector had an internal error.");
            try {
                zzdnVar.x0(zzfjm.d(16, null, null));
            } catch (RemoteException unused) {
            }
            return false;
        }
        if (this.f28970c == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector had an internal error.");
            try {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("InspectorUi.shouldOpenUi", new NullPointerException("InspectorManager null"));
                zzdnVar.x0(zzfjm.d(16, null, null));
            } catch (RemoteException unused2) {
            }
            return false;
        }
        if (!this.f28972e && !this.f28973f) {
            if (com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() >= this.f28974g + ((Integer) r1.f21153c.a(zzbgk.da)).intValue()) {
                return true;
            }
        }
        int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Ad inspector cannot be opened because it is already open.");
        try {
            zzdnVar.x0(zzfjm.d(19, null, null));
        } catch (RemoteException unused3) {
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void d9() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void i5() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w8() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzh() {
        this.f28973f = true;
        c();
    }
}
