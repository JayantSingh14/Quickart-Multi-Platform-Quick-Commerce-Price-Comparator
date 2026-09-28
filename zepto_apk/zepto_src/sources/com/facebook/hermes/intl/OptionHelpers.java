package com.facebook.hermes.intl;

import com.facebook.hermes.intl.JSObjects;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes3.dex */
public class OptionHelpers {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class OptionType {

        /* renamed from: a, reason: collision with root package name */
        public static final OptionType f17633a;

        /* renamed from: b, reason: collision with root package name */
        public static final OptionType f17634b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ OptionType[] f17635c;

        static {
            OptionType optionType = new OptionType("BOOLEAN", 0);
            f17633a = optionType;
            OptionType optionType2 = new OptionType("STRING", 1);
            f17634b = optionType2;
            f17635c = new OptionType[]{optionType, optionType2};
        }

        public static OptionType valueOf(String str) {
            return (OptionType) Enum.valueOf(OptionType.class, str);
        }

        public static OptionType[] values() {
            return (OptionType[]) f17635c.clone();
        }
    }

    public static Object a(String str, Object obj, Object obj2, Double d2, Object obj3) throws JSRangeErrorException {
        if (obj instanceof JSObjects.UndefinedObject) {
            return obj3;
        }
        if (!(obj instanceof Double)) {
            throw new JSRangeErrorException(str.concat(" value is invalid."));
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue) || dDoubleValue > d2.doubleValue() || dDoubleValue < ((Double) obj2).doubleValue()) {
            throw new JSRangeErrorException(str.concat(" value is invalid."));
        }
        return obj;
    }

    public static Object b(Map map, String str, OptionType optionType, Object obj, Object obj2) throws JSRangeErrorException {
        Object objA = JSObjects.a(str, map);
        if (objA instanceof JSObjects.UndefinedObject) {
            return obj2;
        }
        if (objA instanceof JSObjects.NullObject) {
            objA = "";
        }
        if (optionType == OptionType.f17633a && !(objA instanceof Boolean)) {
            throw new JSRangeErrorException("Boolean option expected but not found");
        }
        if (optionType == OptionType.f17634b && !(objA instanceof String)) {
            throw new JSRangeErrorException("String option expected but not found");
        }
        if ((obj instanceof JSObjects.UndefinedObject) || Arrays.asList((Object[]) obj).contains(objA)) {
            return objA;
        }
        throw new JSRangeErrorException("String option expected but not found");
    }

    public static Enum c(Class cls, Object obj) {
        if (obj instanceof JSObjects.UndefinedObject) {
            return Enum.valueOf(cls, "UNDEFINED");
        }
        if (obj instanceof JSObjects.NullObject) {
            return null;
        }
        String str = (String) obj;
        if (str.equals("2-digit")) {
            return Enum.valueOf(cls, "DIGIT2");
        }
        for (Enum r3 : (Enum[]) cls.getEnumConstants()) {
            if (r3.name().compareToIgnoreCase(str) == 0) {
                return r3;
            }
        }
        return null;
    }
}
