package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class zzeb implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {

    /* renamed from: m, reason: collision with root package name */
    public static final Handler f37668m = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public final Context f37669a;

    /* renamed from: b, reason: collision with root package name */
    public final Application f37670b;

    /* renamed from: c, reason: collision with root package name */
    public final PowerManager f37671c;

    /* renamed from: d, reason: collision with root package name */
    public final KeyguardManager f37672d;

    /* renamed from: e, reason: collision with root package name */
    public BroadcastReceiver f37673e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdo f37674f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference f37675g;

    /* renamed from: h, reason: collision with root package name */
    public WeakReference f37676h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdl f37677i;

    /* renamed from: j, reason: collision with root package name */
    public byte f37678j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f37679k = -1;

    /* renamed from: l, reason: collision with root package name */
    public long f37680l = -3;

    public zzeb(Context context, zzdo zzdoVar) {
        Context applicationContext = context.getApplicationContext();
        this.f37669a = applicationContext;
        this.f37674f = zzdoVar;
        this.f37671c = (PowerManager) applicationContext.getSystemService("power");
        this.f37672d = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.f37670b = application;
            this.f37677i = new zzdl(application, this);
        }
        a(null);
    }

    public final void a(View view) {
        long j2;
        WeakReference weakReference = this.f37676h;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            e(view2);
        }
        this.f37676h = new WeakReference(view);
        if (view != null) {
            if (view.getWindowToken() != null || view.getWindowVisibility() != 8) {
                d(view);
            }
            view.addOnAttachStateChangeListener(this);
            j2 = -2;
        } else {
            j2 = -3;
        }
        this.f37680l = j2;
    }

    public final void b(Activity activity, int i2) {
        Window window;
        if (this.f37676h == null || (window = activity.getWindow()) == null) {
            return;
        }
        View viewPeekDecorView = window.peekDecorView();
        WeakReference weakReference = this.f37676h;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null || viewPeekDecorView == null || view.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.f37679k = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r10 = this;
            r0 = 1
            java.lang.ref.WeakReference r1 = r10.f37676h
            if (r1 != 0) goto L7
            goto Lc3
        L7:
            r2 = 0
            if (r1 == 0) goto L11
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            goto L12
        L11:
            r1 = r2
        L12:
            r3 = -1
            r4 = -3
            if (r1 != 0) goto L1c
            r10.f37680l = r4
            r10.f37678j = r3
            return
        L1c:
            int r6 = r1.getVisibility()
            r7 = 0
            if (r6 == 0) goto L25
            r6 = r0
            goto L26
        L25:
            r6 = r7
        L26:
            boolean r8 = r1.isShown()
            if (r8 != 0) goto L2e
            r6 = r6 | 2
        L2e:
            android.os.PowerManager r8 = r10.f37671c
            if (r8 == 0) goto L3a
            boolean r8 = r8.isScreenOn()
            if (r8 != 0) goto L3a
            r6 = r6 | 4
        L3a:
            com.google.android.gms.internal.pal.zzdo r8 = r10.f37674f
            boolean r8 = r8.f37625a
            if (r8 != 0) goto L89
            android.app.KeyguardManager r8 = r10.f37672d
            if (r8 == 0) goto L87
            boolean r8 = r8.inKeyguardRestrictedInputMode()
            if (r8 == 0) goto L87
            char[] r8 = com.google.android.gms.internal.pal.zzdx.f37659a
            android.view.View r8 = r1.getRootView()
            if (r8 == 0) goto L53
            goto L54
        L53:
            r8 = r1
        L54:
            android.content.Context r8 = r8.getContext()
        L58:
            boolean r9 = r8 instanceof android.content.ContextWrapper
            if (r9 == 0) goto L6f
            r9 = 10
            if (r7 >= r9) goto L6f
            boolean r9 = r8 instanceof android.app.Activity
            if (r9 == 0) goto L67
            android.app.Activity r8 = (android.app.Activity) r8
            goto L70
        L67:
            android.content.ContextWrapper r8 = (android.content.ContextWrapper) r8
            android.content.Context r8 = r8.getBaseContext()
            int r7 = r7 + r0
            goto L58
        L6f:
            r8 = r2
        L70:
            if (r8 != 0) goto L73
            goto L87
        L73:
            android.view.Window r0 = r8.getWindow()
            if (r0 != 0) goto L7a
            goto L7e
        L7a:
            android.view.WindowManager$LayoutParams r2 = r0.getAttributes()
        L7e:
            if (r2 == 0) goto L87
            int r0 = r2.flags
            r2 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r2
            if (r0 != 0) goto L89
        L87:
            r6 = r6 | 8
        L89:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            boolean r0 = r1.getGlobalVisibleRect(r0)
            if (r0 != 0) goto L96
            r6 = r6 | 16
        L96:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            boolean r0 = r1.getLocalVisibleRect(r0)
            if (r0 != 0) goto La3
            r6 = r6 | 32
        La3:
            int r0 = r1.getWindowVisibility()
            int r1 = r10.f37679k
            if (r1 == r3) goto Lac
            r0 = r1
        Lac:
            if (r0 == 0) goto Lb0
            r6 = r6 | 64
        Lb0:
            byte r0 = r10.f37678j
            if (r0 == r6) goto Lc3
            byte r0 = (byte) r6
            r10.f37678j = r0
            if (r6 != 0) goto Lbe
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto Lc1
        Lbe:
            long r0 = (long) r6
            long r0 = r4 - r0
        Lc1:
            r10.f37680l = r0
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzeb.c():void");
    }

    public final void d(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f37675g = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f37673e == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            zzea zzeaVar = new zzea(this);
            this.f37673e = zzeaVar;
            this.f37669a.registerReceiver(zzeaVar, intentFilter);
        }
        Application application = this.f37670b;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.f37677i);
            } catch (Exception unused) {
            }
        }
    }

    public final void e(View view) {
        try {
            WeakReference weakReference = this.f37675g;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f37675g = null;
            }
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.f37673e;
        if (broadcastReceiver != null) {
            try {
                this.f37669a.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.f37673e = null;
        }
        Application application = this.f37670b;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.f37677i);
            } catch (Exception unused4) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        b(activity, 0);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        b(activity, 4);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        b(activity, 0);
        c();
        f37668m.post(new zzdz(this));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        b(activity, 0);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        c();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        c();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f37679k = -1;
        d(view);
        c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f37679k = -1;
        c();
        f37668m.post(new zzdz(this));
        e(view);
    }
}
