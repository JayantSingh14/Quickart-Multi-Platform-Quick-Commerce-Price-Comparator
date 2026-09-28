package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import in.juspay.hyperutil.constants.LogLevel;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzdwi implements zzdfm, com.google.android.gms.ads.internal.client.zza, zzdbe, zzdao, zzddf {

    /* renamed from: a, reason: collision with root package name */
    public final Context f28662a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfjd f28663b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdxe f28664c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfic f28665d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfhr f28666e;

    /* renamed from: f, reason: collision with root package name */
    public final zzehu f28667f;

    /* renamed from: g, reason: collision with root package name */
    public final String f28668g;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f28670i;

    /* renamed from: h, reason: collision with root package name */
    public long f28669h = -1;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f28672k = new AtomicBoolean(false);

    /* renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f28673l = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final boolean f28671j = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w7)).booleanValue();

    public zzdwi(Context context, zzfjd zzfjdVar, zzdxe zzdxeVar, zzfic zzficVar, zzfhr zzfhrVar, zzehu zzehuVar, String str) {
        this.f28662a = context;
        this.f28663b = zzfjdVar;
        this.f28664c = zzdxeVar;
        this.f28665d = zzficVar;
        this.f28666e = zzfhrVar;
        this.f28667f = zzehuVar;
        this.f28668g = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void a() {
        if (b()) {
            zzdxd zzdxdVarC = c("adapter_impression");
            zzdxdVarC.b("imp_type", String.valueOf(this.f28666e.f31153e));
            if (this.f28673l.get()) {
                zzdxdVarC.b("po", "1");
                zzdxdVarC.b("pil", String.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - this.f28669h));
            } else {
                zzdxdVarC.b("po", "0");
            }
            zzbgb zzbgbVar = zzbgk.Ie;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && t()) {
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                zzdxdVarC.b("foreground", true != com.google.android.gms.ads.internal.util.zzs.g(this.f28662a) ? "1" : "0");
                zzdxdVarC.b("fg_show", true != this.f28672k.get() ? "0" : "1");
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.Je)).booleanValue() && t()) {
                zzdxdVarC.b("fg_al", true == com.google.android.gms.ads.internal.zzt.C.f21683g.e() ? "1" : "0");
            }
            zzdxdVarC.c();
        }
    }

    public final boolean b() {
        String strQ;
        if (this.f28670i == null) {
            synchronized (this) {
                if (this.f28670i == null) {
                    String str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.O1);
                    com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                    try {
                        strQ = com.google.android.gms.ads.internal.util.zzs.Q(this.f28662a);
                    } catch (RemoteException unused) {
                        strQ = null;
                    }
                    boolean zMatches = false;
                    if (str != null && strQ != null) {
                        try {
                            zMatches = Pattern.matches(str, strQ);
                        } catch (RuntimeException e2) {
                            com.google.android.gms.ads.internal.zzt.C.f21684h.d("CsiActionsListener.isPatternMatched", e2);
                        }
                    }
                    this.f28670i = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.f28670i.booleanValue();
    }

    public final zzdxd c(String str) {
        zzfic zzficVar = this.f28665d;
        zzfib zzfibVar = zzficVar.f31194b;
        zzdxd zzdxdVarA = this.f28664c.a();
        zzdxdVarA.b("gqi", zzfibVar.f31190b.f31167b);
        zzfhr zzfhrVar = this.f28666e;
        zzdxdVarA.a(zzfhrVar);
        zzdxdVarA.b("action", str);
        zzdxdVarA.b("ad_format", this.f28668g.toUpperCase(Locale.ROOT));
        List list = zzfhrVar.t;
        if (!list.isEmpty()) {
            zzdxdVarA.b("ancn", (String) list.get(0));
        }
        if (zzfhrVar.b()) {
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            zzdxdVarA.b("device_connectivity", true != zztVar.f21684h.i(this.f28662a) ? "offline" : "online");
            zzdxdVarA.b("event_timestamp", String.valueOf(zztVar.f21687k.currentTimeMillis()));
            zzdxdVarA.b("offline_ad", "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.D7)).booleanValue()) {
            zzfhz zzfhzVar = zzficVar.f31193a;
            boolean z = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.e(zzfhzVar.f31185a) != 1;
            zzdxdVarA.b("scar", String.valueOf(z));
            if (z) {
                com.google.android.gms.ads.internal.client.zzm zzmVar = zzfhzVar.f31185a.f31216d;
                zzdxdVarA.b("ragent", zzmVar.p);
                zzdxdVarA.b("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzaa.a(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.b(zzmVar)));
            }
        }
        return zzdxdVarA;
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() {
        boolean zB = b();
        zzfhr zzfhrVar = this.f28666e;
        if (zB || zzfhrVar.b()) {
            zzdxd zzdxdVarC = c("impression");
            zzdxdVarC.b("imp_type", String.valueOf(zzfhrVar.f31153e));
            if (this.f28669h > 0) {
                zzdxdVarC.b("p_imp_l", String.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - this.f28669h));
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ie)).booleanValue() && t()) {
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                zzdxdVarC.b("foreground", true != com.google.android.gms.ads.internal.util.zzs.g(this.f28662a) ? "1" : "0");
                zzdxdVarC.b("fg_show", true == this.f28672k.get() ? "1" : "0");
            }
            g(zzdxdVarC);
        }
    }

    public final void g(zzdxd zzdxdVar) {
        if (!this.f28666e.b()) {
            zzdxdVar.c();
            return;
        }
        zzdxj zzdxjVar = zzdxdVar.f28728b.f28729a;
        zzehw zzehwVar = new zzehw(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis(), this.f28665d.f31194b.f31190b.f31167b, zzdxjVar.f28753f.a(zzdxdVar.f28727a), 2);
        zzehu zzehuVar = this.f28667f;
        zzehuVar.getClass();
        zzehuVar.a(new zzehr(zzehuVar, zzehwVar));
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        if (this.f28666e.b()) {
            g(c("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdao
    public final void j(zzdlg zzdlgVar) {
        if (this.f28671j) {
            zzdxd zzdxdVarC = c("ifts");
            zzdxdVarC.b("reason", LogLevel.EXCEPTION);
            if (!TextUtils.isEmpty(zzdlgVar.getMessage())) {
                zzdxdVarC.b("msg", zzdlgVar.getMessage());
            }
            zzdxdVarC.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    @Override // com.google.android.gms.internal.ads.zzdao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k1(com.google.android.gms.ads.internal.client.zze r5) {
        /*
            r4 = this;
            boolean r0 = r4.f28671j
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.String r0 = "ifts"
            com.google.android.gms.internal.ads.zzdxd r0 = r4.c(r0)
            java.lang.String r1 = "reason"
            java.lang.String r2 = "adapter"
            r0.b(r1, r2)
            int r1 = r5.f21161a
            java.lang.String r2 = r5.f21163c
            java.lang.String r3 = "com.google.android.gms.ads"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L2e
            com.google.android.gms.ads.internal.client.zze r2 = r5.f21164d
            if (r2 == 0) goto L2e
            java.lang.String r2 = r2.f21163c
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L2e
            com.google.android.gms.ads.internal.client.zze r5 = r5.f21164d
            int r1 = r5.f21161a
        L2e:
            java.lang.String r5 = r5.f21162b
            if (r1 < 0) goto L3b
            java.lang.String r2 = "arec"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.b(r2, r1)
        L3b:
            com.google.android.gms.internal.ads.zzfjd r1 = r4.f28663b
            java.util.regex.Pattern r1 = r1.f31264a
            if (r1 == 0) goto L53
            if (r5 != 0) goto L44
            goto L53
        L44:
            java.util.regex.Matcher r5 = r1.matcher(r5)
            boolean r1 = r5.find()
            if (r1 == 0) goto L53
            java.lang.String r5 = r5.group()
            goto L54
        L53:
            r5 = 0
        L54:
            if (r5 == 0) goto L5b
            java.lang.String r1 = "areec"
            r0.b(r1, r5)
        L5b:
            r0.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwi.k1(com.google.android.gms.ads.internal.client.zze):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void m() {
        if (b()) {
            c("adapter_shown").c();
        }
    }

    public final boolean t() {
        int i2 = this.f28666e.f31150b;
        return i2 == 2 || i2 == 5 || i2 == 6 || i2 == 7;
    }

    @Override // com.google.android.gms.internal.ads.zzdao
    public final void zze() {
        if (this.f28671j) {
            zzdxd zzdxdVarC = c("ifts");
            zzdxdVarC.b("reason", "blocked");
            zzdxdVarC.c();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddf
    public final void zzk() {
        if (b()) {
            this.f28673l.set(true);
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            this.f28669h = zztVar.f21687k.currentTimeMillis();
            zzdxd zzdxdVarC = c("presentation");
            zzbgb zzbgbVar = zzbgk.Ie;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && t()) {
                AtomicBoolean atomicBoolean = this.f28672k;
                atomicBoolean.set(!com.google.android.gms.ads.internal.util.zzs.g(this.f28662a));
                zzdxdVarC.b("foreground", true != atomicBoolean.get() ? "0" : "1");
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.Je)).booleanValue() && t()) {
                zzdxdVarC.b("fg_al", true != zztVar.f21683g.e() ? "0" : "1");
            }
            zzdxdVarC.c();
        }
    }
}
