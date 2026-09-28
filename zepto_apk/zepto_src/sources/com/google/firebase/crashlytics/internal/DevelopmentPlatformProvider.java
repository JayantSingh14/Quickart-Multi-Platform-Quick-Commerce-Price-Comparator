package com.google.firebase.crashlytics.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class DevelopmentPlatformProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Context f43701a;

    /* renamed from: b, reason: collision with root package name */
    public DevelopmentPlatform f43702b = null;

    public class DevelopmentPlatform {

        /* renamed from: a, reason: collision with root package name */
        public final String f43703a;

        /* renamed from: b, reason: collision with root package name */
        public final String f43704b;

        public DevelopmentPlatform(DevelopmentPlatformProvider developmentPlatformProvider) throws Resources.NotFoundException, IOException {
            int iE = CommonUtils.e(developmentPlatformProvider.f43701a, "com.google.firebase.crashlytics.unity_version", "string");
            Logger logger = Logger.f43705a;
            Context context = developmentPlatformProvider.f43701a;
            if (iE != 0) {
                this.f43703a = "Unity";
                String string = context.getResources().getString(iE);
                this.f43704b = string;
                logger.e("Unity Editor version is: " + string);
                return;
            }
            if (context.getAssets() != null) {
                try {
                    InputStream inputStreamOpen = context.getAssets().open("flutter_assets/NOTICES.Z");
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    this.f43703a = "Flutter";
                    this.f43704b = null;
                    logger.e("Development platform is: Flutter");
                    return;
                } catch (IOException unused) {
                }
            }
            this.f43703a = null;
            this.f43704b = null;
        }
    }

    public DevelopmentPlatformProvider(Context context) {
        this.f43701a = context;
    }

    public final String a() {
        if (this.f43702b == null) {
            this.f43702b = new DevelopmentPlatform(this);
        }
        return this.f43702b.f43703a;
    }

    public final String b() {
        if (this.f43702b == null) {
            this.f43702b = new DevelopmentPlatform(this);
        }
        return this.f43702b.f43704b;
    }
}
