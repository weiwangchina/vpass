/*
 * Copyright (C) 2016-2017 mzlion(mzllon@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.isstech.vpass.tools;

import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * SSL
 *
 * @author mzlion on 2016/12/7.
 */
public class SSLContexts {

    private static final String DEFAULT_SSL_PROTOCAL = "TLSv1.2";

    /**
     * 不对证书进行验证
     */
    private static X509TrustManager unSafeTrustManager = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
                throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
                throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };

    private static HostnameVerifier hostnameVerifier = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    /**
     * Try to parse the SSL certificate
     *
     * @param x509TrustManager Custom Certificate Manager
     * @return {@link SSLConfig}
     */
    public static SSLConfig defualtParse(X509TrustManager x509TrustManager) {
        try {
            SSLConfig sslConfig = new SSLConfig();
            sslConfig.setHostnameVerifier(hostnameVerifier);
            X509TrustManager trustManager =
                    x509TrustManager == null ? unSafeTrustManager : x509TrustManager;

            //Create a TLS type SSLContext object.
            SSLContext sslContext = SSLContext.getInstance(DEFAULT_SSL_PROTOCAL);
            // Initialize the SSLContext with the trustManagers obtained above so that the sslContext will trust the certificate in the keyStore
            sslContext.init(null, new TrustManager[]{trustManager}, null);

            sslConfig.setSslSocketFactory(sslContext.getSocketFactory());
            sslConfig.setX509TrustManager(trustManager);
            return sslConfig;
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    /**
     * The type Ssl config.
     */
    public static final class SSLConfig {

        private SSLSocketFactory sslSocketFactory;

        private X509TrustManager x509TrustManager;

        private HostnameVerifier hostnameVerifier;

        /**
         * Gets ssl socket factory.
         *
         * @return the ssl socket factory
         */
        public SSLSocketFactory getSslSocketFactory() {
            return sslSocketFactory;
        }

        /**
         * Sets ssl socket factory.
         *
         * @param sslSocketFactory the ssl socket factory
         */
        void setSslSocketFactory(SSLSocketFactory sslSocketFactory) {
            this.sslSocketFactory = sslSocketFactory;
        }

        /**
         * Gets x 509 trust manager.
         *
         * @return the x 509 trust manager
         */
        public X509TrustManager getX509TrustManager() {
            return x509TrustManager;
        }

        /**
         * Sets x 509 trust manager.
         *
         * @param x509TrustManager the x 509 trust manager
         */
        void setX509TrustManager(X509TrustManager x509TrustManager) {
            this.x509TrustManager = x509TrustManager;
        }

        /**
         * Gets hostname verifier.
         *
         * @return the hostname verifier
         */
        public HostnameVerifier getHostnameVerifier() {
            return hostnameVerifier;
        }

        /**
         * Sets hostname verifier.
         *
         * @param hostnameVerifier the hostname verifier
         */
        public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
        }
    }
}
