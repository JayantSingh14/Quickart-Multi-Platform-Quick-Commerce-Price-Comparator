package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import in.juspay.airborne.ota.Constants;
import java.io.IOException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class Rpc {

    /* renamed from: h, reason: collision with root package name */
    public static int f22235h;

    /* renamed from: i, reason: collision with root package name */
    public static PendingIntent f22236i;

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f22237j = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: b, reason: collision with root package name */
    public final Context f22239b;

    /* renamed from: c, reason: collision with root package name */
    public final zzw f22240c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f22241d;

    /* renamed from: f, reason: collision with root package name */
    public Messenger f22243f;

    /* renamed from: g, reason: collision with root package name */
    public zzd f22244g;

    /* renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f22238a = new SimpleArrayMap();

    /* renamed from: e, reason: collision with root package name */
    public final Messenger f22242e = new Messenger(new zzae(this, Looper.getMainLooper()));

    public Rpc(Context context) {
        this.f22239b = context;
        this.f22240c = new zzw(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f22241d = scheduledThreadPoolExecutor;
    }

    public final Task a(Bundle bundle) throws RemoteException {
        final String string;
        synchronized (Rpc.class) {
            int i2 = f22235h;
            f22235h = i2 + 1;
            string = Integer.toString(i2);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f22238a) {
            this.f22238a.put(string, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f22240c.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        Context context = this.f22239b;
        synchronized (Rpc.class) {
            try {
                if (f22236i == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    f22236i = PendingIntent.getBroadcast(context, 0, intent2, com.google.android.gms.internal.cloudmessaging.zza.f36475a);
                }
                intent.putExtra(Constants.APP_DIR, f22236i);
            } finally {
            }
        }
        intent.putExtra("kid", "|ID|" + string + CLConstants.SALT_DELIMETER);
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending ".concat(String.valueOf(intent.getExtras())));
        }
        intent.putExtra("google.messenger", this.f22242e);
        if (this.f22243f != null || this.f22244g != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.f22243f;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    this.f22244g.a(messageObtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
        } else if (this.f22240c.b() == 2) {
            this.f22239b.sendBroadcast(intent);
        } else {
            this.f22239b.startService(intent);
        }
        final ScheduledFuture<?> scheduledFutureSchedule = this.f22241d.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzac
            @Override // java.lang.Runnable
            public final void run() {
                if (taskCompletionSource.c(new IOException("TIMEOUT"))) {
                    Log.w("Rpc", "No response");
                }
            }
        }, 30L, TimeUnit.SECONDS);
        taskCompletionSource.f39750a.b(zzy.f22292a, new OnCompleteListener() { // from class: com.google.android.gms.cloudmessaging.zzad
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                Rpc rpc = this.f22248a;
                String str = string;
                ScheduledFuture scheduledFuture = scheduledFutureSchedule;
                synchronized (rpc.f22238a) {
                    rpc.f22238a.remove(str);
                }
                scheduledFuture.cancel(false);
            }
        });
        return taskCompletionSource.f39750a;
    }

    public final void b(Bundle bundle, String str) {
        synchronized (this.f22238a) {
            try {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f22238a.remove(str);
                if (taskCompletionSource != null) {
                    taskCompletionSource.b(bundle);
                    return;
                }
                Log.w("Rpc", "Missing callback for " + str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
