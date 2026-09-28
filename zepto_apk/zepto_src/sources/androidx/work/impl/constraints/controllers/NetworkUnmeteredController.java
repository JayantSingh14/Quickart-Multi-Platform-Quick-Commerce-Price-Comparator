package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.NetworkStateTracker24;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class NetworkUnmeteredController extends ConstraintController<NetworkState> {

    /* renamed from: b, reason: collision with root package name */
    public final int f12829b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkUnmeteredController(NetworkStateTracker24 tracker) {
        super(tracker);
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.f12829b = 7;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final int a() {
        return this.f12829b;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean b(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        NetworkType networkType = workSpec.f12914j.f12487a;
        if (networkType != NetworkType.f12538c) {
            return Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.f12541f;
        }
        return true;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean c(Object obj) {
        NetworkState value = (NetworkState) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        return !value.a() || value.b();
    }
}
