package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {

    @RequiresApi
    public static class Handler28Impl {
    }

    public static class Result {
    }

    @Override // androidx.startup.Initializer
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.startup.Initializer
    public final Object b(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.a
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                this.f11334a.getClass();
                (Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new b(applicationContext, 0), new Random().nextInt(Math.max(1000, 1)) + 5000);
            }
        });
        return new Result();
    }
}
