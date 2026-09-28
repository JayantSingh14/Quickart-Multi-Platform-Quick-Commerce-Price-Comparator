package io.ktor.serialization.kotlinx.json;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.KSerializer;
import org.xbill.DNS.WKSRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 implements FlowCollector<Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f50389a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ByteWriteChannel f50390b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JsonArraySymbols f50391c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ KotlinxSerializationJsonExtensions f50392d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ KSerializer f50393e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Charset f50394f;

    @Metadata
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1", f = "KotlinxSerializationJsonExtensions.kt", l = {124, WKSRecord.Service.LOCUS_CON}, m = "emit")
    @SourceDebugExtension
    /* renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f50395a;

        /* renamed from: b, reason: collision with root package name */
        public int f50396b;

        /* renamed from: d, reason: collision with root package name */
        public KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 f50398d;

        /* renamed from: e, reason: collision with root package name */
        public Object f50399e;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f50395a = obj;
            this.f50396b |= Integer.MIN_VALUE;
            return KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.this.a(null, this);
        }
    }

    public KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1(ByteWriteChannel byteWriteChannel, JsonArraySymbols jsonArraySymbols, KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, KSerializer kSerializer, Charset charset) {
        this.f50390b = byteWriteChannel;
        this.f50391c = jsonArraySymbols;
        this.f50392d = kotlinxSerializationJsonExtensions;
        this.f50393e = kSerializer;
        this.f50394f = charset;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009a, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelKt.b(r6.f50390b, r7, r0) != r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.nio.charset.CharacterCodingException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1 r0 = (io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.AnonymousClass1) r0
            int r1 = r0.f50396b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50396b = r1
            goto L18
        L13:
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1 r0 = new io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f50395a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50396b
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L3d
            if (r2 == r3) goto L35
            if (r2 != r4) goto L2d
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 r6 = r0.f50398d
            kotlin.ResultKt.b(r7)
            goto L9d
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.f50399e
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 r2 = r0.f50398d
            kotlin.ResultKt.b(r7)
            goto L5e
        L3d:
            kotlin.ResultKt.b(r7)
            int r7 = r5.f50389a
            int r2 = r7 + 1
            r5.f50389a = r2
            if (r7 < 0) goto La5
            if (r7 <= 0) goto L61
            io.ktor.serialization.kotlinx.json.JsonArraySymbols r7 = r5.f50391c
            byte[] r7 = r7.f50381c
            r0.f50398d = r5
            r0.f50399e = r6
            r0.f50396b = r3
            io.ktor.utils.io.ByteWriteChannel r2 = r5.f50390b
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelKt.b(r2, r7, r0)
            if (r7 != r1) goto L5d
            goto L9c
        L5d:
            r2 = r5
        L5e:
            r7 = r6
            r6 = r2
            goto L63
        L61:
            r7 = r6
            r6 = r5
        L63:
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions r2 = r6.f50392d
            kotlinx.serialization.json.Json r2 = r2.f50387a
            kotlinx.serialization.KSerializer r3 = r6.f50393e
            java.lang.String r7 = r2.d(r3, r7)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.nio.charset.Charset r3 = r6.f50394f
            boolean r2 = kotlin.jvm.internal.Intrinsics.b(r3, r2)
            if (r2 == 0) goto L7c
            byte[] r7 = kotlin.text.StringsKt.q(r7)
            goto L8d
        L7c:
            java.nio.charset.CharsetEncoder r2 = r3.newEncoder()
            java.lang.String r3 = "charset.newEncoder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            int r3 = r7.length()
            byte[] r7 = io.ktor.utils.io.charsets.CharsetJVMKt.c(r2, r7, r3)
        L8d:
            r0.f50398d = r6
            r2 = 0
            r0.f50399e = r2
            r0.f50396b = r4
            io.ktor.utils.io.ByteWriteChannel r2 = r6.f50390b
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelKt.b(r2, r7, r0)
            if (r7 != r1) goto L9d
        L9c:
            return r1
        L9d:
            io.ktor.utils.io.ByteWriteChannel r6 = r6.f50390b
            r6.flush()
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        La5:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            java.lang.String r7 = "Index overflow has happened"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
