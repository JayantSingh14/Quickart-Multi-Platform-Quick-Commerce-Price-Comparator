package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.internal.ads.zzceb;

/* loaded from: classes4.dex */
public final class zzci {

    /* renamed from: a, reason: collision with root package name */
    public final View f21570a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f21571b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21572c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21573d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21574e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f21575f;

    public zzci(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f21571b = activity;
        this.f21570a = view;
        this.f21575f = onGlobalLayoutListener;
    }

    public final void a() {
        View decorView;
        if (this.f21572c) {
            return;
        }
        Activity activity = this.f21571b;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f21575f;
        if (activity != null) {
            Window window = activity.getWindow();
            ViewTreeObserver viewTreeObserver = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
        zzceb zzcebVar = com.google.android.gms.ads.internal.zzt.C.B;
        zzceb.a(this.f21570a, onGlobalLayoutListener);
        this.f21572c = true;
    }
}
