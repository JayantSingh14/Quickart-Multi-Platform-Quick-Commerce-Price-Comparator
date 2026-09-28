package io.ktor.serialization.kotlinx.json;

import io.ktor.http.ContentType;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.serialization.kotlinx.KotlinxSerializationExtension;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.json.Json;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class KotlinxSerializationJsonExtensions implements KotlinxSerializationExtension {

    /* renamed from: a, reason: collision with root package name */
    public final Json f50387a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f50388b;

    public KotlinxSerializationJsonExtensions(Json format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.f50387a = format;
        this.f50388b = new LinkedHashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c4, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelKt.b(r11, r10, r3) != r4) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions r10, kotlinx.coroutines.flow.Flow r11, kotlinx.serialization.KSerializer r12, java.nio.charset.Charset r13, io.ktor.utils.io.ByteWriteChannel r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions.c(io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions, kotlinx.coroutines.flow.Flow, kotlinx.serialization.KSerializer, java.nio.charset.Charset, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.nio.charset.Charset r5, io.ktor.util.reflect.TypeInfo r6, io.ktor.utils.io.ByteReadChannel r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws io.ktor.serialization.JsonConvertException {
        /*
            r4 = this;
            boolean r0 = r8 instanceof io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1 r0 = (io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1) r0
            int r1 = r0.f50402c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50402c = r1
            goto L18
        L13:
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1 r0 = new io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f50400a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50402c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L27
            return r8
        L27:
            r5 = move-exception
            goto L57
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r8)
            java.nio.charset.Charset r8 = kotlin.text.Charsets.UTF_8
            boolean r5 = kotlin.jvm.internal.Intrinsics.b(r5, r8)
            if (r5 == 0) goto L6f
            kotlin.reflect.KClass r5 = r6.f50602a
            java.lang.Class<kotlin.sequences.Sequence> r8 = kotlin.sequences.Sequence.class
            kotlin.jvm.internal.ClassReference r8 = kotlin.jvm.internal.Reflection.a(r8)
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L4b
            goto L6f
        L4b:
            kotlinx.serialization.json.Json r5 = r4.f50387a     // Catch: java.lang.Throwable -> L27
            r0.f50402c = r3     // Catch: java.lang.Throwable -> L27
            java.lang.Object r5 = io.ktor.serialization.kotlinx.json.JsonExtensionsJvmKt.a(r6, r7, r0, r5)     // Catch: java.lang.Throwable -> L27
            if (r5 != r1) goto L56
            return r1
        L56:
            return r5
        L57:
            io.ktor.serialization.JsonConvertException r6 = new io.ktor.serialization.JsonConvertException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Illegal input: "
            r7.<init>(r8)
            java.lang.String r8 = r5.getMessage()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7, r5)
            throw r6
        L6f:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions.a(java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    public final ChannelWriterContent b(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj) {
        if (!Intrinsics.b(charset, Charsets.UTF_8) || !typeInfo.f50602a.equals(Reflection.a(Flow.class))) {
            return null;
        }
        KotlinxSerializationJsonExtensionsKt.a(typeInfo);
        throw null;
    }
}
