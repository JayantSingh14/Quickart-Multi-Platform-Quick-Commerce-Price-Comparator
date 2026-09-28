package com.google.common.xml;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escapers;
import java.util.HashMap;
import org.apache.commons.lang3.CharUtils;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public class XmlEscapers {
    static {
        Escapers.Builder builder = new Escapers.Builder();
        builder.f43175b = (char) 65533;
        builder.f43176c = "�";
        char c2 = 0;
        while (true) {
            HashMap map = builder.f43174a;
            if (c2 > 31) {
                map.put('&', "&amp;");
                map.put('<', "&lt;");
                map.put('>', "&gt;");
                builder.a();
                map.put('\'', "&apos;");
                map.put('\"', "&quot;");
                builder.a();
                map.put('\t', "&#x9;");
                map.put('\n', "&#xA;");
                map.put(Character.valueOf(CharUtils.CR), "&#xD;");
                builder.a();
                return;
            }
            if (c2 != '\t' && c2 != '\n' && c2 != '\r') {
                map.put(Character.valueOf(c2), "�");
            }
            c2 = (char) (c2 + 1);
        }
    }
}
