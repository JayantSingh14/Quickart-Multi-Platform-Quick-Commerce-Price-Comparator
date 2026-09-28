package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.NetworkStateTracker24;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class NetworkMeteredController extends ConstraintController<NetworkState> {

    /* renamed from: c, reason: collision with root package name */
    public static final String f12826c;

    /* renamed from: b, reason: collision with root package name */
    public final int f12827b;

    @Metadata
    public static final class Companion {
    }

    static {
        String strG = Logger.g("NetworkMeteredCtrlr");
        Intrinsics.checkNotNullExpressionValue(strG, "tagWithPrefix(\"NetworkMeteredCtrlr\")");
        f12826c = strG;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkMeteredController(NetworkStateTracker24 tracker) {
        super(tracker);
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.f12827b = 7;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final int a() {
        return this.f12827b;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean b(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        return workSpec.f12914j.f12487a == NetworkType.f12540e;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean c(Object obj) {
        NetworkState value = (NetworkState) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        if (Build.VERSION.SDK_INT >= 26) {
            return (value.a() && value.b()) ? false : true;
        }
        Logger.e().a(f12826c, "Metered network constraint is not supported before API 26, only checking for connected state.");
        return !value.a();
    }
}
