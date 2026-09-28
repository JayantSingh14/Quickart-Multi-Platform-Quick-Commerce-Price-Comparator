package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.SingleProcessCoordinator", f = "SingleProcessCoordinator.kt", l = {WKSRecord.Protocol.RVD, 41}, m = "lock")
/* loaded from: classes.dex */
final class SingleProcessCoordinator$lock$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f3627a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f3628b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3629c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SingleProcessCoordinator f3630d;

    /* renamed from: e, reason: collision with root package name */
    public int f3631e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessCoordinator$lock$1(SingleProcessCoordinator singleProcessCoordinator, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3630d = singleProcessCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3629c = obj;
        this.f3631e |= Integer.MIN_VALUE;
        return this.f3630d.d(null, this);
    }
}
