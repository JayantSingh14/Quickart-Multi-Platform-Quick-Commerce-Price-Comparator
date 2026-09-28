package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionListener;
import com.reactnativecommunity.webview.RNCWebViewModuleImpl;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = "RNCWebView")
/* loaded from: classes.dex */
public class RNCWebViewModule extends ReactContextBaseJavaModule {
    private final RNCWebViewModuleImpl mRNCWebViewModuleImpl;

    public RNCWebViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mRNCWebViewModuleImpl = new RNCWebViewModuleImpl(reactApplicationContext);
    }

    public void downloadFile(String str) {
        this.mRNCWebViewModuleImpl.b(str);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "RNCWebView";
    }

    public boolean grantFileDownloaderPermissions(final String str, final String str2) {
        final RNCWebViewModuleImpl rNCWebViewModuleImpl = this.mRNCWebViewModuleImpl;
        Activity currentActivity = rNCWebViewModuleImpl.f46283a.getCurrentActivity();
        if (Build.VERSION.SDK_INT > 28) {
            return true;
        }
        boolean z = ContextCompat.a(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        if (!z) {
            rNCWebViewModuleImpl.f().d(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1, new PermissionListener() { // from class: com.reactnativecommunity.webview.RNCWebViewModuleImpl.1
                @Override // com.facebook.react.modules.core.PermissionListener
                public final boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    if (i2 != 1) {
                        return false;
                    }
                    int length = iArr.length;
                    RNCWebViewModuleImpl rNCWebViewModuleImpl2 = RNCWebViewModuleImpl.this;
                    if (length <= 0 || iArr[0] != 0) {
                        Toast.makeText(rNCWebViewModuleImpl2.f46283a, str2, 1).show();
                    } else if (rNCWebViewModuleImpl2.f46284b != null) {
                        rNCWebViewModuleImpl2.b(str);
                    }
                    return true;
                }
            });
        }
        return z;
    }

    @ReactMethod
    public void isFileUploadSupported(Promise promise) {
        this.mRNCWebViewModuleImpl.getClass();
        promise.resolve(Boolean.TRUE);
    }

    public void setDownloadRequest(DownloadManager.Request request) {
        this.mRNCWebViewModuleImpl.f46284b = request;
    }

    @ReactMethod
    public void shouldStartLoadWithLockIdentifier(boolean z, double d2) {
        AtomicReference atomicReference;
        this.mRNCWebViewModuleImpl.getClass();
        RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock shouldOverrideUrlLoadingLock = RNCWebViewModuleImpl.f46282g;
        Double dValueOf = Double.valueOf(d2);
        synchronized (shouldOverrideUrlLoadingLock) {
            atomicReference = (AtomicReference) shouldOverrideUrlLoadingLock.f46306b.get(dValueOf);
        }
        if (atomicReference != null) {
            synchronized (atomicReference) {
                try {
                    atomicReference.set(z ? RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.f46309c : RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.f46308b);
                    atomicReference.notify();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void startPhotoPickerIntent(ValueCallback<Uri> valueCallback, String str) {
        String mimeTypeFromExtension;
        Intent intentG;
        Intent intentH;
        RNCWebViewModuleImpl rNCWebViewModuleImpl = this.mRNCWebViewModuleImpl;
        rNCWebViewModuleImpl.f46285c = valueCallback;
        Activity currentActivity = rNCWebViewModuleImpl.f46283a.getCurrentActivity();
        String mimeTypeFromExtension2 = str.isEmpty() ? RNCWebViewModuleImpl.MimeType.DEFAULT.f46304a : str;
        if (str.matches("\\.\\w+")) {
            String strReplace = str.replace(CLConstants.DOT_SALT_DELIMETER, "");
            mimeTypeFromExtension2 = strReplace != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(strReplace) : null;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(mimeTypeFromExtension2);
        Intent intentCreateChooser = Intent.createChooser(intent, "");
        ArrayList arrayList = new ArrayList();
        if (str.matches("\\.\\w+")) {
            String strReplace2 = str.replace(CLConstants.DOT_SALT_DELIMETER, "");
            mimeTypeFromExtension = strReplace2 != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(strReplace2) : null;
        } else {
            mimeTypeFromExtension = str;
        }
        if ((mimeTypeFromExtension.isEmpty() || mimeTypeFromExtension.toLowerCase().contains(RNCWebViewModuleImpl.MimeType.IMAGE.f46304a)) && (intentG = rNCWebViewModuleImpl.g()) != null) {
            arrayList.add(intentG);
        }
        if (str.matches("\\.\\w+")) {
            String strReplace3 = str.replace(CLConstants.DOT_SALT_DELIMETER, "");
            str = strReplace3 != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(strReplace3) : null;
        }
        if ((str.isEmpty() || str.toLowerCase().contains(RNCWebViewModuleImpl.MimeType.VIDEO.f46304a)) && (intentH = rNCWebViewModuleImpl.h()) != null) {
            arrayList.add(intentH);
        }
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (intentCreateChooser.resolveActivity(currentActivity.getPackageManager()) != null) {
            currentActivity.startActivityForResult(intentCreateChooser, 3);
        } else {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        }
    }

    public boolean startPhotoPickerIntent(ValueCallback<Uri[]> valueCallback, String[] strArr, boolean z, boolean z2) {
        this.mRNCWebViewModuleImpl.j(valueCallback, strArr, z, z2);
        return true;
    }
}
