package org.shadow.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.shadow.apache.commons.lang3.StringUtils;
import org.shadow.apache.commons.lang3.text.StrMatcher;

/* loaded from: classes5.dex */
public class StrTokenizer implements ListIterator<String>, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public char[] f57777a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f57778b;

    /* renamed from: c, reason: collision with root package name */
    public int f57779c;

    /* renamed from: d, reason: collision with root package name */
    public StrMatcher f57780d = StrMatcher.f57768c;

    /* renamed from: e, reason: collision with root package name */
    public StrMatcher f57781e;

    /* renamed from: f, reason: collision with root package name */
    public StrMatcher f57782f;

    /* renamed from: g, reason: collision with root package name */
    public StrMatcher f57783g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f57784h;

    static {
        StrTokenizer strTokenizer = new StrTokenizer();
        strTokenizer.f57780d = StrMatcher.f57766a;
        StrMatcher strMatcher = StrMatcher.f57770e;
        if (strMatcher != null) {
            strTokenizer.f57781e = strMatcher;
        }
        StrMatcher strMatcher2 = StrMatcher.f57771f;
        if (strMatcher2 != null) {
            strTokenizer.f57782f = strMatcher2;
        }
        StrMatcher strMatcher3 = StrMatcher.f57769d;
        if (strMatcher3 != null) {
            strTokenizer.f57783g = strMatcher3;
        }
        strTokenizer.f57784h = false;
        StrTokenizer strTokenizer2 = new StrTokenizer();
        strTokenizer2.f57780d = StrMatcher.f57767b;
        if (strMatcher != null) {
            strTokenizer2.f57781e = strMatcher;
        }
        if (strMatcher2 != null) {
            strTokenizer2.f57782f = strMatcher2;
        }
        if (strMatcher3 != null) {
            strTokenizer2.f57783g = strMatcher3;
        }
        strTokenizer2.f57784h = false;
    }

    public StrTokenizer() {
        StrMatcher strMatcher = StrMatcher.f57771f;
        this.f57781e = strMatcher;
        this.f57782f = strMatcher;
        this.f57783g = strMatcher;
        this.f57784h = true;
        this.f57777a = null;
    }

    public static boolean c(char[] cArr, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i2 + i6;
            if (i7 >= i3 || cArr[i7] != cArr[i4 + i6]) {
                return false;
            }
        }
        return true;
    }

    public final void a(String str, ArrayList arrayList) {
        if (StringUtils.a(str) && this.f57784h) {
            return;
        }
        arrayList.add(str);
    }

    @Override // java.util.ListIterator
    public final void add(String str) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    public final void b() {
        if (this.f57778b == null) {
            char[] cArr = this.f57777a;
            if (cArr == null) {
                List listE = e(null, 0);
                this.f57778b = (String[]) listE.toArray(new String[listE.size()]);
            } else {
                List listE2 = e(cArr, cArr.length);
                this.f57778b = (String[]) listE2.toArray(new String[listE2.size()]);
            }
        }
    }

    public final Object clone() {
        try {
            StrTokenizer strTokenizer = (StrTokenizer) super.clone();
            char[] cArr = strTokenizer.f57777a;
            if (cArr != null) {
                strTokenizer.f57777a = (char[]) cArr.clone();
            }
            strTokenizer.f57779c = 0;
            strTokenizer.f57778b = null;
            return strTokenizer;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public final int d(char[] cArr, int i2, int i3, StrBuilder strBuilder, ArrayList arrayList, int i4, int i5) {
        int i6;
        int i7;
        strBuilder.f57765b = 0;
        boolean z = i5 > 0;
        int i8 = 0;
        while (i2 < i3) {
            if (!z) {
                int iA = this.f57780d.a(cArr, i2, i3);
                if (iA > 0) {
                    a(strBuilder.e(0, i8), arrayList);
                    return i2 + iA;
                }
                if (i5 <= 0 || !c(cArr, i2, i3, i4, i5)) {
                    ((StrMatcher.NoMatcher) this.f57782f).getClass();
                    int iA2 = this.f57783g.a(cArr, i2, i3);
                    if (iA2 > 0) {
                        strBuilder.c(cArr, i2, iA2);
                        i2 += iA2;
                    } else {
                        i6 = i2 + 1;
                        strBuilder.b(cArr[i2]);
                        i7 = strBuilder.f57765b;
                        int i9 = i6;
                        i8 = i7;
                        i2 = i9;
                    }
                } else {
                    i2 += i5;
                    z = true;
                }
            } else if (c(cArr, i2, i3, i4, i5)) {
                int i10 = i2 + i5;
                if (c(cArr, i10, i3, i4, i5)) {
                    strBuilder.c(cArr, i2, i5);
                    i2 += i5 * 2;
                    i8 = strBuilder.f57765b;
                } else {
                    z = false;
                    i2 = i10;
                }
            } else {
                i6 = i2 + 1;
                strBuilder.b(cArr[i2]);
                i7 = strBuilder.f57765b;
                int i92 = i6;
                i8 = i7;
                i2 = i92;
            }
        }
        a(strBuilder.e(0, i8), arrayList);
        return -1;
    }

    public List e(char[] cArr, int i2) {
        char[] cArr2;
        int i3;
        int iD;
        if (cArr == null || i2 == 0) {
            return Collections.EMPTY_LIST;
        }
        StrBuilder strBuilder = new StrBuilder();
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 >= 0 && i4 < i2) {
            int i5 = i4;
            while (i5 < i2) {
                ((StrMatcher.NoMatcher) this.f57782f).getClass();
                int iMax = Math.max(0, this.f57783g.a(cArr, i5, i2));
                if (iMax == 0 || this.f57780d.a(cArr, i5, i2) > 0 || this.f57781e.a(cArr, i5, i2) > 0) {
                    break;
                }
                i5 += iMax;
            }
            if (i5 >= i2) {
                a("", arrayList);
                cArr2 = cArr;
                i3 = i2;
                iD = -1;
            } else {
                int iA = this.f57780d.a(cArr, i5, i2);
                if (iA > 0) {
                    a("", arrayList);
                    cArr2 = cArr;
                    i3 = i2;
                    iD = i5 + iA;
                } else {
                    int iA2 = this.f57781e.a(cArr, i5, i2);
                    if (iA2 > 0) {
                        int i6 = i5;
                        cArr2 = cArr;
                        i3 = i2;
                        iD = d(cArr2, i6 + iA2, i3, strBuilder, arrayList, i6, iA2);
                    } else {
                        cArr2 = cArr;
                        i3 = i2;
                        iD = d(cArr2, i5, i3, strBuilder, arrayList, 0, 0);
                    }
                }
            }
            if (iD >= i3) {
                a("", arrayList);
            }
            i4 = iD;
            cArr = cArr2;
            i2 = i3;
        }
        return arrayList;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        b();
        return this.f57779c < this.f57778b.length;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        b();
        return this.f57779c > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String[] strArr = this.f57778b;
        int i2 = this.f57779c;
        this.f57779c = i2 + 1;
        return strArr[i2];
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f57779c;
    }

    @Override // java.util.ListIterator
    public final String previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        String[] strArr = this.f57778b;
        int i2 = this.f57779c - 1;
        this.f57779c = i2;
        return strArr[i2];
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f57779c - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    @Override // java.util.ListIterator
    public final void set(String str) {
        throw new UnsupportedOperationException("set() is unsupported");
    }

    public final String toString() {
        if (this.f57778b == null) {
            return "StrTokenizer[not tokenized yet]";
        }
        StringBuilder sb = new StringBuilder("StrTokenizer");
        b();
        ArrayList arrayList = new ArrayList(this.f57778b.length);
        for (String str : this.f57778b) {
            arrayList.add(str);
        }
        sb.append(arrayList);
        return sb.toString();
    }
}
