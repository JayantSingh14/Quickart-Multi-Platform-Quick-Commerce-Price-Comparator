package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzeou implements zzejg {

    /* renamed from: a, reason: collision with root package name */
    public final zzbhf f30003a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f30004b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfmu f30005c;

    /* renamed from: d, reason: collision with root package name */
    public final zzepd f30006d;

    public zzeou(zzfmu zzfmuVar, zzgyw zzgywVar, zzbhf zzbhfVar, zzepd zzepdVar) {
        this.f30005c = zzfmuVar;
        this.f30004b = zzgywVar;
        this.f30003a = zzbhfVar;
        this.f30006d = zzepdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(zzfic zzficVar, zzfhr zzfhrVar) {
        zzcdt zzcdtVar = new zzcdt();
        zzeoz zzeozVar = new zzeoz();
        zzeos zzeosVar = new zzeos(this, zzcdtVar, zzficVar, zzfhrVar, zzeozVar);
        synchronized (zzeozVar) {
            zzeozVar.f30014a = zzeosVar;
        }
        zzfhw zzfhwVar = zzfhrVar.s;
        final zzbha zzbhaVar = new zzbha(zzeozVar, zzfhwVar.f31180b, zzfhwVar.f31179a);
        zzfmo zzfmoVar = zzfmo.CUSTOM_RENDER_SYN;
        zzfmu zzfmuVar = this.f30005c;
        Objects.requireNonNull(zzfmuVar);
        zzfma zzfmaVar = new zzfma() { // from class: com.google.android.gms.internal.ads.zzeot
            @Override // com.google.android.gms.internal.ads.zzfma
            public final /* synthetic */ void zza() {
                this.f30001a.f30003a.u4(zzbhaVar);
            }
        };
        zzfml zzfmlVar = new zzfml(zzfmuVar, zzfmoVar, null, zzfmm.f31404d, Collections.EMPTY_LIST, this.f30004b.submit(new zzfme(zzfmaVar)));
        zzfmo zzfmoVar2 = zzfmo.CUSTOM_RENDER_ACK;
        zzfml zzfmlVarA = zzfmlVar.f31403f.a(zzfmlVar.d(), zzfmoVar2);
        ListenableFuture listenableFutureH = zzgym.h(zzfmlVarA.f31402e, new zzfmh(zzcdtVar), zzcdo.f25988g);
        return new zzfml(zzfmlVarA.f31403f, zzfmlVarA.f31398a, zzfmlVarA.f31399b, zzfmlVarA.f31400c, zzfmlVarA.f31401d, listenableFutureH).d();
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        zzfhw zzfhwVar;
        return (this.f30003a == null || (zzfhwVar = zzfhrVar.s) == null || zzfhwVar.f31179a == null) ? false : true;
    }
}
