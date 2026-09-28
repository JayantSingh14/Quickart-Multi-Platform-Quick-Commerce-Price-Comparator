package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class Suppliers {

    /* renamed from: a, reason: collision with root package name */
    public static final Supplier f17084a = new AnonymousClass2();

    /* renamed from: b, reason: collision with root package name */
    public static final Supplier f17085b = new AnonymousClass3();

    /* renamed from: com.facebook.common.internal.Suppliers$1, reason: invalid class name */
    class AnonymousClass1 implements Supplier<Object> {
        @Override // com.facebook.common.internal.Supplier
        public final Object get() {
            return Boolean.FALSE;
        }
    }

    /* renamed from: com.facebook.common.internal.Suppliers$2, reason: invalid class name */
    public class AnonymousClass2 implements Supplier<Boolean> {
        @Override // com.facebook.common.internal.Supplier
        public final /* bridge */ /* synthetic */ Object get() {
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.facebook.common.internal.Suppliers$3, reason: invalid class name */
    public class AnonymousClass3 implements Supplier<Boolean> {
        @Override // com.facebook.common.internal.Supplier
        public final /* bridge */ /* synthetic */ Object get() {
            return Boolean.FALSE;
        }
    }

    /* renamed from: com.facebook.common.internal.Suppliers$4, reason: invalid class name */
    public class AnonymousClass4 implements Supplier<String> {
        @Override // com.facebook.common.internal.Supplier
        public final /* bridge */ /* synthetic */ Object get() {
            return "";
        }
    }

    public static Supplier a() {
        return new AnonymousClass1();
    }
}
