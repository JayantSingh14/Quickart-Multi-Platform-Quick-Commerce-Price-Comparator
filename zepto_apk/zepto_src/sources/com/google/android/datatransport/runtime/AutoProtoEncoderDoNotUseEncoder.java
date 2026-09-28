package com.google.android.datatransport.runtime;

import android.support.v4.media.a;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.proto.AtProtobuf;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {

    public static final class ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {

        /* renamed from: a, reason: collision with root package name */
        public static final ClientMetricsEncoder f20676a = new ClientMetricsEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20677b;

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20678c;

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f20679d;

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f20680e;

        static {
            FieldDescriptor.Builder builder = new FieldDescriptor.Builder("window");
            AtProtobuf atProtobuf = new AtProtobuf();
            atProtobuf.f44515a = 1;
            f20677b = a.h(atProtobuf, builder);
            FieldDescriptor.Builder builder2 = new FieldDescriptor.Builder("logSourceMetrics");
            AtProtobuf atProtobuf2 = new AtProtobuf();
            atProtobuf2.f44515a = 2;
            f20678c = a.h(atProtobuf2, builder2);
            FieldDescriptor.Builder builder3 = new FieldDescriptor.Builder("globalMetrics");
            AtProtobuf atProtobuf3 = new AtProtobuf();
            atProtobuf3.f44515a = 3;
            f20679d = a.h(atProtobuf3, builder3);
            FieldDescriptor.Builder builder4 = new FieldDescriptor.Builder("appNamespace");
            AtProtobuf atProtobuf4 = new AtProtobuf();
            atProtobuf4.f44515a = 4;
            f20680e = a.h(atProtobuf4, builder4);
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ClientMetrics clientMetrics = (ClientMetrics) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f20677b, clientMetrics.f20801a);
            objectEncoderContext.f(f20678c, clientMetrics.f20802b);
            objectEncoderContext.f(f20679d, clientMetrics.f20803c);
            objectEncoderContext.f(f20680e, clientMetrics.f20804d);
        }
    }

    public static final class GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {

        /* renamed from: a, reason: collision with root package name */
        public static final GlobalMetricsEncoder f20681a = new GlobalMetricsEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20682b;

        static {
            FieldDescriptor.Builder builder = new FieldDescriptor.Builder("storageMetrics");
            AtProtobuf atProtobuf = new AtProtobuf();
            atProtobuf.f44515a = 1;
            f20682b = a.h(atProtobuf, builder);
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f20682b, ((GlobalMetrics) obj).f20810a);
        }
    }

    public static final class LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {

        /* renamed from: a, reason: collision with root package name */
        public static final LogEventDroppedEncoder f20683a = new LogEventDroppedEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20684b;

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20685c;

        static {
            FieldDescriptor.Builder builder = new FieldDescriptor.Builder("eventsDroppedCount");
            AtProtobuf atProtobuf = new AtProtobuf();
            atProtobuf.f44515a = 1;
            f20684b = a.h(atProtobuf, builder);
            FieldDescriptor.Builder builder2 = new FieldDescriptor.Builder("reason");
            AtProtobuf atProtobuf2 = new AtProtobuf();
            atProtobuf2.f44515a = 3;
            f20685c = a.h(atProtobuf2, builder2);
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            LogEventDropped logEventDropped = (LogEventDropped) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.b(f20684b, logEventDropped.f20813a);
            objectEncoderContext.f(f20685c, logEventDropped.f20814b);
        }
    }

    public static final class LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {

        /* renamed from: a, reason: collision with root package name */
        public static final LogSourceMetricsEncoder f20686a = new LogSourceMetricsEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20687b;

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20688c;

        static {
            FieldDescriptor.Builder builder = new FieldDescriptor.Builder("logSource");
            AtProtobuf atProtobuf = new AtProtobuf();
            atProtobuf.f44515a = 1;
            f20687b = a.h(atProtobuf, builder);
            FieldDescriptor.Builder builder2 = new FieldDescriptor.Builder("logEventDropped");
            AtProtobuf atProtobuf2 = new AtProtobuf();
            atProtobuf2.f44515a = 2;
            f20688c = a.h(atProtobuf2, builder2);
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            LogSourceMetrics logSourceMetrics = (LogSourceMetrics) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f20687b, logSourceMetrics.f20827a);
            objectEncoderContext.f(f20688c, logSourceMetrics.f20828b);
        }
    }

    public static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* renamed from: a, reason: collision with root package name */
        public static final ProtoEncoderDoNotUseEncoder f20689a = new ProtoEncoderDoNotUseEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20690b = FieldDescriptor.a("clientMetrics");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f20690b, ((ProtoEncoderDoNotUse) obj).a());
        }
    }

    public static final class StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {

        /* renamed from: a, reason: collision with root package name */
        public static final StorageMetricsEncoder f20691a = new StorageMetricsEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20692b;

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20693c;

        static {
            FieldDescriptor.Builder builder = new FieldDescriptor.Builder("currentCacheSizeBytes");
            AtProtobuf atProtobuf = new AtProtobuf();
            atProtobuf.f44515a = 1;
            f20692b = a.h(atProtobuf, builder);
            FieldDescriptor.Builder builder2 = new FieldDescriptor.Builder("maxCacheSizeBytes");
            AtProtobuf atProtobuf2 = new AtProtobuf();
            atProtobuf2.f44515a = 2;
            f20693c = a.h(atProtobuf2, builder2);
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            StorageMetrics storageMetrics = (StorageMetrics) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.b(f20692b, storageMetrics.f20832a);
            objectEncoderContext.b(f20693c, storageMetrics.f20833b);
        }
    }

    public static final class TimeWindowEncoder implements ObjectEncoder<TimeWindow> {

        /* renamed from: a, reason: collision with root package name */
        public static final TimeWindowEncoder f20694a = new TimeWindowEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20695b;

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20696c;

        static {
            FieldDescriptor.Builder builder = new FieldDescriptor.Builder("startMs");
            AtProtobuf atProtobuf = new AtProtobuf();
            atProtobuf.f44515a = 1;
            f20695b = a.h(atProtobuf, builder);
            FieldDescriptor.Builder builder2 = new FieldDescriptor.Builder("endMs");
            AtProtobuf atProtobuf2 = new AtProtobuf();
            atProtobuf2.f44515a = 2;
            f20696c = a.h(atProtobuf2, builder2);
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            TimeWindow timeWindow = (TimeWindow) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.b(f20695b, timeWindow.f20836a);
            objectEncoderContext.b(f20696c, timeWindow.f20837b);
        }
    }
}
