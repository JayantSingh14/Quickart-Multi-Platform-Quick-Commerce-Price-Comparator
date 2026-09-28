package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* loaded from: classes4.dex */
public final class zzdfb implements AppEventListener, OnAdMetadataChangedListener, zzdak, com.google.android.gms.ads.internal.client.zza, zzddb, zzdbe, zzdcj, com.google.android.gms.ads.internal.overlay.zzr, zzdba, zzdir {

    /* renamed from: a, reason: collision with root package name */
    public final zzdea f27693a = new zzdea(this);

    /* renamed from: b, reason: collision with root package name */
    public zzeqp f27694b;

    /* renamed from: c, reason: collision with root package name */
    public zzeqt f27695c;

    /* renamed from: d, reason: collision with root package name */
    public zzfdr f27696d;

    /* renamed from: e, reason: collision with root package name */
    public zzfgv f27697e;

    public static void m(Object obj, zzdfa zzdfaVar) {
        if (obj != null) {
            zzdfaVar.zza(obj);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
        m(this.f27696d, zzdem.f27677a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void R6(final int i2) {
        m(this.f27696d, new zzdfa() { // from class: com.google.android.gms.internal.ads.zzddy
            @Override // com.google.android.gms.internal.ads.zzdfa
            public final /* synthetic */ void zza(Object obj) {
                ((zzfdr) obj).R6(i2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void S() {
        m(this.f27694b, zzdeh.f27672a);
        m(this.f27695c, zzder.f27682a);
        m(this.f27697e, zzdex.f27688a);
        m(this.f27696d, zzdeq.f27681a);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void T() {
        m(this.f27694b, zzdec.f27667a);
        m(this.f27697e, zzdeu.f27685a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void Y(final zzbzj zzbzjVar, final String str, final String str2) {
        m(this.f27694b, new zzddz());
        m(this.f27697e, new zzdfa() { // from class: com.google.android.gms.internal.ads.zzddr
            @Override // com.google.android.gms.internal.ads.zzdfa
            public final /* synthetic */ void zza(Object obj) {
                ((zzfgv) obj).Y(zzbzjVar, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddb
    public final void a(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        m(this.f27694b, new zzdfa() { // from class: com.google.android.gms.internal.ads.zzddt
            @Override // com.google.android.gms.internal.ads.zzdfa
            public final /* synthetic */ void zza(Object obj) {
                ((zzeqp) obj).a(zztVar);
            }
        });
        m(this.f27697e, new zzdfa() { // from class: com.google.android.gms.internal.ads.zzddu
            @Override // com.google.android.gms.internal.ads.zzdfa
            public final /* synthetic */ void zza(Object obj) {
                ((zzfgv) obj).a(zztVar);
            }
        });
        m(this.f27696d, new zzdfa() { // from class: com.google.android.gms.internal.ads.zzddv
            @Override // com.google.android.gms.internal.ads.zzdfa
            public final /* synthetic */ void zza(Object obj) {
                ((zzfdr) obj).a(zztVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void a0() {
        m(this.f27694b, zzdeg.f27671a);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void b() {
        m(this.f27694b, zzdeb.f27666a);
        m(this.f27697e, zzdet.f27684a);
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void c(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        m(this.f27697e, new zzdfa() { // from class: com.google.android.gms.internal.ads.zzddw
            @Override // com.google.android.gms.internal.ads.zzdfa
            public final /* synthetic */ void zza(Object obj) {
                ((zzfgv) obj).c(zzeVar);
            }
        });
        m(this.f27694b, new zzdfa() { // from class: com.google.android.gms.internal.ads.zzddx
            @Override // com.google.android.gms.internal.ads.zzdfa
            public final /* synthetic */ void zza(Object obj) {
                ((zzeqp) obj).c(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void d9() {
        m(this.f27696d, zzdep.f27680a);
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() {
        m(this.f27694b, zzdei.f27673a);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void g() {
        m(this.f27694b, zzdej.f27674a);
        m(this.f27697e, zzdez.f27690a);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        m(this.f27694b, zzdef.f27670a);
        m(this.f27695c, zzdes.f27683a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void i5() {
        m(this.f27696d, zzden.f27678a);
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void j() {
        m(this.f27697e, zzdey.f27689a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w8() {
        m(this.f27696d, zzdeo.f27679a);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void y(final String str, final String str2) {
        m(this.f27694b, new zzdfa() { // from class: com.google.android.gms.internal.ads.zzdds
            @Override // com.google.android.gms.internal.ads.zzdfa
            public final /* synthetic */ void zza(Object obj) {
                ((zzeqp) obj).y(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zze() {
        m(this.f27694b, zzded.f27668a);
        m(this.f27697e, zzdev.f27686a);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zzf() {
        m(this.f27694b, zzdee.f27669a);
        m(this.f27697e, zzdew.f27687a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        m(this.f27696d, zzdel.f27676a);
    }

    @Override // com.google.android.gms.internal.ads.zzdcj
    public final void zzl() {
        m(this.f27696d, zzdek.f27675a);
    }
}
