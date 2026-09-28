package com.zeptonow.horizon.storage;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.storage.PersistentStorage", f = "PersistentStorage.kt", l = {WKSRecord.Service.EMFIS_CNTL, ModuleDescriptor.MODULE_VERSION}, m = "removeEvents")
/* loaded from: classes.dex */
final class PersistentStorage$removeEvents$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public PersistentStorage f48200a;

    /* renamed from: b, reason: collision with root package name */
    public List f48201b;

    /* renamed from: c, reason: collision with root package name */
    public MutexImpl f48202c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f48203d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PersistentStorage f48204e;

    /* renamed from: f, reason: collision with root package name */
    public int f48205f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentStorage$removeEvents$1(PersistentStorage persistentStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48204e = persistentStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48203d = obj;
        this.f48205f |= Integer.MIN_VALUE;
        return this.f48204e.d(null, this);
    }
}
