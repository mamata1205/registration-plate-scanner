package org.platescanner;

import android.content.Context;

import org.platescanner.util.Utils;

import java.io.File;

/**
 * Automatic License Plate Recognition library http://www.platescanner.com
 *
 * Android version.
 */
public interface platescanner {

    /**
     * Recognizes the licence plate.
     *
     * @param imgFilePath - Image containing the license plate
     * @param topN        - Max number of possible plate numbers to return(default 10)
     *
     * @return - JSON string of results
     */
    String recognize(String imgFilePath, int topN);

    /**
     * Recognizes the licence plate.
     *
     * @param country     - Country code to identify (either us for USA or eu for Europe).
     *                    Default=us
     * @param region      -  Attempt to match the plate number against a region template (e.g., md
     *                    for Maryland, ca for California)
     * @param imgFilePath - Image containing the license plate
     * @param topN        - Max number of possible plate numbers to return(default 10)
     *
     * @return - JSON string of results
     */
    String recognizeWithCountryNRegion(String country, String region, String imgFilePath, int topN);

    /**
     * Recognizes the licence plate.
     *
     * @param country        - Country code to identify (either us for USA or eu for Europe).
     *                       Default=us
     * @param region         -  Attempt to match the plate number against a region template (e.g., md
     *                       for Maryland, ca for California)
     * @param imgFilePath    - Image containing the license plate
     * @param configFilePath - Config file path (default /etc/platescanner/platescanner.conf)
     * @param topN           - Max number of possible plate numbers to return(default 10)
     *
     * @return - JSON string of results
     */
    String recognizeWithCountryRegionNConfig(String country, String region, String configFilePath, String imgFilePath, int topN);

    /**
     * Returns the Open ALPR version.
     *
     * @return - Version string
     */
    String version();

    /**
     * platescanner factory.
     */
    class Factory {

        private Factory() {}

        static platescanner instance;

        /**
         *
         * @param context The application context.
         * @param androidDataDir The application data directory. Something like: "/data/data/com.sandro.platescannersample".
         *
         * @return returns the platescanner instance.
         */
        public synchronized static platescanner create(Context context, String androidDataDir) {
            if (instance == null) {
                instance = new AlprJNIWrapper();

                Utils.copyAssetFolder(context.getAssets(), "runtime_data", androidDataDir + File.separatorChar + "runtime_data");
            }

            return instance;
        }
    }

}
