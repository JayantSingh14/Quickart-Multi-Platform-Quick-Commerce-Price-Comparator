package com.rnmaps.maps;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* loaded from: classes4.dex */
public class FileUtil extends AsyncTask<String, Void, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f46469a;

    public FileUtil(Context context) {
        this.f46469a = context;
    }

    public static FileInputStream a(Context context, Uri uri) throws IOException {
        File fileCreateTempFile = File.createTempFile("FileUtil", "temp", context.getApplicationContext().getCacheDir());
        fileCreateTempFile.deleteOnExit();
        InputStream inputStreamOpenStream = new URL(uri.toString()).openStream();
        try {
            ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStreamOpenStream);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    fileOutputStream.getChannel().transferFrom(readableByteChannelNewChannel, 0L, Long.MAX_VALUE);
                    FileInputStream fileInputStream = new FileInputStream(fileCreateTempFile);
                    fileOutputStream.close();
                    readableByteChannelNewChannel.close();
                    inputStreamOpenStream.close();
                    return fileInputStream;
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Throwable th2) {
                readableByteChannelNewChannel.close();
                throw th2;
            }
        } catch (Throwable th3) {
            inputStreamOpenStream.close();
            throw th3;
        }
    }

    @Override // android.os.AsyncTask
    public final InputStream doInBackground(String[] strArr) {
        String[] strArr2 = strArr;
        try {
            Uri uri = Uri.parse(strArr2[0]);
            boolean zStartsWith = uri.getScheme().startsWith("http");
            Context context = this.f46469a;
            return zStartsWith ? a(context, uri) : context.getContentResolver().openInputStream(uri);
        } catch (Exception e2) {
            FLog.h("ReactNative", "Could not retrieve file for contentUri " + strArr2[0], e2);
            return null;
        }
    }
}
