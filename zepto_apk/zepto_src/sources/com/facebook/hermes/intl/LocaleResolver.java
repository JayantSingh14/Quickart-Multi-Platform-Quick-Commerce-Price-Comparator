package com.facebook.hermes.intl;

import android.icu.util.ULocale;
import com.facebook.hermes.intl.JSObjects;
import com.facebook.hermes.intl.LocaleMatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class LocaleResolver {
    public static HashMap a(List list, HashMap map, List list2) throws JSRangeErrorException {
        LocaleMatcher.LocaleMatchResult localeMatchResultB;
        Object obj;
        HashMap map2 = new HashMap();
        if (((String) JSObjects.a("localeMatcher", map)).equals("lookup")) {
            String[] strArr = (String[]) list.toArray(new String[list.size()]);
            String[] strArrD = LocaleMatcher.d();
            localeMatchResultB = new LocaleMatcher.LocaleMatchResult();
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    localeMatchResultB.f17612a = new LocaleObjectICU(ULocale.getDefault(ULocale.Category.FORMAT));
                    break;
                }
                LocaleObjectICU localeObjectICUA = LocaleObject.a(strArr[i2]);
                localeObjectICUA.e();
                ULocale.Builder builder = new ULocale.Builder();
                builder.setLocale(localeObjectICUA.f17617a);
                builder.clearExtensions();
                String strA = LocaleMatcher.a(builder.build().toLanguageTag(), strArrD);
                if (!strA.isEmpty()) {
                    localeMatchResultB.f17612a = LocaleObject.a(strA);
                    localeMatchResultB.f17613b = localeObjectICUA.mo57a();
                    break;
                }
                i2++;
            }
        } else {
            localeMatchResultB = LocaleMatcher.b((String[]) list.toArray(new String[list.size()]));
        }
        HashSet hashSet = new HashSet();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj2 = JSObjects.f17605b;
            if (localeMatchResultB.f17613b.isEmpty() || !localeMatchResultB.f17613b.containsKey(str)) {
                obj = obj2;
            } else {
                String str2 = (String) localeMatchResultB.f17613b.get(str);
                boolean zIsEmpty = str2.isEmpty();
                String str3 = str2;
                if (zIsEmpty) {
                    str3 = "true";
                }
                hashSet.add(str);
                obj = str3;
            }
            Object obj3 = obj;
            if (map.containsKey(str)) {
                Object objA = JSObjects.a(str, map);
                boolean z = objA instanceof String;
                Object obj4 = objA;
                if (z) {
                    boolean zIsEmpty2 = ((String) objA).isEmpty();
                    obj4 = objA;
                    if (zIsEmpty2) {
                        obj4 = Boolean.TRUE;
                    }
                }
                obj3 = obj;
                if (!(obj4 instanceof JSObjects.UndefinedObject)) {
                    boolean zEquals = obj4.equals(obj);
                    obj3 = obj;
                    if (!zEquals) {
                        hashSet.remove(str);
                        obj3 = obj4;
                    }
                }
            }
            boolean z2 = obj3 instanceof JSObjects.NullObject;
            Object objC = obj3;
            if (!z2) {
                objC = UnicodeExtensionKeys.c(obj3, str);
            }
            if (!(objC instanceof String) || UnicodeExtensionKeys.a(str, (String) objC, localeMatchResultB.f17612a)) {
                map2.put(str, objC);
            } else {
                map2.put(str, obj2);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            String str4 = (String) it2.next();
            ArrayList arrayList = new ArrayList();
            String str5 = (String) UnicodeExtensionKeys.c((String) localeMatchResultB.f17613b.get(str4), str4);
            if (str5 == null || UnicodeExtensionKeys.a(str4, str5, localeMatchResultB.f17612a)) {
                arrayList.add(str5);
                localeMatchResultB.f17612a.c(str4, arrayList);
            }
        }
        map2.put("locale", localeMatchResultB.f17612a);
        return map2;
    }
}
