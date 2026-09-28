package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class zzdjs extends zzcvk {

    /* renamed from: l, reason: collision with root package name */
    public final Context f27826l;

    /* renamed from: m, reason: collision with root package name */
    public final WeakReference f27827m;
    public final zzdhv n;
    public final zzdlh o;
    public final zzcwf p;
    public final zzfup q;
    public final zzdax r;
    public final zzcdf s;
    public final zzdxe t;
    public boolean u;

    public zzdjs(zzcvj zzcvjVar, Context context, zzcir zzcirVar, zzdhv zzdhvVar, zzdlh zzdlhVar, zzcwf zzcwfVar, zzfup zzfupVar, zzdax zzdaxVar, zzcdf zzcdfVar, zzdxe zzdxeVar) {
        super(zzcvjVar);
        this.u = false;
        this.f27826l = context;
        this.f27827m = new WeakReference(zzcirVar);
        this.n = zzdhvVar;
        this.o = zzdlhVar;
        this.p = zzcwfVar;
        this.q = zzfupVar;
        this.r = zzdaxVar;
        this.s = zzcdfVar;
        this.t = zzdxeVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Activity activity, boolean z) {
        zzfhr zzfhrVarV;
        int i2;
        zzdhv zzdhvVar = this.n;
        zzdhvVar.v0(zzdhu.f27775a);
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        zzdlh zzdlhVar = this.o;
        boolean zM = com.google.android.gms.ads.internal.util.zzs.m(zzdlhVar.zzb());
        Context context = this.f27826l;
        zzdax zzdaxVar = this.r;
        if (!zM) {
            zzbgb zzbgbVar = zzbgk.Ke;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs.l(context, this.f27228b, this.t);
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.X0)).booleanValue() && com.google.android.gms.ads.internal.util.zzs.g(context)) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://goo.gle/admob-interstitial-policies");
                zzdaxVar.zze();
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.Y0)).booleanValue()) {
                    this.q.a(this.f27227a.f31194b.f31190b.f31167b);
                    return;
                }
                return;
            }
        }
        zzcir zzcirVar = (zzcir) this.f27827m.get();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Zc)).booleanValue() && zzcirVar != null && (zzfhrVarV = zzcirVar.v()) != null && zzfhrVarV.r0) {
            zzcdf zzcdfVar = this.s;
            synchronized (zzcdfVar.f25962a) {
                zzcdc zzcdcVar = zzcdfVar.f25965d;
                synchronized (zzcdcVar.f25952f) {
                    i2 = zzcdcVar.f25958l;
                }
            }
            if (zzfhrVarV.s0 != i2) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("The interstitial consent form has been shown.");
                zzdaxVar.k1(zzfjm.d(12, "The consent form has already been shown.", null));
                return;
            }
        }
        if (this.u) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("The interstitial ad has been shown.");
            zzdaxVar.k1(zzfjm.d(10, null, null));
        }
        if (this.u) {
            return;
        }
        if (activity == null) {
            activity = context;
        }
        try {
            zzdlhVar.a(z, activity, zzdaxVar);
            zzdhvVar.v0(zzdht.f27774a);
            this.u = true;
        } catch (zzdlg e2) {
            zzdaxVar.j(e2);
        }
    }

    public final void finalize() throws Throwable {
        try {
            final zzcir zzcirVar = (zzcir) this.f27827m.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q7)).booleanValue()) {
                if (!this.u && zzcirVar != null) {
                    ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjr
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzcirVar.destroy();
                        }
                    });
                }
            } else if (zzcirVar != null) {
                zzcirVar.destroy();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }
}
