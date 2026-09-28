package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
abstract class zzgxe extends zzgyd implements Runnable {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f33304k = 0;

    /* renamed from: h, reason: collision with root package name */
    public ListenableFuture f33305h;

    /* renamed from: i, reason: collision with root package name */
    public Class f33306i;

    /* renamed from: j, reason: collision with root package name */
    public Object f33307j;

    public zzgxe(ListenableFuture listenableFuture, Class cls, Object obj) {
        listenableFuture.getClass();
        this.f33305h = listenableFuture;
        this.f33306i = cls;
        this.f33307j = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final void e() {
        n(this.f33305h);
        this.f33305h = null;
        this.f33306i = null;
        this.f33307j = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final String f() {
        String strS;
        ListenableFuture listenableFuture = this.f33305h;
        Class cls = this.f33306i;
        Object obj = this.f33307j;
        String strF = super.f();
        if (listenableFuture != null) {
            String string = listenableFuture.toString();
            strS = android.support.v4.media.b.s(new StringBuilder(string.length() + 16), "inputFuture=[", string, "], ");
        } else {
            strS = "";
        }
        if (cls == null || obj == null) {
            if (strF != null) {
                return strS.concat(strF);
            }
            return null;
        }
        int length = strS.length();
        String string2 = cls.toString();
        int length2 = string2.length();
        String string3 = obj.toString();
        StringBuilder sb = new StringBuilder(string3.length() + length + 15 + length2 + 13 + 1);
        android.support.v4.media.b.B(sb, strS, "exceptionType=[", string2, "], fallback=[");
        return android.support.v4.media.b.r(sb, string3, "]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.f33305h;
        Class cls = this.f33306i;
        Object obj = this.f33307j;
        if (((obj == null) || ((listenableFuture == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.f33305h = null;
        try {
            th = listenableFuture instanceof zzgzo ? ((zzgzo) listenableFuture).a() : null;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause == null) {
                String strValueOf = String.valueOf(listenableFuture.getClass());
                String strValueOf2 = String.valueOf(e2.getClass());
                StringBuilder sb = new StringBuilder(strValueOf2.length() + strValueOf.length() + 19 + 16);
                android.support.v4.media.b.B(sb, "Future type ", strValueOf, " threw ", strValueOf2);
                sb.append(" without a cause");
                cause = new NullPointerException(sb.toString());
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        Object objL = th == null ? zzgym.l(listenableFuture) : null;
        if (th == null) {
            c(objL);
            return;
        }
        if (!cls.isInstance(th)) {
            m(listenableFuture);
            return;
        }
        try {
            Object objU = u(obj, th);
            this.f33306i = null;
            this.f33307j = null;
            t(objU);
        } catch (Throwable th2) {
            try {
                if (th2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                d(th2);
            } finally {
                this.f33306i = null;
                this.f33307j = null;
            }
        }
    }

    public abstract void t(Object obj);

    public abstract Object u(Object obj, Throwable th);
}
