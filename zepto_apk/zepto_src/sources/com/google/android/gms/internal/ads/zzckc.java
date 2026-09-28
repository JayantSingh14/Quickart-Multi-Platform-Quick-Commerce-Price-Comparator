package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzckc {

    /* renamed from: a, reason: collision with root package name */
    public final zzckb f26463a;

    /* renamed from: b, reason: collision with root package name */
    public final zzckd f26464b;

    public zzckc(zzckd zzckdVar, zzckb zzckbVar) {
        this.f26463a = zzckbVar;
        this.f26464b = zzckdVar;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zze.k("Click string is empty, not proceeding.");
            return "";
        }
        Object obj = this.f26464b;
        zzayq zzayqVarD = ((zzckk) obj).d();
        if (zzayqVarD == null) {
            com.google.android.gms.ads.internal.util.zze.k("Signal utils is empty, ignoring.");
            return "";
        }
        zzayl zzaylVar = zzayqVarD.f24512b;
        if (zzaylVar == null) {
            com.google.android.gms.ads.internal.util.zze.k("Signals object is empty, ignoring.");
            return "";
        }
        View view = (View) obj;
        if (view.getContext() != null) {
            return zzaylVar.g(view.getContext(), str, ((zzckm) obj).x(), ((zzcju) obj).f26423a.f26469a);
        }
        com.google.android.gms.ads.internal.util.zze.k("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public String getViewSignals() {
        Object obj = this.f26464b;
        zzayq zzayqVarD = ((zzckk) obj).d();
        if (zzayqVarD == null) {
            com.google.android.gms.ads.internal.util.zze.k("Signal utils is empty, ignoring.");
            return "";
        }
        zzayl zzaylVar = zzayqVarD.f24512b;
        if (zzaylVar == null) {
            com.google.android.gms.ads.internal.util.zze.k("Signals object is empty, ignoring.");
            return "";
        }
        View view = (View) obj;
        if (view.getContext() != null) {
            return zzaylVar.j(view.getContext(), ((zzckm) obj).x(), ((zzcju) obj).f26423a.f26469a);
        }
        com.google.android.gms.ads.internal.util.zze.k("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public String getViewSignalsJson() throws JSONException {
        Object obj = this.f26464b;
        zzbgk.a(((View) obj).getContext());
        String viewSignals = getViewSignals();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Re)).booleanValue()) {
            return viewSignals;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ms", viewSignals);
            zzcjc zzcjcVarE0 = ((zzcir) obj).e0();
            zzcze zzczeVar = zzcjcVarE0 != null ? zzcjcVarE0.A : null;
            if (zzczeVar != null) {
                long j2 = zzczeVar.f27458a.get();
                if (j2 > 0) {
                    jSONObject.put("plcmtid", j2);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Error constructing JSON.", e2);
            return "";
        }
    }

    @JavascriptInterface
    public void notify(final String str) {
        if (!TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjz
                @Override // java.lang.Runnable
                public final void run() {
                    zzckb zzckbVar = this.f26456a.f26463a;
                    Uri uri = Uri.parse(str);
                    zzcjc zzcjcVar = ((zzcju) ((zzcka) zzckbVar).f26462a).n;
                    if (zzcjcVar != null) {
                        zzcjcVar.j(uri);
                    } else {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.c("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                    }
                }
            });
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("URL is empty, ignoring message");
        }
    }
}
