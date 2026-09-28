package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzdtb implements zzbof {

    /* renamed from: a, reason: collision with root package name */
    public final zzdbr f28511a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbzy f28512b;

    /* renamed from: c, reason: collision with root package name */
    public final String f28513c;

    /* renamed from: d, reason: collision with root package name */
    public final String f28514d;

    public zzdtb(zzdbr zzdbrVar, zzfhr zzfhrVar) {
        this.f28511a = zzdbrVar;
        this.f28512b = zzfhrVar.f31160l;
        this.f28513c = zzfhrVar.f31158j;
        this.f28514d = zzfhrVar.f31159k;
    }

    @Override // com.google.android.gms.internal.ads.zzbof
    public final void P(zzbzy zzbzyVar) {
        int i2;
        String str;
        zzbzy zzbzyVar2 = this.f28512b;
        if (zzbzyVar2 != null) {
            zzbzyVar = zzbzyVar2;
        }
        if (zzbzyVar != null) {
            str = zzbzyVar.f25781a;
            i2 = zzbzyVar.f25782b;
        } else {
            i2 = 1;
            str = "";
        }
        final zzbzj zzbzjVar = new zzbzj(str, i2);
        zzdbr zzdbrVar = this.f28511a;
        zzdbrVar.getClass();
        final String str2 = this.f28513c;
        final String str3 = this.f28514d;
        zzdbrVar.v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzdbo
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final /* synthetic */ void zza(Object obj) {
                ((zzdak) obj).Y(zzbzjVar, str2, str3);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbof
    public final void g() {
        this.f28511a.v0(zzdbn.f27588a);
    }

    @Override // com.google.android.gms.internal.ads.zzbof
    public final void zzc() {
        this.f28511a.v0(zzdbp.f27592a);
    }
}
