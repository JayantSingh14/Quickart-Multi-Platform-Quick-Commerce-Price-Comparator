package j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f53503a;

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f53504b = Executors.newCachedThreadPool(new ThreadFactoryC0062a());

    /* renamed from: j.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0062a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("AmazonAuthorzationLibrary#");
            int i2 = a.f53503a + 1;
            a.f53503a = i2;
            sb.append(i2);
            return new Thread(runnable, sb.toString());
        }
    }
}
