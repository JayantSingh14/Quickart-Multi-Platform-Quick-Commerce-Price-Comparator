package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TasksKt {
    public static final Object a(Task task, Continuation frame) throws Exception {
        if (!task.o()) {
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
            cancellableContinuationImpl.s();
            task.b(DirectExecutor.f55262a, new OnCompleteListener() { // from class: kotlinx.coroutines.tasks.TasksKt$awaitImpl$2$1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    Exception excK = task2.k();
                    CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                    if (excK != null) {
                        Result.Companion companion = Result.f53538b;
                        cancellableContinuationImpl2.resumeWith(ResultKt.a(excK));
                    } else if (task2.n()) {
                        cancellableContinuationImpl2.l(null);
                    } else {
                        Result.Companion companion2 = Result.f53538b;
                        cancellableContinuationImpl2.resumeWith(task2.l());
                    }
                }
            });
            Object objR = cancellableContinuationImpl.r();
            if (objR == CoroutineSingletons.f53689a) {
                Intrinsics.checkNotNullParameter(frame, "frame");
            }
            return objR;
        }
        Exception excK = task.k();
        if (excK != null) {
            throw excK;
        }
        if (!task.n()) {
            return task.l();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }
}
