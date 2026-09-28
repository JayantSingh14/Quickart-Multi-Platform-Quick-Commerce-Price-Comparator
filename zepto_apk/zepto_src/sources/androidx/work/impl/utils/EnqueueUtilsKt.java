package androidx.work.impl.utils;

import android.support.v4.media.b;
import androidx.work.Configuration;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EnqueueUtilsKt {
    public static final void a(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl continuation) {
        int i2;
        Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        ArrayList arrayListJ = CollectionsKt.J(continuation);
        int i3 = 0;
        while (!arrayListJ.isEmpty()) {
            List list = ((WorkContinuationImpl) CollectionsKt.P(arrayListJ)).f12636d;
            Intrinsics.checkNotNullExpressionValue(list, "current.work");
            List list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i2 = 0;
            } else {
                Iterator it = list2.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (!((WorkRequest) it.next()).f12576b.f12914j.f12494h.isEmpty() && (i2 = i2 + 1) < 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
            }
            i3 += i2;
        }
        if (i3 == 0) {
            return;
        }
        int iB = workDatabase.v().B();
        int i4 = configuration.f12482i;
        if (iB + i3 > i4) {
            throw new IllegalArgumentException(b.o(b.t(i4, iB, "Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ", ";\nalready enqueued count: ", ";\ncurrent enqueue operation count: "), i3, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed."));
        }
    }
}
