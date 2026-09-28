package com.zeptonow.horizon.storage;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.storage.PersistentStorage", f = "PersistentStorage.kt", l = {WKSRecord.Service.EMFIS_CNTL, 148}, m = "resetInProgressEvents")
/* loaded from: classes.dex */
final class PersistentStorage$resetInProgressEvents$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public PersistentStorage f48206a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f48207b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f48208c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PersistentStorage f48209d;

    /* renamed from: e, reason: collision with root package name */
    public int f48210e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentStorage$resetInProgressEvents$1(PersistentStorage persistentStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48209d = persistentStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48208c = obj;
        this.f48210e |= Integer.MIN_VALUE;
        return this.f48209d.g(this);
    }
}
