package coil3.network.okhttp.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CallsKt {
    @Nullable
    public static final Object await(@NotNull Call call, @NotNull Continuation<? super Response> frame) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        ContinuationCallback continuationCallback = new ContinuationCallback(call, cancellableContinuationImpl);
        call.l0(continuationCallback);
        cancellableContinuationImpl.u(continuationCallback);
        Object objR = cancellableContinuationImpl.r();
        if (objR == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR;
    }
}
