package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hypersdk.core.PaymentConstants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzdmg implements zzdnu {
    public com.google.android.gms.ads.internal.client.zzdf C;
    public final zzdcz D;
    public final zzdon E;
    public final com.google.android.gms.ads.internal.zzb F;
    public final zzcze G;

    /* renamed from: a, reason: collision with root package name */
    public final Context f27937a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdnw f27938b;

    /* renamed from: c, reason: collision with root package name */
    public final JSONObject f27939c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdsp f27940d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdnm f27941e;

    /* renamed from: f, reason: collision with root package name */
    public final zzayq f27942f;

    /* renamed from: g, reason: collision with root package name */
    public final zzdbc f27943g;

    /* renamed from: h, reason: collision with root package name */
    public final zzdai f27944h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdip f27945i;

    /* renamed from: j, reason: collision with root package name */
    public final zzfhr f27946j;

    /* renamed from: k, reason: collision with root package name */
    public final VersionInfoParcel f27947k;

    /* renamed from: l, reason: collision with root package name */
    public final zzfik f27948l;

    /* renamed from: m, reason: collision with root package name */
    public final zzcrx f27949m;
    public final zzdor n;
    public final Clock o;
    public final zzdil p;
    public final zzfpi q;
    public final zzduf r;
    public final zzfno s;
    public final zzeif t;
    public boolean v;
    public boolean u = false;
    public boolean w = false;
    public boolean x = false;
    public Point y = new Point();
    public Point z = new Point();
    public long A = 0;
    public long B = 0;

    public zzdmg(Context context, zzdnw zzdnwVar, JSONObject jSONObject, zzdsp zzdspVar, zzdnm zzdnmVar, zzayq zzayqVar, zzdbc zzdbcVar, zzdai zzdaiVar, zzdip zzdipVar, zzfhr zzfhrVar, VersionInfoParcel versionInfoParcel, zzfik zzfikVar, zzcrx zzcrxVar, zzdor zzdorVar, Clock clock, zzdil zzdilVar, zzfpi zzfpiVar, zzfno zzfnoVar, zzeif zzeifVar, zzduf zzdufVar, zzdon zzdonVar, zzdcz zzdczVar, com.google.android.gms.ads.internal.zzb zzbVar, zzcze zzczeVar) {
        this.f27937a = context;
        this.f27938b = zzdnwVar;
        this.f27939c = jSONObject;
        this.f27940d = zzdspVar;
        this.f27941e = zzdnmVar;
        this.f27942f = zzayqVar;
        this.f27943g = zzdbcVar;
        this.f27944h = zzdaiVar;
        this.f27945i = zzdipVar;
        this.f27946j = zzfhrVar;
        this.f27947k = versionInfoParcel;
        this.f27948l = zzfikVar;
        this.f27949m = zzcrxVar;
        this.n = zzdorVar;
        this.o = clock;
        this.p = zzdilVar;
        this.q = zzfpiVar;
        this.s = zzfnoVar;
        this.t = zzeifVar;
        this.r = zzdufVar;
        this.E = zzdonVar;
        this.D = zzdczVar;
        this.F = zzbVar;
        this.G = zzczeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void B() {
        View view;
        if (this.f27939c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzdor zzdorVar = this.n;
            if (zzdorVar.f28126c == null || zzdorVar.f28129f == null) {
                return;
            }
            zzdorVar.f28128e = null;
            zzdorVar.f28129f = null;
            WeakReference weakReference = zzdorVar.f28130g;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                view.setClickable(false);
                view.setOnClickListener(null);
                zzdorVar.f28130g = null;
            }
            try {
                zzdorVar.f28126c.zzf();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void H() {
        zzdsp zzdspVar = this.f27940d;
        synchronized (zzdspVar) {
            ListenableFuture listenableFuture = zzdspVar.f28460m;
            if (listenableFuture == null) {
                return;
            }
            zzgym.k(listenableFuture, new zzdse(), zzdspVar.f28452e);
            zzdspVar.f28460m = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void W(Bundle bundle) throws JSONException {
        if (bundle == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Click data is null. No click is reported.");
            return;
        }
        if (!a("click_reporting")) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
            return;
        }
        Bundle bundle2 = bundle.getBundle("click_signal");
        JSONObject jSONObjectM = null;
        String string = bundle2 != null ? bundle2.getString("asset_id") : null;
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        zzfVar.getClass();
        try {
            jSONObjectM = zzfVar.m(bundle);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Error converting Bundle to JSON", e2);
        }
        i(null, null, null, null, null, string, null, jSONObjectM, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void X(View view) {
        if (!this.f27939c.optBoolean("custom_one_point_five_click_enabled", false)) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        } else {
            if (view == null) {
                return;
            }
            zzdor zzdorVar = this.n;
            view.setOnClickListener(zzdorVar);
            view.setClickable(true);
            zzdorVar.f28130g = new WeakReference(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void Y(String str) throws JSONException {
        i(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void Z(View view) {
        this.y = new Point();
        this.z = new Point();
        if (view != null) {
            zzdil zzdilVar = this.p;
            synchronized (zzdilVar) {
                WeakHashMap weakHashMap = zzdilVar.f27787b;
                if (weakHashMap.containsKey(view)) {
                    ((zzbcm) weakHashMap.get(view)).f24721l.remove(zzdilVar);
                    weakHashMap.remove(view);
                }
            }
        }
        this.v = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void Z0() throws JSONException {
        f(null, null, null, null, null, null, false, null);
    }

    public final boolean a(String str) {
        JSONObject jSONObjectOptJSONObject = this.f27939c.optJSONObject("allow_pub_event_reporting");
        return jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean(str, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void a0(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        com.google.android.gms.ads.internal.client.zzez zzezVar;
        com.google.android.gms.ads.internal.client.zzez zzezVar2;
        try {
            if (this.w) {
                return;
            }
            zzfno zzfnoVar = this.s;
            zzfhr zzfhrVar = this.f27946j;
            zzfpi zzfpiVar = this.q;
            if (zzdjVar == null) {
                zzdnm zzdnmVar = this.f27941e;
                synchronized (zzdnmVar) {
                    zzezVar = zzdnmVar.f28032g;
                }
                if (zzezVar != null) {
                    this.w = true;
                    synchronized (zzdnmVar) {
                        zzezVar2 = zzdnmVar.f28032g;
                    }
                    zzfpiVar.b(zzezVar2.f21225b, zzfhrVar.x0, zzfnoVar, null);
                    j();
                    return;
                }
            }
            this.w = true;
            zzfpiVar.b(zzdjVar.zzf(), zzfhrVar.x0, zzfnoVar, null);
            j();
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void b() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.f27939c);
            zzcdr.a(this.f27940d.a("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final JSONObject b0(View view, Map map, Map map2, ImageView.ScaleType scaleType) throws JSONException {
        JSONObject jSONObjectH0 = h0(view, map, map2, scaleType);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.x && this.f27939c.optBoolean("allow_custom_click_gesture", false)) {
                jSONObject.put("custom_click_gesture_eligible", true);
            }
            if (jSONObjectH0 != null) {
                jSONObject.put("nas", jSONObjectH0);
                return jSONObject;
            }
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to create native click meta data JSON.", e2);
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final int c() {
        zzbjn zzbjnVar = this.f27948l.f31222j;
        if (zzbjnVar == null) {
            return 0;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Gc)).booleanValue()) {
            return zzbjnVar.f25257i;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    @Override // com.google.android.gms.internal.ads.zzdnu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c0(android.view.View r17, android.view.View r18, java.util.Map r19, java.util.Map r20, boolean r21, android.widget.ImageView.ScaleType r22, int r23) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmg.c0(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean, android.widget.ImageView$ScaleType, int):void");
    }

    public final String d(View view, Map map) {
        if (map != null && view != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    return (String) entry.getKey();
                }
            }
        }
        int iQ = this.f27941e.q();
        if (iQ == 1) {
            return "1099";
        }
        if (iQ == 2) {
            return "2099";
        }
        if (iQ != 6) {
            return null;
        }
        return "3099";
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void d0(Bundle bundle) {
        if (bundle == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Touch event data is null. No touch event is reported.");
        } else {
            if (!a("touch_reporting")) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.c("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
                return;
            }
            this.f27942f.f24512b.b((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
            e();
        }
    }

    public final void e() {
        com.google.android.gms.ads.internal.zzb zzbVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Oe)).booleanValue() || (zzbVar = this.F) == null) {
            return;
        }
        zzbVar.f21624b = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final boolean e0(Bundle bundle) throws JSONException {
        JSONObject jSONObjectM;
        if (!a("impression_reporting")) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        zzfVar.getClass();
        if (bundle != null) {
            try {
                jSONObjectM = zzfVar.m(bundle);
            } catch (JSONException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.d("Error converting Bundle to JSON", e2);
            }
        } else {
            jSONObjectM = null;
        }
        return f(null, null, null, null, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Cc)).booleanValue() ? g(null) : null, jSONObjectM, false, null);
    }

    public final boolean f(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z, View view) throws JSONException {
        zzcze zzczeVar;
        zzfhr zzfhrVar = this.f27946j;
        Context context = this.f27937a;
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.f27939c);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            zzbgb zzbgbVar = zzbgk.h4;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            zzbgi zzbgiVar2 = zzbdVar.f21153c;
            if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            jSONObject6.put(PaymentConstants.Event.SCREEN, com.google.android.gms.ads.internal.util.zzbs.h(context));
            if (((Boolean) zzbgiVar2.a(zzbgk.Qe)).booleanValue() && (zzczeVar = this.G) != null) {
                AtomicLong atomicLong = zzczeVar.f27458a;
                if (atomicLong.get() > 0) {
                    jSONObject6.put("placement_id", atomicLong.get());
                }
            }
            boolean zBooleanValue = ((Boolean) zzbgiVar2.a(zzbgk.E9)).booleanValue();
            zzdsp zzdspVar = this.f27940d;
            if (zBooleanValue) {
                zzdspVar.b("/clickRecorded", new zzdmd(this));
            } else {
                zzdspVar.b("/logScionEvent", new zzdmc(this));
            }
            zzdspVar.b("/nativeImpression", new zzdme(this, view));
            zzdspVar.b("/nativeImpressionFlowControl", new zzdmf(this, this.q, zzfhrVar.x0, this.s));
            zzcdr.a(zzdspVar.a("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.u) {
                return true;
            }
            this.u = com.google.android.gms.ads.internal.zzt.C.o.d(context, this.f27947k.f21400a, zzfhrVar.C.toString(), this.f27948l.f31219g);
            return true;
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to create impression JSON.", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void f0(final zzblp zzblpVar) {
        if (!this.f27939c.optBoolean("custom_one_point_five_click_enabled", false)) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        final zzdor zzdorVar = this.n;
        zzdorVar.f28126c = zzblpVar;
        zzbnn zzbnnVar = zzdorVar.f28127d;
        zzdsp zzdspVar = zzdorVar.f28124a;
        if (zzbnnVar != null) {
            zzdspVar.c("/unconfirmedClick", zzbnnVar);
        }
        zzbnn zzbnnVar2 = new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdoq
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final /* synthetic */ void a(Object obj, Map map) {
                zzdor zzdorVar2 = zzdorVar;
                try {
                    zzdorVar2.f28129f = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.c("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzdorVar2.f28128e = (String) map.get(CLConstants.SHARED_PREFERENCE_ITEM_ID);
                String str = (String) map.get("asset_id");
                zzblp zzblpVar2 = zzblpVar;
                if (zzblpVar2 == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("Received unconfirmed click but UnconfirmedClickListener is null.");
                } else {
                    try {
                        zzblpVar2.q(str);
                    } catch (RemoteException e2) {
                        com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
                    }
                }
            }
        };
        zzdorVar.f28127d = zzbnnVar2;
        zzdspVar.b("/unconfirmedClick", zzbnnVar2);
    }

    public final String g(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h4)).booleanValue()) {
            return null;
        }
        try {
            return this.f27942f.f24512b.j(this.f27937a, view, null);
        } catch (Exception unused) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Exception getting data.");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void g0(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        this.C = zzdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final boolean h() {
        if (c() == 0) {
            return true;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Gc)).booleanValue()) {
            return this.f27948l.f31222j.f25258j;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final JSONObject h0(View view, Map map, Map map2, ImageView.ScaleType scaleType) throws JSONException {
        Context context = this.f27937a;
        JSONObject jSONObjectE = com.google.android.gms.ads.internal.util.zzbs.e(context, map, map2, view, scaleType);
        JSONObject jSONObjectB = com.google.android.gms.ads.internal.util.zzbs.b(context, view);
        JSONObject jSONObjectC = com.google.android.gms.ads.internal.util.zzbs.c(view);
        JSONObject jSONObjectD = com.google.android.gms.ads.internal.util.zzbs.d(context, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", jSONObjectE);
            jSONObject.put("ad_view_signal", jSONObjectB);
            jSONObject.put("scroll_view_signal", jSONObjectC);
            jSONObject.put("lock_screen_signal", jSONObjectD);
            return jSONObject;
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to create native ad view signals JSON.", e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(android.view.View r13, org.json.JSONObject r14, org.json.JSONObject r15, org.json.JSONObject r16, org.json.JSONObject r17, java.lang.String r18, org.json.JSONObject r19, org.json.JSONObject r20, boolean r21, boolean r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmg.i(android.view.View, org.json.JSONObject, org.json.JSONObject, org.json.JSONObject, org.json.JSONObject, java.lang.String, org.json.JSONObject, org.json.JSONObject, boolean, boolean):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void i0(View view, Map map, Map map2, zzdpj zzdpjVar, zzdpj zzdpjVar2) {
        this.y = new Point();
        this.z = new Point();
        if (!this.v) {
            this.p.w0(view);
            this.v = true;
        }
        view.setOnTouchListener(zzdpjVar);
        view.setClickable(true);
        view.setOnClickListener(zzdpjVar2);
        zzcrx zzcrxVar = this.f27949m;
        zzcrxVar.getClass();
        zzcrxVar.f27020j = new WeakReference(this);
        boolean zA = com.google.android.gms.ads.internal.util.zzbs.a(this.f27947k.f21402c);
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                if (view2 != null) {
                    if (zA) {
                        view2.setOnTouchListener(zzdpjVar);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(zzdpjVar2);
                }
            }
        }
        if (map2 != null) {
            Iterator it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                View view3 = (View) ((WeakReference) ((Map.Entry) it2.next()).getValue()).get();
                if (view3 != null) {
                    if (zA) {
                        view3.setOnTouchListener(zzdpjVar);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void j() {
        try {
            com.google.android.gms.ads.internal.client.zzdf zzdfVar = this.C;
            if (zzdfVar != null) {
                zzdfVar.zze();
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void j0(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) throws JSONException {
        Context context = this.f27937a;
        JSONObject jSONObjectE = com.google.android.gms.ads.internal.util.zzbs.e(context, map, map2, view2, scaleType);
        JSONObject jSONObjectB = com.google.android.gms.ads.internal.util.zzbs.b(context, view2);
        JSONObject jSONObjectC = com.google.android.gms.ads.internal.util.zzbs.c(view2);
        JSONObject jSONObjectD = com.google.android.gms.ads.internal.util.zzbs.d(context, view2);
        String strD = d(view, map);
        i(true == ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.o4)).booleanValue() ? view2 : view, jSONObjectB, jSONObjectE, jSONObjectC, jSONObjectD, strD, com.google.android.gms.ads.internal.util.zzbs.f(strD, context, this.z, this.y), null, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void k0(View view, Map map, Map map2, ImageView.ScaleType scaleType) throws JSONException {
        Context context = this.f27937a;
        JSONObject jSONObjectE = com.google.android.gms.ads.internal.util.zzbs.e(context, map, map2, view, scaleType);
        JSONObject jSONObjectB = com.google.android.gms.ads.internal.util.zzbs.b(context, view);
        JSONObject jSONObjectC = com.google.android.gms.ads.internal.util.zzbs.c(view);
        JSONObject jSONObjectD = com.google.android.gms.ads.internal.util.zzbs.d(context, view);
        boolean zG = com.google.android.gms.ads.internal.util.zzbs.g(context, this.f27946j);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.f27939c);
            jSONObject.put("asset_view_signal", jSONObjectE);
            jSONObject.put("ad_view_signal", jSONObjectB);
            jSONObject.put("scroll_view_signal", jSONObjectC);
            jSONObject.put("lock_screen_signal", jSONObjectD);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h4)).booleanValue()) {
                jSONObject.put("view_signals", g(view));
            }
            jSONObject.put("policy_validator_enabled", zG);
            jSONObject.put(PaymentConstants.Event.SCREEN, com.google.android.gms.ads.internal.util.zzbs.h(context));
            zzcdr.a(this.f27940d.a("google.afma.nativeAds.handleNativeAdSignalsLogging", jSONObject), "Error during performing handleNativeAdSignalsLogging");
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to create native ad signals logging JSON.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void l0(View view, Map map, Map map2, ImageView.ScaleType scaleType) throws JSONException {
        Context context = this.f27937a;
        f(com.google.android.gms.ads.internal.util.zzbs.b(context, view), com.google.android.gms.ads.internal.util.zzbs.e(context, map, map2, view, scaleType), com.google.android.gms.ads.internal.util.zzbs.c(view), com.google.android.gms.ads.internal.util.zzbs.d(context, view), g(view), null, com.google.android.gms.ads.internal.util.zzbs.g(context, this.f27946j), view);
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void m0(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        this.y = new Point(((int) motionEvent.getRawX()) - iArr[0], ((int) motionEvent.getRawY()) - iArr[1]);
        long jCurrentTimeMillis = this.o.currentTimeMillis();
        this.B = jCurrentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.r.f28591a = motionEvent;
            this.A = jCurrentTimeMillis;
            this.z = this.y;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        Point point = this.y;
        motionEventObtain.setLocation(point.x, point.y);
        this.f27942f.f24512b.f(motionEventObtain);
        motionEventObtain.recycle();
        e();
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void zzg() {
        this.x = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final boolean zzh() {
        return this.f27939c.optBoolean("allow_custom_click_gesture", false);
    }
}
