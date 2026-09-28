package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import com.chuckerteam.chucker.internal.data.room.ChuckerDatabase_Impl;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;

@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class CoroutinesRoom {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    public static final Object a(ChuckerDatabase_Impl chuckerDatabase_Impl, final CancellationSignal cancellationSignal, Callable callable, ContinuationImpl frame) throws Throwable {
        CoroutineDispatcher coroutineDispatcher;
        if (chuckerDatabase_Impl.l() && chuckerDatabase_Impl.g().m1().z1()) {
            return callable.call();
        }
        if (((TransactionElement) frame.getContext().get(TransactionElement.f11850a)) != null) {
            coroutineDispatcher = null;
        } else {
            Map map = chuckerDatabase_Impl.f11807k;
            Object objA = map.get("QueryDispatcher");
            if (objA == null) {
                Executor executor = chuckerDatabase_Impl.f11798b;
                if (executor == null) {
                    Intrinsics.h("internalQueryExecutor");
                    throw null;
                }
                objA = ExecutorsKt.a(executor);
                map.put("QueryDispatcher", objA);
            }
            coroutineDispatcher = (CoroutineDispatcher) objA;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        final Job jobC = BuildersKt.c(GlobalScope.f54113a, coroutineDispatcher, new CoroutinesRoom$Companion$execute$4$job$1(callable, cancellableContinuationImpl, null), 2);
        cancellableContinuationImpl.u(new Function1<Throwable, Unit>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CancellationSignal cancellationSignal2 = cancellationSignal;
                Intrinsics.checkNotNullParameter(cancellationSignal2, "cancellationSignal");
                cancellationSignal2.cancel();
                ((JobSupport) jobC).e(null);
                return Unit.f53572a;
            }
        });
        Object objR = cancellableContinuationImpl.r();
        if (objR == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR;
    }

    public static final Object b(ChuckerDatabase_Impl chuckerDatabase_Impl, Callable callable, ContinuationImpl continuationImpl) {
        CoroutineDispatcher coroutineDispatcher;
        if (chuckerDatabase_Impl.l() && chuckerDatabase_Impl.g().m1().z1()) {
            return callable.call();
        }
        if (((TransactionElement) continuationImpl.getContext().get(TransactionElement.f11850a)) != null) {
            coroutineDispatcher = null;
        } else {
            Map map = chuckerDatabase_Impl.f11807k;
            Object objA = map.get("TransactionDispatcher");
            if (objA == null) {
                TransactionExecutor transactionExecutor = chuckerDatabase_Impl.f11799c;
                if (transactionExecutor == null) {
                    Intrinsics.h("internalTransactionExecutor");
                    throw null;
                }
                objA = ExecutorsKt.a(transactionExecutor);
                map.put("TransactionDispatcher", objA);
            }
            coroutineDispatcher = (CoroutineDispatcher) objA;
        }
        return BuildersKt.e(coroutineDispatcher, new CoroutinesRoom$Companion$execute$2(callable, null), continuationImpl);
    }
}
