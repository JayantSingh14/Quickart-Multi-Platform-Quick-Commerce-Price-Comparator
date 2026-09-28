package com.chuckerteam.chucker.internal.ui.transaction;

import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public /* synthetic */ class TransactionPayloadFragment$payloadAdapter$1 extends FunctionReferenceImpl implements Function0<Unit> {
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String responseBody;
        String requestBody;
        TransactionPayloadFragment transactionPayloadFragment = (TransactionPayloadFragment) this.receiver;
        HttpTransaction httpTransaction = (HttpTransaction) transactionPayloadFragment.B().f16971g.d();
        String strName = transactionPayloadFragment.A().name();
        if (Intrinsics.b(strName, "REQUEST")) {
            if (httpTransaction != null && (requestBody = httpTransaction.getRequestBody()) != null) {
                String string = transactionPayloadFragment.getString(R.string.chucker_request);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = transactionPayloadFragment.getString(R.string.chucker_request_copied);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                transactionPayloadFragment.z(requestBody, string, string2);
            }
        } else if (Intrinsics.b(strName, "RESPONSE") && httpTransaction != null && (responseBody = httpTransaction.getResponseBody()) != null) {
            String string3 = transactionPayloadFragment.getString(R.string.chucker_response);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = transactionPayloadFragment.getString(R.string.chucker_response_copied);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            transactionPayloadFragment.z(responseBody, string3, string4);
        }
        return Unit.f53572a;
    }
}
