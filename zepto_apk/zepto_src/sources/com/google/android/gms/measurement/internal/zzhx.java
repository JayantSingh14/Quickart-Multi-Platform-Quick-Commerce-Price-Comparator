package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.AbstractQueue;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
final class zzhx extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final Object f39066a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractQueue f39067b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39068c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzhy f39069d;

    /* JADX WARN: Multi-variable type inference failed */
    public zzhx(zzhy zzhyVar, String str, BlockingQueue blockingQueue) {
        Objects.requireNonNull(zzhyVar);
        this.f39069d = zzhyVar;
        this.f39068c = false;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.f39066a = new Object();
        this.f39067b = (AbstractQueue) blockingQueue;
        setName(str);
    }

    public final void a() {
        zzhy zzhyVar = this.f39069d;
        synchronized (zzhyVar.f39077i) {
            try {
                if (!this.f39068c) {
                    zzhyVar.f39078j.release();
                    zzhyVar.f39077i.notifyAll();
                    if (this == zzhyVar.f39071c) {
                        zzhyVar.f39071c = null;
                    } else if (this == zzhyVar.f39072d) {
                        zzhyVar.f39072d = null;
                    } else {
                        zzgt zzgtVar = zzhyVar.f39180a.f39089f;
                        zzib.l(zzgtVar);
                        zzgtVar.f38958f.a("Current scheduler thread is neither worker nor network");
                    }
                    this.f39068c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        boolean z = false;
        while (!z) {
            try {
                this.f39069d.f39078j.acquire();
                z = true;
            } catch (InterruptedException e2) {
                zzgt zzgtVar = this.f39069d.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38961i.b(e2, String.valueOf(getName()).concat(" was interrupted"));
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                AbstractQueue abstractQueue = this.f39067b;
                zzhw zzhwVar = (zzhw) abstractQueue.poll();
                if (zzhwVar != null) {
                    Process.setThreadPriority(true != zzhwVar.f39063b ? 10 : threadPriority);
                    zzhwVar.run();
                } else {
                    Object obj = this.f39066a;
                    synchronized (obj) {
                        if (abstractQueue.peek() == null) {
                            this.f39069d.getClass();
                            try {
                                obj.wait(30000L);
                            } catch (InterruptedException e3) {
                                zzgt zzgtVar2 = this.f39069d.f39180a.f39089f;
                                zzib.l(zzgtVar2);
                                zzgtVar2.f38961i.b(e3, String.valueOf(getName()).concat(" was interrupted"));
                            }
                        }
                    }
                    synchronized (this.f39069d.f39077i) {
                        if (this.f39067b.peek() == null) {
                            a();
                            a();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            a();
            throw th;
        }
    }
}
