package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BlockingAdapter$end$1 implements Continuation<Unit> {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f51305a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BlockingAdapter f51306b;

    public BlockingAdapter$end$1(BlockingAdapter blockingAdapter) {
        this.f51306b = blockingAdapter;
        Job job = blockingAdapter.f51297a;
        this.f51305a = job != null ? UnsafeBlockingTrampoline.f51345b.plus(job) : UnsafeBlockingTrampoline.f51345b;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f51305a;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object obj2;
        boolean z;
        boolean z2;
        Throwable thA;
        Job job;
        Object objA = Result.a(obj);
        if (objA == null) {
            objA = Unit.f53572a;
        }
        BlockingAdapter blockingAdapter = this.f51306b;
        do {
            obj2 = blockingAdapter.state;
            z = obj2 instanceof Thread;
            z2 = true;
            if (!(z ? true : obj2 instanceof Continuation ? true : Intrinsics.b(obj2, this))) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BlockingAdapter.f51296f;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(blockingAdapter, obj2, objA)) {
                    break;
                } else if (atomicReferenceFieldUpdater.get(blockingAdapter) != obj2) {
                    z2 = false;
                    break;
                }
            }
        } while (!z2);
        if (z) {
            Parking parking = (Parking) PollersKt.f51329a.get();
            if (parking == null) {
                parking = DefaultParking.f51311a;
            }
            parking.b(obj2);
        } else if ((obj2 instanceof Continuation) && (thA = Result.a(obj)) != null) {
            ((Continuation) obj2).resumeWith(ResultKt.a(thA));
        }
        if ((obj instanceof Result.Failure) && !(Result.a(obj) instanceof CancellationException) && (job = this.f51306b.f51297a) != null) {
            job.e(null);
        }
        DisposableHandle disposableHandle = this.f51306b.f51299c;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }
}
