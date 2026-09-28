package io.ktor.serialization.kotlinx.json;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.serialization.KSerializer;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", l = {80, WKSRecord.Service.ERPC, WKSRecord.Service.SU_MIT_TG}, m = "serialize")
/* loaded from: classes3.dex */
final class KotlinxSerializationJsonExtensions$serialize$3<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f50409a;

    /* renamed from: b, reason: collision with root package name */
    public Object f50410b;

    /* renamed from: c, reason: collision with root package name */
    public KSerializer f50411c;

    /* renamed from: d, reason: collision with root package name */
    public Charset f50412d;

    /* renamed from: e, reason: collision with root package name */
    public ByteWriteChannel f50413e;

    /* renamed from: f, reason: collision with root package name */
    public Object f50414f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f50415g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ KotlinxSerializationJsonExtensions f50416h;

    /* renamed from: i, reason: collision with root package name */
    public int f50417i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationJsonExtensions$serialize$3(KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50416h = kotlinxSerializationJsonExtensions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50415g = obj;
        this.f50417i |= Integer.MIN_VALUE;
        return KotlinxSerializationJsonExtensions.c(this.f50416h, null, null, null, null, this);
    }
}
