package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public final class zzfzz {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f32139b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static zzfzz f32140c;

    /* renamed from: a, reason: collision with root package name */
    public final zzfzx f32141a;

    public zzfzz(Context context, zzgad zzgadVar, zzgyw zzgywVar) {
        zzgak zzgakVar = new zzgak();
        context.getClass();
        zzgakVar.f32168b = context;
        zzgywVar.getClass();
        zzgakVar.f32167a = zzgywVar;
        zzgakVar.f32169c = zzgadVar;
        zzijo.b(Context.class, zzgakVar.f32168b);
        zzijo.b(zzgad.class, zzgakVar.f32169c);
        new zzggi();
        new zzggk();
        new zzggm();
        this.f32141a = (zzfzx) new zzgaj(zzgakVar.f32168b, zzgakVar.f32169c, zzgakVar.f32167a).p.zzb();
    }

    public final String a(final Context context) {
        String string;
        ListenableFuture listenableFuture;
        final zzfzx zzfzxVar = this.f32141a;
        zzgbj zzgbjVar = zzfzxVar.f32125e;
        boolean z = zzfzxVar.f32130j;
        long j2 = zzfzxVar.f32129i;
        boolean z2 = false;
        if (z && System.currentTimeMillis() - j2 <= zzfzxVar.f32131k) {
            z2 = true;
        }
        zzgnc zzgncVar = zzfzxVar.f32124d;
        zzgna zzgnaVarA = zzgncVar.a(3);
        try {
            try {
                try {
                    try {
                        try {
                            zzgnaVarA.a();
                            zzgcd zzgcdVar = zzfzxVar.f32121a;
                            synchronized (zzgcdVar) {
                                listenableFuture = zzgcdVar.f32249e;
                                if (listenableFuture == null) {
                                    throw null;
                                }
                            }
                            string = (String) ((zzgxf) zzgym.h(listenableFuture, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfzw
                                @Override // com.google.android.gms.internal.ads.zzgxu
                                public final ListenableFuture zza(Object obj) {
                                    return ((zzgct) zzfzxVar.f32122b.f32307f.get()).a(context);
                                }
                            }, zzgyb.f33369a)).get(z2 ? zzfzxVar.f32128h : zzfzxVar.f32126f, TimeUnit.MILLISECONDS);
                        } catch (TimeoutException unused) {
                            if (z2) {
                                string = ((zzggg) zzfzxVar.f32127g.zzb()).a(j2);
                            } else {
                                zzgncVar.b(56);
                                string = Integer.toString(17);
                            }
                        }
                    } catch (ExecutionException e2) {
                        e = e2;
                        Throwable cause = e.getCause();
                        if (cause != null) {
                            e = cause;
                        }
                        zzgnaVarA.b(e);
                        string = Integer.toString(3);
                    }
                } catch (Throwable th) {
                    zzgnaVarA.b(th);
                    throw th;
                }
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                zzgnaVarA.b(e3);
                string = "";
            }
            zzgnaVarA.c();
            zzgbjVar.zzb();
            return string;
        } catch (Throwable th2) {
            zzgnaVarA.c();
            zzgbjVar.zzb();
            throw th2;
        }
    }

    public final String b(final Context context, final String str, final View view) {
        String string;
        ListenableFuture listenableFuture;
        final zzfzx zzfzxVar = this.f32141a;
        zzgbj zzgbjVar = zzfzxVar.f32125e;
        zzgnc zzgncVar = zzfzxVar.f32124d;
        zzgna zzgnaVarA = zzgncVar.a(5);
        try {
            try {
                try {
                    try {
                        zzgnaVarA.a();
                        zzgcd zzgcdVar = zzfzxVar.f32121a;
                        synchronized (zzgcdVar) {
                            listenableFuture = zzgcdVar.f32249e;
                            if (listenableFuture == null) {
                                throw null;
                            }
                        }
                        string = (String) ((zzgxf) zzgym.h(listenableFuture, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzfzv
                            @Override // com.google.android.gms.internal.ads.zzgxu
                            public final ListenableFuture zza(Object obj) {
                                return ((zzgct) zzfzxVar.f32122b.f32307f.get()).c(context, str, view);
                            }
                        }, zzgyb.f33369a)).get(zzfzxVar.f32126f, TimeUnit.MILLISECONDS);
                    } catch (Throwable th) {
                        zzgnaVarA.b(th);
                        throw th;
                    }
                } catch (ExecutionException e2) {
                    e = e2;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    zzgnaVarA.b(e);
                    string = Integer.toString(3);
                }
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                zzgnaVarA.b(e3);
                string = "";
            } catch (TimeoutException unused) {
                zzgncVar.b(58);
                string = Integer.toString(17);
            }
            zzgnaVarA.c();
            zzgbjVar.zzb();
            return string;
        } catch (Throwable th2) {
            zzgnaVarA.c();
            zzgbjVar.zzb();
            throw th2;
        }
    }

    public final void c(MotionEvent motionEvent) {
        zzgde zzgdeVar = this.f32141a.f32122b;
        zzgct zzgctVar = (zzgct) zzgdeVar.f32307f.get();
        if (zzgctVar == null) {
            zzgdeVar.f32306e.b(54);
        } else {
            zzgctVar.d(motionEvent);
        }
    }
}
