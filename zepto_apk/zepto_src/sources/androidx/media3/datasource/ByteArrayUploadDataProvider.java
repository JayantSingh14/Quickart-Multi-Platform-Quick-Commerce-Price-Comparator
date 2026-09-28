package androidx.media3.datasource;

import android.net.http.UploadDataProvider;
import android.net.http.UploadDataSink;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

@RequiresApi
/* loaded from: classes3.dex */
final class ByteArrayUploadDataProvider extends UploadDataProvider {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f5829a;

    /* renamed from: b, reason: collision with root package name */
    public int f5830b;

    public ByteArrayUploadDataProvider(byte[] bArr) {
        this.f5829a = bArr;
    }

    public final long getLength() {
        return this.f5829a.length;
    }

    public final void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        int iMin = Math.min(byteBuffer.remaining(), this.f5829a.length - this.f5830b);
        byteBuffer.put(this.f5829a, this.f5830b, iMin);
        this.f5830b += iMin;
        uploadDataSink.onReadSucceeded(false);
    }

    public final void rewind(UploadDataSink uploadDataSink) {
        this.f5830b = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
