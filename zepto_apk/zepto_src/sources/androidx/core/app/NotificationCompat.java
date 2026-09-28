package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import in.juspay.hyper.constants.LogSubCategory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes3.dex */
public class NotificationCompat {

    public static class Action {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f2647a;

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f2648b;

        /* renamed from: c, reason: collision with root package name */
        public final RemoteInput[] f2649c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f2650d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f2651e;

        /* renamed from: f, reason: collision with root package name */
        public final int f2652f;

        /* renamed from: g, reason: collision with root package name */
        public final CharSequence f2653g;

        /* renamed from: h, reason: collision with root package name */
        public final PendingIntent f2654h;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public final IconCompat f2655a;

            /* renamed from: b, reason: collision with root package name */
            public final CharSequence f2656b;

            /* renamed from: c, reason: collision with root package name */
            public final boolean f2657c;

            /* renamed from: d, reason: collision with root package name */
            public final Bundle f2658d;

            /* renamed from: e, reason: collision with root package name */
            public final boolean f2659e;

            @RequiresApi
            public static class Api20Impl {
            }

            @RequiresApi
            public static class Api23Impl {
            }

            @RequiresApi
            public static class Api24Impl {
            }

            @RequiresApi
            public static class Api28Impl {
            }

            @RequiresApi
            public static class Api29Impl {
            }

            @RequiresApi
            public static class Api31Impl {
            }

            public Builder(IconCompat iconCompat, SpannableStringBuilder spannableStringBuilder) {
                Bundle bundle = new Bundle();
                this.f2657c = true;
                this.f2659e = true;
                this.f2655a = iconCompat;
                this.f2656b = Builder.c(spannableStringBuilder);
                this.f2658d = bundle;
                this.f2657c = true;
                this.f2659e = true;
            }
        }

        public interface Extender {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {
            public final Object clone() {
                return new WearableExtender();
            }
        }

        public Action(int i2, String str, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.d(null, "", i2) : null, str, pendingIntent);
        }

        public final IconCompat a() {
            int i2;
            if (this.f2648b == null && (i2 = this.f2652f) != 0) {
                this.f2648b = IconCompat.d(null, "", i2);
            }
            return this.f2648b;
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, true);
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, boolean z2) {
            this.f2651e = true;
            this.f2648b = iconCompat;
            if (iconCompat != null && iconCompat.g() == 2) {
                this.f2652f = iconCompat.e();
            }
            this.f2653g = Builder.c(charSequence);
            this.f2654h = pendingIntent;
            this.f2647a = bundle == null ? new Bundle() : bundle;
            this.f2649c = remoteInputArr;
            this.f2650d = z;
            this.f2651e = z2;
        }
    }

    @RequiresApi
    public static class Api20Impl {
    }

    @RequiresApi
    public static class Api23Impl {
    }

    @RequiresApi
    public static class Api24Impl {
    }

    @RequiresApi
    public static class Api26Impl {
    }

    @RequiresApi
    public static class Api28Impl {
    }

    @RequiresApi
    public static class Api29Impl {
    }

    @RequiresApi
    public static class Api31Impl {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f2660b;

        /* renamed from: c, reason: collision with root package name */
        public IconCompat f2661c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2662d;

        @RequiresApi
        public static class Api23Impl {
            @RequiresApi
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        @RequiresApi
        public static class Api31Impl {
            @RequiresApi
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            @RequiresApi
            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            @RequiresApi
            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z) {
                bigPictureStyle.showBigPictureWhenCollapsed(z);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Bitmap bitmapA;
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f2683b).setBigContentTitle(null);
            IconCompat iconCompat = this.f2660b;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    Api31Impl.a(bigContentTitle, iconCompat.j(((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f2682a));
                } else if (iconCompat.g() == 1) {
                    IconCompat iconCompat2 = this.f2660b;
                    int i2 = iconCompat2.f2843a;
                    if (i2 == -1) {
                        Object obj = iconCompat2.f2844b;
                        bitmapA = obj instanceof Bitmap ? (Bitmap) obj : null;
                    } else if (i2 == 1) {
                        bitmapA = (Bitmap) iconCompat2.f2844b;
                    } else {
                        if (i2 != 5) {
                            throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                        }
                        bitmapA = IconCompat.a((Bitmap) iconCompat2.f2844b, true);
                    }
                    bigContentTitle = bigContentTitle.bigPicture(bitmapA);
                }
            }
            if (this.f2662d) {
                IconCompat iconCompat3 = this.f2661c;
                if (iconCompat3 == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    Api23Impl.a(bigContentTitle, iconCompat3.j(((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f2682a));
                }
            }
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.c(bigContentTitle, false);
                Api31Impl.b(bigContentTitle, null);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final String g() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }
    }

    public static class BigTextStyle extends Style {

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f2663b;

        @Override // androidx.core.app.NotificationCompat.Style
        public final void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            new Notification.BigTextStyle(((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f2683b).setBigContentTitle(null).bigText(this.f2663b);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final String g() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public final void k(String str) {
            this.f2663b = Builder.c(str);
        }
    }

    public static final class BubbleMetadata {

        @RequiresApi
        public static class Api29Impl {
        }

        @RequiresApi
        public static class Api30Impl {
        }

        public static final class Builder {
            @Deprecated
            public Builder() {
            }
        }
    }

    public static class CallStyle extends Style {

        @RequiresApi
        public static class Api20Impl {
        }

        @RequiresApi
        public static class Api21Impl {
            public static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        @RequiresApi
        public static class Api23Impl {
        }

        @RequiresApi
        public static class Api24Impl {
        }

        @RequiresApi
        public static class Api28Impl {
        }

        @RequiresApi
        public static class Api31Impl {
        }

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface CallType {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", 0);
            bundle.putBoolean("android.callIsVideo", false);
            bundle.putCharSequence("android.verificationText", null);
            bundle.putParcelable("android.answerIntent", null);
            bundle.putParcelable("android.declineIntent", null);
            bundle.putParcelable("android.hangUpIntent", null);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 31) {
                if (Log.isLoggable("NotifCompat", 3)) {
                    Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(0));
                    return;
                }
                return;
            }
            Notification.Builder builder = ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f2683b;
            builder.setContentTitle(null);
            Bundle bundle = this.f2679a.q;
            CharSequence charSequence = (bundle == null || !bundle.containsKey("android.text")) ? null : this.f2679a.q.getCharSequence("android.text");
            builder.setContentText(charSequence != null ? charSequence : null);
            Api21Impl.a(builder, "call");
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final String g() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }
    }

    public static final class CarExtender implements Extender {

        @RequiresApi
        public static class Api20Impl {
        }

        @RequiresApi
        public static class Api29Impl {
        }

        @Deprecated
        public static class UnreadConversation {

            public static class Builder {
            }
        }
    }

    public static class DecoratedCustomViewStyle extends Style {

        @RequiresApi
        public static class Api24Impl {
            public static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f2683b.setStyle(Api24Impl.a());
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final String g() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final RemoteViews h() {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final RemoteViews i() {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final RemoteViews j() {
            return null;
        }
    }

    public interface Extender {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends Style {

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f2677b = new ArrayList();

        @Override // androidx.core.app.NotificationCompat.Style
        public final void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f2683b).setBigContentTitle(null);
            Iterator it = this.f2677b.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final String g() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }
    }

    public static class MessagingStyle extends Style {

        /* renamed from: b, reason: collision with root package name */
        public Boolean f2678b;

        @RequiresApi
        public static class Api24Impl {
        }

        @RequiresApi
        public static class Api26Impl {
        }

        @RequiresApi
        public static class Api28Impl {
        }

        public static final class Message {

            @RequiresApi
            public static class Api24Impl {
            }

            @RequiresApi
            public static class Api28Impl {
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final void a(Bundle bundle) {
            super.a(bundle);
            throw null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Boolean bool;
            Builder builder = this.f2679a;
            boolean zBooleanValue = false;
            if ((builder == null || builder.f2664a.getApplicationInfo().targetSdkVersion >= 28 || this.f2678b != null) && (bool = this.f2678b) != null) {
                zBooleanValue = bool.booleanValue();
            }
            this.f2678b = Boolean.valueOf(zBooleanValue);
            if (Build.VERSION.SDK_INT < 28) {
                throw null;
            }
            throw null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final String g() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ServiceNotificationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface StreamType {
    }

    public static abstract class Style {

        /* renamed from: a, reason: collision with root package name */
        public Builder f2679a;

        @RequiresApi
        public static class Api24Impl {
        }

        public void a(Bundle bundle) {
            String strG = g();
            if (strG != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strG);
            }
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        public final RemoteViews c(int i2, boolean z, boolean z2) throws Resources.NotFoundException {
            boolean z3;
            boolean z4;
            Resources resources = this.f2679a.f2664a.getResources();
            RemoteViews remoteViews = new RemoteViews(this.f2679a.f2664a.getPackageName(), i2);
            Builder builder = this.f2679a;
            int i3 = builder.f2673j;
            if (builder.f2671h != null) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                remoteViews.setImageViewBitmap(R.id.icon, e(this.f2679a.f2671h, 0, 0));
                if (z && this.f2679a.y.icon != 0) {
                    int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                    int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
                    Builder builder2 = this.f2679a;
                    remoteViews.setImageViewBitmap(R.id.right_icon, f(builder2.y.icon, dimensionPixelSize, dimensionPixelSize2, builder2.r));
                    remoteViews.setViewVisibility(R.id.right_icon, 0);
                }
            } else if (z && builder.y.icon != 0) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
                Builder builder3 = this.f2679a;
                remoteViews.setImageViewBitmap(R.id.icon, f(builder3.y.icon, dimensionPixelSize3, dimensionPixelSize4, builder3.r));
            }
            CharSequence charSequence = this.f2679a.f2668e;
            if (charSequence != null) {
                remoteViews.setTextViewText(R.id.title, charSequence);
            }
            CharSequence charSequence2 = this.f2679a.f2669f;
            boolean z5 = true;
            if (charSequence2 != null) {
                remoteViews.setTextViewText(R.id.text, charSequence2);
                z3 = true;
            } else {
                z3 = false;
            }
            this.f2679a.getClass();
            if (this.f2679a.f2672i > 0) {
                if (this.f2679a.f2672i > resources.getInteger(R.integer.status_bar_notification_info_maxnum)) {
                    remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
                } else {
                    remoteViews.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(this.f2679a.f2672i));
                }
                remoteViews.setViewVisibility(R.id.info, 0);
                z3 = true;
                z4 = true;
            } else {
                remoteViews.setViewVisibility(R.id.info, 8);
                z4 = false;
            }
            CharSequence charSequence3 = this.f2679a.n;
            if (charSequence3 != null) {
                remoteViews.setTextViewText(R.id.text, charSequence3);
                CharSequence charSequence4 = this.f2679a.f2669f;
                if (charSequence4 != null) {
                    remoteViews.setTextViewText(R.id.text2, charSequence4);
                    remoteViews.setViewVisibility(R.id.text2, 0);
                    if (z2) {
                        remoteViews.setTextViewTextSize(R.id.text, 0, resources.getDimensionPixelSize(R.dimen.notification_subtext_size));
                    }
                    remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
                } else {
                    remoteViews.setViewVisibility(R.id.text2, 8);
                }
            }
            Builder builder4 = this.f2679a;
            if ((builder4.f2674k ? builder4.y.when : 0L) == 0) {
                z5 = z4;
            } else if (builder4.f2675l) {
                remoteViews.setViewVisibility(R.id.chronometer, 0);
                int i4 = R.id.chronometer;
                Builder builder5 = this.f2679a;
                remoteViews.setLong(i4, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + (builder5.f2674k ? builder5.y.when : 0L));
                remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
                this.f2679a.getClass();
            } else {
                remoteViews.setViewVisibility(R.id.time, 0);
                int i5 = R.id.time;
                Builder builder6 = this.f2679a;
                remoteViews.setLong(i5, "setTime", builder6.f2674k ? builder6.y.when : 0L);
            }
            remoteViews.setViewVisibility(R.id.right_side, z5 ? 0 : 8);
            remoteViews.setViewVisibility(R.id.line3, z3 ? 0 : 8);
            return remoteViews;
        }

        public final void d(RemoteViews remoteViews, RemoteViews remoteViews2) throws Resources.NotFoundException {
            remoteViews.setViewVisibility(R.id.title, 8);
            remoteViews.setViewVisibility(R.id.text2, 8);
            remoteViews.setViewVisibility(R.id.text, 8);
            remoteViews.removeAllViews(R.id.notification_main_column);
            remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(R.id.notification_main_column, 0);
            Resources resources = this.f2679a.f2664a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float f2 = resources.getConfiguration().fontScale;
            if (f2 < 1.0f) {
                f2 = 1.0f;
            } else if (f2 > 1.3f) {
                f2 = 1.3f;
            }
            float f3 = (f2 - 1.0f) / 0.29999995f;
            remoteViews.setViewPadding(R.id.notification_main_column_container, 0, Math.round((f3 * dimensionPixelSize2) + ((1.0f - f3) * dimensionPixelSize)), 0, 0);
        }

        public final Bitmap e(IconCompat iconCompat, int i2, int i3) throws PackageManager.NameNotFoundException {
            Object obj;
            ApplicationInfo applicationInfo;
            Resources resourcesForApplication;
            Context context = this.f2679a.f2664a;
            if (iconCompat.f2843a == 2 && (obj = iconCompat.f2844b) != null) {
                String str = (String) obj;
                if (str.contains(":")) {
                    String str2 = str.split(":", -1)[1];
                    String str3 = str2.split("/", -1)[0];
                    String str4 = str2.split("/", -1)[1];
                    String str5 = str.split(":", -1)[0];
                    if ("0_resource_name_obfuscated".equals(str4)) {
                        Log.i("IconCompat", "Found obfuscated resource, not trying to update resource id for it");
                    } else {
                        String strF = iconCompat.f();
                        if (LogSubCategory.LifeCycle.ANDROID.equals(strF)) {
                            resourcesForApplication = Resources.getSystem();
                        } else {
                            PackageManager packageManager = context.getPackageManager();
                            try {
                                applicationInfo = packageManager.getApplicationInfo(strF, KEYRecord.Flags.FLAG2);
                            } catch (PackageManager.NameNotFoundException e2) {
                                Log.e("IconCompat", "Unable to find pkg=" + strF + " for icon", e2);
                            }
                            resourcesForApplication = applicationInfo != null ? packageManager.getResourcesForApplication(applicationInfo) : null;
                        }
                        int identifier = resourcesForApplication.getIdentifier(str4, str3, str5);
                        if (iconCompat.f2847e != identifier) {
                            Log.i("IconCompat", "Id has changed for " + strF + StringUtils.SPACE + str);
                            iconCompat.f2847e = identifier;
                        }
                    }
                }
            }
            Drawable drawableLoadDrawable = iconCompat.j(context).loadDrawable(context);
            int intrinsicWidth = i3 == 0 ? drawableLoadDrawable.getIntrinsicWidth() : i3;
            if (i3 == 0) {
                i3 = drawableLoadDrawable.getIntrinsicHeight();
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
            drawableLoadDrawable.setBounds(0, 0, intrinsicWidth, i3);
            if (i2 != 0) {
                drawableLoadDrawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
            }
            drawableLoadDrawable.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        }

        public final Bitmap f(int i2, int i3, int i4, int i5) throws PackageManager.NameNotFoundException {
            int i6 = R.drawable.notification_icon_background;
            if (i5 == 0) {
                i5 = 0;
            }
            Bitmap bitmapE = e(IconCompat.c(i6, this.f2679a.f2664a), i5, i3);
            Canvas canvas = new Canvas(bitmapE);
            Drawable drawableMutate = this.f2679a.f2664a.getResources().getDrawable(i2).mutate();
            drawableMutate.setFilterBitmap(true);
            int i7 = (i3 - i4) / 2;
            int i8 = i4 + i7;
            drawableMutate.setBounds(i7, i7, i8, i8);
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            drawableMutate.draw(canvas);
            return bitmapE;
        }

        public String g() {
            return null;
        }

        public RemoteViews h() {
            return null;
        }

        public RemoteViews i() {
            return null;
        }

        public RemoteViews j() {
            return null;
        }
    }

    public static final class TvExtender implements Extender {
    }

    public static final class WearableExtender implements Extender {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList f2680a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f2681b = new ArrayList();

        @RequiresApi
        public static class Api20Impl {
        }

        @RequiresApi
        public static class Api23Impl {
        }

        @RequiresApi
        public static class Api24Impl {
        }

        @RequiresApi
        public static class Api31Impl {
        }

        public final Object clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f2680a = new ArrayList(this.f2680a);
            wearableExtender.f2681b = new ArrayList(this.f2681b);
            return wearableExtender;
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f2664a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f2665b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f2666c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f2667d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f2668e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f2669f;

        /* renamed from: g, reason: collision with root package name */
        public PendingIntent f2670g;

        /* renamed from: h, reason: collision with root package name */
        public IconCompat f2671h;

        /* renamed from: i, reason: collision with root package name */
        public int f2672i;

        /* renamed from: j, reason: collision with root package name */
        public int f2673j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f2674k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f2675l;

        /* renamed from: m, reason: collision with root package name */
        public Style f2676m;
        public CharSequence n;
        public String o;
        public boolean p;
        public Bundle q;
        public int r;
        public int s;
        public RemoteViews t;
        public RemoteViews u;
        public String v;
        public int w;
        public final boolean x;
        public final Notification y;
        public final ArrayList z;

        @RequiresApi
        public static class Api21Impl {
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i2) {
                return builder.setContentType(i2);
            }

            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i2) {
                return builder.setUsage(i2);
            }
        }

        @RequiresApi
        public static class Api23Impl {
        }

        @RequiresApi
        public static class Api24Impl {
        }

        public Builder(Context context, String str) {
            this.f2665b = new ArrayList();
            this.f2666c = new ArrayList();
            this.f2667d = new ArrayList();
            this.f2674k = true;
            this.p = false;
            this.r = 0;
            this.s = 0;
            this.w = 0;
            Notification notification = new Notification();
            this.y = notification;
            this.f2664a = context;
            this.v = str;
            notification.when = System.currentTimeMillis();
            notification.audioStreamType = -1;
            this.f2673j = 0;
            this.z = new ArrayList();
            this.x = true;
        }

        public static CharSequence c(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public final void a(int i2, String str, PendingIntent pendingIntent) {
            this.f2665b.add(new Action(i2, str, pendingIntent));
        }

        public final Notification b() {
            Bundle bundle;
            RemoteViews remoteViewsJ;
            RemoteViews remoteViewsH;
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            Builder builder = notificationCompatBuilder.f2684c;
            Style style = builder.f2676m;
            if (style != null) {
                style.b(notificationCompatBuilder);
            }
            RemoteViews remoteViewsI = style != null ? style.i() : null;
            int i2 = Build.VERSION.SDK_INT;
            Notification.Builder builder2 = notificationCompatBuilder.f2683b;
            Notification notificationBuild = i2 >= 26 ? builder2.build() : builder2.build();
            if (remoteViewsI != null) {
                notificationBuild.contentView = remoteViewsI;
            } else {
                RemoteViews remoteViews = builder.t;
                if (remoteViews != null) {
                    notificationBuild.contentView = remoteViews;
                }
            }
            if (style != null && (remoteViewsH = style.h()) != null) {
                notificationBuild.bigContentView = remoteViewsH;
            }
            if (style != null && (remoteViewsJ = builder.f2676m.j()) != null) {
                notificationBuild.headsUpContentView = remoteViewsJ;
            }
            if (style != null && (bundle = notificationBuild.extras) != null) {
                style.a(bundle);
            }
            return notificationBuild;
        }

        public final void d(boolean z) {
            i(16, z);
        }

        public final void e(String str) {
            this.v = str;
        }

        public final void f(PendingIntent pendingIntent) {
            this.f2670g = pendingIntent;
        }

        public final void g(CharSequence charSequence) {
            this.f2669f = c(charSequence);
        }

        public final void h(String str) {
            this.f2668e = c(str);
        }

        public final void i(int i2, boolean z) {
            Notification notification = this.y;
            if (z) {
                notification.flags = i2 | notification.flags;
            } else {
                notification.flags = (~i2) & notification.flags;
            }
        }

        public final void j(Bitmap bitmap) throws Resources.NotFoundException {
            IconCompat iconCompatB;
            if (bitmap == null) {
                iconCompatB = null;
            } else {
                if (Build.VERSION.SDK_INT < 27) {
                    Resources resources = this.f2664a.getResources();
                    int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                    int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                    if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                        double dMin = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                        bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * dMin), (int) Math.ceil(bitmap.getHeight() * dMin), true);
                    }
                }
                iconCompatB = IconCompat.b(bitmap);
            }
            this.f2671h = iconCompatB;
        }

        public final void k() {
            this.p = true;
        }

        public final void l() {
            this.f2673j = 2;
        }

        public final void m(int i2) {
            this.y.icon = i2;
        }

        public final void n(Uri uri) {
            Notification notification = this.y;
            notification.sound = uri;
            notification.audioStreamType = -1;
            notification.audioAttributes = Api21Impl.a(Api21Impl.d(Api21Impl.c(Api21Impl.b(), 4), 5));
        }

        public final void o(Style style) {
            if (this.f2676m != style) {
                this.f2676m = style;
                if (style == null || style.f2679a == this) {
                    return;
                }
                style.f2679a = this;
                o(style);
            }
        }

        public final void p(String str) {
            this.y.tickerText = c(str);
        }

        public final void q(long j2) {
            this.y.when = j2;
        }

        public Builder(Context context) {
            this(context, null);
        }
    }
}
