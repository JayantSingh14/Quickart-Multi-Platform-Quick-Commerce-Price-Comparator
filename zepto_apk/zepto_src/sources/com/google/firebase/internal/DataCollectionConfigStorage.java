package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

/* loaded from: classes.dex */
public class DataCollectionConfigStorage {

    /* renamed from: a, reason: collision with root package name */
    public final Context f44656a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f44657b;

    /* renamed from: c, reason: collision with root package name */
    public final Publisher f44658c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f44659d;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        this.f44656a = contextCreateDeviceProtectedStorageContext;
        SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f44657b = sharedPreferences;
        this.f44658c = publisher;
        this.f44659d = sharedPreferences.contains("firebase_data_collection_default_enabled") ? sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true) : a();
    }

    public final boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context context = this.f44656a;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public final synchronized void b(boolean z) {
        if (this.f44659d != z) {
            this.f44659d = z;
            this.f44658c.c(new Event(new DataCollectionDefaultChange(z)));
        }
    }
}
