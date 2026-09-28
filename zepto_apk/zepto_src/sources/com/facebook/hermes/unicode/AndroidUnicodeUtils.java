package com.facebook.hermes.unicode;

import com.facebook.proguard.annotations.DoNotStrip;
import java.text.Collator;
import java.text.DateFormat;
import java.text.Normalizer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata
/* loaded from: classes3.dex */
public final class AndroidUnicodeUtils {
    static {
        new AndroidUnicodeUtils();
    }

    private AndroidUnicodeUtils() {
    }

    @JvmStatic
    @DoNotStrip
    @NotNull
    public static final String convertToCase(@NotNull String input, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(input, "input");
        Locale locale = z ? Locale.getDefault() : Locale.ENGLISH;
        if (i2 == 0) {
            Intrinsics.c(locale);
            String upperCase = input.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        if (i2 != 1) {
            throw new IllegalStateException("Invalid target case");
        }
        Intrinsics.c(locale);
        String lowerCase = input.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @JvmStatic
    @DoNotStrip
    @NotNull
    public static final String dateFormat(double d2, boolean z, boolean z2) {
        DateFormat timeInstance;
        if (z && z2) {
            timeInstance = DateFormat.getDateTimeInstance(2, 2);
        } else if (z) {
            timeInstance = DateFormat.getDateInstance(2);
        } else {
            if (!z2) {
                throw new IllegalStateException("Bad dateFormat configuration");
            }
            timeInstance = DateFormat.getTimeInstance(2);
        }
        return timeInstance.format(Long.valueOf((long) d2)).toString();
    }

    @JvmStatic
    @DoNotStrip
    public static final int localeCompare(@Nullable String str, @Nullable String str2) {
        return Collator.getInstance().compare(str, str2);
    }

    @JvmStatic
    @DoNotStrip
    @NotNull
    public static final String normalize(@Nullable String str, int i2) {
        if (i2 == 0) {
            String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFC);
            Intrinsics.checkNotNullExpressionValue(strNormalize, "normalize(...)");
            return strNormalize;
        }
        if (i2 == 1) {
            String strNormalize2 = Normalizer.normalize(str, Normalizer.Form.NFD);
            Intrinsics.checkNotNullExpressionValue(strNormalize2, "normalize(...)");
            return strNormalize2;
        }
        if (i2 == 2) {
            String strNormalize3 = Normalizer.normalize(str, Normalizer.Form.NFKC);
            Intrinsics.checkNotNullExpressionValue(strNormalize3, "normalize(...)");
            return strNormalize3;
        }
        if (i2 != 3) {
            throw new IllegalStateException("Invalid form");
        }
        String strNormalize4 = Normalizer.normalize(str, Normalizer.Form.NFKD);
        Intrinsics.checkNotNullExpressionValue(strNormalize4, "normalize(...)");
        return strNormalize4;
    }
}
