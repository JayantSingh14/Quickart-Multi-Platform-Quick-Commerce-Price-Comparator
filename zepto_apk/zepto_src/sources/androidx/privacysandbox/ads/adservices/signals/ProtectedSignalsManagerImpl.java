package androidx.privacysandbox.ads.adservices.signals;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.a;
import androidx.core.os.OutcomeReceiverKt;
import androidx.core.os.b;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@ExperimentalFeatures.Ext12OptIn
@RequiresExtension
@RestrictTo
@SourceDebugExtension
/* loaded from: classes3.dex */
public class ProtectedSignalsManagerImpl extends ProtectedSignalsManager {
    @RequiresPermission
    @DoNotInline
    public static Object b(ProtectedSignalsManagerImpl protectedSignalsManagerImpl, UpdateSignalsRequest updateSignalsRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation));
        cancellableContinuationImpl.s();
        protectedSignalsManagerImpl.getClass();
        b.D();
        updateSignalsRequest.getClass();
        Intrinsics.checkNotNullExpressionValue(b.m().build(), "Builder(request.updateUri).build()");
        new a(1);
        OutcomeReceiverKt.a(cancellableContinuationImpl);
        throw null;
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object a(@NotNull UpdateSignalsRequest updateSignalsRequest, @NotNull Continuation<? super Unit> continuation) {
        return b(this, updateSignalsRequest, continuation);
    }
}
