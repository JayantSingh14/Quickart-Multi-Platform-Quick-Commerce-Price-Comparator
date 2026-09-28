package in.juspay.hypersdk.mystique;

import android.graphics.Bitmap;
import android.util.LruCache;

/* loaded from: classes4.dex */
public class BitmapCache {
    private static BitmapCache bitmapCache;
    private LruCache<String, Bitmap> bitmapStore;

    private BitmapCache() {
        initializeCache(50);
    }

    public static BitmapCache getInstance() {
        if (bitmapCache == null) {
            bitmapCache = new BitmapCache();
        }
        return bitmapCache;
    }

    public void clear() {
        this.bitmapStore.evictAll();
    }

    public Bitmap get(String str) {
        return this.bitmapStore.get(str);
    }

    public void getSize() {
        this.bitmapStore.size();
    }

    public void initializeCache(int i2) {
        this.bitmapStore = new LruCache<>(i2);
    }

    public void put(String str, Bitmap bitmap) {
        this.bitmapStore.put(str, bitmap);
    }
}
