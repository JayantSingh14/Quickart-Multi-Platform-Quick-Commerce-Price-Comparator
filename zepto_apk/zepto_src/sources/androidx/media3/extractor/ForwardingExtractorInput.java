package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import java.io.EOFException;
import java.io.InterruptedIOException;

@UnstableApi
/* loaded from: classes3.dex */
public class ForwardingExtractorInput implements ExtractorInput {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultExtractorInput f8565a;

    public ForwardingExtractorInput(DefaultExtractorInput defaultExtractorInput) {
        this.f8565a = defaultExtractorInput;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final boolean b(byte[] bArr, int i2, int i3, boolean z) {
        return this.f8565a.b(bArr, i2, i3, z);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void d() {
        this.f8565a.f8521f = 0;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final boolean e(byte[] bArr, int i2, int i3, boolean z) {
        return this.f8565a.e(bArr, 0, i3, z);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void f(int i2, byte[] bArr, int i3) {
        this.f8565a.b(bArr, i2, i3, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long g() {
        return this.f8565a.g();
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long getLength() {
        return this.f8565a.f8518c;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long getPosition() {
        return this.f8565a.f8519d;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void h(int i2) throws EOFException, InterruptedIOException {
        this.f8565a.l(i2, false);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void i(int i2) throws EOFException, InterruptedIOException {
        this.f8565a.i(i2);
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        return this.f8565a.read(bArr, i2, i3);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public final void readFully(byte[] bArr, int i2, int i3) throws EOFException, InterruptedIOException {
        this.f8565a.e(bArr, i2, i3, false);
    }
}
