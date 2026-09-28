package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class LifecycleService extends Service implements LifecycleOwner {

    /* renamed from: a, reason: collision with root package name */
    public final ServiceLifecycleDispatcher f4827a = new ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f4827a.f4922a;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.f4827a.a(Lifecycle.Event.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f4827a.a(Lifecycle.Event.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Lifecycle.Event event = Lifecycle.Event.ON_STOP;
        ServiceLifecycleDispatcher serviceLifecycleDispatcher = this.f4827a;
        serviceLifecycleDispatcher.a(event);
        serviceLifecycleDispatcher.a(Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i2) {
        this.f4827a.a(Lifecycle.Event.ON_START);
        super.onStart(intent, i2);
    }
}
