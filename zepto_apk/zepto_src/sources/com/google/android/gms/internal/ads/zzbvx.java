package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import in.juspay.hypersdk.analytics.LogConstants;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzbvx extends zzbwd {

    /* renamed from: c, reason: collision with root package name */
    public String f25618c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f25619d;

    /* renamed from: e, reason: collision with root package name */
    public int f25620e;

    /* renamed from: f, reason: collision with root package name */
    public int f25621f;

    /* renamed from: g, reason: collision with root package name */
    public int f25622g;

    /* renamed from: h, reason: collision with root package name */
    public int f25623h;

    /* renamed from: i, reason: collision with root package name */
    public int f25624i;

    /* renamed from: j, reason: collision with root package name */
    public int f25625j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f25626k;

    /* renamed from: l, reason: collision with root package name */
    public final zzcjn f25627l;

    /* renamed from: m, reason: collision with root package name */
    public final Activity f25628m;
    public zzclb n;
    public ImageView o;
    public LinearLayout p;
    public final zzbwe q;
    public PopupWindow r;
    public RelativeLayout s;
    public ViewGroup t;

    static {
        CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public zzbvx(zzcjn zzcjnVar, zzbwe zzbweVar) {
        super(zzcjnVar, "resize");
        this.f25618c = "top-right";
        this.f25619d = true;
        this.f25620e = 0;
        this.f25621f = 0;
        this.f25622g = -1;
        this.f25623h = 0;
        this.f25624i = 0;
        this.f25625j = -1;
        this.f25626k = new Object();
        this.f25627l = zzcjnVar;
        this.f25628m = ((zzcju) zzcjnVar.f26410a).zzj();
        this.q = zzbweVar;
    }

    public final void f(final boolean z) {
        synchronized (this.f25626k) {
            try {
                if (this.r != null) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Vb)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        g(z);
                    } else {
                        ((zzgxi) zzcdo.f25987f).submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbvw
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() throws JSONException {
                                this.f25616a.g(z);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(boolean z) throws JSONException {
        zzbgb zzbgbVar = zzbgk.Wb;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        zzcjn zzcjnVar = this.f25627l;
        if (zBooleanValue) {
            this.s.removeView(zzcjnVar);
            this.r.dismiss();
        } else {
            this.r.dismiss();
            this.s.removeView(zzcjnVar);
        }
        zzbgb zzbgbVar2 = zzbgk.Xb;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue()) {
            ViewParent parent = zzcjnVar.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(zzcjnVar);
            }
        }
        ViewGroup viewGroup = this.t;
        if (viewGroup != null) {
            viewGroup.removeView(this.o);
            if (((Boolean) zzbgiVar.a(zzbgk.Yb)).booleanValue()) {
                try {
                    this.t.addView(zzcjnVar);
                    zzcjnVar.W(this.n);
                } catch (IllegalStateException e2) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("Unable to add webview back to view hierarchy.", e2);
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("MraidCallResizeHandler.collapseInternal", e2);
                }
            } else {
                this.t.addView(zzcjnVar);
                zzcjnVar.W(this.n);
            }
        }
        if (z) {
            d(LogConstants.DEFAULT_CHANNEL);
            zzbwe zzbweVar = this.q;
            if (zzbweVar != null) {
                ((zzdtq) zzbweVar).f28531a.f28544c.v0(zzdbq.f27593a);
            }
        }
        this.r = null;
        this.s = null;
        this.t = null;
        this.p = null;
    }
}
