package ch.qos.logback.classic.pattern;

/* loaded from: classes3.dex */
public class TargetLengthBasedClassNameAbbreviator implements Abbreviator {

    /* renamed from: a, reason: collision with root package name */
    public final int f13329a;

    public TargetLengthBasedClassNameAbbreviator(int i2) {
        this.f13329a = i2;
    }

    @Override // ch.qos.logback.classic.pattern.Abbreviator
    public final String a(String str) {
        int i2 = this.f13329a;
        StringBuilder sb = new StringBuilder(i2);
        if (str == null) {
            throw new IllegalArgumentException("Class name may not be null");
        }
        if (str.length() >= i2) {
            int[] iArr = new int[16];
            int[] iArr2 = new int[17];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int iIndexOf = str.indexOf(46, i3);
                if (iIndexOf == -1 || i4 >= 16) {
                    break;
                }
                iArr[i4] = iIndexOf;
                i4++;
                i3 = iIndexOf + 1;
            }
            if (i4 != 0) {
                int length = str.length() - i2;
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = (iArr[i5] - (i5 > 0 ? iArr[i5 - 1] : -1)) - 1;
                    int i7 = (length <= 0 || i6 < 1) ? i6 : 1;
                    length -= i6 - i7;
                    iArr2[i5] = i7 + 1;
                    i5++;
                }
                iArr2[i4] = str.length() - iArr[i4 - 1];
                for (int i8 = 0; i8 <= i4; i8++) {
                    if (i8 == 0) {
                        sb.append(str.substring(0, iArr2[i8] - 1));
                    } else {
                        int i9 = iArr[i8 - 1];
                        sb.append(str.substring(i9, iArr2[i8] + i9));
                    }
                }
                return sb.toString();
            }
        }
        return str;
    }
}
