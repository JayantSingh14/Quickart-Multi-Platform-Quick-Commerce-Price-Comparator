package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.CancelWorkRunnable;
import java.util.UUID;

@RestrictTo
/* loaded from: classes3.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {

    /* renamed from: f, reason: collision with root package name */
    public static final String f12864f = Logger.g("SystemFgService");

    /* renamed from: b, reason: collision with root package name */
    public Handler f12865b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12866c;

    /* renamed from: d, reason: collision with root package name */
    public SystemForegroundDispatcher f12867d;

    /* renamed from: e, reason: collision with root package name */
    public NotificationManager f12868e;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(Service service, int i2, Notification notification, int i3) {
            service.startForeground(i2, notification, i3);
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static void a(Service service, int i2, Notification notification, int i3) {
            try {
                service.startForeground(i2, notification, i3);
            } catch (ForegroundServiceStartNotAllowedException e2) {
                Logger.e().i(SystemForegroundService.f12864f, "Unable to start foreground service", e2);
            }
        }
    }

    public final void a(final int i2) {
        this.f12865b.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.3
            @Override // java.lang.Runnable
            public final void run() {
                SystemForegroundService.this.f12868e.cancel(i2);
            }
        });
    }

    public final void b() {
        this.f12865b = new Handler(Looper.getMainLooper());
        this.f12868e = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.f12867d = systemForegroundDispatcher;
        if (systemForegroundDispatcher.f12861i != null) {
            Logger.e().c(SystemForegroundDispatcher.f12852j, "A callback already exists.");
        } else {
            systemForegroundDispatcher.f12861i = this;
        }
    }

    public final void c(final int i2, final int i3, final Notification notification) {
        this.f12865b.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.1
            @Override // java.lang.Runnable
            public final void run() {
                int i4 = Build.VERSION.SDK_INT;
                int i5 = i3;
                Notification notification2 = notification;
                int i6 = i2;
                SystemForegroundService systemForegroundService = SystemForegroundService.this;
                if (i4 >= 31) {
                    Api31Impl.a(systemForegroundService, i6, notification2, i5);
                } else if (i4 >= 29) {
                    Api29Impl.a(systemForegroundService, i6, notification2, i5);
                } else {
                    systemForegroundService.startForeground(i6, notification2);
                }
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        b();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f12867d.g();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        boolean z = this.f12866c;
        String str = f12864f;
        if (z) {
            Logger.e().f(str, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f12867d.g();
            b();
            this.f12866c = false;
        }
        if (intent == null) {
            return 3;
        }
        final SystemForegroundDispatcher systemForegroundDispatcher = this.f12867d;
        systemForegroundDispatcher.getClass();
        String action = intent.getAction();
        boolean zEquals = "ACTION_START_FOREGROUND".equals(action);
        String str2 = SystemForegroundDispatcher.f12852j;
        if (zEquals) {
            Logger.e().f(str2, "Started foreground service " + intent);
            final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            systemForegroundDispatcher.f12854b.c(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundDispatcher.1

                /* renamed from: a */
                public final /* synthetic */ String f12862a;

                public AnonymousClass1(final String stringExtra2) {
                    str = stringExtra2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WorkSpec workSpec;
                    Processor processor = SystemForegroundDispatcher.this.f12853a.f12658f;
                    String str3 = str;
                    synchronized (processor.f12626k) {
                        try {
                            WorkerWrapper workerWrapperC = processor.c(str3);
                            workSpec = workerWrapperC != null ? workerWrapperC.f12668d : null;
                        } finally {
                        }
                    }
                    if (workSpec == null || !workSpec.b()) {
                        return;
                    }
                    synchronized (SystemForegroundDispatcher.this.f12855c) {
                        SystemForegroundDispatcher.this.f12858f.put(WorkSpecKt.a(workSpec), workSpec);
                        SystemForegroundDispatcher systemForegroundDispatcher2 = SystemForegroundDispatcher.this;
                        SystemForegroundDispatcher.this.f12859g.put(WorkSpecKt.a(workSpec), WorkConstraintsTrackerKt.b(systemForegroundDispatcher2.f12860h, workSpec, systemForegroundDispatcher2.f12854b.f13062b, systemForegroundDispatcher2));
                    }
                }
            });
            systemForegroundDispatcher.f(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            systemForegroundDispatcher.f(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            Logger.e().f(str2, "Stopping foreground service");
            SystemForegroundService systemForegroundService = systemForegroundDispatcher.f12861i;
            if (systemForegroundService == null) {
                return 3;
            }
            systemForegroundService.f12866c = true;
            Logger.e().a(str, "All commands completed.");
            if (Build.VERSION.SDK_INT >= 26) {
                systemForegroundService.stopForeground(true);
            }
            systemForegroundService.stopSelf();
            return 3;
        }
        Logger.e().f(str2, "Stopping foreground work for " + intent);
        String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
            return 3;
        }
        UUID uuidFromString = UUID.fromString(stringExtra2);
        WorkManagerImpl workManagerImpl = systemForegroundDispatcher.f12853a;
        workManagerImpl.getClass();
        workManagerImpl.f12656d.c(CancelWorkRunnable.b(workManagerImpl, uuidFromString));
        return 3;
    }
}
