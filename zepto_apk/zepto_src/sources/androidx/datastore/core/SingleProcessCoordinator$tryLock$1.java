package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.SingleProcessCoordinator", f = "SingleProcessCoordinator.kt", l = {50}, m = "tryLock")
/* loaded from: classes3.dex */
final class SingleProcessCoordinator$tryLock$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public MutexImpl f3632a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3633b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3634c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SingleProcessCoordinator f3635d;

    /* renamed from: e, reason: collision with root package name */
    public int f3636e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessCoordinator$tryLock$1(SingleProcessCoordinator singleProcessCoordinator, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3635d = singleProcessCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3634c = obj;
        this.f3636e |= Integer.MIN_VALUE;
        return this.f3635d.a(null, this);
    }
}
