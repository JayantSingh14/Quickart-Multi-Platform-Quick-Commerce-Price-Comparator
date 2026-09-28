package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

@Nullsafe
/* loaded from: classes3.dex */
public final class Objects {

    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        public final String f17078a;

        /* renamed from: b, reason: collision with root package name */
        public final ValueHolder f17079b;

        /* renamed from: c, reason: collision with root package name */
        public ValueHolder f17080c;

        public static final class ValueHolder {

            /* renamed from: a, reason: collision with root package name */
            public String f17081a;

            /* renamed from: b, reason: collision with root package name */
            public Object f17082b;

            /* renamed from: c, reason: collision with root package name */
            public ValueHolder f17083c;
        }

        public ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f17079b = valueHolder;
            this.f17080c = valueHolder;
            this.f17078a = str;
        }

        public final void a(String str) {
            c(str, "holder");
        }

        public final void b(String str, boolean z) {
            c(String.valueOf(z), str);
        }

        public final void c(Object obj, String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f17080c.f17083c = valueHolder;
            this.f17080c = valueHolder;
            valueHolder.f17082b = obj;
            valueHolder.f17081a = str;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f17078a);
            sb.append('{');
            ValueHolder valueHolder = this.f17079b.f17083c;
            String str = "";
            while (valueHolder != null) {
                Object obj = valueHolder.f17082b;
                sb.append(str);
                String str2 = valueHolder.f17081a;
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
                valueHolder = valueHolder.f17083c;
                str = ", ";
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static ToStringHelper b(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }
}
