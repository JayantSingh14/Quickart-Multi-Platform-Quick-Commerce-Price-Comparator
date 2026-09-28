package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

@Metadata
/* loaded from: classes.dex */
public final class DefaultResponseValidationKt {

    /* renamed from: a, reason: collision with root package name */
    public static final AttributeKey f49464a = new AttributeKey("ValidateMark");

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f49465b = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.DefaultResponseValidation");

    public static final void a(HttpClientConfig httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        DefaultResponseValidationKt$addDefaultResponseValidation$1 block = new DefaultResponseValidationKt$addDefaultResponseValidation$1(1);
        Logger logger = HttpCallValidatorKt.f49530a;
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        httpClientConfig.b(HttpCallValidator.f49498d, block);
    }
}
