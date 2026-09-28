package com.chuckerteam.chucker.internal.support;

import android.content.ContentResolver;
import android.net.Uri;
import com.chuckerteam.chucker.internal.support.Logger;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Okio;
import okio.RealBufferedSink;
import okio.Source;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.support.FileSaver$saveFile$2", f = "FileSaver.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class FileSaver$saveFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f16756a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f16757b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f16758c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Source f16759d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSaver$saveFile$2(ContentResolver contentResolver, Uri uri, Source source, Continuation continuation) {
        super(2, continuation);
        this.f16757b = contentResolver;
        this.f16758c = uri;
        this.f16759d = source;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FileSaver$saveFile$2 fileSaver$saveFile$2 = new FileSaver$saveFile$2(this.f16757b, this.f16758c, this.f16759d, continuation);
        fileSaver$saveFile$2.f16756a = obj;
        return fileSaver$saveFile$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileSaver$saveFile$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        ContentResolver contentResolver = this.f16757b;
        Uri uri = this.f16758c;
        Source source = this.f16759d;
        try {
            Result.Companion companion = Result.f53538b;
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri);
            if (outputStreamOpenOutputStream != null) {
                try {
                    RealBufferedSink realBufferedSinkC = Okio.c(Okio.i(outputStreamOpenOutputStream));
                    try {
                        long jG0 = realBufferedSinkC.g0(source);
                        realBufferedSinkC.close();
                        objA = new Long(jG0);
                        outputStreamOpenOutputStream.close();
                    } finally {
                    }
                } finally {
                }
            } else {
                objA = null;
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA == null) {
            return Boolean.TRUE;
        }
        Logger.Companion.f16778a.a("Failed to save data to a file", thA);
        return Boolean.FALSE;
    }
}
