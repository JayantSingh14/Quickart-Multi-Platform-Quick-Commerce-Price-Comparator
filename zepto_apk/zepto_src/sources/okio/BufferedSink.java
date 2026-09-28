package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink D1(ByteString byteString);

    BufferedSink E0(long j2);

    OutputStream P1();

    BufferedSink Y(String str);

    @Override // okio.Sink, java.io.Flushable
    void flush();

    Buffer g();

    long g0(Source source);

    BufferedSink write(byte[] bArr);

    BufferedSink writeByte(int i2);

    BufferedSink x0(int i2, byte[] bArr, int i3);
}
