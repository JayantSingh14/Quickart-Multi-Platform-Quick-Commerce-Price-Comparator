package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", l = {100}, m = "shouldLogSession")
/* loaded from: classes4.dex */
final class SessionFirelogPublisherImpl$shouldLogSession$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SessionFirelogPublisherImpl f45078a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f45079b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SessionFirelogPublisherImpl f45080c;

    /* renamed from: d, reason: collision with root package name */
    public int f45081d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionFirelogPublisherImpl$shouldLogSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f45080c = sessionFirelogPublisherImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f45079b = obj;
        this.f45081d |= Integer.MIN_VALUE;
        return SessionFirelogPublisherImpl.b(this.f45080c, this);
    }
}
