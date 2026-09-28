package io.ktor.serialization.kotlinx;

import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", l = {WKSRecord.Service.NETRJS_4, 78}, m = "deserialize")
/* loaded from: classes3.dex */
final class KotlinxSerializationConverter$deserialize$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public KotlinxSerializationConverter f50361a;

    /* renamed from: b, reason: collision with root package name */
    public Charset f50362b;

    /* renamed from: c, reason: collision with root package name */
    public Object f50363c;

    /* renamed from: d, reason: collision with root package name */
    public ByteReadChannel f50364d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f50365e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ KotlinxSerializationConverter f50366f;

    /* renamed from: g, reason: collision with root package name */
    public int f50367g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationConverter$deserialize$1(KotlinxSerializationConverter kotlinxSerializationConverter, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50366f = kotlinxSerializationConverter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50365e = obj;
        this.f50367g |= Integer.MIN_VALUE;
        return this.f50366f.a(null, null, null, this);
    }
}
