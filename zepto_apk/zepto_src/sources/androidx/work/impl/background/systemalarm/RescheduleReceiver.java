package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12755a = Logger.g("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Logger.e().a(f12755a, "Received intent " + intent);
        try {
            WorkManagerImpl workManagerImplF = WorkManagerImpl.f(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            workManagerImplF.getClass();
            synchronized (WorkManagerImpl.f12652m) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = workManagerImplF.f12661i;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    workManagerImplF.f12661i = pendingResultGoAsync;
                    if (workManagerImplF.f12660h) {
                        pendingResultGoAsync.finish();
                        workManagerImplF.f12661i = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IllegalStateException e2) {
            Logger.e().d(f12755a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
        }
    }
}
