package io.ktor.util;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {Type.TLSA}, m = "deflateWhile")
/* loaded from: classes3.dex */
final class DeflaterKt$deflateWhile$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteWriteChannel f50461a;

    /* renamed from: b, reason: collision with root package name */
    public Deflater f50462b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f50463c;

    /* renamed from: d, reason: collision with root package name */
    public Function0 f50464d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f50465e;

    /* renamed from: f, reason: collision with root package name */
    public int f50466f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50465e = obj;
        this.f50466f |= Integer.MIN_VALUE;
        return DeflaterKt.a(null, null, null, null, this);
    }
}
