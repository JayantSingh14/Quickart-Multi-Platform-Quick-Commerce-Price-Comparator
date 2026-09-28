package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.internal.ads.zzbfp;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public final class zzfew implements zzffj {

    /* renamed from: a, reason: collision with root package name */
    public final zzfjz f30992a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f30993b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyj f30994c = new zzfet();

    public zzfew(zzfjz zzfjzVar, zzgyw zzgywVar) {
        this.f30992a = zzfjzVar;
        this.f30993b = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffj
    public final /* bridge */ /* synthetic */ ListenableFuture a(zzffk zzffkVar, zzffi zzffiVar) {
        return b(null);
    }

    public final zzgye b(final zzczr zzczrVar) {
        ListenableFuture listenableFutureA;
        ListenableFuture listenableFutureA2;
        zzfjz zzfjzVar = this.f30992a;
        zzgyw zzgywVar = this.f30993b;
        zzfff zzfffVar = new zzfff(zzfjzVar, zzczrVar, zzgywVar);
        zzffd zzffdVar = zzfffVar.f31010d;
        if (zzffdVar == null) {
            if (((Boolean) zzbir.f25210a.c()).booleanValue()) {
                final zzcwo zzcwoVarZza = zzczrVar.zza();
                zzfmo zzfmoVar = zzfmo.GET_CACHE_KEY;
                zzfml zzfmlVarA = zzcwoVarZza.f27290c.a(zzcwoVarZza.f27296i.b(), zzfmoVar);
                final zzfkg zzfkgVar = ((zzfka) zzfjzVar).f31293b;
                zzfmb zzfmbVarD = zzfmlVarA.b(new zzgxu() { // from class: com.google.android.gms.internal.ads.zzcwl
                    @Override // com.google.android.gms.internal.ads.zzgxu
                    public final ListenableFuture zza(Object obj) {
                        final zzbza zzbzaVar = (zzbza) obj;
                        zzcwo zzcwoVar = zzcwoVarZza;
                        zzbzaVar.f25728i = zzfkgVar;
                        final zzeer zzeerVar = zzcwoVar.f27295h;
                        zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.internal.ads.zzeel
                            @Override // com.google.android.gms.internal.ads.zzgxu
                            public final /* synthetic */ ListenableFuture zza(Object obj2) {
                                String str = new String(zzgwd.a((InputStream) obj2), StandardCharsets.UTF_8);
                                zzbza zzbzaVar2 = zzbzaVar;
                                zzbzaVar2.f25729j = str;
                                return zzgym.a(zzbzaVar2);
                            }
                        };
                        final zzedw zzedwVar = zzeerVar.f29191b;
                        return zzeerVar.a(zzbzaVar, new zzeeh() { // from class: com.google.android.gms.internal.ads.zzeei
                            @Override // com.google.android.gms.internal.ads.zzeeh
                            public final ListenableFuture a(zzbza zzbzaVar2) {
                                final zzedw zzedwVar2 = zzedwVar;
                                synchronized (zzedwVar2.f29149b) {
                                    try {
                                        int i2 = zzedwVar2.f29161h;
                                        if (i2 != 1 && i2 != 2) {
                                            return zzgym.b(new zzeef(2));
                                        }
                                        if (zzedwVar2.f29150c) {
                                            return zzedwVar2.f29148a;
                                        }
                                        zzedwVar2.f29161h = 2;
                                        zzedwVar2.f29150c = true;
                                        zzedwVar2.f29152e = zzbzaVar2;
                                        zzedwVar2.f29153f.checkAvailabilityAndConnect();
                                        zzcdt zzcdtVar = zzedwVar2.f29148a;
                                        zzcdtVar.f25992a.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedv
                                            @Override // java.lang.Runnable
                                            public final /* synthetic */ void run() {
                                                zzedwVar2.a();
                                            }
                                        }, zzcdo.f25988g);
                                        return zzcdtVar;
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }, new zzeeh() { // from class: com.google.android.gms.internal.ads.zzeem
                            @Override // com.google.android.gms.internal.ads.zzeeh
                            public final /* synthetic */ ListenableFuture a(zzbza zzbzaVar2) {
                                return ((zzefw) zzeerVar.f29192c.zzb()).Yb(zzbzaVar2, Binder.getCallingUid());
                            }
                        }, zzgxuVar);
                    }
                }).d();
                zzfmbVarD.q(new zzgyk(zzfmbVarD, new zzcwj(zzcwoVarZza)), zzcwoVarZza.f27297j);
                listenableFutureA2 = (zzgye) zzgym.e((zzgye) zzgym.i(zzgye.s(zzfmbVarD), new zzffc(zzfffVar), zzgywVar), zzeef.class, new zzffb(zzfffVar), zzgywVar);
            } else {
                zzfik zzfikVarZzb = zzczrVar.zzb();
                zzfkg zzfkgVar2 = ((zzfka) zzfjzVar).f31293b;
                zzbze zzbzeVarA = new zzbzd(zzfkgVar2.f31307a).a();
                zzffd zzffdVar2 = new zzffd(null, new zzfkk(zzfikVarZzb.f31216d, zzfikVarZzb.f31219g, zzbzeVarA.f25768j, zzfkgVar2.f31313g, zzfikVarZzb.f31223k));
                zzfffVar.f31010d = zzffdVar2;
                listenableFutureA2 = zzgym.a(zzffdVar2);
            }
            listenableFutureA = zzgym.i(listenableFutureA2, zzffe.f31006a, zzgywVar);
        } else {
            listenableFutureA = zzgym.a(zzffdVar);
        }
        return (zzgye) zzgym.e((zzgye) zzgym.h(zzgye.s(listenableFutureA), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfeu
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                zzfki zzfkiVar;
                zzffd zzffdVar3 = (zzffd) obj;
                zzfew zzfewVar = this.f30987a;
                zzfewVar.getClass();
                zzfkj zzfkjVar = zzffdVar3.f31005b;
                zzfka zzfkaVar = (zzfka) zzfewVar.f30992a;
                synchronized (zzfkaVar) {
                    try {
                        zzfjy zzfjyVar = (zzfjy) zzfkaVar.f31292a.get(zzfkjVar);
                        zzfkiVar = null;
                        if (zzfjyVar != null) {
                            zzfkx zzfkxVar = zzfjyVar.f31290d;
                            zzfkxVar.getClass();
                            zzfkxVar.f31341c = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
                            zzfkxVar.f31342d++;
                            zzfjyVar.a();
                            LinkedList linkedList = zzfjyVar.f31287a;
                            if (!linkedList.isEmpty() && (zzfkiVar = (zzfki) linkedList.remove()) != null) {
                                zzfkxVar.f31343e++;
                                zzfkxVar.f31340b.f31337a = true;
                            }
                            if (zzfkiVar == null) {
                                zzfkaVar.f31294c.f31301e++;
                            }
                            zzfkw zzfkwVar = zzfjyVar.f31290d.f31340b;
                            zzfkw zzfkwVarClone = zzfkwVar.clone();
                            zzfkwVar.f31337a = false;
                            zzfkwVar.f31338b = 0;
                            if (zzfkiVar != null) {
                                zzbfp.zzb.zzc zzcVarD = zzbfp.zzb.D();
                                zzbfp.zzb.zza.C0026zza c0026zzaE = zzbfp.zzb.zza.E();
                                c0026zzaE.j();
                                ((zzbfp.zzb.zza) c0026zzaE.f34638b).F();
                                zzbfp.zzb.zze.zza zzaVarC = zzbfp.zzb.zze.C();
                                boolean z = zzfkwVarClone.f31337a;
                                zzaVarC.j();
                                ((zzbfp.zzb.zze) zzaVarC.f34638b).E(z);
                                int i2 = zzfkwVarClone.f31338b;
                                zzaVarC.j();
                                ((zzbfp.zzb.zze) zzaVarC.f34638b).F(i2);
                                c0026zzaE.j();
                                ((zzbfp.zzb.zza) c0026zzaE.f34638b).G((zzbfp.zzb.zze) zzaVarC.l());
                                zzcVarD.j();
                                ((zzbfp.zzb) zzcVarD.f34638b).E((zzbfp.zzb.zza) c0026zzaE.l());
                                zzfkiVar.f31317a.zza().f27293f.y((zzbfp.zzb) zzcVarD.l());
                            }
                            zzfkaVar.b();
                        } else {
                            zzfkaVar.f31294c.f31300d++;
                            zzfkaVar.b();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                zzbza zzbzaVar = zzffdVar3.f31004a;
                if (zzfkiVar != null && zzbzaVar != null) {
                    zzcwo zzcwoVarZza2 = zzczrVar.zza();
                    zzfmo zzfmoVar2 = zzfmo.NOTIFY_CACHE_HIT;
                    final zzeer zzeerVar = zzcwoVarZza2.f27295h;
                    zzfmb zzfmbVarD2 = zzcwoVarZza2.f27290c.a(zzeerVar.a(zzbzaVar, new zzeeh() { // from class: com.google.android.gms.internal.ads.zzeeo
                        @Override // com.google.android.gms.internal.ads.zzeeh
                        public final ListenableFuture a(zzbza zzbzaVar2) {
                            final zzedw zzedwVar = zzeerVar.f29191b;
                            String str = zzbzaVar2.f25727h;
                            synchronized (zzedwVar.f29149b) {
                                try {
                                    int i3 = zzedwVar.f29161h;
                                    if (i3 != 1 && i3 != 3) {
                                        return zzgym.b(new zzeef(2));
                                    }
                                    if (zzedwVar.f29150c) {
                                        return zzedwVar.f29148a;
                                    }
                                    zzedwVar.f29161h = 3;
                                    zzedwVar.f29150c = true;
                                    zzedwVar.f29160g = str;
                                    zzedwVar.f29153f.checkAvailabilityAndConnect();
                                    zzcdt zzcdtVar = zzedwVar.f29148a;
                                    zzcdtVar.f25992a.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedu
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            zzedwVar.a();
                                        }
                                    }, zzcdo.f25988g);
                                    return zzcdtVar;
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                    }, new zzeeh() { // from class: com.google.android.gms.internal.ads.zzeep
                        @Override // com.google.android.gms.internal.ads.zzeeh
                        public final /* synthetic */ ListenableFuture a(zzbza zzbzaVar2) {
                            return ((zzefw) zzeerVar.f29192c.zzb()).Zb(zzbzaVar2.f25727h);
                        }
                    }, zzeen.f29186a), zzfmoVar2).d();
                    zzfmbVarD2.q(new zzgyk(zzfmbVarD2, new zzcwk(zzcwoVarZza2)), zzcwoVarZza2.f27297j);
                    zzfmbVarD2.q(new zzgyk(zzfmbVarD2, zzfewVar.f30994c), zzfewVar.f30993b);
                }
                return zzgym.a(new zzfev(zzfkjVar, zzbzaVar, zzfkiVar));
            }
        }, zzgywVar), Exception.class, new zzfes(), zzgywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzffj
    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
