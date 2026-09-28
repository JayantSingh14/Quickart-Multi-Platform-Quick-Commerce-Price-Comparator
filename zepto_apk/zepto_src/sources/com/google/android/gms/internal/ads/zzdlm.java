package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzbfp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzdlm implements zzdak, zzdhw {

    /* renamed from: a, reason: collision with root package name */
    public final zzcbt f27888a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f27889b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcbw f27890c;

    /* renamed from: d, reason: collision with root package name */
    public final WebView f27891d;

    /* renamed from: e, reason: collision with root package name */
    public String f27892e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbfp.zza.EnumC0023zza f27893f;

    public zzdlm(zzcbt zzcbtVar, Context context, zzcbw zzcbwVar, WebView webView, zzbfp.zza.EnumC0023zza enumC0023zza) {
        this.f27888a = zzcbtVar;
        this.f27889b = context;
        this.f27890c = zzcbwVar;
        this.f27891d = webView;
        this.f27893f = enumC0023zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void T() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void Y(zzbzj zzbzjVar, String str, String str2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Context context = this.f27889b;
        zzcbw zzcbwVar = this.f27890c;
        if (zzcbwVar.a(context)) {
            try {
                zzcbwVar.e(context, zzcbwVar.d(context), this.f27888a.f25858c, zzbzjVar.f25777a, zzbzjVar.f25778b);
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Remote Exception to get reward item.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void b() {
        this.f27888a.a(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void g() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        WebView webView = this.f27891d;
        if (webView != null && this.f27892e != null) {
            Context context = webView.getContext();
            String str = this.f27892e;
            zzcbw zzcbwVar = this.f27890c;
            if (zzcbwVar.a(context) && (context instanceof Activity)) {
                AtomicReference atomicReference = zzcbwVar.f25869g;
                if (zzcbwVar.m(context, "com.google.firebase.analytics.FirebaseAnalytics", atomicReference, false)) {
                    ConcurrentHashMap concurrentHashMap = zzcbwVar.f25870h;
                    Method declaredMethod = (Method) concurrentHashMap.get("setCurrentScreen");
                    if (declaredMethod == null) {
                        try {
                            declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("setCurrentScreen", Activity.class, String.class, String.class);
                            concurrentHashMap.put("setCurrentScreen", declaredMethod);
                        } catch (Exception unused) {
                            zzcbwVar.l("setCurrentScreen", false);
                            declaredMethod = null;
                        }
                    }
                    try {
                        declaredMethod.invoke(atomicReference.get(), (Activity) context, str, context.getPackageName());
                    } catch (Exception unused2) {
                        zzcbwVar.l("setCurrentScreen", false);
                    }
                }
            }
        }
        this.f27888a.a(true);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhw
    public final void zzg() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhw
    public final void zzh() {
        zzbfp.zza.EnumC0023zza enumC0023zza = zzbfp.zza.EnumC0023zza.APP_OPEN;
        zzbfp.zza.EnumC0023zza enumC0023zza2 = this.f27893f;
        if (enumC0023zza2 == enumC0023zza) {
            return;
        }
        zzcbw zzcbwVar = this.f27890c;
        Context context = this.f27889b;
        String str = "";
        if (zzcbwVar.a(context)) {
            AtomicReference atomicReference = zzcbwVar.f25868f;
            if (zzcbwVar.m(context, "com.google.android.gms.measurement.AppMeasurement", atomicReference, true)) {
                try {
                    String str2 = (String) zzcbwVar.i(context, "getCurrentScreenName").invoke(atomicReference.get(), null);
                    if (str2 == null) {
                        str2 = (String) zzcbwVar.i(context, "getCurrentScreenClass").invoke(atomicReference.get(), null);
                    }
                    if (str2 != null) {
                        str = str2;
                    }
                } catch (Exception unused) {
                    zzcbwVar.l("getCurrentScreenName", false);
                }
            }
        }
        this.f27892e = str;
        this.f27892e = String.valueOf(str).concat(enumC0023zza2 == zzbfp.zza.EnumC0023zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
    }
}
