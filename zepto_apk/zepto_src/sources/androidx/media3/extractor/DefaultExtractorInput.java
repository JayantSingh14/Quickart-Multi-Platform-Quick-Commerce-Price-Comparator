package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultExtractorInput implements ExtractorInput {

    /* renamed from: b, reason: collision with root package name */
    public final DataReader f8517b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8518c;

    /* renamed from: d, reason: collision with root package name */
    public long f8519d;

    /* renamed from: f, reason: collision with root package name */
    public int f8521f;

    /* renamed from: g, reason: collision with root package name */
    public int f8522g;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f8520e = new byte[65536];

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8516a = new byte[4096];

    static {
        MediaLibraryInfo.a("media3.extractor");
    }

    public DefaultExtractorInput(DataReader dataReader, long j2, long j3) {
        this.f8517b = dataReader;
        this.f8519d = j2;
        this.f8518c = j3;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final boolean b(byte[] bArr, int i2, int i3, boolean z) {
        if (!l(i3, z)) {
            return false;
        }
        System.arraycopy(this.f8520e, this.f8521f - i3, bArr, i2, i3);
        return true;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void d() {
        this.f8521f = 0;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final boolean e(byte[] bArr, int i2, int i3, boolean z) throws EOFException, InterruptedIOException {
        int iMin;
        int i4 = this.f8522g;
        if (i4 == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i4, i3);
            System.arraycopy(this.f8520e, 0, bArr, i2, iMin);
            q(iMin);
        }
        int iO = iMin;
        while (iO < i3 && iO != -1) {
            iO = o(bArr, i2, i3, iO, z);
        }
        if (iO != -1) {
            this.f8519d += iO;
        }
        return iO != -1;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void f(int i2, byte[] bArr, int i3) {
        b(bArr, i2, i3, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final long g() {
        return this.f8519d + this.f8521f;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final long getLength() {
        return this.f8518c;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final long getPosition() {
        return this.f8519d;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void h(int i2) throws EOFException, InterruptedIOException {
        l(i2, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void i(int i2) throws EOFException, InterruptedIOException {
        int iMin = Math.min(this.f8522g, i2);
        q(iMin);
        int iO = iMin;
        while (iO < i2 && iO != -1) {
            byte[] bArr = this.f8516a;
            iO = o(bArr, -iO, Math.min(i2, bArr.length + iO), iO, false);
        }
        if (iO != -1) {
            this.f8519d += iO;
        }
    }

    public final boolean l(int i2, boolean z) throws EOFException, InterruptedIOException {
        m(i2);
        int iO = this.f8522g - this.f8521f;
        while (iO < i2) {
            int i3 = i2;
            boolean z2 = z;
            iO = o(this.f8520e, this.f8521f, i3, iO, z2);
            if (iO == -1) {
                return false;
            }
            this.f8522g = this.f8521f + iO;
            i2 = i3;
            z = z2;
        }
        this.f8521f += i2;
        return true;
    }

    public final void m(int i2) {
        int i3 = this.f8521f + i2;
        byte[] bArr = this.f8520e;
        if (i3 > bArr.length) {
            this.f8520e = Arrays.copyOf(this.f8520e, Util.k(bArr.length * 2, 65536 + i3, i3 + 524288));
        }
    }

    public final int n(int i2, byte[] bArr, int i3) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput;
        int iMin;
        m(i3);
        int i4 = this.f8522g;
        int i5 = this.f8521f;
        int i6 = i4 - i5;
        if (i6 == 0) {
            defaultExtractorInput = this;
            iMin = defaultExtractorInput.o(this.f8520e, i5, i3, 0, true);
            if (iMin == -1) {
                return -1;
            }
            defaultExtractorInput.f8522g += iMin;
        } else {
            defaultExtractorInput = this;
            iMin = Math.min(i3, i6);
        }
        System.arraycopy(defaultExtractorInput.f8520e, defaultExtractorInput.f8521f, bArr, i2, iMin);
        defaultExtractorInput.f8521f += iMin;
        return iMin;
    }

    public final int o(byte[] bArr, int i2, int i3, int i4, boolean z) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i5 = this.f8517b.read(bArr, i2 + i4, i3 - i4);
        if (i5 != -1) {
            return i4 + i5;
        }
        if (i4 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    public final int p(int i2) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput;
        int iMin = Math.min(this.f8522g, i2);
        q(iMin);
        if (iMin == 0) {
            byte[] bArr = this.f8516a;
            defaultExtractorInput = this;
            iMin = defaultExtractorInput.o(bArr, 0, Math.min(i2, bArr.length), 0, true);
        } else {
            defaultExtractorInput = this;
        }
        if (iMin != -1) {
            defaultExtractorInput.f8519d += iMin;
        }
        return iMin;
    }

    public final void q(int i2) {
        int i3 = this.f8522g - i2;
        this.f8522g = i3;
        this.f8521f = 0;
        byte[] bArr = this.f8520e;
        byte[] bArr2 = i3 < bArr.length - 524288 ? new byte[65536 + i3] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        this.f8520e = bArr2;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) throws EOFException, InterruptedIOException {
        DefaultExtractorInput defaultExtractorInput;
        int i4 = this.f8522g;
        int iO = 0;
        if (i4 != 0) {
            int iMin = Math.min(i4, i3);
            System.arraycopy(this.f8520e, 0, bArr, i2, iMin);
            q(iMin);
            iO = iMin;
        }
        if (iO == 0) {
            defaultExtractorInput = this;
            iO = defaultExtractorInput.o(bArr, i2, i3, 0, true);
        } else {
            defaultExtractorInput = this;
        }
        if (iO != -1) {
            defaultExtractorInput.f8519d += iO;
        }
        return iO;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void readFully(byte[] bArr, int i2, int i3) throws EOFException, InterruptedIOException {
        e(bArr, i2, i3, false);
    }
}
