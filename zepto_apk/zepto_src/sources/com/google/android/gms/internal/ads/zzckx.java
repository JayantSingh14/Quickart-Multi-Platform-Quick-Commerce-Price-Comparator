package com.google.android.gms.internal.ads;

import android.os.Process;

/* loaded from: classes4.dex */
final class zzckx extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f26478a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcky f26479b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzckx(zzcky zzckyVar, Runnable runnable, String str, Runnable runnable2) {
        super(runnable, str);
        this.f26478a = runnable2;
        this.f26479b = zzckyVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(this.f26479b.f26481b);
        this.f26478a.run();
    }
}
