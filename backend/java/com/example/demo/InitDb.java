package com.example.demo;

import java.sql.Connection;

import net.is_bg.ltf.db.common.ConnectionProperties;
import net.is_bg.ltf.db.common.DBConfig;
import net.is_bg.ltf.db.common.impl.DataSourceConnectionFactoryDrManager;
import net.is_bg.ltf.db.common.impl.logging.LogFactorySystemOut;
import net.is_bg.ltf.db.common.impl.timer.ElapsedTimer;
import net.is_bg.ltf.db.common.impl.visit.VisitEmpty;
import net.is_bg.ltf.db.common.interfaces.IConnectionFactory;
import net.is_bg.ltf.db.common.interfaces.IConnectionFactoryX;
import net.is_bg.ltf.db.common.interfaces.timer.IElaplsedTimer;
import net.is_bg.ltf.db.common.interfaces.timer.IElaplsedTimerFactory;
import net.is_bg.ltf.db.common.interfaces.visit.IVisit;
import net.is_bg.ltf.db.common.interfaces.visit.IVisitFactory;

public class InitDb {
	//private final static String ORCL_DRIVER = "oracle.jdbc.OracleDriver";
	private final static String PGR_DRIVER  = "org.postgresql.Driver";
	static final ConnectionProperties pr =
	new ConnectionProperties(PGR_DRIVER, "jdbc:postgresql://localhost:5432/soft", "postgres", "012345", "");
	
	static IConnectionFactory cf = new DataSourceConnectionFactoryDrManager(pr);
	
	public static void initDb() {
		DBConfig.initDBConfig(
			new LogFactorySystemOut(), 
			new IVisitFactory() {
				@Override
				public IVisit getVist() {
					return new VisitEmpty();
				}
			},  new Cf() , new IElaplsedTimerFactory() {
				@Override
				public IElaplsedTimer getElapsedTimer() {
					return new ElapsedTimer();
				}
			}, null);
	}
}


class Cf implements IConnectionFactoryX{

	@Override
	public Connection getConnection() {
		return  InitDb.cf.getConnection();
	}

	@Override
	public Connection getConnection(String arg0) {
		return InitDb.cf.getConnection();
	}
}