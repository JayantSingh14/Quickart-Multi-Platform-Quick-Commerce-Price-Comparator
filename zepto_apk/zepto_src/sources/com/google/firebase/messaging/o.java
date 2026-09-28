package com.google.firebase.messaging;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f44841a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f44842b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f44843c;

    public /* synthetic */ o(Context context, boolean z, TaskCompletionSource taskCompletionSource) {
        this.f44841a = context;
        this.f44842b = z;
        this.f44843c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f44841a;
        TaskCompletionSource taskCompletionSource = this.f44843c;
        try {
            if (!(Binder.getCallingUid() == context.getApplicationInfo().uid)) {
                Log.e("FirebaseMessaging", "error configuring notification delegate for package " + context.getPackageName());
                return;
            }
            SharedPreferences.Editor editorEdit = ProxyNotificationPreferences.a(context).edit();
            editorEdit.putBoolean("proxy_notification_initialized", true);
            editorEdit.apply();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (this.f44842b) {
                notificationManager.setNotificationDelegate("com.google.android.gms");
            } else if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                notificationManager.setNotificationDelegate(null);
            }
        } finally {
            taskCompletionSource.d(null);
        }
    }
}
