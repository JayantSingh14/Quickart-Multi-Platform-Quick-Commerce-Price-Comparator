package io.ktor.serialization;

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.plugins.contentnegotiation.JsonContentTypeMatcher;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface Configuration {

    @Metadata
    public static final class DefaultImpls {
        public static void a(ContentNegotiation.Config config, final ContentType contentTypeToSend, KotlinxSerializationConverter converter) {
            Configuration$register$1 configuration = Configuration$register$1.f50313c;
            config.getClass();
            Intrinsics.checkNotNullParameter(contentTypeToSend, "contentType");
            Intrinsics.checkNotNullParameter(converter, "converter");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            ContentTypeMatcher contentTypeMatcher = Intrinsics.b(contentTypeToSend, ContentType.Application.f50129a) ? JsonContentTypeMatcher.f49879a : new ContentTypeMatcher() { // from class: io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Config$defaultMatcher$1
                @Override // io.ktor.http.ContentTypeMatcher
                public final boolean a(ContentType contentType) {
                    Intrinsics.checkNotNullParameter(contentType, "contentType");
                    return contentType.b(contentTypeToSend);
                }
            };
            Intrinsics.checkNotNullParameter(contentTypeToSend, "contentTypeToSend");
            Intrinsics.checkNotNullParameter(converter, "converter");
            Intrinsics.checkNotNullParameter(contentTypeMatcher, "contentTypeMatcher");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            configuration.invoke(converter);
            config.f49850b.add(new ContentNegotiation.Config.ConverterRegistration(converter, contentTypeToSend, contentTypeMatcher));
        }
    }
}
