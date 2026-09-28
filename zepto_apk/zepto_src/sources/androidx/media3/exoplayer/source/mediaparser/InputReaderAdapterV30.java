package androidx.media3.exoplayer.source.mediaparser;

import android.annotation.SuppressLint;
import android.media.MediaParser$SeekableInputReader;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@RequiresApi
@SuppressLint({"Override"})
@UnstableApi
/* loaded from: classes3.dex */
public final class InputReaderAdapterV30 implements MediaParser$SeekableInputReader {

    /* renamed from: a, reason: collision with root package name */
    public DataReader f7921a;

    /* renamed from: b, reason: collision with root package name */
    public long f7922b;

    /* renamed from: c, reason: collision with root package name */
    public long f7923c;

    /* renamed from: d, reason: collision with root package name */
    public long f7924d;

    public final long getLength() {
        return this.f7922b;
    }

    public final long getPosition() {
        return this.f7923c;
    }

    public final int read(byte[] bArr, int i2, int i3) {
        DataReader dataReader = this.f7921a;
        int i4 = Util.f5744a;
        int i5 = dataReader.read(bArr, i2, i3);
        this.f7923c += i5;
        return i5;
    }

    public final void seekToPosition(long j2) {
        this.f7924d = j2;
    }
}
