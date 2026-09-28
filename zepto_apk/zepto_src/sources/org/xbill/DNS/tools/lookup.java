package org.xbill.DNS.tools;

import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

/* loaded from: classes5.dex */
public class lookup {
    public static void main(String[] strArr) throws Exception {
        int iValue = 1;
        int i2 = 0;
        if (strArr.length > 2 && strArr[0].equals("-t")) {
            iValue = Type.value(strArr[1]);
            if (iValue < 0) {
                throw new IllegalArgumentException("invalid type");
            }
            i2 = 2;
        }
        while (i2 < strArr.length) {
            Lookup lookup = new Lookup(strArr[i2], iValue);
            lookup.run();
            printAnswer(strArr[i2], lookup);
            i2++;
        }
    }

    public static void printAnswer(String str, Lookup lookup) {
        System.out.print(str + ":");
        if (lookup.getResult() != 0) {
            System.out.print(StringUtils.SPACE + lookup.getErrorString());
        }
        System.out.println();
        Name[] aliases = lookup.getAliases();
        if (aliases.length > 0) {
            System.out.print("# aliases: ");
            for (int i2 = 0; i2 < aliases.length; i2++) {
                System.out.print(aliases[i2]);
                if (i2 < aliases.length - 1) {
                    System.out.print(StringUtils.SPACE);
                }
            }
            System.out.println();
        }
        if (lookup.getResult() == 0) {
            for (Record record : lookup.getAnswers()) {
                System.out.println(record);
            }
        }
    }
}
