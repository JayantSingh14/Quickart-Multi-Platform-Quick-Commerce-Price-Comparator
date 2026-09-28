package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@SuppressLint({"HandlerLeak"})
/* loaded from: classes4.dex */
final class zzaau extends Handler implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final zzaav f22613a;

    /* renamed from: b, reason: collision with root package name */
    public zzaar f22614b;

    /* renamed from: c, reason: collision with root package name */
    public IOException f22615c;

    /* renamed from: d, reason: collision with root package name */
    public int f22616d;

    /* renamed from: e, reason: collision with root package name */
    public Thread f22617e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22618f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f22619g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzaaz f22620h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaau(zzaaz zzaazVar, Looper looper, zzaav zzaavVar, zzaar zzaarVar, long j2) {
        super(looper);
        Objects.requireNonNull(zzaazVar);
        this.f22620h = zzaazVar;
        this.f22613a = zzaavVar;
        this.f22614b = zzaarVar;
    }

    public final void a(boolean z) {
        this.f22619g = z;
        this.f22615c = null;
        if (hasMessages(1)) {
            this.f22618f = true;
            removeMessages(1);
            if (!z) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                try {
                    this.f22618f = true;
                    ((zzxb) this.f22613a).f35811g = true;
                    Thread thread = this.f22617e;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            this.f22620h.f22625b = null;
            SystemClock.elapsedRealtime();
            zzaar zzaarVar = this.f22614b;
            zzaarVar.getClass();
            ((zzxk) zzaarVar).k(this.f22613a, true);
            this.f22614b = null;
        }
    }

    public final void b() {
        zzvx zzvxVar;
        SystemClock.elapsedRealtime();
        zzaar zzaarVar = this.f22614b;
        zzaarVar.getClass();
        zzaav zzaavVar = this.f22613a;
        int i2 = this.f22616d;
        zzxk zzxkVar = (zzxk) zzaarVar;
        zzxb zzxbVar = (zzxb) zzaavVar;
        zzhy zzhyVar = zzxbVar.f35806b;
        if (i2 == 0) {
            Uri uri = zzxbVar.f35814j.f33691a;
            Map map = Collections.EMPTY_MAP;
            zzvxVar = new zzvx();
        } else {
            Uri uri2 = zzhyVar.f34493b;
            zzvxVar = new zzvx();
        }
        zzwc zzwcVar = new zzwc(-1, null, zzfj.r(zzxbVar.f35813i), zzfj.r(zzxkVar.z));
        zzwq zzwqVar = zzxkVar.f35834d;
        zzwqVar.a(new zzwp(zzwqVar, zzvxVar, zzwcVar, i2));
        this.f22615c = null;
        zzaaz zzaazVar = this.f22620h;
        zzaau zzaauVar = zzaazVar.f22625b;
        zzaauVar.getClass();
        ((zzabe) zzaazVar.f22624a).execute(zzaauVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        long jMin;
        zzaat zzaatVar;
        zzafr zzafrVar;
        boolean z = true;
        if (this.f22619g) {
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            b();
            return;
        }
        if (i2 == 4) {
            throw ((Error) message.obj);
        }
        zzaaz zzaazVar = this.f22620h;
        zzaazVar.f22625b = null;
        SystemClock.elapsedRealtime();
        zzaar zzaarVar = this.f22614b;
        zzaarVar.getClass();
        if (this.f22618f) {
            ((zzxk) zzaarVar).k(this.f22613a, false);
            return;
        }
        int i3 = message.what;
        if (i3 == 2) {
            try {
                ((zzxk) zzaarVar).l(this.f22613a);
                return;
            } catch (RuntimeException e2) {
                zzee.f("LoadTask", "Unexpected exception handling load completed", e2);
                this.f22620h.f22626c = new zzaay(e2);
                return;
            }
        }
        if (i3 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.f22615c = iOException;
        int i4 = this.f22616d;
        this.f22616d = i4 + 1;
        zzxk zzxkVar = (zzxk) zzaarVar;
        zzxb zzxbVar = (zzxb) this.f22613a;
        Uri uri = zzxbVar.f35806b.f34493b;
        zzvx zzvxVar = new zzvx();
        String str = zzfj.f31254a;
        if ((iOException instanceof zzat) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzhp) || (iOException instanceof zzaay)) {
            jMin = -9223372036854775807L;
            break;
        }
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof zzhc) && ((zzhc) cause).f33505a == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min(i4 * 1000, 5000);
        if (jMin == -9223372036854775807L) {
            zzaatVar = zzaaz.f22623e;
        } else {
            int iS = zzxkVar.s();
            int i5 = iS > zzxkVar.K ? 1 : 0;
            if (zzxkVar.G || !((zzafrVar = zzxkVar.y) == null || zzafrVar.zza() == -9223372036854775807L)) {
                zzxkVar.K = iS;
            } else {
                boolean z2 = zzxkVar.u;
                if (!z2 || zzxkVar.o()) {
                    zzxkVar.D = z2;
                    zzxkVar.H = 0L;
                    zzxkVar.K = 0;
                    zzxv[] zzxvVarArr = zzxkVar.r;
                    int length = zzxvVarArr.length;
                    int i6 = 0;
                    while (i6 < length) {
                        zzxvVarArr[i6].k(false);
                        i6++;
                        z = z;
                    }
                    zzxbVar.f35810f.f22954a = 0L;
                    zzxbVar.f35813i = 0L;
                    zzxbVar.f35812h = z;
                    zzxbVar.f35816l = false;
                } else {
                    zzxkVar.J = true;
                    zzaatVar = zzaaz.f22622d;
                }
            }
            zzaatVar = new zzaat(i5, jMin);
        }
        int i7 = zzaatVar.f22611a;
        boolean z3 = i7 == 0 || i7 == 1;
        zzwc zzwcVar = new zzwc(-1, null, zzfj.r(zzxbVar.f35813i), zzfj.r(zzxkVar.z));
        zzwq zzwqVar = zzxkVar.f35834d;
        zzwqVar.a(new zzwm(zzwqVar, zzvxVar, zzwcVar, iOException, !z3));
        int i8 = zzaatVar.f22611a;
        if (i8 == 3) {
            zzaazVar.f22626c = this.f22615c;
            return;
        }
        if (i8 != 2) {
            if (i8 == 1) {
                this.f22616d = 1;
            }
            long jMin2 = zzaatVar.f22612b;
            if (jMin2 == -9223372036854775807L) {
                jMin2 = Math.min((this.f22616d - 1) * 1000, 5000);
            }
            zzaaz zzaazVar2 = this.f22620h;
            zzgqa.f(zzaazVar2.f22625b == null);
            zzaazVar2.f22625b = this;
            if (jMin2 > 0) {
                sendEmptyMessageDelayed(1, jMin2);
            } else {
                b();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = this.f22618f;
                this.f22617e = Thread.currentThread();
            }
            if (!z) {
                zzaav zzaavVar = this.f22613a;
                String simpleName = zzaavVar.getClass().getSimpleName();
                StringBuilder sb = new StringBuilder(simpleName.length() + 5);
                sb.append("load:");
                sb.append(simpleName);
                Trace.beginSection(sb.toString());
                try {
                    ((zzxb) zzaavVar).a();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.f22617e = null;
                Thread.interrupted();
            }
            if (this.f22619g) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e2) {
            if (this.f22619g) {
                return;
            }
            obtainMessage(3, e2).sendToTarget();
        } catch (OutOfMemoryError e3) {
            if (this.f22619g) {
                return;
            }
            zzee.f("LoadTask", "OutOfMemory error loading stream", e3);
            obtainMessage(3, new zzaay(e3)).sendToTarget();
        } catch (Error e4) {
            if (!this.f22619g) {
                zzee.f("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Exception e5) {
            if (this.f22619g) {
                return;
            }
            zzee.f("LoadTask", "Unexpected exception loading stream", e5);
            obtainMessage(3, new zzaay(e5)).sendToTarget();
        }
    }
}
