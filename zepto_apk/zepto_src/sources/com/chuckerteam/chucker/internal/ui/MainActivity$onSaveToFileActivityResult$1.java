package com.chuckerteam.chucker.internal.ui;

import android.net.Uri;
import com.chuckerteam.chucker.internal.ui.MainActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.MainActivity$onSaveToFileActivityResult$1", f = "MainActivity.kt", l = {327, 329}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class MainActivity$onSaveToFileActivityResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16872a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16873b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f16874c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MainActivity f16875d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MainActivity.ExportType f16876e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$onSaveToFileActivityResult$1(Uri uri, MainActivity mainActivity, MainActivity.ExportType exportType, Continuation continuation) {
        super(2, continuation);
        this.f16874c = uri;
        this.f16875d = mainActivity;
        this.f16876e = exportType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MainActivity$onSaveToFileActivityResult$1 mainActivity$onSaveToFileActivityResult$1 = new MainActivity$onSaveToFileActivityResult$1(this.f16874c, this.f16875d, this.f16876e, continuation);
        mainActivity$onSaveToFileActivityResult$1.f16873b = obj;
        return mainActivity$onSaveToFileActivityResult$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MainActivity$onSaveToFileActivityResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        if (r6 == r0) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r5.f16872a
            r2 = 2
            r3 = 1
            com.chuckerteam.chucker.internal.ui.MainActivity r4 = r5.f16875d
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L5f
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L1e
            goto L34
        L1e:
            r6 = move-exception
            goto L39
        L20:
            kotlin.ResultKt.b(r6)
            java.lang.Object r6 = r5.f16873b
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            com.chuckerteam.chucker.internal.ui.MainActivity$ExportType r6 = r5.f16876e
            kotlin.Result$Companion r1 = kotlin.Result.f53538b     // Catch: java.lang.Throwable -> L1e
            r5.f16872a = r3     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r6 = com.chuckerteam.chucker.internal.ui.MainActivity.m(r4, r6, r5)     // Catch: java.lang.Throwable -> L1e
            if (r6 != r0) goto L34
            goto L5e
        L34:
            okio.Source r6 = (okio.Source) r6     // Catch: java.lang.Throwable -> L1e
            kotlin.Result$Companion r1 = kotlin.Result.f53538b     // Catch: java.lang.Throwable -> L1e
            goto L3f
        L39:
            kotlin.Result$Companion r1 = kotlin.Result.f53538b
            kotlin.Result$Failure r6 = kotlin.ResultKt.a(r6)
        L3f:
            boolean r1 = r6 instanceof kotlin.Result.Failure
            if (r1 == 0) goto L44
            r6 = 0
        L44:
            okio.Source r6 = (okio.Source) r6
            if (r6 != 0) goto L4b
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L4b:
            android.content.ContentResolver r1 = r4.getContentResolver()
            java.lang.String r3 = "getContentResolver(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r5.f16872a = r2
            android.net.Uri r2 = r5.f16874c
            java.lang.Object r6 = com.chuckerteam.chucker.internal.support.FileSaver.a(r6, r2, r1, r5)
            if (r6 != r0) goto L5f
        L5e:
            return r0
        L5f:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L6a
            int r6 = com.chuckerteam.chucker.R.string.chucker_file_saved
            goto L6c
        L6a:
            int r6 = com.chuckerteam.chucker.R.string.chucker_file_not_saved
        L6c:
            android.content.Context r0 = r4.getApplicationContext()
            r1 = 0
            android.widget.Toast r6 = android.widget.Toast.makeText(r0, r6, r1)
            r6.show()
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.ui.MainActivity$onSaveToFileActivityResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
