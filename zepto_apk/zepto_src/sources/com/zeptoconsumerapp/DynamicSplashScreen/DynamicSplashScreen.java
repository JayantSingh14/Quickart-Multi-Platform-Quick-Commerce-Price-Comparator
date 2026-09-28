package com.zeptoconsumerapp.DynamicSplashScreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bridges.CommsModule;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.zeptoconsumerapp.DynamicSplashScreen.ActiveCampaign;
import com.zeptoconsumerapp.MainActivity;
import com.zeptoconsumerapp.R;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.models.CampaignDataModel;
import com.zeptoconsumerapp.models.SplashScreenAssetModel;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class DynamicSplashScreen {

    /* renamed from: a, reason: collision with root package name */
    public static Dialog f47414a = null;

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference f47415b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f47416c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f47417d = false;

    /* renamed from: e, reason: collision with root package name */
    public static ReactNativeHost f47418e;

    /* renamed from: f, reason: collision with root package name */
    public static String f47419f;

    /* renamed from: com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen$4, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass4 implements ReactInstanceManager.ReactInstanceEventListener {
        @Override // com.facebook.react.ReactInstanceEventListener
        public final void a(ReactApplicationContext reactApplicationContext) {
            Utils.j(reactApplicationContext, "SPLASH_SCREEN_ANIMATION_END_FROM_NATIVE", "");
        }
    }

    /* renamed from: com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f47424a;

        public AnonymousClass5(Activity activity) {
            this.f47424a = activity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dialog dialog = DynamicSplashScreen.f47414a;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            Activity activity = this.f47424a;
            if (!DynamicSplashScreen.b(activity)) {
                DynamicSplashScreen.a();
                return;
            }
            boolean zIsDestroyed = activity.isDestroyed();
            if (DynamicSplashScreen.b(activity) && !zIsDestroyed && DynamicSplashScreen.f47417d) {
                DynamicSplashScreen.a();
            }
        }
    }

    /* renamed from: com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen$7, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47426a;

        static {
            int[] iArr = new int[ActiveCampaign.AssetPositions.values().length];
            f47426a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47426a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47426a[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47426a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a() {
        if (f47414a == null) {
            return;
        }
        new Timer().schedule(new TimerTask() { // from class: com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                try {
                    Dialog dialog = DynamicSplashScreen.f47414a;
                    if (dialog == null) {
                        return;
                    }
                    dialog.dismiss();
                    DynamicSplashScreen.f47414a = null;
                } catch (Exception e2) {
                    DynamicSplashScreen.f47416c = true;
                    DynamicSplashScreen.c(e2);
                }
            }
        }, 100L);
    }

    public static boolean b(Activity activity) {
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    public static void c(Throwable th) {
        try {
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            if (firebaseCrashlytics == null) {
                return;
            }
            firebaseCrashlytics.recordException(th);
        } catch (Exception unused) {
        }
    }

    public static void d(final MainActivity mainActivity) {
        if (b(mainActivity)) {
            f47415b = new WeakReference(mainActivity);
            mainActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen.2

                /* renamed from: com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen$2$1, reason: invalid class name */
                class AnonymousClass1 implements Runnable {
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e2) {
                            DynamicSplashScreen.c(e2);
                        }
                        WeakReference weakReference = DynamicSplashScreen.f47415b;
                        if (weakReference != null) {
                            DynamicSplashScreen.f47416c = true;
                            Activity activity = (Activity) weakReference.get();
                            if (DynamicSplashScreen.b(activity)) {
                                activity.runOnUiThread(new AnonymousClass5(activity));
                            }
                        }
                        ReactNativeHost reactNativeHost = DynamicSplashScreen.f47418e;
                        if (reactNativeHost == null) {
                            return;
                        }
                        ReactInstanceManager reactInstanceManagerF = reactNativeHost.f();
                        ReactContext reactContextF = reactInstanceManagerF.f();
                        if (reactContextF != null) {
                            Utils.j(reactContextF, "SPLASH_SCREEN_ANIMATION_END_FROM_NATIVE", "");
                        } else {
                            reactInstanceManagerF.s.add(new AnonymousClass4());
                        }
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity mainActivity2 = mainActivity;
                    if (!DynamicSplashScreen.b(mainActivity2)) {
                        DynamicSplashScreen.c(new Throwable("showDefaultSplashScreen: activity is null"));
                        return;
                    }
                    try {
                        Dialog dialog = new Dialog(mainActivity2, R.style.SplashScreen_SplashTheme);
                        DynamicSplashScreen.f47414a = dialog;
                        dialog.setContentView(R.layout.launch_screen);
                        if (DynamicSplashScreen.f47414a == null) {
                            DynamicSplashScreen.f47416c = true;
                            DynamicSplashScreen.c(new Throwable("showDefaultSplashScreen: mSplashDialog is null"));
                        } else {
                            new Thread(new AnonymousClass1()).start();
                            if (DynamicSplashScreen.f47414a.isShowing()) {
                                return;
                            }
                            DynamicSplashScreen.f47414a.show();
                        }
                    } catch (Exception e2) {
                        DynamicSplashScreen.f47416c = true;
                        DynamicSplashScreen.c(e2);
                    }
                }
            });
        }
    }

    public static void e(final MainActivity mainActivity, ReactNativeHost reactNativeHost) {
        try {
            if (b(mainActivity)) {
                f47418e = reactNativeHost;
                ActiveCampaign activeCampaign = new ActiveCampaign();
                if (!mainActivity.isFinishing()) {
                    activeCampaign.f47412a = mainActivity.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
                }
                final CampaignDataModel campaignDataModelA = activeCampaign.a();
                if (campaignDataModelA == null) {
                    d(mainActivity);
                    return;
                }
                f47419f = campaignDataModelA.e();
                if (b(mainActivity)) {
                    f47415b = new WeakReference(mainActivity);
                    mainActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CampaignDataModel campaignDataModel = campaignDataModelA;
                            MainActivity mainActivity2 = mainActivity;
                            if (!DynamicSplashScreen.b(mainActivity2)) {
                                DynamicSplashScreen.c(new Throwable("showDefaultSplashScreen: activity is null"));
                                return;
                            }
                            try {
                                Dialog dialog = new Dialog(mainActivity2, R.style.SplashScreen_SplashTheme);
                                DynamicSplashScreen.f47414a = dialog;
                                dialog.setContentView(R.layout.dynamic_launch_screen);
                                Dialog dialog2 = DynamicSplashScreen.f47414a;
                                if (dialog2 == null) {
                                    DynamicSplashScreen.f47416c = true;
                                    DynamicSplashScreen.c(new Throwable("showDefaultSplashScreen: mSplashDialog is null"));
                                    return;
                                }
                                try {
                                    RelativeLayout relativeLayout = (RelativeLayout) dialog2.findViewById(R.id.backgroundImage);
                                    String strB = campaignDataModel.b();
                                    if (strB != null) {
                                        String str = Utils.f47559a;
                                        if (Pattern.compile("^#?([0-9A-Fa-f]{3}|[0-9A-Fa-f]{6})$").matcher(strB).matches()) {
                                            relativeLayout.setBackgroundColor(Color.parseColor(strB));
                                        }
                                    }
                                } catch (Exception e2) {
                                    DynamicSplashScreen.c(e2);
                                }
                                final long j2 = 800;
                                try {
                                    long jC = campaignDataModel.c();
                                    if (jC > 0) {
                                        j2 = jC;
                                    }
                                } catch (Exception e3) {
                                    DynamicSplashScreen.c(e3);
                                }
                                try {
                                    List listA = campaignDataModel.a();
                                    for (int i2 = 0; i2 < listA.size(); i2++) {
                                        SplashScreenAssetModel splashScreenAssetModel = (SplashScreenAssetModel) listA.get(i2);
                                        int iOrdinal = ActiveCampaign.AssetPositions.valueOf(splashScreenAssetModel.c()).ordinal();
                                        if (iOrdinal == 0) {
                                            ((RelativeLayout) DynamicSplashScreen.f47414a.findViewById(R.id.backgroundImage)).setBackground(new BitmapDrawable(mainActivity2.getResources(), Utils.b(splashScreenAssetModel.b())));
                                        } else if (iOrdinal == 1) {
                                            ImageView imageView = (ImageView) DynamicSplashScreen.f47414a.findViewById(R.id.center_aligned_image);
                                            Bitmap bitmapB = Utils.b(splashScreenAssetModel.b());
                                            int iD = splashScreenAssetModel.d() / splashScreenAssetModel.a();
                                            int i3 = Resources.getSystem().getDisplayMetrics().widthPixels;
                                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, (int) (i3 / iD));
                                            layoutParams.addRule(14, -1);
                                            layoutParams.addRule(15, -1);
                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                            layoutParams.topMargin = 0;
                                            layoutParams.bottomMargin = 0;
                                            imageView.setLayoutParams(layoutParams);
                                            imageView.setImageBitmap(bitmapB);
                                        } else if (iOrdinal == 2) {
                                            ImageView imageView2 = (ImageView) DynamicSplashScreen.f47414a.findViewById(R.id.top_aligned_image);
                                            Bitmap bitmapB2 = Utils.b(splashScreenAssetModel.b());
                                            int iD2 = splashScreenAssetModel.d() / splashScreenAssetModel.a();
                                            int i4 = Resources.getSystem().getDisplayMetrics().widthPixels;
                                            imageView2.setLayoutParams(new RelativeLayout.LayoutParams(i4, (int) (i4 / iD2)));
                                            imageView2.setImageBitmap(bitmapB2);
                                        } else if (iOrdinal == 3) {
                                            ImageView imageView3 = (ImageView) DynamicSplashScreen.f47414a.findViewById(R.id.bottom_aligned_image);
                                            Bitmap bitmapB3 = Utils.b(splashScreenAssetModel.b());
                                            int iD3 = splashScreenAssetModel.d() / splashScreenAssetModel.a();
                                            int i5 = Resources.getSystem().getDisplayMetrics().widthPixels;
                                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i5, (int) (i5 / iD3));
                                            layoutParams2.width = Resources.getSystem().getDisplayMetrics().widthPixels;
                                            layoutParams2.addRule(12, -1);
                                            imageView3.setLayoutParams(layoutParams2);
                                            imageView3.setImageBitmap(bitmapB3);
                                        }
                                    }
                                    new Thread(new Runnable() { // from class: com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen.1.1
                                        @Override // java.lang.Runnable
                                        public final void run() throws InterruptedException {
                                            try {
                                                Thread.sleep(j2);
                                            } catch (InterruptedException e4) {
                                                DynamicSplashScreen.c(e4);
                                            }
                                            WeakReference weakReference = DynamicSplashScreen.f47415b;
                                            if (weakReference != null) {
                                                DynamicSplashScreen.f47416c = true;
                                                Activity activity = (Activity) weakReference.get();
                                                if (DynamicSplashScreen.b(activity)) {
                                                    activity.runOnUiThread(new AnonymousClass5(activity));
                                                }
                                            }
                                            ReactNativeHost reactNativeHost2 = DynamicSplashScreen.f47418e;
                                            if (reactNativeHost2 == null) {
                                                return;
                                            }
                                            ReactInstanceManager reactInstanceManagerF = reactNativeHost2.f();
                                            ReactContext reactContextF = reactInstanceManagerF.f();
                                            if (reactContextF != null) {
                                                Utils.j(reactContextF, "SPLASH_SCREEN_ANIMATION_END_FROM_NATIVE", "");
                                            } else {
                                                reactInstanceManagerF.s.add(new AnonymousClass4());
                                            }
                                        }
                                    }).start();
                                    Dialog dialog3 = DynamicSplashScreen.f47414a;
                                    if (dialog3 == null || dialog3.isShowing()) {
                                        return;
                                    }
                                    DynamicSplashScreen.f47414a.show();
                                } catch (Exception e4) {
                                    Utils.i(e4);
                                    DynamicSplashScreen.f47414a = null;
                                    DynamicSplashScreen.d(mainActivity2);
                                }
                            } catch (Exception e5) {
                                DynamicSplashScreen.f47416c = true;
                                DynamicSplashScreen.c(e5);
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            d(mainActivity);
            c(e2);
        }
    }
}
