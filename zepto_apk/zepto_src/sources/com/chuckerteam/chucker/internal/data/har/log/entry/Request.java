package com.chuckerteam.chucker.internal.data.har.log.entry;

import android.support.v4.media.a;
import androidx.fragment.app.e;
import com.chuckerteam.chucker.internal.data.entity.HttpHeader;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.har.log.entry.request.PostData;
import com.chuckerteam.chucker.internal.data.har.log.entry.request.QueryString;
import com.google.gson.annotations.SerializedName;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Request {

    @SerializedName("bodySize")
    private final long bodySize;

    @SerializedName("comment")
    @Nullable
    private final String comment;

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

    @SerializedName("method")
    @NotNull
    private final String method;

    @SerializedName(PaymentConstants.POST_DATA)
    @Nullable
    private final PostData postData;

    @SerializedName("queryString")
    @NotNull
    private final List<QueryString> queryString;

    @SerializedName("totalSize")
    private final long totalSize;

    @SerializedName("url")
    @NotNull
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, java.util.List<com.chuckerteam.chucker.internal.data.har.log.entry.request.QueryString>] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, java.util.List<com.chuckerteam.chucker.internal.data.har.log.entry.Header>] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayList] */
    public Request(HttpTransaction transaction) {
        ?? headers;
        ?? queryString;
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        String method = transaction.getMethod();
        method = method == null ? "" : method;
        String url = transaction.getUrl();
        url = url == null ? "" : url;
        String httpVersion = transaction.getProtocol();
        httpVersion = httpVersion == null ? "" : httpVersion;
        List<HttpHeader> parsedRequestHeaders = transaction.getParsedRequestHeaders();
        if (parsedRequestHeaders != null) {
            List<HttpHeader> list = parsedRequestHeaders;
            headers = new ArrayList(CollectionsKt.r(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                headers.add(new Header((HttpHeader) it.next()));
            }
        } else {
            headers = EmptyList.f53609a;
        }
        String url2 = transaction.getUrl();
        if (url2 != null) {
            HttpUrl url3 = HttpUrl.Companion.c(url2);
            Intrinsics.checkNotNullParameter(url3, "url");
            ArrayList arrayList = url3.f56265g;
            int size = arrayList != null ? arrayList.size() / 2 : 0;
            queryString = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList == null) {
                    throw new IndexOutOfBoundsException();
                }
                int i3 = i2 * 2;
                Object obj = arrayList.get(i3);
                Intrinsics.c(obj);
                String str = (String) obj;
                String str2 = (String) arrayList.get(i3 + 1);
                if (str2 == null) {
                    str2 = "";
                }
                queryString.add(new QueryString(str, str2));
            }
        } else {
            queryString = EmptyList.f53609a;
        }
        PostData postData = transaction.getRequestPayloadSize() != null ? new PostData(transaction) : null;
        Long requestHeadersSize = transaction.getRequestHeadersSize();
        long jLongValue = requestHeadersSize != null ? requestHeadersSize.longValue() : 0L;
        Long requestPayloadSize = transaction.getRequestPayloadSize();
        long jLongValue2 = requestPayloadSize != null ? requestPayloadSize.longValue() : 0L;
        long requestTotalSize = transaction.getRequestTotalSize();
        EmptyList cookies = EmptyList.f53609a;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(httpVersion, "httpVersion");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(queryString, "queryString");
        this.method = method;
        this.url = url;
        this.httpVersion = httpVersion;
        this.cookies = cookies;
        this.headers = headers;
        this.queryString = queryString;
        this.postData = postData;
        this.headersSize = jLongValue;
        this.bodySize = jLongValue2;
        this.totalSize = requestTotalSize;
        this.comment = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        return Intrinsics.b(this.method, request.method) && Intrinsics.b(this.url, request.url) && Intrinsics.b(this.httpVersion, request.httpVersion) && Intrinsics.b(this.cookies, request.cookies) && Intrinsics.b(this.headers, request.headers) && Intrinsics.b(this.queryString, request.queryString) && Intrinsics.b(this.postData, request.postData) && this.headersSize == request.headersSize && this.bodySize == request.bodySize && this.totalSize == request.totalSize && Intrinsics.b(this.comment, request.comment);
    }

    public final int hashCode() {
        int iF = e.f(e.f(e.f(e.e(e.e(this.method.hashCode() * 31, 31, this.url), 31, this.httpVersion), 31, this.cookies), 31, this.headers), 31, this.queryString);
        PostData postData = this.postData;
        int iD = a.d(a.d(a.d((iF + (postData == null ? 0 : postData.hashCode())) * 31, 31, this.headersSize), 31, this.bodySize), 31, this.totalSize);
        String str = this.comment;
        return iD + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        String str = this.method;
        String str2 = this.url;
        String str3 = this.httpVersion;
        List<Object> list = this.cookies;
        List<Header> list2 = this.headers;
        List<QueryString> list3 = this.queryString;
        PostData postData = this.postData;
        long j2 = this.headersSize;
        long j3 = this.bodySize;
        long j4 = this.totalSize;
        String str4 = this.comment;
        StringBuilder sbV = e.v("Request(method=", str, ", url=", str2, ", httpVersion=");
        sbV.append(str3);
        sbV.append(", cookies=");
        sbV.append(list);
        sbV.append(", headers=");
        sbV.append(list2);
        sbV.append(", queryString=");
        sbV.append(list3);
        sbV.append(", postData=");
        sbV.append(postData);
        sbV.append(", headersSize=");
        sbV.append(j2);
        e.A(sbV, ", bodySize=", j3, ", totalSize=");
        sbV.append(j4);
        sbV.append(", comment=");
        sbV.append(str4);
        sbV.append(")");
        return sbV.toString();
    }
}
