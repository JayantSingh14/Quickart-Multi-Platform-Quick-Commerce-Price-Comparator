package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.internal.WebViewFeatureInternal;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzdua {

    /* renamed from: a, reason: collision with root package name */
    public final Context f28555a;

    /* renamed from: b, reason: collision with root package name */
    public final zzayq f28556b;

    /* renamed from: c, reason: collision with root package name */
    public final zzbhr f28557c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f28558d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.zza f28559e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbfj f28560f;

    /* renamed from: g, reason: collision with root package name */
    public final zzddl f28561g;

    /* renamed from: h, reason: collision with root package name */
    public final zzeif f28562h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfio f28563i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdxe f28564j;

    /* renamed from: k, reason: collision with root package name */
    public final zzckq f28565k;

    public zzdua(Context context, zzayq zzayqVar, zzbhr zzbhrVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbfj zzbfjVar, zzddl zzddlVar, zzeif zzeifVar, zzfio zzfioVar, zzdxe zzdxeVar, zzckq zzckqVar) {
        this.f28555a = context;
        this.f28556b = zzayqVar;
        this.f28557c = zzbhrVar;
        this.f28558d = versionInfoParcel;
        this.f28559e = zzaVar;
        this.f28560f = zzbfjVar;
        this.f28561g = zzddlVar;
        this.f28562h = zzeifVar;
        this.f28563i = zzfioVar;
        this.f28564j = zzdxeVar;
        this.f28565k = zzckqVar;
    }

    public final zzcir a(com.google.android.gms.ads.internal.client.zzr zzrVar, zzfhr zzfhrVar, zzfhu zzfhuVar) throws zzcjg {
        zzclb zzclbVarA = zzclb.a(zzrVar);
        zzdtp zzdtpVar = new zzdtp(this);
        VersionInfoParcel versionInfoParcel = this.f28558d;
        com.google.android.gms.ads.internal.zza zzaVar = this.f28559e;
        zzeif zzeifVar = this.f28562h;
        zzfio zzfioVar = this.f28563i;
        Context context = this.f28555a;
        String str = zzrVar.f21281a;
        zzcir zzcirVarA = zzcjh.a(context, versionInfoParcel, zzaVar, zzdtpVar, this.f28556b, this.f28560f, this.f28557c, zzclbVarA, this.f28564j, zzeifVar, zzfhrVar, zzfhuVar, zzfioVar, str, false, false);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.hf)).booleanValue()) {
            WebView webViewK = zzcirVarA.k();
            if (this.f28565k.f26467a != null) {
                try {
                    int i2 = WebViewCompat.f12427a;
                    if (!WebViewFeatureInternal.n.d()) {
                        throw WebViewFeatureInternal.a();
                    }
                    WebViewCompat.c(webViewK).f12463a.setProfile("GMA_WEBVIEW_PROFILE");
                    com.google.android.gms.ads.internal.util.zze.k("WebViewCompat Profile is defined");
                    return zzcirVarA;
                } catch (IllegalStateException e2) {
                    String strConcat = "WebViewCompat error: ".concat(e2.toString());
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.gf)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("WebViewCompat.setProfile", e2);
                    }
                }
            }
        }
        return zzcirVarA;
    }
}
