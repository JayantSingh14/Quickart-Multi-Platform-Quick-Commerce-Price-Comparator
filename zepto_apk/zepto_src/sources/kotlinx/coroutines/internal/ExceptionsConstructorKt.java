package kotlinx.coroutines.internal;

import com.brentvatne.react.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ExceptionsConstructorKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f55075a = b(Throwable.class, -1);

    static {
        try {
            int i2 = FastServiceLoaderKt.f55077a;
            WeakMapCtorCache weakMapCtorCache = WeakMapCtorCache.f55119a;
        } catch (Throwable unused) {
            WeakMapCtorCache weakMapCtorCache2 = WeakMapCtorCache.f55119a;
        }
    }

    public static final Function1 a(Class cls) throws SecurityException {
        Object next;
        Function1 function1;
        Pair pair;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = ExceptionsConstructorKt$createConstructor$nullResult$1.f55076a;
        if (f55075a == b(cls, 0)) {
            Constructor<?>[] constructors = cls.getConstructors();
            ArrayList arrayList = new ArrayList(constructors.length);
            int length = constructors.length;
            int i2 = 0;
            while (true) {
                next = null;
                if (i2 >= length) {
                    break;
                }
                final Constructor<?> constructor = constructors[i2];
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                int length2 = parameterTypes.length;
                if (length2 == 0) {
                    final int i3 = 3;
                    pair = new Pair(new c(new Function1() { // from class: kotlinx.coroutines.internal.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                            Constructor constructor2 = constructor;
                            Throwable th = (Throwable) obj;
                            switch (i3) {
                                case 0:
                                    int i4 = ExceptionsConstructorKt.f55075a;
                                    Object objNewInstance = constructor2.newInstance(th.getMessage(), th);
                                    Intrinsics.d(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                    return (Throwable) objNewInstance;
                                case 1:
                                    int i5 = ExceptionsConstructorKt.f55075a;
                                    Object objNewInstance2 = constructor2.newInstance(th.getMessage());
                                    Intrinsics.d(objNewInstance2, "null cannot be cast to non-null type kotlin.Throwable");
                                    Throwable th2 = (Throwable) objNewInstance2;
                                    th2.initCause(th);
                                    return th2;
                                case 2:
                                    int i6 = ExceptionsConstructorKt.f55075a;
                                    Object objNewInstance3 = constructor2.newInstance(th);
                                    Intrinsics.d(objNewInstance3, "null cannot be cast to non-null type kotlin.Throwable");
                                    return (Throwable) objNewInstance3;
                                default:
                                    int i7 = ExceptionsConstructorKt.f55075a;
                                    Object objNewInstance4 = constructor2.newInstance(null);
                                    Intrinsics.d(objNewInstance4, "null cannot be cast to non-null type kotlin.Throwable");
                                    Throwable th3 = (Throwable) objNewInstance4;
                                    th3.initCause(th);
                                    return th3;
                            }
                        }
                    }, 12), 0);
                } else if (length2 == 1) {
                    Class<?> cls2 = parameterTypes[0];
                    if (Intrinsics.b(cls2, String.class)) {
                        final int i4 = 1;
                        pair = new Pair(new c(new Function1() { // from class: kotlinx.coroutines.internal.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                                Constructor constructor2 = constructor;
                                Throwable th = (Throwable) obj;
                                switch (i4) {
                                    case 0:
                                        int i42 = ExceptionsConstructorKt.f55075a;
                                        Object objNewInstance = constructor2.newInstance(th.getMessage(), th);
                                        Intrinsics.d(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                        return (Throwable) objNewInstance;
                                    case 1:
                                        int i5 = ExceptionsConstructorKt.f55075a;
                                        Object objNewInstance2 = constructor2.newInstance(th.getMessage());
                                        Intrinsics.d(objNewInstance2, "null cannot be cast to non-null type kotlin.Throwable");
                                        Throwable th2 = (Throwable) objNewInstance2;
                                        th2.initCause(th);
                                        return th2;
                                    case 2:
                                        int i6 = ExceptionsConstructorKt.f55075a;
                                        Object objNewInstance3 = constructor2.newInstance(th);
                                        Intrinsics.d(objNewInstance3, "null cannot be cast to non-null type kotlin.Throwable");
                                        return (Throwable) objNewInstance3;
                                    default:
                                        int i7 = ExceptionsConstructorKt.f55075a;
                                        Object objNewInstance4 = constructor2.newInstance(null);
                                        Intrinsics.d(objNewInstance4, "null cannot be cast to non-null type kotlin.Throwable");
                                        Throwable th3 = (Throwable) objNewInstance4;
                                        th3.initCause(th);
                                        return th3;
                                }
                            }
                        }, 12), 2);
                    } else if (Intrinsics.b(cls2, Throwable.class)) {
                        final int i5 = 2;
                        pair = new Pair(new c(new Function1() { // from class: kotlinx.coroutines.internal.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                                Constructor constructor2 = constructor;
                                Throwable th = (Throwable) obj;
                                switch (i5) {
                                    case 0:
                                        int i42 = ExceptionsConstructorKt.f55075a;
                                        Object objNewInstance = constructor2.newInstance(th.getMessage(), th);
                                        Intrinsics.d(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                        return (Throwable) objNewInstance;
                                    case 1:
                                        int i52 = ExceptionsConstructorKt.f55075a;
                                        Object objNewInstance2 = constructor2.newInstance(th.getMessage());
                                        Intrinsics.d(objNewInstance2, "null cannot be cast to non-null type kotlin.Throwable");
                                        Throwable th2 = (Throwable) objNewInstance2;
                                        th2.initCause(th);
                                        return th2;
                                    case 2:
                                        int i6 = ExceptionsConstructorKt.f55075a;
                                        Object objNewInstance3 = constructor2.newInstance(th);
                                        Intrinsics.d(objNewInstance3, "null cannot be cast to non-null type kotlin.Throwable");
                                        return (Throwable) objNewInstance3;
                                    default:
                                        int i7 = ExceptionsConstructorKt.f55075a;
                                        Object objNewInstance4 = constructor2.newInstance(null);
                                        Intrinsics.d(objNewInstance4, "null cannot be cast to non-null type kotlin.Throwable");
                                        Throwable th3 = (Throwable) objNewInstance4;
                                        th3.initCause(th);
                                        return th3;
                                }
                            }
                        }, 12), 1);
                    } else {
                        pair = new Pair(null, -1);
                    }
                } else if (length2 != 2) {
                    pair = new Pair(null, -1);
                } else if (Intrinsics.b(parameterTypes[0], String.class) && Intrinsics.b(parameterTypes[1], Throwable.class)) {
                    final int i6 = 0;
                    pair = new Pair(new c(new Function1() { // from class: kotlinx.coroutines.internal.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                            Constructor constructor2 = constructor;
                            Throwable th = (Throwable) obj;
                            switch (i6) {
                                case 0:
                                    int i42 = ExceptionsConstructorKt.f55075a;
                                    Object objNewInstance = constructor2.newInstance(th.getMessage(), th);
                                    Intrinsics.d(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                    return (Throwable) objNewInstance;
                                case 1:
                                    int i52 = ExceptionsConstructorKt.f55075a;
                                    Object objNewInstance2 = constructor2.newInstance(th.getMessage());
                                    Intrinsics.d(objNewInstance2, "null cannot be cast to non-null type kotlin.Throwable");
                                    Throwable th2 = (Throwable) objNewInstance2;
                                    th2.initCause(th);
                                    return th2;
                                case 2:
                                    int i62 = ExceptionsConstructorKt.f55075a;
                                    Object objNewInstance3 = constructor2.newInstance(th);
                                    Intrinsics.d(objNewInstance3, "null cannot be cast to non-null type kotlin.Throwable");
                                    return (Throwable) objNewInstance3;
                                default:
                                    int i7 = ExceptionsConstructorKt.f55075a;
                                    Object objNewInstance4 = constructor2.newInstance(null);
                                    Intrinsics.d(objNewInstance4, "null cannot be cast to non-null type kotlin.Throwable");
                                    Throwable th3 = (Throwable) objNewInstance4;
                                    th3.initCause(th);
                                    return th3;
                            }
                        }
                    }, 12), 3);
                } else {
                    pair = new Pair(null, -1);
                }
                arrayList.add(pair);
                i2++;
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iIntValue = ((Number) ((Pair) next).f53534b).intValue();
                    do {
                        Object next2 = it.next();
                        int iIntValue2 = ((Number) ((Pair) next2).f53534b).intValue();
                        if (iIntValue < iIntValue2) {
                            next = next2;
                            iIntValue = iIntValue2;
                        }
                    } while (it.hasNext());
                }
            }
            Pair pair2 = (Pair) next;
            if (pair2 != null && (function1 = (Function1) pair2.f53533a) != null) {
                return function1;
            }
        }
        return exceptionsConstructorKt$createConstructor$nullResult$1;
    }

    public static final int b(Class cls, int i2) {
        Object objA;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Reflection.a(cls);
        try {
            Result.Companion companion = Result.f53538b;
            int i3 = 0;
            do {
                int i4 = 0;
                for (Field field : cls.getDeclaredFields()) {
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
}
