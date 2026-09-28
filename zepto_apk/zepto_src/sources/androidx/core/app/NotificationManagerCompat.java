package androidx.core.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class NotificationManagerCompat {

    /* renamed from: d, reason: collision with root package name */
    public static String f2687d;

    /* renamed from: g, reason: collision with root package name */
    public static SideChannelManager f2690g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f2691a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f2692b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f2686c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static HashSet f2688e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f2689f = new Object();

    @RequiresApi
    public static class Api23Impl {
    }

    @RequiresApi
    public static class Api24Impl {
    }

    @RequiresApi
    public static class Api26Impl {
    }

    @RequiresApi
    public static class Api28Impl {
    }

    @RequiresApi
    public static class Api30Impl {
    }

    @RequiresApi
    public static class Api34Impl {
    }

    public static class CancelTask implements Task {
        @Override // androidx.core.app.NotificationManagerCompat.Task
        public final void a(INotificationSideChannel iNotificationSideChannel) {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface InterruptionFilter {
    }

    public static class NotificationWithIdAndTag {
    }

    public static class NotifyTask implements Task {

        /* renamed from: a, reason: collision with root package name */
        public final String f2693a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2694b;

        /* renamed from: c, reason: collision with root package name */
        public final Notification f2695c;

        public NotifyTask(String str, int i2, Notification notification) {
            this.f2693a = str;
            this.f2694b = i2;
            this.f2695c = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public final void a(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.wb(this.f2693a, this.f2694b, null, this.f2695c);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[packageName:");
            sb.append(this.f2693a);
            sb.append(", id:");
            return b.o(sb, this.f2694b, ", tag:null]");
        }
    }

    public static class ServiceConnectedEvent {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f2696a;

        /* renamed from: b, reason: collision with root package name */
        public final IBinder f2697b;

        public ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f2696a = componentName;
            this.f2697b = iBinder;
        }
    }

    public static class SideChannelManager implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final Context f2698a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f2699b;

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f2700c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        public HashSet f2701d = new HashSet();

        public static class ListenerRecord {

            /* renamed from: a, reason: collision with root package name */
            public final ComponentName f2702a;

            /* renamed from: c, reason: collision with root package name */
            public INotificationSideChannel f2704c;

            /* renamed from: b, reason: collision with root package name */
            public boolean f2703b = false;

            /* renamed from: d, reason: collision with root package name */
            public final ArrayDeque f2705d = new ArrayDeque();

            /* renamed from: e, reason: collision with root package name */
            public int f2706e = 0;

            public ListenerRecord(ComponentName componentName) {
                this.f2702a = componentName;
            }
        }

        public SideChannelManager(Context context) {
            this.f2698a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            handlerThread.start();
            this.f2699b = new Handler(handlerThread.getLooper(), this);
        }

        public final void a(ListenerRecord listenerRecord) {
            boolean z;
            ArrayDeque arrayDeque;
            boolean zIsLoggable = Log.isLoggable("NotifManCompat", 3);
            ComponentName componentName = listenerRecord.f2702a;
            if (zIsLoggable) {
                Log.d("NotifManCompat", "Processing component " + componentName + ", " + listenerRecord.f2705d.size() + " queued tasks");
            }
            if (listenerRecord.f2705d.isEmpty()) {
                return;
            }
            if (listenerRecord.f2703b) {
                z = true;
            } else {
                Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
                Context context = this.f2698a;
                boolean zBindService = context.bindService(component, this, 33);
                listenerRecord.f2703b = zBindService;
                if (zBindService) {
                    listenerRecord.f2706e = 0;
                } else {
                    Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                    context.unbindService(this);
                }
                z = listenerRecord.f2703b;
            }
            if (!z || listenerRecord.f2704c == null) {
                b(listenerRecord);
                return;
            }
            while (true) {
                arrayDeque = listenerRecord.f2705d;
                Task task = (Task) arrayDeque.peek();
                if (task == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + task);
                    }
                    task.a(listenerRecord.f2704c);
                    arrayDeque.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + componentName);
                    }
                } catch (RemoteException e2) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e2);
                }
            }
            if (arrayDeque.isEmpty()) {
                return;
            }
            b(listenerRecord);
        }

        public final void b(ListenerRecord listenerRecord) {
            Handler handler = this.f2699b;
            ComponentName componentName = listenerRecord.f2702a;
            if (handler.hasMessages(3, componentName)) {
                return;
            }
            int i2 = listenerRecord.f2706e;
            int i3 = i2 + 1;
            listenerRecord.f2706e = i3;
            if (i3 <= 6) {
                int i4 = (1 << i2) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i4 + " ms");
                }
                handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i4);
                return;
            }
            StringBuilder sb = new StringBuilder("Giving up on delivering ");
            ArrayDeque arrayDeque = listenerRecord.f2705d;
            sb.append(arrayDeque.size());
            sb.append(" tasks to ");
            sb.append(componentName);
            sb.append(" after ");
            sb.append(listenerRecord.f2706e);
            sb.append(" retries");
            Log.w("NotifManCompat", sb.toString());
            arrayDeque.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            HashSet hashSet;
            int i2 = message.what;
            if (i2 == 0) {
                Task task = (Task) message.obj;
                Context context = this.f2698a;
                Object obj = NotificationManagerCompat.f2686c;
                String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
                synchronized (NotificationManagerCompat.f2686c) {
                    if (string != null) {
                        try {
                            if (!string.equals(NotificationManagerCompat.f2687d)) {
                                String[] strArrSplit = string.split(":", -1);
                                HashSet hashSet2 = new HashSet(strArrSplit.length);
                                for (String str : strArrSplit) {
                                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                                    if (componentNameUnflattenFromString != null) {
                                        hashSet2.add(componentNameUnflattenFromString.getPackageName());
                                    }
                                }
                                NotificationManagerCompat.f2688e = hashSet2;
                                NotificationManagerCompat.f2687d = string;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    hashSet = NotificationManagerCompat.f2688e;
                }
                if (!hashSet.equals(this.f2701d)) {
                    this.f2701d = hashSet;
                    List<ResolveInfo> listQueryIntentServices = this.f2698a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                    HashSet hashSet3 = new HashSet();
                    for (ResolveInfo resolveInfo : listQueryIntentServices) {
                        if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                            ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                            if (resolveInfo.serviceInfo.permission != null) {
                                Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                            } else {
                                hashSet3.add(componentName);
                            }
                        }
                    }
                    Iterator it = hashSet3.iterator();
                    while (it.hasNext()) {
                        ComponentName componentName2 = (ComponentName) it.next();
                        if (!this.f2700c.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                            }
                            this.f2700c.put(componentName2, new ListenerRecord(componentName2));
                        }
                    }
                    Iterator it2 = this.f2700c.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry = (Map.Entry) it2.next();
                        if (!hashSet3.contains(entry.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                            }
                            ListenerRecord listenerRecord = (ListenerRecord) entry.getValue();
                            if (listenerRecord.f2703b) {
                                this.f2698a.unbindService(this);
                                listenerRecord.f2703b = false;
                            }
                            listenerRecord.f2704c = null;
                            it2.remove();
                        }
                    }
                }
                for (ListenerRecord listenerRecord2 : this.f2700c.values()) {
                    listenerRecord2.f2705d.add(task);
                    a(listenerRecord2);
                }
            } else if (i2 == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                ComponentName componentName3 = serviceConnectedEvent.f2696a;
                IBinder iBinder = serviceConnectedEvent.f2697b;
                ListenerRecord listenerRecord3 = (ListenerRecord) this.f2700c.get(componentName3);
                if (listenerRecord3 != null) {
                    listenerRecord3.f2704c = INotificationSideChannel.Stub.g(iBinder);
                    listenerRecord3.f2706e = 0;
                    a(listenerRecord3);
                    return true;
                }
            } else if (i2 == 2) {
                ListenerRecord listenerRecord4 = (ListenerRecord) this.f2700c.get((ComponentName) message.obj);
                if (listenerRecord4 != null) {
                    if (listenerRecord4.f2703b) {
                        this.f2698a.unbindService(this);
                        listenerRecord4.f2703b = false;
                    }
                    listenerRecord4.f2704c = null;
                    return true;
                }
            } else {
                if (i2 != 3) {
                    return false;
                }
                ListenerRecord listenerRecord5 = (ListenerRecord) this.f2700c.get((ComponentName) message.obj);
                if (listenerRecord5 != null) {
                    a(listenerRecord5);
                    return true;
                }
            }
            return true;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f2699b.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f2699b.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface Task {
        void a(INotificationSideChannel iNotificationSideChannel);
    }

    public NotificationManagerCompat(Context context) {
        this.f2691a = context;
        this.f2692b = (NotificationManager) context.getSystemService("notification");
    }

    public static NotificationManagerCompat c(Context context) {
        return new NotificationManagerCompat(context);
    }

    public final boolean a() {
        return this.f2692b.areNotificationsEnabled();
    }

    public final void b(int i2) {
        this.f2692b.cancel(null, i2);
    }

    public final void d(int i2, Notification notification) {
        Bundle bundle = notification.extras;
        NotificationManager notificationManager = this.f2692b;
        if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
            notificationManager.notify(null, i2, notification);
            return;
        }
        NotifyTask notifyTask = new NotifyTask(this.f2691a.getPackageName(), i2, notification);
        synchronized (f2689f) {
            try {
                if (f2690g == null) {
                    f2690g = new SideChannelManager(this.f2691a.getApplicationContext());
                }
                f2690g.f2699b.obtainMessage(0, notifyTask).sendToTarget();
            } catch (Throwable th) {
                throw th;
            }
        }
        notificationManager.cancel(null, i2);
    }
}
