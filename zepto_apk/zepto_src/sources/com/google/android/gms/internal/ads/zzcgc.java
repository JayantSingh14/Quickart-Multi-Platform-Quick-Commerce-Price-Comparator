package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import in.juspay.hyperutil.constants.LogLevel;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzcgc extends zzceq implements TextureView.SurfaceTextureListener, zzcfa {

    /* renamed from: c, reason: collision with root package name */
    public final zzcir f26141c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcfl f26142d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcfj f26143e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdxe f26144f;

    /* renamed from: g, reason: collision with root package name */
    public zzcey f26145g;

    /* renamed from: h, reason: collision with root package name */
    public Surface f26146h;

    /* renamed from: i, reason: collision with root package name */
    public zzchz f26147i;

    /* renamed from: j, reason: collision with root package name */
    public String f26148j;

    /* renamed from: k, reason: collision with root package name */
    public String[] f26149k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f26150l;

    /* renamed from: m, reason: collision with root package name */
    public int f26151m;
    public zzcfi n;
    public final boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public float t;

    public zzcgc(Context context, zzcfl zzcflVar, zzcir zzcirVar, boolean z, zzcfj zzcfjVar, zzdxe zzdxeVar) {
        super(context);
        this.f26151m = 1;
        this.f26141c = zzcirVar;
        this.f26142d = zzcflVar;
        this.o = z;
        this.f26143e = zzcfjVar;
        zzcflVar.a(this);
        this.f26144f = zzdxeVar;
    }

    public static String I(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1 + String.valueOf(message).length());
        android.support.v4.media.b.B(sb, str, "/", canonicalName, ":");
        sb.append(message);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void A(int i2) {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            zzchzVar.r(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void B(int i2) {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            zzchzVar.s(i2);
        }
    }

    public final boolean C() {
        zzchz zzchzVar = this.f26147i;
        return (zzchzVar == null || !zzchzVar.p() || this.f26150l) ? false : true;
    }

    public final boolean D() {
        return C() && this.f26151m != 1;
    }

    public final void E(Integer num, boolean z) {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null && !z) {
            zzchzVar.s = num;
            return;
        }
        if (this.f26148j == null || this.f26146h == null) {
            return;
        }
        if (z) {
            if (!C()) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f("No valid ExoPlayerAdapter exists when switch source.");
                return;
            } else {
                zzchzVar.B();
                F();
            }
        }
        if (this.f26148j.startsWith("cache:")) {
            zzcgx zzcgxVarJ = this.f26141c.j(this.f26148j);
            if (zzcgxVarJ instanceof zzchg) {
                zzchg zzchgVar = (zzchg) zzcgxVarJ;
                synchronized (zzchgVar) {
                    zzchgVar.f26246g = true;
                    zzchgVar.notify();
                }
                zzchz zzchzVar2 = zzchgVar.f26243d;
                zzchzVar2.f26312l = null;
                zzchgVar.f26243d = null;
                this.f26147i = zzchzVar2;
                zzchzVar2.s = num;
                if (!zzchzVar2.p()) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzcgxVarJ instanceof zzchd)) {
                    String strValueOf = String.valueOf(this.f26148j);
                    int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Stream cache miss: ".concat(strValueOf));
                    return;
                }
                zzchd zzchdVar = (zzchd) zzcgxVarJ;
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                zzcir zzcirVar = this.f26141c;
                zzsVar.E(zzcirVar.getContext(), zzcirVar.zzs().f21400a);
                synchronized (zzchdVar.f26236k) {
                    try {
                        ByteBuffer byteBuffer = zzchdVar.f26234i;
                        if (byteBuffer != null && !zzchdVar.f26235j) {
                            byteBuffer.flip();
                            zzchdVar.f26235j = true;
                        }
                        zzchdVar.f26231f = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                ByteBuffer byteBuffer2 = zzchdVar.f26234i;
                boolean z2 = zzchdVar.n;
                String str = zzchdVar.f26229d;
                if (str == null) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Stream cache URL is null.");
                    return;
                }
                zzcir zzcirVar2 = this.f26141c;
                zzchz zzchzVar3 = new zzchz(zzcirVar2.getContext(), this.f26143e, zzcirVar2, num);
                int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.e("ExoPlayerAdapter initialized.");
                this.f26147i = zzchzVar3;
                zzchzVar3.z(new Uri[]{Uri.parse(str)}, byteBuffer2, z2);
            }
        } else {
            zzcir zzcirVar3 = this.f26141c;
            zzchz zzchzVar4 = new zzchz(zzcirVar3.getContext(), this.f26143e, zzcirVar3, num);
            int i7 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e("ExoPlayerAdapter initialized.");
            this.f26147i = zzchzVar4;
            com.google.android.gms.ads.internal.util.zzs zzsVar2 = com.google.android.gms.ads.internal.zzt.C.f21679c;
            zzcir zzcirVar4 = this.f26141c;
            String strE = zzsVar2.E(zzcirVar4.getContext(), zzcirVar4.zzs().f21400a);
            Uri[] uriArr = new Uri[this.f26149k.length];
            int i8 = 0;
            while (true) {
                String[] strArr = this.f26149k;
                if (i8 >= strArr.length) {
                    break;
                }
                uriArr[i8] = Uri.parse(strArr[i8]);
                i8++;
            }
            this.f26147i.y(uriArr, strE);
        }
        this.f26147i.f26312l = this;
        G(this.f26146h, false);
        if (this.f26147i.p()) {
            int iZzh = this.f26147i.f26309i.zzh();
            this.f26151m = iZzh;
            if (iZzh == 3) {
                H();
            }
        }
    }

    public final void F() {
        if (this.f26147i != null) {
            G(null, true);
            zzchz zzchzVar = this.f26147i;
            if (zzchzVar != null) {
                zzchzVar.f26312l = null;
                zzchzVar.A();
                this.f26147i = null;
            }
            this.f26151m = 1;
            this.f26150l = false;
            this.p = false;
            this.q = false;
        }
    }

    public final void G(Surface surface, boolean z) {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzms zzmsVar = zzchzVar.f26309i;
            if (zzmsVar != null) {
                zzmsVar.f35227c.b();
                zzkp zzkpVar = zzmsVar.f35226b;
                zzkpVar.o();
                zzkpVar.m(surface);
                int i3 = surface == null ? 0 : -1;
                zzkpVar.n(i3, i3);
            }
        } catch (IOException e2) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("", e2);
        }
    }

    public final void H() {
        if (this.p) {
            return;
        }
        this.p = true;
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfp
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26119a.f26145g;
                if (zzceyVar != null) {
                    zzceyVar.f();
                }
            }
        });
        zzq();
        zzcfl zzcflVar = this.f26142d;
        if (zzcflVar.f26106i && !zzcflVar.f26107j) {
            zzbgr.a(zzcflVar.f26102e, zzcflVar.f26101d, "vfr2");
            zzcflVar.f26107j = true;
        }
        if (this.q) {
            m();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void K(int i2) {
        zzchz zzchzVar;
        if (this.f26151m != i2) {
            this.f26151m = i2;
            if (i2 == 3) {
                H();
                return;
            }
            if (i2 != 4) {
                return;
            }
            if (this.f26143e.f26085a && (zzchzVar = this.f26147i) != null) {
                zzchzVar.w(false);
            }
            this.f26142d.f26110m = false;
            zzcfo zzcfoVar = this.f26029b;
            zzcfoVar.f26116d = false;
            zzcfoVar.a();
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfs
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcey zzceyVar = this.f26123a.f26145g;
                    if (zzceyVar != null) {
                        zzceyVar.i();
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void a(final long j2, final boolean z) {
        if (this.f26141c != null) {
            ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcga
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f26137a.f26141c.R(j2, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void b(int i2, int i3) {
        this.r = i2;
        this.s = i3;
        float f2 = i3 > 0 ? i2 / i3 : 1.0f;
        if (this.t != f2) {
            this.t = f2;
            requestLayout();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void c(String str, Exception exc) {
        zzchz zzchzVar;
        final String strI = I(str, exc);
        String strConcat = "ExoPlayerAdapter error: ".concat(strI);
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
        this.f26150l = true;
        if (this.f26143e.f26085a && (zzchzVar = this.f26147i) != null) {
            zzchzVar.w(false);
        }
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcft
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26124a.f26145g;
                if (zzceyVar != null) {
                    zzceyVar.j("ExoPlayerAdapter error", strI);
                }
            }
        });
        com.google.android.gms.ads.internal.zzt.C.f21684h.e("AdExoPlayerView.onError", exc);
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void d(IOException iOException) {
        final String strI = I("onLoadException", iOException);
        String strConcat = "ExoPlayerAdapter exception: ".concat(strI);
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
        com.google.android.gms.ads.internal.zzt.C.f21684h.e("AdExoPlayerView.onException", iOException);
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfq
            @Override // java.lang.Runnable
            public final void run() {
                zzcey zzceyVar = this.f26120a.f26145g;
                if (zzceyVar != null) {
                    zzceyVar.c(LogLevel.EXCEPTION, "what", "ExoPlayerAdapter exception", "extra", strI);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void e(int i2) {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            zzchzVar.C(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void f(int i2) {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            zzchzVar.D(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void g(int i2) throws SocketException {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            Iterator it = zzchzVar.v.iterator();
            while (it.hasNext()) {
                zzchi zzchiVar = (zzchi) ((WeakReference) it.next()).get();
                if (zzchiVar != null) {
                    zzchiVar.r = i2;
                    Iterator it2 = zzchiVar.s.iterator();
                    while (it2.hasNext()) {
                        Socket socket = (Socket) it2.next();
                        if (!socket.isClosed()) {
                            try {
                                socket.setReceiveBufferSize(zzchiVar.r);
                            } catch (SocketException e2) {
                                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                com.google.android.gms.ads.internal.util.client.zzo.g("Failed to update receive buffer size.", e2);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final String h() {
        return "ExoPlayer/2".concat(true != this.o ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void i(zzcey zzceyVar) {
        this.f26145g = zzceyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void j(String str) {
        if (str != null) {
            z(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfa
    public final void k() {
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26122a.f26145g;
                if (zzceyVar != null) {
                    zzceyVar.m();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void l() {
        if (C()) {
            this.f26147i.B();
            F();
        }
        zzcfl zzcflVar = this.f26142d;
        zzcflVar.f26110m = false;
        zzcfo zzcfoVar = this.f26029b;
        zzcfoVar.f26116d = false;
        zzcfoVar.a();
        zzcflVar.b();
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void m() {
        zzchz zzchzVar;
        if (!D()) {
            this.q = true;
            return;
        }
        if (this.f26143e.f26085a && (zzchzVar = this.f26147i) != null) {
            zzchzVar.w(true);
        }
        this.f26147i.q(true);
        this.f26142d.d();
        zzcfo zzcfoVar = this.f26029b;
        zzcfoVar.f26116d = true;
        zzcfoVar.a();
        this.f26028a.f26063c = true;
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26126a.f26145g;
                if (zzceyVar != null) {
                    zzceyVar.g();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void n() {
        zzchz zzchzVar;
        if (D()) {
            if (this.f26143e.f26085a && (zzchzVar = this.f26147i) != null) {
                zzchzVar.w(false);
            }
            this.f26147i.q(false);
            this.f26142d.f26110m = false;
            zzcfo zzcfoVar = this.f26029b;
            zzcfoVar.f26116d = false;
            zzcfoVar.a();
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcey zzceyVar = this.f26127a.f26145g;
                    if (zzceyVar != null) {
                        zzceyVar.h();
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int o() {
        if (D()) {
            return (int) this.f26147i.f26309i.c();
        }
        return 0;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSurfaceTextureListener(this);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = this.t;
        if (f2 != 0.0f && this.n == null) {
            float f3 = measuredWidth;
            float f4 = f3 / measuredHeight;
            if (f2 > f4) {
                measuredHeight = (int) (f3 / f2);
            }
            if (f2 < f4) {
                measuredWidth = (int) (measuredHeight * f2);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcfi zzcfiVar = this.n;
        if (zzcfiVar != null) {
            zzcfiVar.a(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) throws InterruptedException {
        zzchz zzchzVar;
        float f2;
        int i4;
        SurfaceTexture surfaceTexture2;
        zzdxe zzdxeVar;
        if (this.o) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.te)).booleanValue() && (zzdxeVar = this.f26144f) != null) {
                zzdxd zzdxdVarA = zzdxeVar.a();
                zzdxdVarA.b("action", "svp_aepv");
                zzdxdVarA.c();
            }
            zzcfi zzcfiVar = new zzcfi(getContext());
            this.n = zzcfiVar;
            zzcfiVar.f26084m = i2;
            zzcfiVar.f26083l = i3;
            zzcfiVar.o = surfaceTexture;
            zzcfiVar.start();
            if (zzcfiVar.o == null) {
                surfaceTexture2 = null;
            } else {
                try {
                    zzcfiVar.t.await();
                } catch (InterruptedException unused) {
                }
                surfaceTexture2 = zzcfiVar.n;
            }
            if (surfaceTexture2 != null) {
                surfaceTexture = surfaceTexture2;
            } else {
                this.n.b();
                this.n = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.f26146h = surface;
        if (this.f26147i == null) {
            E(null, false);
        } else {
            G(surface, true);
            if (!this.f26143e.f26085a && (zzchzVar = this.f26147i) != null) {
                zzchzVar.w(true);
            }
        }
        int i5 = this.r;
        if (i5 == 0 || (i4 = this.s) == 0) {
            f2 = i3 > 0 ? i2 / i3 : 1.0f;
            if (this.t != f2) {
                this.t = f2;
                requestLayout();
            }
        } else {
            f2 = i4 > 0 ? i5 / i4 : 1.0f;
            if (this.t != f2) {
                this.t = f2;
                requestLayout();
            }
        }
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26128a.f26145g;
                if (zzceyVar != null) {
                    zzceyVar.e();
                }
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        n();
        zzcfi zzcfiVar = this.n;
        if (zzcfiVar != null) {
            zzcfiVar.b();
            this.n = null;
        }
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            if (zzchzVar != null) {
                zzchzVar.w(false);
            }
            Surface surface = this.f26146h;
            if (surface != null) {
                surface.release();
            }
            this.f26146h = null;
            G(null, true);
        }
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26132a.f26145g;
                if (zzceyVar != null) {
                    zzceyVar.k();
                }
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i2, final int i3) {
        zzcfi zzcfiVar = this.n;
        if (zzcfiVar != null) {
            zzcfiVar.a(i2, i3);
        }
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26129a.f26145g;
                if (zzceyVar != null) {
                    zzceyVar.l(i2, i3);
                }
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f26142d.c(this);
        this.f26028a.a(surfaceTexture, this.f26145g);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(final int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 46);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26133a.f26145g;
                if (zzceyVar != null) {
                    zzceyVar.onWindowVisibilityChanged(i2);
                }
            }
        });
        super.onWindowVisibilityChanged(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int p() {
        if (D()) {
            return (int) this.f26147i.f26309i.d();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void q(int i2) {
        if (D()) {
            long j2 = i2;
            zzms zzmsVar = this.f26147i.f26309i;
            int iZzs = zzmsVar.zzs();
            zzmsVar.f35227c.b();
            zzkp zzkpVar = zzmsVar.f35226b;
            zzkpVar.o();
            if (iZzs == -1) {
                return;
            }
            zzgqa.a(iZzs >= 0);
            zzbf zzbfVar = zzkpVar.X.f35179a;
            if (zzbfVar.g() || iZzs < zzbfVar.a()) {
                zzoz zzozVar = zzkpVar.r;
                if (!zzozVar.f35276i) {
                    zzmv zzmvVarL = zzozVar.l();
                    zzozVar.f35276i = true;
                    zzozVar.k(zzmvVarL, -1, new zznj());
                }
                zzkpVar.D++;
                if (zzkpVar.v()) {
                    zzee.c("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                    zzkz zzkzVar = new zzkz(zzkpVar.X);
                    zzkzVar.a(1);
                    ((zzjm) zzkpVar.f35044k).a(zzkzVar);
                    return;
                }
                zzma zzmaVarD = zzkpVar.X;
                int i3 = zzmaVarD.f35183e;
                if (i3 == 3 || (i3 == 4 && !zzbfVar.g())) {
                    zzmaVarD = zzkpVar.X.d(2);
                }
                int iZzs2 = zzkpVar.zzs();
                zzma zzmaVarJ = zzkpVar.j(zzmaVarD, zzbfVar, zzkpVar.l(zzbfVar, iZzs, j2));
                long jS = zzfj.s(j2);
                zzlc zzlcVar = zzkpVar.f35045l;
                zzlcVar.getClass();
                ((zzfd) zzlcVar.f35075h.g(3, new zzlb(zzbfVar, iZzs, jS))).a();
                zzkpVar.h(zzmaVarJ, 0, true, 1, zzkpVar.g(zzmaVarJ), iZzs2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void r(float f2, float f3) {
        zzcfi zzcfiVar = this.n;
        if (zzcfiVar != null) {
            zzcfiVar.c(f2, f3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int s() {
        return this.r;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int t() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final long u() {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            return zzchzVar.t();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final long v() {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            return zzchzVar.u();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final long w() {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            return zzchzVar.v();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int x() {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            return zzchzVar.n;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final Integer y() {
        zzchz zzchzVar = this.f26147i;
        if (zzchzVar != null) {
            return zzchzVar.s;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void z(String str, String[] strArr, Integer num) {
        if (str == null) {
            return;
        }
        if (strArr == null) {
            this.f26149k = new String[]{str};
        } else {
            this.f26149k = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.f26148j;
        boolean z = false;
        if (this.f26143e.f26095k && str2 != null && !str.equals(str2) && this.f26151m == 4) {
            z = true;
        }
        this.f26148j = str;
        E(num, z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfn
    public final void zzq() {
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgb
            @Override // java.lang.Runnable
            public final void run() {
                zzcgc zzcgcVar = this.f26140a;
                zzcfo zzcfoVar = zzcgcVar.f26029b;
                float f2 = zzcfoVar.f26115c ? zzcfoVar.f26117e ? 0.0f : zzcfoVar.f26118f : 0.0f;
                zzchz zzchzVar = zzcgcVar.f26147i;
                if (zzchzVar == null) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Trying to set volume before player is initialized.");
                    return;
                }
                try {
                    zzms zzmsVar = zzchzVar.f26309i;
                    if (zzmsVar != null) {
                        zzmsVar.f35227c.b();
                        zzmsVar.f35226b.b(f2);
                    }
                } catch (IOException e2) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.g("", e2);
                }
            }
        });
    }
}
