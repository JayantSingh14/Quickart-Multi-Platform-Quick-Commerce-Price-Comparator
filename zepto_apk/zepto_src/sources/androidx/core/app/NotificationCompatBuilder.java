package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.R;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo
/* loaded from: classes3.dex */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2682a;

    /* renamed from: b, reason: collision with root package name */
    public final Notification.Builder f2683b;

    /* renamed from: c, reason: collision with root package name */
    public final NotificationCompat.Builder f2684c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f2685d;

    @RequiresApi
    public static class Api20Impl {
    }

    @RequiresApi
    public static class Api21Impl {
    }

    @RequiresApi
    public static class Api23Impl {
    }

    @RequiresApi
    public static class Api24Impl {
    }

    @RequiresApi
    public static class Api26Impl {
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static void b(Notification.Builder builder) {
            builder.setBadgeIconType(0);
        }

        public static void c(Notification.Builder builder) {
            builder.setGroupAlertBehavior(0);
        }

        public static void d(Notification.Builder builder) {
            builder.setSettingsText(null);
        }

        public static void e(Notification.Builder builder) {
            builder.setShortcutId(null);
        }

        public static void f(Notification.Builder builder) {
            builder.setTimeoutAfter(0L);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        public static void a(Notification.Builder builder, android.app.Person person) {
            builder.addPerson(person);
        }

        public static void b(Notification.Action.Builder builder) {
            builder.setSemanticAction(0);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        public static void a(Notification.Builder builder, boolean z) {
            builder.setAllowSystemGeneratedContextualActions(z);
        }

        public static void b(Notification.Builder builder) {
            builder.setBubbleMetadata(null);
        }

        public static void c(Notification.Action.Builder builder) {
            builder.setContextual(false);
        }
    }

    @RequiresApi
    public static class Api31Impl {
        public static void a(Notification.Action.Builder builder) {
            builder.setAuthenticationRequired(false);
        }

        public static void b(Notification.Builder builder, int i2) {
            builder.setForegroundServiceBehavior(i2);
        }
    }

    public NotificationCompatBuilder(NotificationCompat.Builder builder) {
        ArrayList arrayList;
        int i2;
        Bundle[] bundleArr;
        ArrayList arrayList2;
        ArrayList arrayList3;
        new ArrayList();
        this.f2685d = new Bundle();
        this.f2684c = builder;
        Context context = builder.f2664a;
        this.f2682a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2683b = Api26Impl.a(context, builder.v);
        } else {
            this.f2683b = new Notification.Builder(builder.f2664a);
        }
        Notification notification = builder.y;
        Bundle[] bundleArr2 = null;
        int i3 = 2;
        int i4 = 0;
        this.f2683b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.f2668e).setContentText(builder.f2669f).setContentInfo(null).setContentIntent(builder.f2670g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(builder.f2672i).setProgress(0, 0, false);
        Notification.Builder builder2 = this.f2683b;
        IconCompat iconCompat = builder.f2671h;
        builder2.setLargeIcon(iconCompat == null ? null : iconCompat.j(context));
        this.f2683b.setSubText(builder.n).setUsesChronometer(builder.f2675l).setPriority(builder.f2673j);
        NotificationCompat.Style style = builder.f2676m;
        if (style instanceof NotificationCompat.CallStyle) {
            NotificationCompat.CallStyle callStyle = (NotificationCompat.CallStyle) style;
            int i5 = R.drawable.ic_call_decline;
            int i6 = R.string.call_notification_hang_up_action;
            int color = callStyle.f2679a.f2664a.getColor(R.color.call_notification_decline_color);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) callStyle.f2679a.f2664a.getResources().getString(i6));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 18);
            NotificationCompat.Action.Builder builder3 = new NotificationCompat.Action.Builder(IconCompat.c(i5, callStyle.f2679a.f2664a), spannableStringBuilder);
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            NotificationCompat.Action action = new NotificationCompat.Action(builder3.f2655a, builder3.f2656b, null, builder3.f2658d, arrayList5.isEmpty() ? null : (RemoteInput[]) arrayList5.toArray(new RemoteInput[arrayList5.size()]), arrayList4.isEmpty() ? null : (RemoteInput[]) arrayList4.toArray(new RemoteInput[arrayList4.size()]), builder3.f2657c, builder3.f2659e);
            action.f2647a.putBoolean("key_action_priority", true);
            ArrayList arrayList6 = new ArrayList(3);
            arrayList6.add(action);
            ArrayList arrayList7 = callStyle.f2679a.f2665b;
            if (arrayList7 != null) {
                Iterator it = arrayList7.iterator();
                while (it.hasNext()) {
                    NotificationCompat.Action action2 = (NotificationCompat.Action) it.next();
                    action2.getClass();
                    if (!action2.f2647a.getBoolean("key_action_priority") && i3 > 1) {
                        arrayList6.add(action2);
                        i3--;
                    }
                }
            }
            Iterator it2 = arrayList6.iterator();
            while (it2.hasNext()) {
                b((NotificationCompat.Action) it2.next());
            }
        } else {
            Iterator it3 = builder.f2665b.iterator();
            while (it3.hasNext()) {
                b((NotificationCompat.Action) it3.next());
            }
        }
        Bundle bundle = builder.q;
        if (bundle != null) {
            this.f2685d.putAll(bundle);
        }
        int i7 = Build.VERSION.SDK_INT;
        this.f2683b.setShowWhen(builder.f2674k);
        this.f2683b.setLocalOnly(builder.p);
        this.f2683b.setGroup(builder.o);
        this.f2683b.setSortKey(null);
        this.f2683b.setGroupSummary(false);
        this.f2683b.setCategory(null);
        this.f2683b.setColor(builder.r);
        this.f2683b.setVisibility(builder.s);
        this.f2683b.setPublicVersion(null);
        this.f2683b.setSound(notification.sound, notification.audioAttributes);
        ArrayList arrayList8 = builder.z;
        ArrayList arrayList9 = builder.f2666c;
        if (i7 < 28) {
            if (arrayList9 == null) {
                arrayList3 = null;
            } else {
                arrayList3 = new ArrayList(arrayList9.size());
                Iterator it4 = arrayList9.iterator();
                while (it4.hasNext()) {
                    ((Person) it4.next()).getClass();
                    arrayList3.add("");
                }
            }
            if (arrayList3 != null) {
                if (arrayList8 == null) {
                    arrayList8 = arrayList3;
                } else {
                    ArraySet arraySet = new ArraySet(arrayList8.size() + arrayList3.size());
                    arraySet.addAll(arrayList3);
                    arraySet.addAll(arrayList8);
                    arrayList8 = new ArrayList(arraySet);
                }
            }
        }
        if (arrayList8 != null && !arrayList8.isEmpty()) {
            Iterator it5 = arrayList8.iterator();
            while (it5.hasNext()) {
                this.f2683b.addPerson((String) it5.next());
            }
        }
        ArrayList arrayList10 = builder.f2667d;
        if (arrayList10.size() > 0) {
            if (builder.q == null) {
                builder.q = new Bundle();
            }
            Bundle bundle2 = builder.q.getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            int i8 = 0;
            while (i8 < arrayList10.size()) {
                String string = Integer.toString(i8);
                NotificationCompat.Action action3 = (NotificationCompat.Action) arrayList10.get(i8);
                Bundle bundle5 = new Bundle();
                IconCompat iconCompatA = action3.a();
                bundle5.putInt("icon", iconCompatA != null ? iconCompatA.e() : i4);
                bundle5.putCharSequence("title", action3.f2653g);
                bundle5.putParcelable("actionIntent", action3.f2654h);
                Bundle bundle6 = action3.f2647a;
                Bundle bundle7 = bundle6 != null ? new Bundle(bundle6) : new Bundle();
                bundle7.putBoolean("android.support.allowGeneratedReplies", action3.f2650d);
                bundle5.putBundle("extras", bundle7);
                RemoteInput[] remoteInputArr = action3.f2649c;
                if (remoteInputArr == null) {
                    arrayList2 = arrayList10;
                    bundleArr = bundleArr2;
                } else {
                    bundleArr = new Bundle[remoteInputArr.length];
                    arrayList2 = arrayList10;
                    int i9 = 0;
                    while (i9 < remoteInputArr.length) {
                        RemoteInput remoteInput = remoteInputArr[i9];
                        Bundle bundle8 = new Bundle();
                        remoteInput.getClass();
                        bundle8.putString("resultKey", null);
                        bundle8.putCharSequence("label", null);
                        bundle8.putCharSequenceArray("choices", null);
                        int i10 = i9;
                        bundle8.putBoolean("allowFreeFormInput", false);
                        bundle8.putBundle("extras", null);
                        bundleArr[i10] = bundle8;
                        i9 = i10 + 1;
                        arrayList9 = arrayList9;
                        remoteInputArr = remoteInputArr;
                    }
                }
                ArrayList arrayList11 = arrayList9;
                bundle5.putParcelableArray("remoteInputs", bundleArr);
                bundle5.putBoolean("showsUserInterface", action3.f2651e);
                bundle5.putInt("semanticAction", 0);
                bundle4.putBundle(string, bundle5);
                i8++;
                arrayList10 = arrayList2;
                arrayList9 = arrayList11;
                bundleArr2 = null;
                i4 = 0;
            }
            arrayList = arrayList9;
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            if (builder.q == null) {
                builder.q = new Bundle();
            }
            builder.q.putBundle("android.car.EXTENSIONS", bundle2);
            this.f2685d.putBundle("android.car.EXTENSIONS", bundle3);
        } else {
            arrayList = arrayList9;
        }
        int i11 = Build.VERSION.SDK_INT;
        this.f2683b.setExtras(builder.q);
        this.f2683b.setRemoteInputHistory(null);
        RemoteViews remoteViews = builder.t;
        if (remoteViews != null) {
            this.f2683b.setCustomContentView(remoteViews);
        }
        RemoteViews remoteViews2 = builder.u;
        if (remoteViews2 != null) {
            this.f2683b.setCustomBigContentView(remoteViews2);
        }
        if (i11 >= 26) {
            Api26Impl.b(this.f2683b);
            Api26Impl.d(this.f2683b);
            Api26Impl.e(this.f2683b);
            Api26Impl.f(this.f2683b);
            Api26Impl.c(this.f2683b);
            if (!TextUtils.isEmpty(builder.v)) {
                this.f2683b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i11 >= 28) {
            Iterator it6 = arrayList.iterator();
            while (it6.hasNext()) {
                Person person = (Person) it6.next();
                Notification.Builder builder4 = this.f2683b;
                person.getClass();
                Api28Impl.a(builder4, Person.Api28Impl.a(person));
            }
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 29) {
            Api29Impl.a(this.f2683b, builder.x);
            Api29Impl.b(this.f2683b);
        }
        if (i12 < 31 || (i2 = builder.w) == 0) {
            return;
        }
        Api31Impl.b(this.f2683b, i2);
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public final Notification.Builder a() {
        return this.f2683b;
    }

    public final void b(NotificationCompat.Action action) {
        IconCompat iconCompatA = action.a();
        Notification.Action.Builder builder = new Notification.Action.Builder(iconCompatA != null ? iconCompatA.j(null) : null, action.f2653g, action.f2654h);
        RemoteInput[] remoteInputArr = action.f2649c;
        if (remoteInputArr != null) {
            android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
            for (int i2 = 0; i2 < remoteInputArr.length; i2++) {
                remoteInputArr[i2].getClass();
                RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(null).setLabel(null).setChoices(null).setAllowFreeFormInput(false).addExtras(null);
                if (Build.VERSION.SDK_INT >= 29) {
                    RemoteInput.Api29Impl.a(builderAddExtras);
                }
                remoteInputArr2[i2] = builderAddExtras.build();
            }
            for (android.app.RemoteInput remoteInput : remoteInputArr2) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = action.f2647a;
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        boolean z = action.f2650d;
        bundle2.putBoolean("android.support.allowGeneratedReplies", z);
        int i3 = Build.VERSION.SDK_INT;
        builder.setAllowGeneratedReplies(z);
        bundle2.putInt("android.support.action.semanticAction", 0);
        if (i3 >= 28) {
            Api28Impl.b(builder);
        }
        if (i3 >= 29) {
            Api29Impl.c(builder);
        }
        if (i3 >= 31) {
            Api31Impl.a(builder);
        }
        bundle2.putBoolean("android.support.action.showsUserInterface", action.f2651e);
        builder.addExtras(bundle2);
        this.f2683b.addAction(builder.build());
    }
}
