package androidx.datastore.preferences.protobuf;

/* loaded from: classes3.dex */
final class Android {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f3733a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f3734b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f3733a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f3734b = cls2 != null;
    }

    public static boolean a() {
        return (f3733a == null || f3734b) ? false : true;
    }
}
