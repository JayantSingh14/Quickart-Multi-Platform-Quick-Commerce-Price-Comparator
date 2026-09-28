package com.zeptonow.horizon.storage;

import com.zeptonow.horizon.entity.EventStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.storage.PersistentStorage", f = "PersistentStorage.kt", l = {WKSRecord.Service.EMFIS_CNTL, 148}, m = "updateStatusForEvents")
/* loaded from: classes.dex */
final class PersistentStorage$updateStatusForEvents$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public PersistentStorage f48218a;

    /* renamed from: b, reason: collision with root package name */
    public List f48219b;

    /* renamed from: c, reason: collision with root package name */
    public EventStatus f48220c;

    /* renamed from: d, reason: collision with root package name */
    public MutexImpl f48221d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f48222e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ PersistentStorage f48223f;

    /* renamed from: g, reason: collision with root package name */
    public int f48224g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentStorage$updateStatusForEvents$1(PersistentStorage persistentStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48223f = persistentStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48222e = obj;
        this.f48224g |= Integer.MIN_VALUE;
        return this.f48223f.j(null, null, this);
    }
}
