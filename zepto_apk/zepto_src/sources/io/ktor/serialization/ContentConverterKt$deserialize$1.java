package io.ktor.serialization;

import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.serialization.ContentConverterKt", f = "ContentConverter.kt", l = {WKSRecord.Service.NTP}, m = "deserialize")
/* loaded from: classes3.dex */
final class ContentConverterKt$deserialize$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteReadChannel f50326a;

    /* renamed from: b, reason: collision with root package name */
    public TypeInfo f50327b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50328c;

    /* renamed from: d, reason: collision with root package name */
    public int f50329d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50328c = obj;
        this.f50329d |= Integer.MIN_VALUE;
        return ContentConverterKt.a(null, null, null, null, this);
    }
}
