package j$.time.format;

import java.text.ParsePosition;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public String f53333a;

    /* renamed from: b, reason: collision with root package name */
    public String f53334b;

    /* renamed from: c, reason: collision with root package name */
    public final char f53335c;

    /* renamed from: d, reason: collision with root package name */
    public m f53336d;

    /* renamed from: e, reason: collision with root package name */
    public m f53337e;

    public boolean b(char c2, char c3) {
        return c2 == c3;
    }

    public m(String str, String str2, m mVar) {
        this.f53333a = str;
        this.f53334b = str2;
        this.f53336d = mVar;
        if (str.isEmpty()) {
            this.f53335c = (char) 65535;
        } else {
            this.f53335c = this.f53333a.charAt(0);
        }
    }

    public final String c(CharSequence charSequence, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int length = charSequence.length();
        if (!e(charSequence, index, length)) {
            return null;
        }
        int length2 = this.f53333a.length() + index;
        m mVar = this.f53336d;
        if (mVar != null && length2 != length) {
            while (true) {
                if (b(mVar.f53335c, charSequence.charAt(length2))) {
                    parsePosition.setIndex(length2);
                    String strC = mVar.c(charSequence, parsePosition);
                    if (strC != null) {
                        return strC;
                    }
                } else {
                    mVar = mVar.f53337e;
                    if (mVar == null) {
                        break;
                    }
                }
            }
        }
        parsePosition.setIndex(length2);
        return this.f53334b;
    }

    public m d(String str, String str2, m mVar) {
        return new m(str, str2, mVar);
    }

    public boolean e(CharSequence charSequence, int i2, int i3) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f53333a, i2);
        }
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
            if (!b(this.f53333a.charAt(i4), charSequence.charAt(i2))) {
                return false;
            }
            i2 = i7;
            length = i5;
            i4 = i6;
        }
    }

    public final boolean a(String str, String str2) {
        int i2 = 0;
        while (i2 < str.length() && i2 < this.f53333a.length() && b(str.charAt(i2), this.f53333a.charAt(i2))) {
            i2++;
        }
        if (i2 == this.f53333a.length()) {
            if (i2 < str.length()) {
                String strSubstring = str.substring(i2);
                for (m mVar = this.f53336d; mVar != null; mVar = mVar.f53337e) {
                    if (b(mVar.f53335c, strSubstring.charAt(0))) {
                        return mVar.a(strSubstring, str2);
                    }
                }
                m mVarD = d(strSubstring, str2, null);
                mVarD.f53337e = this.f53336d;
                this.f53336d = mVarD;
                return true;
            }
            this.f53334b = str2;
            return true;
        }
        m mVarD2 = d(this.f53333a.substring(i2), this.f53334b, this.f53336d);
        this.f53333a = str.substring(0, i2);
        this.f53336d = mVarD2;
        if (i2 < str.length()) {
            this.f53336d.f53337e = d(str.substring(i2), str2, null);
            this.f53334b = null;
            return true;
        }
        this.f53334b = str2;
        return true;
    }
}
