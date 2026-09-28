package com.facebook.soloader;

import android.content.Context;
import android.support.v4.media.b;
import org.apache.commons.lang3.StringUtils;

@DoNotStripAny
/* loaded from: classes3.dex */
public class SoLoaderDSONotFoundError extends SoLoaderULError {
    public static SoLoaderDSONotFoundError a(String str, Context context, SoSource[] soSourceArr) {
        StringBuilder sbY = b.y("couldn't find DSO to load: ", str, "\n\texisting SO sources: ");
        for (int i2 = 0; i2 < soSourceArr.length; i2++) {
            sbY.append("\n\t\tSoSource ");
            sbY.append(i2);
            sbY.append(": ");
            sbY.append(soSourceArr[i2].toString());
        }
        if (context != null) {
            sbY.append("\n\tNative lib dir: ");
            sbY.append(context.getApplicationInfo().nativeLibraryDir);
            sbY.append(StringUtils.LF);
        }
        return new SoLoaderDSONotFoundError(str, sbY.toString());
    }
}
