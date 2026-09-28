package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
final class FuturesGetChecked {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43451a = 0;

    @VisibleForTesting
    public interface GetCheckedTypeValidator {
    }

    @VisibleForTesting
    public static class GetCheckedTypeValidatorHolder {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class WeakSetValidator implements GetCheckedTypeValidator {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ WeakSetValidator[] f43452a = {new WeakSetValidator("INSTANCE", 0)};

            /* JADX INFO: Fake field, exist only in values array */
            WeakSetValidator EF5;

            static {
                new CopyOnWriteArraySet();
            }

            public static WeakSetValidator valueOf(String str) {
                return (WeakSetValidator) Enum.valueOf(WeakSetValidator.class, str);
            }

            public static WeakSetValidator[] values() {
                return (WeakSetValidator[]) f43452a.clone();
            }
        }

        static {
            int i2 = FuturesGetChecked.f43451a;
            WeakSetValidator[] weakSetValidatorArr = WeakSetValidator.f43452a;
        }
    }

    static {
        final int i2 = 0;
        final int i3 = 1;
        Ordering orderingG = Ordering.c().f(new Function() { // from class: com.google.common.util.concurrent.c
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                switch (i2) {
                    case 0:
                        int i4 = FuturesGetChecked.f43451a;
                        return Boolean.valueOf(((List) obj).contains(String.class));
                    case 1:
                        int i5 = FuturesGetChecked.f43451a;
                        return Boolean.valueOf(((List) obj).contains(Throwable.class));
                    default:
                        int i6 = FuturesGetChecked.f43451a;
                        return Arrays.asList(((Constructor) obj).getParameterTypes());
                }
            }
        }).a(Ordering.c().f(new Function() { // from class: com.google.common.util.concurrent.c
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                switch (i3) {
                    case 0:
                        int i4 = FuturesGetChecked.f43451a;
                        return Boolean.valueOf(((List) obj).contains(String.class));
                    case 1:
                        int i5 = FuturesGetChecked.f43451a;
                        return Boolean.valueOf(((List) obj).contains(Throwable.class));
                    default:
                        int i6 = FuturesGetChecked.f43451a;
                        return Arrays.asList(((Constructor) obj).getParameterTypes());
                }
            }
        })).g();
        final int i4 = 2;
        orderingG.f(new Function() { // from class: com.google.common.util.concurrent.c
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                switch (i4) {
                    case 0:
                        int i42 = FuturesGetChecked.f43451a;
                        return Boolean.valueOf(((List) obj).contains(String.class));
                    case 1:
                        int i5 = FuturesGetChecked.f43451a;
                        return Boolean.valueOf(((List) obj).contains(Throwable.class));
                    default:
                        int i6 = FuturesGetChecked.f43451a;
                        return Arrays.asList(((Constructor) obj).getParameterTypes());
                }
            }
        });
    }
}
