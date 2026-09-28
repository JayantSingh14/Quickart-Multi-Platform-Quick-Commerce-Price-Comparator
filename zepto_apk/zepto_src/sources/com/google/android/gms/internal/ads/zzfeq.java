package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzfeq implements zzffj {

    /* renamed from: a, reason: collision with root package name */
    public final zzffa f30980a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfew f30981b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfkv f30982c;

    /* renamed from: d, reason: collision with root package name */
    public final String f30983d;

    /* renamed from: e, reason: collision with root package name */
    public zzczr f30984e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgyw f30985f;

    public zzfeq(zzffa zzffaVar, zzfew zzfewVar, zzfkv zzfkvVar, String str, zzgyw zzgywVar) {
        this.f30980a = zzffaVar;
        this.f30981b = zzfewVar;
        this.f30982c = zzfkvVar;
        this.f30983d = str;
        this.f30985f = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffj
    public final ListenableFuture a(final zzffk zzffkVar, final zzffi zzffiVar) {
        synchronized (this) {
            zzczq zzczqVarA = zzffiVar.a(zzffkVar.f31012b);
            zzczqVarA.a(new zzfer(this.f30983d));
            final zzczr zzczrVar = (zzczr) zzczqVarA.zzh();
            zzczrVar.zzb();
            zzczrVar.zzb();
            com.google.android.gms.ads.internal.client.zzm zzmVar = zzczrVar.zzb().f31216d;
            if (zzmVar.s != null || zzmVar.x != null) {
                this.f30984e = zzczrVar;
                return this.f30980a.b(zzffkVar, zzffiVar, zzczrVar);
            }
            zzfik zzfikVarZzb = zzczrVar.zzb();
            com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzfikVarZzb.f31216d;
            String str = zzfikVarZzb.f31219g;
            com.google.android.gms.ads.internal.client.zzx zzxVar = zzfikVarZzb.f31223k;
            zzgyw zzgywVar = this.f30985f;
            final zzfep zzfepVar = new zzfep(zzffiVar, zzffkVar, zzmVar2, str, zzgywVar, zzxVar, null);
            return (zzgye) zzgym.h(zzgye.s(this.f30981b.b(zzczrVar)), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfeo
                /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
                /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
                @Override // com.google.android.gms.internal.ads.zzgxu
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final com.google.common.util.concurrent.ListenableFuture zza(java.lang.Object r14) {
                    /*
                        r13 = this;
                        com.google.android.gms.internal.ads.zzfeq r0 = r13.f30968a
                        com.google.android.gms.internal.ads.zzffk r1 = r2
                        com.google.android.gms.internal.ads.zzfep r2 = r3
                        com.google.android.gms.internal.ads.zzffi r3 = r4
                        com.google.android.gms.internal.ads.zzczr r4 = r5
                        com.google.android.gms.internal.ads.zzfev r14 = (com.google.android.gms.internal.ads.zzfev) r14
                        if (r14 == 0) goto L86
                        r0.getClass()
                        com.google.android.gms.internal.ads.zzffi r6 = r2.f30973a
                        com.google.android.gms.internal.ads.zzffk r7 = r2.f30974b
                        com.google.android.gms.ads.internal.client.zzm r8 = r2.f30975c
                        java.lang.String r9 = r2.f30976d
                        com.google.android.gms.internal.ads.zzgyw r10 = r2.f30977e
                        com.google.android.gms.ads.internal.client.zzx r11 = r2.f30978f
                        com.google.android.gms.internal.ads.zzfkj r12 = r14.f30989a
                        com.google.android.gms.internal.ads.zzfep r5 = new com.google.android.gms.internal.ads.zzfep
                        r5.<init>(r6, r7, r8, r9, r10, r11, r12)
                        com.google.android.gms.internal.ads.zzfki r2 = r14.f30991c
                        r6 = 0
                        if (r2 == 0) goto L3d
                        r0.f30984e = r6
                        com.google.android.gms.internal.ads.zzfkv r7 = r0.f30982c
                        monitor-enter(r7)
                        java.util.ArrayDeque r14 = r7.f31334c     // Catch: java.lang.Throwable -> L39
                        r14.add(r5)     // Catch: java.lang.Throwable -> L39
                        monitor-exit(r7)
                        com.google.common.util.concurrent.ListenableFuture r14 = r0.b(r2, r1)
                        return r14
                    L39:
                        r0 = move-exception
                        r14 = r0
                        monitor-exit(r7)     // Catch: java.lang.Throwable -> L39
                        throw r14
                    L3d:
                        com.google.android.gms.internal.ads.zzfkv r2 = r0.f30982c
                        monitor-enter(r2)
                        r7 = 2
                        r2.f31336e = r7     // Catch: java.lang.Throwable -> L7d
                        monitor-enter(r2)     // Catch: java.lang.Throwable -> L7d
                        com.google.android.gms.internal.ads.zzflb r7 = r2.f31335d     // Catch: java.lang.Throwable -> L80
                        if (r7 != 0) goto L4b
                        monitor-exit(r2)     // Catch: java.lang.Throwable -> L7d
                        r8 = 1
                        goto L4d
                    L4b:
                        monitor-exit(r2)     // Catch: java.lang.Throwable -> L7d
                        r8 = 0
                    L4d:
                        if (r8 == 0) goto L52
                        monitor-exit(r2)
                        r7 = r6
                        goto L57
                    L52:
                        com.google.common.util.concurrent.ListenableFuture r7 = r7.a(r5)     // Catch: java.lang.Throwable -> L7d
                        monitor-exit(r2)
                    L57:
                        if (r7 == 0) goto L67
                        r0.f30984e = r6
                        com.google.android.gms.internal.ads.zzfen r14 = new com.google.android.gms.internal.ads.zzfen
                        r14.<init>()
                        com.google.android.gms.internal.ads.zzgyw r0 = r0.f30985f
                        com.google.common.util.concurrent.ListenableFuture r14 = com.google.android.gms.internal.ads.zzgym.h(r7, r14, r0)
                        return r14
                    L67:
                        monitor-enter(r2)
                        java.util.ArrayDeque r6 = r2.f31334c     // Catch: java.lang.Throwable -> L79
                        r6.add(r5)     // Catch: java.lang.Throwable -> L79
                        monitor-exit(r2)
                        com.google.android.gms.internal.ads.zzffh r1 = r1.f31012b
                        com.google.android.gms.internal.ads.zzbza r14 = r14.f30990b
                        com.google.android.gms.internal.ads.zzffk r2 = new com.google.android.gms.internal.ads.zzffk
                        r2.<init>(r1, r14)
                        r1 = r2
                        goto L86
                    L79:
                        r0 = move-exception
                        r14 = r0
                        monitor-exit(r2)     // Catch: java.lang.Throwable -> L79
                        throw r14
                    L7d:
                        r0 = move-exception
                        r14 = r0
                        goto L84
                    L80:
                        r0 = move-exception
                        r14 = r0
                        monitor-exit(r2)     // Catch: java.lang.Throwable -> L80
                        throw r14     // Catch: java.lang.Throwable -> L7d
                    L84:
                        monitor-exit(r2)     // Catch: java.lang.Throwable -> L7d
                        throw r14
                    L86:
                        com.google.android.gms.internal.ads.zzffa r14 = r0.f30980a
                        com.google.common.util.concurrent.ListenableFuture r14 = r14.b(r1, r3, r4)
                        r0.f30984e = r4
                        return r14
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfeo.zza(java.lang.Object):com.google.common.util.concurrent.ListenableFuture");
                }
            }, zzgywVar);
        }
    }

    public final ListenableFuture b(zzfki zzfkiVar, zzffk zzffkVar) {
        zzczr zzczrVar = zzfkiVar.f31317a;
        this.f30984e = zzczrVar;
        if (zzfkiVar.f31319c == null) {
            zzczrVar.zza().f27294g = zzfkiVar.f31318b;
            return this.f30980a.b(zzffkVar, null, zzfkiVar.f31317a);
        }
        if (zzczrVar.zzc() != null) {
            zzfdr zzfdrVar = zzfkiVar.f31319c.f27231e;
            zzffg zzffgVarZzc = zzfkiVar.f31317a.zzc();
            zzfdrVar.getClass();
            zzfdrVar.f30902h = (zzfdr) zzffgVarZzc;
        }
        return zzgym.a(zzfkiVar.f31319c);
    }

    @Override // com.google.android.gms.internal.ads.zzffj
    public final Object zzd() {
        zzczr zzczrVar;
        synchronized (this) {
            zzczrVar = this.f30984e;
        }
        return zzczrVar;
    }
}
