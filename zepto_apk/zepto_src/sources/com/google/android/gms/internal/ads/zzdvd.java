package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbfp;

/* loaded from: classes4.dex */
public final class zzdvd implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f28625a;

    /* renamed from: b, reason: collision with root package name */
    public final zzecm f28626b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcmg f28627c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijp f28628d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f28629e;

    public zzdvd(zzclp zzclpVar, zzecm zzecmVar, zzcmg zzcmgVar, zzijp zzijpVar, zzijf zzijfVar) {
        this.f28625a = zzclpVar;
        this.f28626b = zzecmVar;
        this.f28627c = zzcmgVar;
        this.f28628d = zzijpVar;
        this.f28629e = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f28625a.a();
        final String packageName = this.f28626b.f29063a.a().getPackageName();
        zzijo.a(packageName);
        VersionInfoParcel versionInfoParcelA = this.f28627c.a();
        final zzbfp.zza.EnumC0023zza enumC0023zza = (zzbfp.zza.EnumC0023zza) this.f28628d.zzb();
        final String str = (String) this.f28629e.zzb();
        zzbfj zzbfjVar = new zzbfj(new zzbfo(contextA));
        zzbfp.zzar.zza zzaVarE = zzbfp.zzar.E();
        int i2 = versionInfoParcelA.f21401b;
        zzaVarE.j();
        ((zzbfp.zzar) zzaVarE.f34638b).F(i2);
        int i3 = versionInfoParcelA.f21402c;
        zzaVarE.j();
        ((zzbfp.zzar) zzaVarE.f34638b).G(i3);
        int i4 = true != versionInfoParcelA.f21403d ? 2 : 0;
        zzaVarE.j();
        ((zzbfp.zzar) zzaVarE.f34638b).C(i4);
        final zzbfp.zzar zzarVar = (zzbfp.zzar) zzaVarE.l();
        zzbfjVar.a(new zzbfi() { // from class: com.google.android.gms.internal.ads.zzdvc
            @Override // com.google.android.gms.internal.ads.zzbfi
            public final void a(zzbfp.zzt.zza zzaVar) {
                zzbfp.zza.zzb zzbVar = (zzbfp.zza.zzb) ((zzbfp.zzt) zzaVar.f34638b).E().v();
                zzbVar.j();
                ((zzbfp.zza) zzbVar.f34638b).D(enumC0023zza);
                zzaVar.j();
                ((zzbfp.zzt) zzaVar.f34638b).K((zzbfp.zza) zzbVar.l());
                zzbfp.zzm.zza zzaVar2 = (zzbfp.zzm.zza) ((zzbfp.zzt) zzaVar.f34638b).C().v();
                zzaVar2.j();
                ((zzbfp.zzm) zzaVar2.f34638b).D(packageName);
                zzbfp.zzar zzarVar2 = zzarVar;
                zzaVar2.j();
                ((zzbfp.zzm) zzaVar2.f34638b).E(zzarVar2);
                zzaVar.j();
                ((zzbfp.zzt) zzaVar.f34638b).J((zzbfp.zzm) zzaVar2.l());
                zzaVar.j();
                ((zzbfp.zzt) zzaVar.f34638b).D(str);
            }
        });
        return zzbfjVar;
    }
}
