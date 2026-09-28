package j$.time.format;

/* renamed from: j$.time.format.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0120c implements InterfaceC0122e {

    /* renamed from: a, reason: collision with root package name */
    public final char f53312a;

    public C0120c(char c2) {
        this.f53312a = c2;
    }

    @Override // j$.time.format.InterfaceC0122e
    public final boolean q(w wVar, StringBuilder sb) {
        sb.append(this.f53312a);
        return true;
    }

    @Override // j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        if (i2 == charSequence.length()) {
            return ~i2;
        }
        char cCharAt = charSequence.charAt(i2);
        char c2 = this.f53312a;
        return (cCharAt == c2 || (!uVar.f53362b && (Character.toUpperCase(cCharAt) == Character.toUpperCase(c2) || Character.toLowerCase(cCharAt) == Character.toLowerCase(c2)))) ? i2 + 1 : ~i2;
    }

    public final String toString() {
        char c2 = this.f53312a;
        if (c2 == '\'') {
            return "''";
        }
        return "'" + c2 + "'";
    }
}
