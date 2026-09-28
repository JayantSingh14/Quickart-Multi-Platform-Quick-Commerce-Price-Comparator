package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public abstract class BaseConsumer<T> implements Consumer<T> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f18089a = false;

    public static boolean d(int i2) {
        return (i2 & 1) == 1;
    }

    public static boolean e(int i2) {
        return !d(i2);
    }

    public static boolean k(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public final synchronized void a() {
        if (this.f18089a) {
            return;
        }
        this.f18089a = true;
        try {
            f();
        } catch (Exception e2) {
            j(e2);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public final synchronized void b(int i2, Object obj) {
        if (this.f18089a) {
            return;
        }
        this.f18089a = d(i2);
        try {
            h(i2, obj);
        } catch (Exception e2) {
            j(e2);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public final synchronized void c(float f2) {
        if (this.f18089a) {
            return;
        }
        try {
            i(f2);
        } catch (Exception e2) {
            j(e2);
        }
    }

    public abstract void f();

    public abstract void g(Throwable th);

    public abstract void h(int i2, Object obj);

    public void i(float f2) {
    }

    public final void j(Exception exc) {
        Class<?> cls = getClass();
        if (FLog.f17086a.a(6)) {
            FLogDefaultLoggingDelegate.c(6, cls.getSimpleName(), "unhandled exception", exc);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public final synchronized void onFailure(Throwable th) {
        if (this.f18089a) {
            return;
        }
        this.f18089a = true;
        try {
            g(th);
        } catch (Exception e2) {
            j(e2);
        }
    }
}
