package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@RestrictTo
/* loaded from: classes.dex */
public final class Lifecycling {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f4828a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f4829b = new HashMap();

    public static GeneratedAdapter a(Constructor constructor, LifecycleObserver lifecycleObserver) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = constructor.newInstance(lifecycleObserver);
            Intrinsics.checkNotNullExpressionValue(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            return (GeneratedAdapter) objNewInstance;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static final String b(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return StringsKt.K(className, CLConstants.DOT_SALT_DELIMETER, Attributes.PREDEFINED_ATTRIBUTE_PREFIX) + "_LifecycleAdapter";
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0104 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.Class r11) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.Lifecycling.c(java.lang.Class):int");
    }
}
