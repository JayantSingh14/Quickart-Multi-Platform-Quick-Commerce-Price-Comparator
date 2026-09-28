package com.facebook.hermes.intl;

/* loaded from: classes3.dex */
class LocaleIdTokenizer {

    /* renamed from: a, reason: collision with root package name */
    public String f17606a;

    /* renamed from: b, reason: collision with root package name */
    public int f17607b;

    /* renamed from: c, reason: collision with root package name */
    public int f17608c;

    public class LocaleIdSubtag {

        /* renamed from: a, reason: collision with root package name */
        public String f17609a;

        /* renamed from: b, reason: collision with root package name */
        public int f17610b;

        /* renamed from: c, reason: collision with root package name */
        public int f17611c;

        public final boolean a() {
            char cCharAt;
            int i2 = this.f17610b;
            int i3 = i2 + 1;
            int i4 = this.f17611c;
            if (i4 != i3) {
                return false;
            }
            String str = this.f17609a;
            return IntlTextUtils.a(str.charAt(i2)) && (cCharAt = str.charAt(i4)) >= '0' && cCharAt <= '9';
        }

        public final boolean b() {
            int i2 = this.f17610b;
            int i3 = i2 + 1;
            int i4 = this.f17611c;
            if (i4 != i3) {
                return false;
            }
            String str = this.f17609a;
            char cCharAt = str.charAt(i2);
            return (IntlTextUtils.a(cCharAt) || (cCharAt >= '0' && cCharAt <= '9')) && IntlTextUtils.a(str.charAt(i4));
        }

        public final boolean c() {
            String str = this.f17609a;
            int i2 = this.f17610b;
            int i3 = this.f17611c;
            return IntlTextUtils.b(i2, i3, 2, 3, str) || IntlTextUtils.b(i2, i3, 5, 8, str) || ((i3 - i2) + 1 == 4 && str.charAt(i2) == 'r' && str.charAt(i2 + 1) == 'o' && str.charAt(i2 + 2) == 'o' && str.charAt(i2 + 3) == 't');
        }

        public final String toString() {
            return this.f17609a.subSequence(this.f17610b, this.f17611c + 1).toString();
        }
    }

    public class LocaleIdSubtagIterationFailed extends Exception {
    }

    public final boolean a() {
        String str = this.f17606a;
        return str.length() > 0 && this.f17608c < str.length() - 1;
    }

    public final LocaleIdSubtag b() throws LocaleIdSubtagIterationFailed {
        if (!a()) {
            throw new LocaleIdSubtagIterationFailed();
        }
        int i2 = this.f17608c;
        int i3 = this.f17607b;
        String str = this.f17606a;
        if (i2 >= i3) {
            if (str.charAt(i2 + 1) != '-') {
                throw new LocaleIdSubtagIterationFailed();
            }
            if (this.f17608c + 2 == str.length()) {
                throw new LocaleIdSubtagIterationFailed();
            }
            this.f17607b = this.f17608c + 2;
        }
        this.f17608c = this.f17607b;
        while (this.f17608c < str.length() && str.charAt(this.f17608c) != '-') {
            this.f17608c++;
        }
        int i4 = this.f17608c;
        int i5 = this.f17607b;
        if (i4 <= i5) {
            throw new LocaleIdSubtagIterationFailed();
        }
        int i6 = i4 - 1;
        this.f17608c = i6;
        LocaleIdSubtag localeIdSubtag = new LocaleIdSubtag();
        localeIdSubtag.f17609a = str;
        localeIdSubtag.f17610b = i5;
        localeIdSubtag.f17611c = i6;
        return localeIdSubtag;
    }
}
