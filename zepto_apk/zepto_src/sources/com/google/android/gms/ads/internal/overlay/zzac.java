package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbwx;
import com.google.android.gms.internal.ads.zzdir;

/* loaded from: classes4.dex */
public final class zzac extends zzbwx implements zzbde {

    /* renamed from: b, reason: collision with root package name */
    public final AdOverlayInfoParcel f21328b;

    /* renamed from: c, reason: collision with root package name */
    public final Activity f21329c;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f21333g;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21330d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21331e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21332f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21334h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21335i = false;

    public zzac(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        zzc zzcVar;
        boolean z = false;
        this.f21328b = adOverlayInfoParcel;
        this.f21329c = activity;
        zzbgb zzbgbVar = zzbgk.v5;
        zzbd zzbdVar = zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if ((zBooleanValue || ((Boolean) zzbgiVar.a(zzbgk.w5)).booleanValue() || ((Boolean) zzbgiVar.a(zzbgk.A5)).booleanValue()) && (zzcVar = adOverlayInfoParcel.f21314a) != null && zzcVar.f21345j && Build.MANUFACTURER.matches((String) zzbgiVar.a(zzbgk.y5)) && Build.MODEL.matches((String) zzbgiVar.a(zzbgk.z5))) {
            z = true;
        }
        this.f21333g = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void B() {
        if (this.f21329c.isFinishing()) {
            Xb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void J(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void Q2(int i2, int i3, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void R7(int i2, String[] strArr, int[] iArr) {
    }

    public final synchronized void Xb() {
        try {
            if (!this.f21331e) {
                zzr zzrVar = this.f21328b.f21316c;
                if (zzrVar != null) {
                    zzrVar.R6(4);
                }
                this.f21331e = true;
                if (this.f21333g) {
                    if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.A5)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.C.f21683g.c(this);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void e1() {
        if (this.f21329c.isFinishing()) {
            Xb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final void j1(boolean z) {
        if (!z) {
            this.f21335i = true;
        } else if (this.f21335i) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Foregrounded: finishing activity from LauncherOverlay");
            this.f21329c.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void n0(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f21330d);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void t6(Bundle bundle) {
        zzr zzrVar;
        zzbgb zzbgbVar = zzbgk.Y9;
        zzbd zzbdVar = zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        Activity activity = this.f21329c;
        if (zBooleanValue && !this.f21332f) {
            activity.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f21328b;
        if (adOverlayInfoParcel == null) {
            activity.finish();
            return;
        }
        if (z) {
            activity.finish();
            return;
        }
        if (bundle == null) {
            com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel.f21315b;
            if (zzaVar != null) {
                zzaVar.h();
            }
            zzdir zzdirVar = adOverlayInfoParcel.u;
            if (zzdirVar != null) {
                zzdirVar.S();
            }
            if (activity.getIntent() != null && activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zzrVar = adOverlayInfoParcel.f21316c) != null) {
                zzrVar.zzh();
            }
        }
        if (this.f21333g) {
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.A5)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.C.f21683g.b(this);
            }
        }
        zza zzaVar2 = com.google.android.gms.ads.internal.zzt.C.f21677a;
        zzc zzcVar = adOverlayInfoParcel.f21314a;
        zzaa zzaaVar = zzcVar.f21344i;
        zzad zzadVar = adOverlayInfoParcel.f21322i;
        Activity activity2 = this.f21329c;
        if (zza.b(activity2, zzcVar, zzadVar, zzaaVar, null, "")) {
            return;
        }
        activity2.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzf() {
        zzr zzrVar = this.f21328b.f21316c;
        if (zzrVar != null) {
            zzrVar.i5();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final boolean zzg() {
        return ((Boolean) zzbd.f21150e.f21153c.a(zzbgk.w5)).booleanValue() && this.f21333g && this.f21334h;
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzk() {
        if (this.f21330d) {
            com.google.android.gms.ads.internal.util.zze.k("LauncherOverlay finishing activity");
            this.f21329c.finish();
            return;
        }
        this.f21330d = true;
        this.f21334h = true;
        zzr zzrVar = this.f21328b.f21316c;
        if (zzrVar != null) {
            zzrVar.d9();
        }
        if (this.f21333g) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.v5)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs.f21608l.postDelayed(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzab
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzac zzacVar = this.f21327a;
                        if (zzacVar.f21334h) {
                            zzacVar.f21329c.finish();
                        }
                    }
                }, ((Integer) r1.f21153c.a(zzbgk.x5)).intValue());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzl() {
        this.f21334h = false;
        zzr zzrVar = this.f21328b.f21316c;
        if (zzrVar != null) {
            zzrVar.w8();
        }
        if (this.f21329c.isFinishing()) {
            Xb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzs() {
        this.f21332f = true;
    }
}
