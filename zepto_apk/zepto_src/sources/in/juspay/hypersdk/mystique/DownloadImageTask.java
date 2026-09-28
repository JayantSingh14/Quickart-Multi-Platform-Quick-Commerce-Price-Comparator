package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import in.juspay.hypersdk.core.DuiCallback;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private static int downloadCount;
    private final BaseAdapter adapter;
    private final BitmapCache bitmapCache;
    private final WeakReference<Context> contextWeakReference;
    private final DuiCallback duiCallback;
    private String imageUrl;
    boolean isTriggerNotify;
    private final Integer palceHolder;

    public DownloadImageTask(BaseAdapter baseAdapter, Integer num, Context context, BitmapCache bitmapCache, DuiCallback duiCallback, ImageView imageView) {
        this.adapter = baseAdapter;
        this.palceHolder = num;
        this.contextWeakReference = new WeakReference<>(context);
        this.bitmapCache = bitmapCache;
        this.duiCallback = duiCallback;
        int i2 = downloadCount;
        if (i2 == 0) {
            this.isTriggerNotify = true;
        } else {
            this.isTriggerNotify = false;
        }
        downloadCount = (i2 + 1) % 5;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap getImage(java.lang.String r5) throws java.lang.Throwable {
        /*
            r4 = this;
            in.juspay.hypersdk.mystique.BitmapCache r0 = r4.bitmapCache
            android.graphics.Bitmap r0 = r0.get(r5)
            r1 = 0
            if (r0 != 0) goto L64
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            java.net.URLConnection r5 = r0.openConnection()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r0 = 1
            r5.setDoInput(r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2d
            r5.connect()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2d
            java.io.InputStream r0 = r5.getInputStream()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2d
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2d
            r5.disconnect()
            return r0
        L27:
            r0 = move-exception
            r1 = r5
            goto L5e
        L2a:
            r0 = move-exception
            goto L5e
        L2c:
            r5 = r1
        L2d:
            java.lang.ref.WeakReference<android.content.Context> r0 = r4.contextWeakReference     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L4b
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L4b
            android.content.Context r0 = (android.content.Context) r0     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L4b
            if (r0 == 0) goto L58
            android.content.res.Resources r0 = r0.getResources()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L4b
            java.lang.Integer r2 = r4.palceHolder     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L4b
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L4b
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r2)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L4b
            if (r5 == 0) goto L4a
            r5.disconnect()
        L4a:
            return r0
        L4b:
            in.juspay.hypersdk.core.DuiCallback r0 = r4.duiCallback     // Catch: java.lang.Throwable -> L27
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()     // Catch: java.lang.Throwable -> L27
            java.lang.String r2 = "IMG_ERR"
            java.lang.String r3 = "Not able to apply placeholder"
            r0.e(r2, r3)     // Catch: java.lang.Throwable -> L27
        L58:
            if (r5 == 0) goto L64
            r5.disconnect()
            goto L64
        L5e:
            if (r1 == 0) goto L63
            r1.disconnect()
        L63:
            throw r0
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.DownloadImageTask.getImage(java.lang.String):android.graphics.Bitmap");
    }

    @Override // android.os.AsyncTask
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        this.imageUrl = str;
        return getImage(str);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute((DownloadImageTask) bitmap);
        if (bitmap != null) {
            this.bitmapCache.put(this.imageUrl, bitmap);
            BaseAdapter baseAdapter = this.adapter;
            if (baseAdapter == null) {
                this.duiCallback.getLogger().e("IMG_ERR", "Fetching image from url failed. Null adapter passed");
            } else if (this.isTriggerNotify) {
                baseAdapter.notifyDataSetChanged();
            }
        }
    }
}
