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
    private static final String SQL_GET_ALL_SERVICE_TYPE = "SELECT * FROM ServiceType WHERE ServiceTypeStatus = ?";
    private static final String SQL_GET_SERVICE_TYPE_BY_ID = "SELECT * FROM ServiceType WHERE ServiceTypeID = ?";
    private static final String SQL_ADD_SERVICE_TYPE = "INSERT INTO ServiceType(ServiceTypeID, ServiceTypeName) VALUES(?, ?)";
    private static final String SQL_EDIT_SERVICE_TYPE = "UPDATE ServiceType SET ServiceTypeName = ? WHERE ServiceTypeID = ?";
    private static final String SQL_UPDATE_SERVICE_TYPE_STATUS = "UPDATE ServiceType SET ServiceTypeStatus = ? WHERE ServiceTypeID = ?";
    private static final String SQL_GET_TOTAL_SERVICE_TYPE = "SELECT COUNT(*) FROM ServiceType";
//    private static final String SQL_GET_PAGING_SERVICE_TYPE = "SELECT * FROM ServiceType ORDER BY ServiceTypeID OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY;";
    private static final String SQL_GET_PAGING_SERVICE_TYPE = "SELECT * FROM ServiceType ORDER BY ServiceTypeID LIMIT 5 OFFSET ?;";

    private ServiceType getInfoServiceTypeFromSQL(ResultSet resultSet) throws SQLException {
        String getServiceTypeID = resultSet.getString("ServiceTypeID");
        String getServiceTypeName = resultSet.getString("ServiceTypeName");
        int getServiceTypeStatus = resultSet.getInt("ServiceTypeStatus");
        return new ServiceType(getServiceTypeID, getServiceTypeName, getServiceTypeStatus);
    }

    @Override
    protected List<ServiceType> getAllServiceType(Connection connection, Object object, Object action) throws SQLException {
        ArrayList<ServiceType> serviceTypeAllList = new ArrayList<>();

        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "GetAllServiceType":
                        preparedStatement = connection.prepareStatement(SQL_GET_ALL_SERVICE_TYPE);
                        preparedStatement.setInt(1, Integer.parseInt(object.toString()));
                        break;
                    case "PagingServiceType":
                        preparedStatement = connection.prepareStatement(SQL_GET_PAGING_SERVICE_TYPE);
                        preparedStatement.setInt(1, ((int) object - 1) * 5);
                        break;
                }

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

    @Override
    protected ServiceType getServiceType(Connection connection, Object serviceTypeID) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_SERVICE_TYPE_BY_ID);
                preparedStatement.setString(1, serviceTypeID.toString());
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoServiceTypeFromSQL(resultSet);
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
        return null;
    }

    @Override
    protected boolean addServiceType(Connection connection, ServiceType serviceType) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_ADD_SERVICE_TYPE);
                preparedStatement.setString(1, serviceType.getServiceTypeID());
                preparedStatement.setString(2, serviceType.getServiceTypeName());
                preparedStatement.executeUpdate();
                return true;
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    protected boolean updateServiceType(Connection connection, ServiceType serviceType, Object action) throws SQLException {
        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "EditServiceType":
                        preparedStatement = connection.prepareStatement(SQL_EDIT_SERVICE_TYPE);
                        preparedStatement.setString(1, serviceType.getServiceTypeName());
                        preparedStatement.setString(2, serviceType.getServiceTypeID());
                        break;
                    case "UpdateServiceTypeStatus":
                        preparedStatement = connection.prepareStatement(SQL_UPDATE_SERVICE_TYPE_STATUS);
                        preparedStatement.setInt(1, serviceType.getServiceTypeStatus());
                        preparedStatement.setString(2, serviceType.getServiceTypeID());
                        break;
                }

                preparedStatement.executeUpdate();
                return true;
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    protected int countServiceType(Connection connection) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_TOTAL_SERVICE_TYPE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    return resultSet.getInt(1);
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
        return 0;
    }

}
