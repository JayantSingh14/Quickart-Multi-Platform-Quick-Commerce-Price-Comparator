package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import android.support.v4.media.b;
import org.xbill.DNS.WKSRecord;

@DoNotOptimize
@TargetApi(18)
/* loaded from: classes.dex */
class Api18TraceUtils {
    public static void a(String str, String str2, String str3) {
        String strL = b.l(str, str2, str3);
        if (strL.length() > 127 && str2 != null) {
            int length = (WKSRecord.Service.LOCUS_CON - str.length()) - str3.length();
            StringBuilder sbW = b.w(str);
            sbW.append(str2.substring(0, length));
            sbW.append(str3);
            strL = sbW.toString();
        }
        Trace.beginSection(strL);
    }
}
