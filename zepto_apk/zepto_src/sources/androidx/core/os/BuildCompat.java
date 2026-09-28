package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class BuildCompat {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final BuildCompat f2866a = new BuildCompat();

    /* renamed from: b, reason: collision with root package name */
    @ChecksSdkIntAtLeast
    @JvmField
    public static final int f2867b;

    /* renamed from: c, reason: collision with root package name */
    @ChecksSdkIntAtLeast
    @JvmField
    public static final int f2868c;

    /* renamed from: d, reason: collision with root package name */
    @ChecksSdkIntAtLeast
    @JvmField
    public static final int f2869d;

    /* renamed from: e, reason: collision with root package name */
    @ChecksSdkIntAtLeast
    @JvmField
    public static final int f2870e;

    @RequiresApi
    @Metadata
    public static final class Api30Impl {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final Api30Impl f2871a = new Api30Impl();

        private Api30Impl() {
        }

        public final int a(int i2) {
            return SdkExtensions.getExtensionVersion(i2);
        }
    }

    @Metadata
    @RequiresOptIn
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention
    public @interface PrereleaseSdkCheck {
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f2867b = i2 >= 30 ? Api30Impl.f2871a.a(30) : 0;
        f2868c = i2 >= 30 ? Api30Impl.f2871a.a(31) : 0;
        f2869d = i2 >= 30 ? Api30Impl.f2871a.a(33) : 0;
        f2870e = i2 >= 30 ? Api30Impl.f2871a.a(1000000) : 0;
    }

    private BuildCompat() {
    }

    @JvmStatic
    @RestrictTo
    @VisibleForTesting
    public static final boolean a(@NotNull String codename, @NotNull String buildCodename) {
        Intrinsics.checkNotNullParameter(codename, "codename");
        Intrinsics.checkNotNullParameter(buildCodename, "buildCodename");
        if (!"REL".equals(buildCodename)) {
            Locale locale = Locale.ROOT;
            String upperCase = buildCodename.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Integer num = Intrinsics.b(upperCase, "BAKLAVA") ? 0 : null;
            String upperCase2 = codename.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Integer num2 = Intrinsics.b(upperCase2, "BAKLAVA") ? 0 : null;
            if (num == null || num2 == null) {
                if (num == null && num2 == null) {
                    String upperCase3 = buildCodename.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase3, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    String upperCase4 = codename.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase4, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    if (upperCase3.compareTo(upperCase4) >= 0) {
                        return true;
                    }
                } else if (num != null) {
                    return true;
                }
            } else if (num.intValue() >= num2.intValue()) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    @JvmStatic
    @ChecksSdkIntAtLeast
    public static final boolean b() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            return true;
        }
        if (i2 < 32) {
            return false;
        }
        String CODENAME = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
        return a("Tiramisu", CODENAME);
    }

    @Deprecated
    @JvmStatic
    @ChecksSdkIntAtLeast
    public static final boolean c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            return true;
        }
        if (i2 < 34) {
            return false;
        }
        String CODENAME = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
        return a("VanillaIceCream", CODENAME);
    }
}
