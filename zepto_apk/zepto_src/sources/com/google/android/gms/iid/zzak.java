package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class zzak {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f22557a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f22558b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayMap f22559c = new ArrayMap();

    public zzak(Context context) {
        this.f22558b = context;
        this.f22557a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(context.getNoBackupFilesDir(), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || this.f22557a.getAll().isEmpty()) {
                return;
            }
            Log.i("InstanceID/Store", "App restored, clearing state");
            int i2 = InstanceIDListenerService.f22553f;
            b();
            Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
            intent.putExtra("CMD", "RST");
            intent.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
            context.sendBroadcast(intent);
        } catch (IOException e2) {
            if (Log.isLoggable("InstanceID/Store", 3)) {
                String strValueOf = String.valueOf(e2.getMessage());
                Log.d("InstanceID/Store", strValueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    public final synchronized void a(String str) {
        try {
            SharedPreferences.Editor editorEdit = this.f22557a.edit();
            for (String str2 : this.f22557a.getAll().keySet()) {
                if (str2.startsWith(str)) {
                    editorEdit.remove(str2);
                }
            }
            editorEdit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b() {
        this.f22559c.clear();
        Context context = this.f22558b;
        File noBackupFilesDir = context.getNoBackupFilesDir();
        if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
            Log.w("InstanceID", "noBackupFilesDir doesn't exist, using regular files directory instead");
            noBackupFilesDir = context.getFilesDir();
        }
        for (File file : noBackupFilesDir.listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
        this.f22557a.edit().clear().commit();
    }
}
