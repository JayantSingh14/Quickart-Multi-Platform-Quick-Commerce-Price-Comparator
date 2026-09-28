package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {818}, m = "readBoolean")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readBoolean$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50687a;

    /* renamed from: b, reason: collision with root package name */
    public int f50688b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50687a = obj;
        this.f50688b |= Integer.MIN_VALUE;
        throw null;
    }
}
