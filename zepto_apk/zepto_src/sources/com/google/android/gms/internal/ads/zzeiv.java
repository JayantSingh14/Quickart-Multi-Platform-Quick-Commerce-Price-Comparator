package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class zzeiv implements zzeiw {
    public static zzfru f(String str) {
        return "native".equals(str) ? zzfru.NATIVE : "javascript".equals(str) ? zzfru.JAVASCRIPT : zzfru.NONE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzfrp g(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 1
            r3 = 2
            if (r0 == r1) goto L2a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L20
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = r3
            goto L35
        L20:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = r2
            goto L35
        L2a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 0
            goto L35
        L34:
            r4 = -1
        L35:
            if (r4 == 0) goto L44
            if (r4 == r2) goto L41
            if (r4 == r3) goto L3e
            com.google.android.gms.internal.ads.zzfrp r4 = com.google.android.gms.internal.ads.zzfrp.UNSPECIFIED
            return r4
        L3e:
            com.google.android.gms.internal.ads.zzfrp r4 = com.google.android.gms.internal.ads.zzfrp.ONE_PIXEL
            return r4
        L41:
            com.google.android.gms.internal.ads.zzfrp r4 = com.google.android.gms.internal.ads.zzfrp.DEFINED_BY_JAVASCRIPT
            return r4
        L44:
            com.google.android.gms.internal.ads.zzfrp r4 = com.google.android.gms.internal.ads.zzfrp.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiv.g(java.lang.String):com.google.android.gms.internal.ads.zzfrp");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzfrm h(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L20
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = r3
            goto L35
        L20:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = r2
            goto L35
        L2a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 0
            goto L35
        L34:
            r4 = -1
        L35:
            if (r4 == 0) goto L43
            if (r4 == r3) goto L40
            if (r4 == r2) goto L3d
            r4 = 0
            return r4
        L3d:
            com.google.android.gms.internal.ads.zzfrm r4 = com.google.android.gms.internal.ads.zzfrm.VIDEO
            return r4
        L40:
            com.google.android.gms.internal.ads.zzfrm r4 = com.google.android.gms.internal.ads.zzfrm.NATIVE_DISPLAY
            return r4
        L43:
            com.google.android.gms.internal.ads.zzfrm r4 = com.google.android.gms.internal.ads.zzfrm.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiv.h(java.lang.String):com.google.android.gms.internal.ads.zzfrm");
    }

    public static final Object i(zzeiu zzeiuVar) {
        try {
            return zzeiuVar.zza();
        } catch (RuntimeException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("omid exception", e2);
            return null;
        }
    }

    public static final void j(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("omid exception", e2);
        }
    }

    public final boolean a(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.V5)).booleanValue()) {
            Boolean bool = (Boolean) i(new zzeiu() { // from class: com.google.android.gms.internal.ads.zzeit
                @Override // com.google.android.gms.internal.ads.zzeiu
                public final Object zza() {
                    zzfrg zzfrgVar = zzfrf.f31700a;
                    if (zzfrgVar.f31701a) {
                        return Boolean.TRUE;
                    }
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        throw new IllegalArgumentException("Application Context cannot be null");
                    }
                    if (!zzfrgVar.f31701a) {
                        zzfrgVar.f31701a = true;
                        zzfsn zzfsnVarB = zzfsn.b();
                        zzfsnVarB.getClass();
                        new zzfrx();
                        zzfsnVarB.f31799b = new zzfsb(new Handler(), applicationContext, zzfsnVarB);
                        zzfse zzfseVar = zzfse.f31779d;
                        zzfseVar.getClass();
                        boolean z = applicationContext instanceof Application;
                        if (z) {
                            ((Application) applicationContext).registerActivityLifecycleCallbacks(zzfseVar);
                        }
                        zzfta.f31820a = (UiModeManager) applicationContext.getSystemService("uimode");
                        WindowManager windowManager = zzftb.f31821a;
                        zzftb.f31823c = applicationContext.getResources().getDisplayMetrics().density;
                        zzftb.f31821a = (WindowManager) applicationContext.getSystemService("window");
                        applicationContext.registerReceiver(new zzftd(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
                        zzfsk.f31792b.f31793a = applicationContext.getApplicationContext();
                        zzfsd zzfsdVar = zzfsd.f31774e;
                        if (!zzfsdVar.f31776b) {
                            zzfsh zzfshVar = zzfsdVar.f31777c;
                            if (z) {
                                ((Application) applicationContext).registerActivityLifecycleCallbacks(zzfshVar);
                            }
                            zzfshVar.f31785c = zzfsdVar;
                            zzfshVar.f31783a = true;
                            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                            ActivityManager.getMyMemoryState(runningAppProcessInfo);
                            zzfshVar.f31784b = runningAppProcessInfo.importance == 100;
                            zzfsdVar.f31778d = zzfshVar.f31784b;
                            zzfsdVar.f31776b = true;
                        }
                        zzfsp zzfspVar = zzfsp.f31802d;
                        zzfspVar.getClass();
                        zzfspVar.f31803a = new WeakReference(applicationContext);
                        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        applicationContext.registerReceiver(new zzfso(zzfspVar), intentFilter);
                    }
                    return Boolean.valueOf(zzfrgVar.f31701a);
                }
            });
            return bool != null && bool.booleanValue();
        }
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Omid flag is disabled");
        return false;
    }

    public final zzejb b(final WebView webView, final zzeix zzeixVar, final zzeiy zzeiyVar, final String str, final String str2, final String str3) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.V5)).booleanValue() && zzfrf.f31700a.f31701a) {
            return (zzejb) i(new zzeiu() { // from class: com.google.android.gms.internal.ads.zzeil
                @Override // com.google.android.gms.internal.ads.zzeiu
                public final Object zza() {
                    if (TextUtils.isEmpty("Google")) {
                        throw new IllegalArgumentException("Name is null or empty");
                    }
                    String str4 = str;
                    if (TextUtils.isEmpty(str4)) {
                        throw new IllegalArgumentException("Version is null or empty");
                    }
                    zzfrv zzfrvVar = new zzfrv("Google", str4);
                    zzfru zzfruVarF = zzeiv.f("javascript");
                    zzeix zzeixVar2 = zzeixVar;
                    zzfrm zzfrmVarH = zzeiv.h(zzeixVar2.f29435a);
                    zzfru zzfruVar = zzfru.NONE;
                    if (zzfruVarF == zzfruVar) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Omid html session error; Unable to parse impression owner: javascript");
                        return null;
                    }
                    if (zzfrmVarH == null) {
                        String strValueOf = String.valueOf(zzeixVar2);
                        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Omid html session error; Unable to parse creative type: ".concat(strValueOf));
                        return null;
                    }
                    String str5 = str2;
                    zzfru zzfruVarF2 = zzeiv.f(str5);
                    if (zzfrmVarH == zzfrm.VIDEO && zzfruVarF2 == zzfruVar) {
                        String strValueOf2 = String.valueOf(str5);
                        int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Omid html session error; Video events owner unknown for video creative: ".concat(strValueOf2));
                        return null;
                    }
                    zzfrj zzfrjVar = new zzfrj(zzfrvVar, webView, str3, "", zzfrk.HTML);
                    zzfri zzfriVarA = zzfri.a(zzfrmVarH, zzeiv.g(zzeiyVar.f29441a), zzfruVarF, zzfruVarF2, true);
                    if (zzfrf.f31700a.f31701a) {
                        return new zzejb(new zzfrl(zzfriVarA, zzfrjVar, UUID.randomUUID().toString()), zzfrjVar);
                    }
                    throw new IllegalStateException("Method called before OM SDK activation");
                }
            });
        }
        return null;
    }

    public final void c(final zzfrl zzfrlVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.V5)).booleanValue() && zzfrf.f31700a.f31701a) {
            j(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeij
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfrlVar.d();
                }
            });
        }
    }

    public final void d(final zzfrl zzfrlVar, final View view) {
        j(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeio
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.V5)).booleanValue() && zzfrf.f31700a.f31701a) {
                    zzfrlVar.c(view, zzfro.f31736a);
                }
            }
        });
    }

    public final void e(final zzfrl zzfrlVar, final View view) {
        j(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeip
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.V5)).booleanValue() && zzfrf.f31700a.f31701a) {
                    zzfrlVar.a(view);
                }
            }
        });
    }
}
