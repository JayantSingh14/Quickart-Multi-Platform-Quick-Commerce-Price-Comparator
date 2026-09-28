package com.zeptonow.horizon.storage;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.storage.PersistentStorage", f = "PersistentStorage.kt", l = {WKSRecord.Service.EMFIS_CNTL, ModuleDescriptor.MODULE_VERSION}, m = "markEventsFailed")
/* loaded from: classes4.dex */
final class PersistentStorage$markEventsFailed$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public PersistentStorage f48193a;

    /* renamed from: b, reason: collision with root package name */
    public List f48194b;

    /* renamed from: c, reason: collision with root package name */
    public String f48195c;

    /* renamed from: d, reason: collision with root package name */
    public MutexImpl f48196d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f48197e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ PersistentStorage f48198f;

    /* renamed from: g, reason: collision with root package name */
    public int f48199g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentStorage$markEventsFailed$1(PersistentStorage persistentStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48198f = persistentStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48197e = obj;
        this.f48199g |= Integer.MIN_VALUE;
        return this.f48198f.c(null, null, this);
    }
}
