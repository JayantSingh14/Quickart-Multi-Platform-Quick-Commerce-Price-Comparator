package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import in.juspay.airborne.ota.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class RNCWebViewModuleImpl implements ActivityEventListener {

    /* renamed from: g, reason: collision with root package name */
    public static final ShouldOverrideUrlLoadingLock f46282g = new ShouldOverrideUrlLoadingLock();

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f46283a;

    /* renamed from: b, reason: collision with root package name */
    public DownloadManager.Request f46284b;

    /* renamed from: c, reason: collision with root package name */
    public ValueCallback f46285c;

    /* renamed from: d, reason: collision with root package name */
    public ValueCallback f46286d;

    /* renamed from: e, reason: collision with root package name */
    public File f46287e;

    /* renamed from: f, reason: collision with root package name */
    public File f46288f;

    /* renamed from: com.reactnativecommunity.webview.RNCWebViewModuleImpl$5, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass5 implements PermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f46294a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f46295b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f46296c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f46297d;

        public AnonymousClass5(String[] strArr, boolean z, ValueCallback valueCallback, boolean z2) {
            this.f46294a = strArr;
            this.f46295b = z;
            this.f46296c = valueCallback;
            this.f46297d = z2;
        }

        @Override // com.reactnativecommunity.webview.PermissionCallback
        public final void a(boolean z) {
            RNCWebViewModuleImpl rNCWebViewModuleImpl = RNCWebViewModuleImpl.this;
            if (!z) {
                rNCWebViewModuleImpl.f46286d.onReceiveValue(null);
                rNCWebViewModuleImpl.f46286d = null;
            } else {
                rNCWebViewModuleImpl.j(this.f46296c, this.f46294a, this.f46295b, this.f46297d);
            }
        }
    }

    /* renamed from: com.reactnativecommunity.webview.RNCWebViewModuleImpl$6, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46299a;

        static {
            int[] iArr = new int[MimeType.values().length];
            f46299a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46299a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public enum MimeType {
        DEFAULT("*/*"),
        IMAGE("image"),
        VIDEO("video");


        /* renamed from: a, reason: collision with root package name */
        public final String f46304a;

        MimeType(String str) {
            this.f46304a = str;
        }
    }

    public static class ShouldOverrideUrlLoadingLock {

        /* renamed from: a, reason: collision with root package name */
        public double f46305a = 1.0d;

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f46306b = new HashMap();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* loaded from: classes4.dex */
        public static final class ShouldOverrideCallbackState {

            /* renamed from: a, reason: collision with root package name */
            public static final ShouldOverrideCallbackState f46307a;

            /* renamed from: b, reason: collision with root package name */
            public static final ShouldOverrideCallbackState f46308b;

            /* renamed from: c, reason: collision with root package name */
            public static final ShouldOverrideCallbackState f46309c;

            /* renamed from: d, reason: collision with root package name */
            public static final /* synthetic */ ShouldOverrideCallbackState[] f46310d;

            static {
                ShouldOverrideCallbackState shouldOverrideCallbackState = new ShouldOverrideCallbackState("UNDECIDED", 0);
                f46307a = shouldOverrideCallbackState;
                ShouldOverrideCallbackState shouldOverrideCallbackState2 = new ShouldOverrideCallbackState("SHOULD_OVERRIDE", 1);
                f46308b = shouldOverrideCallbackState2;
                ShouldOverrideCallbackState shouldOverrideCallbackState3 = new ShouldOverrideCallbackState("DO_NOT_OVERRIDE", 2);
                f46309c = shouldOverrideCallbackState3;
                f46310d = new ShouldOverrideCallbackState[]{shouldOverrideCallbackState, shouldOverrideCallbackState2, shouldOverrideCallbackState3};
            }

            public static ShouldOverrideCallbackState valueOf(String str) {
                return (ShouldOverrideCallbackState) Enum.valueOf(ShouldOverrideCallbackState.class, str);
            }

            public static ShouldOverrideCallbackState[] values() {
                return (ShouldOverrideCallbackState[]) f46310d.clone();
            }
        }
    }

    public RNCWebViewModuleImpl(ReactApplicationContext reactApplicationContext) {
        this.f46283a = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    public static Boolean a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str2.contains(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static String[] c(String[] strArr) {
        String str;
        if (strArr.length != 0) {
            if (strArr.length != 1 || (str = strArr[0]) == null || str.length() != 0) {
                String[] strArr2 = new String[strArr.length];
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String str2 = strArr[i2];
                    if (str2.matches("\\.\\w+")) {
                        String strReplace = str2.replace(CLConstants.DOT_SALT_DELIMETER, "");
                        String mimeTypeFromExtension = strReplace != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(strReplace) : null;
                        if (mimeTypeFromExtension != null) {
                            strArr2[i2] = mimeTypeFromExtension;
                        } else {
                            strArr2[i2] = str2;
                        }
                    } else {
                        strArr2[i2] = str2;
                    }
                }
                return strArr2;
            }
        }
        return new String[]{MimeType.DEFAULT.f46304a};
    }

    public final void b(String str) {
        ReactApplicationContext reactApplicationContext = this.f46283a;
        try {
            ((DownloadManager) reactApplicationContext.getSystemService("download")).enqueue(this.f46284b);
            Toast.makeText(reactApplicationContext, str, 1).show();
        } catch (IllegalArgumentException | SecurityException e2) {
            Log.w("RNCWebViewModule", "Unsupported URI, aborting download", e2);
        }
    }

    public final File d(MimeType mimeType) {
        String str;
        String str2;
        int iOrdinal = mimeType.ordinal();
        if (iOrdinal == 1) {
            String str3 = Environment.DIRECTORY_PICTURES;
            str = "image-";
            str2 = ".jpg";
        } else if (iOrdinal != 2) {
            str = "";
            str2 = "";
        } else {
            String str4 = Environment.DIRECTORY_MOVIES;
            str = "video-";
            str2 = ".mp4";
        }
        String.valueOf(System.currentTimeMillis());
        return File.createTempFile(str, str2, this.f46283a.getExternalFilesDir(null));
    }

    public final Uri e(File file) {
        ReactApplicationContext reactApplicationContext = this.f46283a;
        return FileProvider.d(reactApplicationContext, reactApplicationContext.getPackageName() + ".fileprovider", file);
    }

    public final PermissionAwareActivity f() {
        ComponentCallbacks2 currentActivity = this.f46283a.getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        }
        if (currentActivity instanceof PermissionAwareActivity) {
            return (PermissionAwareActivity) currentActivity;
        }
        throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
    }

    public final Intent g() {
        Intent intent;
        Throwable e2;
        Uri uriE;
        try {
            File fileD = d(MimeType.IMAGE);
            this.f46287e = fileD;
            uriE = e(fileD);
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
        } catch (IOException | IllegalArgumentException e3) {
            intent = null;
            e2 = e3;
        }
        try {
            intent.putExtra("output", uriE);
            return intent;
        } catch (IOException e4) {
            e2 = e4;
            Log.e("CREATE FILE", "Error occurred while creating the File", e2);
            e2.printStackTrace();
            return intent;
        } catch (IllegalArgumentException e5) {
            e2 = e5;
            Log.e("CREATE FILE", "Error occurred while creating the File", e2);
            e2.printStackTrace();
            return intent;
        }
    }

    public final Intent h() {
        Intent intent;
        Throwable e2;
        Uri uriE;
        try {
            File fileD = d(MimeType.VIDEO);
            this.f46288f = fileD;
            uriE = e(fileD);
            intent = new Intent("android.media.action.VIDEO_CAPTURE");
        } catch (IOException | IllegalArgumentException e3) {
            intent = null;
            e2 = e3;
        }
        try {
            intent.putExtra("output", uriE);
            return intent;
        } catch (IOException e4) {
            e2 = e4;
            Log.e("CREATE FILE", "Error occurred while creating the File", e2);
            e2.printStackTrace();
            return intent;
        } catch (IllegalArgumentException e5) {
            e2 = e5;
            Log.e("CREATE FILE", "Error occurred while creating the File", e2);
            e2.printStackTrace();
            return intent;
        }
    }

    public final void i(PermissionCallback permissionCallback) {
        ((AnonymousClass5) permissionCallback).a(false);
        Activity currentActivity = this.f46283a.getCurrentActivity();
        if (currentActivity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
            builder.b("Camera permission is required to capture photos. Please grant the permission in the app settings.");
            builder.setTitle("Permission Required").d("OK", new DialogInterface.OnClickListener() { // from class: com.reactnativecommunity.webview.RNCWebViewModuleImpl.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    ReactApplicationContext reactApplicationContext = RNCWebViewModuleImpl.this.f46283a;
                    Activity currentActivity2 = reactApplicationContext.getCurrentActivity();
                    if (currentActivity2 != null) {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts(Constants.PACKAGE_DIR_NAME, reactApplicationContext.getPackageName(), null));
                        currentActivity2.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent2.setData(Uri.fromParts(Constants.PACKAGE_DIR_NAME, reactApplicationContext.getPackageName(), null));
                        intent2.addFlags(268435456);
                        reactApplicationContext.startActivity(intent2);
                    }
                }
            }).c("Cancel", new DialogInterface.OnClickListener() { // from class: com.reactnativecommunity.webview.RNCWebViewModuleImpl.3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.create().show();
        }
    }

    public final void j(ValueCallback valueCallback, String[] strArr, boolean z, boolean z2) {
        Intent intentH;
        this.f46286d = valueCallback;
        ReactApplicationContext reactApplicationContext = this.f46283a;
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        boolean z3 = ContextCompat.a(reactApplicationContext, "android.permission.CAMERA") == 0;
        if (!z3 && z2) {
            final AnonymousClass5 anonymousClass5 = new AnonymousClass5(strArr, z, valueCallback, z2);
            try {
                Activity currentActivity2 = reactApplicationContext.getCurrentActivity();
                if (currentActivity2 == null) {
                    i(anonymousClass5);
                    return;
                } else if (ActivityCompat.l(currentActivity2, "android.permission.CAMERA")) {
                    i(anonymousClass5);
                    return;
                } else {
                    f().d(new String[]{"android.permission.CAMERA"}, 5, new PermissionListener() { // from class: com.reactnativecommunity.webview.RNCWebViewModuleImpl.2
                        @Override // com.facebook.react.modules.core.PermissionListener
                        public final boolean onRequestPermissionsResult(int i2, String[] strArr2, int[] iArr) {
                            PermissionCallback permissionCallback = anonymousClass5;
                            if (i2 != 5) {
                                permissionCallback.a(false);
                                return false;
                            }
                            if (iArr.length <= 0 || iArr[0] != 0) {
                                permissionCallback.a(false);
                                return true;
                            }
                            permissionCallback.a(true);
                            return true;
                        }
                    });
                    return;
                }
            } catch (Exception unused) {
                i(anonymousClass5);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        MimeType mimeType = MimeType.DEFAULT;
        Intent intentG = null;
        if (z3) {
            String[] strArrC = c(strArr);
            if ((a(mimeType.f46304a, strArrC).booleanValue() || a(MimeType.IMAGE.f46304a, strArrC).booleanValue()) && (intentG = g()) != null) {
                arrayList.add(intentG);
            }
            String[] strArrC2 = c(strArr);
            if ((a(mimeType.f46304a, strArrC2).booleanValue() || a(MimeType.VIDEO.f46304a, strArrC2).booleanValue()) && (intentH = h()) != null) {
                arrayList.add(intentH);
            }
        }
        Intent intent = new Intent("android.intent.action.CHOOSER");
        if (!z2) {
            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.addCategory("android.intent.category.OPENABLE");
            intent2.setType(mimeType.f46304a);
            intent2.putExtra("android.intent.extra.MIME_TYPES", c(strArr));
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
            intent.putExtra("android.intent.extra.INTENT", intent2);
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
            intentG = intent;
        }
        if (intentG == null) {
            Log.w("RNCWebViewModule", "there is no Camera permission");
        } else if (intentG.resolveActivity(currentActivity.getPackageManager()) != null) {
            currentActivity.startActivityForResult(intentG, 1);
        } else {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009f  */
    @Override // com.facebook.react.bridge.ActivityEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityResult(android.app.Activity r7, int r8, int r9, android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewModuleImpl.onActivityResult(android.app.Activity, int, int, android.content.Intent):void");
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public final void onNewIntent(Intent intent) {
    }
}
