package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", l = {62, 87}, m = "tryLock")
/* loaded from: classes3.dex */
final class MultiProcessCoordinator$tryLock$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public MutexImpl f3596a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3597b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3598c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MultiProcessCoordinator f3599d;

    /* renamed from: e, reason: collision with root package name */
    public int f3600e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$tryLock$1(MultiProcessCoordinator multiProcessCoordinator, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3599d = multiProcessCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3598c = obj;
        this.f3600e |= Integer.MIN_VALUE;
        return this.f3599d.a(null, this);
    }
}
