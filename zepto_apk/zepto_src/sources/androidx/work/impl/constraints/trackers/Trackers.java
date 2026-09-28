package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes.dex */
public final class Trackers {

    /* renamed from: a, reason: collision with root package name */
    public final BatteryChargingTracker f12847a;

    /* renamed from: b, reason: collision with root package name */
    public final BatteryNotLowTracker f12848b;

    /* renamed from: c, reason: collision with root package name */
    public final NetworkStateTracker24 f12849c;

    /* renamed from: d, reason: collision with root package name */
    public final StorageNotLowTracker f12850d;

    public Trackers(Context context, WorkManagerTaskExecutor taskExecutor) {
        Context context2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context.applicationContext");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        BatteryChargingTracker batteryChargingTracker = new BatteryChargingTracker(context2, taskExecutor);
        Context context3 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context.applicationContext");
        Intrinsics.checkNotNullParameter(context3, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        BatteryNotLowTracker batteryNotLowTracker = new BatteryNotLowTracker(context3, taskExecutor);
        Context context4 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context.applicationContext");
        String str = NetworkStateTrackerKt.f12845a;
        Intrinsics.checkNotNullParameter(context4, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        NetworkStateTracker24 networkStateTracker = new NetworkStateTracker24(context4, taskExecutor);
        Context context5 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context.applicationContext");
        Intrinsics.checkNotNullParameter(context5, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        StorageNotLowTracker storageNotLowTracker = new StorageNotLowTracker(context5, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        Intrinsics.checkNotNullParameter(batteryChargingTracker, "batteryChargingTracker");
        Intrinsics.checkNotNullParameter(batteryNotLowTracker, "batteryNotLowTracker");
        Intrinsics.checkNotNullParameter(networkStateTracker, "networkStateTracker");
        Intrinsics.checkNotNullParameter(storageNotLowTracker, "storageNotLowTracker");
        this.f12847a = batteryChargingTracker;
        this.f12848b = batteryNotLowTracker;
        this.f12849c = networkStateTracker;
        this.f12850d = storageNotLowTracker;
    }
}
