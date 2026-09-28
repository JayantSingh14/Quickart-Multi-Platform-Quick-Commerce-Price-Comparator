package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.apache.commons.lang3.ClassUtils;

@Singleton
@Metadata
/* loaded from: classes.dex */
public final class FirebaseSessions {

    /* renamed from: a, reason: collision with root package name */
    public final FirebaseApp f44992a;

    /* renamed from: b, reason: collision with root package name */
    public final SessionsSettings f44993b;

    @Metadata
    @DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {51, 55}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.google.firebase.sessions.FirebaseSessions$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f44994a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f44996c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SessionLifecycleServiceBinder f44997d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CoroutineContext coroutineContext, SessionLifecycleServiceBinder sessionLifecycleServiceBinder, Continuation continuation) {
            super(2, continuation);
            this.f44996c = coroutineContext;
            this.f44997d = sessionLifecycleServiceBinder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FirebaseSessions.this.new AnonymousClass1(this.f44996c, this.f44997d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
        
            if (r7.b(r6) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r1 = r6.f44994a
                r2 = 1
                java.lang.String r3 = "FirebaseSessions"
                r4 = 2
                com.google.firebase.sessions.FirebaseSessions r5 = com.google.firebase.sessions.FirebaseSessions.this
                if (r1 == 0) goto L20
                if (r1 == r2) goto L1c
                if (r1 != r4) goto L14
                kotlin.ResultKt.b(r7)
                goto L65
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1c:
                kotlin.ResultKt.b(r7)
                goto L2e
            L20:
                kotlin.ResultKt.b(r7)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f45125a
                r6.f44994a = r2
                java.lang.Object r7 = r7.c(r6)
                if (r7 != r0) goto L2e
                goto L64
            L2e:
                java.util.Map r7 = (java.util.Map) r7
                java.util.Collection r7 = r7.values()
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                boolean r1 = r7 instanceof java.util.Collection
                if (r1 == 0) goto L44
                r1 = r7
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L44
                goto Lb3
            L44:
                java.util.Iterator r7 = r7.iterator()
            L48:
                boolean r1 = r7.hasNext()
                if (r1 == 0) goto Lb3
                java.lang.Object r1 = r7.next()
                com.google.firebase.sessions.api.SessionSubscriber r1 = (com.google.firebase.sessions.api.SessionSubscriber) r1
                boolean r1 = r1.a()
                if (r1 == 0) goto L48
                com.google.firebase.sessions.settings.SessionsSettings r7 = r5.f44993b
                r6.f44994a = r4
                java.lang.Object r7 = r7.b(r6)
                if (r7 != r0) goto L65
            L64:
                return r0
            L65:
                com.google.firebase.sessions.settings.SessionsSettings r7 = r5.f44993b
                com.google.firebase.sessions.settings.SettingsProvider r0 = r7.f45184a
                java.lang.Boolean r0 = r0.a()
                if (r0 == 0) goto L74
                boolean r2 = r0.booleanValue()
                goto L80
            L74:
                com.google.firebase.sessions.settings.SettingsProvider r7 = r7.f45185b
                java.lang.Boolean r7 = r7.a()
                if (r7 == 0) goto L80
                boolean r2 = r7.booleanValue()
            L80:
                if (r2 != 0) goto L88
                java.lang.String r7 = "Sessions SDK disabled. Not listening to lifecycle events."
                android.util.Log.d(r3, r7)
                goto Lb8
            L88:
                com.google.firebase.sessions.SessionLifecycleClient r7 = new com.google.firebase.sessions.SessionLifecycleClient
                kotlin.coroutines.CoroutineContext r0 = r6.f44996c
                r7.<init>(r0)
                com.google.firebase.sessions.SessionLifecycleServiceBinder r0 = r6.f44997d
                r7.c(r0)
                com.google.firebase.sessions.SessionsActivityLifecycleCallbacks.f45122c = r7
                boolean r0 = com.google.firebase.sessions.SessionsActivityLifecycleCallbacks.f45121b
                if (r0 == 0) goto La0
                r0 = 0
                com.google.firebase.sessions.SessionsActivityLifecycleCallbacks.f45121b = r0
                r7.d()
            La0:
                com.google.firebase.sessions.a r7 = new com.google.firebase.sessions.a
                r7.<init>()
                com.google.firebase.FirebaseApp r0 = r5.f44992a
                r0.a()
                com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
                java.util.concurrent.CopyOnWriteArrayList r0 = r0.f43498j
                r0.add(r7)
                goto Lb8
            Lb3:
                java.lang.String r7 = "No Sessions subscribers. Not listening to lifecycle events."
                android.util.Log.d(r3, r7)
            Lb8:
                kotlin.Unit r7 = kotlin.Unit.f53572a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata
    public static final class Companion {
    }

    public FirebaseSessions(FirebaseApp firebaseApp, SessionsSettings settings, CoroutineContext backgroundDispatcher, SessionLifecycleServiceBinder lifecycleServiceBinder) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(lifecycleServiceBinder, "lifecycleServiceBinder");
        this.f44992a = firebaseApp;
        this.f44993b = settings;
        Log.d(FirebaseSessionsRegistrar.TAG, "Initializing Firebase Sessions SDK.");
        firebaseApp.a();
        Context applicationContext = firebaseApp.f43489a.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(SessionsActivityLifecycleCallbacks.f45120a);
            BuildersKt.c(CoroutineScopeKt.a(backgroundDispatcher), null, new AnonymousClass1(backgroundDispatcher, lifecycleServiceBinder, null), 3);
        } else {
            Log.e(FirebaseSessionsRegistrar.TAG, "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
    }
}
