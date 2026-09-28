package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbdk extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public boolean f24784a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f24785b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f24786c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbdb f24787d;

    /* renamed from: e, reason: collision with root package name */
    public final int f24788e;

    /* renamed from: f, reason: collision with root package name */
    public final int f24789f;

    /* renamed from: g, reason: collision with root package name */
    public final int f24790g;

    /* renamed from: h, reason: collision with root package name */
    public final int f24791h;

    /* renamed from: i, reason: collision with root package name */
    public final int f24792i;

    /* renamed from: j, reason: collision with root package name */
    public final int f24793j;

    /* renamed from: k, reason: collision with root package name */
    public final int f24794k;

    /* renamed from: l, reason: collision with root package name */
    public final int f24795l;

    /* renamed from: m, reason: collision with root package name */
    public final String f24796m;
    public final boolean n;
    public final boolean o;

    public zzbdk() {
        zzbdb zzbdbVar = new zzbdb();
        this.f24784a = false;
        this.f24785b = false;
        this.f24787d = zzbdbVar;
        this.f24786c = new Object();
        this.f24789f = ((Long) zzbib.f25118d.c()).intValue();
        this.f24790g = ((Long) zzbib.f25115a.c()).intValue();
        this.f24791h = ((Long) zzbib.f25119e.c()).intValue();
        this.f24792i = ((Long) zzbib.f25117c.c()).intValue();
        zzbgb zzbgbVar = zzbgk.r0;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        this.f24793j = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
        zzbgb zzbgbVar2 = zzbgk.s0;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        this.f24794k = ((Integer) zzbgiVar.a(zzbgbVar2)).intValue();
        this.f24795l = ((Integer) zzbgiVar.a(zzbgk.t0)).intValue();
        this.f24788e = ((Long) zzbib.f25120f.c()).intValue();
        this.f24796m = (String) zzbgiVar.a(zzbgk.v0);
        this.n = ((Boolean) zzbgiVar.a(zzbgk.w0)).booleanValue();
        this.o = ((Boolean) zzbgiVar.a(zzbgk.x0)).booleanValue();
        ((Boolean) zzbgiVar.a(zzbgk.y0)).getClass();
        setName("ContentFetchTask");
    }

    public final zzbdj a(View view, zzbda zzbdaVar) {
        if (view == null) {
            return new zzbdj(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzbdj(this, 0, 0);
            }
            zzbdaVar.c(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzbdj(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzcir)) {
            WebView webView = (WebView) view;
            synchronized (zzbdaVar.f24749g) {
                zzbdaVar.f24755m++;
            }
            webView.post(new zzbdi(this, zzbdaVar, webView, globalVisibleRect));
            return new zzbdj(this, 0, 1);
        }
        if (!(view instanceof ViewGroup)) {
            return new zzbdj(this, 0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            zzbdj zzbdjVarA = a(viewGroup.getChildAt(i4), zzbdaVar);
            i2 += zzbdjVarA.f24782a;
            i3 += zzbdjVarA.f24783b;
        }
        return new zzbdj(this, i2, i3);
    }

    public final void b() {
        synchronized (this.f24786c) {
            this.f24785b = true;
            StringBuilder sb = new StringBuilder(40);
            sb.append("ContentFetchThread: paused, pause = true");
            String string = sb.toString();
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a(string);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        if (r4.importance != 100) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        if (r3.inKeyguardRestrictedInputMode() != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
    
        r0 = (android.os.PowerManager) r0.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        if (r0.isScreenOn() == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        r0 = com.google.android.gms.ads.internal.zzt.C.f21683g.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        if (r0 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        r1 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("ContentFetchThread: no activity. Sleeping.");
        b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0079, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:
    
        if (r0.getWindow() == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008b, code lost:
    
        if (r0.getWindow().getDecorView() == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        r2 = r0.getWindow().getDecorView().findViewById(android.R.id.content);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009e, code lost:
    
        com.google.android.gms.ads.internal.zzt.C.f21684h.d("ContentFetchTask.extractContent", r0);
        r1 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00da, code lost:
    
        r1 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.d("Error in ContentFetchTask", r0);
        com.google.android.gms.ads.internal.zzt.C.f21684h.d("ContentFetchTask.run", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00eb, code lost:
    
        r1 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.d("Error in ContentFetchTask", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c7 A[Catch: Exception -> 0x0079, InterruptedException -> 0x007b, TryCatch #7 {InterruptedException -> 0x007b, Exception -> 0x0079, blocks: (B:31:0x0064, B:33:0x006e, B:57:0x00d1, B:48:0x00b0, B:46:0x009e, B:56:0x00c7, B:55:0x00be, B:39:0x007d, B:41:0x0083, B:43:0x008d, B:2:0x0000, B:3:0x0006, B:13:0x0016, B:16:0x002a, B:18:0x0030, B:19:0x0034, B:21:0x003a, B:23:0x0048, B:25:0x004e, B:27:0x0054, B:29:0x005e, B:54:0x00bd, B:4:0x0007, B:6:0x000c, B:7:0x000e, B:9:0x0010), top: B:84:0x0064, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f5 A[EXC_TOP_SPLITTER, LOOP:2: B:78:0x00f5->B:91:0x00f5, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdk.run():void");
    }
}
