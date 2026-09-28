package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;
import java.util.Random;

@UnstableApi
/* loaded from: classes3.dex */
public interface ShuffleOrder {

    public static class DefaultShuffleOrder implements ShuffleOrder {

        /* renamed from: a, reason: collision with root package name */
        public final Random f7710a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f7711b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f7712c;

        public DefaultShuffleOrder() {
            this(new Random());
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final ShuffleOrder a(int i2, int i3) {
            int i4 = i3 - i2;
            int[] iArr = this.f7711b;
            int[] iArr2 = new int[iArr.length - i4];
            int i5 = 0;
            for (int i6 = 0; i6 < iArr.length; i6++) {
                int i7 = iArr[i6];
                if (i7 < i2 || i7 >= i3) {
                    int i8 = i6 - i5;
                    if (i7 >= i2) {
                        i7 -= i4;
                    }
                    iArr2[i8] = i7;
                } else {
                    i5++;
                }
            }
            return new DefaultShuffleOrder(iArr2, new Random(this.f7710a.nextLong()));
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int b(int i2) {
            int i3 = this.f7712c[i2] - 1;
            if (i3 >= 0) {
                return this.f7711b[i3];
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int c(int i2) {
            int i3 = this.f7712c[i2] + 1;
            int[] iArr = this.f7711b;
            if (i3 < iArr.length) {
                return iArr[i3];
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int d() {
            int[] iArr = this.f7711b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final ShuffleOrder e() {
            return new DefaultShuffleOrder(new Random(this.f7710a.nextLong()));
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int f() {
            int[] iArr = this.f7711b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final ShuffleOrder g(int i2, int i3) {
            int[] iArr;
            Random random;
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            int i4 = 0;
            while (true) {
                iArr = this.f7711b;
                random = this.f7710a;
                if (i4 >= i3) {
                    break;
                }
                iArr2[i4] = random.nextInt(iArr.length + 1);
                int i5 = i4 + 1;
                int iNextInt = random.nextInt(i5);
                iArr3[i4] = iArr3[iNextInt];
                iArr3[iNextInt] = i4 + i2;
                i4 = i5;
            }
            Arrays.sort(iArr2);
            int[] iArr4 = new int[iArr.length + i3];
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < iArr.length + i3; i8++) {
                if (i6 >= i3 || i7 != iArr2[i6]) {
                    int i9 = i7 + 1;
                    int i10 = iArr[i7];
                    iArr4[i8] = i10;
                    if (i10 >= i2) {
                        iArr4[i8] = i10 + i3;
                    }
                    i7 = i9;
                } else {
                    iArr4[i8] = iArr3[i6];
                    i6++;
                }
            }
            return new DefaultShuffleOrder(iArr4, new Random(random.nextLong()));
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int getLength() {
            return this.f7711b.length;
        }

        public DefaultShuffleOrder(int[] iArr, Random random) {
            this.f7711b = iArr;
            this.f7710a = random;
            this.f7712c = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.f7712c[iArr[i2]] = i2;
            }
        }

        public DefaultShuffleOrder(Random random) {
            this(new int[0], random);
        }
    }

    public static final class UnshuffledShuffleOrder implements ShuffleOrder {

        /* renamed from: a, reason: collision with root package name */
        public final int f7713a;

        public UnshuffledShuffleOrder(int i2) {
            this.f7713a = i2;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final ShuffleOrder a(int i2, int i3) {
            return new UnshuffledShuffleOrder((this.f7713a - i3) + i2);
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int b(int i2) {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                return i3;
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int c(int i2) {
            int i3 = i2 + 1;
            if (i3 < this.f7713a) {
                return i3;
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int d() {
            int i2 = this.f7713a;
            if (i2 > 0) {
                return i2 - 1;
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final ShuffleOrder e() {
            return new UnshuffledShuffleOrder(0);
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int f() {
            return this.f7713a > 0 ? 0 : -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final ShuffleOrder g(int i2, int i3) {
            return new UnshuffledShuffleOrder(this.f7713a + i3);
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public final int getLength() {
            return this.f7713a;
        }
    }

    ShuffleOrder a(int i2, int i3);

    int b(int i2);

    int c(int i2);

    int d();

    ShuffleOrder e();

    int f();

    ShuffleOrder g(int i2, int i3);

    int getLength();
}
