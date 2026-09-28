package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzeop implements zzejg {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29986a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcuh f29987b;

    /* renamed from: c, reason: collision with root package name */
    public final zzbhf f29988c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgyw f29989d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfmu f29990e;

    public zzeop(Context context, zzcuh zzcuhVar, zzfmu zzfmuVar, zzgyw zzgywVar, zzbhf zzbhfVar) {
        this.f29986a = context;
        this.f29987b = zzcuhVar;
        this.f29990e = zzfmuVar;
        this.f29989d = zzgywVar;
        this.f29988c = zzbhfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(zzfic zzficVar, zzfhr zzfhrVar) {
        zzeol zzeolVar = new zzeol(new View(this.f29986a), null, zzeon.f29979a, (zzfhs) zzfhrVar.u.get(0));
        zzctd zzctdVarD = this.f29987b.d(new zzcwa(zzficVar, zzfhrVar, null), zzeolVar);
        zzcnb zzcnbVar = (zzcnb) zzctdVarD;
        zzeoo zzeooVar = new zzeoo((zzdai) zzcnbVar.w.zzb(), (zzdbc) zzcnbVar.z.zzb(), (zzdit) zzcnbVar.B.zzb(), (zzdil) zzcnbVar.K.zzb(), (zzcrx) zzcnbVar.f26631h.zzb());
        zzfhw zzfhwVar = zzfhrVar.s;
        final zzbha zzbhaVar = new zzbha(zzeooVar, zzfhwVar.f31180b, zzfhwVar.f31179a);
        zzfmo zzfmoVar = zzfmo.CUSTOM_RENDER_SYN;
        zzfmu zzfmuVar = this.f29990e;
        Objects.requireNonNull(zzfmuVar);
        zzfml zzfmlVar = new zzfml(zzfmuVar, zzfmoVar, null, zzfmm.f31404d, Collections.EMPTY_LIST, this.f29989d.submit(new zzfme(new zzfma() { // from class: com.google.android.gms.internal.ads.zzeom
            @Override // com.google.android.gms.internal.ads.zzfma
            public final /* synthetic */ void zza() {
                this.f29977a.f29988c.u4(zzbhaVar);
            }
        })));
        zzfmo zzfmoVar2 = zzfmo.CUSTOM_RENDER_ACK;
        zzfml zzfmlVarA = zzfmlVar.f31403f.a(zzfmlVar.d(), zzfmoVar2);
        ListenableFuture listenableFutureH = zzgym.h(zzfmlVarA.f31402e, new zzfmh(zzgym.a(zzctdVarD.g())), zzcdo.f25988g);
        return new zzfml(zzfmlVarA.f31403f, zzfmlVarA.f31398a, zzfmlVarA.f31399b, zzfmlVarA.f31400c, zzfmlVarA.f31401d, listenableFutureH).d();
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        zzfhw zzfhwVar;
        return (this.f29988c == null || (zzfhwVar = zzfhrVar.s) == null || zzfhwVar.f31179a == null) ? false : true;
    }
}
