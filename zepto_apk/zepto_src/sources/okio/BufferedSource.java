package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    String A1();

    Buffer B();

    long F1(Sink sink);

    InputStream Q1();

    int R1(Options options);

    byte[] U0();

    Buffer g();

    boolean h0(long j2);

    String p0();

    String p1(Charset charset);

    RealBufferedSource peek();
}
