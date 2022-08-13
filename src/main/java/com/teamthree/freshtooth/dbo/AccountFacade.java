package com.teamthree.freshtooth.dbo;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.teamthree.freshtooth.models.Account;
import com.teamthree.freshtooth.utils.FunctionSendEmail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class AccountFacade extends AbstractAccount<Account> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_ALL_ACCOUNT_DENTIST = "SELECT * FROM Accounts WHERE UserRole = ?";
    private static final String SQL_LOGIN = "SELECT * FROM Accounts WHERE UserEmail = ?";
    private static final String SQL_GET_ACCOUNT_WITH_ID = "SELECT * FROM Accounts WHERE UserID = ?";
//    private static final String SQL_GET_ALL_ACCOUNT = "SELECT * FROM Accounts WHERE UserRole = ? ORDER BY UserID OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY;";
    private static final String SQL_GET_ALL_ACCOUNT = "SELECT * FROM Accounts WHERE UserRole = ? ORDER BY UserID LIMIT 5 OFFSET ?;";
    private static final String SQL_REGISTER_ACCOUNT = "INSERT INTO Accounts(UserID, FullName, UserPassword, UserEmail, DefaultAvatar, ColorAvatar) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_ADD_ACCOUNT_GOOGLE = "INSERT INTO Accounts(UserID, UserEmail, DefaultAvatar, ColorAvatar, UserRole, UserStatus) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_ADD_ACCOUNT = "INSERT INTO Accounts(UserID, FullName, UserPassword, UserEmail, DateOfBirth, UserAddress, UserPhone, Sex, ImageAvatar, ColorAvatar, DefaultAvatar, UserRole, UserStatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_STATUS_ACCOUNT_WITH_ID = "UPDATE Accounts SET UserStatus = ? WHERE UserID = ?";
    private static final String SQL_STATUS_ACCOUNT_WITH_EMAIL = "UPDATE Accounts SET UserStatus = ? WHERE UserEmail = ?";
    private static final String SQL_EDIT_PROFILE = "UPDATE Accounts SET FullName = ?, Sex = ?, DateOfBirth = ?, UserPhone = ?, ImageAvatar = ?, UserAddress = ? WHERE UserEmail = ?";
    private static final String SQL_CHANGE_PASSWORD = "UPDATE Accounts SET UserPassword = ? WHERE UserEmail = ?";
    private static final String SQL_GET_TOTAL_ACCOUNT = "SELECT COUNT(*) FROM Accounts WHERE UserRole = ?";
    private static final String SQL_SEARCH_ACCOUNT_BY_NAME = "SELECT * FROM Accounts WHERE FullName LIKE ?";
    private static final String SQL_GET_STATISTIC_ACCOUNT = "SELECT COUNT(*), MONTH(AccountCreated) FROM Accounts WHERE UserRole = 0 AND YEAR(AccountCreated) = ? GROUP BY MONTH(AccountCreated)";

    private Account getInfoAccountFromSQL(ResultSet resultSet) throws SQLException {
        String getUserID = resultSet.getString("UserID");
        String getFullName = resultSet.getString("FullName");
        String getUserPassword = resultSet.getString("UserPassword");
        String getUserEmail = resultSet.getString("UserEmail");
        Date getDateOfBirth = resultSet.getDate("DateOfBirth");
        String getUserAddress = resultSet.getString("UserAddress");
        String getUserPhone = resultSet.getString("UserPhone");
        String getSex = resultSet.getString("Sex");
        byte[] getImageAvatar = resultSet.getBytes("ImageAvatar");
        String getColorAvatar = resultSet.getString("ColorAvatar");
        String getDefaultAvatar = resultSet.getString("DefaultAvatar");
        int getUserRole = resultSet.getInt("UserRole");
        int getUserStatus = resultSet.getInt("UserStatus");
        Timestamp getAccountCreated = resultSet.getTimestamp("AccountCreated");

        return new Account(getUserID, getFullName, getUserPassword, getUserEmail, getUserAddress, getUserPhone, getSex, Base64.encode(getImageAvatar), getColorAvatar, getDefaultAvatar, getDateOfBirth, getUserRole, getUserStatus, getAccountCreated);
    }

    @Override
    protected String registerAccount(Connection connection, Account account, HttpServletRequest request) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_REGISTER_ACCOUNT);
                preparedStatement.setString(1, account.getUserID());
                preparedStatement.setString(2, account.getFullName());
                preparedStatement.setString(3, account.getUserPassword());
                preparedStatement.setString(4, account.getUserEmail());
                preparedStatement.setString(5, account.getDefaultAvatar());
                preparedStatement.setString(6, account.getColorAvatar());

                FunctionSendEmail se = new FunctionSendEmail(account, "Verify Account", request);
                if (se.sendMailVerifyAccount()) {
                    preparedStatement.executeUpdate();
                    return "success";
                }
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return "error";
    }

    @Override
    protected boolean addAccount(Connection connection, Account account, Object action) throws SQLException {
        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "AddAccount":
                        preparedStatement = connection.prepareStatement(SQL_ADD_ACCOUNT);
                        preparedStatement.setString(1, account.getUserID());
                        preparedStatement.setString(2, account.getFullName());
                        preparedStatement.setString(3, account.getUserPassword());
                        preparedStatement.setString(4, account.getUserEmail());
                        preparedStatement.setDate(5, account.getDateOfBirth());
                        preparedStatement.setString(6, account.getUserAddress());
                        preparedStatement.setString(7, account.getUserPhone());
                        preparedStatement.setString(8, account.getSex());
                        preparedStatement.setBytes(9, Base64.decode(account.getImageAvatar()));
                        preparedStatement.setString(10, account.getColorAvatar());
                        preparedStatement.setString(11, account.getDefaultAvatar());
                        preparedStatement.setInt(12, account.getUserRole());
                        preparedStatement.setInt(13, account.getUserStatus());
                        break;
                    case "AddAccountGoogle":
                        preparedStatement = connection.prepareStatement(SQL_ADD_ACCOUNT_GOOGLE);
                        preparedStatement.setString(1, account.getUserID());
                        preparedStatement.setString(2, account.getUserEmail());
                        preparedStatement.setString(3, account.getDefaultAvatar());
                        preparedStatement.setString(4, account.getColorAvatar());
                        preparedStatement.setInt(5, account.getUserRole());
                        preparedStatement.setInt(6, account.getUserStatus());
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
    protected boolean updateAccount(Connection connection, Account account, Object object) throws SQLException {
        try {
            if (connection != null) {
                switch (object.toString()) {
                    case "EditStatusWithID":
                        preparedStatement = connection.prepareStatement(SQL_STATUS_ACCOUNT_WITH_ID);
                        preparedStatement.setInt(1, account.getUserStatus());
                        preparedStatement.setString(2, account.getUserID());
                        break;
                    case "EditStatusWithEmail":
                        preparedStatement = connection.prepareStatement(SQL_STATUS_ACCOUNT_WITH_EMAIL);
                        preparedStatement.setInt(1, account.getUserStatus());
                        preparedStatement.setString(2, account.getUserEmail());
                        break;
                    case "EditProfile":
                        preparedStatement = connection.prepareStatement(SQL_EDIT_PROFILE);
                        preparedStatement.setString(1, account.getFullName());
                        preparedStatement.setString(2, account.getSex());
                        preparedStatement.setDate(3, account.getDateOfBirth());
                        preparedStatement.setString(4, account.getUserPhone());
                        preparedStatement.setBytes(5, Base64.decode(account.getImageAvatar()));
                        preparedStatement.setString(6, account.getUserAddress());
                        preparedStatement.setString(7, account.getUserEmail());
                        break;
                    case "ChangePassword":
                        preparedStatement = connection.prepareStatement(SQL_CHANGE_PASSWORD);
                        preparedStatement.setString(1, account.getUserPassword());
                        preparedStatement.setString(2, account.getUserEmail());
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
    protected List<Account> getAccount(Connection connection, Object object, Object action, Object status) throws SQLException {
        ArrayList<Account> accountList = new ArrayList<>();

        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "SearchAccount":
                        preparedStatement = connection.prepareStatement(SQL_SEARCH_ACCOUNT_BY_NAME);
                        preparedStatement.setString(1, "%" + object.toString() + "%");
                        break;
                    case "PagingAccount":
                        preparedStatement = connection.prepareStatement(SQL_GET_ALL_ACCOUNT);
                        preparedStatement.setString(1, status.toString());
                        preparedStatement.setInt(2, ((int) object - 1) * 5);
                        break;
                    case "AllAccountDentist":
                        preparedStatement = connection.prepareStatement(SQL_GET_ALL_ACCOUNT_DENTIST);
                        preparedStatement.setString(1, object.toString());
                        break;
                    case "GetAllAccountWithID":
                        preparedStatement = connection.prepareStatement(SQL_GET_ACCOUNT_WITH_ID);
                        preparedStatement.setString(1, object.toString());
                        break;
                }

                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Account account = getInfoAccountFromSQL(resultSet);
                    accountList.add(account);
                }
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return accountList;
    }

    @Override
    protected Account checkAccount(Connection connection, Object object, Object action) throws SQLException {
        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "Login":
                        preparedStatement = connection.prepareStatement(SQL_LOGIN);
                        preparedStatement.setString(1, object.toString());
                        break;
                    case "GetAccountDentist":
                        preparedStatement = connection.prepareStatement(SQL_GET_ACCOUNT_WITH_ID);
                        preparedStatement.setString(1, object.toString());
                        break;
                }

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoAccountFromSQL(resultSet);
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
    protected int countAccount(Connection connection, Object status) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_TOTAL_ACCOUNT);
                preparedStatement.setString(1, status.toString());
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

    @Override
    protected HashMap<Integer, Integer> statisticAccount(Connection connection, Object object) throws SQLException {
        HashMap<Integer, Integer> statisticAccountList = new HashMap<>();

        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_STATISTIC_ACCOUNT);
                preparedStatement.setString(1, object.toString());
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    statisticAccountList.put(resultSet.getInt(2), resultSet.getInt(1));
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
        return statisticAccountList;
    }

}
