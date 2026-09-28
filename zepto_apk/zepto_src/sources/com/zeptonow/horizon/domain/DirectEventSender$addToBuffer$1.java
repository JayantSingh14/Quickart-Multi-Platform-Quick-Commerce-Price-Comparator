package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.storage.EventEntity;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.DirectEventSender", f = "DirectEventSender.kt", l = {156}, m = "addToBuffer")
/* loaded from: classes4.dex */
final class DirectEventSender$addToBuffer$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public DirectEventSender f47873a;

    /* renamed from: b, reason: collision with root package name */
    public EventEntity f47874b;

    /* renamed from: c, reason: collision with root package name */
    public MutexImpl f47875c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f47876d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DirectEventSender f47877e;

    /* renamed from: f, reason: collision with root package name */
    public int f47878f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectEventSender$addToBuffer$1(DirectEventSender directEventSender, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f47877e = directEventSender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47876d = obj;
        this.f47878f |= Integer.MIN_VALUE;
        return DirectEventSender.a(this.f47877e, null, this);
    }
}
