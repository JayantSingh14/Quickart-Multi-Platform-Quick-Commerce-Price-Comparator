Java.perform(function () {
    console.log("[+] Zepto full SSL bypass loaded");

    // 1. TrustManagerImpl (Android 7+)
    try {
        var TrustManagerImpl = Java.use('com.android.org.conscrypt.TrustManagerImpl');
        TrustManagerImpl.verifyChain.implementation = function () {
            console.log('[+] TrustManagerImpl.verifyChain bypass');
            return arguments[0];
        };
    } catch (e) {}

    // 2. OkHttp CertificatePinner
    try {
        var CertificatePinner = Java.use('okhttp3.CertificatePinner');
        CertificatePinner.check.overload(
            'java.lang.String',
            'java.util.List'
        ).implementation = function () {
            console.log('[+] OkHttp CertificatePinner bypass');
            return;
        };
    } catch (e) {}

    // 3. SSLContext
    try {
        var SSLContext = Java.use('javax.net.ssl.SSLContext');
        SSLContext.init.overload(
            '[Ljavax.net.ssl.KeyManager;',
            '[Ljavax.net.ssl.TrustManager;',
            'java.security.SecureRandom'
        ).implementation = function (km, tm, sr) {
            console.log('[+] SSLContext.init override');
            this.init(km, tm, sr);
        };
    } catch (e) {}

    // 4. WebView SSL errors
    try {
        var WebViewClient = Java.use('android.webkit.WebViewClient');
        WebViewClient.onReceivedSslError.implementation = function (view, handler, error) {
            console.log('[+] WebView SSL error bypass');
            handler.proceed();
        };
    } catch (e) {}

    console.log("[+] All hooks installed");
});
