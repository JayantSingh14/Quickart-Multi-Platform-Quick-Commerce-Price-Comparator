package org.xbill.DNS;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class Generator {
    private long current;
    public final int dclass;
    public long end;
    public final String namePattern;
    public final Name origin;
    public final String rdataPattern;
    public long start;
    public long step;
    public final long ttl;
    public final int type;

    public Generator(long j2, long j3, long j4, String str, int i2, int i3, long j5, String str2, Name name) {
        if (j2 < 0 || j3 < 0 || j2 > j3 || j4 <= 0) {
            throw new IllegalArgumentException("invalid range specification");
        }
        if (!supportedType(i2)) {
            throw new IllegalArgumentException("unsupported type");
        }
        DClass.check(i3);
        this.start = j2;
        this.end = j3;
        this.step = j4;
        this.namePattern = str;
        this.type = i2;
        this.dclass = i3;
        this.ttl = j5;
        this.rdataPattern = str2;
        this.origin = name;
        this.current = j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0096, code lost:
    
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0097, code lost:
    
        if (r3 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        r6 = -r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009a, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009b, code lost:
    
        if (r5 != ',') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
    
        r3 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
    
        if (r3 >= r0.length) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a2, code lost:
    
        r5 = (char) (r0[r3] & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a7, code lost:
    
        if (r5 == ',') goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a9, code lost:
    
        if (r5 != '}') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ae, code lost:
    
        if (r5 < r2) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b0, code lost:
    
        if (r5 > '9') goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b2, code lost:
    
        r5 = (char) (r5 - '0');
        r9 = (r9 * 10) + r5;
        r8 = r3;
        r2 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c7, code lost:
    
        throw new org.xbill.DNS.TextParseException("invalid width");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c8, code lost:
    
        r8 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ca, code lost:
    
        if (r5 != ',') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cc, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d1, code lost:
    
        if (r8 == r0.length) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d3, code lost:
    
        r2 = (char) (r0[r8] & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00da, code lost:
    
        if (r2 != 'o') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00dc, code lost:
    
        r22 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00de, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e2, code lost:
    
        if (r2 != 'x') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e4, code lost:
    
        r22 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e9, code lost:
    
        if (r2 != 'X') goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00eb, code lost:
    
        r2 = true;
        r22 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00f2, code lost:
    
        if (r2 != 'd') goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00fa, code lost:
    
        throw new org.xbill.DNS.TextParseException("invalid base");
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0100, code lost:
    
        throw new org.xbill.DNS.TextParseException("invalid base");
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0101, code lost:
    
        r3 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0104, code lost:
    
        if (r3 == r0.length) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0108, code lost:
    
        if (r0[r3] != 125) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0112, code lost:
    
        throw new org.xbill.DNS.TextParseException("invalid modifiers");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String substitute(java.lang.String r26, long r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Generator.substitute(java.lang.String, long):java.lang.String");
    }

    public static boolean supportedType(int i2) {
        Type.check(i2);
        return i2 == 12 || i2 == 5 || i2 == 39 || i2 == 1 || i2 == 28 || i2 == 2;
    }

    public Record[] expand() throws IOException {
        ArrayList arrayList = new ArrayList();
        long j2 = this.start;
        while (j2 < this.end) {
            arrayList.add(Record.fromString(Name.fromString(substitute(this.namePattern, this.current), this.origin), this.type, this.dclass, this.ttl, substitute(this.rdataPattern, this.current), this.origin));
            j2 += this.step;
        }
        return (Record[]) arrayList.toArray(new Record[0]);
    }

    public Record nextRecord() throws IOException {
        long j2 = this.current;
        if (j2 > this.end) {
            return null;
        }
        Name nameFromString = Name.fromString(substitute(this.namePattern, j2), this.origin);
        String strSubstitute = substitute(this.rdataPattern, this.current);
        this.current += this.step;
        return Record.fromString(nameFromString, this.type, this.dclass, this.ttl, strSubstitute, this.origin);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("$GENERATE ");
        sb.append(this.start);
        sb.append("-");
        sb.append(this.end);
        if (this.step > 1) {
            sb.append("/");
            sb.append(this.step);
        }
        sb.append(StringUtils.SPACE);
        sb.append(this.namePattern);
        sb.append(StringUtils.SPACE);
        sb.append(this.ttl);
        sb.append(StringUtils.SPACE);
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            sb.append(DClass.string(this.dclass));
            sb.append(StringUtils.SPACE);
        }
        sb.append(Type.string(this.type));
        sb.append(StringUtils.SPACE);
        return android.support.v4.media.b.r(sb, this.rdataPattern, StringUtils.SPACE);
    }
}
