package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public class zzaaq implements Closeable, AutoCloseable {
    private final Reader zzb;
    private long zzi;
    private int zzj;
    private String zzk;
    private int[] zzl;
    private String[] zzn;
    private int[] zzo;
    private zzuq zzc = zzuq.LEGACY_STRICT;
    private final char[] zzd = new char[1024];
    private int zze = 0;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = 0;
    int zza = 0;
    private int zzm = 1;

    static {
        zzwa.zza = new zzaap();
    }

    public zzaaq(Reader reader) {
        int[] iArr = new int[32];
        this.zzl = iArr;
        iArr[0] = 6;
        this.zzn = new String[32];
        this.zzo = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.zzb = reader;
    }

    private String zzA(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i2 = 0;
        while (true) {
            int i3 = this.zzm;
            if (i2 >= i3) {
                return sb.toString();
            }
            int i4 = this.zzl[i2];
            switch (i4) {
                case 1:
                case 2:
                    int i5 = this.zzo[i2];
                    if (z && i5 > 0 && i2 == i3 - 1) {
                        i5--;
                    }
                    sb.append('[');
                    sb.append(i5);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    String str = this.zzn[i2];
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(b.f(i4, "Unknown scope value: "));
            }
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        r3 = r1 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
    
        if (r0 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
    
        r0 = new java.lang.StringBuilder(java.lang.Math.max(r3 + r3, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        r0.append(r4, r2, r3);
        r10.zze = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String zzB(char r11) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
        L1:
            int r1 = r10.zze
            int r2 = r10.zzf
            r3 = r2
            r2 = r1
        L7:
            char[] r4 = r10.zzd
            r5 = 16
            r6 = 1
            if (r1 >= r3) goto L6f
            int r7 = r1 + 1
            char r1 = r4[r1]
            com.google.ads.interactivemedia.v3.internal.zzuq r8 = r10.zzc
            com.google.ads.interactivemedia.v3.internal.zzuq r9 = com.google.ads.interactivemedia.v3.internal.zzuq.STRICT
            if (r8 != r9) goto L24
            r8 = 32
            if (r1 < r8) goto L1d
            goto L24
        L1d:
            java.lang.String r11 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            com.google.ads.interactivemedia.v3.internal.zzaat r11 = r10.zzy(r11)
            throw r11
        L24:
            if (r1 != r11) goto L3c
            int r11 = r7 - r2
            int r11 = r11 + (-1)
            r10.zze = r7
            if (r0 != 0) goto L34
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4, r2, r11)
            return r0
        L34:
            r0.append(r4, r2, r11)
            java.lang.String r11 = r0.toString()
            return r11
        L3c:
            r8 = 92
            if (r1 != r8) goto L62
            int r1 = r7 - r2
            int r3 = r1 + (-1)
            r10.zze = r7
            if (r0 != 0) goto L52
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r1 + r1
            int r1 = java.lang.Math.max(r1, r5)
            r0.<init>(r1)
        L52:
            r0.append(r4, r2, r3)
            char r1 = r10.zzd()
            r0.append(r1)
            int r2 = r10.zze
            int r3 = r10.zzf
            r1 = r2
            goto L7
        L62:
            r4 = 10
            if (r1 != r4) goto L6d
            int r1 = r10.zzg
            int r1 = r1 + r6
            r10.zzg = r1
            r10.zzh = r7
        L6d:
            r1 = r7
            goto L7
        L6f:
            int r3 = r1 - r2
            if (r0 != 0) goto L7f
            int r0 = r3 + r3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r0 = java.lang.Math.max(r0, r5)
            r7.<init>(r0)
            r0 = r7
        L7f:
            r0.append(r4, r2, r3)
            r10.zze = r1
            boolean r1 = r10.zzI(r6)
            if (r1 == 0) goto L8c
            goto L1
        L8c:
            java.lang.String r11 = "Unterminated string"
            com.google.ads.interactivemedia.v3.internal.zzaat r11 = r10.zzy(r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaaq.zzB(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        zzD();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String zzC() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r0
        L3:
            int r3 = r5.zze
            int r3 = r3 + r2
            int r4 = r5.zzf
            if (r3 >= r4) goto L4c
            char[] r4 = r5.zzd
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L59
            r4 = 10
            if (r3 == r4) goto L59
            r4 = 12
            if (r3 == r4) goto L59
            r4 = 13
            if (r3 == r4) goto L59
            r4 = 32
            if (r3 == r4) goto L59
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L59
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L59
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L59
            r4 = 58
            if (r3 == r4) goto L59
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L59;
                case 92: goto L48;
                case 93: goto L59;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.zzD()
            goto L59
        L4c:
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 >= r3) goto L5b
            int r3 = r2 + 1
            boolean r3 = r5.zzI(r3)
            if (r3 == 0) goto L59
            goto L3
        L59:
            r0 = r2
            goto L7b
        L5b:
            if (r1 != 0) goto L68
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L68:
            char[] r3 = r5.zzd
            int r4 = r5.zze
            r1.append(r3, r4, r2)
            int r3 = r5.zze
            int r3 = r3 + r2
            r5.zze = r3
            r2 = 1
            boolean r2 = r5.zzI(r2)
            if (r2 != 0) goto L2
        L7b:
            if (r1 != 0) goto L87
            char[] r1 = r5.zzd
            java.lang.String r2 = new java.lang.String
            int r3 = r5.zze
            r2.<init>(r1, r3, r0)
            goto L92
        L87:
            char[] r2 = r5.zzd
            int r3 = r5.zze
            r1.append(r2, r3, r0)
            java.lang.String r2 = r1.toString()
        L92:
            int r1 = r5.zze
            int r1 = r1 + r0
            r5.zze = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaaq.zzC():java.lang.String");
    }

    private final void zzD() throws zzaat {
        if (this.zzc != zzuq.LENIENT) {
            throw zzy("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private final void zzE(int i2) {
        int i3 = this.zzm;
        int[] iArr = this.zzl;
        if (i3 == iArr.length) {
            int i4 = i3 + i3;
            this.zzl = Arrays.copyOf(iArr, i4);
            this.zzo = Arrays.copyOf(this.zzo, i4);
            this.zzn = (String[]) Arrays.copyOf(this.zzn, i4);
        }
        int[] iArr2 = this.zzl;
        int i5 = this.zzm;
        this.zzm = i5 + 1;
        iArr2[i5] = i2;
    }

    private final void zzF(char c2) throws IOException {
        do {
            int i2 = this.zze;
            int i3 = this.zzf;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = this.zzd[i2];
                if (c3 == c2) {
                    this.zze = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.zze = i4;
                    zzd();
                    i2 = this.zze;
                    i3 = this.zzf;
                } else {
                    if (c3 == '\n') {
                        this.zzg++;
                        this.zzh = i4;
                    }
                    i2 = i4;
                }
            }
            this.zze = i2;
        } while (zzI(1));
        throw zzy("Unterminated string");
    }

    private final void zzG() throws IOException {
        char c2;
        do {
            if (this.zze >= this.zzf && !zzI(1)) {
                return;
            }
            char[] cArr = this.zzd;
            int i2 = this.zze;
            int i3 = i2 + 1;
            this.zze = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.zzg++;
                this.zzh = i3;
                return;
            }
        } while (c2 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0047, code lost:
    
        zzD();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzH() throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            int r2 = r4.zze
            int r2 = r2 + r1
            int r3 = r4.zzf
            if (r2 >= r3) goto L50
            char[] r3 = r4.zzd
            char r2 = r3[r2]
            r3 = 9
            if (r2 == r3) goto L4a
            r3 = 10
            if (r2 == r3) goto L4a
            r3 = 12
            if (r2 == r3) goto L4a
            r3 = 13
            if (r2 == r3) goto L4a
            r3 = 32
            if (r2 == r3) goto L4a
            r3 = 35
            if (r2 == r3) goto L47
            r3 = 44
            if (r2 == r3) goto L4a
            r3 = 47
            if (r2 == r3) goto L47
            r3 = 61
            if (r2 == r3) goto L47
            r3 = 123(0x7b, float:1.72E-43)
            if (r2 == r3) goto L4a
            r3 = 125(0x7d, float:1.75E-43)
            if (r2 == r3) goto L4a
            r3 = 58
            if (r2 == r3) goto L4a
            r3 = 59
            if (r2 == r3) goto L47
            switch(r2) {
                case 91: goto L4a;
                case 92: goto L47;
                case 93: goto L4a;
                default: goto L44;
            }
        L44:
            int r1 = r1 + 1
            goto L2
        L47:
            r4.zzD()
        L4a:
            int r0 = r4.zze
            int r0 = r0 + r1
            r4.zze = r0
            return
        L50:
            r4.zze = r2
            r1 = 1
            boolean r1 = r4.zzI(r1)
            if (r1 == 0) goto L5a
            goto L1
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaaq.zzH():void");
    }

    private final boolean zzI(int i2) throws IOException {
        int i3;
        int i4 = this.zzh;
        int i5 = this.zze;
        this.zzh = i4 - i5;
        char[] cArr = this.zzd;
        int i6 = this.zzf;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.zzf = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.zzf = 0;
        }
        this.zze = 0;
        do {
            Reader reader = this.zzb;
            int i8 = this.zzf;
            int i9 = reader.read(cArr, i8, 1024 - i8);
            if (i9 == -1) {
                return false;
            }
            i3 = this.zzf + i9;
            this.zzf = i3;
            if (this.zzg == 0 && this.zzh == 0 && i3 > 0 && cArr[0] == 65279) {
                this.zze++;
                this.zzh = 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    private final boolean zzJ(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case WKSRecord.Service.MIT_DOV /* 91 */:
                        case WKSRecord.Service.DCP /* 93 */:
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzD();
        return false;
    }

    private final char zzd() throws IOException {
        int i2;
        if (this.zze == this.zzf && !zzI(1)) {
            throw zzy("Unterminated escape sequence");
        }
        char[] cArr = this.zzd;
        int i3 = this.zze;
        int i4 = i3 + 1;
        this.zze = i4;
        char c2 = cArr[i3];
        if (c2 != '\n') {
            if (c2 != '\"') {
                if (c2 != '\'') {
                    if (c2 != '/' && c2 != '\\') {
                        if (c2 == 'b') {
                            return '\b';
                        }
                        if (c2 == 'f') {
                            return '\f';
                        }
                        if (c2 == 'n') {
                            return '\n';
                        }
                        if (c2 == 'r') {
                            return CharUtils.CR;
                        }
                        if (c2 == 't') {
                            return '\t';
                        }
                        if (c2 != 'u') {
                            throw zzy("Invalid escape sequence");
                        }
                        if (i3 + 5 > this.zzf && !zzI(4)) {
                            throw zzy("Unterminated escape sequence");
                        }
                        int i5 = this.zze;
                        int i6 = i5 + 4;
                        int i7 = 0;
                        while (i5 < i6) {
                            char[] cArr2 = this.zzd;
                            int i8 = i7 << 4;
                            char c3 = cArr2[i5];
                            if (c3 >= '0' && c3 <= '9') {
                                i2 = c3 - '0';
                            } else if (c3 >= 'a' && c3 <= 'f') {
                                i2 = c3 - 'W';
                            } else {
                                if (c3 < 'A' || c3 > 'F') {
                                    throw zzy("Malformed Unicode escape \\u".concat(new String(cArr2, this.zze, 4)));
                                }
                                i2 = c3 - '7';
                            }
                            i7 = i2 + i8;
                            i5++;
                        }
                        this.zze += 4;
                        return (char) i7;
                    }
                }
            }
            return c2;
        }
        if (this.zzc == zzuq.STRICT) {
            throw zzy("Cannot escape a newline character in strict mode");
        }
        this.zzg++;
        this.zzh = i4;
        if (this.zzc == zzuq.STRICT) {
            throw zzy("Invalid escaped character \"'\" in strict mode");
        }
        return c2;
    }

    private final int zzn(boolean z) throws IOException {
        int i2;
        int i3 = this.zze;
        int i4 = this.zzf;
        while (true) {
            if (i3 == i4) {
                this.zze = i3;
                if (!zzI(1)) {
                    if (z) {
                        throw new EOFException("End of input".concat(zzv()));
                    }
                    return -1;
                }
                i3 = this.zze;
                i4 = this.zzf;
            }
            char[] cArr = this.zzd;
            int i5 = i3 + 1;
            char c2 = cArr[i3];
            if (c2 == '\n') {
                this.zzg++;
                this.zzh = i5;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.zze = i5;
                    if (i5 == i4) {
                        this.zze = i3;
                        boolean zZzI = zzI(2);
                        this.zze++;
                        if (!zZzI) {
                            return 47;
                        }
                    }
                    zzD();
                    int i6 = this.zze;
                    char c3 = cArr[i6];
                    if (c3 == '*') {
                        this.zze = i6 + 1;
                        while (true) {
                            if (this.zze + 2 > this.zzf && !zzI(2)) {
                                throw zzy("Unterminated comment");
                            }
                            char[] cArr2 = this.zzd;
                            int i7 = this.zze;
                            if (cArr2[i7] != '\n') {
                                while (i2 < 2) {
                                    i2 = this.zzd[this.zze + i2] == "*/".charAt(i2) ? i2 + 1 : 0;
                                }
                                i3 = this.zze + 2;
                                i4 = this.zzf;
                                break;
                            }
                            this.zzg++;
                            this.zzh = i7 + 1;
                            this.zze++;
                        }
                    } else {
                        if (c3 != '/') {
                            return 47;
                        }
                        this.zze = i6 + 1;
                        zzG();
                        i3 = this.zze;
                        i4 = this.zzf;
                    }
                } else {
                    if (c2 != '#') {
                        this.zze = i5;
                        return c2;
                    }
                    this.zze = i5;
                    zzD();
                    zzG();
                    i3 = this.zze;
                    i4 = this.zzf;
                }
            }
            i3 = i5;
        }
    }

    private final zzaat zzy(String str) throws zzaat {
        throw new zzaat(b.l(str, zzv(), "\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#malformed-json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IllegalStateException zzz(String str) throws IOException {
        int iZzr = zzr();
        StringBuilder sbV = e.v("Expected ", str, " but was ", zzaar.zza(zzr()), zzv());
        sbV.append("\nSee ");
        sbV.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(iZzr == 9 ? "adapter-not-null-safe" : "unexpected-json-structure"));
        return new IllegalStateException(sbV.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zza = 0;
        this.zzl[0] = 8;
        this.zzm = 1;
        this.zzb.close();
    }

    public String toString() {
        return getClass().getSimpleName().concat(zzv());
    }

    public double zza() throws IOException, NumberFormatException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs == 15) {
            this.zza = 0;
            int[] iArr = this.zzo;
            int i2 = this.zzm - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.zzi;
        }
        if (iZzs == 16) {
            char[] cArr = this.zzd;
            int i3 = this.zze;
            int i4 = this.zzj;
            this.zzk = new String(cArr, i3, i4);
            this.zze = i3 + i4;
        } else if (iZzs == 8 || iZzs == 9) {
            this.zzk = zzB(iZzs == 8 ? '\'' : '\"');
        } else if (iZzs == 10) {
            this.zzk = zzC();
        } else if (iZzs != 11) {
            throw zzz("a double");
        }
        this.zza = 11;
        double d2 = Double.parseDouble(this.zzk);
        if (this.zzc != zzuq.LENIENT && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw zzy("JSON forbids NaN and infinities: " + d2);
        }
        this.zzk = null;
        this.zza = 0;
        int[] iArr2 = this.zzo;
        int i5 = this.zzm - 1;
        iArr2[i5] = iArr2[i5] + 1;
        return d2;
    }

    public int zzb() throws IOException, NumberFormatException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs == 15) {
            long j2 = this.zzi;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.zza = 0;
                int[] iArr = this.zzo;
                int i3 = this.zzm - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + j2 + zzv());
        }
        if (iZzs == 16) {
            char[] cArr = this.zzd;
            int i4 = this.zze;
            int i5 = this.zzj;
            this.zzk = new String(cArr, i4, i5);
            this.zze = i4 + i5;
        } else {
            if (iZzs != 8 && iZzs != 9 && iZzs != 10) {
                throw zzz("an int");
            }
            if (iZzs == 10) {
                this.zzk = zzC();
            } else {
                this.zzk = zzB(iZzs == 8 ? '\'' : '\"');
            }
            try {
                int i6 = Integer.parseInt(this.zzk);
                this.zza = 0;
                int[] iArr2 = this.zzo;
                int i7 = this.zzm - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return i6;
            } catch (NumberFormatException unused) {
            }
        }
        this.zza = 11;
        double d2 = Double.parseDouble(this.zzk);
        int i8 = (int) d2;
        if (i8 != d2) {
            throw new NumberFormatException(b.D("Expected an int but was ", this.zzk, zzv()));
        }
        this.zzk = null;
        this.zza = 0;
        int[] iArr3 = this.zzo;
        int i9 = this.zzm - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return i8;
    }

    public long zzc() throws IOException, NumberFormatException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs == 15) {
            this.zza = 0;
            int[] iArr = this.zzo;
            int i2 = this.zzm - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.zzi;
        }
        if (iZzs == 16) {
            char[] cArr = this.zzd;
            int i3 = this.zze;
            int i4 = this.zzj;
            this.zzk = new String(cArr, i3, i4);
            this.zze = i3 + i4;
        } else {
            if (iZzs != 8 && iZzs != 9 && iZzs != 10) {
                throw zzz("a long");
            }
            if (iZzs == 10) {
                this.zzk = zzC();
            } else {
                this.zzk = zzB(iZzs == 8 ? '\'' : '\"');
            }
            try {
                long j2 = Long.parseLong(this.zzk);
                this.zza = 0;
                int[] iArr2 = this.zzo;
                int i5 = this.zzm - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.zza = 11;
        double d2 = Double.parseDouble(this.zzk);
        long j3 = (long) d2;
        if (j3 != d2) {
            throw new NumberFormatException(b.D("Expected a long but was ", this.zzk, zzv()));
        }
        this.zzk = null;
        this.zza = 0;
        int[] iArr3 = this.zzo;
        int i6 = this.zzm - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return j3;
    }

    public String zze() {
        return zzA(false);
    }

    public String zzf() {
        return zzA(true);
    }

    public String zzg() throws IOException {
        String strZzB;
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs == 14) {
            strZzB = zzC();
        } else if (iZzs == 12) {
            strZzB = zzB('\'');
        } else {
            if (iZzs != 13) {
                throw zzz("a name");
            }
            strZzB = zzB('\"');
        }
        this.zza = 0;
        this.zzn[this.zzm - 1] = strZzB;
        return strZzB;
    }

    public String zzh() throws IOException {
        String string;
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs == 10) {
            string = zzC();
        } else if (iZzs == 8) {
            string = zzB('\'');
        } else if (iZzs == 9) {
            string = zzB('\"');
        } else if (iZzs == 11) {
            string = this.zzk;
            this.zzk = null;
        } else if (iZzs == 15) {
            string = Long.toString(this.zzi);
        } else {
            if (iZzs != 16) {
                throw zzz("a string");
            }
            String str = new String(this.zzd, this.zze, this.zzj);
            this.zze += this.zzj;
            string = str;
        }
        this.zza = 0;
        int[] iArr = this.zzo;
        int i2 = this.zzm - 1;
        iArr[i2] = iArr[i2] + 1;
        return string;
    }

    public void zzi() throws IOException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs != 3) {
            throw zzz("BEGIN_ARRAY");
        }
        zzE(1);
        this.zzo[this.zzm - 1] = 0;
        this.zza = 0;
    }

    public void zzj() throws IOException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs != 1) {
            throw zzz("BEGIN_OBJECT");
        }
        zzE(3);
        this.zza = 0;
    }

    public void zzk() throws IOException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs != 4) {
            throw zzz("END_ARRAY");
        }
        int i2 = this.zzm;
        this.zzm = i2 - 1;
        int[] iArr = this.zzo;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.zza = 0;
    }

    public void zzl() throws IOException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs != 2) {
            throw zzz("END_OBJECT");
        }
        int i2 = this.zzm;
        int i3 = i2 - 1;
        this.zzm = i3;
        this.zzn[i3] = null;
        int[] iArr = this.zzo;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.zza = 0;
    }

    public void zzm() throws IOException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs != 7) {
            throw zzz("null");
        }
        this.zza = 0;
        int[] iArr = this.zzo;
        int i2 = this.zzm - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void zzo() throws IOException {
        int i2 = 0;
        do {
            int iZzs = this.zza;
            if (iZzs == 0) {
                iZzs = zzs();
            }
            switch (iZzs) {
                case 1:
                    zzE(3);
                    i2++;
                    this.zza = 0;
                    break;
                case 2:
                    if (i2 == 0) {
                        this.zzn[this.zzm - 1] = null;
                        i2 = 0;
                    }
                    this.zzm--;
                    i2--;
                    this.zza = 0;
                    break;
                case 3:
                    zzE(1);
                    i2++;
                    this.zza = 0;
                    break;
                case 4:
                    this.zzm--;
                    i2--;
                    this.zza = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.zza = 0;
                    break;
                case 8:
                    zzF('\'');
                    this.zza = 0;
                    break;
                case 9:
                    zzF('\"');
                    this.zza = 0;
                    break;
                case 10:
                    zzH();
                    this.zza = 0;
                    break;
                case 12:
                    zzF('\'');
                    if (i2 == 0) {
                        this.zzn[this.zzm - 1] = "<skipped>";
                        i2 = 0;
                    }
                    this.zza = 0;
                    break;
                case 13:
                    zzF('\"');
                    if (i2 == 0) {
                        this.zzn[this.zzm - 1] = "<skipped>";
                        i2 = 0;
                    }
                    this.zza = 0;
                    break;
                case 14:
                    zzH();
                    if (i2 == 0) {
                        this.zzn[this.zzm - 1] = "<skipped>";
                        i2 = 0;
                    }
                    this.zza = 0;
                    break;
                case 16:
                    this.zze += this.zzj;
                    this.zza = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i2 > 0);
        int[] iArr = this.zzo;
        int i3 = this.zzm - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    public boolean zzp() throws IOException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        return (iZzs == 2 || iZzs == 4 || iZzs == 17) ? false : true;
    }

    public boolean zzq() throws IOException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        if (iZzs == 5) {
            this.zza = 0;
            int[] iArr = this.zzo;
            int i2 = this.zzm - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iZzs != 6) {
            throw zzz("a boolean");
        }
        this.zza = 0;
        int[] iArr2 = this.zzo;
        int i3 = this.zzm - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }

    public int zzr() throws IOException {
        int iZzs = this.zza;
        if (iZzs == 0) {
            iZzs = zzs();
        }
        switch (iZzs) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x022c, code lost:
    
        if (zzJ(r1) == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0247, code lost:
    
        if (r3 == 0) goto L178;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0296 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzs() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 837
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaaq.zzs():int");
    }

    public final zzuq zzt() {
        return this.zzc;
    }

    public String zzv() {
        int i2 = this.zzg + 1;
        int i3 = this.zze - this.zzh;
        String strZze = zze();
        StringBuilder sbU = b.u(i2, " at line ", " column ");
        sbU.append(i3 + 1);
        sbU.append(" path ");
        sbU.append(strZze);
        return sbU.toString();
    }

    public final void zzw(zzuq zzuqVar) {
        Objects.requireNonNull(zzuqVar);
        this.zzc = zzuqVar;
    }

    public final boolean zzx() {
        return this.zzc == zzuq.LENIENT;
    }
}
