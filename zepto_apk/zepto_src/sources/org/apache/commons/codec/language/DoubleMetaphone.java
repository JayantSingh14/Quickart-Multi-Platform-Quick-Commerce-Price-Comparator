package org.apache.commons.codec.language;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes5.dex */
public class DoubleMetaphone implements StringEncoder {
    private static final String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", "V", "W", StringUtils.SPACE};
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", RegionUtil.SubRegionUtil.SUB_REGION_STRING_IN, "IE", "EI", "ER"};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", "T", "K", "S", "N", "M", "B", "Z"};

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return null;
        }
        return strTrim.toUpperCase(Locale.ENGLISH);
    }

    private boolean conditionC0(String str, int i2) {
        if (contains(str, i2, 4, "CHIA")) {
            return true;
        }
        if (i2 <= 1) {
            return false;
        }
        int i3 = i2 - 2;
        if (isVowel(charAt(str, i3)) || !contains(str, i2 - 1, 3, "ACH")) {
            return false;
        }
        char cCharAt = charAt(str, i2 + 2);
        return !(cCharAt == 'I' || cCharAt == 'E') || contains(str, i3, 6, "BACHER", "MACHER");
    }

    private boolean conditionCH0(String str, int i2) {
        if (i2 != 0) {
            return false;
        }
        int i3 = i2 + 1;
        return (contains(str, i3, 5, "HARAC", "HARIS") || contains(str, i3, 3, "HOR", "HYM", "HIA", "HEM")) && !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(String str, int i2) {
        if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH") && !contains(str, i2 - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i3 = i2 + 2;
            if (!contains(str, i3, 1, "T", "S") && ((!contains(str, i2 - 1, 1, "A", "O", "U", "E") && i2 != 0) || (!contains(str, i3, 1, L_R_N_M_B_H_F_V_W_SPACE) && i2 + 1 != str.length() - 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean conditionL0(String str, int i2) {
        if (i2 == str.length() - 3 && contains(str, i2 - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        return (contains(str, str.length() - 2, 2, "AS", "OS") || contains(str, str.length() - 1, 1, "A", "O")) && contains(str, i2 - 1, 4, "ALLE");
    }

    private boolean conditionM0(String str, int i2) {
        int i3 = i2 + 1;
        if (charAt(str, i3) == 'M') {
            return true;
        }
        if (contains(str, i2 - 1, 3, "UMB")) {
            return i3 == str.length() - 1 || contains(str, i2 + 2, 2, "ER");
        }
        return false;
    }

    public static boolean contains(String str, int i2, int i3, String... strArr) {
        int i4;
        if (i2 >= 0 && (i4 = i3 + i2) <= str.length()) {
            String strSubstring = str.substring(i2, i4);
            for (String str2 : strArr) {
                if (strSubstring.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int handleAEIOUY(DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (i2 == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i2 + 1;
    }

    private int handleC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (conditionC0(str, i2)) {
            doubleMetaphoneResult.append('K');
            return i2 + 2;
        }
        if (i2 == 0 && contains(str, i2, 6, "CAESAR")) {
            doubleMetaphoneResult.append('S');
            return i2 + 2;
        }
        if (contains(str, i2, 2, "CH")) {
            return handleCH(str, doubleMetaphoneResult, i2);
        }
        if (contains(str, i2, 2, "CZ") && !contains(str, i2 - 2, 4, "WICZ")) {
            doubleMetaphoneResult.append('S', 'X');
            return i2 + 2;
        }
        int i3 = i2 + 1;
        if (contains(str, i3, 3, "CIA")) {
            doubleMetaphoneResult.append('X');
            return i2 + 3;
        }
        if (contains(str, i2, 2, "CC") && (i2 != 1 || charAt(str, 0) != 'M')) {
            return handleCC(str, doubleMetaphoneResult, i2);
        }
        if (contains(str, i2, 2, "CK", "CG", "CQ")) {
            doubleMetaphoneResult.append('K');
            return i2 + 2;
        }
        if (!contains(str, i2, 2, "CI", "CE", "CY")) {
            doubleMetaphoneResult.append('K');
            return contains(str, i3, 2, " C", " Q", " G") ? i2 + 3 : (!contains(str, i3, 1, "C", "K", "Q") || contains(str, i3, 2, "CE", "CI")) ? i3 : i2 + 2;
        }
        if (contains(str, i2, 3, "CIO", "CIE", "CIA")) {
            doubleMetaphoneResult.append('S', 'X');
        } else {
            doubleMetaphoneResult.append('S');
        }
        return i2 + 2;
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        int i3 = i2 + 2;
        if (!contains(str, i3, 1, "I", "E", "H") || contains(str, i3, 2, "HU")) {
            doubleMetaphoneResult.append('K');
            return i3;
        }
        if ((i2 == 1 && charAt(str, i2 - 1) == 'A') || contains(str, i2 - 1, 5, "UCCEE", "UCCES")) {
            doubleMetaphoneResult.append("KS");
        } else {
            doubleMetaphoneResult.append('X');
        }
        return i2 + 3;
    }

    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (i2 > 0 && contains(str, i2, 4, "CHAE")) {
            doubleMetaphoneResult.append('K', 'X');
        } else {
            if (!conditionCH0(str, i2) && !conditionCH1(str, i2)) {
                if (i2 <= 0) {
                    doubleMetaphoneResult.append('X');
                } else if (contains(str, 0, 2, "MC")) {
                    doubleMetaphoneResult.append('K');
                } else {
                    doubleMetaphoneResult.append('X', 'K');
                }
                return i2 + 2;
            }
            doubleMetaphoneResult.append('K');
        }
        return i2 + 2;
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (!contains(str, i2, 2, "DG")) {
            if (contains(str, i2, 2, "DT", "DD")) {
                doubleMetaphoneResult.append('T');
                return i2 + 2;
            }
            doubleMetaphoneResult.append('T');
            return i2 + 1;
        }
        int i3 = i2 + 2;
        if (contains(str, i3, 1, "I", "E", "Y")) {
            doubleMetaphoneResult.append('J');
            return i2 + 3;
        }
        doubleMetaphoneResult.append("TK");
        return i3;
    }

    private int handleG(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2, boolean z) {
        int i3 = i2 + 1;
        if (charAt(str, i3) == 'H') {
            return handleGH(str, doubleMetaphoneResult, i2);
        }
        if (charAt(str, i3) == 'N') {
            if (i2 == 1 && isVowel(charAt(str, 0)) && !z) {
                doubleMetaphoneResult.append("KN", "N");
            } else if (contains(str, i2 + 2, 2, "EY") || charAt(str, i3) == 'Y' || z) {
                doubleMetaphoneResult.append("KN");
            } else {
                doubleMetaphoneResult.append("N", "KN");
            }
            return i2 + 2;
        }
        if (contains(str, i3, 2, "LI") && !z) {
            doubleMetaphoneResult.append("KL", "L");
            return i2 + 2;
        }
        if (i2 == 0 && (charAt(str, i3) == 'Y' || contains(str, i3, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            doubleMetaphoneResult.append('K', 'J');
            return i2 + 2;
        }
        if ((contains(str, i3, 2, "ER") || charAt(str, i3) == 'Y') && !contains(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
            int i4 = i2 - 1;
            if (!contains(str, i4, 1, "E", "I") && !contains(str, i4, 3, "RGY", "OGY")) {
                doubleMetaphoneResult.append('K', 'J');
                return i2 + 2;
            }
        }
        if (!contains(str, i3, 1, "E", "I", "Y") && !contains(str, i2 - 1, 4, "AGGI", "OGGI")) {
            if (charAt(str, i3) != 'G') {
                doubleMetaphoneResult.append('K');
                return i3;
            }
            int i5 = i2 + 2;
            doubleMetaphoneResult.append('K');
            return i5;
        }
        if (contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH") || contains(str, i3, 2, "ET")) {
            doubleMetaphoneResult.append('K');
        } else if (contains(str, i3, 3, "IER")) {
            doubleMetaphoneResult.append('J');
        } else {
            doubleMetaphoneResult.append('J', 'K');
        }
        return i2 + 2;
    }

    private int handleGH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (i2 > 0 && !isVowel(charAt(str, i2 - 1))) {
            doubleMetaphoneResult.append('K');
            return i2 + 2;
        }
        if (i2 == 0) {
            int i3 = i2 + 2;
            if (charAt(str, i3) == 'I') {
                doubleMetaphoneResult.append('J');
            } else {
                doubleMetaphoneResult.append('K');
            }
            return i3;
        }
        if ((i2 > 1 && contains(str, i2 - 2, 1, "B", "H", "D")) || ((i2 > 2 && contains(str, i2 - 3, 1, "B", "H", "D")) || (i2 > 3 && contains(str, i2 - 4, 1, "B", "H")))) {
            return i2 + 2;
        }
        if (i2 > 2 && charAt(str, i2 - 1) == 'U' && contains(str, i2 - 3, 1, "C", "G", "L", "R", "T")) {
            doubleMetaphoneResult.append('F');
        } else if (i2 > 0 && charAt(str, i2 - 1) != 'I') {
            doubleMetaphoneResult.append('K');
        }
        return i2 + 2;
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if ((i2 != 0 && !isVowel(charAt(str, i2 - 1))) || !isVowel(charAt(str, i2 + 1))) {
            return i2 + 1;
        }
        doubleMetaphoneResult.append('H');
        return i2 + 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int handleJ(java.lang.String r10, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r11, int r12, boolean r13) {
        /*
            r9 = this;
            java.lang.String r0 = "JOSE"
            java.lang.String[] r1 = new java.lang.String[]{r0}
            r2 = 4
            boolean r1 = contains(r10, r12, r2, r1)
            r3 = 32
            java.lang.String r4 = "SAN "
            r5 = 0
            r6 = 72
            r7 = 74
            r8 = 1
            if (r1 != 0) goto L8a
            java.lang.String[] r1 = new java.lang.String[]{r4}
            boolean r1 = contains(r10, r5, r2, r1)
            if (r1 == 0) goto L22
            goto L8a
        L22:
            r1 = 65
            if (r12 != 0) goto L34
            java.lang.String[] r0 = new java.lang.String[]{r0}
            boolean r0 = contains(r10, r12, r2, r0)
            if (r0 != 0) goto L34
            r11.append(r7, r1)
            goto L7e
        L34:
            int r0 = r12 + (-1)
            char r2 = r9.charAt(r10, r0)
            boolean r2 = r9.isVowel(r2)
            if (r2 == 0) goto L56
            if (r13 != 0) goto L56
            int r13 = r12 + 1
            char r2 = r9.charAt(r10, r13)
            if (r2 == r1) goto L52
            char r13 = r9.charAt(r10, r13)
            r1 = 79
            if (r13 != r1) goto L56
        L52:
            r11.append(r7, r6)
            goto L7e
        L56:
            int r13 = r10.length()
            int r13 = r13 - r8
            if (r12 != r13) goto L61
            r11.append(r7, r3)
            goto L7e
        L61:
            int r13 = r12 + 1
            java.lang.String[] r1 = org.apache.commons.codec.language.DoubleMetaphone.L_T_K_S_N_M_B_Z
            boolean r13 = contains(r10, r13, r8, r1)
            if (r13 != 0) goto L7e
            java.lang.String r13 = "K"
            java.lang.String r1 = "L"
            java.lang.String r2 = "S"
            java.lang.String[] r13 = new java.lang.String[]{r2, r13, r1}
            boolean r13 = contains(r10, r0, r8, r13)
            if (r13 != 0) goto L7e
            r11.append(r7)
        L7e:
            int r11 = r12 + 1
            char r10 = r9.charAt(r10, r11)
            if (r10 != r7) goto L89
            int r12 = r12 + 2
            return r12
        L89:
            return r11
        L8a:
            if (r12 != 0) goto L94
            int r13 = r12 + 4
            char r13 = r9.charAt(r10, r13)
            if (r13 == r3) goto La9
        L94:
            int r13 = r10.length()
            if (r13 == r2) goto La9
            java.lang.String[] r13 = new java.lang.String[]{r4}
            boolean r10 = contains(r10, r5, r2, r13)
            if (r10 == 0) goto La5
            goto La9
        La5:
            r11.append(r7, r6)
            goto Lac
        La9:
            r11.append(r6)
        Lac:
            int r12 = r12 + r8
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleJ(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        int i3 = i2 + 1;
        if (charAt(str, i3) != 'L') {
            doubleMetaphoneResult.append('L');
            return i3;
        }
        if (conditionL0(str, i2)) {
            doubleMetaphoneResult.appendPrimary('L');
        } else {
            doubleMetaphoneResult.append('L');
        }
        return i2 + 2;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        int i3 = i2 + 1;
        if (charAt(str, i3) == 'H') {
            doubleMetaphoneResult.append('F');
            return i2 + 2;
        }
        doubleMetaphoneResult.append('P');
        return contains(str, i3, 1, "P", "B") ? i2 + 2 : i3;
    }

    private int handleR(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2, boolean z) {
        if (i2 != str.length() - 1 || z || !contains(str, i2 - 2, 2, "IE") || contains(str, i2 - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.append('R');
        } else {
            doubleMetaphoneResult.appendAlternate('R');
        }
        int i3 = i2 + 1;
        return charAt(str, i3) == 'R' ? i2 + 2 : i3;
    }

    private int handleS(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2, boolean z) {
        if (contains(str, i2 - 1, 3, "ISL", "YSL")) {
            return i2 + 1;
        }
        if (i2 == 0 && contains(str, i2, 5, "SUGAR")) {
            doubleMetaphoneResult.append('X', 'S');
            return i2 + 1;
        }
        if (contains(str, i2, 2, "SH")) {
            if (contains(str, i2 + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                doubleMetaphoneResult.append('S');
            } else {
                doubleMetaphoneResult.append('X');
            }
            return i2 + 2;
        }
        if (contains(str, i2, 3, "SIO", "SIA") || contains(str, i2, 4, "SIAN")) {
            if (z) {
                doubleMetaphoneResult.append('S');
            } else {
                doubleMetaphoneResult.append('S', 'X');
            }
            return i2 + 3;
        }
        if (i2 != 0 || !contains(str, i2 + 1, 1, "M", "N", "L", "W")) {
            int i3 = i2 + 1;
            if (!contains(str, i3, 1, "Z")) {
                if (contains(str, i2, 2, "SC")) {
                    return handleSC(str, doubleMetaphoneResult, i2);
                }
                if (i2 == str.length() - 1 && contains(str, i2 - 2, 2, "AI", "OI")) {
                    doubleMetaphoneResult.appendAlternate('S');
                } else {
                    doubleMetaphoneResult.append('S');
                }
                return contains(str, i3, 1, "S", "Z") ? i2 + 2 : i3;
            }
        }
        doubleMetaphoneResult.append('S', 'X');
        int i4 = i2 + 1;
        return contains(str, i4, 1, "Z") ? i2 + 2 : i4;
    }

    private int handleSC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        int i3 = i2 + 2;
        if (charAt(str, i3) == 'H') {
            int i4 = i2 + 3;
            if (contains(str, i4, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str, i4, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append("X", "SK");
                } else {
                    doubleMetaphoneResult.append("SK");
                }
            } else if (i2 != 0 || isVowel(charAt(str, 3)) || charAt(str, 3) == 'W') {
                doubleMetaphoneResult.append('X');
            } else {
                doubleMetaphoneResult.append('X', 'S');
            }
        } else if (contains(str, i3, 1, "I", "E", "Y")) {
            doubleMetaphoneResult.append('S');
        } else {
            doubleMetaphoneResult.append("SK");
        }
        return i2 + 3;
    }

    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (contains(str, i2, 4, "TION") || contains(str, i2, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X');
            return i2 + 3;
        }
        if (!contains(str, i2, 2, "TH") && !contains(str, i2, 3, "TTH")) {
            doubleMetaphoneResult.append('T');
            int i3 = i2 + 1;
            return contains(str, i3, 1, "T", "D") ? i2 + 2 : i3;
        }
        int i4 = i2 + 2;
        if (contains(str, i4, 2, "OM", "AM") || contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH")) {
            doubleMetaphoneResult.append('T');
        } else {
            doubleMetaphoneResult.append('0', 'T');
        }
        return i4;
    }

    private int handleW(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (contains(str, i2, 2, "WR")) {
            doubleMetaphoneResult.append('R');
            return i2 + 2;
        }
        if (i2 == 0) {
            int i3 = i2 + 1;
            if (isVowel(charAt(str, i3)) || contains(str, i2, 2, "WH")) {
                if (isVowel(charAt(str, i3))) {
                    doubleMetaphoneResult.append('A', 'F');
                } else {
                    doubleMetaphoneResult.append('A');
                }
                return i3;
            }
        }
        if ((i2 == str.length() - 1 && isVowel(charAt(str, i2 - 1))) || contains(str, i2 - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || contains(str, 0, 3, "SCH")) {
            doubleMetaphoneResult.appendAlternate('F');
            return i2 + 1;
        }
        if (!contains(str, i2, 4, "WICZ", "WITZ")) {
            return i2 + 1;
        }
        doubleMetaphoneResult.append("TS", "FX");
        return i2 + 4;
    }

    private int handleX(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2) {
        if (i2 == 0) {
            doubleMetaphoneResult.append('S');
            return i2 + 1;
        }
        if (i2 != str.length() - 1 || (!contains(str, i2 - 3, 3, "IAU", "EAU") && !contains(str, i2 - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append("KS");
        }
        int i3 = i2 + 1;
        return contains(str, i3, 1, "C", "X") ? i2 + 2 : i3;
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i2, boolean z) {
        int i3 = i2 + 1;
        if (charAt(str, i3) == 'H') {
            doubleMetaphoneResult.append('J');
            return i2 + 2;
        }
        if (contains(str, i3, 2, "ZO", "ZI", "ZA") || (z && i2 > 0 && charAt(str, i2 - 1) != 'T')) {
            doubleMetaphoneResult.append("S", "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        return charAt(str, i3) == 'Z' ? i2 + 2 : i3;
    }

    private boolean isSilentStart(String str) {
        for (String str2 : SILENT_START) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSlavoGermanic(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char c2) {
        return VOWELS.indexOf(c2) != -1;
    }

    public char charAt(String str, int i2) {
        if (i2 < 0 || i2 >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i2);
    }

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public void setMaxCodeLen(int i2) {
        this.maxCodeLen = i2;
    }

    public class DoubleMetaphoneResult {
        private final StringBuilder alternate;
        private final int maxLength;
        private final StringBuilder primary;

        public DoubleMetaphoneResult(int i2) {
            this.primary = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.alternate = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.maxLength = i2;
        }

        public void append(char c2) {
            appendPrimary(c2);
            appendAlternate(c2);
        }

        public void appendAlternate(char c2) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c2);
            }
        }

        public void appendPrimary(char c2) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c2);
            }
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }

        public void append(char c2, char c3) {
            appendPrimary(c2);
            appendAlternate(c3);
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.apache.commons.codec.language.DoubleMetaphone] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    public String doubleMetaphone(String str, boolean z) {
        int i2;
        ?? CleanInput = cleanInput(str);
        if (CleanInput == 0) {
            return null;
        }
        boolean zIsSlavoGermanic = isSlavoGermanic(CleanInput);
        ?? IsSilentStart = isSilentStart(CleanInput);
        DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(getMaxCodeLen());
        while (!doubleMetaphoneResult.isComplete() && IsSilentStart <= CleanInput.length() - 1) {
            char cCharAt = CleanInput.charAt(IsSilentStart);
            if (cCharAt == 199) {
                doubleMetaphoneResult.append('S');
            } else if (cCharAt != 209) {
                switch (cCharAt) {
                    case 'A':
                    case 'E':
                    case WKSRecord.Service.NETRJS_3 /* 73 */:
                    case 'O':
                    case 'U':
                    case WKSRecord.Service.SU_MIT_TG /* 89 */:
                        IsSilentStart = handleAEIOUY(doubleMetaphoneResult, IsSilentStart);
                        break;
                    case WKSRecord.Protocol.RVD /* 66 */:
                        doubleMetaphoneResult.append('P');
                        i2 = IsSilentStart + 1;
                        if (charAt(CleanInput, i2) != 'B') {
                            IsSilentStart = i2;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'C':
                        IsSilentStart = handleC(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case WKSRecord.Service.BOOTPC /* 68 */:
                        IsSilentStart = handleD(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'F':
                        doubleMetaphoneResult.append('F');
                        i2 = IsSilentStart + 1;
                        if (charAt(CleanInput, i2) != 'F') {
                            IsSilentStart = i2;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'G':
                        IsSilentStart = handleG(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case WKSRecord.Service.NETRJS_2 /* 72 */:
                        IsSilentStart = handleH(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case WKSRecord.Service.NETRJS_4 /* 74 */:
                        IsSilentStart = handleJ(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'K':
                        doubleMetaphoneResult.append('K');
                        i2 = IsSilentStart + 1;
                        if (charAt(CleanInput, i2) != 'K') {
                            IsSilentStart = i2;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'L':
                        IsSilentStart = handleL(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'M':
                        doubleMetaphoneResult.append('M');
                        if (!conditionM0(CleanInput, IsSilentStart)) {
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'N':
                        doubleMetaphoneResult.append('N');
                        i2 = IsSilentStart + 1;
                        if (charAt(CleanInput, i2) != 'N') {
                            IsSilentStart = i2;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'P':
                        IsSilentStart = handleP(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case WKSRecord.Service.HOSTS2_NS /* 81 */:
                        doubleMetaphoneResult.append('K');
                        i2 = IsSilentStart + 1;
                        if (charAt(CleanInput, i2) != 'Q') {
                            IsSilentStart = i2;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'R':
                        IsSilentStart = handleR(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'S':
                        IsSilentStart = handleS(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'T':
                        IsSilentStart = handleT(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'V':
                        doubleMetaphoneResult.append('F');
                        i2 = IsSilentStart + 1;
                        if (charAt(CleanInput, i2) != 'V') {
                            IsSilentStart = i2;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'W':
                        IsSilentStart = handleW(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'X':
                        IsSilentStart = handleX(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'Z':
                        IsSilentStart = handleZ(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                }
            } else {
                doubleMetaphoneResult.append('N');
            }
            IsSilentStart++;
        }
        return z ? doubleMetaphoneResult.getAlternate() : doubleMetaphoneResult.getPrimary();
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        return org.apache.commons.codec.binary.StringUtils.equals(doubleMetaphone(str, z), doubleMetaphone(str2, z));
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return doubleMetaphone(str);
    }
}
