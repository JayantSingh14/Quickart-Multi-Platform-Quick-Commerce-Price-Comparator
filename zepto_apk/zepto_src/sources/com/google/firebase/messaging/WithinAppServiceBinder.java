package com.google.firebase.messaging;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.firebase.messaging.EnhancedIntentService;
import com.google.firebase.messaging.WithinAppServiceConnection;

/* loaded from: classes4.dex */
class WithinAppServiceBinder extends Binder {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f44803b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final EnhancedIntentService.AnonymousClass1 f44804a;

    public interface IntentHandler {
    }

    public WithinAppServiceBinder(EnhancedIntentService.AnonymousClass1 anonymousClass1) {
        this.f44804a = anonymousClass1;
    }

    public final void a(WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        EnhancedIntentService.access$000(EnhancedIntentService.this, bindRequest.f44811a).b(new androidx.arch.core.executor.a(1), new u(bindRequest, 1));
    }
}
