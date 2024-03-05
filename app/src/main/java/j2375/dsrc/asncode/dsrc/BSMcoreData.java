/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/BSMcoreData.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * Class definition of the BSMcoreData type of the dsrc module.
 */
public class BSMcoreData extends fr.marben.asnsdk.japi.spe.SequenceValue
{
  /**
   * value of the typeIndex field for this class.
   */
  public static final int ASNTYPE = 39;

  /**
   * mandatory field msgCnt.
   */
  public j2375.dsrc.asncode.dsrc.MsgCount msgCnt;

  /**
   * mandatory field id.
   */
  public j2375.dsrc.asncode.dsrc.TemporaryID id;

  /**
   * mandatory field secMark.
   */
  public j2375.dsrc.asncode.dsrc.DSecond secMark;

  /**
   * mandatory field lat.
   */
  public j2375.dsrc.asncode.dsrc.Latitude lat;

  /**
   * mandatory field a__long.
   */
  public j2375.dsrc.asncode.dsrc.Longitude a__long;

  /**
   * mandatory field elev.
   */
  public j2375.dsrc.asncode.dsrc.Elevation elev;

  /**
   * mandatory field accuracy.
   */
  public j2375.dsrc.asncode.dsrc.PositionalAccuracy accuracy;

  /**
   * mandatory field transmission.
   */
  public j2375.dsrc.asncode.dsrc.TransmissionState transmission;

  /**
   * mandatory field speed.
   */
  public j2375.dsrc.asncode.dsrc.Speed speed;

  /**
   * mandatory field heading.
   */
  public j2375.dsrc.asncode.dsrc.Heading heading;

  /**
   * mandatory field angle.
   */
  public j2375.dsrc.asncode.dsrc.SteeringWheelAngle angle;

  /**
   * mandatory field accelSet.
   */
  public j2375.dsrc.asncode.dsrc.AccelerationSet4Way accelSet;

  /**
   * mandatory field brakes.
   */
  public j2375.dsrc.asncode.dsrc.BrakeSystemStatus brakes;

  /**
   * mandatory field size.
   */
  public j2375.dsrc.asncode.dsrc.VehicleSize size;

  /**
   *  Constructs a newly allocated BSMcoreData.
   */
  public BSMcoreData ()
  {
    super();
  };

  /**
   *  Gets the value of a component from this BSMcoreData.
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
       return this.msgCnt;
     case 1 :
       return this.id;
     case 2 :
       return this.secMark;
     case 3 :
       return this.lat;
     case 4 :
       return this.a__long;
     case 5 :
       return this.elev;
     case 6 :
       return this.accuracy;
     case 7 :
       return this.transmission;
     case 8 :
       return this.speed;
     case 9 :
       return this.heading;
     case 10 :
       return this.angle;
     case 11 :
       return this.accelSet;
     case 12 :
       return this.brakes;
     case 13 :
       return this.size;
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to set field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates a newly allocated component value from this BSMcoreData.
   *  this value is created for temporary use to solve atNotations
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this BSMcoreData.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewTmpSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       return new j2375.dsrc.asncode.dsrc.MsgCount();
     case 1 :
       return new j2375.dsrc.asncode.dsrc.TemporaryID();
     case 2 :
       return new j2375.dsrc.asncode.dsrc.DSecond();
     case 3 :
       return new j2375.dsrc.asncode.dsrc.Latitude();
     case 4 :
       return new j2375.dsrc.asncode.dsrc.Longitude();
     case 5 :
       return new j2375.dsrc.asncode.dsrc.Elevation();
     case 6 :
       return new j2375.dsrc.asncode.dsrc.PositionalAccuracy();
     case 7 :
       return new j2375.dsrc.asncode.dsrc.TransmissionState();
     case 8 :
       return new j2375.dsrc.asncode.dsrc.Speed();
     case 9 :
       return new j2375.dsrc.asncode.dsrc.Heading();
     case 10 :
       return new j2375.dsrc.asncode.dsrc.SteeringWheelAngle();
     case 11 :
       return new j2375.dsrc.asncode.dsrc.AccelerationSet4Way();
     case 12 :
       return new j2375.dsrc.asncode.dsrc.BrakeSystemStatus();
     case 13 :
       return new j2375.dsrc.asncode.dsrc.VehicleSize();
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates and sets a newly allocated component value from this BSMcoreData.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this BSMcoreData.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       this.msgCnt = new j2375.dsrc.asncode.dsrc.MsgCount();
       return this.msgCnt;
     case 1 :
       this.id = new j2375.dsrc.asncode.dsrc.TemporaryID();
       return this.id;
     case 2 :
       this.secMark = new j2375.dsrc.asncode.dsrc.DSecond();
       return this.secMark;
     case 3 :
       this.lat = new j2375.dsrc.asncode.dsrc.Latitude();
       return this.lat;
     case 4 :
       this.a__long = new j2375.dsrc.asncode.dsrc.Longitude();
       return this.a__long;
     case 5 :
       this.elev = new j2375.dsrc.asncode.dsrc.Elevation();
       return this.elev;
     case 6 :
       this.accuracy = new j2375.dsrc.asncode.dsrc.PositionalAccuracy();
       return this.accuracy;
     case 7 :
       this.transmission = new j2375.dsrc.asncode.dsrc.TransmissionState();
       return this.transmission;
     case 8 :
       this.speed = new j2375.dsrc.asncode.dsrc.Speed();
       return this.speed;
     case 9 :
       this.heading = new j2375.dsrc.asncode.dsrc.Heading();
       return this.heading;
     case 10 :
       this.angle = new j2375.dsrc.asncode.dsrc.SteeringWheelAngle();
       return this.angle;
     case 11 :
       this.accelSet = new j2375.dsrc.asncode.dsrc.AccelerationSet4Way();
       return this.accelSet;
     case 12 :
       this.brakes = new j2375.dsrc.asncode.dsrc.BrakeSystemStatus();
       return this.brakes;
     case 13 :
       this.size = new j2375.dsrc.asncode.dsrc.VehicleSize();
       return this.size;
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
    return 39;
  }

}
