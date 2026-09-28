package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.WithinAppServiceBinder;
import com.google.firebase.messaging.threads.PoolableExecutors;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: classes.dex */
public abstract class EnhancedIntentService extends Service {
    static final long MESSAGE_TIMEOUT_S = 20;
    private static final String TAG = "EnhancedIntentService";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f44691a = 0;
    private Binder binder;
    private int lastStartId;

    @VisibleForTesting
    final ExecutorService executor = PoolableExecutors.f44897b.a(new NamedThreadFactory("Firebase-Messaging-Intent-Handle"));
    private final Object lock = new Object();
    private int runningTasks = 0;

    /* renamed from: com.google.firebase.messaging.EnhancedIntentService$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements WithinAppServiceBinder.IntentHandler {
        public AnonymousClass1() {
        }
    }

    public static Task access$000(EnhancedIntentService enhancedIntentService, Intent intent) {
        if (enhancedIntentService.handleIntentOnMainThread(intent)) {
            return Tasks.e(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        enhancedIntentService.executor.execute(new c(enhancedIntentService, intent, taskCompletionSource));
        return taskCompletionSource.f39750a;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            WakeLockHolder.b(intent);
        }
        synchronized (this.lock) {
            try {
                int i2 = this.runningTasks - 1;
                this.runningTasks = i2;
                if (i2 == 0) {
                    stopSelfResultHook(this.lastStartId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Service received bind request");
            }
            if (this.binder == null) {
                this.binder = new WithinAppServiceBinder(new AnonymousClass1());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.binder;
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i2, int i3) {
        Task taskE;
        synchronized (this.lock) {
            this.lastStartId = i3;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            a(intent);
            return 2;
        }
        if (handleIntentOnMainThread(startCommandIntent)) {
            taskE = Tasks.e(null);
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.executor.execute(new c(this, startCommandIntent, taskCompletionSource));
            taskE = taskCompletionSource.f39750a;
        }
        if (taskE.o()) {
            a(intent);
            return 2;
        }
        taskE.b(new a(0), new OnCompleteListener() { // from class: com.google.firebase.messaging.b
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                int i4 = EnhancedIntentService.f44691a;
                this.f44814a.a(intent);
            }
        });
        return 3;
    }

    public boolean stopSelfResultHook(int i2) {
        return stopSelfResult(i2);
    }
}
