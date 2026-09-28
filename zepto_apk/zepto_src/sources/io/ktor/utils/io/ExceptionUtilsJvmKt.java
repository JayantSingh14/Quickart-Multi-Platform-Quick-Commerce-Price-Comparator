package io.ktor.utils.io;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ExceptionUtilsJvmKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f51139a = a(Throwable.class, -1);

    /* renamed from: b, reason: collision with root package name */
    public static final ReentrantReadWriteLock f51140b = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    public static final WeakHashMap f51141c = new WeakHashMap();

    public static final int a(Class cls, int i2) {
        Object objA;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Reflection.a(cls);
        try {
            Result.Companion companion = Result.f53538b;
            int i3 = 0;
            do {
                Field[] declaredFields = cls.getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
                int i4 = 0;
                for (Field field : declaredFields) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        i4++;
                    }
                }
                i3 += i4;
                cls = cls.getSuperclass();
            } while (cls != null);
            objA = Integer.valueOf(i3);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        Object objValueOf = Integer.valueOf(i2);
        Result.Companion companion3 = Result.f53538b;
        if (objA instanceof Result.Failure) {
            objA = objValueOf;
        }
        return ((Number) objA).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x010f A[EDGE_INSN: B:105:0x010f->B:64:0x010f BREAK  A[LOOP:3: B:41:0x00b3->B:108:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[LOOP:3: B:41:0x00b3->B:108:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Throwable b(java.lang.Throwable r12, java.lang.Throwable r13) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ExceptionUtilsJvmKt.b(java.lang.Throwable, java.lang.Throwable):java.lang.Throwable");
    }
}
