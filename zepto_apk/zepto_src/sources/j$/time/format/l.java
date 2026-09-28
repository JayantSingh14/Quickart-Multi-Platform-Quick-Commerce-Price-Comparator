package j$.time.format;

/* loaded from: classes2.dex */
public final class l extends m {
    @Override // j$.time.format.m
    public final m d(String str, String str2, m mVar) {
        return new l(str, str2, mVar);
    }

    @Override // j$.time.format.m
    public final boolean b(char c2, char c3) {
        return u.b(c2, c3);
    }

    @Override // j$.time.format.m
    public final boolean e(CharSequence charSequence, int i2, int i3) {
        int length = this.f53333a.length();
        if (length > i3 - i2) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i6 = i4 + 1;
            int i7 = i2 + 1;
            if (!u.b(this.f53333a.charAt(i4), charSequence.charAt(i2))) {
                return false;
            }
            i2 = i7;
            length = i5;
            i4 = i6;
        }
    }
}
