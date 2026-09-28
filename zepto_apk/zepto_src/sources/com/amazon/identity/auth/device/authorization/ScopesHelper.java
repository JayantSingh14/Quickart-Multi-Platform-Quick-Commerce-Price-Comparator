package com.amazon.identity.auth.device.authorization;

import android.text.TextUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final class ScopesHelper {
    public static String[] getScopesFromString(String str) {
        return str.contains(StringUtils.SPACE) ? TextUtils.split(str, StringUtils.SPACE) : TextUtils.split(str, "\\+");
    }

    public static String getScopesString(String[] strArr) {
        return TextUtils.join(StringUtils.SPACE, strArr);
    }
}
