/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/addgrpb/SummerTime.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.addgrpb;

/**
 * <BR> Unsigned units of 1/100th seconds of angle, in 2 octets
 * <BR> values from 6000 to 65534 shall not be sent
 * <BR> the value 65535 (0xFFFF) shall indicate an invalid value
 * Class definition of the SummerTime type of the addgrpb module.
 */
public class SummerTime extends fr.marben.asnsdk.japi.spe.EnumeratedValue
{
  /**
   * value of the named enumerated notInSummerTime.
   */
  public static final int ASN_notInSummerTime = 0;

  /**
   * value of the named enumerated inSummerTime.
   */
  public static final int ASN_inSummerTime = 1;

  /**
   *  Constructs a newly allocated SummerTime.
   */
  public SummerTime ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated SummerTime that represents the primitive int argument.
   *  @param value the value to be represented by this SummerTime.
   */
  public SummerTime (int value)
  {
    super(value);
  };
}