package com.facebook.hermes.intl;

import android.icu.text.RuleBasedCollator;
import com.facebook.hermes.intl.IPlatformCollator;
import com.facebook.hermes.intl.JSObjects;
import com.facebook.hermes.intl.OptionHelpers;
import com.facebook.proguard.annotations.DoNotStrip;
import in.juspay.hypersdk.analytics.LogConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@DoNotStrip
/* loaded from: classes3.dex */
public class Collator {

    /* renamed from: a, reason: collision with root package name */
    public final IPlatformCollator.Usage f17492a;

    /* renamed from: b, reason: collision with root package name */
    public final IPlatformCollator.Sensitivity f17493b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17494c;

    /* renamed from: d, reason: collision with root package name */
    public final String f17495d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f17496e;

    /* renamed from: f, reason: collision with root package name */
    public final IPlatformCollator.CaseFirst f17497f;

    /* renamed from: g, reason: collision with root package name */
    public final ILocaleObject f17498g;

    /* renamed from: h, reason: collision with root package name */
    public final ILocaleObject f17499h;

    /* renamed from: i, reason: collision with root package name */
    public final PlatformCollatorICU f17500i;

    @DoNotStrip
    public Collator(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        Object obj = LogConstants.DEFAULT_CHANNEL;
        this.f17495d = LogConstants.DEFAULT_CHANNEL;
        PlatformCollatorICU platformCollatorICU = new PlatformCollatorICU();
        platformCollatorICU.f17648a = null;
        this.f17500i = platformCollatorICU;
        OptionHelpers.OptionType optionType = OptionHelpers.OptionType.f17634b;
        this.f17492a = (IPlatformCollator.Usage) OptionHelpers.c(IPlatformCollator.Usage.class, (String) OptionHelpers.b(map, "usage", optionType, Constants.f17504d, "sort"));
        HashMap map2 = new HashMap();
        map2.put("localeMatcher", OptionHelpers.b(map, "localeMatcher", optionType, Constants.f17501a, "best fit"));
        OptionHelpers.OptionType optionType2 = OptionHelpers.OptionType.f17633a;
        Object obj2 = JSObjects.f17604a;
        Object objB = OptionHelpers.b(map, "numeric", optionType2, obj2, obj2);
        map2.put("kn", objB instanceof JSObjects.UndefinedObject ? objB : String.valueOf(((Boolean) objB).booleanValue()));
        map2.put("kf", OptionHelpers.b(map, "caseFirst", optionType, Constants.f17503c, obj2));
        HashMap mapA = LocaleResolver.a(list, map2, Arrays.asList("co", "kf", "kn"));
        ILocaleObject iLocaleObject = (ILocaleObject) mapA.get("locale");
        this.f17498g = iLocaleObject;
        this.f17499h = iLocaleObject.b();
        Object objA = JSObjects.a("co", mapA);
        this.f17495d = (String) (objA instanceof JSObjects.NullObject ? obj : objA);
        Object objA2 = JSObjects.a("kn", mapA);
        if (objA2 instanceof JSObjects.NullObject) {
            this.f17496e = false;
        } else {
            this.f17496e = Boolean.parseBoolean((String) objA2);
        }
        String strA = JSObjects.a("kf", mapA);
        this.f17497f = (IPlatformCollator.CaseFirst) OptionHelpers.c(IPlatformCollator.CaseFirst.class, (String) (strA instanceof JSObjects.NullObject ? "false" : strA));
        if (this.f17492a == IPlatformCollator.Usage.f17529b) {
            ArrayList arrayListA = this.f17498g.a();
            ArrayList arrayList = new ArrayList();
            Iterator it = arrayListA.iterator();
            while (it.hasNext()) {
                arrayList.add(UnicodeExtensionKeys.b((String) it.next()));
            }
            arrayList.add(UnicodeExtensionKeys.b("search"));
            this.f17498g.c("co", arrayList);
        }
        Object objB2 = OptionHelpers.b(map, "sensitivity", optionType, Constants.f17502b, obj2);
        if (!(objB2 instanceof JSObjects.UndefinedObject)) {
            this.f17493b = (IPlatformCollator.Sensitivity) OptionHelpers.c(IPlatformCollator.Sensitivity.class, (String) objB2);
        } else if (this.f17492a == IPlatformCollator.Usage.f17528a) {
            this.f17493b = IPlatformCollator.Sensitivity.f17525d;
        } else {
            this.f17493b = IPlatformCollator.Sensitivity.f17526e;
        }
        this.f17494c = ((Boolean) OptionHelpers.b(map, "ignorePunctuation", optionType2, obj2, Boolean.FALSE)).booleanValue();
        PlatformCollatorICU platformCollatorICU2 = this.f17500i;
        LocaleObjectICU localeObjectICU = (LocaleObjectICU) this.f17498g;
        localeObjectICU.e();
        RuleBasedCollator ruleBasedCollator = (RuleBasedCollator) android.icu.text.Collator.getInstance(localeObjectICU.f17617a);
        platformCollatorICU2.f17648a = ruleBasedCollator;
        ruleBasedCollator.setDecomposition(17);
        if (this.f17496e) {
            platformCollatorICU2.f17648a.setNumericCollation(true);
        }
        int iOrdinal = this.f17497f.ordinal();
        if (iOrdinal == 0) {
            platformCollatorICU2.f17648a.setUpperCaseFirst(true);
        } else if (iOrdinal != 1) {
            platformCollatorICU2.f17648a.setCaseFirstDefault();
        } else {
            platformCollatorICU2.f17648a.setLowerCaseFirst(true);
        }
        int iOrdinal2 = this.f17493b.ordinal();
        if (iOrdinal2 == 0) {
            platformCollatorICU2.f17648a.setStrength(0);
        } else if (iOrdinal2 == 1) {
            platformCollatorICU2.f17648a.setStrength(1);
        } else if (iOrdinal2 == 2) {
            platformCollatorICU2.f17648a.setStrength(0);
            platformCollatorICU2.f17648a.setCaseLevel(true);
        } else if (iOrdinal2 == 3) {
            platformCollatorICU2.f17648a.setStrength(2);
        }
        if (this.f17494c) {
            platformCollatorICU2.f17648a.setAlternateHandlingShifted(true);
        }
    }

    @DoNotStrip
    public static List<String> supportedLocalesOf(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        return ((String) OptionHelpers.b(map, "localeMatcher", OptionHelpers.OptionType.f17634b, Constants.f17501a, "best fit")).equals("best fit") ? Arrays.asList(LocaleMatcher.c((String[]) list.toArray(new String[list.size()]))) : Arrays.asList(LocaleMatcher.e((String[]) list.toArray(new String[list.size()])));
    }

    @DoNotStrip
    public double compare(String str, String str2) {
        return this.f17500i.f17648a.compare(str, str2);
    }

    @DoNotStrip
    public Map<String, Object> resolvedOptions() throws JSRangeErrorException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("locale", this.f17499h.d().replace("-kn-true", "-kn"));
        linkedHashMap.put("usage", this.f17492a.toString());
        IPlatformCollator.Sensitivity sensitivity = this.f17493b;
        IPlatformCollator.Sensitivity sensitivity2 = IPlatformCollator.Sensitivity.f17526e;
        if (sensitivity == sensitivity2) {
            PlatformCollatorICU platformCollatorICU = this.f17500i;
            RuleBasedCollator ruleBasedCollator = platformCollatorICU.f17648a;
            if (ruleBasedCollator != null) {
                int strength = ruleBasedCollator.getStrength();
                sensitivity2 = strength == 0 ? platformCollatorICU.f17648a.isCaseLevel() ? IPlatformCollator.Sensitivity.f17524c : IPlatformCollator.Sensitivity.f17522a : strength == 1 ? IPlatformCollator.Sensitivity.f17523b : IPlatformCollator.Sensitivity.f17525d;
            }
            linkedHashMap.put("sensitivity", sensitivity2.toString());
        } else {
            linkedHashMap.put("sensitivity", sensitivity.toString());
        }
        linkedHashMap.put("ignorePunctuation", Boolean.valueOf(this.f17494c));
        linkedHashMap.put("collation", this.f17495d);
        linkedHashMap.put("numeric", Boolean.valueOf(this.f17496e));
        linkedHashMap.put("caseFirst", this.f17497f.toString());
        return linkedHashMap;
    }
}
