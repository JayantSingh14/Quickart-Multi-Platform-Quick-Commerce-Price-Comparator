package com.google.android.gms.internal.pal;

import android.os.Handler;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public abstract class zzbg {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f37536a;

    /* renamed from: b, reason: collision with root package name */
    public final zzagc f37537b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f37538c;

    /* renamed from: d, reason: collision with root package name */
    public Task f37539d = Tasks.e(zzif.f37811a);

    public zzbg(Handler handler, ExecutorService executorService, zzagc zzagcVar) {
        this.f37536a = executorService;
        this.f37538c = handler;
        this.f37537b = zzagcVar;
    }

    public abstract zzil a();

    public final Task b() {
        if (this.f37539d.o() && !this.f37539d.p()) {
            c();
        }
        return this.f37539d;
    }

    public final void c() {
        this.f37538c.removeCallbacksAndMessages(null);
        this.f37538c.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.pal.zzbe
            @Override // java.lang.Runnable
            public final void run() {
                this.f37534a.c();
            }
        }, (this.f37537b.f37520a / 1000) * 1000);
        this.f37539d = Tasks.c(new Callable() { // from class: com.google.android.gms.internal.pal.zzbf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f37535a.a();
            }
        }, this.f37536a);
    }
}
