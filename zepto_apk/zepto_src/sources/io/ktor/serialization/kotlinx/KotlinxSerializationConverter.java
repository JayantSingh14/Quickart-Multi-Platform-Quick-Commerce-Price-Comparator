package io.ktor.serialization.kotlinx;

import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.StringFormat;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class KotlinxSerializationConverter implements ContentConverter {

    /* renamed from: a, reason: collision with root package name */
    public final SerialFormat f50333a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f50334b;

    public KotlinxSerializationConverter(SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.f50333a = format;
        Intrinsics.checkNotNullParameter(format, "format");
        List list = ExtensionsJvmKt.f50332a;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensionsA = ((KotlinxSerializationExtensionProvider) it.next()).a(format);
            if (kotlinxSerializationJsonExtensionsA != null) {
                arrayList.add(kotlinxSerializationJsonExtensionsA);
            }
        }
        this.f50334b = arrayList;
        SerialFormat serialFormat = this.f50333a;
        if ((serialFormat instanceof BinaryFormat) || (serialFormat instanceof StringFormat)) {
            return;
        }
        throw new IllegalArgumentException(("Only binary and string formats are supported, " + this.f50333a + " is not supported.").toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5 A[Catch: all -> 0x00c0, TryCatch #0 {all -> 0x00c0, blocks: (B:31:0x00af, B:33:0x00b5, B:37:0x00c2, B:39:0x00c6, B:41:0x00d0, B:42:0x00ea), top: B:45:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2 A[Catch: all -> 0x00c0, TryCatch #0 {all -> 0x00c0, blocks: (B:31:0x00af, B:33:0x00b5, B:37:0x00c2, B:39:0x00c6, B:41:0x00d0, B:42:0x00ea), top: B:45:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(final java.nio.charset.Charset r9, final io.ktor.util.reflect.TypeInfo r10, final io.ktor.utils.io.ByteReadChannel r11, kotlin.coroutines.jvm.internal.ContinuationImpl r12) throws java.lang.IllegalAccessException, io.ktor.serialization.JsonConvertException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationConverter.a(java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(final io.ktor.http.ContentType r11, final java.nio.charset.Charset r12, final io.ktor.util.reflect.TypeInfo r13, final java.lang.Object r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r10 = this;
            boolean r0 = r15 instanceof io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1
            if (r0 == 0) goto L13
            r0 = r15
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1 r0 = (io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1) r0
            int r1 = r0.f50377h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50377h = r1
            goto L18
        L13:
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1 r0 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1
            r0.<init>(r10, r15)
        L18:
            java.lang.Object r15 = r0.f50375f
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50377h
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r14 = r0.f50374e
            io.ktor.util.reflect.TypeInfo r13 = r0.f50373d
            java.nio.charset.Charset r12 = r0.f50372c
            io.ktor.http.ContentType r11 = r0.f50371b
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter r0 = r0.f50370a
            kotlin.ResultKt.b(r15)
            goto L69
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            kotlin.ResultKt.b(r15)
            java.util.ArrayList r15 = r10.f50334b
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3 r5 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3
            r5.<init>(r15)
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$$inlined$map$1 r4 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$$inlined$map$1
            r6 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r4.<init>()
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$fromExtension$2 r11 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$fromExtension$2
            r11.<init>()
            r0.f50370a = r10
            r0.f50371b = r6
            r0.f50372c = r7
            r0.f50373d = r8
            r0.f50374e = r9
            r0.f50377h = r3
            java.lang.Object r15 = kotlinx.coroutines.flow.FlowKt.k(r4, r11, r0)
            if (r15 != r1) goto L64
            return r1
        L64:
            r0 = r10
            r11 = r6
            r12 = r7
            r13 = r8
            r14 = r9
        L69:
            io.ktor.http.content.OutgoingContent r15 = (io.ktor.http.content.OutgoingContent) r15
            if (r15 == 0) goto L6e
            return r15
        L6e:
            kotlinx.serialization.SerialFormat r15 = r0.f50333a     // Catch: kotlinx.serialization.SerializationException -> L79
            kotlinx.serialization.modules.SerializersModule r15 = r15.a()     // Catch: kotlinx.serialization.SerializationException -> L79
            kotlinx.serialization.KSerializer r13 = io.ktor.serialization.kotlinx.SerializerLookupKt.c(r15, r13)     // Catch: kotlinx.serialization.SerializationException -> L79
            goto L83
        L79:
            kotlinx.serialization.SerialFormat r13 = r0.f50333a
            kotlinx.serialization.modules.SerializersModule r13 = r13.a()
            kotlinx.serialization.KSerializer r13 = io.ktor.serialization.kotlinx.SerializerLookupKt.b(r14, r13)
        L83:
            kotlinx.serialization.SerialFormat r15 = r0.f50333a
            boolean r0 = r15 instanceof kotlinx.serialization.StringFormat
            if (r0 == 0) goto L99
            kotlinx.serialization.StringFormat r15 = (kotlinx.serialization.StringFormat) r15
            java.lang.String r13 = r15.d(r13, r14)
            io.ktor.http.content.TextContent r14 = new io.ktor.http.content.TextContent
            io.ktor.http.ContentType r11 = io.ktor.http.ContentTypesKt.c(r11, r12)
            r14.<init>(r13, r11)
            goto La8
        L99:
            boolean r12 = r15 instanceof kotlinx.serialization.BinaryFormat
            if (r12 == 0) goto La9
            kotlinx.serialization.BinaryFormat r15 = (kotlinx.serialization.BinaryFormat) r15
            byte[] r12 = r15.e()
            io.ktor.http.content.ByteArrayContent r14 = new io.ktor.http.content.ByteArrayContent
            r14.<init>(r12, r11)
        La8:
            return r14
        La9:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Unsupported format "
            r12.<init>(r13)
            r12.append(r15)
            java.lang.String r12 = r12.toString()
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationConverter.b(io.ktor.http.ContentType, java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, java.lang.Object, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
