package com.cardreader.card_reader_lib.xutils;

/* loaded from: classes3.dex */
public interface ITag {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Class {

        /* renamed from: a, reason: collision with root package name */
        public static final Class f16580a;

        /* renamed from: b, reason: collision with root package name */
        public static final Class f16581b;

        /* renamed from: c, reason: collision with root package name */
        public static final Class f16582c;

        /* renamed from: d, reason: collision with root package name */
        public static final Class f16583d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Class[] f16584e;

        static {
            Class r0 = new Class("UNIVERSAL", 0);
            f16580a = r0;
            Class r1 = new Class("APPLICATION", 1);
            f16581b = r1;
            Class r2 = new Class("CONTEXT_SPECIFIC", 2);
            f16582c = r2;
            Class r3 = new Class("PRIVATE", 3);
            f16583d = r3;
            f16584e = new Class[]{r0, r1, r2, r3};
        }

        public static Class valueOf(String str) {
            return (Class) Enum.valueOf(Class.class, str);
        }

        public static Class[] values() {
            return (Class[]) f16584e.clone();
        }
    }

    byte[] a();

    boolean b();
}
