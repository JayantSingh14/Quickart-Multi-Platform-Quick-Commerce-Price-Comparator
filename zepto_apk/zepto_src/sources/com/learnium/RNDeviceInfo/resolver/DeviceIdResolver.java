package com.learnium.RNDeviceInfo.resolver;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzaj;
import com.learnium.RNDeviceInfo.RNDeviceModule;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class DeviceIdResolver {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f45959a;

    public DeviceIdResolver(ReactApplicationContext reactApplicationContext) {
        this.f45959a = reactApplicationContext;
    }

    public static String a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke = Class.forName("com.google.firebase.iid.FirebaseInstanceId").getDeclaredMethod("getInstance", null).invoke(null, null);
        return (String) objInvoke.getClass().getMethod("getId", null).invoke(objInvoke, null);
    }

    public final String b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        zzaj zzajVar = InstanceID.f22549b;
        Object objInvoke = InstanceID.class.getDeclaredMethod("getInstance", Context.class).invoke(null, this.f45959a.getApplicationContext());
        return (String) objInvoke.getClass().getMethod("getId", null).invoke(objInvoke, null);
    }

    public final void c(String str) {
        SharedPreferences.Editor editorEdit = RNDeviceModule.getRNDISharedPreferences(this.f45959a).edit();
        editorEdit.putString("instanceId", str);
        editorEdit.apply();
    }
}
