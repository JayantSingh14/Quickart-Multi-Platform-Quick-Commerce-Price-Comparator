package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.firebase.sessions.SessionDatastoreImpl;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1", f = "SessionDatastore.kt", l = {WKSRecord.Service.MIT_DOV}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class SessionDatastoreImpl$updateSessionId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f45047a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SessionDatastoreImpl f45048b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f45049c;

    @Metadata
    @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1", f = "SessionDatastore.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f45050a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f45051b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Continuation continuation) {
            super(2, continuation);
            this.f45051b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f45051b, continuation);
            anonymousClass1.f45050a = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f45050a;
            Preferences.Key key = SessionDatastoreImpl.FirebaseSessionDataKeys.f45043a;
            mutablePreferences.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            mutablePreferences.d(key, this.f45051b);
            return Unit.f53572a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionDatastoreImpl$updateSessionId$1(SessionDatastoreImpl sessionDatastoreImpl, String str, Continuation continuation) {
        super(2, continuation);
        this.f45048b = sessionDatastoreImpl;
        this.f45049c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SessionDatastoreImpl$updateSessionId$1(this.f45048b, this.f45049c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SessionDatastoreImpl$updateSessionId$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f45047a;
        try {
            if (i2 == 0) {
                ResultKt.b(obj);
                DataStore dataStore = this.f45048b.f45030b;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f45049c, null);
                this.f45047a = 1;
                if (PreferencesKt.a(dataStore, anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (IOException e2) {
            Log.w("FirebaseSessionsRepo", "Failed to update session Id: " + e2);
        }
        return Unit.f53572a;
    }
}
