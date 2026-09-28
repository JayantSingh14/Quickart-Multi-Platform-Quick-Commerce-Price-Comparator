package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", l = {Type.CDS}, m = "serializeNullable")
/* loaded from: classes3.dex */
final class KotlinxSerializationConverter$serializeNullable$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public KotlinxSerializationConverter f50370a;

    /* renamed from: b, reason: collision with root package name */
    public ContentType f50371b;

    /* renamed from: c, reason: collision with root package name */
    public Charset f50372c;

    /* renamed from: d, reason: collision with root package name */
    public TypeInfo f50373d;

    /* renamed from: e, reason: collision with root package name */
    public Object f50374e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f50375f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ KotlinxSerializationConverter f50376g;

    /* renamed from: h, reason: collision with root package name */
    public int f50377h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationConverter$serializeNullable$1(KotlinxSerializationConverter kotlinxSerializationConverter, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50376g = kotlinxSerializationConverter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50375f = obj;
        this.f50377h |= Integer.MIN_VALUE;
        return this.f50376g.b(null, null, null, null, this);
    }
}
