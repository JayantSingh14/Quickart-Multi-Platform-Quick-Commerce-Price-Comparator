package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", l = {160}, m = "awaitCancellation")
/* loaded from: classes3.dex */
final class DelayKt$awaitCancellation$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54087a;

    /* renamed from: b, reason: collision with root package name */
    public int f54088b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DelayKt$awaitCancellation$1 frame;
        this.f54087a = obj;
        int i2 = this.f54088b | Integer.MIN_VALUE;
        this.f54088b = i2;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f54088b = i2 - Integer.MIN_VALUE;
            frame = this;
        } else {
            frame = new DelayKt$awaitCancellation$1(this);
        }
        Object obj2 = frame.f54087a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = frame.f54088b;
        if (i3 == 0) {
            ResultKt.b(obj2);
            frame.f54088b = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
            cancellableContinuationImpl.s();
            Object objR = cancellableContinuationImpl.r();
            if (objR == coroutineSingletons) {
                Intrinsics.checkNotNullParameter(frame, "frame");
            }
            if (objR == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj2);
        }
        throw new KotlinNothingValueException();
    }
}
