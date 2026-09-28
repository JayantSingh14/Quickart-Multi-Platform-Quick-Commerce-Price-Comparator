package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzeoi implements zzejg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeji f29959a;

    /* renamed from: b, reason: collision with root package name */
    public final zzejm f29960b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfmu f29961c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgyw f29962d;

    public zzeoi(zzfmu zzfmuVar, zzgyw zzgywVar, zzeji zzejiVar, zzejm zzejmVar) {
        this.f29961c = zzfmuVar;
        this.f29962d = zzgywVar;
        this.f29960b = zzejmVar;
        this.f29959a = zzejiVar;
    }

    public static final String c(int i2, String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(i2).length());
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i2);
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdbu] */
    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(final zzfic zzficVar, final zzfhr zzfhrVar) {
        final zzejj zzejjVarA;
        Iterator it = zzfhrVar.t.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzejjVarA = null;
                break;
            }
            try {
                zzejjVarA = this.f29959a.a((String) it.next(), zzfhrVar.v);
                break;
            } catch (zzfir unused) {
            }
        }
        if (zzejjVarA == null) {
            return zzgym.b(new zzelz(3, "Unable to instantiate mediation adapter class."));
        }
        zzcdt zzcdtVar = new zzcdt();
        zzejjVarA.f29464c.m9(new zzeof(this, zzejjVarA, zzcdtVar));
        if (zzfhrVar.M) {
            Bundle bundle = zzficVar.f31193a.f31185a.f31216d.f21266m;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfmo zzfmoVar = zzfmo.ADAPTER_LOAD_AD_SYN;
        zzfmu zzfmuVar = this.f29961c;
        Objects.requireNonNull(zzfmuVar);
        zzfml zzfmlVar = new zzfml(zzfmuVar, zzfmoVar, null, zzfmm.f31404d, Collections.EMPTY_LIST, this.f29962d.submit(new zzfme(new zzfma() { // from class: com.google.android.gms.internal.ads.zzeoh
            @Override // com.google.android.gms.internal.ads.zzfma
            public final /* synthetic */ void zza() {
                this.f29955a.f29960b.b(zzficVar, zzfhrVar, zzejjVarA);
            }
        })));
        zzfmo zzfmoVar2 = zzfmo.ADAPTER_LOAD_AD_ACK;
        zzfml zzfmlVarA = zzfmlVar.f31403f.a(zzfmlVar.d(), zzfmoVar2);
        ListenableFuture listenableFutureH = zzgym.h(zzfmlVarA.f31402e, new zzfmh(zzcdtVar), zzcdo.f25988g);
        zzfml zzfmlVar2 = new zzfml(zzfmlVarA.f31403f, zzfmlVarA.f31398a, zzfmlVarA.f31399b, zzfmlVarA.f31400c, zzfmlVarA.f31401d, listenableFutureH);
        zzfmo zzfmoVar3 = zzfmo.ADAPTER_WRAP_ADAPTER;
        return zzfmlVar2.f31403f.a(zzfmlVar2.d(), zzfmoVar3).a(new zzflu() { // from class: com.google.android.gms.internal.ads.zzeog
            @Override // com.google.android.gms.internal.ads.zzflu
            public final /* synthetic */ Object zza(Object obj) {
                return this.f29951a.f29960b.a(zzficVar, zzfhrVar, zzejjVarA);
            }
        }).d();
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        return !zzfhrVar.t.isEmpty();
    }
}
