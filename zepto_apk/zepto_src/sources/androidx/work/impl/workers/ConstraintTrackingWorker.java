package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.helper.widget.a;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@RestrictTo
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ConstraintTrackingWorker extends ListenableWorker implements OnConstraintsStateChangedListener {

    /* renamed from: e, reason: collision with root package name */
    public final WorkerParameters f13066e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f13067f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f13068g;

    /* renamed from: h, reason: collision with root package name */
    public final SettableFuture f13069h;

    /* renamed from: i, reason: collision with root package name */
    public ListenableWorker f13070i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(@NotNull Context appContext, @NotNull WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        this.f13066e = workerParameters;
        this.f13067f = new Object();
        this.f13069h = new SettableFuture();
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void e(WorkSpec workSpec, ConstraintsState state) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Intrinsics.checkNotNullParameter(state, "state");
        Logger.e().a(ConstraintTrackingWorkerKt.f13071a, "Constraints changed for " + workSpec);
        if (state instanceof ConstraintsState.ConstraintsNotMet) {
            synchronized (this.f13067f) {
                this.f13068g = true;
                Unit unit = Unit.f53572a;
            }
        }
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f13070i;
        if (listenableWorker == null || listenableWorker.isStopped()) {
            return;
        }
        listenableWorker.stop(Build.VERSION.SDK_INT >= 31 ? getStopReason() : 0);
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture startWork() {
        getBackgroundExecutor().execute(new a(this, 5));
        SettableFuture future = this.f13069h;
        Intrinsics.checkNotNullExpressionValue(future, "future");
        return future;
    }
}
