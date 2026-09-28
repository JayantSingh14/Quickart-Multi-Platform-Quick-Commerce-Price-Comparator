package fr.greweb.reactnativeviewshot;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class RNViewShotModule extends NativeRNViewShotSpec {
    private static final String TEMP_FILE_PREFIX = "ReactNative-snapshot-image";
    private final Executor executor;
    private final ReactApplicationContext reactContext;

    public static class CleanTask extends GuardedAsyncTask<Void, Void> implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        public final File f48368a;

        /* renamed from: b, reason: collision with root package name */
        public final File f48369b;

        public CleanTask(ReactApplicationContext reactApplicationContext) {
            super(reactApplicationContext);
            this.f48368a = reactApplicationContext.getCacheDir();
            this.f48369b = reactApplicationContext.getExternalCacheDir();
        }

        public final void a(File file) {
            File[] fileArrListFiles = file.listFiles(this);
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.delete()) {
                        Log.d(NativeRNViewShotSpec.NAME, "deleted file: " + file2.getAbsolutePath());
                    }
                }
            }
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith(RNViewShotModule.TEMP_FILE_PREFIX);
        }

        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public final void doInBackgroundGuarded(Void[] voidArr) {
            File file = this.f48368a;
            if (file != null) {
                a(file);
            }
            File file2 = this.f48369b;
            if (file2 != null) {
                a(file2);
            }
        }
    }

    public RNViewShotModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.executor = Executors.newCachedThreadPool();
        this.reactContext = reactApplicationContext;
    }

    @NonNull
    private File createTempFile(@NonNull Context context, @NonNull String str, String str2) throws IOException {
        File externalCacheDir = context.getExternalCacheDir();
        File cacheDir = context.getCacheDir();
        if (externalCacheDir == null && cacheDir == null) {
            throw new IOException("No cache directory available");
        }
        if (externalCacheDir == null || (cacheDir != null && externalCacheDir.getFreeSpace() <= cacheDir.getFreeSpace())) {
            externalCacheDir = cacheDir;
        }
        String strC = b.C(CLConstants.DOT_SALT_DELIMETER, str);
        return str2 != null ? File.createTempFile(str2, strC, externalCacheDir) : File.createTempFile(TEMP_FILE_PREFIX, strC, externalCacheDir);
    }

    @Override // fr.greweb.reactnativeviewshot.NativeRNViewShotSpec
    @ReactMethod
    public void captureRef(Double d2, ReadableMap readableMap, Promise promise) {
        int i2 = -1;
        int iIntValue = d2 == null ? -1 : d2.intValue();
        getReactApplicationContext().getResources().getDisplayMetrics();
        String string = readableMap.getString("format");
        if ("jpg".equals(string)) {
            i2 = 0;
        } else if ("webm".equals(string)) {
            i2 = 2;
        } else if (!"raw".equals(string)) {
            i2 = 1;
        }
        double d3 = readableMap.getDouble("quality");
        Integer numValueOf = readableMap.hasKey(Snapshot.WIDTH) ? Integer.valueOf(readableMap.getInt(Snapshot.WIDTH)) : null;
        Integer numValueOf2 = readableMap.hasKey(Snapshot.HEIGHT) ? Integer.valueOf(readableMap.getInt(Snapshot.HEIGHT)) : null;
        String string2 = readableMap.getString("result");
        String string3 = readableMap.hasKey("fileName") ? readableMap.getString("fileName") : null;
        Boolean boolValueOf = Boolean.valueOf(readableMap.getBoolean("snapshotContentContainer"));
        boolean z = readableMap.hasKey("handleGLSurfaceViewOnAndroid") && readableMap.getBoolean("handleGLSurfaceViewOnAndroid");
        try {
            File fileCreateTempFile = "tmpfile".equals(string2) ? createTempFile(getReactApplicationContext(), string, string3) : null;
            ((UIManagerModule) this.reactContext.getNativeModule(UIManagerModule.class)).addUIBlock(new ViewShot(iIntValue, string, i2, d3, numValueOf, numValueOf2, fileCreateTempFile, string2, boolValueOf, getCurrentActivity(), z, promise, this.executor));
        } catch (Throwable th) {
            Log.e(NativeRNViewShotSpec.NAME, "Failed to snapshot view tag " + iIntValue, th);
            promise.reject("E_UNABLE_TO_SNAPSHOT", "Failed to snapshot view tag " + iIntValue);
        }
    }

    @Override // fr.greweb.reactnativeviewshot.NativeRNViewShotSpec
    @ReactMethod
    public void captureScreen(ReadableMap readableMap, Promise promise) {
        captureRef(Double.valueOf(-1.0d), readableMap, promise);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        new CleanTask(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // fr.greweb.reactnativeviewshot.NativeRNViewShotSpec
    @ReactMethod
    public void releaseCapture(String str) {
        String path = Uri.parse(str).getPath();
        if (path == null) {
            return;
        }
        File file = new File(path);
        if (file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile.equals(this.reactContext.getExternalCacheDir()) || parentFile.equals(this.reactContext.getCacheDir())) {
                file.delete();
            }
        }
    }
}
