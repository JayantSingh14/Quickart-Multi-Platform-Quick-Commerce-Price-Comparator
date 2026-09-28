package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$firebaseSessionDataFlow$1", f = "SessionDatastore.kt", l = {78}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class SessionDatastoreImpl$firebaseSessionDataFlow$1 extends SuspendLambda implements Function3<FlowCollector<? super Preferences>, Throwable, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f45044a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ FlowCollector f45045b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Throwable f45046c;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        SessionDatastoreImpl$firebaseSessionDataFlow$1 sessionDatastoreImpl$firebaseSessionDataFlow$1 = new SessionDatastoreImpl$firebaseSessionDataFlow$1(3, (Continuation) obj3);
        sessionDatastoreImpl$firebaseSessionDataFlow$1.f45045b = (FlowCollector) obj;
        sessionDatastoreImpl$firebaseSessionDataFlow$1.f45046c = (Throwable) obj2;
        return sessionDatastoreImpl$firebaseSessionDataFlow$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f45044a;
        if (i2 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = this.f45045b;
            Log.e("FirebaseSessionsRepo", "Error reading stored session data.", this.f45046c);
            MutablePreferences mutablePreferences = new MutablePreferences(true, 1);
            this.f45045b = null;
            this.f45044a = 1;
            if (flowCollector.a(mutablePreferences, this) == coroutineSingletons) {
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
