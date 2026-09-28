package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzgdx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f32350a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgec f32351b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f32352c;

    /* renamed from: d, reason: collision with root package name */
    public final String f32353d;

    /* renamed from: e, reason: collision with root package name */
    public final zzavs f32354e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgev f32355f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgnc f32356g;

    public zzgdx(zzgyw zzgywVar, zzgec zzgecVar, zzgev zzgevVar, zzgba zzgbaVar, String str, zzavs zzavsVar, zzijs zzijsVar, zzijs zzijsVar2, zzijs zzijsVar3, zzgnc zzgncVar) {
        this.f32350a = zzgywVar;
        this.f32351b = zzgecVar;
        this.f32353d = str;
        this.f32355f = zzgevVar;
        this.f32354e = zzavsVar;
        this.f32356g = zzgncVar;
        int iOrdinal = zzgbaVar.ordinal();
        if (iOrdinal == 0) {
            this.f32352c = zzijsVar.zzb();
        } else if (iOrdinal == 1) {
            this.f32352c = zzijsVar2.zzb();
        } else {
            if (iOrdinal != 2) {
                throw new IllegalStateException();
            }
            this.f32352c = zzijsVar3.zzb();
        }
    }

    public final ListenableFuture a() {
        boolean z;
        zzgec zzgecVar = this.f32351b;
        synchronized (zzgecVar) {
            z = zzgecVar.f32373d;
        }
        if (!z) {
            return zzgym.a(Integer.toString(7));
        }
        boolean zZzb = this.f32355f.zzb();
        zzgyw zzgywVar = this.f32350a;
        if (!zZzb) {
            return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgdw
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzgdx zzgdxVar = this.f32349a;
                    zzgec zzgecVar2 = zzgdxVar.f32351b;
                    zzgecVar2.getClass();
                    zzavs zzavsVarF0 = zzawp.F0();
                    zzavsVarF0.o(16384);
                    return Base64.encodeToString(zzgecVar2.b(zzgdxVar.f32353d, ((zzawp) zzavsVarF0.l()).g(), true), 11);
                }
            }, zzgywVar);
        }
        Set set = this.f32352c;
        ArrayList arrayList = new ArrayList(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(zzgywVar.submit((zzgfy) it.next()));
        }
        return new zzgyl(zzgtd.r(arrayList), false).a(new Callable() { // from class: com.google.android.gms.internal.ads.zzgdu
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                final zzgdx zzgdxVar = this.f32347a;
                zzgdxVar.getClass();
                Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzgdv
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        zzgdx zzgdxVar2 = zzgdxVar;
                        zzawp zzawpVar = (zzawp) zzgdxVar2.f32354e.l();
                        String str = zzgdxVar2.f32353d;
                        zzgec zzgecVar2 = zzgdxVar2.f32351b;
                        try {
                            return Base64.encodeToString(((zzaxg) zzgecVar2.d(str, zzawpVar.g()).l()).g(), 11);
                        } catch (IllegalArgumentException unused) {
                            zzgecVar2.getClass();
                            zzavs zzavsVarF0 = zzawp.F0();
                            zzavsVarF0.o(4096);
                            return Base64.encodeToString(zzgecVar2.b(str, ((zzawp) zzavsVarF0.l()).g(), true), 11);
                        }
                    }
                };
                zzgna zzgnaVarA = zzgdxVar.f32356g.a(101);
                try {
                    zzgnaVarA.a();
                    Object objCall = callable.call();
                    zzgnaVarA.c();
                    return (String) objCall;
                } finally {
                }
            }
        }, zzgyb.f33369a);
    }
}
