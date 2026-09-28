package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzdrr extends zzbqa implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbji {

    /* renamed from: a, reason: collision with root package name */
    public View f28368a;

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzed f28369b;

    /* renamed from: c, reason: collision with root package name */
    public zzdnh f28370c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f28371d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f28372e;

    public final void Xb(IObjectWrapper iObjectWrapper, zzbqe zzbqeVar) {
        ViewTreeObserver viewTreeObserver;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.f28371d) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Instream ad can not be shown after destroy().");
            try {
                zzbqeVar.zzf(2);
                return;
            } catch (RemoteException e2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
                return;
            }
        }
        View view = this.f28368a;
        if (view == null || this.f28369b == null) {
            String str = view == null ? "can not get video view." : "can not get video controller.";
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Instream internal error: ".concat(str));
            try {
                zzbqeVar.zzf(0);
                return;
            } catch (RemoteException e3) {
                int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                return;
            }
        }
        if (this.f28372e) {
            int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Instream ad should not be used again.");
            try {
                zzbqeVar.zzf(1);
                return;
            } catch (RemoteException e4) {
                int i7 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e4);
                return;
            }
        }
        this.f28372e = true;
        Yb();
        ((ViewGroup) ObjectWrapper.z0(iObjectWrapper)).addView(this.f28368a, new ViewGroup.LayoutParams(-1, -1));
        zzceb zzcebVar = com.google.android.gms.ads.internal.zzt.C.B;
        zzceb.a(this.f28368a, this);
        zzced zzcedVar = new zzced(this.f28368a, this);
        View view2 = (View) zzcedVar.f26001a.get();
        ViewTreeObserver viewTreeObserver2 = null;
        if (view2 != null && (viewTreeObserver = view2.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver2 = viewTreeObserver;
        }
        if (viewTreeObserver2 != null) {
            zzcedVar.a(viewTreeObserver2);
        }
        Zb();
        try {
            zzbqeVar.zze();
        } catch (RemoteException e5) {
            int i8 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e5);
        }
    }

    public final void Yb() {
        View view = this.f28368a;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f28368a);
        }
    }

    public final void Zb() {
        View view;
        zzdnh zzdnhVar = this.f28370c;
        if (zzdnhVar == null || (view = this.f28368a) == null) {
            return;
        }
        Map map = Collections.EMPTY_MAP;
        zzdnhVar.t(view, map, map, zzdnh.d(view));
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Zb();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        Zb();
    }
}
