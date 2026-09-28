package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f15848a;

    /* renamed from: b, reason: collision with root package name */
    public final ThumbnailStreamOpener f15849b;

    /* renamed from: c, reason: collision with root package name */
    public InputStream f15850c;

    public static class ImageThumbnailQuery implements ThumbnailQuery {

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f15851b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f15852a;

        public ImageThumbnailQuery(ContentResolver contentResolver) {
            this.f15852a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public final Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f15852a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f15851b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    public static class VideoThumbnailQuery implements ThumbnailQuery {

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f15853b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f15854a;

        public VideoThumbnailQuery(ContentResolver contentResolver) {
            this.f15854a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public final Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f15854a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f15853b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    public ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.f15848a = uri;
        this.f15849b = thumbnailStreamOpener;
    }

    public static ThumbFetcher c(Context context, Uri uri) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.b(context).f15651d.b(), new ImageThumbnailQuery(context.getContentResolver()), Glide.b(context).f15652e, context.getContentResolver()));
    }

    public static ThumbFetcher f(Context context, Uri uri) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.b(context).f15651d.b(), new VideoThumbnailQuery(context.getContentResolver()), Glide.b(context).f15652e, context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void b() throws IOException {
        InputStream inputStream = this.f15850c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource d() {
        return DataSource.f15788a;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void e(Priority priority, DataFetcher.DataCallback dataCallback) throws Throwable {
        try {
            InputStream inputStreamG = g();
            this.f15850c = inputStreamG;
            dataCallback.f(inputStreamG);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            dataCallback.c(e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0022: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:35), block:B:10:0x0022 */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0029 A[PHI: r6
      0x0029: PHI (r6v6 android.database.Cursor) = (r6v2 android.database.Cursor), (r6v8 android.database.Cursor) binds: [B:23:0x0048, B:13:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.NullPointerException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.InputStream g() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbFetcher.g():java.io.InputStream");
    }
}
