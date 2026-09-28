package androidx.media3.session;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class CommandButton {

    /* renamed from: i, reason: collision with root package name */
    public static final String f9864i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f9865j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f9866k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f9867l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f9868m;
    public static final String n;
    public static final String o;
    public static final String p;

    /* renamed from: a, reason: collision with root package name */
    public final SessionCommand f9869a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9870b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9871c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9872d;

    /* renamed from: e, reason: collision with root package name */
    public final Uri f9873e;

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f9874f;

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f9875g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f9876h;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public SessionCommand f9877a;

        /* renamed from: b, reason: collision with root package name */
        public int f9878b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9879c;

        /* renamed from: d, reason: collision with root package name */
        public int f9880d;

        /* renamed from: e, reason: collision with root package name */
        public Uri f9881e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f9882f;

        /* renamed from: g, reason: collision with root package name */
        public Bundle f9883g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f9884h;

        public Builder() {
            this(0);
        }

        public final CommandButton a() {
            Assertions.f("Exactly one of sessionCommand and playerCommand should be set", (this.f9877a == null) != (this.f9878b == -1));
            return new CommandButton(this.f9877a, this.f9878b, this.f9879c, this.f9880d, this.f9881e, this.f9882f, this.f9883g, this.f9884h);
        }

        public final void b(int i2) {
            Assertions.b(this.f9877a == null, "sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.");
            this.f9878b = i2;
        }

        public final void c(SessionCommand sessionCommand) {
            Assertions.b(this.f9878b == -1, "playerCommands is already set. Only one of sessionCommand and playerCommand should be set.");
            this.f9877a = sessionCommand;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Builder(int i2) {
            int i3;
            String str = CommandButton.f9864i;
            switch (i2) {
                case 57369:
                    i3 = R.drawable.media3_icon_album;
                    break;
                case 57370:
                    i3 = R.drawable.media3_icon_artist;
                    break;
                case 57372:
                    i3 = R.drawable.media3_icon_closed_captions;
                    break;
                case 57375:
                    i3 = R.drawable.media3_icon_fast_forward;
                    break;
                case 57376:
                    i3 = R.drawable.media3_icon_rewind;
                    break;
                case 57396:
                    i3 = R.drawable.media3_icon_pause;
                    break;
                case 57399:
                    i3 = R.drawable.media3_icon_play;
                    break;
                case 57403:
                    i3 = R.drawable.media3_icon_playlist_add;
                    break;
                case 57408:
                    i3 = R.drawable.media3_icon_repeat_all;
                    break;
                case 57409:
                    i3 = R.drawable.media3_icon_repeat_one;
                    break;
                case 57410:
                    i3 = R.drawable.media3_icon_skip_back;
                    break;
                case 57411:
                    i3 = R.drawable.media3_icon_shuffle_on;
                    break;
                case 57412:
                    i3 = R.drawable.media3_icon_next;
                    break;
                case 57413:
                    i3 = R.drawable.media3_icon_previous;
                    break;
                case 57415:
                    i3 = R.drawable.media3_icon_stop;
                    break;
                case 57416:
                    i3 = R.drawable.media3_icon_subtitles;
                    break;
                case 57421:
                    i3 = R.drawable.media3_icon_volume_down;
                    break;
                case 57423:
                    i3 = R.drawable.media3_icon_volume_off;
                    break;
                case 57424:
                    i3 = R.drawable.media3_icon_volume_up;
                    break;
                case 57430:
                    i3 = R.drawable.media3_icon_skip_forward_10;
                    break;
                case 57431:
                    i3 = R.drawable.media3_icon_skip_forward_30;
                    break;
                case 57432:
                    i3 = R.drawable.media3_icon_skip_forward_5;
                    break;
                case 57433:
                    i3 = R.drawable.media3_icon_skip_back_10;
                    break;
                case 57434:
                    i3 = R.drawable.media3_icon_skip_back_30;
                    break;
                case 57435:
                    i3 = R.drawable.media3_icon_skip_back_5;
                    break;
                case 57436:
                    i3 = R.drawable.media3_icon_queue_add;
                    break;
                case 57446:
                    i3 = R.drawable.media3_icon_queue_next;
                    break;
                case 57447:
                    i3 = R.drawable.media3_icon_queue_remove;
                    break;
                case 57448:
                    i3 = R.drawable.media3_icon_playback_speed;
                    break;
                case 57573:
                    i3 = R.drawable.media3_icon_feed;
                    break;
                case 57669:
                    i3 = R.drawable.media3_icon_plus;
                    break;
                case 57671:
                    i3 = R.drawable.media3_icon_plus_circle_unfilled;
                    break;
                case 57675:
                    i3 = R.drawable.media3_icon_block;
                    break;
                case 57683:
                    i3 = R.drawable.media3_icon_flag_unfilled;
                    break;
                case 57691:
                    i3 = R.drawable.media3_icon_minus;
                    break;
                case 58409:
                    i3 = R.drawable.media3_icon_quality;
                    break;
                case 58654:
                    i3 = R.drawable.media3_icon_radio;
                    break;
                case 58919:
                    i3 = R.drawable.media3_icon_sync;
                    break;
                case 59405:
                    i3 = R.drawable.media3_icon_share;
                    break;
                case 59448:
                    i3 = R.drawable.media3_icon_star_unfilled;
                    break;
                case 59494:
                    i3 = R.drawable.media3_icon_bookmark_unfilled;
                    break;
                case 59500:
                    i3 = R.drawable.media3_icon_check_circle_unfilled;
                    break;
                case 59517:
                    i3 = R.drawable.media3_icon_heart_unfilled;
                    break;
                case 59576:
                    i3 = R.drawable.media3_icon_settings;
                    break;
                case 59611:
                    i3 = R.drawable.media3_icon_thumb_down_unfilled;
                    break;
                case 59612:
                    i3 = R.drawable.media3_icon_thumb_up_unfilled;
                    break;
                case 60288:
                    i3 = R.drawable.media3_icon_playlist_remove;
                    break;
                case 61298:
                    i3 = R.drawable.media3_icon_subtitles_off;
                    break;
                case 61389:
                    i3 = R.drawable.media3_icon_playback_speed_1_0;
                    break;
                case 61512:
                    i3 = R.drawable.media3_icon_signal;
                    break;
                case 61916:
                    i3 = R.drawable.media3_icon_closed_captions_off;
                    break;
                case 62688:
                    i3 = R.drawable.media3_icon_playback_speed_1_5;
                    break;
                case 62689:
                    i3 = R.drawable.media3_icon_playback_speed_1_2;
                    break;
                case 62690:
                    i3 = R.drawable.media3_icon_playback_speed_0_5;
                    break;
                case 62699:
                    i3 = R.drawable.media3_icon_playback_speed_2_0;
                    break;
                case 63220:
                    i3 = R.drawable.media3_icon_skip_forward;
                    break;
                case 1040448:
                    i3 = R.drawable.media3_icon_repeat_off;
                    break;
                case 1040451:
                    i3 = R.drawable.media3_icon_shuffle_star;
                    break;
                case 1040452:
                    i3 = R.drawable.media3_icon_shuffle_off;
                    break;
                case 1040470:
                    i3 = R.drawable.media3_icon_skip_forward_15;
                    break;
                case 1040473:
                    i3 = R.drawable.media3_icon_skip_back_15;
                    break;
                case 1040711:
                    i3 = R.drawable.media3_icon_plus_circle_filled;
                    break;
                case 1040712:
                    i3 = R.drawable.media3_icon_minus_circle_filled;
                    break;
                case 1040713:
                    i3 = R.drawable.media3_icon_minus_circle_unfilled;
                    break;
                case 1040723:
                    i3 = R.drawable.media3_icon_flag_filled;
                    break;
                case 1042488:
                    i3 = R.drawable.media3_icon_star_filled;
                    break;
                case 1042534:
                    i3 = R.drawable.media3_icon_bookmark_filled;
                    break;
                case 1042540:
                    i3 = R.drawable.media3_icon_check_circle_filled;
                    break;
                case 1042557:
                    i3 = R.drawable.media3_icon_heart_filled;
                    break;
                case 1042651:
                    i3 = R.drawable.media3_icon_thumb_down_filled;
                    break;
                case 1042652:
                    i3 = R.drawable.media3_icon_thumb_up_filled;
                    break;
                case 1045728:
                    i3 = R.drawable.media3_icon_playback_speed_1_8;
                    break;
                case 1045730:
                    i3 = R.drawable.media3_icon_playback_speed_0_8;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            this(i2, i3);
        }

        public Builder(int i2, int i3) {
            this.f9879c = i2;
            this.f9880d = i3;
            this.f9882f = "";
            this.f9883g = Bundle.EMPTY;
            this.f9878b = -1;
            this.f9884h = true;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface Icon {
    }

    static {
        int i2 = Util.f5744a;
        f9864i = Integer.toString(0, 36);
        f9865j = Integer.toString(1, 36);
        f9866k = Integer.toString(2, 36);
        f9867l = Integer.toString(3, 36);
        f9868m = Integer.toString(4, 36);
        n = Integer.toString(5, 36);
        o = Integer.toString(6, 36);
        p = Integer.toString(7, 36);
    }

    public CommandButton(SessionCommand sessionCommand, int i2, int i3, int i4, Uri uri, CharSequence charSequence, Bundle bundle, boolean z) {
        this.f9869a = sessionCommand;
        this.f9870b = i2;
        this.f9871c = i3;
        this.f9872d = i4;
        this.f9873e = uri;
        this.f9874f = charSequence;
        this.f9875g = new Bundle(bundle);
        this.f9876h = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.common.collect.ImmutableList a(java.util.List r13, androidx.media3.session.SessionCommands r14, androidx.media3.common.Player.Commands r15) {
        /*
            com.google.common.collect.ImmutableList$Builder r0 = new com.google.common.collect.ImmutableList$Builder
            r0.<init>()
            r1 = 0
        L6:
            int r2 = r13.size()
            if (r1 >= r2) goto L55
            java.lang.Object r2 = r13.get(r1)
            androidx.media3.session.CommandButton r2 = (androidx.media3.session.CommandButton) r2
            androidx.media3.session.SessionCommand r3 = r2.f9869a
            if (r3 == 0) goto L21
            r14.getClass()
            com.google.common.collect.ImmutableSet r4 = r14.f10238a
            boolean r3 = r4.contains(r3)
            if (r3 != 0) goto L2c
        L21:
            r3 = -1
            int r4 = r2.f9870b
            if (r4 == r3) goto L30
            boolean r3 = r15.a(r4)
            if (r3 == 0) goto L30
        L2c:
            r0.h(r2)
            goto L52
        L30:
            boolean r3 = r2.f9876h
            if (r3 != 0) goto L35
            goto L4f
        L35:
            androidx.media3.session.CommandButton r4 = new androidx.media3.session.CommandButton
            android.os.Bundle r11 = new android.os.Bundle
            android.os.Bundle r3 = r2.f9875g
            r11.<init>(r3)
            int r8 = r2.f9872d
            r12 = 0
            androidx.media3.session.SessionCommand r5 = r2.f9869a
            int r6 = r2.f9870b
            int r7 = r2.f9871c
            android.net.Uri r9 = r2.f9873e
            java.lang.CharSequence r10 = r2.f9874f
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            r2 = r4
        L4f:
            r0.h(r2)
        L52:
            int r1 = r1 + 1
            goto L6
        L55:
            com.google.common.collect.ImmutableList r13 = r0.j()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.CommandButton.a(java.util.List, androidx.media3.session.SessionCommands, androidx.media3.common.Player$Commands):com.google.common.collect.ImmutableList");
    }

    public static CommandButton b(int i2, Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f9864i);
        SessionCommand sessionCommandA = bundle2 == null ? null : SessionCommand.a(bundle2);
        int i3 = bundle.getInt(f9865j, -1);
        int i4 = bundle.getInt(f9866k, 0);
        CharSequence charSequence = bundle.getCharSequence(f9867l, "");
        Bundle bundle3 = bundle.getBundle(f9868m);
        boolean z = true;
        if (i2 >= 3 && !bundle.getBoolean(n, true)) {
            z = false;
        }
        Uri uri = (Uri) bundle.getParcelable(o);
        Builder builder = new Builder(bundle.getInt(p, 0), i4);
        if (sessionCommandA != null) {
            builder.c(sessionCommandA);
        }
        if (i3 != -1) {
            builder.b(i3);
        }
        if (uri != null) {
            builder.f9881e = uri;
        }
        builder.f9882f = charSequence;
        if (bundle3 == null) {
            bundle3 = Bundle.EMPTY;
        }
        builder.f9883g = new Bundle(bundle3);
        builder.f9884h = z;
        return builder.a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandButton)) {
            return false;
        }
        CommandButton commandButton = (CommandButton) obj;
        return Objects.a(this.f9869a, commandButton.f9869a) && this.f9870b == commandButton.f9870b && this.f9871c == commandButton.f9871c && this.f9872d == commandButton.f9872d && Objects.a(this.f9873e, commandButton.f9873e) && TextUtils.equals(this.f9874f, commandButton.f9874f) && this.f9876h == commandButton.f9876h;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9869a, Integer.valueOf(this.f9870b), Integer.valueOf(this.f9871c), Integer.valueOf(this.f9872d), this.f9874f, Boolean.valueOf(this.f9876h), this.f9873e});
    }
}
