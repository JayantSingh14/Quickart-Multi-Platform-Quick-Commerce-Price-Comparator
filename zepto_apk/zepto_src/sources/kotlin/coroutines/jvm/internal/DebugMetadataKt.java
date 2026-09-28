package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ModuleNameRetriever;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DebugMetadataKt {
    public static final StackTraceElement a(BaseContinuationImpl continuation) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        DebugMetadata debugMetadata = (DebugMetadata) continuation.getClass().getAnnotation(DebugMetadata.class);
        String str = null;
        if (debugMetadata == null) {
            return null;
        }
        int iV = debugMetadata.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = continuation.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(continuation);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i2 = iIntValue >= 0 ? debugMetadata.l()[iIntValue] : -1;
        ModuleNameRetriever.f53705a.getClass();
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        ModuleNameRetriever.Cache cache = ModuleNameRetriever.f53707c;
        ModuleNameRetriever.Cache cache2 = ModuleNameRetriever.f53706b;
        if (cache == null) {
            try {
                ModuleNameRetriever.Cache cache3 = new ModuleNameRetriever.Cache(Class.class.getDeclaredMethod("getModule", null), continuation.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(CLConstants.FIELD_PAY_INFO_NAME, null));
                ModuleNameRetriever.f53707c = cache3;
                cache = cache3;
            } catch (Exception unused2) {
                ModuleNameRetriever.f53707c = cache2;
                cache = cache2;
            }
        }
        if (cache != cache2 && (method = cache.f53708a) != null && (objInvoke = method.invoke(continuation.getClass(), null)) != null && (method2 = cache.f53709b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = cache.f53710c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = debugMetadata.c();
        } else {
            strC = str + '/' + debugMetadata.c();
        }
        return new StackTraceElement(strC, debugMetadata.m(), debugMetadata.f(), i2);
    }
}
