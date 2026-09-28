package androidx.datastore.core;

import androidx.datastore.core.DataStoreImpl;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1", f = "DataStoreImpl.kt", l = {437, 458, 546, 468}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class DataStoreImpl$InitDataStore$doRun$initData$1 extends SuspendLambda implements Function1<Continuation<? super Data<Object>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f3419a;

    /* renamed from: b, reason: collision with root package name */
    public Serializable f3420b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3421c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3422d;

    /* renamed from: e, reason: collision with root package name */
    public Iterator f3423e;

    /* renamed from: f, reason: collision with root package name */
    public int f3424f;

    /* renamed from: g, reason: collision with root package name */
    public int f3425g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3426h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl.InitDataStore f3427i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$InitDataStore$doRun$initData$1(DataStoreImpl dataStoreImpl, DataStoreImpl.InitDataStore initDataStore, Continuation continuation) {
        super(1, continuation);
        this.f3426h = dataStoreImpl;
        this.f3427i = initDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DataStoreImpl$InitDataStore$doRun$initData$1(this.f3426h, this.f3427i, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((DataStoreImpl$InitDataStore$doRun$initData$1) create((Continuation) obj)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws androidx.datastore.core.CorruptionException {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
