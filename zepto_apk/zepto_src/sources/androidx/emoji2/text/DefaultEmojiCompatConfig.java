package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class DefaultEmojiCompatConfig {

    @RestrictTo
    public static class DefaultEmojiCompatConfigFactory {

        /* renamed from: a, reason: collision with root package name */
        public final DefaultEmojiCompatConfigHelper f4290a;

        public DefaultEmojiCompatConfigFactory() {
            this.f4290a = Build.VERSION.SDK_INT >= 28 ? new DefaultEmojiCompatConfigHelper_API28() : new DefaultEmojiCompatConfigHelper_API19();
        }
    }

    @RestrictTo
    public static class DefaultEmojiCompatConfigHelper {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public List c(PackageManager packageManager, Intent intent) {
            return Collections.EMPTY_LIST;
        }
    }

    @RequiresApi
    @RestrictTo
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public final ProviderInfo a(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public final List c(PackageManager packageManager, Intent intent) {
            return packageManager.queryIntentContentProviders(intent, 0);
        }
    }

    @RequiresApi
    @RestrictTo
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public final Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    public static FontRequestEmojiCompatConfig a(Context context) {
        ProviderInfo providerInfoA;
        FontRequest fontRequest;
        ApplicationInfo applicationInfo;
        DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfigFactory();
        PackageManager packageManager = context.getPackageManager();
        Preconditions.c(packageManager, "Package manager required to locate emoji font provider");
        Intent intent = new Intent("androidx.content.action.LOAD_EMOJI_FONT");
        DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper = defaultEmojiCompatConfigFactory.f4290a;
        Iterator it = defaultEmojiCompatConfigHelper.c(packageManager, intent).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfoA = null;
                break;
            }
            providerInfoA = defaultEmojiCompatConfigHelper.a((ResolveInfo) it.next());
            if (providerInfoA != null && (applicationInfo = providerInfoA.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfoA == null) {
            fontRequest = null;
        } else {
            try {
                String str = providerInfoA.authority;
                String str2 = providerInfoA.packageName;
                Signature[] signatureArrB = defaultEmojiCompatConfigHelper.b(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrB) {
                    arrayList.add(signature.toByteArray());
                }
                fontRequest = new FontRequest(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e2);
            }
        }
        if (fontRequest == null) {
            return null;
        }
        return new FontRequestEmojiCompatConfig(new FontRequestEmojiCompatConfig.FontRequestMetadataLoader(context, fontRequest, FontRequestEmojiCompatConfig.f4333d));
    }
}
