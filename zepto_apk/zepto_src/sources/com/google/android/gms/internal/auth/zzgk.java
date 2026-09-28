package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzgk {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f36395a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzgz f36396b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhb f36397c;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzgz zzgzVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f36395a = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzgzVar = (zzgz) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        f36396b = zzgzVar;
        f36397c = new zzhb();
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
