package com.ReactNativeBlobUtil;

import android.content.res.AssetFileDescriptor;
import android.os.Environment;
import coil3.util.UtilsKt;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: classes.dex */
class ReactNativeBlobUtilFS {
    public static void a(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        if (file.delete()) {
            return;
        }
        throw new IOException("Failed to delete '" + file + "'");
    }

    public static String b(ReactApplicationContext reactApplicationContext, String str) {
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(str);
        return externalFilesDir != null ? externalFilesDir.getAbsolutePath() : "";
    }

    public static HashMap c() {
        HashMap map = new HashMap();
        map.put("LegacyDCIMDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        map.put("LegacyPictureDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        map.put("LegacyMusicDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        map.put("LegacyDownloadDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        map.put("LegacyMovieDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        map.put("LegacyRingtoneDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            map.put("LegacySDCardDir", Environment.getExternalStorageDirectory().getAbsolutePath());
            return map;
        }
        map.put("LegacySDCardDir", "");
        return map;
    }

    public static String d(String str) {
        return ReactNativeBlobUtilImpl.f13918b.getFilesDir() + "/ReactNativeBlobUtilTmp_" + str;
    }

    public static InputStream e(String str) {
        return str.startsWith("bundle-assets://") ? ReactNativeBlobUtilImpl.f13918b.getAssets().open(str.replace("bundle-assets://", "")) : new FileInputStream(new File(str));
    }

    public static boolean f(String str) throws IOException {
        if (!str.startsWith("bundle-assets://")) {
            return new File(str).exists();
        }
        try {
            ReactNativeBlobUtilImpl.f13918b.getAssets().open(str.replace("bundle-assets://", ""));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static WritableMap g(String str) throws IOException {
        try {
            String strC = ReactNativeBlobUtilUtils.c(str);
            WritableMap writableMapCreateMap = Arguments.createMap();
            if (strC != null && strC.startsWith("bundle-assets://")) {
                String strReplace = strC.replace("bundle-assets://", "");
                AssetFileDescriptor assetFileDescriptorOpenFd = ReactNativeBlobUtilImpl.f13918b.getAssets().openFd(strReplace);
                writableMapCreateMap.putString("filename", strReplace);
                writableMapCreateMap.putString("path", strC);
                writableMapCreateMap.putString("type", "asset");
                writableMapCreateMap.putString("size", String.valueOf(assetFileDescriptorOpenFd.getLength()));
                writableMapCreateMap.putInt("lastModified", 0);
                return writableMapCreateMap;
            }
            File file = new File(strC);
            if (!file.exists()) {
                return null;
            }
            writableMapCreateMap.putString("filename", file.getName());
            writableMapCreateMap.putString("path", file.getPath());
            writableMapCreateMap.putString("type", file.isDirectory() ? "directory" : UtilsKt.SCHEME_FILE);
            writableMapCreateMap.putString("size", String.valueOf(file.length()));
            writableMapCreateMap.putString("lastModified", String.valueOf(file.lastModified()));
            return writableMapCreateMap;
        } catch (Exception unused) {
            return null;
        }
    }
}
