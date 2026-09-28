package io.ktor.client.plugins;

import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import org.slf4j.Logger;

@Metadata
/* loaded from: classes3.dex */
public final class HttpRequestRetryKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f49619a = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.HttpRequestRetry");

    /* renamed from: b, reason: collision with root package name */
    public static final AttributeKey f49620b = new AttributeKey("MaxRetriesPerRequestAttributeKey");

    /* renamed from: c, reason: collision with root package name */
    public static final AttributeKey f49621c = new AttributeKey("ShouldRetryPerRequestAttributeKey");

    /* renamed from: d, reason: collision with root package name */
    public static final AttributeKey f49622d = new AttributeKey("ShouldRetryOnExceptionPerRequestAttributeKey");

    /* renamed from: e, reason: collision with root package name */
    public static final AttributeKey f49623e = new AttributeKey("ModifyRequestPerRequestAttributeKey");

    /* renamed from: f, reason: collision with root package name */
    public static final AttributeKey f49624f = new AttributeKey("RetryDelayPerRequestAttributeKey");
}
