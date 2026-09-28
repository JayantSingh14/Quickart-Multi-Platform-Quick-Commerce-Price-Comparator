package app.cash.sqldelight;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "app.cash.sqldelight.SuspendingTransacterImpl", f = "Transacter.kt", l = {397, 407, 412, 412, 412}, m = "transactionWithWrapper")
/* loaded from: classes3.dex */
final class SuspendingTransacterImpl$transactionWithWrapper$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f13079a;

    /* renamed from: b, reason: collision with root package name */
    public int f13080b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f13079a = obj;
        this.f13080b |= Integer.MIN_VALUE;
        throw null;
    }
}
