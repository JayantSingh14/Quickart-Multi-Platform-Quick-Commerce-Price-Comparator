package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public interface ExtractorInput extends DataReader {
    boolean b(byte[] bArr, int i2, int i3, boolean z);

    void d();

    boolean e(byte[] bArr, int i2, int i3, boolean z);

    void f(int i2, byte[] bArr, int i3);

    long g();

    long getLength();

    long getPosition();

    void h(int i2);

    void i(int i2);

    void readFully(byte[] bArr, int i2, int i3);
}
