package com.google.android.play.core.splitinstall.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes4.dex */
final class zzae implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzaf f41939a;

    public /* synthetic */ zzae(zzaf zzafVar) {
        this.f41939a = zzafVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzaf zzafVar = this.f41939a;
        zzafVar.f41941b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        zzafVar.a().post(new zzab(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzaf zzafVar = this.f41939a;
        zzafVar.f41941b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        zzafVar.a().post(new zzac(this));
    }
}
