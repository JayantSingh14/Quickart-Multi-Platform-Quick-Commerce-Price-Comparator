package com.google.ads.interactivemedia.v3.internal;

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
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class zzio implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final Handler zza = new Handler(Looper.getMainLooper());
    private final Context zzb;
    private Application zzc;

    @Nullable
    private final PowerManager zzd;

    @Nullable
    private final KeyguardManager zze;
    private BroadcastReceiver zzf;
    private final zzia zzg;
    private WeakReference zzh;

    @Nullable
    private WeakReference zzi;
    private zzhw zzj;
    private byte zzk = -1;
    private int zzl = -1;
    private long zzm = -3;

    public zzio(Context context, zzia zziaVar) {
        Context applicationContext = context.getApplicationContext();
        this.zzb = applicationContext;
        this.zzg = zziaVar;
        this.zzd = (PowerManager) applicationContext.getSystemService("power");
        this.zze = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.zzc = application;
            this.zzj = new zzhw(application, this);
        }
        zzd(null);
    }

    private final void zze(Activity activity, int i2) {
        Window window;
        if (this.zzi == null || (window = activity.getWindow()) == null) {
            return;
        }
        View viewPeekDecorView = window.peekDecorView();
        View viewZzb = zzb();
        if (viewZzb == null || viewPeekDecorView == null || viewZzb.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.zzl = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006a, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf() {
        /*
            r10 = this;
            r0 = 1
            java.lang.ref.WeakReference r1 = r10.zzi
            if (r1 != 0) goto L7
            goto Lbe
        L7:
            android.view.View r1 = r10.zzb()
            r2 = -1
            r3 = -3
            if (r1 != 0) goto L15
            r10.zzm = r3
            r10.zzk = r2
            return
        L15:
            int r5 = r1.getVisibility()
            r6 = 0
            if (r5 == 0) goto L1e
            r5 = r0
            goto L1f
        L1e:
            r5 = r6
        L1f:
            boolean r7 = r1.isShown()
            if (r7 != 0) goto L27
            r5 = r5 | 2
        L27:
            android.os.PowerManager r7 = r10.zzd
            if (r7 == 0) goto L33
            boolean r7 = r7.isScreenOn()
            if (r7 != 0) goto L33
            r5 = r5 | 4
        L33:
            com.google.ads.interactivemedia.v3.internal.zzia r7 = r10.zzg
            boolean r7 = r7.zza()
            if (r7 != 0) goto L84
            android.app.KeyguardManager r7 = r10.zze
            if (r7 == 0) goto L82
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L82
            int r7 = com.google.ads.interactivemedia.v3.internal.zzik.zza
            android.view.View r7 = r1.getRootView()
            if (r7 != 0) goto L4e
            r7 = r1
        L4e:
            android.content.Context r7 = r7.getContext()
        L52:
            boolean r8 = r7 instanceof android.content.ContextWrapper
            r9 = 0
            if (r8 == 0) goto L6a
            r8 = 10
            if (r6 >= r8) goto L6a
            boolean r8 = r7 instanceof android.app.Activity
            if (r8 == 0) goto L62
            android.app.Activity r7 = (android.app.Activity) r7
            goto L6b
        L62:
            android.content.ContextWrapper r7 = (android.content.ContextWrapper) r7
            android.content.Context r7 = r7.getBaseContext()
            int r6 = r6 + r0
            goto L52
        L6a:
            r7 = r9
        L6b:
            if (r7 != 0) goto L6e
            goto L82
        L6e:
            android.view.Window r0 = r7.getWindow()
            if (r0 != 0) goto L75
            goto L79
        L75:
            android.view.WindowManager$LayoutParams r9 = r0.getAttributes()
        L79:
            if (r9 == 0) goto L82
            int r0 = r9.flags
            r6 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r6
            if (r0 != 0) goto L84
        L82:
            r5 = r5 | 8
        L84:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            boolean r0 = r1.getGlobalVisibleRect(r0)
            if (r0 != 0) goto L91
            r5 = r5 | 16
        L91:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            boolean r0 = r1.getLocalVisibleRect(r0)
            if (r0 != 0) goto L9e
            r5 = r5 | 32
        L9e:
            int r0 = r1.getWindowVisibility()
            int r1 = r10.zzl
            if (r1 == r2) goto La7
            r0 = r1
        La7:
            if (r0 == 0) goto Lab
            r5 = r5 | 64
        Lab:
            byte r0 = r10.zzk
            if (r0 == r5) goto Lbe
            byte r0 = (byte) r5
            r10.zzk = r0
            if (r5 != 0) goto Lb9
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto Lbc
        Lb9:
            long r0 = (long) r5
            long r0 = r3 - r0
        Lbc:
            r10.zzm = r0
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzio.zzf():void");
    }

    private final void zzg() {
        zza.post(new zzim(this));
    }

    private final void zzh(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzh = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzf == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            zzin zzinVar = new zzin(this);
            this.zzf = zzinVar;
            this.zzb.registerReceiver(zzinVar, intentFilter);
        }
        Application application = this.zzc;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception unused) {
            }
        }
    }

    private final void zzi(View view) {
        try {
            WeakReference weakReference = this.zzh;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzh = null;
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
        BroadcastReceiver broadcastReceiver = this.zzf;
        if (broadcastReceiver != null) {
            try {
                this.zzb.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.zzf = null;
        }
        Application application = this.zzc;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception unused4) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zze(activity, 0);
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zze(activity, 4);
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zze(activity, 0);
        zzf();
        zzg();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zze(activity, 0);
        zzf();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzf();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzf();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzf();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzl = -1;
        zzh(view);
        zzf();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzl = -1;
        zzf();
        zzg();
        zzi(view);
    }

    public final long zza() {
        if (this.zzm <= -2 && zzb() == null) {
            this.zzm = -3L;
        }
        return this.zzm;
    }

    @Nullable
    public final View zzb() {
        WeakReference weakReference = this.zzi;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public final void zzd(View view) {
        long j2;
        View viewZzb = zzb();
        if (viewZzb != null) {
            viewZzb.removeOnAttachStateChangeListener(this);
            zzi(viewZzb);
        }
        this.zzi = new WeakReference(view);
        if (view != null) {
            if (view.getWindowToken() != null || view.getWindowVisibility() != 8) {
                zzh(view);
            }
            view.addOnAttachStateChangeListener(this);
            j2 = -2;
        } else {
            j2 = -3;
        }
        this.zzm = j2;
    }
}
