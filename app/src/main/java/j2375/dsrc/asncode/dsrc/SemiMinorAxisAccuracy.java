/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/SemiMinorAxisAccuracy.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * <BR> orientation of semi-major axis 
 * <BR> relative to true north (0~3599945078786 degrees)
 * <BR> LSB units of 360/65535 deg  = 00054932479
 * <BR> a value of 0 shall be 0 degrees
 * <BR> a value of 1 shall be 00054932479 degrees 
 * <BR> a value of 65534 shall be 3599945078786 deg
 * <BR> a value of 65535 shall be used for orientation unavailable
 * Class definition of the SemiMinorAxisAccuracy type of the dsrc module.
 */
public class SemiMinorAxisAccuracy extends fr.marben.asnsdk.japi.spe.IntIntegerValue
{
  /**
   *  Constructs a newly allocated SemiMinorAxisAccuracy.
   */
  public SemiMinorAxisAccuracy ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated SemiMinorAxisAccuracy that represents the primitive int argument.
   *  @param value the value to be represented by this SemiMinorAxisAccuracy.
   */
  public SemiMinorAxisAccuracy (int value)
  {
    super(value);
  };
}
