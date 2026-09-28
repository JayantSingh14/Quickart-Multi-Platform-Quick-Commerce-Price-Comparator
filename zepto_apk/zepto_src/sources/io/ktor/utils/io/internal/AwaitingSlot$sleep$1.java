package io.ktor.utils.io.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableJob;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", l = {24}, m = "sleep")
/* loaded from: classes3.dex */
final class AwaitingSlot$sleep$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AwaitingSlot f51231a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51232b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AwaitingSlot f51233c;

    /* renamed from: d, reason: collision with root package name */
    public int f51234d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwaitingSlot$sleep$1(AwaitingSlot awaitingSlot, Continuation continuation) {
        super(continuation);
        this.f51233c = awaitingSlot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AwaitingSlot$sleep$1 awaitingSlot$sleep$1;
        this.f51232b = obj;
        this.f51234d |= Integer.MIN_VALUE;
        AwaitingSlot awaitingSlot = this.f51233c;
        awaitingSlot.getClass();
        int i2 = this.f51234d;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f51234d = i2 - Integer.MIN_VALUE;
            awaitingSlot$sleep$1 = this;
        } else {
            awaitingSlot$sleep$1 = new AwaitingSlot$sleep$1(awaitingSlot, this);
        }
        Object objA = awaitingSlot$sleep$1.f51232b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = awaitingSlot$sleep$1.f51234d;
        if (i3 == 0) {
            ResultKt.b(objA);
            awaitingSlot$sleep$1.f51231a = awaitingSlot;
            awaitingSlot$sleep$1.f51234d = 1;
            objA = awaitingSlot.a(awaitingSlot$sleep$1);
            if (objA == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            awaitingSlot = awaitingSlot$sleep$1.f51231a;
            ResultKt.b(objA);
        }
        if (((Boolean) objA).booleanValue()) {
            return Unit.f53572a;
        }
        awaitingSlot.getClass();
        CompletableJob completableJob = (CompletableJob) AwaitingSlot.f51230a.getAndSet(awaitingSlot, null);
        if (completableJob != null) {
            completableJob.complete();
        }
        return Unit.f53572a;
    }
}
