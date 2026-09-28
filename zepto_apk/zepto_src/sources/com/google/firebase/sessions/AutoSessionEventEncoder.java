package com.google.firebase.sessions;

import android.os.Build;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class AutoSessionEventEncoder implements Configurator {

    public static final class AndroidApplicationInfoEncoder implements ObjectEncoder<AndroidApplicationInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final AndroidApplicationInfoEncoder f44925a = new AndroidApplicationInfoEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44926b = FieldDescriptor.a("packageName");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44927c = FieldDescriptor.a("versionName");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44928d = FieldDescriptor.a("appBuildVersion");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44929e = FieldDescriptor.a("deviceManufacturer");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44930f = FieldDescriptor.a("currentProcessDetails");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f44931g = FieldDescriptor.a("appProcessDetails");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            AndroidApplicationInfo androidApplicationInfo = (AndroidApplicationInfo) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44926b, androidApplicationInfo.f44918a);
            objectEncoderContext.f(f44927c, androidApplicationInfo.f44919b);
            objectEncoderContext.f(f44928d, androidApplicationInfo.f44920c);
            objectEncoderContext.f(f44929e, Build.MANUFACTURER);
            objectEncoderContext.f(f44930f, androidApplicationInfo.f44921d);
            objectEncoderContext.f(f44931g, androidApplicationInfo.f44922e);
        }
    }

    public static final class ApplicationInfoEncoder implements ObjectEncoder<ApplicationInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final ApplicationInfoEncoder f44932a = new ApplicationInfoEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44933b = FieldDescriptor.a(CLConstants.SALT_FIELD_APP_ID);

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44934c = FieldDescriptor.a("deviceModel");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44935d = FieldDescriptor.a("sessionSdkVersion");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44936e = FieldDescriptor.a("osVersion");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44937f = FieldDescriptor.a("logEnvironment");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f44938g = FieldDescriptor.a("androidAppInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ApplicationInfo applicationInfo = (ApplicationInfo) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44933b, applicationInfo.f44923a);
            objectEncoderContext.f(f44934c, Build.MODEL);
            objectEncoderContext.f(f44935d, "2.1.2");
            objectEncoderContext.f(f44936e, Build.VERSION.RELEASE);
            objectEncoderContext.f(f44937f, LogEnvironment.LOG_ENVIRONMENT_PROD);
            objectEncoderContext.f(f44938g, applicationInfo.f44924b);
        }
    }

    public static final class DataCollectionStatusEncoder implements ObjectEncoder<DataCollectionStatus> {

        /* renamed from: a, reason: collision with root package name */
        public static final DataCollectionStatusEncoder f44939a = new DataCollectionStatusEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44940b = FieldDescriptor.a("performance");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44941c = FieldDescriptor.a("crashlytics");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44942d = FieldDescriptor.a("sessionSamplingRate");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            DataCollectionStatus dataCollectionStatus = (DataCollectionStatus) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44940b, dataCollectionStatus.f44984a);
            objectEncoderContext.f(f44941c, dataCollectionStatus.f44985b);
            objectEncoderContext.d(f44942d, dataCollectionStatus.f44986c);
        }
    }

    public static final class ProcessDetailsEncoder implements ObjectEncoder<ProcessDetails> {

        /* renamed from: a, reason: collision with root package name */
        public static final ProcessDetailsEncoder f44943a = new ProcessDetailsEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44944b = FieldDescriptor.a("processName");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44945c = FieldDescriptor.a("pid");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44946d = FieldDescriptor.a("importance");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44947e = FieldDescriptor.a("defaultProcess");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ProcessDetails processDetails = (ProcessDetails) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44944b, processDetails.f45023a);
            objectEncoderContext.c(f44945c, processDetails.f45024b);
            objectEncoderContext.c(f44946d, processDetails.f45025c);
            objectEncoderContext.a(f44947e, processDetails.f45026d);
        }
    }

    public static final class SessionEventEncoder implements ObjectEncoder<SessionEvent> {

        /* renamed from: a, reason: collision with root package name */
        public static final SessionEventEncoder f44948a = new SessionEventEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44949b = FieldDescriptor.a("eventType");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44950c = FieldDescriptor.a("sessionData");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44951d = FieldDescriptor.a("applicationInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            SessionEvent sessionEvent = (SessionEvent) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            sessionEvent.getClass();
            objectEncoderContext.f(f44949b, EventType.SESSION_START);
            objectEncoderContext.f(f44950c, sessionEvent.f45058a);
            objectEncoderContext.f(f44951d, sessionEvent.f45059b);
        }
    }

    public static final class SessionInfoEncoder implements ObjectEncoder<SessionInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final SessionInfoEncoder f44952a = new SessionInfoEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44953b = FieldDescriptor.a("sessionId");

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44954c = FieldDescriptor.a("firstSessionId");

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44955d = FieldDescriptor.a("sessionIndex");

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44956e = FieldDescriptor.a("eventTimestampUs");

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44957f = FieldDescriptor.a("dataCollectionStatus");

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f44958g = FieldDescriptor.a("firebaseInstallationId");

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f44959h = FieldDescriptor.a("firebaseAuthenticationToken");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            SessionInfo sessionInfo = (SessionInfo) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.f(f44953b, sessionInfo.f45094a);
            objectEncoderContext.f(f44954c, sessionInfo.f45095b);
            objectEncoderContext.c(f44955d, sessionInfo.f45096c);
            objectEncoderContext.b(f44956e, sessionInfo.f45097d);
            objectEncoderContext.f(f44957f, sessionInfo.f45098e);
            objectEncoderContext.f(f44958g, sessionInfo.f45099f);
            objectEncoderContext.f(f44959h, sessionInfo.f45100g);
        }
    }
}
