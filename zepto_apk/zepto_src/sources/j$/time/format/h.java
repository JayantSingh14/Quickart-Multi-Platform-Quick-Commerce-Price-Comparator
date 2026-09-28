package j$.time.format;

import com.tencent.mmkv.MMKV;
import org.apache.commons.lang3.time.TimeZones;

/* loaded from: classes2.dex */
public final class h implements InterfaceC0122e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f53316a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f53317b;

    public /* synthetic */ h(Object obj, int i2) {
        this.f53316a = i2;
        this.f53317b = obj;
    }

    @Override // j$.time.format.InterfaceC0122e
    public final boolean q(w wVar, StringBuilder sb) {
        switch (this.f53316a) {
            case 0:
                Long lA = wVar.a(j$.time.temporal.a.OFFSET_SECONDS);
                if (lA != null) {
                    sb.append(TimeZones.GMT_ID);
                    int intExact = Math.toIntExact(lA.longValue());
                    if (intExact != 0) {
                        int iAbs = Math.abs((intExact / MMKV.ExpireInHour) % 100);
                        int iAbs2 = Math.abs((intExact / 60) % 60);
                        int iAbs3 = Math.abs(intExact % 60);
                        sb.append(intExact < 0 ? "-" : "+");
                        if (((E) this.f53317b) == E.FULL) {
                            a(sb, iAbs);
                            sb.append(':');
                            a(sb, iAbs2);
                            if (iAbs3 != 0) {
                                sb.append(':');
                                a(sb, iAbs3);
                                break;
                            }
                        } else {
                            if (iAbs >= 10) {
                                sb.append((char) ((iAbs / 10) + 48));
                            }
                            sb.append((char) ((iAbs % 10) + 48));
                            if (iAbs2 != 0 || iAbs3 != 0) {
                                sb.append(':');
                                a(sb, iAbs2);
                                if (iAbs3 != 0) {
                                    sb.append(':');
                                    a(sb, iAbs3);
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            default:
                sb.append((String) this.f53317b);
                break;
        }
        return true;
    }

    @Override // j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        int i3;
        int iB;
        int i4;
        int i5;
        int i6;
        int i7;
        switch (this.f53316a) {
            case 0:
                int length = charSequence.length();
                if (uVar.g(charSequence, i2, TimeZones.GMT_ID, 0, 3)) {
                    int i8 = i2 + 3;
                    if (i8 == length) {
                        return uVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i2, i8);
                    }
                    char cCharAt = charSequence.charAt(i8);
                    if (cCharAt == '+') {
                        i3 = 1;
                    } else {
                        if (cCharAt != '-') {
                            return uVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i2, i8);
                        }
                        i3 = -1;
                    }
                    int i9 = i2 + 4;
                    int i10 = 0;
                    if (((E) this.f53317b) == E.FULL) {
                        int i11 = i2 + 5;
                        int iB2 = b(charSequence, i9);
                        int i12 = i2 + 6;
                        int iB3 = b(charSequence, i11);
                        if (iB2 >= 0 && iB3 >= 0) {
                            int i13 = i2 + 7;
                            if (charSequence.charAt(i12) == ':') {
                                iB = (iB2 * 10) + iB3;
                                int iB4 = b(charSequence, i13);
                                i7 = i2 + 9;
                                int iB5 = b(charSequence, i2 + 8);
                                if (iB4 >= 0 && iB5 >= 0) {
                                    i6 = (iB4 * 10) + iB5;
                                    int i14 = i2 + 11;
                                    if (i14 < length && charSequence.charAt(i7) == ':') {
                                        int iB6 = b(charSequence, i2 + 10);
                                        int iB7 = b(charSequence, i14);
                                        if (iB6 >= 0 && iB7 >= 0) {
                                            i10 = (iB6 * 10) + iB7;
                                            i7 = i2 + 12;
                                        }
                                    }
                                    i4 = i10;
                                    i5 = i7;
                                }
                            }
                        }
                    } else {
                        int i15 = i2 + 5;
                        iB = b(charSequence, i9);
                        if (iB >= 0) {
                            if (i15 < length) {
                                int iB8 = b(charSequence, i15);
                                if (iB8 >= 0) {
                                    iB = (iB * 10) + iB8;
                                    i15 = i2 + 6;
                                }
                                int i16 = i15 + 2;
                                if (i16 < length && charSequence.charAt(i15) == ':' && i16 < length && charSequence.charAt(i15) == ':') {
                                    int iB9 = b(charSequence, i15 + 1);
                                    int iB10 = b(charSequence, i16);
                                    if (iB9 >= 0 && iB10 >= 0) {
                                        i6 = (iB9 * 10) + iB10;
                                        int i17 = i15 + 3;
                                        int i18 = i15 + 5;
                                        if (i18 < length && charSequence.charAt(i17) == ':') {
                                            int iB11 = b(charSequence, i15 + 4);
                                            int iB12 = b(charSequence, i18);
                                            if (iB11 >= 0 && iB12 >= 0) {
                                                i10 = (iB11 * 10) + iB12;
                                                i7 = i15 + 6;
                                                i4 = i10;
                                                i5 = i7;
                                            }
                                        }
                                        i5 = i17;
                                        i4 = 0;
                                    }
                                }
                            }
                            i4 = 0;
                            i5 = i15;
                            return uVar.f(j$.time.temporal.a.OFFSET_SECONDS, ((i10 * 60) + (iB * 3600) + i4) * i3, i2, i5);
                        }
                    }
                    i10 = i6;
                    return uVar.f(j$.time.temporal.a.OFFSET_SECONDS, ((i10 * 60) + (iB * 3600) + i4) * i3, i2, i5);
                }
                return ~i2;
            default:
                if (i2 > charSequence.length() || i2 < 0) {
                    throw new IndexOutOfBoundsException();
                }
                String str = (String) this.f53317b;
                return !uVar.g(charSequence, i2, str, 0, str.length()) ? ~i2 : str.length() + i2;
        }
    }

    public final String toString() {
        switch (this.f53316a) {
            case 0:
                return "LocalizedOffset(" + ((E) this.f53317b) + ")";
            default:
                return "'" + ((String) this.f53317b).replace("'", "''") + "'";
        }
    }

    public static void a(StringBuilder sb, int i2) {
        sb.append((char) ((i2 / 10) + 48));
        sb.append((char) ((i2 % 10) + 48));
    }

    public static int b(CharSequence charSequence, int i2) {
        char cCharAt = charSequence.charAt(i2);
        if (cCharAt < '0' || cCharAt > '9') {
            return -1;
        }
        return cCharAt - '0';
    }
}
