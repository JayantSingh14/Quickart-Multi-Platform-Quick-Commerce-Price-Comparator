package okhttp3.internal.http2;

import coil3.network.internal.UtilsKt;
import com.google.android.gms.common.api.Api;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.Huffman;
import okio.Buffer;
import okio.ByteString;
import okio.Okio;
import okio.RealBufferedSource;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

@Metadata
/* loaded from: classes.dex */
public final class Hpack {

    /* renamed from: a, reason: collision with root package name */
    public static final Header[] f56636a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f56637b;

    @Metadata
    public static final class Reader {

        /* renamed from: a, reason: collision with root package name */
        public int f56638a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f56639b;

        /* renamed from: c, reason: collision with root package name */
        public final RealBufferedSource f56640c;

        /* renamed from: d, reason: collision with root package name */
        public Header[] f56641d;

        /* renamed from: e, reason: collision with root package name */
        public int f56642e;

        /* renamed from: f, reason: collision with root package name */
        public int f56643f;

        /* renamed from: g, reason: collision with root package name */
        public int f56644g;

        public Reader(Http2Reader.ContinuationSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f56638a = 4096;
            this.f56639b = new ArrayList();
            this.f56640c = Okio.d(source);
            this.f56641d = new Header[8];
            this.f56642e = 7;
        }

        public final int a(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f56641d.length;
                while (true) {
                    length--;
                    i3 = this.f56642e;
                    if (length < i3 || i2 <= 0) {
                        break;
                    }
                    Header header = this.f56641d[length];
                    Intrinsics.c(header);
                    int i5 = header.f56635c;
                    i2 -= i5;
                    this.f56644g -= i5;
                    this.f56643f--;
                    i4++;
                }
                Header[] headerArr = this.f56641d;
                System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i4, this.f56643f);
                this.f56642e += i4;
            }
            return i4;
        }

        public final ByteString b(int i2) throws IOException {
            if (i2 >= 0) {
                Header[] headerArr = Hpack.f56636a;
                if (i2 <= headerArr.length - 1) {
                    return headerArr[i2].f56633a;
                }
            }
            int length = this.f56642e + 1 + (i2 - Hpack.f56636a.length);
            if (length >= 0) {
                Header[] headerArr2 = this.f56641d;
                if (length < headerArr2.length) {
                    Header header = headerArr2[length];
                    Intrinsics.c(header);
                    return header.f56633a;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        public final void c(Header header) {
            this.f56639b.add(header);
            int i2 = this.f56638a;
            int i3 = header.f56635c;
            if (i3 > i2) {
                Header[] headerArr = this.f56641d;
                ArraysKt.q(headerArr, null, 0, headerArr.length);
                this.f56642e = this.f56641d.length - 1;
                this.f56643f = 0;
                this.f56644g = 0;
                return;
            }
            a((this.f56644g + i3) - i2);
            int i4 = this.f56643f + 1;
            Header[] headerArr2 = this.f56641d;
            if (i4 > headerArr2.length) {
                Header[] headerArr3 = new Header[headerArr2.length * 2];
                System.arraycopy(headerArr2, 0, headerArr3, headerArr2.length, headerArr2.length);
                this.f56642e = this.f56641d.length - 1;
                this.f56641d = headerArr3;
            }
            int i5 = this.f56642e;
            this.f56642e = i5 - 1;
            this.f56641d[i5] = header;
            this.f56643f++;
            this.f56644g += i3;
        }

        public final ByteString d() {
            int i2;
            RealBufferedSource source = this.f56640c;
            byte bE = source.e();
            byte[] bArr = Util.f56394a;
            int i3 = bE & 255;
            int i4 = 0;
            boolean z = (bE & 128) == 128;
            long jE = e(i3, WKSRecord.Service.LOCUS_CON);
            if (!z) {
                return source.l(jE);
            }
            Buffer sink = new Buffer();
            int[] iArr = Huffman.f56757a;
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            Huffman.Node node = Huffman.f56759c;
            Huffman.Node node2 = node;
            int i5 = 0;
            for (long j2 = 0; j2 < jE; j2++) {
                byte bE2 = source.e();
                byte[] bArr2 = Util.f56394a;
                i4 = (i4 << 8) | (bE2 & 255);
                i5 += 8;
                while (i5 >= 8) {
                    Huffman.Node[] nodeArr = node2.f56760a;
                    Intrinsics.c(nodeArr);
                    node2 = nodeArr[(i4 >>> (i5 - 8)) & 255];
                    Intrinsics.c(node2);
                    if (node2.f56760a == null) {
                        sink.O1(node2.f56761b);
                        i5 -= node2.f56762c;
                        node2 = node;
                    } else {
                        i5 -= 8;
                    }
                }
            }
            while (i5 > 0) {
                Huffman.Node[] nodeArr2 = node2.f56760a;
                Intrinsics.c(nodeArr2);
                Huffman.Node node3 = nodeArr2[(i4 << (8 - i5)) & 255];
                Intrinsics.c(node3);
                if (node3.f56760a != null || (i2 = node3.f56762c) > i5) {
                    break;
                }
                sink.O1(node3.f56761b);
                i5 -= i2;
                node2 = node;
            }
            return sink.s0(sink.f56914b);
        }

        public final int e(int i2, int i3) {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                byte bE = this.f56640c.e();
                byte[] bArr = Util.f56394a;
                int i6 = bE & 255;
                if ((bE & 128) == 0) {
                    return i3 + (i6 << i5);
                }
                i3 += (bE & 127) << i5;
                i5 += 7;
            }
        }
    }

    @Metadata
    public static final class Writer {

        /* renamed from: a, reason: collision with root package name */
        public final Buffer f56645a;

        /* renamed from: b, reason: collision with root package name */
        public int f56646b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f56647c;

        /* renamed from: d, reason: collision with root package name */
        public int f56648d;

        /* renamed from: e, reason: collision with root package name */
        public Header[] f56649e;

        /* renamed from: f, reason: collision with root package name */
        public int f56650f;

        /* renamed from: g, reason: collision with root package name */
        public int f56651g;

        /* renamed from: h, reason: collision with root package name */
        public int f56652h;

        public Writer(Buffer out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.f56645a = out;
            this.f56646b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f56648d = 4096;
            this.f56649e = new Header[8];
            this.f56650f = 7;
        }

        public final void a(int i2) {
            int i3;
            if (i2 > 0) {
                int length = this.f56649e.length - 1;
                int i4 = 0;
                while (true) {
                    i3 = this.f56650f;
                    if (length < i3 || i2 <= 0) {
                        break;
                    }
                    Header header = this.f56649e[length];
                    Intrinsics.c(header);
                    i2 -= header.f56635c;
                    int i5 = this.f56652h;
                    Header header2 = this.f56649e[length];
                    Intrinsics.c(header2);
                    this.f56652h = i5 - header2.f56635c;
                    this.f56651g--;
                    i4++;
                    length--;
                }
                Header[] headerArr = this.f56649e;
                int i6 = i3 + 1;
                System.arraycopy(headerArr, i6, headerArr, i6 + i4, this.f56651g);
                Header[] headerArr2 = this.f56649e;
                int i7 = this.f56650f + 1;
                Arrays.fill(headerArr2, i7, i7 + i4, (Object) null);
                this.f56650f += i4;
            }
        }

        public final void b(Header header) {
            int i2 = this.f56648d;
            int i3 = header.f56635c;
            if (i3 > i2) {
                Header[] headerArr = this.f56649e;
                ArraysKt.q(headerArr, null, 0, headerArr.length);
                this.f56650f = this.f56649e.length - 1;
                this.f56651g = 0;
                this.f56652h = 0;
                return;
            }
            a((this.f56652h + i3) - i2);
            int i4 = this.f56651g + 1;
            Header[] headerArr2 = this.f56649e;
            if (i4 > headerArr2.length) {
                Header[] headerArr3 = new Header[headerArr2.length * 2];
                System.arraycopy(headerArr2, 0, headerArr3, headerArr2.length, headerArr2.length);
                this.f56650f = this.f56649e.length - 1;
                this.f56649e = headerArr3;
            }
            int i5 = this.f56650f;
            this.f56650f = i5 - 1;
            this.f56649e[i5] = header;
            this.f56651g++;
            this.f56652h += i3;
        }

        public final void c(ByteString source) throws EOFException {
            Intrinsics.checkNotNullParameter(source, "data");
            Buffer buffer = this.f56645a;
            int[] iArr = Huffman.f56757a;
            Intrinsics.checkNotNullParameter(source, "bytes");
            int iD = source.d();
            long j2 = 0;
            for (int i2 = 0; i2 < iD; i2++) {
                byte bL = source.l(i2);
                byte[] bArr = Util.f56394a;
                j2 += Huffman.f56758b[bL & 255];
            }
            if (((int) ((j2 + 7) >> 3)) >= source.d()) {
                e(source.d(), WKSRecord.Service.LOCUS_CON, 0);
                buffer.s1(source);
                return;
            }
            Buffer sink = new Buffer();
            int[] iArr2 = Huffman.f56757a;
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            int iD2 = source.d();
            long j3 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < iD2; i4++) {
                byte bL2 = source.l(i4);
                byte[] bArr2 = Util.f56394a;
                int i5 = bL2 & 255;
                int i6 = Huffman.f56757a[i5];
                byte b2 = Huffman.f56758b[i5];
                j3 = (j3 << b2) | i6;
                i3 += b2;
                while (i3 >= 8) {
                    i3 -= 8;
                    sink.O1((int) (j3 >> i3));
                }
            }
            if (i3 > 0) {
                sink.O1((int) ((255 >>> i3) | (j3 << (8 - i3))));
            }
            ByteString byteStringS0 = sink.s0(sink.f56914b);
            e(byteStringS0.d(), WKSRecord.Service.LOCUS_CON, 128);
            buffer.s1(byteStringS0);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d(java.util.ArrayList r14) throws java.io.EOFException {
            /*
                Method dump skipped, instructions count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.d(java.util.ArrayList):void");
        }

        public final void e(int i2, int i3, int i4) {
            Buffer buffer = this.f56645a;
            if (i2 < i3) {
                buffer.O1(i2 | i4);
                return;
            }
            buffer.O1(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                buffer.O1(128 | (i5 & WKSRecord.Service.LOCUS_CON));
                i5 >>>= 7;
            }
            buffer.O1(i5);
        }
    }

    static {
        Header header = new Header(Header.f56632i, "");
        ByteString byteString = Header.f56629f;
        Header header2 = new Header(byteString, UtilsKt.HTTP_METHOD_GET);
        Header header3 = new Header(byteString, "POST");
        ByteString byteString2 = Header.f56630g;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.f56631h;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.f56628e;
        Header[] headerArr = {header, header2, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header(CLConstants.SHARED_PREFERENCE_ITEM_DATE, ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        f56636a = headerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i2 = 0; i2 < 61; i2++) {
            if (!linkedHashMap.containsKey(headerArr[i2].f56633a)) {
                linkedHashMap.put(headerArr[i2].f56633a, Integer.valueOf(i2));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(result)");
        f56637b = mapUnmodifiableMap;
    }

    public static void a(ByteString name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int iD = name.d();
        for (int i2 = 0; i2 < iD; i2++) {
            byte bL = name.l(i2);
            if (65 <= bL && bL < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(name.z()));
            }
        }
    }
}
