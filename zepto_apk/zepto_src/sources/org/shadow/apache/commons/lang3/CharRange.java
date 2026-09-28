package org.shadow.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes5.dex */
final class CharRange implements Iterable<Character>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final char f57692a;

    /* renamed from: b, reason: collision with root package name */
    public final char f57693b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f57694c;

    /* renamed from: d, reason: collision with root package name */
    public transient String f57695d;

    public static class CharacterIterator implements Iterator<Character> {

        /* renamed from: a, reason: collision with root package name */
        public char f57696a;

        /* renamed from: b, reason: collision with root package name */
        public final CharRange f57697b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f57698c;

        public CharacterIterator(CharRange charRange) {
            this.f57697b = charRange;
            this.f57698c = true;
            boolean z = charRange.f57694c;
            char c2 = charRange.f57692a;
            if (!z) {
                this.f57696a = c2;
                return;
            }
            if (c2 != 0) {
                this.f57696a = (char) 0;
                return;
            }
            char c3 = charRange.f57693b;
            if (c3 == 65535) {
                this.f57698c = false;
            } else {
                this.f57696a = (char) (c3 + 1);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f57698c;
        }

        @Override // java.util.Iterator
        public final Character next() {
            if (!this.f57698c) {
                throw new NoSuchElementException();
            }
            char c2 = this.f57696a;
            CharRange charRange = this.f57697b;
            boolean z = charRange.f57694c;
            char c3 = charRange.f57693b;
            if (z) {
                if (c2 == 65535) {
                    this.f57698c = false;
                } else {
                    int i2 = c2 + 1;
                    if (i2 != charRange.f57692a) {
                        this.f57696a = (char) i2;
                    } else if (c3 == 65535) {
                        this.f57698c = false;
                    } else {
                        this.f57696a = (char) (c3 + 1);
                    }
                }
            } else if (c2 < c3) {
                this.f57696a = (char) (c2 + 1);
            } else {
                this.f57698c = false;
            }
            return Character.valueOf(c2);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public CharRange(char c2, char c3, boolean z) {
        if (c2 > c3) {
            c3 = c2;
            c2 = c3;
        }
        this.f57692a = c2;
        this.f57693b = c3;
        this.f57694c = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        return this.f57692a == charRange.f57692a && this.f57693b == charRange.f57693b && this.f57694c == charRange.f57694c;
    }

    public final int hashCode() {
        return (this.f57693b * 7) + this.f57692a + 'S' + (this.f57694c ? 1 : 0);
    }

    @Override // java.lang.Iterable
    public final Iterator<Character> iterator() {
        return new CharacterIterator(this);
    }

    public final String toString() {
        if (this.f57695d == null) {
            StringBuilder sb = new StringBuilder(4);
            if (this.f57694c) {
                sb.append('^');
            }
            char c2 = this.f57692a;
            sb.append(c2);
            char c3 = this.f57693b;
            if (c2 != c3) {
                sb.append(Soundex.SILENT_MARKER);
                sb.append(c3);
            }
            this.f57695d = sb.toString();
        }
        return this.f57695d;
    }
}
