package cn.itcast.utils;

import java.sql.Connection;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * JDBC工具类:
 * 	* 加载驱动
 *  * 获得连接
 *  * 释放资源
 *  	* 代码都重复.
 * @author 
 *
 */
public class JDBCUtils {
	
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	// 获得连接池:
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	// 获得连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("get dataSource success");
		return conn;
	}
	/*
	 *  [ acquireIncrement -> 3,
	 *    acquireRetryAttempts -> 30, 
	 *    acquireRetryDelay -> 1000, 
	 *    autoCommitOnClose -> false, 
	 *    automaticTestTable -> null, 
	 *    breakAfterAcquireFailure -> false, 
	 *    checkoutTimeout -> 30000, 
	 *    connectionCustomizerClassName -> null, 
	 *    connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, 
	 *    dataSourceName -> 1hge4g19z1nlggl398lz5u|48cac17, 
	 *    debugUnreturnedConnectionStackTraces -> false, 
	 *    description -> null, 
	 *    driverClass -> com.mysql.jdbc.Driver, 
	 *    factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, identityToken -> 1hge4g19z1nlggl398lz5u|48cac17, idleConnectionTestPeriod -> 30, initialPoolSize -> 10, jdbcUrl -> jdbc:mysql:///chatroom, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 30, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 100, maxStatements -> 200, maxStatementsPerConnection -> 0, minPoolSize -> 10, numHelperThreads -> 3, numThreadsAwaitingCheckoutDefaultUser -> 0, preferredTestQuery -> null, properties -> {user=******, password=******}, propertyCycle -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, 
	 *  usesTraditionalReflectiveProxies -> false ]
	 * 
	 */
	
	//测试模块
	public static void main(String[] args) {
		System.out.println("132");
		Connection  conn = JDBCUtils.getConnection();
		if(conn != null)
		{
			System.out.println("conn succ");
		}
		else {
			System.out.println("conn is null");
		}
	}
	
}
