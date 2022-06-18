package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.models.ServiceType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeFacade extends AbstractServiceType<ServiceType> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_ALL_SERVICE_TYPE = "SELECT * FROM ServiceType";

    private ServiceType getInfoServiceTypeFromSQL(ResultSet resultSet) throws SQLException {
        String getServiceTypeID = resultSet.getString("ServiceTypeID");
        String getServiceTypeName = resultSet.getString("ServiceTypeName");
        return new ServiceType(getServiceTypeID, getServiceTypeName);
    }

    @Override
    protected List<ServiceType> getAllServiceType(Connection connection) throws SQLException {
        ArrayList<ServiceType> serviceTypeAllList = new ArrayList<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_ALL_SERVICE_TYPE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    ServiceType serviceType = getInfoServiceTypeFromSQL(resultSet);
                    serviceTypeAllList.add(serviceType);
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return serviceTypeAllList;
    }

}
