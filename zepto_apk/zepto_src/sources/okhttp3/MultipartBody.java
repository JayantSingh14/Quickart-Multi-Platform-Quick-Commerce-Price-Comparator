package okhttp3;

import coil3.network.internal.UtilsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

@Metadata
/* loaded from: classes3.dex */
public final class MultipartBody extends RequestBody {

    /* renamed from: e, reason: collision with root package name */
    public static final MediaType f56283e;

    /* renamed from: f, reason: collision with root package name */
    public static final MediaType f56284f;

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f56285g;

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f56286h;

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f56287i;

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f56288a;

    /* renamed from: b, reason: collision with root package name */
    public final List f56289b;

    /* renamed from: c, reason: collision with root package name */
    public final MediaType f56290c;

    /* renamed from: d, reason: collision with root package name */
    public long f56291d;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final ByteString f56292a;

        /* renamed from: b, reason: collision with root package name */
        public MediaType f56293b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f56294c;

        @JvmOverloads
        public Builder() {
            String boundary = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(boundary, "randomUUID().toString()");
            Intrinsics.checkNotNullParameter(boundary, "boundary");
            ByteString byteString = ByteString.f56924d;
            this.f56292a = ByteString.Companion.c(boundary);
            this.f56293b = MultipartBody.f56283e;
            this.f56294c = new ArrayList();
        }

        public final void a(Headers headers, RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.checkNotNullParameter(body, "body");
            if ((headers != null ? headers.d(UtilsKt.CONTENT_TYPE) : null) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if ((headers != null ? headers.d("Content-Length") : null) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            b(new Part(headers, body));
        }

        public final void b(Part part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.f56294c.add(part);
        }

        public final MultipartBody c() {
            ArrayList arrayList = this.f56294c;
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.f56292a, this.f56293b, Util.y(arrayList));
        }

        public final void d(MediaType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (Intrinsics.b(type.f56281b, "multipart")) {
                this.f56293b = type;
            } else {
                throw new IllegalArgumentException(("multipart != " + type).toString());
            }
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Part {

        /* renamed from: a, reason: collision with root package name */
        public final Headers f56295a;

        /* renamed from: b, reason: collision with root package name */
        public final RequestBody f56296b;

        @Metadata
        @SourceDebugExtension
        public static final class Companion {
        }

        public Part(Headers headers, RequestBody requestBody) {
            this.f56295a = headers;
            this.f56296b = requestBody;
        }
    }

    static {
        Pattern pattern = MediaType.f56278d;
        f56283e = MediaType.Companion.a("multipart/mixed");
        MediaType.Companion.a("multipart/alternative");
        MediaType.Companion.a("multipart/digest");
        MediaType.Companion.a("multipart/parallel");
        f56284f = MediaType.Companion.a("multipart/form-data");
        f56285g = new byte[]{58, 32};
        f56286h = new byte[]{13, 10};
        f56287i = new byte[]{45, 45};
    }

    public MultipartBody(ByteString boundaryByteString, MediaType type, List parts) {
        Intrinsics.checkNotNullParameter(boundaryByteString, "boundaryByteString");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parts, "parts");
        this.f56288a = boundaryByteString;
        this.f56289b = parts;
        Pattern pattern = MediaType.f56278d;
        this.f56290c = MediaType.Companion.a(type + "; boundary=" + boundaryByteString.z());
        this.f56291d = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        BufferedSink buffer2;
        if (z) {
            buffer2 = new Buffer();
            buffer = buffer2;
        } else {
            buffer = 0;
            buffer2 = bufferedSink;
        }
        List list = this.f56289b;
        int size = list.size();
        long j2 = 0;
        int i2 = 0;
        while (true) {
            ByteString byteString = this.f56288a;
            byte[] bArr = f56287i;
            byte[] bArr2 = f56286h;
            if (i2 >= size) {
                Intrinsics.c(buffer2);
                buffer2.write(bArr);
                buffer2.D1(byteString);
                buffer2.write(bArr);
                buffer2.write(bArr2);
                if (!z) {
                    return j2;
                }
                Intrinsics.c(buffer);
                long j3 = j2 + buffer.f56914b;
                buffer.a();
                return j3;
            }
            Part part = (Part) list.get(i2);
            Headers headers = part.f56295a;
            Intrinsics.c(buffer2);
            buffer2.write(bArr);
            buffer2.D1(byteString);
            buffer2.write(bArr2);
            if (headers != null) {
                int size2 = headers.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    buffer2.Y(headers.f(i3)).write(f56285g).Y(headers.m(i3)).write(bArr2);
                }
            }
            RequestBody requestBody = part.f56296b;
            MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                buffer2.Y("Content-Type: ").Y(mediaTypeContentType.f56280a).write(bArr2);
            }
            long jContentLength = requestBody.contentLength();
            if (jContentLength != -1) {
                buffer2.Y("Content-Length: ").E0(jContentLength).write(bArr2);
            } else if (z) {
                Intrinsics.c(buffer);
                buffer.a();
                return -1L;
            }
            buffer2.write(bArr2);
            if (z) {
                j2 += jContentLength;
            } else {
                requestBody.writeTo(buffer2);
            }
            buffer2.write(bArr2);
            i2++;
        }
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() throws IOException {
        long j2 = this.f56291d;
        if (j2 != -1) {
            return j2;
        }
        long jA = a(null, true);
        this.f56291d = jA;
        return jA;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.f56290c;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        a(sink, false);
    }
}
