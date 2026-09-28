package com.google.firebase.sessions.api;

import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.api.FirebaseSessionsDependencies", f = "FirebaseSessionsDependencies.kt", l = {124}, m = "getRegisteredSubscribers$com_google_firebase_firebase_sessions")
/* loaded from: classes.dex */
final class FirebaseSessionsDependencies$getRegisteredSubscribers$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Map f45129a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f45130b;

    /* renamed from: c, reason: collision with root package name */
    public SessionSubscriber.Name f45131c;

    /* renamed from: d, reason: collision with root package name */
    public Mutex f45132d;

    /* renamed from: e, reason: collision with root package name */
    public Map f45133e;

    /* renamed from: f, reason: collision with root package name */
    public Object f45134f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f45135g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ FirebaseSessionsDependencies f45136h;

    /* renamed from: i, reason: collision with root package name */
    public int f45137i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseSessionsDependencies$getRegisteredSubscribers$1(FirebaseSessionsDependencies firebaseSessionsDependencies, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f45136h = firebaseSessionsDependencies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f45135g = obj;
        this.f45137i |= Integer.MIN_VALUE;
        return this.f45136h.c(this);
    }
}
