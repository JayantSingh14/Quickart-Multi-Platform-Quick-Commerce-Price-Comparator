package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public abstract class zziiy {
    public static zziiy b(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zziit(cls.getSimpleName()) : new zziiv(cls.getSimpleName());
    }

    public abstract void a(String str);
}
