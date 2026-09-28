package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbwd;
import com.google.android.gms.internal.ads.zzbwr;
import com.google.android.gms.internal.ads.zzbwx;
import com.google.android.gms.internal.ads.zzcir;
import com.google.android.gms.internal.ads.zzdax;
import com.google.android.gms.internal.ads.zzdir;
import com.google.android.gms.internal.ads.zzdxd;
import com.google.android.gms.internal.ads.zzdxe;
import com.google.android.gms.internal.ads.zzeig;
import com.google.android.gms.internal.ads.zzeih;
import com.google.android.gms.internal.ads.zzeiz;
import com.google.android.gms.internal.ads.zzejb;
import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfrk;
import java.util.Collections;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class zzm extends zzbwx implements zzah {
    public static final int x = Color.argb(0, 0, 0, 0);

    /* renamed from: b, reason: collision with root package name */
    public final Activity f21360b;

    /* renamed from: c, reason: collision with root package name */
    public AdOverlayInfoParcel f21361c;

    /* renamed from: d, reason: collision with root package name */
    public zzcir f21362d;

    /* renamed from: e, reason: collision with root package name */
    public zzj f21363e;

    /* renamed from: f, reason: collision with root package name */
    public zzu f21364f;

    /* renamed from: h, reason: collision with root package name */
    public FrameLayout f21366h;

    /* renamed from: i, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f21367i;

    /* renamed from: l, reason: collision with root package name */
    public zzi f21370l;
    public Runnable p;
    public boolean q;
    public boolean r;
    public Toolbar v;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21365g = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f21368j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f21369k = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21371m = false;
    public int w = 1;
    public final Object n = new Object();
    public final View.OnClickListener o = new zzd(this);
    public boolean s = false;
    public boolean t = false;
    public boolean u = true;

    public zzm(Activity activity) {
        this.f21360b = activity;
    }

    public static final void dc(View view, zzejb zzejbVar) {
        if (zzejbVar == null || view == null) {
            return;
        }
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.X5)).booleanValue()) {
            zzfrj zzfrjVar = zzejbVar.f29454b;
            if (zzfrjVar.f31713g == zzfrk.HTML) {
                return;
            }
        }
        com.google.android.gms.ads.internal.zzt.C.x.e(zzejbVar.f29453a, view);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void B() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f21316c) != null) {
            zzrVar.T7();
        }
        zzcir zzcirVar = this.f21362d;
        if (zzcirVar != null) {
            try {
                this.f21370l.removeView(zzcirVar.x());
            } catch (NullPointerException unused) {
            }
        }
        Xb();
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void J(IObjectWrapper iObjectWrapper) {
        bc((Configuration) ObjectWrapper.z0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void Q2(int i2, int i3, Intent intent) {
        zzdxe zzdxeVar;
        AdOverlayInfoParcel adOverlayInfoParcel;
        if (i2 == 236) {
            zzbgb zzbgbVar = zzbgk.me;
            zzbd zzbdVar = zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 66);
                sb.append("Callback from intent launch with requestCode: 236 and resultCode: ");
                sb.append(i3);
                com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                zzcir zzcirVar = this.f21362d;
                if (zzcirVar == null || zzcirVar.e0() == null || (zzdxeVar = zzcirVar.e0().z) == null || (adOverlayInfoParcel = this.f21361c) == null || !((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                    return;
                }
                zzdxd zzdxdVarA = zzdxeVar.a();
                zzdxdVarA.b("action", "hilca");
                String str = adOverlayInfoParcel.q;
                if (str == null) {
                    str = "";
                }
                zzdxdVarA.b("gqi", str);
                StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length());
                sb2.append(i3);
                zzdxdVarA.b("hilr", sb2.toString());
                if (i3 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("callerPackage");
                    String stringExtra2 = intent.getStringExtra("loadingStage");
                    if (stringExtra != null) {
                        zzdxdVarA.b("hilcp", stringExtra);
                    }
                    if (stringExtra2 != null) {
                        zzdxdVarA.b("hills", stringExtra2);
                    }
                }
                zzdxdVarA.e();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void R7(int i2, String[] strArr, int[] iArr) {
        if (i2 == 12345) {
            zzeig zzeigVarE = zzeih.e();
            zzeigVarE.a(this.f21360b);
            zzeigVarE.b(this.f21361c.f21324k == 5 ? this : null);
            try {
                this.f21361c.v.q6(strArr, iArr, new ObjectWrapper(zzeigVarE.e()));
            } catch (RemoteException unused) {
            }
        }
    }

    public final void Xb() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzr zzrVar;
        if (!this.f21360b.isFinishing() || this.s) {
            return;
        }
        this.s = true;
        zzcir zzcirVar = this.f21362d;
        if (zzcirVar != null) {
            zzcirVar.V(this.w - 1);
            synchronized (this.n) {
                try {
                    if (!this.q && this.f21362d.D()) {
                        zzbgb zzbgbVar = zzbgk.J5;
                        zzbd zzbdVar = zzbd.f21150e;
                        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && !this.t && (adOverlayInfoParcel = this.f21361c) != null && (zzrVar = adOverlayInfoParcel.f21316c) != null) {
                            zzrVar.A4();
                        }
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzf
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.f21349a.Yb();
                            }
                        };
                        this.p = runnable;
                        com.google.android.gms.ads.internal.util.zzs.f21608l.postDelayed(runnable, ((Long) zzbdVar.f21153c.a(zzbgk.t1)).longValue());
                        return;
                    }
                } finally {
                }
            }
        }
        Yb();
    }

    public final void Yb() {
        zzcir zzcirVar;
        zzr zzrVar;
        if (this.t) {
            return;
        }
        this.t = true;
        zzcir zzcirVar2 = this.f21362d;
        if (zzcirVar2 != null) {
            this.f21370l.removeView(zzcirVar2.x());
            zzj zzjVar = this.f21363e;
            if (zzjVar != null) {
                this.f21362d.N(zzjVar.f21356d);
                this.f21362d.g0(false);
                if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Od)).booleanValue() && this.f21362d.getParent() != null) {
                    ((ViewGroup) this.f21362d.getParent()).removeView(this.f21362d.x());
                }
                ViewGroup viewGroup = this.f21363e.f21355c;
                View viewX = this.f21362d.x();
                zzj zzjVar2 = this.f21363e;
                viewGroup.addView(viewX, zzjVar2.f21353a, zzjVar2.f21354b);
                this.f21363e = null;
            } else {
                Activity activity = this.f21360b;
                if (activity.getApplicationContext() != null) {
                    this.f21362d.N(activity.getApplicationContext());
                }
            }
            this.f21362d = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f21316c) != null) {
            zzrVar.R6(this.w);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.f21361c;
        if (adOverlayInfoParcel2 == null || (zzcirVar = adOverlayInfoParcel2.f21317d) == null) {
            return;
        }
        dc(this.f21361c.f21317d.x(), zzcirVar.L());
    }

    public final void Zb() {
        this.f21370l.f21352b = true;
    }

    public final void ac(zzeih zzeihVar) throws zzh {
        zzbwr zzbwrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel == null || (zzbwrVar = adOverlayInfoParcel.v) == null) {
            throw new zzh("noioou");
        }
        zzbwrVar.X0(new ObjectWrapper(zzeihVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void bc(android.content.res.Configuration r14) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.bc(android.content.res.Configuration):void");
    }

    public final void cc(View view) {
        zzejb zzejbVarL;
        zzeiz zzeizVarQ;
        zzcir zzcirVar = this.f21362d;
        if (zzcirVar == null) {
            return;
        }
        zzbgb zzbgbVar = zzbgk.Y5;
        zzbd zzbdVar = zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && (zzeizVarQ = zzcirVar.q()) != null) {
            zzeizVarQ.d(view);
            return;
        }
        if (!((Boolean) zzbdVar.f21153c.a(zzbgk.X5)).booleanValue() || (zzejbVarL = zzcirVar.L()) == null) {
            return;
        }
        if (zzejbVarL.f29454b.f31713g == zzfrk.HTML) {
            com.google.android.gms.ads.internal.zzt.C.x.d(zzejbVarL.f29453a, view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void e1() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f21316c) != null) {
            zzrVar.j7();
        }
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.L5)).booleanValue() && this.f21362d != null && (!this.f21360b.isFinishing() || this.f21363e == null)) {
            this.f21362d.onPause();
        }
        Xb();
    }

    public final void ec(boolean z, boolean z2) throws JSONException {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzl zzlVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzl zzlVar2;
        zzbgb zzbgbVar = zzbgk.u1;
        zzbd zzbdVar = zzbd.f21150e;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && (adOverlayInfoParcel2 = this.f21361c) != null && (zzlVar2 = adOverlayInfoParcel2.o) != null && zzlVar2.f21660h;
        boolean z5 = ((Boolean) zzbdVar.f21153c.a(zzbgk.v1)).booleanValue() && (adOverlayInfoParcel = this.f21361c) != null && (zzlVar = adOverlayInfoParcel.o) != null && zzlVar.f21661i;
        if (z && z2 && z4 && !z5) {
            new zzbwd(this.f21362d, "useCustomClose").b("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzu zzuVar = this.f21364f;
        if (zzuVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            ImageButton imageButton = zzuVar.f21388a;
            if (!z3) {
                imageButton.setVisibility(0);
                return;
            }
            imageButton.setVisibility(8);
            if (((Long) zzbdVar.f21153c.a(zzbgk.y1)).longValue() > 0) {
                imageButton.animate().cancel();
                imageButton.clearAnimation();
            }
        }
    }

    public final void fc(int i2) {
        Activity activity = this.f21360b;
        int i3 = activity.getApplicationInfo().targetSdkVersion;
        zzbgb zzbgbVar = zzbgk.G6;
        zzbd zzbdVar = zzbd.f21150e;
        if (i3 >= ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue()) {
            if (activity.getApplicationInfo().targetSdkVersion <= ((Integer) zzbdVar.f21153c.a(zzbgk.H6)).intValue()) {
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= ((Integer) zzbdVar.f21153c.a(zzbgk.I6)).intValue()) {
                    if (i4 <= ((Integer) zzbdVar.f21153c.a(zzbgk.J6)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            activity.setRequestedOrientation(i2);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("AdOverlay.setRequestedOrientation", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void gc(boolean r44) throws org.json.JSONException, com.google.android.gms.ads.internal.overlay.zzh {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.gc(boolean):void");
    }

    public final void h1(boolean z) throws JSONException {
        if (this.f21361c.w) {
            return;
        }
        zzbgb zzbgbVar = zzbgk.O5;
        zzbd zzbdVar = zzbd.f21150e;
        int iIntValue = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
        boolean z2 = ((Boolean) zzbdVar.f21153c.a(zzbgk.w1)).booleanValue() || z;
        zzt zztVar = new zzt();
        zztVar.f21387d = 50;
        zztVar.f21384a = true != z2 ? 0 : iIntValue;
        zztVar.f21385b = true != z2 ? iIntValue : 0;
        zztVar.f21386c = iIntValue;
        this.f21364f = new zzu(this.f21360b, zztVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z2 ? 9 : 11);
        ec(z, this.f21361c.f21320g);
        this.f21370l.addView(this.f21364f, layoutParams);
        cc(this.f21364f);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void n0(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f21368j);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public void t6(Bundle bundle) throws JSONException, zzh {
        zzr zzrVar;
        if (!this.r) {
            this.f21360b.requestWindowFeature(1);
        }
        this.f21368j = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            Activity activity = this.f21360b;
            AdOverlayInfoParcel adOverlayInfoParcelB = AdOverlayInfoParcel.b(activity.getIntent());
            this.f21361c = adOverlayInfoParcelB;
            if (adOverlayInfoParcelB == null) {
                throw new zzh("Could not get info for ad overlay.");
            }
            if (adOverlayInfoParcelB.w) {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.setShowWhenLocked(true);
                } else {
                    activity.getWindow().addFlags(524288);
                }
            }
            if (this.f21361c.f21326m.f21402c > 7500000) {
                this.w = 4;
            }
            if (activity.getIntent() != null) {
                this.u = activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
            com.google.android.gms.ads.internal.zzl zzlVar = adOverlayInfoParcel.o;
            if (zzlVar != null) {
                boolean z = zzlVar.f21653a;
                this.f21369k = z;
                if (z) {
                    if (adOverlayInfoParcel.f21324k != 5 && zzlVar.f21658f != -1) {
                        new zzl(this).b();
                    }
                }
            } else if (adOverlayInfoParcel.f21324k == 5) {
                this.f21369k = true;
                if (adOverlayInfoParcel.f21324k != 5) {
                    new zzl(this).b();
                }
            } else {
                this.f21369k = false;
            }
            if (bundle == null) {
                if (this.u) {
                    zzdax zzdaxVar = this.f21361c.t;
                    if (zzdaxVar != null) {
                        synchronized (zzdaxVar) {
                            ScheduledFuture scheduledFuture = zzdaxVar.f27573c;
                            if (scheduledFuture != null) {
                                scheduledFuture.cancel(true);
                            }
                        }
                    }
                    zzr zzrVar2 = this.f21361c.f21316c;
                    if (zzrVar2 != null) {
                        zzrVar2.zzh();
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.f21361c;
                if (adOverlayInfoParcel2.f21324k != 1) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel2.f21315b;
                    if (zzaVar != null) {
                        zzaVar.h();
                    }
                    zzdir zzdirVar = this.f21361c.u;
                    if (zzdirVar != null) {
                        zzdirVar.S();
                    }
                }
            }
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.f21361c;
            if (adOverlayInfoParcel3 != null && (zzrVar = adOverlayInfoParcel3.f21316c) != null) {
                zzrVar.V2();
            }
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.f21361c;
            zzi zziVar = new zzi(activity, adOverlayInfoParcel4.n, adOverlayInfoParcel4.f21326m.f21400a, adOverlayInfoParcel4.s);
            this.f21370l = zziVar;
            zziVar.setId(1000);
            com.google.android.gms.ads.internal.zzt.C.f21682f.e(activity);
            AdOverlayInfoParcel adOverlayInfoParcel5 = this.f21361c;
            int i2 = adOverlayInfoParcel5.f21324k;
            if (i2 == 1) {
                gc(false);
                return;
            }
            if (i2 == 2) {
                this.f21363e = new zzj(adOverlayInfoParcel5.f21317d);
                gc(false);
            } else if (i2 == 3) {
                gc(true);
            } else {
                if (i2 != 5) {
                    throw new zzh("Could not determine ad overlay type.");
                }
                gc(false);
            }
        } catch (zzh e2) {
            String message = e2.getMessage();
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f(message);
            this.w = 4;
            this.f21360b.finish();
        }
    }

    public final void zzb() {
        this.w = 3;
        Activity activity = this.f21360b;
        activity.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.f21324k != 5) {
            return;
        }
        activity.overridePendingTransition(0, 0);
        zzcir zzcirVar = this.f21362d;
        if (zzcirVar != null) {
            zzcirVar.K(null);
        }
    }

    public final void zzc() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel != null && this.f21365g) {
            fc(adOverlayInfoParcel.f21323j);
        }
        if (this.f21366h != null) {
            this.f21360b.setContentView(this.f21370l);
            this.r = true;
            this.f21366h.removeAllViews();
            this.f21366h = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.f21367i;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.f21367i = null;
        }
        this.f21365g = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zze() {
        this.w = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzf() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.f21316c) == null) {
            return;
        }
        zzrVar.i5();
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final boolean zzg() {
        this.w = 1;
        if (this.f21362d == null) {
            return true;
        }
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.aa)).booleanValue() && this.f21362d.canGoBack()) {
            this.f21362d.goBack();
            return false;
        }
        boolean zS = this.f21362d.s();
        if (!zS) {
            this.f21362d.g("onbackblocked", Collections.EMPTY_MAP);
        }
        return zS;
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzi() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.f21316c) == null) {
            return;
        }
        zzrVar.w1();
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzj() {
        zzr zzrVar;
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.L5)).booleanValue()) {
            zzcir zzcirVar = this.f21362d;
            if (zzcirVar == null || zzcirVar.n()) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("The webview does not exist. Ignoring action.");
            } else {
                this.f21362d.onResume();
            }
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.f21316c) == null) {
            return;
        }
        zzrVar.y3();
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzk() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f21316c) != null) {
            zzrVar.d9();
        }
        bc(this.f21360b.getResources().getConfiguration());
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.L5)).booleanValue()) {
            return;
        }
        zzcir zzcirVar = this.f21362d;
        if (zzcirVar != null && !zzcirVar.n()) {
            this.f21362d.onResume();
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzl() {
        zzr zzrVar;
        zzc();
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21361c;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.f21316c) != null) {
            zzrVar.w8();
        }
        if (!((Boolean) zzbd.f21150e.f21153c.a(zzbgk.L5)).booleanValue() && this.f21362d != null && (!this.f21360b.isFinishing() || this.f21363e == null)) {
            this.f21362d.onPause();
        }
        Xb();
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzs() {
        this.r = true;
    }
}
