package org.shadow.apache.commons.lang3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.shadow.apache.commons.lang3.builder.ToStringBuilder;
import org.shadow.apache.commons.lang3.builder.ToStringStyle;

/* loaded from: classes5.dex */
public class AnnotationUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ToStringStyle f57690a;

    /* renamed from: org.shadow.apache.commons.lang3.AnnotationUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends ToStringStyle {
        @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
        public final void c(StringBuffer stringBuffer, String str, Object obj) throws SecurityException {
            if (obj instanceof Annotation) {
                Annotation annotation = (Annotation) obj;
                ToStringStyle toStringStyle = AnnotationUtils.f57690a;
                ToStringBuilder toStringBuilder = new ToStringBuilder(annotation, AnnotationUtils.f57690a);
                for (Method method : annotation.annotationType().getDeclaredMethods()) {
                    if (method.getParameterTypes().length <= 0) {
                        try {
                            toStringBuilder.a(method.invoke(annotation, null), method.getName());
                        } catch (RuntimeException e2) {
                            throw e2;
                        } catch (Exception e3) {
                            throw new RuntimeException(e3);
                        }
                    }
                }
                obj = toStringBuilder.toString();
            }
            stringBuffer.append(obj);
        }

        @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
        public final String r(Class cls) {
            Class cls2;
            HashMap map = ClassUtils.f57702a;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            ClassUtils.a(cls, linkedHashSet);
            Iterator it = new ArrayList(linkedHashSet).iterator();
            while (true) {
                if (!it.hasNext()) {
                    cls2 = null;
                    break;
                }
                cls2 = (Class) it.next();
                if (Annotation.class.isAssignableFrom(cls2)) {
                    break;
                }
            }
            return new StringBuilder(cls2 == null ? "" : cls2.getName()).insert(0, '@').toString();
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        anonymousClass1.f57736b = true;
        anonymousClass1.f57737c = true;
        anonymousClass1.f57738d = false;
        anonymousClass1.f57739e = "(";
        anonymousClass1.f57740f = ")";
        anonymousClass1.f57743i = ", ";
        anonymousClass1.f57744j = "[";
        anonymousClass1.f57746l = "]";
        f57690a = anonymousClass1;
    }
}
