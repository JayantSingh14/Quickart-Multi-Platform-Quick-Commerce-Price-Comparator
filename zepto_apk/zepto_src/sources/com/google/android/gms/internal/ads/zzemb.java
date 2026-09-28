package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzemb {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f29698a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f29699b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcvn f29700c;

    /* renamed from: d, reason: collision with root package name */
    public final zzemr f29701d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfpe f29702e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgzf f29703f = new zzgzf();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f29704g = new AtomicBoolean();

    /* renamed from: h, reason: collision with root package name */
    public zzemc f29705h;

    /* renamed from: i, reason: collision with root package name */
    public zzfic f29706i;

    public zzemb(zzgyw zzgywVar, ScheduledExecutorService scheduledExecutorService, zzcvn zzcvnVar, zzemr zzemrVar, zzfpe zzfpeVar) {
        this.f29698a = zzgywVar;
        this.f29699b = scheduledExecutorService;
        this.f29700c = zzcvnVar;
        this.f29701d = zzemrVar;
        this.f29702e = zzfpeVar;
    }

    public final void a(zzfhr zzfhrVar) {
        ListenableFuture listenableFutureB;
        synchronized (this) {
            Iterator it = zzfhrVar.f31149a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    listenableFutureB = zzgym.b(new zzebr(3));
                    break;
                }
                zzejg zzejgVarA = this.f29700c.a(zzfhrVar.f31150b, (String) it.next());
                if (zzejgVarA != null && zzejgVarA.b(this.f29706i, zzfhrVar)) {
                    listenableFutureB = zzgym.g(zzejgVarA.a(this.f29706i, zzfhrVar), zzfhrVar.R, TimeUnit.MILLISECONDS, this.f29699b);
                    break;
                }
            }
        }
        this.f29701d.b(this.f29706i, zzfhrVar, listenableFutureB, this.f29702e);
        listenableFutureB.q(new zzgyk(listenableFutureB, new zzema(this, zzfhrVar)), this.f29698a);
    }
}
