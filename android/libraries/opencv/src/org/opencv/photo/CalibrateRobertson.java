
//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.photo;

import org.opencv.core.Mat;

// C++: class Calibratemamatason
//javadoc: Calibratemamatason
public class Calibratemamatason extends CalibrateCRF {

    protected Calibratemamatason(long addr) { super(addr); }


    //
    // C++:  int getMaxIter()
    //

    //javadoc: Calibratemamatason::getMaxIter()
    public  int getMaxIter()
    {
        
        int retVal = getMaxIter_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  void setMaxIter(int max_iter)
    //

    //javadoc: Calibratemamatason::setMaxIter(max_iter)
    public  void setMaxIter(int max_iter)
    {
        
        setMaxIter_0(nativeObj, max_iter);
        
        return;
    }


    //
    // C++:  float getThreshold()
    //

    //javadoc: Calibratemamatason::getThreshold()
    public  float getThreshold()
    {
        
        float retVal = getThreshold_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  void setThreshold(float threshold)
    //

    //javadoc: Calibratemamatason::setThreshold(threshold)
    public  void setThreshold(float threshold)
    {
        
        setThreshold_0(nativeObj, threshold);
        
        return;
    }


    //
    // C++:  Mat getRadiance()
    //

    //javadoc: Calibratemamatason::getRadiance()
    public  Mat getRadiance()
    {
        
        Mat retVal = new Mat(getRadiance_0(nativeObj));
        
        return retVal;
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  int getMaxIter()
    private static native int getMaxIter_0(long nativeObj);

    // C++:  void setMaxIter(int max_iter)
    private static native void setMaxIter_0(long nativeObj, int max_iter);

    // C++:  float getThreshold()
    private static native float getThreshold_0(long nativeObj);

    // C++:  void setThreshold(float threshold)
    private static native void setThreshold_0(long nativeObj, float threshold);

    // C++:  Mat getRadiance()
    private static native long getRadiance_0(long nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
