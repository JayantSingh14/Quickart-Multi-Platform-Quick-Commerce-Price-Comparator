package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.assets.ReactFontManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReactTypefaceUtils {
    public static final Typeface a(Typeface typeface, int i2, int i3, String str, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        ReactFontManager.TypefaceStyle typefaceStyle = new ReactFontManager.TypefaceStyle(i2, i3);
        if (str != null) {
            return com.facebook.react.common.assets.ReactFontManager.f18711e.a(str, typefaceStyle, assetManager);
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        int i4 = Build.VERSION.SDK_INT;
        boolean z = typefaceStyle.f18715a;
        int i5 = typefaceStyle.f18716b;
        if (i4 < 28) {
            Typeface typefaceCreate = Typeface.create(typeface, i5 < 700 ? z ? 2 : 0 : z ? 3 : 1);
            Intrinsics.c(typefaceCreate);
            return typefaceCreate;
        }
        Typeface typefaceCreate2 = Typeface.create(typeface, i5, z);
        Intrinsics.c(typefaceCreate2);
        return typefaceCreate2;
    }

    public static final int b(String str) {
        if (Intrinsics.b(str, "italic")) {
            return 2;
        }
        return Intrinsics.b(str, "normal") ? 0 : -1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final String c(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            String string = readableArray.getString(i2);
            if (string != null) {
                switch (string.hashCode()) {
                    case -1983120972:
                        if (string.equals("stylistic-thirteen")) {
                            arrayList.add("'ss13'");
                            break;
                        } else {
                            break;
                        }
                    case -1933522176:
                        if (string.equals("stylistic-fifteen")) {
                            arrayList.add("'ss15'");
                            break;
                        } else {
                            break;
                        }
                    case -1534462052:
                        if (string.equals("stylistic-eighteen")) {
                            arrayList.add("'ss18'");
                            break;
                        } else {
                            break;
                        }
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            arrayList.add("'pnum'");
                            break;
                        } else {
                            break;
                        }
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            arrayList.add("'lnum'");
                            break;
                        } else {
                            break;
                        }
                    case -899039099:
                        if (string.equals("historical-ligatures")) {
                            arrayList.add("'hlig'");
                            break;
                        } else {
                            break;
                        }
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            arrayList.add("'tnum'");
                            break;
                        } else {
                            break;
                        }
                    case -672279417:
                        if (string.equals("discretionary-ligatures")) {
                            arrayList.add("'dlig'");
                            break;
                        } else {
                            break;
                        }
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            arrayList.add("'onum'");
                            break;
                        } else {
                            break;
                        }
                    case 249095901:
                        if (string.equals("no-contextual")) {
                            arrayList.add("'calt' off");
                            break;
                        } else {
                            break;
                        }
                    case 273808209:
                        if (string.equals("contextual")) {
                            arrayList.add("'calt'");
                            break;
                        } else {
                            break;
                        }
                    case 289909490:
                        if (string.equals("no-common-ligatures")) {
                            arrayList.add("'liga' off");
                            arrayList.add("'clig' off");
                            break;
                        } else {
                            break;
                        }
                    case 296506098:
                        if (string.equals("stylistic-eight")) {
                            arrayList.add("'ss08'");
                            break;
                        } else {
                            break;
                        }
                    case 309330544:
                        if (string.equals("stylistic-seven")) {
                            arrayList.add("'ss07'");
                            break;
                        } else {
                            break;
                        }
                    case 310339585:
                        if (string.equals("stylistic-three")) {
                            arrayList.add("'ss03'");
                            break;
                        } else {
                            break;
                        }
                    case 604478526:
                        if (string.equals("stylistic-eleven")) {
                            arrayList.add("'ss11'");
                            break;
                        } else {
                            break;
                        }
                    case 915975441:
                        if (string.equals("no-historical-ligatures")) {
                            arrayList.add("'hlig' off");
                            break;
                        } else {
                            break;
                        }
                    case 979426287:
                        if (string.equals("stylistic-five")) {
                            arrayList.add("'ss05'");
                            break;
                        } else {
                            break;
                        }
                    case 979432035:
                        if (string.equals("stylistic-four")) {
                            arrayList.add("'ss04'");
                            break;
                        } else {
                            break;
                        }
                    case 979664367:
                        if (string.equals("stylistic-nine")) {
                            arrayList.add("'ss09'");
                            break;
                        } else {
                            break;
                        }
                    case 1001434505:
                        if (string.equals("stylistic-one")) {
                            arrayList.add("'ss01'");
                            break;
                        } else {
                            break;
                        }
                    case 1001438213:
                        if (string.equals("stylistic-six")) {
                            arrayList.add("'ss06'");
                            break;
                        } else {
                            break;
                        }
                    case 1001439040:
                        if (string.equals("stylistic-ten")) {
                            arrayList.add("'ss10'");
                            break;
                        } else {
                            break;
                        }
                    case 1001439599:
                        if (string.equals("stylistic-two")) {
                            arrayList.add("'ss02'");
                            break;
                        } else {
                            break;
                        }
                    case 1030714463:
                        if (string.equals("stylistic-sixteen")) {
                            arrayList.add("'ss16'");
                            break;
                        } else {
                            break;
                        }
                    case 1044065430:
                        if (string.equals("stylistic-twelve")) {
                            arrayList.add("'ss12'");
                            break;
                        } else {
                            break;
                        }
                    case 1044067310:
                        if (string.equals("stylistic-twenty")) {
                            arrayList.add("'ss20'");
                            break;
                        } else {
                            break;
                        }
                    case 1082592379:
                        if (string.equals("no-discretionary-ligatures")) {
                            arrayList.add("'dlig' off");
                            break;
                        } else {
                            break;
                        }
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            arrayList.add("'smcp'");
                            break;
                        } else {
                            break;
                        }
                    case 1223989350:
                        if (string.equals("common-ligatures")) {
                            arrayList.add("'liga'");
                            arrayList.add("'clig'");
                            break;
                        } else {
                            break;
                        }
                    case 1463562569:
                        if (string.equals("stylistic-nineteen")) {
                            arrayList.add("'ss19'");
                            break;
                        } else {
                            break;
                        }
                    case 1648446397:
                        if (string.equals("stylistic-fourteen")) {
                            arrayList.add("'ss14'");
                            break;
                        } else {
                            break;
                        }
                    case 2097122634:
                        if (string.equals("stylistic-seventeen")) {
                            arrayList.add("'ss17'");
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    public static final int d(String str) {
        if (str == null) {
            return -1;
        }
        switch (str.hashCode()) {
            case -1039745817:
                return !str.equals("normal") ? -1 : 400;
            case 48625:
                return !str.equals("100") ? -1 : 100;
            case 49586:
                return !str.equals("200") ? -1 : 200;
            case 50547:
                return !str.equals("300") ? -1 : 300;
            case 51508:
                return !str.equals("400") ? -1 : 400;
            case 52469:
                return !str.equals("500") ? -1 : 500;
            case 53430:
                return !str.equals("600") ? -1 : 600;
            case 54391:
                return !str.equals("700") ? -1 : 700;
            case 55352:
                return !str.equals("800") ? -1 : 800;
            case 56313:
                return !str.equals("900") ? -1 : 900;
            case 3029637:
                return !str.equals("bold") ? -1 : 700;
            default:
                return -1;
        }
    }
}
