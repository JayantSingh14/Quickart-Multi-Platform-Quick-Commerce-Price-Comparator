package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleDispatcher;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    @Override // androidx.startup.Initializer
    public final List a() {
        return EmptyList.f53609a;
    }

    @Override // androidx.startup.Initializer
    public final Object b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppInitializer appInitializerC = AppInitializer.c(context);
        Intrinsics.checkNotNullExpressionValue(appInitializerC, "getInstance(context)");
        if (!appInitializerC.f11948b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        AtomicBoolean atomicBoolean = LifecycleDispatcher.f4815a;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!LifecycleDispatcher.f4815a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new LifecycleDispatcher.DispatcherActivityCallback());
        }
        ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.f4856i;
        Intrinsics.checkNotNullParameter(context, "context");
        final ProcessLifecycleOwner processLifecycleOwner2 = ProcessLifecycleOwner.f4856i;
        processLifecycleOwner2.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        processLifecycleOwner2.f4861e = new Handler();
        processLifecycleOwner2.f4862f.f(Lifecycle.Event.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.d(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1
            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (Build.VERSION.SDK_INT < 29) {
                    int i2 = ReportFragment.f4894b;
                    Intrinsics.checkNotNullParameter(activity, "<this>");
                    Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
                    Intrinsics.d(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
                    ((ReportFragment) fragmentFindFragmentByTag).f4895a = processLifecycleOwner2.f4864h;
                }
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                ProcessLifecycleOwner processLifecycleOwner3 = processLifecycleOwner2;
                int i2 = processLifecycleOwner3.f4858b - 1;
                processLifecycleOwner3.f4858b = i2;
                if (i2 == 0) {
                    Handler handler = processLifecycleOwner3.f4861e;
                    Intrinsics.c(handler);
                    handler.postDelayed(processLifecycleOwner3.f4863g, 700L);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            @RequiresApi
            public void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                final ProcessLifecycleOwner processLifecycleOwner3 = processLifecycleOwner2;
                ProcessLifecycleOwner.Api29Impl.a(activity, new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1$onActivityPreCreated$1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostResumed(@NotNull Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                        processLifecycleOwner3.a();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostStarted(@NotNull Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                        ProcessLifecycleOwner processLifecycleOwner4 = processLifecycleOwner3;
                        int i2 = processLifecycleOwner4.f4857a + 1;
                        processLifecycleOwner4.f4857a = i2;
                        if (i2 == 1 && processLifecycleOwner4.f4860d) {
                            processLifecycleOwner4.f4862f.f(Lifecycle.Event.ON_START);
                            processLifecycleOwner4.f4860d = false;
                        }
                    }
                });
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                ProcessLifecycleOwner processLifecycleOwner3 = processLifecycleOwner2;
                int i2 = processLifecycleOwner3.f4857a - 1;
                processLifecycleOwner3.f4857a = i2;
                if (i2 == 0 && processLifecycleOwner3.f4859c) {
                    processLifecycleOwner3.f4862f.f(Lifecycle.Event.ON_STOP);
                    processLifecycleOwner3.f4860d = true;
                }
            }
        });
        return processLifecycleOwner2;
    }
}
