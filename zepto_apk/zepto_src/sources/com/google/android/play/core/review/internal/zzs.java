package com.google.android.play.core.review.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes4.dex */
final class zzs implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzt f41868a;

    public /* synthetic */ zzs(zzt zztVar) {
        this.f41868a = zztVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzt zztVar = this.f41868a;
        zztVar.f41870b.a("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        zztVar.a().post(new zzp(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzt zztVar = this.f41868a;
        zztVar.f41870b.a("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        zztVar.a().post(new zzq(this));
    }
}
