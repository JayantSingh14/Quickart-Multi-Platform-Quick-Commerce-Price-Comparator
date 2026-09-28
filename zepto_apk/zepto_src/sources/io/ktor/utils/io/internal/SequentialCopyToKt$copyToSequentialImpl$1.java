package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteChannelSequentialBase;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", l = {26, 31, 39}, m = "copyToSequentialImpl")
/* loaded from: classes3.dex */
final class SequentialCopyToKt$copyToSequentialImpl$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f51273a;

    /* renamed from: b, reason: collision with root package name */
    public ByteChannelSequentialBase f51274b;

    /* renamed from: c, reason: collision with root package name */
    public long f51275c;

    /* renamed from: d, reason: collision with root package name */
    public long f51276d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f51277e;

    /* renamed from: f, reason: collision with root package name */
    public int f51278f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51277e = obj;
        this.f51278f |= Integer.MIN_VALUE;
        return SequentialCopyToKt.a(null, null, 0L, this);
    }
}
