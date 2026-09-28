package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.annotations.ExtraProperty;

@ExtraProperty
/* loaded from: classes4.dex */
public @interface Protobuf {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class IntEncoding {

        /* renamed from: a, reason: collision with root package name */
        public static final IntEncoding f44518a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ IntEncoding[] f44519b;

        static {
            IntEncoding intEncoding = new IntEncoding("DEFAULT", 0);
            f44518a = intEncoding;
            f44519b = new IntEncoding[]{intEncoding, new IntEncoding("SIGNED", 1), new IntEncoding("FIXED", 2)};
        }

        public static IntEncoding valueOf(String str) {
            return (IntEncoding) Enum.valueOf(IntEncoding.class, str);
        }

        public static IntEncoding[] values() {
            return (IntEncoding[]) f44519b.clone();
        }
    }

    IntEncoding intEncoding() default IntEncoding.f44518a;

    int tag();
}
