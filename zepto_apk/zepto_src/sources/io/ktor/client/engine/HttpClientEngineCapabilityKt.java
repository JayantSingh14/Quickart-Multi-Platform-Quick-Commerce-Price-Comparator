package io.ktor.client.engine;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata
/* loaded from: classes.dex */
public final class HttpClientEngineCapabilityKt {

    /* renamed from: a, reason: collision with root package name */
    public static final AttributeKey f49353a = new AttributeKey("EngineCapabilities");

    static {
        SetsKt.e(HttpTimeout.f49642d);
    }
}
