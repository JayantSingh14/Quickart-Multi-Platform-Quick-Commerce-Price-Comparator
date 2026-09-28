package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DefaultExtractorInput;
import java.io.EOFException;

/* loaded from: classes3.dex */
final class OggPageHeader {

    /* renamed from: a, reason: collision with root package name */
    public int f9127a;

    /* renamed from: b, reason: collision with root package name */
    public long f9128b;

    /* renamed from: c, reason: collision with root package name */
    public int f9129c;

    /* renamed from: d, reason: collision with root package name */
    public int f9130d;

    /* renamed from: e, reason: collision with root package name */
    public int f9131e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f9132f = new int[255];

    /* renamed from: g, reason: collision with root package name */
    public final ParsableByteArray f9133g = new ParsableByteArray(255);

    public final boolean a(DefaultExtractorInput defaultExtractorInput, boolean z) throws ParserException, EOFException {
        boolean zB;
        boolean zB2;
        this.f9127a = 0;
        this.f9128b = 0L;
        this.f9129c = 0;
        this.f9130d = 0;
        this.f9131e = 0;
        ParsableByteArray parsableByteArray = this.f9133g;
        parsableByteArray.G(27);
        try {
            zB = defaultExtractorInput.b(parsableByteArray.f5723a, 0, 27, z);
        } catch (EOFException e2) {
            if (!z) {
                throw e2;
            }
            zB = false;
        }
        if (zB && parsableByteArray.z() == 1332176723) {
            if (parsableByteArray.x() == 0) {
                this.f9127a = parsableByteArray.x();
                this.f9128b = parsableByteArray.m();
                parsableByteArray.o();
                parsableByteArray.o();
                parsableByteArray.o();
                int iX = parsableByteArray.x();
                this.f9129c = iX;
                this.f9130d = iX + 27;
                parsableByteArray.G(iX);
                try {
                    zB2 = defaultExtractorInput.b(parsableByteArray.f5723a, 0, this.f9129c, z);
                } catch (EOFException e3) {
                    if (!z) {
                        throw e3;
                    }
                    zB2 = false;
                }
                if (zB2) {
                    for (int i2 = 0; i2 < this.f9129c; i2++) {
                        int iX2 = parsableByteArray.x();
                        this.f9132f[i2] = iX2;
                        this.f9131e += iX2;
                    }
                    return true;
                }
            } else if (!z) {
                throw ParserException.c("unsupported bit stream revision");
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        if (r11 == (-1)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        if (r10.f8519d >= r11) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        if (r10.p(1) == (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(androidx.media3.extractor.DefaultExtractorInput r10, long r11) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r9 = this;
            long r0 = r10.f8519d
            long r2 = r10.g()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Le
            r0 = r2
            goto Lf
        Le:
            r0 = r1
        Lf:
            androidx.media3.common.util.Assertions.a(r0)
            androidx.media3.common.util.ParsableByteArray r0 = r9.f9133g
            r3 = 4
            r0.G(r3)
        L18:
            r4 = -1
            int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r4 == 0) goto L27
            long r5 = r10.f8519d
            r7 = 4
            long r5 = r5 + r7
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 >= 0) goto L46
        L27:
            byte[] r5 = r0.f5723a
            boolean r5 = r10.b(r5, r1, r3, r2)     // Catch: java.io.EOFException -> L2e
            goto L2f
        L2e:
            r5 = r1
        L2f:
            if (r5 == 0) goto L46
            r0.J(r1)
            long r4 = r0.z()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L42
            r10.f8521f = r1
            return r2
        L42:
            r10.i(r2)
            goto L18
        L46:
            if (r4 == 0) goto L4e
            long r5 = r10.f8519d
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 >= 0) goto L56
        L4e:
            int r0 = r10.p(r2)
            r3 = -1
            if (r0 == r3) goto L56
            goto L46
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ogg.OggPageHeader.b(androidx.media3.extractor.DefaultExtractorInput, long):boolean");
    }
}
