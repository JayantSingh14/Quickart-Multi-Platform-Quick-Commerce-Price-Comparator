package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public final class Throwables {
    public static void a(Throwable th) throws Throwable {
        b(th);
        throw new RuntimeException(th);
    }

    public static void b(Throwable th) throws Throwable {
        if (Error.class.isInstance(th)) {
            throw ((Throwable) Error.class.cast(th));
        }
        if (RuntimeException.class.isInstance(th)) {
            throw ((Throwable) RuntimeException.class.cast(th));
        }
    }
}
