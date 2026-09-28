package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes.dex */
public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {

    /* renamed from: f, reason: collision with root package name */
    public final BroadcastReceiverConstraintTracker$broadcastReceiver$1 f12833f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker$broadcastReceiver$1] */
    public BroadcastReceiverConstraintTracker(Context context, WorkManagerTaskExecutor taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        this.f12833f = new BroadcastReceiver() { // from class: androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker$broadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                this.f12834a.f(intent);
            }
        };
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void c() {
        Logger.e().a(BroadcastReceiverConstraintTrackerKt.f12835a, getClass().getSimpleName().concat(": registering receiver"));
        this.f12837b.registerReceiver(this.f12833f, e());
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void d() {
        Logger.e().a(BroadcastReceiverConstraintTrackerKt.f12835a, getClass().getSimpleName().concat(": unregistering receiver"));
        this.f12837b.unregisterReceiver(this.f12833f);
    }

    public abstract IntentFilter e();

    public abstract void f(Intent intent);
}
