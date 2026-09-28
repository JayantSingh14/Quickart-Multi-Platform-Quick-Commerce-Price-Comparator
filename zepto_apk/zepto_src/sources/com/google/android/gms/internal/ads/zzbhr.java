package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzbhr {

    /* renamed from: a, reason: collision with root package name */
    public MotionEvent f25091a = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);

    /* renamed from: b, reason: collision with root package name */
    public MotionEvent f25092b = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f25093c;

    public zzbhr(ScheduledExecutorService scheduledExecutorService) {
        this.f25093c = scheduledExecutorService;
    }
}
