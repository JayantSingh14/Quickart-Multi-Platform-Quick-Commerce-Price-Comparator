package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdoh extends zzbkb implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdpj {
    public static final zzgtd p;

    /* renamed from: b, reason: collision with root package name */
    public final String f28081b;

    /* renamed from: d, reason: collision with root package name */
    public FrameLayout f28083d;

    /* renamed from: e, reason: collision with root package name */
    public FrameLayout f28084e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgyw f28085f;

    /* renamed from: g, reason: collision with root package name */
    public View f28086g;

    /* renamed from: i, reason: collision with root package name */
    public zzdnh f28088i;

    /* renamed from: j, reason: collision with root package name */
    public zzbcm f28089j;

    /* renamed from: l, reason: collision with root package name */
    public zzbjv f28091l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f28092m;
    public GestureDetector o;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f28082c = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    public IObjectWrapper f28090k = null;
    public boolean n = false;

    /* renamed from: h, reason: collision with root package name */
    public final int f28087h = ModuleDescriptor.MODULE_VERSION;

    static {
        zzgvs zzgvsVar = zzgtd.f33183b;
        Object[] objArr = {"2011", "1009", "3010"};
        zzguw.a(3, objArr);
        p = zzgtd.t(3, objArr);
    }

    public zzdoh(FrameLayout frameLayout, FrameLayout frameLayout2) {
        String str;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2 = null;
        this.f28083d = frameLayout;
        this.f28084e = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.f28081b = str;
        zzceb zzcebVar = com.google.android.gms.ads.internal.zzt.C.B;
        zzceb.a(frameLayout, this);
        zzced zzcedVar = new zzced(frameLayout, this);
        View view = (View) zzcedVar.f26001a.get();
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver2 = viewTreeObserver;
        }
        if (viewTreeObserver2 != null) {
            zzcedVar.a(viewTreeObserver2);
        }
        this.f28085f = zzcdo.f25987f;
        this.f28089j = new zzbcm(this.f28083d.getContext(), this.f28083d);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final synchronized void H0(IObjectWrapper iObjectWrapper) {
        if (this.n) {
            return;
        }
        Object objZ0 = ObjectWrapper.z0(iObjectWrapper);
        if (!(objZ0 instanceof zzdnh)) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        zzdnh zzdnhVar = this.f28088i;
        if (zzdnhVar != null) {
            zzdnhVar.r(this);
        }
        synchronized (this) {
            ((zzcdn) this.f28085f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdog
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzdoh zzdohVar = this.f28080a;
                    if (zzdohVar.f28086g == null) {
                        View view = new View(zzdohVar.f28083d.getContext());
                        zzdohVar.f28086g = view;
                        view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
                    }
                    if (zzdohVar.f28083d != zzdohVar.f28086g.getParent()) {
                        zzdohVar.f28083d.addView(zzdohVar.f28086g);
                    }
                }
            });
            zzdnh zzdnhVar2 = (zzdnh) objZ0;
            this.f28088i = zzdnhVar2;
            zzdnhVar2.q(this);
            this.f28088i.f(this.f28083d);
            zzdnh zzdnhVar3 = this.f28088i;
            FrameLayout frameLayout = this.f28084e;
            zzejb zzejbVarK = zzdnhVar3.f28007m.k();
            if (zzdnhVar3.p.c() && zzejbVarK != null && frameLayout != null) {
                com.google.android.gms.ads.internal.zzt.C.x.d(zzejbVarK.f29453a, frameLayout);
            }
            if (this.f28092m) {
                zzdnj zzdnjVar = this.f28088i.F;
                zzbjv zzbjvVar = this.f28091l;
                synchronized (zzdnjVar) {
                    zzdnjVar.f28021a = zzbjvVar;
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.B4)).booleanValue() && !TextUtils.isEmpty(this.f28088i.p.e())) {
                Yb(this.f28088i.p.e());
            }
            Xb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final synchronized void P6(IObjectWrapper iObjectWrapper, String str) {
        y5((View) ObjectWrapper.z0(iObjectWrapper), str);
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final synchronized void Tb(zzbjv zzbjvVar) {
        if (!this.n) {
            this.f28092m = true;
            this.f28091l = zzbjvVar;
            zzdnh zzdnhVar = this.f28088i;
            if (zzdnhVar != null) {
                zzdnj zzdnjVar = zzdnhVar.F;
                synchronized (zzdnjVar) {
                    zzdnjVar.f28021a = zzbjvVar;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final void U2(IObjectWrapper iObjectWrapper) {
        onTouch(this.f28083d, (MotionEvent) ObjectWrapper.z0(iObjectWrapper));
    }

    public final synchronized void Xb() {
        int iC;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Gc)).booleanValue()) {
            zzdnh zzdnhVar = this.f28088i;
            synchronized (zzdnhVar) {
                iC = zzdnhVar.n.c();
            }
            if (iC != 0) {
                this.o = new GestureDetector(this.f28083d.getContext(), new zzdop(this.f28088i, this));
            }
        }
    }

    public final synchronized void Yb(String str) {
        DisplayMetrics displayMetrics;
        try {
            View frameLayout = new FrameLayout(this.f28084e.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Context context = this.f28084e.getContext();
            frameLayout.setClickable(false);
            frameLayout.setFocusable(false);
            if (!TextUtils.isEmpty(str)) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                Resources resources = context.getResources();
                if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                    try {
                        byte[] bArrDecode = Base64.decode(str, 0);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                        bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        bitmapDrawable.setTileModeXY(tileMode, tileMode);
                        frameLayout.setBackground(bitmapDrawable);
                    } catch (IllegalArgumentException e2) {
                        com.google.android.gms.ads.internal.util.client.zzo.g("Encountered invalid base64 watermark.", e2);
                    }
                }
            }
            this.f28084e.addView(frameLayout);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final synchronized void Z(IObjectWrapper iObjectWrapper) {
        zzdnh zzdnhVar = this.f28088i;
        View view = (View) ObjectWrapper.z0(iObjectWrapper);
        synchronized (zzdnhVar) {
            zzdnhVar.n.X(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final /* synthetic */ View Z8() {
        return this.f28083d;
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final synchronized void ha(IObjectWrapper iObjectWrapper) {
        if (this.n) {
            return;
        }
        this.f28090k = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final synchronized IObjectWrapper o(String str) {
        return new ObjectWrapper(z0(str));
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        boolean zH;
        zzdnh zzdnhVar = this.f28088i;
        if (zzdnhVar != null) {
            synchronized (zzdnhVar) {
                zH = zzdnhVar.n.h();
            }
            if (zH) {
                zzdnh zzdnhVar2 = this.f28088i;
                synchronized (zzdnhVar2) {
                    zzdnhVar2.n.B();
                }
                this.f28088i.s(view, this.f28083d, zzj(), zzk(), false);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzdnh zzdnhVar = this.f28088i;
        if (zzdnhVar != null) {
            FrameLayout frameLayout = this.f28083d;
            zzdnhVar.t(frameLayout, zzj(), zzk(), zzdnh.d(frameLayout));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzdnh zzdnhVar = this.f28088i;
        if (zzdnhVar != null) {
            FrameLayout frameLayout = this.f28083d;
            zzdnhVar.t(frameLayout, zzj(), zzk(), zzdnh.d(frameLayout));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        int iC;
        zzdnh zzdnhVar = this.f28088i;
        if (zzdnhVar != null) {
            FrameLayout frameLayout = this.f28083d;
            synchronized (zzdnhVar) {
                zzdnhVar.n.m0(frameLayout, motionEvent);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Gc)).booleanValue() && this.o != null) {
                zzdnh zzdnhVar2 = this.f28088i;
                synchronized (zzdnhVar2) {
                    iC = zzdnhVar2.n.c();
                }
                if (iC != 0) {
                    this.o.onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final FrameLayout p6() {
        return this.f28084e;
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final synchronized void v0(IObjectWrapper iObjectWrapper, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized void y5(View view, String str) {
        if (!this.n) {
            if (view == null) {
                this.f28082c.remove(str);
                return;
            }
            this.f28082c.put(str, new WeakReference(view));
            if (!"1098".equals(str) && !"3011".equals(str)) {
                if (com.google.android.gms.ads.internal.util.zzbs.a(this.f28087h)) {
                    view.setOnTouchListener(this);
                }
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized View z0(String str) {
        WeakReference weakReference;
        if (!this.n && (weakReference = (WeakReference) this.f28082c.get(str)) != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final synchronized void zze() {
        try {
            if (this.n) {
                return;
            }
            zzdnh zzdnhVar = this.f28088i;
            if (zzdnhVar != null) {
                zzdnhVar.r(this);
                this.f28088i = null;
            }
            this.f28082c.clear();
            this.f28083d.removeAllViews();
            this.f28084e.removeAllViews();
            this.f28082c = null;
            this.f28083d = null;
            this.f28084e = null;
            this.f28086g = null;
            this.f28089j = null;
            this.n = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final zzbcm zzh() {
        return this.f28089j;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized Map zzj() {
        return this.f28082c;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized Map zzk() {
        return this.f28082c;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized Map zzl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized String zzn() {
        return this.f28081b;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final IObjectWrapper zzo() {
        return this.f28090k;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized JSONObject zzp() {
        JSONObject jSONObjectH0;
        zzdnh zzdnhVar = this.f28088i;
        if (zzdnhVar == null) {
            return null;
        }
        FrameLayout frameLayout = this.f28083d;
        Map mapZzj = zzj();
        Map mapZzk = zzk();
        synchronized (zzdnhVar) {
            jSONObjectH0 = zzdnhVar.n.h0(frameLayout, mapZzj, mapZzk, zzdnhVar.l());
        }
        return jSONObjectH0;
    }

    @Override // com.google.android.gms.internal.ads.zzdpj
    public final synchronized JSONObject zzq() {
        JSONObject jSONObjectB0;
        zzdnh zzdnhVar = this.f28088i;
        if (zzdnhVar == null) {
            return null;
        }
        FrameLayout frameLayout = this.f28083d;
        Map mapZzj = zzj();
        Map mapZzk = zzk();
        synchronized (zzdnhVar) {
            jSONObjectB0 = zzdnhVar.n.b0(frameLayout, mapZzj, mapZzk, zzdnhVar.l());
        }
        return jSONObjectB0;
    }
}
