package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.modules.SerializersModuleCollector;

@Metadata
/* loaded from: classes.dex */
public final class PolymorphismValidator implements SerializersModuleCollector {

    /* renamed from: a, reason: collision with root package name */
    public final String f56084a;

    public PolymorphismValidator(String discriminator) {
        Intrinsics.checkNotNullParameter(discriminator, "discriminator");
        this.f56084a = discriminator;
    }

    public final void a(KClass kClass, Function1 provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
    }
}
