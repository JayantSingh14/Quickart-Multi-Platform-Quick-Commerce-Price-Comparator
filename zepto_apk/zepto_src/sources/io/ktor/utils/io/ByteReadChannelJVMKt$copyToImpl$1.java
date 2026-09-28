package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", l = {309, 312}, m = "copyToImpl")
/* loaded from: classes3.dex */
final class ByteReadChannelJVMKt$copyToImpl$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteReadChannel f51078a;

    /* renamed from: b, reason: collision with root package name */
    public ByteWriteChannel f51079b;

    /* renamed from: c, reason: collision with root package name */
    public ChunkBuffer f51080c;

    /* renamed from: d, reason: collision with root package name */
    public long f51081d;

    /* renamed from: e, reason: collision with root package name */
    public long f51082e;

    /* renamed from: f, reason: collision with root package name */
    public int f51083f;

    /* renamed from: g, reason: collision with root package name */
    public int f51084g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f51085h;

    /* renamed from: i, reason: collision with root package name */
    public int f51086i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51085h = obj;
        this.f51086i |= Integer.MIN_VALUE;
        return ByteReadChannelJVMKt.b(null, null, 0L, this);
    }
}
