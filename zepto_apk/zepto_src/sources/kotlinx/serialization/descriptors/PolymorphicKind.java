package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata
@ExperimentalSerializationApi
/* loaded from: classes.dex */
public abstract class PolymorphicKind extends SerialKind {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class OPEN extends PolymorphicKind {

        /* renamed from: a, reason: collision with root package name */
        public static final OPEN f55730a = new OPEN();
    }

    @Metadata
    public static final class SEALED extends PolymorphicKind {

        /* renamed from: a, reason: collision with root package name */
        public static final SEALED f55731a = new SEALED();
    }
}
