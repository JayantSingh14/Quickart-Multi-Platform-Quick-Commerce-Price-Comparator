package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.ResourcesCompat;
import java.io.InputStream;

@RestrictTo
/* loaded from: classes.dex */
public class VectorEnabledTintResources extends ResourcesWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1260a = 0;

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final XmlResourceParser getAnimation(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final boolean getBoolean(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final int getColor(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final ColorStateList getColorStateList(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final Configuration getConfiguration() {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final float getDimension(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final int getDimensionPixelOffset(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final int getDimensionPixelSize(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final Drawable getDrawable(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        return ResourcesCompat.d(null, i2, i3, theme);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final float getFraction(int i2, int i3, int i4) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final int[] getIntArray(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final int getInteger(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final XmlResourceParser getLayout(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final Movie getMovie(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final String getQuantityString(int i2, int i3, Object[] objArr) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final CharSequence getQuantityText(int i2, int i3) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final String getResourceEntryName(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final String getResourceName(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final String getResourcePackageName(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final String getResourceTypeName(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final String getString(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final String[] getStringArray(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final CharSequence getText(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final CharSequence[] getTextArray(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final XmlResourceParser getXml(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final TypedArray obtainTypedArray(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final InputStream openRawResource(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i2) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final Drawable getDrawable(int i2, Resources.Theme theme) {
        return ResourcesCompat.c(null, i2, theme);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final String getQuantityString(int i2, int i3) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final String getString(int i2, Object[] objArr) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final CharSequence getText(int i2, CharSequence charSequence) {
        throw null;
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public final InputStream openRawResource(int i2, TypedValue typedValue) {
        throw null;
    }
}
