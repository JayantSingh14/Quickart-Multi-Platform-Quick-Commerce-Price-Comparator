package com.reactnativedocumentpicker;

import android.net.Uri;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$2", f = "MetadataGetter.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class MetadataGetter$processPickedFileUris$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WritableArray>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public WritableArray f46363a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f46364b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f46365c;

    /* renamed from: d, reason: collision with root package name */
    public int f46366d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f46367e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ MetadataGetter f46368f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f46369g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ PickOptions f46370h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetadataGetter$processPickedFileUris$2(List list, MetadataGetter metadataGetter, ReactApplicationContext reactApplicationContext, PickOptions pickOptions, Continuation continuation) {
        super(2, continuation);
        this.f46367e = list;
        this.f46368f = metadataGetter;
        this.f46369g = reactApplicationContext;
        this.f46370h = pickOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MetadataGetter$processPickedFileUris$2(this.f46367e, this.f46368f, this.f46369g, this.f46370h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MetadataGetter$processPickedFileUris$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0057 -> B:15:0x005b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r10.f46366d
            com.reactnativedocumentpicker.MetadataGetter r6 = r10.f46368f
            r8 = 1
            if (r1 == 0) goto L1d
            if (r1 != r8) goto L15
            android.net.Uri r1 = r10.f46365c
            java.util.Iterator r2 = r10.f46364b
            com.facebook.react.bridge.WritableArray r3 = r10.f46363a
            kotlin.ResultKt.b(r11)
            goto L5b
        L15:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1d:
            kotlin.ResultKt.b(r11)
            com.facebook.react.bridge.WritableArray r11 = com.facebook.react.bridge.Arguments.createArray()
            java.util.List r1 = r10.f46367e
            java.util.Iterator r1 = r1.iterator()
        L2a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L70
            java.lang.Object r2 = r1.next()
            r4 = r2
            android.net.Uri r4 = (android.net.Uri) r4
            r10.f46363a = r11
            r10.f46364b = r1
            r10.f46365c = r4
            r10.f46366d = r8
            r6.getClass()
            kotlinx.coroutines.scheduling.DefaultScheduler r2 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.scheduling.DefaultIoScheduler r9 = kotlinx.coroutines.scheduling.DefaultIoScheduler.f55150b
            com.reactnativedocumentpicker.MetadataGetter$getMetadataForUri$2 r2 = new com.reactnativedocumentpicker.MetadataGetter$getMetadataForUri$2
            com.facebook.react.bridge.ReactApplicationContext r3 = r10.f46369g
            com.reactnativedocumentpicker.PickOptions r5 = r10.f46370h
            r7 = 0
            r2.<init>(r3, r4, r5, r6, r7)
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.e(r9, r2, r10)
            if (r2 != r0) goto L57
            return r0
        L57:
            r3 = r11
            r11 = r2
            r2 = r1
            r1 = r4
        L5b:
            com.reactnativedocumentpicker.DocumentMetadataBuilder r11 = (com.reactnativedocumentpicker.DocumentMetadataBuilder) r11
            java.util.LinkedHashMap r4 = r6.f46355a
            java.lang.String r5 = r1.toString()
            r4.put(r5, r1)
            com.facebook.react.bridge.WritableMap r11 = r11.a()
            r3.pushMap(r11)
            r1 = r2
            r11 = r3
            goto L2a
        L70:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
