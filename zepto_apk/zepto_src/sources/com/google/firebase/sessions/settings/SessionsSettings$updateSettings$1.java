package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.settings.SessionsSettings", f = "SessionsSettings.kt", l = {WKSRecord.Service.TACNEWS, 99}, m = "updateSettings")
/* loaded from: classes4.dex */
final class SessionsSettings$updateSettings$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SessionsSettings f45186a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f45187b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SessionsSettings f45188c;

    /* renamed from: d, reason: collision with root package name */
    public int f45189d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionsSettings$updateSettings$1(SessionsSettings sessionsSettings, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f45188c = sessionsSettings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f45187b = obj;
        this.f45189d |= Integer.MIN_VALUE;
        return this.f45188c.b(this);
    }
}
