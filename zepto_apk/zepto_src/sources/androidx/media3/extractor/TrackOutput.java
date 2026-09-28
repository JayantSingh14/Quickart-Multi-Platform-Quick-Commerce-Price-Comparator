package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public interface TrackOutput {

    public static final class CryptoData {

        /* renamed from: a, reason: collision with root package name */
        public final int f8614a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f8615b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8616c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8617d;

        public CryptoData(int i2, int i3, byte[] bArr, int i4) {
            this.f8614a = i2;
            this.f8615b = bArr;
            this.f8616c = i3;
            this.f8617d = i4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && CryptoData.class == obj.getClass()) {
                CryptoData cryptoData = (CryptoData) obj;
                if (this.f8614a == cryptoData.f8614a && this.f8616c == cryptoData.f8616c && this.f8617d == cryptoData.f8617d && Arrays.equals(this.f8615b, cryptoData.f8615b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ((((Arrays.hashCode(this.f8615b) + (this.f8614a * 31)) * 31) + this.f8616c) * 31) + this.f8617d;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SampleDataPart {
    }

    void a(ParsableByteArray parsableByteArray, int i2, int i3);

    void b(Format format);

    default int c(DataReader dataReader, int i2, boolean z) {
        return d(dataReader, i2, z);
    }

    int d(DataReader dataReader, int i2, boolean z);

    default void e(int i2, ParsableByteArray parsableByteArray) {
        a(parsableByteArray, i2, 0);
    }

    void f(long j2, int i2, int i3, int i4, CryptoData cryptoData);
}
