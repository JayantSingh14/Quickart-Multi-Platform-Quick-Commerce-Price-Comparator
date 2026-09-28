package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbfp;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public final class zzdvt implements zzddq, zzdby, zzdan, zzdbe, com.google.android.gms.ads.internal.client.zza, zzdgb {

    /* renamed from: a, reason: collision with root package name */
    public final zzbfj f28643a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f28644b = false;

    public zzdvt(zzbfj zzbfjVar, zzffn zzffnVar) {
        this.f28643a = zzbfjVar;
        zzbfjVar.b(2);
        if (zzffnVar != null) {
            zzbfjVar.b(1101);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void F(final zzfic zzficVar) {
        this.f28643a.a(new zzbfi() { // from class: com.google.android.gms.internal.ads.zzdvs
            @Override // com.google.android.gms.internal.ads.zzbfi
            public final void a(zzbfp.zzt.zza zzaVar) {
                zzbfp.zza.zzb zzbVar = (zzbfp.zza.zzb) ((zzbfp.zzt) zzaVar.f34638b).E().v();
                zzbfp.zzi.zza zzaVar2 = (zzbfp.zzi.zza) ((zzbfp.zzt) zzaVar.f34638b).E().G().v();
                String str = zzficVar.f31194b.f31190b.f31167b;
                zzaVar2.j();
                ((zzbfp.zzi) zzaVar2.f34638b).D(str);
                zzbVar.j();
                ((zzbfp.zza) zzbVar.f34638b).E((zzbfp.zzi) zzaVar2.l());
                zzaVar.j();
                ((zzbfp.zzt) zzaVar.f34638b).K((zzbfp.zza) zzbVar.l());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final synchronized void f() {
        this.f28643a.b(6);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void h() {
        if (this.f28644b) {
            this.f28643a.b(8);
        } else {
            this.f28643a.b(7);
            this.f28644b = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void i0(boolean z) {
        this.f28643a.b(true != z ? 1106 : 1105);
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void l0(boolean z) {
        this.f28643a.b(true != z ? 1108 : 1107);
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void m(final zzbfp.zzb zzbVar) {
        zzbfi zzbfiVar = new zzbfi() { // from class: com.google.android.gms.internal.ads.zzdvq
            @Override // com.google.android.gms.internal.ads.zzbfi
            public final void a(zzbfp.zzt.zza zzaVar) {
                zzbfp.zzb zzbVar2 = zzbVar;
                zzaVar.j();
                ((zzbfp.zzt) zzaVar.f34638b).F(zzbVar2);
            }
        };
        zzbfj zzbfjVar = this.f28643a;
        zzbfjVar.a(zzbfiVar);
        zzbfjVar.b(1102);
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void m0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        int i2 = zzeVar.f21161a;
        zzbfj zzbfjVar = this.f28643a;
        switch (i2) {
            case 1:
                zzbfjVar.b(101);
                break;
            case 2:
                zzbfjVar.b(102);
                break;
            case 3:
                zzbfjVar.b(5);
                break;
            case 4:
                zzbfjVar.b(103);
                break;
            case 5:
                zzbfjVar.b(104);
                break;
            case 6:
                zzbfjVar.b(105);
                break;
            case 7:
                zzbfjVar.b(Type.L64);
                break;
            default:
                zzbfjVar.b(4);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void s0(final zzbfp.zzb zzbVar) {
        zzbfi zzbfiVar = new zzbfi() { // from class: com.google.android.gms.internal.ads.zzdvr
            @Override // com.google.android.gms.internal.ads.zzbfi
            public final void a(zzbfp.zzt.zza zzaVar) {
                zzbfp.zzb zzbVar2 = zzbVar;
                zzaVar.j();
                ((zzbfp.zzt) zzaVar.f34638b).F(zzbVar2);
            }
        };
        zzbfj zzbfjVar = this.f28643a;
        zzbfjVar.a(zzbfiVar);
        zzbfjVar.b(1104);
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void y(final zzbfp.zzb zzbVar) {
        zzbfi zzbfiVar = new zzbfi() { // from class: com.google.android.gms.internal.ads.zzdvp
            @Override // com.google.android.gms.internal.ads.zzbfi
            public final void a(zzbfp.zzt.zza zzaVar) {
                zzbfp.zzb zzbVar2 = zzbVar;
                zzaVar.j();
                ((zzbfp.zzt) zzaVar.f34638b).F(zzbVar2);
            }
        };
        zzbfj zzbfjVar = this.f28643a;
        zzbfjVar.a(zzbfiVar);
        zzbfjVar.b(1103);
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        this.f28643a.b(3);
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void zzo() {
        this.f28643a.b(1109);
    }
}
