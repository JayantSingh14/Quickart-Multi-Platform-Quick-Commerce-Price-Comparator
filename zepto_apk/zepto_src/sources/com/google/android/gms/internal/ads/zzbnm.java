package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbnm {

    /* renamed from: a, reason: collision with root package name */
    public static final zzbnn f25337a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final zzbnn f25338b = null;

    /* renamed from: c, reason: collision with root package name */
    public static final zzbnn f25339c = null;

    /* renamed from: f, reason: collision with root package name */
    public static final zzbnn f25342f = null;

    /* renamed from: i, reason: collision with root package name */
    public static final zzbnn f25345i = null;

    /* renamed from: d, reason: collision with root package name */
    public static final zzbnn f25340d = new zzbmu();

    /* renamed from: e, reason: collision with root package name */
    public static final zzbnn f25341e = new zzbmv();

    /* renamed from: g, reason: collision with root package name */
    public static final zzbnn f25343g = new zzbmw();

    /* renamed from: h, reason: collision with root package name */
    public static final zzbnn f25344h = new zzbmx();

    /* renamed from: j, reason: collision with root package name */
    public static final zzbnn f25346j = new zzbmy();

    /* renamed from: k, reason: collision with root package name */
    public static final zzbnn f25347k = new zzbmz();

    /* renamed from: l, reason: collision with root package name */
    public static final zzcgl f25348l = new zzcgl();

    /* renamed from: m, reason: collision with root package name */
    public static final zzcgm f25349m = new zzcgm();
    public static final zzbmg n = new zzbmg();
    public static final zzboe o = new zzboe();
    public static final zzbnn p = new zzbna();
    public static final zzbnn q = new zzbnb();
    public static final zzbnn r = new zzbmh();
    public static final zzbnn s = new zzbmi();
    public static final zzbnn t = new zzbmj();
    public static final zzbnn u = new zzbmk();
    public static final zzbnn v = new zzbml();
    public static final zzbnn w = new zzbmm();
    public static final zzbnn x = new zzbmn();
    public static final zzbnn y = new zzbmo();
    public static final zzbnn z = new zzbmp();
    public static final zzbnn A = new zzbmq();
    public static final zzbnn B = new zzbms();
    public static final zzbnn C = new zzbmt();

    public static ListenableFuture a(zzcir zzcirVar, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        zzcbw zzcbwVar;
        String strD;
        final String strReplace;
        Uri uriB = Uri.parse(str);
        try {
            zzayq zzayqVarD = zzcirVar.d();
            zzfio zzfioVarC = zzcirVar.C();
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ed)).booleanValue() || zzfioVarC == null) {
                if (zzayqVarD != null && zzayqVarD.a(uriB)) {
                    uriB = zzayqVarD.b(uriB, zzcirVar.getContext(), zzcirVar.x(), zzcirVar.zzj());
                }
            } else if (zzayqVarD != null && zzayqVarD.a(uriB)) {
                uriB = zzfioVarC.a(uriB, zzcirVar.getContext(), zzcirVar.x(), zzcirVar.zzj());
            }
        } catch (zzayr unused) {
            String strConcat = "Unable to append parameter to URL: ".concat(str);
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
        }
        HashMap map = new HashMap();
        if (zzcirVar.v() != null) {
            map = zzcirVar.v().w0;
        }
        Context context = zzcirVar.getContext();
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        if (zztVar.y.a(context) && (strD = (zzcbwVar = zztVar.y).d(context)) != null) {
            zzbgb zzbgbVar = zzbgk.F0;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            String str2 = (String) zzbdVar.f21153c.a(zzbgbVar);
            String string = uriB.toString();
            zzbgb zzbgbVar2 = zzbgk.E0;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue() && string.contains(str2)) {
                zzcbwVar.h(context, "_ac", strD, zzcbw.f((Map) map.get("_ac")));
                strReplace = zzcby.c(context, string).replace(str2, strD);
            } else if (!TextUtils.isEmpty(uriB.getQueryParameter("fbs_aeid")) || ((Boolean) zzbgiVar.a(zzbgk.D0)).booleanValue()) {
                strReplace = string;
            } else {
                String string2 = zzcby.b(zzcby.c(context, string), "fbs_aeid", strD).toString();
                zzcbwVar.h(context, "_ac", strD, zzcbw.f((Map) map.get("_ac")));
                strReplace = string2;
            }
        } else {
            strReplace = uriB.toString();
        }
        long jLongValue = ((Long) zzbij.f25170e.c()).longValue();
        if (jLongValue <= 0 || jLongValue > 254380000) {
            return zzgym.a(strReplace);
        }
        zzgye zzgyeVarS = zzgye.s(zzcirVar.J());
        zzbne zzbneVar = zzbne.f25327a;
        zzgyw zzgywVar = zzcdo.f25988g;
        return (zzgye) zzgym.e((zzgye) zzgym.i((zzgye) zzgym.e(zzgyeVarS, Throwable.class, zzbneVar, zzgywVar), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzbnf
            /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
            @Override // com.google.android.gms.internal.ads.zzgpr
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final /* synthetic */ java.lang.Object apply(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.String r6 = (java.lang.String) r6
                    com.google.android.gms.internal.ads.zzbnn r0 = com.google.android.gms.internal.ads.zzbnm.f25337a
                    java.lang.String r0 = r1
                    if (r6 != 0) goto L9
                    goto L74
                L9:
                    com.google.android.gms.internal.ads.zzbhu r1 = com.google.android.gms.internal.ads.zzbij.f25171f
                    java.lang.Object r1 = r1.c()
                    java.lang.Boolean r1 = (java.lang.Boolean) r1
                    boolean r1 = r1.booleanValue()
                    if (r1 != 0) goto L18
                    goto L39
                L18:
                    java.lang.String r1 = ".googlesyndication.com"
                    java.lang.String r2 = ".doubleclick.net"
                    java.lang.String r3 = ".googleadservices.com"
                    java.lang.String[] r1 = new java.lang.String[]{r2, r3, r1}
                    android.net.Uri r2 = android.net.Uri.parse(r0)
                    java.lang.String r2 = r2.getHost()
                    r3 = 0
                L2b:
                    r4 = 3
                    if (r3 >= r4) goto L74
                    r4 = r1[r3]
                    boolean r4 = r2.endsWith(r4)
                    if (r4 != 0) goto L39
                    int r3 = r3 + 1
                    goto L2b
                L39:
                    com.google.android.gms.internal.ads.zzbhu r1 = com.google.android.gms.internal.ads.zzbij.f25166a
                    java.lang.Object r1 = r1.c()
                    java.lang.String r1 = (java.lang.String) r1
                    com.google.android.gms.internal.ads.zzbhu r2 = com.google.android.gms.internal.ads.zzbij.f25167b
                    java.lang.Object r2 = r2.c()
                    java.lang.String r2 = (java.lang.String) r2
                    boolean r3 = android.text.TextUtils.isEmpty(r1)
                    if (r3 != 0) goto L53
                    java.lang.String r0 = r0.replace(r1, r6)
                L53:
                    boolean r1 = android.text.TextUtils.isEmpty(r2)
                    if (r1 != 0) goto L74
                    android.net.Uri r1 = android.net.Uri.parse(r0)
                    java.lang.String r3 = r1.getQueryParameter(r2)
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 == 0) goto L74
                    android.net.Uri$Builder r0 = r1.buildUpon()
                    android.net.Uri$Builder r6 = r0.appendQueryParameter(r2, r6)
                    java.lang.String r6 = r6.toString()
                    return r6
                L74:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnf.apply(java.lang.Object):java.lang.Object");
            }
        }, zzgywVar), Throwable.class, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzbng
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbnn zzbnnVar = zzbnm.f25337a;
                if (((Boolean) zzbij.f25174i.c()).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("prepareClickUrl.attestation2", th);
                }
                return strReplace;
            }
        }, zzgywVar);
    }

    public static void b(Map map, zzdir zzdirVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Rb)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("1") && zzdirVar != null) {
            zzdirVar.S();
        }
    }
}
