package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
final class zzgja implements zzgid {

    /* renamed from: a, reason: collision with root package name */
    public final zzgls f32703a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgle f32704b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f32705c;

    /* renamed from: d, reason: collision with root package name */
    public final zzglx f32706d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgnc f32707e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f32708f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public final String f32709g;

    /* renamed from: h, reason: collision with root package name */
    public final long f32710h;

    /* renamed from: i, reason: collision with root package name */
    public final long f32711i;

    /* renamed from: j, reason: collision with root package name */
    public zzgiz f32712j;

    public zzgja(zzgls zzglsVar, zzgle zzgleVar, zzglx zzglxVar, zzgnc zzgncVar, zzgad zzgadVar, ExecutorService executorService) {
        this.f32703a = zzglsVar;
        this.f32704b = zzgleVar;
        this.f32705c = executorService;
        this.f32706d = zzglxVar;
        this.f32707e = zzgncVar;
        this.f32709g = zzgadVar.I();
        this.f32710h = zzgadVar.Q();
        this.f32711i = zzgadVar.P();
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final ListenableFuture a(final Context context) {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgir
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                final zzgja zzgjaVar = this.f32670a;
                zzgjaVar.getClass();
                final HashMap map = new HashMap();
                final Context context2 = context;
                zzgjaVar.f32707e.f(20106, new Runnable() { // from class: com.google.android.gms.internal.ads.zzgiv
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzgja zzgjaVar2 = zzgjaVar;
                        HashMap mapA = zzgjaVar2.f32706d.a();
                        HashMap map2 = map;
                        map2.putAll(mapA);
                        zzgjaVar2.e(map2);
                        map2.put("f", "q");
                        map2.put("ctx", context2);
                    }
                });
                String strF = zzgjaVar.f(map);
                map.clear();
                return strF;
            }
        }, this.f32705c);
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final ListenableFuture b(final Context context, final View view, final Activity activity) {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgis
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                final zzgja zzgjaVar = this.f32672a;
                zzgjaVar.getClass();
                final HashMap map = new HashMap();
                final View view2 = view;
                final Activity activity2 = activity;
                final Context context2 = context;
                zzgjaVar.f32707e.f(20106, new Runnable() { // from class: com.google.android.gms.internal.ads.zzgiw
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzgja zzgjaVar2 = zzgjaVar;
                        zzglx zzglxVar = zzgjaVar2.f32706d;
                        Context context3 = context2;
                        View view3 = view2;
                        HashMap mapB = zzglxVar.b(context3, view3);
                        HashMap map2 = map;
                        map2.putAll(mapB);
                        zzgjaVar2.e(map2);
                        map2.put("f", "v");
                        map2.put("ctx", context3);
                        map2.put("view", view3);
                        map2.put("act", activity2);
                        map2.put("bds", null);
                    }
                });
                String strF = zzgjaVar.f(map);
                map.clear();
                return strF;
            }
        }, this.f32705c);
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final ListenableFuture c(final Context context, final String str, final View view) {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgit
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                final zzgja zzgjaVar = this.f32676a;
                zzgjaVar.getClass();
                final HashMap map = new HashMap();
                final View view2 = view;
                final String str2 = str;
                final Context context2 = context;
                zzgjaVar.f32707e.f(20106, new Runnable() { // from class: com.google.android.gms.internal.ads.zzgix
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzgja zzgjaVar2 = zzgjaVar;
                        HashMap mapC = zzgjaVar2.f32706d.c();
                        HashMap map2 = map;
                        map2.putAll(mapC);
                        zzgjaVar2.e(map2);
                        map2.put("f", "c");
                        map2.put("ctx", context2);
                        map2.put("view", view2);
                        map2.put("act", null);
                        map2.put("bds", str2);
                    }
                });
                String strF = zzgjaVar.f(map);
                map.clear();
                return strF;
            }
        }, this.f32705c);
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final void d(MotionEvent motionEvent) {
        try {
            synchronized (this.f32708f) {
                try {
                    zzgiz zzgizVar = this.f32712j;
                    if (zzgizVar != null) {
                        HashMap map = new HashMap();
                        map.put("evt", motionEvent);
                        zzgizVar.f32695a.c(zzgizVar.f32697c, Optional.of(map));
                    } else {
                        this.f32707e.b(20105);
                    }
                } finally {
                }
            }
        } catch (zzatb | zzatf e2) {
            this.f32707e.d(20104, e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.util.HashMap r13) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgja.e(java.util.HashMap):void");
    }

    public final String f(HashMap map) {
        String strG;
        zzgnc zzgncVar = this.f32707e;
        try {
            zzgncVar.a(20110).a();
            synchronized (this.f32708f) {
                try {
                    zzgiz zzgizVar = this.f32712j;
                    if (zzgizVar == null) {
                        zzgncVar.b(20109);
                        strG = "";
                    } else {
                        byte[] bArr = (byte[]) zzgizVar.f32695a.c(zzgizVar.f32696b, Optional.of(map));
                        zzgvx zzgvxVar = (zzgvx) zzgvy.f33276b;
                        strG = (zzgvxVar.f33273e == null ? zzgvxVar : zzgvxVar.i(zzgvxVar.f33272d, null)).g(bArr.length, bArr);
                    }
                } finally {
                }
            }
            return strG;
        } finally {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final String zza() {
        synchronized (this.f32708f) {
            try {
                zzgiz zzgizVar = this.f32712j;
                if (zzgizVar == null) {
                    return "3.815976881.-1";
                }
                return zzgizVar.f32698d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final zzgye zzb() {
        zzgye zzgyeVarS = zzgye.s(this.f32704b.zzb());
        zzgiy zzgiyVar = zzgiy.f32694a;
        ExecutorService executorService = this.f32705c;
        return (zzgye) zzgym.h((zzgye) zzgym.e(zzgyeVarS, Throwable.class, zzgiyVar, executorService), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzgiq
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                final zzgja zzgjaVar = this.f32669a;
                if (zzgjaVar.f32703a.a((zzgcs) obj)) {
                    return zzgym.i(zzgjaVar.f32704b.zze(), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgiu
                        @Override // com.google.android.gms.internal.ads.zzgpr
                        public final Object apply(Object obj2) {
                            zzgja zzgjaVar2 = zzgjaVar;
                            byte[] bArr = (byte[]) obj2;
                            zzgjaVar2.getClass();
                            zzath zzathVar = new zzath();
                            zzgna zzgnaVarA = zzgjaVar2.f32707e.a(20102);
                            try {
                                try {
                                    zzgnaVarA.a();
                                    synchronized (zzgjaVar2.f32708f) {
                                        zzgjaVar2.f32712j = zzgiz.a(zzathVar, bArr);
                                    }
                                    zzgnaVarA.c();
                                    return null;
                                } catch (zzatb e2) {
                                    e = e2;
                                    zzgnaVarA.b(e);
                                    throw new zzgie("r: 2", e);
                                } catch (zzatf e3) {
                                    e = e3;
                                    zzgnaVarA.b(e);
                                    throw new zzgie("r: 2", e);
                                } catch (Throwable th) {
                                    zzgnaVarA.b(th);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                zzgnaVarA.c();
                                throw th2;
                            }
                        }
                    }, zzgyb.f33369a);
                }
                zzgjaVar.f32707e.b(20103);
                throw new zzgie(1);
            }
        }, executorService);
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final int zzg() {
        return 4;
    }
}
