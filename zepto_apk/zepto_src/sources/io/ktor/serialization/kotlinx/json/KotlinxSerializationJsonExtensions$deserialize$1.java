package io.ktor.serialization.kotlinx.json;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", l = {WKSRecord.Protocol.RVD}, m = "deserialize")
/* loaded from: classes3.dex */
final class KotlinxSerializationJsonExtensions$deserialize$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50400a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KotlinxSerializationJsonExtensions f50401b;

    /* renamed from: c, reason: collision with root package name */
    public int f50402c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationJsonExtensions$deserialize$1(KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50401b = kotlinxSerializationJsonExtensions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50400a = obj;
        this.f50402c |= Integer.MIN_VALUE;
        return this.f50401b.a(null, null, null, this);
    }
}
