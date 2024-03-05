/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/addgrpc/EmissionType.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.addgrpc;

/**
 * <BR> units of  001 meter 
 * <BR> Where: 
 * <BR> seaLevel(0), 
 * <BR> oneCentimeter(1), 
 * <BR> unavailable(800001)
 * Class definition of the EmissionType type of the addgrpc module.
 */
public class EmissionType extends fr.marben.asnsdk.japi.spe.ExtEnumeratedValue
{
  /**
   * value of the named enumerated typeA.
   */
  public static final int ASN_typeA = 0;

  /**
   * value of the named enumerated typeB.
   */
  public static final int ASN_typeB = 1;

  /**
   * value of the named enumerated typeC.
   */
  public static final int ASN_typeC = 2;

  /**
   * value of the named enumerated typeD.
   */
  public static final int ASN_typeD = 3;

  /**
   * value of the named enumerated typeE.
   */
  public static final int ASN_typeE = 4;

  /**
   *  Constructs a newly allocated EmissionType.
   */
  public EmissionType ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated EmissionType that represents the primitive int argument.
   *  @param value the value to be represented by this EmissionType.
   */
  public EmissionType (int value)
  {
    super(value);
  };

  /**
   *  Constructs a newly allocated EmissionType that represents the unknownExt argument.
   *  @param unknownExt the unknown extension value to be represented by this EmissionType.
   */
  public EmissionType (fr.marben.asnsdk.japi.UnknownExtensionValue unknownExt)
  {
    super(unknownExt);
  };
}