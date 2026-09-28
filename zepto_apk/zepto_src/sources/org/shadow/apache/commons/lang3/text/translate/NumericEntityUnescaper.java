package org.shadow.apache.commons.lang3.text.translate;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;

/* loaded from: classes5.dex */
public class NumericEntityUnescaper extends CharSequenceTranslator {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class OPTION {

        /* renamed from: a, reason: collision with root package name */
        public static final OPTION f57797a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ OPTION[] f57798b;

        static {
            OPTION option = new OPTION("semiColonRequired", 0);
            f57797a = option;
            f57798b = new OPTION[]{option, new OPTION("semiColonOptional", 1), new OPTION("errorIfNoSemiColon", 2)};
        }

        public static OPTION valueOf(String str) {
            return (OPTION) Enum.valueOf(OPTION.class, str);
        }

        public static OPTION[] values() {
            return (OPTION[]) f57798b.clone();
        }
    }

    public NumericEntityUnescaper(OPTION... optionArr) {
        if (optionArr.length > 0) {
            EnumSet.copyOf((Collection) Arrays.asList(optionArr));
        } else {
            EnumSet.copyOf((Collection) Arrays.asList(OPTION.f57797a));
        }
    }
}
