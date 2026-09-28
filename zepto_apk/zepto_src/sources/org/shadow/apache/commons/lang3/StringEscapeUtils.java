package org.shadow.apache.commons.lang3;

import org.shadow.apache.commons.lang3.text.translate.AggregateTranslator;
import org.shadow.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.shadow.apache.commons.lang3.text.translate.EntityArrays;
import org.shadow.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.shadow.apache.commons.lang3.text.translate.LookupTranslator;
import org.shadow.apache.commons.lang3.text.translate.NumericEntityEscaper;
import org.shadow.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.shadow.apache.commons.lang3.text.translate.OctalUnescaper;
import org.shadow.apache.commons.lang3.text.translate.UnicodeUnescaper;
import org.shadow.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;

/* loaded from: classes5.dex */
public class StringEscapeUtils {

    public static class CsvEscaper extends CharSequenceTranslator {
        static {
            String.valueOf('\"');
        }
    }

    public static class CsvUnescaper extends CharSequenceTranslator {
        static {
            String.valueOf('\"');
        }
    }

    static {
        LookupTranslator lookupTranslator = new LookupTranslator(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"});
        String[][] strArr = EntityArrays.f57793i;
        CharSequenceTranslator[] charSequenceTranslatorArr = {new LookupTranslator((String[][]) strArr.clone())};
        CharSequenceTranslator[] charSequenceTranslatorArr2 = new CharSequenceTranslator[2];
        charSequenceTranslatorArr2[0] = lookupTranslator;
        System.arraycopy(charSequenceTranslatorArr, 0, charSequenceTranslatorArr2, 1, 1);
        AggregateTranslator aggregateTranslator = new AggregateTranslator(charSequenceTranslatorArr2);
        CharSequenceTranslator[] charSequenceTranslatorArr3 = {new JavaUnicodeEscaper()};
        CharSequenceTranslator[] charSequenceTranslatorArr4 = new CharSequenceTranslator[2];
        charSequenceTranslatorArr4[0] = aggregateTranslator;
        System.arraycopy(charSequenceTranslatorArr3, 0, charSequenceTranslatorArr4, 1, 1);
        new AggregateTranslator(charSequenceTranslatorArr4);
        new AggregateTranslator(new LookupTranslator(new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new LookupTranslator((String[][]) strArr.clone()), new JavaUnicodeEscaper());
        new AggregateTranslator(new LookupTranslator(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new LookupTranslator((String[][]) strArr.clone()), new JavaUnicodeEscaper());
        String[][] strArr2 = EntityArrays.f57789e;
        LookupTranslator lookupTranslator2 = new LookupTranslator((String[][]) strArr2.clone());
        String[][] strArr3 = EntityArrays.f57791g;
        new AggregateTranslator(lookupTranslator2, new LookupTranslator((String[][]) strArr3.clone()));
        new AggregateTranslator(new LookupTranslator((String[][]) strArr2.clone()), new LookupTranslator((String[][]) strArr3.clone()), new LookupTranslator(new String[]{"\u0000", ""}, new String[]{"\u0001", ""}, new String[]{"\u0002", ""}, new String[]{"\u0003", ""}, new String[]{"\u0004", ""}, new String[]{"\u0005", ""}, new String[]{"\u0006", ""}, new String[]{"\u0007", ""}, new String[]{"\b", ""}, new String[]{"\u000b", ""}, new String[]{"\f", ""}, new String[]{"\u000e", ""}, new String[]{"\u000f", ""}, new String[]{"\u0010", ""}, new String[]{"\u0011", ""}, new String[]{"\u0012", ""}, new String[]{"\u0013", ""}, new String[]{"\u0014", ""}, new String[]{"\u0015", ""}, new String[]{"\u0016", ""}, new String[]{"\u0017", ""}, new String[]{"\u0018", ""}, new String[]{"\u0019", ""}, new String[]{"\u001a", ""}, new String[]{"\u001b", ""}, new String[]{"\u001c", ""}, new String[]{"\u001d", ""}, new String[]{"\u001e", ""}, new String[]{"\u001f", ""}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), new NumericEntityEscaper(), new NumericEntityEscaper(), new UnicodeUnpairedSurrogateRemover());
        new AggregateTranslator(new LookupTranslator((String[][]) strArr2.clone()), new LookupTranslator((String[][]) strArr3.clone()), new LookupTranslator(new String[]{"\u0000", ""}, new String[]{"\u000b", "&#11;"}, new String[]{"\f", "&#12;"}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), new NumericEntityEscaper(), new NumericEntityEscaper(), new NumericEntityEscaper(), new NumericEntityEscaper(), new UnicodeUnpairedSurrogateRemover());
        LookupTranslator lookupTranslator3 = new LookupTranslator((String[][]) strArr2.clone());
        String[][] strArr4 = EntityArrays.f57785a;
        new AggregateTranslator(lookupTranslator3, new LookupTranslator((String[][]) strArr4.clone()));
        new AggregateTranslator(new LookupTranslator((String[][]) strArr2.clone()), new LookupTranslator((String[][]) strArr4.clone()), new LookupTranslator((String[][]) EntityArrays.f57787c.clone()));
        new CsvEscaper();
        new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator((String[][]) EntityArrays.f57794j.clone()), new LookupTranslator(new String[]{"\\\\", "\\"}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{"\\", ""}));
        String[][] strArr5 = EntityArrays.f57790f;
        LookupTranslator lookupTranslator4 = new LookupTranslator((String[][]) strArr5.clone());
        String[][] strArr6 = EntityArrays.f57786b;
        new AggregateTranslator(lookupTranslator4, new LookupTranslator((String[][]) strArr6.clone()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        new AggregateTranslator(new LookupTranslator((String[][]) strArr5.clone()), new LookupTranslator((String[][]) strArr6.clone()), new LookupTranslator((String[][]) EntityArrays.f57788d.clone()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        new AggregateTranslator(new LookupTranslator((String[][]) strArr5.clone()), new LookupTranslator((String[][]) EntityArrays.f57792h.clone()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        new CsvUnescaper();
    }
}
