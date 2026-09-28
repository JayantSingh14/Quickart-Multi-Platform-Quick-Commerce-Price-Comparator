package com.google.firebase.sessions;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata
/* loaded from: classes.dex */
public final class SessionLifecycleServiceBinderImpl implements SessionLifecycleServiceBinder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f45118a;

    @Metadata
    public static final class Companion {
    }

    public SessionLifecycleServiceBinderImpl(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.f45118a = appContext;
    }

    @Override // com.google.firebase.sessions.SessionLifecycleServiceBinder
    public final void a(Messenger callback, ServiceConnection serviceConnection) {
        boolean zBindService;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(serviceConnection, "serviceConnection");
        Context context = this.f45118a;
        Intent intent = new Intent(context, (Class<?>) SessionLifecycleService.class);
        Log.d("LifecycleServiceBinder", "Binding service to application.");
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra("ClientCallbackMessenger", callback);
        intent.setPackage(context.getPackageName());
        try {
            zBindService = context.bindService(intent, serviceConnection, 65);
        } catch (SecurityException e2) {
            Log.w("LifecycleServiceBinder", "Failed to bind session lifecycle service to application.", e2);
            zBindService = false;
        }
        if (zBindService) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
            Unit unit = Unit.f53572a;
        } catch (IllegalArgumentException e3) {
            Log.w("LifecycleServiceBinder", "Session lifecycle service binding failed.", e3);
        }
        Log.i("LifecycleServiceBinder", "Session lifecycle service binding failed.");
    }
}
