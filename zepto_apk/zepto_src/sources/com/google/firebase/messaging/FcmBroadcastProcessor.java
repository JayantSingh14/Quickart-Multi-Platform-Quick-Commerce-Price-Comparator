package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@KeepForSdk
/* loaded from: classes4.dex */
public class FcmBroadcastProcessor {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f44693c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static WithinAppServiceConnection f44694d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f44695a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.arch.core.executor.a f44696b = new androidx.arch.core.executor.a(1);

    public FcmBroadcastProcessor(Context context) {
        this.f44695a = context;
    }

    public static Task a(Context context, Intent intent, boolean z) {
        WithinAppServiceConnection withinAppServiceConnection;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        synchronized (f44693c) {
            try {
                if (f44694d == null) {
                    f44694d = new WithinAppServiceConnection(context);
                }
                withinAppServiceConnection = f44694d;
            } finally {
            }
        }
        if (!z) {
            return withinAppServiceConnection.b(intent).h(new androidx.arch.core.executor.a(1), new com.google.common.net.a(2));
        }
        if (ServiceStarter.a().c(context)) {
            synchronized (WakeLockHolder.f44801b) {
                try {
                    WakeLockHolder.a(context);
                    boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                    if (!booleanExtra) {
                        WakeLockHolder.f44802c.a(WakeLockHolder.f44800a);
                    }
                    withinAppServiceConnection.b(intent).addOnCompleteListener(new u(intent, 0));
                } finally {
                }
            }
        } else {
            withinAppServiceConnection.b(intent);
        }
        return Tasks.e(-1);
    }

    public final Task b(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        boolean zIsAtLeastO = PlatformVersion.isAtLeastO();
        final Context context = this.f44695a;
        boolean z = zIsAtLeastO && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z2 = (intent.getFlags() & 268435456) != 0;
        if (z && !z2) {
            return a(context, intent, z2);
        }
        androidx.arch.core.executor.a aVar = this.f44696b;
        return Tasks.c(new Callable() { // from class: com.google.firebase.messaging.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                ServiceInfo serviceInfo;
                String str2;
                int i2;
                ComponentName componentNameStartService;
                Context context2 = context;
                Intent intent2 = intent;
                ServiceStarter serviceStarterA = ServiceStarter.a();
                serviceStarterA.getClass();
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Starting service");
                }
                serviceStarterA.f44756d.offer(intent2);
                Intent intent3 = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent3.setPackage(context2.getPackageName());
                synchronized (serviceStarterA) {
                    try {
                        str = serviceStarterA.f44753a;
                        if (str == null) {
                            ResolveInfo resolveInfoResolveService = context2.getPackageManager().resolveService(intent3, 0);
                            if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
                                Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                            } else {
                                if (context2.getPackageName().equals(serviceInfo.packageName) && (str2 = serviceInfo.name) != null) {
                                    if (str2.startsWith(CLConstants.DOT_SALT_DELIMETER)) {
                                        serviceStarterA.f44753a = context2.getPackageName() + serviceInfo.name;
                                    } else {
                                        serviceStarterA.f44753a = serviceInfo.name;
                                    }
                                    str = serviceStarterA.f44753a;
                                }
                                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                            }
                            str = null;
                        }
                    } finally {
                    }
                }
                if (str != null) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Restricting intent to a specific service: ".concat(str));
                    }
                    intent3.setClassName(context2.getPackageName(), str);
                }
                try {
                    if (serviceStarterA.c(context2)) {
                        componentNameStartService = WakeLockHolder.c(context2, intent3);
                    } else {
                        componentNameStartService = context2.startService(intent3);
                        Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
                    }
                    if (componentNameStartService == null) {
                        Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
                        i2 = 404;
                    } else {
                        i2 = -1;
                    }
                } catch (IllegalStateException e2) {
                    Log.e("FirebaseMessaging", "Failed to start service while in background: " + e2);
                    i2 = 402;
                } catch (SecurityException e3) {
                    Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e3);
                    i2 = 401;
                }
                return Integer.valueOf(i2);
            }
        }, aVar).j(aVar, new Continuation() { // from class: com.google.firebase.messaging.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return (PlatformVersion.isAtLeastO() && ((Integer) task.l()).intValue() == 402) ? FcmBroadcastProcessor.a(context, intent, z2).h(new androidx.arch.core.executor.a(1), new com.google.common.net.a(1)) : task;
            }
        });
    }
}
