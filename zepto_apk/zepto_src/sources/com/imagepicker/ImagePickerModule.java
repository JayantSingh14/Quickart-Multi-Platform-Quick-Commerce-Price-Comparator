package com.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import in.juspay.hyper.constants.Labels;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class ImagePickerModule extends ReactContextBaseJavaModule {
    final ImagePickerModuleImpl imagePickerModuleImpl;

    public ImagePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        ImagePickerModuleImpl imagePickerModuleImpl = new ImagePickerModuleImpl();
        imagePickerModuleImpl.f45931b = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(imagePickerModuleImpl);
        this.imagePickerModuleImpl = imagePickerModuleImpl;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ImagePicker";
    }

    @ReactMethod
    public void launchCamera(ReadableMap readableMap, Callback callback) throws IOException {
        Intent intent;
        File fileB;
        int i2;
        ImagePickerModuleImpl imagePickerModuleImpl = this.imagePickerModuleImpl;
        ReactApplicationContext reactApplicationContext = imagePickerModuleImpl.f45931b;
        if (!reactApplicationContext.getPackageManager().hasSystemFeature("android.hardware.camera") && !reactApplicationContext.getPackageManager().hasSystemFeature("android.hardware.camera.any")) {
            callback.invoke(Utils.d("camera_unavailable", null));
            return;
        }
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(Utils.d("others", "Activity error"));
            return;
        }
        try {
            String[] strArr = reactApplicationContext.getPackageManager().getPackageInfo(reactApplicationContext.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && Arrays.asList(strArr).contains("android.permission.CAMERA")) {
                if (ContextCompat.a(currentActivity, "android.permission.CAMERA") != 0) {
                    callback.invoke(Utils.d("others", "This library does not require Manifest.permission.CAMERA, if you add this permission in manifest then you have to obtain the same."));
                    return;
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        imagePickerModuleImpl.f45932c = callback;
        Options options = new Options(readableMap);
        imagePickerModuleImpl.f45933d = options;
        if (options.f45945h.booleanValue() && Build.VERSION.SDK_INT <= 28 && ContextCompat.a(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            callback.invoke(Utils.d(Labels.System.PERMISSION, null));
            return;
        }
        if (imagePickerModuleImpl.f45933d.f45948k.equals("video")) {
            intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", imagePickerModuleImpl.f45933d.f45941d);
            int i3 = imagePickerModuleImpl.f45933d.f45946i;
            if (i3 > 0) {
                intent.putExtra("android.intent.extra.durationLimit", i3);
            }
            fileB = Utils.b(reactApplicationContext, "mp4");
            imagePickerModuleImpl.f45934e = FileProvider.d(reactApplicationContext, reactApplicationContext.getApplicationContext().getPackageName() + ".imagepickerprovider", fileB);
            i2 = 13002;
        } else {
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
            fileB = Utils.b(reactApplicationContext, "jpg");
            imagePickerModuleImpl.f45934e = FileProvider.d(reactApplicationContext, reactApplicationContext.getApplicationContext().getPackageName() + ".imagepickerprovider", fileB);
            i2 = 13001;
        }
        if (imagePickerModuleImpl.f45933d.f45947j.booleanValue()) {
            int i4 = Build.VERSION.SDK_INT;
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (i4 >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
        }
        imagePickerModuleImpl.f45930a = Uri.fromFile(fileB);
        intent.putExtra("output", imagePickerModuleImpl.f45934e);
        intent.addFlags(3);
        try {
            currentActivity.startActivityForResult(intent, i2);
        } catch (ActivityNotFoundException e3) {
            callback.invoke(Utils.d("others", e3.getMessage()));
            imagePickerModuleImpl.f45932c = null;
        }
    }

    @ReactMethod
    public void launchImageLibrary(ReadableMap readableMap, Callback callback) {
        Intent intent;
        ImagePickerModuleImpl imagePickerModuleImpl = this.imagePickerModuleImpl;
        Activity currentActivity = imagePickerModuleImpl.f45931b.getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(Utils.d("others", "Activity error"));
            return;
        }
        imagePickerModuleImpl.f45932c = callback;
        Options options = new Options(readableMap);
        imagePickerModuleImpl.f45933d = options;
        int pickImagesMaxLimit = options.f45938a;
        boolean z = pickImagesMaxLimit == 1;
        boolean zEquals = options.f45948k.equals("photo");
        boolean zEquals2 = imagePickerModuleImpl.f45933d.f45948k.equals("video");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            intent = new Intent("android.provider.action.PICK_IMAGES");
        } else if (z && (zEquals || zEquals2)) {
            intent = new Intent("android.intent.action.PICK");
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
        }
        if (!z) {
            if (i2 < 33) {
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            } else if (pickImagesMaxLimit != 1) {
                if (pickImagesMaxLimit == 0) {
                    pickImagesMaxLimit = MediaStore.getPickImagesMaxLimit();
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", pickImagesMaxLimit);
            }
        }
        if (zEquals) {
            intent.setType("image/*");
        } else if (zEquals2) {
            intent.setType("video/*");
        } else if (i2 < 33) {
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        }
        try {
            currentActivity.startActivityForResult(intent, 13003);
        } catch (ActivityNotFoundException e2) {
            callback.invoke(Utils.d("others", e2.getMessage()));
            imagePickerModuleImpl.f45932c = null;
        }
    }
}
