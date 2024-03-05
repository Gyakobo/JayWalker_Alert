/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/VehicleEventFlags.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * Class definition of the VehicleEventFlags type of the dsrc module.
 */
public class VehicleEventFlags extends fr.marben.asnsdk.japi.spe.BitStringValue
{
  /**
   * value of the named bit eventHazardLights.
   */
  public static final int ASN_eventHazardLights = 0;

  /**
   * value of the named bit eventStopLineViolation.
   */
  public static final int ASN_eventStopLineViolation = 1;

  /**
   * value of the named bit eventABSactivated.
   */
  public static final int ASN_eventABSactivated = 2;

  /**
   * value of the named bit eventTractionControlLoss.
   */
  public static final int ASN_eventTractionControlLoss = 3;

  /**
   * value of the named bit eventStabilityControlactivated.
   */
  public static final int ASN_eventStabilityControlactivated = 4;

  /**
   * value of the named bit eventHazardousMaterials.
   */
  public static final int ASN_eventHazardousMaterials = 5;

  /**
   * value of the named bit eventReserved1.
   */
  public static final int ASN_eventReserved1 = 6;

  /**
   * value of the named bit eventHardBraking.
   */
  public static final int ASN_eventHardBraking = 7;

  /**
   * value of the named bit eventLightsChanged.
   */
  public static final int ASN_eventLightsChanged = 8;

  /**
   * value of the named bit eventWipersChanged.
   */
  public static final int ASN_eventWipersChanged = 9;

  /**
   * value of the named bit eventFlatTire.
   */
  public static final int ASN_eventFlatTire = 10;

  /**
   * value of the named bit eventDisabledVehicle.
   */
  public static final int ASN_eventDisabledVehicle = 11;

  /**
   * value of the named bit eventAirBagDeployment.
   */
  public static final int ASN_eventAirBagDeployment = 12;

  /**
   *  Constructs a newly allocated VehicleEventFlags.
   */
  public VehicleEventFlags ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated VehicleEventFlags.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the bytes array parameter.
   *  @param value the value to be represented by this VehicleEventFlags.
   *  @param bitCount the number of used bits to be represented by this VehicleEventFlags.
   *  @throws IllegalArgumentException if the bitCount is not consistent with the length of the value.
   */
  public VehicleEventFlags (byte[] value, int bitCount)
  {
    super(value, bitCount);
  }

  /**
   *  Constructs a newly allocated VehicleEventFlags.
   *  Sets the number of used bits using the int parameter
   *  and sets the internal value using the subarray of bytes.
   *  @param value the array containing the value to be represented by this VehicleEventFlags.
   *  @param bitOffset  the index of the first bit to be represented by this VehicleEventFlags.
   *  @param bitCount the number of used bits to be represented by this VehicleEventFlags.
   *  @throws IllegalArgumentException if the bitCount and bitOffset are not consistent with the length of the value.
   */
  public VehicleEventFlags (byte[] value, int bitOffset, int bitCount)
  {
    super(value, bitOffset, bitCount);
  }
}
