package j$.time.format;

import j$.time.DayOfWeek;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class r extends i {

    /* renamed from: g, reason: collision with root package name */
    public final char f53350g;

    /* renamed from: h, reason: collision with root package name */
    public final int f53351h;

    @Override // j$.time.format.i, j$.time.format.InterfaceC0122e
    public final boolean q(w wVar, StringBuilder sb) {
        return f(wVar.f53371b.f53287b).q(wVar, sb);
    }

    @Override // j$.time.format.i, j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        return f(uVar.f53361a.f53287b).s(uVar, charSequence, i2);
    }

    public r(char c2, int i2, int i3, int i4, int i5) {
        super(null, i3, i4, D.NOT_NEGATIVE, i5);
        this.f53350g = c2;
        this.f53351h = i2;
    }

    @Override // j$.time.format.i
    public final i d() {
        if (this.f53323e == -1) {
            return this;
        }
        return new r(this.f53350g, this.f53351h, this.f53320b, this.f53321c, -1);
    }

    @Override // j$.time.format.i
    public final i e(int i2) {
        int i3 = this.f53323e + i2;
        return new r(this.f53350g, this.f53351h, this.f53320b, this.f53321c, i3);
    }

    public final i f(Locale locale) {
        j$.time.temporal.r rVar;
        ConcurrentHashMap concurrentHashMap = j$.time.temporal.s.f53448g;
        Objects.requireNonNull(locale, "locale");
        j$.time.temporal.s sVarA = j$.time.temporal.s.a(DayOfWeek.f53173a[((((int) ((r7.getFirstDayOfWeek() - 1) % 7)) + 7) + DayOfWeek.SUNDAY.ordinal()) % 7], Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
        char c2 = this.f53350g;
        if (c2 == 'W') {
            rVar = sVarA.f53453d;
        } else {
            if (c2 == 'Y') {
                j$.time.temporal.r rVar2 = sVarA.f53455f;
                int i2 = this.f53351h;
                if (i2 == 2) {
                    return new o(rVar2, 2, 2, o.f53343h, this.f53323e);
                }
                return new i(rVar2, i2, 19, i2 < 4 ? D.NORMAL : D.EXCEEDS_PAD, this.f53323e);
            }
            if (c2 == 'c' || c2 == 'e') {
                rVar = sVarA.f53452c;
            } else {
                if (c2 != 'w') {
                    throw new IllegalStateException("unreachable");
                }
                rVar = sVarA.f53454e;
            }
        }
        return new i(rVar, this.f53320b, this.f53321c, D.NOT_NEGATIVE, this.f53323e);
    }

    @Override // j$.time.format.i
    public final String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("Localized(");
        int i2 = this.f53351h;
        char c2 = this.f53350g;
        if (c2 != 'Y') {
            if (c2 == 'W') {
                sb.append("WeekOfMonth");
            } else if (c2 == 'c' || c2 == 'e') {
                sb.append("DayOfWeek");
            } else if (c2 == 'w') {
                sb.append("WeekOfWeekBasedYear");
            }
            sb.append(",");
            sb.append(i2);
        } else if (i2 == 1) {
            sb.append("WeekBasedYear");
        } else if (i2 == 2) {
            sb.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
        } else {
            sb.append("WeekBasedYear,");
            sb.append(i2);
            sb.append(",19,");
            sb.append(i2 < 4 ? D.NORMAL : D.EXCEEDS_PAD);
        }
        sb.append(")");
        return sb.toString();
    }
}
