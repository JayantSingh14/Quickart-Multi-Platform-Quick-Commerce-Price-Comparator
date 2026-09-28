package j$.time.format;

import j$.time.DateTimeException;

/* loaded from: classes2.dex */
public final class k implements InterfaceC0122e {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0122e f53330a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53331b;

    /* renamed from: c, reason: collision with root package name */
    public final char f53332c;

    @Override // j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        boolean z = uVar.f53363c;
        if (i2 > charSequence.length()) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == charSequence.length()) {
            return ~i2;
        }
        int length = this.f53331b + i2;
        if (length > charSequence.length()) {
            if (z) {
                return ~i2;
            }
            length = charSequence.length();
        }
        int i3 = i2;
        while (i3 < length && uVar.a(charSequence.charAt(i3), this.f53332c)) {
            i3++;
        }
        int iS = this.f53330a.s(uVar, charSequence.subSequence(0, length), i3);
        return (iS == length || !z) ? iS : ~(i2 + i3);
    }

    public k(InterfaceC0122e interfaceC0122e, int i2, char c2) {
        this.f53330a = interfaceC0122e;
        this.f53331b = i2;
        this.f53332c = c2;
    }

    @Override // j$.time.format.InterfaceC0122e
    public final boolean q(w wVar, StringBuilder sb) {
        int length = sb.length();
        if (!this.f53330a.q(wVar, sb)) {
            return false;
        }
        int length2 = sb.length() - length;
        int i2 = this.f53331b;
        if (length2 <= i2) {
            for (int i3 = 0; i3 < i2 - length2; i3++) {
                sb.insert(length, this.f53332c);
            }
            return true;
        }
        throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + i2);
    }

    public final String toString() {
        String str;
        char c2 = this.f53332c;
        if (c2 == ' ') {
            str = ")";
        } else {
            str = ",'" + c2 + "')";
        }
        return "Pad(" + this.f53330a + "," + this.f53331b + str;
    }
}
