package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
abstract class zzgxl extends zzgyd implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f33342j = 0;

    /* renamed from: h, reason: collision with root package name */
    public ListenableFuture f33343h;

    /* renamed from: i, reason: collision with root package name */
    public Object f33344i;

    public zzgxl(ListenableFuture listenableFuture, Object obj) {
        listenableFuture.getClass();
        this.f33343h = listenableFuture;
        this.f33344i = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final void e() {
        n(this.f33343h);
        this.f33343h = null;
        this.f33344i = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final String f() {
        String strS;
        ListenableFuture listenableFuture = this.f33343h;
        Object obj = this.f33344i;
        String strF = super.f();
        if (listenableFuture != null) {
            String string = listenableFuture.toString();
            strS = android.support.v4.media.b.s(new StringBuilder(string.length() + 16), "inputFuture=[", string, "], ");
        } else {
            strS = "";
        }
        if (obj == null) {
            if (strF != null) {
                return strS.concat(strF);
            }
            return null;
        }
        int length = strS.length();
        String string2 = obj.toString();
        return android.support.v4.media.a.n(new StringBuilder(string2.length() + length + 10 + 1), strS, "function=[", string2, "]");
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.f33343h;
        Object obj = this.f33344i;
        if ((isCancelled() | (listenableFuture == null)) || (obj == null)) {
            return;
        }
        this.f33343h = null;
        if (listenableFuture.isCancelled()) {
            m(listenableFuture);
            return;
        }
        try {
            try {
                Object objU = u(obj, zzgym.l(listenableFuture));
                this.f33344i = null;
                t(objU);
            } catch (Throwable th) {
                try {
                    if (th instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    d(th);
                } finally {
                    this.f33344i = null;
                }
            }
        } catch (Error e2) {
            d(e2);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e3) {
            d(e3.getCause());
        } catch (Exception e4) {
            d(e4);
        }
    }

    public abstract void t(Object obj);

    public abstract Object u(Object obj, Object obj2);
}
