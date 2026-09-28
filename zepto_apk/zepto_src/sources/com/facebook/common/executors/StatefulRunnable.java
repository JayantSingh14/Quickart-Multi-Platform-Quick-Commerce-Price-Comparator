package com.facebook.common.executors;

import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.atomic.AtomicInteger;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class StatefulRunnable<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f17073a = new AtomicInteger(0);

    public final void a() {
        if (this.f17073a.compareAndSet(0, 2)) {
            d();
        }
    }

    public void b(Object obj) {
    }

    public abstract Object c();

    public void d() {
    }

    public void e(Exception exc) {
    }

    public void f(Object obj) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicInteger atomicInteger = this.f17073a;
        if (atomicInteger.compareAndSet(0, 1)) {
            try {
                Object objC = c();
                atomicInteger.set(3);
                try {
                    f(objC);
                } finally {
                    b(objC);
                }
            } catch (Exception e2) {
                atomicInteger.set(4);
                e(e2);
            }
        }
    }
}
