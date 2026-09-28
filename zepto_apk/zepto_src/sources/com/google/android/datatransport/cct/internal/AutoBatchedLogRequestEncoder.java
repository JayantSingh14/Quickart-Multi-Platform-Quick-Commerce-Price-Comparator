package com.google.android.datatransport.cct.internal;

import com.appsflyer.AdRevenueScheme;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.PaymentConstants;

/* loaded from: classes3.dex */
public final class AutoBatchedLogRequestEncoder implements Configurator {

    /* renamed from: a, reason: collision with root package name */
    public static final AutoBatchedLogRequestEncoder f20538a = new AutoBatchedLogRequestEncoder();

    public static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final AndroidClientInfoEncoder f20539a = new AndroidClientInfoEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20540b = FieldDescriptor.a(PaymentConstants.SDK_VERSION);

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20541c = FieldDescriptor.a("model");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f20542d = FieldDescriptor.a("hardware");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f20543e = FieldDescriptor.a(LogSubCategory.Context.DEVICE);

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f20544f = FieldDescriptor.a("product");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f20545g = FieldDescriptor.a("osBuild");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f20546h = FieldDescriptor.a("manufacturer");

        /* renamed from: i, reason: collision with root package name */
        public static final FieldDescriptor f20547i = FieldDescriptor.a("fingerprint");

        /* renamed from: j, reason: collision with root package name */
        public static final FieldDescriptor f20548j = FieldDescriptor.a("locale");

        /* renamed from: k, reason: collision with root package name */
        public static final FieldDescriptor f20549k = FieldDescriptor.a(AdRevenueScheme.COUNTRY);

        /* renamed from: l, reason: collision with root package name */
        public static final FieldDescriptor f20550l = FieldDescriptor.a("mccMnc");

        /* renamed from: m, reason: collision with root package name */
        public static final FieldDescriptor f20551m = FieldDescriptor.a("applicationBuild");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f20540b, androidClientInfo.m());
            objectEncoderContext.f(f20541c, androidClientInfo.j());
            objectEncoderContext.f(f20542d, androidClientInfo.f());
            objectEncoderContext.f(f20543e, androidClientInfo.d());
            objectEncoderContext.f(f20544f, androidClientInfo.l());
            objectEncoderContext.f(f20545g, androidClientInfo.k());
            objectEncoderContext.f(f20546h, androidClientInfo.h());
            objectEncoderContext.f(f20547i, androidClientInfo.e());
            objectEncoderContext.f(f20548j, androidClientInfo.g());
            objectEncoderContext.f(f20549k, androidClientInfo.c());
            objectEncoderContext.f(f20550l, androidClientInfo.i());
            objectEncoderContext.f(f20551m, androidClientInfo.b());
        }
    }

    public static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {

        /* renamed from: a, reason: collision with root package name */
        public static final BatchedLogRequestEncoder f20552a = new BatchedLogRequestEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20553b = FieldDescriptor.a("logRequest");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f20553b, ((BatchedLogRequest) obj).b());
        }
    }

    public static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final ClientInfoEncoder f20554a = new ClientInfoEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20555b = FieldDescriptor.a("clientType");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20556c = FieldDescriptor.a("androidClientInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ClientInfo clientInfo = (ClientInfo) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f20555b, clientInfo.c());
            objectEncoderContext.f(f20556c, clientInfo.b());
        }
    }

    public static final class ComplianceDataEncoder implements ObjectEncoder<ComplianceData> {

        /* renamed from: a, reason: collision with root package name */
        public static final ComplianceDataEncoder f20557a = new ComplianceDataEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20558b = FieldDescriptor.a("privacyContext");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20559c = FieldDescriptor.a("productIdOrigin");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ComplianceData complianceData = (ComplianceData) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f20558b, complianceData.b());
            objectEncoderContext.f(f20559c, complianceData.c());
        }
    }

    public static final class ExperimentIdsEncoder implements ObjectEncoder<ExperimentIds> {

        /* renamed from: a, reason: collision with root package name */
        public static final ExperimentIdsEncoder f20560a = new ExperimentIdsEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20561b = FieldDescriptor.a("clearBlob");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20562c = FieldDescriptor.a("encryptedBlob");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ExperimentIds experimentIds = (ExperimentIds) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f20561b, experimentIds.b());
            objectEncoderContext.f(f20562c, experimentIds.c());
        }
    }

    public static final class ExternalPRequestContextEncoder implements ObjectEncoder<ExternalPRequestContext> {

        /* renamed from: a, reason: collision with root package name */
        public static final ExternalPRequestContextEncoder f20563a = new ExternalPRequestContextEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20564b = FieldDescriptor.a("originAssociatedProductId");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f20564b, ((ExternalPRequestContext) obj).b());
        }
    }

    public static final class ExternalPrivacyContextEncoder implements ObjectEncoder<ExternalPrivacyContext> {

        /* renamed from: a, reason: collision with root package name */
        public static final ExternalPrivacyContextEncoder f20565a = new ExternalPrivacyContextEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20566b = FieldDescriptor.a("prequest");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f20566b, ((ExternalPrivacyContext) obj).b());
        }
    }

    public static final class LogEventEncoder implements ObjectEncoder<LogEvent> {

        /* renamed from: a, reason: collision with root package name */
        public static final LogEventEncoder f20567a = new LogEventEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20568b = FieldDescriptor.a("eventTimeMs");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20569c = FieldDescriptor.a("eventCode");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f20570d = FieldDescriptor.a("complianceData");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f20571e = FieldDescriptor.a("eventUptimeMs");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f20572f = FieldDescriptor.a("sourceExtension");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f20573g = FieldDescriptor.a("sourceExtensionJsonProto3");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f20574h = FieldDescriptor.a("timezoneOffsetSeconds");

        /* renamed from: i, reason: collision with root package name */
        public static final FieldDescriptor f20575i = FieldDescriptor.a("networkConnectionInfo");

        /* renamed from: j, reason: collision with root package name */
        public static final FieldDescriptor f20576j = FieldDescriptor.a("experimentIds");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            LogEvent logEvent = (LogEvent) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.b(f20568b, logEvent.c());
            objectEncoderContext.f(f20569c, logEvent.b());
            objectEncoderContext.f(f20570d, logEvent.a());
            objectEncoderContext.b(f20571e, logEvent.d());
            objectEncoderContext.f(f20572f, logEvent.g());
            objectEncoderContext.f(f20573g, logEvent.h());
            objectEncoderContext.b(f20574h, logEvent.i());
            objectEncoderContext.f(f20575i, logEvent.f());
            objectEncoderContext.f(f20576j, logEvent.e());
        }
    }

    public static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {

        /* renamed from: a, reason: collision with root package name */
        public static final LogRequestEncoder f20577a = new LogRequestEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20578b = FieldDescriptor.a("requestTimeMs");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20579c = FieldDescriptor.a("requestUptimeMs");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f20580d = FieldDescriptor.a("clientInfo");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f20581e = FieldDescriptor.a("logSource");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f20582f = FieldDescriptor.a("logSourceName");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f20583g = FieldDescriptor.a("logEvent");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f20584h = FieldDescriptor.a("qosTier");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            LogRequest logRequest = (LogRequest) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.b(f20578b, logRequest.g());
            objectEncoderContext.b(f20579c, logRequest.h());
            objectEncoderContext.f(f20580d, logRequest.b());
            objectEncoderContext.f(f20581e, logRequest.d());
            objectEncoderContext.f(f20582f, logRequest.e());
            objectEncoderContext.f(f20583g, logRequest.c());
            objectEncoderContext.f(f20584h, logRequest.f());
        }
    }

    public static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final NetworkConnectionInfoEncoder f20585a = new NetworkConnectionInfoEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f20586b = FieldDescriptor.a("networkType");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f20587c = FieldDescriptor.a("mobileSubtype");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f20586b, networkConnectionInfo.c());
            objectEncoderContext.f(f20587c, networkConnectionInfo.b());
        }
    }

    public final void a(EncoderConfig encoderConfig) {
        BatchedLogRequestEncoder batchedLogRequestEncoder = BatchedLogRequestEncoder.f20552a;
        JsonDataEncoderBuilder jsonDataEncoderBuilder = (JsonDataEncoderBuilder) encoderConfig;
        jsonDataEncoderBuilder.b(BatchedLogRequest.class, batchedLogRequestEncoder);
        jsonDataEncoderBuilder.b(AutoValue_BatchedLogRequest.class, batchedLogRequestEncoder);
        LogRequestEncoder logRequestEncoder = LogRequestEncoder.f20577a;
        jsonDataEncoderBuilder.b(LogRequest.class, logRequestEncoder);
        jsonDataEncoderBuilder.b(AutoValue_LogRequest.class, logRequestEncoder);
        ClientInfoEncoder clientInfoEncoder = ClientInfoEncoder.f20554a;
        jsonDataEncoderBuilder.b(ClientInfo.class, clientInfoEncoder);
        jsonDataEncoderBuilder.b(AutoValue_ClientInfo.class, clientInfoEncoder);
        AndroidClientInfoEncoder androidClientInfoEncoder = AndroidClientInfoEncoder.f20539a;
        jsonDataEncoderBuilder.b(AndroidClientInfo.class, androidClientInfoEncoder);
        jsonDataEncoderBuilder.b(AutoValue_AndroidClientInfo.class, androidClientInfoEncoder);
        LogEventEncoder logEventEncoder = LogEventEncoder.f20567a;
        jsonDataEncoderBuilder.b(LogEvent.class, logEventEncoder);
        jsonDataEncoderBuilder.b(AutoValue_LogEvent.class, logEventEncoder);
        ComplianceDataEncoder complianceDataEncoder = ComplianceDataEncoder.f20557a;
        jsonDataEncoderBuilder.b(ComplianceData.class, complianceDataEncoder);
        jsonDataEncoderBuilder.b(AutoValue_ComplianceData.class, complianceDataEncoder);
        ExternalPrivacyContextEncoder externalPrivacyContextEncoder = ExternalPrivacyContextEncoder.f20565a;
        jsonDataEncoderBuilder.b(ExternalPrivacyContext.class, externalPrivacyContextEncoder);
        jsonDataEncoderBuilder.b(AutoValue_ExternalPrivacyContext.class, externalPrivacyContextEncoder);
        ExternalPRequestContextEncoder externalPRequestContextEncoder = ExternalPRequestContextEncoder.f20563a;
        jsonDataEncoderBuilder.b(ExternalPRequestContext.class, externalPRequestContextEncoder);
        jsonDataEncoderBuilder.b(AutoValue_ExternalPRequestContext.class, externalPRequestContextEncoder);
        NetworkConnectionInfoEncoder networkConnectionInfoEncoder = NetworkConnectionInfoEncoder.f20585a;
        jsonDataEncoderBuilder.b(NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        jsonDataEncoderBuilder.b(AutoValue_NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        ExperimentIdsEncoder experimentIdsEncoder = ExperimentIdsEncoder.f20560a;
        jsonDataEncoderBuilder.b(ExperimentIds.class, experimentIdsEncoder);
        jsonDataEncoderBuilder.b(AutoValue_ExperimentIds.class, experimentIdsEncoder);
    }
}
