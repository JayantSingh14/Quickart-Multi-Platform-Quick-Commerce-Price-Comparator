package com.facebook.hermes.intl;

import android.support.v4.media.b;
import android.text.TextUtils;
import com.facebook.hermes.intl.LocaleIdTokenizer;
import com.facebook.hermes.intl.ParsedLocaleIdentifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class LocaleObjectAndroid implements ILocaleObject<Locale> {

    /* renamed from: a, reason: collision with root package name */
    public Locale f17614a;

    /* renamed from: b, reason: collision with root package name */
    public ParsedLocaleIdentifier f17615b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17616c;

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final ArrayList a() throws JSRangeErrorException {
        ArrayList arrayList;
        e();
        if (this.f17615b == null) {
            String lowerCase = this.f17614a.toLanguageTag().toLowerCase();
            LocaleIdTokenizer localeIdTokenizer = new LocaleIdTokenizer();
            localeIdTokenizer.f17607b = 0;
            localeIdTokenizer.f17608c = -1;
            localeIdTokenizer.f17606a = lowerCase;
            ParsedLocaleIdentifier parsedLocaleIdentifier = new ParsedLocaleIdentifier();
            try {
                if (!localeIdTokenizer.a()) {
                    throw new JSRangeErrorException("Language subtag not found: " + lowerCase);
                }
                LocaleIdentifier.c(lowerCase, localeIdTokenizer, localeIdTokenizer.b(), false, parsedLocaleIdentifier);
                this.f17615b = parsedLocaleIdentifier;
            } catch (LocaleIdTokenizer.LocaleIdSubtagIterationFailed unused) {
                throw new JSRangeErrorException(b.C("Locale Identifier subtag iteration failed: ", lowerCase));
            }
        }
        TreeMap treeMap = this.f17615b.f17638c;
        return (treeMap == null || (arrayList = (ArrayList) treeMap.get("collation")) == null) ? new ArrayList() : arrayList;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final ILocaleObject b() throws JSRangeErrorException {
        e();
        Locale locale = this.f17614a;
        LocaleObjectAndroid localeObjectAndroid = new LocaleObjectAndroid();
        localeObjectAndroid.f17615b = null;
        localeObjectAndroid.f17616c = false;
        localeObjectAndroid.f17614a = locale;
        return localeObjectAndroid;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final void c(String str, ArrayList arrayList) throws JSRangeErrorException {
        e();
        if (this.f17615b == null) {
            String lowerCase = this.f17614a.toLanguageTag().toLowerCase();
            LocaleIdTokenizer localeIdTokenizer = new LocaleIdTokenizer();
            localeIdTokenizer.f17607b = 0;
            localeIdTokenizer.f17608c = -1;
            localeIdTokenizer.f17606a = lowerCase;
            ParsedLocaleIdentifier parsedLocaleIdentifier = new ParsedLocaleIdentifier();
            try {
                if (!localeIdTokenizer.a()) {
                    throw new JSRangeErrorException("Language subtag not found: " + lowerCase);
                }
                LocaleIdentifier.c(lowerCase, localeIdTokenizer, localeIdTokenizer.b(), false, parsedLocaleIdentifier);
                this.f17615b = parsedLocaleIdentifier;
            } catch (LocaleIdTokenizer.LocaleIdSubtagIterationFailed unused) {
                throw new JSRangeErrorException(b.C("Locale Identifier subtag iteration failed: ", lowerCase));
            }
        }
        ParsedLocaleIdentifier parsedLocaleIdentifier2 = this.f17615b;
        if (parsedLocaleIdentifier2.f17638c == null) {
            parsedLocaleIdentifier2.f17638c = new TreeMap();
        }
        if (!this.f17615b.f17638c.containsKey(str)) {
            this.f17615b.f17638c.put(str, new ArrayList());
        }
        ((ArrayList) this.f17615b.f17638c.get(str)).clear();
        ((ArrayList) this.f17615b.f17638c.get(str)).addAll(arrayList);
        this.f17616c = true;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final String d() throws JSRangeErrorException {
        e();
        return this.f17614a.toLanguageTag();
    }

    public final void e() throws JSRangeErrorException {
        if (this.f17616c) {
            try {
                f();
                this.f17616c = false;
            } catch (RuntimeException e2) {
                throw new JSRangeErrorException(e2.getMessage());
            }
        }
    }

    public final void f() throws JSRangeErrorException {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();
        String str = this.f17615b.f17636a.f17643a;
        if (str != null && !str.isEmpty()) {
            stringBuffer2.append(this.f17615b.f17636a.f17643a);
        }
        String str2 = this.f17615b.f17636a.f17644b;
        if (str2 != null && !str2.isEmpty()) {
            stringBuffer3.append(this.f17615b.f17636a.f17644b);
        }
        String str3 = this.f17615b.f17636a.f17645c;
        if (str3 != null && !str3.isEmpty()) {
            stringBuffer4.append(this.f17615b.f17636a.f17645c);
        }
        if (stringBuffer2.length() > 0) {
            stringBuffer.append(stringBuffer2.toString());
        }
        if (stringBuffer3.length() > 0) {
            stringBuffer.append("-");
            stringBuffer.append(stringBuffer3.toString());
        }
        if (stringBuffer4.length() > 0) {
            stringBuffer.append("-");
            stringBuffer.append(stringBuffer4.toString());
        }
        ArrayList arrayList = this.f17615b.f17636a.f17646d;
        if (arrayList != null && !arrayList.isEmpty()) {
            stringBuffer.append("-");
            stringBuffer.append(TextUtils.join("-", this.f17615b.f17636a.f17646d));
        }
        TreeMap treeMap = this.f17615b.f17641f;
        if (treeMap != null) {
            for (Map.Entry entry : treeMap.entrySet()) {
                stringBuffer.append("-");
                stringBuffer.append(entry.getKey());
                stringBuffer.append("-");
                stringBuffer.append(TextUtils.join("-", (Iterable) entry.getValue()));
            }
        }
        ParsedLocaleIdentifier parsedLocaleIdentifier = this.f17615b;
        if (parsedLocaleIdentifier.f17639d != null || parsedLocaleIdentifier.f17640e != null) {
            stringBuffer.append("-t-");
            StringBuffer stringBuffer5 = new StringBuffer();
            ParsedLocaleIdentifier.ParsedLanguageIdentifier parsedLanguageIdentifier = this.f17615b.f17639d;
            if (parsedLanguageIdentifier != null) {
                stringBuffer5.append(parsedLanguageIdentifier.f17643a);
                if (this.f17615b.f17639d.f17644b != null) {
                    stringBuffer5.append("-");
                    stringBuffer5.append(this.f17615b.f17639d.f17644b);
                }
                if (this.f17615b.f17639d.f17645c != null) {
                    stringBuffer5.append("-");
                    stringBuffer5.append(this.f17615b.f17639d.f17645c);
                }
                ArrayList arrayList2 = this.f17615b.f17639d.f17646d;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    stringBuffer5.append("-");
                    stringBuffer5.append(TextUtils.join("-", this.f17615b.f17639d.f17646d));
                }
            }
            TreeMap treeMap2 = this.f17615b.f17640e;
            if (treeMap2 != null) {
                for (Map.Entry entry2 : treeMap2.entrySet()) {
                    String str4 = (String) entry2.getKey();
                    ArrayList arrayList3 = (ArrayList) entry2.getValue();
                    stringBuffer5.append("-" + str4);
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        stringBuffer5.append("-" + ((String) it.next()));
                    }
                }
                if (stringBuffer5.length() > 0 && stringBuffer5.charAt(0) == '-') {
                    stringBuffer5.deleteCharAt(0);
                }
            }
            stringBuffer.append(stringBuffer5.toString());
        }
        ParsedLocaleIdentifier parsedLocaleIdentifier2 = this.f17615b;
        if (parsedLocaleIdentifier2.f17637b != null || parsedLocaleIdentifier2.f17638c != null) {
            stringBuffer.append("-u-");
            StringBuffer stringBuffer6 = new StringBuffer();
            ArrayList arrayList4 = this.f17615b.f17637b;
            if (arrayList4 != null) {
                stringBuffer6.append(TextUtils.join("-", arrayList4));
            }
            TreeMap treeMap3 = this.f17615b.f17638c;
            if (treeMap3 != null) {
                for (Map.Entry entry3 : treeMap3.entrySet()) {
                    String str5 = (String) entry3.getKey();
                    ArrayList arrayList5 = (ArrayList) entry3.getValue();
                    stringBuffer6.append("-" + str5);
                    Iterator it2 = arrayList5.iterator();
                    while (it2.hasNext()) {
                        stringBuffer6.append("-" + ((String) it2.next()));
                    }
                }
            }
            if (stringBuffer6.length() > 0 && stringBuffer6.charAt(0) == '-') {
                stringBuffer6.deleteCharAt(0);
            }
            stringBuffer.append(stringBuffer6.toString());
        }
        if (this.f17615b.f17642g != null) {
            stringBuffer.append("-x-");
            stringBuffer.append(TextUtils.join("-", this.f17615b.f17642g));
        }
        try {
            this.f17614a = Locale.forLanguageTag(stringBuffer.toString());
            this.f17616c = false;
        } catch (RuntimeException e2) {
            throw new JSRangeErrorException(e2.getMessage());
        }
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final Object getLocale() throws JSRangeErrorException {
        e();
        return this.f17614a;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    /* renamed from: a */
    public final HashMap mo57a() {
        HashMap map = new HashMap();
        TreeMap treeMap = this.f17615b.f17638c;
        if (treeMap != null) {
            for (String str : treeMap.keySet()) {
                map.put(str, TextUtils.join("-", (ArrayList) this.f17615b.f17638c.get(str)));
            }
        }
        return map;
    }
}
