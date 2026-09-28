package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import java.io.InputStream;

/* loaded from: classes.dex */
class ResourcesWrapper extends Resources {
    public final Drawable a(int i2) {
        return super.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        throw null;
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        throw null;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3) {
        return ResourcesCompat.d(null, i2, i3, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i2, int i3, int i4) {
        throw null;
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        throw null;
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3, Object... objArr) {
        throw null;
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i2, int i3) {
        throw null;
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public String getString(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) {
        throw null;
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) {
        throw null;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        throw null;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) {
        throw null;
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        throw null;
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        throw null;
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2, Resources.Theme theme) {
        return ResourcesCompat.c(null, i2, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        return ResourcesCompat.d(null, i2, i3, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3) {
        throw null;
    }

    @Override // android.content.res.Resources
    public String getString(int i2, Object... objArr) {
        throw null;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2, CharSequence charSequence) {
        throw null;
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) {
        throw null;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) {
        throw null;
    }
}
