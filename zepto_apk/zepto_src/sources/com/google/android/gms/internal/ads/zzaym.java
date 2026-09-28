package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public abstract class zzaym implements zzayl {
    public static volatile zzazt u;

    /* renamed from: a, reason: collision with root package name */
    public MotionEvent f24494a;

    /* renamed from: j, reason: collision with root package name */
    public double f24503j;

    /* renamed from: k, reason: collision with root package name */
    public double f24504k;

    /* renamed from: l, reason: collision with root package name */
    public double f24505l;

    /* renamed from: m, reason: collision with root package name */
    public float f24506m;
    public float n;
    public float o;
    public float p;
    public final DisplayMetrics s;
    public final zzazl t;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList f24495b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    public long f24496c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f24497d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f24498e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f24499f = 0;

    /* renamed from: g, reason: collision with root package name */
    public long f24500g = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f24501h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f24502i = 0;
    public boolean q = false;
    public boolean r = false;

    public zzaym(Context context) {
        try {
            zzaxp.a();
            this.s = context.getResources().getDisplayMetrics();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q3)).booleanValue()) {
                this.t = new zzazl();
            }
        } catch (Throwable unused) {
        }
    }

    public abstract zzavs a(Context context);

    @Override // com.google.android.gms.internal.ads.zzayl
    public final synchronized void b(int i2, int i3, int i4) {
        try {
            if (this.f24494a != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Z2)).booleanValue()) {
                    o();
                } else {
                    this.f24494a.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.s;
            if (displayMetrics != null) {
                float f2 = displayMetrics.density;
                this.f24494a = MotionEvent.obtain(0L, i4, 1, i2 * f2, i3 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.f24494a = null;
            }
            this.r = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String c(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String d(Context context) {
        char[] cArr = zzazw.f24590a;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return p(context, null, 1, null, null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String e(Context context, String str, View view) {
        return p(context, str, 3, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final synchronized void f(MotionEvent motionEvent) {
        Long l2;
        try {
            if (this.q) {
                o();
                this.q = false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f24503j = 0.0d;
                this.f24504k = motionEvent.getRawX();
                this.f24505l = motionEvent.getRawY();
            } else if (action == 1 || action == 2) {
                double rawX = motionEvent.getRawX();
                double rawY = motionEvent.getRawY();
                double d2 = rawX - this.f24504k;
                double d3 = rawY - this.f24505l;
                this.f24503j += Math.sqrt((d3 * d3) + (d2 * d2));
                this.f24504k = rawX;
                this.f24505l = rawY;
            }
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                try {
                    if (action2 == 1) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        this.f24494a = motionEventObtain;
                        LinkedList linkedList = this.f24495b;
                        linkedList.add(motionEventObtain);
                        if (linkedList.size() > 6) {
                            ((MotionEvent) linkedList.remove()).recycle();
                        }
                        this.f24498e++;
                        this.f24500g = n(new Throwable().getStackTrace());
                    } else if (action2 == 2) {
                        this.f24497d += motionEvent.getHistorySize() + 1;
                        zzazv zzazvVarM = m(motionEvent);
                        Long l3 = zzazvVarM.f24582d;
                        if (l3 != null && zzazvVarM.f24585g != null) {
                            this.f24501h = l3.longValue() + zzazvVarM.f24585g.longValue() + this.f24501h;
                        }
                        if (this.s != null && (l2 = zzazvVarM.f24583e) != null && zzazvVarM.f24586h != null) {
                            this.f24502i = l2.longValue() + zzazvVarM.f24586h.longValue() + this.f24502i;
                        }
                    } else if (action2 == 3) {
                        this.f24499f++;
                    }
                } catch (zzazj unused) {
                }
            } else {
                this.f24506m = motionEvent.getX();
                this.n = motionEvent.getY();
                this.o = motionEvent.getRawX();
                this.p = motionEvent.getRawY();
                this.f24496c++;
            }
            this.r = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String g(Context context, String str, View view, Activity activity) {
        return p(context, str, 3, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void h(StackTraceElement[] stackTraceElementArr) {
        zzazl zzazlVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q3)).booleanValue() || (zzazlVar = this.t) == null) {
            return;
        }
        zzazlVar.f24540a = new ArrayList(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public void i(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final String j(Context context, View view, Activity activity) {
        return p(context, null, 2, view, activity);
    }

    public abstract zzavs k(Context context, View view, Activity activity);

    public abstract zzavs l(Context context, View view, Activity activity);

    public abstract zzazv m(MotionEvent motionEvent);

    public abstract long n(StackTraceElement[] stackTraceElementArr);

    public final void o() {
        this.f24500g = 0L;
        this.f24496c = 0L;
        this.f24497d = 0L;
        this.f24498e = 0L;
        this.f24499f = 0L;
        this.f24501h = 0L;
        this.f24502i = 0L;
        LinkedList linkedList = this.f24495b;
        if (linkedList.isEmpty()) {
            MotionEvent motionEvent = this.f24494a;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            linkedList.clear();
        }
        this.f24494a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String p(android.content.Context r20, java.lang.String r21, int r22, android.view.View r23, android.app.Activity r24) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaym.p(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity):java.lang.String");
    }
}
