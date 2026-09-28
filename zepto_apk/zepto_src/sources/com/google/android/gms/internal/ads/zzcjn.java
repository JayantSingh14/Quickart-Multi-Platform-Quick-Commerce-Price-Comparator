package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcjn extends FrameLayout implements zzcir {

    /* renamed from: a, reason: collision with root package name */
    public final zzcir f26410a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcez f26411b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f26412c;

    /* JADX WARN: Multi-variable type inference failed */
    public zzcjn(zzcir zzcirVar, zzdxe zzdxeVar) {
        super(((View) zzcirVar).getContext());
        this.f26412c = new AtomicBoolean();
        this.f26410a = zzcirVar;
        this.f26411b = new zzcez(((zzcju) zzcirVar).f26423a.f26471c, this, this, zzdxeVar);
        addView((View) zzcirVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final com.google.android.gms.ads.internal.overlay.zzm A() {
        return this.f26410a.A();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean B() {
        return this.f26412c.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void B0() {
        this.f26410a.B0();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final zzfio C() {
        return this.f26410a.C();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void C0(boolean z) {
        this.f26410a.C0(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean D() {
        return this.f26410a.D();
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void D0() {
        this.f26410a.D0();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final zzbjl E() {
        return this.f26410a.E();
    }

    public final void E0() {
        zzcez zzcezVar = this.f26411b;
        zzcezVar.getClass();
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcey zzceyVar = zzcezVar.f26055e;
        if (zzceyVar != null) {
            zzceyVar.f26042e.a();
            zzceq zzceqVar = zzceyVar.f26044g;
            if (zzceqVar != null) {
                zzceqVar.l();
            }
            zzceyVar.d();
            zzcezVar.f26053c.removeView(zzcezVar.f26055e);
            zzcezVar.f26055e = null;
        }
        ((zzcju) this.f26410a).F0();
    }

    @Override // com.google.android.gms.internal.ads.zzckh
    public final void F(int i2, boolean z, boolean z2) {
        this.f26410a.F(i2, z, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean G() {
        return this.f26410a.G();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void H() {
        ((zzcju) this.f26410a).H();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final zzbdx I() {
        return this.f26410a.I();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final ListenableFuture J() {
        return this.f26410a.J();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void K(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.f26410a.K(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final zzejb L() {
        return this.f26410a.L();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void M(String str, String str2) {
        ((zzcju) this.f26410a).M(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void N(Context context) {
        this.f26410a.N(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final Context O() {
        return this.f26410a.O();
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void P(int i2) {
        this.f26410a.P(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void Q(boolean z) {
        ((zzcju) this.f26410a).Q(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void R(long j2, boolean z) {
        this.f26410a.R(j2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void S() {
        zzcir zzcirVar = this.f26410a;
        if (zzcirVar != null) {
            zzcirVar.S();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void T(String str, zzcgx zzcgxVar) {
        ((zzcju) this.f26410a).T(str, zzcgxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void U(zzfhr zzfhrVar, zzfhu zzfhuVar) {
        zzcju zzcjuVar = (zzcju) this.f26410a;
        zzcjuVar.f26432j = zzfhrVar;
        zzcjuVar.f26433k = zzfhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void V(int i2) {
        this.f26410a.V(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void W(zzclb zzclbVar) {
        this.f26410a.W(zzclbVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean X(int i2, boolean z) {
        if (!this.f26412c.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h1)).booleanValue()) {
            return false;
        }
        zzcir zzcirVar = this.f26410a;
        if (zzcirVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzcirVar.getParent()).removeView((View) zzcirVar);
        }
        zzcirVar.X(i2, z);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzckh
    public final void Y(String str, String str2, boolean z, int i2, boolean z2) {
        this.f26410a.Y(str, str2, z, i2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void Z(boolean z) {
        this.f26410a.Z(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void a(String str) {
        ((zzcju) this.f26410a).H0(str);
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void a0() {
        zzcir zzcirVar = this.f26410a;
        if (zzcirVar != null) {
            zzcirVar.a0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final int b() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z4)).booleanValue() ? this.f26410a.getMeasuredWidth() : getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void b0(zzeiz zzeizVar) {
        this.f26410a.b0(zzeizVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void c(String str, String str2) {
        ((zzcju) this.f26410a).c("window.inspectorInfo", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void c0(String str, Predicate predicate) {
        ((zzcju) this.f26410a).c0(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean canGoBack() {
        return this.f26410a.canGoBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzckk
    public final zzayq d() {
        return this.f26410a.d();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void d0() {
        ((zzcju) this.f26410a).K0 = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void destroy() {
        final zzeiz zzeizVarQ;
        final zzcju zzcjuVar = (zzcju) this.f26410a;
        final zzejb zzejbVarL = zzcjuVar.L();
        if (zzejbVarL != null) {
            com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
            zzfVar.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjm
                @Override // java.lang.Runnable
                public final void run() {
                    zzeiv zzeivVar = com.google.android.gms.ads.internal.zzt.C.x;
                    final zzfrl zzfrlVar = zzejbVarL.f29453a;
                    zzeivVar.getClass();
                    zzeiv.j(new Runnable() { // from class: com.google.android.gms.internal.ads.zzein
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.V5)).booleanValue() && zzfrf.f31700a.f31701a) {
                                zzfrlVar.b();
                            }
                        }
                    });
                }
            });
            zzfVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcjuVar.destroy();
                }
            }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.W5)).intValue());
        } else if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Y5)).booleanValue() || (zzeizVarQ = zzcjuVar.q()) == null) {
            zzcjuVar.destroy();
        } else {
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjk
                @Override // java.lang.Runnable
                public final void run() {
                    zzcir zzcirVar;
                    final zzcjl zzcjlVar = new zzcjl(this.f26406a);
                    zzeiz zzeizVar = zzeizVarQ;
                    synchronized (zzeizVar) {
                        final zzfrt zzfrtVar = zzeizVar.f29447f;
                        if (zzfrtVar == null || (zzcirVar = zzeizVar.f29445d) == null) {
                            return;
                        }
                        com.google.android.gms.ads.internal.zzt.C.x.getClass();
                        zzeiv.j(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeir
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzfrt zzfrtVar2 = zzfrtVar;
                                Iterator it = zzfrtVar2.f31751d.values().iterator();
                                while (it.hasNext()) {
                                    ((zzfrh) it.next()).b();
                                }
                                Timer timer = new Timer();
                                timer.schedule(new zzfrq(zzfrtVar2, zzcjlVar, timer), 1000L);
                            }
                        });
                        zzeizVar.f29447f = null;
                        zzcirVar.b0(null);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcjy
    public final zzfhu e() {
        return this.f26410a.e();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final zzcjc e0() {
        return ((zzcju) this.f26410a).n;
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void f(String str, JSONObject jSONObject) {
        ((zzcju) this.f26410a).c(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void f0(boolean z) {
        this.f26410a.f0(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbqj
    public final void g(String str, Map map) {
        ((zzcju) this.f26410a).g(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void g0(boolean z) {
        ((zzcju) this.f26410a).g0(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void goBack() {
        this.f26410a.goBack();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        zzcir zzcirVar = this.f26410a;
        if (zzcirVar != null) {
            ((zzcju) zzcirVar).h();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void h0(String str, zzbnn zzbnnVar) {
        this.f26410a.h0(str, zzbnnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void i() {
        setBackgroundColor(0);
        this.f26410a.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void i0(int i2) {
        zzcey zzceyVar = this.f26411b.f26055e;
        if (zzceyVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.e0)).booleanValue()) {
                zzceyVar.f26039b.setBackgroundColor(i2);
                zzceyVar.f26040c.setBackgroundColor(i2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final zzcgx j(String str) {
        return this.f26410a.j(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void j0(int i2) {
        this.f26410a.j0(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final WebView k() {
        return (WebView) this.f26410a;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void k0(String str, zzbnn zzbnnVar) {
        ((zzcju) this.f26410a).k0(str, zzbnnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void l() {
        this.f26410a.l();
    }

    @Override // com.google.android.gms.internal.ads.zzckh
    public final void l0(String str, String str2) {
        ((zzcju) this.f26410a).l0(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void loadData(String str, String str2, String str3) {
        this.f26410a.loadData(str, "text/html", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f26410a.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void loadUrl(String str) {
        this.f26410a.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbqj
    public final void m(String str, JSONObject jSONObject) {
        ((zzcju) this.f26410a).m(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void m0() {
        ((zzcju) this.f26410a).m0();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean n() {
        return ((zzcju) this.f26410a).n();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void n0(zzbjl zzbjlVar) {
        ((zzcju) this.f26410a).n0(zzbjlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void o() {
        this.f26410a.o();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void o0(zzdrr zzdrrVar) {
        ((zzcju) this.f26410a).o0(zzdrrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void onPause() {
        zzceq zzceqVar;
        zzcez zzcezVar = this.f26411b;
        zzcezVar.getClass();
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcey zzceyVar = zzcezVar.f26055e;
        if (zzceyVar != null && (zzceqVar = zzceyVar.f26044g) != null) {
            zzceqVar.n();
        }
        ((zzcju) this.f26410a).onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void onResume() {
        this.f26410a.onResume();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void p() {
        zzejb zzejbVarL;
        zzeiz zzeizVarQ;
        TextView textView = new TextView(getContext());
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zztVar.f21679c;
        Resources resourcesC = zztVar.f21684h.c();
        textView.setText(resourcesC != null ? resourcesC.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
        zzbgb zzbgbVar = zzbgk.Y5;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        zzcir zzcirVar = this.f26410a;
        if (zBooleanValue && (zzeizVarQ = ((zzcju) zzcirVar).q()) != null) {
            zzeizVarQ.d(textView);
        } else {
            if (!((Boolean) zzbdVar.f21153c.a(zzbgk.X5)).booleanValue() || (zzejbVarL = ((zzcju) zzcirVar).L()) == null) {
                return;
            }
            if (zzejbVarL.f29454b.f31713g == zzfrk.HTML) {
                zztVar.x.d(zzejbVarL.f29453a, textView);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void p0(boolean z) {
        this.f26410a.p0(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final zzeiz q() {
        return this.f26410a.q();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void q0(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.f26410a.q0(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean r() {
        return ((zzcju) this.f26410a).r();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void r0(zzejb zzejbVar) {
        this.f26410a.r0(zzejbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean s() {
        return this.f26410a.s();
    }

    @Override // com.google.android.gms.internal.ads.zzckh
    public final void s0(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        ((zzcju) this.f26410a).s0(zzcVar, z, z2, str);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcir
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f26410a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcir
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f26410a.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f26410a.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.f26410a.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void t(zzcjx zzcjxVar) {
        ((zzcju) this.f26410a).t(zzcjxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzckh
    public final void t0(boolean z, int i2, String str, boolean z2, boolean z3) {
        this.f26410a.t0(z, i2, str, z2, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void u() {
        this.f26410a.u();
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void u0(zzbcj zzbcjVar) {
        ((zzcju) this.f26410a).u0(zzbcjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcii
    public final zzfhr v() {
        return this.f26410a.v();
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void v0() {
        this.f26410a.v0();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final ArrayList w() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != this.f26410a) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void w0() {
        ((zzcju) this.f26410a).w0();
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzckm
    public final View x() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final int y() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z4)).booleanValue() ? this.f26410a.getMeasuredHeight() : getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void y0(zzbdx zzbdxVar) {
        this.f26410a.y0(zzbdxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final com.google.android.gms.ads.internal.overlay.zzm z() {
        return this.f26410a.z();
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final zzcez z0() {
        return this.f26411b;
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzckj
    public final zzclb zzN() {
        return this.f26410a.zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final String zzO() {
        return this.f26410a.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcfk
    public final zzcjx zzh() {
        return this.f26410a.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final zzbgw zzi() {
        return this.f26410a.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcfk
    public final Activity zzj() {
        return this.f26410a.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcfk
    public final com.google.android.gms.ads.internal.zza zzk() {
        return this.f26410a.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void zzl() {
        this.f26410a.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final String zzm() {
        return this.f26410a.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final String zzn() {
        return this.f26410a.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final int zzp() {
        return this.f26410a.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcfk
    public final zzbgx zzq() {
        return this.f26410a.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzckl, com.google.android.gms.internal.ads.zzcfk
    public final VersionInfoParcel zzs() {
        return this.f26410a.zzs();
    }
}
