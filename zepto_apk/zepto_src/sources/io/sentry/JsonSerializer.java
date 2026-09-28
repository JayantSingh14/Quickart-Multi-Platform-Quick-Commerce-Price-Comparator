package io.sentry;

import io.sentry.Breadcrumb;
import io.sentry.ProfilingTraceData;
import io.sentry.ProfilingTransactionData;
import io.sentry.ReplayRecording;
import io.sentry.SentryAppStartProfilingOptions;
import io.sentry.SentryEnvelopeHeader;
import io.sentry.SentryEnvelopeItemHeader;
import io.sentry.SentryEvent;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryLockReason;
import io.sentry.SentryReplayEvent;
import io.sentry.Session;
import io.sentry.SpanContext;
import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.UserFeedback;
import io.sentry.clientreport.ClientReport;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.profilemeasurements.ProfileMeasurementValue;
import io.sentry.protocol.App;
import io.sentry.protocol.Browser;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Device;
import io.sentry.protocol.Geo;
import io.sentry.protocol.Gpu;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.Message;
import io.sentry.protocol.MetricSummary;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkInfo;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryPackage;
import io.sentry.protocol.SentryRuntime;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.rrweb.RRWebBreadcrumbEvent;
import io.sentry.rrweb.RRWebEventType;
import io.sentry.rrweb.RRWebInteractionEvent;
import io.sentry.rrweb.RRWebInteractionMoveEvent;
import io.sentry.rrweb.RRWebMetaEvent;
import io.sentry.rrweb.RRWebSpanEvent;
import io.sentry.rrweb.RRWebVideoEvent;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public final class JsonSerializer implements ISerializer {

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f51673c = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f51674a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f51675b;

    public JsonSerializer(SentryOptions sentryOptions) {
        this.f51674a = sentryOptions;
        HashMap map = new HashMap();
        this.f51675b = map;
        map.put(App.class, new App.Deserializer());
        map.put(Breadcrumb.class, new Breadcrumb.Deserializer());
        map.put(Browser.class, new Browser.Deserializer());
        map.put(Contexts.class, new Contexts.Deserializer());
        map.put(DebugImage.class, new DebugImage.Deserializer());
        map.put(DebugMeta.class, new DebugMeta.Deserializer());
        map.put(Device.class, new Device.Deserializer());
        map.put(Device.DeviceOrientation.class, new Device.DeviceOrientation.Deserializer());
        map.put(Gpu.class, new Gpu.Deserializer());
        map.put(MeasurementValue.class, new MeasurementValue.Deserializer());
        map.put(Mechanism.class, new Mechanism.Deserializer());
        map.put(Message.class, new Message.Deserializer());
        map.put(MetricSummary.class, new MetricSummary.Deserializer());
        map.put(OperatingSystem.class, new OperatingSystem.Deserializer());
        map.put(ProfilingTraceData.class, new ProfilingTraceData.Deserializer());
        map.put(ProfilingTransactionData.class, new ProfilingTransactionData.Deserializer());
        map.put(ProfileMeasurement.class, new ProfileMeasurement.Deserializer());
        map.put(ProfileMeasurementValue.class, new ProfileMeasurementValue.Deserializer());
        map.put(Request.class, new Request.Deserializer());
        map.put(ReplayRecording.class, new ReplayRecording.Deserializer());
        map.put(RRWebBreadcrumbEvent.class, new RRWebBreadcrumbEvent.Deserializer());
        map.put(RRWebEventType.class, new RRWebEventType.Deserializer());
        map.put(RRWebInteractionEvent.class, new RRWebInteractionEvent.Deserializer());
        map.put(RRWebInteractionMoveEvent.class, new RRWebInteractionMoveEvent.Deserializer());
        map.put(RRWebMetaEvent.class, new RRWebMetaEvent.Deserializer());
        map.put(RRWebSpanEvent.class, new RRWebSpanEvent.Deserializer());
        map.put(RRWebVideoEvent.class, new RRWebVideoEvent.Deserializer());
        map.put(SdkInfo.class, new SdkInfo.Deserializer());
        map.put(SdkVersion.class, new SdkVersion.Deserializer());
        map.put(SentryEnvelopeHeader.class, new SentryEnvelopeHeader.Deserializer());
        map.put(SentryEnvelopeItemHeader.class, new SentryEnvelopeItemHeader.Deserializer());
        map.put(SentryEvent.class, new SentryEvent.Deserializer());
        map.put(SentryException.class, new SentryException.Deserializer());
        map.put(SentryItemType.class, new SentryItemType.Deserializer());
        map.put(SentryLevel.class, new SentryLevel.Deserializer());
        map.put(SentryLockReason.class, new SentryLockReason.Deserializer());
        map.put(SentryPackage.class, new SentryPackage.Deserializer());
        map.put(SentryRuntime.class, new SentryRuntime.Deserializer());
        map.put(SentryReplayEvent.class, new SentryReplayEvent.Deserializer());
        map.put(SentrySpan.class, new SentrySpan.Deserializer());
        map.put(SentryStackFrame.class, new SentryStackFrame.Deserializer());
        map.put(SentryStackTrace.class, new SentryStackTrace.Deserializer());
        map.put(SentryAppStartProfilingOptions.class, new SentryAppStartProfilingOptions.Deserializer());
        map.put(SentryThread.class, new SentryThread.Deserializer());
        map.put(SentryTransaction.class, new SentryTransaction.Deserializer());
        map.put(Session.class, new Session.Deserializer());
        map.put(SpanContext.class, new SpanContext.Deserializer());
        map.put(SpanId.class, new SpanId.Deserializer());
        map.put(SpanStatus.class, new SpanStatus.Deserializer());
        map.put(User.class, new User.Deserializer());
        map.put(Geo.class, new Geo.Deserializer());
        map.put(UserFeedback.class, new UserFeedback.Deserializer());
        map.put(ClientReport.class, new ClientReport.Deserializer());
        map.put(ViewHierarchyNode.class, new ViewHierarchyNode.Deserializer());
        map.put(ViewHierarchy.class, new ViewHierarchy.Deserializer());
    }

    @Override // io.sentry.ISerializer
    public final String a(ConcurrentHashMap concurrentHashMap) {
        return f(concurrentHashMap, false);
    }

    @Override // io.sentry.ISerializer
    public final SentryEnvelope b(BufferedInputStream bufferedInputStream) {
        SentryOptions sentryOptions = this.f51674a;
        try {
            return sentryOptions.getEnvelopeReader().a(bufferedInputStream);
        } catch (IOException e2) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error deserializing envelope.", e2);
            return null;
        }
    }

    @Override // io.sentry.ISerializer
    public final void c(SentryEnvelope sentryEnvelope, OutputStream outputStream) throws IOException {
        SentryOptions sentryOptions = this.f51674a;
        Objects.b(sentryEnvelope, "The SentryEnvelope object is required.");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), f51673c));
        try {
            sentryEnvelope.f51812a.serialize(new JsonObjectWriter(sentryOptions.getMaxDepth(), bufferedWriter), sentryOptions.getLogger());
            bufferedWriter.write(StringUtils.LF);
            for (SentryEnvelopeItem sentryEnvelopeItem : sentryEnvelope.f51813b) {
                try {
                    byte[] bArrD = sentryEnvelopeItem.d();
                    sentryEnvelopeItem.f51820a.serialize(new JsonObjectWriter(sentryOptions.getMaxDepth(), bufferedWriter), sentryOptions.getLogger());
                    bufferedWriter.write(StringUtils.LF);
                    bufferedWriter.flush();
                    outputStream.write(bArrD);
                    bufferedWriter.write(StringUtils.LF);
                } catch (Exception e2) {
                    sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to create envelope item. Dropping it.", e2);
                }
            }
        } finally {
            bufferedWriter.flush();
        }
    }

    @Override // io.sentry.ISerializer
    public final Object d(Reader reader, Class cls) {
        Object objB1;
        SentryOptions sentryOptions = this.f51674a;
        try {
            JsonObjectReader jsonObjectReader = new JsonObjectReader(reader);
            try {
                JsonDeserializer jsonDeserializer = (JsonDeserializer) this.f51675b.get(cls);
                if (jsonDeserializer != null) {
                    objB1 = cls.cast(jsonDeserializer.a(jsonObjectReader, sentryOptions.getLogger()));
                } else {
                    if (!cls.isArray() && !Collection.class.isAssignableFrom(cls) && !String.class.isAssignableFrom(cls) && !Map.class.isAssignableFrom(cls)) {
                        jsonObjectReader.close();
                        return null;
                    }
                    objB1 = jsonObjectReader.B1();
                }
                jsonObjectReader.close();
                return objB1;
            } finally {
            }
        } catch (Exception e2) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error when deserializing", e2);
            return null;
        }
    }

    @Override // io.sentry.ISerializer
    public final void e(Object obj, BufferedWriter bufferedWriter) throws IOException {
        Objects.b(obj, "The entity is required.");
        SentryOptions sentryOptions = this.f51674a;
        ILogger logger = sentryOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        if (logger.d(sentryLevel)) {
            sentryOptions.getLogger().c(sentryLevel, "Serializing object: %s", f(obj, sentryOptions.isEnablePrettySerializationOutput()));
        }
        JsonObjectWriter jsonObjectWriter = new JsonObjectWriter(sentryOptions.getMaxDepth(), bufferedWriter);
        jsonObjectWriter.f51670b.a(jsonObjectWriter, sentryOptions.getLogger(), obj);
        bufferedWriter.flush();
    }

    public final String f(Object obj, boolean z) {
        StringWriter stringWriter = new StringWriter();
        SentryOptions sentryOptions = this.f51674a;
        JsonObjectWriter jsonObjectWriter = new JsonObjectWriter(sentryOptions.getMaxDepth(), stringWriter);
        if (z) {
            JsonWriter jsonWriter = jsonObjectWriter.f51669a;
            jsonWriter.getClass();
            jsonWriter.f53163d = "\t";
            jsonWriter.f53164e = ": ";
        }
        jsonObjectWriter.f51670b.a(jsonObjectWriter, sentryOptions.getLogger(), obj);
        return stringWriter.toString();
    }
}
