/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/LaneAttributes_Bike.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * Class definition of the LaneAttributes_Bike type of the dsrc module.
 */
public class LaneAttributes_Bike extends fr.marben.asnsdk.japi.spe.BitStringValue
{
  /**
   * value of the named bit bikeRevocableLane.
   */
  public static final int ASN_bikeRevocableLane = 0;

  /**
   * value of the named bit pedestrianUseAllowed.
   */
  public static final int ASN_pedestrianUseAllowed = 1;

  /**
   * value of the named bit isBikeFlyOverLane.
   */
  public static final int ASN_isBikeFlyOverLane = 2;

  /**
   * value of the named bit fixedCycleTime.
   */
  public static final int ASN_fixedCycleTime = 3;

  /**
   * value of the named bit biDirectionalCycleTimes.
   */
  public static final int ASN_biDirectionalCycleTimes = 4;

  /**
   * value of the named bit isolatedByBarrier.
   */
  public static final int ASN_isolatedByBarrier = 5;

  /**
   * value of the named bit unsignalizedSegmentsPresent.
   */
  public static final int ASN_unsignalizedSegmentsPresent = 6;

  /**
   *  Constructs a newly allocated LaneAttributes_Bike.
   */
  public LaneAttributes_Bike ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated LaneAttributes_Bike.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the bytes array parameter.
   *  @param value the value to be represented by this LaneAttributes_Bike.
   *  @param bitCount the number of used bits to be represented by this LaneAttributes_Bike.
   *  @throws IllegalArgumentException if the bitCount is not consistent with the length of the value.
   */
  public LaneAttributes_Bike (byte[] value, int bitCount)
  {
    super(value, bitCount);
  }

  /**
   *  Constructs a newly allocated LaneAttributes_Bike.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the subarray of bytes.
   *  @param value the array containing the value to be represented by this LaneAttributes_Bike.
   *  @param bitOffset  the index of the first bit to be represented by this LaneAttributes_Bike.
   *  @param bitCount the number of used bits to be represented by this LaneAttributes_Bike.
   *  @throws IllegalArgumentException if the bitCount and bitOffset are not consistent with the length of the value.
   */
  public LaneAttributes_Bike (byte[] value, int bitOffset, int bitCount)
  {
    super(value, bitOffset, bitCount);
  }
}
