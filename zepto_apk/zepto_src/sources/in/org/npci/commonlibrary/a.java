package in.org.npci.commonlibrary;

import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f49165a = true;

    /* renamed from: in.org.npci.commonlibrary.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0061a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f49166a;

        /* renamed from: b, reason: collision with root package name */
        public int f49167b;
    }

    public static class b extends AbstractC0061a {

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f49168c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d, reason: collision with root package name */
        private static final int[] f49169d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e, reason: collision with root package name */
        private int f49170e;

        /* renamed from: f, reason: collision with root package name */
        private int f49171f;

        /* renamed from: g, reason: collision with root package name */
        private final int[] f49172g;

        public b(int i2, byte[] bArr) {
            this.f49166a = bArr;
            this.f49172g = (i2 & 8) == 0 ? f49168c : f49169d;
            this.f49170e = 0;
            this.f49171f = 0;
        }

        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            int i4 = this.f49170e;
            if (i4 == 6) {
                return false;
            }
            int i5 = i3 + i2;
            int i6 = this.f49171f;
            byte[] bArr2 = this.f49166a;
            int[] iArr = this.f49172g;
            int i7 = 0;
            int i8 = i6;
            int i9 = i4;
            int i10 = i2;
            while (i10 < i5) {
                if (i9 == 0) {
                    while (true) {
                        int i11 = i10 + 4;
                        if (i11 > i5 || (i8 = (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10 + 2] & 255] << 6) | iArr[bArr[i10 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i8;
                        bArr2[i7 + 1] = (byte) (i8 >> 8);
                        bArr2[i7] = (byte) (i8 >> 16);
                        i7 += 3;
                        i10 = i11;
                    }
                    if (i10 >= i5) {
                        break;
                    }
                }
                int i12 = i10 + 1;
                int i13 = iArr[bArr[i10] & 255];
                if (i9 != 0) {
                    if (i9 == 1) {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.f49170e = 6;
                                return false;
                            }
                        }
                        i13 |= i8 << 6;
                    } else if (i9 == 2) {
                        if (i13 < 0) {
                            if (i13 == -2) {
                                bArr2[i7] = (byte) (i8 >> 4);
                                i7++;
                                i9 = 4;
                            } else if (i13 != -1) {
                                this.f49170e = 6;
                                return false;
                            }
                        }
                        i13 |= i8 << 6;
                    } else if (i9 != 3) {
                        if (i9 != 4) {
                            if (i9 == 5 && i13 != -1) {
                                this.f49170e = 6;
                                return false;
                            }
                        } else if (i13 == -2) {
                            i9++;
                        } else if (i13 != -1) {
                            this.f49170e = 6;
                            return false;
                        }
                    } else if (i13 >= 0) {
                        int i14 = i13 | (i8 << 6);
                        bArr2[i7 + 2] = (byte) i14;
                        bArr2[i7 + 1] = (byte) (i14 >> 8);
                        bArr2[i7] = (byte) (i14 >> 16);
                        i7 += 3;
                        i8 = i14;
                        i9 = 0;
                    } else if (i13 == -2) {
                        bArr2[i7 + 1] = (byte) (i8 >> 2);
                        bArr2[i7] = (byte) (i8 >> 10);
                        i7 += 2;
                        i9 = 5;
                    } else if (i13 != -1) {
                        this.f49170e = 6;
                        return false;
                    }
                    i9++;
                    i8 = i13;
                } else if (i13 >= 0) {
                    i9++;
                    i8 = i13;
                } else if (i13 != -1) {
                    this.f49170e = 6;
                    return false;
                }
                i10 = i12;
            }
            if (!z) {
                this.f49170e = i9;
                this.f49171f = i8;
            } else {
                if (i9 == 1) {
                    this.f49170e = 6;
                    return false;
                }
                if (i9 == 2) {
                    bArr2[i7] = (byte) (i8 >> 4);
                    i7++;
                } else if (i9 == 3) {
                    int i15 = i7 + 1;
                    bArr2[i7] = (byte) (i8 >> 10);
                    i7 += 2;
                    bArr2[i15] = (byte) (i8 >> 2);
                } else if (i9 == 4) {
                    this.f49170e = 6;
                    return false;
                }
                this.f49170e = i9;
            }
            this.f49167b = i7;
            return true;
        }
    }

    public static class c extends AbstractC0061a {

        /* renamed from: g, reason: collision with root package name */
        static final /* synthetic */ boolean f49174g = true;

        /* renamed from: h, reason: collision with root package name */
        private static final byte[] f49175h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: i, reason: collision with root package name */
        private static final byte[] f49176i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: c, reason: collision with root package name */
        int f49177c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f49178d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f49179e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f49180f;

        /* renamed from: j, reason: collision with root package name */
        private final byte[] f49181j;

        /* renamed from: k, reason: collision with root package name */
        private int f49182k;

        /* renamed from: l, reason: collision with root package name */
        private final byte[] f49183l;

        public c(int i2, byte[] bArr) {
            this.f49166a = bArr;
            this.f49178d = (i2 & 1) == 0;
            boolean z = (i2 & 2) == 0;
            this.f49179e = z;
            this.f49180f = (i2 & 4) != 0;
            this.f49183l = (i2 & 8) == 0 ? f49175h : f49176i;
            this.f49181j = new byte[2];
            this.f49177c = 0;
            this.f49182k = z ? 19 : -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01c6  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01d3 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 523
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: in.org.npci.commonlibrary.a.c.a(byte[], int, int, boolean):boolean");
        }
    }

    private a() {
    }

    public static String a(String str) {
        return str.replace("+", "-").replace("/", Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
    }

    public static String b(byte[] bArr, int i2) {
        try {
            return new String(c(bArr, i2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static byte[] c(byte[] bArr, int i2) {
        return b(bArr, 0, bArr.length, i2);
    }

    public static byte[] a(String str, int i2) {
        return a(str.getBytes(), i2);
    }

    public static byte[] b(byte[] bArr, int i2, int i3, int i4) {
        c cVar = new c(i4, null);
        int i5 = (i3 / 3) * 4;
        if (!cVar.f49178d) {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        } else if (i3 % 3 > 0) {
            i5 += 4;
        }
        if (cVar.f49179e && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (cVar.f49180f ? 2 : 1);
        }
        cVar.f49166a = new byte[i5];
        cVar.a(bArr, i2, i3, true);
        if (f49165a || cVar.f49167b == i5) {
            return cVar.f49166a;
        }
        throw new AssertionError();
    }

    public static byte[] a(byte[] bArr, int i2) {
        return a(bArr, 0, bArr.length, i2);
    }

    public static byte[] a(byte[] bArr, int i2, int i3, int i4) {
        b bVar = new b(i4, new byte[(i3 * 3) / 4]);
        if (!bVar.a(bArr, i2, i3, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i5 = bVar.f49167b;
        byte[] bArr2 = bVar.f49166a;
        if (i5 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr3, 0, i5);
        return bArr3;
    }
}
