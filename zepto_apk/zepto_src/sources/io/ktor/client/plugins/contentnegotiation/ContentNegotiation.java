package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ContentNegotiation {

    /* renamed from: c, reason: collision with root package name */
    public static final Plugin f49845c = new Plugin();

    /* renamed from: d, reason: collision with root package name */
    public static final AttributeKey f49846d = new AttributeKey("ContentNegotiation");

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f49847a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f49848b;

    @Metadata
    public static final class Config implements Configuration {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashSet f49849a = CollectionsKt.g0(SetsKt.d(DefaultIgnoredTypesJvmKt.f49878a, ContentNegotiationKt.f49877b));

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f49850b = new ArrayList();

        @Metadata
        public static final class ConverterRegistration {

            /* renamed from: a, reason: collision with root package name */
            public final KotlinxSerializationConverter f49851a;

            /* renamed from: b, reason: collision with root package name */
            public final ContentType f49852b;

            /* renamed from: c, reason: collision with root package name */
            public final ContentTypeMatcher f49853c;

            public ConverterRegistration(KotlinxSerializationConverter converter, ContentType contentTypeToSend, ContentTypeMatcher contentTypeMatcher) {
                Intrinsics.checkNotNullParameter(converter, "converter");
                Intrinsics.checkNotNullParameter(contentTypeToSend, "contentTypeToSend");
                Intrinsics.checkNotNullParameter(contentTypeMatcher, "contentTypeMatcher");
                this.f49851a = converter;
                this.f49852b = contentTypeToSend;
                this.f49853c = contentTypeMatcher;
            }
        }
    }

    @KtorDsl
    @Metadata
    public static final class Plugin implements HttpClientPlugin<Config, ContentNegotiation> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            ContentNegotiation plugin = (ContentNegotiation) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.f49262e.g(HttpRequestPipeline.f50019i, new ContentNegotiation$Plugin$install$1(plugin, null));
            scope.f49263f.g(HttpResponsePipeline.f50071i, new ContentNegotiation$Plugin$install$2(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new ContentNegotiation(config.f49850b, config.f49849a);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return ContentNegotiation.f49846d;
        }
    }

    public ContentNegotiation(ArrayList registrations, LinkedHashSet ignoredTypes) {
        Intrinsics.checkNotNullParameter(registrations, "registrations");
        Intrinsics.checkNotNullParameter(ignoredTypes, "ignoredTypes");
        this.f49847a = registrations;
        this.f49848b = ignoredTypes;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0218 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0219  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x01e3 -> B:76:0x01e9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(io.ktor.client.request.HttpRequestBuilder r13, java.lang.Object r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.contentnegotiation.ContentNegotiation.a(io.ktor.client.request.HttpRequestBuilder, java.lang.Object, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(io.ktor.http.Url r9, io.ktor.util.reflect.TypeInfo r10, java.lang.Object r11, io.ktor.http.ContentType r12, java.nio.charset.Charset r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.contentnegotiation.ContentNegotiation.b(io.ktor.http.Url, io.ktor.util.reflect.TypeInfo, java.lang.Object, io.ktor.http.ContentType, java.nio.charset.Charset, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
