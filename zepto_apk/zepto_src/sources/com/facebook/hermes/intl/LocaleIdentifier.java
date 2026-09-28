package com.facebook.hermes.intl;

import android.support.v4.media.b;
import com.facebook.hermes.intl.LocaleIdTokenizer;
import java.util.ArrayList;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class LocaleIdentifier {
    public static boolean a(String str, LocaleIdTokenizer localeIdTokenizer, LocaleIdTokenizer.LocaleIdSubtag localeIdSubtag, boolean z, ParsedLocaleIdentifier parsedLocaleIdentifier) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (z && localeIdSubtag.a()) {
            d(localeIdSubtag, localeIdTokenizer, parsedLocaleIdentifier, str);
            return true;
        }
        if (!IntlTextUtils.c(localeIdSubtag.f17610b, localeIdSubtag.f17611c, localeIdSubtag.f17609a, 1, 1)) {
            return false;
        }
        if (z) {
            throw new JSRangeErrorException(b.C("Extension singletons in transformed extension language tag: ", str));
        }
        b(localeIdSubtag, localeIdTokenizer, parsedLocaleIdentifier, str);
        return true;
    }

    public static void b(LocaleIdTokenizer.LocaleIdSubtag localeIdSubtag, LocaleIdTokenizer localeIdTokenizer, ParsedLocaleIdentifier parsedLocaleIdentifier, String str) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (!localeIdTokenizer.a()) {
            throw new JSRangeErrorException("Extension sequence expected.");
        }
        char cCharAt = localeIdSubtag.toString().charAt(0);
        if (cCharAt == 'u') {
            if (!localeIdTokenizer.a()) {
                throw new JSRangeErrorException("Extension sequence expected.");
            }
            LocaleIdTokenizer.LocaleIdSubtag localeIdSubtagB = localeIdTokenizer.b();
            if (parsedLocaleIdentifier.f17637b != null || parsedLocaleIdentifier.f17638c != null) {
                throw new JSRangeErrorException(b.D("Duplicate unicode extension sequence in [", str, "]"));
            }
            while (IntlTextUtils.c(localeIdSubtagB.f17610b, localeIdSubtagB.f17611c, localeIdSubtagB.f17609a, 3, 8)) {
                if (parsedLocaleIdentifier.f17637b == null) {
                    parsedLocaleIdentifier.f17637b = new ArrayList();
                }
                parsedLocaleIdentifier.f17637b.add(localeIdSubtagB.toString());
                if (!localeIdTokenizer.a()) {
                    return;
                } else {
                    localeIdSubtagB = localeIdTokenizer.b();
                }
            }
            if (localeIdSubtagB.b()) {
                if (parsedLocaleIdentifier.f17638c == null) {
                    parsedLocaleIdentifier.f17638c = new TreeMap();
                }
                do {
                    String string = localeIdSubtagB.toString();
                    ArrayList arrayList = new ArrayList();
                    parsedLocaleIdentifier.f17638c.put(string, arrayList);
                    if (!localeIdTokenizer.a()) {
                        return;
                    }
                    localeIdSubtagB = localeIdTokenizer.b();
                    while (IntlTextUtils.c(localeIdSubtagB.f17610b, localeIdSubtagB.f17611c, localeIdSubtagB.f17609a, 3, 8)) {
                        arrayList.add(localeIdSubtagB.toString());
                        if (!localeIdTokenizer.a()) {
                            return;
                        } else {
                            localeIdSubtagB = localeIdTokenizer.b();
                        }
                    }
                } while (localeIdSubtagB.b());
            }
            if (!IntlTextUtils.c(localeIdSubtagB.f17610b, localeIdSubtagB.f17611c, localeIdSubtagB.f17609a, 1, 1)) {
                throw new JSRangeErrorException("Malformed sequence expected.");
            }
            b(localeIdSubtagB, localeIdTokenizer, parsedLocaleIdentifier, str);
            return;
        }
        if (cCharAt == 't') {
            if (!localeIdTokenizer.a()) {
                throw new JSRangeErrorException("Extension sequence expected.");
            }
            LocaleIdTokenizer.LocaleIdSubtag localeIdSubtagB2 = localeIdTokenizer.b();
            if (localeIdSubtagB2.c()) {
                c(str, localeIdTokenizer, localeIdSubtagB2, true, parsedLocaleIdentifier);
                return;
            } else {
                if (!localeIdSubtagB2.a()) {
                    throw new JSRangeErrorException(b.m("Unexpected token [", localeIdSubtagB2.toString(), "] in transformed extension sequence [", str, "]"));
                }
                d(localeIdSubtagB2, localeIdTokenizer, parsedLocaleIdentifier, str);
                return;
            }
        }
        if (cCharAt == 'x') {
            if (!localeIdTokenizer.a()) {
                throw new JSRangeErrorException("Extension sequence expected.");
            }
            LocaleIdTokenizer.LocaleIdSubtag localeIdSubtagB3 = localeIdTokenizer.b();
            if (parsedLocaleIdentifier.f17642g == null) {
                parsedLocaleIdentifier.f17642g = new ArrayList();
            }
            while (IntlTextUtils.c(localeIdSubtagB3.f17610b, localeIdSubtagB3.f17611c, localeIdSubtagB3.f17609a, 1, 8)) {
                parsedLocaleIdentifier.f17642g.add(localeIdSubtagB3.toString());
                if (!localeIdTokenizer.a()) {
                    return;
                } else {
                    localeIdSubtagB3 = localeIdTokenizer.b();
                }
            }
            throw new JSRangeErrorException("Tokens are not expected after pu extension.");
        }
        if (!localeIdTokenizer.a()) {
            throw new JSRangeErrorException("Extension sequence expected.");
        }
        LocaleIdTokenizer.LocaleIdSubtag localeIdSubtagB4 = localeIdTokenizer.b();
        if (parsedLocaleIdentifier.f17641f == null) {
            parsedLocaleIdentifier.f17641f = new TreeMap();
        }
        ArrayList arrayList2 = new ArrayList();
        parsedLocaleIdentifier.f17641f.put(Character.valueOf(cCharAt), arrayList2);
        while (IntlTextUtils.c(localeIdSubtagB4.f17610b, localeIdSubtagB4.f17611c, localeIdSubtagB4.f17609a, 2, 8)) {
            arrayList2.add(localeIdSubtagB4.toString());
            if (!localeIdTokenizer.a()) {
                return;
            } else {
                localeIdSubtagB4 = localeIdTokenizer.b();
            }
        }
        if (!IntlTextUtils.c(localeIdSubtagB4.f17610b, localeIdSubtagB4.f17611c, localeIdSubtagB4.f17609a, 1, 1)) {
            throw new JSRangeErrorException("Malformed sequence expected.");
        }
        b(localeIdSubtagB4, localeIdTokenizer, parsedLocaleIdentifier, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c9 A[Catch: LocaleIdSubtagIterationFailed -> 0x018f, LOOP:4: B:53:0x00c7->B:54:0x00c9, LOOP_END, TryCatch #0 {LocaleIdSubtagIterationFailed -> 0x018f, blocks: (B:6:0x000e, B:8:0x0014, B:9:0x001b, B:11:0x001f, B:12:0x002f, B:15:0x003d, B:17:0x0047, B:20:0x004f, B:22:0x0056, B:25:0x0060, B:27:0x0077, B:26:0x006c, B:28:0x007a, B:31:0x0088, B:32:0x008c, B:34:0x009b, B:59:0x00e9, B:62:0x00f1, B:64:0x0100, B:66:0x0105, B:68:0x010f, B:71:0x0118, B:72:0x013a, B:73:0x013b, B:75:0x0143, B:77:0x0149, B:81:0x0164, B:84:0x016b, B:78:0x0152, B:79:0x0159, B:80:0x015a, B:37:0x00a2, B:43:0x00ad, B:51:0x00bf, B:52:0x00c2, B:54:0x00c9, B:55:0x00d7, B:58:0x00e5, B:85:0x0171, B:86:0x018e), top: B:89:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5 A[Catch: LocaleIdSubtagIterationFailed -> 0x018f, TryCatch #0 {LocaleIdSubtagIterationFailed -> 0x018f, blocks: (B:6:0x000e, B:8:0x0014, B:9:0x001b, B:11:0x001f, B:12:0x002f, B:15:0x003d, B:17:0x0047, B:20:0x004f, B:22:0x0056, B:25:0x0060, B:27:0x0077, B:26:0x006c, B:28:0x007a, B:31:0x0088, B:32:0x008c, B:34:0x009b, B:59:0x00e9, B:62:0x00f1, B:64:0x0100, B:66:0x0105, B:68:0x010f, B:71:0x0118, B:72:0x013a, B:73:0x013b, B:75:0x0143, B:77:0x0149, B:81:0x0164, B:84:0x016b, B:78:0x0152, B:79:0x0159, B:80:0x015a, B:37:0x00a2, B:43:0x00ad, B:51:0x00bf, B:52:0x00c2, B:54:0x00c9, B:55:0x00d7, B:58:0x00e5, B:85:0x0171, B:86:0x018e), top: B:89:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(java.lang.String r10, com.facebook.hermes.intl.LocaleIdTokenizer r11, com.facebook.hermes.intl.LocaleIdTokenizer.LocaleIdSubtag r12, boolean r13, com.facebook.hermes.intl.ParsedLocaleIdentifier r14) throws com.facebook.hermes.intl.JSRangeErrorException {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.LocaleIdentifier.c(java.lang.String, com.facebook.hermes.intl.LocaleIdTokenizer, com.facebook.hermes.intl.LocaleIdTokenizer$LocaleIdSubtag, boolean, com.facebook.hermes.intl.ParsedLocaleIdentifier):void");
    }

    public static void d(LocaleIdTokenizer.LocaleIdSubtag localeIdSubtag, LocaleIdTokenizer localeIdTokenizer, ParsedLocaleIdentifier parsedLocaleIdentifier, String str) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (localeIdSubtag.a()) {
            TreeMap treeMap = parsedLocaleIdentifier.f17640e;
            if (treeMap != null) {
                throw new JSRangeErrorException(b.D("Duplicate transformed extension sequence in [", str, "]"));
            }
            if (treeMap == null) {
                parsedLocaleIdentifier.f17640e = new TreeMap();
            }
            do {
                String string = localeIdSubtag.toString();
                ArrayList arrayList = new ArrayList();
                parsedLocaleIdentifier.f17640e.put(string, arrayList);
                if (!localeIdTokenizer.a()) {
                    throw new JSRangeErrorException(b.C("Malformated transformed key in : ", str));
                }
                localeIdSubtag = localeIdTokenizer.b();
                while (IntlTextUtils.c(localeIdSubtag.f17610b, localeIdSubtag.f17611c, localeIdSubtag.f17609a, 3, 8)) {
                    arrayList.add(localeIdSubtag.toString());
                    if (!localeIdTokenizer.a()) {
                        return;
                    } else {
                        localeIdSubtag = localeIdTokenizer.b();
                    }
                }
            } while (localeIdSubtag.a());
        }
        if (!IntlTextUtils.c(localeIdSubtag.f17610b, localeIdSubtag.f17611c, localeIdSubtag.f17609a, 1, 1)) {
            throw new JSRangeErrorException("Malformed extension sequence.");
        }
        b(localeIdSubtag, localeIdTokenizer, parsedLocaleIdentifier, str);
    }
}
