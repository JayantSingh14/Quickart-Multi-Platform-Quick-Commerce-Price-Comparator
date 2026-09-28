package org.npci.upi.security.pinactivitycomponent;

import android.os.Process;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class j implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    String f57539a = StringUtils.LF;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        Log.e("Exception!!!", "************ LOCATION OF ERROR ************\n\nNPCI Common Library" + this.f57539a + "\n************ CAUSE OF ERROR ************\n\n" + stringWriter.toString() + this.f57539a);
        Process.killProcess(Process.myPid());
    }
}
