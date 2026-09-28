package cl.json;

import android.app.Activity;
import android.content.Intent;
import cl.json.social.DiscordShare;
import cl.json.social.EmailShare;
import cl.json.social.FacebookPagesManagerShare;
import cl.json.social.FacebookShare;
import cl.json.social.FacebookStoriesShare;
import cl.json.social.GenericShare;
import cl.json.social.GooglePlusShare;
import cl.json.social.InstagramShare;
import cl.json.social.InstagramStoriesShare;
import cl.json.social.LinkedinShare;
import cl.json.social.MessengerShare;
import cl.json.social.PinterestShare;
import cl.json.social.SMSShare;
import cl.json.social.ShareIntent;
import cl.json.social.SnapChatShare;
import cl.json.social.TargetChosenReceiver;
import cl.json.social.TelegramShare;
import cl.json.social.TwitterShare;
import cl.json.social.ViberShare;
import cl.json.social.WhatsAppBusinessShare;
import cl.json.social.WhatsAppShare;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.Scopes;

/* loaded from: classes3.dex */
public class RNShareImpl implements ActivityEventListener {

    /* renamed from: a, reason: collision with root package name */
    public static ReactApplicationContext f13815a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class SHARES {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SHARES[] f13816a = {new SHARES("facebook", 0), new SHARES("facebookstories", 1), new SHARES("generic", 2), new SHARES("pagesmanager", 3), new SHARES("twitter", 4), new SHARES("whatsapp", 5), new SHARES("whatsappbusiness", 6), new SHARES("instagram", 7), new SHARES("instagramstories", 8), new SHARES("googleplus", 9), new SHARES(Scopes.EMAIL, 10), new SHARES("pinterest", 11), new SHARES("messenger", 12), new SHARES("snapchat", 13), new SHARES("sms", 14), new SHARES("linkedin", 15), new SHARES("telegram", 16), new SHARES("viber", 17), new SHARES("discord", 18)};

        /* JADX INFO: Fake field, exist only in values array */
        SHARES EF5;

        public static ShareIntent a(ReactApplicationContext reactApplicationContext, String str) {
            switch (valueOf(str).ordinal()) {
                case 0:
                    return new FacebookShare(reactApplicationContext);
                case 1:
                    FacebookStoriesShare facebookStoriesShare = new FacebookStoriesShare(reactApplicationContext);
                    facebookStoriesShare.f13832b = new Intent("com.facebook.stories.ADD_TO_STORY");
                    return facebookStoriesShare;
                case 2:
                    return new GenericShare(reactApplicationContext);
                case 3:
                    return new FacebookPagesManagerShare(reactApplicationContext);
                case 4:
                    return new TwitterShare(reactApplicationContext);
                case 5:
                    return new WhatsAppShare(reactApplicationContext);
                case 6:
                    return new WhatsAppBusinessShare(reactApplicationContext);
                case 7:
                    return new InstagramShare(reactApplicationContext);
                case 8:
                    InstagramStoriesShare instagramStoriesShare = new InstagramStoriesShare(reactApplicationContext);
                    instagramStoriesShare.f13832b = new Intent("com.instagram.share.ADD_TO_STORY");
                    return instagramStoriesShare;
                case 9:
                    return new GooglePlusShare(reactApplicationContext);
                case 10:
                    return new EmailShare(reactApplicationContext);
                case 11:
                    return new PinterestShare(reactApplicationContext);
                case 12:
                    return new MessengerShare(reactApplicationContext);
                case 13:
                    return new SnapChatShare(reactApplicationContext);
                case 14:
                    SMSShare sMSShare = new SMSShare(reactApplicationContext);
                    sMSShare.f13830f = reactApplicationContext;
                    return sMSShare;
                case 15:
                    return new LinkedinShare(reactApplicationContext);
                case 16:
                    return new TelegramShare(reactApplicationContext);
                case 17:
                    return new ViberShare(reactApplicationContext);
                case 18:
                    return new DiscordShare(reactApplicationContext);
                default:
                    return null;
            }
        }

        public static SHARES valueOf(String str) {
            return (SHARES) Enum.valueOf(SHARES.class, str);
        }

        public static SHARES[] values() {
            return (SHARES[]) f13816a.clone();
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public final void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        if (i2 == 16845) {
            if (i3 == 0) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putBoolean(APayConstants.SUCCESS, false);
                writableMapCreateMap.putString(APayConstants.Error.MESSAGE, "CANCELED");
                TargetChosenReceiver.b(writableMapCreateMap);
                return;
            }
            if (i3 == -1) {
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putBoolean(APayConstants.SUCCESS, true);
                TargetChosenReceiver.b(writableMapCreateMap2);
            }
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public final void onNewIntent(Intent intent) {
    }
}
