package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzeiz {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29442a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f29443b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfhr f29444c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcir f29445d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdxe f29446e;

    /* renamed from: f, reason: collision with root package name */
    public zzfrt f29447f;

    public zzeiz(Context context, VersionInfoParcel versionInfoParcel, zzfhr zzfhrVar, zzcir zzcirVar, zzdxe zzdxeVar) {
        this.f29442a = context;
        this.f29443b = versionInfoParcel;
        this.f29444c = zzfhrVar;
        this.f29445d = zzcirVar;
        this.f29446e = zzdxeVar;
    }

    public final synchronized boolean a() {
        zzcir zzcirVar;
        zzfhr zzfhrVar = this.f29444c;
        if (zzfhrVar.T) {
            zzbgb zzbgbVar = zzbgk.V5;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.Y5)).booleanValue() && (zzcirVar = this.f29445d) != null) {
                    if (this.f29447f != null) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Omid javascript session service already started for ad.");
                        return false;
                    }
                    Context context = this.f29442a;
                    com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                    if (!zztVar.x.a(context)) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Unable to initialize omid.");
                        return false;
                    }
                    zzfin zzfinVar = zzfhrVar.V;
                    zzfinVar.getClass();
                    if (zzfinVar.f31227a.optBoolean((String) zzbdVar.f21153c.a(zzbgk.a6), true)) {
                        final VersionInfoParcel versionInfoParcel = this.f29443b;
                        zzeiv zzeivVar = zztVar.x;
                        final WebView webViewK = zzcirVar.k();
                        zzeivVar.getClass();
                        zzfrt zzfrtVar = (zzfrt) zzeiv.i(new zzeiu() { // from class: com.google.android.gms.internal.ads.zzeiq
                            @Override // com.google.android.gms.internal.ads.zzeiu
                            public final Object zza() {
                                VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
                                int i4 = versionInfoParcel2.f21401b;
                                int length = String.valueOf(i4).length();
                                int i5 = versionInfoParcel2.f21402c;
                                StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(i5).length());
                                sb.append(i4);
                                sb.append(CLConstants.DOT_SALT_DELIMETER);
                                sb.append(i5);
                                String string = sb.toString();
                                if (TextUtils.isEmpty("Google")) {
                                    throw new IllegalArgumentException("Name is null or empty");
                                }
                                if (TextUtils.isEmpty(string)) {
                                    throw new IllegalArgumentException("Version is null or empty");
                                }
                                return new zzfrt(new zzfrv("Google", string), webViewK);
                            }
                        });
                        if (((Boolean) zzbdVar.f21153c.a(zzbgk.Z5)).booleanValue()) {
                            zzdxe zzdxeVar = this.f29446e;
                            String str = zzfrtVar != null ? "1" : "0";
                            zzdxd zzdxdVarA = zzdxeVar.a();
                            zzdxdVarA.b("omid_js_session_success", str);
                            zzdxdVarA.c();
                        }
                        if (zzfrtVar == null) {
                            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.f("Unable to create javascript session service.");
                            return false;
                        }
                        int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.e("Created omid javascript session service.");
                        this.f29447f = zzfrtVar;
                        zzcirVar.b0(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final synchronized void b() {
        zzcir zzcirVar;
        try {
            zzfrt zzfrtVar = this.f29447f;
            if (zzfrtVar == null || (zzcirVar = this.f29445d) == null) {
                return;
            }
            Iterator it = zzcirVar.w().iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                com.google.android.gms.ads.internal.zzt.C.x.getClass();
                zzeiv.j(new zzeis(zzfrtVar, view));
            }
            zzcirVar.g("onSdkLoaded", zzgvd.f33244g);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        zzcir zzcirVar;
        if (this.f29447f == null || (zzcirVar = this.f29445d) == null) {
            return;
        }
        zzcirVar.g("onSdkImpression", zzgvd.f33244g);
    }

    public final synchronized void d(View view) {
        zzfrt zzfrtVar = this.f29447f;
        if (zzfrtVar != null) {
            com.google.android.gms.ads.internal.zzt.C.x.getClass();
            zzeiv.j(new zzeis(zzfrtVar, view));
        }
    }
}
