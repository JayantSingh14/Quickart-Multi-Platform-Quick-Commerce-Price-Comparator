package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzfel implements zzffj {

    /* renamed from: a, reason: collision with root package name */
    public zzczr f30964a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f30965b = zzgyb.f33369a;

    @Override // com.google.android.gms.internal.ads.zzffj
    public final /* bridge */ /* synthetic */ ListenableFuture a(zzffk zzffkVar, zzffi zzffiVar) {
        return b(zzffkVar, zzffiVar, null);
    }

    public final ListenableFuture b(zzffk zzffkVar, zzffi zzffiVar, zzczr zzczrVar) {
        zzczq zzczqVarA = zzffiVar.a(zzffkVar.f31012b);
        zzczqVarA.b(new zzffn());
        zzczr zzczrVar2 = (zzczr) zzczqVarA.zzh();
        this.f30964a = zzczrVar2;
        final zzcwo zzcwoVarZza = zzczrVar2.zza();
        final zzfki zzfkiVar = new zzfki();
        zzgye zzgyeVarS = zzgye.s(zzcwoVarZza.b());
        zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfek
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                zzfic zzficVar = (zzfic) obj;
                zzfkiVar.f31318b = zzficVar;
                Iterator it = zzficVar.f31194b.f31189a.iterator();
                boolean z = false;
                loop0: while (true) {
                    if (it.hasNext()) {
                        Iterator it2 = ((zzfhr) it.next()).f31149a.iterator();
                        while (it2.hasNext()) {
                            if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                                break loop0;
                            }
                            z = true;
                        }
                    } else if (z) {
                        return zzcwoVarZza.c(zzgym.a(zzficVar));
                    }
                }
                return zzgyq.f33377b;
            }
        };
        zzgyb zzgybVar = zzgyb.f33369a;
        return (zzgye) zzgym.i((zzgye) zzgym.h(zzgyeVarS, zzgxuVar, zzgybVar), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzfej
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                zzfki zzfkiVar2 = zzfkiVar;
                zzfkiVar2.f31319c = (zzcvk) obj;
                return zzfkiVar2;
            }
        }, zzgybVar);
    }

    @Override // com.google.android.gms.internal.ads.zzffj
    public final /* synthetic */ Object zzd() {
        return this.f30964a;
    }
}
