package com.chuckerteam.chucker.internal.data.entity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import androidx.fragment.app.e;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.brentvatne.common.react.r;
import com.chuckerteam.chucker.internal.support.FormatUtils;
import com.chuckerteam.chucker.internal.support.FormattedUrl;
import com.chuckerteam.chucker.internal.support.JsonConverter;
import com.chuckerteam.chucker.internal.support.SpanTextUtil;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

@Entity
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HttpTransaction {

    @ColumnInfo
    @Nullable
    private String error;

    @ColumnInfo
    private boolean graphQlDetected;

    @ColumnInfo
    @Nullable
    private String graphQlOperationName;

    @ColumnInfo
    @Nullable
    private String host;

    @PrimaryKey
    @ColumnInfo
    private long id;

    @ColumnInfo
    private boolean isRequestBodyEncoded;

    @ColumnInfo
    private boolean isResponseBodyEncoded;

    @ColumnInfo
    @Nullable
    private String method;

    @ColumnInfo
    @Nullable
    private String path;

    @ColumnInfo
    @Nullable
    private String protocol;

    @ColumnInfo
    @Nullable
    private String requestBody;

    @ColumnInfo
    @Nullable
    private String requestContentType;

    @ColumnInfo
    @Nullable
    private Long requestDate;

    @ColumnInfo
    @Nullable
    private String requestHeaders;

    @ColumnInfo
    @Nullable
    private Long requestHeadersSize;

    @ColumnInfo
    @Nullable
    private Long requestPayloadSize;

    @ColumnInfo
    @Nullable
    private String responseBody;

    @ColumnInfo
    @Nullable
    private String responseCipherSuite;

    @ColumnInfo
    @Nullable
    private Integer responseCode;

    @ColumnInfo
    @Nullable
    private String responseContentType;

    @ColumnInfo
    @Nullable
    private Long responseDate;

    @ColumnInfo
    @Nullable
    private String responseHeaders;

    @ColumnInfo
    @Nullable
    private Long responseHeadersSize;

    @ColumnInfo
    @Nullable
    private byte[] responseImageData;

    @ColumnInfo
    @Nullable
    private String responseMessage;

    @ColumnInfo
    @Nullable
    private Long responsePayloadSize;

    @ColumnInfo
    @Nullable
    private String responseTlsVersion;

    @ColumnInfo
    @Nullable
    private String scheme;

    @ColumnInfo
    @Nullable
    private Long tookMs;

    @ColumnInfo
    @Nullable
    private String url;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Status {

        /* renamed from: a, reason: collision with root package name */
        public static final Status f16693a;

        /* renamed from: b, reason: collision with root package name */
        public static final Status f16694b;

        /* renamed from: c, reason: collision with root package name */
        public static final Status f16695c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ Status[] f16696d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f16697e;

        static {
            Status status = new Status("Requested", 0);
            f16693a = status;
            Status status2 = new Status("Complete", 1);
            f16694b = status2;
            Status status3 = new Status("Failed", 2);
            f16695c = status3;
            Status[] statusArr = {status, status2, status3};
            f16696d = statusArr;
            f16697e = EnumEntriesKt.a(statusArr);
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) f16696d.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Status status = Status.f16693a;
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public HttpTransaction(long j2, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Long l5, @Nullable String str9, @Nullable String str10, @Nullable Long l6, @Nullable String str11, boolean z, @Nullable Integer num, @Nullable String str12, @Nullable String str13, @Nullable Long l7, @Nullable String str14, @Nullable String str15, @Nullable Long l8, @Nullable String str16, boolean z2, @Nullable byte[] bArr, boolean z3, @Nullable String str17) {
        this.id = j2;
        this.requestDate = l2;
        this.responseDate = l3;
        this.tookMs = l4;
        this.protocol = str;
        this.method = str2;
        this.url = str3;
        this.host = str4;
        this.path = str5;
        this.scheme = str6;
        this.responseTlsVersion = str7;
        this.responseCipherSuite = str8;
        this.requestPayloadSize = l5;
        this.requestContentType = str9;
        this.requestHeaders = str10;
        this.requestHeadersSize = l6;
        this.requestBody = str11;
        this.isRequestBodyEncoded = z;
        this.responseCode = num;
        this.responseMessage = str12;
        this.error = str13;
        this.responsePayloadSize = l7;
        this.responseContentType = str14;
        this.responseHeaders = str15;
        this.responseHeadersSize = l8;
        this.responseBody = str16;
        this.isResponseBodyEncoded = z2;
        this.responseImageData = bArr;
        this.graphQlDetected = z3;
        this.graphQlOperationName = str17;
    }

    private final String formatBody(String form, String str) throws TransformerException, ParserConfigurationException, SAXException, TransformerFactoryConfigurationError, IOException, IllegalArgumentException {
        if (str == null || StringsKt.z(str)) {
            return form;
        }
        if (StringsKt.n(str, "json", true)) {
            Intrinsics.checkNotNullParameter(form, "json");
            try {
                return JsonConverter.a().i(JsonParser.b(form));
            } catch (JsonParseException unused) {
                return form;
            }
        }
        if (!StringsKt.n(str, "xml", true)) {
            if (!StringsKt.n(str, "x-www-form-urlencoded", true)) {
                return form;
            }
            Intrinsics.checkNotNullParameter(form, "form");
            return StringsKt.z(form) ? form : CollectionsKt.E(StringsKt__StringsKt.split$default(form, new String[]{"&"}, false, 0, 6, null), StringUtils.LF, null, null, new r(3), 30);
        }
        Intrinsics.checkNotNullParameter(form, "xml");
        try {
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            Intrinsics.checkNotNullExpressionValue(documentBuilderFactoryNewInstance, "newInstance(...)");
            documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
            DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
            Intrinsics.checkNotNullExpressionValue(documentBuilderNewDocumentBuilder, "newDocumentBuilder(...)");
            Charset charsetDefaultCharset = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
            byte[] bytes = form.getBytes(charsetDefaultCharset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            Document document = documentBuilderNewDocumentBuilder.parse(new InputSource(new ByteArrayInputStream(bytes)));
            Intrinsics.checkNotNullExpressionValue(document, "parse(...)");
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
            transformerFactoryNewInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            Transformer transformerNewTransformer = transformerFactoryNewInstance.newTransformer();
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.transform(dOMSource, streamResult);
            return stringWriter.toString();
        } catch (UnsupportedEncodingException | IOException | IllegalArgumentException | TransformerException | SAXParseException unused2) {
            return form;
        }
    }

    private final String formatBytes(long j2) {
        return FormatUtils.a(j2);
    }

    private final CharSequence spanBody(CharSequence charSequence, String str, Context context) {
        return (str == null || StringsKt.z(str)) ? charSequence : (!StringsKt.n(str, "json", true) || context == null) ? formatBody(charSequence.toString(), str) : new SpanTextUtil(context).a(charSequence);
    }

    private final List<HttpHeader> toHttpHeaderList(Headers headers) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new HttpHeader(headers.f(i2), headers.m(i2)));
        }
        return arrayList;
    }

    @Nullable
    public final String getDurationString() {
        Long l2 = this.tookMs;
        if (l2 == null) {
            return null;
        }
        return l2.longValue() + " ms";
    }

    @Nullable
    public final String getError() {
        return this.error;
    }

    @NotNull
    public final String getFormattedPath(boolean z) {
        String str = this.url;
        return str != null ? FormattedUrl.Companion.a(HttpUrl.Companion.c(str), z).a() : "";
    }

    @NotNull
    public final String getFormattedRequestBody() {
        String body;
        String str = this.requestBody;
        return (str == null || (body = formatBody(str, this.requestContentType)) == null) ? "" : body;
    }

    @NotNull
    public final String getFormattedResponseBody() {
        String body;
        String str = this.responseBody;
        return (str == null || (body = formatBody(str, this.responseContentType)) == null) ? "" : body;
    }

    @NotNull
    public final String getFormattedUrl(boolean z) {
        String str = this.url;
        return str != null ? FormattedUrl.Companion.a(HttpUrl.Companion.c(str), z).b() : "";
    }

    public final boolean getGraphQlDetected() {
        return this.graphQlDetected;
    }

    @Nullable
    public final String getGraphQlOperationName() {
        return this.graphQlOperationName;
    }

    public final long getHarResponseBodySize() {
        Long l2;
        Integer num = this.responseCode;
        if ((num != null && num.intValue() == 304) || (l2 = this.responsePayloadSize) == null) {
            return 0L;
        }
        return l2.longValue();
    }

    @Nullable
    public final String getHost() {
        return this.host;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final String getNotificationText() {
        int iOrdinal = getStatus().ordinal();
        if (iOrdinal == 0) {
            return e.p(" . . .  ", this.method, StringUtils.SPACE, this.path);
        }
        if (iOrdinal == 2) {
            return e.p(" ! ! !  ", this.method, StringUtils.SPACE, this.path);
        }
        return this.responseCode + StringUtils.SPACE + this.method + StringUtils.SPACE + this.path;
    }

    @Nullable
    public final List<HttpHeader> getParsedRequestHeaders() {
        return (List) JsonConverter.a().e(this.requestHeaders, TypeToken.a(HttpHeader.class).f45460b);
    }

    @Nullable
    public final List<HttpHeader> getParsedResponseHeaders() {
        return (List) JsonConverter.a().e(this.responseHeaders, TypeToken.a(HttpHeader.class).f45460b);
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final String getProtocol() {
        return this.protocol;
    }

    @Nullable
    public final String getRequestBody() {
        return this.requestBody;
    }

    @Nullable
    public final String getRequestContentType() {
        return this.requestContentType;
    }

    @Nullable
    public final Long getRequestDate() {
        return this.requestDate;
    }

    @Nullable
    public final String getRequestDateString() {
        Long l2 = this.requestDate;
        if (l2 != null) {
            return new Date(l2.longValue()).toString();
        }
        return null;
    }

    @Nullable
    public final String getRequestHeaders() {
        return this.requestHeaders;
    }

    @Nullable
    public final Long getRequestHeadersSize() {
        return this.requestHeadersSize;
    }

    @NotNull
    public final String getRequestHeadersString(boolean z) {
        return FormatUtils.b(getParsedRequestHeaders(), z);
    }

    @Nullable
    public final Long getRequestPayloadSize() {
        return this.requestPayloadSize;
    }

    @NotNull
    public final String getRequestSizeString() {
        Long l2 = this.requestPayloadSize;
        return formatBytes(l2 != null ? l2.longValue() : 0L);
    }

    public final long getRequestTotalSize() {
        Long l2 = this.requestHeadersSize;
        long jLongValue = l2 != null ? l2.longValue() : 0L;
        Long l3 = this.requestPayloadSize;
        return jLongValue + (l3 != null ? l3.longValue() : 0L);
    }

    @Nullable
    public final String getResponseBody() {
        return this.responseBody;
    }

    @Nullable
    public final String getResponseCipherSuite() {
        return this.responseCipherSuite;
    }

    @Nullable
    public final Integer getResponseCode() {
        return this.responseCode;
    }

    @Nullable
    public final String getResponseContentType() {
        return this.responseContentType;
    }

    @Nullable
    public final Long getResponseDate() {
        return this.responseDate;
    }

    @Nullable
    public final String getResponseDateString() {
        Long l2 = this.responseDate;
        if (l2 != null) {
            return new Date(l2.longValue()).toString();
        }
        return null;
    }

    @Nullable
    public final String getResponseHeaders() {
        return this.responseHeaders;
    }

    @Nullable
    public final Long getResponseHeadersSize() {
        return this.responseHeadersSize;
    }

    @NotNull
    public final String getResponseHeadersString(boolean z) {
        return FormatUtils.b(getParsedResponseHeaders(), z);
    }

    @Nullable
    public final Bitmap getResponseImageBitmap() {
        byte[] bArr = this.responseImageData;
        if (bArr != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    @Nullable
    public final byte[] getResponseImageData() {
        return this.responseImageData;
    }

    @Nullable
    public final String getResponseMessage() {
        return this.responseMessage;
    }

    @Nullable
    public final Long getResponsePayloadSize() {
        return this.responsePayloadSize;
    }

    @Nullable
    public final String getResponseSizeString() {
        Long l2 = this.responsePayloadSize;
        if (l2 != null) {
            return formatBytes(l2.longValue());
        }
        return null;
    }

    @Nullable
    public final String getResponseSummaryText() {
        int iOrdinal = getStatus().ordinal();
        if (iOrdinal == 0) {
            return null;
        }
        if (iOrdinal == 2) {
            return this.error;
        }
        return this.responseCode + StringUtils.SPACE + this.responseMessage;
    }

    @Nullable
    public final String getResponseTlsVersion() {
        return this.responseTlsVersion;
    }

    public final long getResponseTotalSize() {
        Long l2 = this.responseHeadersSize;
        return getHarResponseBodySize() + (l2 != null ? l2.longValue() : 0L);
    }

    @Nullable
    public final String getScheme() {
        return this.scheme;
    }

    @NotNull
    public final CharSequence getSpannedRequestBody(@Nullable Context context) {
        CharSequence charSequenceSpanBody;
        String str = this.requestBody;
        if (str != null && (charSequenceSpanBody = spanBody(str, this.requestContentType, context)) != null) {
            return charSequenceSpanBody;
        }
        SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf("");
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilderValueOf, "valueOf(...)");
        return spannableStringBuilderValueOf;
    }

    @NotNull
    public final CharSequence getSpannedResponseBody(@Nullable Context context) {
        CharSequence charSequenceSpanBody;
        String str = this.responseBody;
        if (str != null && (charSequenceSpanBody = spanBody(str, this.responseContentType, context)) != null) {
            return charSequenceSpanBody;
        }
        SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf("");
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilderValueOf, "valueOf(...)");
        return spannableStringBuilderValueOf;
    }

    @NotNull
    public final Status getStatus() {
        return this.error != null ? Status.f16695c : this.responseCode == null ? Status.f16693a : Status.f16694b;
    }

    @Nullable
    public final Long getTookMs() {
        return this.tookMs;
    }

    @NotNull
    public final String getTotalSizeString() {
        Long l2 = this.requestPayloadSize;
        long jLongValue = l2 != null ? l2.longValue() : 0L;
        Long l3 = this.responsePayloadSize;
        return formatBytes(jLongValue + (l3 != null ? l3.longValue() : 0L));
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean hasTheSameContent(@org.jetbrains.annotations.Nullable com.chuckerteam.chucker.internal.data.entity.HttpTransaction r7) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.data.entity.HttpTransaction.hasTheSameContent(com.chuckerteam.chucker.internal.data.entity.HttpTransaction):boolean");
    }

    public final boolean isRequestBodyEncoded() {
        return this.isRequestBodyEncoded;
    }

    public final boolean isResponseBodyEncoded() {
        return this.isResponseBodyEncoded;
    }

    public final boolean isSsl() {
        return StringsKt.t(this.scheme, "https", true);
    }

    @NotNull
    public final HttpTransaction populateUrl(@NotNull HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, "httpUrl");
        FormattedUrl formattedUrlA = FormattedUrl.Companion.a(httpUrl, false);
        this.url = formattedUrlA.b();
        this.host = formattedUrlA.f16761b;
        this.path = formattedUrlA.a();
        this.scheme = formattedUrlA.f16760a;
        return this;
    }

    public final void setError(@Nullable String str) {
        this.error = str;
    }

    public final void setGraphQlDetected(boolean z) {
        this.graphQlDetected = z;
    }

    public final void setGraphQlOperationName(@Nullable String str) {
        this.graphQlOperationName = str;
    }

    public final void setHost(@Nullable String str) {
        this.host = str;
    }

    public final void setId(long j2) {
        this.id = j2;
    }

    public final void setMethod(@Nullable String str) {
        this.method = str;
    }

    public final void setPath(@Nullable String str) {
        this.path = str;
    }

    public final void setProtocol(@Nullable String str) {
        this.protocol = str;
    }

    public final void setRequestBody(@Nullable String str) {
        this.requestBody = str;
    }

    public final void setRequestBodyEncoded(boolean z) {
        this.isRequestBodyEncoded = z;
    }

    public final void setRequestContentType(@Nullable String str) {
        this.requestContentType = str;
    }

    public final void setRequestDate(@Nullable Long l2) {
        this.requestDate = l2;
    }

    public final void setRequestHeaders(@Nullable String str) {
        this.requestHeaders = str;
    }

    public final void setRequestHeadersSize(@Nullable Long l2) {
        this.requestHeadersSize = l2;
    }

    public final void setRequestPayloadSize(@Nullable Long l2) {
        this.requestPayloadSize = l2;
    }

    public final void setResponseBody(@Nullable String str) {
        this.responseBody = str;
    }

    public final void setResponseBodyEncoded(boolean z) {
        this.isResponseBodyEncoded = z;
    }

    public final void setResponseCipherSuite(@Nullable String str) {
        this.responseCipherSuite = str;
    }

    public final void setResponseCode(@Nullable Integer num) {
        this.responseCode = num;
    }

    public final void setResponseContentType(@Nullable String str) {
        this.responseContentType = str;
    }

    public final void setResponseDate(@Nullable Long l2) {
        this.responseDate = l2;
    }

    public final void setResponseHeaders(@Nullable String str) {
        this.responseHeaders = str;
    }

    public final void setResponseHeadersSize(@Nullable Long l2) {
        this.responseHeadersSize = l2;
    }

    public final void setResponseImageData(@Nullable byte[] bArr) {
        this.responseImageData = bArr;
    }

    public final void setResponseMessage(@Nullable String str) {
        this.responseMessage = str;
    }

    public final void setResponsePayloadSize(@Nullable Long l2) {
        this.responsePayloadSize = l2;
    }

    public final void setResponseTlsVersion(@Nullable String str) {
        this.responseTlsVersion = str;
    }

    public final void setScheme(@Nullable String str) {
        this.scheme = str;
    }

    public final void setTookMs(@Nullable Long l2) {
        this.tookMs = l2;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    public final void setGraphQlOperationName(@NotNull Headers headers) {
        Object next;
        Intrinsics.checkNotNullParameter(headers, "headers");
        Iterator<T> it = toHttpHeaderList(headers).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String lowerCase = ((HttpHeader) next).a().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.n(lowerCase, "operation-name", false)) {
                break;
            }
        }
        HttpHeader httpHeader = (HttpHeader) next;
        this.graphQlOperationName = httpHeader != null ? httpHeader.b() : null;
    }

    public final void setRequestHeaders(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        setRequestHeaders(toHttpHeaderList(headers));
    }

    public final void setResponseHeaders(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        setResponseHeaders(toHttpHeaderList(headers));
    }

    public final void setRequestHeaders(@NotNull List<HttpHeader> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.requestHeaders = JsonConverter.a().j(headers);
    }

    public final void setResponseHeaders(@NotNull List<HttpHeader> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.responseHeaders = JsonConverter.a().j(headers);
    }

    public /* synthetic */ HttpTransaction(long j2, Long l2, Long l3, Long l4, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l5, String str9, String str10, Long l6, String str11, boolean z, Integer num, String str12, String str13, Long l7, String str14, String str15, Long l8, String str16, boolean z2, byte[] bArr, boolean z3, String str17, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, l2, l3, l4, str, str2, str3, str4, str5, str6, str7, str8, l5, str9, str10, l6, str11, (i2 & 131072) != 0 ? false : z, num, str12, str13, l7, str14, str15, l8, str16, (i2 & 67108864) != 0 ? false : z2, bArr, (i2 & 268435456) != 0 ? false : z3, str17);
    }

    @Ignore
    public HttpTransaction() {
        this(0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, null, false, null, 335675393, null);
    }
}
