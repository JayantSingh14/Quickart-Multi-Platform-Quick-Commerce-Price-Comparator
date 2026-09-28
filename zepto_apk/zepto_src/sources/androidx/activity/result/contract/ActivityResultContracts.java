package androidx.activity.result.contract;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class ActivityResultContracts {

    @Metadata
    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            Uri input = (Uri) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            Uri input = (Uri) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            return Boolean.valueOf(i2 == -1);
        }
    }

    @Metadata
    @SourceDebugExtension
    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            String input = (String) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input);
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            String input = (String) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {

        @Metadata
        public static final class Companion {
            public static List a(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return EmptyList.f53609a;
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i2 = 0; i2 < itemCount; i2++) {
                        Uri uri = clipData.getItemAt(i2).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            String input = (String) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            String input = (String) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            List listA;
            if (i2 != -1) {
                intent = null;
            }
            return (intent == null || (listA = Companion.a(intent)) == null) ? EmptyList.f53609a : listA;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            String[] input = (String[]) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            String[] input = (String[]) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata
    @RequiresApi
    @SourceDebugExtension
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            Uri uri = (Uri) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            String[] input = (String[]) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            String[] input = (String[]) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            List listA;
            if (i2 != -1) {
                intent = null;
            }
            return (intent == null || (listA = GetMultipleContents.Companion.a(intent)) == null) ? EmptyList.f53609a : listA;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {

        /* renamed from: a, reason: collision with root package name */
        public final int f232a;

        @Metadata
        public static final class Companion {
        }

        public PickMultipleVisualMedia() {
            int pickImagesMaxLimit = PickVisualMedia.Companion.d() ? MediaStore.getPickImagesMaxLimit() : Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f232a = pickImagesMaxLimit;
            if (pickImagesMaxLimit <= 1) {
                throw new IllegalArgumentException("Max items must be higher than 1");
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            PickVisualMediaRequest input = (PickVisualMediaRequest) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            boolean zD = PickVisualMedia.Companion.d();
            int i2 = this.f232a;
            if (zD) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                input.getClass();
                intent.setType(PickVisualMedia.Companion.c());
                if (i2 > MediaStore.getPickImagesMaxLimit()) {
                    throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()");
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", i2);
                return intent;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (PickVisualMedia.Companion.b(context) != null) {
                ResolveInfo resolveInfoB = PickVisualMedia.Companion.b(context);
                if (resolveInfoB == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                ActivityInfo activityInfo = resolveInfoB.activityInfo;
                Intent intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                input.getClass();
                intent2.setType(PickVisualMedia.Companion.c());
                intent2.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", i2);
                return intent2;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (PickVisualMedia.Companion.a(context) != null) {
                ResolveInfo resolveInfoA = PickVisualMedia.Companion.a(context);
                if (resolveInfoA == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                ActivityInfo activityInfo2 = resolveInfoA.activityInfo;
                Intent intent3 = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
                intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                intent3.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", i2);
                return intent3;
            }
            Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
            input.getClass();
            intent4.setType(PickVisualMedia.Companion.c());
            intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (intent4.getType() == null) {
                intent4.setType("*/*");
                intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }
            return intent4;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            PickVisualMediaRequest input = (PickVisualMediaRequest) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            List listA;
            if (i2 != -1) {
                intent = null;
            }
            return (intent == null || (listA = GetMultipleContents.Companion.a(intent)) == null) ? EmptyList.f53609a : listA;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {

        @Metadata
        public static final class Companion {
            public static ResolveInfo a(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return context.getPackageManager().resolveActivity(new Intent("com.google.android.gms.provider.action.PICK_IMAGES"), 1114112);
            }

            public static ResolveInfo b(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
            }

            public static String c() {
                ImageAndVideo input = ImageAndVideo.f233a;
                Intrinsics.checkNotNullParameter(input, "input");
                return null;
            }

            public static boolean d() {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 33) {
                    return true;
                }
                return i2 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
            }
        }

        @Metadata
        public static final class ImageAndVideo implements VisualMediaType {

            /* renamed from: a, reason: collision with root package name */
            public static final ImageAndVideo f233a = new ImageAndVideo();
        }

        @Metadata
        public static final class ImageOnly implements VisualMediaType {
        }

        @Metadata
        public static final class SingleMimeType implements VisualMediaType {
        }

        @Metadata
        public static final class VideoOnly implements VisualMediaType {
        }

        @Metadata
        public interface VisualMediaType {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            PickVisualMediaRequest input = (PickVisualMediaRequest) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            if (Companion.d()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                input.getClass();
                intent.setType(Companion.c());
                return intent;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (Companion.b(context) != null) {
                ResolveInfo resolveInfoB = Companion.b(context);
                if (resolveInfoB == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                ActivityInfo activityInfo = resolveInfoB.activityInfo;
                Intent intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                input.getClass();
                intent2.setType(Companion.c());
                return intent2;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (Companion.a(context) == null) {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                input.getClass();
                intent3.setType(Companion.c());
                if (intent3.getType() == null) {
                    intent3.setType("*/*");
                    intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                }
                return intent3;
            }
            ResolveInfo resolveInfoA = Companion.a(context);
            if (resolveInfoA == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ActivityInfo activityInfo2 = resolveInfoA.activityInfo;
            Intent intent4 = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
            intent4.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            input.getClass();
            intent4.setType(Companion.c());
            return intent4;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            PickVisualMediaRequest input = (PickVisualMediaRequest) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent == null) {
                return null;
            }
            Uri data = intent.getData();
            return data == null ? (Uri) CollectionsKt.firstOrNull(GetMultipleContents.Companion.a(intent)) : data;
        }
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes.dex */
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {

        @Metadata
        public static final class Companion {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            String[] input = (String[]) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            String[] input = (String[]) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            if (input.length == 0) {
                return new ActivityResultContract.SynchronousResult((Serializable) MapsKt.c());
            }
            for (String str : input) {
                if (ContextCompat.a(context, str) != 0) {
                    return null;
                }
            }
            int iF = MapsKt.f(input.length);
            if (iF < 16) {
                iF = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
            for (String str2 : input) {
                linkedHashMap.put(str2, Boolean.TRUE);
            }
            return new ActivityResultContract.SynchronousResult(linkedHashMap);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (i2 != -1) {
                return MapsKt.c();
            }
            if (intent == null) {
                return MapsKt.c();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return MapsKt.c();
            }
            ArrayList other = new ArrayList(intArrayExtra.length);
            for (int i3 : intArrayExtra) {
                other.add(Boolean.valueOf(i3 == 0));
            }
            ArrayList arrayListT = ArraysKt.t(stringArrayExtra);
            Intrinsics.checkNotNullParameter(arrayListT, "<this>");
            Intrinsics.checkNotNullParameter(other, "other");
            Iterator it = arrayListT.iterator();
            Iterator it2 = other.iterator();
            ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.r(arrayListT, 10), CollectionsKt.r(other, 10)));
            while (it.hasNext() && it2.hasNext()) {
                arrayList.add(new Pair(it.next(), it2.next()));
            }
            return MapsKt.k(arrayList);
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            String input = (String) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            String[] input2 = {input};
            Intrinsics.checkNotNullParameter(input2, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input2);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            String input = (String) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            if (ContextCompat.a(context, input) == 0) {
                return new ActivityResultContract.SynchronousResult(Boolean.TRUE);
            }
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (intent == null || i2 != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            boolean z = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (intArrayExtra[i3] == 0) {
                        z = true;
                        break;
                    }
                    i3++;
                }
            }
            return Boolean.valueOf(z);
        }
    }

    @Metadata
    /* loaded from: classes.dex */
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {

        @Metadata
        public static final class Companion {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            Intent input = (Intent) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return input;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            return new ActivityResult(intent, i2);
        }
    }

    @Metadata
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {

        @Metadata
        public static final class Companion {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            IntentSenderRequest input = (IntentSenderRequest) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            return new ActivityResult(intent, i2);
        }
    }

    @Metadata
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            Uri input = (Uri) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            Uri input = (Uri) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            return Boolean.valueOf(i2 == -1);
        }
    }

    @Metadata
    @SourceDebugExtension
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    @Metadata
    @Deprecated
    @SourceDebugExtension
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            Uri input = (Uri) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            Uri input = (Uri) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static class CreateDocument extends ActivityResultContract<String, Uri> {

        /* renamed from: a, reason: collision with root package name */
        public final String f231a;

        public CreateDocument(String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.f231a = mimeType;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            String input = (String) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.f231a).putExtra("android.intent.extra.TITLE", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final ActivityResultContract.SynchronousResult b(Object obj, Context context) {
            String input = (String) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            if (i2 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @Deprecated
        public CreateDocument() {
            this("*/*");
        }
    }
}
