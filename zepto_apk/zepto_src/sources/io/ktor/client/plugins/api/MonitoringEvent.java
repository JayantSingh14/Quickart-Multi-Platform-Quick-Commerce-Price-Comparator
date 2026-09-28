package io.ktor.client.plugins.api;

import io.ktor.events.EventDefinition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes3.dex */
public final class MonitoringEvent<Param, Event extends EventDefinition<Param>> implements ClientHook<Function1<? super Param, ? extends Unit>> {
}
