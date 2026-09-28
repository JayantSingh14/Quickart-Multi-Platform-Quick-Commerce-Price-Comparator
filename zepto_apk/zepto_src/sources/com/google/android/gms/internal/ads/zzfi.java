package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
final /* synthetic */ class zzfi implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f31186a;

    public /* synthetic */ zzfi(String str) {
        this.f31186a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final /* synthetic */ Thread newThread(Runnable runnable) {
        String str = zzfj.f31254a;
        return new Thread(runnable, this.f31186a);
    }
}
