package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdol {

    /* renamed from: k, reason: collision with root package name */
    public static final ImageView.ScaleType f28099k = ImageView.ScaleType.CENTER_INSIDE;

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f28100a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f28101b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdnr f28102c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdnm f28103d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdoz f28104e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdph f28105f;

    /* renamed from: g, reason: collision with root package name */
    public final Executor f28106g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgyw f28107h;

    /* renamed from: i, reason: collision with root package name */
    public final zzbjn f28108i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdnj f28109j;

    public zzdol(com.google.android.gms.ads.internal.util.zzj zzjVar, zzfik zzfikVar, zzdnr zzdnrVar, zzdnm zzdnmVar, zzdoz zzdozVar, zzdph zzdphVar, Executor executor, zzgyw zzgywVar, zzdnj zzdnjVar) {
        this.f28100a = zzjVar;
        this.f28101b = zzfikVar;
        this.f28108i = zzfikVar.f31222j;
        this.f28102c = zzdnrVar;
        this.f28103d = zzdnmVar;
        this.f28104e = zzdozVar;
        this.f28105f = zzdphVar;
        this.f28106g = executor;
        this.f28107h = zzgywVar;
        this.f28109j = zzdnjVar;
    }

    public static void b(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (i2 == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i2 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i2 != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    public final void a(zzdpj zzdpjVar) {
        if (zzdpjVar == null) {
            return;
        }
        Context context = zzdpjVar.Z8().getContext();
        if (com.google.android.gms.ads.internal.util.zzbs.g(context, this.f28102c.f28046a)) {
            if (!(context instanceof Activity)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Activity context is needed for policy validator.");
                return;
            }
            zzdph zzdphVar = this.f28105f;
            if (zzdphVar == null || zzdpjVar.p6() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(zzdphVar.a(zzdpjVar.p6(), windowManager), com.google.android.gms.ads.internal.util.zzbs.i());
            } catch (zzcjg e2) {
                com.google.android.gms.ads.internal.util.zze.l("web view can not be obtained", e2);
            }
        }
    }

    public final boolean c(ViewGroup viewGroup, boolean z) {
        View view;
        if (z) {
            zzdnm zzdnmVar = this.f28103d;
            synchronized (zzdnmVar) {
                view = zzdnmVar.o;
            }
        } else {
            zzdnm zzdnmVar2 = this.f28103d;
            synchronized (zzdnmVar2) {
                view = zzdnmVar2.p;
            }
        }
        if (view == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        viewGroup.addView(view, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.y4)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }
}
