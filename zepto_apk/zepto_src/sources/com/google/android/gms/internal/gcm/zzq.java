package com.google.android.gms.internal.gcm;

import java.io.PrintStream;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentHashMap;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzq {

    public static final class zzd extends zzr {
    }

    static {
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e2) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e2.printStackTrace(System.err);
            }
            if ((num == null || num.intValue() < 19) && !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                new ConcurrentHashMap(16, 0.75f, 10);
                new ReferenceQueue();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zzd.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + WKSRecord.Service.STATSRV);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
        }
    }
}
