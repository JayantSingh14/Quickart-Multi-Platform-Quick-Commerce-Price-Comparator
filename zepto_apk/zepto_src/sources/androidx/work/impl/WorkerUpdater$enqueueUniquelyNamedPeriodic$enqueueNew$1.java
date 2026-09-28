package androidx.work.impl;

import androidx.work.ExistingWorkPolicy;
import androidx.work.impl.utils.EnqueueRunnable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1 extends Lambda implements Function0<Unit> {
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        new EnqueueRunnable(new WorkContinuationImpl(null, null, ExistingWorkPolicy.f12517b, CollectionsKt.H(null)), null).run();
        return Unit.f53572a;
    }
}
