/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/addgrpc/Altitude.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.addgrpc;

/**
 * Class definition of the Altitude type of the addgrpc module.
 */
public class Altitude extends fr.marben.asnsdk.japi.spe.SequenceValue
{
  /**
   * value of the typeIndex field for this class.
   */
  public static final int ASNTYPE = 11;

  /**
   * mandatory field value.
   */
  public j2375.dsrc.asncode.addgrpc.AltitudeValue value;

  /**
   * mandatory field confidence.
   */
  public j2375.dsrc.asncode.addgrpc.AltitudeConfidence confidence;

  /**
   *  Constructs a newly allocated Altitude.
   */
  public Altitude ()
  {
    super();
  };

  /**
   *  Gets the value of a component from this Altitude.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type identifier of the component.
   *  @return the value identified by the named type.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnGetSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       return this.value;
     case 1 :
       return this.confidence;
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to set field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates a newly allocated component value from this Altitude.
   *  this value is created for temporary use to solve atNotations
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this Altitude.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewTmpSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       return new j2375.dsrc.asncode.addgrpc.AltitudeValue();
     case 1 :
       return new j2375.dsrc.asncode.addgrpc.AltitudeConfidence();
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates and sets a newly allocated component value from this Altitude.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this Altitude.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       this.value = new j2375.dsrc.asncode.addgrpc.AltitudeValue();
       return this.value;
     case 1 :
       this.confidence = new j2375.dsrc.asncode.addgrpc.AltitudeConfidence();
       return this.confidence;
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Gets the typeIndex value for this class.
   *  This method is only for ASNSDK internal use. 
   *  @return the type index.
   */
  public int asnGetTypeIndex()
  {
    return 11;
  }

}