package androidx.work;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ListenableFutureKt$await$2$1 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            Result.Companion companion = Result.f53538b;
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                throw null;
            }
            Result.Companion companion2 = Result.f53538b;
            ResultKt.a(cause);
            throw null;
        }
    }
}
