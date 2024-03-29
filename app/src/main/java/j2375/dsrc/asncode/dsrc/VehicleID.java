/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/VehicleID.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * Class definition of the VehicleID type of the dsrc module.
 */
public class VehicleID extends fr.marben.asnsdk.japi.spe.ChoiceValue
{
  /**
   * value of the typeIndex field for this class.
   */
  public static final int ASNTYPE = 164;

  /**
   * value of the fieldNumber for the field entityID.
   * <BR>Use {@link j2375.dsrc.asncode.dsrc.TemporaryID j2375.dsrc.asncode.dsrc.TemporaryID} for the values of this type.
   */
  public static final short ASN_entityID = 0;

  /**
   * value of the fieldNumber for the field stationID.
   * <BR>Use {@link j2375.dsrc.asncode.dsrc.StationID j2375.dsrc.asncode.dsrc.StationID} for the values of this type.
   */
  public static final short ASN_stationID = 1;

  /**
   *  Constructs a newly allocated VehicleID.
   */
  public VehicleID ()
  {
    super();
  };

  /**
   *  Create a newly allocated VehicleID.
   *  @param fieldNumber the named type identifier of the component.
   *  @param value the value to set.
   *  @throws fr.marben.asnsdk.japi.InvalidStructureException in case of a problem
   */
   public VehicleID(short fieldNumber,
                        fr.marben.asnsdk.japi.spe.Value value)
                        throws fr.marben.asnsdk.japi.InvalidStructureException
   {
     this.fieldNumber = fieldNumber;
     switch (fieldNumber)
     {
     case 0 :
       this.value = (j2375.dsrc.asncode.dsrc.TemporaryID)value;
       break;
     case 1 :
       this.value = (j2375.dsrc.asncode.dsrc.StationID)value;
       break;
     default :
       throw new fr.marben.asnsdk.japi.InvalidStructureException(fr.marben.asnsdk.japi.InvalidStructureException.INVALID_CHOICE_ALTERNATIVE);
     }
   }

  /**
   *  Sets the value of a component from this VehicleID.
   *  @param fieldNumber the named type identifier of the component.
   *  @param value the value to set.
   *  @throws fr.marben.asnsdk.japi.InvalidStructureException in case of a problem
   */
   public void setValue(short fieldNumber,
                        fr.marben.asnsdk.japi.spe.Value value)
                        throws fr.marben.asnsdk.japi.InvalidStructureException
   {
     this.fieldNumber = fieldNumber;
     switch (fieldNumber)
     {
     case 0 :
       this.value = (j2375.dsrc.asncode.dsrc.TemporaryID)value;
       break;
     case 1 :
       this.value = (j2375.dsrc.asncode.dsrc.StationID)value;
       break;
     default :
       throw new fr.marben.asnsdk.japi.InvalidStructureException(fr.marben.asnsdk.japi.InvalidStructureException.INVALID_CHOICE_ALTERNATIVE);
     }
   }

  /**
   *  Creates and sets a newly allocated component value from this VehicleID.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this VehicleID.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewChoiceValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.IChoiceNamedType field)
   {
     this.fieldNumber = field.getFieldNumber(context);
     switch (this.fieldNumber)
     {
     case 0 :
       this.value = new j2375.dsrc.asncode.dsrc.TemporaryID();
       return this.value;
     case 1 :
       this.value = new j2375.dsrc.asncode.dsrc.StationID();
       return this.value;
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
    return 164;
  }

}
