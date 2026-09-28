package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxg;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final /* synthetic */ class zzgxh implements PrivilegedExceptionAction {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzgxh f33341a = new zzgxh();

    @Override // java.security.PrivilegedExceptionAction
    public final /* synthetic */ Object run() throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Unsafe unsafe = zzgxg.zzd.f33332a;
        for (Field field : Unsafe.class.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (Unsafe.class.isInstance(obj)) {
                return (Unsafe) Unsafe.class.cast(obj);
            }
        }
        throw new NoSuchFieldError("the Unsafe");
    }
}
