package kotlinx.serialization.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes3.dex */
public final class AbstractPolymorphicSerializerKt {
    public static final void a(String str, KClass baseClass) {
        String string;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        String str2 = "in the polymorphic scope of '" + baseClass.i() + '\'';
        if (str == null) {
            string = e.l(ClassUtils.PACKAGE_SEPARATOR_CHAR, "Class discriminator was missing and no default serializers were registered ", str2);
        } else {
            StringBuilder sbV = e.v("Serializer for subclass '", str, "' is not found ", str2, ".\nCheck if class with serial name '");
            b.B(sbV, str, "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '", str, "' has to be '@Serializable', and the base class '");
            sbV.append(baseClass.i());
            sbV.append("' has to be sealed and '@Serializable'.");
            string = sbV.toString();
        }
        throw new SerializationException(string);
    }
}
