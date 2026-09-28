package com.facebook.hermes.intl;

import android.icu.util.ULocale;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class LocaleObjectICU implements ILocaleObject<ULocale> {

    /* renamed from: a, reason: collision with root package name */
    public ULocale f17617a;

    /* renamed from: b, reason: collision with root package name */
    public ULocale.Builder f17618b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17619c = false;

    public LocaleObjectICU(ULocale uLocale) {
        this.f17617a = uLocale;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final ArrayList a() throws JSRangeErrorException {
        e();
        HashMap map = UnicodeExtensionKeys.f17661a;
        String str = map.containsKey("collation") ? (String) map.get("collation") : "collation";
        ArrayList arrayList = new ArrayList();
        String keywordValue = this.f17617a.getKeywordValue(str);
        if (keywordValue != null && !keywordValue.isEmpty()) {
            Collections.addAll(arrayList, keywordValue.split("-|_"));
        }
        return arrayList;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final ILocaleObject b() throws JSRangeErrorException {
        e();
        return new LocaleObjectICU(this.f17617a);
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final void c(String str, ArrayList arrayList) throws JSRangeErrorException {
        e();
        if (this.f17618b == null) {
            this.f17618b = new ULocale.Builder().setLocale(this.f17617a);
        }
        try {
            this.f17618b.setUnicodeLocaleKeyword(str, TextUtils.join("-", arrayList));
            this.f17619c = true;
        } catch (RuntimeException e2) {
            throw new JSRangeErrorException(e2.getMessage());
        }
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final String d() throws JSRangeErrorException {
        e();
        return this.f17617a.toLanguageTag();
    }

    public final void e() throws JSRangeErrorException {
        if (this.f17619c) {
            try {
                this.f17617a = this.f17618b.build();
                this.f17619c = false;
            } catch (RuntimeException e2) {
                throw new JSRangeErrorException(e2.getMessage());
            }
        }
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public final Object getLocale() throws JSRangeErrorException {
        e();
        return this.f17617a;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    /* renamed from: a */
    public final HashMap mo57a() throws JSRangeErrorException {
        e();
        HashMap map = new HashMap();
        Iterator<String> keywords = this.f17617a.getKeywords();
        if (keywords != null) {
            while (keywords.hasNext()) {
                String next = keywords.next();
                HashMap map2 = UnicodeExtensionKeys.f17662b;
                map.put(map2.containsKey(next) ? (String) map2.get(next) : next, this.f17617a.getKeywordValue(next));
            }
        }
        return map;
    }
}
