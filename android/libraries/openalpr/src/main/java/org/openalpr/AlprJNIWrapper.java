package org.platescanner;

/**
 * Open ALPR wrapper.
 */
public class AlprJNIWrapper implements platescanner {

    static {
        System.loadLibrary("platescanner-native");
    }

    /* (non-Javadoc)
     * @see org.platescanner.Alpr#recognize(java.lang.String, int)
     */
    @Override
    public native String recognize(String imgFilePath, int topN);

    /* (non-Javadoc)
     * @see org.platescanner.Alpr#recognizeWithCountryNRegion(java.lang.String, java.lang.String, java.lang.String, int)
     */
    @Override
    public native String recognizeWithCountryNRegion(String country, String region,
                                                     String imgFilePath, int topN);

    /* (non-Javadoc)
     * @see org.platescanner.Alpr#recognizeWithCountryRegionNConfig(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
     */
    @Override
    public native String recognizeWithCountryRegionNConfig(String country,
                                                           String region, String imgFilePath, String configFilePath, int topN);

    /*
     * (non-Javadoc)
     * @see org.platescanner.Alpr#version()
     */
    @Override
    public native String version();
}