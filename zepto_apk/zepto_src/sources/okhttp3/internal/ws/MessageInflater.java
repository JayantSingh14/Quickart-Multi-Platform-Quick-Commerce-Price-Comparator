package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Inflater;
import kotlin.Metadata;
import okio.Buffer;
import okio.InflaterSource;

@Metadata
/* loaded from: classes3.dex */
public final class MessageInflater implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f56828a;

    /* renamed from: b, reason: collision with root package name */
    public final Buffer f56829b;

    /* renamed from: c, reason: collision with root package name */
    public final Inflater f56830c;

    /* renamed from: d, reason: collision with root package name */
    public final InflaterSource f56831d;

    public MessageInflater(boolean z) {
        this.f56828a = z;
        Buffer buffer = new Buffer();
        this.f56829b = buffer;
        Inflater inflater = new Inflater(true);
        this.f56830c = inflater;
        this.f56831d = new InflaterSource(buffer, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f56831d.close();
    }
}
