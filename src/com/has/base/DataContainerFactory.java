package com.has.base;

/*
 * DataContainerFactory to create data containers for specified actions easier ( ** IN PROGRESS **)
 * @author Ege Ozan Özyedek
 * @version v1.0
 * @date 26/04/18
 */
public class DataContainerFactory {

    //properties

    static final int ERROR_STATEMENT_CONTAINER = 0;
    static final int TEMPERATURE_SENSOR_DATA_CONTAINER = 1;
    static final int SINGLE_GAS_SENSOR_DATA_CONTAINER = 2;
    static final int MULTI_GAS_SENSOR_DATA_CONTAINER = 3;
    static final int CAMERA_DATA_CONTAINER = 4;



    public static DataContainer createById( int typeId) {

        if ( typeId == ERROR_STATEMENT_CONTAINER) {
            return new DataContainer( new DataStructure( DataType.STRING));
        }

        else if ( typeId == TEMPERATURE_SENSOR_DATA_CONTAINER) {}

        else if ( typeId == SINGLE_GAS_SENSOR_DATA_CONTAINER) {}

        else if ( typeId == MULTI_GAS_SENSOR_DATA_CONTAINER) {}

        else if ( typeId == CAMERA_DATA_CONTAINER) {}

        //WIP
        return null;
        
    }

}
