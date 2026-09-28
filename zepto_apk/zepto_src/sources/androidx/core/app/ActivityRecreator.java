package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestrictTo
/* loaded from: classes3.dex */
final class ActivityRecreator {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f2592a;

    /* renamed from: b, reason: collision with root package name */
    public static final Field f2593b;

    /* renamed from: c, reason: collision with root package name */
    public static final Field f2594c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f2595d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f2596e;

    /* renamed from: f, reason: collision with root package name */
    public static final Method f2597f;

    /* renamed from: g, reason: collision with root package name */
    public static final Handler f2598g = new Handler(Looper.getMainLooper());

    public static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public Object f2605a;

        /* renamed from: b, reason: collision with root package name */
        public Activity f2606b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2607c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2608d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2609e = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f2610f = false;

        public LifecycleCheckCallbacks(Activity activity) {
            this.f2606b = activity;
            this.f2607c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (this.f2606b == activity) {
                this.f2606b = null;
                this.f2609e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            if (!this.f2609e || this.f2610f || this.f2608d) {
                return;
            }
            Object obj = this.f2605a;
            try {
                final Object obj2 = ActivityRecreator.f2594c.get(activity);
                if (obj2 == obj && activity.hashCode() == this.f2607c) {
                    final Object obj3 = ActivityRecreator.f2593b.get(activity);
                    ActivityRecreator.f2598g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.ActivityRecreator.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                Method method = ActivityRecreator.f2595d;
                                Object obj4 = obj2;
                                Object obj5 = obj3;
                                if (method != null) {
                                    method.invoke(obj5, obj4, Boolean.FALSE, "AppCompat recreation");
                                } else {
                                    ActivityRecreator.f2596e.invoke(obj5, obj4, Boolean.FALSE);
                                }
                            } catch (RuntimeException e2) {
                                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                                    throw e2;
                                }
                            } catch (Throwable th) {
                                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                            }
                        }
                    });
                    this.f2610f = true;
                    this.f2605a = null;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while fetching field values", th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (this.f2606b == activity) {
                this.f2608d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> cls;
        Field declaredField;
        Field declaredField2;
        Method declaredMethod;
        Method declaredMethod2;
        Method method = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        f2592a = cls;
        try {
            declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
        } catch (Throwable unused2) {
            declaredField = null;
        }
        f2593b = declaredField;
        try {
            declaredField2 = Activity.class.getDeclaredField("mToken");
            declaredField2.setAccessible(true);
        } catch (Throwable unused3) {
            declaredField2 = null;
        }
        f2594c = declaredField2;
        Class cls2 = f2592a;
        Class cls3 = Boolean.TYPE;
        if (cls2 == null) {
            declaredMethod = null;
        } else {
            try {
                declaredMethod = cls2.getDeclaredMethod("performStopActivity", IBinder.class, cls3, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
            }
        }
        f2595d = declaredMethod;
        Class cls4 = f2592a;
        if (cls4 == null) {
            declaredMethod2 = null;
        } else {
            try {
                declaredMethod2 = cls4.getDeclaredMethod("performStopActivity", IBinder.class, cls3);
                declaredMethod2.setAccessible(true);
            } catch (Throwable unused5) {
            }
        }
        f2596e = declaredMethod2;
        Class cls5 = f2592a;
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 == 26 || i2 == 27) && cls5 != null) {
            try {
                Class cls6 = Integer.TYPE;
                Class cls7 = Boolean.TYPE;
                Method declaredMethod3 = cls5.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, cls6, cls7, Configuration.class, Configuration.class, cls7, cls7);
                declaredMethod3.setAccessible(true);
                method = declaredMethod3;
            } catch (Throwable unused6) {
            }
        }
        f2597f = method;
    }
}
