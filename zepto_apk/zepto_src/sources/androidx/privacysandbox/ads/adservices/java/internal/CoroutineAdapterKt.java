package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.JobSupport;

@Metadata
/* loaded from: classes3.dex */
public final class CoroutineAdapterKt {
    public static ListenableFuture a(final Deferred deferred) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        ListenableFuture listenableFutureA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.privacysandbox.ads.adservices.java.internal.a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(final CallbackToFutureAdapter.Completer completer) {
                final Deferred this_asListenableFuture = deferred;
                Intrinsics.checkNotNullParameter(this_asListenableFuture, "$this_asListenableFuture");
                Intrinsics.checkNotNullParameter(completer, "completer");
                ((JobSupport) this_asListenableFuture).j0(new Function1<Throwable, Unit>() { // from class: androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$asListenableFuture$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Throwable th = (Throwable) obj;
                        CallbackToFutureAdapter.Completer completer2 = completer;
                        if (th == null) {
                            completer2.a(this_asListenableFuture.x());
                        } else if (th instanceof CancellationException) {
                            completer2.b();
                        } else {
                            completer2.c(th);
                        }
                        return Unit.f53572a;
                    }
                });
                return "Deferred.asListenableFuture";
            }
        });
        Intrinsics.checkNotNullExpressionValue(listenableFutureA, "getFuture { completer ->…      }\n        tag\n    }");
        return listenableFutureA;
    }
}
