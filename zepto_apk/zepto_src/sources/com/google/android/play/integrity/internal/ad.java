package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes4.dex */
final class ad implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ae f42155a;

    public /* synthetic */ ad(ae aeVar) {
        this.f42155a = aeVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ae aeVar = this.f42155a;
        aeVar.f42157b.b("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        aeVar.a().post(new aa(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        ae aeVar = this.f42155a;
        aeVar.f42157b.b("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        aeVar.a().post(new ab(this));
    }
}
