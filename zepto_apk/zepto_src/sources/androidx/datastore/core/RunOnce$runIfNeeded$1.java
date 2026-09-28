package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.RunOnce", f = "DataStoreImpl.kt", l = {544, 497}, m = "runIfNeeded")
/* loaded from: classes.dex */
final class RunOnce$runIfNeeded$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public RunOnce f3608a;

    /* renamed from: b, reason: collision with root package name */
    public Mutex f3609b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3610c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RunOnce f3611d;

    /* renamed from: e, reason: collision with root package name */
    public int f3612e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunOnce$runIfNeeded$1(RunOnce runOnce, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3611d = runOnce;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3610c = obj;
        this.f3612e |= Integer.MIN_VALUE;
        return this.f3611d.b(this);
    }
}
