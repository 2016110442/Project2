package com.project1.controller.logging;

import ch.qos.logback.classic.db.DBAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MyDBAppender extends DBAppender {

	final static Logger log = LoggerFactory.getLogger(MyDBAppender.class);

	protected String insertPropertiesSQL; 
	protected String insertExceptionSQL; 
	protected String insertSQL; 
	protected static final Method GET_GENERATED_KEYS_METHOD;
	String url = "jdbc:mysql://localhost:3306/eighthcompany?serverTimezone=GMT";
	private MyDBNameResolver dbNameResolver;
	private Connection conn;
	private Date d;
	private String method;
	private String sql;
	private String o_way;
	private String ip;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
	@Autowired
	DataSource dataSource;

	public Connection getConnection() throws SQLException {
		if(dataSource!=null)
			return	dataSource.getConnection();
		return getConnectionSource().getConnection();
	}


	static { 
		Method getGeneratedKeysMethod; 
		try { 
			getGeneratedKeysMethod = PreparedStatement.class.getMethod("getGeneratedKeys", (Class[]) null); 
		} catch (Exception ex) { 
			getGeneratedKeysMethod = null; 
		} 
		GET_GENERATED_KEYS_METHOD = getGeneratedKeysMethod; 
	} 


	public MyDBAppender(){}


	public MyDBNameResolver getDbNameResolver() {
		return dbNameResolver;
	}


	public void setDbNameResolver(MyDBNameResolver dbNameResolver) {
		this.dbNameResolver = dbNameResolver;
	}

	@Override 
	public void start() { 

		super.start();	 
		if (dbNameResolver == null) 
			dbNameResolver = new MyDBNameResolver();
		insertSQL = MySQLBuilder.buildInsertSQL(dbNameResolver);
		System.out.println(insertSQL);
	} 

	@Override 
	protected void subAppend(ILoggingEvent event, Connection connection, PreparedStatement insertStatement) throws Throwable { 

		
		//boolean isAuditable = checkForAudit(event);
		//System.out.println("1111111111111"+isAuditable);

			bindLoggingEventWithInsertStatement(insertStatement, event);
			//System.out.println("===      INSERT STATEMENT      ===    " + insertStatement);
			int updateCount = -1;
			//System.out.println(event.getFormattedMessage());
			if(event.getThreadName().contains("RMI TCP Connection"))
			{
				String i[] = event.getThreadName().split("-");
				ip = i[1];
				//System.out.println("ip是"+ip);
			}
			//System.out.println("ip是"+ip);
			if(event.getFormattedMessage().contains("GET")||event.getFormattedMessage().contains("POST")||event.getFormattedMessage().contains("DELETE")||event.getFormattedMessage().contains("PUT")||event.getFormattedMessage().contains("Preparing")){
			if(event.getFormattedMessage().contains("Preparing")){
				sql = event.getFormattedMessage();
				o_way=event.getLoggerName();
			}else{
				method = event.getFormattedMessage();
			}
			if((method.contains("GET")||method.contains("POST")||method.contains("PUT")||method.contains("DELETE"))&&sql.contains("Preparing")){
				try {
					//updateCount = insertStatement.executeUpdate();
					conn=DriverManager.getConnection(url, "root", "123456");
					if(conn!=null)
					{
						d=new Date();
						System.out.println("格式化输出：" + sdf.format(d));
						PreparedStatement stmt=conn.prepareStatement(insertSQL);
						String e_id = "";
                        String c_way = "";
						String request = "";
						String r_way = "";
						String parms = "";
						//String o_way = "";
						String o_sql="";
						String date = "";
						e_id = "2016110";
						date = sdf.format(d);
						//o_way = r[r.length-1];
						if(o_way.toLowerCase().contains("select")){
							c_way = "查找";
						}else if(o_way.toLowerCase().contains("update")){
							c_way = "修改";
						}else if(o_way.toLowerCase().contains("delete")) {
							c_way="删除";
						}else{
							c_way="新增";
						}
						System.out.println("开始打印日志");
						String log = event.getFormattedMessage();
						//System.out.println();
//					System.out.println(event.getLoggerName());
//					System.out.println((event.getArgumentArray()));
//					System.out.println(event.getCallerData());
//					System.out.println(event.getLevel());
//					//System.out.println(event.getMessage());
//					System.out.println(event.getMDCPropertyMap());
//					System.out.println(event.getThrowableProxy());
//					System.out.println(event.getMarker());
//					System.out.println(event.getLoggerContextVO());
						//submission_date = ;
						if(method.contains("GET")||method.contains("POST")||method.contains("PUT")||method.contains("DELETE")){
							String s1[]=method.split(",");
							if(method.contains("GET")){
								r_way="GET";
							}else if(method.contains("POST")) {
								r_way = "POST";
							}else if(method.contains("PUT")){
								r_way="PUT";
							}else if(method.contains("DELETE")){
								r_way="DELETE";
							}
							String s2[]=s1[0].split("\"");
							request = s2[1];
//							for(int i=2;i<s2.length;i++){
//								System.out.println(parms);
//								parms+="参数"+(i-1)+":";
//								if(i!=s2.length-1) {
//									parms+=s2[i]+" ";
//								}else if(i==s2.length-1){
//									for(int j=0;j<s2[i].length()-1;j++){
//										parms+=s2[i].charAt(j);
//									}
//								}
//							}
						}
						if(sql.contains("Preparing")){
							String s[] = sql.split(":");
							o_sql =  s[1];
						}
						System.out.println("o_way是"+o_way);
						if(o_way.contains(".")){
						    o_way = o_way.replace(".",",");
						    String s2[]=o_way.split(",");
						    o_way = s2[s2.length-1];
                        }
                        System.out.println("o_way是"+o_way);
                        System.out.println("ip是"+ip);
                        parms="";
						stmt.setString(1, e_id);
						stmt.setString(2, c_way);
						stmt.setString(3, request);
						stmt.setString(4, r_way);
						stmt.setString(5, parms);
						stmt.setString(6,o_way);
						stmt.setString(7,o_sql);
						stmt.setString(8,date);
						stmt.setString(9,ip);
						stmt.executeUpdate();
						//System.out.println("还是发挥双方");
						conn.close();
						method="";
						sql="";
					}



				} catch (Exception e) {
					log.error(" ERROR   ");
					e.printStackTrace();
				}

				//System.out.println(" updateCount = "+ updateCount);

				if (updateCount != 1) {
					//log.error(" ERROR  IT IS ");
					//addWarn("Failed to insert loggingEvent");
				}
			}
		}




		
	}

	private boolean checkForAudit(ILoggingEvent event) {
		String logdata = event.getFormattedMessage();
		//System.out.println("22222222222222"+logdata);
		if(logdata.contains("AUDIT#")) {
			return true;
		}
		return false;
	}


	protected void secondarySubAppend(ILoggingEvent event, 
			Connection connection, long eventId) throws Throwable { 
	} 

	private void bindLoggingEventWithInsertStatement(PreparedStatement stmt, ILoggingEvent event) throws SQLException { 
		String logdata = event.getFormattedMessage();
		log.debug(" logdata   = "+ logdata);	

		parseLogData(logdata.substring(logdata.indexOf("#")+1), stmt);


	} 

	private void parseLogData(String logdata, PreparedStatement stmt) throws SQLException {

		//ILoggingEvent event;
		String requestid = null;
		String submission_date = null;
		String eID = null;
		String status = null;
		String service = null;
		String authnContextClassRef = null;
		String ipaddresss = null;
		//submission_date = e

		try {


				//System.out.println("哈哈哈哈");
//				String[] entries = logdata.split(",");
//				if (null != entries && entries.length > 0) {
//					submission_date = entries[0];
//					requestid = entries[1];
//					eID = entries[2];
//					status = entries[3];
//					service = entries[4];
//					authnContextClassRef = entries[5];
//					ipaddresss = entries[6];
//
//				}

				stmt.setString(1, "111");
				stmt.setString(2, "222");
				stmt.setString(3, "333");
				stmt.setString(4, "444");
				stmt.setString(5, "555");
				stmt.setString(6, "666");
				stmt.setString(7, "777");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			requestid = null;
			submission_date = null;
			eID = null;
			status = null;
			service = null;
			authnContextClassRef = null;
			ipaddresss = null;

		}

	}



	@Override 
	protected Method getGeneratedKeysMethod() { 
		return GET_GENERATED_KEYS_METHOD; 
	} 

	@Override 
	protected String getInsertSQL() { 
		return insertSQL; 
	} 

	protected void insertProperties(Map<String, String> mergedMap, 
			Connection connection, long eventId) throws SQLException {

	} 

}
