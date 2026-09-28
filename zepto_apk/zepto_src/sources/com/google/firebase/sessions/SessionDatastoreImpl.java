package com.google.firebase.sessions;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Singleton
@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class SessionDatastoreImpl implements SessionDatastore {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f45029a;

    /* renamed from: b, reason: collision with root package name */
    public final DataStore f45030b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f45031c;

    /* renamed from: d, reason: collision with root package name */
    public final SessionDatastoreImpl$special$$inlined$map$1 f45032d;

    @Metadata
    @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$1", f = "SessionDatastore.kt", l = {84}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f45040a;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return SessionDatastoreImpl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f45040a;
            if (i2 == 0) {
                ResultKt.b(obj);
                final SessionDatastoreImpl sessionDatastoreImpl = SessionDatastoreImpl.this;
                SessionDatastoreImpl$special$$inlined$map$1 sessionDatastoreImpl$special$$inlined$map$1 = sessionDatastoreImpl.f45032d;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.google.firebase.sessions.SessionDatastoreImpl.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object a(Object obj2, Continuation continuation) {
                        sessionDatastoreImpl.f45031c.set((FirebaseSessionsData) obj2);
                        return Unit.f53572a;
                    }
                };
                this.f45040a = 1;
                if (sessionDatastoreImpl$special$$inlined$map$1.c(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f53572a;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class FirebaseSessionDataKeys {

        /* renamed from: a, reason: collision with root package name */
        public static final Preferences.Key f45043a = PreferencesKeys.a("session_id");
    }

    public SessionDatastoreImpl(CoroutineContext backgroundDispatcher, DataStore dataStore) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.f45029a = backgroundDispatcher;
        this.f45030b = dataStore;
        this.f45031c = new AtomicReference();
        this.f45032d = new SessionDatastoreImpl$special$$inlined$map$1(FlowKt.b(dataStore.getData(), new SessionDatastoreImpl$firebaseSessionDataFlow$1(3, null)), this);
        BuildersKt.c(CoroutineScopeKt.a(backgroundDispatcher), null, new AnonymousClass1(null), 3);
    }

    @Override // com.google.firebase.sessions.SessionDatastore
    public final String a() {
        FirebaseSessionsData firebaseSessionsData = (FirebaseSessionsData) this.f45031c.get();
        if (firebaseSessionsData != null) {
            return firebaseSessionsData.f45007a;
        }
        return null;
    }

    @Override // com.google.firebase.sessions.SessionDatastore
    public final void b(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        BuildersKt.c(CoroutineScopeKt.a(this.f45029a), null, new SessionDatastoreImpl$updateSessionId$1(this, sessionId, null), 3);
    }
}
