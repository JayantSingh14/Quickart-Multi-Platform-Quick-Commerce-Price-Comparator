package com.chuckerteam.chucker.internal.support;

import android.content.Context;
import com.chuckerteam.chucker.internal.data.entity.HttpHeader;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TransactionCurlCommandSharable implements Sharable {

    /* renamed from: a, reason: collision with root package name */
    public final HttpTransaction f16836a;

    public TransactionCurlCommandSharable(HttpTransaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        this.f16836a = transaction;
    }

    @Override // com.chuckerteam.chucker.internal.support.Sharable
    public final Buffer a(Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Buffer buffer = new Buffer();
        HttpTransaction httpTransaction = this.f16836a;
        buffer.X1("curl -X " + httpTransaction.getMethod());
        List<HttpHeader> parsedRequestHeaders = httpTransaction.getParsedRequestHeaders();
        if (parsedRequestHeaders != null) {
            z = false;
            for (HttpHeader httpHeader : parsedRequestHeaders) {
                if (("Accept-Encoding".equalsIgnoreCase(httpHeader.a()) && StringsKt.n("gzip", httpHeader.b(), true)) || StringsKt.n("br", httpHeader.b(), true)) {
                    z = true;
                }
                buffer.X1(android.support.v4.media.b.m(" -H \"", httpHeader.a(), ": ", StringsKt.K(httpHeader.b(), "\"", "\\\""), "\""));
            }
        } else {
            z = false;
        }
        String requestBody = httpTransaction.getRequestBody();
        if (requestBody != null && requestBody.length() != 0) {
            buffer.X1(" --data $'" + StringsKt.K(requestBody, StringUtils.LF, "\\n") + "'");
        }
        String str = z ? " --compressed " : StringUtils.SPACE;
        buffer.X1(str + httpTransaction.getFormattedUrl(false));
        return buffer;
    }
}
