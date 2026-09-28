package io.ktor.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

@Metadata
@DebugMetadata(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", l = {76}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class NonceKt$nonceGeneratorJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Channel f50491a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f50492b;

    /* renamed from: c, reason: collision with root package name */
    public SecureRandom f50493c;

    /* renamed from: d, reason: collision with root package name */
    public SecureRandom f50494d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f50495e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f50496f;

    /* renamed from: g, reason: collision with root package name */
    public List f50497g;

    /* renamed from: h, reason: collision with root package name */
    public long f50498h;

    /* renamed from: i, reason: collision with root package name */
    public int f50499i;

    /* renamed from: j, reason: collision with root package name */
    public int f50500j;

    /* renamed from: k, reason: collision with root package name */
    public int f50501k;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NonceKt$nonceGeneratorJob$1(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((NonceKt$nonceGeneratorJob$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4 A[Catch: all -> 0x0033, LOOP:1: B:27:0x00c2->B:28:0x00c4, LOOP_END, TryCatch #0 {all -> 0x0033, blocks: (B:6:0x0022, B:38:0x013f, B:35:0x011b, B:39:0x0142, B:41:0x0151, B:26:0x00b9, B:28:0x00c4, B:29:0x00cd, B:31:0x00d9, B:33:0x00ea, B:32:0x00e7), top: B:52:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:6:0x0022, B:38:0x013f, B:35:0x011b, B:39:0x0142, B:41:0x0151, B:26:0x00b9, B:28:0x00c4, B:29:0x00cd, B:31:0x00d9, B:33:0x00ea, B:32:0x00e7), top: B:52:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e7 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:6:0x0022, B:38:0x013f, B:35:0x011b, B:39:0x0142, B:41:0x0151, B:26:0x00b9, B:28:0x00c4, B:29:0x00cd, B:31:0x00d9, B:33:0x00ea, B:32:0x00e7), top: B:52:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011b A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:6:0x0022, B:38:0x013f, B:35:0x011b, B:39:0x0142, B:41:0x0151, B:26:0x00b9, B:28:0x00c4, B:29:0x00cd, B:31:0x00d9, B:33:0x00ea, B:32:0x00e7), top: B:52:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0142 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:6:0x0022, B:38:0x013f, B:35:0x011b, B:39:0x0142, B:41:0x0151, B:26:0x00b9, B:28:0x00c4, B:29:0x00cd, B:31:0x00d9, B:33:0x00ea, B:32:0x00e7), top: B:52:0x0022 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x013c -> B:38:0x013f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.security.NoSuchAlgorithmException {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.NonceKt$nonceGeneratorJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
