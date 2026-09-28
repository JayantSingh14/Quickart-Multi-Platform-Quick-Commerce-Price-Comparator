package io.sentry;

/* loaded from: classes.dex */
public interface JsonSerializable {
    void serialize(ObjectWriter objectWriter, ILogger iLogger);
}
