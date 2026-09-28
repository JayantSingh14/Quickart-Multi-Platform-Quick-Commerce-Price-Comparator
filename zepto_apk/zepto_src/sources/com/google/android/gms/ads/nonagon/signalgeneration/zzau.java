package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzayl;
import com.google.android.gms.internal.ads.zzayq;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzbip;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzbxq;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzccn;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzclg;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzdxj;
import com.google.android.gms.internal.ads.zzfio;
import com.google.android.gms.internal.ads.zzfjj;
import com.google.android.gms.internal.ads.zzfno;
import com.google.android.gms.internal.ads.zzfnr;
import com.google.android.gms.internal.ads.zzfpi;
import com.google.android.gms.internal.ads.zzgpr;
import com.google.android.gms.internal.ads.zzgqr;
import com.google.android.gms.internal.ads.zzgxf;
import com.google.android.gms.internal.ads.zzgxi;
import com.google.android.gms.internal.ads.zzgxt;
import com.google.android.gms.internal.ads.zzgxu;
import com.google.android.gms.internal.ads.zzgye;
import com.google.android.gms.internal.ads.zzgym;
import com.google.android.gms.internal.ads.zzgyw;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzau extends zzcci {
    public static final ArrayList H = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    public static final ArrayList I = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    public static final ArrayList J = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    public static final ArrayList K = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    public final ArrayList A;
    public final zzbhp E;
    public final zzo F;
    public final zzf G;

    /* renamed from: b, reason: collision with root package name */
    public final zzclg f21795b;

    /* renamed from: c, reason: collision with root package name */
    public Context f21796c;

    /* renamed from: d, reason: collision with root package name */
    public final zzayq f21797d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfio f21798e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfjj f21799f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgyw f21800g;

    /* renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f21801h;

    /* renamed from: i, reason: collision with root package name */
    public zzbxq f21802i;

    /* renamed from: l, reason: collision with root package name */
    public final zzdxj f21805l;

    /* renamed from: m, reason: collision with root package name */
    public final zzfpi f21806m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final String s;
    public final VersionInfoParcel u;
    public String v;
    public final String w;
    public final ArrayList x;
    public final ArrayList y;
    public final ArrayList z;

    /* renamed from: j, reason: collision with root package name */
    public Point f21803j = new Point();

    /* renamed from: k, reason: collision with root package name */
    public Point f21804k = new Point();
    public final AtomicInteger t = new AtomicInteger(0);
    public final AtomicBoolean B = new AtomicBoolean(false);
    public final AtomicBoolean C = new AtomicBoolean(false);
    public final AtomicInteger D = new AtomicInteger(0);

    public zzau(zzclg zzclgVar, Context context, zzayq zzayqVar, zzfjj zzfjjVar, zzgyw zzgywVar, ScheduledExecutorService scheduledExecutorService, zzdxj zzdxjVar, zzfpi zzfpiVar, VersionInfoParcel versionInfoParcel, zzbhp zzbhpVar, zzfio zzfioVar, zzo zzoVar, zzf zzfVar) {
        ArrayList arrayListFc;
        this.f21795b = zzclgVar;
        this.f21796c = context;
        this.f21797d = zzayqVar;
        this.f21798e = zzfioVar;
        this.f21799f = zzfjjVar;
        this.f21800g = zzgywVar;
        this.f21801h = scheduledExecutorService;
        this.f21805l = zzdxjVar;
        this.f21806m = zzfpiVar;
        this.u = versionInfoParcel;
        this.E = zzbhpVar;
        zzbgb zzbgbVar = zzbgk.U7;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        this.n = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        zzbgb zzbgbVar2 = zzbgk.T7;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        this.o = ((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue();
        this.p = ((Boolean) zzbgiVar.a(zzbgk.W7)).booleanValue();
        this.q = ((Boolean) zzbgiVar.a(zzbgk.Y7)).booleanValue();
        this.r = (String) zzbgiVar.a(zzbgk.X7);
        this.s = (String) zzbgiVar.a(zzbgk.Z7);
        this.w = (String) zzbgiVar.a(zzbgk.a8);
        this.F = zzoVar;
        this.G = zzfVar;
        if (((Boolean) zzbgiVar.a(zzbgk.b8)).booleanValue()) {
            this.x = fc((String) zzbgiVar.a(zzbgk.c8));
            this.y = fc((String) zzbgiVar.a(zzbgk.d8));
            this.z = fc((String) zzbgiVar.a(zzbgk.e8));
            arrayListFc = fc((String) zzbgiVar.a(zzbgk.f8));
        } else {
            this.x = H;
            this.y = I;
            this.z = J;
            arrayListFc = K;
        }
        this.A = arrayListFc;
    }

    public static boolean bc(Uri uri, ArrayList arrayList, ArrayList arrayList2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host == null || path == null) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (path.contains((String) it.next())) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    if (host.endsWith((String) it2.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final Uri ec(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl=");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl=");
        }
        if (iIndexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i2 = iIndexOf + 1;
        StringBuilder sb = new StringBuilder(string.substring(0, i2));
        b.B(sb, str, "=", str2, "&");
        sb.append(string.substring(i2));
        return Uri.parse(sb.toString());
    }

    public static final ArrayList fc(String str) {
        String[] strArrSplit = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (!zzgqr.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static zzfno gc(ListenableFuture listenableFuture, zzccn zzccnVar) {
        if (!zzfnr.a() || !((Boolean) zzbid.f25135e.c()).booleanValue()) {
            return null;
        }
        try {
            zzfno zzfnoVarB = ((zzac) zzgym.l(listenableFuture)).b();
            zzfnoVarB.b(new ArrayList(Collections.singletonList(zzccnVar.f25886b)));
            com.google.android.gms.ads.internal.client.zzm zzmVar = zzccnVar.f25888d;
            zzfnoVarB.c(zzmVar == null ? "" : zzmVar.p);
            zzfnoVarB.d(zzmVar.f21266m);
            return zzfnoVarB;
        } catch (ExecutionException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("SignalGeneratorImpl.getConfiguredCriticalUserJourney", e2);
            return null;
        }
    }

    public final void Xb(final ArrayList arrayList, final IObjectWrapper iObjectWrapper, zzbxn zzbxnVar, boolean z) {
        Map map;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.r8)).booleanValue()) {
            try {
                zzbxnVar.c0("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
                return;
            }
        }
        Callable callable = new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzai
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                zzau zzauVar = this.f21772a;
                zzayl zzaylVar = zzauVar.f21797d.f24512b;
                String strJ = zzaylVar != null ? zzaylVar.j(zzauVar.f21796c, (View) ObjectWrapper.z0(iObjectWrapper), null) : "";
                if (TextUtils.isEmpty(strJ)) {
                    throw new Exception("Failed to get view signals.");
                }
                ArrayList arrayList2 = new ArrayList();
                for (Uri uri : arrayList) {
                    if (zzau.bc(uri, zzauVar.z, zzauVar.A)) {
                        arrayList2.add(zzau.ec(uri, "ms", strJ));
                    } else {
                        String strValueOf = String.valueOf(uri);
                        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("Not a Google URL: ".concat(strValueOf));
                        arrayList2.add(uri);
                    }
                }
                if (arrayList2.isEmpty()) {
                    throw new Exception("Empty impression URLs result.");
                }
                return arrayList2;
            }
        };
        zzgxi zzgxiVar = (zzgxi) this.f21800g;
        ListenableFuture listenableFutureSubmit = zzgxiVar.submit(callable);
        zzbxq zzbxqVar = this.f21802i;
        if (zzbxqVar == null || (map = zzbxqVar.f25670b) == null || map.isEmpty()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Asset view map is empty.");
        } else {
            listenableFutureSubmit = zzgym.h(listenableFutureSubmit, new zzgxu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzak
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    final ArrayList arrayList2 = (ArrayList) obj;
                    final zzau zzauVar = this.f21777a;
                    return zzgym.i(zzauVar.dc("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzgpr() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzao
                        @Override // com.google.android.gms.internal.ads.zzgpr
                        public final Object apply(Object obj2) {
                            String str = (String) obj2;
                            zzau zzauVar2 = zzauVar;
                            zzauVar2.getClass();
                            ArrayList arrayList3 = new ArrayList();
                            for (Uri uri : arrayList2) {
                                if (!zzau.bc(uri, zzauVar2.z, zzauVar2.A) || TextUtils.isEmpty(str)) {
                                    arrayList3.add(uri);
                                } else {
                                    arrayList3.add(zzau.ec(uri, "nas", str));
                                }
                            }
                            return arrayList3;
                        }
                    }, zzauVar.f21800g);
                }
            }, zzgxiVar);
        }
        zzgym.k(listenableFutureSubmit, new zzae(this, zzbxnVar, z), this.f21795b.g());
    }

    public final void Yb(ArrayList arrayList, final IObjectWrapper iObjectWrapper, zzbxn zzbxnVar, boolean z) {
        ArrayList arrayList2;
        ArrayList arrayList3;
        ListenableFuture listenableFutureH;
        Map map;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.r8)).booleanValue()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("The updating URL feature is not enabled.");
            try {
                zzbxnVar.c0("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
                return;
            }
        }
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (true) {
            boolean zHasNext = it.hasNext();
            arrayList2 = this.y;
            arrayList3 = this.x;
            if (!zHasNext) {
                break;
            } else if (bc((Uri) it.next(), arrayList3, arrayList2)) {
                i3++;
            }
        }
        if (i3 > 1) {
            String strValueOf = String.valueOf(arrayList);
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Multiple google urls found: ".concat(strValueOf));
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final Uri uri = (Uri) it2.next();
            if (bc(uri, arrayList3, arrayList2)) {
                Callable callable = new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzal
                    @Override // java.util.concurrent.Callable
                    public final Object call() throws Exception {
                        zzfio zzfioVar;
                        Uri uriB = uri;
                        zzau zzauVar = this.f21778a;
                        zzauVar.getClass();
                        try {
                            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ed)).booleanValue();
                            IObjectWrapper iObjectWrapper2 = iObjectWrapper;
                            uriB = (!zBooleanValue || (zzfioVar = zzauVar.f21798e) == null) ? zzauVar.f21797d.b(uriB, zzauVar.f21796c, (View) ObjectWrapper.z0(iObjectWrapper2), null) : zzfioVar.a(uriB, zzauVar.f21796c, (View) ObjectWrapper.z0(iObjectWrapper2), null);
                        } catch (zzayr e3) {
                            int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.g("", e3);
                        }
                        if (uriB.getQueryParameter("ms") != null) {
                            return uriB;
                        }
                        throw new Exception("Failed to append spam signals to click url.");
                    }
                };
                zzgxi zzgxiVar = (zzgxi) this.f21800g;
                ListenableFuture listenableFutureSubmit = zzgxiVar.submit(callable);
                zzbxq zzbxqVar = this.f21802i;
                if (zzbxqVar == null || (map = zzbxqVar.f25670b) == null || map.isEmpty()) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.e("Asset view map is empty.");
                    listenableFutureH = listenableFutureSubmit;
                } else {
                    listenableFutureH = zzgym.h(listenableFutureSubmit, new zzgxu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzam
                        @Override // com.google.android.gms.internal.ads.zzgxu
                        public final /* synthetic */ ListenableFuture zza(Object obj) {
                            final Uri uri2 = (Uri) obj;
                            zzau zzauVar = this.f21781a;
                            return zzgym.i(zzauVar.dc("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzgpr() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzap
                                @Override // com.google.android.gms.internal.ads.zzgpr
                                public final /* synthetic */ Object apply(Object obj2) {
                                    String str = (String) obj2;
                                    ArrayList arrayList5 = zzau.H;
                                    boolean zIsEmpty = TextUtils.isEmpty(str);
                                    Uri uri3 = uri2;
                                    return !zIsEmpty ? zzau.ec(uri3, "nas", str) : uri3;
                                }
                            }, zzauVar.f21800g);
                        }
                    }, zzgxiVar);
                }
            } else {
                String strValueOf2 = String.valueOf(uri);
                int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Not a Google URL: ".concat(strValueOf2));
                listenableFutureH = zzgym.a(uri);
            }
            arrayList4.add(listenableFutureH);
        }
        zzgym.k(zzgym.j(arrayList4), new zzaf(this, zzbxnVar, z), this.f21795b.g());
    }

    public final void Zb() {
        zzbgb zzbgbVar = zzbgk.Ja;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.Ma)).booleanValue()) {
                return;
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.Qa)).booleanValue() && this.B.getAndSet(true)) {
                return;
            }
            ac();
        }
    }

    public final void ac() {
        zzau zzauVar;
        ListenableFuture listenableFutureA;
        if (((Boolean) zzbip.f25199e.c()).booleanValue()) {
            zzo zzoVar = this.F;
            synchronized (zzoVar) {
                zzoVar.c(true);
                zzoVar.c(false);
            }
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.jc)).booleanValue()) {
            listenableFutureA = zzgym.d(new zzgxt() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzan
                @Override // com.google.android.gms.internal.ads.zzgxt
                public final /* synthetic */ ListenableFuture zza() {
                    zzau zzauVar2 = this.f21782a;
                    return zzauVar2.cc(zzauVar2.f21796c, null, "BANNER", null, null, 0, null, new Bundle(), null).a();
                }
            }, zzcdo.f25982a);
            zzauVar = this;
        } else {
            zzauVar = this;
            listenableFutureA = zzauVar.cc(this.f21796c, null, "BANNER", null, null, 0, null, new Bundle(), null).a();
        }
        zzgym.k(listenableFutureA, new zzag(this), zzauVar.f21795b.g());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d5  */
    @Override // com.google.android.gms.internal.ads.zzccj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c6(com.google.android.gms.dynamic.IObjectWrapper r11, final com.google.android.gms.internal.ads.zzccn r12, com.google.android.gms.internal.ads.zzccg r13) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzau.c6(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzccn, com.google.android.gms.internal.ads.zzccg):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzac cc(android.content.Context r28, java.lang.String r29, java.lang.String r30, com.google.android.gms.ads.internal.client.zzr r31, com.google.android.gms.ads.internal.client.zzm r32, int r33, java.lang.String r34, android.os.Bundle r35, com.google.android.gms.internal.ads.zzccn r36) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzau.cc(android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.client.zzm, int, java.lang.String, android.os.Bundle, com.google.android.gms.internal.ads.zzccn):com.google.android.gms.ads.nonagon.signalgeneration.zzac");
    }

    public final zzgye dc(final String str) {
        final zzdsp[] zzdspVarArr = new zzdsp[1];
        ListenableFuture listenableFutureB = this.f21799f.b();
        zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzas
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) throws JSONException {
                zzdsp zzdspVar = (zzdsp) obj;
                zzau zzauVar = this.f21788a;
                zzauVar.getClass();
                zzdspVarArr[0] = zzdspVar;
                Context context = zzauVar.f21796c;
                zzbxq zzbxqVar = zzauVar.f21802i;
                Map map = zzbxqVar.f25670b;
                JSONObject jSONObjectE = com.google.android.gms.ads.internal.util.zzbs.e(context, map, map, zzbxqVar.f25669a, null);
                JSONObject jSONObjectB = com.google.android.gms.ads.internal.util.zzbs.b(zzauVar.f21796c, zzauVar.f21802i.f25669a);
                JSONObject jSONObjectC = com.google.android.gms.ads.internal.util.zzbs.c(zzauVar.f21802i.f25669a);
                JSONObject jSONObjectD = com.google.android.gms.ads.internal.util.zzbs.d(zzauVar.f21796c, zzauVar.f21802i.f25669a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("asset_view_signal", jSONObjectE);
                jSONObject.put("ad_view_signal", jSONObjectB);
                jSONObject.put("scroll_view_signal", jSONObjectC);
                jSONObject.put("lock_screen_signal", jSONObjectD);
                String str2 = str;
                if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str2)) {
                    jSONObject.put("click_signal", com.google.android.gms.ads.internal.util.zzbs.f(null, zzauVar.f21796c, zzauVar.f21804k, zzauVar.f21803j));
                }
                return zzdspVar.a(str2, jSONObject);
            }
        };
        zzgyw zzgywVar = this.f21800g;
        ListenableFuture listenableFutureH = zzgym.h(listenableFutureB, zzgxuVar, zzgywVar);
        ((zzgxf) listenableFutureH).q(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaj
            @Override // java.lang.Runnable
            public final void run() {
                zzau zzauVar = this.f21775a;
                zzauVar.getClass();
                zzdsp zzdspVar = zzdspVarArr[0];
                if (zzdspVar != null) {
                    ListenableFuture listenableFutureA = zzgym.a(zzdspVar);
                    zzfjj zzfjjVar = zzauVar.f21799f;
                    synchronized (zzfjjVar) {
                        zzfjjVar.f31271a.addFirst(listenableFutureA);
                    }
                }
            }
        }, zzgywVar);
        return (zzgye) zzgym.e((zzgye) zzgym.i((zzgye) zzgym.g(zzgye.s(listenableFutureH), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.s8)).intValue(), TimeUnit.MILLISECONDS, this.f21801h), zzaq.f21786a, zzgywVar), Exception.class, zzar.f21787a, zzgywVar);
    }

    public final void ua(IObjectWrapper iObjectWrapper) {
        zzbgb zzbgbVar = zzbgk.Ia;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzbgb zzbgbVar2 = zzbgk.i8;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (!((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue()) {
                Zb();
            }
            WebView webView = (WebView) ObjectWrapper.z0(iObjectWrapper);
            if (webView == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.c("The webView cannot be null.");
                return;
            }
            zzgyw zzgywVar = zzcdo.f25987f;
            zzf zzfVar = this.G;
            final zzj zzjVar = new zzj(webView, zzfVar, zzgywVar);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.f21797d, this.f21805l, this.f21806m, this.f21798e, this.F, zzfVar, zzjVar), "gmaSdk");
            if (((Boolean) zzbgiVar.a(zzbgk.Sa)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.f25942l.incrementAndGet();
            }
            if (((Boolean) zzbip.f25197c.c()).booleanValue()) {
                zzfVar.a(webView);
                if (((Boolean) zzbip.f25198d.c()).booleanValue()) {
                    ((ScheduledThreadPoolExecutor) zzcdo.f25985d).scheduleWithFixedDelay(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzi
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzj zzjVar2 = zzjVar;
                            zzjVar2.f21904c.execute(new zzh(zzjVar2));
                        }
                    }, 0L, ((Integer) zzbgiVar.a(zzbgk.Ta)).intValue(), TimeUnit.MILLISECONDS);
                }
            }
            if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue()) {
                Zb();
            }
        }
    }
}
