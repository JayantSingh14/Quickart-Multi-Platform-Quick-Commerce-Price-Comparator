package androidx.work;

import android.content.Context;
import android.support.v4.media.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class DelegatingWorkerFactory extends WorkerFactory {

    /* renamed from: c, reason: collision with root package name */
    public static final String f12512c = Logger.g("DelegatingWkrFctry");

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f12513b = new CopyOnWriteArrayList();

    @Override // androidx.work.WorkerFactory
    public final ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
        Iterator it = this.f12513b.iterator();
        while (it.hasNext()) {
            try {
                ListenableWorker listenableWorkerA = ((WorkerFactory) it.next()).a(context, str, workerParameters);
                if (listenableWorkerA != null) {
                    return listenableWorkerA;
                }
            } catch (Throwable th) {
                Logger.e().d(f12512c, b.D("Unable to instantiate a ListenableWorker (", str, ")"), th);
                throw th;
            }
        }
        return null;
    }
}
