package io.ktor.utils.io.pool;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class SingleInstancePool<T> implements ObjectPool<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51376a = AtomicIntegerFieldUpdater.newUpdater(SingleInstancePool.class, "borrowed");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51377b = AtomicIntegerFieldUpdater.newUpdater(SingleInstancePool.class, "disposed");

    @NotNull
    private volatile /* synthetic */ int borrowed = 0;

    @NotNull
    private volatile /* synthetic */ int disposed = 0;

    @NotNull
    private volatile /* synthetic */ Object instance = null;

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void G1(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (this.instance != instance) {
            if (this.instance == null && this.borrowed != 0) {
                throw new IllegalStateException("Already recycled or an irrelevant instance tried to be recycled");
            }
            throw new IllegalStateException("Unable to recycle irrelevant instance");
        }
        this.instance = null;
        if (!f51377b.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException("An instance is already disposed");
        }
        a(instance);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object S0() {
        int i2;
        do {
            i2 = this.borrowed;
            if (i2 != 0) {
                throw new IllegalStateException("Instance is already consumed");
            }
        } while (!f51376a.compareAndSet(this, i2, 1));
        Object objB = b();
        this.instance = objB;
        return objB;
    }

    public abstract void a(Object obj);

    public abstract Object b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        dispose();
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
        Object obj;
        if (!f51377b.compareAndSet(this, 0, 1) || (obj = this.instance) == null) {
            return;
        }
        this.instance = null;
        a(obj);
    }
}
