package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", l = {177, 83, 101}, m = "updateSettings")
/* loaded from: classes4.dex */
final class RemoteSettings$updateSettings$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f45154a;

    /* renamed from: b, reason: collision with root package name */
    public Mutex f45155b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f45156c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RemoteSettings f45157d;

    /* renamed from: e, reason: collision with root package name */
    public int f45158e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$1(RemoteSettings remoteSettings, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f45157d = remoteSettings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f45156c = obj;
        this.f45158e |= Integer.MIN_VALUE;
        return this.f45157d.d(this);
    }
}
