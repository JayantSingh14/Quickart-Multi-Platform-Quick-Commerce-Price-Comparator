Java.perform(function () {
    console.log("[*] Zepto OkHttp payload hook loaded");

    try {
        var RequestBody = Java.use("okhttp3.RequestBody");
        var Buffer = Java.use("okio.Buffer");

        RequestBody.writeTo.implementation = function (sink) {
            try {
                var buffer = Buffer.$new();
                this.writeTo(buffer);

                var payload = buffer.readUtf8();

                if (
                    payload.indexOf("graphql") !== -1 ||
                    payload.indexOf("operationName") !== -1 ||
                    payload.indexOf("query") !== -1 ||
                    payload.indexOf("cart") !== -1 ||
                    payload.indexOf("sku") !== -1
                ) {
                    console.log("\n===== OKHTTP REQUEST BODY =====");
                    console.log(payload);
                    console.log("===============================\n");
                }
            } catch (e) {}

            return this.writeTo(sink);
        };

        console.log("[+] okhttp3.RequestBody hooked");
    } catch (e) {
        console.log("[-] OkHttp hook failed:", e);
    }
});
