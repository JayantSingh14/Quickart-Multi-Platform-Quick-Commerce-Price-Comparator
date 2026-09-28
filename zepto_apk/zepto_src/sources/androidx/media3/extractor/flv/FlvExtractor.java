package androidx.media3.extractor.flv;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import java.io.EOFException;
import java.io.InterruptedIOException;
import org.xbill.DNS.Type;

@UnstableApi
/* loaded from: classes3.dex */
public final class FlvExtractor implements Extractor {

    /* renamed from: f, reason: collision with root package name */
    public ExtractorOutput f8721f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8723h;

    /* renamed from: i, reason: collision with root package name */
    public long f8724i;

    /* renamed from: j, reason: collision with root package name */
    public int f8725j;

    /* renamed from: k, reason: collision with root package name */
    public int f8726k;

    /* renamed from: l, reason: collision with root package name */
    public int f8727l;

    /* renamed from: m, reason: collision with root package name */
    public long f8728m;
    public boolean n;
    public AudioTagPayloadReader o;
    public VideoTagPayloadReader p;

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f8716a = new ParsableByteArray(4);

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f8717b = new ParsableByteArray(9);

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f8718c = new ParsableByteArray(11);

    /* renamed from: d, reason: collision with root package name */
    public final ParsableByteArray f8719d = new ParsableByteArray();

    /* renamed from: e, reason: collision with root package name */
    public final ScriptTagPayloadReader f8720e = new ScriptTagPayloadReader();

    /* renamed from: g, reason: collision with root package name */
    public int f8722g = 1;

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        if (j2 == 0) {
            this.f8722g = 1;
            this.f8723h = false;
        } else {
            this.f8722g = 3;
        }
        this.f8725j = 0;
    }

    public final ParsableByteArray b(DefaultExtractorInput defaultExtractorInput) throws EOFException, InterruptedIOException {
        int i2 = this.f8727l;
        ParsableByteArray parsableByteArray = this.f8719d;
        byte[] bArr = parsableByteArray.f5723a;
        if (i2 > bArr.length) {
            parsableByteArray.H(0, new byte[Math.max(bArr.length * 2, i2)]);
        } else {
            parsableByteArray.J(0);
        }
        parsableByteArray.I(this.f8727l);
        defaultExtractorInput.e(parsableByteArray.f5723a, 0, this.f8727l, false);
        return parsableByteArray;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8721f = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) throws EOFException, InterruptedIOException {
        ParsableByteArray parsableByteArray = this.f8716a;
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        defaultExtractorInput.b(parsableByteArray.f5723a, 0, 3, false);
        parsableByteArray.J(0);
        if (parsableByteArray.A() == 4607062) {
            defaultExtractorInput.b(parsableByteArray.f5723a, 0, 2, false);
            parsableByteArray.J(0);
            if ((parsableByteArray.D() & Type.TSIG) == 0) {
                defaultExtractorInput.b(parsableByteArray.f5723a, 0, 4, false);
                parsableByteArray.J(0);
                int iJ = parsableByteArray.j();
                defaultExtractorInput.f8521f = 0;
                defaultExtractorInput.l(iJ, false);
                defaultExtractorInput.b(parsableByteArray.f5723a, 0, 4, false);
                parsableByteArray.J(0);
                if (parsableByteArray.j() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x038c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0007 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0269  */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r29, androidx.media3.extractor.PositionHolder r30) throws androidx.media3.common.ParserException, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 1084
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.flv.FlvExtractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
