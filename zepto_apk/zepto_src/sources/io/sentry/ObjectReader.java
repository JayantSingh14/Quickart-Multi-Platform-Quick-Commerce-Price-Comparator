package io.sentry;

import io.sentry.protocol.MetricSummary;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.Closeable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

/* loaded from: classes.dex */
public interface ObjectReader extends Closeable {
    Object B1();

    void E();

    void I(ILogger iLogger, AbstractMap abstractMap, String str);

    ArrayList I1(ILogger iLogger, JsonDeserializer jsonDeserializer);

    TimeZone K(ILogger iLogger);

    String K0();

    Integer M0();

    Long R0();

    Double W();

    HashMap W0(ILogger iLogger, MetricSummary.Deserializer deserializer);

    String X();

    String a1();

    Date c0(ILogger iLogger);

    HashMap d1(ILogger iLogger, JsonDeserializer jsonDeserializer);

    Boolean f0();

    void k();

    double nextDouble();

    float nextFloat();

    int nextInt();

    long nextLong();

    Object o0(ILogger iLogger, JsonDeserializer jsonDeserializer);

    void p(boolean z);

    JsonToken peek();

    void t();

    Float x1();
}
