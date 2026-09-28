package com.chuckerteam.chucker.internal.data.har.log.entry;

import android.support.v4.media.a;
import androidx.fragment.app.e;
import com.chuckerteam.chucker.internal.data.entity.HttpHeader;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.har.log.entry.response.Content;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Response {

    @SerializedName("bodySize")
    private final long bodySize;

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName("content")
    @Nullable
    private final Content content;

    @SerializedName("cookies")
    @NotNull
    private final List<Object> cookies;

    @SerializedName("headers")
    @NotNull
    private final List<Header> headers;

    @SerializedName("headersSize")
    private final long headersSize;

    @SerializedName("httpVersion")
    @NotNull
    private final String httpVersion;

    @SerializedName("redirectURL")
    @NotNull
    private final String redirectUrl;

    @SerializedName(CLConstants.OTP_STATUS)
    private final int status;

    @SerializedName("statusText")
    @NotNull
    private final String statusText;

    @SerializedName("totalSize")
    private final long totalSize;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, java.util.List<com.chuckerteam.chucker.internal.data.har.log.entry.Header>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.ArrayList] */
    public Response(HttpTransaction transaction) {
        ?? headers;
        Content content;
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Integer responseCode = transaction.getResponseCode();
        int iIntValue = responseCode != null ? responseCode.intValue() : 0;
        String statusText = transaction.getResponseMessage();
        statusText = statusText == null ? "" : statusText;
        String httpVersion = transaction.getProtocol();
        httpVersion = httpVersion == null ? "" : httpVersion;
        List<HttpHeader> parsedResponseHeaders = transaction.getParsedResponseHeaders();
        if (parsedResponseHeaders != null) {
            List<HttpHeader> list = parsedResponseHeaders;
            headers = new ArrayList(CollectionsKt.r(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                headers.add(new Header((HttpHeader) it.next()));
            }
        } else {
            headers = EmptyList.f53609a;
        }
        if (transaction.getResponsePayloadSize() != null) {
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            Long responsePayloadSize = transaction.getResponsePayloadSize();
            String responseContentType = transaction.getResponseContentType();
            content = new Content(responsePayloadSize, responseContentType == null ? "application/octet-stream" : responseContentType, transaction.getResponseBody(), 50);
        } else {
            content = Content.f16712a;
        }
        Long responseHeadersSize = transaction.getResponseHeadersSize();
        long jLongValue = responseHeadersSize != null ? responseHeadersSize.longValue() : 0L;
        long harResponseBodySize = transaction.getHarResponseBodySize();
        long responseTotalSize = transaction.getResponseTotalSize();
        EmptyList cookies = EmptyList.f53609a;
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(httpVersion, "httpVersion");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter("", "redirectUrl");
        this.status = iIntValue;
        this.statusText = statusText;
        this.httpVersion = httpVersion;
        this.cookies = cookies;
        this.headers = headers;
        this.content = content;
        this.redirectUrl = "";
        this.headersSize = jLongValue;
        this.bodySize = harResponseBodySize;
        this.totalSize = responseTotalSize;
        this.comment = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return this.status == response.status && Intrinsics.b(this.statusText, response.statusText) && Intrinsics.b(this.httpVersion, response.httpVersion) && Intrinsics.b(this.cookies, response.cookies) && Intrinsics.b(this.headers, response.headers) && Intrinsics.b(this.content, response.content) && Intrinsics.b(this.redirectUrl, response.redirectUrl) && this.headersSize == response.headersSize && this.bodySize == response.bodySize && this.totalSize == response.totalSize && Intrinsics.b(this.comment, response.comment);
    }

    public final int hashCode() {
        int iF = e.f(e.f(e.e(e.e(Integer.hashCode(this.status) * 31, 31, this.statusText), 31, this.httpVersion), 31, this.cookies), 31, this.headers);
        Content content = this.content;
        int iD = a.d(a.d(a.d(e.e((iF + (content == null ? 0 : content.hashCode())) * 31, 31, this.redirectUrl), 31, this.headersSize), 31, this.bodySize), 31, this.totalSize);
        String str = this.comment;
        return iD + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        int i2 = this.status;
        String str = this.statusText;
        String str2 = this.httpVersion;
        List<Object> list = this.cookies;
        List<Header> list2 = this.headers;
        Content content = this.content;
        String str3 = this.redirectUrl;
        long j2 = this.headersSize;
        long j3 = this.bodySize;
        long j4 = this.totalSize;
        String str4 = this.comment;
        StringBuilder sb = new StringBuilder("Response(status=");
        sb.append(i2);
        sb.append(", statusText=");
        sb.append(str);
        sb.append(", httpVersion=");
        sb.append(str2);
        sb.append(", cookies=");
        sb.append(list);
        sb.append(", headers=");
        sb.append(list2);
        sb.append(", content=");
        sb.append(content);
        sb.append(", redirectUrl=");
        sb.append(str3);
        sb.append(", headersSize=");
        sb.append(j2);
        e.A(sb, ", bodySize=", j3, ", totalSize=");
        sb.append(j4);
        sb.append(", comment=");
        sb.append(str4);
        sb.append(")");
        return sb.toString();
    }
}
