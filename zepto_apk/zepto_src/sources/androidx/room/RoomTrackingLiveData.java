package androidx.room;

import android.annotation.SuppressLint;
import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@SuppressLint({"RestrictedApi"})
/* loaded from: classes3.dex */
public final class RoomTrackingLiveData<T> extends LiveData<T> {

    /* renamed from: l, reason: collision with root package name */
    public final RoomDatabase f11843l;

    /* renamed from: m, reason: collision with root package name */
    public final InvalidationLiveDataContainer f11844m;
    public final Callable n;
    public final RoomTrackingLiveData$observer$1 o;
    public final AtomicBoolean p;
    public final AtomicBoolean q;
    public final AtomicBoolean r;
    public final a s;
    public final a t;

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.room.RoomTrackingLiveData$observer$1] */
    public RoomTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, Callable computeFunction, final String[] tableNames) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.f11843l = database;
        this.f11844m = container;
        this.n = computeFunction;
        this.o = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RoomTrackingLiveData$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public final void b(Set tables) {
                Intrinsics.checkNotNullParameter(tables, "tables");
                ArchTaskExecutor archTaskExecutorA = ArchTaskExecutor.a();
                a aVar = this.t;
                archTaskExecutorA.f1276a.getClass();
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    aVar.run();
                } else {
                    archTaskExecutorA.b(aVar);
                }
            }
        };
        this.p = new AtomicBoolean(true);
        this.q = new AtomicBoolean(false);
        this.r = new AtomicBoolean(false);
        this.s = new a(this, 0);
        this.t = new a(this, 1);
    }

    @Override // androidx.lifecycle.LiveData
    public final void g() {
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.f11844m;
        invalidationLiveDataContainer.getClass();
        Intrinsics.checkNotNullParameter(this, "liveData");
        invalidationLiveDataContainer.f11762b.add(this);
        Executor executor = this.f11843l.f11798b;
        if (executor != null) {
            executor.execute(this.s);
        } else {
            Intrinsics.h("internalQueryExecutor");
            throw null;
        }
    }

    @Override // androidx.lifecycle.LiveData
    public final void h() {
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.f11844m;
        invalidationLiveDataContainer.getClass();
        Intrinsics.checkNotNullParameter(this, "liveData");
        invalidationLiveDataContainer.f11762b.remove(this);
    }
}
