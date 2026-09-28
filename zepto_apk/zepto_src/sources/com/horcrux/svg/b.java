package com.horcrux.svg;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ Typeface.Builder b(AssetManager assetManager, String str) {
        return new Typeface.Builder(assetManager, str);
    }

    public static /* bridge */ /* synthetic */ Path k(Object obj) {
        return (Path) obj;
    }

    public static /* bridge */ /* synthetic */ BasicFileAttributes o(Object obj) {
        return (BasicFileAttributes) obj;
    }

    public static /* synthetic */ void p() {
    }
}
