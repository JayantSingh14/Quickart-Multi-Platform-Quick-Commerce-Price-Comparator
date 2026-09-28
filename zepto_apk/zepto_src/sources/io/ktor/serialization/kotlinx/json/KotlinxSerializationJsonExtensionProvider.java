package io.ktor.serialization.kotlinx.json;

import io.ktor.serialization.kotlinx.KotlinxSerializationExtensionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.json.Json;

@Metadata
/* loaded from: classes.dex */
public final class KotlinxSerializationJsonExtensionProvider implements KotlinxSerializationExtensionProvider {
    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtensionProvider
    public final KotlinxSerializationJsonExtensions a(SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (format instanceof Json) {
            return new KotlinxSerializationJsonExtensions((Json) format);
        }
        return null;
    }
}
