package io.ktor.client.plugins.contentnegotiation;

import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.slf4j.Logger;

@Metadata
/* loaded from: classes.dex */
public final class ContentNegotiationKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f49876a = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.contentnegotiation.ContentNegotiation");

    /* renamed from: b, reason: collision with root package name */
    public static final Set f49877b;

    static {
        KClass[] elements = {Reflection.a(byte[].class), Reflection.a(String.class), Reflection.a(HttpStatusCode.class), Reflection.a(ByteReadChannel.class), Reflection.a(OutgoingContent.class)};
        Intrinsics.checkNotNullParameter(elements, "elements");
        f49877b = ArraysKt.H(elements);
    }
}
