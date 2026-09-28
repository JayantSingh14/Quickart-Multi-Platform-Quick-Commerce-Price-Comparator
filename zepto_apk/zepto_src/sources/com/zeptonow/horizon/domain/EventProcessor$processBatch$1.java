package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.storage.EventStorage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventProcessor", f = "EventProcessor.kt", l = {WKSRecord.Service.PWDGEN, 33, 33, Type.A6}, m = "processBatch")
/* loaded from: classes.dex */
final class EventProcessor$processBatch$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public EventProcessor f48023a;

    /* renamed from: b, reason: collision with root package name */
    public Object f48024b;

    /* renamed from: c, reason: collision with root package name */
    public Object f48025c;

    /* renamed from: d, reason: collision with root package name */
    public EventStorage f48026d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f48027e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ EventProcessor f48028f;

    /* renamed from: g, reason: collision with root package name */
    public int f48029g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventProcessor$processBatch$1(EventProcessor eventProcessor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48028f = eventProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48027e = obj;
        this.f48029g |= Integer.MIN_VALUE;
        return this.f48028f.c(null, this);
    }
}
