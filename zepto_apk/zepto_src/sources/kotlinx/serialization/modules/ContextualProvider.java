package kotlinx.serialization.modules;

import com.zeptonow.horizon.utils.AnyValueSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

@Metadata
/* loaded from: classes.dex */
public abstract class ContextualProvider {

    @Metadata
    public static final class Argless extends ContextualProvider {
        @Override // kotlinx.serialization.modules.ContextualProvider
        public final KSerializer a(List typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return AnyValueSerializer.f48230a;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Argless)) {
                return false;
            }
            ((Argless) obj).getClass();
            Object obj2 = AnyValueSerializer.f48230a;
            return obj2.equals(obj2);
        }

        public final int hashCode() {
            return AnyValueSerializer.f48230a.hashCode();
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class WithTypeArguments extends ContextualProvider {
        @Override // kotlinx.serialization.modules.ContextualProvider
        public final KSerializer a(List typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            throw null;
        }

        public final Function1 b() {
            return null;
        }
    }

    public abstract KSerializer a(List list);
}
