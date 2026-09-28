package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdnh extends zzcvk {
    public static final zzgtd J;
    public boolean A;
    public final zzcbt B;
    public final zzayq C;
    public final VersionInfoParcel D;
    public final Context E;
    public final zzdnj F;
    public final zzeqs G;
    public final HashMap H;
    public final ArrayList I;

    /* renamed from: l, reason: collision with root package name */
    public final Executor f28006l;

    /* renamed from: m, reason: collision with root package name */
    public final zzdnm f28007m;
    public final zzdnu n;
    public final zzdol o;
    public final zzdnr p;
    public final zzdnw q;
    public final zzija r;
    public final zzija s;
    public final zzija t;
    public final zzija u;
    public final zzija v;
    public zzbcc w;
    public boolean x;
    public boolean y;
    public boolean z;

    static {
        zzgvs zzgvsVar = zzgtd.f33183b;
        Object[] objArr = {"3010", "3008", "1005", "1009", "2011", "2007"};
        zzguw.a(6, objArr);
        J = zzgtd.t(6, objArr);
    }

    public zzdnh(zzcvj zzcvjVar, Executor executor, zzdnm zzdnmVar, zzdnu zzdnuVar, zzdol zzdolVar, zzdnr zzdnrVar, zzdnw zzdnwVar, zzija zzijaVar, zzija zzijaVar2, zzija zzijaVar3, zzija zzijaVar4, zzija zzijaVar5, zzcbt zzcbtVar, zzayq zzayqVar, VersionInfoParcel versionInfoParcel, Context context, zzdnj zzdnjVar, zzeqs zzeqsVar) {
        super(zzcvjVar);
        this.f28006l = executor;
        this.f28007m = zzdnmVar;
        this.n = zzdnuVar;
        this.o = zzdolVar;
        this.p = zzdnrVar;
        this.q = zzdnwVar;
        this.r = zzijaVar;
        this.s = zzijaVar2;
        this.t = zzijaVar3;
        this.u = zzijaVar4;
        this.v = zzijaVar5;
        this.B = zzcbtVar;
        this.C = zzayqVar;
        this.D = versionInfoParcel;
        this.E = context;
        this.F = zzdnjVar;
        this.G = zzeqsVar;
        this.H = new HashMap();
        this.I = new ArrayList();
    }

    public static boolean d(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Kb)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point());
        }
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        long jA = com.google.android.gms.ads.internal.util.zzs.a(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point())) {
            if (jA >= ((Integer) r1.f21153c.a(zzbgk.Lb)).intValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcvk
    public final void a() {
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdnf
            @Override // java.lang.Runnable
            public final void run() {
                zzdnh zzdnhVar = this.f28004a;
                zzdnhVar.getClass();
                try {
                    zzdnm zzdnmVar = zzdnhVar.f28007m;
                    int iQ = zzdnmVar.q();
                    zzdnw zzdnwVar = zzdnhVar.q;
                    if (iQ == 1) {
                        zzbkz zzbkzVar = zzdnwVar.f28058a;
                        if (zzbkzVar != null) {
                            zzdnhVar.m();
                            zzbkzVar.N2((zzbkp) zzdnhVar.r.zzb());
                            return;
                        }
                        return;
                    }
                    if (iQ == 2) {
                        zzbkw zzbkwVar = zzdnwVar.f28059b;
                        if (zzbkwVar != null) {
                            zzdnhVar.m();
                            zzbkwVar.o4((zzbkn) zzdnhVar.s.zzb());
                            return;
                        }
                        return;
                    }
                    if (iQ == 3) {
                        String strG = zzdnmVar.g();
                        zzblf zzblfVar = strG == null ? null : (zzblf) zzdnwVar.f28063f.get(strG);
                        if (zzblfVar != null) {
                            if (zzdnmVar.h() != null) {
                                zzdnhVar.e("Google", true);
                            }
                            zzblfVar.Na((zzbks) zzdnhVar.v.zzb());
                            return;
                        }
                        return;
                    }
                    if (iQ == 6) {
                        zzblm zzblmVar = zzdnwVar.f28060c;
                        if (zzblmVar != null) {
                            zzdnhVar.m();
                            zzblmVar.L2((zzbls) zzdnhVar.t.zzb());
                            return;
                        }
                        return;
                    }
                    if (iQ != 7) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.c("Wrong native template id!");
                    } else {
                        zzbqh zzbqhVar = zzdnwVar.f28062e;
                        if (zzbqhVar != null) {
                            zzbqhVar.tb((zzbqb) zzdnhVar.u.zzb());
                        }
                    }
                } catch (RemoteException e2) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("RemoteException when notifyAdLoad is called", e2);
                }
            }
        };
        Executor executor = this.f28006l;
        executor.execute(runnable);
        if (this.f28007m.q() != 7) {
            final zzdnu zzdnuVar = this.n;
            Objects.requireNonNull(zzdnuVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdng
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzdnuVar.b();
                }
            });
        }
        super.a();
    }

    public final synchronized void c(final int i2, final View view) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Gc)).booleanValue()) {
            zzbcc zzbccVar = this.w;
            if (zzbccVar == null) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                final boolean z = zzbccVar instanceof zzdof;
                this.f28006l.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdnd
                    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
                    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzdnh zzdnhVar = this.f27998a;
                        ?? r1 = zzdnhVar.w;
                        if (r1 == 0) {
                            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.a("Ad should be associated with an ad view before calling performClickForCustomGesture()");
                            return;
                        }
                        View viewZ8 = r1.Z8();
                        Map mapZzj = zzdnhVar.w.zzj();
                        Map mapZzk = zzdnhVar.w.zzk();
                        ImageView.ScaleType scaleTypeL = zzdnhVar.l();
                        zzdnhVar.n.c0(view, viewZ8, mapZzj, mapZzk, z, scaleTypeL, i2);
                    }
                });
            }
        }
    }

    public final zzejb e(final String str, boolean z) {
        boolean z2;
        final String str2;
        zzeix zzeixVar;
        zzeiy zzeiyVar;
        zzdnr zzdnrVar = this.p;
        if (zzdnrVar.c() && !TextUtils.isEmpty(str)) {
            zzdnm zzdnmVar = this.f28007m;
            zzcir zzcirVarJ = zzdnmVar.j();
            zzcir zzcirVarH = zzdnmVar.h();
            if (zzcirVarJ == null && zzcirVarH == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Omid display and video webview are null. Skipping initialization.");
                return null;
            }
            zzdnrVar.f();
            int iA = zzdnrVar.f().a();
            int i3 = iA - 1;
            boolean z3 = false;
            if (i3 != 0) {
                if (i3 != 1) {
                    String str3 = iA != 1 ? iA != 2 ? "UNKNOWN" : "DISPLAY" : "VIDEO";
                    String strS = android.support.v4.media.b.s(new StringBuilder(str3.length() + 49), "Unknown omid media type: ", str3, ". Not initializing Omid.");
                    int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f(strS);
                    return null;
                }
                if (zzcirVarJ == null) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Omid media type was display but there was no display webview.");
                    return null;
                }
                z2 = false;
                z3 = true;
            } else if (zzcirVarH != null) {
                z2 = true;
            } else {
                int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Omid media type was video but there was no video webview.");
            }
            if (z3) {
                str2 = null;
            } else {
                str2 = "javascript";
                zzcirVarJ = zzcirVarH;
            }
            if (zzcirVarJ == null) {
                int i7 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Webview is null in InternalNativeAd");
                return null;
            }
            Context context = this.E;
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            if (!zztVar.x.a(context)) {
                int i8 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Failed to initialize omid in InternalNativeAd");
                return null;
            }
            VersionInfoParcel versionInfoParcel = this.D;
            int i9 = versionInfoParcel.f21401b;
            int i10 = versionInfoParcel.f21402c;
            StringBuilder sb = new StringBuilder(androidx.fragment.app.e.a(i9, 1) + String.valueOf(i10).length());
            sb.append(i9);
            sb.append(CLConstants.DOT_SALT_DELIMETER);
            sb.append(i10);
            final String string = sb.toString();
            if (z2) {
                zzeixVar = zzeix.VIDEO;
                zzeiyVar = zzeiy.DEFINED_BY_JAVASCRIPT;
            } else {
                zzeixVar = zzeix.NATIVE_DISPLAY;
                zzeiyVar = zzdnmVar.q() == 3 ? zzeiy.UNSPECIFIED : zzeiy.ONE_PIXEL;
            }
            final zzeix zzeixVar2 = zzeixVar;
            final zzeiy zzeiyVar2 = zzeiyVar;
            zzeiv zzeivVar = zztVar.x;
            final WebView webViewK = zzcirVarJ.k();
            final String str4 = this.f27228b.l0;
            zzeivVar.getClass();
            zzejb zzejbVar = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.V5)).booleanValue() && zzfrf.f31700a.f31701a) ? (zzejb) zzeiv.i(new zzeiu() { // from class: com.google.android.gms.internal.ads.zzeim
                @Override // com.google.android.gms.internal.ads.zzeiu
                public final Object zza() {
                    String str5 = str;
                    if (TextUtils.isEmpty(str5)) {
                        throw new IllegalArgumentException("Name is null or empty");
                    }
                    String str6 = string;
                    if (TextUtils.isEmpty(str6)) {
                        throw new IllegalArgumentException("Version is null or empty");
                    }
                    zzfrv zzfrvVar = new zzfrv(str5, str6);
                    zzfru zzfruVarF = zzeiv.f("javascript");
                    String str7 = str2;
                    zzfru zzfruVarF2 = zzeiv.f(str7);
                    zzeix zzeixVar3 = zzeixVar2;
                    zzfrm zzfrmVarH = zzeiv.h(zzeixVar3.f29435a);
                    zzfru zzfruVar = zzfru.NONE;
                    if (zzfruVarF == zzfruVar) {
                        int i11 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Omid js session error; Unable to parse impression owner: javascript");
                        return null;
                    }
                    if (zzfrmVarH == null) {
                        String strValueOf = String.valueOf(zzeixVar3);
                        int i12 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Omid js session error; Unable to parse creative type: ".concat(strValueOf));
                        return null;
                    }
                    if (zzfrmVarH == zzfrm.VIDEO && zzfruVarF2 == zzfruVar) {
                        String strValueOf2 = String.valueOf(str7);
                        int i13 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Omid js session error; Video events owner unknown for video creative: ".concat(strValueOf2));
                        return null;
                    }
                    zzfrj zzfrjVar = new zzfrj(zzfrvVar, webViewK, str4, "", zzfrk.JAVASCRIPT);
                    zzfri zzfriVarA = zzfri.a(zzfrmVarH, zzeiv.g(zzeiyVar2.f29441a), zzfruVarF, zzfruVarF2, true);
                    if (zzfrf.f31700a.f31701a) {
                        return new zzejb(new zzfrl(zzfriVarA, zzfrjVar, UUID.randomUUID().toString()), zzfrjVar);
                    }
                    throw new IllegalStateException("Method called before OM SDK activation");
                }
            }) : null;
            if (zzejbVar == null) {
                int i11 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Failed to create omid session in InternalNativeAd");
                return null;
            }
            synchronized (zzdnmVar) {
                zzdnmVar.f28037l = zzejbVar;
            }
            zzcirVarJ.r0(zzejbVar);
            if (z2) {
                zzfrl zzfrlVar = zzejbVar.f29453a;
                if (zzcirVarH != null) {
                    zztVar.x.e(zzfrlVar, zzcirVarH.x());
                }
                this.A = true;
            }
            if (z) {
                zztVar.x.c(zzejbVar.f29453a);
                zzcirVarJ.g("onSdkLoaded", new ArrayMap());
            }
            return zzejbVar;
        }
        return null;
    }

    public final void f(View view) {
        zzcdt zzcdtVar;
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.c6)).booleanValue();
        zzdnm zzdnmVar = this.f28007m;
        if (!zBooleanValue || zzdnmVar.q() == 3) {
            n(view, zzdnmVar.k());
            return;
        }
        synchronized (zzdnmVar) {
            zzcdtVar = zzdnmVar.n;
        }
        if (zzcdtVar == null) {
            return;
        }
        zzdmy zzdmyVar = new zzdmy(this, view);
        zzcdtVar.q(new zzgyk(zzcdtVar, zzdmyVar), this.f28006l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    public final synchronized void g(final zzdpj zzdpjVar) {
        Iterator<String> itKeys;
        View view;
        zzayl zzaylVar;
        try {
            if (!this.x) {
                this.w = (zzbcc) zzdpjVar;
                final zzdol zzdolVar = this.o;
                zzdolVar.f28106g.execute(new Runnable(zzdpjVar) { // from class: com.google.android.gms.internal.ads.zzdok

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ zzbcc f28098b;

                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.f28098b = (zzbcc) zzdpjVar;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:112:0x027a  */
                    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void run() {
                        /*
                            Method dump skipped, instructions count: 666
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdok.run():void");
                    }
                });
                this.n.i0(zzdpjVar.Z8(), zzdpjVar.zzk(), zzdpjVar.zzl(), zzdpjVar, zzdpjVar);
                zzbgb zzbgbVar = zzbgk.f3;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && (zzaylVar = this.C.f24512b) != null) {
                    zzaylVar.i(zzdpjVar.Z8());
                }
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.f2)).booleanValue()) {
                    zzfhr zzfhrVar = this.f27228b;
                    if (zzfhrVar.k0 && (itKeys = zzfhrVar.j0.keys()) != null) {
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            ?? r2 = this.w;
                            WeakReference weakReference = r2 == 0 ? null : (WeakReference) r2.zzj().get(next);
                            this.H.put(next, Boolean.FALSE);
                            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                                zzbcm zzbcmVar = new zzbcm(this.E, view);
                                this.I.add(zzbcmVar);
                                zzbcmVar.f24721l.add(new zzdmw(this, next));
                                zzbcmVar.d(3);
                            }
                        }
                    }
                }
                if (zzdpjVar.zzh() != null) {
                    zzbcm zzbcmVarZzh = zzdpjVar.zzh();
                    zzbcmVarZzh.f24721l.add(this.B);
                    zzbcmVarZzh.d(3);
                }
            }
        } finally {
        }
    }

    public final void h(zzdpj zzdpjVar) {
        View viewZ8 = zzdpjVar.Z8();
        zzdpjVar.zzj();
        this.n.Z(viewZ8);
        if (zzdpjVar.p6() != null) {
            zzdpjVar.p6().setClickable(false);
            zzdpjVar.p6().removeAllViews();
        }
        if (zzdpjVar.zzh() != null) {
            zzbcm zzbcmVarZzh = zzdpjVar.zzh();
            zzbcmVarZzh.f24721l.remove(this.B);
        }
        this.w = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    public final synchronized void i(View view, Map map, Map map2) {
        this.o.a(this.w);
        this.n.l0(view, map, map2, l());
        this.y = true;
    }

    public final synchronized void j(View view, Map map, Map map2) {
        View viewK;
        if (!this.z && (viewK = k(map)) != null) {
            zzbgb zzbgbVar = zzbgk.Le;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                Rect rect = new Rect();
                if (viewK.getGlobalVisibleRect(rect, new Point()) && viewK.getHeight() == rect.height() && viewK.getWidth() == rect.width()) {
                    this.n.k0(view, map, map2, l());
                    this.z = true;
                }
            } else if (!((Boolean) zzbdVar.f21153c.a(zzbgk.Me)).booleanValue()) {
                zzbgb zzbgbVar2 = zzbgk.Ne;
                if (((Float) zzbdVar.f21153c.a(zzbgbVar2)).floatValue() > 0.0d) {
                    double dFloatValue = ((Float) zzbdVar.f21153c.a(zzbgbVar2)).floatValue();
                    if (viewK.getGlobalVisibleRect(new Rect(), new Point())) {
                        if (r4.height() * r4.width() >= viewK.getHeight() * viewK.getWidth() * (dFloatValue / 100.0d)) {
                            this.n.k0(view, map, map2, l());
                            this.z = true;
                        }
                    }
                }
            } else if (d(viewK)) {
                this.n.k0(view, map, map2, l());
                this.z = true;
            }
        }
    }

    public final synchronized View k(Map map) {
        if (map != null) {
            zzgtd zzgtdVar = J;
            int i2 = ((zzguy) zzgtdVar).f33234d;
            int i3 = 0;
            while (i3 < i2) {
                WeakReference weakReference = (WeakReference) map.get((String) ((zzguy) zzgtdVar).get(i3));
                i3++;
                if (weakReference != null) {
                    return (View) weakReference.get();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    public final synchronized ImageView.ScaleType l() {
        ?? r0 = this.w;
        if (r0 == 0) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper iObjectWrapperZzo = r0.zzo();
        if (iObjectWrapperZzo != null) {
            return (ImageView.ScaleType) ObjectWrapper.z0(iObjectWrapperZzo);
        }
        return zzdol.f28099k;
    }

    public final void m() {
        ListenableFuture listenableFuture;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.c6)).booleanValue()) {
            e("Google", true);
            return;
        }
        zzdnm zzdnmVar = this.f28007m;
        synchronized (zzdnmVar) {
            listenableFuture = zzdnmVar.f28038m;
        }
        if (listenableFuture == null) {
            return;
        }
        zzdmx zzdmxVar = new zzdmx(this);
        listenableFuture.q(new zzgyk(listenableFuture, zzdmxVar), this.f28006l);
    }

    public final void n(View view, zzejb zzejbVar) {
        zzcir zzcirVarJ = this.f28007m.j();
        if (!this.p.c() || zzejbVar == null || zzcirVarJ == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.C.x.e(zzejbVar.f29453a, view);
    }

    public final synchronized void o() {
        this.x = true;
        this.f28006l.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmz
            @Override // java.lang.Runnable
            public final void run() {
                zzdnh zzdnhVar = this.f27990a;
                zzdnhVar.n.H();
                zzdnm zzdnmVar = zzdnhVar.f28007m;
                synchronized (zzdnmVar) {
                    try {
                        zzcir zzcirVar = zzdnmVar.f28034i;
                        if (zzcirVar != null) {
                            zzcirVar.destroy();
                            zzdnmVar.f28034i = null;
                        }
                        zzcir zzcirVar2 = zzdnmVar.f28035j;
                        if (zzcirVar2 != null) {
                            zzcirVar2.destroy();
                            zzdnmVar.f28035j = null;
                        }
                        zzcir zzcirVar3 = zzdnmVar.f28036k;
                        if (zzcirVar3 != null) {
                            zzcirVar3.destroy();
                            zzdnmVar.f28036k = null;
                        }
                        ListenableFuture listenableFuture = zzdnmVar.f28038m;
                        if (listenableFuture != null) {
                            listenableFuture.cancel(false);
                            zzdnmVar.f28038m = null;
                        }
                        zzcdt zzcdtVar = zzdnmVar.n;
                        if (zzcdtVar != null) {
                            zzcdtVar.cancel(false);
                            zzdnmVar.n = null;
                        }
                        zzdnmVar.f28037l = null;
                        zzdnmVar.v.clear();
                        zzdnmVar.w.clear();
                        zzdnmVar.f28027b = null;
                        zzdnmVar.f28028c = null;
                        zzdnmVar.f28029d = null;
                        zzdnmVar.f28030e = null;
                        zzdnmVar.f28033h = null;
                        zzdnmVar.o = null;
                        zzdnmVar.p = null;
                        zzdnmVar.q = null;
                        zzdnmVar.s = null;
                        zzdnmVar.t = null;
                        zzdnmVar.u = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        zzdbj zzdbjVar = this.f27229c;
        zzdbjVar.getClass();
        zzdbjVar.v0(new zzdbh(null));
    }

    public final synchronized boolean p(Bundle bundle) {
        if (this.y) {
            return true;
        }
        boolean zE0 = this.n.e0(bundle);
        this.y = zE0;
        return zE0;
    }

    public final synchronized void q(final zzdpj zzdpjVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.d2)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable(zzdpjVar) { // from class: com.google.android.gms.internal.ads.zzdna

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ zzbcc f27993b;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f27993b = (zzbcc) zzdpjVar;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f27992a.g(this.f27993b);
                }
            });
        } else {
            g(zzdpjVar);
        }
    }

    public final synchronized void r(final zzdpj zzdpjVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.d2)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable(zzdpjVar) { // from class: com.google.android.gms.internal.ads.zzdnb

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ zzbcc f27995b;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f27995b = (zzbcc) zzdpjVar;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f27994a.h(this.f27995b);
                }
            });
        } else {
            h(zzdpjVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x0059, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000b, B:10:0x0012, B:12:0x001a, B:15:0x0027, B:16:0x002c, B:18:0x003e, B:21:0x0047, B:23:0x004d), top: B:32:0x0001, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void s(android.view.View r8, android.view.View r9, java.util.Map r10, java.util.Map r11, boolean r12) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.google.android.gms.internal.ads.zzdol r0 = r7.o     // Catch: java.lang.Throwable -> L59
            com.google.android.gms.internal.ads.zzbcc r1 = r7.w     // Catch: java.lang.Throwable -> L59
            if (r1 == 0) goto L2c
            com.google.android.gms.internal.ads.zzdoz r2 = r0.f28104e     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L2c
            android.widget.FrameLayout r3 = r1.p6()     // Catch: java.lang.Throwable -> L59
            if (r3 != 0) goto L12
            goto L2c
        L12:
            com.google.android.gms.internal.ads.zzdnr r0 = r0.f28102c     // Catch: java.lang.Throwable -> L59
            boolean r0 = r0.a()     // Catch: java.lang.Throwable -> L59
            if (r0 == 0) goto L2c
            android.widget.FrameLayout r0 = r1.p6()     // Catch: com.google.android.gms.internal.ads.zzcjg -> L26 java.lang.Throwable -> L59
            android.view.View r1 = r2.a()     // Catch: com.google.android.gms.internal.ads.zzcjg -> L26 java.lang.Throwable -> L59
            r0.addView(r1)     // Catch: com.google.android.gms.internal.ads.zzcjg -> L26 java.lang.Throwable -> L59
            goto L2c
        L26:
            r0 = move-exception
            java.lang.String r1 = "web view can not be obtained"
            com.google.android.gms.ads.internal.util.zze.l(r1, r0)     // Catch: java.lang.Throwable -> L59
        L2c:
            android.widget.ImageView$ScaleType r6 = r7.l()     // Catch: java.lang.Throwable -> L59
            com.google.android.gms.internal.ads.zzdnu r0 = r7.n     // Catch: java.lang.Throwable -> L59
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.j0(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L59
            boolean r8 = r7.A     // Catch: java.lang.Throwable -> L59
            if (r8 == 0) goto L5c
            com.google.android.gms.internal.ads.zzdnm r8 = r7.f28007m     // Catch: java.lang.Throwable -> L59
            com.google.android.gms.internal.ads.zzcir r9 = r8.h()     // Catch: java.lang.Throwable -> L59
            if (r9 != 0) goto L47
            goto L5c
        L47:
            com.google.android.gms.internal.ads.zzcir r8 = r8.h()     // Catch: java.lang.Throwable -> L59
            if (r8 == 0) goto L5c
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap     // Catch: java.lang.Throwable -> L59
            r9.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r10 = "onSdkAdUserInteractionClick"
            r8.g(r10, r9)     // Catch: java.lang.Throwable -> L59
            monitor-exit(r7)
            return
        L59:
            r0 = move-exception
            r8 = r0
            goto L5e
        L5c:
            monitor-exit(r7)
            return
        L5e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L59
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdnh.s(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[Catch: all -> 0x000a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:12:0x001f, B:14:0x0025, B:15:0x002f, B:17:0x0035, B:21:0x004a, B:24:0x005e, B:25:0x0066, B:27:0x006c, B:29:0x0080, B:31:0x0086, B:36:0x008d), top: B:41:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[Catch: all -> 0x000a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:12:0x001f, B:14:0x0025, B:15:0x002f, B:17:0x0035, B:21:0x004a, B:24:0x005e, B:25:0x0066, B:27:0x006c, B:29:0x0080, B:31:0x0086, B:36:0x008d), top: B:41:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void t(android.view.View r4, java.util.Map r5, java.util.Map r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.y     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto Ld
            r3.j(r4, r5, r6)     // Catch: java.lang.Throwable -> La
            monitor-exit(r3)
            return
        La:
            r4 = move-exception
            goto L95
        Ld:
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.f2     // Catch: java.lang.Throwable -> La
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> La
            com.google.android.gms.internal.ads.zzbgi r1 = r1.f21153c     // Catch: java.lang.Throwable -> La
            java.lang.Object r0 = r1.a(r0)     // Catch: java.lang.Throwable -> La
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> La
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L48
            com.google.android.gms.internal.ads.zzfhr r0 = r3.f27228b     // Catch: java.lang.Throwable -> La
            boolean r0 = r0.k0     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L48
            java.util.HashMap r0 = r3.H     // Catch: java.lang.Throwable -> La
            java.util.Set r1 = r0.keySet()     // Catch: java.lang.Throwable -> La
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> La
        L2f:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> La
            if (r2 == 0) goto L48
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> La
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> La
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> La
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> La
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> La
            if (r2 != 0) goto L2f
            goto L8b
        L48:
            if (r7 != 0) goto L8d
            com.google.android.gms.internal.ads.zzbgb r7 = com.google.android.gms.internal.ads.zzbgk.A4     // Catch: java.lang.Throwable -> La
            com.google.android.gms.ads.internal.client.zzbd r0 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> La
            com.google.android.gms.internal.ads.zzbgi r0 = r0.f21153c     // Catch: java.lang.Throwable -> La
            java.lang.Object r7 = r0.a(r7)     // Catch: java.lang.Throwable -> La
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> La
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> La
            if (r7 == 0) goto L8b
            if (r5 == 0) goto L8b
            java.util.Set r7 = r5.entrySet()     // Catch: java.lang.Throwable -> La
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> La
        L66:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L8b
            java.lang.Object r0 = r7.next()     // Catch: java.lang.Throwable -> La
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> La
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> La
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch: java.lang.Throwable -> La
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> La
            android.view.View r0 = (android.view.View) r0     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L66
            boolean r0 = d(r0)     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L66
            r3.i(r4, r5, r6)     // Catch: java.lang.Throwable -> La
            monitor-exit(r3)
            return
        L8b:
            monitor-exit(r3)
            return
        L8d:
            r3.i(r4, r5, r6)     // Catch: java.lang.Throwable -> La
            r3.j(r4, r5, r6)     // Catch: java.lang.Throwable -> La
            monitor-exit(r3)
            return
        L95:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdnh.t(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }
}
