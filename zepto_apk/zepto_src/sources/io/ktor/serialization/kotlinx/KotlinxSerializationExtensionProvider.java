package io.ktor.serialization.kotlinx;

import io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions;
import kotlin.Metadata;
import kotlinx.serialization.SerialFormat;

@Metadata
/* loaded from: classes.dex */
public interface KotlinxSerializationExtensionProvider {
    KotlinxSerializationJsonExtensions a(SerialFormat serialFormat);
}
