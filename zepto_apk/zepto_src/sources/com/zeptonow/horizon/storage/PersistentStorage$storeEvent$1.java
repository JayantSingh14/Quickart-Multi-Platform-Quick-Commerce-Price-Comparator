package com.zeptonow.horizon.storage;

import com.zeptonow.horizon.entity.Event;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.storage.PersistentStorage", f = "PersistentStorage.kt", l = {WKSRecord.Service.EMFIS_CNTL, 148}, m = "storeEvent")
/* loaded from: classes.dex */
final class PersistentStorage$storeEvent$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public PersistentStorage f48211a;

    /* renamed from: b, reason: collision with root package name */
    public Event f48212b;

    /* renamed from: c, reason: collision with root package name */
    public String f48213c;

    /* renamed from: d, reason: collision with root package name */
    public MutexImpl f48214d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f48215e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ PersistentStorage f48216f;

    /* renamed from: g, reason: collision with root package name */
    public int f48217g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentStorage$storeEvent$1(PersistentStorage persistentStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48216f = persistentStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48215e = obj;
        this.f48217g |= Integer.MIN_VALUE;
        return this.f48216f.h(null, null, this);
    }
}
