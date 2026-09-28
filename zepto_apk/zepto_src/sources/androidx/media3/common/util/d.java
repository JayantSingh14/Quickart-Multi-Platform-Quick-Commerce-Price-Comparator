package androidx.media3.common.util;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5764a;

    public /* synthetic */ d(String str) {
        this.f5764a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int i2 = Util.f5744a;
        return new Thread(runnable, this.f5764a);
    }
}
