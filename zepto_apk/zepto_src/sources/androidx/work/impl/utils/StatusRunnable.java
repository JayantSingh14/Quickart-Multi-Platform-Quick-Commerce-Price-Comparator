package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.List;

@RestrictTo
/* loaded from: classes3.dex */
public abstract class StatusRunnable<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final SettableFuture f12989a = new SettableFuture();

    /* renamed from: androidx.work.impl.utils.StatusRunnable$1, reason: invalid class name */
    class AnonymousClass1 extends StatusRunnable<List<WorkInfo>> {
        @Override // androidx.work.impl.utils.StatusRunnable
        public final Object b() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$2, reason: invalid class name */
    class AnonymousClass2 extends StatusRunnable<WorkInfo> {
        @Override // androidx.work.impl.utils.StatusRunnable
        public final Object b() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$4, reason: invalid class name */
    class AnonymousClass4 extends StatusRunnable<List<WorkInfo>> {
        @Override // androidx.work.impl.utils.StatusRunnable
        public final Object b() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$5, reason: invalid class name */
    class AnonymousClass5 extends StatusRunnable<List<WorkInfo>> {
        @Override // androidx.work.impl.utils.StatusRunnable
        public final Object b() {
            throw null;
        }
    }

    public static StatusRunnable a(final WorkManagerImpl workManagerImpl, final String str) {
        return new StatusRunnable<List<WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable.3
            @Override // androidx.work.impl.utils.StatusRunnable
            public final Object b() {
                return (List) WorkSpec.y.apply((Object) workManagerImpl.f12655c.v().z(str));
            }
        };
    }

    public abstract Object b();

    @Override // java.lang.Runnable
    public final void run() {
        SettableFuture settableFuture = this.f12989a;
        try {
            settableFuture.i(b());
        } catch (Throwable th) {
            settableFuture.j(th);
        }
    }
}
