package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzdof extends zzbkh implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdpj {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f28074b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f28075c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f28076d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f28077e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public zzdnh f28078f;

    /* renamed from: g, reason: collision with root package name */
    public final zzbcm f28079g;

    public zzdof(View view, HashMap map, HashMap map2) {
        ViewTreeObserver viewTreeObserver;
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzceb zzcebVar = com.google.android.gms.ads.internal.zzt.C.B;
        zzceb.a(view, this);
        zzced zzcedVar = new zzced(view, this);
        View view2 = (View) zzcedVar.f26001a.get();
        ViewTreeObserver viewTreeObserver2 = null;
        if (view2 != null && (viewTreeObserver = view2.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver2 = viewTreeObserver;
        }
        if (viewTreeObserver2 != null) {
            zzcedVar.a(viewTreeObserver2);
        }
        this.f28074b = new WeakReference(view);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            View view3 = (View) entry.getValue();
            if (view3 != null) {
                this.f28075c.put(str, new WeakReference(view3));
                if (!"1098".equals(str) && !"3011".equals(str)) {
                    view3.setOnTouchListener(this);
                    view3.setClickable(true);
                    view3.setOnClickListener(this);
                }
            }
        }
        this.f28077e.putAll(this.f28075c);
        for (Map.Entry entry2 : map2.entrySet()) {
            View view4 = (View) entry2.getValue();
            if (view4 != null) {
                this.f28076d.put((String) entry2.getKey(), new WeakReference(view4));
                view4.setOnTouchListener(this);
                view4.setClickable(false);
            }
        }
        this.f28077e.putAll(this.f28076d);
        this.f28079g = new zzbcm(view.getContext(), view);
    }

    @Override // com.google.android.gms.internal.ads.zzbki
    public final synchronized void H0(IObjectWrapper iObjectWrapper) {
        try {
            if (this.f28078f != null) {
                Object objZ0 = ObjectWrapper.z0(iObjectWrapper);
                if (!(objZ0 instanceof View)) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
                }
                zzdnh zzdnhVar = this.f28078f;
                View view = (View) objZ0;
                synchronized (zzdnhVar) {
                    zzdnhVar.n.X(view);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbki
    public final synchronized void N(IObjectWrapper iObjectWrapper) {
        Object objZ0 = ObjectWrapper.z0(iObjectWrapper);
        if (!(objZ0 instanceof zzdnh)) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzdnh zzdnhVar = this.f28078f;
        if (zzdnhVar != null) {
            zzdnhVar.r(this);
        }
        zzdnh zzdnhVar2 = (zzdnh) objZ0;
        if (!zzdnhVar2.p.b()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
        } else {
            this.f28078f = zzdnhVar2;
            zzdnhVar2.q(this);
            this.f28078f.f(Z8());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final View Z8() {
        return (View) this.f28074b.get();
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzdnh zzdnhVar = this.f28078f;
        if (zzdnhVar != null) {
            zzdnhVar.s(view, Z8(), zzj(), zzk(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzdnh zzdnhVar = this.f28078f;
        if (zzdnhVar != null) {
            zzdnhVar.t(Z8(), zzj(), zzk(), zzdnh.d(Z8()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzdnh zzdnhVar = this.f28078f;
        if (zzdnhVar != null) {
            zzdnhVar.t(Z8(), zzj(), zzk(), zzdnh.d(Z8()));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdnh zzdnhVar = this.f28078f;
        if (zzdnhVar != null) {
            View viewZ8 = Z8();
            synchronized (zzdnhVar) {
                zzdnhVar.n.m0(viewZ8, motionEvent);
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final FrameLayout p6() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized void y5(View view, String str) {
        this.f28077e.put(str, new WeakReference(view));
        if (!"1098".equals(str) && !"3011".equals(str)) {
            this.f28075c.put(str, new WeakReference(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized View z0(String str) {
        WeakReference weakReference = (WeakReference) this.f28077e.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbki
    public final synchronized void zzc() {
        zzdnh zzdnhVar = this.f28078f;
        if (zzdnhVar != null) {
            zzdnhVar.r(this);
            this.f28078f = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final zzbcm zzh() {
        return this.f28079g;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized Map zzj() {
        return this.f28077e;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized Map zzk() {
        return this.f28075c;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized Map zzl() {
        return this.f28076d;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized String zzn() {
        return "1007";
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized IObjectWrapper zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized JSONObject zzp() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized JSONObject zzq() {
        JSONObject jSONObjectB0;
        zzdnh zzdnhVar = this.f28078f;
        if (zzdnhVar == null) {
            return null;
        }
        View viewZ8 = Z8();
        Map mapZzj = zzj();
        Map mapZzk = zzk();
        synchronized (zzdnhVar) {
            jSONObjectB0 = zzdnhVar.n.b0(viewZ8, mapZzj, mapZzk, zzdnhVar.l());
        }
        return jSONObjectB0;
    }
}
