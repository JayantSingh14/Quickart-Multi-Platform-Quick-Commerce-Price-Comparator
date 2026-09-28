package androidx.work;

import android.content.Context;
import android.support.v4.media.b;

/* loaded from: classes.dex */
public abstract class WorkerFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12586a = Logger.g("WorkerFactory");

    /* renamed from: androidx.work.WorkerFactory$1, reason: invalid class name */
    class AnonymousClass1 extends WorkerFactory {
        @Override // androidx.work.WorkerFactory
        public final ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
            return null;
        }
    }

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        String str2 = f12586a;
        ListenableWorker listenableWorkerA = a(context, str, workerParameters);
        if (listenableWorkerA == null) {
            try {
                clsAsSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                Logger.e().d(str2, "Invalid class: " + str, th);
                clsAsSubclass = null;
            }
            if (clsAsSubclass != null) {
                try {
                    listenableWorkerA = (ListenableWorker) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                } catch (Throwable th2) {
                    Logger.e().d(str2, "Could not instantiate " + str, th2);
                }
            }
        }
        if (listenableWorkerA == null || !listenableWorkerA.isUsed()) {
            return listenableWorkerA;
        }
        throw new IllegalStateException(b.m("WorkerFactory (", getClass().getName(), ") returned an instance of a ListenableWorker (", str, ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker."));
    }
}
