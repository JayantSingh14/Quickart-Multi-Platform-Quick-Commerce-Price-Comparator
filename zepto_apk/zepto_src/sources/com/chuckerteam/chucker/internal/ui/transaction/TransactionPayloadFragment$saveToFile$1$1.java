package com.chuckerteam.chucker.internal.ui.transaction;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.support.FileSaver;
import com.chuckerteam.chucker.internal.support.Logger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okio.Source;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$saveToFile$1$1", f = "TransactionPayloadFragment.kt", l = {WKSRecord.Service.BOOTPC}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class TransactionPayloadFragment$saveToFile$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16956a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16957b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f16958c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f16959d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TransactionPayloadFragment f16960e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ HttpTransaction f16961f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionPayloadFragment$saveToFile$1$1(Uri uri, Context context, TransactionPayloadFragment transactionPayloadFragment, HttpTransaction httpTransaction, Continuation continuation) {
        super(2, continuation);
        this.f16958c = uri;
        this.f16959d = context;
        this.f16960e = transactionPayloadFragment;
        this.f16961f = httpTransaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TransactionPayloadFragment$saveToFile$1$1 transactionPayloadFragment$saveToFile$1$1 = new TransactionPayloadFragment$saveToFile$1$1(this.f16958c, this.f16959d, this.f16960e, this.f16961f, continuation);
        transactionPayloadFragment$saveToFile$1$1.f16957b = obj;
        return transactionPayloadFragment$saveToFile$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TransactionPayloadFragment$saveToFile$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16956a;
        Context context = this.f16959d;
        if (i2 == 0) {
            ResultKt.b(obj);
            TransactionPayloadFragment transactionPayloadFragment = this.f16960e;
            HttpTransaction httpTransaction = this.f16961f;
            try {
                Result.Companion companion = Result.f53538b;
                objA = TransactionPayloadFragment.y(transactionPayloadFragment, transactionPayloadFragment.A(), httpTransaction);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f53538b;
                objA = ResultKt.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Logger.Companion.f16778a.a("Failed to save transaction to a file", thA);
                return Unit.f53572a;
            }
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            this.f16956a = 1;
            obj = FileSaver.a((Source) objA, this.f16958c, contentResolver, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Toast.makeText(context, ((Boolean) obj).booleanValue() ? R.string.chucker_file_saved : R.string.chucker_file_not_saved, 0).show();
        return Unit.f53572a;
    }
}
