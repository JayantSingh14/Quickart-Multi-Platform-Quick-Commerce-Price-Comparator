package i;

import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static c f48444b;

    /* renamed from: a, reason: collision with root package name */
    public final WeakHashMap f48445a = new WeakHashMap();

    public static synchronized c a() {
        try {
            if (f48444b == null) {
                f48444b = new c();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f48444b;
    }
}
