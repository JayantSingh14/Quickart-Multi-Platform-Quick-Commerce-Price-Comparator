package coil3.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import androidx.annotation.DrawableRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParserException;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ContextsKt {
    private static final int DEFAULT_MEMORY_CLASS_MEGABYTES = 256;
    private static final double LOW_MEMORY_MULTIPLIER = 0.15d;
    private static final double STANDARD_MEMORY_MULTIPLIER = 0.2d;

    public static final double defaultMemoryCacheSizePercent(@NotNull Context context) {
        try {
            Object systemService = context.getSystemService((Class<Object>) ActivityManager.class);
            Intrinsics.c(systemService);
            return ((ActivityManager) systemService).isLowRamDevice() ? LOW_MEMORY_MULTIPLIER : STANDARD_MEMORY_MULTIPLIER;
        } catch (Exception unused) {
            return STANDARD_MEMORY_MULTIPLIER;
        }
    }

    @NotNull
    public static final Context getApplication(@NotNull Context context) {
        return context.getApplicationContext();
    }

    @NotNull
    public static final Drawable getDrawableCompat(@NotNull Context context, @DrawableRes int i2) {
        Drawable drawableB = AppCompatResources.b(i2, context);
        if (drawableB != null) {
            return drawableB;
        }
        throw new IllegalStateException(b.f(i2, "Invalid resource ID: ").toString());
    }

    @Nullable
    public static final Lifecycle getLifecycle(@Nullable Context context) {
        Object baseContext = context;
        while (!(baseContext instanceof LifecycleOwner)) {
            if (!(baseContext instanceof ContextWrapper)) {
                return null;
            }
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
        }
        return ((LifecycleOwner) baseContext).getLifecycle();
    }

    @SuppressLint({"ResourceType"})
    @NotNull
    public static final Drawable getXmlDrawableCompat(@NotNull Context context, @NotNull Resources resources, @XmlRes @DrawableRes int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = resources.getXml(i2);
        int next = xml.next();
        while (next != 2 && next != 1) {
            next = xml.next();
        }
        if (next == 2) {
            return getDrawableCompat(resources, i2, context.getTheme());
        }
        throw new XmlPullParserException("No start tag found.");
    }

    public static final long totalAvailableMemoryBytes(@NotNull Context context) {
        int largeMemoryClass;
        try {
            Object systemService = context.getSystemService((Class<Object>) ActivityManager.class);
            Intrinsics.c(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            largeMemoryClass = 256;
        }
        return largeMemoryClass * 1048576;
    }

    @NotNull
    public static final Drawable getDrawableCompat(@NotNull Resources resources, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        Drawable drawableC = ResourcesCompat.c(resources, i2, theme);
        if (drawableC != null) {
            return drawableC;
        }
        throw new IllegalStateException(b.f(i2, "Invalid resource ID: ").toString());
    }
}
