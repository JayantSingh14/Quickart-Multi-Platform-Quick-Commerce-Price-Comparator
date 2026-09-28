package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Singleton
@Metadata
/* loaded from: classes4.dex */
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {

    /* renamed from: f, reason: collision with root package name */
    public static final double f45062f = Math.random();

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f45063g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final FirebaseApp f45064a;

    /* renamed from: b, reason: collision with root package name */
    public final FirebaseInstallationsApi f45065b;

    /* renamed from: c, reason: collision with root package name */
    public final SessionsSettings f45066c;

    /* renamed from: d, reason: collision with root package name */
    public final EventGDTLoggerInterface f45067d;

    /* renamed from: e, reason: collision with root package name */
    public final CoroutineContext f45068e;

    @Metadata
    public static final class Companion {
    }

    public SessionFirelogPublisherImpl(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallations, SessionsSettings sessionSettings, EventGDTLoggerInterface eventGDTLogger, CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(firebaseInstallations, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(sessionSettings, "sessionSettings");
        Intrinsics.checkNotNullParameter(eventGDTLogger, "eventGDTLogger");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.f45064a = firebaseApp;
        this.f45065b = firebaseInstallations;
        this.f45066c = sessionSettings;
        this.f45067d = eventGDTLogger;
        this.f45068e = backgroundDispatcher;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(com.google.firebase.sessions.SessionFirelogPublisherImpl r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r5.getClass()
            boolean r0 = r6 instanceof com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            if (r0 == 0) goto L16
            r0 = r6
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1) r0
            int r1 = r0.f45081d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f45081d = r1
            goto L1b
        L16:
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = new com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            r0.<init>(r5, r6)
        L1b:
            java.lang.Object r6 = r0.f45079b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f45081d
            r3 = 1
            java.lang.String r4 = "SessionFirelogPublisher"
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            com.google.firebase.sessions.SessionFirelogPublisherImpl r5 = r0.f45078a
            kotlin.ResultKt.b(r6)
            goto L4b
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.b(r6)
            java.lang.String r6 = "Data Collection is enabled for at least one Subscriber"
            android.util.Log.d(r4, r6)
            r0.f45078a = r5
            r0.f45081d = r3
            com.google.firebase.sessions.settings.SessionsSettings r6 = r5.f45066c
            java.lang.Object r6 = r6.b(r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            com.google.firebase.sessions.settings.SessionsSettings r6 = r5.f45066c
            com.google.firebase.sessions.settings.SettingsProvider r0 = r6.f45184a
            java.lang.Boolean r0 = r0.a()
            if (r0 == 0) goto L5a
            boolean r3 = r0.booleanValue()
            goto L66
        L5a:
            com.google.firebase.sessions.settings.SettingsProvider r6 = r6.f45185b
            java.lang.Boolean r6 = r6.a()
            if (r6 == 0) goto L66
            boolean r3 = r6.booleanValue()
        L66:
            if (r3 != 0) goto L70
            java.lang.String r5 = "Sessions SDK disabled. Events will not be sent."
            android.util.Log.d(r4, r5)
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L70:
            com.google.firebase.sessions.settings.SessionsSettings r5 = r5.f45066c
            double r5 = r5.a()
            double r0 = com.google.firebase.sessions.SessionFirelogPublisherImpl.f45062f
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 > 0) goto L7f
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        L7f:
            java.lang.String r5 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r4, r5)
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.b(com.google.firebase.sessions.SessionFirelogPublisherImpl, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public final void a(SessionDetails sessionDetails) {
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        BuildersKt.c(CoroutineScopeKt.a(this.f45068e), null, new SessionFirelogPublisherImpl$logSession$1(this, sessionDetails, null), 3);
    }
}
