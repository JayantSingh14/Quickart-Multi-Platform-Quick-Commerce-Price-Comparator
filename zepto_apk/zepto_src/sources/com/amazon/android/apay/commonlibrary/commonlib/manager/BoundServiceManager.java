package com.amazon.android.apay.commonlibrary.commonlib.manager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.amazon.android.apay.commonlibrary.commonlib.service.a;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.commonlib.utils.b;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayError;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class BoundServiceManager {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public static boolean f14868a;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isMshopInstalled$annotations() {
        }

        public final boolean isMshopInstalled() {
            return BoundServiceManager.f14868a;
        }

        public final void setMshopInstalled(boolean z) {
            BoundServiceManager.f14868a = z;
        }

        public Companion() {
        }
    }

    public static final boolean isMshopInstalled() {
        return Companion.isMshopInstalled();
    }

    public static final void setMshopInstalled(boolean z) {
        Companion.setMshopInstalled(z);
    }

    public final void a(Context context) throws PackageManager.NameNotFoundException {
        ResolveInfo resolveInfo;
        Object next;
        Intent intent = new Intent("com.amazon.mShop.kuber.service.PREFETCH_SERVICE");
        intent.putExtra("PREFETCH_SERVICE_USECASE", "WALLET");
        Intrinsics.checkNotNullParameter(context, "context");
        List<ResolveInfo> listQueryIntentServices = context.getApplicationContext().getPackageManager().queryIntentServices(new Intent("com.amazon.mShop.kuber.service.PREFETCH_SERVICE"), 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentServices, "context.applicationConte…tMshopServiceIntent(), 0)");
        Intrinsics.checkNotNullParameter(context, "context");
        if (listQueryIntentServices != null) {
            Iterator<T> it = listQueryIntentServices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(((ResolveInfo) next).serviceInfo.applicationInfo.packageName, Build.VERSION.SDK_INT >= 28 ? 134217728 : 64);
                Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g…nFlag()\n                )");
                if (b.c(packageInfo)) {
                    break;
                }
            }
            resolveInfo = (ResolveInfo) next;
        } else {
            resolveInfo = null;
        }
        ServiceInfo serviceInfo = resolveInfo != null ? resolveInfo.serviceInfo : null;
        if (serviceInfo != null) {
            f14868a = true;
            intent.setComponent(new ComponentName(serviceInfo.applicationInfo.packageName, serviceInfo.name));
            a aVar = new a(context);
            int i2 = Build.VERSION.SDK_INT;
            ExecutorService executorService = aVar.f14875b;
            if (i2 >= 34) {
                context.bindService(intent, 517, executorService, aVar);
            } else if (i2 >= 29) {
                context.bindService(intent, 69, executorService, aVar);
            } else {
                context.bindService(intent, aVar, 69);
            }
        }
    }

    public final void createBoundServiceConnection(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context == null) {
            throw new AmazonPayError("Initialisation Error", "[App Initialization Error] context can not be null");
        }
        if (!(context instanceof Activity) && !context.equals(context.getApplicationContext())) {
            throw new AmazonPayError("Initialisation Error", "[App Initialization Error]Context object should be either an Activity or the ApplicationContext");
        }
        try {
            a(context);
        } catch (Exception e2) {
            e2.getMessage();
            InstrumentUtil.addMetricEvent("boundServiceConnectionException", "BoundService", context, "420", ExceptionsKt.b(e2));
        }
    }
}
