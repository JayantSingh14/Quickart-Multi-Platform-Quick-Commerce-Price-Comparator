package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzboa implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.zzb f25374a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdxe f25375b;

    /* renamed from: d, reason: collision with root package name */
    public final zzbvx f25377d;

    /* renamed from: e, reason: collision with root package name */
    public final zzehu f25378e;

    /* renamed from: f, reason: collision with root package name */
    public final zzcra f25379f;

    /* renamed from: g, reason: collision with root package name */
    public final zzczj f25380g;

    /* renamed from: c, reason: collision with root package name */
    public com.google.android.gms.ads.internal.util.client.zzu f25376c = null;

    /* renamed from: h, reason: collision with root package name */
    public com.google.android.gms.ads.internal.overlay.zzaa f25381h = null;

    /* renamed from: i, reason: collision with root package name */
    public final zzgyw f25382i = zzcdo.f25988g;

    public zzboa(com.google.android.gms.ads.internal.zzb zzbVar, zzbvx zzbvxVar, zzehu zzehuVar, zzdxe zzdxeVar, zzcra zzcraVar, zzczj zzczjVar) {
        this.f25374a = zzbVar;
        this.f25377d = zzbvxVar;
        this.f25378e = zzehuVar;
        this.f25375b = zzdxeVar;
        this.f25379f = zzcraVar;
        this.f25380g = zzczjVar;
    }

    public static int b(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    public static Uri c(Context context, zzayq zzayqVar, Uri uri, View view, Activity activity, zzfio zzfioVar) {
        if (zzayqVar != null) {
            try {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ed)).booleanValue() || zzfioVar == null) {
                    if (zzayqVar.c(uri)) {
                        return zzayqVar.b(uri, context, view, activity);
                    }
                } else if (zzayqVar.c(uri)) {
                    return zzfioVar.a(uri, context, view, activity);
                }
            } catch (zzayr unused) {
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("OpenGmsgHandler.maybeAddClickSignalsToUri", e2);
            }
        }
        return uri;
    }

    public static Uri d(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e2) {
            String strValueOf = String.valueOf(uri.toString());
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error adding click uptime parameter to url: ".concat(strValueOf), e2);
        }
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzcra zzcraVar;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String str = (String) map.get("u");
        HashMap map2 = new HashMap();
        zzcir zzcirVar = (zzcir) zzaVar;
        if (zzcirVar.v() != null) {
            map2 = zzcirVar.v().w0;
        }
        String strA = zzcby.a(str, zzcirVar.getContext(), true, map2);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.f25374a;
        if (zzbVar != null && !zzbVar.a()) {
            zzbVar.b(strA);
        } else {
            ListenableFuture listenableFutureA = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.hb)).booleanValue() && (zzcraVar = this.f25379f) != null && zzcra.b(strA)) ? zzcraVar.a(strA, com.google.android.gms.ads.internal.client.zzbb.f21141g.f21146e) : zzgym.a(strA);
            listenableFutureA.q(new zzgyk(listenableFutureA, new zzbnw(this, map, zzaVar, str2)), this.f25382i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(com.google.android.gms.internal.ads.zzbgk.A9)).booleanValue() != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e3, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(com.google.android.gms.internal.ads.zzbgk.v9)).booleanValue() : ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(com.google.android.gms.internal.ads.zzbgk.u9)).booleanValue()) != false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(com.google.android.gms.ads.internal.client.zza r11, android.content.Context r12, java.lang.String r13, java.lang.String r14) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzboa.e(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public final void f(Context context, String str, String str2) {
        zzehu zzehuVar = this.f25378e;
        zzehuVar.b(str);
        zzdxe zzdxeVar = this.f25375b;
        if (zzdxeVar != null) {
            zzgrz.a("dialog_not_shown_reason", str2);
            zzeif.Yb(context, zzdxeVar, zzehuVar, str, "dialog_not_shown", zzgvd.e(1, new Object[]{"dialog_not_shown_reason", str2}, null));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0156, code lost:
    
        r6 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(com.google.android.gms.ads.internal.client.zza r18, java.util.Map r19, boolean r20, java.lang.String r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzboa.g(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean, boolean):void");
    }

    public final void h(boolean z) {
        zzbvx zzbvxVar = this.f25377d;
        if (zzbvxVar != null) {
            zzbvxVar.f(z);
        }
    }

    public final void i(int i2) {
        zzdxe zzdxeVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.n5)).booleanValue() || (zzdxeVar = this.f25375b) == null) {
            return;
        }
        zzdxd zzdxdVarA = zzdxeVar.a();
        zzdxdVarA.b("action", "cct_action");
        switch (i2) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = "UNKNOWN";
                break;
            case 9:
                str = "WRONG_EXP_SETUP";
                break;
            default:
                str = "OPT_OUT";
                break;
        }
        zzdxdVarA.b("cct_open_status", str);
        zzdxdVarA.c();
    }
}
