package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.cache.storage.CacheStorage;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HttpCache {

    /* renamed from: e, reason: collision with root package name */
    public static final AttributeKey f49687e = new AttributeKey("HttpCache");

    /* renamed from: f, reason: collision with root package name */
    public static final EventDefinition f49688f = new EventDefinition();

    /* renamed from: a, reason: collision with root package name */
    public final HttpCacheStorage f49689a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpCacheStorage f49690b;

    /* renamed from: c, reason: collision with root package name */
    public final CacheStorage f49691c;

    /* renamed from: d, reason: collision with root package name */
    public final CacheStorage f49692d;

    @Metadata
    @SourceDebugExtension
    public static final class Companion implements HttpClientPlugin<Config, HttpCache> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) throws InvalidPhaseException {
            HttpCache plugin = (HttpCache) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            PipelinePhase pipelinePhase = new PipelinePhase("Cache");
            scope.f49264g.f(HttpSendPipeline.f50031h, pipelinePhase);
            scope.f49264g.g(pipelinePhase, new HttpCache$Companion$install$1(plugin, scope, null));
            scope.f49265h.g(HttpReceivePipeline.f50059h, new HttpCache$Companion$install$2(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpCache(config.f49705c, config.f49706d, config.f49703a, config.f49704b);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return HttpCache.f49687e;
        }
    }

    @KtorDsl
    @Metadata
    public static final class Config {

        /* renamed from: a, reason: collision with root package name */
        public final CacheStorage f49703a;

        /* renamed from: b, reason: collision with root package name */
        public final CacheStorage f49704b;

        /* renamed from: c, reason: collision with root package name */
        public final HttpCacheStorage f49705c;

        /* renamed from: d, reason: collision with root package name */
        public final HttpCacheStorage f49706d;

        public Config() {
            CacheStorage.f49750a.getClass();
            this.f49703a = (CacheStorage) CacheStorage.Companion.a().invoke();
            this.f49704b = (CacheStorage) CacheStorage.Companion.a().invoke();
            Function0 function0 = HttpCacheStorage.f49821a;
            this.f49705c = (HttpCacheStorage) HttpCacheStorage.Companion.a().invoke();
            this.f49706d = (HttpCacheStorage) HttpCacheStorage.Companion.a().invoke();
        }
    }

    public HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2) {
        this.f49689a = httpCacheStorage;
        this.f49690b = httpCacheStorage2;
        this.f49691c = cacheStorage;
        this.f49692d = cacheStorage2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(io.ktor.client.plugins.cache.HttpCache r20, io.ktor.client.request.HttpRequest r21, io.ktor.client.statement.HttpResponse r22, kotlin.coroutines.jvm.internal.ContinuationImpl r23) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.a(io.ktor.client.plugins.cache.HttpCache, io.ktor.client.request.HttpRequest, io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(io.ktor.client.plugins.cache.HttpCache r18, io.ktor.client.request.HttpRequestBuilder r19, io.ktor.http.content.OutgoingContent r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.b(io.ktor.client.plugins.cache.HttpCache, io.ktor.client.request.HttpRequestBuilder, io.ktor.http.content.OutgoingContent, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(io.ktor.client.plugins.cache.storage.CacheStorage r18, java.util.Map r19, io.ktor.http.Url r20, io.ktor.client.request.HttpRequest r21, kotlin.coroutines.jvm.internal.ContinuationImpl r22) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.c(io.ktor.client.plugins.cache.storage.CacheStorage, java.util.Map, io.ktor.http.Url, io.ktor.client.request.HttpRequest, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
