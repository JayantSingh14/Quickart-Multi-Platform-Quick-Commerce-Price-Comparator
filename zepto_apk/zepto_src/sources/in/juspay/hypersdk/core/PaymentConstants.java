package in.juspay.hypersdk.core;

import androidx.annotation.Keep;

/* loaded from: classes4.dex */
public class PaymentConstants {
    public static final String ACS = "payments/in.juspay.godel/v1-acs.jsa";
    public static final String AMOUNT = "amount";
    public static final String ASSET_AAR_VERSION = "asset_aar_version";
    public static final String ATTR_HASH_IN_DISK = "hashInDisk";
    public static final String BANK = "bank";
    public static final String BETA_ASSETS = "betaAssets";

    @Keep
    public static final String BLOCKED_WALLETS = "udf_disabled_methods";
    public static final String BUILD_ID = "jp_hyper_build_id";

    @Keep
    public static final String CLIENT_AUTH_TOKEN = "session_token";
    public static final String CLIENT_EMAIL = "customer_email";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_ID_CAMEL = "clientId";
    public static final String CLIENT_MOBILE_NO = "customer_phone_number";

    @Keep
    public static final String CUSTOMER_EMAIL = "customer_email";

    @Keep
    public static final String CUSTOMER_ID = "customer_id";

    @Keep
    public static final String CUSTOMER_MOBILE = "customer_phone_number";
    public static final String DELIVER_SMS = "DELIVER_SMS";
    public static final String DESCRIPTION = "display_note";

    @Keep
    public static final String END_URLS = "endUrls";

    @Keep
    public static final String ENV = "environment";
    public static final String FRAGMENT_VIEW_GROUPS = "fragmentViewGroups";
    public static final String GODEL = "GODEL";
    public static final String GODEL_BUILD_VERSION = "godel_build_version";
    public static final String GODEL_VERSION = "godel_version";

    @Keep
    public static final String ITEM_COUNT = "itemCount";
    public static final String JP_HASH_AND_STATUS = "jp_hash_and_status";
    public static final String LOG_VERSION = "2.0.1";

    @Keep
    public static final String MCC = "mcc";
    public static final String MERCHANT_ID = "merchant_id";
    public static final String MERCHANT_ID_CAMEL = "merchantId";

    @Keep
    public static final String MERCHANT_KEY_ID = "merchant_key_id";
    public static final String NETWORK_STATUS = "NETWORK_STATUS";

    @Keep
    public static final String OFFER_APPLIED = "offer_applied";

    @Keep
    public static final String OFFER_CODE = "offer_code";

    @Keep
    public static final String OFFER_DISCOUNT = "offer_discount";

    @Keep
    public static final String OFFER_PAYMENT_CARD_ISSUER = "offer_payment_card_issuer";

    @Keep
    public static final String OFFER_PAYMENT_CARD_TYPE = "offer_payment_card_type";

    @Keep
    public static final String OFFER_PAYMENT_METHOD = "offer_payment_method";

    @Keep
    public static final String OFFER_PAYMENT_METHOD_TYPE = "offer_payment_method_type";
    public static final String ORDER_DETAILS_CAMEL = "orderDetails";
    public static final String ORDER_ID = "order_id";
    public static final String ORDER_ID_CAMEL = "orderId";

    @Keep
    public static final String PAYLOAD = "payload";

    @Keep
    public static final String PAYMENT_PAGE_TITLE = "udf_title";

    @Keep
    public static final String POST_DATA = "postData";
    public static final String PROJECT_ID = "project_id";
    public static final String REQUEST_PERMISSION_PREFIX = "ReqPermi";
    public static final int REQUEST_SMS_PERMISSION = 7;
    public static final String SDK_CONFIG = "sdk_meta";
    public static final String SDK_NAME = "sdkName";
    public static final String SDK_VERSION = "sdkVersion";
    public static final String SEND_SMS = "SEND_SMS";
    public static final String SERVICE = "service";

    @Keep
    public static final String SIGNATURE = "signature";

    @Keep
    public static final String SIGNATURE_PAYLOAD = "signature_payload";
    public static final String SIGNATURE_PAYLOAD_CAMEL = "signaturePayload";
    public static final String SMS_CONSENT = "SMS_CONSENT";
    public static final String SMS_RECEIVE = "SMS_RECEIVE";
    public static final String SMS_RETRIEVER = "SMS_RETRIEVER";

    @Keep
    public static final String TIMESTAMP = "timestamp";

    @Keep
    public static final String UDF5 = "udf5";

    @Keep
    public static final String URL = "url";
    public static final String VIES_PAY = "VIES_PAY";

    @Keep
    public static final String WIDGET_ADD_CARD = "addCard";

    @Keep
    public static final String WIDGET_ADD_WALLETS = "addAndLinkWallet";

    @Keep
    public static final String WIDGET_DELINK_WALLET = "delinkWallet";

    @Keep
    public static final String WIDGET_NAME = "widget_key";

    @Keep
    public static final String WIDGET_NETBANKING = "nb";

    @Keep
    public static final String WIDGET_PAYMENT_PAGE = "paymentPage";

    @Keep
    public static final String WIDGET_UPI = "upi";

    @Keep
    public static final Boolean IS_SIGNATURE_BASED = Boolean.TRUE;

    @Keep
    public static final Boolean ADD_MANDATE_PARAMS = Boolean.FALSE;

    @Keep
    public static abstract class Category {
        public static final String ACS = "acs";
        public static final String CONFIG = "config";
        public static final String GODEL = "godel";
        public static final String JS = "JS";
        public static final String SDK = "sdk";
        public static final String UBER = "uber";
    }

    @Keep
    public static abstract class ENVIRONMENT {
        public static final String DEV = "dev";
        public static final String PRODUCTION = "prod";
        public static final String SANDBOX = "sandbox";
    }

    public static class Event {
        public static final String ERROR = "error";
        public static final String INFO = "info";
        public static final String SCREEN = "screen";
    }

    public static abstract class GodelOffReasons {
        public static final String LOW_ON_MEMORY = "LOW_ON_MEMORY";
        public static final String ON_GODEL_EXCEPTION = "ON_GODEL_EXCEPTION";
        public static final String TELEPHONY_NOT_FOUND = "TELEPHONY_NOT_FOUND";
    }
}
