package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public interface JsonDeserializer<T> {
    Object a(ObjectReader objectReader, ILogger iLogger);
}
