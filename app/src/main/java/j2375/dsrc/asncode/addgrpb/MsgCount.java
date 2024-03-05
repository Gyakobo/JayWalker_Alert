/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/addgrpb/MsgCount.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.addgrpb;

/**
 * <BR> BCD coding of Month of a year, in 1 octet
 * <BR> values above a combined BCD value of 12 (>12)
 * <BR> (ie 0001 0011) shall not be sent
 * <BR> except that value 255 (0xFF) shall indicate an invalid value
 * Class definition of the MsgCount type of the addgrpb module.
 */
public class MsgCount extends fr.marben.asnsdk.japi.spe.IntIntegerValue
{
  /**
   * value of the typeIndex field for this class.
   */
  public static final int ASNTYPE = 5;

  /**
   *  Constructs a newly allocated MsgCount.
   */
  public MsgCount ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated MsgCount that represents the primitive int argument.
   *  @param value the value to be represented by this MsgCount.
   */
  public MsgCount (int value)
  {
    super(value);
  };
  /**
   *  Gets the typeIndex value for this class.
   *  This method is only for ASNSDK internal use. 
   *  @return the type index.
   */
  public int asnGetTypeIndex()
  {
    return 5;
  }

}