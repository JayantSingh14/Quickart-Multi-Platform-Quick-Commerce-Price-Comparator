package com.google.android.gms.ads.internal.util.client;

import androidx.fragment.app.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class zza implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f21405a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21406b;

    public zza(String str) {
        this.f21406b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f21405a.getAndIncrement();
        int length = String.valueOf(andIncrement).length();
        String str = this.f21406b;
        StringBuilder sb = new StringBuilder(e.C(12, length, str));
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
