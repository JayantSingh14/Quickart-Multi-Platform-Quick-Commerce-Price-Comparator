package androidx.datastore.core;

import androidx.datastore.core.Message;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableDeferred;

@Metadata
/* loaded from: classes.dex */
final class DataStoreImpl$writeActor$2 extends Lambda implements Function2<Message.Update<Object>, Throwable, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final DataStoreImpl$writeActor$2 f3527c = new DataStoreImpl$writeActor$2(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Message.Update msg = (Message.Update) obj;
        Throwable cancellationException = (Throwable) obj2;
        Intrinsics.checkNotNullParameter(msg, "msg");
        CompletableDeferred completableDeferredA = msg.a();
        if (cancellationException == null) {
            cancellationException = new CancellationException("DataStore scope was cancelled before updateData could complete");
        }
        completableDeferredA.c(cancellationException);
        return Unit.f53572a;
    }
}
