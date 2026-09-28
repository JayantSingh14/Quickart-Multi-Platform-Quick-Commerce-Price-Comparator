package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", l = {83}, m = "completeWritingFallback")
/* loaded from: classes3.dex */
final class WriterSessionKt$completeWritingFallback$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ChunkBuffer f51164a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51165b;

    /* renamed from: c, reason: collision with root package name */
    public int f51166c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51165b = obj;
        this.f51166c |= Integer.MIN_VALUE;
        return WriterSessionKt.b(null, null, this);
    }
}
