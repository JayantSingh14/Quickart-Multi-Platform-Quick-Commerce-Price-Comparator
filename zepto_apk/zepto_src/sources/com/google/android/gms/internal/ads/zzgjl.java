package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
final class zzgjl implements zzgje {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32725a;

    /* renamed from: b, reason: collision with root package name */
    public final zzija f32726b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgjv f32727c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgnc f32728d;

    /* renamed from: e, reason: collision with root package name */
    public final ExecutorService f32729e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgic f32730f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfuf f32731g;

    public zzgjl(Context context, zzija zzijaVar, zzgjv zzgjvVar, zzgnc zzgncVar, ExecutorService executorService, zzgic zzgicVar, zzfuf zzfufVar) {
        this.f32725a = context;
        this.f32726b = zzijaVar;
        this.f32727c = zzgjvVar;
        this.f32728d = zzgncVar;
        this.f32729e = executorService;
        this.f32730f = zzgicVar;
        this.f32731g = zzfufVar;
    }

    public static zzgcq a(int i2) {
        zzgcp zzgcpVarF = zzgcq.F();
        zzgcpVarF.j();
        ((zzgcq) zzgcpVarF.f34638b).K(i2);
        return (zzgcq) zzgcpVarF.l();
    }

    @Override // com.google.android.gms.internal.ads.zzgje
    public final zzgye zza() {
        final zzija zzijaVar = this.f32726b;
        Objects.requireNonNull(zzijaVar);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzgjg
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzijaVar.zzb();
            }
        };
        ExecutorService executorService = this.f32729e;
        zzgye zzgyeVarS = zzgye.s(zzgym.c(callable, executorService));
        zzgpr zzgprVar = new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgjk
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                zzbbq zzbbqVar = (zzbbq) obj;
                zzgjl zzgjlVar = this.f32724a;
                zzgjlVar.getClass();
                if (zzfvc.a(zzbbqVar)) {
                    return new Integer(0);
                }
                zzgjlVar.f32728d.c(15204, zzbbqVar.name());
                throw new zzgjf();
            }
        };
        zzgyb zzgybVar = zzgyb.f33369a;
        zzgye zzgyeVar = (zzgye) zzgym.e((zzgye) zzgym.i((zzgye) zzgym.h((zzgye) zzgym.i(zzgyeVarS, zzgprVar, zzgybVar), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzgjh
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.f32721a.f32727c.zzb();
            }
        }, zzgybVar), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgji
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                boolean zA;
                zzgcs zzgcsVar = (zzgcs) obj;
                zzgjl zzgjlVar = this.f32722a;
                zzija zzijaVar2 = zzgjlVar.f32726b;
                String strC = zzgcsVar.C().C();
                String strD = zzgcsVar.C().D();
                zzgnc zzgncVar = zzgjlVar.f32728d;
                zzgna zzgnaVarA = zzgncVar.a(15203);
                try {
                    zzgnaVarA.a();
                    zzfvt zzfvtVarA = zzfuo.a(zzgjlVar.f32725a, (zzbbq) zzijaVar2.zzb(), strC, strD, zzgjlVar.f32731g);
                    zzgnaVarA.c();
                    int i2 = 2;
                    int i3 = zzfvtVarA.f31948c;
                    if (i3 == 2) {
                        zzgncVar.b(15208);
                        return zzgjl.a(4);
                    }
                    byte[] bArr = zzfvtVarA.f31947b;
                    if (bArr == null || bArr.length == 0) {
                        zzgncVar.b(5010);
                        return zzgjl.a(8);
                    }
                    try {
                        zzbbs zzbbsVarG = zzbbs.G(bArr, zziab.a());
                        if (zzbbsVarG.C().C().isEmpty() || zzbbsVarG.C().D().isEmpty() || zzbbsVarG.E().z().length == 0) {
                            zzgncVar.b(15207);
                        } else {
                            if (zzgcsVar.equals(zzgcs.H()) || !TextUtils.equals(zzgcsVar.C().C(), zzbbsVarG.C().C()) || !TextUtils.equals(zzgcsVar.C().D(), zzbbsVarG.C().D())) {
                                if (i3 == 4) {
                                    byte[] bArrZ = zzbbsVarG.D().z();
                                    zzgic zzgicVar = zzgjlVar.f32730f;
                                    File file = zzgicVar.f32638a;
                                    try {
                                        zzgwk.b(file);
                                        zzgwk.a(file, bArrZ);
                                        zA = zzgicVar.f32639b.a(file);
                                    } catch (IOException | GeneralSecurityException e2) {
                                        zzgicVar.f32640c.d(2027, e2);
                                        zA = false;
                                    }
                                    try {
                                        file.delete();
                                    } catch (SecurityException unused) {
                                    }
                                    if (!zA) {
                                        zzgncVar.b(15206);
                                        return zzgjl.a(12);
                                    }
                                    i3 = 4;
                                }
                                zzgcp zzgcpVarF = zzgcq.F();
                                if (i3 == 2) {
                                    i2 = 4;
                                } else if (i3 != 3) {
                                    i2 = i3 != 4 ? i3 != 6 ? 1 : 5 : 3;
                                }
                                zzgcpVarF.j();
                                ((zzgcq) zzgcpVarF.f34638b).K(i2);
                                zzgcr zzgcrVarG = zzgcs.G();
                                zzbby zzbbyVarC = zzbbsVarG.C();
                                zzgcrVarG.j();
                                ((zzgcs) zzgcrVarG.f34638b).I(zzbbyVarC);
                                zzbbq zzbbqVar = (zzbbq) zzijaVar2.zzb();
                                zzgcrVarG.j();
                                ((zzgcs) zzgcrVarG.f34638b).K(zzbbqVar);
                                zzgcs zzgcsVar2 = (zzgcs) zzgcrVarG.l();
                                zzgcpVarF.j();
                                ((zzgcq) zzgcpVarF.f34638b).G(zzgcsVar2);
                                zzhzl zzhzlVarD = zzbbsVarG.D();
                                zzgcpVarF.j();
                                ((zzgcq) zzgcpVarF.f34638b).I(zzhzlVarD);
                                zzhzl zzhzlVarE = zzbbsVarG.E();
                                zzgcpVarF.j();
                                ((zzgcq) zzgcpVarF.f34638b).H(zzhzlVarE);
                                return (zzgcq) zzgcpVarF.l();
                            }
                            zzgncVar.b(15209);
                        }
                        return zzgjl.a(11);
                    } catch (zzibg e3) {
                        zzgncVar.d(15205, e3);
                        return zzgjl.a(9);
                    } catch (NullPointerException unused2) {
                        zzgncVar.b(15210);
                        return zzgjl.a(10);
                    }
                } catch (Throwable th) {
                    try {
                        zzgnaVarA.b(th);
                        throw th;
                    } catch (Throwable th2) {
                        zzgnaVarA.c();
                        throw th2;
                    }
                }
            }
        }, executorService), zzgjf.class, zzgjj.f32723a, zzgybVar);
        this.f32728d.e(15202, zzgyeVar);
        return zzgyeVar;
    }
}
