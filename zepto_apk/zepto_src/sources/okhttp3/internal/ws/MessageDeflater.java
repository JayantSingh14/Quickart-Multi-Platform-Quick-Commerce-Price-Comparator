package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Deflater;
import kotlin.Metadata;
import okio.Buffer;
import okio.DeflaterSink;

@Metadata
/* loaded from: classes3.dex */
public final class MessageDeflater implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f56823a;

    /* renamed from: b, reason: collision with root package name */
    public final Buffer f56824b;

    /* renamed from: c, reason: collision with root package name */
    public final Deflater f56825c;

    /* renamed from: d, reason: collision with root package name */
    public final DeflaterSink f56826d;

    public MessageDeflater(boolean z) {
        this.f56823a = z;
        Buffer buffer = new Buffer();
        this.f56824b = buffer;
        Deflater deflater = new Deflater(-1, true);
        this.f56825c = deflater;
        this.f56826d = new DeflaterSink(buffer, deflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.f56826d.close();
    }
}
