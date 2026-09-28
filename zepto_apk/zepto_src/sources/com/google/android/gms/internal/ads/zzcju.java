package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import androidx.webkit.internal.WebViewFeatureInternal;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.google.android.gms.internal.ads.zzbfp;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hypersdk.analytics.LogConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@SuppressLint({"ViewConstructor"})
@VisibleForTesting
/* loaded from: classes4.dex */
final class zzcju extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcir {
    public static final /* synthetic */ int L0 = 0;
    public zzcjx A;
    public boolean A0;
    public boolean B;
    public final com.google.android.gms.ads.internal.util.zzci B0;
    public boolean C;
    public int C0;
    public zzbjl D;
    public int D0;
    public zzdrr E;
    public int E0;
    public zzbdx F;
    public int F0;
    public int G;
    public int G0;
    public int H;
    public HashMap H0;
    public zzbgw I;
    public final WindowManager I0;
    public final zzbgw J;
    public final zzbfj J0;
    public zzbgw K;
    public boolean K0;
    public final zzbgx L;
    public int M;
    public com.google.android.gms.ads.internal.overlay.zzm Q;

    /* renamed from: a, reason: collision with root package name */
    public final zzckt f26423a;

    /* renamed from: b, reason: collision with root package name */
    public final zzayq f26424b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfio f26425c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbhr f26426d;

    /* renamed from: e, reason: collision with root package name */
    public final VersionInfoParcel f26427e;

    /* renamed from: f, reason: collision with root package name */
    public com.google.android.gms.ads.internal.zzn f26428f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.zza f26429g;

    /* renamed from: h, reason: collision with root package name */
    public final DisplayMetrics f26430h;

    /* renamed from: i, reason: collision with root package name */
    public final float f26431i;

    /* renamed from: j, reason: collision with root package name */
    public zzfhr f26432j;

    /* renamed from: k, reason: collision with root package name */
    public zzfhu f26433k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f26434l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f26435m;
    public zzcjc n;
    public com.google.android.gms.ads.internal.overlay.zzm o;
    public zzejb p;
    public zzeiz q;
    public zzclb r;
    public final String s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public Boolean x;
    public boolean y;
    public final String z;

    public zzcju(zzckt zzcktVar, zzclb zzclbVar, String str, boolean z, zzayq zzayqVar, zzbhr zzbhrVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zzn zznVar, com.google.android.gms.ads.internal.zza zzaVar, zzbfj zzbfjVar, zzfhr zzfhrVar, zzfhu zzfhuVar, zzfio zzfioVar) {
        zzfhu zzfhuVar2;
        String str2;
        zzbgp zzbgpVarA;
        super(zzcktVar);
        this.f26434l = false;
        this.f26435m = false;
        this.y = true;
        this.z = "";
        this.C0 = -1;
        this.D0 = -1;
        this.E0 = -1;
        this.F0 = -1;
        this.G0 = -1;
        this.f26423a = zzcktVar;
        this.r = zzclbVar;
        this.s = str;
        this.v = z;
        this.f26424b = zzayqVar;
        this.f26425c = zzfioVar;
        this.f26426d = zzbhrVar;
        this.f26427e = versionInfoParcel;
        this.f26428f = zznVar;
        this.f26429g = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.I0 = windowManager;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f26430h = displayMetrics;
        this.f26431i = displayMetrics.density;
        this.J0 = zzbfjVar;
        this.f26432j = zzfhrVar;
        this.f26433k = zzfhuVar;
        this.B0 = new com.google.android.gms.ads.internal.util.zzci(zzcktVar.f26469a, this, this);
        this.K0 = false;
        setBackgroundColor(0);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Jc)).booleanValue()) {
            setSoundEffectsEnabled(false);
        }
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to enable Javascript.", e2);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        zzbgb zzbgbVar = zzbgk.Ic;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.pe)).booleanValue()) {
            settings.setGeolocationEnabled(false);
        }
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        settings.setUserAgentString(zztVar.f21679c.E(zzcktVar, versionInfoParcel.f21400a));
        com.google.android.gms.ads.internal.util.zzs.O(getContext(), settings);
        setDownloadListener(this);
        O0();
        addJavascriptInterface(new zzckc(this, new zzcka(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbgx zzbgxVar = this.L;
        if (zzbgxVar != null && (zzbgpVarA = zztVar.f21684h.a()) != null) {
            zzbgpVarA.f25029a.offer(zzbgxVar.f25045b);
        }
        zzbgz zzbgzVar = new zzbgz(this.s);
        zzbgx zzbgxVar2 = new zzbgx(zzbgzVar);
        this.L = zzbgxVar2;
        synchronized (zzbgzVar.f25050c) {
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.l2)).booleanValue() && (zzfhuVar2 = this.f26433k) != null && (str2 = zzfhuVar2.f31167b) != null) {
            zzbgzVar.c("gqi", str2);
        }
        Context context = null;
        zzbgw zzbgwVar = new zzbgw(zztVar.f21687k.elapsedRealtime(), null, null);
        this.J = zzbgwVar;
        zzbgxVar2.f25044a.put("native:view_create", zzbgwVar);
        this.K = null;
        this.I = null;
        if (com.google.android.gms.ads.internal.util.zzce.f21559b == null) {
            com.google.android.gms.ads.internal.util.zzce.f21559b = new com.google.android.gms.ads.internal.util.zzce();
        }
        com.google.android.gms.ads.internal.util.zzce zzceVar = com.google.android.gms.ads.internal.util.zzce.f21559b;
        zzceVar.getClass();
        com.google.android.gms.ads.internal.util.zze.k("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(zzcktVar);
        if (!defaultUserAgent.equals(zzceVar.f21560a)) {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(zzcktVar);
            if (ClientLibraryUtils.isPackageSide()) {
                context = remoteContext;
            } else {
                if (remoteContext == null) {
                }
                zzceVar.f21560a = defaultUserAgent;
            }
            SharedPreferences.Editor editorPutString = zzcktVar.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(zzcktVar));
            if (context == null) {
                editorPutString.apply();
            } else {
                SharedPreferencesUtils.publishWorldReadableSharedPreferences(zzcktVar, editorPutString, "admob_user_agent");
            }
            zzceVar.f21560a = defaultUserAgent;
        }
        com.google.android.gms.ads.internal.util.zze.k("User agent is updated.");
        zztVar.f21684h.f25941k.incrementAndGet();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm A() {
        return this.Q;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean B() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void B0() {
        boolean z;
        HashMap map = new HashMap(3);
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzaa zzaaVar = zztVar.f21685i;
        synchronized (zzaaVar) {
            z = zzaaVar.f21456a;
        }
        map.put("app_muted", String.valueOf(z));
        map.put("app_volume", String.valueOf(zztVar.f21685i.a()));
        map.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.util.zzaa.b(getContext())));
        g("volume", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final zzfio C() {
        return this.f26425c;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void C0(boolean z) {
        this.y = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized boolean D() {
        return this.G > 0;
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final synchronized void D0() {
        com.google.android.gms.ads.internal.zzn zznVar = this.f26428f;
        if (zznVar != null) {
            zznVar.D0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized zzbjl E() {
        return this.D;
    }

    public final WebViewClient E0() {
        return this.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzckh
    public final void F(int i2, boolean z, boolean z2) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        zzdir zzdirVar;
        zzeif zzeifVar;
        int i3;
        com.google.android.gms.ads.internal.client.zza zzaVar2;
        boolean z3;
        zzcjc zzcjcVar = this.n;
        zzcjn zzcjnVar = zzcjcVar.f26369a;
        boolean zI0 = zzcjc.i0(zzcjnVar.r(), zzcjnVar);
        boolean z4 = true;
        if (!zI0 && z2) {
            z4 = false;
        }
        if (zI0) {
            zzaVar = null;
            zzdirVar = null;
        } else {
            zzaVar = zzcjcVar.f26373e;
            zzdirVar = null;
        }
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = zzcjcVar.f26374f;
        zzdir zzdirVar2 = zzdirVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = zzcjcVar.u;
        VersionInfoParcel versionInfoParcelZzs = ((zzcju) zzcjnVar.f26410a).zzs();
        zzdir zzdirVar3 = z4 ? zzdirVar2 : zzcjcVar.f26379k;
        if (zzcjc.Y(zzcjnVar)) {
            zzeifVar = zzcjcVar.G;
            i3 = i2;
            z3 = z;
            zzaVar2 = zzaVar;
        } else {
            zzeifVar = zzdirVar2;
            i3 = i2;
            zzaVar2 = zzaVar;
            z3 = z;
        }
        zzcjcVar.a(new AdOverlayInfoParcel(zzaVar2, zzrVar, zzadVar, zzcjnVar, z3, i3, versionInfoParcelZzs, zzdirVar3, zzeifVar));
    }

    public final synchronized void F0() {
        com.google.android.gms.ads.internal.util.zze.k("Destroying WebView!");
        P0();
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzcjp(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized boolean G() {
        return this.t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008b, code lost:
    
        if (r10.G0 != r9) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean G0() throws org.json.JSONException {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzcjc r0 = r10.n
            boolean r0 = r0.s0()
            r1 = 0
            if (r0 != 0) goto L11
            com.google.android.gms.internal.ads.zzcjc r0 = r10.n
            boolean r0 = r0.t0()
            if (r0 == 0) goto L8e
        L11:
            com.google.android.gms.ads.internal.client.zzbb r0 = com.google.android.gms.ads.internal.client.zzbb.f21141g
            com.google.android.gms.ads.internal.util.client.zzf r0 = r0.f21142a
            android.util.DisplayMetrics r0 = r10.f26430h
            int r2 = r0.widthPixels
            float r2 = (float) r2
            float r3 = r0.density
            float r2 = r2 / r3
            int r4 = java.lang.Math.round(r2)
            int r2 = r0.heightPixels
            float r2 = (float) r2
            float r3 = r0.density
            float r2 = r2 / r3
            int r5 = java.lang.Math.round(r2)
            com.google.android.gms.internal.ads.zzckt r2 = r10.f26423a
            android.app.Activity r2 = r2.f26469a
            r3 = 1
            if (r2 == 0) goto L57
            android.view.Window r6 = r2.getWindow()
            if (r6 != 0) goto L39
            goto L57
        L39:
            com.google.android.gms.ads.internal.zzt r6 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.ads.internal.util.zzs r6 = r6.f21679c
            int[] r2 = com.google.android.gms.ads.internal.util.zzs.p(r2)
            r6 = r2[r1]
            float r6 = (float) r6
            float r7 = r0.density
            float r6 = r6 / r7
            int r6 = java.lang.Math.round(r6)
            r2 = r2[r3]
            float r2 = (float) r2
            float r7 = r0.density
            float r2 = r2 / r7
            int r2 = java.lang.Math.round(r2)
            r7 = r2
            goto L59
        L57:
            r6 = r4
            r7 = r5
        L59:
            com.google.android.gms.ads.internal.zzt r2 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.ads.internal.util.zzs r2 = r2.f21679c
            android.view.WindowManager r2 = r10.I0
            android.view.Display r2 = r2.getDefaultDisplay()
            int r9 = r2.getRotation()
            int r2 = r10.D0
            if (r2 != r4) goto L8f
            int r2 = r10.C0
            if (r2 != r5) goto L8f
            int r2 = r10.E0
            if (r2 != r6) goto L8f
            int r2 = r10.F0
            if (r2 != r7) goto L8f
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.q0
            com.google.android.gms.ads.internal.client.zzbd r8 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r8 = r8.f21153c
            java.lang.Object r2 = r8.a(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L8e
            int r2 = r10.G0
            if (r2 == r9) goto L8e
            goto L8f
        L8e:
            return r1
        L8f:
            int r2 = r10.D0
            if (r2 != r4) goto Lad
            int r2 = r10.C0
            if (r2 != r5) goto Lad
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.q0
            com.google.android.gms.ads.internal.client.zzbd r8 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r8 = r8.f21153c
            java.lang.Object r2 = r8.a(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto Lae
            int r2 = r10.G0
            if (r2 == r9) goto Lae
        Lad:
            r1 = r3
        Lae:
            r10.D0 = r4
            r10.C0 = r5
            r10.E0 = r6
            r10.F0 = r7
            r10.G0 = r9
            com.google.android.gms.internal.ads.zzbwd r3 = new com.google.android.gms.internal.ads.zzbwd
            java.lang.String r2 = ""
            r3.<init>(r10, r2)
            float r8 = r0.density
            r3.e(r4, r5, r6, r7, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcju.G0():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void H() {
        if (this.I == null) {
            zzbgx zzbgxVar = this.L;
            zzbgr.a(zzbgxVar.f25045b, this.J, "aes2");
            zzbgw zzbgwVar = new zzbgw(com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime(), null, null);
            this.I = zzbgwVar;
            zzbgxVar.f25044a.put("native:view_show", zzbgwVar);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.f26427e.f21400a);
        g("onshow", map);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H0(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.Boolean r0 = r3.x     // Catch: java.lang.Throwable -> L75
            monitor-exit(r3)
            r1 = 0
            if (r0 != 0) goto L30
            monitor-enter(r3)
            com.google.android.gms.ads.internal.zzt r0 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L22
            com.google.android.gms.internal.ads.zzcda r0 = r0.f21684h     // Catch: java.lang.Throwable -> L22
            java.lang.Object r2 = r0.f25931a     // Catch: java.lang.Throwable -> L22
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L22
            java.lang.Boolean r0 = r0.f25940j     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            r3.x = r0     // Catch: java.lang.Throwable -> L22
            if (r0 != 0) goto L20
            java.lang.String r0 = "(function(){})()"
            r3.evaluateJavascript(r0, r1)     // Catch: java.lang.Throwable -> L22 java.lang.IllegalStateException -> L24
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L22 java.lang.IllegalStateException -> L24
            r3.I0(r0)     // Catch: java.lang.Throwable -> L22 java.lang.IllegalStateException -> L24
        L20:
            monitor-exit(r3)
            goto L30
        L22:
            r4 = move-exception
            goto L2e
        L24:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L22
            r3.I0(r0)     // Catch: java.lang.Throwable -> L22
            monitor-exit(r3)
            goto L30
        L2b:
            r4 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            throw r4     // Catch: java.lang.Throwable -> L22
        L2e:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L22
            throw r4
        L30:
            monitor-enter(r3)
            java.lang.Boolean r0 = r3.x     // Catch: java.lang.Throwable -> L72
            monitor-exit(r3)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L53
            monitor-enter(r3)
            boolean r0 = r3.n()     // Catch: java.lang.Throwable -> L46
            if (r0 != 0) goto L48
            r3.evaluateJavascript(r4, r1)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r3)
            goto L6f
        L46:
            r4 = move-exception
            goto L51
        L48:
            int r4 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> L46
            java.lang.String r4 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.ads.internal.util.client.zzo.f(r4)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r3)
            goto L6f
        L51:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L46
            throw r4
        L53:
            java.lang.String r0 = "javascript:"
            java.lang.String r4 = r0.concat(r4)
            monitor-enter(r3)
            boolean r0 = r3.n()     // Catch: java.lang.Throwable -> L65
            if (r0 != 0) goto L67
            r3.loadUrl(r4)     // Catch: java.lang.Throwable -> L65
            monitor-exit(r3)
            goto L6f
        L65:
            r4 = move-exception
            goto L70
        L67:
            int r4 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> L65
            java.lang.String r4 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.ads.internal.util.client.zzo.f(r4)     // Catch: java.lang.Throwable -> L65
            monitor-exit(r3)
        L6f:
            return
        L70:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L65
            throw r4
        L72:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L72
            throw r4
        L75:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L75
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcju.H0(java.lang.String):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized zzbdx I() {
        return this.F;
    }

    public final void I0(Boolean bool) {
        synchronized (this) {
            this.x = bool;
        }
        zzcda zzcdaVar = com.google.android.gms.ads.internal.zzt.C.f21684h;
        synchronized (zzcdaVar.f25931a) {
            zzcdaVar.f25940j = bool;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final ListenableFuture J() {
        zzbhr zzbhrVar = this.f26426d;
        return zzbhrVar == null ? zzgyq.f33377b : (zzgye) zzgym.g(zzgye.s(zzgyq.f33377b), ((Long) zzbij.f25168c.c()).longValue(), TimeUnit.MILLISECONDS, zzbhrVar.f25093c);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void K(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.o = zzmVar;
    }

    public final /* synthetic */ void K0(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized zzejb L() {
        return this.p;
    }

    public final /* synthetic */ void L0(String str) {
        super.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void M(String str, String str2) {
        Throwable th;
        String str3;
        try {
            try {
                if (n()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
                    return;
                }
                String str4 = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.n0);
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put("version", str4);
                        jSONObject.put("sdk", "Google Mobile Ads");
                        jSONObject.put(PaymentConstants.SDK_VERSION, "12.4.51-000");
                        str3 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (JSONException e2) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.g("Unable to build MRAID_ENV", e2);
                    str3 = null;
                }
                super.loadDataWithBaseURL(str, zzcki.a(str2, str3), "text/html", "UTF-8", null);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final /* synthetic */ void M0() {
        super.loadUrl("about:blank");
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void N(Context context) {
        zzckt zzcktVar = this.f26423a;
        zzcktVar.setBaseContext(context);
        this.B0.f21571b = zzcktVar.f26469a;
    }

    public final synchronized void N0() {
        try {
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f26417a.M0();
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdWebViewImpl.loadUrlUnsafe", th);
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not call loadUrl in destroy(). ", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final Context O() {
        return this.f26423a.f26471c;
    }

    public final synchronized void O0() {
        try {
            zzfhr zzfhrVar = this.f26432j;
            if (zzfhrVar != null && zzfhrVar.m0) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Disabling hardware acceleration on an overlay.");
                synchronized (this) {
                    try {
                        if (!this.w) {
                            setLayerType(1, null);
                        }
                        this.w = true;
                    } finally {
                    }
                }
                return;
            }
            if (this.v || this.r.b()) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Enabling hardware acceleration on an overlay.");
                synchronized (this) {
                    try {
                        if (this.w) {
                            setLayerType(0, null);
                        }
                        this.w = false;
                    } finally {
                    }
                }
                return;
            }
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Enabling hardware acceleration on an AdView.");
            synchronized (this) {
                try {
                    if (this.w) {
                        setLayerType(0, null);
                    }
                    this.w = false;
                } finally {
                }
            }
            return;
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final synchronized void P(int i2) {
        this.M = i2;
    }

    public final synchronized void P0() {
        if (this.A0) {
            return;
        }
        this.A0 = true;
        com.google.android.gms.ads.internal.zzt.C.f21684h.f25941k.decrementAndGet();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void Q(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        int i2 = this.G + (true != z ? -1 : 1);
        this.G = i2;
        if (i2 > 0 || (zzmVar = this.o) == null) {
            return;
        }
        synchronized (zzmVar.n) {
            try {
                zzmVar.q = true;
                Runnable runnable = zzmVar.p;
                if (runnable != null) {
                    com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
                    zzfVar.removeCallbacks(runnable);
                    zzfVar.post(zzmVar.p);
                }
            } finally {
            }
        }
    }

    public final synchronized void Q0() {
        try {
            HashMap map = this.H0;
            if (map != null) {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    ((zzcgx) it.next()).release();
                }
            }
            this.H0 = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void R(long j2, boolean z) {
        HashMap map = new HashMap(2);
        map.put(APayConstants.SUCCESS, true != z ? "0" : "1");
        map.put("duration", Long.toString(j2));
        g("onCacheAccessComplete", map);
    }

    public final void R0(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", true != z ? "0" : "1");
        g("onAdVisibilityChanged", map);
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void S() {
        zzcjc zzcjcVar = this.n;
        if (zzcjcVar != null) {
            zzcjcVar.S();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final synchronized void T(String str, zzcgx zzcgxVar) {
        try {
            if (this.H0 == null) {
                this.H0 = new HashMap();
            }
            this.H0.put(str, zzcgxVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void U(zzfhr zzfhrVar, zzfhu zzfhuVar) {
        this.f26432j = zzfhrVar;
        this.f26433k = zzfhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void V(int i2) {
        zzbgw zzbgwVar = this.J;
        zzbgx zzbgxVar = this.L;
        if (i2 == 0) {
            zzbgr.a(zzbgxVar.f25045b, zzbgwVar, "aebb2");
        }
        zzbgr.a(zzbgxVar.f25045b, zzbgwVar, "aeh2");
        zzbgxVar.getClass();
        zzbgxVar.f25045b.c("close_type", String.valueOf(i2));
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i2));
        map.put("version", this.f26427e.f21400a);
        g("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void W(zzclb zzclbVar) {
        this.r = zzclbVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final boolean X(final int i2, final boolean z) {
        destroy();
        zzbfi zzbfiVar = new zzbfi() { // from class: com.google.android.gms.internal.ads.zzcjs
            @Override // com.google.android.gms.internal.ads.zzbfi
            public final void a(zzbfp.zzt.zza zzaVar) {
                int i3 = zzcju.L0;
                zzbfp.zzbl.zza zzaVarD = zzbfp.zzbl.D();
                boolean zC = ((zzbfp.zzbl) zzaVarD.f34638b).C();
                boolean z2 = z;
                if (zC != z2) {
                    zzaVarD.j();
                    ((zzbfp.zzbl) zzaVarD.f34638b).E(z2);
                }
                zzaVarD.j();
                ((zzbfp.zzbl) zzaVarD.f34638b).F(i2);
                zzbfp.zzbl zzblVar = (zzbfp.zzbl) zzaVarD.l();
                zzaVar.j();
                ((zzbfp.zzt) zzaVar.f34638b).M(zzblVar);
            }
        };
        zzbfj zzbfjVar = this.J0;
        zzbfjVar.a(zzbfiVar);
        zzbfjVar.b(10003);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzckh
    public final void Y(String str, String str2, boolean z, int i2, boolean z2) {
        zzcjc zzcjcVar = this.n;
        zzcjn zzcjnVar = zzcjcVar.f26369a;
        boolean zR = zzcjnVar.r();
        boolean zI0 = zzcjc.i0(zR, zzcjnVar);
        boolean z3 = true;
        if (!zI0 && z2) {
            z3 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zI0 ? null : zzcjcVar.f26373e;
        zzcjb zzcjbVar = zR ? null : new zzcjb(zzcjnVar, zzcjcVar.f26374f);
        zzbmd zzbmdVar = zzcjcVar.f26377i;
        zzeif zzeifVar = null;
        zzbmf zzbmfVar = zzcjcVar.f26378j;
        boolean z4 = z3;
        zzcjb zzcjbVar2 = zzcjbVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = zzcjcVar.u;
        VersionInfoParcel versionInfoParcelZzs = ((zzcju) zzcjnVar.f26410a).zzs();
        zzdir zzdirVar = z4 ? null : zzcjcVar.f26379k;
        if (zzcjc.Y(zzcjnVar)) {
            zzeifVar = zzcjcVar.G;
        }
        zzcjcVar.a(new AdOverlayInfoParcel(zzaVar, zzcjbVar2, zzbmdVar, zzbmfVar, zzadVar, zzcjnVar, z, i2, str, str2, versionInfoParcelZzs, zzdirVar, zzeifVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void Z(boolean z) {
        this.n.E = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void a(String str) {
        H0(str);
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void a0() {
        zzcjc zzcjcVar = this.n;
        if (zzcjcVar != null) {
            zzcjcVar.a0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final int b() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void b0(zzeiz zzeizVar) {
        this.q = zzeizVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void c(String str, String str2) {
        H0(android.support.v4.media.a.n(new StringBuilder(androidx.fragment.app.e.C(1, String.valueOf(str2).length(), str) + 2), str, "(", str2, ");"));
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void c0(String str, Predicate predicate) {
        zzcjc zzcjcVar = this.n;
        if (zzcjcVar != null) {
            synchronized (zzcjcVar.f26372d) {
                try {
                    List<zzbnn> list = (List) zzcjcVar.f26371c.get(str);
                    if (list == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (zzbnn zzbnnVar : list) {
                        if (((zzbqs) predicate).apply(zzbnnVar)) {
                            arrayList.add(zzbnnVar);
                        }
                    }
                    list.removeAll(arrayList);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzckk
    public final zzayq d() {
        return this.f26424b;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void d0() {
        this.K0 = true;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcir
    public final synchronized void destroy() {
        zzbgp zzbgpVarA;
        View decorView;
        try {
            zzbgx zzbgxVar = this.L;
            if (zzbgxVar != null && (zzbgpVarA = com.google.android.gms.ads.internal.zzt.C.f21684h.a()) != null) {
                zzbgpVarA.f25029a.offer(zzbgxVar.f25045b);
            }
            com.google.android.gms.ads.internal.util.zzci zzciVar = this.B0;
            zzciVar.f21574e = false;
            Activity activity = zzciVar.f21571b;
            if (activity != null && zzciVar.f21572c) {
                Window window = activity.getWindow();
                ViewTreeObserver viewTreeObserver = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(zzciVar.f21575f);
                }
                zzciVar.f21572c = false;
            }
            com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.o;
            if (zzmVar != null) {
                zzmVar.zzb();
                this.o.B();
                this.o = null;
            }
            this.p = null;
            this.q = null;
            this.n.f();
            this.F = null;
            this.f26428f = null;
            setOnClickListener(null);
            setOnTouchListener(null);
            if (this.u) {
                return;
            }
            com.google.android.gms.ads.internal.zzt.C.A.b(this);
            Q0();
            this.u = true;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Tb)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.k("Destroying the WebView immediately...");
                F0();
                return;
            }
            Activity activity2 = this.f26423a.f26469a;
            if (activity2 != null && activity2.isDestroyed()) {
                com.google.android.gms.ads.internal.util.zze.k("Destroying the WebView immediately...");
                F0();
            } else {
                com.google.android.gms.ads.internal.util.zze.k("Initiating WebView self destruct sequence in 3...");
                com.google.android.gms.ads.internal.util.zze.k("Loading blank page in WebView, 2...");
                N0();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcjy
    public final zzfhu e() {
        return this.f26433k;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final /* synthetic */ zzcjc e0() {
        return this.n;
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(final String str, final ValueCallback valueCallback) {
        if (n()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ub)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
            return;
        }
        ((zzgxi) zzcdo.f25987f).submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f26420a.K0(str, valueCallback);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbqv
    public final void f(String str, JSONObject jSONObject) {
        c(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void f0(boolean z) {
        if (z) {
            try {
                setBackgroundColor(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.o;
        if (zzmVar != null) {
            if (z) {
                zzmVar.f21370l.setBackgroundColor(0);
            } else {
                zzmVar.f21370l.setBackgroundColor(-16777216);
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                try {
                    if (!this.u) {
                        this.n.f();
                        com.google.android.gms.ads.internal.zzt.C.A.b(this);
                        Q0();
                        P0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqj
    public final void g(String str, Map map) {
        try {
            m(str, com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.l(map));
        } catch (JSONException unused) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void g0(boolean z) {
        try {
            boolean z2 = this.v;
            this.v = z;
            O0();
            if (z != z2) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.o0)).booleanValue()) {
                    if (!this.r.b()) {
                    }
                }
                new zzbwd(this, "").d(true != z ? LogConstants.DEFAULT_CHANNEL : "expanded");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        zzcjc zzcjcVar = this.n;
        if (zzcjcVar != null) {
            zzcjcVar.h();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void h0(String str, zzbnn zzbnnVar) {
        zzcjc zzcjcVar = this.n;
        if (zzcjcVar != null) {
            synchronized (zzcjcVar.f26372d) {
                try {
                    List list = (List) zzcjcVar.f26371c.get(str);
                    if (list == null) {
                        return;
                    }
                    list.remove(zzbnnVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void i() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void i0(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final synchronized zzcgx j(String str) {
        HashMap map = this.H0;
        if (map == null) {
            return null;
        }
        return (zzcgx) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void j0(int i2) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.o;
        if (zzmVar != null) {
            zzmVar.fc(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final WebView k() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void k0(String str, zzbnn zzbnnVar) {
        zzcjc zzcjcVar = this.n;
        if (zzcjcVar != null) {
            zzcjcVar.b(str, zzbnnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void l() {
        zzbgr.a(this.L.f25045b, this.J, "aeh2");
        HashMap map = new HashMap(1);
        map.put("version", this.f26427e.f21400a);
        g("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzckh
    public final void l0(String str, String str2) {
        zzcjc zzcjcVar = this.n;
        zzcjcVar.getClass();
        zzcjn zzcjnVar = zzcjcVar.f26369a;
        zzcjcVar.a(new AdOverlayInfoParcel(zzcjnVar, ((zzcju) zzcjnVar.f26410a).zzs(), str, str2, zzcjcVar.G));
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcir
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!n()) {
            super.loadData(str, str2, str3);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcir
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) throws Throwable {
        try {
            try {
                if (!n()) {
                    super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                } else {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcir
    public final synchronized void loadUrl(final String str) {
        if (n()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f26415a.L0(str);
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdWebViewImpl.loadUrl", th);
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not call loadUrl. ", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqj
    public final void m(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        StringBuilder sbV = androidx.fragment.app.e.v("(window.AFMA_ReceiveMessage || function() {})('", str, "',", jSONObject.toString(), ");");
        String string = sbV.toString();
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Dispatching AFMA event: ".concat(string));
        H0(sbV.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final synchronized void m0() {
        final zzdrr zzdrrVar = this.E;
        if (zzdrrVar != null) {
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrq
                @Override // java.lang.Runnable
                public final void run() {
                    zzdrr zzdrrVar2 = zzdrrVar;
                    try {
                        zzdrrVar2.getClass();
                        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
                        zzdrrVar2.Yb();
                        zzdnh zzdnhVar = zzdrrVar2.f28370c;
                        if (zzdnhVar != null) {
                            zzdnhVar.o();
                        }
                        zzdrrVar2.f28370c = null;
                        zzdrrVar2.f28368a = null;
                        zzdrrVar2.f28369b = null;
                        zzdrrVar2.f28371d = true;
                    } catch (RemoteException e2) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized boolean n() {
        return this.u;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void n0(zzbjl zzbjlVar) {
        this.D = zzbjlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void o() {
        com.google.android.gms.ads.internal.util.zzci zzciVar = this.B0;
        zzciVar.f21574e = true;
        if (zzciVar.f21573d) {
            zzciVar.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void o0(zzdrr zzdrrVar) {
        this.E = zzdrrVar;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final synchronized void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            boolean z = true;
            if (!n()) {
                com.google.android.gms.ads.internal.util.zzci zzciVar = this.B0;
                zzciVar.f21573d = true;
                if (zzciVar.f21574e) {
                    zzciVar.a();
                }
            }
            if (this.K0) {
                onResume();
                this.K0 = false;
            }
            boolean z2 = this.B;
            zzcjc zzcjcVar = this.n;
            if (zzcjcVar == null || !zzcjcVar.t0()) {
                z = z2;
            } else {
                if (!this.C) {
                    synchronized (this.n.f26372d) {
                    }
                    synchronized (this.n.f26372d) {
                    }
                    this.C = true;
                }
                G0();
            }
            R0(z);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        zzcjc zzcjcVar;
        View decorView;
        synchronized (this) {
            try {
                if (!n()) {
                    com.google.android.gms.ads.internal.util.zzci zzciVar = this.B0;
                    zzciVar.f21573d = false;
                    Activity activity = zzciVar.f21571b;
                    if (activity != null && zzciVar.f21572c) {
                        Window window = activity.getWindow();
                        ViewTreeObserver viewTreeObserver = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeOnGlobalLayoutListener(zzciVar.f21575f);
                        }
                        zzciVar.f21572c = false;
                    }
                }
                super.onDetachedFromWindow();
                if (this.C && (zzcjcVar = this.n) != null && zzcjcVar.t0() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                    synchronized (this.n.f26372d) {
                    }
                    synchronized (this.n.f26372d) {
                    }
                    this.C = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        R0(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ic)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            com.google.android.gms.ads.internal.util.zzs.t(getContext(), intent);
        } catch (ActivityNotFoundException e2) {
            String strN = android.support.v4.media.a.n(new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length()), "Couldn't find an Activity to view url/mimetype: ", str, " / ", str4);
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a(strN);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)), e2);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (n()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() throws JSONException {
        boolean zG0 = G0();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZ = z();
        if (zzmVarZ != null && zG0 && zzmVarZ.f21371m) {
            zzmVarZ.f21371m = false;
            zzmVarZ.f21362d.H();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void onMeasure(int r10, int r11) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcju.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcir
    public final void onPause() {
        if (n()) {
            return;
        }
        try {
            super.onPause();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Jd)).booleanValue() && WebViewFeature.a("MUTE_AUDIO")) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Muting webview");
                int i3 = WebViewCompat.f12427a;
                if (!WebViewFeatureInternal.o.d()) {
                    throw WebViewFeatureInternal.a();
                }
                WebViewCompat.c(this).f12463a.setAudioMuted(true);
            }
        } catch (Exception e2) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Could not pause webview.", e2);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Md)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdWebViewImpl.onPause", e2);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcir
    public final void onResume() {
        if (n()) {
            return;
        }
        try {
            super.onResume();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Jd)).booleanValue() && WebViewFeature.a("MUTE_AUDIO")) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Unmuting webview");
                int i3 = WebViewCompat.f12427a;
                if (!WebViewFeatureInternal.o.d()) {
                    throw WebViewFeatureInternal.a();
                }
                WebViewCompat.c(this).f12463a.setAudioMuted(false);
            }
        } catch (Exception e2) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Could not resume webview.", e2);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Md)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdWebViewImpl.onResume", e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.g4
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r1 = r1.f21153c
            java.lang.Object r0 = r1.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L20
            com.google.android.gms.internal.ads.zzcjc r0 = r7.n
            java.lang.Object r3 = r0.f26372d
            monitor-enter(r3)
            boolean r0 = r0.s     // Catch: java.lang.Throwable -> L22
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L20
            r0 = r1
            goto L25
        L20:
            r0 = r2
            goto L25
        L22:
            r8 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L22
            throw r8
        L25:
            com.google.android.gms.internal.ads.zzcjc r3 = r7.n
            boolean r3 = r3.t0()
            if (r3 == 0) goto L3b
            com.google.android.gms.internal.ads.zzcjc r3 = r7.n
            java.lang.Object r4 = r3.f26372d
            monitor-enter(r4)
            boolean r3 = r3.t     // Catch: java.lang.Throwable -> L38
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L3d
            goto L3b
        L38:
            r8 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L38
            throw r8
        L3b:
            if (r0 == 0) goto L4c
        L3d:
            monitor-enter(r7)
            com.google.android.gms.internal.ads.zzbjl r0 = r7.D     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L48
            r0.a(r8)     // Catch: java.lang.Throwable -> L46
            goto L48
        L46:
            r8 = move-exception
            goto L4a
        L48:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L46
            goto L8f
        L4a:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L46
            throw r8
        L4c:
            com.google.android.gms.internal.ads.zzayq r0 = r7.f26424b
            if (r0 == 0) goto L55
            com.google.android.gms.internal.ads.zzayl r0 = r0.f24512b
            r0.f(r8)
        L55:
            com.google.android.gms.internal.ads.zzbhr r0 = r7.f26426d
            if (r0 == 0) goto L8f
            int r3 = r8.getAction()
            if (r3 != r1) goto L75
            long r3 = r8.getEventTime()
            android.view.MotionEvent r1 = r0.f25091a
            long r5 = r1.getEventTime()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 > 0) goto L6e
            goto L75
        L6e:
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r8)
            r0.f25091a = r1
            goto L8f
        L75:
            int r1 = r8.getAction()
            if (r1 != 0) goto L8f
            long r3 = r8.getEventTime()
            android.view.MotionEvent r1 = r0.f25092b
            long r5 = r1.getEventTime()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L8f
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r8)
            r0.f25092b = r1
        L8f:
            boolean r0 = r7.n()
            if (r0 == 0) goto L96
            return r2
        L96:
            boolean r8 = super.onTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcju.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void p() {
        com.google.android.gms.ads.internal.util.zze.k("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void p0(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.o;
        if (zzmVar != null) {
            zzmVar.ec(this.n.s0(), z);
        } else {
            this.t = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized zzeiz q() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void q0(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.Q = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized boolean r() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void r0(zzejb zzejbVar) {
        this.p = zzejbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized boolean s() {
        return this.y;
    }

    @Override // com.google.android.gms.internal.ads.zzckh
    public final void s0(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        this.n.w0(zzcVar, z, z2, str);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcir
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcjc) {
            this.n = (zzcjc) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (n()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Could not stop loading webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final synchronized void t(zzcjx zzcjxVar) {
        if (this.A == null) {
            this.A = zzcjxVar;
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Attempt to create multiple AdWebViewVideoControllers.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzckh
    public final void t0(boolean z, int i2, String str, boolean z2, boolean z3) {
        zzcjc zzcjcVar = this.n;
        zzcjn zzcjnVar = zzcjcVar.f26369a;
        boolean zR = zzcjnVar.r();
        boolean zI0 = zzcjc.i0(zR, zzcjnVar);
        boolean z4 = true;
        if (!zI0 && z2) {
            z4 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zI0 ? null : zzcjcVar.f26373e;
        zzcjb zzcjbVar = zR ? null : new zzcjb(zzcjnVar, zzcjcVar.f26374f);
        zzbmd zzbmdVar = zzcjcVar.f26377i;
        zzeif zzeifVar = null;
        zzbmf zzbmfVar = zzcjcVar.f26378j;
        boolean z5 = z4;
        zzcjb zzcjbVar2 = zzcjbVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = zzcjcVar.u;
        VersionInfoParcel versionInfoParcelZzs = ((zzcju) zzcjnVar.f26410a).zzs();
        zzdir zzdirVar = z5 ? null : zzcjcVar.f26379k;
        if (zzcjc.Y(zzcjnVar)) {
            zzeifVar = zzcjcVar.G;
        }
        zzcjcVar.a(new AdOverlayInfoParcel(zzaVar, zzcjbVar2, zzbmdVar, zzbmfVar, zzadVar, zzcjnVar, z, i2, str, versionInfoParcelZzs, zzdirVar, zzeifVar, z3));
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final void u() {
        if (this.K == null) {
            zzbgx zzbgxVar = this.L;
            zzbgxVar.getClass();
            zzbgw zzbgwVar = new zzbgw(com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime(), null, null);
            this.K = zzbgwVar;
            zzbgxVar.f25044a.put("native:view_load", zzbgwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void u0(zzbcj zzbcjVar) {
        boolean z;
        synchronized (this) {
            z = zzbcjVar.f24707j;
            this.B = z;
        }
        R0(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcii
    public final zzfhr v() {
        return this.f26432j;
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final synchronized void v0() {
        com.google.android.gms.ads.internal.zzn zznVar = this.f26428f;
        if (zznVar != null) {
            zznVar.v0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final ArrayList w() {
        return new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void w0() {
        this.n.f26380l = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzckm
    public final View x() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final int y() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized void y0(zzbdx zzbdxVar) {
        this.F = zzbdxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm z() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final zzcez z0() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzckj
    public final synchronized zzclb zzN() {
        return this.r;
    }

    @Override // com.google.android.gms.internal.ads.zzcir
    public final synchronized String zzO() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcfk
    public final synchronized zzcjx zzh() {
        return this.A;
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final zzbgw zzi() {
        return this.J;
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcfk
    public final Activity zzj() {
        return this.f26423a.f26469a;
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcfk
    public final com.google.android.gms.ads.internal.zza zzk() {
        return this.f26429g;
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final void zzl() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZ = z();
        if (zzmVarZ != null) {
            zzmVarZ.Zb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final synchronized String zzm() {
        return this.z;
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final synchronized String zzn() {
        zzfhu zzfhuVar = this.f26433k;
        if (zzfhuVar == null) {
            return null;
        }
        return zzfhuVar.f31167b;
    }

    @Override // com.google.android.gms.internal.ads.zzcfk
    public final synchronized int zzp() {
        return this.M;
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzcfk
    public final zzbgx zzq() {
        return this.L;
    }

    @Override // com.google.android.gms.internal.ads.zzcir, com.google.android.gms.internal.ads.zzckl, com.google.android.gms.internal.ads.zzcfk
    public final VersionInfoParcel zzs() {
        return this.f26427e;
    }
}
