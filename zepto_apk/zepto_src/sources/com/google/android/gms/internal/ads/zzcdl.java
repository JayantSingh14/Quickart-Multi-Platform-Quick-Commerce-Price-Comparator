package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class zzcdl implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f25978a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f25979b;

    public zzcdl(String str) {
        this.f25979b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f25978a.getAndIncrement();
        int length = String.valueOf(andIncrement).length();
        String str = this.f25979b;
        StringBuilder sb = new StringBuilder(androidx.fragment.app.e.C(12, length, str));
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
