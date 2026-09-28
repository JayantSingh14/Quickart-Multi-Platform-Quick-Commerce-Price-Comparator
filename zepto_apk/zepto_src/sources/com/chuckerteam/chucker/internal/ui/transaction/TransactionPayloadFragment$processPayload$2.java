package com.chuckerteam.chucker.internal.ui.transaction;

import android.graphics.Bitmap;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.support.BitmapUtilsKt;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt$lineSequence$$inlined$Sequence$1;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$processPayload$2", f = "TransactionPayloadFragment.kt", l = {435}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class TransactionPayloadFragment$processPayload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<TransactionPayloadItem>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f16948a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f16949b;

    /* renamed from: c, reason: collision with root package name */
    public int f16950c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PayloadType f16951d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpTransaction f16952e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f16953f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ TransactionPayloadFragment f16954g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionPayloadFragment$processPayload$2(PayloadType payloadType, HttpTransaction httpTransaction, boolean z, TransactionPayloadFragment transactionPayloadFragment, Continuation continuation) {
        super(2, continuation);
        this.f16951d = payloadType;
        this.f16952e = httpTransaction;
        this.f16953f = z;
        this.f16954g = transactionPayloadFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TransactionPayloadFragment$processPayload$2(this.f16951d, this.f16952e, this.f16953f, this.f16954g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TransactionPayloadFragment$processPayload$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String responseHeadersString;
        boolean zIsResponseBodyEncoded;
        CharSequence spannedResponseBody;
        ArrayList arrayList;
        Bitmap bitmap;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16950c;
        if (i2 == 0) {
            ResultKt.b(obj);
            ArrayList arrayList2 = new ArrayList();
            PayloadType payloadType = PayloadType.f16899a;
            TransactionPayloadFragment transactionPayloadFragment = this.f16954g;
            PayloadType payloadType2 = this.f16951d;
            HttpTransaction httpTransaction = this.f16952e;
            if (payloadType2 == payloadType) {
                responseHeadersString = httpTransaction.getRequestHeadersString(true);
                zIsResponseBodyEncoded = httpTransaction.isRequestBodyEncoded();
                if (this.f16953f) {
                    spannedResponseBody = httpTransaction.getSpannedRequestBody(transactionPayloadFragment.getContext());
                } else {
                    spannedResponseBody = httpTransaction.getRequestBody();
                    if (spannedResponseBody == null) {
                        spannedResponseBody = "";
                    }
                }
            } else {
                responseHeadersString = httpTransaction.getResponseHeadersString(true);
                zIsResponseBodyEncoded = httpTransaction.isResponseBodyEncoded();
                spannedResponseBody = httpTransaction.getSpannedResponseBody(transactionPayloadFragment.getContext());
            }
            if (!StringsKt.z(responseHeadersString)) {
                Spanned spannedFromHtml = Html.fromHtml(responseHeadersString, 0);
                Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
                arrayList2.add(new TransactionPayloadItem.HeaderItem(spannedFromHtml));
            }
            Bitmap responseImageBitmap = httpTransaction.getResponseImageBitmap();
            if (payloadType2 != PayloadType.f16900b || responseImageBitmap == null) {
                if (zIsResponseBodyEncoded) {
                    String string = transactionPayloadFragment.requireContext().getString(R.string.chucker_body_omitted);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(string);
                    Intrinsics.checkNotNullExpressionValue(spannableStringBuilderValueOf, "valueOf(...)");
                    arrayList2.add(new TransactionPayloadItem.BodyLineItem(spannableStringBuilderValueOf));
                    return arrayList2;
                }
                if (StringsKt.z(spannedResponseBody)) {
                    String string2 = transactionPayloadFragment.requireContext().getString(R.string.chucker_body_empty);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    SpannableStringBuilder spannableStringBuilderValueOf2 = SpannableStringBuilder.valueOf(string2);
                    Intrinsics.checkNotNullExpressionValue(spannableStringBuilderValueOf2, "valueOf(...)");
                    arrayList2.add(new TransactionPayloadItem.BodyLineItem(spannableStringBuilderValueOf2));
                    return arrayList2;
                }
                String copy = transactionPayloadFragment.getString(R.string.chucker_copy_response);
                Intrinsics.checkNotNullExpressionValue(copy, "getString(...)");
                Intrinsics.checkNotNullParameter(copy, "copy");
                arrayList2.add(new TransactionPayloadItem.CopyItem());
                Intrinsics.checkNotNullParameter(spannedResponseBody, "<this>");
                List listQ = SequencesKt.q(new StringsKt__StringsKt$lineSequence$$inlined$Sequence$1(spannedResponseBody));
                ArrayList arrayList3 = new ArrayList();
                int size = listQ.size();
                int iC = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList3.add(spannedResponseBody.subSequence(iC, ((String) listQ.get(i3)).length() + iC));
                    iC = androidx.fragment.app.e.C(1, iC, (String) listQ.get(i3));
                }
                if (arrayList3.isEmpty()) {
                    arrayList3.add(spannedResponseBody.subSequence(0, spannedResponseBody.length()));
                }
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    CharSequence charSequence = (CharSequence) it.next();
                    SpannableStringBuilder spannableStringBuilderValueOf3 = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : SpannableStringBuilder.valueOf(charSequence);
                    Intrinsics.c(spannableStringBuilderValueOf3);
                    arrayList2.add(new TransactionPayloadItem.BodyLineItem(spannableStringBuilderValueOf3));
                }
                Unit unit = Unit.f53572a;
                return arrayList2;
            }
            this.f16948a = arrayList2;
            this.f16949b = responseImageBitmap;
            this.f16950c = 1;
            Object objA = BitmapUtilsKt.a(responseImageBitmap, this);
            if (objA == coroutineSingletons) {
                return coroutineSingletons;
            }
            arrayList = arrayList2;
            obj = objA;
            bitmap = responseImageBitmap;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bitmap = this.f16949b;
            arrayList = this.f16948a;
            ResultKt.b(obj);
        }
        arrayList.add(new TransactionPayloadItem.ImageItem(bitmap, (Double) obj));
        return arrayList;
    }
}
