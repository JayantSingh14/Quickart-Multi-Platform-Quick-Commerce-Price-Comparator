package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzfgv implements OnAdMetadataChangedListener, zzdby, zzdan, zzdak, zzdba, zzddb, zzffg, zzdir {

    /* renamed from: a, reason: collision with root package name */
    public final zzfjv f31076a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f31077b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f31078c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f31079d = new AtomicReference();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f31080e = new AtomicReference();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f31081f = new AtomicReference();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference f31082g = new AtomicReference();

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReference f31083h = new AtomicReference();

    /* renamed from: i, reason: collision with root package name */
    public final zzfgv f31084i = null;

    public zzfgv(zzfjv zzfjvVar) {
        this.f31076a = zzfjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void S() {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.S();
        } else {
            zzfey.a(this.f31079d, zzfgl.f31066a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void T() {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.T();
        } else {
            zzfey.a(this.f31080e, zzfgq.f31071a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void Y(final zzbzj zzbzjVar, final String str, final String str2) {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.Y(zzbzjVar, str, str2);
            return;
        }
        zzfey.a(this.f31079d, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfgb
            @Override // com.google.android.gms.internal.ads.zzfex
            public final void zza(Object obj) {
                zzbzj zzbzjVar2 = zzbzjVar;
                ((zzcai) obj).e7(new zzcaw(zzbzjVar2.f25777a, zzbzjVar2.f25778b));
            }
        });
        zzfey.a(this.f31081f, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfgc
            @Override // com.google.android.gms.internal.ads.zzfex
            public final void zza(Object obj) {
                zzcan zzcanVar = (zzcan) obj;
                zzbzj zzbzjVar2 = zzbzjVar;
                zzcaw zzcawVar = new zzcaw(zzbzjVar2.f25777a, zzbzjVar2.f25778b);
                Parcel parcelG = zzcanVar.g();
                zzbcd.e(parcelG, zzcawVar);
                parcelG.writeString(str);
                parcelG.writeString(str2);
                zzcanVar.j1(2, parcelG);
            }
        });
        zzfey.a(this.f31080e, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfgd
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((zzbzs) obj).Ua(zzbzjVar);
            }
        });
        zzfey.a(this.f31082g, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfge
            @Override // com.google.android.gms.internal.ads.zzfex
            public final void zza(Object obj) {
                zzbzn zzbznVar = (zzbzn) obj;
                Parcel parcelG = zzbznVar.g();
                zzbcd.e(parcelG, zzbzjVar);
                parcelG.writeString(str);
                parcelG.writeString(str2);
                zzbznVar.j1(2, parcelG);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddb
    public final void a(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.a(zztVar);
        } else {
            zzfey.a(this.f31083h, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfgh
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

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void b() {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.b();
            return;
        }
        zzfju zzfjuVar = this.f31076a.f31285a;
        if (zzfjuVar != null) {
            zzfkv zzfkvVar = ((zzfku) zzfjuVar).f31331a;
            synchronized (zzfkvVar) {
                zzfkvVar.f31336e = 1;
                zzfkvVar.a();
            }
        }
        zzfey.a(this.f31079d, zzfgk.f31065a);
        zzfey.a(this.f31080e, zzfgp.f31070a);
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void c(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.c(zzeVar);
            return;
        }
        AtomicReference atomicReference = this.f31079d;
        zzfey.a(atomicReference, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfgf
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((zzcai) obj).L5(zzeVar);
            }
        });
        zzfey.a(atomicReference, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfgg
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((zzcai) obj).zzh(zzeVar.f21161a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void g() {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.g();
            return;
        }
        AtomicReference atomicReference = this.f31079d;
        zzfey.a(atomicReference, zzfgm.f31067a);
        zzfey.a(this.f31080e, zzfgo.f31069a);
        zzfey.a(atomicReference, zzfgj.f31064a);
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void j() {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.j();
        } else {
            zzfey.a(this.f31077b, zzfgu.f31075a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void m0(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.m0(zzeVar);
            return;
        }
        AtomicReference atomicReference = this.f31078c;
        zzfey.a(atomicReference, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfgi
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((zzcam) obj).a(zzeVar);
            }
        });
        final int i2 = zzeVar.f21161a;
        zzfey.a(atomicReference, new zzfex() { // from class: com.google.android.gms.internal.ads.zzffz
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((zzcam) obj).zzf(i2);
            }
        });
        zzfey.a(this.f31080e, new zzfex() { // from class: com.google.android.gms.internal.ads.zzfga
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((zzbzs) obj).r(i2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zze() {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.zze();
        } else {
            zzfey.a(this.f31080e, zzfgr.f31072a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zzf() {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.zzf();
        } else {
            zzfey.a(this.f31080e, zzfgs.f31073a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        zzfgv zzfgvVar = this.f31084i;
        if (zzfgvVar != null) {
            zzfgvVar.zzg();
        } else {
            zzfey.a(this.f31078c, zzfgn.f31068a);
            zzfey.a(this.f31080e, zzfgt.f31074a);
        }
    }
}
