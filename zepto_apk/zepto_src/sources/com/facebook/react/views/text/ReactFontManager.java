package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.facebook.react.common.assets.ReactFontManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public final class ReactFontManager {

    /* renamed from: b, reason: collision with root package name */
    public static ReactFontManager f20095b;

    /* renamed from: a, reason: collision with root package name */
    public final com.facebook.react.common.assets.ReactFontManager f20096a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static ReactFontManager a() {
            ReactFontManager reactFontManager = ReactFontManager.f20095b;
            if (reactFontManager != null) {
                return reactFontManager;
            }
            ReactFontManager reactFontManager2 = new ReactFontManager(com.facebook.react.common.assets.ReactFontManager.f18711e);
            ReactFontManager.f20095b = reactFontManager2;
            return reactFontManager2;
        }
    }

    public ReactFontManager(com.facebook.react.common.assets.ReactFontManager reactFontManager) {
        this.f20096a = reactFontManager;
    }

    public static final ReactFontManager a() {
        return Companion.a();
    }

    public final Typeface b(String fontFamilyName, int i2, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        com.facebook.react.common.assets.ReactFontManager reactFontManager = this.f20096a;
        reactFontManager.getClass();
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return reactFontManager.a(fontFamilyName, new ReactFontManager.TypefaceStyle(i2, -1), assetManager);
    }
}
