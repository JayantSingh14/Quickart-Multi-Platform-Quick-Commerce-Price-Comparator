package com.zeptonow.horizon.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventProcessor", f = "EventProcessor.kt", l = {99, WKSRecord.Service.NETBIOS_SSN, WKSRecord.Service.SUNRPC, 112}, m = "handleFailedEvents")
/* loaded from: classes4.dex */
final class EventProcessor$handleFailedEvents$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f48012a;

    /* renamed from: b, reason: collision with root package name */
    public String f48013b;

    /* renamed from: c, reason: collision with root package name */
    public List f48014c;

    /* renamed from: d, reason: collision with root package name */
    public Object f48015d;

    /* renamed from: e, reason: collision with root package name */
    public MutexImpl f48016e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f48017f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ EventProcessor f48018g;

    /* renamed from: h, reason: collision with root package name */
    public int f48019h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventProcessor$handleFailedEvents$1(EventProcessor eventProcessor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48018g = eventProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48017f = obj;
        this.f48019h |= Integer.MIN_VALUE;
        return this.f48018g.b(null, null, this);
    }
}
