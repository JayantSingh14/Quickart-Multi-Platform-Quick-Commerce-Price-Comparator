package retrofit2;

import android.annotation.TargetApi;
import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes.dex */
class Reflection {

    @TargetApi(24)
    @IgnoreJRERequirement
    public static final class Android24 extends Reflection {
        @Override // retrofit2.Reflection
        public final Object b(Method method, Class cls, Object obj, Object[] objArr) {
            if (Build.VERSION.SDK_INT >= 26) {
                return DefaultMethodSupport.a(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }

        @Override // retrofit2.Reflection
        public final boolean c(Method method) {
            return method.isDefault();
        }
    }

    @IgnoreJRERequirement
    /* loaded from: classes5.dex */
    public static class Java8 extends Reflection {
        @Override // retrofit2.Reflection
        public final String a(Method method, int i2) {
            Parameter parameter = method.getParameters()[i2];
            if (!parameter.isNamePresent()) {
                return super.a(method, i2);
            }
            return "parameter '" + parameter.getName() + '\'';
        }

        @Override // retrofit2.Reflection
        public final Object b(Method method, Class cls, Object obj, Object[] objArr) {
            return DefaultMethodSupport.a(method, cls, obj, objArr);
        }

        @Override // retrofit2.Reflection
        public final boolean c(Method method) {
            return method.isDefault();
        }
    }

    public String a(Method method, int i2) {
        return "parameter #" + (i2 + 1);
    }

    public Object b(Method method, Class cls, Object obj, Object[] objArr) {
        throw new AssertionError();
    }

    public boolean c(Method method) {
        return false;
    }
}
