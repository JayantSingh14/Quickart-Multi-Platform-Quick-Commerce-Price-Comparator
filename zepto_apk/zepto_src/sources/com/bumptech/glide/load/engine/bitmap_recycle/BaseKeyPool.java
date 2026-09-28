package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.ArrayDeque;

/* loaded from: classes3.dex */
abstract class BaseKeyPool<T extends Poolable> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f16048a;

    public BaseKeyPool() {
        char[] cArr = Util.f16528a;
        this.f16048a = new ArrayDeque(20);
    }

    public abstract Poolable a();

    public final Poolable b() {
        Poolable poolable = (Poolable) this.f16048a.poll();
        return poolable == null ? a() : poolable;
    }

    public final void c(Poolable poolable) {
        ArrayDeque arrayDeque = this.f16048a;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(poolable);
        }
    }
}
