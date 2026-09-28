package io.ktor.client.engine.okhttp;

import io.ktor.client.HttpClientEngineContainer;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class OkHttpEngineContainer implements HttpClientEngineContainer {
    @Override // io.ktor.client.HttpClientEngineContainer
    public final OkHttp a() {
        return OkHttp.f49365a;
    }

    public final String toString() {
        return "OkHttp";
    }
}
