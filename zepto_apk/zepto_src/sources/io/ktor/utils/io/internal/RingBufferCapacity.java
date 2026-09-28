package io.ktor.utils.io.internal;

import android.support.v4.media.b;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RingBufferCapacity {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51269b = AtomicIntegerFieldUpdater.newUpdater(RingBufferCapacity.class, "_availableForRead$internal");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51270c = AtomicIntegerFieldUpdater.newUpdater(RingBufferCapacity.class, "_availableForWrite$internal");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51271d = AtomicIntegerFieldUpdater.newUpdater(RingBufferCapacity.class, "_pendingToFlush");

    @NotNull
    public volatile /* synthetic */ int _availableForWrite$internal;

    /* renamed from: a, reason: collision with root package name */
    public final int f51272a;

    @NotNull
    public volatile /* synthetic */ int _availableForRead$internal = 0;

    @NotNull
    volatile /* synthetic */ int _pendingToFlush = 0;

    public RingBufferCapacity(int i2) {
        this.f51272a = i2;
        this._availableForWrite$internal = i2;
    }

    public final void a(int i2) {
        int i3;
        int i4;
        do {
            i3 = this._availableForWrite$internal;
            i4 = i3 + i2;
            if (i4 > this.f51272a) {
                StringBuilder sbT = b.t(i3, i2, "Completed read overflow: ", " + ", " = ");
                sbT.append(i4);
                sbT.append(" > ");
                sbT.append(this.f51272a);
                throw new IllegalArgumentException(sbT.toString());
            }
        } while (!f51270c.compareAndSet(this, i3, i4));
    }

    public final void b(int i2) {
        int i3;
        int i4;
        do {
            i3 = this._pendingToFlush;
            i4 = i3 + i2;
            if (i4 > this.f51272a) {
                StringBuilder sbT = b.t(i3, i2, "Complete write overflow: ", " + ", " > ");
                sbT.append(this.f51272a);
                throw new IllegalArgumentException(sbT.toString());
            }
        } while (!f51271d.compareAndSet(this, i3, i4));
    }

    public final boolean c() {
        int andSet = f51271d.getAndSet(this, 0);
        return andSet == 0 ? this._availableForRead$internal > 0 : f51269b.addAndGet(this, andSet) > 0;
    }

    public final boolean d() {
        return this._availableForWrite$internal == 0;
    }

    public final void e() {
        this._availableForRead$internal = this.f51272a;
        this._availableForWrite$internal = 0;
        this._pendingToFlush = 0;
    }

    public final void f() {
        this._availableForRead$internal = 0;
        this._pendingToFlush = 0;
        this._availableForWrite$internal = this.f51272a;
    }

    public final boolean g() {
        int i2;
        do {
            i2 = this._availableForWrite$internal;
            if (this._pendingToFlush > 0 || this._availableForRead$internal > 0 || i2 != this.f51272a) {
                return false;
            }
        } while (!f51270c.compareAndSet(this, i2, 0));
        return true;
    }

    public final int h(int i2) {
        int i3;
        int iMin;
        do {
            i3 = this._availableForRead$internal;
            iMin = Math.min(i2, i3);
            if (iMin == 0) {
                return 0;
            }
        } while (!f51269b.compareAndSet(this, i3, i3 - iMin));
        return Math.min(i2, i3);
    }

    public final boolean i(int i2) {
        int i3;
        do {
            i3 = this._availableForRead$internal;
            if (i3 < i2) {
                return false;
            }
        } while (!f51269b.compareAndSet(this, i3, i3 - i2));
        return true;
    }

    public final int j(int i2) {
        int i3;
        int iMin;
        do {
            i3 = this._availableForWrite$internal;
            iMin = Math.min(i2, i3);
            if (iMin == 0) {
                return 0;
            }
        } while (!f51270c.compareAndSet(this, i3, i3 - iMin));
        return Math.min(i2, i3);
    }

    public final boolean k(int i2) {
        int i3;
        do {
            i3 = this._availableForWrite$internal;
            if (i3 < i2) {
                return false;
            }
        } while (!f51270c.compareAndSet(this, i3, i3 - i2));
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RingBufferCapacity[read: ");
        sb.append(this._availableForRead$internal);
        sb.append(", write: ");
        sb.append(this._availableForWrite$internal);
        sb.append(", flush: ");
        sb.append(this._pendingToFlush);
        sb.append(", capacity: ");
        return b.n(sb, this.f51272a, ']');
    }
}
