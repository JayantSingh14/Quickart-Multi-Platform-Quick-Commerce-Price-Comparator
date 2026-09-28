package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.media.a;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.List;

/* loaded from: classes3.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16340a;

    public ResourceDrawableDecoder(Context context) {
        this.f16340a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(Object obj, Options options) {
        return ((Uri) obj).getScheme().equals("android.resource");
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ Resource b(Object obj, int i2, int i3, Options options) {
        return c((Uri) obj);
    }

    public final Resource c(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException {
        Context contextCreatePackageContext;
        int identifier;
        Drawable drawable;
        String authority = uri.getAuthority();
        Context context = this.f16340a;
        if (authority.equals(context.getPackageName())) {
            contextCreatePackageContext = context;
        } else {
            try {
                contextCreatePackageContext = context.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                if (!authority.contains(context.getPackageName())) {
                    throw new IllegalArgumentException(a.l(uri, "Failed to obtain context or unrecognized Uri format for: "), e2);
                }
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            identifier = contextCreatePackageContext.getResources().getIdentifier(str2, str, authority2);
            if (identifier == 0) {
                identifier = Resources.getSystem().getIdentifier(str2, str, LogSubCategory.LifeCycle.ANDROID);
            }
            if (identifier == 0) {
                throw new IllegalArgumentException(a.l(uri, "Failed to find resource id for: "));
            }
        } else {
            if (pathSegments.size() != 1) {
                throw new IllegalArgumentException(a.l(uri, "Unrecognized Uri format: "));
            }
            try {
                identifier = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e3) {
                throw new IllegalArgumentException(a.l(uri, "Unrecognized Uri format: "), e3);
            }
        }
        try {
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e4) {
            if (context.getPackageName().equals(contextCreatePackageContext.getPackageName())) {
                throw e4;
            }
            drawable = contextCreatePackageContext.getDrawable(identifier);
        } catch (NoClassDefFoundError unused2) {
            DrawableDecoderCompat.f16338a = false;
        }
        if (DrawableDecoderCompat.f16338a) {
            drawable = AppCompatResources.b(identifier, contextCreatePackageContext);
        } else {
            drawable = ResourcesCompat.c(contextCreatePackageContext.getResources(), identifier, contextCreatePackageContext.getTheme());
        }
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }
}
