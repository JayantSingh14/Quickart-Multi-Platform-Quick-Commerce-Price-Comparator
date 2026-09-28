package net.jpountz.lz4;

import android.support.v4.media.b;

/* loaded from: classes.dex */
enum LZ4Utils {
    ;

    private static final int MAX_INPUT_SIZE = 2113929216;

    public static class Match {
        int len;
        int ref;
        int start;

        public int end() {
            return this.start + this.len;
        }

        public void fix(int i2) {
            this.start += i2;
            this.ref += i2;
            this.len -= i2;
        }
    }

    public static void copyTo(Match match, Match match2) {
        match2.len = match.len;
        match2.start = match.start;
        match2.ref = match.ref;
    }

    public static int hash(int i2) {
        return (i2 * (-1640531535)) >>> 20;
    }

    public static int hash64k(int i2) {
        return (i2 * (-1640531535)) >>> 19;
    }

    public static int hashHC(int i2) {
        return (i2 * (-1640531535)) >>> 17;
    }

    public static int maxCompressedLength(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "length must be >= 0, got "));
        }
        if (i2 < MAX_INPUT_SIZE) {
            return (i2 / 255) + i2 + 16;
        }
        throw new IllegalArgumentException("length must be < 2113929216");
    }
}
