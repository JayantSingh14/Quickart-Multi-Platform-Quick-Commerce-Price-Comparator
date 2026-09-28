package bridges;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.util.List;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class AppInfoModule extends ReactContextBaseJavaModule {
    public final String MODULE_NAME_CONSTANT;

    public AppInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.MODULE_NAME_CONSTANT = "AppInfoModule";
    }

    @ReactMethod
    public void getAppsInstalledAndroidList(Promise promise) {
        try {
            PackageManager packageManager = getReactApplicationContext().getPackageManager();
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(128);
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (ApplicationInfo applicationInfo : installedApplications) {
                if ((applicationInfo.flags & 1) == 0) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putString(CLConstants.FIELD_PAY_INFO_NAME, applicationInfo.loadLabel(packageManager).toString());
                    writableMapCreateMap.putString("packageName", applicationInfo.packageName);
                    writableArrayCreateArray.pushMap(writableMapCreateMap);
                }
            }
            promise.resolve(writableArrayCreateArray);
        } catch (Exception e2) {
            promise.reject("ERROR: ", e2);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AppInfoModule";
    }

    @ReactMethod
    public void getPackageInfo(Promise promise) {
        try {
            PackageManager packageManager = getReactApplicationContext().getPackageManager();
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            String packageName = reactApplicationContext.getPackageName();
            String str = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(reactApplicationContext.getPackageName(), 0));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("packageName", packageName);
            writableMapCreateMap.putString("displayName", str);
            if (externalFilesDir != null) {
                writableMapCreateMap.putString("externalFileDir", externalFilesDir.getAbsolutePath());
            } else {
                writableMapCreateMap.putString("externalFileDir", "NOT FOUND");
            }
            writableMapCreateMap.putString("privateDir", reactApplicationContext.getDataDir().getAbsolutePath());
            writableMapCreateMap.putString("packageCodePath", reactApplicationContext.getPackageCodePath());
            writableMapCreateMap.putString("storageState", Environment.getExternalStorageState());
            promise.resolve(writableMapCreateMap);
        } catch (Exception e2) {
            promise.reject(e2);
        }
    }
}
