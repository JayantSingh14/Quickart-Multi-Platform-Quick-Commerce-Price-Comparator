package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzcey extends FrameLayout implements zzcep {

    /* renamed from: a, reason: collision with root package name */
    public final zzcir f26038a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f26039b;

    /* renamed from: c, reason: collision with root package name */
    public final View f26040c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbgz f26041d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcfm f26042e;

    /* renamed from: f, reason: collision with root package name */
    public final long f26043f;

    /* renamed from: g, reason: collision with root package name */
    public final zzceq f26044g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f26045h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f26046i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f26047j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f26048k;

    /* renamed from: l, reason: collision with root package name */
    public long f26049l;

    /* renamed from: m, reason: collision with root package name */
    public long f26050m;
    public String n;
    public String[] o;
    public Bitmap p;
    public final ImageView q;
    public boolean r;

    public zzcey(Context context, zzcir zzcirVar, int i2, boolean z, zzbgz zzbgzVar, zzcfj zzcfjVar, zzdxe zzdxeVar) {
        zzceq zzceoVar;
        zzceq zzcigVar;
        super(context);
        this.f26038a = zzcirVar;
        this.f26041d = zzbgzVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f26039b = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzcirVar.zzk());
        zzcfc zzcfcVar = zzcirVar.zzk().f21621a;
        zzcfl zzcflVar = new zzcfl(context, zzcirVar.zzs(), zzcirVar.zzm(), zzbgzVar, zzcirVar.zzi());
        if (i2 == 3) {
            zzcigVar = new zzcig(context, zzcflVar);
        } else {
            if (i2 == 2) {
                zzcirVar.zzN().getClass();
                zzceoVar = new zzcgc(context, zzcflVar, zzcirVar, z, zzcfjVar, zzdxeVar);
            } else {
                zzceoVar = new zzceo(context, zzcirVar, z, zzcirVar.zzN().b(), new zzcfl(context, zzcirVar.zzs(), zzcirVar.zzm(), zzbgzVar, zzcirVar.zzi()), zzdxeVar);
            }
            zzcigVar = zzceoVar;
        }
        this.f26044g = zzcigVar;
        View view = new View(context);
        this.f26040c = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzcigVar, new FrameLayout.LayoutParams(-1, -1, 17));
        zzbgb zzbgbVar = zzbgk.e0;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.b0)).booleanValue()) {
            a();
        }
        this.q = new ImageView(context);
        this.f26043f = ((Long) zzbdVar.f21153c.a(zzbgk.g0)).longValue();
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgk.d0)).booleanValue();
        this.f26048k = zBooleanValue;
        zzbgzVar.c("spinner_used", true != zBooleanValue ? "0" : "1");
        this.f26042e = new zzcfm(this);
        zzcigVar.i(this);
    }

    public final void a() {
        zzceq zzceqVar = this.f26044g;
        if (zzceqVar == null) {
            return;
        }
        TextView textView = new TextView(zzceqVar.getContext());
        Resources resourcesC = com.google.android.gms.ads.internal.zzt.C.f21684h.c();
        textView.setText(String.valueOf(resourcesC == null ? "AdMob - " : resourcesC.getString(R.string.watermark_label_prefix)).concat(zzceqVar.h()));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        FrameLayout frameLayout = this.f26039b;
        frameLayout.addView(textView, layoutParams);
        frameLayout.bringChildToFront(textView);
    }

    public final void b() {
        zzceq zzceqVar = this.f26044g;
        if (zzceqVar == null) {
            return;
        }
        long jP = zzceqVar.p();
        if (this.f26049l == jP || jP <= 0) {
            return;
        }
        float f2 = jP / 1000.0f;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue()) {
            c("timeupdate", "time", String.valueOf(f2), "totalBytes", String.valueOf(zzceqVar.w()), "qoeCachedBytes", String.valueOf(zzceqVar.v()), "qoeLoadedBytes", String.valueOf(zzceqVar.u()), "droppedFrames", String.valueOf(zzceqVar.x()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis()));
        } else {
            c("timeupdate", "time", String.valueOf(f2));
        }
        this.f26049l = jP;
    }

    public final void c(String str, String... strArr) {
        HashMap map = new HashMap();
        zzceq zzceqVar = this.f26044g;
        Integer numY = zzceqVar != null ? zzceqVar.y() : null;
        if (numY != null) {
            map.put("playerId", numY.toString());
        }
        map.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.f26038a.g("onVideoEvent", map);
    }

    public final void d() {
        zzcir zzcirVar = this.f26038a;
        if (zzcirVar.zzj() == null || !this.f26046i || this.f26047j) {
            return;
        }
        zzcirVar.zzj().getWindow().clearFlags(128);
        this.f26046i = false;
    }

    public final void e() {
        zzcfm zzcfmVar = this.f26042e;
        zzcfmVar.f26112b = false;
        com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
        zzfVar.removeCallbacks(zzcfmVar);
        zzfVar.postDelayed(zzcfmVar, 250L);
        zzfVar.post(new zzces(this));
    }

    public final void f() {
        zzceq zzceqVar = this.f26044g;
        if (zzceqVar != null && this.f26050m == 0) {
            c("canplaythrough", "duration", String.valueOf(zzceqVar.o() / 1000.0f), "videoWidth", String.valueOf(zzceqVar.s()), "videoHeight", String.valueOf(zzceqVar.t()));
        }
    }

    public final void finalize() throws Throwable {
        try {
            this.f26042e.a();
            final zzceq zzceqVar = this.f26044g;
            if (zzceqVar != null) {
                ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcev
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzceqVar.l();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    public final void g() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.n2)).booleanValue()) {
            zzcfm zzcfmVar = this.f26042e;
            zzcfmVar.f26112b = false;
            com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
            zzfVar.removeCallbacks(zzcfmVar);
            zzfVar.postDelayed(zzcfmVar, 250L);
        }
        zzcir zzcirVar = this.f26038a;
        if (zzcirVar.zzj() != null && !this.f26046i) {
            boolean z = (zzcirVar.zzj().getWindow().getAttributes().flags & 128) != 0;
            this.f26047j = z;
            if (!z) {
                zzcirVar.zzj().getWindow().addFlags(128);
                this.f26046i = true;
            }
        }
        this.f26045h = true;
    }

    public final void h() {
        c(CLConstants.CRED_SUB_TYPE_MANDATE_PAUSE, new String[0]);
        d();
        this.f26045h = false;
    }

    public final void i() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.n2)).booleanValue()) {
            this.f26042e.a();
        }
        c("ended", new String[0]);
        d();
    }

    public final void j(String str, String str2) {
        c("error", "what", str, "extra", str2);
    }

    public final void k() {
        if (this.r && this.p != null) {
            ImageView imageView = this.q;
            if (imageView.getParent() == null) {
                imageView.setImageBitmap(this.p);
                imageView.invalidate();
                FrameLayout frameLayout = this.f26039b;
                frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.bringChildToFront(imageView);
            }
        }
        this.f26042e.a();
        this.f26050m = this.f26049l;
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzcet(this));
    }

    public final void l(int i2, int i3) {
        if (this.f26048k) {
            zzbgb zzbgbVar = zzbgk.f0;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            int iMax = Math.max(i2 / ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue(), 1);
            int iMax2 = Math.max(i3 / ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue(), 1);
            Bitmap bitmap = this.p;
            if (bitmap != null && bitmap.getWidth() == iMax && this.p.getHeight() == iMax2) {
                return;
            }
            this.p = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.r = false;
        }
    }

    public final void m() {
        this.f26040c.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcew
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f26035a.c("firstFrameRendered", new String[0]);
            }
        });
    }

    public final void n(int i2, int i3, int i4, int i5) {
        if (com.google.android.gms.ads.internal.util.zze.m()) {
            int length = String.valueOf(i2).length();
            StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(i3).length() + 3 + String.valueOf(i4).length() + 3 + String.valueOf(i5).length());
            androidx.fragment.app.e.w(i2, i3, "Set video bounds to x:", ";y:", sb);
            sb.append(";w:");
            sb.append(i4);
            sb.append(";h:");
            sb.append(i5);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
        if (i4 == 0 || i5 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
        layoutParams.setMargins(i2, i3, 0, 0);
        this.f26039b.setLayoutParams(layoutParams);
        requestLayout();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        zzcfm zzcfmVar = this.f26042e;
        if (z) {
            zzcfmVar.f26112b = false;
            com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
            zzfVar.removeCallbacks(zzcfmVar);
            zzfVar.postDelayed(zzcfmVar, 250L);
        } else {
            zzcfmVar.a();
            this.f26050m = this.f26049l;
        }
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcex
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26036a;
                zzceyVar.getClass();
                zzceyVar.c("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
            }
        });
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        boolean z = false;
        zzcfm zzcfmVar = this.f26042e;
        if (i2 == 0) {
            zzcfmVar.f26112b = false;
            com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
            zzfVar.removeCallbacks(zzcfmVar);
            zzfVar.postDelayed(zzcfmVar, 250L);
            z = true;
        } else {
            zzcfmVar.a();
            this.f26050m = this.f26049l;
        }
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzceu(this, z));
    }
}
