package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.VisibleForTesting;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryAppStartProfilingOptions implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f51782a;

    /* renamed from: b, reason: collision with root package name */
    public Double f51783b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f51784c;

    /* renamed from: d, reason: collision with root package name */
    public Double f51785d;

    /* renamed from: e, reason: collision with root package name */
    public String f51786e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f51787f;

    /* renamed from: g, reason: collision with root package name */
    public int f51788g;

    /* renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap f51789h;

    public static final class Deserializer implements JsonDeserializer<SentryAppStartProfilingOptions> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            SentryAppStartProfilingOptions sentryAppStartProfilingOptions = new SentryAppStartProfilingOptions();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "trace_sampled":
                        Boolean boolF0 = objectReader.f0();
                        if (boolF0 == null) {
                            break;
                        } else {
                            sentryAppStartProfilingOptions.f51784c = boolF0.booleanValue();
                            break;
                        }
                    case "profiling_traces_dir_path":
                        String strA1 = objectReader.a1();
                        if (strA1 == null) {
                            break;
                        } else {
                            sentryAppStartProfilingOptions.f51786e = strA1;
                            break;
                        }
                    case "is_profiling_enabled":
                        Boolean boolF02 = objectReader.f0();
                        if (boolF02 == null) {
                            break;
                        } else {
                            sentryAppStartProfilingOptions.f51787f = boolF02.booleanValue();
                            break;
                        }
                    case "profile_sampled":
                        Boolean boolF03 = objectReader.f0();
                        if (boolF03 == null) {
                            break;
                        } else {
                            sentryAppStartProfilingOptions.f51782a = boolF03.booleanValue();
                            break;
                        }
                    case "profiling_traces_hz":
                        Integer numM0 = objectReader.M0();
                        if (numM0 == null) {
                            break;
                        } else {
                            sentryAppStartProfilingOptions.f51788g = numM0.intValue();
                            break;
                        }
                    case "trace_sample_rate":
                        Double dW = objectReader.W();
                        if (dW == null) {
                            break;
                        } else {
                            sentryAppStartProfilingOptions.f51785d = dW;
                            break;
                        }
                    case "profile_sample_rate":
                        Double dW2 = objectReader.W();
                        if (dW2 == null) {
                            break;
                        } else {
                            sentryAppStartProfilingOptions.f51783b = dW2;
                            break;
                        }
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            sentryAppStartProfilingOptions.f51789h = concurrentHashMap;
            objectReader.t();
            return sentryAppStartProfilingOptions;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @VisibleForTesting
    public SentryAppStartProfilingOptions() {
        this.f51784c = false;
        this.f51785d = null;
        this.f51782a = false;
        this.f51783b = null;
        this.f51786e = null;
        this.f51787f = false;
        this.f51788g = 0;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("profile_sampled").h(iLogger, Boolean.valueOf(this.f51782a));
        objectWriter.d("profile_sample_rate").h(iLogger, this.f51783b);
        objectWriter.d("trace_sampled").h(iLogger, Boolean.valueOf(this.f51784c));
        objectWriter.d("trace_sample_rate").h(iLogger, this.f51785d);
        objectWriter.d("profiling_traces_dir_path").h(iLogger, this.f51786e);
        objectWriter.d("is_profiling_enabled").h(iLogger, Boolean.valueOf(this.f51787f));
        objectWriter.d("profiling_traces_hz").h(iLogger, Integer.valueOf(this.f51788g));
        ConcurrentHashMap concurrentHashMap = this.f51789h;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f51789h, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }

    public SentryAppStartProfilingOptions(SentryOptions sentryOptions, TracesSamplingDecision tracesSamplingDecision) {
        this.f51784c = tracesSamplingDecision.d().booleanValue();
        this.f51785d = tracesSamplingDecision.c();
        this.f51782a = tracesSamplingDecision.b().booleanValue();
        this.f51783b = tracesSamplingDecision.a();
        this.f51786e = sentryOptions.getProfilingTracesDirPath();
        this.f51787f = sentryOptions.isProfilingEnabled();
        this.f51788g = sentryOptions.getProfilingTracesHz();
    }
}
