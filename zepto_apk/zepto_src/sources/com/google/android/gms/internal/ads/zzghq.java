package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzghq {

    /* renamed from: a, reason: collision with root package name */
    public final zzgls f32597a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgje f32598b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgjv f32599c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgnc f32600d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgbj f32601e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f32602f;

    /* renamed from: g, reason: collision with root package name */
    public final long f32603g;

    /* renamed from: h, reason: collision with root package name */
    public final long f32604h;

    public zzghq(zzgls zzglsVar, zzgje zzgjeVar, zzgjv zzgjvVar, zzgnc zzgncVar, zzgbj zzgbjVar, boolean z, long j2, long j3) {
        this.f32597a = zzglsVar;
        this.f32598b = zzgjeVar;
        this.f32599c = zzgjvVar;
        this.f32600d = zzgncVar;
        this.f32601e = zzgbjVar;
        this.f32602f = z;
        this.f32603g = j2;
        this.f32604h = j3;
    }

    public final zzgye a() {
        zzgye zzgyeVarS = zzgye.s(this.f32599c.zzb());
        zzghf zzghfVar = zzghf.f32578a;
        zzgyb zzgybVar = zzgyb.f33369a;
        zzgye zzgyeVar = (zzgye) zzgym.e(zzgyeVarS, Throwable.class, zzghfVar, zzgybVar);
        final zzgls zzglsVar = this.f32597a;
        Objects.requireNonNull(zzglsVar);
        return (zzgye) zzgym.h((zzgye) zzgym.i(zzgyeVar, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzghe
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                return new Boolean(zzglsVar.b((zzgcs) obj));
            }
        }, zzgybVar), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzghg
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                zzghq zzghqVar = this.f32579a;
                zzghqVar.getClass();
                if (((Boolean) obj).booleanValue()) {
                    return zzghqVar.b(0);
                }
                zzghqVar.f32600d.b(1003);
                return zzgym.a(zzghp.f32591b);
            }
        }, zzgybVar);
    }

    public final zzgye b(final int i2) {
        zzgye zzgyeVarS = zzgye.s(this.f32598b.zza());
        zzgpr zzgprVar = new zzgpr() { // from class: com.google.android.gms.internal.ads.zzghh
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                zzgcq zzgcqVar = (zzgcq) obj;
                zzghq zzghqVar = this.f32580a;
                zzghqVar.getClass();
                int iJ = zzgcqVar.J() - 1;
                if (iJ == 1 || iJ == 2) {
                    return zzgcqVar;
                }
                zzgnc zzgncVar = zzghqVar.f32600d;
                if (iJ == 3) {
                    int iJ2 = zzgcqVar.J() - 1;
                    StringBuilder sb = new StringBuilder(String.valueOf(iJ2).length());
                    sb.append(iJ2);
                    zzgncVar.c(1004, sb.toString());
                    int iJ3 = zzgcqVar.J() - 1;
                    throw new zzghd(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iJ3).length() + 3), iJ3, "r: "));
                }
                if (iJ != 12) {
                    int iJ4 = zzgcqVar.J() - 1;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iJ4).length());
                    sb2.append(iJ4);
                    zzgncVar.c(1005, sb2.toString());
                    int iJ5 = zzgcqVar.J() - 1;
                    throw new zzghc(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iJ5).length() + 3), iJ5, "r: "));
                }
                int iJ6 = zzgcqVar.J() - 1;
                StringBuilder sb3 = new StringBuilder(String.valueOf(iJ6).length());
                sb3.append(iJ6);
                zzgncVar.c(1005, sb3.toString());
                int iJ7 = zzgcqVar.J() - 1;
                throw new zzghb(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iJ7).length() + 3), iJ7, "r: "));
            }
        };
        zzgyb zzgybVar = zzgyb.f33369a;
        zzgye zzgyeVar = (zzgye) zzgym.e((zzgye) zzgym.e((zzgye) zzgym.e((zzgye) zzgym.i((zzgye) zzgym.h((zzgye) zzgym.i(zzgyeVarS, zzgprVar, zzgybVar), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzghi
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                zzgcq zzgcqVar = (zzgcq) obj;
                zzghq zzghqVar = this.f32581a;
                zzghqVar.getClass();
                int iJ = zzgcqVar.J();
                zzgjv zzgjvVar = zzghqVar.f32599c;
                if (iJ == 2) {
                    return zzgjvVar.b(zzgcqVar.C(), zzgcqVar.D().z());
                }
                if (zzgcqVar.J() == 3) {
                    return zzgjvVar.a(zzgcqVar.C(), zzgcqVar.E().z(), zzgcqVar.D().z());
                }
                throw new AssertionError("Unreachable");
            }
        }, zzgybVar), zzghj.f32582a, zzgybVar), zzghc.class, zzghk.f32583a, zzgybVar), zzghd.class, zzghl.f32584a, zzgybVar), zzghb.class, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzghm
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                final zzghq zzghqVar = this.f32585a;
                if (zzghqVar.f32602f) {
                    final int i3 = i2;
                    if (i3 < zzghqVar.f32603g) {
                        zzghqVar.f32601e.a(zzghqVar.f32604h * ((long) Math.pow(2.0d, i3)), new Runnable() { // from class: com.google.android.gms.internal.ads.zzghn
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzghqVar.b(i3 + 1);
                            }
                        });
                    }
                }
                return zzghp.f32595f;
            }
        }, zzgybVar);
        this.f32600d.e(1002, zzgyeVar);
        return zzgyeVar;
    }
}
