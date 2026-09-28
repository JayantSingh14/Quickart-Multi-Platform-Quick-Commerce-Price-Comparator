package okhttp3;

import android.support.v4.media.b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.BufferedSource;
import org.xbill.DNS.TTL;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class ResponseBody implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public BomAwareReader f56376a;

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class BomAwareReader extends Reader implements AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        public final BufferedSource f56377a;

        /* renamed from: b, reason: collision with root package name */
        public final Charset f56378b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f56379c;

        /* renamed from: d, reason: collision with root package name */
        public InputStreamReader f56380d;

        public BomAwareReader(BufferedSource source, Charset charset) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(charset, "charset");
            this.f56377a = source;
            this.f56378b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            Unit unit;
            this.f56379c = true;
            InputStreamReader inputStreamReader = this.f56380d;
            if (inputStreamReader != null) {
                inputStreamReader.close();
                unit = Unit.f53572a;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.f56377a.close();
            }
        }

        @Override // java.io.Reader
        public final int read(char[] cbuf, int i2, int i3) throws IOException {
            Intrinsics.checkNotNullParameter(cbuf, "cbuf");
            if (this.f56379c) {
                throw new IOException("Stream closed");
            }
            InputStreamReader inputStreamReader = this.f56380d;
            if (inputStreamReader == null) {
                BufferedSource bufferedSource = this.f56377a;
                inputStreamReader = new InputStreamReader(bufferedSource.Q1(), Util.s(bufferedSource, this.f56378b));
                this.f56380d = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i2, i3);
        }
    }

    @Metadata
    public static final class Companion {
    }

    public final InputStream a() {
        return source().Q1();
    }

    public final byte[] b() {
        long jE = e();
        if (jE > TTL.MAX_VALUE) {
            throw new IOException(b.i(jE, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSourceSource = source();
        try {
            byte[] bArrU0 = bufferedSourceSource.U0();
            bufferedSourceSource.close();
            int length = bArrU0.length;
            if (jE == -1 || jE == length) {
                return bArrU0;
            }
            throw new IOException("Content-Length (" + jE + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    public final Reader c() {
        Charset charsetA;
        BomAwareReader bomAwareReader = this.f56376a;
        if (bomAwareReader == null) {
            BufferedSource bufferedSourceSource = source();
            MediaType mediaTypeL = l();
            if (mediaTypeL == null || (charsetA = mediaTypeL.a(Charsets.UTF_8)) == null) {
                charsetA = Charsets.UTF_8;
            }
            bomAwareReader = new BomAwareReader(bufferedSourceSource, charsetA);
            this.f56376a = bomAwareReader;
        }
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.c(source());
    }

    public abstract long e();

    public abstract MediaType l();

    public final String r() throws IOException {
        Charset charsetA;
        BufferedSource bufferedSourceSource = source();
        try {
            MediaType mediaTypeL = l();
            if (mediaTypeL == null || (charsetA = mediaTypeL.a(Charsets.UTF_8)) == null) {
                charsetA = Charsets.UTF_8;
            }
            String strP1 = bufferedSourceSource.p1(Util.s(bufferedSourceSource, charsetA));
            bufferedSourceSource.close();
            return strP1;
        } finally {
        }
    }

    public abstract BufferedSource source();
}
