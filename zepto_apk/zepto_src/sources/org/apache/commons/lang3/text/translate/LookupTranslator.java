package org.apache.commons.lang3.text.translate;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

@Deprecated
/* loaded from: classes5.dex */
public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final HashMap<String, String> lookupMap = new HashMap<>();
    private final HashSet<Character> prefixSet = new HashSet<>();
    private final int shortest;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i3 = 0;
        if (charSequenceArr != null) {
            int i4 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.lookupMap.put(charSequenceArr2[0].toString(), charSequenceArr2[1].toString());
                this.prefixSet.add(Character.valueOf(charSequenceArr2[0].charAt(0)));
                int length = charSequenceArr2[0].length();
                i2 = length < i2 ? length : i2;
                if (length > i4) {
                    i4 = length;
                }
            }
            i3 = i4;
        }
        this.shortest = i2;
        this.longest = i3;
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        if (!this.prefixSet.contains(Character.valueOf(charSequence.charAt(i2)))) {
            return 0;
        }
        int length = this.longest;
        if (i2 + length > charSequence.length()) {
            length = charSequence.length() - i2;
        }
        while (length >= this.shortest) {
            String str = this.lookupMap.get(charSequence.subSequence(i2, i2 + length).toString());
            if (str != null) {
                writer.write(str);
                return length;
            }
            length--;
        }
        return 0;
    }
}
