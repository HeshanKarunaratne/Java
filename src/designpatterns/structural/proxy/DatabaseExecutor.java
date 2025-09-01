package designpatterns.proxy;

import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public interface DatabaseExecutor {
    public void executeDatabase(String query) throws Exception;
}

class DatabaseExecutorImpl implements DatabaseExecutor {
    public static final Logger LOGGER = Logger.getLogger(DatabaseExecutorImpl.class.getName());

    @Override
    public void executeDatabase(String query) {
        String value = "Going to execute Query: " + query;
        LOGGER.info(value);
    }
}

class DatabaseExecutorProxy implements DatabaseExecutor {
    public static final Logger LOGGER = Logger.getLogger(DatabaseExecutorProxy.class.getName());

    boolean ifAdmin;
    DatabaseExecutorImpl databaseExecutor;

    public DatabaseExecutorProxy(String name, String password) {
        if (name.equals("Admin") && password.equals("Admin@123")) {
            ifAdmin = true;
            databaseExecutor = new DatabaseExecutorImpl();
        }
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        String value = "Going to execute Query: " + query;
        LOGGER.info(value);

        if (ifAdmin) {
            databaseExecutor.executeDatabase(query);
        } else {
            if (query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non admin user");
            } else {
                databaseExecutor.executeDatabase(query);
            }
        }
    }
}

class ProxyTest {
    public static void main(String[] args) throws Exception {

        DatabaseExecutor nonAdminUser = new DatabaseExecutorProxy("NonAdmin", "NonAdmin@123");
        nonAdminUser.executeDatabase("DELETE");

        DatabaseExecutor adminUser = new DatabaseExecutorProxy("Admin", "Admin@123");
        adminUser.executeDatabase("DELETE");

    }
}