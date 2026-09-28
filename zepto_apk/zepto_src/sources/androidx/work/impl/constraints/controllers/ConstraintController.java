package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
/* loaded from: classes.dex */
public abstract class ConstraintController<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintTracker f12817a;

    public ConstraintController(ConstraintTracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.f12817a = tracker;
    }

    public abstract int a();

    public abstract boolean b(WorkSpec workSpec);

    public abstract boolean c(Object obj);

    public final Flow d() {
        return FlowKt.a(new ConstraintController$track$1(this, null));
    }
}
