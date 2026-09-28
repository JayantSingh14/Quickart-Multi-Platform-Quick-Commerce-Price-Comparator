package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class zzepp extends com.google.android.gms.ads.internal.client.zzbw {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30051a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzbk f30052b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfik f30053c;

    /* renamed from: d, reason: collision with root package name */
    public final zzctc f30054d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f30055e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdxe f30056f;

    public zzepp(Context context, com.google.android.gms.ads.internal.client.zzbk zzbkVar, zzfik zzfikVar, zzctc zzctcVar, zzdxe zzdxeVar) {
        this.f30051a = context;
        this.f30052b = zzbkVar;
        this.f30053c = zzfikVar;
        this.f30054d = zzctcVar;
        this.f30056f = zzdxeVar;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        frameLayout.addView(((zzctf) zzctcVar).f27101m, new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setMinimumHeight(zzn().f21283c);
        frameLayout.setMinimumWidth(zzn().f21286f);
        this.f30055e = frameLayout;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void B7(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void C0(boolean z) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Ga(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean H() {
        zzctc zzctcVar = this.f30054d;
        return zzctcVar != null && zzctcVar.f27228b.q0;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void J6(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
        zzeqp zzeqpVar = this.f30053c.f31215c;
        if (zzeqpVar != null) {
            zzeqpVar.m(zzcoVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long L() {
        zzcze zzczeVar;
        zzctc zzctcVar = this.f30054d;
        if (zzctcVar == null || (zzczeVar = zzctcVar.f27236j) == null) {
            return 0L;
        }
        return zzczeVar.f27458a.get();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Q4(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean U0(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void b2(zzbhf zzbhfVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String c() {
        return this.f30053c.f31219g;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void c3() {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void d8(com.google.android.gms.ads.internal.client.zzx zzxVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void eb(com.google.android.gms.ads.internal.client.zzga zzgaVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzea f() {
        return this.f30054d.f27232f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzco h() {
        return this.f30053c.o;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzbk j() {
        return this.f30052b;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void j2(long j2) {
        zzcze zzczeVar = this.f30054d.f27236j;
        if (zzczeVar != null) {
            zzczeVar.a(j2);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void k6(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void o8(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void qa(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean t() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void t5(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzed w() {
        return this.f30054d.e();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void w4(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzctc zzctcVar = this.f30054d;
        if (zzctcVar != null) {
            zzctcVar.d(this.f30055e, zzrVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void xa(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Hc)).booleanValue()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
            return;
        }
        zzeqp zzeqpVar = this.f30053c.f31215c;
        if (zzeqpVar != null) {
            try {
                if (!zzdtVar.zzf()) {
                    this.f30056f.b();
                }
            } catch (RemoteException e2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.b("Error in making CSI ping for reporting paid event callback", e2);
            }
            zzeqpVar.f30105c.set(zzdtVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z2(zzbeg zzbegVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z3(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z8(zzbzs zzbzsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzb() {
        return new ObjectWrapper(this.f30055e);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdbj zzdbjVar = this.f30054d.f27229c;
        zzdbjVar.getClass();
        zzdbjVar.v0(new zzdbh(null));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzf() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdbj zzdbjVar = this.f30054d.f27229c;
        zzdbjVar.getClass();
        zzdbjVar.v0(new zzdbi(null));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzg() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdbj zzdbjVar = this.f30054d.f27229c;
        zzdbjVar.getClass();
        zzdbjVar.v0(new zzdbg(null));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zzk() {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzl() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzm() {
        this.f30054d.j();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzr zzn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzfiq.a(this.f30051a, Collections.singletonList(this.f30054d.f()));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzr() {
        zzdad zzdadVar = this.f30054d.f27232f;
        if (zzdadVar != null) {
            return zzdadVar.f27543a;
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzs() {
        zzdad zzdadVar = this.f30054d.f27232f;
        if (zzdadVar != null) {
            return zzdadVar.f27543a;
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void m() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void x() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzp() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzq() {
    }
}
