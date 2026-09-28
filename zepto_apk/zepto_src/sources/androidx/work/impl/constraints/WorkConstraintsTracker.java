package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.NetworkStateTracker24;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class WorkConstraintsTracker {

    /* renamed from: a, reason: collision with root package name */
    public final List f12801a;

    public WorkConstraintsTracker(Trackers trackers) {
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        BatteryChargingController batteryChargingController = new BatteryChargingController(trackers.f12847a);
        BatteryNotLowController batteryNotLowController = new BatteryNotLowController(trackers.f12848b);
        StorageNotLowController storageNotLowController = new StorageNotLowController(trackers.f12850d);
        NetworkStateTracker24 networkStateTracker24 = trackers.f12849c;
        List controllers = CollectionsKt.I(batteryChargingController, batteryNotLowController, storageNotLowController, new NetworkConnectedController(networkStateTracker24), new NetworkUnmeteredController(networkStateTracker24), new NetworkNotRoamingController(networkStateTracker24), new NetworkMeteredController(networkStateTracker24));
        Intrinsics.checkNotNullParameter(controllers, "controllers");
        this.f12801a = controllers;
    }

    public final boolean a(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        List list = this.f12801a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ConstraintController constraintController = (ConstraintController) obj;
            constraintController.getClass();
            Intrinsics.checkNotNullParameter(workSpec, "workSpec");
            if (constraintController.b(workSpec) && constraintController.c(constraintController.f12817a.a())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger.e().a(WorkConstraintsTrackerKt.f12808a, "Work " + workSpec.f12905a + " constrained by " + CollectionsKt.E(arrayList, null, null, null, WorkConstraintsTracker$areAllConstraintsMet$1.f12807c, 31));
        }
        return arrayList.isEmpty();
    }
}
