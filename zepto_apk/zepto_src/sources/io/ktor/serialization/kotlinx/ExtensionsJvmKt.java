package io.ktor.serialization.kotlinx;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ExtensionsJvmKt {

    /* renamed from: a, reason: collision with root package name */
    public static final List f50332a;

    static {
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(KotlinxSerializationExtensionProvider.class, KotlinxSerializationExtensionProvider.class.getClassLoader());
        Intrinsics.checkNotNullExpressionValue(serviceLoaderLoad, "load(it, it.classLoader)");
        f50332a = CollectionsKt.e0(serviceLoaderLoad);
    }
}
