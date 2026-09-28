package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class a extends AsyncTask<String, Bitmap, Bitmap> {

    /* renamed from: b, reason: collision with root package name */
    private String f57491b;

    /* renamed from: d, reason: collision with root package name */
    private Context f57493d;

    /* renamed from: a, reason: collision with root package name */
    private String f57490a = "(https)?:\\/\\/.*\\.(?:png|jpg)";

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f57492c = null;

    public a(Context context, String str) {
        this.f57493d = context;
        this.f57491b = str;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                try {
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            q.a("NPCIFragment", e2);
                        }
                    }
                    throw th;
                }
            } catch (MalformedURLException e3) {
                q.a("NPCIFragment", e3);
                if (0 != 0) {
                    inputStream.close();
                }
            } catch (IOException e4) {
                q.a("NPCIFragment", e4);
                if (0 != 0) {
                    inputStream.close();
                }
            }
        } catch (IOException e5) {
            q.a("NPCIFragment", e5);
        }
        if (!Pattern.compile(this.f57490a).matcher(this.f57491b).matches()) {
            throw new IOException("Pattern didn't match");
        }
        InputStream inputStream2 = new URL(this.f57491b).openConnection().getInputStream();
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream2);
        this.f57492c = bitmapDecodeStream;
        if (bitmapDecodeStream != null) {
            this.f57492c = Bitmap.createScaledBitmap(bitmapDecodeStream, 50, 50, false);
        }
        if (inputStream2 != null) {
            inputStream2.close();
        }
        return this.f57492c;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) throws Resources.NotFoundException {
        try {
            if (bitmap != null) {
                ((ImageView) ((GetCredential) this.f57493d).findViewById(R.id.bank_image)).setImageBitmap(bitmap);
            } else {
                Resources resources = ((GetCredential) this.f57493d).getResources();
                ((ImageView) ((GetCredential) this.f57493d).findViewById(R.id.bank_image)).setImageDrawable(resources.getDrawable(resources.getIdentifier(this.f57491b, "drawable", ((GetCredential) this.f57493d).getPackageName())));
            }
            ((ImageView) ((GetCredential) this.f57493d).findViewById(R.id.bank_image)).setVisibility(0);
        } catch (Exception e2) {
            q.a("NPCIFragment", e2);
        }
    }
}
