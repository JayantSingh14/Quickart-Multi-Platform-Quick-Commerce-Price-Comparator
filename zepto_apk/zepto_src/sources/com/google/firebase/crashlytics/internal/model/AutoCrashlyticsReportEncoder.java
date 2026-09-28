package com.google.firebase.crashlytics.internal.model;

import coil3.util.UtilsKt;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import in.juspay.airborne.ota.Constants;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hyperutil.constants.LogLevel;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class AutoCrashlyticsReportEncoder implements Configurator {

    /* renamed from: a, reason: collision with root package name */
    public static final AutoCrashlyticsReportEncoder f43947a = new AutoCrashlyticsReportEncoder();

    public static final class CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder f43948a = new CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43949b = FieldDescriptor.a("arch");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f43950c = FieldDescriptor.a("libraryName");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f43951d = FieldDescriptor.a("buildId");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch buildIdMappingForArch = (CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f43949b, buildIdMappingForArch.b());
            objectEncoderContext.f(f43950c, buildIdMappingForArch.d());
            objectEncoderContext.f(f43951d, buildIdMappingForArch.c());
        }
    }

    public static final class CrashlyticsReportApplicationExitInfoEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportApplicationExitInfoEncoder f43952a = new CrashlyticsReportApplicationExitInfoEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43953b = FieldDescriptor.a("pid");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f43954c = FieldDescriptor.a("processName");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f43955d = FieldDescriptor.a("reasonCode");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f43956e = FieldDescriptor.a("importance");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f43957f = FieldDescriptor.a("pss");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f43958g = FieldDescriptor.a("rss");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f43959h = FieldDescriptor.a("timestamp");

        /* renamed from: i, reason: collision with root package name */
        public static final FieldDescriptor f43960i = FieldDescriptor.a("traceFile");

        /* renamed from: j, reason: collision with root package name */
        public static final FieldDescriptor f43961j = FieldDescriptor.a("buildIdMappingForArch");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.c(f43953b, applicationExitInfo.d());
            objectEncoderContext.f(f43954c, applicationExitInfo.e());
            objectEncoderContext.c(f43955d, applicationExitInfo.g());
            objectEncoderContext.c(f43956e, applicationExitInfo.c());
            objectEncoderContext.b(f43957f, applicationExitInfo.f());
            objectEncoderContext.b(f43958g, applicationExitInfo.h());
            objectEncoderContext.b(f43959h, applicationExitInfo.i());
            objectEncoderContext.f(f43960i, applicationExitInfo.j());
            objectEncoderContext.f(f43961j, applicationExitInfo.b());
        }
    }

    public static final class CrashlyticsReportCustomAttributeEncoder implements ObjectEncoder<CrashlyticsReport.CustomAttribute> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportCustomAttributeEncoder f43962a = new CrashlyticsReportCustomAttributeEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43963b = FieldDescriptor.a("key");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f43964c = FieldDescriptor.a(CLConstants.FIELD_PAY_INFO_VALUE);

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f43963b, customAttribute.b());
            objectEncoderContext.f(f43964c, customAttribute.c());
        }
    }

    public static final class CrashlyticsReportEncoder implements ObjectEncoder<CrashlyticsReport> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportEncoder f43965a = new CrashlyticsReportEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43966b = FieldDescriptor.a(PaymentConstants.SDK_VERSION);

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f43967c = FieldDescriptor.a("gmpAppId");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f43968d = FieldDescriptor.a("platform");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f43969e = FieldDescriptor.a("installationUuid");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f43970f = FieldDescriptor.a("firebaseInstallationId");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f43971g = FieldDescriptor.a("firebaseAuthenticationToken");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f43972h = FieldDescriptor.a("appQualitySessionId");

        /* renamed from: i, reason: collision with root package name */
        public static final FieldDescriptor f43973i = FieldDescriptor.a("buildVersion");

        /* renamed from: j, reason: collision with root package name */
        public static final FieldDescriptor f43974j = FieldDescriptor.a("displayVersion");

        /* renamed from: k, reason: collision with root package name */
        public static final FieldDescriptor f43975k = FieldDescriptor.a("session");

        /* renamed from: l, reason: collision with root package name */
        public static final FieldDescriptor f43976l = FieldDescriptor.a("ndkPayload");

        /* renamed from: m, reason: collision with root package name */
        public static final FieldDescriptor f43977m = FieldDescriptor.a("appExitInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f43966b, crashlyticsReport.l());
            objectEncoderContext.f(f43967c, crashlyticsReport.h());
            objectEncoderContext.c(f43968d, crashlyticsReport.k());
            objectEncoderContext.f(f43969e, crashlyticsReport.i());
            objectEncoderContext.f(f43970f, crashlyticsReport.g());
            objectEncoderContext.f(f43971g, crashlyticsReport.f());
            objectEncoderContext.f(f43972h, crashlyticsReport.c());
            objectEncoderContext.f(f43973i, crashlyticsReport.d());
            objectEncoderContext.f(f43974j, crashlyticsReport.e());
            objectEncoderContext.f(f43975k, crashlyticsReport.m());
            objectEncoderContext.f(f43976l, crashlyticsReport.j());
            objectEncoderContext.f(f43977m, crashlyticsReport.b());
        }
    }

    public static final class CrashlyticsReportFilesPayloadEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportFilesPayloadEncoder f43978a = new CrashlyticsReportFilesPayloadEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43979b = FieldDescriptor.a("files");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f43980c = FieldDescriptor.a("orgId");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f43979b, filesPayload.b());
            objectEncoderContext.f(f43980c, filesPayload.c());
        }
    }

    public static final class CrashlyticsReportFilesPayloadFileEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload.File> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportFilesPayloadFileEncoder f43981a = new CrashlyticsReportFilesPayloadFileEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43982b = FieldDescriptor.a("filename");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f43983c = FieldDescriptor.a("contents");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f43982b, file.c());
            objectEncoderContext.f(f43983c, file.b());
        }
    }

    public static final class CrashlyticsReportSessionApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionApplicationEncoder f43984a = new CrashlyticsReportSessionApplicationEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43985b = FieldDescriptor.a("identifier");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f43986c = FieldDescriptor.a("version");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f43987d = FieldDescriptor.a("displayVersion");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f43988e = FieldDescriptor.a("organization");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f43989f = FieldDescriptor.a("installationUuid");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f43990g = FieldDescriptor.a("developmentPlatform");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f43991h = FieldDescriptor.a("developmentPlatformVersion");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f43985b, application.e());
            objectEncoderContext.f(f43986c, application.h());
            objectEncoderContext.f(f43987d, application.d());
            objectEncoderContext.f(f43988e, application.g());
            objectEncoderContext.f(f43989f, application.f());
            objectEncoderContext.f(f43990g, application.b());
            objectEncoderContext.f(f43991h, application.c());
        }
    }

    public static final class CrashlyticsReportSessionApplicationOrganizationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionApplicationOrganizationEncoder f43992a = new CrashlyticsReportSessionApplicationOrganizationEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43993b = FieldDescriptor.a("clsId");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((CrashlyticsReport.Session.Application.Organization) obj).getClass();
            ((ObjectEncoderContext) obj2).f(f43993b, null);
        }
    }

    public static final class CrashlyticsReportSessionDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Device> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionDeviceEncoder f43994a = new CrashlyticsReportSessionDeviceEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f43995b = FieldDescriptor.a("arch");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f43996c = FieldDescriptor.a("model");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f43997d = FieldDescriptor.a("cores");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f43998e = FieldDescriptor.a("ram");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f43999f = FieldDescriptor.a("diskSpace");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f44000g = FieldDescriptor.a("simulator");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f44001h = FieldDescriptor.a("state");

        /* renamed from: i, reason: collision with root package name */
        public static final FieldDescriptor f44002i = FieldDescriptor.a("manufacturer");

        /* renamed from: j, reason: collision with root package name */
        public static final FieldDescriptor f44003j = FieldDescriptor.a("modelClass");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.c(f43995b, device.b());
            objectEncoderContext.f(f43996c, device.f());
            objectEncoderContext.c(f43997d, device.c());
            objectEncoderContext.b(f43998e, device.h());
            objectEncoderContext.b(f43999f, device.d());
            objectEncoderContext.a(f44000g, device.j());
            objectEncoderContext.c(f44001h, device.i());
            objectEncoderContext.f(f44002i, device.e());
            objectEncoderContext.f(f44003j, device.g());
        }
    }

    public static final class CrashlyticsReportSessionEncoder implements ObjectEncoder<CrashlyticsReport.Session> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEncoder f44004a = new CrashlyticsReportSessionEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44005b = FieldDescriptor.a("generator");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44006c = FieldDescriptor.a("identifier");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44007d = FieldDescriptor.a("appQualitySessionId");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44008e = FieldDescriptor.a("startedAt");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44009f = FieldDescriptor.a("endedAt");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f44010g = FieldDescriptor.a("crashed");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f44011h = FieldDescriptor.a(Constants.APP_DIR);

        /* renamed from: i, reason: collision with root package name */
        public static final FieldDescriptor f44012i = FieldDescriptor.a(LogSubCategory.Action.USER);

        /* renamed from: j, reason: collision with root package name */
        public static final FieldDescriptor f44013j = FieldDescriptor.a("os");

        /* renamed from: k, reason: collision with root package name */
        public static final FieldDescriptor f44014k = FieldDescriptor.a(LogSubCategory.Context.DEVICE);

        /* renamed from: l, reason: collision with root package name */
        public static final FieldDescriptor f44015l = FieldDescriptor.a("events");

        /* renamed from: m, reason: collision with root package name */
        public static final FieldDescriptor f44016m = FieldDescriptor.a("generatorType");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44005b, session.g());
            objectEncoderContext.f(f44006c, session.i().getBytes(CrashlyticsReport.f44366a));
            objectEncoderContext.f(f44007d, session.c());
            objectEncoderContext.b(f44008e, session.k());
            objectEncoderContext.f(f44009f, session.e());
            objectEncoderContext.a(f44010g, session.m());
            objectEncoderContext.f(f44011h, session.b());
            objectEncoderContext.f(f44012i, session.l());
            objectEncoderContext.f(f44013j, session.j());
            objectEncoderContext.f(f44014k, session.d());
            objectEncoderContext.f(f44015l, session.f());
            objectEncoderContext.c(f44016m, session.h());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventApplicationEncoder f44017a = new CrashlyticsReportSessionEventApplicationEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44018b = FieldDescriptor.a("execution");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44019c = FieldDescriptor.a("customAttributes");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44020d = FieldDescriptor.a("internalKeys");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44021e = FieldDescriptor.a(AppStateModule.APP_STATE_BACKGROUND);

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44022f = FieldDescriptor.a("currentProcessDetails");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f44023g = FieldDescriptor.a("appProcessDetails");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f44024h = FieldDescriptor.a("uiOrientation");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44018b, application.f());
            objectEncoderContext.f(f44019c, application.e());
            objectEncoderContext.f(f44020d, application.g());
            objectEncoderContext.f(f44021e, application.c());
            objectEncoderContext.f(f44022f, application.d());
            objectEncoderContext.f(f44023g, application.b());
            objectEncoderContext.c(f44024h, application.h());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder f44025a = new CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44026b = FieldDescriptor.a("baseAddress");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44027c = FieldDescriptor.a("size");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44028d = FieldDescriptor.a(CLConstants.FIELD_PAY_INFO_NAME);

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44029e = FieldDescriptor.a("uuid");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.b(f44026b, binaryImage.b());
            objectEncoderContext.b(f44027c, binaryImage.d());
            objectEncoderContext.f(f44028d, binaryImage.c());
            String strE = binaryImage.e();
            objectEncoderContext.f(f44029e, strE != null ? strE.getBytes(CrashlyticsReport.f44366a) : null);
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventApplicationExecutionEncoder f44030a = new CrashlyticsReportSessionEventApplicationExecutionEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44031b = FieldDescriptor.a("threads");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44032c = FieldDescriptor.a(LogLevel.EXCEPTION);

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44033d = FieldDescriptor.a("appExitInfo");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44034e = FieldDescriptor.a("signal");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44035f = FieldDescriptor.a("binaries");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44031b, execution.f());
            objectEncoderContext.f(f44032c, execution.d());
            objectEncoderContext.f(f44033d, execution.b());
            objectEncoderContext.f(f44034e, execution.e());
            objectEncoderContext.f(f44035f, execution.c());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder f44036a = new CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44037b = FieldDescriptor.a("type");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44038c = FieldDescriptor.a("reason");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44039d = FieldDescriptor.a("frames");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44040e = FieldDescriptor.a("causedBy");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44041f = FieldDescriptor.a("overflowCount");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.Application.Execution.Exception exception = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44037b, exception.f());
            objectEncoderContext.f(f44038c, exception.e());
            objectEncoderContext.f(f44039d, exception.c());
            objectEncoderContext.f(f44040e, exception.b());
            objectEncoderContext.c(f44041f, exception.d());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventApplicationExecutionSignalEncoder f44042a = new CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44043b = FieldDescriptor.a(CLConstants.FIELD_PAY_INFO_NAME);

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44044c = FieldDescriptor.a("code");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44045d = FieldDescriptor.a("address");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44043b, signal.d());
            objectEncoderContext.f(f44044c, signal.c());
            objectEncoderContext.b(f44045d, signal.b());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventApplicationExecutionThreadEncoder f44046a = new CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44047b = FieldDescriptor.a(CLConstants.FIELD_PAY_INFO_NAME);

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44048c = FieldDescriptor.a("importance");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44049d = FieldDescriptor.a("frames");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44047b, thread.d());
            objectEncoderContext.c(f44048c, thread.c());
            objectEncoderContext.f(f44049d, thread.b());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder f44050a = new CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44051b = FieldDescriptor.a("pc");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44052c = FieldDescriptor.a("symbol");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44053d = FieldDescriptor.a(UtilsKt.SCHEME_FILE);

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44054e = FieldDescriptor.a("offset");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44055f = FieldDescriptor.a("importance");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.b(f44051b, frame.e());
            objectEncoderContext.f(f44052c, frame.f());
            objectEncoderContext.f(f44053d, frame.b());
            objectEncoderContext.b(f44054e, frame.d());
            objectEncoderContext.c(f44055f, frame.c());
        }
    }

    public static final class CrashlyticsReportSessionEventApplicationProcessDetailsEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.ProcessDetails> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventApplicationProcessDetailsEncoder f44056a = new CrashlyticsReportSessionEventApplicationProcessDetailsEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44057b = FieldDescriptor.a("processName");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44058c = FieldDescriptor.a("pid");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44059d = FieldDescriptor.a("importance");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44060e = FieldDescriptor.a("defaultProcess");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44057b, processDetails.d());
            objectEncoderContext.c(f44058c, processDetails.c());
            objectEncoderContext.c(f44059d, processDetails.b());
            objectEncoderContext.a(f44060e, processDetails.e());
        }
    }

    public static final class CrashlyticsReportSessionEventDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Device> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventDeviceEncoder f44061a = new CrashlyticsReportSessionEventDeviceEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44062b = FieldDescriptor.a("batteryLevel");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44063c = FieldDescriptor.a("batteryVelocity");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44064d = FieldDescriptor.a("proximityOn");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44065e = FieldDescriptor.a("orientation");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44066f = FieldDescriptor.a("ramUsed");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f44067g = FieldDescriptor.a("diskUsed");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44062b, device.b());
            objectEncoderContext.c(f44063c, device.c());
            objectEncoderContext.a(f44064d, device.g());
            objectEncoderContext.c(f44065e, device.e());
            objectEncoderContext.b(f44066f, device.f());
            objectEncoderContext.b(f44067g, device.d());
        }
    }

    public static final class CrashlyticsReportSessionEventEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventEncoder f44068a = new CrashlyticsReportSessionEventEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44069b = FieldDescriptor.a("timestamp");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44070c = FieldDescriptor.a("type");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44071d = FieldDescriptor.a(Constants.APP_DIR);

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44072e = FieldDescriptor.a(LogSubCategory.Context.DEVICE);

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44073f = FieldDescriptor.a("log");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f44074g = FieldDescriptor.a("rollouts");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.b(f44069b, event.f());
            objectEncoderContext.f(f44070c, event.g());
            objectEncoderContext.f(f44071d, event.b());
            objectEncoderContext.f(f44072e, event.c());
            objectEncoderContext.f(f44073f, event.d());
            objectEncoderContext.f(f44074g, event.e());
        }
    }

    public static final class CrashlyticsReportSessionEventLogEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Log> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventLogEncoder f44075a = new CrashlyticsReportSessionEventLogEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44076b = FieldDescriptor.a("content");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f44076b, ((CrashlyticsReport.Session.Event.Log) obj).b());
        }
    }

    public static final class CrashlyticsReportSessionEventRolloutAssignmentEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.RolloutAssignment> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventRolloutAssignmentEncoder f44077a = new CrashlyticsReportSessionEventRolloutAssignmentEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44078b = FieldDescriptor.a("rolloutVariant");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44079c = FieldDescriptor.a("parameterKey");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44080d = FieldDescriptor.a("parameterValue");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44081e = FieldDescriptor.a("templateVersion");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.RolloutAssignment rolloutAssignment = (CrashlyticsReport.Session.Event.RolloutAssignment) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44078b, rolloutAssignment.d());
            objectEncoderContext.f(f44079c, rolloutAssignment.b());
            objectEncoderContext.f(f44080d, rolloutAssignment.c());
            objectEncoderContext.b(f44081e, rolloutAssignment.e());
        }
    }

    public static final class CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder f44082a = new CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44083b = FieldDescriptor.a("rolloutId");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44084c = FieldDescriptor.a("variantId");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant = (CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44083b, rolloutVariant.b());
            objectEncoderContext.f(f44084c, rolloutVariant.c());
        }
    }

    public static final class CrashlyticsReportSessionEventRolloutsStateEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.RolloutsState> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionEventRolloutsStateEncoder f44085a = new CrashlyticsReportSessionEventRolloutsStateEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44086b = FieldDescriptor.a("assignments");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f44086b, ((CrashlyticsReport.Session.Event.RolloutsState) obj).b());
        }
    }

    public static final class CrashlyticsReportSessionOperatingSystemEncoder implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionOperatingSystemEncoder f44087a = new CrashlyticsReportSessionOperatingSystemEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44088b = FieldDescriptor.a("platform");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44089c = FieldDescriptor.a("version");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44090d = FieldDescriptor.a("buildVersion");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44091e = FieldDescriptor.a("jailbroken");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.c(f44088b, operatingSystem.c());
            objectEncoderContext.f(f44089c, operatingSystem.d());
            objectEncoderContext.f(f44090d, operatingSystem.b());
            objectEncoderContext.a(f44091e, operatingSystem.e());
        }
    }

    public static final class CrashlyticsReportSessionUserEncoder implements ObjectEncoder<CrashlyticsReport.Session.User> {

        /* renamed from: a, reason: collision with root package name */
        public static final CrashlyticsReportSessionUserEncoder f44092a = new CrashlyticsReportSessionUserEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44093b = FieldDescriptor.a("identifier");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f44093b, ((CrashlyticsReport.Session.User) obj).b());
        }
    }

    public final void a(EncoderConfig encoderConfig) {
        CrashlyticsReportEncoder crashlyticsReportEncoder = CrashlyticsReportEncoder.f43965a;
        JsonDataEncoderBuilder jsonDataEncoderBuilder = (JsonDataEncoderBuilder) encoderConfig;
        jsonDataEncoderBuilder.b(CrashlyticsReport.class, crashlyticsReportEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport.class, crashlyticsReportEncoder);
        CrashlyticsReportSessionEncoder crashlyticsReportSessionEncoder = CrashlyticsReportSessionEncoder.f44004a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.class, crashlyticsReportSessionEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session.class, crashlyticsReportSessionEncoder);
        CrashlyticsReportSessionApplicationEncoder crashlyticsReportSessionApplicationEncoder = CrashlyticsReportSessionApplicationEncoder.f43984a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Application.class, crashlyticsReportSessionApplicationEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Application.class, crashlyticsReportSessionApplicationEncoder);
        CrashlyticsReportSessionApplicationOrganizationEncoder crashlyticsReportSessionApplicationOrganizationEncoder = CrashlyticsReportSessionApplicationOrganizationEncoder.f43992a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Application.Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Application_Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        CrashlyticsReportSessionUserEncoder crashlyticsReportSessionUserEncoder = CrashlyticsReportSessionUserEncoder.f44092a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.User.class, crashlyticsReportSessionUserEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_User.class, crashlyticsReportSessionUserEncoder);
        CrashlyticsReportSessionOperatingSystemEncoder crashlyticsReportSessionOperatingSystemEncoder = CrashlyticsReportSessionOperatingSystemEncoder.f44087a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        CrashlyticsReportSessionDeviceEncoder crashlyticsReportSessionDeviceEncoder = CrashlyticsReportSessionDeviceEncoder.f43994a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Device.class, crashlyticsReportSessionDeviceEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Device.class, crashlyticsReportSessionDeviceEncoder);
        CrashlyticsReportSessionEventEncoder crashlyticsReportSessionEventEncoder = CrashlyticsReportSessionEventEncoder.f44068a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.class, crashlyticsReportSessionEventEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event.class, crashlyticsReportSessionEventEncoder);
        CrashlyticsReportSessionEventApplicationEncoder crashlyticsReportSessionEventApplicationEncoder = CrashlyticsReportSessionEventApplicationEncoder.f44017a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Application.class, crashlyticsReportSessionEventApplicationEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Application.class, crashlyticsReportSessionEventApplicationEncoder);
        CrashlyticsReportSessionEventApplicationExecutionEncoder crashlyticsReportSessionEventApplicationExecutionEncoder = CrashlyticsReportSessionEventApplicationExecutionEncoder.f44030a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Application.Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadEncoder crashlyticsReportSessionEventApplicationExecutionThreadEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.f44046a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.f44050a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder crashlyticsReportSessionEventApplicationExecutionExceptionEncoder = CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.f44036a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        CrashlyticsReportApplicationExitInfoEncoder crashlyticsReportApplicationExitInfoEncoder = CrashlyticsReportApplicationExitInfoEncoder.f43952a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder = CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder.f43948a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        CrashlyticsReportSessionEventApplicationExecutionSignalEncoder crashlyticsReportSessionEventApplicationExecutionSignalEncoder = CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.f44042a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder = CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.f44025a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        CrashlyticsReportCustomAttributeEncoder crashlyticsReportCustomAttributeEncoder = CrashlyticsReportCustomAttributeEncoder.f43962a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        CrashlyticsReportSessionEventApplicationProcessDetailsEncoder crashlyticsReportSessionEventApplicationProcessDetailsEncoder = CrashlyticsReportSessionEventApplicationProcessDetailsEncoder.f44056a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Application.ProcessDetails.class, crashlyticsReportSessionEventApplicationProcessDetailsEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails.class, crashlyticsReportSessionEventApplicationProcessDetailsEncoder);
        CrashlyticsReportSessionEventDeviceEncoder crashlyticsReportSessionEventDeviceEncoder = CrashlyticsReportSessionEventDeviceEncoder.f44061a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Device.class, crashlyticsReportSessionEventDeviceEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Device.class, crashlyticsReportSessionEventDeviceEncoder);
        CrashlyticsReportSessionEventLogEncoder crashlyticsReportSessionEventLogEncoder = CrashlyticsReportSessionEventLogEncoder.f44075a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.Log.class, crashlyticsReportSessionEventLogEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_Log.class, crashlyticsReportSessionEventLogEncoder);
        CrashlyticsReportSessionEventRolloutsStateEncoder crashlyticsReportSessionEventRolloutsStateEncoder = CrashlyticsReportSessionEventRolloutsStateEncoder.f44085a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.RolloutsState.class, crashlyticsReportSessionEventRolloutsStateEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_RolloutsState.class, crashlyticsReportSessionEventRolloutsStateEncoder);
        CrashlyticsReportSessionEventRolloutAssignmentEncoder crashlyticsReportSessionEventRolloutAssignmentEncoder = CrashlyticsReportSessionEventRolloutAssignmentEncoder.f44077a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.RolloutAssignment.class, crashlyticsReportSessionEventRolloutAssignmentEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment.class, crashlyticsReportSessionEventRolloutAssignmentEncoder);
        CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder crashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder = CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder.f44082a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.class, crashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant.class, crashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder);
        CrashlyticsReportFilesPayloadEncoder crashlyticsReportFilesPayloadEncoder = CrashlyticsReportFilesPayloadEncoder.f43978a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        CrashlyticsReportFilesPayloadFileEncoder crashlyticsReportFilesPayloadFileEncoder = CrashlyticsReportFilesPayloadFileEncoder.f43981a;
        jsonDataEncoderBuilder.b(CrashlyticsReport.FilesPayload.File.class, crashlyticsReportFilesPayloadFileEncoder);
        jsonDataEncoderBuilder.b(AutoValue_CrashlyticsReport_FilesPayload_File.class, crashlyticsReportFilesPayloadFileEncoder);
    }
}
