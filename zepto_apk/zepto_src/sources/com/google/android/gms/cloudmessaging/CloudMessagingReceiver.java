package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static SoftReference f22233a;

    /* renamed from: b, reason: collision with root package name */
    public static SoftReference f22234b;

    public static final class IntentActionKeys {
    }

    public static final class IntentKeys {
    }

    public abstract int a(Context context, CloudMessage cloudMessage);

    public final int c(Context context, Intent intent) throws PendingIntent.CanceledException {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if (Objects.equals(intent.getAction(), "com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
            b(extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        ExecutorService executorService;
        if (intent == null) {
            return;
        }
        final boolean zIsOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        synchronized (CloudMessagingReceiver.class) {
            try {
                SoftReference softReference = f22233a;
                ExecutorService executorServiceUnconfigurableExecutorService = softReference != null ? (ExecutorService) softReference.get() : null;
                if (executorServiceUnconfigurableExecutorService == null) {
                    executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new NamedThreadFactory("firebase-iid-executor")));
                    f22233a = new SoftReference(executorServiceUnconfigurableExecutorService);
                }
                executorService = executorServiceUnconfigurableExecutorService;
            } catch (Throwable th) {
                throw th;
            }
        }
        executorService.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzh
            @Override // java.lang.Runnable
            public final void run() {
                Executor executorUnconfigurableExecutorService;
                int iC;
                CloudMessagingReceiver cloudMessagingReceiver = this.f22258a;
                Intent intent2 = intent;
                final Context context2 = context;
                boolean z = zIsOrderedBroadcast;
                BroadcastReceiver.PendingResult pendingResult = pendingResultGoAsync;
                try {
                    Parcelable parcelableExtra = intent2.getParcelableExtra("wrapped_intent");
                    Intent intent3 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
                    if (intent3 != null) {
                        iC = cloudMessagingReceiver.c(context2, intent3);
                    } else if (intent2.getExtras() == null) {
                        iC = 500;
                    } else {
                        final CloudMessage cloudMessage = new CloudMessage(intent2);
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        synchronized (CloudMessagingReceiver.class) {
                            try {
                                SoftReference softReference2 = CloudMessagingReceiver.f22234b;
                                executorUnconfigurableExecutorService = softReference2 != null ? (Executor) softReference2.get() : null;
                                if (executorUnconfigurableExecutorService == null) {
                                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("pscm-ack-executor"));
                                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                                    executorUnconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
                                    CloudMessagingReceiver.f22234b = new SoftReference(executorUnconfigurableExecutorService);
                                }
                            } finally {
                            }
                        }
                        executorUnconfigurableExecutorService.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzg
                            @Override // java.lang.Runnable
                            public final void run() {
                                Task taskB;
                                CloudMessage cloudMessage2 = cloudMessage;
                                if (TextUtils.isEmpty(cloudMessage2.b())) {
                                    taskB = Tasks.e(null);
                                } else {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("google.message_id", cloudMessage2.b());
                                    Integer numR = cloudMessage2.r();
                                    if (numR != null) {
                                        bundle.putInt("google.product_id", numR.intValue());
                                    }
                                    bundle.putBoolean("supports_message_handled", true);
                                    taskB = zzv.a(context2).b(2, bundle);
                                }
                                zze zzeVar = zze.f22253a;
                                final CountDownLatch countDownLatch2 = countDownLatch;
                                taskB.b(zzeVar, new OnCompleteListener() { // from class: com.google.android.gms.cloudmessaging.zzf
                                    @Override // com.google.android.gms.tasks.OnCompleteListener
                                    public final void onComplete(Task task) {
                                        countDownLatch2.countDown();
                                    }
                                });
                            }
                        });
                        int iA = cloudMessagingReceiver.a(context2, cloudMessage);
                        try {
                            if (!countDownLatch.await(TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS)) {
                                Log.w("CloudMessagingReceiver", "Message ack timed out");
                            }
                        } catch (InterruptedException e2) {
                            Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e2.toString()));
                        }
                        iC = iA;
                    }
                    if (z && pendingResult != null) {
                        pendingResult.setResultCode(iC);
                    }
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                } catch (Throwable th2) {
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    throw th2;
                }
            }
        });
    }

    public void b(Bundle bundle) {
    }
}
