package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzcld {

    /* renamed from: a, reason: collision with root package name */
    public String f26495a;

    /* renamed from: b, reason: collision with root package name */
    public zzief f26496b;

    /* renamed from: c, reason: collision with root package name */
    public zziic f26497c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f26498d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f26499e = new AtomicBoolean(false);

    public zzcld(ScheduledExecutorService scheduledExecutorService) {
        this.f26498d = scheduledExecutorService;
    }

    public final void a() {
        try {
            String strD = WebViewFeature.a("GET_VARIATIONS_HEADER") ? WebViewCompat.d() : null;
            if (strD != null && !strD.isEmpty()) {
                this.f26495a = strD;
                byte[] bArrDecode = Base64.decode(strD, 10);
                this.f26496b = zzief.C(bArrDecode, zziab.a());
                zzbgb zzbgbVar = zzbgk.U9;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                zzbgi zzbgiVar = zzbdVar.f21153c;
                zzbgi zzbgiVar2 = zzbdVar.f21153c;
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    this.f26497c = zziic.C(bArrDecode, zziab.a());
                }
                if (((Boolean) zzbgiVar2.a(zzbgk.S9)).booleanValue() && ((Boolean) zzbgiVar2.a(zzbgk.R9)).booleanValue()) {
                    this.f26498d.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclc
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f26494a.a();
                        }
                    }, ((Integer) zzbgiVar2.a(zzbgk.T9)).intValue(), TimeUnit.MINUTES);
                }
            }
        } catch (zzibg e2) {
            e = e2;
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("ChromeVariations", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("ChromeVariations", e);
        }
    }
}
