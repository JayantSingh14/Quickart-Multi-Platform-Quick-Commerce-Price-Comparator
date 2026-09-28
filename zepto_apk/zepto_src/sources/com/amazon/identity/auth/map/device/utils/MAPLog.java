package com.amazon.identity.auth.map.device.utils;

import android.os.Build;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class MAPLog {
    static {
        try {
            String str = Build.VERSION.INCREMENTAL;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Matcher matcher = Pattern.compile("^(?:(.*?)_)??(?:([^_]*)_)?([0-9]+)$").matcher(str);
            if (matcher.find() && matcher.groupCount() >= 3) {
                String strGroup = matcher.group(2);
                if (TextUtils.isEmpty(strGroup) || strGroup.equals("userdebug")) {
                    return;
                }
                strGroup.equals("eng");
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }
}
