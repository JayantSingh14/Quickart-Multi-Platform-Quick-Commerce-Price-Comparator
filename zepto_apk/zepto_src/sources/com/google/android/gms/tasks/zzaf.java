package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
final class zzaf<T> implements zzae<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f39756a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final int f39757b;

    /* renamed from: c, reason: collision with root package name */
    public final zzw f39758c;

    /* renamed from: d, reason: collision with root package name */
    public int f39759d;

    /* renamed from: e, reason: collision with root package name */
    public int f39760e;

    /* renamed from: f, reason: collision with root package name */
    public int f39761f;

    /* renamed from: g, reason: collision with root package name */
    public Exception f39762g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f39763h;

    public zzaf(int i2, zzw zzwVar) {
        this.f39757b = i2;
        this.f39758c = zzwVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void a() {
        synchronized (this.f39756a) {
            this.f39761f++;
            this.f39763h = true;
            b();
        }
    }

    public final void b() {
        int i2 = this.f39759d + this.f39760e + this.f39761f;
        int i3 = this.f39757b;
        if (i2 == i3) {
            Exception exc = this.f39762g;
            zzw zzwVar = this.f39758c;
            if (exc == null) {
                if (this.f39763h) {
                    zzwVar.u();
                    return;
                } else {
                    zzwVar.t(null);
                    return;
                }
            }
            zzwVar.s(new ExecutionException(this.f39760e + " out of " + i3 + " underlying tasks failed", this.f39762g));
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f39756a) {
            this.f39760e++;
            this.f39762g = exc;
            b();
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        synchronized (this.f39756a) {
            this.f39759d++;
            b();
        }
    }
}
