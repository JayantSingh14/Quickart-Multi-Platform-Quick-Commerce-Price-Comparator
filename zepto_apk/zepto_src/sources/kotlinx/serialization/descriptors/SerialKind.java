package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata
@ExperimentalSerializationApi
/* loaded from: classes.dex */
public abstract class SerialKind {

    @Metadata
    @ExperimentalSerializationApi
    public static final class CONTEXTUAL extends SerialKind {

        /* renamed from: a, reason: collision with root package name */
        public static final CONTEXTUAL f55763a = new CONTEXTUAL();
    }

    @Metadata
    @ExperimentalSerializationApi
    public static final class ENUM extends SerialKind {

        /* renamed from: a, reason: collision with root package name */
        public static final ENUM f55764a = new ENUM();
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        String strI = Reflection.a(getClass()).i();
        Intrinsics.c(strI);
        return strI;
    }
}
