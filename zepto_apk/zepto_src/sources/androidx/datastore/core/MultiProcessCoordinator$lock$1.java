package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", l = {211, 47, Type.DNSKEY}, m = "lock")
/* loaded from: classes3.dex */
final class MultiProcessCoordinator$lock$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f3590a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3591b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3592c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f3593d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MultiProcessCoordinator f3594e;

    /* renamed from: f, reason: collision with root package name */
    public int f3595f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$lock$1(MultiProcessCoordinator multiProcessCoordinator, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3594e = multiProcessCoordinator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3593d = obj;
        this.f3595f |= Integer.MIN_VALUE;
        return this.f3594e.d(null, this);
    }
}
