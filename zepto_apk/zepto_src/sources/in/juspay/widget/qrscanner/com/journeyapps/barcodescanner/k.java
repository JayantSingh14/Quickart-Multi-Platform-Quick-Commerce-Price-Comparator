package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.os.Looper;

/* loaded from: classes4.dex */
public class k {
    public static void a() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }
}
