package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzfdr implements zzdan, zzdcj, zzffg, com.google.android.gms.ads.internal.overlay.zzr, zzddb, zzdba, zzdir {

    /* renamed from: a, reason: collision with root package name */
    public final zzfjv f30895a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f30896b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f30897c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f30898d = new AtomicReference();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f30899e = new AtomicReference();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f30900f = new AtomicReference();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference f30901g = new AtomicReference();

    /* renamed from: h, reason: collision with root package name */
    public zzfdr f30902h = null;

    public zzfdr(zzfjv zzfjvVar) {
        this.f30895a = zzfjvVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.A4();
        } else {
            zzfey.a(this.f30900f, zzfdd.f30881a);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void R6(final int i2) {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.R6(i2);
        } else {
            zzfey.a(this.f30900f, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfdj
                @Override // com.google.android.gms.internal.ads.zzfex
                public final /* synthetic */ void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzr) obj).R6(i2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void S() {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.S();
        } else {
            zzfey.a(this.f30898d, zzfdp.f30893a);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
    }

    @Override // com.google.android.gms.internal.ads.zzddb
    public final void a(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.a(zztVar);
        } else {
            zzfey.a(this.f30901g, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfdl
                @Override // com.google.android.gms.internal.ads.zzfex
                public final /* synthetic */ void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzdt) obj).va(zztVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void a0() {
    }

    public final void b(final zzcsx zzcsxVar) {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.b(zzcsxVar);
        } else {
            zzfey.a(this.f30896b, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfdg
                @Override // com.google.android.gms.internal.ads.zzfex
                public final /* synthetic */ void zza(Object obj) {
                    ((zzbeg) obj).gb(zzcsxVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void c(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.c(zzeVar);
        } else {
            zzfey.a(this.f30898d, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfdk
                @Override // com.google.android.gms.internal.ads.zzfex
                public final /* synthetic */ void zza(Object obj) {
                    ((zzbek) obj).x0(zzeVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void d9() {
    }

    public final void f() {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.f();
            return;
        }
        zzfju zzfjuVar = this.f30895a.f31285a;
        if (zzfjuVar != null) {
            zzfkv zzfkvVar = ((zzfku) zzfjuVar).f31331a;
            synchronized (zzfkvVar) {
                zzfkvVar.f31336e = 1;
                zzfkvVar.a();
            }
        }
        zzfey.a(this.f30897c, zzfdm.f30890a);
        zzfey.a(this.f30898d, zzfdq.f30894a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void i5() {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.i5();
        } else {
            zzfey.a(this.f30900f, zzfde.f30882a);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void m0(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.m0(zzeVar);
            return;
        }
        AtomicReference atomicReference = this.f30896b;
        zzfey.a(atomicReference, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfdh
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((zzbeg) obj).t0(zzeVar);
            }
        });
        zzfey.a(atomicReference, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfdi
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((zzbeg) obj).l(zzeVar.f21161a);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w8() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.zzh();
            return;
        }
        zzfey.a(this.f30900f, zzfdf.f30883a);
        AtomicReference atomicReference = this.f30898d;
        zzfey.a(atomicReference, zzfdn.f30891a);
        zzfey.a(atomicReference, zzfdo.f30892a);
    }

    @Override // com.google.android.gms.internal.ads.zzdcj
    public final void zzl() {
        zzfdr zzfdrVar = this.f30902h;
        if (zzfdrVar != null) {
            zzfdrVar.zzl();
        } else {
            zzfey.a(this.f30899e, zzfdc.f30880a);
        }
    }
}
