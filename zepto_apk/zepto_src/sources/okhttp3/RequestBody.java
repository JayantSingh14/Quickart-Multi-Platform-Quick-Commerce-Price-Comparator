package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public abstract class RequestBody {

    @NotNull
    public static final Companion Companion = new Companion();

    @Metadata
    public static final class Companion {
        public static RequestBody$Companion$toRequestBody$2 a(String str, MediaType mediaType) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Charset charset = Charsets.UTF_8;
            if (mediaType != null) {
                Pattern pattern = MediaType.f56278d;
                Charset charsetA = mediaType.a(null);
                if (charsetA == null) {
                    mediaType = MediaType.Companion.b(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetA;
                }
            }
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return b(mediaType, bytes, 0, bytes.length);
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [okhttp3.RequestBody$Companion$toRequestBody$2] */
        public static RequestBody$Companion$toRequestBody$2 b(final MediaType mediaType, final byte[] bArr, final int i2, final int i3) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            long length = bArr.length;
            long j2 = i2;
            long j3 = i3;
            byte[] bArr2 = Util.f56394a;
            if ((j2 | j3) < 0 || j2 > length || length - j2 < j3) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public final long contentLength() {
                    return i3;
                }

                @Override // okhttp3.RequestBody
                public final MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public final void writeTo(BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    int i4 = i3;
                    sink.x0(i2, bArr, i4);
                }
            };
        }

        public static /* synthetic */ RequestBody$Companion$toRequestBody$2 c(Companion companion, byte[] bArr, MediaType mediaType, int i2, int i3) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            int length = bArr.length;
            companion.getClass();
            return b(mediaType, bArr, i2, length);
        }
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final RequestBody create(@NotNull String str, @Nullable MediaType mediaType) {
        Companion.getClass();
        return Companion.a(str, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink);

    @Deprecated
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new RequestBody$Companion$asRequestBody$1(mediaType, file);
    }

    @Deprecated
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull String content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        return Companion.a(content, mediaType);
    }

    @Deprecated
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(content, "<this>");
        return new RequestBody$Companion$toRequestBody$1(mediaType, content);
    }

    @JvmStatic
    @NotNull
    @Deprecated
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        int length = content.length;
        Intrinsics.checkNotNullParameter(content, "content");
        return Companion.b(mediaType, content, 0, length);
    }

    @JvmStatic
    @NotNull
    @Deprecated
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content, int i2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        int length = content.length;
        Intrinsics.checkNotNullParameter(content, "content");
        return Companion.b(mediaType, content, i2, length);
    }

    @JvmStatic
    @JvmName
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr) {
        Companion companion = Companion;
        companion.getClass();
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return Companion.c(companion, bArr, null, 0, 7);
    }

    @JvmStatic
    @JvmName
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
        Companion companion = Companion;
        companion.getClass();
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return Companion.c(companion, bArr, mediaType, 0, 6);
    }

    @JvmStatic
    @JvmName
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i2) {
        Companion companion = Companion;
        companion.getClass();
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return Companion.c(companion, bArr, mediaType, i2, 4);
    }

    @JvmStatic
    @JvmName
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i2, int i3) {
        Companion.getClass();
        return Companion.b(mediaType, bArr, i2, i3);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final RequestBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return new RequestBody$Companion$toRequestBody$1(mediaType, byteString);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final RequestBody create(@NotNull File file, @Nullable MediaType mediaType) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new RequestBody$Companion$asRequestBody$1(mediaType, file);
    }

    @JvmStatic
    @NotNull
    @Deprecated
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content, int i2, int i3) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        return Companion.b(mediaType, content, i2, i3);
    }
}
