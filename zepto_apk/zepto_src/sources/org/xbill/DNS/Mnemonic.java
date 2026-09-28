package org.xbill.DNS;

import com.google.android.gms.common.api.Api;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
class Mnemonic {
    static final int CASE_LOWER = 3;
    static final int CASE_SENSITIVE = 1;
    static final int CASE_UPPER = 2;
    private final String description;
    private boolean numericok;
    private String prefix;
    private final int wordcase;
    private final HashMap<String, Integer> strings = new HashMap<>();
    private final HashMap<Integer, String> values = new HashMap<>();
    private int max = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public Mnemonic(String str, int i2) {
        this.description = str;
        this.wordcase = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$remove$0(int i2, Map.Entry entry) {
        return ((Integer) entry.getValue()).intValue() == i2;
    }

    private int parseNumeric(String str) throws NumberFormatException {
        try {
            int i2 = Integer.parseInt(str);
            if (i2 < 0) {
                return -1;
            }
            if (i2 <= this.max) {
                return i2;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private String sanitize(String str) {
        int i2 = this.wordcase;
        return i2 == 2 ? str.toUpperCase() : i2 == 3 ? str.toLowerCase() : str;
    }

    public void add(int i2, String str) {
        check(i2);
        String strSanitize = sanitize(str);
        this.strings.put(strSanitize, Integer.valueOf(i2));
        this.values.put(Integer.valueOf(i2), strSanitize);
    }

    public void addAlias(int i2, String str) {
        check(i2);
        this.strings.put(sanitize(str), Integer.valueOf(i2));
    }

    public void addAll(Mnemonic mnemonic) {
        if (this.wordcase != mnemonic.wordcase) {
            throw new IllegalArgumentException(android.support.v4.media.b.r(new StringBuilder(), mnemonic.description, ": wordcases do not match"));
        }
        this.strings.putAll(mnemonic.strings);
        this.values.putAll(mnemonic.values);
    }

    public void check(int i2) {
        if (i2 < 0 || i2 > this.max) {
            throw new IllegalArgumentException(this.description + StringUtils.SPACE + i2 + " is out of range");
        }
    }

    public String getText(int i2) {
        check(i2);
        String str = this.values.get(Integer.valueOf(i2));
        if (str != null) {
            return str;
        }
        String string = Integer.toString(i2);
        return this.prefix != null ? android.support.v4.media.b.r(new StringBuilder(), this.prefix, string) : string;
    }

    public int getValue(String str) {
        int numeric;
        String strSanitize = sanitize(str);
        Integer num = this.strings.get(strSanitize);
        if (num != null) {
            return num.intValue();
        }
        String str2 = this.prefix;
        if (str2 != null && strSanitize.startsWith(str2) && (numeric = parseNumeric(strSanitize.substring(this.prefix.length()))) >= 0) {
            return numeric;
        }
        if (this.numericok) {
            return parseNumeric(strSanitize);
        }
        return -1;
    }

    public void remove(final int i2) {
        this.values.remove(Integer.valueOf(i2));
        this.strings.entrySet().removeIf(new Predicate() { // from class: org.xbill.DNS.r
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Mnemonic.lambda$remove$0(i2, (Map.Entry) obj);
            }
        });
    }

    public void removeAlias(String str) {
        this.strings.remove(sanitize(str));
    }

    public void setMaximum(int i2) {
        this.max = i2;
    }

    public void setNumericAllowed(boolean z) {
        this.numericok = z;
    }

    public void setPrefix(String str) {
        this.prefix = sanitize(str);
    }
}
