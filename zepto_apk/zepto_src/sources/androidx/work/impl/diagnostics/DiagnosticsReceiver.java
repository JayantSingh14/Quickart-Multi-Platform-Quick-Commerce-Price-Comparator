package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.workers.DiagnosticsWorker;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo
/* loaded from: classes3.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12851a = Logger.g("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Logger loggerE = Logger.e();
        String str = f12851a;
        loggerE.a(str, "Requesting diagnostics");
        try {
            WorkManagerImpl workManagerImplF = WorkManagerImpl.f(context);
            Intrinsics.checkNotNullParameter(DiagnosticsWorker.class, "workerClass");
            Intrinsics.checkNotNullParameter(DiagnosticsWorker.class, "workerClass");
            workManagerImplF.b((OneTimeWorkRequest) new OneTimeWorkRequest.Builder(DiagnosticsWorker.class).b());
        } catch (IllegalStateException e2) {
            Logger.e().d(str, "WorkManager is not initialized", e2);
        }
    }
}
