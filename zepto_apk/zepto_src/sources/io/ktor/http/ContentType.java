package io.ktor.http;

import com.amazon.apay.hardened.external.model.APayConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ContentType extends HeaderValueWithParameters {

    /* renamed from: e, reason: collision with root package name */
    public static final ContentType f50126e = new ContentType("*", "*", EmptyList.f53609a);

    /* renamed from: c, reason: collision with root package name */
    public final String f50127c;

    /* renamed from: d, reason: collision with root package name */
    public final String f50128d;

    @Metadata
    public static final class Application {

        /* renamed from: a, reason: collision with root package name */
        public static final ContentType f50129a;

        /* renamed from: b, reason: collision with root package name */
        public static final ContentType f50130b;

        static {
            EmptyList emptyList = EmptyList.f53609a;
            new ContentType("application", "*", emptyList);
            new ContentType("application", "atom+xml", emptyList);
            new ContentType("application", "cbor", emptyList);
            f50129a = new ContentType("application", "json", emptyList);
            new ContentType("application", "hal+json", emptyList);
            new ContentType("application", "javascript", emptyList);
            f50130b = new ContentType("application", "octet-stream", emptyList);
            new ContentType("application", "rss+xml", emptyList);
            new ContentType("application", "xml", emptyList);
            new ContentType("application", "xml-dtd", emptyList);
            new ContentType("application", "zip", emptyList);
            new ContentType("application", "gzip", emptyList);
            new ContentType("application", "x-www-form-urlencoded", emptyList);
            new ContentType("application", "pdf", emptyList);
            new ContentType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet", emptyList);
            new ContentType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document", emptyList);
            new ContentType("application", "vnd.openxmlformats-officedocument.presentationml.presentation", emptyList);
            new ContentType("application", "protobuf", emptyList);
            new ContentType("application", "wasm", emptyList);
            new ContentType("application", "problem+json", emptyList);
            new ContentType("application", "problem+xml", emptyList);
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Audio {
        static {
            EmptyList emptyList = EmptyList.f53609a;
            new ContentType("audio", "*", emptyList);
            new ContentType("audio", "mp4", emptyList);
            new ContentType("audio", "mpeg", emptyList);
            new ContentType("audio", "ogg", emptyList);
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static ContentType a(String value) throws BadContentTypeFormatException {
            Intrinsics.checkNotNullParameter(value, "value");
            if (StringsKt.z(value)) {
                return ContentType.f50126e;
            }
            HeaderValue headerValue = (HeaderValue) CollectionsKt.F(HttpHeaderValueParserKt.a(value));
            String str = headerValue.f50192a;
            int iW = StringsKt.w(str, '/', 0, 6);
            if (iW == -1) {
                if (Intrinsics.b(StringsKt.b0(str).toString(), "*")) {
                    return ContentType.f50126e;
                }
                throw new BadContentTypeFormatException(value);
            }
            String strSubstring = str.substring(0, iW);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String string = StringsKt.b0(strSubstring).toString();
            if (string.length() == 0) {
                throw new BadContentTypeFormatException(value);
            }
            String strSubstring2 = str.substring(iW + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            String string2 = StringsKt.b0(strSubstring2).toString();
            if (StringsKt.o(string, ' ') || StringsKt.o(string2, ' ')) {
                throw new BadContentTypeFormatException(value);
            }
            if (string2.length() == 0 || StringsKt.o(string2, '/')) {
                throw new BadContentTypeFormatException(value);
            }
            return new ContentType(string, string2, headerValue.f50193b);
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Font {
        static {
            EmptyList emptyList = EmptyList.f53609a;
            new ContentType("font", "*", emptyList);
            new ContentType("font", "collection", emptyList);
            new ContentType("font", "otf", emptyList);
            new ContentType("font", "sfnt", emptyList);
            new ContentType("font", "ttf", emptyList);
            new ContentType("font", "woff", emptyList);
            new ContentType("font", "woff2", emptyList);
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Image {
        static {
            EmptyList emptyList = EmptyList.f53609a;
            new ContentType("image", "*", emptyList);
            new ContentType("image", "gif", emptyList);
            new ContentType("image", "jpeg", emptyList);
            new ContentType("image", "png", emptyList);
            new ContentType("image", "svg+xml", emptyList);
            new ContentType("image", "x-icon", emptyList);
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Message {
        static {
            EmptyList emptyList = EmptyList.f53609a;
            new ContentType(APayConstants.Error.MESSAGE, "*", emptyList);
            new ContentType(APayConstants.Error.MESSAGE, "http", emptyList);
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class MultiPart {
        static {
            EmptyList emptyList = EmptyList.f53609a;
            new ContentType("multipart", "*", emptyList);
            new ContentType("multipart", "mixed", emptyList);
            new ContentType("multipart", "alternative", emptyList);
            new ContentType("multipart", "related", emptyList);
            new ContentType("multipart", "form-data", emptyList);
            new ContentType("multipart", "signed", emptyList);
            new ContentType("multipart", "encrypted", emptyList);
            new ContentType("multipart", "byteranges", emptyList);
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Text {

        /* renamed from: a, reason: collision with root package name */
        public static final ContentType f50131a;

        static {
            EmptyList emptyList = EmptyList.f53609a;
            new ContentType("text", "*", emptyList);
            f50131a = new ContentType("text", "plain", emptyList);
            new ContentType("text", "css", emptyList);
            new ContentType("text", "csv", emptyList);
            new ContentType("text", "html", emptyList);
            new ContentType("text", "javascript", emptyList);
            new ContentType("text", "vcard", emptyList);
            new ContentType("text", "xml", emptyList);
            new ContentType("text", "event-stream", emptyList);
        }

        public static ContentType a() {
            return f50131a;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Video {
        static {
            EmptyList emptyList = EmptyList.f53609a;
            new ContentType("video", "*", emptyList);
            new ContentType("video", "mpeg", emptyList);
            new ContentType("video", "mp4", emptyList);
            new ContentType("video", "ogg", emptyList);
            new ContentType("video", "quicktime", emptyList);
        }
    }

    public ContentType(String str, String str2, String str3, List list) {
        super(str3, list);
        this.f50127c = str;
        this.f50128d = str2;
    }

    public final boolean b(ContentType pattern) {
        boolean zT;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (Intrinsics.b(pattern.f50127c, "*") || StringsKt.t(pattern.f50127c, this.f50127c, true)) {
            String str = pattern.f50128d;
            if (Intrinsics.b(str, "*") || StringsKt.t(str, this.f50128d, true)) {
                for (HeaderValueParam headerValueParam : pattern.f50198b) {
                    String strA = headerValueParam.a();
                    String strB = headerValueParam.b();
                    if (Intrinsics.b(strA, "*")) {
                        if (!Intrinsics.b(strB, "*")) {
                            List list = this.f50198b;
                            if (!(list instanceof Collection) || !list.isEmpty()) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    if (StringsKt.t(((HeaderValueParam) it.next()).d(), strB, true)) {
                                    }
                                }
                            }
                            zT = false;
                        }
                        zT = true;
                        break;
                    }
                    String strA2 = a(strA);
                    if (!Intrinsics.b(strB, "*")) {
                        zT = StringsKt.t(strA2, strB, true);
                    } else {
                        if (strA2 != null) {
                            zT = true;
                            break;
                            break;
                        }
                        zT = false;
                    }
                    if (!zT) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        if (kotlin.text.StringsKt.t(r2.d(), r7, true) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.ktor.http.ContentType c(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "name"
            java.lang.String r1 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.List r0 = r6.f50198b
            int r2 = r0.size()
            if (r2 == 0) goto L69
            r3 = 1
            if (r2 == r3) goto L4d
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r4 = r2 instanceof java.util.Collection
            if (r4 == 0) goto L28
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L28
            goto L69
        L28:
            java.util.Iterator r2 = r2.iterator()
        L2c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L69
            java.lang.Object r4 = r2.next()
            io.ktor.http.HeaderValueParam r4 = (io.ktor.http.HeaderValueParam) r4
            java.lang.String r5 = r4.c()
            boolean r5 = kotlin.text.StringsKt.t(r5, r1, r3)
            if (r5 == 0) goto L2c
            java.lang.String r4 = r4.d()
            boolean r4 = kotlin.text.StringsKt.t(r4, r7, r3)
            if (r4 == 0) goto L2c
            goto L68
        L4d:
            r2 = 0
            java.lang.Object r2 = r0.get(r2)
            io.ktor.http.HeaderValueParam r2 = (io.ktor.http.HeaderValueParam) r2
            java.lang.String r4 = r2.c()
            boolean r4 = kotlin.text.StringsKt.t(r4, r1, r3)
            if (r4 == 0) goto L69
            java.lang.String r2 = r2.d()
            boolean r2 = kotlin.text.StringsKt.t(r2, r7, r3)
            if (r2 == 0) goto L69
        L68:
            return r6
        L69:
            io.ktor.http.ContentType r2 = new io.ktor.http.ContentType
            java.util.Collection r0 = (java.util.Collection) r0
            io.ktor.http.HeaderValueParam r3 = new io.ktor.http.HeaderValueParam
            r3.<init>(r1, r7)
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt.K(r3, r0)
            java.lang.String r0 = r6.f50128d
            java.lang.String r1 = r6.f50197a
            java.lang.String r3 = r6.f50127c
            r2.<init>(r3, r0, r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.ContentType.c(java.lang.String):io.ktor.http.ContentType");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ContentType)) {
            return false;
        }
        ContentType contentType = (ContentType) obj;
        if (StringsKt.t(this.f50127c, contentType.f50127c, true) && StringsKt.t(this.f50128d, contentType.f50128d, true)) {
            return Intrinsics.b(this.f50198b, contentType.f50198b);
        }
        return false;
    }

    public final int hashCode() {
        Locale locale = Locale.ROOT;
        String lowerCase = this.f50127c.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.f50128d.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return (this.f50198b.hashCode() * 31) + lowerCase2.hashCode() + (iHashCode * 31) + iHashCode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentType(String contentType, String contentSubtype, List parameters) {
        this(contentType, contentSubtype, contentType + '/' + contentSubtype, parameters);
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentSubtype, "contentSubtype");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }
}
