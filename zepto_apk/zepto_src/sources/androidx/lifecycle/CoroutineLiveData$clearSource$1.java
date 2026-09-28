package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {235}, m = "clearSource$lifecycle_livedata_release")
/* loaded from: classes3.dex */
final class CoroutineLiveData$clearSource$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public CoroutineLiveData f4776a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4777b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CoroutineLiveData f4778c;

    /* renamed from: d, reason: collision with root package name */
    public int f4779d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$clearSource$1(CoroutineLiveData coroutineLiveData, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f4778c = coroutineLiveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4777b = obj;
        this.f4779d |= Integer.MIN_VALUE;
        return this.f4778c.m(this);
    }
}
