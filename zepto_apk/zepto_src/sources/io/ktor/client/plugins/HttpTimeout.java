package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class HttpTimeout {

    /* renamed from: d, reason: collision with root package name */
    public static final Plugin f49642d = new Plugin();

    /* renamed from: e, reason: collision with root package name */
    public static final AttributeKey f49643e = new AttributeKey("TimeoutPlugin");

    /* renamed from: a, reason: collision with root package name */
    public final Long f49644a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f49645b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f49646c;

    @KtorDsl
    @Metadata
    public static final class HttpTimeoutCapabilityConfiguration {

        /* renamed from: a, reason: collision with root package name */
        public Long f49647a;

        /* renamed from: b, reason: collision with root package name */
        public Long f49648b;

        /* renamed from: c, reason: collision with root package name */
        public Long f49649c;

        @Metadata
        public static final class Companion {
        }

        static {
            new AttributeKey("TimeoutConfiguration");
        }

        public HttpTimeoutCapabilityConfiguration() {
            this.f49647a = 0L;
            this.f49648b = 0L;
            this.f49649c = 0L;
            this.f49647a = null;
            this.f49648b = null;
            this.f49649c = null;
        }

        public static void a(Long l2) {
            if (l2 != null && l2.longValue() <= 0) {
                throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS");
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HttpTimeoutCapabilityConfiguration.class != obj.getClass()) {
                return false;
            }
            HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeoutCapabilityConfiguration) obj;
            return Intrinsics.b(this.f49647a, httpTimeoutCapabilityConfiguration.f49647a) && Intrinsics.b(this.f49648b, httpTimeoutCapabilityConfiguration.f49648b) && Intrinsics.b(this.f49649c, httpTimeoutCapabilityConfiguration.f49649c);
        }

        public final int hashCode() {
            Long l2 = this.f49647a;
            int iHashCode = (l2 != null ? l2.hashCode() : 0) * 31;
            Long l3 = this.f49648b;
            int iHashCode2 = (iHashCode + (l3 != null ? l3.hashCode() : 0)) * 31;
            Long l4 = this.f49649c;
            return iHashCode2 + (l4 != null ? l4.hashCode() : 0);
        }
    }

    @Metadata
    public static final class Plugin implements HttpClientPlugin<HttpTimeoutCapabilityConfiguration, HttpTimeout>, HttpClientEngineCapability<HttpTimeoutCapabilityConfiguration> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            HttpTimeout plugin = (HttpTimeout) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            ((HttpSend) HttpClientPluginKt.a(scope, HttpSend.f49625b)).a(new HttpTimeout$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = new HttpTimeoutCapabilityConfiguration();
            block.invoke(httpTimeoutCapabilityConfiguration);
            return new HttpTimeout(httpTimeoutCapabilityConfiguration.f49647a, httpTimeoutCapabilityConfiguration.f49648b, httpTimeoutCapabilityConfiguration.f49649c);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return HttpTimeout.f49643e;
        }
    }

    public HttpTimeout(Long l2, Long l3, Long l4) {
        this.f49644a = l2;
        this.f49645b = l3;
        this.f49646c = l4;
    }
}
