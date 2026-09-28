package kotlinx.serialization.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PlatformKt {
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01d0, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01de A[Catch: NoSuchFieldException -> 0x01d7, TRY_LEAVE, TryCatch #2 {NoSuchFieldException -> 0x01d7, blocks: (B:94:0x01b3, B:96:0x01c0, B:106:0x01de, B:101:0x01d4), top: B:134:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c0 A[Catch: NoSuchFieldException -> 0x01d7, TryCatch #2 {NoSuchFieldException -> 0x01d7, blocks: (B:94:0x01b3, B:96:0x01c0, B:106:0x01de, B:101:0x01d4), top: B:134:0x01b3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlinx.serialization.KSerializer a(kotlin.reflect.KClass r16, kotlinx.serialization.KSerializer... r17) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.a(kotlin.reflect.KClass, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    public static final KSerializer b(Object obj, KSerializer... kSerializerArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] clsArr;
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i2 = 0; i2 < length; i2++) {
                    clsArr2[i2] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object objInvoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (objInvoke instanceof KSerializer) {
                return (KSerializer) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause == null) {
                throw e2;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e2.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }
}
