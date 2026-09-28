package androidx.media3.extractor.ts;

import androidx.media3.common.util.Assertions;
import java.util.Arrays;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
final class NalUnitTargetBuffer {

    /* renamed from: a, reason: collision with root package name */
    public final int f9716a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9717b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9718c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f9719d;

    /* renamed from: e, reason: collision with root package name */
    public int f9720e;

    public NalUnitTargetBuffer(int i2) {
        this.f9716a = i2;
        byte[] bArr = new byte[WKSRecord.Service.CISCO_TNA];
        this.f9719d = bArr;
        bArr[2] = 1;
    }

    public final void a(int i2, byte[] bArr, int i3) {
        if (this.f9717b) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f9719d;
            int length = bArr2.length;
            int i5 = this.f9720e;
            if (length < i5 + i4) {
                this.f9719d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f9719d, this.f9720e, i4);
            this.f9720e += i4;
        }
    }

    public final boolean b(int i2) {
        if (!this.f9717b) {
            return false;
        }
        this.f9720e -= i2;
        this.f9717b = false;
        this.f9718c = true;
        return true;
    }

    public final void c() {
        this.f9717b = false;
        this.f9718c = false;
    }

    public final void d(int i2) {
        Assertions.g(!this.f9717b);
        boolean z = i2 == this.f9716a;
        this.f9717b = z;
        if (z) {
            this.f9720e = 3;
            this.f9718c = false;
        }
    }
}
