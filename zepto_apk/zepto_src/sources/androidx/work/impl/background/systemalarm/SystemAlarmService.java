package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;

@RestrictTo
/* loaded from: classes3.dex */
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.CommandsCompletedListener {

    /* renamed from: d, reason: collision with root package name */
    public static final String f12773d = Logger.g("SystemAlarmService");

    /* renamed from: b, reason: collision with root package name */
    public SystemAlarmDispatcher f12774b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12775c;

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.f12774b = systemAlarmDispatcher;
        if (systemAlarmDispatcher.f12765i != null) {
            Logger.e().c(SystemAlarmDispatcher.f12756k, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            systemAlarmDispatcher.f12765i = this;
        }
        this.f12775c = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f12775c = true;
        SystemAlarmDispatcher systemAlarmDispatcher = this.f12774b;
        systemAlarmDispatcher.getClass();
        Logger.e().a(SystemAlarmDispatcher.f12756k, "Destroying SystemAlarmDispatcher");
        systemAlarmDispatcher.f12760d.f(systemAlarmDispatcher);
        systemAlarmDispatcher.f12765i = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f12775c) {
            Logger.e().f(f12773d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            SystemAlarmDispatcher systemAlarmDispatcher = this.f12774b;
            systemAlarmDispatcher.getClass();
            Logger loggerE = Logger.e();
            String str = SystemAlarmDispatcher.f12756k;
            loggerE.a(str, "Destroying SystemAlarmDispatcher");
            systemAlarmDispatcher.f12760d.f(systemAlarmDispatcher);
            systemAlarmDispatcher.f12765i = null;
            SystemAlarmDispatcher systemAlarmDispatcher2 = new SystemAlarmDispatcher(this);
            this.f12774b = systemAlarmDispatcher2;
            if (systemAlarmDispatcher2.f12765i != null) {
                Logger.e().c(str, "A completion listener for SystemAlarmDispatcher already exists.");
            } else {
                systemAlarmDispatcher2.f12765i = this;
            }
            this.f12775c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f12774b.a(intent, i3);
        return 3;
    }
}
