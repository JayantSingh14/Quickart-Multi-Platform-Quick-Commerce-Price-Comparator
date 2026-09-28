package okhttp3.internal;

import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f56401a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f56402b;

    public /* synthetic */ a(String str, boolean z) {
        this.f56401a = str;
        this.f56402b = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        byte[] bArr = Util.f56394a;
        String name = this.f56401a;
        Intrinsics.checkNotNullParameter(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(this.f56402b);
        return thread;
    }
}
