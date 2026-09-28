package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;

@Metadata
/* loaded from: classes3.dex */
public final class WorkConstraintsTrackerKt {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12808a;

    static {
        String strG = Logger.g("WorkConstraintsTracker");
        Intrinsics.checkNotNullExpressionValue(strG, "tagWithPrefix(\"WorkConstraintsTracker\")");
        f12808a = strG;
    }

    public static final JobImpl b(WorkConstraintsTracker workConstraintsTracker, WorkSpec spec, CoroutineDispatcher dispatcher, OnConstraintsStateChangedListener listener) {
        Intrinsics.checkNotNullParameter(workConstraintsTracker, "<this>");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(listener, "listener");
        JobImpl jobImplA = JobKt.a();
        BuildersKt.c(CoroutineScopeKt.a(dispatcher.plus(jobImplA)), null, new WorkConstraintsTrackerKt$listen$1(workConstraintsTracker, spec, listener, null), 3);
        return jobImplA;
    }
}
