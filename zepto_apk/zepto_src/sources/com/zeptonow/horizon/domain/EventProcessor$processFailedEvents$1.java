package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.storage.EventStorage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventProcessor", f = "EventProcessor.kt", l = {WKSRecord.Service.PWDGEN, 65, 65, 70, 78, 85, 90}, m = "processFailedEvents")
/* loaded from: classes.dex */
final class EventProcessor$processFailedEvents$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f48038a;

    /* renamed from: b, reason: collision with root package name */
    public Object f48039b;

    /* renamed from: c, reason: collision with root package name */
    public Object f48040c;

    /* renamed from: d, reason: collision with root package name */
    public EventStorage f48041d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f48042e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ EventProcessor f48043f;

    /* renamed from: g, reason: collision with root package name */
    public int f48044g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventProcessor$processFailedEvents$1(EventProcessor eventProcessor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48043f = eventProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48042e = obj;
        this.f48044g |= Integer.MIN_VALUE;
        return this.f48043f.d(null, this);
    }
}
