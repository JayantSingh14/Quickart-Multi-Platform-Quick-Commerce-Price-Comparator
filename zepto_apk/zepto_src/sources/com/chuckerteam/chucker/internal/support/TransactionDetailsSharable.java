package com.chuckerteam.chucker.internal.support;

import android.content.Context;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

@Metadata
/* loaded from: classes3.dex */
public final class TransactionDetailsSharable implements Sharable {

    /* renamed from: a, reason: collision with root package name */
    public final HttpTransaction f16838a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16839b;

    public TransactionDetailsSharable(HttpTransaction transaction, boolean z) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        this.f16838a = transaction;
        this.f16839b = z;
    }

    @Override // com.chuckerteam.chucker.internal.support.Sharable
    public final Buffer a(Context context) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(context, "context");
        Buffer buffer = new Buffer();
        String string3 = context.getString(R.string.chucker_url);
        HttpTransaction httpTransaction = this.f16838a;
        buffer.X1(string3 + ": " + httpTransaction.getFormattedUrl(this.f16839b) + StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_method) + ": " + httpTransaction.getMethod() + StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_protocol) + ": " + httpTransaction.getProtocol() + StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_status) + ": " + httpTransaction.getStatus() + StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_response) + ": " + httpTransaction.getResponseSummaryText() + StringUtils.LF);
        int i2 = httpTransaction.isSsl() ? R.string.chucker_yes : R.string.chucker_no;
        buffer.X1(context.getString(R.string.chucker_ssl) + ": " + context.getString(i2) + StringUtils.LF);
        buffer.X1(StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_request_time) + ": " + httpTransaction.getRequestDateString() + StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_response_time) + ": " + httpTransaction.getResponseDateString() + StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_duration) + ": " + httpTransaction.getDurationString() + StringUtils.LF);
        buffer.X1(StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_request_size) + ": " + httpTransaction.getRequestSizeString() + StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_response_size) + ": " + httpTransaction.getResponseSizeString() + StringUtils.LF);
        buffer.X1(context.getString(R.string.chucker_total_size) + ": " + httpTransaction.getTotalSizeString() + StringUtils.LF);
        buffer.X1(StringUtils.LF);
        buffer.X1("---------- " + context.getString(R.string.chucker_request) + " ----------\n\n");
        String strB = FormatUtils.b(httpTransaction.getParsedRequestHeaders(), false);
        if (!StringsKt.z(strB)) {
            buffer.X1(strB);
            buffer.X1(StringUtils.LF);
        }
        String requestBody = httpTransaction.getRequestBody();
        if (requestBody == null || StringsKt.z(requestBody)) {
            string = context.getString(httpTransaction.isResponseBodyEncoded() ? R.string.chucker_body_omitted : R.string.chucker_body_empty);
        } else {
            string = httpTransaction.getFormattedRequestBody();
        }
        Intrinsics.c(string);
        buffer.X1(string);
        buffer.X1("\n\n");
        buffer.X1("---------- " + context.getString(R.string.chucker_response) + " ----------\n\n");
        String strB2 = FormatUtils.b(httpTransaction.getParsedResponseHeaders(), false);
        if (!StringsKt.z(strB2)) {
            buffer.X1(strB2);
            buffer.X1(StringUtils.LF);
        }
        String responseBody = httpTransaction.getResponseBody();
        if (responseBody == null || StringsKt.z(responseBody)) {
            string2 = context.getString(httpTransaction.isResponseBodyEncoded() ? R.string.chucker_body_omitted : R.string.chucker_body_empty);
        } else {
            string2 = httpTransaction.getFormattedResponseBody();
        }
        Intrinsics.c(string2);
        buffer.X1(string2);
        return buffer;
    }
}
