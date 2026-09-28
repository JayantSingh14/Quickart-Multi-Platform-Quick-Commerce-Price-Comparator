package com.google.android.play.core.appupdate.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes4.dex */
final class zzw implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzx f41699a;

    public /* synthetic */ zzw(zzx zzxVar) {
        this.f41699a = zzxVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzx zzxVar = this.f41699a;
        zzxVar.f41701b.c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        zzxVar.a().post(new zzt(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzx zzxVar = this.f41699a;
        zzxVar.f41701b.c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        zzxVar.a().post(new zzu(this));
    }
}
