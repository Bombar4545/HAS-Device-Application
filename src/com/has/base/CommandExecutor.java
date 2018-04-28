package com.has.base;

/*
 * CommandExecutor class which will be used to execute preferred command with he runCommand method ( ** IN PROGRESS **)
 * @author Ege Ozan Özyedek
 * @version v2.0
 * @date 28/04/18
 * Update: Organized so that it looks better and is more readable
 */
public class CommandExecutor {

    /**
     * runCommand method which executes the missions of command
     * @param command, the command to be executed
     * @param container, the device list to chose which device the command will affect
     * @return dataContainer, the container which is either null or contains the found data
     */
    public DataContainer runCommand( Command command, DeviceControllerContainer container) {

        DeviceController deviceController;
        DataContainer dataContainer;
        String errorString;

        dataContainer = null;

        deviceController = container.getDeviceController( (int) command.getArgument().getData(0));

        switch ( command.getName()) {

            //BASIC NON-DEVICE COMMANDS

            case GET_CONFIG:
            case GET_OPTIONS:
            case SET_NOBODY_HOME_MODE:
            case ENABLE_DEVELOPER_SESSION:
            case NOTIFICATION:
            case RESPONSE:
                break;

            //DEVICE COMMANDS

            case GET_TEMPERATURE:

                if ( deviceController instanceof TempratureSensorController ) {
                    double temp = deviceController.getTemperature();
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.TEMPERATURE_SENSOR_DATA_CONTAINER);
                    dataContainer.setData( 0, temp);
                }

                else {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.ERROR_STATEMENT_CONTAINER); //Dont forget to add structure
                    errorString = "Command could not be executed. Check deviceId.";
                    dataContainer.setData( 0, errorString);
                }

                break;

            case GET_DISTANCE:
            case GET_INTRUSION_TIMESTAMP:
            case GET_BUTTON_STATE:
            case GET_LIGHT_INTENSITY:
            case SET_LIGHT_STATE:
            case GET_LIGHT_STATE:
            case SET_FAN_STATE:
            case GET_FAN_STATE:
            case SET_HEATER_STATE:
            case GET_HEATER_STATE:
            case SET_CAMERA_STATE:


            case GET_CAMERA_STATE:

                if ( deviceController instanceof CameraController ) {
                    boolean condition = deviceController.getCameraState();
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.CAMERA_DATA_CONTAINER);
                    dataContainer.setData( 0, condition);
                }

                else {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.ERROR_STATEMENT_CONTAINER);
                    errorString = "Command could not be executed. Check deviceId.";
                    dataContainer.setData( 0, errorString);
                }

                break;

            case GET_CAMERA_IMAGE:
                break;
            case RECORD_FOR:
                break;
            case GET_LPG_CONCENTRATION:

                if ( deviceController instanceof GasSensorController ) {
                    double concentration = deviceController.getLPGConfiguration();
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.SINGLE_GAS_SENSOR_DATA_CONTAINER);
                    dataContainer.setData( 0, concentration);
                }

                else {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.ERROR_STATEMENT_CONTAINER);
                    errorString = "Command could not be executed. Check deviceId.";
                    dataContainer.setData( 0, errorString);
                }


                break;

            case GET_METHANE_CONCENTRATION:

                if ( deviceController instanceof GasSensorController ) {
                    double concentration = deviceController.getMethaneConfiguration();
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.SINGLE_GAS_SENSOR_DATA_CONTAINER);
                    dataContainer.setData( 0,concentration);
                }

                else {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.ERROR_STATEMENT_CONTAINER);
                    errorString = "Command could not be executed. Check deviceId.";
                    dataContainer.setData( 0, errorString);
                }

                break;

            case GET_ETHANE_CONCENTRATION:

                if ( deviceController instanceof GasSensorController ) {
                    double concentration = deviceController.getEthaneConfiguration();
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.SINGLE_GAS_SENSOR_DATA_CONTAINER);
                    dataContainer.setData( 0, concentration);
                }

                else {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.ERROR_STATEMENT_CONTAINER);
                    errorString = "Command could not be executed. Check deviceId.";
                    dataContainer.setData( 0, errorString);
                }

                break;

            case GET_PROPANE_CONCENTRATION:

                if ( deviceController instanceof GasSensorController ) {
                    double concentration = deviceController.getPropaneConfiguration();
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.SINGLE_GAS_SENSOR_DATA_CONTAINER);
                    dataContainer.setData( 0, concentration);
                }

                else {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.ERROR_STATEMENT_CONTAINER);
                    errorString = "Command could not be executed. Check deviceId.";
                    dataContainer.setData( 0, errorString);
                }

                break;

            case GET_CO_CONCENTRATION:

                if ( deviceController instanceof GasSensorController ) {
                    double concentration = deviceController.getCOConfiguration();
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.SINGLE_GAS_SENSOR_DATA_CONTAINER);
                    dataContainer.setData( 0, concentration);
                }

                else {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.ERROR_STATEMENT_CONTAINER);
                    errorString = "Command could not be executed. Check deviceId.";
                    dataContainer.setData( 0, errorString);
                }

                break;

            case GET_SMOKE_CONCENTRATION:

                if ( deviceController instanceof GasSensorController ) {
                    double concentration = deviceController.getSmokeConfiguration();
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.SINGLE_GAS_SENSOR_DATA_CONTAINER);
                    dataContainer.setData( 0, concentration);
                }

                else {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.ERROR_STATEMENT_CONTAINER);
                    errorString = "Command could not be executed. Check deviceId.";
                    dataContainer.setData( 0, errorString);
                }

                break;

            case GET_GAS_CONCENTRATION:

                if ( deviceController instanceof GasSensorController ) {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.MULTI_GAS_SENSOR_DATA_CONTAINER);
                    double concentration = deviceController.getLPGConfiguration();
                    dataContainer.setData( 0, concentration);
                    concentration = deviceController.getMethaneConfiguration();
                    dataContainer.setData( 1, concentration);
                    concentration = deviceController.getEthaneConfiguration();
                    dataContainer.setData( 2, concentration);
                    concentration = deviceController.getPropaneConfiguration();
                    dataContainer.setData( 3, concentration);
                    concentration = deviceController.getCOConfiguration();
                    dataContainer.setData( 4, concentration);
                    concentration = deviceController.getSmokeConfiguration();
                    dataContainer.setData( 5, concentration);
                }

                else {
                    dataContainer = DataContainerFactory.createById( DataContainerFactory.ERROR_STATEMENT_CONTAINER);
                    errorString = "Command could not be executed. Check deviceId.";
                    dataContainer.setData( 0, errorString);
                }

                break;

            //NON-DEVELOPER DATABASE COMMANDS

            case GET_TEMP_DATA:
            case GET_GAS_DATA:
            case GET_CONSUMPTION_DATA:
            case UPDATE_CONSUMPTION_DATABASE:
                break;

            //DEVELOPER DEVICE COMMANDS

            case SET_TEMPERATURE:
            case SET_DISTANCE:
            case SET_INTRUSION_TIMESTAMP:
            case SET_BUTTON_STATE:
            case SET_LIGHT_INTENSITY:
            case SET_CAMERA_IMAGE:
            case SET_LPG_CONCENTRATION:
            case SET_METHANE_CONCENTRATION:
            case SET_ETHANE_CONCENTRATION:
            case SET_PROPANE_CONCENTRATION:
            case SET_CO_CONCENTRATION:
            case SET_SMOKE_CONCENTRATION:
            case SET_GAS_CONCENTRATION:

            //DEVELOPER DATABASE COMMANDS

            case RESET_DATABASE:
            case RUN_DATABASE_QUERY:
            case SET_TEMP_DATA:
            case SET_GAS_DATA:
            case SET_CONSUMPTION_DATA:

        }

        //end of switch statement, returns dataContainer
        return dataContainer;
    }

}
