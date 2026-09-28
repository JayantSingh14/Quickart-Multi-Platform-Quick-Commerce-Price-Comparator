package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
final class zzgkb implements zzgjw {

    /* renamed from: a, reason: collision with root package name */
    public final zzgbr f32764a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgbr f32765b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgbr f32766c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgbr f32767d;

    /* renamed from: e, reason: collision with root package name */
    public final zzija f32768e;

    /* renamed from: f, reason: collision with root package name */
    public final zzija f32769f;

    /* renamed from: g, reason: collision with root package name */
    public final File f32770g;

    /* renamed from: h, reason: collision with root package name */
    public final ExecutorService f32771h;

    /* renamed from: i, reason: collision with root package name */
    public final zzgnc f32772i;

    public zzgkb(zzgbr zzgbrVar, zzgbr zzgbrVar2, zzija zzijaVar, zzgbr zzgbrVar3, zzgbr zzgbrVar4, zzija zzijaVar2, File file, ExecutorService executorService, zzgnc zzgncVar) {
        this.f32764a = zzgbrVar;
        this.f32766c = zzgbrVar2;
        this.f32768e = zzijaVar;
        this.f32765b = zzgbrVar3;
        this.f32767d = zzgbrVar4;
        this.f32769f = zzijaVar2;
        this.f32770g = file;
        this.f32771h = executorService;
        this.f32772i = zzgncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture a(final zzgcs zzgcsVar, byte[] bArr, byte[] bArr2) {
        ListenableFuture listenableFutureB = ((zzgbr) this.f32769f.zzb()).b(bArr);
        zzgnc zzgncVar = this.f32772i;
        zzgncVar.e(15307, listenableFutureB);
        ListenableFuture listenableFutureB2 = this.f32767d.b(bArr2);
        zzgncVar.e(15305, listenableFutureB2);
        return (zzgye) zzgym.h(zzgye.s(new zzgxv(zzgtd.s(new ListenableFuture[]{listenableFutureB, listenableFutureB2}), true)), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzgjz
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                zzgkb zzgkbVar = this.f32761a;
                ListenableFuture listenableFutureB3 = zzgkbVar.f32765b.b(zzgcsVar);
                zzgkbVar.f32772i.e(15303, listenableFutureB3);
                return listenableFutureB3;
            }
        }, zzgyb.f33369a);
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture b(final zzgcs zzgcsVar, byte[] bArr) {
        ListenableFuture listenableFutureB = this.f32767d.b(bArr);
        this.f32772i.e(15305, listenableFutureB);
        return (zzgye) zzgym.h(zzgye.s(listenableFutureB), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzgjy
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                zzgkb zzgkbVar = this.f32759a;
                ListenableFuture listenableFutureB2 = zzgkbVar.f32765b.b(zzgcsVar);
                zzgkbVar.f32772i.e(15303, listenableFutureB2);
                return listenableFutureB2;
            }
        }, zzgyb.f33369a);
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture zza() {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgka
            @Override // java.util.concurrent.Callable
            public final Object call() {
                File file;
                File file2;
                File file3;
                zzgkb zzgkbVar = this.f32763a;
                zzgnc zzgncVar = zzgkbVar.f32772i;
                zzgbr zzgbrVar = zzgkbVar.f32765b;
                zzgbr zzgbrVar2 = zzgkbVar.f32767d;
                zzija zzijaVar = zzgkbVar.f32769f;
                try {
                    File file4 = zzgbrVar.f32231a;
                    boolean zExists = file4.exists();
                    File file5 = zzgbrVar.f32231a;
                    boolean z = false;
                    if (zExists) {
                        File file6 = ((zzgbr) zzijaVar.zzb()).f32231a;
                        File file7 = ((zzgbr) zzgkbVar.f32768e.zzb()).f32231a;
                        try {
                            if (file6.exists()) {
                                File parentFile = file7.getParentFile();
                                if (parentFile != null) {
                                    zzfvq.e(parentFile);
                                }
                                zzgwk.b(file7);
                                zzgwk.c(file6, file7);
                            }
                            File file8 = zzgbrVar2.f32231a;
                            file = zzgbrVar2.f32231a;
                            File file9 = zzgkbVar.f32766c.f32231a;
                            try {
                                if (file8.exists()) {
                                    zzgwk.b(file9);
                                    zzgwk.c(file8, file9);
                                }
                                file3 = zzgkbVar.f32764a.f32231a;
                            } catch (IOException | SecurityException e2) {
                                zzgncVar.d(15312, e2);
                                file5.delete();
                                file2 = ((zzgbr) zzijaVar.zzb()).f32231a;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            zzgncVar.d(15311, e);
                            file5.delete();
                            ((zzgbr) zzijaVar.zzb()).f32231a.delete();
                            zzgbrVar2.f32231a.delete();
                            return new Boolean(z);
                        } catch (SecurityException e4) {
                            e = e4;
                            zzgncVar.d(15311, e);
                            file5.delete();
                            ((zzgbr) zzijaVar.zzb()).f32231a.delete();
                            zzgbrVar2.f32231a.delete();
                            return new Boolean(z);
                        }
                        try {
                            if (file4.exists()) {
                                zzgwk.b(file3);
                                zzgwk.c(file4, file3);
                            }
                            file5.delete();
                            ((zzgbr) zzijaVar.zzb()).f32231a.delete();
                            file.delete();
                            z = true;
                        } catch (IOException | SecurityException e5) {
                            zzgncVar.d(15313, e5);
                            file5.delete();
                            file2 = ((zzgbr) zzijaVar.zzb()).f32231a;
                            file2.delete();
                            file.delete();
                            return new Boolean(z);
                        }
                        return new Boolean(z);
                    }
                    file5.delete();
                    ((zzgbr) zzijaVar.zzb()).f32231a.delete();
                    zzgbrVar2.f32231a.delete();
                    return new Boolean(z);
                } catch (Throwable th) {
                    zzgbrVar.f32231a.delete();
                    ((zzgbr) zzijaVar.zzb()).f32231a.delete();
                    zzgbrVar2.f32231a.delete();
                    throw th;
                }
            }
        }, this.f32771h);
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureA = this.f32764a.a();
        this.f32772i.e(15302, listenableFutureA);
        return listenableFutureA;
    }

    @Override // com.google.android.gms.internal.ads.zzgjw
    public final ListenableFuture zze() {
        zzgye zzgyeVar = (zzgye) zzgym.i(zzgye.s(this.f32764a.a()), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgjx
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                zzgcs zzgcsVar = (zzgcs) obj;
                zzgkb zzgkbVar = this.f32758a;
                zzgkbVar.getClass();
                if (zzgcsVar == null || zzgcsVar.equals(zzgcs.H())) {
                    return null;
                }
                return new zzfvo(zzgcsVar.C(), ((zzgbr) zzgkbVar.f32768e.zzb()).f32231a, zzgkbVar.f32766c.f32231a, zzgkbVar.f32770g);
            }
        }, zzgyb.f33369a);
        this.f32772i.e(15314, zzgyeVar);
        return zzgyeVar;
    }
}
