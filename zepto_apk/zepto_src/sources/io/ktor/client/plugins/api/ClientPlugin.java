package io.ktor.client.plugins.api;

import io.ktor.client.plugins.HttpClientPlugin;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface ClientPlugin<PluginConfig> extends HttpClientPlugin<PluginConfig, ClientPluginInstance<PluginConfig>> {
}
