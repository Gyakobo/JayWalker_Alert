/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/SpeedLimitType.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * Class definition of the SpeedLimitType type of the dsrc module.
 */
public class SpeedLimitType extends fr.marben.asnsdk.japi.spe.ExtEnumeratedValue
{
  /**
   * value of the named enumerated unknown.
   */
  public static final int ASN_unknown = 0;

  /**
   * value of the named enumerated maxSpeedInSchoolZone.
   */
  public static final int ASN_maxSpeedInSchoolZone = 1;

  /**
   * value of the named enumerated maxSpeedInSchoolZoneWhenChildrenArePresent.
   */
  public static final int ASN_maxSpeedInSchoolZoneWhenChildrenArePresent = 2;

  /**
   * value of the named enumerated maxSpeedInConstructionZone.
   */
  public static final int ASN_maxSpeedInConstructionZone = 3;

  /**
   * value of the named enumerated vehicleMinSpeed.
   */
  public static final int ASN_vehicleMinSpeed = 4;

  /**
   * value of the named enumerated vehicleMaxSpeed.
   */
  public static final int ASN_vehicleMaxSpeed = 5;

  /**
   * value of the named enumerated vehicleNightMaxSpeed.
   */
  public static final int ASN_vehicleNightMaxSpeed = 6;

  /**
   * value of the named enumerated truckMinSpeed.
   */
  public static final int ASN_truckMinSpeed = 7;

  /**
   * value of the named enumerated truckMaxSpeed.
   */
  public static final int ASN_truckMaxSpeed = 8;

  /**
   * value of the named enumerated truckNightMaxSpeed.
   */
  public static final int ASN_truckNightMaxSpeed = 9;

  /**
   * value of the named enumerated vehiclesWithTrailersMinSpeed.
   */
  public static final int ASN_vehiclesWithTrailersMinSpeed = 10;

  /**
   * value of the named enumerated vehiclesWithTrailersMaxSpeed.
   */
  public static final int ASN_vehiclesWithTrailersMaxSpeed = 11;

  /**
   * value of the named enumerated vehiclesWithTrailersNightMaxSpeed.
   */
  public static final int ASN_vehiclesWithTrailersNightMaxSpeed = 12;

  /**
   *  Constructs a newly allocated SpeedLimitType.
   */
  public SpeedLimitType ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated SpeedLimitType that represents the primitive int argument.
   *  @param value the value to be represented by this SpeedLimitType.
   */
  public SpeedLimitType (int value)
  {
    super(value);
  };

  /**
   *  Constructs a newly allocated SpeedLimitType that represents the unknownExt argument.
   *  @param unknownExt the unknown extension value to be represented by this SpeedLimitType.
   */
  public SpeedLimitType (fr.marben.asnsdk.japi.UnknownExtensionValue unknownExt)
  {
    super(unknownExt);
  };
}