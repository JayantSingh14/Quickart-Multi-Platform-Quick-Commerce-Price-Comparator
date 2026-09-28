package com.google.android.gms.iid;

import android.content.Intent;

/* loaded from: classes4.dex */
final class zzf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f22565a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f22566b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zze f22567c;

    public zzf(zze zzeVar, Intent intent, Intent intent2) {
        this.f22567c = zzeVar;
        this.f22565a = intent;
        this.f22566b = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent intent = this.f22565a;
        zze zzeVar = this.f22567c;
        zzeVar.a(intent);
        zzeVar.b(this.f22566b);
    }
}
