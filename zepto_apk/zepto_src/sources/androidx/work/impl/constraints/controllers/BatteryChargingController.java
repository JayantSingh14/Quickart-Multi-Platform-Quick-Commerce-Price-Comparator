package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.trackers.BatteryChargingTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class BatteryChargingController extends ConstraintController<Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public final int f12815b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatteryChargingController(BatteryChargingTracker tracker) {
        super(tracker);
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.f12815b = 6;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final int a() {
        return this.f12815b;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean b(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        return workSpec.f12914j.f12488b;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean c(Object obj) {
        return !((Boolean) obj).booleanValue();
    }
}
