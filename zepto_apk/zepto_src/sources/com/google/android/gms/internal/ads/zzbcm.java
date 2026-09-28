package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzbcm implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    public static final long o = ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.I1)).longValue();

    /* renamed from: a, reason: collision with root package name */
    public final Context f24710a;

    /* renamed from: b, reason: collision with root package name */
    public final Application f24711b;

    /* renamed from: c, reason: collision with root package name */
    public final PowerManager f24712c;

    /* renamed from: d, reason: collision with root package name */
    public final KeyguardManager f24713d;

    /* renamed from: e, reason: collision with root package name */
    public BroadcastReceiver f24714e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f24715f;

    /* renamed from: g, reason: collision with root package name */
    public final WeakReference f24716g;

    /* renamed from: h, reason: collision with root package name */
    public final zzbcy f24717h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzbu f24718i = new com.google.android.gms.ads.internal.util.zzbu(o);

    /* renamed from: j, reason: collision with root package name */
    public boolean f24719j = false;

    /* renamed from: k, reason: collision with root package name */
    public int f24720k = -1;

    /* renamed from: l, reason: collision with root package name */
    public final HashSet f24721l = new HashSet();

    /* renamed from: m, reason: collision with root package name */
    public final DisplayMetrics f24722m;
    public final Rect n;

    public zzbcm(Context context, View view) {
        Context applicationContext = context.getApplicationContext();
        this.f24710a = applicationContext;
        WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
        this.f24712c = (PowerManager) applicationContext.getSystemService("power");
        this.f24713d = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.f24711b = application;
            this.f24717h = new zzbcy(application, this);
        }
        this.f24722m = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.n = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference weakReference = this.f24716g;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            f(view2);
        }
        this.f24716g = new WeakReference(view);
        if (view != null) {
            if (view.isAttachedToWindow()) {
                e(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public final Rect a(Rect rect) {
        float f2 = rect.left;
        float f3 = this.f24722m.density;
        return new Rect((int) (f2 / f3), (int) (rect.top / f3), (int) (rect.right / f3), (int) (rect.bottom / f3));
    }

    public final void b() {
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbcl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f24709a.d(3);
            }
        });
    }

    public final void c(Activity activity, int i2) {
        Window window;
        WeakReference weakReference = this.f24716g;
        if (weakReference == null || (window = activity.getWindow()) == null) {
            return;
        }
        View viewPeekDecorView = window.peekDecorView();
        View view = (View) weakReference.get();
        if (view == null || viewPeekDecorView == null || view.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.f24720k = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0137  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v34, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(int r30) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcm.d(int):void");
    }

    public final void e(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f24715f = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f24714e == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            zzbci zzbciVar = new zzbci(this);
            this.f24714e = zzbciVar;
            Context context = this.f24710a;
            com.google.android.gms.ads.internal.util.zzcg zzcgVar = com.google.android.gms.ads.internal.zzt.C.z;
            synchronized (zzcgVar) {
                if (zzcgVar.f21565d) {
                    zzcgVar.f21563b.put(zzbciVar, intentFilter);
                } else {
                    zzbgk.a(context);
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.fc)).booleanValue() || Build.VERSION.SDK_INT < 33) {
                        context.registerReceiver(zzbciVar, intentFilter);
                    } else {
                        context.registerReceiver(zzbciVar, intentFilter, 4);
                    }
                }
            }
        }
        Application application = this.f24711b;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.f24717h);
            } catch (Exception e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Error registering activity lifecycle callbacks.", e2);
            }
        }
    }

    public final void f(View view) {
        try {
            WeakReference weakReference = this.f24715f;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f24715f = null;
            }
        } catch (Exception e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error while unregistering listeners from the last ViewTreeObserver.", e2);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error while unregistering listeners from the ViewTreeObserver.", e3);
        }
        BroadcastReceiver broadcastReceiver = this.f24714e;
        if (broadcastReceiver != null) {
            try {
                com.google.android.gms.ads.internal.zzt.C.z.b(this.f24710a, broadcastReceiver);
            } catch (IllegalStateException e4) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Failed trying to unregister the receiver", e4);
            } catch (Exception e5) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("ActiveViewUnit.stopScreenStatusMonitoring", e5);
            }
            this.f24714e = null;
        }
        Application application = this.f24711b;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.f24717h);
            } catch (Exception e6) {
                int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Error registering activity lifecycle callbacks.", e6);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        c(activity, 0);
        d(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        d(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c(activity, 4);
        d(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        c(activity, 0);
        d(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        d(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        c(activity, 0);
        d(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        d(3);
        b();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        d(2);
        b();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        d(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f24720k = -1;
        e(view);
        d(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f24720k = -1;
        d(3);
        b();
        f(view);
    }
}
