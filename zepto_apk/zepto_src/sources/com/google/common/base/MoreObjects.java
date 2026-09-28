package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class MoreObjects {

    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        public final String f42279a;

        /* renamed from: b, reason: collision with root package name */
        public final ValueHolder f42280b;

        /* renamed from: c, reason: collision with root package name */
        public ValueHolder f42281c;

        public static final class UnconditionalValueHolder extends ValueHolder {
        }

        public static class ValueHolder {

            /* renamed from: a, reason: collision with root package name */
            public String f42282a;

            /* renamed from: b, reason: collision with root package name */
            public Object f42283b;

            /* renamed from: c, reason: collision with root package name */
            public ValueHolder f42284c;
        }

        public ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f42280b = valueHolder;
            this.f42281c = valueHolder;
            this.f42279a = str;
        }

        public final void a(Object obj, String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f42281c.f42284c = valueHolder;
            this.f42281c = valueHolder;
            valueHolder.f42283b = obj;
            valueHolder.f42282a = str;
        }

        public final void b(String str) {
            String strValueOf = String.valueOf(0L);
            UnconditionalValueHolder unconditionalValueHolder = new UnconditionalValueHolder();
            this.f42281c.f42284c = unconditionalValueHolder;
            this.f42281c = unconditionalValueHolder;
            unconditionalValueHolder.f42283b = strValueOf;
            unconditionalValueHolder.f42282a = str;
        }

        public final void c(Object obj) {
            ValueHolder valueHolder = new ValueHolder();
            this.f42281c.f42284c = valueHolder;
            this.f42281c = valueHolder;
            valueHolder.f42283b = obj;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f42279a);
            sb.append('{');
            ValueHolder valueHolder = this.f42280b.f42284c;
            String str = "";
            while (valueHolder != null) {
                Object obj = valueHolder.f42283b;
                boolean z = valueHolder instanceof UnconditionalValueHolder;
                sb.append(str);
                String str2 = valueHolder.f42282a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String strDeepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                }
                valueHolder = valueHolder.f42284c;
                str = ", ";
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static Object a(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper b(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }
}
