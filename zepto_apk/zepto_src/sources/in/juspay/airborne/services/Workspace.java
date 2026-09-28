package in.juspay.airborne.services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.Keep;
import in.juspay.airborne.utils.OTAUtils;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public class Workspace {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String FALLBACK_WORKSPACE = "juspay";

    @NotNull
    private static final String TAG = "Workspace";

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static Context ctx;

    @Nullable
    private static SharedPreferences fallbackSharedPreferencesGodel;

    @Nullable
    private static SharedPreferences fallbackSharedPreferencesJuspay;

    @NotNull
    private final AssetManager assetManager;

    @NotNull
    private final File cacheRoot;
    private final boolean fromAirborne;

    @NotNull
    private final String path;

    @NotNull
    private File root;

    @NotNull
    private final List<SharedPreferences> sharedPrefsList;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getCtx$annotations() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File mkCacheRoot(Context context, String str) {
            File file = new File(context.getCacheDir(), str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File mkRoot(Context context, String str) {
            if (!StringsKt.n(str, "/", false)) {
                File dir = context.getDir(str, 0);
                Intrinsics.checkNotNullExpressionValue(dir, "ctx.getDir(workspacePath, Context.MODE_PRIVATE)");
                return dir;
            }
            int iW = StringsKt.w(str, '/', 0, 6);
            String strSubstring = str.substring(0, iW);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            File dir2 = context.getDir(strSubstring, 0);
            String strSubstring2 = str.substring(iW + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            File file = new File(dir2, strSubstring2);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        @Nullable
        public final Context getCtx() {
            return Workspace.ctx;
        }

        public final void setCtx(@Nullable Context context) {
            Workspace.ctx = context;
        }

        @NotNull
        public final String trimFileSeparator(@NotNull String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            return StringsKt.c0(path, ' ', '/');
        }

        private Companion() {
        }
    }

    public Workspace(@NotNull Context ctx2, @NotNull String workspacePath, boolean z) {
        Intrinsics.checkNotNullParameter(ctx2, "ctx");
        Intrinsics.checkNotNullParameter(workspacePath, "workspacePath");
        Companion companion = Companion;
        String strTrimFileSeparator = companion.trimFileSeparator(workspacePath);
        this.path = strTrimFileSeparator;
        this.fromAirborne = z;
        ctx = ctx2;
        this.root = companion.mkRoot(ctx2, strTrimFileSeparator);
        this.cacheRoot = companion.mkCacheRoot(ctx2, strTrimFileSeparator);
        String strJ = StringsKt.J(strTrimFileSeparator, '/', '_');
        AssetManager assets = ctx2.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "ctx.assets");
        this.assetManager = assets;
        ArrayList arrayList = new ArrayList();
        if (fallbackSharedPreferencesJuspay == null) {
            fallbackSharedPreferencesJuspay = ctx2.getSharedPreferences(FALLBACK_WORKSPACE, 0);
        }
        if (fallbackSharedPreferencesGodel == null) {
            fallbackSharedPreferencesGodel = ctx2.getSharedPreferences(PaymentConstants.Category.GODEL, 0);
        }
        if (strTrimFileSeparator.equals(FALLBACK_WORKSPACE)) {
            SharedPreferences sharedPreferences = fallbackSharedPreferencesJuspay;
            if (sharedPreferences != null) {
                arrayList.add(sharedPreferences);
            }
            SharedPreferences sharedPreferences2 = fallbackSharedPreferencesGodel;
            if (sharedPreferences2 != null) {
                arrayList.add(sharedPreferences2);
            }
        } else {
            arrayList.add(ctx2.getSharedPreferences(strJ, 0));
            SharedPreferences sharedPreferences3 = fallbackSharedPreferencesJuspay;
            if (sharedPreferences3 != null) {
                arrayList.add(sharedPreferences3);
            }
            SharedPreferences sharedPreferences4 = fallbackSharedPreferencesGodel;
            if (sharedPreferences4 != null) {
                arrayList.add(sharedPreferences4);
            }
        }
        this.sharedPrefsList = arrayList;
    }

    @Nullable
    public static final Context getCtx() {
        return Companion.getCtx();
    }

    public static final void setCtx(@Nullable Context context) {
        Companion.setCtx(context);
    }

    public final void clean(@NotNull Context ctx2) {
        Intrinsics.checkNotNullParameter(ctx2, "ctx");
        if (this.root.exists()) {
            OTAUtils.deleteRecursive(this.root);
            Companion.mkRoot(ctx2, this.path);
        }
    }

    @NotNull
    public final File getCacheRoot() {
        return this.cacheRoot;
    }

    @Nullable
    public final String getFromSharedPreference(@Nullable String str, @Nullable String str2) {
        Iterator<SharedPreferences> it = this.sharedPrefsList.iterator();
        while (it.hasNext()) {
            String string = it.next().getString(str, null);
            if (string != null) {
                return string;
            }
        }
        return str2;
    }

    @NotNull
    public final Set<String> getKeysInSharedPreference() {
        HashSet hashSet = new HashSet();
        Iterator<SharedPreferences> it = this.sharedPrefsList.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getAll().keySet());
        }
        return hashSet;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final File getRoot() {
        return this.root;
    }

    public final boolean isInSharedPreference(@Nullable String str) {
        Iterator<SharedPreferences> it = this.sharedPrefsList.iterator();
        while (it.hasNext()) {
            if (it.next().contains(str)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final File open(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return open(this.root, filePath);
    }

    @NotNull
    public final InputStream openAsset(@NotNull String filePath) throws IOException {
        InputStream inputStreamOpen;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String strTrimFileSeparator = Companion.trimFileSeparator(filePath);
        try {
            InputStream inputStreamOpen2 = this.assetManager.open(this.path + '/' + strTrimFileSeparator);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen2, "{\n            assetManag…path/$trimmed\")\n        }");
            return inputStreamOpen2;
        } catch (IOException e2) {
            if (Intrinsics.b(this.path, FALLBACK_WORKSPACE)) {
                throw e2;
            }
            Log.d(TAG, e2 + ", trying fallback workspace.");
            if (this.fromAirborne) {
                inputStreamOpen = this.assetManager.open("airborne/" + strTrimFileSeparator);
            } else {
                inputStreamOpen = this.assetManager.open("juspay/" + strTrimFileSeparator);
            }
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "{\n            if (path !…e\n            }\n        }");
            return inputStreamOpen;
        }
    }

    @NotNull
    public final File openInCache(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return open(this.cacheRoot, filePath);
    }

    @Nullable
    public final Unit removeFromSharedPreference(@Nullable String str) {
        SharedPreferences.Editor editorRemove;
        if (str == null) {
            return null;
        }
        Iterator<SharedPreferences> it = this.sharedPrefsList.iterator();
        while (it.hasNext()) {
            SharedPreferences.Editor editorEdit = it.next().edit();
            if (editorEdit != null && (editorRemove = editorEdit.remove(str)) != null) {
                editorRemove.apply();
            }
        }
        return Unit.f53572a;
    }

    public final void setRoot(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<set-?>");
        this.root = file;
    }

    @Nullable
    public final Unit writeToSharedPreference(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return null;
        }
        this.sharedPrefsList.get(0).edit().putString(str, str2).apply();
        return Unit.f53572a;
    }

    private final File open(File file, String str) {
        return new File(file, Companion.trimFileSeparator(str));
    }

    public /* synthetic */ Workspace(Context context, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i2 & 4) != 0 ? false : z);
    }

    public Workspace(@NotNull Workspace workspace) {
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        this.path = workspace.path;
        this.fromAirborne = workspace.fromAirborne;
        this.root = workspace.root;
        this.cacheRoot = workspace.cacheRoot;
        this.sharedPrefsList = workspace.sharedPrefsList;
        this.assetManager = workspace.assetManager;
    }
}
