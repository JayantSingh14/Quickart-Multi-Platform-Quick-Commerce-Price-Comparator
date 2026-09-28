package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@SuppressAnimalSniffer
/* loaded from: classes3.dex */
public final class ComposerForUnsignedNumbers extends Composer {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f56036c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(JsonToStringWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.f56036c = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void d(byte b2) {
        if (this.f56036c) {
            UByte.Companion companion = UByte.f53551b;
            j(String.valueOf(b2 & 255));
        } else {
            UByte.Companion companion2 = UByte.f53551b;
            h(String.valueOf(b2 & 255));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void f(int i2) {
        if (this.f56036c) {
            UInt.Companion companion = UInt.f53556b;
            j(Long.toString(4294967295L & i2, 10));
        } else {
            UInt.Companion companion2 = UInt.f53556b;
            h(Long.toString(4294967295L & i2, 10));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void g(long j2) {
        int i2 = 63;
        String str = "0";
        if (this.f56036c) {
            ULong.Companion companion = ULong.f53561b;
            if (j2 != 0) {
                if (j2 > 0) {
                    str = Long.toString(j2, 10);
                } else {
                    char[] cArr = new char[64];
                    long j3 = (j2 >>> 1) / 5;
                    long j4 = 10;
                    cArr[63] = Character.forDigit((int) (j2 - (j3 * j4)), 10);
                    while (j3 > 0) {
                        i2--;
                        cArr[i2] = Character.forDigit((int) (j3 % j4), 10);
                        j3 /= j4;
                    }
                    str = new String(cArr, i2, 64 - i2);
                }
            }
            j(str);
            return;
        }
        ULong.Companion companion2 = ULong.f53561b;
        if (j2 != 0) {
            if (j2 > 0) {
                str = Long.toString(j2, 10);
            } else {
                char[] cArr2 = new char[64];
                long j5 = (j2 >>> 1) / 5;
                long j6 = 10;
                cArr2[63] = Character.forDigit((int) (j2 - (j5 * j6)), 10);
                while (j5 > 0) {
                    i2--;
                    cArr2[i2] = Character.forDigit((int) (j5 % j6), 10);
                    j5 /= j6;
                }
                str = new String(cArr2, i2, 64 - i2);
            }
        }
        h(str);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void i(short s) {
        if (this.f56036c) {
            UShort.Companion companion = UShort.f53567b;
            j(String.valueOf(s & 65535));
        } else {
            UShort.Companion companion2 = UShort.f53567b;
            h(String.valueOf(s & 65535));
        }
    }
}
